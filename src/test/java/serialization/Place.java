package serialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Place {
    private  String state , placeName , stateAbb , lon , lat;

    public Place() {
        this.state = "Riga";
        this.placeName =  "Riga";
        this.stateAbb = "RI";
        this.lon = "1";
        this.lat = "1";
    }
    @JsonProperty("state")

    public String getState() {
        return state;
    }
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }
    @JsonProperty("place name")
    public String getPlaceName() {
        return placeName;
    }
    @JsonProperty("place name")
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    @JsonProperty("state abbreviation")

    public String getStateAbb() {
        return stateAbb;
    }
    @JsonProperty("state abbreviation")
    public void setStateAbb(String stateAbb) {
        this.stateAbb = stateAbb;
    }
    @JsonProperty("longitude")

    public String getLon() {
        return lon;
    }
    @JsonProperty("longitude")

    public void setLon(String lon) {
        this.lon = lon;
    }
    @JsonProperty("latitude")

    public String getLat() {
        return lat;
    }
    @JsonProperty("latitude")
    public void setLat(String lat) {
        this.lat = lat;
    }
}
