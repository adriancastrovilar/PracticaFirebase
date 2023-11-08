/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.firebase.uidemo.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.uidemo.R;
import com.firebase.uidemo.databinding.SignedInLayoutBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class SignedInActivity extends AppCompatActivity {
    private static final String TAG = "SignedInActivity";

    private SignedInLayoutBinding mBinding;

    @NonNull
    public static Intent createIntent(@NonNull Context context, @Nullable IdpResponse response) {
        return new Intent().setClass(context, SignedInActivity.class)
                .putExtra(ExtraConstants.IDP_RESPONSE, response);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            startActivity(AuthUiActivity.createIntent(this));
            finish();
            return;
        }

        IdpResponse response = getIntent().getParcelableExtra(ExtraConstants.IDP_RESPONSE);

        mBinding = SignedInLayoutBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        populateProfile(response);
        populateIdpToken(response);

        mBinding.signOut.setOnClickListener(view -> signOut());
    }

    public void signOut() {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        startActivity(AuthUiActivity.createIntent(SignedInActivity.this));
                        finish();
                    } else {
                        Log.w(TAG, "signOut:failure", task.getException());
                        showSnackbar(R.string.sign_out_failed);
                    }
                });
    }

    private void populateProfile(@Nullable IdpResponse response) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        mBinding.userEmail.setText(
                TextUtils.isEmpty(user.getEmail()) ? "Sin email" : user.getEmail());
        mBinding.userPhoneNumber.setText(
                TextUtils.isEmpty(user.getPhoneNumber()) ? "Sin número de teléfono" : user.getPhoneNumber());
        mBinding.userDisplayName.setText(
                TextUtils.isEmpty(user.getDisplayName()) ? "Sin nombre de usuario" : user.getDisplayName());

        if (response == null) {
            mBinding.userIsNew.setVisibility(View.GONE);
        } else {
            mBinding.userIsNew.setVisibility(View.VISIBLE);
            mBinding.userIsNew.setText(response.isNewUser() ? "Nuevo usuario" : "Usuario existente");
        }

        List<String> providers = new ArrayList<>();
        if (user.getProviderData().isEmpty()) {
            providers.add(getString(R.string.providers_anonymous));
        } else {
            for (UserInfo info : user.getProviderData()) {
                if (info.getProviderId().equals(EmailAuthProvider.PROVIDER_ID)) {
                    providers.add(getString(R.string.providers_email));
                } else {
                    providers.add(info.getProviderId());
                }
            }
        }

        mBinding.userEnabledProviders.setText(getString(R.string.used_providers, providers));
    }

    private void populateIdpToken(@Nullable IdpResponse response) {
        String token = null;
        String secret = null;
        if (response != null) {
            token = response.getIdpToken();
            secret = response.getIdpSecret();
        }

        View idpTokenLayout = findViewById(R.id.idp_token_layout);
        if (token == null) {
            idpTokenLayout.setVisibility(View.GONE);
        } else {
            idpTokenLayout.setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.idp_token)).setText(token);
        }

        View idpSecretLayout = findViewById(R.id.idp_secret_layout);
        if (secret == null) {
            idpSecretLayout.setVisibility(View.GONE);
        } else {
            idpSecretLayout.setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.idp_secret)).setText(secret);
        }
    }

    private void showSnackbar(@StringRes int errorMessageRes) {
        Snackbar.make(mBinding.getRoot(), errorMessageRes, Snackbar.LENGTH_LONG).show();
    }
}
