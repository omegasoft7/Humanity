package com.omegasoft.humanity.tools;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.omegasoft.humanity.interfaces.AliveObject;
import com.omegasoft.humanity.views.LocationSetView;

import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by farhad on 2/13/16.
 */
public class HumanityUtils {

    public static Observable<AliveObject> showDialogWithView(Context context, AliveObject aliveObject) {
        BehaviorSubject<AliveObject> behaviorSubject = BehaviorSubject.create();

        if (aliveObject == null) {
            behaviorSubject.onError(new NullPointerException("aliveObject is null."));
            return behaviorSubject.asObservable();
        }

        LocationSetView locationSetView = new LocationSetView(context);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Enter a value:");
        builder.setView(locationSetView);
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                aliveObject.moveTo(locationSetView.getLocation(), locationSetView.getSpeed());

                behaviorSubject.onNext(aliveObject);

                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //todo Do we need it here?
                behaviorSubject.onNext(aliveObject);

                dialog.dismiss();
            }
        });

        builder.create().show();

        return behaviorSubject.asObservable();
    }
}
