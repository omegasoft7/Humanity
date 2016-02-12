package com.omegasoft.humanity.activities;

import android.app.Activity;
import android.os.Bundle;

import com.omegasoft.humanity.R;
import com.omegasoft.humanity.models.Earth;
import com.omegasoft.humanity.models.Human;
import com.omegasoft.humanity.models.Location;
import com.omegasoft.humanity.views.WorldView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.world)
    WorldView world;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnTest)
    void onTestButtonClick() {

        Earth earth = new Earth();

        Human human1 = new Human(null, null, "Adam");
        earth.attachObjectToWorld(human1);

        human1.moveTo(new Location(10, 20, 30), 1.0f);

        world.init(earth);
    }
}
