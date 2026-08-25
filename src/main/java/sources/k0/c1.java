package k0;

import android.text.Layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public static final c1 f16024a = new c1();

    /* renamed from: b, reason: collision with root package name */
    private static final Layout.Alignment f16025b;

    /* renamed from: c, reason: collision with root package name */
    private static final Layout.Alignment f16026c;

    static {
        Layout.Alignment[] values = Layout.Alignment.values();
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        Layout.Alignment alignment2 = alignment;
        for (Layout.Alignment alignment3 : values) {
            if (Intrinsics.c(alignment3.name(), "ALIGN_LEFT")) {
                alignment = alignment3;
            } else if (Intrinsics.c(alignment3.name(), "ALIGN_RIGHT")) {
                alignment2 = alignment3;
            }
        }
        f16025b = alignment;
        f16026c = alignment2;
    }

    private c1() {
    }

    public final Layout.Alignment a(int i5) {
        return i5 != 0 ? i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? Layout.Alignment.ALIGN_NORMAL : f16026c : f16025b : Layout.Alignment.ALIGN_CENTER : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
    }
}
