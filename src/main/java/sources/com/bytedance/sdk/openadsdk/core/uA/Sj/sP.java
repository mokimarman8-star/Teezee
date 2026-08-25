package com.bytedance.sdk.openadsdk.core.uA.Sj;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.util.ArrayMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP {
    private static volatile sP Sj;
    private final ArrayList<String> sP = new ArrayList<>();
    private final AtomicBoolean TKC = new AtomicBoolean(false);
    private long EjP = System.currentTimeMillis();
    private long HiB = 0;
    private long vS = 0;
    private String Jcg = "";
    private String Dq = "";
    private String uA = "";
    private boolean TEQ = false;
    private boolean Ym = false;

    private static int Sj(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static sP Sj(Application application) {
        if (Sj == null) {
            synchronized (sP.class) {
                try {
                    if (Sj == null) {
                        sP sPVar = new sP();
                        Sj = sPVar;
                        sPVar.TEQ = Sj((Context) application);
                        Sj.Ym = Sj(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                        Sj.Sj();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Sj;
    }

    private void Sj() {
        int size;
        boolean z = true;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(invoke);
            if (arrayMap != null && (size = arrayMap.size()) > 0) {
                Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                Field declaredField2 = cls2.getDeclaredField("stopped");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                for (int i = 0; i < size; i++) {
                    Object valueAt = arrayMap.valueAt(i);
                    if (!((Boolean) declaredField2.get(valueAt)).booleanValue()) {
                        String localClassName = ((Activity) declaredField3.get(valueAt)).getLocalClassName();
                        if (!this.sP.contains(localClassName)) {
                            this.sP.add(localClassName);
                        }
                    }
                }
                AtomicBoolean atomicBoolean = this.TKC;
                if (this.sP.size() > 0) {
                    z = false;
                }
                atomicBoolean.set(z);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean Sj(Context context) {
        ApplicationInfo applicationInfo;
        return (context == null || (applicationInfo = context.getApplicationInfo()) == null || (applicationInfo.flags & 1) <= 0) ? false : true;
    }

    public String Sj(String str, long j, int i) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.HiB;
        long j3 = currentTimeMillis - j;
        int i2 = j3 < 500 ? 1 : 0;
        if (this.TKC.get() && this.Ym) {
            i2 |= 2;
        }
        if (!this.TKC.get() && this.vS >= 5000 && j2 < 1000) {
            i2 = this.Dq.equals(this.uA) ? i2 | 4 : i2 | 8;
        }
        try {
            str2 = new JSONObject().put("rst", i2).put("adtag", str).put("bakdur", this.vS).put("rit", i).put("poptime", j2).put("unlocktime", j3).put("bakground", this.TKC).put("alert", this.Ym).put("sys", this.TEQ).put("actsize", this.sP.size()).put("mutiproc", com.bytedance.sdk.openadsdk.multipro.sP.TKC()).toString();
        } catch (JSONException unused) {
            str2 = "";
        }
        this.Jcg = "";
        this.vS = 0L;
        this.HiB = 0L;
        this.EjP = System.currentTimeMillis();
        return str2;
    }

    public void Sj(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.sP.size() == 0) {
            this.Jcg = localClassName;
            this.HiB = System.currentTimeMillis();
            this.vS = System.currentTimeMillis() - this.EjP;
            this.TKC.set(false);
        }
        if (!this.sP.contains(localClassName)) {
            this.sP.add(localClassName);
        }
        if (localClassName.contains("com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity") || localClassName.contains("com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity")) {
            return;
        }
        this.uA = localClassName;
    }

    public void sP(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.sP.contains(localClassName)) {
            this.sP.remove(localClassName);
        }
        if (this.sP.size() == 0) {
            this.EjP = System.currentTimeMillis();
            this.TKC.set(true);
            this.Dq = localClassName;
        }
    }
}
