package com.transsion.ninegridview;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.recyclerview.widget.RecyclerView;
import com.aliyun.player.bean.ErrorCode;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.player.config.RenderType;
import com.transsion.player.orplayer.f;
import com.transsion.player.p003enum.ScaleMode;
import com.transsion.player.ui.ORPlayerView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vm.d;
import wf.a;
import yg.l;
import yg.m;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements d {
    public static final C0042a h = new C0042a(null);
    private static final hn.d i = new hn.d(RenderType.TEXTURE_VIEW, false, 0, 1000, 1000, 200, 10, 0, 0, 0, 0, false, false, false, false, false, null, 130950, null);
    private f a;
    private wm.a b;
    private vm.c c;
    private m d;
    private boolean e;
    private vm.a f;
    private Context g;

    /* renamed from: com.transsion.ninegridview.a$a, reason: collision with other inner class name */
    public static final class C0042a {
        private C0042a() {
        }

        public /* synthetic */ C0042a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final hn.d a() {
            return a.i;
        }
    }

    public static final class b implements m {
        b() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            vm.a aVar = a.this.f;
            if (aVar != null) {
                int a = aVar.a();
                a aVar2 = a.this;
                if (aVar2.e && a == ErrorCode.ERROR_LOADING_TIMEOUT.getValue()) {
                    wm.a g = aVar2.g();
                    if (g != null) {
                        g.w();
                    }
                    aVar2.e = false;
                }
            }
        }

        public void onDisconnected() {
            a.this.e = true;
        }
    }

    @Override // vm.d
    public void a() {
        Context context = this.g;
        if (context != null) {
            j(context);
        }
    }

    public final void f() {
        f fVar = this.a;
        if (fVar != null) {
            fVar.release();
        }
        this.a = null;
        wm.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
        this.b = null;
        vm.c cVar = this.c;
        if (cVar != null) {
            cVar.e();
        }
        this.c = null;
        l.a.m(this.d);
        this.d = null;
    }

    public final wm.a g() {
        return this.b;
    }

    public final void h() {
        if (this.c == null) {
            this.c = new vm.c();
        }
        vm.c cVar = this.c;
        if (cVar != null) {
            cVar.e();
        }
    }

    public final void i() {
        if (this.d == null) {
            b bVar = new b();
            this.d = bVar;
            l.a.l(bVar);
        }
    }

    public final void j(Context context) {
        Intrinsics.h(context, "context");
        if (this.a == null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            ORPlayerView oRPlayerView = new ORPlayerView(applicationContext, RenderType.TEXTURE_VIEW);
            Context applicationContext2 = context.getApplicationContext();
            Intrinsics.g(applicationContext2, "getApplicationContext(...)");
            f a = new f.a(applicationContext2).a();
            a.setPlayerConfig(i);
            a.setTextureView(oRPlayerView.getTextureView());
            a.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
            a.setMute(true);
            this.b = new wm.a(a, oRPlayerView);
            vm.a aVar = new vm.a();
            aVar.b(this.b);
            a.setPlayerListener(aVar);
            this.f = aVar;
            this.a = a;
            vm.c cVar = this.c;
            if (cVar != null) {
                cVar.k(this.b);
            }
            i();
            a.a.f(wf.a.a, "GifPlayerManager", "initPlayer", false, 4, (Object) null);
        }
    }

    public final void k() {
        f fVar = this.a;
        if (fVar != null) {
            fVar.pause();
        }
    }

    public final void l() {
        f fVar = this.a;
        if (fVar != null) {
            fVar.play();
        }
    }

    public final void m() {
        wm.a aVar = this.b;
        if (aVar != null) {
            aVar.x(-1);
        }
    }

    public final void n(RecyclerView recyclerView, BaseQuickAdapter baseQuickAdapter) {
        Intrinsics.h(recyclerView, "recyclerView");
        this.g = recyclerView.getContext();
        h();
        vm.c cVar = this.c;
        if (cVar != null) {
            cVar.j(baseQuickAdapter);
            recyclerView.addOnScrollListener(cVar);
        }
        vm.c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.l(this);
        }
    }
}
