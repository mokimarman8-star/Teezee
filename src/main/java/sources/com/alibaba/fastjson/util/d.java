package com.alibaba.fastjson.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class d implements Comparable {
    public final String a;
    public final Method b;
    public final Field c;
    private int d;
    public final Class e;
    public final Type f;
    public final Class g;
    public final boolean h;
    public final int i;
    public final int j;
    public final String k;
    private final z4.b l;
    private final z4.b m;
    public final boolean n;
    public final boolean o;
    public final char[] p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final String t;
    public final String[] u;
    public final long v;

    public d(String str, Class cls, Class cls2, Type type, Field field, int i, int i2, int i3) {
        this.d = 0;
        i = i < 0 ? 0 : i;
        this.a = str;
        this.g = cls;
        this.e = cls2;
        this.f = type;
        this.b = null;
        this.c = field;
        this.d = i;
        this.i = i2;
        this.j = i3;
        this.q = cls2.isEnum();
        if (field != null) {
            int modifiers = field.getModifiers();
            this.n = true;
            this.o = Modifier.isTransient(modifiers);
        } else {
            this.o = false;
            this.n = false;
        }
        this.p = b();
        if (field != null) {
            TypeUtils.M0(field);
        }
        this.k = "";
        z4.b bVar = field == null ? null : (z4.b) TypeUtils.O(field, z4.b.class);
        this.l = bVar;
        this.m = null;
        this.h = false;
        this.r = false;
        this.s = false;
        this.t = null;
        this.u = new String[0];
        this.v = n(str, bVar);
    }

    public d(String str, Method method, Field field, Class cls, Type type, int i, int i2, int i3, z4.b bVar, z4.b bVar2, String str2) {
        this(str, method, field, cls, type, i, i2, i3, bVar, bVar2, str2, null);
    }

    public d(String str, Method method, Field field, Class cls, Type type, int i, int i2, int i3, z4.b bVar, z4.b bVar2, String str2, Map map) {
        boolean z;
        boolean isFinal;
        Class<?> cls2;
        Type type2;
        Type l;
        Class<?> cls3;
        Class<?> cls4;
        Type type3;
        Class<?> cls5;
        Type type4;
        boolean z2 = false;
        this.d = 0;
        if (field != null) {
            String name = field.getName();
            if (name.equals(str)) {
                str = name;
            }
        }
        i = i < 0 ? 0 : i;
        this.a = str;
        this.b = method;
        this.c = field;
        this.d = i;
        this.i = i2;
        this.j = i3;
        this.l = bVar;
        this.m = bVar2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.n = (modifiers & 1) != 0 || method == null;
            this.o = Modifier.isTransient(modifiers) || TypeUtils.y0(method);
        } else {
            this.n = false;
            this.o = TypeUtils.y0(method);
        }
        if (str2 == null || str2.length() <= 0) {
            this.k = "";
        } else {
            this.k = str2;
        }
        z4.b e = e();
        this.v = n(str, e);
        if (e != null) {
            String format = e.format();
            r4 = format.trim().length() != 0 ? format : null;
            z = e.jsonDirect();
            this.s = e.unwrapped();
            this.u = e.alternateNames();
        } else {
            this.s = false;
            this.u = new String[0];
            z = false;
        }
        this.t = r4;
        this.p = b();
        if (method != null) {
            TypeUtils.M0(method);
        }
        if (field != null) {
            TypeUtils.M0(field);
        }
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                cls4 = parameterTypes[0];
                type4 = method.getGenericParameterTypes()[0];
            } else if (parameterTypes.length == 2 && (cls3 = parameterTypes[0]) == String.class && parameterTypes[1] == Object.class) {
                cls4 = cls3;
                type4 = cls3;
            } else {
                isFinal = true;
                cls5 = method.getReturnType();
                type3 = method.getGenericReturnType();
                this.g = method.getDeclaringClass();
                cls2 = cls5;
                type2 = type3;
            }
            isFinal = false;
            cls5 = cls4;
            type3 = type4;
            this.g = method.getDeclaringClass();
            cls2 = cls5;
            type2 = type3;
        } else {
            Class<?> type5 = field.getType();
            Type genericType = field.getGenericType();
            this.g = field.getDeclaringClass();
            isFinal = Modifier.isFinal(field.getModifiers());
            cls2 = type5;
            type2 = genericType;
        }
        this.h = isFinal;
        if (z && cls2 == String.class) {
            z2 = true;
        }
        this.r = z2;
        if (cls != null && cls2 == Object.class && (type2 instanceof TypeVariable) && (l = l(cls, type, (TypeVariable) type2)) != null) {
            this.e = TypeUtils.Q(l);
            this.f = l;
            this.q = cls2.isEnum();
            return;
        }
        boolean z3 = type2 instanceof Class;
        Class<?> cls6 = cls2;
        Type type6 = type2;
        if (!z3) {
            Type j = j(cls, type == null ? cls : type, type2, map);
            Class<?> cls7 = cls2;
            if (j != type2) {
                if (j instanceof ParameterizedType) {
                    cls7 = TypeUtils.Q(j);
                } else {
                    cls7 = cls2;
                    if (j instanceof Class) {
                        cls7 = TypeUtils.Q(j);
                    }
                }
            }
            type6 = j;
            cls6 = cls7;
        }
        this.f = type6;
        this.e = cls6;
        this.q = cls6.isEnum();
    }

    private static boolean f(Type[] typeArr, Map map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            Type type = typeArr[i];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (f(actualTypeArguments, map)) {
                    typeArr[i] = com.alibaba.fastjson.g.b(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                    z = true;
                }
            } else {
                if ((type instanceof TypeVariable) && map.containsKey(type)) {
                    typeArr[i] = (Type) map.get(type);
                    z = true;
                }
            }
        }
        return z;
    }

    private static boolean g(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            Type type = typeArr[i];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (g(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i] = com.alibaba.fastjson.g.b(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                    z = true;
                }
            } else if (type instanceof TypeVariable) {
                for (int i2 = 0; i2 < typeVariableArr.length; i2++) {
                    if (type.equals(typeVariableArr[i2])) {
                        typeArr[i] = typeArr2[i2];
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static Type i(Class cls, Type type, Type type2) {
        return j(cls, type, type2, null);
    }

    public static Type j(Class cls, Type type, Type type2, Map map) {
        TypeVariable<Class<?>>[] typeParameters;
        ParameterizedType parameterizedType;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type j = j(cls, type, genericComponentType, map);
                return genericComponentType != j ? Array.newInstance((Class<?>) TypeUtils.Q(j), 0).getClass() : type2;
            }
            if (!TypeUtils.p0(type)) {
                return type2;
            }
            if (type2 instanceof TypeVariable) {
                ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.Z(type);
                TypeVariable typeVariable = (TypeVariable) type2;
                TypeVariable[] typeParameters2 = TypeUtils.Q(parameterizedType2).getTypeParameters();
                for (int i = 0; i < typeParameters2.length; i++) {
                    if (typeParameters2[i].getName().equals(typeVariable.getName())) {
                        return parameterizedType2.getActualTypeArguments()[i];
                    }
                }
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                boolean f = f(actualTypeArguments, map);
                if (!f) {
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                        typeParameters = cls.getTypeParameters();
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        typeParameters = cls.getSuperclass().getTypeParameters();
                    } else {
                        typeParameters = type.getClass().getTypeParameters();
                        parameterizedType = parameterizedType3;
                    }
                    f = g(actualTypeArguments, typeParameters, parameterizedType.getActualTypeArguments());
                }
                if (f) {
                    return com.alibaba.fastjson.g.b(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType()));
                }
            }
        }
        return type2;
    }

    private static Type l(Class cls, Type type, TypeVariable typeVariable) {
        Type[] typeArr;
        Class cls2 = typeVariable.getGenericDeclaration() instanceof Class ? (Class) typeVariable.getGenericDeclaration() : null;
        if (cls2 == cls) {
            typeArr = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
        } else {
            Type[] typeArr2 = null;
            while (cls != null && cls != Object.class && cls != cls2) {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    g(actualTypeArguments, cls.getTypeParameters(), typeArr2);
                    typeArr2 = actualTypeArguments;
                }
                cls = cls.getSuperclass();
            }
            typeArr = typeArr2;
        }
        if (typeArr == null || cls2 == null) {
            return null;
        }
        TypeVariable[] typeParameters = cls2.getTypeParameters();
        for (int i = 0; i < typeParameters.length; i++) {
            if (typeVariable.equals(typeParameters[i])) {
                return typeArr[i];
            }
        }
        return null;
    }

    private long n(String str, z4.b bVar) {
        return (bVar == null || bVar.name().length() == 0) ? TypeUtils.K(str) : TypeUtils.L(str);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(d dVar) {
        Method method = dVar.b;
        if (method != null && this.b != null && method.isBridge() && !this.b.isBridge() && dVar.b.getName().equals(this.b.getName())) {
            return 1;
        }
        int i = this.d;
        int i2 = dVar.d;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int compareTo = this.a.compareTo(dVar.a);
        if (compareTo != 0) {
            return compareTo;
        }
        Class<?> h = h();
        Class<?> h2 = dVar.h();
        if (h != null && h2 != null && h != h2) {
            if (h.isAssignableFrom(h2)) {
                return -1;
            }
            if (h2.isAssignableFrom(h)) {
                return 1;
            }
        }
        Field field = this.c;
        boolean z = false;
        boolean z2 = field != null && field.getType() == this.e;
        Field field2 = dVar.c;
        if (field2 != null && field2.getType() == dVar.e) {
            z = true;
        }
        if (z2 && !z) {
            return 1;
        }
        if (z && !z2) {
            return -1;
        }
        if (dVar.e.isPrimitive() && !this.e.isPrimitive()) {
            return 1;
        }
        if (this.e.isPrimitive() && !dVar.e.isPrimitive()) {
            return -1;
        }
        if (dVar.e.getName().startsWith("java.") && !this.e.getName().startsWith("java.")) {
            return 1;
        }
        if (!this.e.getName().startsWith("java.") || dVar.e.getName().startsWith("java.")) {
            return this.e.getName().compareTo(dVar.e.getName());
        }
        return -1;
    }

    protected char[] b() {
        int length = this.a.length();
        char[] cArr = new char[length + 3];
        String str = this.a;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
        return cArr;
    }

    public Object d(Object obj) {
        Method method = this.b;
        return method != null ? method.invoke(obj, null) : this.c.get(obj);
    }

    public z4.b e() {
        z4.b bVar = this.l;
        return bVar != null ? bVar : this.m;
    }

    protected Class h() {
        Method method = this.b;
        if (method != null) {
            return method.getDeclaringClass();
        }
        Field field = this.c;
        if (field != null) {
            return field.getDeclaringClass();
        }
        return null;
    }

    public String k() {
        return this.t;
    }

    public Member m() {
        Method method = this.b;
        return method != null ? method : this.c;
    }

    public void o(Object obj, Object obj2) {
        Method method = this.b;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.c.set(obj, obj2);
        }
    }

    public void p() {
        Method method = this.b;
        if (method != null) {
            TypeUtils.M0(method);
        } else {
            TypeUtils.M0(this.c);
        }
    }

    public String toString() {
        return this.a;
    }
}
