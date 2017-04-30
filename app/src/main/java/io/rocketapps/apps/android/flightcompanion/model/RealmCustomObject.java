package io.rocketapps.apps.android.flightcompanion.model;

import io.realm.RealmObject;

/**
 * Created by macbook on 4/29/17.
 */

public class RealmCustomObject {

    public static final int SAVED_FLIGHT_LIST = 1;

    int viewType;
    RealmObject object;


    public int getViewType() {
        return viewType;
    }

    public RealmCustomObject setViewType(int viewType) {
        this.viewType = viewType;

        return this;
    }

    public RealmObject getObject() {
        return object;
    }

    public RealmCustomObject setObject(RealmObject object) {
        this.object = object;
        return this;

    }
}
