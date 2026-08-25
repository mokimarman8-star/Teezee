package p1;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map f16867a = new LinkedHashMap();

    /* renamed from: p1.a$a, reason: collision with other inner class name */
    public static final class C0164a extends a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0164a f16868b = new C0164a();

        private C0164a() {
        }

        @Override // p1.a
        public Object a(b bVar) {
            Intrinsics.h(bVar, "key");
            return null;
        }
    }

    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.f16867a;
    }
}
