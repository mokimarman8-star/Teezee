package com.transsnet.downloader.manager;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import ci.b;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsnet.downloader.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uf.c;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class u {
    public static final a c = new a(null);
    private boolean a;
    private boolean b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public u() {
        this.a = true;
        this.a = b.a.c();
    }

    private final View c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_downloading_play_guide, (ViewGroup) null);
        Intrinsics.g(inflate, "inflate(...)");
        return inflate;
    }

    private final void e(FrameLayout frameLayout, View view) {
        int a2 = a0.a(106.0f);
        int a3 = a0.a(16.0f);
        Context context = view.getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
        final View c2 = c((Activity) context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a0.a(230.0f), -2);
        layoutParams.topMargin = a2;
        layoutParams.setMarginStart(a3);
        frameLayout.addView(c2, layoutParams);
        c2.postDelayed(new Runnable() { // from class: com.transsnet.downloader.manager.s
            @Override // java.lang.Runnable
            public final void run() {
                u.f(c2);
            }
        }, 3000L);
        c2.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.manager.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                u.g(c2, view2);
            }
        });
        this.a = false;
        b.a.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view) {
        if (view.getParent() != null) {
            ViewParent parent = view.getParent();
            Intrinsics.f(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View view, View view2) {
        if (view.getParent() != null) {
            ViewParent parent = view.getParent();
            Intrinsics.f(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(view);
        }
    }

    public final void d(FrameLayout fragmentRootView, BaseViewHolder holder, long j) {
        View viewOrNull;
        Intrinsics.h(fragmentRootView, "fragmentRootView");
        Intrinsics.h(holder, "holder");
        if (this.a && !this.b && (viewOrNull = holder.getViewOrNull(R.id.iv_cover)) != null && c.i(viewOrNull)) {
            this.b = true;
            e(fragmentRootView, viewOrNull);
        }
    }
}
