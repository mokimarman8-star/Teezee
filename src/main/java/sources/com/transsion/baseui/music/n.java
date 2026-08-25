package com.transsion.baseui.music;

import com.transsion.baselib.db.download.DownloadException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n {
    private String a;
    private String b;
    private String c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private int i;
    private int j;

    public n() {
        this(null, null, null, 0L, 0L, 0L, 0L, 0L, 0, 0, 1023, null);
    }

    public n(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = j4;
        this.h = j5;
        this.i = i;
        this.j = i2;
    }

    public /* synthetic */ n(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) == 0 ? str3 : null, (i3 & 8) != 0 ? 0L : j, (i3 & 16) != 0 ? 0L : j2, (i3 & 32) != 0 ? 0L : j3, (i3 & 64) != 0 ? 0L : j4, (i3 & 128) == 0 ? j5 : 0L, (i3 & 256) != 0 ? 0 : i, (i3 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) == 0 ? i2 : 0);
    }

    public final int a() {
        return this.j;
    }

    public final long b() {
        return this.g;
    }

    public final long c() {
        return this.h;
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }

    public final long f() {
        return this.e;
    }

    public final long g() {
        return this.d;
    }

    public final String h() {
        return this.c;
    }

    public final long i() {
        return this.f;
    }

    public final int j() {
        return this.i;
    }

    public final void k(int i) {
        this.j = i;
    }

    public final void l(long j) {
        this.g = j;
    }

    public final void m(long j) {
        this.h = j;
    }

    public final void n(String str) {
        this.b = str;
    }

    public final void o(long j) {
        this.e = j;
    }

    public final void p(long j) {
        this.d = j;
    }

    public final void q(String str) {
        this.c = str;
    }

    public final void r(long j) {
        this.f = j;
    }

    public final void s(int i) {
        this.i = i;
    }
}
