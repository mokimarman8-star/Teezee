package wz;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class c implements org.mvel2.a {
    private static final Map a;

    static class a implements wz.i {
        a() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger(String.valueOf(obj));
        }
    }

    static class b implements wz.i {
        b() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return (BigInteger) obj;
        }
    }

    /* renamed from: wz.c$c, reason: collision with other inner class name */
    static class C0013c implements wz.i {
        C0013c() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return ((BigDecimal) obj).toBigInteger();
        }
    }

    static class d implements wz.i {
        d() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger((String) obj);
        }
    }

    static class e implements wz.i {
        e() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger(String.valueOf(obj));
        }
    }

    static class f implements wz.i {
        f() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger(String.valueOf(obj));
        }
    }

    static class g implements wz.i {
        g() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger(String.valueOf(obj));
        }
    }

    static class h implements wz.i {
        h() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger((String) obj);
        }
    }

    static class i implements wz.i {
        i() {
        }

        @Override // wz.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger(new String((char[]) obj));
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(Object.class, new a());
        hashMap.put(BigInteger.class, new b());
        hashMap.put(BigDecimal.class, new C0013c());
        hashMap.put(String.class, new d());
        hashMap.put(Short.class, new e());
        hashMap.put(Long.class, new f());
        hashMap.put(Integer.class, new g());
        hashMap.put(String.class, new h());
        hashMap.put(char[].class, new i());
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
