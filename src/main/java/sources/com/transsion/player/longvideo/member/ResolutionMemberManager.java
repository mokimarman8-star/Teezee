package com.transsion.player.longvideo.member;

import android.app.Application;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.ps.activate.PSActivateManager;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.member.MemberResolutionDao;
import com.transsion.memberapi.MemberSource;
import com.transsion.wrapperad.activate.ui.LongVodActivateDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ResolutionMemberManager {
    public static final ResolutionMemberManager a = new ResolutionMemberManager();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.member.l
        public final Object invoke() {
            MemberResolutionDao h;
            h = ResolutionMemberManager.h();
            return h;
        }
    });

    private ResolutionMemberManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d() {
        String simpleName = ResolutionMemberManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MemberResolutionDao e() {
        return (MemberResolutionDao) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MemberResolutionDao h() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return appDatabase$f1.b(a2).r1();
    }

    public final Object f(ln.a aVar, Continuation continuation) {
        return aVar == null ? Boxing.a(false) : kotlinx.coroutines.i.g(y0.b(), new ResolutionMemberManager$isUnlock$2(aVar, null), continuation);
    }

    public final Object g(ln.a aVar, Continuation continuation) {
        return kotlinx.coroutines.i.g(y0.b(), new ResolutionMemberManager$isVipResolutionTip$2(aVar, null), continuation);
    }

    public final void i(FragmentManager fragmentManager, MemberSource memberSource, final ln.a aVar, String str, final nw.e eVar) {
        Intrinsics.h(fragmentManager, "fragmentManager");
        Intrinsics.h(memberSource, "from");
        if (mw.a.a.k(memberSource)) {
            a.a.g(wf.a.a, d() + " --> showRewardDialog() --> 解锁高清视频播放权限开关关闭 --> from = " + memberSource, false, 2, (Object) null);
            return;
        }
        if (PSActivateManager.a.d()) {
            LongVodActivateDialog longVodActivateDialog = new LongVodActivateDialog();
            longVodActivateDialog.v0(new nw.e() { // from class: com.transsion.player.longvideo.member.ResolutionMemberManager$showRewardDialog$1$1
                public void a(boolean z) {
                    kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new ResolutionMemberManager$showRewardDialog$1$1$onActivate$1(z, ln.a.this, eVar, null), 3, (Object) null);
                }
            });
            longVodActivateDialog.r0(memberSource, str);
            longVodActivateDialog.show(fragmentManager, "解锁高清视频播放权限");
            return;
        }
        a.a.g(wf.a.a, d() + " --> showRewardDialog() --> 没有激励广告，无法解锁高清视频播放权限 --> from = " + memberSource, false, 2, (Object) null);
        if (eVar != null) {
            eVar.a(false);
        }
    }

    public final Object j(ln.a aVar, Continuation continuation) {
        Object g;
        return (aVar != null && (g = kotlinx.coroutines.i.g(y0.b(), new ResolutionMemberManager$unlock$2(aVar, null), continuation)) == IntrinsicsKt.f()) ? g : Unit.a;
    }

    public final Object k(ln.a aVar, Continuation continuation) {
        Object g;
        return (aVar != null && (g = kotlinx.coroutines.i.g(y0.b(), new ResolutionMemberManager$updateVipResolutionTip$2(aVar, null), continuation)) == IntrinsicsKt.f()) ? g : Unit.a;
    }
}
