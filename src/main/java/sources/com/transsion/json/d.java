package com.transsion.json;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class d {
    private final String a;
    private String b;
    private final c c;
    private Class d;
    protected final Field e;
    protected Method f;
    protected Method g;
    protected final Map h = new HashMap();
    protected g i = null;
    protected g j = null;
    protected Boolean k = null;

    public d(String str, c cVar) {
        this.b = str;
        this.a = str;
        this.c = cVar;
        Field b = cVar.b(str);
        this.e = b;
        if (b == null || !b.isAnnotationPresent(nl.a.class)) {
            return;
        }
        d((nl.a) b.getAnnotation(nl.a.class));
    }

    public d(Field field, c cVar) {
        String name = field.getName();
        this.b = name;
        this.a = name;
        this.c = cVar;
        this.e = field;
        this.d = field.getType();
        if (field.isAnnotationPresent(nl.a.class)) {
            d((nl.a) field.getAnnotation(nl.a.class));
        }
    }

    private void d(nl.a aVar) {
        this.b = aVar.name().length() > 0 ? aVar.name() : this.a;
        this.i = aVar.transformer() == com.transsion.json.b.n.class ? null : new g(aVar.transformer());
        this.j = aVar.objectFactory() != o.class ? new g(aVar.objectFactory()) : null;
        this.k = Boolean.valueOf(aVar.include());
    }

    public Object a(Object obj) {
        try {
            Method i = i();
            if (i != null) {
                return i.invoke(obj, null);
            }
            Field field = this.e;
            if (field != null) {
                return field.get(obj);
            }
            return null;
        } catch (IllegalAccessException e) {
            e = e;
            throw new k("Error while reading property " + this.d.getName() + "." + this.a, e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new k("Error while reading property " + this.d.getName() + "." + this.a, e);
        }
    }

    public String b() {
        return this.b;
    }

    public void c(Method method) {
        Class<?> cls = method.getParameterTypes()[0];
        if (this.d == null) {
            this.d = cls;
        }
        this.h.put(cls, method);
        method.setAccessible(true);
    }

    public String e() {
        return this.a;
    }

    public void f(Method method) {
        if (this.d == null) {
            this.d = method.getReturnType();
            this.f = method;
            method.setAccessible(true);
        } else if (method.getReturnType().isAssignableFrom(this.d)) {
            this.f = method;
            method.setAccessible(true);
        }
        Method method2 = this.f;
        if (method2 == null || !method2.isAnnotationPresent(nl.a.class)) {
            return;
        }
        d((nl.a) this.f.getAnnotation(nl.a.class));
    }

    public Field g() {
        return this.e;
    }

    public Class h() {
        return this.d;
    }

    public Method i() {
        return (this.f == null && this.c.e() != null && this.c.e().h(this.a)) ? this.c.e().f(this.a).i() : this.f;
    }

    public com.transsion.json.b.n j() {
        g gVar = this.i;
        if (gVar != null) {
            return (com.transsion.json.b.n) gVar.a();
        }
        return null;
    }

    public Method k() {
        if (this.g == null) {
            Method method = (Method) this.h.get(this.d);
            this.g = method;
            if (method == null && this.c.e() != null && this.c.e().h(this.a)) {
                return this.c.e().f(this.a).k();
            }
        }
        return this.g;
    }

    public Boolean l() {
        return this.k;
    }

    protected boolean m() {
        return i() == null && k() == null && !Modifier.isPublic(this.e.getModifiers());
    }

    public Boolean n() {
        Field field;
        Method i = i();
        return Boolean.valueOf(((i == null || Modifier.isStatic(i.getModifiers())) && ((field = this.e) == null || Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(this.e.getModifiers()))) ? false : true);
    }

    public Boolean o() {
        Field field = this.e;
        return Boolean.valueOf(field != null && Modifier.isTransient(field.getModifiers()));
    }

    public Boolean p() {
        Field field;
        return Boolean.valueOf((k() == null && ((field = this.e) == null || !Modifier.isPublic(field.getModifiers()) || Modifier.isTransient(this.e.getModifiers()))) ? false : true);
    }
}
