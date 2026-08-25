package com.transsion.room.helper;

import android.app.PendingIntent;
import android.location.LocationManager;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements ep.c {
    private final Fragment a;
    private Function1 b;
    private final androidx.activity.result.b c;

    public e(Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        this.a = fragment;
        androidx.activity.result.b registerForActivityResult = fragment.registerForActivityResult(new f.k(), new androidx.activity.result.a() { // from class: com.transsion.room.helper.a
            public final void a(Object obj) {
                e.g(e.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult, "registerForActivityResult(...)");
        this.c = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e eVar, ActivityResult activityResult) {
        Intrinsics.h(activityResult, "result");
        Function1 function1 = eVar.b;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(activityResult.getResultCode() == -1));
        }
        eVar.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Function1 function1, LocationSettingsResponse locationSettingsResponse) {
        function1.invoke(Boolean.TRUE);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(e eVar, Exception exc) {
        Intrinsics.h(exc, "exception");
        if (exc instanceof ResolvableApiException) {
            try {
                PendingIntent resolution = ((ResolvableApiException) exc).getResolution();
                Intrinsics.g(resolution, "getResolution(...)");
                eVar.c.a(new IntentSenderRequest.a(resolution).a());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // ep.c
    public void a(final Function1 function1) {
        Intrinsics.h(function1, "callback");
        this.b = function1;
        LocationRequest create = LocationRequest.create();
        create.setPriority(100);
        Intrinsics.g(create, "apply(...)");
        LocationSettingsRequest.Builder addLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(create);
        Intrinsics.g(addLocationRequest, "addLocationRequest(...)");
        FragmentActivity activity = this.a.getActivity();
        if (activity == null) {
            function1.invoke(Boolean.FALSE);
            return;
        }
        SettingsClient settingsClient = LocationServices.getSettingsClient(activity);
        Intrinsics.g(settingsClient, "getSettingsClient(...)");
        Task checkLocationSettings = settingsClient.checkLocationSettings(addLocationRequest.build());
        Intrinsics.g(checkLocationSettings, "checkLocationSettings(...)");
        final Function1 function12 = new Function1() { // from class: com.transsion.room.helper.b
            public final Object invoke(Object obj) {
                Unit h;
                h = e.h(function1, (LocationSettingsResponse) obj);
                return h;
            }
        };
        checkLocationSettings.addOnSuccessListener(new OnSuccessListener() { // from class: com.transsion.room.helper.c
            public final void onSuccess(Object obj) {
                e.i(function12, obj);
            }
        });
        checkLocationSettings.addOnFailureListener(new OnFailureListener() { // from class: com.transsion.room.helper.d
            public final void onFailure(Exception exc) {
                e.j(e.this, exc);
            }
        });
    }

    @Override // ep.c
    public boolean b() {
        LocationManager locationManager = (LocationManager) Utils.a().getSystemService("location");
        Intrinsics.e(locationManager);
        return locationManager.isProviderEnabled("gps");
    }
}
