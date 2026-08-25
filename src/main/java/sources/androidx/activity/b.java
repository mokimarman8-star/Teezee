package androidx.activity;

import android.window.BackEvent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final a f94e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final float f95a;

    /* renamed from: b, reason: collision with root package name */
    private final float f96b;

    /* renamed from: c, reason: collision with root package name */
    private final float f97c;

    /* renamed from: d, reason: collision with root package name */
    private final int f98d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(float f5, float f6, float f7, int i5) {
        this.f95a = f5;
        this.f96b = f6;
        this.f97c = f7;
        this.f98d = i5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(BackEvent backEvent) {
        this(r0.c(backEvent), r0.d(backEvent), r0.a(backEvent), r0.b(backEvent));
        Intrinsics.h(backEvent, "backEvent");
        androidx.activity.a aVar = androidx.activity.a.f93a;
    }

    public final float a() {
        return this.f97c;
    }

    public final int b() {
        return this.f98d;
    }

    public final float c() {
        return this.f96b;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f95a + ", touchY=" + this.f96b + ", progress=" + this.f97c + ", swipeEdge=" + this.f98d + '}';
    }
}
