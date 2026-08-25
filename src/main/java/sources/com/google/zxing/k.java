package com.google.zxing;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class k {
    private final float a;
    private final float b;

    public k(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    private static float a(k kVar, k kVar2, k kVar3) {
        float f = kVar2.a;
        float f2 = kVar2.b;
        return ((kVar3.a - f) * (kVar.b - f2)) - ((kVar3.b - f2) * (kVar.a - f));
    }

    public static float b(k kVar, k kVar2) {
        return ld.a.a(kVar.a, kVar.b, kVar2.a, kVar2.b);
    }

    public static void e(k[] kVarArr) {
        k kVar;
        k kVar2;
        k kVar3;
        float b = b(kVarArr[0], kVarArr[1]);
        float b2 = b(kVarArr[1], kVarArr[2]);
        float b3 = b(kVarArr[0], kVarArr[2]);
        if (b2 >= b && b2 >= b3) {
            kVar = kVarArr[0];
            kVar2 = kVarArr[1];
            kVar3 = kVarArr[2];
        } else if (b3 < b2 || b3 < b) {
            kVar = kVarArr[2];
            kVar2 = kVarArr[0];
            kVar3 = kVarArr[1];
        } else {
            kVar = kVarArr[1];
            kVar2 = kVarArr[0];
            kVar3 = kVarArr[2];
        }
        if (a(kVar2, kVar, kVar3) < 0.0f) {
            k kVar4 = kVar3;
            kVar3 = kVar2;
            kVar2 = kVar4;
        }
        kVarArr[0] = kVar2;
        kVarArr[1] = kVar;
        kVarArr[2] = kVar3;
    }

    public final float c() {
        return this.a;
    }

    public final float d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.a == kVar.a && this.b == kVar.b;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "(" + this.a + ',' + this.b + ')';
    }
}
