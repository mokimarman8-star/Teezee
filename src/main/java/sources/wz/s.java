package wz;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class s implements org.mvel2.a {
    private static final Map a;

    static class a implements i {
        a() {
        }

        @Override // wz.i
        public Object convert(Object obj) {
            Object[] objArr = (Object[]) obj;
            String[] strArr = new String[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                strArr[i] = String.valueOf(objArr[i]);
            }
            return strArr;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(Object[].class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        if (!obj.getClass().isArray()) {
            return new String[]{String.valueOf(obj)};
        }
        Object[] objArr = (Object[]) obj;
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            strArr[i] = String.valueOf(objArr[i]);
        }
        return strArr;
    }
}
