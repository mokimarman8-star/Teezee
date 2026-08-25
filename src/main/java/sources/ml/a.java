package ml;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a implements com.transsion.json.o {
    public Object a(com.transsion.json.m mVar, Object obj, Type type, Class cls) {
        List list = (List) obj;
        mVar.d().a("values");
        try {
            try {
                Class<?> componentType = cls.getComponentType() != null ? cls.getComponentType() : mVar.e(mVar.d());
                if (componentType == null) {
                    throw new com.transsion.json.k("Missing concrete class for array.  You might require a use() method.");
                }
                Object newInstance = Array.newInstance(componentType, list.size());
                for (int i = 0; i < list.size(); i++) {
                    Array.set(newInstance, i, mVar.j(list.get(i), componentType));
                }
                mVar.d().d();
                return newInstance;
            } catch (ClassNotFoundException e) {
                throw new com.transsion.json.k(String.format("%s: Could not find class %s", mVar.d(), e.getMessage()), e);
            }
        } catch (Throwable th2) {
            mVar.d().d();
            throw th2;
        }
    }
}
