package com.transsion.json;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ml.b;
import ml.f;
import ml.g;
import ml.k;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class m {
    private final Map d;
    private final LinkedList a = new LinkedList();
    private final LinkedList b = new LinkedList();
    private final q c = new q();
    private final Map e = new HashMap();

    public m() {
        HashMap hashMap = new HashMap();
        this.d = hashMap;
        hashMap.put(Object.class, new b());
        hashMap.put(Collection.class, new k());
        hashMap.put(List.class, new k());
        hashMap.put(Set.class, new ml.n());
        hashMap.put(Map.class, new ml.m());
        hashMap.put(Integer.class, new ml.i());
        hashMap.put(Integer.TYPE, new ml.i());
        hashMap.put(Float.class, new ml.h());
        hashMap.put(Float.TYPE, new ml.h());
        hashMap.put(Double.class, new f());
        hashMap.put(Double.TYPE, new f());
        hashMap.put(Long.class, new ml.l());
        hashMap.put(Long.TYPE, new ml.l());
        hashMap.put(Byte.class, new ml.d());
        hashMap.put(Byte.TYPE, new ml.d());
        hashMap.put(Boolean.class, new ml.c());
        hashMap.put(Boolean.TYPE, new ml.c());
        hashMap.put(Character.class, new ml.e());
        hashMap.put(Character.TYPE, new ml.e());
        hashMap.put(Enum.class, new g());
        hashMap.put(String.class, new ml.o());
        hashMap.put(Array.class, new ml.a());
        hashMap.put(n.class, new ml.j());
    }

    private o c(Class cls) {
        o oVar = (o) this.d.get(cls);
        if (oVar != null || cls == null) {
            return oVar;
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            o c = c(cls2);
            if (c != null) {
                return c;
            }
        }
        if (cls.getSuperclass() != null) {
            return c(cls.getSuperclass());
        }
        return null;
    }

    private Class g(Type type) {
        if (type == null) {
            return null;
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return Array.class;
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable)) {
            return null;
        }
        throw new k(this.c + ":  Unknown type " + type);
    }

    private String m(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    private Type n(Type type, Type type2) {
        if ((type instanceof Class) || (type instanceof ParameterizedType)) {
            return type;
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return type2;
        }
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        throw new k(this.c + ":  Unknown generic type " + type + ".");
    }

    private boolean p(Map map, d dVar) {
        return map.containsKey(dVar.b()) || map.containsKey(m(dVar.b()));
    }

    private o r(Class cls) {
        o oVar = (o) this.e.get(this.c);
        return oVar == null ? (cls == null || !cls.isArray()) ? c(cls) : (o) this.d.get(Array.class) : oVar;
    }

    private Object s(Map map, d dVar) {
        Object obj = map.get(dVar.b());
        return obj == null ? map.get(m(dVar.b())) : obj;
    }

    private Class t(Object obj, Class cls) {
        if (this.e.containsKey(this.c)) {
            return null;
        }
        Class f = f(obj instanceof Map ? h((Map) obj, null) : null, cls);
        return f == null ? obj.getClass() : f;
    }

    public m a(q qVar, o oVar) {
        this.e.put(qVar, oVar);
        return this;
    }

    public m b(Class cls, o oVar) {
        this.d.put(cls, oVar);
        return this;
    }

    public q d() {
        return this.c;
    }

    public Class e(q qVar) {
        return null;
    }

    protected Class f(Class cls, Class cls2) {
        if (cls != null && cls2 != null) {
            return cls2.isAssignableFrom(cls) ? cls : cls2;
        }
        if (cls2 != null) {
            return cls2;
        }
        if (cls != null) {
            return cls;
        }
        return null;
    }

    protected Class h(Map map, Class cls) {
        if (cls != null) {
            return cls;
        }
        String str = (String) map.get("class");
        if (str == null) {
            return null;
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return contextClassLoader != null ? contextClassLoader.loadClass(str) : Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new k(String.format("%s:  Could not load %s", this.c, str), e);
        }
    }

    public Object i(Object obj) {
        return j(obj, null);
    }

    public Object j(Object obj, Type type) {
        this.b.add(obj);
        if (obj == null) {
            this.b.removeLast();
            return null;
        }
        try {
            Class t = t(obj, g(type));
            o r = r(t);
            if (r != null) {
                return r.a(this, obj, type, t);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            sb.append(": + Could not find a suitable ObjectFactory for ");
            sb.append(t);
            throw new k(sb.toString());
        } finally {
            this.b.removeLast();
        }
    }

    public Object k(Map map, Object obj, Type type) {
        try {
            this.a.add(obj);
            c a = c.a(obj.getClass());
            for (d dVar : a != null ? a.c() : null) {
                if (p(map, dVar)) {
                    Object s = s(map, dVar);
                    if (dVar.p().booleanValue()) {
                        this.c.a(dVar.e());
                        Method k = dVar.k();
                        if (k != null) {
                            Type[] genericParameterTypes = k.getGenericParameterTypes();
                            if (genericParameterTypes.length != 1) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.c);
                                sb.append(":  Expected a single parameter for method ");
                                sb.append(obj.getClass().getName());
                                sb.append(".");
                                sb.append(k.getName());
                                sb.append(" but got ");
                                sb.append(genericParameterTypes.length);
                                throw new k(sb.toString());
                            }
                            k.invoke(this.a.getLast(), j(s, n(genericParameterTypes[0], type)));
                        } else {
                            Field g = dVar.g();
                            if (g != null) {
                                g.setAccessible(true);
                                g.set(obj, j(s, g.getGenericType()));
                            }
                        }
                        this.c.d();
                    } else {
                        continue;
                    }
                }
            }
            return this.a.removeLast();
        } catch (IllegalAccessException e) {
            throw new k(this.c + ":  Could not access the no-arg constructor for " + obj.getClass().getName(), e);
        } catch (InvocationTargetException e3) {
            throw new k(this.c + ":  Exception while trying to invoke setter method.", e3);
        }
    }

    public Object l(Map map, Map map2, Type type, Type type2) {
        this.b.add(map);
        this.a.add(map2);
        for (Object obj : map.keySet()) {
            this.c.a("keys");
            Object j = j(obj, type);
            this.c.d();
            this.c.a("values");
            Object j2 = j(map.get(obj), type2);
            this.c.d();
            map2.put(j, j2);
        }
        this.a.removeLast();
        this.b.removeLast();
        return map2;
    }

    public Collection o(Collection collection, Collection collection2, Type type) {
        Type type2 = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        this.b.add(collection);
        this.a.add(collection2);
        d().a("values");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            collection2.add(j(it.next(), type2));
        }
        d().d();
        this.a.removeLast();
        this.b.removeLast();
        return collection2;
    }

    public k q(Object obj, Class cls) {
        return new k(String.format("%s:  Can not convert %s into %s", this.c, obj.getClass().getName(), cls.getName()));
    }
}
