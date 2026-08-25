package org.mvel2.util;

import java.lang.reflect.Array;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class t {
    public static Object[] a(Class[] clsArr, Object[] objArr, boolean z) {
        if (!z) {
            return objArr;
        }
        Object newInstance = objArr.length > 0 ? objArr[objArr.length - 1] : Array.newInstance(clsArr[clsArr.length - 1].getComponentType(), 0);
        if (clsArr.length == objArr.length && (newInstance == null || newInstance.getClass().isArray())) {
            return objArr;
        }
        int length = (objArr.length - clsArr.length) + 1;
        Object newInstance2 = Array.newInstance(clsArr[clsArr.length - 1].getComponentType(), length);
        for (int i = 0; i < length; i++) {
            Array.set(newInstance2, i, objArr[(clsArr.length - 1) + i]);
        }
        Object[] objArr2 = new Object[clsArr.length];
        for (int i2 = 0; i2 < clsArr.length - 1; i2++) {
            objArr2[i2] = objArr[i2];
        }
        objArr2[clsArr.length - 1] = newInstance2;
        return objArr2;
    }

    public static Class b(Class[] clsArr, int i, boolean z) {
        if (z && i >= clsArr.length - 1) {
            return clsArr[clsArr.length - 1].getComponentType();
        }
        return clsArr[i];
    }
}
