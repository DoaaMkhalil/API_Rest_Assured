package serialization;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Location {
  private   String postCode ;
    private String country , countryApp;
    private List<Place> places ;
    public Location() {
        this.postCode = "1050";
        this.country = "Latvia";
        this.countryApp = "LV";
        Place place = new Place();
        List<Place>  places = new ArrayList<>();
        places.add(place);
        this.places=places;
    }
    @JsonProperty("post code")
    public String getPostCode() {
        return postCode;
    }
    @JsonProperty("post code")
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    @JsonProperty("country")

    public void setCountry(String country) {
        this.country = country;
    }
    @JsonProperty("country abbreviation")

    public void setCountryApp(String countryApp) {
        this.countryApp = countryApp;
    }
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }
    @JsonProperty("places")
    public List<Place> getPlaces() {
        return places;
    }
    @JsonProperty("places")
    public void setPlaces(List<Place> places) {
        this.places = places;
    }
    @JsonProperty("country abbreviation")
    public String getCountryApp() {
        return countryApp;
    }
}
