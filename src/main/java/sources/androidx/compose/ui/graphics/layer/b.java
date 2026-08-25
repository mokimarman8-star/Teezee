package androidx.compose.ui.graphics.layer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3509a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f3510b = d(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f3511c = d(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f3512d = d(2);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return b.f3510b;
        }

        public final int b() {
            return b.f3512d;
        }

        public final int c() {
            return b.f3511c;
        }
    }

    public static int d(int i5) {
        return i5;
    }

    public static final boolean e(int i5, int i6) {
        return i5 == i6;
    }
}
