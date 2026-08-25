package com.mbridge.msdk.foundation.entity;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c {
    private int a;
    private List<String> d;
    private int i;
    private int j;
    private String b = TtmlNode.ANONYMOUS_REGION_ID;
    private String c = TtmlNode.ANONYMOUS_REGION_ID;
    private String e = TtmlNode.ANONYMOUS_REGION_ID;
    private long f = 0;
    private long g = 0;
    private long h = 0;

    public String a() {
        return this.b;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(List<String> list) {
        this.d = list;
    }

    public String b() {
        return this.c;
    }

    public void b(int i) {
        this.i = i;
    }

    public void b(long j) {
        this.g = j;
    }

    public void b(String str) {
        this.c = str;
    }

    public List<String> c() {
        return this.d;
    }

    public void c(int i) {
        this.j = i;
    }

    public void c(long j) {
        this.h = j;
    }

    public void c(String str) {
        this.e = str;
    }

    public String d() {
        return this.e;
    }

    public long e() {
        return this.g;
    }

    public long f() {
        return this.h;
    }
}
