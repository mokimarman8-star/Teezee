package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import java.util.concurrent.ExecutionException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class i0 {
    static void A(String str, Bundle bundle) {
        try {
            com.google.firebase.f.l();
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = new Bundle();
            String d = d(bundle);
            if (d != null) {
                bundle2.putString("_nmid", d);
            }
            String e = e(bundle);
            if (e != null) {
                bundle2.putString("_nmn", e);
            }
            String i = i(bundle);
            if (!TextUtils.isEmpty(i)) {
                bundle2.putString("label", i);
            }
            String g = g(bundle);
            if (!TextUtils.isEmpty(g)) {
                bundle2.putString("message_channel", g);
            }
            String r = r(bundle);
            if (r != null) {
                bundle2.putString("_nt", r);
            }
            String l = l(bundle);
            if (l != null) {
                try {
                    bundle2.putInt("_nmt", Integer.parseInt(l));
                } catch (NumberFormatException e2) {
                    Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e2);
                }
            }
            String t = t(bundle);
            if (t != null) {
                try {
                    bundle2.putInt("_ndt", Integer.parseInt(t));
                } catch (NumberFormatException e3) {
                    Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e3);
                }
            }
            String n = n(bundle);
            if ("_nr".equals(str) || "_nf".equals(str)) {
                bundle2.putString("_nmc", n);
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Logging to scion event=");
                sb2.append(str);
                sb2.append(" scionPayload=");
                sb2.append(bundle2);
            }
            mb.a aVar = (mb.a) com.google.firebase.f.l().j(mb.a.class);
            if (aVar != null) {
                aVar.a("fcm", str, bundle2);
            } else {
                Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
            }
        } catch (IllegalStateException unused) {
            Log.e("FirebaseMessaging", "Default FirebaseApp has not been initialized. Skip logging event to GA.");
        }
    }

    private static void B(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (!"1".equals(bundle.getString("google.c.a.tc"))) {
            Log.isLoggable("FirebaseMessaging", 3);
            return;
        }
        mb.a aVar = (mb.a) com.google.firebase.f.l().j(mb.a.class);
        Log.isLoggable("FirebaseMessaging", 3);
        if (aVar == null) {
            Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
            return;
        }
        String string = bundle.getString("google.c.a.c_id");
        aVar.b("fcm", "_ln", string);
        Bundle bundle2 = new Bundle();
        bundle2.putString("source", "Firebase");
        bundle2.putString("medium", "notification");
        bundle2.putString(MBInterstitialActivity.INTENT_CAMAPIGN, string);
        aVar.a("fcm", "_cmp", bundle2);
    }

    public static boolean C(Intent intent) {
        if (intent == null || u(intent)) {
            return false;
        }
        return a();
    }

    public static boolean D(Intent intent) {
        if (intent == null || u(intent)) {
            return false;
        }
        return E(intent.getExtras());
    }

    public static boolean E(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return "1".equals(bundle.getString("google.c.a.e"));
    }

    static boolean a() {
        Context k;
        SharedPreferences sharedPreferences;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            com.google.firebase.f.l();
            k = com.google.firebase.f.l().k();
            sharedPreferences = k.getSharedPreferences("com.google.firebase.messaging", 0);
        } catch (PackageManager.NameNotFoundException | IllegalStateException unused) {
        }
        if (sharedPreferences.contains("export_to_big_query")) {
            return sharedPreferences.getBoolean("export_to_big_query", false);
        }
        PackageManager packageManager = k.getPackageManager();
        if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(k.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
            return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
        }
        return false;
    }

    static MessagingClientEvent b(MessagingClientEvent.Event event, Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = Bundle.EMPTY;
        }
        MessagingClientEvent.a j = MessagingClientEvent.p().n(s(extras)).e(event).f(f(extras)).i(o()).l(MessagingClientEvent.SDKPlatform.ANDROID).h(m(extras)).j(k(extras));
        String h = h(extras);
        if (h != null) {
            j.g(h);
        }
        String r = r(extras);
        if (r != null) {
            j.m(r);
        }
        String c = c(extras);
        if (c != null) {
            j.c(c);
        }
        String i = i(extras);
        if (i != null) {
            j.b(i);
        }
        String e = e(extras);
        if (e != null) {
            j.d(e);
        }
        long q = q(extras);
        if (q > 0) {
            j.k(q);
        }
        return j.a();
    }

    static String c(Bundle bundle) {
        return bundle.getString("collapse_key");
    }

    static String d(Bundle bundle) {
        return bundle.getString("google.c.a.c_id");
    }

    static String e(Bundle bundle) {
        return bundle.getString("google.c.a.c_l");
    }

    static String f(Bundle bundle) {
        String string = bundle.getString("google.to");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return (String) Tasks.await(com.google.firebase.installations.c.q(com.google.firebase.f.l()).getId());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    static String g(Bundle bundle) {
        return bundle.getString("google.c.a.m_c");
    }

    static String h(Bundle bundle) {
        String string = bundle.getString("google.message_id");
        return string == null ? bundle.getString("message_id") : string;
    }

    static String i(Bundle bundle) {
        return bundle.getString("google.c.a.m_l");
    }

    private static int j(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    static int k(Bundle bundle) {
        int p = p(bundle);
        if (p == 2) {
            return 5;
        }
        return p == 1 ? 10 : 0;
    }

    static String l(Bundle bundle) {
        return bundle.getString("google.c.a.ts");
    }

    static MessagingClientEvent.MessageType m(Bundle bundle) {
        return (bundle == null || !k0.t(bundle)) ? MessagingClientEvent.MessageType.DATA_MESSAGE : MessagingClientEvent.MessageType.DISPLAY_NOTIFICATION;
    }

    static String n(Bundle bundle) {
        return (bundle == null || !k0.t(bundle)) ? "data" : "display";
    }

    static String o() {
        return com.google.firebase.f.l().k().getPackageName();
    }

    static int p(Bundle bundle) {
        String string = bundle.getString("google.delivered_priority");
        if (string == null) {
            if ("1".equals(bundle.getString("google.priority_reduced"))) {
                return 2;
            }
            string = bundle.getString("google.priority");
        }
        return j(string);
    }

    static long q(Bundle bundle) {
        if (bundle.containsKey("google.c.sender.id")) {
            try {
                return Long.parseLong(bundle.getString("google.c.sender.id"));
            } catch (NumberFormatException e) {
                Log.w("FirebaseMessaging", "error parsing project number", e);
            }
        }
        com.google.firebase.f l = com.google.firebase.f.l();
        String d = l.n().d();
        if (d != null) {
            try {
                return Long.parseLong(d);
            } catch (NumberFormatException e2) {
                Log.w("FirebaseMessaging", "error parsing sender ID", e2);
            }
        }
        String c = l.n().c();
        if (c.startsWith("1:")) {
            String[] split = c.split(":");
            if (split.length < 2) {
                return 0L;
            }
            String str = split[1];
            if (str.isEmpty()) {
                return 0L;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e3) {
                Log.w("FirebaseMessaging", "error parsing app ID", e3);
            }
        } else {
            try {
                return Long.parseLong(c);
            } catch (NumberFormatException e4) {
                Log.w("FirebaseMessaging", "error parsing app ID", e4);
            }
        }
        return 0L;
    }

    static String r(Bundle bundle) {
        String string = bundle.getString("from");
        if (string == null || !string.startsWith("/topics/")) {
            return null;
        }
        return string;
    }

    static int s(Bundle bundle) {
        Object obj = bundle.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid TTL: " + obj);
            return 0;
        }
    }

    static String t(Bundle bundle) {
        if (bundle.containsKey("google.c.a.udt")) {
            return bundle.getString("google.c.a.udt");
        }
        return null;
    }

    private static boolean u(Intent intent) {
        return "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction());
    }

    public static void v(Intent intent) {
        A("_nd", intent.getExtras());
    }

    public static void w(Intent intent) {
        A("_nf", intent.getExtras());
    }

    public static void x(Bundle bundle) {
        B(bundle);
        A("_no", bundle);
    }

    public static void y(Intent intent) {
        if (D(intent)) {
            A("_nr", intent.getExtras());
        }
        if (C(intent)) {
            z(MessagingClientEvent.Event.MESSAGE_DELIVERED, intent, FirebaseMessaging.u());
        }
    }

    private static void z(MessagingClientEvent.Event event, Intent intent, t8.i iVar) {
        if (iVar == null) {
            Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
            return;
        }
        MessagingClientEvent b = b(event, intent);
        if (b == null) {
            return;
        }
        try {
            iVar.b("FCM_CLIENT_EVENT_LOGGING", pc.a.class, t8.c.b("proto"), new t8.g() { // from class: com.google.firebase.messaging.h0
                public final Object apply(Object obj) {
                    return ((pc.a) obj).c();
                }
            }).a(t8.d.g(pc.a.b().b(b).a(), t8.f.b(Integer.valueOf(intent.getIntExtra("google.product_id", 111881503)))));
        } catch (RuntimeException e) {
            Log.w("FirebaseMessaging", "Failed to send big query analytics payload.", e);
        }
    }
}
