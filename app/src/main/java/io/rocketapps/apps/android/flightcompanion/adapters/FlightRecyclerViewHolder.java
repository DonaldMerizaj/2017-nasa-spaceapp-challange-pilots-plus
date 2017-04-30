package io.rocketapps.apps.android.flightcompanion.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import io.rocketapps.apps.android.flightcompanion.R;
import io.rocketapps.apps.android.flightcompanion.model.FlightModel;
import io.rocketapps.apps.android.flightcompanion.model.RealmCustomObject;

/**
 * Created by macbook on 4/29/17.
 */

public class FlightRecyclerViewHolder extends RecyclerView.ViewHolder {


    TextView txtFrom;
    TextView txtTo;
    TextView txtFromIata;
    TextView txtToIata;
    RealmCustomObject mItem;

    public FlightRecyclerViewHolder(View itemView, int viewType) {
        super(itemView);

        if (viewType == RealmCustomObject.SAVED_FLIGHT_LIST) {

            txtFrom = (TextView) itemView.findViewById(R.id.txt_from);
            txtTo = (TextView) itemView.findViewById(R.id.txt_to);
            txtFromIata = (TextView) itemView.findViewById(R.id.txt_from_iata);
            txtToIata = (TextView) itemView.findViewById(R.id.txt_to_iata);
        }
    }

    public void bind(Context mContext, RealmCustomObject object) {


        mItem = object;

        if(object.getViewType() == RealmCustomObject.SAVED_FLIGHT_LIST)
        {
            FlightModel flight = (FlightModel) object.getObject();
            txtFrom.setText(flight.getAirport_from());
            txtTo.setText(flight.getAirport_to());

            txtFromIata.setText(flight.getIata_from());
            txtToIata.setText(flight.getIata_to());

        }
    }
}
