package com.omegasoft.humanity.activities;

import android.app.Activity;
import android.os.Bundle;

import com.omegasoft.humanity.R;
import com.omegasoft.humanity.models.Earth;
import com.omegasoft.humanity.models.Human;
import com.omegasoft.humanity.models.Location;
import com.omegasoft.humanity.tools.HumanityUtils;
import com.omegasoft.humanity.views.WorldView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fslogger.lizsoft.lv.fslogger.FSLogger;

public class MainActivity extends Activity {

    @Bind(R.id.world)
    WorldView world;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        firstImplementation();
    }

    private void firstImplementation() {
        Earth earth = new Earth();

        human1 = new Human(null, null, "Adam");
        earth.attachObjectToWorld(human1);

        world.init(earth);
    }

    Human human1;

    @OnClick(R.id.btnTest)
    void onTestButtonClick() {
        FSLogger.w(1, "btnTest1 clicked.");

        HumanityUtils.showDialogWithView(this, human1);
    }

    @OnClick(R.id.btnTest2)
    void onTest2ButtonClick() {
        FSLogger.w(1, "btnTest2 clicked.");
        human1.moveTo(new Location(150, 180, 0), 1.0f).subscribe();
    }
}
