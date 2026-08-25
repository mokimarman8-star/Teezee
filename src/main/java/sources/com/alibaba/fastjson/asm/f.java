package com.alibaba.fastjson.asm;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    int f14690a;

    /* renamed from: b, reason: collision with root package name */
    int f14691b;

    /* renamed from: c, reason: collision with root package name */
    private int f14692c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f14693d;

    private void a(int i5, int i6, int i7) {
        if (this.f14693d == null) {
            this.f14693d = new int[6];
        }
        int i8 = this.f14692c;
        int[] iArr = this.f14693d;
        if (i8 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f14693d = iArr2;
        }
        int[] iArr3 = this.f14693d;
        int i9 = this.f14692c;
        int i10 = i9 + 1;
        this.f14692c = i10;
        iArr3[i9] = i5;
        this.f14692c = i9 + 2;
        iArr3[i10] = i6 | i7;
    }

    void b(i iVar, a aVar, int i5, boolean z5) {
        if ((this.f14690a & 2) != 0) {
            if (z5) {
                aVar.f(this.f14691b - i5);
                return;
            } else {
                aVar.g(this.f14691b - i5);
                return;
            }
        }
        if (z5) {
            a(i5, aVar.f14652b, 536870912);
            aVar.f(-1);
        } else {
            a(i5, aVar.f14652b, 268435456);
            aVar.g(-1);
        }
    }

    void c(i iVar, int i5, byte[] bArr) {
        this.f14690a |= 2;
        this.f14691b = i5;
        int i6 = 0;
        while (i6 < this.f14692c) {
            int[] iArr = this.f14693d;
            int i7 = i6 + 1;
            int i8 = iArr[i6];
            i6 += 2;
            int i9 = iArr[i7];
            int i10 = 268435455 & i9;
            int i11 = i5 - i8;
            if ((i9 & (-268435456)) == 268435456) {
                bArr[i10] = (byte) (i11 >>> 8);
                bArr[i10 + 1] = (byte) i11;
            } else {
                bArr[i10] = (byte) (i11 >>> 24);
                bArr[i10 + 1] = (byte) (i11 >>> 16);
                bArr[i10 + 2] = (byte) (i11 >>> 8);
                bArr[i10 + 3] = (byte) i11;
            }
        }
    }
}
