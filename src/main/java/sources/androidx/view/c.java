package androidx.view;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class c {

    /* renamed from: c, reason: collision with root package name */
    static c f8285c = new c();

    /* renamed from: a, reason: collision with root package name */
    private final Map f8286a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map f8287b = new HashMap();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        final Map f8288a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        final Map f8289b;

        a(Map map) {
            this.f8289b = map;
            for (Map.Entry entry : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) entry.getValue();
                List list = (List) this.f8288a.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.f8288a.put(event, list);
                }
                list.add((b) entry.getKey());
            }
        }

        private static void b(List list, u uVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((b) list.get(size)).a(uVar, event, obj);
                }
            }
        }

        void a(u uVar, Lifecycle.Event event, Object obj) {
            b((List) this.f8288a.get(event), uVar, event, obj);
            b((List) this.f8288a.get(Lifecycle.Event.ON_ANY), uVar, event, obj);
        }
    }

    static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f8290a;

        /* renamed from: b, reason: collision with root package name */
        final Method f8291b;

        b(int i5, Method method) {
            this.f8290a = i5;
            this.f8291b = method;
            method.setAccessible(true);
        }

        void a(u uVar, Lifecycle.Event event, Object obj) {
            try {
                int i5 = this.f8290a;
                if (i5 == 0) {
                    this.f8291b.invoke(obj, null);
                } else if (i5 == 1) {
                    this.f8291b.invoke(obj, uVar);
                } else {
                    if (i5 != 2) {
                        return;
                    }
                    this.f8291b.invoke(obj, uVar, event);
                }
            } catch (IllegalAccessException e5) {
                throw new RuntimeException(e5);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException("Failed to call observer method", e6.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f8290a == bVar.f8290a && this.f8291b.getName().equals(bVar.f8291b.getName());
        }

        public int hashCode() {
            return (this.f8290a * 31) + this.f8291b.getName().hashCode();
        }
    }

    c() {
    }

    private a a(Class cls, Method[] methodArr) {
        int i5;
        a c5;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c5 = c(superclass)) != null) {
            hashMap.putAll(c5.f8289b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f8289b.entrySet()) {
                e(hashMap, (b) entry.getKey(), (Lifecycle.Event) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z5 = false;
        for (Method method : methodArr) {
            d0 d0Var = (d0) method.getAnnotation(d0.class);
            if (d0Var != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i5 = 0;
                } else {
                    if (!u.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i5 = 1;
                }
                Lifecycle.Event value = d0Var.value();
                if (parameterTypes.length > 1) {
                    if (!Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i5 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(hashMap, new b(i5, method), value, cls);
                z5 = true;
            }
        }
        a aVar = new a(hashMap);
        this.f8286a.put(cls, aVar);
        this.f8287b.put(cls, Boolean.valueOf(z5));
        return aVar;
    }

    private Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e5) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e5);
        }
    }

    private void e(Map map, b bVar, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = (Lifecycle.Event) map.get(bVar);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(bVar, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f8291b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }

    a c(Class cls) {
        a aVar = (a) this.f8286a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    boolean d(Class cls) {
        Boolean bool = (Boolean) this.f8287b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b5 = b(cls);
        for (Method method : b5) {
            if (((d0) method.getAnnotation(d0.class)) != null) {
                a(cls, b5);
                return true;
            }
        }
        this.f8287b.put(cls, Boolean.FALSE);
        return false;
    }
}
