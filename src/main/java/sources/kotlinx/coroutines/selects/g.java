package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.internal.z;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class g {
    private static final Function3 a = a.a;
    private static final z b = new z("STATE_REG");
    private static final z c = new z("STATE_COMPLETED");
    private static final z d = new z("STATE_CANCELLED");
    private static final z e = new z("NO_RESULT");
    private static final z f = new z("PARAM_CLAUSE_0");

    static final class a implements Function3 {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj, Object obj2, Object obj3) {
            return null;
        }
    }
}
