package wz;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class e implements org.mvel2.a {
    private static final Map a;
    private static i b;

    static class a implements i {
        a() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Byte.valueOf(Byte.parseByte((String) obj));
        }
    }

    static class b implements i {
        b() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return e.b.convert(String.valueOf(obj));
        }
    }

    static class c implements i {
        c() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return new Byte(((Byte) obj).byteValue());
        }
    }

    static class d implements i {
        d() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Byte.valueOf(((Integer) obj).byteValue());
        }
    }

    /* renamed from: wz.e$e, reason: collision with other inner class name */
    static class C0015e implements i {
        C0015e() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Byte.valueOf(((Long) obj).byteValue());
        }
    }

    static class f implements i {
        f() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Byte.valueOf(((Double) obj).byteValue());
        }
    }

    static class g implements i {
        g() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Byte.valueOf(((Float) obj).byteValue());
        }
    }

    static class h implements i {
        h() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Byte.valueOf(((Short) obj).byteValue());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        a aVar = new a();
        b = aVar;
        hashMap.put(String.class, aVar);
        hashMap.put(Object.class, new b());
        hashMap.put(Byte.class, new c());
        hashMap.put(Integer.class, new d());
        hashMap.put(Long.class, new C0015e());
        hashMap.put(Double.class, new f());
        hashMap.put(Float.class, new g());
        hashMap.put(Short.class, new h());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = a;
        if (map.containsKey(obj.getClass())) {
            return ((i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
