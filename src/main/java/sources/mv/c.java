package mv;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    public static final a a = new a(null);
    private static final Lazy b = LazyKt.b(new Function0() { // from class: mv.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a b2;
            b2 = c.b();
            return b2;
        }
    });

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final mv.a b() {
        return (mv.a) kg.c.e.a().h(mv.a.class);
    }
}
