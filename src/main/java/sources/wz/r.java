package wz;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class r implements org.mvel2.a {
    private static final Short a = 1;
    private static final Short b = 0;
    private static wz.i c = new b();
    private static final Map d;

    static class a implements wz.i {
        a() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            return ((Boolean) obj).booleanValue() ? r.a : r.b;
        }
    }

    static class b implements wz.i {
        b() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            return Short.valueOf(Short.parseShort((String) obj));
        }
    }

    static class c implements wz.i {
        c() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return r.c.convert(String.valueOf(obj));
        }
    }

    static class d implements wz.i {
        d() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            return Short.valueOf(((BigDecimal) obj).shortValue());
        }
    }

    static class e implements wz.i {
        e() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            return Short.valueOf(((BigInteger) obj).shortValue());
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
        public Short convert(Object obj) {
            Integer num = (Integer) obj;
            if (num.intValue() <= 32767) {
                return Short.valueOf(num.shortValue());
            }
            throw new ConversionException("cannot coerce Integer to Short since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    static class h implements wz.i {
        h() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            Float f = (Float) obj;
            if (f.floatValue() <= 32767.0f) {
                return Short.valueOf(f.shortValue());
            }
            throw new ConversionException("cannot coerce Float to Short since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    static class i implements wz.i {
        i() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            Double d = (Double) obj;
            if (d.doubleValue() <= 32767.0d) {
                return Short.valueOf(d.shortValue());
            }
            throw new ConversionException("cannot coerce Double to Short since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    static class j implements wz.i {
        j() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            Long l = (Long) obj;
            if (l.longValue() <= 32767) {
                return Short.valueOf(l.shortValue());
            }
            throw new ConversionException("cannot coerce Integer to Short since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        d = hashMap;
        hashMap.put(String.class, c);
        hashMap.put(Object.class, new c());
        hashMap.put(BigDecimal.class, new d());
        hashMap.put(BigInteger.class, new e());
        hashMap.put(Short.class, new f());
        hashMap.put(Integer.class, new g());
        hashMap.put(Float.class, new h());
        hashMap.put(Double.class, new i());
        hashMap.put(Long.class, new j());
        hashMap.put(Boolean.class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return d.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = d;
        if (map.containsKey(obj.getClass())) {
            return ((wz.i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Short.class.getName());
    }
}
