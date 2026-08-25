package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private float[] f3837a = new float[64];

    public static /* synthetic */ ArrayList b(g gVar, String str, ArrayList arrayList, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            arrayList = new ArrayList();
        }
        return gVar.a(str, arrayList);
    }

    public final ArrayList a(String str, ArrayList arrayList) {
        int i5;
        char charAt;
        int i6;
        int length = str.length();
        int i7 = 0;
        while (i7 < length && Intrinsics.j(str.charAt(i7), 32) <= 0) {
            i7++;
        }
        while (length > i7 && Intrinsics.j(str.charAt(length - 1), 32) <= 0) {
            length--;
        }
        int i8 = 0;
        while (i7 < length) {
            while (true) {
                i5 = i7 + 1;
                charAt = str.charAt(i7);
                int i9 = charAt | ' ';
                if ((i9 - 97) * (i9 - 122) <= 0 && i9 != 101) {
                    break;
                }
                if (i5 >= length) {
                    charAt = 0;
                    break;
                }
                i7 = i5;
            }
            if (charAt != 0) {
                if ((charAt | ' ') != 122) {
                    i8 = 0;
                    while (true) {
                        if (i5 >= length || Intrinsics.j(str.charAt(i5), 32) > 0) {
                            long a5 = b.a(str, i5, length);
                            i6 = (int) (a5 >>> 32);
                            float intBitsToFloat = Float.intBitsToFloat((int) (a5 & 4294967295L));
                            if (!Float.isNaN(intBitsToFloat)) {
                                float[] fArr = this.f3837a;
                                int i10 = i8 + 1;
                                fArr[i8] = intBitsToFloat;
                                if (i10 >= fArr.length) {
                                    float[] fArr2 = new float[i10 * 2];
                                    this.f3837a = fArr2;
                                    ArraysKt.i(fArr, fArr2, 0, 0, fArr.length);
                                }
                                i8 = i10;
                            }
                            while (i6 < length && str.charAt(i6) == ',') {
                                i6++;
                            }
                            if (i6 >= length || Float.isNaN(intBitsToFloat)) {
                                break;
                            }
                            i5 = i6;
                        } else {
                            i5++;
                        }
                    }
                    i5 = i6;
                }
                f.a(charAt, arrayList, this.f3837a, i8);
            }
            i7 = i5;
        }
        return arrayList;
    }
}
