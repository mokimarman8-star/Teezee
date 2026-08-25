package org.mvel2;

import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.mvel2.ast.TypeDescriptor;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.ImmutableDefaultFactory;
import org.mvel2.util.m;
import org.mvel2.util.n;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class g {
    private static final Object[] o = new Object[0];
    private static final Map p = Collections.synchronizedMap(new WeakHashMap(10));
    private static final Map q = Collections.synchronizedMap(new WeakHashMap(10));
    private static final Map r = Collections.synchronizedMap(new WeakHashMap(10));
    private static final Map s = Collections.synchronizedMap(new WeakHashMap(10));
    private int a;
    private int b;
    private int c;
    private char[] d;
    private int e;
    private int f;
    private Object g;
    private Object h;
    private Object i;
    private Class j;
    private boolean k;
    private boolean l;
    private VariableResolverFactory m;
    private ParserContext n;

    public g(String str, Object obj) {
        this.a = 0;
        this.b = 0;
        this.j = null;
        this.k = true;
        this.l = false;
        char[] charArray = str.toCharArray();
        this.d = charArray;
        int length = charArray.length;
        this.f = length;
        this.e = length;
        this.h = obj;
        this.m = new ImmutableDefaultFactory();
    }

    public g(char[] cArr, int i, int i2, Object obj, VariableResolverFactory variableResolverFactory, Object obj2, ParserContext parserContext) {
        this.j = null;
        this.k = true;
        this.l = false;
        this.d = cArr;
        this.a = i;
        this.c = i;
        this.b = i;
        this.e = i2;
        this.f = i + i2;
        this.h = obj;
        this.m = variableResolverFactory;
        this.g = obj2;
        this.n = parserContext;
    }

    public g(char[] cArr, Object obj, VariableResolverFactory variableResolverFactory, Object obj2, ParserContext parserContext) {
        this.a = 0;
        this.b = 0;
        this.j = null;
        this.k = true;
        this.l = false;
        this.d = cArr;
        int length = cArr.length;
        this.f = length;
        this.e = length;
        this.h = obj;
        this.m = variableResolverFactory;
        this.g = obj2;
        this.n = parserContext;
    }

    public static void A(Object obj, VariableResolverFactory variableResolverFactory, String str, Object obj2, ParserContext parserContext) {
        new g(str.toCharArray(), obj, variableResolverFactory, null, parserContext).y(obj2);
    }

    private void D() {
        if (this.b < this.f) {
            while (m.q0(this.d[this.b])) {
                int i = this.b + 1;
                this.b = i;
                if (i >= this.f) {
                    return;
                }
            }
        }
    }

    private static void a(Class cls, Integer num, Method method) {
        Map map = r;
        synchronized (map) {
            try {
                WeakHashMap weakHashMap = (WeakHashMap) map.get(cls);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap();
                    map.put(cls, weakHashMap);
                }
                weakHashMap.put(num, new WeakReference(new Object[]{method, method.getParameterTypes()}));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void b(Class cls, Integer num, Member member) {
        Map map = p;
        synchronized (map) {
            try {
                WeakHashMap weakHashMap = (WeakHashMap) map.get(cls);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap();
                    map.put(cls, weakHashMap);
                }
                weakHashMap.put(num, new WeakReference(member));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void c(Class cls, Integer num, Member member) {
        Map map = q;
        synchronized (map) {
            try {
                WeakHashMap weakHashMap = (WeakHashMap) map.get(cls);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap();
                    map.put(cls, weakHashMap);
                }
                weakHashMap.put(num, new WeakReference(member));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private String d() {
        return new String(this.d, this.c, B(this.b) - this.c);
    }

    private static Object[] e(Class cls, Integer num) {
        WeakReference weakReference;
        Map map = (Map) r.get(cls);
        if (map == null || (weakReference = (WeakReference) map.get(num)) == null) {
            return null;
        }
        return (Object[]) weakReference.get();
    }

    public static Class[] f(Method method) {
        Class[] clsArr;
        Map map = s;
        WeakReference weakReference = (WeakReference) map.get(method);
        if (weakReference != null && (clsArr = (Class[]) weakReference.get()) != null) {
            return clsArr;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        map.put(method, new WeakReference(parameterTypes));
        return parameterTypes;
    }

    private static Member g(Class cls, Integer num) {
        WeakReference weakReference;
        WeakHashMap weakHashMap = (WeakHashMap) p.get(cls);
        if (weakHashMap == null || (weakReference = (WeakReference) weakHashMap.get(num)) == null) {
            return null;
        }
        return (Member) weakReference.get();
    }

    private static Member h(Class cls, Integer num) {
        WeakReference weakReference;
        Map map = (Map) q.get(cls);
        if (map == null || (weakReference = (WeakReference) map.get(num)) == null) {
            return null;
        }
        return (Member) weakReference.get();
    }

    private static int i(String str, String str2) {
        return str.hashCode() + str2.hashCode();
    }

    private Object j() {
        this.i = this.h;
        try {
            return !d.h ? u() : n();
        } catch (IllegalAccessException e) {
            throw new PropertyAccessException("could not access property", this.d, this.b, e, this.n);
        } catch (IndexOutOfBoundsException e3) {
            int i = this.b;
            int i2 = this.e;
            if (i >= i2) {
                this.b = i2 - 1;
            }
            throw new PropertyAccessException("array or collections index out of bounds in property: " + new String(this.d, this.b, this.e), this.d, this.b, e3, this.n);
        } catch (NullPointerException e4) {
            throw new PropertyAccessException("null pointer exception in property: " + new String(this.d), this.d, this.b, e4, this.n);
        } catch (InvocationTargetException e5) {
            throw new PropertyAccessException("could not access property", this.d, this.b, e5, this.n);
        } catch (CompileException e6) {
            throw org.mvel2.util.f.a(e6, this.d, this.c);
        } catch (Exception e7) {
            throw new PropertyAccessException("unknown exception in expression: " + new String(this.d), this.d, this.b, e7, this.n);
        }
    }

    public static Object k(String str, Object obj) {
        return new g(str, obj).j();
    }

    public static Object l(String str, Object obj, VariableResolverFactory variableResolverFactory, Object obj2, ParserContext parserContext) {
        return new g(str.toCharArray(), obj, variableResolverFactory, obj2, parserContext).j();
    }

    public static Object m(char[] cArr, int i, int i2, Object obj, VariableResolverFactory variableResolverFactory, Object obj2, ParserContext parserContext) {
        return new g(cArr, i, i2, obj, variableResolverFactory, obj2, parserContext).j();
    }

    private Object n() {
        while (this.b < this.f) {
            int w = w();
            if (w == 0) {
                Object p2 = p(this.i, d());
                this.i = p2;
                if (p2 == null && yz.d.e()) {
                    yz.d.b();
                    d();
                    throw null;
                }
            } else if (w == 1) {
                Object t = t(this.i, d());
                this.i = t;
                if (t == null && yz.d.d()) {
                    yz.d.a();
                    d();
                    throw null;
                }
            } else if (w == 2) {
                this.i = s(this.i, d());
            } else if (w == 3) {
                this.i = v(this.i);
            }
            if (this.l) {
                if (this.i == null) {
                    return null;
                }
                this.l = false;
            } else if (this.i == null && this.b < this.f) {
                throw null;
            }
            this.k = false;
        }
        return this.i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x0211, code lost:
    
        return t(r8, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object o(java.lang.Object r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.g.o(java.lang.Object, java.lang.String):java.lang.Object");
    }

    private Object p(Object obj, String str) {
        if (obj == null || !yz.d.f(obj.getClass())) {
            yz.a.c(obj, str, this.m);
            return o(obj, str);
        }
        yz.d.c(obj.getClass());
        throw null;
    }

    private ClassLoader q() {
        ParserContext parserContext = this.n;
        return parserContext != null ? parserContext.getClassLoader() : Thread.currentThread().getContextClassLoader();
    }

    private Object r(Object obj, String str) {
        if (str.length() != 0 && (obj = o(obj, str)) == null) {
            throw new NullPointerException("null pointer on indexed access for: " + str);
        }
        this.j = null;
        int i = this.b + 1;
        this.b = i;
        D();
        if (this.b == this.f || x(']')) {
            throw new PropertyAccessException("unterminated '['", this.d, this.b, this.n);
        }
        char[] cArr = this.d;
        int i2 = this.b;
        this.b = i2 + 1;
        String str2 = new String(cArr, i, i2 - i);
        if (obj instanceof Map) {
            return ((Map) obj).get(d.l(str2, obj, this.m));
        }
        if (obj instanceof List) {
            return ((List) obj).get(((Integer) d.l(str2, obj, this.m)).intValue());
        }
        if (!(obj instanceof Collection)) {
            if (obj.getClass().isArray()) {
                return Array.get(obj, ((Integer) d.l(str2, obj, this.m)).intValue());
            }
            if (obj instanceof CharSequence) {
                return Character.valueOf(((CharSequence) obj).charAt(((Integer) d.l(str2, obj, this.m)).intValue()));
            }
            try {
                return TypeDescriptor.getClassReference(this.n, (Class) obj, new TypeDescriptor(this.d, this.a, this.e, 0));
            } catch (Exception e) {
                throw new PropertyAccessException("illegal use of []: unknown type: " + obj.getClass().getName(), this.d, this.c, e, this.n);
            }
        }
        int intValue = ((Integer) d.l(str2, obj, this.m)).intValue();
        Collection collection = (Collection) obj;
        if (intValue <= collection.size()) {
            Iterator it = collection.iterator();
            for (int i3 = 0; i3 < intValue; i3++) {
                it.next();
            }
            return it.next();
        }
        throw new PropertyAccessException("index [" + intValue + "] out of bounds on collections", this.d, this.b, this.n);
    }

    private Object s(Object obj, String str) {
        if (str.length() != 0) {
            obj = o(obj, str);
        }
        this.j = null;
        if (obj == null) {
            return null;
        }
        int i = this.b + 1;
        this.b = i;
        D();
        if (this.b == this.f || x(']')) {
            throw new PropertyAccessException("unterminated '['", this.d, this.b, this.n);
        }
        char[] cArr = this.d;
        int i2 = this.b;
        this.b = i2 + 1;
        String str2 = new String(cArr, i, i2 - i);
        if (obj instanceof Map) {
            if (!yz.d.f(Map.class)) {
                return ((Map) obj).get(d.l(str2, obj, this.m));
            }
            yz.d.c(Map.class);
            throw null;
        }
        if (obj instanceof List) {
            if (!yz.d.f(List.class)) {
                return ((List) obj).get(((Integer) d.l(str2, obj, this.m)).intValue());
            }
            yz.d.c(List.class);
            throw null;
        }
        if (obj instanceof Collection) {
            if (yz.d.f(Collection.class)) {
                yz.d.c(Collection.class);
                throw null;
            }
            int intValue = ((Integer) d.l(str2, obj, this.m)).intValue();
            Collection collection = (Collection) obj;
            if (intValue <= collection.size()) {
                Iterator it = collection.iterator();
                for (int i3 = 0; i3 < intValue; i3++) {
                    it.next();
                }
                return it.next();
            }
            throw new PropertyAccessException("index [" + intValue + "] out of bounds on collections", this.d, this.b, this.n);
        }
        if (obj.getClass().isArray()) {
            if (!yz.d.f(Array.class)) {
                return Array.get(obj, ((Integer) d.l(str2, obj, this.m)).intValue());
            }
            yz.d.c(Array.class);
            throw null;
        }
        if (obj instanceof CharSequence) {
            if (!yz.d.f(CharSequence.class)) {
                return Character.valueOf(((CharSequence) obj).charAt(((Integer) d.l(str2, obj, this.m)).intValue()));
            }
            yz.d.c(CharSequence.class);
            throw null;
        }
        try {
            char[] cArr2 = this.d;
            int i4 = this.a;
            return TypeDescriptor.getClassReference(this.n, (Class) obj, new TypeDescriptor(cArr2, i4, this.f - i4, 0));
        } catch (Exception unused) {
            throw new PropertyAccessException("illegal use of []: unknown type: " + obj.getClass().getName(), this.d, this.c, this.n);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object t(java.lang.Object r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 711
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.g.t(java.lang.Object, java.lang.String):java.lang.Object");
    }

    private Object u() {
        while (this.b < this.f) {
            int w = w();
            if (w == 0) {
                this.i = o(this.i, d());
            } else if (w == 1) {
                this.i = t(this.i, d());
            } else if (w == 2) {
                this.i = r(this.i, d());
            } else if (w == 3) {
                this.i = v(this.i);
            }
            if (this.l) {
                if (this.i == null) {
                    return null;
                }
                this.l = false;
            }
            this.k = false;
        }
        return this.i;
    }

    private Object v(Object obj) {
        int i = this.a;
        String trim = i == this.b ? null : new String(this.d, i, (r1 - i) - 1).trim();
        char[] cArr = this.d;
        int i2 = this.b;
        int i3 = i2 + 1;
        int e = m.e(cArr, i2, this.f, '{', this.n);
        this.b = e;
        m.z0(trim, cArr, i3, e - i3, obj, this.m);
        this.b++;
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab A[LOOP:2: B:32:0x00ab->B:34:0x00b7, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a4 A[EDGE_INSN: B:44:0x00a4->B:30:0x00a4 BREAK  A[LOOP:1: B:25:0x0090->B:43:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int w() {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.g.w():int");
    }

    private boolean x(char c) {
        while (true) {
            int i = this.b;
            int i2 = this.f;
            if (i >= i2) {
                return true;
            }
            char[] cArr = this.d;
            char c2 = cArr[i];
            if (c2 == '\"' || c2 == '\'') {
                this.b = m.h(c2, cArr, i, i2);
            }
            char[] cArr2 = this.d;
            int i3 = this.b;
            if (cArr2[i3] == c) {
                return false;
            }
            this.b = i3 + 1;
        }
    }

    private void y(Object obj) {
        this.i = this.h;
        try {
            int i = this.f;
            this.f = m.C(this.d);
            Object j = j();
            this.i = j;
            if (j == null) {
                throw new PropertyAccessException("cannot bind to null context: " + new String(this.d, this.b, this.e), this.d, this.b, this.n);
            }
            this.f = i;
            if (w() == 2) {
                int i2 = this.b + 1;
                this.b = i2;
                D();
                if (this.b == this.e || x(']')) {
                    throw new PropertyAccessException("unterminated '['", this.d, this.b, this.n);
                }
                String str = new String(this.d, i2, this.b - i2);
                if (!d.h) {
                    Object obj2 = this.i;
                    if (obj2 instanceof Map) {
                        ((Map) obj2).put(d.l(str, this.h, this.m), obj);
                        return;
                    }
                    if (obj2 instanceof List) {
                        ((List) obj2).set(((Integer) d.m(str, this.h, this.m, Integer.class)).intValue(), obj);
                        return;
                    }
                    if (yz.d.f(obj2.getClass())) {
                        yz.d.c(this.i.getClass());
                        throw null;
                    }
                    if (this.i.getClass().isArray()) {
                        Array.set(this.i, ((Integer) d.m(str, this.h, this.m, Integer.class)).intValue(), b.b(obj, m.I(this.i.getClass())));
                        return;
                    }
                    throw new PropertyAccessException("cannot bind to collection property: " + new String(this.d) + ": not a recognized collection type: " + this.h.getClass(), this.d, this.b, this.n);
                }
                yz.a.d(this.h, str, this.m, obj);
                Object obj3 = this.i;
                if (obj3 instanceof Map) {
                    if (yz.d.f(Map.class)) {
                        yz.d.c(Map.class);
                        throw null;
                    }
                    ((Map) this.i).put(d.l(str, this.h, this.m), obj);
                    return;
                }
                if (obj3 instanceof List) {
                    if (yz.d.f(List.class)) {
                        yz.d.c(List.class);
                        throw null;
                    }
                    ((List) this.i).set(((Integer) d.m(str, this.h, this.m, Integer.class)).intValue(), obj);
                    return;
                }
                if (obj3.getClass().isArray()) {
                    if (yz.d.f(Array.class)) {
                        yz.d.c(Array.class);
                        throw null;
                    }
                    Array.set(this.i, ((Integer) d.m(str, this.h, this.m, Integer.class)).intValue(), b.b(obj, m.I(this.i.getClass())));
                    return;
                }
                if (yz.d.f(this.i.getClass())) {
                    yz.d.c(this.i.getClass());
                    throw null;
                }
                throw new PropertyAccessException("cannot bind to collection property: " + new String(this.d) + ": not a recognized collection type: " + this.h.getClass(), this.d, this.b, this.n);
            }
            if (d.h && yz.d.f(this.i.getClass())) {
                yz.d.c(this.i.getClass());
                d();
                throw null;
            }
            String d = d();
            Member h = h(this.i.getClass(), Integer.valueOf(d == null ? 0 : d.hashCode()));
            if (h == null) {
                Class<?> cls = this.i.getClass();
                Integer valueOf = Integer.valueOf(d != null ? d.hashCode() : -1);
                Member d2 = obj != null ? n.d(this.i.getClass(), d, obj.getClass()) : n.c(this.i.getClass(), d);
                c(cls, valueOf, d2);
                h = d2;
            }
            if (h instanceof Method) {
                Method method = (Method) h;
                Class[] f = f(method);
                if (obj == null || f[0].isAssignableFrom(obj.getClass())) {
                    method.invoke(this.i, obj);
                    return;
                }
                if (b.a(f[0], obj.getClass())) {
                    method.invoke(this.i, b.b(obj, f[0]));
                    return;
                }
                throw new CompileException("cannot convert type: " + obj.getClass() + ": to " + method.getParameterTypes()[0], this.d, this.b);
            }
            if (h != null) {
                Field field = (Field) h;
                if (obj == null || field.getType().isAssignableFrom(obj.getClass())) {
                    field.set(this.i, obj);
                    return;
                }
                if (b.a(field.getType(), obj.getClass())) {
                    field.set(this.i, b.b(obj, field.getType()));
                    return;
                }
                throw new CompileException("cannot convert type: " + obj.getClass() + ": to " + field.getType(), this.d, this.b);
            }
            Object obj4 = this.i;
            if (obj4 instanceof Map) {
                ((Map) obj4).put(d.l(d, this.h, this.m), obj);
                return;
            }
            if (obj4 instanceof org.mvel2.ast.b) {
                ((org.mvel2.ast.d) obj4).c().getVariableResolver(d).setValue(obj);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("could not access/write property (");
            sb.append(d);
            sb.append(") in: ");
            Object obj5 = this.i;
            sb.append(obj5 == null ? "Unknown" : obj5.getClass().getName());
            throw new PropertyAccessException(sb.toString(), this.d, this.b, this.n);
        } catch (IllegalAccessException e) {
            throw new PropertyAccessException("could not access property", this.d, this.c, e, this.n);
        } catch (InvocationTargetException e3) {
            throw new PropertyAccessException("could not access property", this.d, this.c, e3, this.n);
        }
    }

    public static void z(Object obj, String str, Object obj2) {
        new g(str, obj).y(obj2);
    }

    protected int B(int i) {
        while (i > 0 && m.q0(this.d[i - 1])) {
            i--;
        }
        return i;
    }

    protected Object C() {
        int i;
        int i2 = this.b;
        try {
            int i3 = this.f;
            int i4 = i3 - 1;
            boolean z = false;
            while (true) {
                int i6 = this.a;
                if (i4 > i6) {
                    char[] cArr = this.d;
                    char c = cArr[i4];
                    if (c == '\"') {
                        while (true) {
                            i = i4 - 1;
                            if (i > 0) {
                                char[] cArr2 = this.d;
                                if (cArr2[i] != '\"' || cArr2[i4 - 2] == '\\') {
                                    i4 = i;
                                }
                            }
                        }
                    } else if (c != '\'') {
                        int i7 = 1;
                        if (c == ')') {
                            int i8 = i4 - 1;
                            int i9 = 1;
                            while (i8 > 0 && i9 != 0) {
                                char c2 = this.d[i8];
                                if (c2 != '\"') {
                                    switch (c2) {
                                        case '(':
                                            i9--;
                                            break;
                                        case ')':
                                            i9++;
                                            break;
                                    }
                                    i8--;
                                }
                                while (i8 > 0) {
                                    char[] cArr3 = this.d;
                                    if (cArr3[i8] != c2 && cArr3[i8 - 1] != '\\') {
                                        i8--;
                                    }
                                    i8--;
                                }
                                i8--;
                            }
                            z = true;
                            int i10 = i8;
                            i4 = i8 + 1;
                            i3 = i10;
                        } else if (c == '.') {
                            if (!z) {
                                try {
                                    this.b = i3;
                                    String str = new String(cArr, i6, i3 - i6);
                                    if (d.j && str.endsWith(".class")) {
                                        str = str.substring(0, str.length() - 6);
                                    }
                                    return q().loadClass(str);
                                } catch (ClassNotFoundException unused) {
                                    ClassLoader q2 = q();
                                    char[] cArr4 = this.d;
                                    int i11 = this.a;
                                    Class<?> loadClass = q2.loadClass(new String(cArr4, i11, i4 - i11));
                                    String str2 = new String(this.d, i4 + 1, (this.f - i4) - 1);
                                    try {
                                        return loadClass.getField(str2);
                                    } catch (NoSuchFieldException unused2) {
                                        for (Method method : loadClass.getMethods()) {
                                            if (str2.equals(method.getName())) {
                                                return method;
                                            }
                                        }
                                        return null;
                                    }
                                }
                            }
                            i3 = i4;
                            z = false;
                        } else if (c == '}') {
                            while (true) {
                                i4--;
                                if (i4 > 0 && i7 != 0) {
                                    char c3 = this.d[i4];
                                    if (c3 == '\"' || c3 == '\'') {
                                        while (i4 > 0) {
                                            char[] cArr5 = this.d;
                                            if (cArr5[i4] != c3 && cArr5[i4 - 1] != '\\') {
                                                i4--;
                                            }
                                        }
                                    } else if (c3 == '{') {
                                        i7--;
                                    } else if (c3 == '}') {
                                        i7++;
                                    }
                                }
                            }
                        }
                        i4--;
                    } else {
                        while (true) {
                            i = i4 - 1;
                            if (i > 0) {
                                char[] cArr6 = this.d;
                                if (cArr6[i] != '\'' || cArr6[i4 - 2] == '\\') {
                                    i4 = i;
                                }
                            }
                        }
                    }
                    i4 = i;
                    i4--;
                }
            }
        } catch (Exception unused3) {
            this.b = i2;
        }
        return null;
    }
}
