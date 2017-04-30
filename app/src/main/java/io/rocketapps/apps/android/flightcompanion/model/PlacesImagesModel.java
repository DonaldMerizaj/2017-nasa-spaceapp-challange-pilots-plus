package io.rocketapps.apps.android.flightcompanion.model;

import io.realm.RealmObject;
import io.realm.annotations.Index;

/**
 * Created by macbook on 4/29/17.
 */

public class PlacesImagesModel extends RealmObject {

    @Index
    long id;
    String link;
    String title;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
