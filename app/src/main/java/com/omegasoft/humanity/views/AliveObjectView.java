package com.omegasoft.humanity.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.omegasoft.humanity.humanity.HumanityAPP;
import com.omegasoft.humanity.interfaces.AliveObject;
import com.omegasoft.humanity.models.Location;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by farhad on 16.12.2.
 */
public class AliveObjectView extends View {

    public AliveObjectView(Context context) {
        super(context);
    }

    public AliveObjectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AliveObjectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(AliveObject aliveObject, int color) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aliveObject.getSize() * HumanityAPP.zoom, aliveObject.getSize() * HumanityAPP.zoom);
        setLayoutParams(layoutParams);

        setBackgroundColor(color);
        setClickable(true);

        aliveObject.change()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::redraw);

        if (!aliveObject.getLocation().equals(new Location(0, 0, 0))) {
            aliveObject.moveTo(aliveObject.getLocation(), 1);
        }
    }

    private void redraw(AliveObject aliveObject) {
        setX(aliveObject.getLocation().getX() * HumanityAPP.zoom);
        setY(aliveObject.getLocation().getY() * HumanityAPP.zoom);
//        setZ(aliveObject.getLocation().getZ());
    }
}
