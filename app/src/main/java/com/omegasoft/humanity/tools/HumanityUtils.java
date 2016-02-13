package com.omegasoft.humanity.tools;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.omegasoft.humanity.R;
import com.omegasoft.humanity.interfaces.AliveObject;

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

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Enter a value:");
        builder.setView(R.layout.dialog_customview);
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //todo set received values from view to aliveobject
                aliveObject.notifyChange();

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
