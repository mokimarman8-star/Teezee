package com.google.firebase.remoteconfig.internal;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class t implements ad.k {
    private final String a;
    private final int b;

    t(String str, int i) {
        this.a = str;
        this.b = i;
    }

    private String f() {
        return b().trim();
    }

    private void g() {
        if (this.a == null) {
            throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
        }
    }

    @Override // ad.k
    public int a() {
        return this.b;
    }

    @Override // ad.k
    public String b() {
        if (this.b == 0) {
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
        g();
        return this.a;
    }

    @Override // ad.k
    public long c() {
        if (this.b == 0) {
            return 0L;
        }
        String f = f();
        try {
            return Long.valueOf(f).longValue();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", f, "long"), e);
        }
    }

    @Override // ad.k
    public double d() {
        if (this.b == 0) {
            return 0.0d;
        }
        String f = f();
        try {
            return Double.valueOf(f).doubleValue();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", f, "double"), e);
        }
    }

    @Override // ad.k
    public boolean e() {
        if (this.b == 0) {
            return false;
        }
        String f = f();
        if (m.f.matcher(f).matches()) {
            return true;
        }
        if (m.g.matcher(f).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", f, "boolean"));
    }
}
