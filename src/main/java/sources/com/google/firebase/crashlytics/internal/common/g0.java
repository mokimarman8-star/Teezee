package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.common.h0;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.tmc.network.HttpClientConfig;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class g0 implements h0 {
    private static final Pattern g = Pattern.compile("[^\\p{Alnum}]");
    private static final String h = Pattern.quote("/");
    private final i0 a;
    private final Context b;
    private final String c;
    private final lc.e d;
    private final d0 e;
    private h0.a f;

    public g0(Context context, String str, lc.e eVar, d0 d0Var) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.b = context;
        this.c = str;
        this.d = eVar;
        this.e = d0Var;
        this.a = new i0();
    }

    private synchronized String b(String str, SharedPreferences sharedPreferences) {
        String e;
        e = e(UUID.randomUUID().toString());
        qb.g.f().i("Created new Crashlytics installation ID: " + e + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", e).putString("firebase.installation.id", str).apply();
        return e;
    }

    static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    private static String e(String str) {
        return g.matcher(str).replaceAll(TtmlNode.ANONYMOUS_REGION_ID).toLowerCase(Locale.US);
    }

    static boolean k(String str) {
        return str != null && str.startsWith("SYN_");
    }

    private String l(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", null);
    }

    private String m(String str) {
        return str.replaceAll(h, TtmlNode.ANONYMOUS_REGION_ID);
    }

    private boolean n() {
        h0.a aVar = this.f;
        return aVar == null || (aVar.e() == null && this.e.d());
    }

    @Override // com.google.firebase.crashlytics.internal.common.h0
    public synchronized h0.a a() {
        if (!n()) {
            return this.f;
        }
        qb.g.f().i("Determining Crashlytics installation ID...");
        SharedPreferences q = CommonUtils.q(this.b);
        String string = q.getString("firebase.installation.id", null);
        qb.g.f().i("Cached Firebase Installation ID: " + string);
        if (this.e.d()) {
            f0 d = d(false);
            qb.g.f().i("Fetched Firebase Installation ID: " + d.b());
            if (d.b() == null) {
                d = new f0(string == null ? c() : string, null);
            }
            if (Objects.equals(d.b(), string)) {
                this.f = h0.a.a(l(q), d);
            } else {
                this.f = h0.a.a(b(d.b(), q), d);
            }
        } else if (k(string)) {
            this.f = h0.a.b(l(q));
        } else {
            this.f = h0.a.b(b(c(), q));
        }
        qb.g.f().i("Install IDs: " + this.f);
        return this.f;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(7:13|14|4|5|6|7|8)|3|4|5|6|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
    
        qb.g.f().l("Error getting Firebase installation id.", r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f0 d(boolean z) {
        String b;
        CrashlyticsWorkers.e();
        String str = null;
        if (z) {
            try {
                b = ((com.google.firebase.installations.f) Tasks.await(this.d.a(false), HttpClientConfig.DEFAULT_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)).b();
            } catch (Exception e) {
                qb.g.f().l("Error getting Firebase authentication token.", e);
            }
            str = (String) Tasks.await(this.d.getId(), HttpClientConfig.DEFAULT_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
            return new f0(str, b);
        }
        b = null;
        str = (String) Tasks.await(this.d.getId(), HttpClientConfig.DEFAULT_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        return new f0(str, b);
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.a.a(this.b);
    }

    public String h() {
        return String.format(Locale.US, "%s/%s", m(Build.MANUFACTURER), m(Build.MODEL));
    }

    public String i() {
        return m(Build.VERSION.INCREMENTAL);
    }

    public String j() {
        return m(Build.VERSION.RELEASE);
    }
}
