package com.omegasoft.humanity.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

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
    }

    public WorldView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WorldView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(World world) {
        getLayoutParams().width = (int) (world.getFinishX() - world.getStartX());
        getLayoutParams().height = (int) (world.getFinishY() - world.getStartY());
        requestLayout();

        world.change()
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::redrawWorld);
    }

    private void redrawWorld(World world) {
        FSLogger.w(1, "redrawWorld called.");
    }
}
