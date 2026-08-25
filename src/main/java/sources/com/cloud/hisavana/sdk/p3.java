package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.bean.SSPWebPageReqInfo;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.sdk.commonutil.util.DeviceUtil;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class p3 {
    private final long a;
    private final String b;
    private final boolean c;
    private final int d;
    private final boolean e;
    private final int f;
    private final boolean g;
    private final int h;
    private final d7.b i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final double n;
    private final boolean o;
    private final int p;
    private final String q;
    private boolean r;
    private ConfigCodeSeatDTO s;
    private int t;
    private int u;
    private String v;
    private SSPWebPageReqInfo w;

    public static class b {
        private String a;
        private boolean b;
        private int c;
        private boolean d;
        private int e;
        private boolean f;
        private int g;
        private d7.b h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private double m;
        private boolean n;
        private int o;
        private String p;
        private int q;
        private String r;
        private SSPWebPageReqInfo s;
        private boolean t;

        public b() {
            this("");
        }

        public b(String str) {
            this.e = 1;
            this.i = true;
            this.j = false;
            this.k = false;
            this.l = false;
            this.n = false;
            this.t = false;
            this.p = DeviceUtil.o();
            this.q = 45000;
            if (TextUtils.isEmpty(str)) {
                this.r = com.cloud.hisavana.sdk.common.util.l0.b();
            } else {
                this.r = str;
            }
            this.o = 1;
            this.h = new d7.b(null, null, null);
        }

        public b a(int i) {
            if (i < 1) {
                i = 1;
            }
            this.e = i;
            return this;
        }

        public b b(SSPWebPageReqInfo sSPWebPageReqInfo) {
            this.s = sSPWebPageReqInfo;
            return this;
        }

        public b c(d7.a aVar) {
            if (aVar == null) {
                return this;
            }
            if (!this.t) {
                String c = aVar.c();
                if (!TextUtils.isEmpty(c)) {
                    this.p = c.replace("hisa-", "");
                }
            }
            if (aVar.e() > 0) {
                this.q = aVar.e();
            }
            if (aVar.d() != -1) {
                this.o = aVar.d();
            }
            this.n = aVar.g();
            String f = aVar.f();
            if (!this.t && !TextUtils.isEmpty(f)) {
                this.r = f.replace("hisa-", "");
            }
            if (aVar.b() > 0.0d) {
                this.m = aVar.b();
            }
            return this;
        }

        public b d(d7.b bVar) {
            if (bVar != null) {
                this.h = bVar;
            }
            return this;
        }

        public b e(String str) {
            this.a = str;
            return this;
        }

        public b f(boolean z) {
            this.t = z;
            return this;
        }

        public p3 g() {
            return new p3(this);
        }

        public b i(int i) {
            this.g = i;
            return this;
        }

        public b j(boolean z) {
            this.d = z;
            return this;
        }

        public b l(int i) {
            this.c = i;
            return this;
        }

        public b m(boolean z) {
            this.l = z;
            return this;
        }

        public b o(boolean z) {
            this.f = z;
            return this;
        }

        public b r(boolean z) {
            this.b = z;
            return this;
        }

        public b s(boolean z) {
            this.k = z;
            return this;
        }

        public b v(boolean z) {
            this.j = z;
            return this;
        }
    }

    private p3(b bVar) {
        this.r = false;
        this.b = bVar.a;
        this.c = bVar.b;
        this.d = bVar.c;
        this.e = bVar.d;
        this.f = bVar.e;
        this.g = bVar.f;
        this.h = bVar.g;
        this.i = bVar.h;
        this.j = bVar.i;
        this.k = bVar.j;
        this.l = bVar.k;
        this.m = bVar.l;
        this.n = bVar.m;
        this.o = bVar.n;
        this.p = bVar.o;
        this.v = bVar.p;
        this.q = bVar.r;
        this.u = bVar.q;
        this.a = System.currentTimeMillis();
        this.w = bVar.s;
        this.r = bVar.t;
    }

    public int a() {
        return this.f;
    }

    public void b(int i) {
        this.t = i;
    }

    public void c(ConfigCodeSeatDTO configCodeSeatDTO) {
        this.s = configCodeSeatDTO;
    }

    public void d(String str) {
        this.v = str;
    }

    public int e() {
        return this.h;
    }

    public ConfigCodeSeatDTO f() {
        ConfigCodeSeatDTO configCodeSeatDTO = this.s;
        return configCodeSeatDTO == null ? new ConfigCodeSeatDTO() : configCodeSeatDTO;
    }

    public long g() {
        return this.a;
    }

    public int h() {
        return this.d;
    }

    public String i() {
        return this.b;
    }

    public String j() {
        return this.v;
    }

    public int k() {
        return this.p;
    }

    public d7.b l() {
        return this.i;
    }

    public int m() {
        return this.u;
    }

    public String n() {
        return this.q;
    }

    public int o() {
        return this.t;
    }

    public SSPWebPageReqInfo p() {
        return this.w;
    }

    public boolean q() {
        return this.j;
    }

    public boolean r() {
        return this.r;
    }

    public boolean s() {
        return this.e;
    }

    public boolean t() {
        return this.m;
    }

    public boolean u() {
        return this.g;
    }

    public boolean v() {
        return this.c;
    }

    public boolean w() {
        return this.l;
    }

    public boolean x() {
        return this.k;
    }

    public boolean y() {
        return this.o;
    }
}
