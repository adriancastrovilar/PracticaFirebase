package com.firebase.uidemo.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.firebase.firestore.IgnoreExtraProperties;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@IgnoreExtraProperties
public class EpisodeDTO {

    private String name;
    private String season;
    private String runtime;
    private String timestamp;

    public EpisodeDTO() {
        //empty constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public EpisodeDTO(String name, String season, String runtime) {
        this.name = name;
        this.season = season;
        this.runtime = runtime;
        this.timestamp = generateTimestamp();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String generateTimestamp() {
        long timestamp = new Date().getTime();
        return Long.toString(timestamp);
    }


    public String getName() {
        return name;
    }

    public String getHistoricName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public String getHistoricSeason() {
        return "Season: " + season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getHistoricRuntime() {
        return "Duración: " + runtime + " minutos";
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getFormatedTimestamp() {
        long milis = Long.parseLong(timestamp);
        Date currentDate = new Date(milis);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String formatted = format.format(currentDate);
        return "Fecha: " + formatted;
    }

}
