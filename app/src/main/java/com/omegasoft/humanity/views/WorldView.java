package com.omegasoft.humanity.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.omegasoft.humanity.humanity.HumanityAPP;
import com.omegasoft.humanity.interfaces.AliveObject;
import com.omegasoft.humanity.interfaces.World;

import java.util.concurrent.TimeUnit;

import fslogger.lizsoft.lv.fslogger.FSLogger;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by farhad on 16.12.2.
 */
public class WorldView extends FrameLayout {

    public WorldView(Context context) {
        super(context);
        init();
    }

    public WorldView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WorldView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setBackgroundColor(Color.YELLOW);
    }

    public void init(World world) {
        getLayoutParams().width = (int) (world.getFinishX() - world.getStartX()) * HumanityAPP.zoom;
        getLayoutParams().height = (int) (world.getFinishY() - world.getStartY()) * HumanityAPP.zoom;
        requestLayout();

        world.change()
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::redrawWorld);
    }

    private void redrawWorld(World world) {
        FSLogger.w(1, "redrawWorld called.");
        //Remove whole previous views
        removeAllViews();

        //Draw new views
        for (AliveObject aliveObject : world.getObjecstInWorld()) {
            AliveObjectView aliveObjectView = new AliveObjectView(getContext());
            aliveObjectView.init(aliveObject, Color.RED);
            addView(aliveObjectView);
        }
    }
}
