package wz;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class k implements org.mvel2.a {
    private static final Map a;
    private static wz.i b;

    static class a implements wz.i {
        a() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float convert(Object obj) {
            return ((Boolean) obj).booleanValue() ? Float.valueOf(1.0f) : Float.valueOf(0.0f);
        }
    }

    static class b implements wz.i {
        b() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            String str = (String) obj;
            return str.length() == 0 ? Float.valueOf(0.0f) : Float.valueOf(Float.parseFloat(str));
        }
    }

    static class c implements wz.i {
        c() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return k.b.convert(String.valueOf(obj));
        }
    }

    static class d implements wz.i {
        d() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float convert(Object obj) {
            return Float.valueOf(((BigDecimal) obj).floatValue());
        }
    }

    static class e implements wz.i {
        e() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float convert(Object obj) {
            return Float.valueOf(((BigInteger) obj).floatValue());
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
        public Float convert(Object obj) {
            return Float.valueOf(((Integer) obj).floatValue());
        }
    }

    static class h implements wz.i {
        h() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float convert(Object obj) {
            return Float.valueOf(((Double) obj).floatValue());
        }
    }

    static class i implements wz.i {
        i() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float convert(Object obj) {
            return Float.valueOf(((Long) obj).floatValue());
        }
    }

    static class j implements wz.i {
        j() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float convert(Object obj) {
            return Float.valueOf(((Short) obj).floatValue());
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
        hashMap.put(Float.class, new f());
        hashMap.put(Integer.class, new g());
        hashMap.put(Double.class, new h());
        hashMap.put(Long.class, new i());
        hashMap.put(Short.class, new j());
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
