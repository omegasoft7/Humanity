package com.omegasoft.humanity.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.omegasoft.humanity.R;
import com.omegasoft.humanity.models.Location;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by farhad on 2/13/16.
 */
public class LocationSetView extends RelativeLayout {

    @Bind(R.id.locationSetX)
    EditText locationSetX;

    @Bind(R.id.locationSetY)
    EditText locationSetY;

    @Bind(R.id.locationSetZ)
    EditText locationSetZ;

    @Bind(R.id.locationSetSpeed)
    EditText locationSetSpeed;

    public LocationSetView(Context context) {
        super(context);
        init();
    }

    public LocationSetView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LocationSetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_set_view, this);

        if (isInEditMode()) return;

        ButterKnife.bind(this, view);
    }

    public Location getLocation() {
        Location _loc = new Location();
        _loc.setX(Float.valueOf(String.valueOf(locationSetX.getText())));
        _loc.setY(Float.valueOf(String.valueOf(locationSetY.getText())));
        _loc.setZ(Float.valueOf(String.valueOf(locationSetZ.getText())));

        return _loc;
    }

    public float getSpeed() {
        return Float.valueOf(String.valueOf(locationSetSpeed.getText()));
    }
}
