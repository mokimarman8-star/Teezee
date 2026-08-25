package yz;

import java.util.Iterator;
import java.util.List;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class a {
    private static List a;
    private static List b;

    public static boolean a() {
        List list = a;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static boolean b() {
        List list = b;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static void c(Object obj, String str, VariableResolverFactory variableResolverFactory) {
        List list = a;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                throw null;
            }
        }
    }

    public static void d(Object obj, String str, VariableResolverFactory variableResolverFactory, Object obj2) {
        List list = b;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                throw null;
            }
        }
    }
}
