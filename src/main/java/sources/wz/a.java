package wz;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class a implements org.mvel2.a {
    private final Class a;

    public a(Class cls) {
        this.a = cls;
    }

    private static Object c(Class cls, Object obj, Class cls2) {
        Class<?> componentType = cls2.getComponentType();
        int i = 0;
        if (Collection.class.isAssignableFrom(cls)) {
            Collection collection = (Collection) obj;
            Object newInstance = Array.newInstance(componentType, collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Array.set(newInstance, i, org.mvel2.b.b(it.next(), componentType));
                i++;
            }
            return newInstance;
        }
        if (!obj.getClass().isArray()) {
            Object newInstance2 = Array.newInstance(componentType, 1);
            Array.set(newInstance2, 0, obj);
            return newInstance2;
        }
        int length = Array.getLength(obj);
        Object newInstance3 = Array.newInstance(componentType, length);
        while (i < length) {
            Array.set(newInstance3, i, org.mvel2.b.b(Array.get(obj, i), componentType));
            i++;
        }
        return newInstance3;
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return cls.isArray() || Collection.class.isAssignableFrom(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        return c(obj.getClass(), obj, this.a);
    }
}
