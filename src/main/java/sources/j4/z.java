package j4;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface z {

    public static final class a {
        public static void a(z zVar, String str, Set set) {
            Intrinsics.h(str, "id");
            Intrinsics.h(set, "tags");
            Iterator it = set.iterator();
            while (it.hasNext()) {
                zVar.a(new y((String) it.next(), str));
            }
        }
    }

    void a(y yVar);

    List b(String str);

    void c(String str);

    void d(String str, Set set);
}
