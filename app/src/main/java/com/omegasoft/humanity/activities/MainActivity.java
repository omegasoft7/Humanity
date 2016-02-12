package com.omegasoft.humanity.activities;

import android.app.Activity;
import android.os.Bundle;

import com.omegasoft.humanity.R;
import com.omegasoft.humanity.models.Human;
import com.omegasoft.humanity.models.Location;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnTest)
    void onTestButtonClick() {
        Human human1 = new Human(null, null, "Adam");
        human1.moveTo(new Location(10, 20, 30), 1.0f);
    }
}
