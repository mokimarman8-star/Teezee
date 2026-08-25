package tu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class d {
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a5, code lost:
    
        if (r4.getInteger(r6) == 2) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Window window, Context context) {
        int i;
        Intrinsics.h(window, "window");
        Intrinsics.h(context, "context");
        window.setBackgroundDrawableResource(R.color.transparent);
        Intrinsics.h(context, "context");
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * 16.0f) + 0.5f);
        Object systemService = context.getSystemService("window");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels - (i2 * 2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i3;
        attributes.height = -2;
        attributes.gravity = 81;
        Intrinsics.h(context, "context");
        int i4 = (int) ((context.getResources().getDisplayMetrics().density * 28.0f) + 0.5f);
        Intrinsics.h(context, "context");
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
        if (dimensionPixelSize <= 0 || (i = i4 - dimensionPixelSize) <= 0) {
            Intrinsics.h(context, "context");
            int i5 = (int) ((context.getResources().getDisplayMetrics().density * 16.0f) + 0.5f);
            Intrinsics.h(context, "context");
            try {
                Resources resources2 = context.getResources();
                int identifier2 = resources2.getIdentifier("config_navBarInteractionMode", "integer", "android");
                if (identifier2 > 0) {
                }
            } catch (Exception unused) {
            }
            i4 = i5;
        } else {
            i4 = i;
        }
        attributes.y = i4;
        Intrinsics.h(context, "context");
        attributes.dimAmount = (context.getResources().getConfiguration().uiMode & 48) == 32 ? 0.65f : 0.2f;
        window.addFlags(2);
        window.setAttributes(attributes);
    }
}
