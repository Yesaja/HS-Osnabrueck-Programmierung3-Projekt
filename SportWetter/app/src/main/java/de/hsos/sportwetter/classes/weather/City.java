package de.hsos.sportwetter.classes.weather;

import net.aksingh.owmjapis.model.CurrentWeather;

public class City {
    private  String name, land;
    private  double longitude, latitude;

    public City(CurrentWeather cwd) {
        this.name = cwd.getCityName();
        this.land = cwd.getSystemData().getCountryCode();
        this.latitude = cwd.getCoordData().getLatitude();
        this.longitude = cwd.getCoordData().getLongitude();
    }

    public City() {

    }

    public String getName() { return this.name; }
    public String getLand() { return this.land; }
    public Double getLongitude() { return this.longitude; }
    public Double getLatitude() { return this.latitude; }
}
