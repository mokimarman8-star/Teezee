package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface f {

    public static final class a {
        public static List a(f fVar) {
            return CollectionsKt.l();
        }

        public static boolean b(f fVar) {
            return false;
        }

        public static boolean c(f fVar) {
            return false;
        }
    }

    boolean b();

    int c(String str);

    h d();

    int e();

    String f(int i);

    List g(int i);

    List getAnnotations();

    f h(int i);

    String i();

    boolean isInline();

    boolean j(int i);
}
