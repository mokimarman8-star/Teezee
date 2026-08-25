package com.cloud.hisavana.sdk.common.util;

import android.graphics.Bitmap;
import android.util.Log;
import com.cloud.hisavana.sdk.b4;
import java.lang.reflect.Array;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class f {
    public static Bitmap a(Bitmap bitmap, int i, boolean z) {
        Bitmap copy;
        int[] iArr;
        int i2 = i;
        if (z) {
            copy = bitmap;
        } else {
            try {
                copy = bitmap.copy(bitmap.getConfig(), true);
            } catch (Throwable th) {
                b4.b().e(Log.getStackTraceString(th));
                return null;
            }
        }
        if (i2 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i8 = height - 1;
        int i9 = i2 + i2;
        int i10 = i9 + 1;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        int[] iArr6 = new int[Math.max(width, height)];
        int i11 = (i9 + 2) >> 1;
        int i12 = i11 * i11;
        int i13 = i12 * 256;
        int[] iArr7 = new int[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            iArr7[i14] = i14 / i12;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i10, 3);
        int i15 = i2 + 1;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i16 < height) {
            Bitmap bitmap2 = copy;
            int i19 = height;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            int i28 = -i2;
            int i29 = 0;
            while (i28 <= i2) {
                int i30 = i8;
                int[] iArr9 = iArr6;
                int i31 = iArr2[i17 + Math.min(i4, Math.max(i28, 0))];
                int[] iArr10 = iArr8[i28 + i2];
                iArr10[0] = (i31 & 16711680) >> 16;
                iArr10[1] = (i31 & 65280) >> 8;
                iArr10[2] = i31 & 255;
                int abs = i15 - Math.abs(i28);
                int i32 = iArr10[0];
                i21 += i32 * abs;
                int i33 = iArr10[1];
                i20 += i33 * abs;
                int i34 = iArr10[2];
                i29 += abs * i34;
                if (i28 > 0) {
                    i25 += i32;
                    i27 += i33;
                    i26 += i34;
                } else {
                    i24 += i32;
                    i23 += i33;
                    i22 += i34;
                }
                i28++;
                i8 = i30;
                iArr6 = iArr9;
            }
            int i35 = i8;
            int[] iArr11 = iArr6;
            int i36 = i2;
            int i37 = i29;
            int i38 = 0;
            while (i38 < width) {
                iArr3[i17] = iArr7[i21];
                iArr4[i17] = iArr7[i20];
                iArr5[i17] = iArr7[i37];
                int i39 = i21 - i24;
                int i40 = i20 - i23;
                int i41 = i37 - i22;
                int[] iArr12 = iArr8[((i36 - i2) + i10) % i10];
                int i42 = i24 - iArr12[0];
                int i43 = i23 - iArr12[1];
                int i44 = i22 - iArr12[2];
                if (i16 == 0) {
                    iArr = iArr7;
                    iArr11[i38] = Math.min(i38 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i45 = iArr2[i18 + iArr11[i38]];
                int i46 = (i45 & 16711680) >> 16;
                iArr12[0] = i46;
                int i47 = (i45 & 65280) >> 8;
                iArr12[1] = i47;
                int i48 = i45 & 255;
                iArr12[2] = i48;
                int i49 = i25 + i46;
                int i50 = i27 + i47;
                int i51 = i26 + i48;
                i21 = i39 + i49;
                i20 = i40 + i50;
                i37 = i41 + i51;
                i36 = (i36 + 1) % i10;
                int[] iArr13 = iArr8[i36 % i10];
                int i52 = iArr13[0];
                i24 = i42 + i52;
                int i53 = iArr13[1];
                i23 = i43 + i53;
                int i54 = iArr13[2];
                i22 = i44 + i54;
                i25 = i49 - i52;
                i27 = i50 - i53;
                i26 = i51 - i54;
                i17++;
                i38++;
                iArr7 = iArr;
            }
            i18 += width;
            i16++;
            copy = bitmap2;
            height = i19;
            i8 = i35;
            iArr6 = iArr11;
        }
        int[] iArr14 = iArr7;
        Bitmap bitmap3 = copy;
        int i55 = i8;
        int[] iArr15 = iArr6;
        int i56 = height;
        int i57 = 0;
        while (i57 < width) {
            int i58 = -i2;
            int i59 = i10;
            int[] iArr16 = iArr2;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            int i64 = 0;
            int i65 = 0;
            int i66 = 0;
            int i67 = i58;
            int i68 = i58 * width;
            int i69 = 0;
            int i70 = 0;
            while (i67 <= i2) {
                int i71 = width;
                int max = Math.max(0, i68) + i57;
                int[] iArr17 = iArr8[i67 + i2];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i15 - Math.abs(i67);
                i60 += iArr3[max] * abs2;
                i70 += iArr4[max] * abs2;
                i69 += iArr5[max] * abs2;
                if (i67 > 0) {
                    i66 += iArr17[0];
                    i65 += iArr17[1];
                    i64 += iArr17[2];
                } else {
                    i63 += iArr17[0];
                    i62 += iArr17[1];
                    i61 += iArr17[2];
                }
                int i72 = i55;
                if (i67 < i72) {
                    i68 += i71;
                }
                i67++;
                i55 = i72;
                width = i71;
            }
            int i73 = width;
            int i74 = i55;
            int i75 = i2;
            int i76 = i57;
            int i77 = i60;
            int i78 = i56;
            int i79 = i70;
            int i80 = i69;
            int i81 = 0;
            while (i81 < i78) {
                iArr16[i76] = (iArr16[i76] & (-16777216)) | (iArr14[i77] << 16) | (iArr14[i79] << 8) | iArr14[i80];
                int i82 = i77 - i63;
                int i83 = i79 - i62;
                int i84 = i80 - i61;
                int[] iArr18 = iArr8[((i75 - i2) + i59) % i59];
                int i85 = i63 - iArr18[0];
                int i86 = i62 - iArr18[1];
                int i87 = i61 - iArr18[2];
                if (i57 == 0) {
                    iArr15[i81] = Math.min(i81 + i15, i74) * i73;
                }
                int i88 = iArr15[i81] + i57;
                int i89 = iArr3[i88];
                iArr18[0] = i89;
                int i90 = iArr4[i88];
                iArr18[1] = i90;
                int i91 = iArr5[i88];
                iArr18[2] = i91;
                int i92 = i66 + i89;
                int i93 = i65 + i90;
                int i94 = i64 + i91;
                i77 = i82 + i92;
                i79 = i83 + i93;
                i80 = i84 + i94;
                i75 = (i75 + 1) % i59;
                int[] iArr19 = iArr8[i75];
                int i95 = iArr19[0];
                i63 = i85 + i95;
                int i96 = iArr19[1];
                i62 = i86 + i96;
                int i97 = iArr19[2];
                i61 = i87 + i97;
                i66 = i92 - i95;
                i65 = i93 - i96;
                i64 = i94 - i97;
                i76 += i73;
                i81++;
                i2 = i;
            }
            i57++;
            i2 = i;
            i55 = i74;
            i56 = i78;
            i10 = i59;
            iArr2 = iArr16;
            width = i73;
        }
        int i98 = width;
        bitmap3.setPixels(iArr2, 0, i98, 0, 0, i98, i56);
        return bitmap3;
    }
}
