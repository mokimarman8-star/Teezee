package wz;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class j implements org.mvel2.a {
    private static final Map a;
    private static wz.i b;

    static class a implements wz.i {
        a() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            return ((Boolean) obj).booleanValue() ? Double.valueOf(1.0d) : Double.valueOf(0.0d);
        }
    }

    static class b implements wz.i {
        b() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            String str = (String) obj;
            return str.length() == 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.parseDouble(str));
        }
    }

    static class c implements wz.i {
        c() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return j.b.convert(String.valueOf(obj));
        }
    }

    static class d implements wz.i {
        d() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            return Double.valueOf(((BigDecimal) obj).doubleValue());
        }
    }

    static class e implements wz.i {
        e() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            return Double.valueOf(((BigInteger) obj).doubleValue());
        }
    }

    static class f implements wz.i {
        f() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return obj;
        }
    }

    static class g implements wz.i {
        g() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            Float f = (Float) obj;
            if (f.floatValue() <= Double.MAX_VALUE) {
                return Double.valueOf(f.doubleValue());
            }
            throw new ConversionException("cannot coerce Float to Double since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Double.");
        }
    }

    static class h implements wz.i {
        h() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
    }

    static class i implements wz.i {
        i() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            return Double.valueOf(((Short) obj).doubleValue());
        }
    }

    /* renamed from: wz.j$j, reason: collision with other inner class name */
    static class C0016j implements wz.i {
        C0016j() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            return Double.valueOf(((Long) obj).doubleValue());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        b bVar = new b();
        b = bVar;
        hashMap.put(String.class, bVar);
        hashMap.put(Object.class, new c());
        hashMap.put(BigDecimal.class, new d());
        hashMap.put(BigInteger.class, new e());
        hashMap.put(Double.class, new f());
        hashMap.put(Float.class, new g());
        hashMap.put(Integer.class, new h());
        hashMap.put(Short.class, new i());
        hashMap.put(Long.class, new C0016j());
        hashMap.put(Boolean.class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = a;
        if (map.containsKey(obj.getClass())) {
            return ((wz.i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
