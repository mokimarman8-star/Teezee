package wz;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class d implements org.mvel2.a {
    private static final Map a;
    private static wz.i b;

    static class a implements wz.i {
        a() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            return Boolean.valueOf(((BigDecimal) obj).doubleValue() > 0.0d);
        }
    }

    static class b implements wz.i {
        b() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            String str = (String) obj;
            return Boolean.valueOf((str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase("off") || "0".equals(obj) || "".equals(obj)) ? false : true);
        }
    }

    static class c implements wz.i {
        c() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return d.b.convert(String.valueOf(obj));
        }
    }

    /* renamed from: wz.d$d, reason: collision with other inner class name */
    static class C0014d implements wz.i {
        C0014d() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return obj;
        }
    }

    static class e implements wz.i {
        e() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            return Boolean.valueOf(((Integer) obj).intValue() > 0);
        }
    }

    static class f implements wz.i {
        f() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            return Boolean.valueOf(((Float) obj).floatValue() > 0.0f);
        }
    }

    static class g implements wz.i {
        g() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            return Boolean.valueOf(((Double) obj).doubleValue() > 0.0d);
        }
    }

    static class h implements wz.i {
        h() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            return Boolean.valueOf(((Short) obj).shortValue() > 0);
        }
    }

    static class i implements wz.i {
        i() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            return Boolean.valueOf(((Long) obj).longValue() > 0);
        }
    }

    static class j implements wz.i {
        j() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            Boolean bool = (Boolean) obj;
            bool.booleanValue();
            return bool;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        b bVar = new b();
        b = bVar;
        hashMap.put(String.class, bVar);
        hashMap.put(Object.class, new c());
        hashMap.put(Boolean.class, new C0014d());
        hashMap.put(Integer.class, new e());
        hashMap.put(Float.class, new f());
        hashMap.put(Double.class, new g());
        hashMap.put(Short.class, new h());
        hashMap.put(Long.class, new i());
        hashMap.put(Boolean.TYPE, new j());
        hashMap.put(BigDecimal.class, new a());
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
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Boolean.class.getName());
    }
}
