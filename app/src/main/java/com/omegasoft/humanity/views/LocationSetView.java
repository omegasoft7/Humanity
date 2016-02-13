package com.omegasoft.humanity.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.omegasoft.humanity.R;

import butterknife.ButterKnife;

/**
 * Created by farhad on 2/13/16.
 */
public class LocationSetView extends RelativeLayout {
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
}
