package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class n3 {
    static Object a(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i);
    }

    static Object[] b(Object... objArr) {
        c(objArr, objArr.length);
        return objArr;
    }

    static Object[] c(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            a(objArr[i2], i2);
        }
        return objArr;
    }

    private static Object[] d(Iterable iterable, Object[] objArr) {
        Iterator it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    public static Object[] e(Object[] objArr, int i) {
        return r3.c(objArr, i);
    }

    static Object[] f(Collection collection) {
        return d(collection, new Object[collection.size()]);
    }

    static Object[] g(Collection collection, Object[] objArr) {
        int size = collection.size();
        if (objArr.length < size) {
            objArr = e(objArr, size);
        }
        d(collection, objArr);
        if (objArr.length > size) {
            objArr[size] = null;
        }
        return objArr;
    }

    static Object[] h(Object[] objArr, int i, int i2, Object[] objArr2) {
        com.google.common.base.m.t(i, i + i2, objArr.length);
        if (objArr2.length < i2) {
            objArr2 = e(objArr2, i2);
        } else if (objArr2.length > i2) {
            objArr2[i2] = null;
        }
        System.arraycopy(objArr, i, objArr2, 0, i2);
        return objArr2;
    }
}
