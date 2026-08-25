package y0;

import java.lang.reflect.Array;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class g {
    public static int[] a(int[] iArr, int i5, int i6) {
        if (i5 + 1 > iArr.length) {
            int[] iArr2 = new int[c(i5)];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            iArr = iArr2;
        }
        iArr[i5] = i6;
        return iArr;
    }

    public static Object[] b(Object[] objArr, int i5, Object obj) {
        if (i5 + 1 > objArr.length) {
            Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), c(i5));
            System.arraycopy(objArr, 0, objArr2, 0, i5);
            objArr = objArr2;
        }
        objArr[i5] = obj;
        return objArr;
    }

    public static int c(int i5) {
        if (i5 <= 4) {
            return 8;
        }
        return i5 * 2;
    }
}
