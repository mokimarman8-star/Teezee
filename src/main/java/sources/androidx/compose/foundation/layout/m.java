package androidx.compose.foundation.layout;

import androidx.compose.ui.b;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1858a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final m f1859b = a.f1862e;

    /* renamed from: c, reason: collision with root package name */
    private static final m f1860c = e.f1865e;

    /* renamed from: d, reason: collision with root package name */
    private static final m f1861d = c.f1863e;

    private static final class a extends m {

        /* renamed from: e, reason: collision with root package name */
        public static final a f1862e = new a();

        private a() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.m
        public int a(int i5, LayoutDirection layoutDirection, androidx.compose.ui.layout.g0 g0Var, int i6) {
            return i5 / 2;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final m a(b.InterfaceC0025b interfaceC0025b) {
            return new d(interfaceC0025b);
        }
    }

    private static final class c extends m {

        /* renamed from: e, reason: collision with root package name */
        public static final c f1863e = new c();

        private c() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.m
        public int a(int i5, LayoutDirection layoutDirection, androidx.compose.ui.layout.g0 g0Var, int i6) {
            if (layoutDirection == LayoutDirection.Ltr) {
                return i5;
            }
            return 0;
        }
    }

    private static final class d extends m {

        /* renamed from: e, reason: collision with root package name */
        private final b.InterfaceC0025b f1864e;

        public d(b.InterfaceC0025b interfaceC0025b) {
            super(null);
            this.f1864e = interfaceC0025b;
        }

        @Override // androidx.compose.foundation.layout.m
        public int a(int i5, LayoutDirection layoutDirection, androidx.compose.ui.layout.g0 g0Var, int i6) {
            return this.f1864e.a(0, i5, layoutDirection);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Intrinsics.c(this.f1864e, ((d) obj).f1864e);
        }

        public int hashCode() {
            return this.f1864e.hashCode();
        }

        public String toString() {
            return "HorizontalCrossAxisAlignment(horizontal=" + this.f1864e + ')';
        }
    }

    private static final class e extends m {

        /* renamed from: e, reason: collision with root package name */
        public static final e f1865e = new e();

        private e() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.m
        public int a(int i5, LayoutDirection layoutDirection, androidx.compose.ui.layout.g0 g0Var, int i6) {
            if (layoutDirection == LayoutDirection.Ltr) {
                return 0;
            }
            return i5;
        }
    }

    private m() {
    }

    public /* synthetic */ m(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int a(int i5, LayoutDirection layoutDirection, androidx.compose.ui.layout.g0 g0Var, int i6);

    public Integer b(androidx.compose.ui.layout.g0 g0Var) {
        return null;
    }

    public boolean c() {
        return false;
    }
}
