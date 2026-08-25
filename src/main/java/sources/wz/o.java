package wz;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class o implements org.mvel2.a {
    private static final Map a;
    private static wz.i b;

    static class a implements wz.i {
        a() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long convert(Object obj) {
            return ((Boolean) obj).booleanValue() ? 1L : 0L;
        }
    }

    static class b implements wz.i {
        b() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            String str = (String) obj;
            if (str.length() == 0) {
                return 0L;
            }
            return Long.valueOf(Long.parseLong(str));
        }
    }

    static class c implements wz.i {
        c() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return o.b.convert(String.valueOf(obj));
        }
    }

    static class d implements wz.i {
        d() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long convert(Object obj) {
            return Long.valueOf(((BigDecimal) obj).longValue());
        }
    }

    static class e implements wz.i {
        e() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long convert(Object obj) {
            return Long.valueOf(((BigInteger) obj).longValue());
        }
    }

    static class f implements wz.i {
        f() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Long.valueOf(((Short) obj).longValue());
        }
    }

    static class g implements wz.i {
        g() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return new Long(((Long) obj).longValue());
        }
    }

    static class h implements wz.i {
        h() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Long.valueOf(((Integer) obj).longValue());
        }
    }

    static class i implements wz.i {
        i() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Long.valueOf(((Double) obj).longValue());
        }
    }

    static class j implements wz.i {
        j() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Long.valueOf(((Float) obj).longValue());
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
        hashMap.put(Short.class, new f());
        hashMap.put(Long.class, new g());
        hashMap.put(Integer.class, new h());
        hashMap.put(Double.class, new i());
        hashMap.put(Float.class, new j());
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
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Long.class.getName());
    }
}
