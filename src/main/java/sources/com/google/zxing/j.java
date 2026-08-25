package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class j {
    private final String a;
    private final byte[] b;
    private final int c;
    private k[] d;
    private final BarcodeFormat e;
    private Map f;
    private final long g;

    public j(String str, byte[] bArr, int i, k[] kVarArr, BarcodeFormat barcodeFormat, long j) {
        this.a = str;
        this.b = bArr;
        this.c = i;
        this.d = kVarArr;
        this.e = barcodeFormat;
        this.f = null;
        this.g = j;
    }

    public j(String str, byte[] bArr, k[] kVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, kVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public j(String str, byte[] bArr, k[] kVarArr, BarcodeFormat barcodeFormat, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, kVarArr, barcodeFormat, j);
    }

    public void a(k[] kVarArr) {
        k[] kVarArr2 = this.d;
        if (kVarArr2 == null) {
            this.d = kVarArr;
            return;
        }
        if (kVarArr == null || kVarArr.length <= 0) {
            return;
        }
        k[] kVarArr3 = new k[kVarArr2.length + kVarArr.length];
        System.arraycopy(kVarArr2, 0, kVarArr3, 0, kVarArr2.length);
        System.arraycopy(kVarArr, 0, kVarArr3, kVarArr2.length, kVarArr.length);
        this.d = kVarArr3;
    }

    public BarcodeFormat b() {
        return this.e;
    }

    public byte[] c() {
        return this.b;
    }

    public Map d() {
        return this.f;
    }

    public k[] e() {
        return this.d;
    }

    public String f() {
        return this.a;
    }

    public void g(Map map) {
        if (map != null) {
            Map map2 = this.f;
            if (map2 == null) {
                this.f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f == null) {
            this.f = new EnumMap(ResultMetadataType.class);
        }
        this.f.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.a;
    }
}
