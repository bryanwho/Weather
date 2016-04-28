
package com.codetank.weather.data;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Main {

    private float temp;
    private int pressure;
    private int humidity;
    private float temp_min;
    private float temp_max;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Main() {
    }

    /**
     * 
     * @param humidity
     * @param pressure
     * @param temp_max
     * @param temp_min
     * @param temp
     */
    public Main(float temp, int pressure, int humidity, float temp_min, float temp_max) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
    }

    /**
     * 
     * @return
     *     The temp
     */
    public float getTemp() {
        return temp;
    }

    /**
     * 
     * @param temp
     *     The temp
     */
    public void setTemp(float temp) {
        this.temp = temp;
    }

    /**
     * 
     * @return
     *     The pressure
     */
    public int getPressure() {
        return pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    public int getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The temp_min
     */
    public float getTemp_min() {
        return temp_min;
    }

    /**
     * 
     * @param temp_min
     *     The temp_min
     */
    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    /**
     * 
     * @return
     *     The temp_max
     */
    public float getTemp_max() {
        return temp_max;
    }

    /**
     * 
     * @param temp_max
     *     The temp_max
     */
    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
