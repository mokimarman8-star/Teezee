package com.mbridge.msdk.mbbanner.common.data;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class b {
    private String a;
    private String b;
    private String c = TtmlNode.ANONYMOUS_REGION_ID;
    private int d;
    private int e;

    public b(String str, String str2, int i, int i2) {
        this.a = str;
        this.b = str2;
        this.d = i;
        this.e = i2;
    }

    public String a() {
        return this.c;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(String str) {
        this.c = str;
    }

    public int b() {
        return this.e;
    }

    public void b(String str) {
        this.b = str;
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.b;
    }
}
