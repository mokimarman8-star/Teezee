package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.b;
import retrofit2.e;
import retrofit2.k;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public final class k0 {
    private final ConcurrentHashMap a = new ConcurrentHashMap();
    final Call.Factory b;
    final HttpUrl c;
    final List d;
    final int e;
    final List f;
    final int g;
    final Executor h;
    final boolean i;

    class a implements InvocationHandler {
        private final Object[] a = new Object[0];
        final /* synthetic */ Class b;

        a(Class cls) {
            this.b = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (objArr == null) {
                objArr = this.a;
            }
            d0 d0Var = b0.b;
            return d0Var.c(method) ? d0Var.b(method, this.b, obj, objArr) : k0.this.c(this.b, method).a(obj, objArr);
        }
    }

    public static final class b {
        private Call.Factory a;
        private HttpUrl b;
        private final List c = new ArrayList();
        private final List d = new ArrayList();
        private Executor e;
        private boolean f;

        public b a(e.a aVar) {
            List list = this.d;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b b(k.a aVar) {
            List list = this.c;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b c(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return d(HttpUrl.get(str));
        }

        public b d(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "baseUrl == null");
            if ("".equals(httpUrl.pathSegments().get(r0.size() - 1))) {
                this.b = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        public k0 e() {
            if (this.b == null) {
                throw new IllegalStateException("Base URL required.");
            }
            Call.Factory factory = this.a;
            if (factory == null) {
                factory = new OkHttpClient();
            }
            Call.Factory factory2 = factory;
            Executor executor = this.e;
            if (executor == null) {
                executor = b0.a;
            }
            Executor executor2 = executor;
            c cVar = b0.c;
            ArrayList arrayList = new ArrayList(this.d);
            List a = cVar.a(executor2);
            arrayList.addAll(a);
            List b = cVar.b();
            int size = b.size();
            ArrayList arrayList2 = new ArrayList(this.c.size() + 1 + size);
            arrayList2.add(new retrofit2.b());
            arrayList2.addAll(this.c);
            arrayList2.addAll(b);
            return new k0(factory2, this.b, Collections.unmodifiableList(arrayList2), size, Collections.unmodifiableList(arrayList), a.size(), executor2, this.f);
        }

        public b f(Call.Factory factory) {
            Objects.requireNonNull(factory, "factory == null");
            this.a = factory;
            return this;
        }

        public b g(OkHttpClient okHttpClient) {
            Objects.requireNonNull(okHttpClient, "client == null");
            return f(okHttpClient);
        }
    }

    k0(Call.Factory factory, HttpUrl httpUrl, List list, int i, List list2, int i2, Executor executor, boolean z) {
        this.b = factory;
        this.c = httpUrl;
        this.d = list;
        this.e = i;
        this.f = list2;
        this.g = i2;
        this.h = executor;
        this.i = z;
    }

    private void j(Class cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                sb.append(cls2.getName());
                if (cls2 != cls) {
                    sb.append(" which is an interface of ");
                    sb.append(cls.getName());
                }
                throw new IllegalArgumentException(sb.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.i) {
            d0 d0Var = b0.b;
            for (Method method : cls.getDeclaredMethods()) {
                if (!d0Var.c(method) && !Modifier.isStatic(method.getModifiers()) && !method.isSynthetic()) {
                    c(cls, method);
                }
            }
        }
    }

    public e a(Type type, Annotation[] annotationArr) {
        return d(null, type, annotationArr);
    }

    public Object b(Class cls) {
        j(cls);
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    l0 c(Class cls, Method method) {
        l0 l0Var;
        Object obj = this.a.get(method);
        if (obj instanceof l0) {
            return (l0) obj;
        }
        if (obj == null) {
            Object obj2 = new Object();
            synchronized (obj2) {
                try {
                    obj = this.a.putIfAbsent(method, obj2);
                    if (obj == null) {
                        l0 b2 = l0.b(this, cls, method);
                        this.a.put(method, b2);
                        return b2;
                    }
                } finally {
                }
            }
        }
        synchronized (obj) {
            l0Var = (l0) this.a.get(method);
        }
        return l0Var;
    }

    public e d(e.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.f.indexOf(aVar) + 1;
        int size = this.f.size();
        for (int i = indexOf; i < size; i++) {
            e a2 = ((e.a) this.f.get(i)).a(type, annotationArr, this);
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(((e.a) this.f.get(i2)).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(((e.a) this.f.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public k e(k.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int indexOf = this.d.indexOf(aVar) + 1;
        int size = this.d.size();
        for (int i = indexOf; i < size; i++) {
            k c = ((k.a) this.d.get(i)).c(type, annotationArr, annotationArr2, this);
            if (c != null) {
                return c;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(((k.a) this.d.get(i2)).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(((k.a) this.d.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public k f(k.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.d.indexOf(aVar) + 1;
        int size = this.d.size();
        for (int i = indexOf; i < size; i++) {
            k d = ((k.a) this.d.get(i)).d(type, annotationArr, this);
            if (d != null) {
                return d;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(((k.a) this.d.get(i2)).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(((k.a) this.d.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public k g(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return e(null, type, annotationArr, annotationArr2);
    }

    public k h(Type type, Annotation[] annotationArr) {
        return f(null, type, annotationArr);
    }

    public k i(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            k e = ((k.a) this.d.get(i)).e(type, annotationArr, this);
            if (e != null) {
                return e;
            }
        }
        return b.d.a;
    }
}
