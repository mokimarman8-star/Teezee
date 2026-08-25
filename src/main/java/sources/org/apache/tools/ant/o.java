package org.apache.tools.ant;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class o {
    static /* synthetic */ Class A;
    static /* synthetic */ Class B;
    private static final Map h = new Hashtable();
    private static final Map i = new HashMap(8);
    static /* synthetic */ Class j;
    static /* synthetic */ Class k;
    static /* synthetic */ Class l;
    static /* synthetic */ Class m;
    static /* synthetic */ Class n;
    static /* synthetic */ Class o;
    static /* synthetic */ Class p;
    static /* synthetic */ Class q;
    static /* synthetic */ Class r;
    static /* synthetic */ Class s;
    static /* synthetic */ Class t;
    static /* synthetic */ Class u;
    static /* synthetic */ Class v;
    static /* synthetic */ Class w;
    static /* synthetic */ Class x;
    static /* synthetic */ Class y;
    static /* synthetic */ Class z;
    private Hashtable a = new Hashtable();
    private Hashtable b = new Hashtable();
    private Hashtable c = new Hashtable();
    private Hashtable d = new Hashtable();
    private List e = new ArrayList();
    private Method f;
    private Class g;

    private static class a extends e {
        private Constructor b;
        private int c;

        a(Method method, Constructor constructor, int i) {
            super(method);
            this.b = constructor;
            this.c = i;
        }

        private void e(Object obj, Object obj2) {
            b().invoke(obj, obj2);
        }

        @Override // org.apache.tools.ant.o.e
        Object a(Project project, Object obj, Object obj2) {
            if (obj2 == null) {
                Constructor constructor = this.b;
                obj2 = constructor.newInstance(constructor.getParameterTypes().length == 0 ? new Object[0] : new Object[]{project});
            }
            if (this.c == 1) {
                e(obj, obj2);
            }
            return obj2;
        }

        @Override // org.apache.tools.ant.o.e
        boolean c() {
            return true;
        }

        @Override // org.apache.tools.ant.o.e
        void d(Object obj, Object obj2) {
            if (this.c == 2) {
                e(obj, obj2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class b {
        private Method a;

        protected b(Method method) {
            this.a = method;
        }

        abstract void a(Project project, Object obj, String str);
    }

    private static class c extends e {
        c(Method method) {
            super(method);
        }

        @Override // org.apache.tools.ant.o.e
        Object a(Project project, Object obj, Object obj2) {
            return b().invoke(obj, null);
        }
    }

    public static final class d {
        private e a;
        private Object b;
        private Project c;
        private Object d;
        private String e;

        private d(Project project, Object obj, e eVar) {
            this.c = project;
            this.b = obj;
            this.a = eVar;
        }

        /* synthetic */ d(Project project, Object obj, e eVar, g gVar) {
            this(project, obj, eVar);
        }

        public Object a() {
            if (this.e != null) {
                if (!this.a.c()) {
                    throw new BuildException("Not allowed to use the polymorphic form for this element");
                }
                Object d = ComponentHelper.j(this.c).d(this.e);
                this.d = d;
                if (d == null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unable to create object of type ");
                    stringBuffer.append(this.e);
                    throw new BuildException(stringBuffer.toString());
                }
            }
            try {
                Object a = this.a.a(this.c, this.b, this.d);
                this.d = a;
                Project project = this.c;
                if (project != null) {
                    project.K(a);
                }
                return this.d;
            } catch (IllegalAccessException e) {
                throw new BuildException(e);
            } catch (IllegalArgumentException e2) {
                if (this.e == null) {
                    throw e2;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Invalid type used ");
                stringBuffer2.append(this.e);
                throw new BuildException(stringBuffer2.toString());
            } catch (InstantiationException e3) {
                throw new BuildException(e3);
            } catch (InvocationTargetException e4) {
                throw o.g(e4);
            }
        }

        public void b(String str) {
            this.e = str;
        }

        public void c() {
            try {
                this.a.d(this.b, this.d);
            } catch (IllegalAccessException e) {
                throw new BuildException(e);
            } catch (IllegalArgumentException e2) {
                if (this.e == null) {
                    throw e2;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Invalid type used ");
                stringBuffer.append(this.e);
                throw new BuildException(stringBuffer.toString());
            } catch (InstantiationException e3) {
                throw new BuildException(e3);
            } catch (InvocationTargetException e4) {
                throw o.g(e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class e {
        private Method a;

        protected e(Method method) {
            this.a = method;
        }

        abstract Object a(Project project, Object obj, Object obj2);

        Method b() {
            return this.a;
        }

        boolean c() {
            return false;
        }

        void d(Object obj, Object obj2) {
        }
    }

    static {
        Class[] clsArr = {Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
        Class cls = j;
        if (cls == null) {
            cls = c("java.lang.Boolean");
            j = cls;
        }
        Class cls2 = k;
        if (cls2 == null) {
            cls2 = c("java.lang.Byte");
            k = cls2;
        }
        Class cls3 = l;
        if (cls3 == null) {
            cls3 = c("java.lang.Character");
            l = cls3;
        }
        Class cls4 = m;
        if (cls4 == null) {
            cls4 = c("java.lang.Short");
            m = cls4;
        }
        Class cls5 = n;
        if (cls5 == null) {
            cls5 = c("java.lang.Integer");
            n = cls5;
        }
        Class cls6 = o;
        if (cls6 == null) {
            cls6 = c("java.lang.Long");
            o = cls6;
        }
        Class cls7 = p;
        if (cls7 == null) {
            cls7 = c("java.lang.Float");
            p = cls7;
        }
        Class cls8 = q;
        if (cls8 == null) {
            cls8 = c("java.lang.Double");
            q = cls8;
        }
        Class[] clsArr2 = {cls, cls2, cls3, cls4, cls5, cls6, cls7, cls8};
        for (int i2 = 0; i2 < 8; i2++) {
            i.put(clsArr[i2], clsArr2[i2]);
        }
    }

    private o(Class cls) {
        Constructor<?> constructor;
        Constructor<?> constructor2;
        int i2 = 1;
        this.f = null;
        this.g = cls;
        Method[] methods = cls.getMethods();
        for (int i3 = 0; i3 < methods.length; i3 += i2) {
            Method method = methods[i3];
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == i2 && Void.TYPE.equals(returnType) && ("add".equals(name) || "addConfigured".equals(name))) {
                n(method);
            } else {
                Class cls2 = r;
                if (cls2 == null) {
                    cls2 = c("org.apache.tools.ant.ProjectComponent");
                    r = cls2;
                }
                if (!cls2.isAssignableFrom(cls) || parameterTypes.length != i2 || !q(name, parameterTypes[0])) {
                    if (o() && parameterTypes.length == i2 && "addTask".equals(name)) {
                        Class cls3 = s;
                        if (cls3 == null) {
                            cls3 = c("org.apache.tools.ant.Task");
                            s = cls3;
                        }
                        if (cls3.equals(parameterTypes[0])) {
                        }
                    }
                    if ("addText".equals(name) && Void.TYPE.equals(returnType) && parameterTypes.length == i2) {
                        Class cls4 = t;
                        if (cls4 == null) {
                            cls4 = c("java.lang.String");
                            t = cls4;
                        }
                        if (cls4.equals(parameterTypes[0])) {
                            this.f = methods[i3];
                        }
                    }
                    if (name.startsWith("set") && Void.TYPE.equals(returnType) && parameterTypes.length == i2 && !parameterTypes[0].isArray()) {
                        String m2 = m(name, "set");
                        if (this.b.get(m2) != null) {
                            Class cls5 = t;
                            if (cls5 == null) {
                                cls5 = c("java.lang.String");
                                t = cls5;
                            }
                            if (cls5.equals(parameterTypes[0])) {
                            }
                        }
                        b f = f(method, parameterTypes[0], m2);
                        if (f != null) {
                            this.a.put(m2, parameterTypes[0]);
                            this.b.put(m2, f);
                        }
                    } else if (!name.startsWith("create") || returnType.isArray() || returnType.isPrimitive() || parameterTypes.length != 0) {
                        if (name.startsWith("addConfigured") && Void.TYPE.equals(returnType) && parameterTypes.length == i2) {
                            Class cls6 = t;
                            if (cls6 == null) {
                                cls6 = c("java.lang.String");
                                t = cls6;
                            }
                            if (!cls6.equals(parameterTypes[0]) && !parameterTypes[0].isArray() && !parameterTypes[0].isPrimitive()) {
                                try {
                                    try {
                                        constructor2 = parameterTypes[0].getConstructor(null);
                                    } catch (NoSuchMethodException unused) {
                                        Class<?> cls7 = parameterTypes[0];
                                        Class<?> cls8 = u;
                                        if (cls8 == null) {
                                            cls8 = c("org.apache.tools.ant.Project");
                                            u = cls8;
                                        }
                                        constructor2 = cls7.getConstructor(cls8);
                                    }
                                    String m3 = m(name, "addConfigured");
                                    this.c.put(m3, parameterTypes[0]);
                                    this.d.put(m3, new a(method, constructor2, 2));
                                } catch (NoSuchMethodException unused2) {
                                }
                                i2 = 1;
                            }
                        }
                        if (name.startsWith("add") && Void.TYPE.equals(returnType)) {
                            if (parameterTypes.length == 1) {
                                Class cls9 = t;
                                if (cls9 == null) {
                                    cls9 = c("java.lang.String");
                                    t = cls9;
                                }
                                if (!cls9.equals(parameterTypes[0]) && !parameterTypes[0].isArray() && !parameterTypes[0].isPrimitive()) {
                                    try {
                                        constructor = parameterTypes[0].getConstructor(null);
                                    } catch (NoSuchMethodException unused3) {
                                        Class<?> cls10 = parameterTypes[0];
                                        Class<?> cls11 = u;
                                        if (cls11 == null) {
                                            cls11 = c("org.apache.tools.ant.Project");
                                            u = cls11;
                                        }
                                        constructor = cls10.getConstructor(cls11);
                                    }
                                    String m4 = m(name, "add");
                                    if (this.c.get(m4) == null) {
                                        this.c.put(m4, parameterTypes[0]);
                                        this.d.put(m4, new a(method, constructor, 1));
                                    }
                                }
                            } else {
                                i2 = 1;
                            }
                        }
                        i2 = 1;
                    } else {
                        String m5 = m(name, "create");
                        if (this.d.get(m5) == null) {
                            this.c.put(m5, returnType);
                            this.d.put(m5, new c(method));
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private String d(String str) {
        return str.length() <= 20 ? str : new StringBuffer(str).replace(8, str.length() - 8, "...").toString();
    }

    private e e(Project project, Object obj, String str) {
        ComponentHelper j2;
        Class i2;
        Method h2;
        Object d2;
        if (this.e.size() == 0 || (i2 = (j2 = ComponentHelper.j(project)).i(str)) == null || (h2 = h(i2, this.e)) == null || (d2 = j2.d(str)) == null) {
            return null;
        }
        return new f(this, h2, d2, d2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private b f(Method method, Class cls, String str) {
        Constructor constructor;
        boolean z2;
        Map map = i;
        if (map.containsKey(cls)) {
            cls = (Class) map.get(cls);
        }
        Class cls2 = t;
        if (cls2 == null) {
            cls2 = c("java.lang.String");
            t = cls2;
        }
        if (cls2.equals(cls)) {
            return new h(this, method, method);
        }
        Class cls3 = l;
        if (cls3 == null) {
            cls3 = c("java.lang.Character");
            l = cls3;
        }
        if (cls3.equals(cls)) {
            return new i(this, method, str, method);
        }
        Class cls4 = j;
        if (cls4 == null) {
            cls4 = c("java.lang.Boolean");
            j = cls4;
        }
        if (cls4.equals(cls)) {
            return new j(this, method, method);
        }
        Class cls5 = z;
        if (cls5 == null) {
            cls5 = c("java.lang.Class");
            z = cls5;
        }
        if (cls5.equals(cls)) {
            return new k(this, method, method);
        }
        Class cls6 = A;
        if (cls6 == null) {
            cls6 = c("java.io.File");
            A = cls6;
        }
        if (cls6.equals(cls)) {
            return new l(this, method, method);
        }
        Class cls7 = B;
        Class cls8 = cls7;
        if (cls7 == null) {
            Class c2 = c("org.apache.tools.ant.types.EnumeratedAttribute");
            B = c2;
            cls8 = c2;
        }
        if (cls8.isAssignableFrom(cls)) {
            return new m(this, method, cls, method);
        }
        if (Enum.class != 0 && Enum.class.isAssignableFrom(cls)) {
            return new n(this, method, method, cls);
        }
        Class cls9 = o;
        if (cls9 == null) {
            cls9 = c("java.lang.Long");
            o = cls9;
        }
        if (cls9.equals(cls)) {
            return new org.apache.tools.ant.d(this, method, method);
        }
        try {
            try {
                Class<?> cls10 = u;
                if (cls10 == null) {
                    cls10 = c("org.apache.tools.ant.Project");
                    u = cls10;
                }
                Class<?> cls11 = t;
                if (cls11 == null) {
                    cls11 = c("java.lang.String");
                    t = cls11;
                }
                constructor = cls.getConstructor(cls10, cls11);
                z2 = true;
            } catch (NoSuchMethodException unused) {
                return null;
            }
        } catch (NoSuchMethodException unused2) {
            Class<?> cls12 = t;
            if (cls12 == null) {
                cls12 = c("java.lang.String");
                t = cls12;
            }
            constructor = cls.getConstructor(cls12);
            z2 = false;
        }
        return new org.apache.tools.ant.e(this, method, z2, constructor, method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BuildException g(InvocationTargetException invocationTargetException) {
        Throwable targetException = invocationTargetException.getTargetException();
        return targetException instanceof BuildException ? (BuildException) targetException : new BuildException(targetException);
    }

    private Method h(Class cls, List list) {
        Method method = null;
        Class<?> cls2 = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Method method2 = (Method) list.get(i2);
            Class<?> cls3 = method2.getParameterTypes()[0];
            if (cls3.isAssignableFrom(cls)) {
                if (cls2 == null) {
                    method = method2;
                    cls2 = cls3;
                } else if (!cls3.isAssignableFrom(cls2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("ambiguous: types ");
                    stringBuffer.append(cls2.getName());
                    stringBuffer.append(" and ");
                    stringBuffer.append(cls3.getName());
                    stringBuffer.append(" match ");
                    stringBuffer.append(cls.getName());
                    throw new BuildException(stringBuffer.toString());
                }
            }
        }
        return method;
    }

    private String j(Project project, Object obj) {
        return project.p(obj);
    }

    public static o k(Project project, Class cls) {
        Map map = h;
        o oVar = (o) map.get(cls.getName());
        if (oVar == null || oVar.g != cls) {
            oVar = new o(cls);
            if (project != null) {
                map.put(cls.getName(), oVar);
            }
        }
        return oVar;
    }

    private e l(Project project, String str, Object obj, String str2, w wVar) {
        String d2 = r.d(str2);
        String c2 = r.c(str2);
        if (d2.equals("antlib:org.apache.tools.ant")) {
            d2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (str.equals("antlib:org.apache.tools.ant")) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        e eVar = (d2.equals(str) || d2.length() == 0) ? (e) this.d.get(c2.toLowerCase(Locale.US)) : null;
        if (eVar == null) {
            eVar = e(project, obj, str2);
        }
        if (eVar == null) {
            t(project, obj, str2);
        }
        return eVar;
    }

    private static String m(String str, String str2) {
        return str.substring(str2.length()).toLowerCase(Locale.US);
    }

    private void n(Method method) {
        Class<?> cls = method.getParameterTypes()[0];
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            Method method2 = (Method) this.e.get(i2);
            if (method2.getParameterTypes()[0].equals(cls)) {
                if (method.getName().equals("addConfigured")) {
                    this.e.set(i2, method);
                    return;
                }
                return;
            } else {
                if (method2.getParameterTypes()[0].isAssignableFrom(cls)) {
                    this.e.add(i2, method);
                    return;
                }
            }
        }
        this.e.add(method);
    }

    private boolean q(String str, Class cls) {
        if ("setLocation".equals(str)) {
            Class cls2 = v;
            if (cls2 == null) {
                cls2 = c("org.apache.tools.ant.Location");
                v = cls2;
            }
            if (cls2.equals(cls)) {
                return true;
            }
        }
        if (!"setTaskType".equals(str)) {
            return false;
        }
        Class cls3 = t;
        if (cls3 == null) {
            cls3 = c("java.lang.String");
            t = cls3;
        }
        return cls3.equals(cls);
    }

    public void b(Project project, Object obj, String str) {
        Method method = this.f;
        if (method != null) {
            try {
                method.invoke(obj, str);
                return;
            } catch (IllegalAccessException e2) {
                throw new BuildException(e2);
            } catch (InvocationTargetException e3) {
                throw g(e3);
            }
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(project.p(obj));
        stringBuffer.append(" doesn't support nested text data (\"");
        stringBuffer.append(d(trim));
        stringBuffer.append("\").");
        throw new BuildException(stringBuffer.toString());
    }

    public d i(Project project, String str, Object obj, String str2, w wVar) {
        return new d(project, obj, l(project, str, obj, str2, wVar), null);
    }

    public boolean o() {
        Class cls = y;
        if (cls == null) {
            cls = c("org.apache.tools.ant.TaskContainer");
            y = cls;
        }
        return cls.isAssignableFrom(this.g);
    }

    public boolean p() {
        Class cls = w;
        if (cls == null) {
            cls = c("org.apache.tools.ant.DynamicElement");
            w = cls;
        }
        if (!cls.isAssignableFrom(this.g)) {
            Class cls2 = x;
            if (cls2 == null) {
                cls2 = c("org.apache.tools.ant.DynamicElementNS");
                x = cls2;
            }
            if (!cls2.isAssignableFrom(this.g)) {
                return false;
            }
        }
        return true;
    }

    public void r(Project project, Object obj, String str, String str2) {
        b bVar = (b) this.b.get(str.toLowerCase(Locale.US));
        if (bVar != null) {
            try {
                bVar.a(project, obj, str2);
                return;
            } catch (IllegalAccessException e2) {
                throw new BuildException(e2);
            } catch (InvocationTargetException e3) {
                throw g(e3);
            }
        }
        if (str.indexOf(58) != -1) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(j(project, obj));
        stringBuffer.append(" doesn't support the \"");
        stringBuffer.append(str);
        stringBuffer.append("\" attribute.");
        throw new UnsupportedAttributeException(stringBuffer.toString(), str);
    }

    public boolean s(String str, String str2) {
        if (p() || this.e.size() > 0) {
            return true;
        }
        if (!this.d.containsKey(r.c(str2).toLowerCase(Locale.US))) {
            return false;
        }
        String d2 = r.d(str2);
        if (d2.equals("antlib:org.apache.tools.ant")) {
            d2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (HttpUrl.FRAGMENT_ENCODE_SET.equals(d2)) {
            return true;
        }
        if (str.equals("antlib:org.apache.tools.ant")) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return d2.equals(str);
    }

    public void t(Project project, Object obj, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(project.p(obj));
        stringBuffer.append(" doesn't support the nested \"");
        stringBuffer.append(str);
        stringBuffer.append("\" element.");
        throw new UnsupportedElementException(stringBuffer.toString(), str);
    }
}
