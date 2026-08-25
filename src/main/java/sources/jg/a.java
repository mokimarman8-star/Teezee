package jg;

import com.tn.lib.net.cons.HeaderType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    public static final C0146a a = new C0146a(null);

    /* renamed from: jg.a$a, reason: collision with other inner class name */
    public static final class C0146a {
        private C0146a() {
        }

        public /* synthetic */ C0146a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Interceptor a() {
            ag.b b = ag.a.a.b();
            return (b != null ? b.a() : null) == HeaderType.ONE_ROOM ? new c() : new c();
        }
    }
}
