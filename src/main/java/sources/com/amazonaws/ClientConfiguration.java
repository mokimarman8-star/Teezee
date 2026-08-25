package com.amazonaws;

import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.VersionInfoUtils;
import javax.net.ssl.TrustManager;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ClientConfiguration {
    public static final String u = VersionInfoUtils.b();
    public static final RetryPolicy v = PredefinedRetryPolicies.b;
    private String b;
    private String q;
    private String a = u;
    private int c = -1;
    private RetryPolicy d = v;
    private Protocol e = Protocol.HTTPS;
    private String f = null;
    private int g = -1;
    private String h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    private int l = 10;
    private int m = 15000;
    private int n = 15000;
    private int o = 0;
    private int p = 0;
    private TrustManager r = null;
    private boolean s = false;
    private boolean t = false;

    public int a() {
        return this.n;
    }

    public int b() {
        return this.c;
    }

    public Protocol c() {
        return this.e;
    }

    public RetryPolicy d() {
        return this.d;
    }

    public String e() {
        return this.q;
    }

    public int f() {
        return this.m;
    }

    public TrustManager g() {
        return this.r;
    }

    public String h() {
        return this.a;
    }

    public String i() {
        return this.b;
    }

    public boolean j() {
        return this.s;
    }

    public boolean k() {
        return this.t;
    }
}
