package com.cloud.tmc.miniutils.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.cloud.tmc.miniutils.util.Utils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class UtilsTransActivity extends AppCompatActivity {
    private static final Map<UtilsTransActivity, TransActivityDelegate> CALLBACK_MAP = new HashMap();
    protected static final String EXTRA_DELEGATE = "extra_delegate";

    public static abstract class TransActivityDelegate implements Serializable {
        public boolean dispatchTouchEvent(@NonNull UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            return false;
        }

        public void onActivityResult(@NonNull UtilsTransActivity utilsTransActivity, int i, int i2, Intent intent) {
        }

        public void onCreateBefore(@NonNull UtilsTransActivity utilsTransActivity, @Nullable Bundle bundle) {
        }

        public void onCreated(@NonNull UtilsTransActivity utilsTransActivity, @Nullable Bundle bundle) {
        }

        public void onDestroy(@NonNull UtilsTransActivity utilsTransActivity) {
        }

        public void onPaused(@NonNull UtilsTransActivity utilsTransActivity) {
        }

        public void onRequestPermissionsResult(@NonNull UtilsTransActivity utilsTransActivity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        }

        public void onResumed(@NonNull UtilsTransActivity utilsTransActivity) {
        }

        public void onSaveInstanceState(@NonNull UtilsTransActivity utilsTransActivity, Bundle bundle) {
        }

        public void onStarted(@NonNull UtilsTransActivity utilsTransActivity) {
        }

        public void onStopped(@NonNull UtilsTransActivity utilsTransActivity) {
        }
    }

    public static void start(Activity activity, Utils.Consumer<Intent> consumer, TransActivityDelegate transActivityDelegate) {
        start(activity, consumer, transActivityDelegate, UtilsTransActivity.class);
    }

    protected static void start(Activity activity, Utils.Consumer<Intent> consumer, TransActivityDelegate transActivityDelegate, Class<?> cls) {
        if (transActivityDelegate == null) {
            return;
        }
        Intent intent = new Intent(Utils.getApp(), cls);
        intent.putExtra(EXTRA_DELEGATE, transActivityDelegate);
        if (consumer != null) {
            consumer.accept(intent);
        }
        if (activity != null) {
            activity.startActivity(intent);
            return;
        }
        try {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                topActivity.startActivity(intent);
            }
        } catch (Throwable th) {
            Log.e("UtilsTransActivity", "start: ", th);
            intent.addFlags(268435456);
            Utils.getApp().startActivity(intent);
        }
    }

    public static void start(Activity activity, TransActivityDelegate transActivityDelegate) {
        start(activity, null, transActivityDelegate, UtilsTransActivity.class);
    }

    public static void start(Utils.Consumer<Intent> consumer, TransActivityDelegate transActivityDelegate) {
        start(null, consumer, transActivityDelegate, UtilsTransActivity.class);
    }

    public static void start(TransActivityDelegate transActivityDelegate) {
        start(null, null, transActivityDelegate, UtilsTransActivity.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate != null && transActivityDelegate.dispatchTouchEvent(this, motionEvent)) {
            return true;
        }
        return super/*android.app.Activity*/.dispatchTouchEvent(motionEvent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onActivityResult(this, i, i2, intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle bundle) {
        overridePendingTransition(0, 0);
        Serializable serializableExtra = getIntent().getSerializableExtra(EXTRA_DELEGATE);
        if (!(serializableExtra instanceof TransActivityDelegate)) {
            super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
            finish();
            return;
        }
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) serializableExtra;
        CALLBACK_MAP.put(this, transActivityDelegate);
        transActivityDelegate.onCreateBefore(this, bundle);
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        transActivityDelegate.onCreated(this, bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        Map<UtilsTransActivity, TransActivityDelegate> map = CALLBACK_MAP;
        TransActivityDelegate transActivityDelegate = map.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onDestroy(this);
        map.remove(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onPause() {
        overridePendingTransition(0, 0);
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onPaused(this);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super/*androidx.fragment.app.FragmentActivity*/.onRequestPermissionsResult(i, strArr, iArr);
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onRequestPermissionsResult(this, i, strArr, iArr);
    }

    protected void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onResumed(this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onSaveInstanceState(this, bundle);
    }

    protected void onStart() {
        super.onStart();
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onStarted(this);
    }

    protected void onStop() {
        super.onStop();
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onStopped(this);
    }
}
