package gj;

import java.util.HashMap;
import java.util.ServiceLoader;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final C0070a a = new C0070a(null);
    private static final HashMap b = new HashMap();

    /* renamed from: gj.a$a, reason: collision with other inner class name */
    public static final class C0070a {
        private C0070a() {
        }

        public /* synthetic */ C0070a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Object a(Class cls) {
            Intrinsics.h(cls, "clazz");
            if (a.b.containsKey(cls.getName())) {
                Object obj = a.b.get(cls.getName());
                Intrinsics.f(obj, "null cannot be cast to non-null type T of com.transsion.baselib.service.BusinessServiceManager.Companion.getService");
                return obj;
            }
            ServiceLoader load = ServiceLoader.load(cls);
            if (load.iterator().hasNext()) {
                Object next = load.iterator().next();
                a.b.put(cls.getName(), next);
                return next;
            }
            a.a.m(wf.a.a, "Service " + cls + " has not implemented", false, 2, (Object) null);
            return null;
        }
    }
}
