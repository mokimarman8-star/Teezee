package sf;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Array;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class b {
    public static Bitmap a(Bitmap bitmap, int i5, boolean z5) {
        int[] iArr;
        int i6 = i5;
        Bitmap copy = z5 ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i6 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i7 = width * height;
        int[] iArr2 = new int[i7];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i8 = width - 1;
        int i9 = height - 1;
        int i10 = i6 + i6;
        int i11 = i10 + 1;
        int[] iArr3 = new int[i7];
        int[] iArr4 = new int[i7];
        int[] iArr5 = new int[i7];
        int[] iArr6 = new int[Math.max(width, height)];
        int i12 = (i10 + 2) >> 1;
        int i13 = i12 * i12;
        int i14 = i13 * 256;
        int[] iArr7 = new int[i14];
        for (int i15 = 0; i15 < i14; i15++) {
            iArr7[i15] = i15 / i13;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i11, 3);
        int i16 = i6 + 1;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i17 < height) {
            Bitmap bitmap2 = copy;
            int i20 = height;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = -i6;
            int i30 = 0;
            while (i29 <= i6) {
                int i31 = i9;
                int[] iArr9 = iArr6;
                int i32 = iArr2[i18 + Math.min(i8, Math.max(i29, 0))];
                int[] iArr10 = iArr8[i29 + i6];
                iArr10[0] = (i32 & 16711680) >> 16;
                iArr10[1] = (i32 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i32 & 255;
                int abs = i16 - Math.abs(i29);
                int i33 = iArr10[0];
                i30 += i33 * abs;
                int i34 = iArr10[1];
                i21 += i34 * abs;
                int i35 = iArr10[2];
                i22 += abs * i35;
                if (i29 > 0) {
                    i26 += i33;
                    i27 += i34;
                    i28 += i35;
                } else {
                    i23 += i33;
                    i24 += i34;
                    i25 += i35;
                }
                i29++;
                i9 = i31;
                iArr6 = iArr9;
            }
            int i36 = i9;
            int[] iArr11 = iArr6;
            int i37 = i6;
            int i38 = i30;
            int i39 = 0;
            while (i39 < width) {
                iArr3[i18] = iArr7[i38];
                iArr4[i18] = iArr7[i21];
                iArr5[i18] = iArr7[i22];
                int i40 = i38 - i23;
                int i41 = i21 - i24;
                int i42 = i22 - i25;
                int[] iArr12 = iArr8[((i37 - i6) + i11) % i11];
                int i43 = i23 - iArr12[0];
                int i44 = i24 - iArr12[1];
                int i45 = i25 - iArr12[2];
                if (i17 == 0) {
                    iArr = iArr7;
                    iArr11[i39] = Math.min(i39 + i6 + 1, i8);
                } else {
                    iArr = iArr7;
                }
                int i46 = iArr2[i19 + iArr11[i39]];
                int i47 = (i46 & 16711680) >> 16;
                iArr12[0] = i47;
                int i48 = (i46 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[1] = i48;
                int i49 = i46 & 255;
                iArr12[2] = i49;
                int i50 = i26 + i47;
                int i51 = i27 + i48;
                int i52 = i28 + i49;
                i38 = i40 + i50;
                i21 = i41 + i51;
                i22 = i42 + i52;
                i37 = (i37 + 1) % i11;
                int[] iArr13 = iArr8[i37 % i11];
                int i53 = iArr13[0];
                i23 = i43 + i53;
                int i54 = iArr13[1];
                i24 = i44 + i54;
                int i55 = iArr13[2];
                i25 = i45 + i55;
                i26 = i50 - i53;
                i27 = i51 - i54;
                i28 = i52 - i55;
                i18++;
                i39++;
                iArr7 = iArr;
            }
            i19 += width;
            i17++;
            copy = bitmap2;
            height = i20;
            i9 = i36;
            iArr6 = iArr11;
        }
        int[] iArr14 = iArr7;
        Bitmap bitmap3 = copy;
        int i56 = i9;
        int[] iArr15 = iArr6;
        int i57 = height;
        int i58 = 0;
        while (i58 < width) {
            int i59 = -i6;
            int i60 = i11;
            int[] iArr16 = iArr2;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            int i64 = 0;
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            int i68 = i59;
            int i69 = i59 * width;
            int i70 = 0;
            int i71 = 0;
            while (i68 <= i6) {
                int i72 = width;
                int max = Math.max(0, i69) + i58;
                int[] iArr17 = iArr8[i68 + i6];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i16 - Math.abs(i68);
                i70 += iArr3[max] * abs2;
                i71 += iArr4[max] * abs2;
                i61 += iArr5[max] * abs2;
                if (i68 > 0) {
                    i65 += iArr17[0];
                    i66 += iArr17[1];
                    i67 += iArr17[2];
                } else {
                    i62 += iArr17[0];
                    i63 += iArr17[1];
                    i64 += iArr17[2];
                }
                int i73 = i56;
                if (i68 < i73) {
                    i69 += i72;
                }
                i68++;
                i56 = i73;
                width = i72;
            }
            int i74 = width;
            int i75 = i56;
            int i76 = i6;
            int i77 = i58;
            int i78 = i57;
            int i79 = 0;
            while (i79 < i78) {
                iArr16[i77] = (iArr16[i77] & (-16777216)) | (iArr14[i70] << 16) | (iArr14[i71] << 8) | iArr14[i61];
                int i80 = i70 - i62;
                int i81 = i71 - i63;
                int i82 = i61 - i64;
                int[] iArr18 = iArr8[((i76 - i6) + i60) % i60];
                int i83 = i62 - iArr18[0];
                int i84 = i63 - iArr18[1];
                int i85 = i64 - iArr18[2];
                if (i58 == 0) {
                    iArr15[i79] = Math.min(i79 + i16, i75) * i74;
                }
                int i86 = iArr15[i79] + i58;
                int i87 = iArr3[i86];
                iArr18[0] = i87;
                int i88 = iArr4[i86];
                iArr18[1] = i88;
                int i89 = iArr5[i86];
                iArr18[2] = i89;
                int i90 = i65 + i87;
                int i91 = i66 + i88;
                int i92 = i67 + i89;
                i70 = i80 + i90;
                i71 = i81 + i91;
                i61 = i82 + i92;
                i76 = (i76 + 1) % i60;
                int[] iArr19 = iArr8[i76];
                int i93 = iArr19[0];
                i62 = i83 + i93;
                int i94 = iArr19[1];
                i63 = i84 + i94;
                int i95 = iArr19[2];
                i64 = i85 + i95;
                i65 = i90 - i93;
                i66 = i91 - i94;
                i67 = i92 - i95;
                i77 += i74;
                i79++;
                i6 = i5;
            }
            i58++;
            i6 = i5;
            i56 = i75;
            i57 = i78;
            i11 = i60;
            iArr2 = iArr16;
            width = i74;
        }
        int i96 = width;
        bitmap3.setPixels(iArr2, 0, i96, 0, 0, i96, i57);
        return bitmap3;
    }
}
