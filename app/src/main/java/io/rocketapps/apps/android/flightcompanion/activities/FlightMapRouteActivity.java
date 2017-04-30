package io.rocketapps.apps.android.flightcompanion.activities;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONException;

import io.rocketapps.apps.android.flightcompanion.R;
import io.rocketapps.apps.android.flightcompanion.model.FlightModel;
import io.rocketapps.apps.android.flightcompanion.model.RealmController;
import io.rocketapps.apps.android.flightcompanion.model.Utils;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class FlightMapRouteActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private long uniqueId;
    private FlightModel mFlight;
    private Polyline mRouteFlight;
    private MarkerOptions mMarkerFrom;
    private MarkerOptions mMarkerTo;
    private String TAG = "VIEWMAP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_map_route);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Bundle bundle = getIntent().getExtras();

        if(bundle != null)
        {
            uniqueId = bundle.getLong("object_id");
            mFlight = RealmController.with(this).getSingleObject(uniqueId);


            setTitle(mFlight.getIata_from()+" -> "+ mFlight.getIata_to());
            toolbar.setTitle(mFlight.getIata_from()+" -> "+ mFlight.getIata_to());


        }
    }

    private void initData() {

        try {

            if (mMap == null)
                return;


            mMap.clear();

            LatLng mFrom = null;
            LatLng mTo = null;

                mFrom = new LatLng(mFlight.getLatFrom(), mFlight.getLngFrom());

                mMarkerFrom = new MarkerOptions().position(mFrom)
                        .title(mFlight.getAirport_from());
                mMap.addMarker(mMarkerFrom);
                mMap.setMaxZoomPreference(12F);
                mMap.animateCamera(CameraUpdateFactory.newLatLng(mFrom));

                mTo = new LatLng(mFlight.getLatTo(), mFlight.getLngTo());


                mMarkerTo = new MarkerOptions().position(mTo)
                        .title(mFlight.getAirport_to());
                mMap.addMarker(mMarkerTo);
                mMap.setMaxZoomPreference(12F);
                mMap.animateCamera(CameraUpdateFactory.newLatLng(mTo));



                if (mRouteFlight != null) {
                    mRouteFlight.remove();
                }
                LatLngBounds b = new LatLngBounds.Builder().include(mFrom).include(mTo).build();

                Utils.Log(TAG, b.getCenter().toString());

                MarkerOptions mCenter = new MarkerOptions().position(b.getCenter())
                        .anchor(0.5f, 0.5f)
                        .rotation((float) getBearing(mFrom, mTo))
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_plane_white));
                mMap.addMarker(mCenter);


                mRouteFlight = mMap.addPolyline(new PolylineOptions()
                        .add(mFrom, mTo)
                        .width(5)
                        .color(Color.RED));
                mRouteFlight.setJointType(JointType.ROUND);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private static double degreeToRadians(double latLong) {
        return (Math.PI * latLong / 180.0);
    }

    private static double radiansToDegree(double latLong) {
        return (latLong * 180.0 / Math.PI);
    }

    public static double getBearing(LatLng l1, LatLng l2) {

        double lat1 = l1.latitude;
        double lng1 = l1.longitude;

        double lat2 =l2.latitude;
        double lng2 = l2.longitude;

        double fLat = degreeToRadians(lat1);
        double fLong = degreeToRadians(lng1);
        double tLat = degreeToRadians(lat2);
        double tLong = degreeToRadians(lng2);

        double dLon = (tLong - fLong);

        double degree = radiansToDegree(Math.atan2(sin(dLon) * cos(tLat),
                cos(fLat) * sin(tLat) - sin(fLat) * cos(tLat) * cos(dLon)));

        if (degree >= 0) {
            return degree;
        } else {
            return 360 + degree;
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        if(mFlight != null)
        {
            initData();
        }

    }
}
