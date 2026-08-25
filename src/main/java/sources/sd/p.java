package sd;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class p implements com.google.zxing.i {
    /* JADX WARN: Removed duplicated region for block: B:34:0x0077 A[Catch: ReaderException -> 0x00c8, TRY_LEAVE, TryCatch #3 {ReaderException -> 0x00c8, blocks: (B:32:0x0071, B:34:0x0077), top: B:31:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ce A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.google.zxing.j d(com.google.zxing.b bVar, Map map) {
        p pVar;
        Map map2;
        int i;
        int i2;
        Map map3 = map;
        int d = bVar.d();
        int c = bVar.c();
        kd.a aVar = new kd.a(d);
        int i3 = 0;
        int i4 = 1;
        boolean z = map3 != null && map3.containsKey(DecodeHintType.TRY_HARDER);
        int max = Math.max(1, c >> (z ? 8 : 5));
        int i5 = z ? c : 15;
        int i6 = c / 2;
        int i7 = 0;
        while (i7 < i5) {
            int i8 = i7 + 1;
            int i9 = i8 / 2;
            if ((i7 & 1) != 0) {
                i9 = -i9;
            }
            int i10 = (i9 * max) + i6;
            if (i10 < 0 || i10 >= c) {
                break;
            }
            try {
                aVar = bVar.b(i10, aVar);
                int i11 = i3;
                while (i11 < 2) {
                    try {
                        if (i11 == i4) {
                            aVar.q();
                            if (map3 != null) {
                                DecodeHintType decodeHintType = DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                                if (map3.containsKey(decodeHintType)) {
                                    EnumMap enumMap = new EnumMap(DecodeHintType.class);
                                    enumMap.putAll(map3);
                                    enumMap.remove(decodeHintType);
                                    pVar = this;
                                    map3 = enumMap;
                                    com.google.zxing.j c2 = pVar.c(i10, aVar, map3);
                                    if (i11 != i4) {
                                        try {
                                            c2.h(ResultMetadataType.ORIENTATION, 180);
                                            com.google.zxing.k[] e = c2.e();
                                            if (e != null) {
                                                map2 = map3;
                                                float f = d;
                                                try {
                                                    i = d;
                                                } catch (ReaderException unused) {
                                                    i = d;
                                                    i2 = 1;
                                                    i11++;
                                                    i4 = i2;
                                                    map3 = map2;
                                                    d = i;
                                                    i3 = 0;
                                                }
                                                try {
                                                    e[0] = new com.google.zxing.k((f - e[i3].c()) - 1.0f, e[i3].d());
                                                    i2 = 1;
                                                } catch (ReaderException unused2) {
                                                    i2 = 1;
                                                    i11++;
                                                    i4 = i2;
                                                    map3 = map2;
                                                    d = i;
                                                    i3 = 0;
                                                }
                                                try {
                                                    e[1] = new com.google.zxing.k((f - e[1].c()) - 1.0f, e[1].d());
                                                } catch (ReaderException unused3) {
                                                    continue;
                                                    i11++;
                                                    i4 = i2;
                                                    map3 = map2;
                                                    d = i;
                                                    i3 = 0;
                                                }
                                            }
                                        } catch (ReaderException unused4) {
                                            map2 = map3;
                                        }
                                    }
                                    return c2;
                                }
                            }
                        }
                        com.google.zxing.j c22 = pVar.c(i10, aVar, map3);
                        if (i11 != i4) {
                        }
                        return c22;
                    } catch (ReaderException unused5) {
                        map2 = map3;
                        i = d;
                        i2 = i4;
                    }
                    pVar = this;
                }
            } catch (NotFoundException unused6) {
            }
            i7 = i8;
            i4 = i4;
            d = d;
            i3 = 0;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static float e(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    protected static void f(kd.a aVar, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int m = aVar.m();
        if (i >= m) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = !aVar.i(i);
        while (i < m) {
            if (aVar.i(i) != z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != m) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    protected static void g(kd.a aVar, int i, int[] iArr) {
        int length = iArr.length;
        boolean i2 = aVar.i(i);
        while (i > 0 && length >= 0) {
            i--;
            if (aVar.i(i) != i2) {
                length--;
                i2 = !i2;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        f(aVar, i + 1, iArr);
    }

    @Override // com.google.zxing.i
    public com.google.zxing.j a(com.google.zxing.b bVar, Map map) {
        try {
            return d(bVar, map);
        } catch (NotFoundException e) {
            if (map == null || !map.containsKey(DecodeHintType.TRY_HARDER) || !bVar.e()) {
                throw e;
            }
            com.google.zxing.b f = bVar.f();
            com.google.zxing.j d = d(f, map);
            Map d2 = d.d();
            int i = 270;
            if (d2 != null) {
                ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                if (d2.containsKey(resultMetadataType)) {
                    i = (((Integer) d2.get(resultMetadataType)).intValue() + 270) % 360;
                }
            }
            d.h(ResultMetadataType.ORIENTATION, Integer.valueOf(i));
            com.google.zxing.k[] e2 = d.e();
            if (e2 != null) {
                int c = f.c();
                for (int i2 = 0; i2 < e2.length; i2++) {
                    e2[i2] = new com.google.zxing.k((c - e2[i2].d()) - 1.0f, e2[i2].c());
                }
            }
            return d;
        }
    }

    @Override // com.google.zxing.i
    public com.google.zxing.j b(com.google.zxing.b bVar) {
        return a(bVar, null);
    }

    public abstract com.google.zxing.j c(int i, kd.a aVar, Map map);

    @Override // com.google.zxing.i
    public void reset() {
    }
}
