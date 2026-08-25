package com.airbnb.lottie.model;

import android.graphics.PointF;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class DocumentData {

    /* renamed from: a, reason: collision with root package name */
    public String f14395a;

    /* renamed from: b, reason: collision with root package name */
    public String f14396b;

    /* renamed from: c, reason: collision with root package name */
    public float f14397c;

    /* renamed from: d, reason: collision with root package name */
    public Justification f14398d;

    /* renamed from: e, reason: collision with root package name */
    public int f14399e;

    /* renamed from: f, reason: collision with root package name */
    public float f14400f;

    /* renamed from: g, reason: collision with root package name */
    public float f14401g;

    /* renamed from: h, reason: collision with root package name */
    public int f14402h;

    /* renamed from: i, reason: collision with root package name */
    public int f14403i;

    /* renamed from: j, reason: collision with root package name */
    public float f14404j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14405k;

    /* renamed from: l, reason: collision with root package name */
    public PointF f14406l;

    /* renamed from: m, reason: collision with root package name */
    public PointF f14407m;

    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData() {
    }

    public DocumentData(String str, String str2, float f5, Justification justification, int i5, float f6, float f7, int i6, int i7, float f8, boolean z5, PointF pointF, PointF pointF2) {
        a(str, str2, f5, justification, i5, f6, f7, i6, i7, f8, z5, pointF, pointF2);
    }

    public void a(String str, String str2, float f5, Justification justification, int i5, float f6, float f7, int i6, int i7, float f8, boolean z5, PointF pointF, PointF pointF2) {
        this.f14395a = str;
        this.f14396b = str2;
        this.f14397c = f5;
        this.f14398d = justification;
        this.f14399e = i5;
        this.f14400f = f6;
        this.f14401g = f7;
        this.f14402h = i6;
        this.f14403i = i7;
        this.f14404j = f8;
        this.f14405k = z5;
        this.f14406l = pointF;
        this.f14407m = pointF2;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f14395a.hashCode() * 31) + this.f14396b.hashCode()) * 31) + this.f14397c)) * 31) + this.f14398d.ordinal()) * 31) + this.f14399e;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f14400f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f14402h;
    }
}
