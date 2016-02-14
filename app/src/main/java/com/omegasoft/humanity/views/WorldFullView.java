package com.omegasoft.humanity.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.omegasoft.humanity.R;
import com.omegasoft.humanity.interfaces.AliveObject;
import com.omegasoft.humanity.interfaces.World;
import com.omegasoft.humanity.tools.HumanityUtils;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by farhad on 2/14/16.
 */
public class WorldFullView extends FrameLayout {

    @Bind(R.id.worldFullSpinner)
    Spinner worldFullSpinner;

    @Bind(R.id.worldFullWorld)
    WorldView worldView;

    private World mWorld;
    private AliveObject mAliveObject;

    public WorldFullView(Context context) {
        super(context);
        init();
    }

    public WorldFullView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WorldFullView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.world_full_view, this);

        if (isInEditMode()) return;

        ButterKnife.bind(this, view);
    }

    public void init(World world) {
        this.mWorld = world;

        worldView.init(mWorld);

        mWorld.change()
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::redrawWorld);
    }

    private void redrawWorld(World world) {
        this.mWorld = world;

        ArrayAdapter<AliveObject> dataAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, mWorld.getObjecstInWorld());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        worldFullSpinner.setAdapter(dataAdapter);
    }


    @OnItemSelected(R.id.worldFullSpinner)
    void onSpinnerItemSelect(int position) {
        mAliveObject = mWorld.getObjecstInWorld().get(position);
    }

    @OnClick(R.id.worldFullActionButton)
    void onClickActionButton() {
        if (mAliveObject == null) return;

        HumanityUtils.showDialogWithView(getContext(), mAliveObject);
    }
}
