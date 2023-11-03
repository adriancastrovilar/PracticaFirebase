
package com.firebase.uidemo.api.models;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Externals {

    private Object tvrage;
    private Integer thetvdb;
    private String imdb;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Object getTvrage() {
        return tvrage;
    }

    public void setTvrage(Object tvrage) {
        this.tvrage = tvrage;
    }

    public Integer getThetvdb() {
        return thetvdb;
    }

    public void setThetvdb(Integer thetvdb) {
        this.thetvdb = thetvdb;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Externals.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("tvrage");
        sb.append('=');
        sb.append(((this.tvrage == null) ? "<null>" : this.tvrage));
        sb.append(',');
        sb.append("thetvdb");
        sb.append('=');
        sb.append(((this.thetvdb == null) ? "<null>" : this.thetvdb));
        sb.append(',');
        sb.append("imdb");
        sb.append('=');
        sb.append(((this.imdb == null) ? "<null>" : this.imdb));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
