package io.rocketapps.apps.android.flightcompanion.model;

import io.realm.RealmObject;
import io.realm.annotations.Index;

/**
 * Created by macbook on 4/29/17.
 */

public class PlacesDetailsModel extends RealmObject {

    @Index
    private long id;
    String general;
    String history;
    String geography;
    String climate;
    String culture;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }
}
