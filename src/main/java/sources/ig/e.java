package ig;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class e {
    public static final e a = new e();
    private static final ArrayList b = new ArrayList();

    private e() {
    }

    public final void a(Interceptor interceptor) {
        Intrinsics.h(interceptor, "interceptor");
        ArrayList arrayList = b;
        if (!arrayList.contains(interceptor)) {
            arrayList.add(interceptor);
            return;
        }
        a.C0158a.x(wf.a.a, "InterceptorsManager", "add dump interceptor " + interceptor, false, 4, null);
    }

    public final ArrayList b() {
        return b;
    }
}
