
package com.firebase.uidemo.api.models;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Request {

    private String type;
    private String query;
    private String language;
    private String unit;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
        sb.append(Request.class.getName())
                .append('@')
                .append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("query");
        sb.append('=');
        sb.append(((this.query == null) ? "<null>" : this.query));
        sb.append(',');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null) ? "<null>" : this.language));
        sb.append(',');
        sb.append("unit");
        sb.append('=');
        sb.append(((this.unit == null) ? "<null>" : this.unit));
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
