package androidx.compose.ui.platform;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i implements h {

    /* renamed from: b, reason: collision with root package name */
    private static final a f4797b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f4798c = 8;

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityManager f4799a;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public i(Context context) {
        Object systemService = context.getSystemService("accessibility");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.f4799a = (AccessibilityManager) systemService;
    }
}
