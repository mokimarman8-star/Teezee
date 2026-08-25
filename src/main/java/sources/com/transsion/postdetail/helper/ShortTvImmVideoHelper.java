package com.transsion.postdetail.helper;

import android.content.Context;
import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import androidx.appcompat.widget.x;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import androidx.core.view.d2;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.b0;
import com.blankj.utilcode.util.a0;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.postdetail.R$layout;
import com.transsion.shorttv.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvImmVideoHelper {
    public static final a k = new a(null);
    private static final Lazy l = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.helper.f
        public final Object invoke() {
            ShortTvImmVideoHelper r;
            r = ShortTvImmVideoHelper.r();
            return r;
        }
    });
    private int b;
    private boolean e;
    private boolean f;
    private List i;
    private boolean j;
    private final List a = new ArrayList();
    private final Map c = new LinkedHashMap();
    private final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.helper.e
        public final Object invoke() {
            b0 B;
            B = ShortTvImmVideoHelper.B();
            return B;
        }
    });
    private List g = new ArrayList();
    private List h = new ArrayList();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortTvImmVideoHelper a() {
            return (ShortTvImmVideoHelper) ShortTvImmVideoHelper.l.getValue();
        }
    }

    public ShortTvImmVideoHelper() {
        this.e = true;
        this.f = true;
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        this.e = bVar.b().getBoolean("k_imm_video_guide", true);
        this.f = bVar.b().getBoolean("k_short_tv_guide", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 B() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(FragmentActivity fragmentActivity, ShortTvImmVideoHelper shortTvImmVideoHelper) {
        View decorView;
        WindowInsets rootWindowInsets;
        if (fragmentActivity.isFinishing()) {
            return;
        }
        Window window = fragmentActivity.getWindow();
        Insets a2 = (window == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null) ? null : d2.a(rootWindowInsets);
        if (a2 == null || x.a(a2) > a0.a(40.0f)) {
            a.a.f(wf.a.a, "ImmVideoHelper", "is open navigation bar 2", false, 4, (Object) null);
            return;
        }
        int a3 = x.a(a2);
        shortTvImmVideoHelper.b = a3;
        a.a.f(wf.a.a, "ImmVideoHelper", "on get navigation gesture height = " + a3, false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTvImmVideoHelper r() {
        return new ShortTvImmVideoHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(Video video) {
        String url;
        if (video == null || (url = video.getUrl()) == null) {
            return;
        }
        ORPlayerPreloadManager.i.a().j(url, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ShortTvImmVideoHelper shortTvImmVideoHelper, View view, int i, ViewGroup viewGroup) {
        Intrinsics.h(view, "view");
        a.a.f(wf.a.a, "ShortTvImmVideoPlayer", "for you preloadItemViews completion, " + view, false, 4, (Object) null);
        if (shortTvImmVideoHelper.j) {
            return;
        }
        shortTvImmVideoHelper.g.add(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(ShortTvImmVideoHelper shortTvImmVideoHelper, View view, int i, ViewGroup viewGroup) {
        Intrinsics.h(view, "view");
        a.a.f(wf.a.a, "ShortTvImmVideoPlayer", "detail preloadItemViews completion, " + view, false, 4, (Object) null);
        if (shortTvImmVideoHelper.j) {
            return;
        }
        shortTvImmVideoHelper.h.add(view);
    }

    public final void A() {
        a.a.v(wf.a.a, "ImmVideoPlayer", "-- setVideoGuideShown", false, 4, (Object) null);
        this.e = false;
        com.transsion.baselib.report.launch.b.a.b().putBoolean("k_imm_video_guide", false);
    }

    public final void j() {
        this.a.clear();
    }

    public final List k() {
        return this.a;
    }

    public final List l() {
        return this.g;
    }

    public final int m() {
        return this.b;
    }

    public final b0 n() {
        return (b0) this.d.getValue();
    }

    public final Map o() {
        return this.c;
    }

    public final void p(final FragmentActivity fragmentActivity) {
        Intrinsics.h(fragmentActivity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            this.b = 0;
            return;
        }
        if (com.blankj.utilcode.util.d.a() > 50) {
            a.a.f(wf.a.a, "ImmVideoHelper", "is open navigation bar", false, 4, (Object) null);
            this.b = 0;
            return;
        }
        Window window = fragmentActivity.getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView != null) {
            decorView.post(new Runnable() { // from class: com.transsion.postdetail.helper.g
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTvImmVideoHelper.q(fragmentActivity, this);
                }
            });
        }
    }

    public final boolean s() {
        return this.e;
    }

    public final void t() {
        List list = (List) n().f();
        if ((list != null ? list.size() : 0) > 0) {
            return;
        }
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new ShortTvImmVideoHelper$loadCache$1(this, null), 3, (Object) null);
    }

    public final void v(Context context) {
        Intrinsics.h(context, "context");
        this.j = false;
        for (int i = 0; i < 2; i++) {
            new AsyncLayoutInflater(context).a(R$layout.item_short_tv_immersion_video, (ViewGroup) null, new AsyncLayoutInflater.d() { // from class: com.transsion.postdetail.helper.h
                public final void a(View view, int i2, ViewGroup viewGroup) {
                    ShortTvImmVideoHelper.w(ShortTvImmVideoHelper.this, view, i2, viewGroup);
                }
            });
        }
        for (int i2 = 0; i2 < 2; i2++) {
            new AsyncLayoutInflater(context).a(R.layout.short_tv_item_video, (ViewGroup) null, new AsyncLayoutInflater.d() { // from class: com.transsion.postdetail.helper.i
                public final void a(View view, int i3, ViewGroup viewGroup) {
                    ShortTvImmVideoHelper.x(ShortTvImmVideoHelper.this, view, i3, viewGroup);
                }
            });
        }
    }

    public final void y() {
        this.j = true;
        this.g.clear();
        this.h.clear();
    }

    public final void z(List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty() || Intrinsics.c(list, n().f())) {
            return;
        }
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new ShortTvImmVideoHelper$saveCache$1(list, this, null), 3, (Object) null);
    }
}
