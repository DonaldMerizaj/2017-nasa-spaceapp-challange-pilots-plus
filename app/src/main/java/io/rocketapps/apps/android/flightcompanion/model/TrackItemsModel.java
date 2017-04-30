package io.rocketapps.apps.android.flightcompanion.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by macbook on 4/25/17.
 */

public class TrackItemsModel extends RealmObject {

    @PrimaryKey
    long id;
    long date;
    String description;
    String office;
    String destination;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
