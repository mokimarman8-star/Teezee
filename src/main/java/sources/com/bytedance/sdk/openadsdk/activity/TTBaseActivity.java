package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Build;
import com.bytedance.sdk.component.utils.sU;
import java.lang.reflect.Field;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TTBaseActivity extends Activity {
    protected boolean Jcg = false;

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        if (Build.VERSION.SDK_INT < 33) {
            super.onPause();
            return;
        }
        try {
            try {
                super.onPause();
            } catch (Exception unused) {
            }
        } catch (IllegalArgumentException unused2) {
            Field declaredField = Activity.class.getDeclaredField("mCalled");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.TRUE);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        int i = Build.VERSION.SDK_INT;
        if (i > 28 || i < 24) {
            super.onResume();
            return;
        }
        try {
            super.onResume();
        } catch (IllegalArgumentException e) {
            sU.Sj("TTBaseActivity", "super.onResume() run fail", e);
            try {
                Field declaredField = Activity.class.getDeclaredField("mCalled");
                declaredField.setAccessible(true);
                declaredField.set(this, Boolean.TRUE);
            } catch (Exception e2) {
                sU.Sj("TTBaseActivity", "onResume set mCalled fail", e2);
            }
        }
    }

    public void sP(boolean z) {
        this.Jcg = z;
    }
}
