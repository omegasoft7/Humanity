package com.omegasoft.humanity.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.omegasoft.humanity.humanity.HumanityAPP;
import com.omegasoft.humanity.interfaces.AliveObject;

import fslogger.lizsoft.lv.fslogger.FSLogger;
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
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(1 * HumanityAPP.zoom, 1 * HumanityAPP.zoom);
        setLayoutParams(layoutParams);

        setBackgroundColor(color);
        setClickable(true);

        aliveObject.change()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::redraw);
    }

    private void redraw(AliveObject aliveObject) {
        setX(aliveObject.getLocation().getX() * HumanityAPP.zoom);
        setY(aliveObject.getLocation().getY() * HumanityAPP.zoom);
//        setZ(aliveObject.getLocation().getZ());
    }

    @Override
    public boolean performClick() {
        FSLogger.w(1, "performClick called");
        //todo this object clicked on word. do something for that
        return super.performClick();
    }
}
