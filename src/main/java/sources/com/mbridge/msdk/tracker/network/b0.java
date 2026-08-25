package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class b0 extends Exception {
    public final q a;
    private long b;
    private int c;
    private String d;

    public b0() {
        this.c = 0;
        this.d = TtmlNode.ANONYMOUS_REGION_ID;
        this.a = null;
    }

    public b0(q qVar) {
        this.c = 0;
        this.d = TtmlNode.ANONYMOUS_REGION_ID;
        this.a = qVar;
    }

    public b0(String str) {
        super(str);
        this.c = 0;
        this.d = TtmlNode.ANONYMOUS_REGION_ID;
        this.a = null;
    }

    public b0(Throwable th) {
        super(th);
        this.c = 0;
        this.d = TtmlNode.ANONYMOUS_REGION_ID;
        this.a = null;
    }

    public abstract int a();

    public void a(int i) {
        this.c = i;
    }

    void a(long j) {
        this.b = j;
    }

    public int b() {
        return this.c;
    }
}
