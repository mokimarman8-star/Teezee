package com.transsion.commercialization.task;

import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.monopoly.manager.AdSceneAssetsManager;
import com.transsion.commercialization.R$string;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.OpType;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class DownloadInterceptAdHelper {
    private final wj.g a;
    private final MemberCheckResult b;
    private final String c;
    private final boolean d;
    private BiddingNativeManager e;
    private OpType f;
    private AdInterceptDialog g;

    public DownloadInterceptAdHelper(wj.g gVar, MemberCheckResult memberCheckResult, String str, boolean z) {
        this.a = gVar;
        this.b = memberCheckResult;
        this.c = str;
        this.d = z;
        this.f = OpType.OP_AD;
    }

    public /* synthetic */ DownloadInterceptAdHelper(wj.g gVar, MemberCheckResult memberCheckResult, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, (i & 2) != 0 ? null : memberCheckResult, (i & 4) != 0 ? null : str, (i & 8) != 0 ? false : z);
    }

    private final void i() {
        wj.g gVar = this.a;
        if (gVar != null) {
            gVar.a(false);
        }
        BiddingNativeManager biddingNativeManager = this.e;
        if (biddingNativeManager != null) {
            biddingNativeManager.U();
        }
        this.g = null;
    }

    private final String j(MemberCheckResult memberCheckResult) {
        return (memberCheckResult != null ? memberCheckResult.getMemberPrice() : null) + " " + (memberCheckResult != null ? memberCheckResult.getCurrency() : null) + " ";
    }

    private final void k() {
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new DownloadInterceptAdHelper$loadNativeAd$1(this, null), 3, (Object) null);
    }

    private final void l() {
        com.transsion.commercialization.pslink.a.a.b(AdSceneAssetsManager.b.getClassTag() + " --> showAdInterceptDialog() --> 广告任务 未完成 --> 结束流程");
        fh.b.a.e(Utils.a().getString(R$string.co_cancel_tips));
        wj.g gVar = this.a;
        if (gVar != null) {
            gVar.onFail();
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        com.transsion.commercialization.pslink.a.a.a(AdSceneAssetsManager.b.getClassTag() + " --> showAdInterceptDialog() --> 广告任务完成 --> 继续执行下载任务 --> 结束流程");
        wj.g gVar = this.a;
        if (gVar != null) {
            gVar.onSuccess();
        }
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.n(this.f, new Function1() { // from class: com.transsion.commercialization.task.f
                public final Object invoke(Object obj) {
                    Unit n;
                    n = DownloadInterceptAdHelper.n(DownloadInterceptAdHelper.this, obj);
                    return n;
                }
            });
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(DownloadInterceptAdHelper downloadInterceptAdHelper, Object obj) {
        com.transsion.commercialization.pslink.a.a.a(AdSceneAssetsManager.b.getClassTag() + " --> checkMember() --> uploadOperationStat --> " + downloadInterceptAdHelper.f + " --> success");
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(DownloadInterceptAdHelper downloadInterceptAdHelper, int i) {
        if (i == 1) {
            downloadInterceptAdHelper.l();
        } else if (i == 2) {
            downloadInterceptAdHelper.m();
        }
        return Unit.a;
    }

    public final void h() {
        k();
    }

    public final void o(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        MemberCheckResult memberCheckResult = this.b;
        String interceptType = memberCheckResult != null ? memberCheckResult.getInterceptType() : null;
        OpType opType = OpType.OP_INSTALL;
        if (!Intrinsics.c(interceptType, opType.getValue())) {
            opType = OpType.OP_AD;
            Intrinsics.c(interceptType, opType.getValue());
        }
        this.f = opType;
        wj.g gVar = this.a;
        if (gVar != null) {
            gVar.a(true);
        }
        AdInterceptDialog adInterceptDialog = new AdInterceptDialog();
        this.g = adInterceptDialog;
        adInterceptDialog.N0(j(this.b));
        adInterceptDialog.I0(this.c);
        adInterceptDialog.H0(this.d);
        adInterceptDialog.F0(this.e, biddingIntermediateMaterialBean);
        adInterceptDialog.G0(new Function1() { // from class: com.transsion.commercialization.task.e
            public final Object invoke(Object obj) {
                Unit p;
                p = DownloadInterceptAdHelper.p(DownloadInterceptAdHelper.this, ((Integer) obj).intValue());
                return p;
            }
        });
        adInterceptDialog.k0(com.blankj.utilcode.util.a.b(), "AdInterceptDialog");
    }
}
