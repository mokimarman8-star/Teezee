package ml;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class b implements com.transsion.json.o {
    public Object a(com.transsion.json.m mVar, Object obj, Type type, Class cls) {
        try {
            return mVar.k((Map) obj, b(cls), type);
        } catch (IllegalAccessException e) {
            throw new com.transsion.json.k(mVar.d() + ":There was an exception trying to instantiate an instance of " + cls.getName(), e);
        } catch (InstantiationException e2) {
            throw new com.transsion.json.k(mVar.d() + ":There was an exception trying to instantiate an instance of " + cls.getName(), e2);
        } catch (NoSuchMethodException e3) {
            throw new com.transsion.json.k(mVar.d() + ": " + cls.getName() + " lacks a no argument constructor.  com.zero.json will instantiate any protected, private, or public no-arg constructor.", e3);
        } catch (InvocationTargetException e4) {
            throw new com.transsion.json.k(mVar.d() + ":There was an exception trying to instantiate an instance of " + cls.getName(), e4);
        }
    }

    protected Object b(Class cls) {
        Constructor declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(null);
    }
}
