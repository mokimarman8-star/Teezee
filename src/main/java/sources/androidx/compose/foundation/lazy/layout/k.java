package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2055a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final int f2056b = 8;

    /* renamed from: c, reason: collision with root package name */
    private static final long f2057c = o0.q.a(DescriptorProtos$Edition.EDITION_MAX_VALUE, DescriptorProtos$Edition.EDITION_MAX_VALUE);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return k.f2057c;
        }
    }

    public abstract void b(long j5, boolean z5);

    public abstract void c();

    public abstract long d();

    public abstract GraphicsLayer e();

    public abstract long f();

    public abstract long g();

    public abstract long h();

    public abstract boolean i();

    public abstract void j();

    public abstract void k(long j5);

    public abstract void l(long j5);

    public abstract void m(long j5);
}
