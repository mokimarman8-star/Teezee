package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class v1 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3672b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final ColorFilter f3673a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ v1 b(a aVar, long j5, int i5, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                i5 = c1.f3289a.z();
            }
            return aVar.a(j5, i5);
        }

        public final v1 a(long j5, int i5) {
            return new d1(j5, i5, (DefaultConstructorMarker) null);
        }
    }

    public v1(ColorFilter colorFilter) {
        this.f3673a = colorFilter;
    }

    public final ColorFilter a() {
        return this.f3673a;
    }
}
