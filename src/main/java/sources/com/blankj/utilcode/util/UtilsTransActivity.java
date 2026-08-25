package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class UtilsTransActivity extends AppCompatActivity {
    private static final Map a = new HashMap();

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

    protected static void O(Activity activity, Utils$b utils$b, TransActivityDelegate transActivityDelegate, Class cls) {
        if (transActivityDelegate == null) {
            return;
        }
        Intent intent = new Intent(Utils.a(), (Class<?>) cls);
        intent.putExtra("extra_delegate", transActivityDelegate);
        if (utils$b != null) {
            utils$b.accept(intent);
        }
        if (activity != null) {
            activity.startActivity(intent);
        } else {
            intent.addFlags(268435456);
            Utils.a().startActivity(intent);
        }
    }

    public static void P(Utils$b utils$b, TransActivityDelegate transActivityDelegate) {
        O(null, utils$b, transActivityDelegate, UtilsTransActivity.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) a.get(this);
        if (transActivityDelegate != null && transActivityDelegate.dispatchTouchEvent(this, motionEvent)) {
            return true;
        }
        return super/*android.app.Activity*/.dispatchTouchEvent(motionEvent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onActivityResult(this, i, i2, intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        overridePendingTransition(0, 0);
        Serializable serializableExtra = getIntent().getSerializableExtra("extra_delegate");
        if (!(serializableExtra instanceof TransActivityDelegate)) {
            super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
            finish();
            return;
        }
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) serializableExtra;
        a.put(this, transActivityDelegate);
        transActivityDelegate.onCreateBefore(this, bundle);
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        transActivityDelegate.onCreated(this, bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        Map map = a;
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) map.get(this);
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
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onPaused(this);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super/*androidx.fragment.app.FragmentActivity*/.onRequestPermissionsResult(i, strArr, iArr);
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onRequestPermissionsResult(this, i, strArr, iArr);
    }

    protected void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onResumed(this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onSaveInstanceState(this, bundle);
    }

    protected void onStart() {
        super.onStart();
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onStarted(this);
    }

    protected void onStop() {
        super.onStop();
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onStopped(this);
    }
}
