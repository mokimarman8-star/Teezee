package wz;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class f implements org.mvel2.a {
    private static final Map a;

    static class a implements i {
        a() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            return ((String) obj).toCharArray();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(String.class, new a());
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
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Boolean.class.getName());
    }
}
