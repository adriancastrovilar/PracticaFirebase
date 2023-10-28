
package com.firebase.uidemo.api.models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Current {

    private String observationTime;
    private Integer temperature;
    private Integer weatherCode;
    private List<String> weatherIcons;
    private List<String> weatherDescriptions;
    private Integer windSpeed;
    private Integer windDegree;
    private String windDir;
    private Integer pressure;
    private Integer precip;
    private Integer humidity;
    private Integer cloudcover;
    private Integer feelslike;
    private Integer uvIndex;
    private Integer visibility;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(Integer weatherCode) {
        this.weatherCode = weatherCode;
    }

    public List<String> getWeatherIcons() {
        return weatherIcons;
    }

    public void setWeatherIcons(List<String> weatherIcons) {
        this.weatherIcons = weatherIcons;
    }

    public List<String> getWeatherDescriptions() {
        return weatherDescriptions;
    }

    public void setWeatherDescriptions(List<String> weatherDescriptions) {
        this.weatherDescriptions = weatherDescriptions;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(Integer windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getPrecip() {
        return precip;
    }

    public void setPrecip(Integer precip) {
        this.precip = precip;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(Integer cloudcover) {
        this.cloudcover = cloudcover;
    }

    public Integer getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(Integer feelslike) {
        this.feelslike = feelslike;
    }

    public Integer getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(Integer uvIndex) {
        this.uvIndex = uvIndex;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
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
        sb.append(Current.class.getName())
                .append('@')
                .append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("observationTime");
        sb.append('=');
        sb.append(((this.observationTime == null) ? "<null>" : this.observationTime));
        sb.append(',');
        sb.append("temperature");
        sb.append('=');
        sb.append(((this.temperature == null) ? "<null>" : this.temperature));
        sb.append(',');
        sb.append("weatherCode");
        sb.append('=');
        sb.append(((this.weatherCode == null) ? "<null>" : this.weatherCode));
        sb.append(',');
        sb.append("weatherIcons");
        sb.append('=');
        sb.append(((this.weatherIcons == null) ? "<null>" : this.weatherIcons));
        sb.append(',');
        sb.append("weatherDescriptions");
        sb.append('=');
        sb.append(((this.weatherDescriptions == null) ? "<null>" : this.weatherDescriptions));
        sb.append(',');
        sb.append("windSpeed");
        sb.append('=');
        sb.append(((this.windSpeed == null) ? "<null>" : this.windSpeed));
        sb.append(',');
        sb.append("windDegree");
        sb.append('=');
        sb.append(((this.windDegree == null) ? "<null>" : this.windDegree));
        sb.append(',');
        sb.append("windDir");
        sb.append('=');
        sb.append(((this.windDir == null) ? "<null>" : this.windDir));
        sb.append(',');
        sb.append("pressure");
        sb.append('=');
        sb.append(((this.pressure == null) ? "<null>" : this.pressure));
        sb.append(',');
        sb.append("precip");
        sb.append('=');
        sb.append(((this.precip == null) ? "<null>" : this.precip));
        sb.append(',');
        sb.append("humidity");
        sb.append('=');
        sb.append(((this.humidity == null) ? "<null>" : this.humidity));
        sb.append(',');
        sb.append("cloudcover");
        sb.append('=');
        sb.append(((this.cloudcover == null) ? "<null>" : this.cloudcover));
        sb.append(',');
        sb.append("feelslike");
        sb.append('=');
        sb.append(((this.feelslike == null) ? "<null>" : this.feelslike));
        sb.append(',');
        sb.append("uvIndex");
        sb.append('=');
        sb.append(((this.uvIndex == null) ? "<null>" : this.uvIndex));
        sb.append(',');
        sb.append("visibility");
        sb.append('=');
        sb.append(((this.visibility == null) ? "<null>" : this.visibility));
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
