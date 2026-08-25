package com.google.firebase.messaging;

import android.R;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class d {
    private static final AtomicInteger a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    public static class a {
        public final NotificationCompat.m a;
        public final String b;
        public final int c;

        a(NotificationCompat.m mVar, String str, int i) {
            this.a = mVar;
            this.b = str;
            this.c = i;
        }
    }

    private static PendingIntent a(Context context, k0 k0Var, String str, PackageManager packageManager) {
        Intent f = f(str, k0Var, packageManager);
        if (f == null) {
            return null;
        }
        f.addFlags(67108864);
        f.putExtras(k0Var.y());
        if (q(k0Var)) {
            f.putExtra("gcm.n.analytics_data", k0Var.x());
        }
        return PendingIntent.getActivity(context, g(), f, l(1073741824));
    }

    private static PendingIntent b(Context context, Context context2, k0 k0Var) {
        if (q(k0Var)) {
            return c(context, context2, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(k0Var.x()));
        }
        return null;
    }

    private static PendingIntent c(Context context, Context context2, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent("com.google.android.c2dm.intent.RECEIVE").setPackage(context2.getPackageName()).putExtra("wrapped_intent", intent), l(1073741824));
    }

    public static a d(Context context, Context context2, k0 k0Var, String str, Bundle bundle) {
        String packageName = context2.getPackageName();
        Resources resources = context2.getResources();
        PackageManager packageManager = context2.getPackageManager();
        NotificationCompat.m mVar = new NotificationCompat.m(context2, str);
        String n = k0Var.n(resources, packageName, "gcm.n.title");
        if (!TextUtils.isEmpty(n)) {
            mVar.r(n);
        }
        String n2 = k0Var.n(resources, packageName, "gcm.n.body");
        if (!TextUtils.isEmpty(n2)) {
            mVar.q(n2);
            mVar.L(new NotificationCompat.k().q(n2));
        }
        mVar.J(m(packageManager, resources, packageName, k0Var.p("gcm.n.icon"), bundle));
        Uri n3 = n(packageName, k0Var, resources);
        if (n3 != null) {
            mVar.K(n3);
        }
        mVar.p(a(context, k0Var, packageName, packageManager));
        PendingIntent b = b(context, context2, k0Var);
        if (b != null) {
            mVar.v(b);
        }
        Integer h = h(context2, k0Var.p("gcm.n.color"), bundle);
        if (h != null) {
            mVar.o(h.intValue());
        }
        mVar.l(!k0Var.a("gcm.n.sticky"));
        mVar.C(k0Var.a("gcm.n.local_only"));
        String p = k0Var.p("gcm.n.ticker");
        if (p != null) {
            mVar.M(p);
        }
        Integer m = k0Var.m();
        if (m != null) {
            mVar.G(m.intValue());
        }
        Integer r = k0Var.r();
        if (r != null) {
            mVar.O(r.intValue());
        }
        Integer l = k0Var.l();
        if (l != null) {
            mVar.D(l.intValue());
        }
        Long j = k0Var.j("gcm.n.event_time");
        if (j != null) {
            mVar.I(true);
            mVar.P(j.longValue());
        }
        long[] q = k0Var.q();
        if (q != null) {
            mVar.N(q);
        }
        int[] e = k0Var.e();
        if (e != null) {
            mVar.B(e[0], e[1], e[2]);
        }
        mVar.u(i(k0Var));
        return new a(mVar, o(k0Var), 0);
    }

    static a e(Context context, k0 k0Var) {
        Bundle j = j(context.getPackageManager(), context.getPackageName());
        return d(context, context, k0Var, k(context, k0Var.k(), j), j);
    }

    private static Intent f(String str, k0 k0Var, PackageManager packageManager) {
        String p = k0Var.p("gcm.n.click_action");
        if (!TextUtils.isEmpty(p)) {
            Intent intent = new Intent(p);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri f = k0Var.f();
        if (f != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(f);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w("FirebaseMessaging", "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    private static int g() {
        return a.incrementAndGet();
    }

    private static Integer h(Context context, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                Log.w("FirebaseMessaging", "Color is invalid: " + str + ". Notification will use default color.");
            }
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i == 0) {
            return null;
        }
        try {
            return Integer.valueOf(androidx.core.content.b.getColor(context, i));
        } catch (Resources.NotFoundException unused2) {
            Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static int i(k0 k0Var) {
        boolean a2 = k0Var.a("gcm.n.default_sound");
        ?? r0 = a2;
        if (k0Var.a("gcm.n.default_vibrate_timings")) {
            r0 = (a2 ? 1 : 0) | 2;
        }
        return k0Var.a("gcm.n.default_light_settings") ? r0 | 4 : r0;
    }

    private static Bundle j(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("FirebaseMessaging", "Couldn't get own application info: " + e);
        }
        return Bundle.EMPTY;
    }

    public static String k(Context context, String str, Bundle bundle) {
        String string;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (m.a.a(notificationManager, str) != null) {
                    return str;
                }
                Log.w("FirebaseMessaging", "Notification Channel requested (" + str + ") has not been created by the app. Manifest configuration, or default, value will be used.");
            }
            String string2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string2)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            } else {
                if (m.a.a(notificationManager, string2) != null) {
                    return string2;
                }
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            }
            if (m.a.a(notificationManager, "fcm_fallback_notification_channel") == null) {
                int identifier = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName());
                if (identifier == 0) {
                    Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                    string = "Misc";
                } else {
                    string = context.getString(identifier);
                }
                m.c.a(notificationManager, m.f.a("fcm_fallback_notification_channel", string, 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static int l(int i) {
        return i | 67108864;
    }

    private static int m(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && p(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && p(resources, identifier2)) {
                return identifier2;
            }
            Log.w("FirebaseMessaging", "Icon resource " + str2 + " not found. Notification will use default icon.");
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i == 0 || !p(resources, i)) {
            try {
                i = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("FirebaseMessaging", "Couldn't get own application info: " + e);
            }
        }
        return (i == 0 || !p(resources, i)) ? R.drawable.sym_def_app_icon : i;
    }

    private static Uri n(String str, k0 k0Var, Resources resources) {
        String o = k0Var.o();
        if (TextUtils.isEmpty(o)) {
            return null;
        }
        if ("default".equals(o) || resources.getIdentifier(o, "raw", str) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        return Uri.parse("android.resource://" + str + "/raw/" + o);
    }

    private static String o(k0 k0Var) {
        String p = k0Var.p("gcm.n.tag");
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        return "FCM-Notification:" + SystemClock.uptimeMillis();
    }

    private static boolean p(Resources resources, int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!c.a(resources.getDrawable(i, null))) {
                return true;
            }
            Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + i);
            return false;
        } catch (Resources.NotFoundException unused) {
            Log.e("FirebaseMessaging", "Couldn't find resource " + i + ", treating it as an invalid icon");
            return false;
        }
    }

    static boolean q(k0 k0Var) {
        return k0Var.a("google.c.a.e");
    }
}
