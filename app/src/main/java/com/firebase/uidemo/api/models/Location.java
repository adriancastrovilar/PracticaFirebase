
package com.firebase.uidemo.api.models;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Location {

    private String name;
    private String country;
    private String region;
    private String lat;
    private String lon;
    private String timezoneId;
    private String localtime;
    private Integer localtimeEpoch;
    private String utcOffset;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public Integer getLocaltimeEpoch() {
        return localtimeEpoch;
    }

    public void setLocaltimeEpoch(Integer localtimeEpoch) {
        this.localtimeEpoch = localtimeEpoch;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
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
        sb.append(Location.class.getName())
                .append('@')
                .append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null) ? "<null>" : this.country));
        sb.append(',');
        sb.append("region");
        sb.append('=');
        sb.append(((this.region == null) ? "<null>" : this.region));
        sb.append(',');
        sb.append("lat");
        sb.append('=');
        sb.append(((this.lat == null) ? "<null>" : this.lat));
        sb.append(',');
        sb.append("lon");
        sb.append('=');
        sb.append(((this.lon == null) ? "<null>" : this.lon));
        sb.append(',');
        sb.append("timezoneId");
        sb.append('=');
        sb.append(((this.timezoneId == null) ? "<null>" : this.timezoneId));
        sb.append(',');
        sb.append("localtime");
        sb.append('=');
        sb.append(((this.localtime == null) ? "<null>" : this.localtime));
        sb.append(',');
        sb.append("localtimeEpoch");
        sb.append('=');
        sb.append(((this.localtimeEpoch == null) ? "<null>" : this.localtimeEpoch));
        sb.append(',');
        sb.append("utcOffset");
        sb.append('=');
        sb.append(((this.utcOffset == null) ? "<null>" : this.utcOffset));
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
