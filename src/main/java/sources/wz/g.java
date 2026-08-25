package wz;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class g implements org.mvel2.a {
    private static final Map a;
    private static final i b;

    static class a implements i {
        a() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            String str = (String) obj;
            if (str.length() <= 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new ConversionException("cannot convert a string with a length greater than 1 to java.lang.Character");
        }
    }

    static class b implements i {
        b() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return g.b.convert(String.valueOf(obj));
        }
    }

    static class c implements i {
        c() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return new Character(((Character) obj).charValue());
        }
    }

    static class d implements i {
        d() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Character.valueOf((char) ((BigDecimal) obj).intValue());
        }
    }

    static class e implements i {
        e() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return Character.valueOf((char) ((Integer) obj).intValue());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        a aVar = new a();
        b = aVar;
        hashMap.put(String.class, aVar);
        hashMap.put(Object.class, new b());
        hashMap.put(Character.class, new c());
        hashMap.put(BigDecimal.class, new d());
        hashMap.put(Integer.class, new e());
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
