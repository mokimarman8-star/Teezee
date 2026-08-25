package com.cloud.tmc.kernel.proxy;

import android.content.Context;
import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class TmcProxy {
    private static final String TAG = "TmcProxy";
    public static WeakReference<Context> sApplicationContext;
    private static final Map<Class<?>, Object> sProxyMap = new ConcurrentHashMap();

    public interface LazyGetter<T> {
        T get();
    }

    public static <T> T get(final Class<T> cls) {
        boolean z;
        if (!cls.isInterface()) {
            StringBuilder sb = new StringBuilder();
            sb.append("got proxy clazz must a Interface:");
            sb.append(cls.getSimpleName());
        }
        Map<Class<?>, Object> map = sProxyMap;
        T t = (T) map.get(cls);
        if (t != null && !(t instanceof LazyGetter)) {
            return t;
        }
        synchronized (map) {
            try {
                LazyGetter lazyGetter = (T) map.get(cls);
                if (lazyGetter != null) {
                    if (lazyGetter instanceof LazyGetter) {
                        lazyGetter = (T) lazyGetter.get();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Lazy initialize of ");
                        sb2.append(cls);
                        sb2.append(" to ");
                        sb2.append(lazyGetter);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (lazyGetter != null) {
                        if (z) {
                            map.put(cls, lazyGetter);
                        }
                        return (T) lazyGetter;
                    }
                }
                DefaultImpl defaultImpl = (DefaultImpl) cls.getAnnotation(DefaultImpl.class);
                if (defaultImpl != null) {
                    try {
                        Class<?> cls2 = Class.forName(defaultImpl.value());
                        if (cls.isAssignableFrom(cls2)) {
                            T t2 = (T) cls2.newInstance();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Default initialize of ");
                            sb3.append(cls);
                            sb3.append(" to ");
                            sb3.append(t2);
                            set(cls, t2);
                            return t2;
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Default impl ");
                        sb4.append(defaultImpl.value());
                        sb4.append(" is not instance of ");
                        sb4.append(cls);
                    } catch (Throwable th) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("DefaultImpl instantiate exception!");
                        sb5.append(th.getMessage());
                    }
                }
                T t3 = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.cloud.tmc.kernel.proxy.TmcProxy.1
                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj, Method method, Object[] objArr) {
                        Class<?> returnType = method.getReturnType();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("unimplemented proxy:");
                        sb6.append(cls.getSimpleName());
                        sb6.append(TmcConstants.EXTENSION_SEPARATOR);
                        sb6.append(method.getName());
                        if (!returnType.isPrimitive()) {
                            return null;
                        }
                        Class<?> cls3 = Boolean.TYPE;
                        if (returnType == cls3 || returnType == cls3) {
                            return Boolean.FALSE;
                        }
                        return 0;
                    }
                });
                set(cls, t3);
                return t3;
            } finally {
            }
        }
    }

    public static <T> void set(Class<? super T> cls, T t) {
        setInternal(cls, t);
    }

    private static <T> void setInternal(Class<? extends T> cls, Object obj) {
        if (cls == null) {
            return;
        }
        Map<Class<?>, Object> map = sProxyMap;
        if (map.containsKey(cls)) {
            return;
        }
        if (obj == null) {
            map.remove(cls);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getSimpleName());
        sb.append(" >>> ");
        sb.append(obj.getClass());
        map.put(cls, obj);
    }

    public static <T> void setLazy(Class<T> cls, LazyGetter<T> lazyGetter) {
        setInternal(cls, lazyGetter);
    }
}
