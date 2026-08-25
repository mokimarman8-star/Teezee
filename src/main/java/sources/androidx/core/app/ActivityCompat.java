package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.content.b;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class ActivityCompat extends b {
    public static void b(Activity activity) {
        activity.finishAffinity();
    }

    public static void c(Activity activity) {
        a.a(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(Activity activity) {
        if (activity.isFinishing() || ActivityRecreator.i(activity)) {
            return;
        }
        activity.recreate();
    }

    public static void e(Activity activity) {
        a.b(activity);
    }

    public static void f(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new a(activity));
        }
    }

    public static void g(Activity activity, String[] strArr, int i) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (!hashSet.contains(Integer.valueOf(i4))) {
                    strArr2[i3] = strArr[i4];
                    i3++;
                }
            }
        }
        if (activity instanceof f) {
            ((f) activity).validateRequestPermissionsRequestCode(i);
        }
        b.b(activity, strArr, i);
    }

    public static void h(Activity activity, a0 a0Var) {
        a.c(activity, a0Var != null ? new g(a0Var) : null);
    }

    public static void i(Activity activity, a0 a0Var) {
        a.d(activity, a0Var != null ? new g(a0Var) : null);
    }

    public static boolean j(Activity activity, String str) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return i >= 32 ? d.a(activity, str) : i == 31 ? c.a(activity, str) : b.c(activity, str);
        }
        return false;
    }

    public static void k(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    public static void l(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public static void m(Activity activity) {
        a.e(activity);
    }
}
