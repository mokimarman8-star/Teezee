package androidx.collection;

import java.lang.reflect.Array;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class c {
    static Object[] a(Object[] objArr, int i5) {
        if (objArr.length < i5) {
            return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i5);
        }
        if (objArr.length > i5) {
            objArr[i5] = null;
        }
        return objArr;
    }
}
