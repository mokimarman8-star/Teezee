package com.transsion.shorttv.ui.widget;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    public static final a f = new a(null);
    private final View a;
    private final b b;
    private final Handler c;
    private final Runnable d;
    private final Runnable e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        ur.d a();

        String b();

        boolean c();

        void d();
    }

    public c(View bubbleView, b conditionProvider) {
        Intrinsics.h(bubbleView, "bubbleView");
        Intrinsics.h(conditionProvider, "conditionProvider");
        this.a = bubbleView;
        this.b = conditionProvider;
        this.c = new Handler(Looper.getMainLooper());
        this.d = new Runnable() { // from class: com.transsion.shorttv.ui.widget.a
            @Override // java.lang.Runnable
            public final void run() {
                c.k(c.this);
            }
        };
        this.e = new Runnable() { // from class: com.transsion.shorttv.ui.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                c.g(c.this);
            }
        };
    }

    private final long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (Exception e) {
            a.a.l(wf.a.a, "DownloadGuideBubble", "getAvailableStorageBytes error: " + e.getMessage(), false, 4, (Object) null);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(c cVar) {
        cVar.f();
    }

    private final void j() {
        this.b.d();
        a.a.f(wf.a.a, "DownloadGuideBubble", "showBubble: UI restored, showing bubble", false, 4, (Object) null);
        cr.b.e(this.a);
        this.c.removeCallbacks(this.e);
        this.c.postDelayed(this.e, 6000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(c cVar) {
        cVar.l();
    }

    private final void l() {
        a.a aVar = wf.a.a;
        a.a.f(aVar, "DownloadGuideBubble", "tryShowBubble: checking conditions...", false, 4, (Object) null);
        if (!this.b.c()) {
            a.a.f(aVar, "DownloadGuideBubble", "tryShowBubble: SKIP - not buffering", false, 4, (Object) null);
            return;
        }
        com.transsion.shorttv.utils.h hVar = com.transsion.shorttv.utils.h.a;
        if (!hVar.c()) {
            a.a.f(aVar, "DownloadGuideBubble", "tryShowBubble: SKIP - fatigue control (shown within 3 days)", false, 4, (Object) null);
            return;
        }
        long e = e();
        if (e < 524288000) {
            long j = 1024;
            a.a.f(aVar, "DownloadGuideBubble", "tryShowBubble: SKIP - storage insufficient (" + ((e / j) / j) + "MB < 500MB)", false, 4, (Object) null);
            return;
        }
        String b2 = this.b.b();
        ur.d a2 = this.b.a();
        if ((a2 != null ? a2.f(b2) : null) == null) {
            a.a.f(aVar, "DownloadGuideBubble", "tryShowBubble: ALL conditions met, showing bubble!", false, 4, (Object) null);
            hVar.f();
            j();
        } else {
            a.a.f(aVar, "DownloadGuideBubble", "tryShowBubble: SKIP - video already in download list (resourceId=" + b2 + ")", false, 4, (Object) null);
        }
    }

    public final void c() {
        this.c.removeCallbacksAndMessages(null);
        a.a.f(wf.a.a, "DownloadGuideBubble", "destroy: all callbacks cleared", false, 4, (Object) null);
    }

    public final void d() {
        this.c.removeCallbacks(this.d);
        f();
        a.a.f(wf.a.a, "DownloadGuideBubble", "dismiss: timer cancelled + bubble hidden", false, 4, (Object) null);
    }

    public final void f() {
        this.c.removeCallbacks(this.e);
        if (this.a.getVisibility() == 0) {
            a.a.f(wf.a.a, "DownloadGuideBubble", "hide: bubble hidden", false, 4, (Object) null);
        }
        cr.b.b(this.a);
    }

    public final void h() {
        this.c.removeCallbacks(this.d);
        a.a.f(wf.a.a, "DownloadGuideBubble", "onBufferingEnd: timer cancelled", false, 4, (Object) null);
    }

    public final void i() {
        this.c.removeCallbacks(this.d);
        this.c.postDelayed(this.d, 5000L);
        a.a.f(wf.a.a, "DownloadGuideBubble", "onBufferingStart: timer started (5000ms)", false, 4, (Object) null);
    }
}
