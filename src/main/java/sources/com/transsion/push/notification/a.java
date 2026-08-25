package com.transsion.push.notification;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.transsion.lib.push.R$drawable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    private int a;
    public String b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private int h;
    private String i;
    private long j;
    private String k;
    private String l;
    private Bitmap m;
    private Bitmap n;
    private String o;
    private String p;
    private int q;
    private RemoteViews r;
    private RemoteViews s;
    private PendingIntent t;
    private PendingIntent u;
    private PendingIntent v;
    private PendingIntent w;
    private PendingIntent x;
    private boolean y;

    public a(Context context, int i) {
        Intrinsics.h(context, "context");
        this.a = i;
        this.g = true;
        this.h = R$drawable.push_small_logo;
        this.y = true;
    }

    public a A(String str) {
        this.l = str;
        return this;
    }

    public a B(String str) {
        this.k = str;
        return this;
    }

    public final void C(RemoteViews remoteViews) {
        this.s = remoteViews;
    }

    public final void D(RemoteViews remoteViews) {
        this.r = remoteViews;
    }

    public a E(PendingIntent pendingIntent) {
        this.u = pendingIntent;
        return this;
    }

    public a F(String str) {
        this.p = str;
        return this;
    }

    public final void G(boolean z) {
        this.f = z;
    }

    public a H(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.m = bitmap;
        }
        return this;
    }

    public final void I(PendingIntent pendingIntent) {
        this.w = pendingIntent;
    }

    public final void J(PendingIntent pendingIntent) {
        this.x = pendingIntent;
    }

    public final void K(boolean z) {
        this.c = z;
    }

    public a L(int i) {
        this.h = i;
        return this;
    }

    public final void M(int i) {
        this.h = i;
    }

    public final void N(boolean z) {
        this.y = z;
    }

    public a O(long j) {
        this.j = j;
        return this;
    }

    public final Bitmap a() {
        return this.n;
    }

    public final String b() {
        return this.o;
    }

    public final PendingIntent c() {
        return this.v;
    }

    public final String d() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        Intrinsics.y("channelId");
        return null;
    }

    public final int e() {
        return this.q;
    }

    public final PendingIntent f() {
        return this.t;
    }

    public final String g() {
        return this.l;
    }

    public final String h() {
        return this.k;
    }

    public final RemoteViews i() {
        return this.s;
    }

    public final RemoteViews j() {
        return this.r;
    }

    public final String k() {
        return this.p;
    }

    public final Bitmap l() {
        return this.m;
    }

    public final PendingIntent m() {
        return this.w;
    }

    public final PendingIntent n() {
        return this.x;
    }

    public final int o() {
        return this.h;
    }

    public final boolean p() {
        return this.y;
    }

    public final String q() {
        return this.i;
    }

    public final long r() {
        return this.j;
    }

    public final boolean s() {
        return this.g;
    }

    public final boolean t() {
        return this.f;
    }

    public final boolean u() {
        return this.c;
    }

    public final boolean v() {
        return this.d;
    }

    public final boolean w() {
        return this.e;
    }

    public a x(String str) {
        Intrinsics.h(str, "channelId");
        y(str);
        return this;
    }

    public final void y(String str) {
        Intrinsics.h(str, "<set-?>");
        this.b = str;
    }

    public a z(PendingIntent pendingIntent) {
        this.t = pendingIntent;
        return this;
    }
}
