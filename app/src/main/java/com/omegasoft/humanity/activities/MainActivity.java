package com.omegasoft.humanity.activities;

import android.app.Activity;
import android.os.Bundle;

import com.omegasoft.humanity.R;
import com.omegasoft.humanity.models.Earth;
import com.omegasoft.humanity.models.Human;
import com.omegasoft.humanity.models.Location;
import com.omegasoft.humanity.tools.HumanityUtils;
import com.omegasoft.humanity.views.WorldFullView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fslogger.lizsoft.lv.fslogger.FSLogger;

public class MainActivity extends Activity {

    @Bind(R.id.world)
    WorldFullView world;

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

        Human human1 = new Human(null, null, "Adam");
        Human human2 = new Human(null, null, "Adam2");
        human2.setLocation(new Location(150, 150, 0));
        Human human3 = new Human(null, null, "Adam3");
        human3.setLocation(new Location(150, 0, 0));
        Human human4 = new Human(null, null, "Adam4");
        human4.setLocation(new Location(0, 150, 0));

        earth.attachObjectToWorld(human1);
        earth.attachObjectToWorld(human2);
        earth.attachObjectToWorld(human3);
        earth.attachObjectToWorld(human4);

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
    }
}
