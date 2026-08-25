package com.transsion.room.helper;

import android.R;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.transsion.room.R$layout;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n {
    public static final n a = new n();

    private n() {
    }

    private final ObjectAnimator b(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -lj.a.b(12));
        ofFloat.setDuration(500L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        Intrinsics.g(ofFloat, "apply(...)");
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ObjectAnimator objectAnimator, FrameLayout frameLayout, View view) {
        try {
            Result.Companion companion = Result.Companion;
            objectAnimator.cancel();
            frameLayout.removeView(view);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public final void c(Activity activity) {
        Intrinsics.h(activity, "activity");
        final FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content);
        final View inflate = LayoutInflater.from(activity).inflate(R$layout.layout_room_tab_refresh, (ViewGroup) null);
        Intrinsics.e(inflate);
        final ObjectAnimator b = b(inflate);
        b.start();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = lj.a.b(80);
        frameLayout.addView(inflate, layoutParams);
        qi.h.a.z("room_home", MapsKt.m(new Pair[]{TuplesKt.a("opt_type", "refresh_float")}));
        frameLayout.postDelayed(new Runnable() { // from class: com.transsion.room.helper.m
            @Override // java.lang.Runnable
            public final void run() {
                n.d(b, frameLayout, inflate);
            }
        }, 3000L);
    }
}
