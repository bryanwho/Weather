
package com.codetank.weather.data;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Rain {

    private int _1h;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rain() {
    }

    /**
     * 
     * @param _1h
     */
    public Rain(int _1h) {
        this._1h = _1h;
    }

    /**
     * 
     * @return
     *     The _1h
     */
    public int get1h() {
        return _1h;
    }

    /**
     * 
     * @param _1h
     *     The 1h
     */
    public void set1h(int _1h) {
        this._1h = _1h;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
