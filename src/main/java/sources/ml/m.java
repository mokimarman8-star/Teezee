package ml;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class m implements com.transsion.json.o {
    public Object a(com.transsion.json.m mVar, Object obj, Type type, Class cls) {
        if (type == null || !(type instanceof ParameterizedType)) {
            return mVar.l((Map) obj, b(), (Type) null, (Type) null);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type2 = parameterizedType.getActualTypeArguments()[0];
        Type type3 = parameterizedType.getActualTypeArguments()[1];
        Map map = (Map) obj;
        HashMap b = b();
        if (type2 == Object.class) {
            type2 = null;
        }
        return mVar.l(map, b, type2, type3 != Object.class ? type3 : null);
    }

    protected HashMap b() {
        return new HashMap();
    }
}
