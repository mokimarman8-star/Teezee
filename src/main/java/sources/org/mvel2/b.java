package org.mvel2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.mvel2.util.FastList;
import wz.h;
import wz.j;
import wz.k;
import wz.l;
import wz.m;
import wz.n;
import wz.o;
import wz.p;
import wz.q;
import wz.r;
import wz.s;
import wz.t;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class b {
    private static final Map a;

    static {
        HashMap hashMap = new HashMap(76, 0.5f);
        a = hashMap;
        m mVar = new m();
        hashMap.put(Integer.class, mVar);
        hashMap.put(Integer.TYPE, mVar);
        r rVar = new r();
        hashMap.put(Short.class, rVar);
        hashMap.put(Short.TYPE, rVar);
        o oVar = new o();
        hashMap.put(Long.class, oVar);
        hashMap.put(Long.TYPE, oVar);
        wz.g gVar = new wz.g();
        hashMap.put(Character.class, gVar);
        hashMap.put(Character.TYPE, gVar);
        wz.e eVar = new wz.e();
        hashMap.put(Byte.class, eVar);
        hashMap.put(Byte.TYPE, eVar);
        k kVar = new k();
        hashMap.put(Float.class, kVar);
        hashMap.put(Float.TYPE, kVar);
        j jVar = new j();
        hashMap.put(Double.class, jVar);
        hashMap.put(Double.TYPE, jVar);
        wz.d dVar = new wz.d();
        hashMap.put(Boolean.class, dVar);
        hashMap.put(Boolean.TYPE, dVar);
        hashMap.put(String.class, new t());
        hashMap.put(Object.class, new p());
        wz.f fVar = new wz.f();
        hashMap.put(Character[].class, fVar);
        hashMap.put(char[].class, new h(fVar, new wz.a(char[].class)));
        hashMap.put(String[].class, new s());
        hashMap.put(Integer[].class, new l());
        hashMap.put(int[].class, new wz.a(int[].class));
        hashMap.put(long[].class, new wz.a(long[].class));
        hashMap.put(double[].class, new wz.a(double[].class));
        hashMap.put(float[].class, new wz.a(float[].class));
        hashMap.put(short[].class, new wz.a(short[].class));
        hashMap.put(boolean[].class, new wz.a(boolean[].class));
        hashMap.put(byte[].class, new wz.a(byte[].class));
        hashMap.put(BigDecimal.class, new wz.b());
        hashMap.put(BigInteger.class, new wz.c());
        n nVar = new n();
        hashMap.put(List.class, nVar);
        hashMap.put(FastList.class, nVar);
        hashMap.put(ArrayList.class, nVar);
        hashMap.put(LinkedList.class, nVar);
        q qVar = new q();
        hashMap.put(Set.class, qVar);
        hashMap.put(HashSet.class, qVar);
        hashMap.put(LinkedHashSet.class, qVar);
        hashMap.put(TreeSet.class, qVar);
    }

    public static boolean a(Class cls, Class cls2) {
        if (org.mvel2.util.p.f(cls, cls2)) {
            return true;
        }
        Map map = a;
        return map.containsKey(cls) ? ((a) map.get(cls)).a(org.mvel2.util.p.i(cls2)) : cls.isArray() && a(cls.getComponentType(), cls2);
    }

    public static Object b(Object obj, Class cls) {
        if (obj == null) {
            return null;
        }
        if (cls == obj.getClass() || cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        Map map = a;
        a aVar = (a) map.get(cls);
        if (aVar != null || !cls.isArray()) {
            return aVar.b(obj);
        }
        wz.a aVar2 = new wz.a(cls);
        map.put(cls, aVar2);
        return aVar2.b(obj);
    }
}
