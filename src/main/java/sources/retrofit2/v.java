package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public final class v {
    private final Class a;
    private final Object b;
    private final Method c;
    private final List d;

    v(Class cls, Object obj, Method method, List list) {
        this.a = cls;
        this.b = obj;
        this.c = method;
        this.d = Collections.unmodifiableList(list);
    }

    public Method a() {
        return this.c;
    }

    public Class b() {
        return this.a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.a.getName(), this.c.getName(), this.d);
    }
}
