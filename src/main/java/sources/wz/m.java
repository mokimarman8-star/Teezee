package wz;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class m implements org.mvel2.a {
    private static final Map a;

    static class a implements wz.i {
        a() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer convert(Object obj) {
            return ((Boolean) obj).booleanValue() ? 1 : 0;
        }
    }

    static class b implements wz.i {
        b() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer convert(Object obj) {
            return Integer.valueOf(((Character) obj).charValue());
        }
    }

    static class c implements wz.i {
        c() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            if (((String) obj).length() == 0) {
                return 0;
            }
            return Integer.valueOf(Integer.parseInt(String.valueOf(obj)));
        }
    }

    static class d implements wz.i {
        d() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer convert(Object obj) {
            return Integer.valueOf(((BigDecimal) obj).intValue());
        }
    }

    static class e implements wz.i {
        e() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer convert(Object obj) {
            return Integer.valueOf(((BigInteger) obj).intValue());
        }
    }

    static class f implements wz.i {
        f() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Integer.valueOf(Integer.parseInt((String) obj));
        }
    }

    static class g implements wz.i {
        g() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Integer.valueOf(((Short) obj).intValue());
        }
    }

    static class h implements wz.i {
        h() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            Long l = (Long) obj;
            if (l.longValue() <= 2147483647L) {
                return Integer.valueOf(l.intValue());
            }
            throw new ConversionException("cannot coerce Long to Integer since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    static class i implements wz.i {
        i() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            Float f = (Float) obj;
            if (f.floatValue() <= 2.14748365E9f) {
                return Integer.valueOf(f.intValue());
            }
            throw new ConversionException("cannot coerce Float to Integer since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    static class j implements wz.i {
        j() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            Double d = (Double) obj;
            if (d.doubleValue() <= 2.147483647E9d) {
                return Integer.valueOf(d.intValue());
            }
            throw new ConversionException("cannot coerce Long to Integer since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    static class k implements wz.i {
        k() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return obj;
        }
    }

    static {
        HashMap hashMap = new HashMap(10);
        a = hashMap;
        hashMap.put(Object.class, new c());
        hashMap.put(BigDecimal.class, new d());
        hashMap.put(BigInteger.class, new e());
        hashMap.put(String.class, new f());
        hashMap.put(Short.class, new g());
        hashMap.put(Long.class, new h());
        hashMap.put(Float.class, new i());
        hashMap.put(Double.class, new j());
        hashMap.put(Integer.class, new k());
        hashMap.put(Boolean.class, new a());
        hashMap.put(Character.class, new b());
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
