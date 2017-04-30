package io.rocketapps.apps.android.flightcompanion.network;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by FPEPOSHI on 3/31/16.
 */
public class DashboardCustomRequest extends JsonObjectRequest {

    public DashboardCustomRequest(int method, String url, JSONObject jsonRequest, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }


}
