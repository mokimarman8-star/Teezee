package com.mbridge.msdk.dycreator.bus;

import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class SubscriberMethod {
    final Method a;
    final ThreadMode b;
    final Class<?> c;
    String d;

    SubscriberMethod(Method method, ThreadMode threadMode, Class<?> cls) {
        this.a = method;
        this.b = threadMode;
        this.c = cls;
    }

    private synchronized void a() {
        if (this.d == null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append(this.a.getDeclaringClass().getName());
            sb2.append('#');
            sb2.append(this.a.getName());
            sb2.append('(');
            sb2.append(this.c.getName());
            this.d = sb2.toString();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        a();
        return this.d.equals(((SubscriberMethod) obj).d);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
