package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class q0 {
    private final Object a;
    private final Object b;
    private final Object c;
    private final Object d;
    public volatile JSONObject e;
    private String f;
    private volatile ConcurrentHashMap<String, Boolean> g;
    private volatile ConcurrentHashMap<String, Integer> h;
    private volatile ConcurrentHashMap<String, String> i;
    private volatile com.mbridge.msdk.setting.g j;

    private static final class b {
        private static final q0 a = new q0();
    }

    private q0() {
        this.a = new Object();
        this.b = new Object();
        this.c = new Object();
        this.d = new Object();
    }

    private int a(String str, int i) {
        if (a(true)) {
            return i;
        }
        try {
            return this.e.optInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    private int a(String str, String str2, int i) {
        if (a(true)) {
            return i;
        }
        try {
            String optString = this.e.optString(str, TtmlNode.ANONYMOUS_REGION_ID);
            if (TextUtils.isEmpty(optString)) {
                return i;
            }
            String a2 = i0.a(optString);
            return TextUtils.isEmpty(a2) ? i : new JSONObject(a2).optInt(str2, i);
        } catch (Exception unused) {
            return i;
        }
    }

    public static q0 a() {
        return b.a;
    }

    private static Boolean a(String str, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private String a(String str, String str2, boolean z) {
        if (a(z)) {
            return str2;
        }
        try {
            return this.e.optString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    private boolean a(String str, boolean z, boolean z2) {
        if (a(z2)) {
            return z;
        }
        try {
            return this.e.optInt(str, z ? 1 : 0) != 0;
        } catch (Exception unused) {
            return z;
        }
    }

    private boolean a(boolean z) {
        synchronized (this.d) {
            if (this.j == null || e() || !z) {
                try {
                    if (TextUtils.isEmpty(this.f)) {
                        String b2 = com.mbridge.msdk.foundation.controller.c.m().b();
                        this.f = b2;
                        if (TextUtils.isEmpty(b2)) {
                            this.f = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("app_id");
                        }
                    }
                    this.j = com.mbridge.msdk.setting.h.b().b(this.f);
                } catch (Exception unused) {
                    this.j = null;
                }
            }
            if (this.j != null) {
                this.e = this.j.j0();
            }
        }
        return this.j == null || this.e == null;
    }

    private static Integer b(String str, ConcurrentHashMap<String, Integer> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private ConcurrentHashMap<String, Boolean> b() {
        synchronized (this.c) {
            try {
                if (this.g == null) {
                    this.g = new ConcurrentHashMap<>();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.g;
    }

    private static String c(String str, ConcurrentHashMap<String, String> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private ConcurrentHashMap<String, Integer> c() {
        synchronized (this.a) {
            try {
                if (this.h == null) {
                    this.h = new ConcurrentHashMap<>();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.h;
    }

    private ConcurrentHashMap<String, String> d() {
        synchronized (this.b) {
            try {
                if (this.i == null) {
                    this.i = new ConcurrentHashMap<>();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.i;
    }

    private boolean e() {
        return this.j.D() == 1;
    }

    public boolean a(String str, boolean z) {
        try {
            return b(str, z, true);
        } catch (Exception unused) {
            return z;
        }
    }

    public int b(String str, int i) {
        Integer valueOf;
        try {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            ConcurrentHashMap<String, Integer> c = c();
            Integer b2 = b(str, c);
            if (b2 != null) {
                return b2.intValue();
            }
            try {
                valueOf = Integer.valueOf(a(str, i));
            } catch (Exception unused) {
                valueOf = Integer.valueOf(i);
            }
            c.put(str, valueOf);
            return valueOf.intValue();
        } catch (Exception unused2) {
            return i;
        }
    }

    public int b(String str, String str2, int i) {
        Integer valueOf;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String str3 = str + "_" + str2;
                ConcurrentHashMap<String, Integer> c = c();
                Integer b2 = b(str3, c);
                if (b2 != null) {
                    return b2.intValue();
                }
                try {
                    valueOf = Integer.valueOf(a(str, str2, i));
                } catch (Exception unused) {
                    valueOf = Integer.valueOf(i);
                }
                c.put(str3, valueOf);
                return valueOf.intValue();
            }
            return b(str2, i);
        } catch (Exception unused2) {
            return i;
        }
    }

    public String b(String str, String str2, boolean z) {
        String str3;
        String c;
        try {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            ConcurrentHashMap<String, String> d = d();
            if (z && (c = c(str, d)) != null) {
                return c;
            }
            try {
                str3 = a(str, str2, z);
            } catch (Exception unused) {
                str3 = str2;
            }
            d.put(str, str3);
            return str3;
        } catch (Exception unused2) {
            return str2;
        }
    }

    public boolean b(String str, boolean z, boolean z2) {
        Boolean valueOf;
        Boolean a2;
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            ConcurrentHashMap<String, Boolean> b2 = b();
            if (z2 && (a2 = a(str, b2)) != null) {
                return a2.booleanValue();
            }
            try {
                valueOf = Boolean.valueOf(a(str, z, z2));
            } catch (Exception unused) {
                valueOf = Boolean.valueOf(z);
            }
            b2.put(str, valueOf);
            return valueOf.booleanValue();
        } catch (Exception unused2) {
            return z;
        }
    }
}
