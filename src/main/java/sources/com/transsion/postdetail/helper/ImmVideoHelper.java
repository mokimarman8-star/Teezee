package com.transsion.postdetail.helper;

import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.appcompat.widget.x;
import androidx.core.view.d2;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.b0;
import com.blankj.utilcode.util.a0;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
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
public final class ImmVideoHelper {
    public static final a h = new a(null);
    private static final Lazy i = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.helper.c
        public final Object invoke() {
            ImmVideoHelper m;
            m = ImmVideoHelper.m();
            return m;
        }
    });
    private int b;
    private boolean e;
    private boolean f;
    private boolean g;
    private final List a = new ArrayList();
    private final Map c = new LinkedHashMap();
    private final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.helper.b
        public final Object invoke() {
            b0 v;
            v = ImmVideoHelper.v();
            return v;
        }
    });

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImmVideoHelper a() {
            return (ImmVideoHelper) ImmVideoHelper.i.getValue();
        }
    }

    public ImmVideoHelper() {
        this.e = true;
        this.f = true;
        this.g = true;
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        this.e = bVar.b().getBoolean("k_imm_video_guide", true);
        this.g = bVar.b().getBoolean("k_short_tv_guide", true);
        this.f = bVar.b().getBoolean("k_imm_video_guide_from_trending", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(FragmentActivity fragmentActivity, ImmVideoHelper immVideoHelper) {
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
        immVideoHelper.b = a3;
        a.a.f(wf.a.a, "ImmVideoHelper", "on get navigation gesture height = " + a3, false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImmVideoHelper m() {
        return new ImmVideoHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(List list) {
        String url;
        if (list == null || !(!list.isEmpty()) || (url = ((Video) list.get(0)).getUrl()) == null) {
            return;
        }
        ORPlayerPreloadManager.i.a().j(url, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 v() {
        return new b0();
    }

    public final void f() {
        this.a.clear();
    }

    public final List g() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    public final b0 i() {
        return (b0) this.d.getValue();
    }

    public final Map j() {
        return this.c;
    }

    public final void k(final FragmentActivity fragmentActivity) {
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
            decorView.post(new Runnable() { // from class: com.transsion.postdetail.helper.d
                @Override // java.lang.Runnable
                public final void run() {
                    ImmVideoHelper.l(fragmentActivity, this);
                }
            });
        }
    }

    public final boolean n() {
        return this.e;
    }

    public final boolean o() {
        return this.f;
    }

    public final void p() {
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new ImmVideoHelper$loadCache$1(this, null), 3, (Object) null);
    }

    public final void r(List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new ImmVideoHelper$saveCache$1(list, this, null), 3, (Object) null);
    }

    public final void s(PostSubjectItem postSubjectItem) {
        List video;
        Intrinsics.h(postSubjectItem, "data");
        Media media = postSubjectItem.getMedia();
        if (media == null || (video = media.getVideo()) == null || !(!video.isEmpty())) {
            return;
        }
        f();
        this.a.add(PostSubjectItem.Companion.a(postSubjectItem));
    }

    public final void t() {
        a.a.v(wf.a.a, "ImmVideoPlayer", "-- setVideoGuideShown", false, 4, (Object) null);
        this.e = false;
        com.transsion.baselib.report.launch.b.a.b().putBoolean("k_imm_video_guide", false);
    }

    public final void u() {
        a.a.v(wf.a.a, "ImmVideoPlayer", "-- setVideoGuideShownFromTrending", false, 4, (Object) null);
        this.f = false;
        com.transsion.baselib.report.launch.b.a.b().putBoolean("k_imm_video_guide_from_trending", false);
    }
}
