package com.airbnb.lottie;

import android.graphics.Bitmap;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f14388a;

    /* renamed from: b, reason: collision with root package name */
    private final int f14389b;

    /* renamed from: c, reason: collision with root package name */
    private final String f14390c;

    /* renamed from: d, reason: collision with root package name */
    private final String f14391d;

    /* renamed from: e, reason: collision with root package name */
    private final String f14392e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f14393f;

    public l0(int i5, int i6, String str, String str2, String str3) {
        this.f14388a = i5;
        this.f14389b = i6;
        this.f14390c = str;
        this.f14391d = str2;
        this.f14392e = str3;
    }

    public l0 a(float f5) {
        l0 l0Var = new l0((int) (this.f14388a * f5), (int) (this.f14389b * f5), this.f14390c, this.f14391d, this.f14392e);
        Bitmap bitmap = this.f14393f;
        if (bitmap != null) {
            l0Var.g(Bitmap.createScaledBitmap(bitmap, l0Var.f14388a, l0Var.f14389b, true));
        }
        return l0Var;
    }

    public Bitmap b() {
        return this.f14393f;
    }

    public String c() {
        return this.f14391d;
    }

    public int d() {
        return this.f14389b;
    }

    public String e() {
        return this.f14390c;
    }

    public int f() {
        return this.f14388a;
    }

    public void g(Bitmap bitmap) {
        this.f14393f = bitmap;
    }
}
