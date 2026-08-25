package com.transsion.commercialization.task;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.RotateAnimation;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.therouter.TheRouter;
import com.tn.lib.widget.R;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.icon.BiddingIconAdManager;
import com.transsion.ad.bidding.icon.BiddingWrapperIconBean;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.commercialization.R$layout;
import com.transsion.commercialization.R$string;
import com.transsion.gslb.BuildConfig;
import com.transsion.memberapi.MemberSource;
import fh.b;
import im.b$a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001w\u0018\u0000 {2\u00020\u0001:\u0001|B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u0019\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u0019\u0010\u001c\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u0019J\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u0019\u0010\u001e\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u0019J\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020&H\u0002¢\u0006\u0004\b)\u0010(J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0003J\u0019\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J!\u0010/\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b1\u0010\u0003J\u0017\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020;0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR&\u0010F\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010PR\u001b\u0010W\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010(R\u0016\u0010Y\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010PR\u0016\u0010[\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010PR\u0016\u0010]\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010HR\u001b\u0010`\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010U\u001a\u0004\b_\u0010(R\u0014\u0010b\u001a\u00020N8\u0002X\u0082D¢\u0006\u0006\n\u0004\ba\u0010PR\u0014\u0010d\u001a\u00020N8\u0002X\u0082D¢\u0006\u0006\n\u0004\bc\u0010PR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010PR\u0014\u0010v\u001a\u00020s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010z\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010y¨\u0006}"}, d2 = {"Lcom/transsion/commercialization/task/DownloadInterceptDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/view/View;", "view", BuildConfig.FLAVOR, "g1", "(Landroid/view/View;)V", "f1", "w1", "m1", "u1", "loadData", "G1", "W0", "B1", "Z0", "t1", "s1", "D1", "j1", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "maxEcpmObject", "F1", "(Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;)V", "Y0", "i1", "E1", "X0", "q1", "r1", "n1", "l1", "o1", "p1", "v1", "h1", BuildConfig.FLAVOR, "d1", "()I", "a1", "C1", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lcom/transsion/ad/bidding/icon/BiddingIconAdManager;", "c", "Lcom/transsion/ad/bidding/icon/BiddingIconAdManager;", "adManager", BuildConfig.FLAVOR, "Lcom/transsion/ad/bidding/icon/BiddingWrapperIconBean;", "d", "Ljava/util/List;", "iconList", "Lsj/d;", "e", "Lsj/d;", "bind", "Lkotlin/Function1;", "f", "Lkotlin/jvm/functions/Function1;", "mCallback", "g", "I", "finishTaskType", "Lcom/transsion/commercialization/task/n;", "h", "Lcom/transsion/commercialization/task/n;", "mDownloadAdapter", BuildConfig.FLAVOR, "i", "Z", "isLoading", "j", "mIsTask", "k", "Lkotlin/Lazy;", "b1", "iconFetchCount", "l", "isRewardedAdShow", "m", "shouldCheckIconAd", "n", "curShowErrorTimes", "o", "c1", "maxShowErrorTimes", "p", "isRewardedOff", "q", "isRewardInterstitialOff", BuildConfig.FLAVOR, "r", "Ljava/lang/String;", "interceptSceneId", "Lcom/transsion/ad/bidding/video/BiddingVideoManager;", "s", "Lcom/transsion/ad/bidding/video/BiddingVideoManager;", "rewardedAdManager", "Lcom/transsion/ad/bidding/interstitial/BiddingInterstitialManager;", "t", "Lcom/transsion/ad/bidding/interstitial/BiddingInterstitialManager;", "interstitialAdManager", "u", "isRewarded", "Loh/a;", "v", "Loh/a;", "listener", "com/transsion/commercialization/task/DownloadInterceptDialog$d", "w", "Lcom/transsion/commercialization/task/DownloadInterceptDialog$d;", "rewardInterceptListener", "x", "a", "Commercialization_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class DownloadInterceptDialog extends BaseDialog {

    /* renamed from: c, reason: from kotlin metadata */
    private BiddingIconAdManager adManager;

    /* renamed from: d, reason: from kotlin metadata */
    private final List iconList;

    /* renamed from: e, reason: from kotlin metadata */
    private sj.d bind;

    /* renamed from: f, reason: from kotlin metadata */
    private Function1 mCallback;

    /* renamed from: g, reason: from kotlin metadata */
    private int finishTaskType;

    /* renamed from: h, reason: from kotlin metadata */
    private n mDownloadAdapter;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean mIsTask;

    /* renamed from: k, reason: from kotlin metadata */
    private final Lazy iconFetchCount;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean isRewardedAdShow;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean shouldCheckIconAd;

    /* renamed from: n, reason: from kotlin metadata */
    private int curShowErrorTimes;

    /* renamed from: o, reason: from kotlin metadata */
    private final Lazy maxShowErrorTimes;

    /* renamed from: p, reason: from kotlin metadata */
    private final boolean isRewardedOff;

    /* renamed from: q, reason: from kotlin metadata */
    private final boolean isRewardInterstitialOff;

    /* renamed from: r, reason: from kotlin metadata */
    private String interceptSceneId;

    /* renamed from: s, reason: from kotlin metadata */
    private BiddingVideoManager rewardedAdManager;

    /* renamed from: t, reason: from kotlin metadata */
    private BiddingInterstitialManager interstitialAdManager;

    /* renamed from: u, reason: from kotlin metadata */
    private boolean isRewarded;

    /* renamed from: v, reason: from kotlin metadata */
    private final oh.a listener;

    /* renamed from: w, reason: from kotlin metadata */
    private final d rewardInterceptListener;

    public static final class b extends RecyclerView.l {
        b() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(rect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            super.getItemOffsets(rect, view, recyclerView, xVar);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                if (adapter.getItemCount() == 1) {
                    rect.top = a0.a(8.0f);
                    return;
                }
                if (childAdapterPosition == 0) {
                    rect.top = a0.a(8.0f);
                    rect.bottom = a0.a(12.0f);
                } else if (childAdapterPosition == adapter.getItemCount() - 1) {
                    rect.bottom = a0.a(4.0f);
                } else {
                    rect.bottom = a0.a(12.0f);
                }
            }
        }
    }

    public static final class c extends oh.a {
        c() {
        }

        public void onClick(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
            Intrinsics.h(additionalInfo, "p1");
            super/*com.hisavana.common.interfacz.TAdditionalListener*/.onClick(tAdNativeInfo, additionalInfo);
            DownloadInterceptDialog.this.m1();
        }

        public void r(RecommendInfo recommendInfo) {
            super.r(recommendInfo);
            DownloadInterceptDialog.this.m1();
        }

        public void w(List list) {
            super.w(list);
            DownloadInterceptDialog.this.iconList.clear();
            if (list != null && (!list.isEmpty())) {
                DownloadInterceptDialog.this.iconList.addAll(list);
            }
            DownloadInterceptDialog.this.B1();
        }
    }

    public static final class d extends oh.a {
        d() {
        }

        public void i(TAdErrorCode tAdErrorCode) {
            com.transsion.commercialization.pslink.a.a.a(DownloadInterceptDialog.this.getClassTag() + " --> rewardedListener --> onBiddingError() --> 广告加载失败");
            DownloadInterceptDialog.this.o1();
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            com.transsion.commercialization.pslink.a.a.a(DownloadInterceptDialog.this.getClassTag() + " --> rewardedListener --> onLoad() --> 广告加载成功");
            DownloadInterceptDialog.this.q1(biddingIntermediateMaterialBean);
        }

        public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            com.transsion.commercialization.pslink.a.a.a(DownloadInterceptDialog.this.getClassTag() + " --> rewardedListener --> onClosed() --> 广告关闭");
            DownloadInterceptDialog.this.n1();
        }

        public void n(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            com.transsion.commercialization.pslink.a.a.a(DownloadInterceptDialog.this.getClassTag() + " --> rewardedListener --> onShow() --> 广告展示");
            DownloadInterceptDialog.this.r1();
        }

        public void o(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            com.transsion.commercialization.pslink.a.a.a(DownloadInterceptDialog.this.getClassTag() + " --> rewardedListener --> onRewarded() --> 激励广告奖励");
            DownloadInterceptDialog.this.l1();
        }

        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            com.transsion.commercialization.pslink.a.a.a(DownloadInterceptDialog.this.getClassTag() + " --> rewardedListener --> onShowError() --> 广告展示失败");
            DownloadInterceptDialog.this.p1();
        }
    }

    public static final class e implements im.c {
        e() {
        }

        @Override // im.c
        public void a() {
            com.transsion.commercialization.pslink.a.a.a(DownloadInterceptDialog.this.getClassTag() + " --> startMemberPage() --> onFailed() --> 开通会员失败");
        }

        @Override // im.c
        public void onSuccess() {
            com.transsion.commercialization.pslink.a.a.a(DownloadInterceptDialog.this.getClassTag() + " --> startMemberPage() --> onSuccess() --> 开通会员成功，直接下载不需要做任务了");
            DownloadInterceptDialog.this.finishTaskType = 2;
            DownloadInterceptDialog.this.dismissAllowingStateLoss();
        }
    }

    public DownloadInterceptDialog() {
        super(R$layout.dialog_download_intercept_v2_layout);
        this.adManager = new BiddingIconAdManager();
        this.iconList = new ArrayList();
        this.finishTaskType = 1;
        this.iconFetchCount = LazyKt.b(new Function0() { // from class: com.transsion.commercialization.task.g
            public final Object invoke() {
                int e1;
                e1 = DownloadInterceptDialog.e1(DownloadInterceptDialog.this);
                return Integer.valueOf(e1);
            }
        });
        this.shouldCheckIconAd = true;
        this.maxShowErrorTimes = LazyKt.b(new Function0() { // from class: com.transsion.commercialization.task.h
            public final Object invoke() {
                int k1;
                k1 = DownloadInterceptDialog.k1(DownloadInterceptDialog.this);
                return Integer.valueOf(k1);
            }
        });
        this.isRewardedOff = true;
        this.isRewardInterstitialOff = true;
        this.interceptSceneId = BuildConfig.FLAVOR;
        this.listener = new c();
        this.rewardInterceptListener = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(DownloadInterceptDialog downloadInterceptDialog, View view) {
        downloadInterceptDialog.D1();
        com.transsion.commercialization.pslink.f.a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1() {
        sj.h hVar;
        ConstraintLayout constraintLayout;
        Context context;
        ConstraintLayout constraintLayout2;
        if (isDetached() || getActivity() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!this.iconList.isEmpty()) {
            arrayList.add(this.iconList.get(0));
            this.iconList.remove(0);
        }
        if (!arrayList.isEmpty()) {
            u1();
            n nVar = this.mDownloadAdapter;
            if (nVar != null) {
                nVar.n1(arrayList);
            }
        } else if (this.shouldCheckIconAd) {
            sj.d dVar = this.bind;
            if (dVar != null && (constraintLayout2 = dVar.b) != null) {
                uf.c.g(constraintLayout2);
            }
            if (this.isRewardedOff) {
                Z0();
            }
        } else {
            b.a aVar = fh.b.a;
            sj.d dVar2 = this.bind;
            aVar.e((dVar2 == null || (hVar = dVar2.j) == null || (constraintLayout = hVar.c) == null || (context = constraintLayout.getContext()) == null) ? null : context.getString(R.string.no_more_ad_tips));
        }
        this.shouldCheckIconAd = false;
        this.isLoading = false;
        W0();
        com.transsion.commercialization.pslink.a.a.b(getClassTag() + " --> show() --> 组装数据 ..... --> excessiveList.size = " + arrayList.size() + " 一次数据加载结束 -- isLoading = false");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1() {
        if (this.mIsTask) {
            return;
        }
        b.a.h(fh.b.a, R$layout.download_toast_layout, "+1 download granted", 80, 0, a0.a(66.0f), 8, (Object) null);
    }

    private final void D1() {
        String str = this.interceptSceneId;
        if (Intrinsics.c(str, "DownloadInterceptRewarded")) {
            j1();
        } else if (Intrinsics.c(str, "DownloadInterceptInterstitial")) {
            i1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E1(BiddingIntermediateMaterialBean maxEcpmObject) {
        Context context = getContext();
        if (context != null) {
            this.interceptSceneId = "DownloadInterceptInterstitial";
            kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new DownloadInterceptDialog$showInterstitialAd$1$1(this, context, maxEcpmObject, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1(BiddingIntermediateMaterialBean maxEcpmObject) {
        Context context = getContext();
        if (context != null) {
            this.interceptSceneId = "DownloadInterceptRewarded";
            kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new DownloadInterceptDialog$showRewardedAd$1$1(this, context, maxEcpmObject, null), 3, (Object) null);
        }
    }

    private final void G1() {
        AppCompatImageView appCompatImageView;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setRepeatCount(-1);
        sj.d dVar = this.bind;
        if (dVar == null || (appCompatImageView = dVar.g) == null) {
            return;
        }
        appCompatImageView.startAnimation(rotateAnimation);
    }

    private final void W0() {
        AppCompatImageView appCompatImageView;
        sj.d dVar = this.bind;
        if (dVar == null || (appCompatImageView = dVar.g) == null) {
            return;
        }
        appCompatImageView.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0() {
        BiddingInterstitialManager biddingInterstitialManager = this.interstitialAdManager;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.U();
        }
        this.interstitialAdManager = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0() {
        BiddingVideoManager biddingVideoManager = this.rewardedAdManager;
        if (biddingVideoManager != null) {
            biddingVideoManager.U();
        }
        this.rewardedAdManager = null;
    }

    private final void Z0() {
        this.finishTaskType = 3;
        dismissAllowingStateLoss();
    }

    private final int a1() {
        JsonElement jsonElement;
        JsonObject b2 = com.transsion.ad.scene.d.a.b("DownloadInterceptRewarded");
        if (b2 == null || (jsonElement = b2.get("iconFetchCount")) == null) {
            return 10;
        }
        return jsonElement.getAsInt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b1() {
        return ((Number) this.iconFetchCount.getValue()).intValue();
    }

    private final int c1() {
        return ((Number) this.maxShowErrorTimes.getValue()).intValue();
    }

    private final int d1() {
        JsonElement jsonElement;
        JsonObject b2 = com.transsion.ad.scene.d.a.b("DownloadInterceptRewarded");
        if (b2 == null || (jsonElement = b2.get("maxShowErrorTimes")) == null) {
            return 3;
        }
        return jsonElement.getAsInt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e1(DownloadInterceptDialog downloadInterceptDialog) {
        return downloadInterceptDialog.a1();
    }

    private final void f1() {
        RecyclerView recyclerView;
        sj.d dVar = this.bind;
        if (dVar == null || (recyclerView = dVar.k) == null) {
            return;
        }
        n nVar = new n(this.adManager);
        this.mDownloadAdapter = nVar;
        recyclerView.setAdapter(nVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new b());
    }

    private final void g1(View view) {
        LinearLayoutCompat linearLayoutCompat;
        ConstraintLayout constraintLayout;
        sj.h hVar;
        ConstraintLayout constraintLayout2;
        Window window;
        Window window2;
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-1, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(17);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setCancelable(false);
        }
        this.bind = sj.d.a(view);
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (!(bVar != null ? bVar.z() : false) || this.mIsTask) {
            sj.d dVar = this.bind;
            if (dVar != null && (constraintLayout = dVar.c) != null) {
                constraintLayout.setVisibility(8);
            }
            sj.d dVar2 = this.bind;
            if (dVar2 != null && (linearLayoutCompat = dVar2.i) != null) {
                linearLayoutCompat.setVisibility(8);
            }
        }
        sj.d dVar3 = this.bind;
        if (dVar3 == null || (hVar = dVar3.j) == null || (constraintLayout2 = hVar.c) == null) {
            return;
        }
        constraintLayout2.setVisibility(this.isRewardedOff ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1() {
        sj.h hVar;
        ConstraintLayout constraintLayout;
        Context context;
        ConstraintLayout constraintLayout2;
        sj.h hVar2;
        ConstraintLayout constraintLayout3;
        Context context2;
        X0();
        sj.d dVar = this.bind;
        String str = null;
        if (dVar == null || (constraintLayout2 = dVar.b) == null || uf.c.i(constraintLayout2)) {
            b.a aVar = fh.b.a;
            sj.d dVar2 = this.bind;
            if (dVar2 != null && (hVar = dVar2.j) != null && (constraintLayout = hVar.c) != null && (context = constraintLayout.getContext()) != null) {
                str = context.getString(R.string.common_failed);
            }
            aVar.e(str);
            return;
        }
        Z0();
        b.a aVar2 = fh.b.a;
        sj.d dVar3 = this.bind;
        if (dVar3 != null && (hVar2 = dVar3.j) != null && (constraintLayout3 = hVar2.c) != null && (context2 = constraintLayout3.getContext()) != null) {
            str = context2.getString(R$string.reward_intercept_skip);
        }
        aVar2.e(str);
    }

    private final void i1() {
        Context context;
        if (this.isRewardInterstitialOff || (context = getContext()) == null) {
            return;
        }
        this.interceptSceneId = "DownloadInterceptInterstitial";
        kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new DownloadInterceptDialog$loadInterstitialAd$1$1(this, context, null), 3, (Object) null);
    }

    private final void j1() {
        Context context;
        if (this.isRewardedOff || (context = getContext()) == null) {
            return;
        }
        this.interceptSceneId = "DownloadInterceptRewarded";
        kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new DownloadInterceptDialog$loadRewardedAd$1$1(this, context, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k1(DownloadInterceptDialog downloadInterceptDialog) {
        return downloadInterceptDialog.d1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new DownloadInterceptDialog$onAdRewarded$1(this, null), 3, (Object) null);
    }

    private final void loadData() {
        this.isLoading = true;
        G1();
        kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new DownloadInterceptDialog$loadData$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1() {
        this.finishTaskType = 2;
        dismissAllowingStateLoss();
        C1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1() {
        this.isRewardedAdShow = false;
        kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new DownloadInterceptDialog$onRewardAdClose$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1() {
        kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new DownloadInterceptDialog$onRewardLoadError$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p1() {
        kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new DownloadInterceptDialog$onRewardShowError$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(BiddingIntermediateMaterialBean maxEcpmObject) {
        kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new DownloadInterceptDialog$onRewardedLoad$1(this, maxEcpmObject, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1() {
        this.isRewardedAdShow = true;
        this.curShowErrorTimes = 0;
    }

    private final void s1() {
        if (this.isRewardInterstitialOff) {
            return;
        }
        this.interceptSceneId = "DownloadInterceptInterstitial";
        BiddingInterstitialManager.Companion.b(BiddingInterstitialManager.t, "DownloadInterceptInterstitial", (Map) null, 2, (Object) null);
    }

    private final void t1() {
        if (this.isRewardedOff) {
            return;
        }
        this.interceptSceneId = "DownloadInterceptRewarded";
        BiddingVideoManager.Companion.b(BiddingVideoManager.t, "DownloadInterceptRewarded", (Map) null, 2, (Object) null);
    }

    private final void u1() {
        List<BiddingWrapperIconBean> data;
        TAdNativeInfo nativeInfo;
        n nVar = this.mDownloadAdapter;
        if (nVar == null || (data = nVar.getData()) == null) {
            return;
        }
        for (BiddingWrapperIconBean biddingWrapperIconBean : data) {
            if (biddingWrapperIconBean.getType() == 2 && (nativeInfo = biddingWrapperIconBean.getNativeInfo()) != null) {
                nativeInfo.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1() {
        sj.d dVar;
        ConstraintLayout constraintLayout;
        sj.h hVar;
        ConstraintLayout constraintLayout2;
        Context context;
        b.a aVar = fh.b.a;
        sj.d dVar2 = this.bind;
        aVar.e((dVar2 == null || (hVar = dVar2.j) == null || (constraintLayout2 = hVar.c) == null || (context = constraintLayout2.getContext()) == null) ? null : context.getString(R.string.common_failed));
        if (!this.isRewardInterstitialOff) {
            Y0();
            s1();
            return;
        }
        int i = this.curShowErrorTimes + 1;
        this.curShowErrorTimes = i;
        if (i < c1() || (dVar = this.bind) == null || (constraintLayout = dVar.b) == null || uf.c.i(constraintLayout)) {
            return;
        }
        Z0();
    }

    private final void w1() {
        sj.h hVar;
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        AppCompatImageView appCompatImageView;
        sj.d dVar = this.bind;
        if (dVar != null && (appCompatImageView = dVar.d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadInterceptDialog.x1(DownloadInterceptDialog.this, view);
                }
            });
        }
        sj.d dVar2 = this.bind;
        if (dVar2 != null && (constraintLayout2 = dVar2.c) != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadInterceptDialog.y1(DownloadInterceptDialog.this, view);
                }
            });
        }
        com.transsion.baseui.util.o oVar = com.transsion.baseui.util.o.a;
        sj.d dVar3 = this.bind;
        oVar.a(new View[]{dVar3 != null ? dVar3.p : null, dVar3 != null ? dVar3.g : null}, new View.OnClickListener() { // from class: com.transsion.commercialization.task.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadInterceptDialog.z1(DownloadInterceptDialog.this, view);
            }
        });
        sj.d dVar4 = this.bind;
        if (dVar4 == null || (hVar = dVar4.j) == null || (constraintLayout = hVar.c) == null) {
            return;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadInterceptDialog.A1(DownloadInterceptDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(DownloadInterceptDialog downloadInterceptDialog, View view) {
        downloadInterceptDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(DownloadInterceptDialog downloadInterceptDialog, View view) {
        com.transsion.commercialization.pslink.f.a.a();
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            b$a.c(bVar, downloadInterceptDialog.getActivity(), MemberSource.SOURCE_DOWNLOAD_DIALOG, downloadInterceptDialog.new e(), false, null, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(DownloadInterceptDialog downloadInterceptDialog, View view) {
        if (downloadInterceptDialog.isLoading) {
            return;
        }
        com.transsion.commercialization.pslink.f.a.c();
        if (downloadInterceptDialog.iconList.isEmpty()) {
            downloadInterceptDialog.loadData();
        } else {
            downloadInterceptDialog.B1();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.center_DialogStyle);
        com.transsion.commercialization.pslink.a.a.a(getClassTag() + " --> onCreate() --> 下载应用弹窗");
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onDestroy() {
        super.onDestroy();
        u1();
        this.adManager.I();
        com.transsion.commercialization.pslink.a.a.a(getClassTag() + " --> onDestroy() -> " + this.isRewardedAdShow);
        if (this.isRewardedAdShow) {
            return;
        }
        Y0();
        X0();
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onDismiss(DialogInterface dialog) {
        Function1 function1;
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        com.transsion.commercialization.pslink.a.a.a(getClassTag() + " --> onDismiss() --> " + this.isRewardedAdShow);
        if (this.isRewardedAdShow || (function1 = this.mCallback) == null) {
            return;
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        t1();
        com.transsion.commercialization.pslink.f.a.g();
        g1(view);
        f1();
        w1();
        loadData();
    }
}
