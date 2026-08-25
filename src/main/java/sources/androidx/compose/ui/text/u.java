package androidx.compose.ui.text;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    public static final a f5442c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final u f5443d = new u();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f5444a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5445b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public u() {
        this(e.f5088b.b(), false, null);
    }

    private u(int i5, boolean z5) {
        this.f5444a = z5;
        this.f5445b = i5;
    }

    public /* synthetic */ u(int i5, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, z5);
    }

    public u(boolean z5) {
        this.f5444a = z5;
        this.f5445b = e.f5088b.b();
    }

    public final int a() {
        return this.f5445b;
    }

    public final boolean b() {
        return this.f5444a;
    }

    public final u c(u uVar) {
        return uVar == null ? this : uVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f5444a == uVar.f5444a && e.g(this.f5445b, uVar.f5445b);
    }

    public int hashCode() {
        return (androidx.compose.foundation.e.a(this.f5444a) * 31) + e.h(this.f5445b);
    }

    public String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.f5444a + ", emojiSupportMatch=" + ((Object) e.i(this.f5445b)) + ')';
    }
}
