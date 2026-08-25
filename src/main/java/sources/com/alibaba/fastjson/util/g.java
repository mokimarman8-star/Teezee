package com.alibaba.fastjson.util;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class g {
    private final a[] a;
    private final int b;

    protected static final class a {
        public final int a;
        public final Object b;
        public Object c;
        public final a d;

        public a(Object obj, Object obj2, int i, a aVar) {
            this.b = obj;
            this.c = obj2;
            this.d = aVar;
            this.a = i;
        }
    }

    public g() {
        this(8192);
    }

    public g(int i) {
        this.b = i - 1;
        this.a = new a[i];
    }

    public Class a(String str) {
        int i = 0;
        while (true) {
            a[] aVarArr = this.a;
            if (i >= aVarArr.length) {
                return null;
            }
            a aVar = aVarArr[i];
            if (aVar != null) {
                for (a aVar2 = aVar; aVar2 != null; aVar2 = aVar2.d) {
                    Object obj = aVar.b;
                    if (obj instanceof Class) {
                        Class cls = (Class) obj;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
            }
            i++;
        }
    }

    public final Object b(Object obj) {
        for (a aVar = this.a[System.identityHashCode(obj) & this.b]; aVar != null; aVar = aVar.d) {
            if (obj == aVar.b) {
                return aVar.c;
            }
        }
        return null;
    }

    public boolean c(Object obj, Object obj2) {
        int identityHashCode = System.identityHashCode(obj);
        int i = this.b & identityHashCode;
        for (a aVar = this.a[i]; aVar != null; aVar = aVar.d) {
            if (obj == aVar.b) {
                aVar.c = obj2;
                return true;
            }
        }
        this.a[i] = new a(obj, obj2, identityHashCode, this.a[i]);
        return false;
    }
}
