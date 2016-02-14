package com.omegasoft.humanity.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.omegasoft.humanity.R;
import com.omegasoft.humanity.interfaces.World;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by farhad on 2/14/16.
 */
public class WorldFullView extends FrameLayout {

    @Bind(R.id.worldFullWorld)
    WorldView worldView;

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
        worldView.init(world);
    }
}
