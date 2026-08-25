package com.cloud.tmc.miniapp.defaultimpl;

import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.cloud.tmc.integration.proxy.OnKeyboardListener;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO extends WindowInsetsAnimationCompat.Callback {
    public final int OooO00o;
    public final int OooO0O0;
    public final OnKeyboardListener OooO0OO;

    public OooO(int i, int i2, OnKeyboardListener onKeyboardListener) {
        super(0);
        this.OooO00o = i;
        this.OooO0O0 = i2;
        this.OooO0OO = onKeyboardListener;
        if ((i & i2) != 0) {
            throw new IllegalArgumentException("persistentInsetTypes and deferredInsetTypes can not contain any of  same WindowInsetsCompat.Type values");
        }
    }

    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        Intrinsics.h(windowInsetsAnimationCompat, "animation");
        OnKeyboardListener onKeyboardListener = this.OooO0OO;
        if (onKeyboardListener != null) {
            onKeyboardListener.onKeyBoardAnimEnd();
        }
    }

    public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
        Intrinsics.h(windowInsetsCompat, "insets");
        Intrinsics.h(list, "runningAnims");
        z0.c insets = windowInsetsCompat.getInsets(this.OooO0O0);
        Intrinsics.g(insets, "insets.getInsets(deferredInsetTypes)");
        z0.c insets2 = windowInsetsCompat.getInsets(this.OooO00o);
        Intrinsics.g(insets2, "insets.getInsets(persistentInsetTypes)");
        z0.c a = z0.c.a(z0.c.e(insets, insets2), z0.c.e);
        Intrinsics.g(a, "subtract(typesInset, oth…t, Insets.NONE)\n        }");
        OnKeyboardListener onKeyboardListener = this.OooO0OO;
        if (onKeyboardListener != null) {
            onKeyboardListener.onKeyBoardHeightChange(a.d);
        }
        return windowInsetsCompat;
    }

    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        Intrinsics.h(windowInsetsAnimationCompat, "animation");
        Intrinsics.h(boundsCompat, "bounds");
        OnKeyboardListener onKeyboardListener = this.OooO0OO;
        if (onKeyboardListener != null) {
            onKeyboardListener.onKeyBoardAnimStart();
        }
        WindowInsetsAnimationCompat.BoundsCompat onStart = super.onStart(windowInsetsAnimationCompat, boundsCompat);
        Intrinsics.g(onStart, "super.onStart(animation, bounds)");
        return onStart;
    }
}
