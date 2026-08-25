package androidx.window.layout;

import android.graphics.Point;
import android.view.Display;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f13807a = new f();

    private f() {
    }

    public final void a(Display display, Point point) {
        Intrinsics.h(display, "display");
        Intrinsics.h(point, "point");
        display.getRealSize(point);
    }
}
