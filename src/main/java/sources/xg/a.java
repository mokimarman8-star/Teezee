package xg;

import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    public static final C0163a a = new C0163a(null);

    /* renamed from: xg.a$a, reason: collision with other inner class name */
    public static final class C0163a {
        private C0163a() {
        }

        public /* synthetic */ C0163a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MMKV a() {
            MMKV J = MMKV.J("vshow", 2);
            Intrinsics.g(J, "mmkvWithID(...)");
            return J;
        }
    }
}
