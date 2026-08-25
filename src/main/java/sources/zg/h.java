package zg;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.tn.lib.widget.R;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class h {
    public static final h a = new h();

    private h() {
    }

    public final int a(Context context, float f) {
        Intrinsics.h(context, "context");
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final Pair b() {
        float e = (y.e() - a0.a(40.0f)) / 3.0f;
        return new Pair(Integer.valueOf((int) e), Integer.valueOf((int) ((153.0f * e) / 107.0f)));
    }

    public final int c(Context context) {
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Point point = new Point();
        ((WindowManager) systemService).getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public final int d(Context context) {
        Intrinsics.h(context, "context");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            identifier = R.dimen.default_status_bar_height;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public final int e(Context context) {
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Point point = new Point();
        ((WindowManager) systemService).getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    public final boolean f() {
        return ((double) (((float) a0.a(120.0f)) / ((float) y.e()))) >= 0.35d;
    }
}
