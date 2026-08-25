package eg;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    public static final C0141a a = new C0141a(null);

    /* renamed from: eg.a$a, reason: collision with other inner class name */
    public static final class C0141a {
        private C0141a() {
        }

        public /* synthetic */ C0141a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str) {
            Intrinsics.h(str, "token");
            return "Bearer " + str;
        }
    }
}
