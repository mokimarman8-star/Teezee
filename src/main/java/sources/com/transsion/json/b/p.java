package com.transsion.json.b;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class p extends ConcurrentHashMap<Class, n> {
    private p a;
    protected boolean b;

    class a {
        private boolean a;

        a() {
        }

        public void a(boolean z) {
            this.a = z;
        }

        public boolean b() {
            return this.a;
        }
    }

    public p() {
    }

    public p(p pVar) {
        this.a = pVar;
    }

    private n a(Class cls, Class cls2, a aVar) {
        if (cls == null) {
            return null;
        }
        if (containsKey(cls)) {
            if (cls != cls2) {
                aVar.a(false);
            }
            return get(cls);
        }
        if (cls.isArray()) {
            aVar.a(false);
            return get(Arrays.class);
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            n a2 = a(cls3, cls2, aVar);
            if (a2 != null) {
                return a2;
            }
        }
        return a(cls.getSuperclass(), cls2, aVar);
    }

    public n a(Class cls, n nVar) {
        if (!this.b) {
            put(cls, nVar);
        }
        return nVar;
    }

    public n a(Object obj) {
        p pVar;
        a aVar = new a();
        Class<?> cls = obj == null ? Void.TYPE : obj.getClass();
        n a2 = a(cls, cls, aVar);
        if (a2 == null && (pVar = this.a) != null && (a2 = pVar.a(obj)) != null) {
            a(obj == null ? Void.TYPE : obj.getClass(), a2);
        }
        if (!aVar.b()) {
            a(cls, a2);
        }
        return a2;
    }
}
