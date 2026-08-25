package wz;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class b implements org.mvel2.a {
    private static final Map a;

    static class a implements wz.i {
        a() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal((String) obj, MathContext.DECIMAL128);
        }
    }

    /* renamed from: wz.b$b, reason: collision with other inner class name */
    static class C0012b implements wz.i {
        C0012b() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal((char[]) obj, MathContext.DECIMAL128);
        }
    }

    static class c implements wz.i {
        c() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(String.valueOf(obj), MathContext.DECIMAL128);
        }
    }

    static class d implements wz.i {
        d() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return (BigDecimal) obj;
        }
    }

    static class e implements wz.i {
        e() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(((BigInteger) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    static class f implements wz.i {
        f() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal((String) obj, MathContext.DECIMAL128);
        }
    }

    static class g implements wz.i {
        g() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(((Double) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    static class h implements wz.i {
        h() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(((Float) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    static class i implements wz.i {
        i() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(((Short) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    static class j implements wz.i {
        j() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(((Long) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    static class k implements wz.i {
        k() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(((Integer) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(Object.class, new c());
        hashMap.put(BigDecimal.class, new d());
        hashMap.put(BigInteger.class, new e());
        hashMap.put(String.class, new f());
        hashMap.put(Double.class, new g());
        hashMap.put(Float.class, new h());
        hashMap.put(Short.class, new i());
        hashMap.put(Long.class, new j());
        hashMap.put(Integer.class, new k());
        hashMap.put(String.class, new a());
        hashMap.put(char[].class, new C0012b());
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
