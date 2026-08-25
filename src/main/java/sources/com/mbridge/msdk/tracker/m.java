package com.mbridge.msdk.tracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class m {
    private static final ConcurrentHashMap<String, m> b = new ConcurrentHashMap<>();
    private final k a;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                u.a().b();
                m.this.a.p().b();
            } catch (Exception e) {
                if (com.mbridge.msdk.tracker.a.a) {
                    Log.e("TrackManager", "flush error", e);
                }
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ e a;
        final /* synthetic */ JSONObject b;

        b(e eVar, JSONObject jSONObject) {
            this.a = eVar;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                m.this.a.g().a(this.a);
                JSONObject jSONObject = this.b;
                if (jSONObject != null) {
                    jSONObject.put("session_id", m.this.d());
                    long[] e = m.this.e();
                    this.b.put("track_time", e[0]);
                    this.b.put("track_count", e[1]);
                    this.a.a(this.b);
                }
                this.a.b(m.this.a.b().f);
                m.this.a.g().b(this.a);
            } catch (Exception unused) {
            }
        }
    }

    private m(String str, Context context, x xVar) {
        k kVar = new k(str, this);
        this.a = kVar;
        kVar.a(context);
        kVar.a(xVar);
    }

    public static m a(String str, Context context, x xVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentHashMap<String, m> concurrentHashMap = b;
        m mVar = concurrentHashMap.get(str);
        if (!y.b(mVar)) {
            return mVar;
        }
        m mVar2 = new m(str, context, xVar);
        concurrentHashMap.put(str, mVar2);
        return mVar2;
    }

    private boolean b(e eVar) {
        if (y.b(eVar) || TextUtils.isEmpty(eVar.b())) {
            return false;
        }
        return this.a.a(eVar);
    }

    public static m[] b() {
        ConcurrentHashMap<String, m> concurrentHashMap = b;
        m[] mVarArr = new m[concurrentHashMap.size()];
        try {
            Iterator<Map.Entry<String, m>> it = concurrentHashMap.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                mVarArr[i] = it.next().getValue();
                i++;
            }
        } catch (Exception e) {
            if (com.mbridge.msdk.tracker.a.a) {
                Log.e("TrackManager", "getAllTrackManager error", e);
            }
        }
        return mVarArr;
    }

    public void a() {
        try {
            this.a.h().a(new a());
        } catch (Exception e) {
            if (com.mbridge.msdk.tracker.a.a) {
                Log.e("TrackManager", "flush error", e);
            }
        }
    }

    public void a(JSONObject jSONObject) {
        this.a.a(jSONObject);
    }

    public boolean a(e eVar) {
        try {
            return b(eVar);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a(String str) {
        return a(new e(str));
    }

    public JSONObject c() {
        return this.a.o();
    }

    public void c(e eVar) {
        d(eVar);
    }

    public String d() {
        return this.a.s();
    }

    public void d(e eVar) {
        if (this.a.w()) {
            boolean z = com.mbridge.msdk.tracker.a.a;
            return;
        }
        if (eVar != null && b(eVar)) {
            JSONObject d = eVar.d();
            if (d != null && !d.has("ts")) {
                try {
                    d.put("ts", System.currentTimeMillis());
                } catch (Exception e) {
                    Log.e("TrackManager", "trackEvent error", e);
                }
            }
            try {
                this.a.h().a(new b(eVar, d));
            } catch (Exception e2) {
                if (com.mbridge.msdk.tracker.a.a) {
                    Log.e("TrackManager", "trackEvent error", e2);
                }
            }
        }
    }

    public long[] e() {
        return this.a.g().a();
    }

    public String f() {
        return this.a.v();
    }

    public boolean g() {
        return !this.a.w();
    }

    public String h() {
        if (!g()) {
            return this.a.x();
        }
        if (com.mbridge.msdk.tracker.a.a) {
            Log.e("TrackManager", "MBridgeTrackManager is already running");
        }
        return d();
    }
}
