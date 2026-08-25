package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f13404d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f13405e = new Object();

    /* renamed from: c, reason: collision with root package name */
    final Context f13408c;

    /* renamed from: b, reason: collision with root package name */
    final Set f13407b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    final Map f13406a = new HashMap();

    a(Context context) {
        this.f13408c = context.getApplicationContext();
    }

    private Object d(Class cls, Set set) {
        Object obj;
        if (e4.a.d()) {
            try {
                e4.a.a(cls.getSimpleName());
            } catch (Throwable th) {
                e4.a.b();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f13406a.containsKey(cls)) {
            obj = this.f13406a.get(cls);
        } else {
            set.add(cls);
            try {
                d4.a aVar = (d4.a) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> a5 = aVar.a();
                if (!a5.isEmpty()) {
                    for (Class cls2 : a5) {
                        if (!this.f13406a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                obj = aVar.b(this.f13408c);
                set.remove(cls);
                this.f13406a.put(cls, obj);
            } catch (Throwable th2) {
                throw new StartupException(th2);
            }
        }
        e4.a.b();
        return obj;
    }

    public static a e(Context context) {
        if (f13404d == null) {
            synchronized (f13405e) {
                try {
                    if (f13404d == null) {
                        f13404d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f13404d;
    }

    void a() {
        try {
            try {
                e4.a.a("Startup");
                b(this.f13408c.getPackageManager().getProviderInfo(new ComponentName(this.f13408c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e5) {
                throw new StartupException(e5);
            }
        } finally {
            e4.a.b();
        }
    }

    void b(Bundle bundle) {
        String string = this.f13408c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (d4.a.class.isAssignableFrom(cls)) {
                            this.f13407b.add(cls);
                        }
                    }
                }
                Iterator it = this.f13407b.iterator();
                while (it.hasNext()) {
                    d((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e5) {
                throw new StartupException(e5);
            }
        }
    }

    Object c(Class cls) {
        Object obj;
        synchronized (f13405e) {
            try {
                obj = this.f13406a.get(cls);
                if (obj == null) {
                    obj = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.f13407b.contains(cls);
    }
}
