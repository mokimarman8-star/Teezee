package com.transsion.postdetail.shorttv.factory;

import android.os.Build;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.postdetail.util.ShortTVFloatManager;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsion.videofloat.manager.a0;
import cw.b;
import cw.e;
import gw.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements ur.g {

    public static final class a implements gw.a {
        a() {
        }

        public boolean a(dw.a aVar) {
            return ShortTVFloatManager.b.r(aVar);
        }

        public void b(dw.a aVar) {
            ShortTVFloatManager shortTVFloatManager = ShortTVFloatManager.b;
            shortTVFloatManager.o();
            shortTVFloatManager.t(aVar);
        }

        public void c(dw.a aVar) {
            a.a.a(this, aVar);
            ShortTVFloatManager.b.p(aVar);
        }
    }

    private final dw.a j(nr.j jVar) {
        dw.a aVar = new dw.a(jVar.g(), jVar.c(), (ViewGroup) null, FloatPlayType.SHORT_TV, jVar.i(), jVar.h(), jVar.a(), BuildConfig.FLAVOR, jVar.e());
        aVar.J(Integer.valueOf(SubjectType.SHORT_TV.getValue()));
        aVar.A(jVar.b());
        aVar.B(jVar.d());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(FragmentActivity fragmentActivity, boolean z) {
        if (z) {
            fragmentActivity.finish();
        }
        return Unit.a;
    }

    @Override // ur.g
    public void a(FragmentActivity fragmentActivity, boolean z, boolean z2, ViewGroup viewGroup) {
        Intrinsics.h(fragmentActivity, "activity");
        e.a aVar = cw.e.a;
        if (aVar.b().c() && com.transsion.baselib.report.launch.b.a.b().getBoolean("k_pip_enable", true)) {
            aVar.b().a(fragmentActivity, true, z2, viewGroup);
        }
    }

    @Override // ur.g
    public void b(FragmentActivity fragmentActivity, String str, String str2, String str3) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(str, "subjectId");
        Intrinsics.h(str2, "pageName");
        cw.b.a.c().f(fragmentActivity, str, (String) null, str2, str3);
    }

    @Override // ur.g
    public void c() {
        b.b.a(cw.b.a.c(), false, 1, (Object) null);
    }

    @Override // ur.g
    public com.transsion.player.orplayer.f d(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return a0.a.b(ShortTVFloatManager.b.k(str));
    }

    @Override // ur.g
    public boolean e(com.transsion.player.orplayer.f fVar) {
        return a0.a.c(fVar);
    }

    @Override // ur.g
    public boolean f(com.transsion.player.orplayer.f fVar) {
        return cw.c.a.c(fVar);
    }

    @Override // ur.g
    public void g(boolean z, FragmentActivity fragmentActivity, nr.j jVar) {
        Intrinsics.h(jVar, "bean");
        if (z) {
            if (fragmentActivity == null || fragmentActivity.isDestroyed() || fragmentActivity.isFinishing()) {
                return;
            }
            dw.a j = j(jVar);
            if (Build.VERSION.SDK_INT >= 31) {
                cw.e.a.b().h(fragmentActivity, j);
            }
        }
        cw.e.a.b().onPipModeChanged(z);
    }

    @Override // ur.g
    public void h(final FragmentActivity fragmentActivity, nr.j jVar) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(jVar, "bean");
        dw.a j = j(jVar);
        if (!com.transsion.baselib.report.launch.b.a.b().getBoolean("k_pip_enable", true)) {
            wf.a.a.c("VideoFloat", "shottv 设置页pip开关被关闭了", true);
            return;
        }
        e.a aVar = cw.e.a;
        if (aVar.b().c()) {
            wf.a.a.c("VideoFloat-pip", "shottv 当前可用画中画，使用画中画播放", true);
            aVar.b().d(fragmentActivity, j, FloatActionType.HOME, false);
        } else {
            ShortTVFloatManager.b.w(jVar.f());
            cw.b.a.c().e(fragmentActivity, j, false, false, new Function1() { // from class: com.transsion.postdetail.shorttv.factory.f
                public final Object invoke(Object obj) {
                    Unit k;
                    k = g.k(fragmentActivity, ((Boolean) obj).booleanValue());
                    return k;
                }
            }, new a());
        }
    }
}
