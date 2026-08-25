package com.transsion.rewardscenter.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.imageview.ShapeableImageView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R;
import com.transsion.baseui.dialog.BaseMemberLoadingDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.model.RewardsCenterModel;
import com.transsion.rewardscenter.prize.PrizeListView;
import com.transsion.rewardscenter.redeem.RedeemView;
import com.transsion.rewardscenter.utils.AppInstallBroadcastHelper;
import com.transsion.rewardscenter.view.PrizeFlowView;
import com.transsion.rewardscenter.view.RewardsCenterTaskView;
import com.transsion.rewardscenterapi.Banner;
import com.transsion.rewardscenterapi.DrawResult;
import com.transsion.rewardscenterapi.Lottery;
import com.transsion.rewardscenterapi.PrizeFlow;
import com.transsion.rewardscenterapi.Redeem;
import com.transsion.rewardscenterapi.Rule;
import com.transsion.rewardscenterapi.SkuPoint;
import com.transsion.rewardscenterapi.Task;
import com.transsion.rewardscenterapi.TopUpType;
import com.transsion.rewardscenterapi.User;
import com.transsion.rewardscenterapi.UserPrize;
import com.transsnet.loginapi.bean.UserInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import ni.f;
import qx.b;
import wf.a;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 j2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001kB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u0005J\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u0004\u0018\u00010\u001dH\u0014¢\u0006\u0004\b \u0010\u001fJ\u0019\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010\u0005J\u0017\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0011H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\bH\u0016¢\u0006\u0004\b1\u0010\u0005J\u000f\u00102\u001a\u00020\bH\u0016¢\u0006\u0004\b2\u0010\u0005J\u000f\u00103\u001a\u00020\bH\u0016¢\u0006\u0004\b3\u0010\u0005J\u000f\u00104\u001a\u00020\bH\u0016¢\u0006\u0004\b4\u0010\u0005J\r\u00105\u001a\u00020\b¢\u0006\u0004\b5\u0010\u0005J\r\u00106\u001a\u00020\b¢\u0006\u0004\b6\u0010\u0005J\r\u00107\u001a\u00020\b¢\u0006\u0004\b7\u0010\u0005J\u0015\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J!\u0010D\u001a\u00020\b2\u0006\u0010A\u001a\u00020@2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B¢\u0006\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010GR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u001b\u0010W\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001b\u0010\\\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010T\u001a\u0004\bZ\u0010[R\u001d\u0010a\u001a\u0004\u0018\u00010]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010T\u001a\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010MR\"\u0010i\u001a\u0010\u0012\f\u0012\n f*\u0004\u0018\u00010e0e0d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lcom/transsion/rewardscenter/ui/RewardsCenterFragment;", "Lcom/transsion/rewardscenter/ui/FitStatusBarFragment;", "Lyo/d;", "Lqx/b;", "<init>", "()V", "Lcom/transsion/rewardscenterapi/Lottery;", "lottery", BuildConfig.FLAVOR, "u1", "(Lcom/transsion/rewardscenterapi/Lottery;)V", "Lcom/transsion/rewardscenterapi/User;", "info", "x1", "(Lcom/transsion/rewardscenterapi/User;)V", BuildConfig.FLAVOR, "point", BuildConfig.FLAVOR, "R0", "(I)Ljava/lang/String;", "prizeId", "l1", "(Ljava/lang/String;)V", "s1", "y1", "p1", "v1", "Q0", "n1", "Landroid/view/View;", "n0", "()Landroid/view/View;", "o0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroy", "Landroid/view/LayoutInflater;", "inflater", "U0", "(Landroid/view/LayoutInflater;)Lyo/d;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "initViewData", "initViewModel", "initListener", "retryLoadData", "q1", "showLoading", "P0", "Lcom/transsion/rewardscenterapi/DrawResult;", "drawResult", "k1", "(Lcom/transsion/rewardscenterapi/DrawResult;)V", "Lcom/transsnet/loginapi/bean/UserInfo;", "user", "onLogin", "(Lcom/transsnet/loginapi/bean/UserInfo;)V", "Lcom/transsion/rewardscenterapi/TopUpType;", "topUpType", "Lcom/transsion/rewardscenterapi/SkuPoint;", "skuPoint", "z1", "(Lcom/transsion/rewardscenterapi/TopUpType;Lcom/transsion/rewardscenterapi/SkuPoint;)V", "b", "Ljava/lang/String;", "source", "c", "sceneId", BuildConfig.FLAVOR, "d", "Z", "isFromAdTask", "e", "Lcom/transsion/rewardscenterapi/SkuPoint;", "bannerSkuPoint", "Lcom/transsion/rewardscenter/model/RewardsCenterModel;", "f", "Lkotlin/Lazy;", "T0", "()Lcom/transsion/rewardscenter/model/RewardsCenterModel;", "rewardsCenterModel", "Lcom/transsion/baseui/dialog/BaseMemberLoadingDialog;", "g", "S0", "()Lcom/transsion/baseui/dialog/BaseMemberLoadingDialog;", "loadingDialog", "Lqx/a;", "h", "getLoginApi", "()Lqx/a;", "loginApi", "i", "isFirstResume", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "j", "Landroidx/activity/result/b;", "claimRewardLauncher", "k", "a", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RewardsCenterFragment extends FitStatusBarFragment<yo.d> implements qx.b {
    public static final int l = 8;

    /* renamed from: b, reason: from kotlin metadata */
    private String source;

    /* renamed from: c, reason: from kotlin metadata */
    private String sceneId;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isFromAdTask;

    /* renamed from: e, reason: from kotlin metadata */
    private SkuPoint bannerSkuPoint;

    /* renamed from: f, reason: from kotlin metadata */
    private final Lazy rewardsCenterModel;

    /* renamed from: g, reason: from kotlin metadata */
    private final Lazy loadingDialog;

    /* renamed from: h, reason: from kotlin metadata */
    private final Lazy loginApi;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean isFirstResume;

    /* renamed from: j, reason: from kotlin metadata */
    private final androidx.activity.result.b claimRewardLauncher;

    static final class b implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        b(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    public static final class c implements RequestListener {
        c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z) {
            CardView cardView;
            Intrinsics.h(drawable, "resource");
            Intrinsics.h(obj, "model");
            Intrinsics.h(dataSource, "dataSource");
            yo.d dVar = (yo.d) RewardsCenterFragment.this.getMViewBinding();
            if (dVar != null && (cardView = dVar.g) != null) {
                ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = -2;
                } else {
                    layoutParams = null;
                }
                cardView.setLayoutParams(layoutParams);
                com.transsion.rewardscenter.utils.q.b("banner");
            }
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
            CardView cardView;
            Intrinsics.h(target, "target");
            yo.d dVar = (yo.d) RewardsCenterFragment.this.getMViewBinding();
            if (dVar != null && (cardView = dVar.g) != null) {
                uf.c.g(cardView);
            }
            a.a.f(wf.a.a, "RewardsCenter", "--> banner image load failed", false, 4, (Object) null);
            return false;
        }
    }

    public RewardsCenterFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.rewardscenter.ui.RewardsCenterFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m147invoke() {
                return this;
            }
        };
        this.rewardsCenterModel = FragmentViewModelLazyKt.a(this, Reflection.b(RewardsCenterModel.class), new Function0<x0>() { // from class: com.transsion.rewardscenter.ui.RewardsCenterFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m148invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.rewardscenter.ui.RewardsCenterFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m149invoke() {
                Object invoke = function0.invoke();
                androidx.lifecycle.m mVar = invoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.loadingDialog = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.ui.o0
            public final Object invoke() {
                BaseMemberLoadingDialog m1;
                m1 = RewardsCenterFragment.m1();
                return m1;
            }
        });
        this.loginApi = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.ui.p0
            public final Object invoke() {
                qx.a loginApi_delegate$lambda$1;
                loginApi_delegate$lambda$1 = RewardsCenterFragment.loginApi_delegate$lambda$1();
                return loginApi_delegate$lambda$1;
            }
        });
        this.isFirstResume = true;
        androidx.activity.result.b registerForActivityResult = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.rewardscenter.ui.q0
            public final void a(Object obj) {
                RewardsCenterFragment.O0(RewardsCenterFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult, "registerForActivityResult(...)");
        this.claimRewardLauncher = registerForActivityResult;
    }

    public static /* synthetic */ void A1(RewardsCenterFragment rewardsCenterFragment, TopUpType topUpType, SkuPoint skuPoint, int i, Object obj) {
        if ((i & 2) != 0) {
            skuPoint = null;
        }
        rewardsCenterFragment.z1(topUpType, skuPoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(RewardsCenterFragment rewardsCenterFragment, ActivityResult activityResult) {
        yo.d dVar;
        PrizeListView prizeListView;
        Intrinsics.h(activityResult, "it");
        if (activityResult.getResultCode() != -1) {
            rewardsCenterFragment.T0().A(null);
            return;
        }
        String q = rewardsCenterFragment.T0().q();
        rewardsCenterFragment.T0().A(null);
        if (q != null && (dVar = (yo.d) rewardsCenterFragment.getMViewBinding()) != null && (prizeListView = dVar.i) != null) {
            prizeListView.markClaimed(q);
        }
        String string = rewardsCenterFragment.getString(R$string.success_claim);
        Intrinsics.g(string, "getString(...)");
        com.transsion.rewardscenter.utils.p.a(true, string);
    }

    private final void Q0() {
        PhoneBottomSheetFragment k0 = getParentFragmentManager().k0("PhoneBottomSheetFragment");
        PhoneBottomSheetFragment phoneBottomSheetFragment = k0 instanceof PhoneBottomSheetFragment ? k0 : null;
        if (phoneBottomSheetFragment == null) {
            return;
        }
        phoneBottomSheetFragment.dismissAllowingStateLoss();
    }

    private final String R0(int point) {
        if (point < 1000) {
            return String.valueOf(point);
        }
        if (point < 10000) {
            String format = String.format("%,d", Arrays.copyOf(new Object[]{Integer.valueOf(point)}, 1));
            Intrinsics.g(format, "format(...)");
            return format;
        }
        if (point < 1000000) {
            return (point / 1000) + "k";
        }
        return (point / 1000000) + "M";
    }

    private final BaseMemberLoadingDialog S0() {
        return (BaseMemberLoadingDialog) this.loadingDialog.getValue();
    }

    private final RewardsCenterModel T0() {
        return (RewardsCenterModel) this.rewardsCenterModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(RewardsCenterFragment rewardsCenterFragment, View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.h(view, "it");
        rewardsCenterFragment.getParentFragmentManager().g1();
        FragmentActivity activity = rewardsCenterFragment.getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.l();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(RewardsCenterFragment rewardsCenterFragment, View view) {
        Intrinsics.h(view, "it");
        rewardsCenterFragment.p1();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(RewardsCenterFragment rewardsCenterFragment, View view) {
        Intrinsics.h(view, "it");
        rewardsCenterFragment.p1();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(RewardsCenterFragment rewardsCenterFragment, View view) {
        Intrinsics.h(view, "it");
        rewardsCenterFragment.n1();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(RewardsCenterFragment rewardsCenterFragment, View view) {
        RewardsCenterTaskView rewardsCenterTaskView;
        Intrinsics.h(view, "it");
        yo.d dVar = (yo.d) rewardsCenterFragment.getMViewBinding();
        if (dVar != null && (rewardsCenterTaskView = dVar.n) != null) {
            rewardsCenterTaskView.scrollToSelf();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(RewardsCenterFragment rewardsCenterFragment, View view) {
        User w = rewardsCenterFragment.T0().w();
        if (w == null || w.isLogin()) {
            return;
        }
        rewardsCenterFragment.y1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(RewardsCenterFragment rewardsCenterFragment, Redeem redeem) {
        CardView cardView;
        List<SkuPoint> skuPointList;
        RedeemView redeemView;
        if (redeem != null) {
            yo.d dVar = (yo.d) rewardsCenterFragment.getMViewBinding();
            if (dVar != null && (redeemView = dVar.l) != null) {
                redeemView.setRedeemData(redeem);
            }
            if (redeem.getLotteryPrize() != null || ((skuPointList = redeem.getSkuPointList()) != null && !skuPointList.isEmpty())) {
                yo.d dVar2 = (yo.d) rewardsCenterFragment.getMViewBinding();
                if (dVar2 != null && (cardView = dVar2.k) != null) {
                    uf.c.k(cardView);
                }
                com.transsion.rewardscenter.utils.q.b("redeem_rewards");
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(final RewardsCenterFragment rewardsCenterFragment, Task task) {
        yo.d dVar;
        ConstraintLayout constraintLayout;
        CardView cardView;
        RewardsCenterTaskView rewardsCenterTaskView;
        if (task != null) {
            yo.d dVar2 = (yo.d) rewardsCenterFragment.getMViewBinding();
            if (dVar2 != null && (rewardsCenterTaskView = dVar2.n) != null) {
                rewardsCenterTaskView.setTaskData(task);
            }
            yo.d dVar3 = (yo.d) rewardsCenterFragment.getMViewBinding();
            if (dVar3 != null && (cardView = dVar3.m) != null) {
                uf.c.k(cardView);
            }
            com.transsion.rewardscenter.utils.q.b("earn_points");
            if (rewardsCenterFragment.isFromAdTask && (dVar = (yo.d) rewardsCenterFragment.getMViewBinding()) != null && (constraintLayout = dVar.n) != null) {
                constraintLayout.postDelayed(new Runnable() { // from class: com.transsion.rewardscenter.ui.h0
                    @Override // java.lang.Runnable
                    public final void run() {
                        RewardsCenterFragment.d1(RewardsCenterFragment.this);
                    }
                }, 500L);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(RewardsCenterFragment rewardsCenterFragment) {
        RewardsCenterTaskView rewardsCenterTaskView;
        yo.d dVar = (yo.d) rewardsCenterFragment.getMViewBinding();
        if (dVar == null || (rewardsCenterTaskView = dVar.n) == null) {
            return;
        }
        rewardsCenterTaskView.scrollToSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(RewardsCenterFragment rewardsCenterFragment, Rule rule) {
        ArrayList arrayList;
        String str;
        AppCompatTextView appCompatTextView;
        if (rule != null) {
            List<String> terms = rule.getTerms();
            if (terms != null) {
                arrayList = new ArrayList();
                for (Object obj : terms) {
                    if (((String) obj).length() > 0) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList == null || arrayList.size() != 0) {
                List<String> terms2 = rule.getTerms();
                if (terms2 == null || (str = CollectionsKt.s0(terms2, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)) == null) {
                    str = BuildConfig.FLAVOR;
                }
                yo.d dVar = (yo.d) rewardsCenterFragment.getMViewBinding();
                if (dVar != null && (appCompatTextView = dVar.r) != null) {
                    appCompatTextView.setText(str);
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(RewardsCenterFragment rewardsCenterFragment, Boolean bool) {
        if (bool.booleanValue()) {
            rewardsCenterFragment.showLoading();
        } else {
            rewardsCenterFragment.P0();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(RewardsCenterFragment rewardsCenterFragment, Pair pair) {
        String string;
        if (pair == null) {
            return Unit.a;
        }
        rewardsCenterFragment.T0().m().n((Object) null);
        if (Intrinsics.c((String) pair.getFirst(), "400")) {
            string = (String) pair.getSecond();
            if (string == null) {
                string = rewardsCenterFragment.getString(R$string.claim_failed);
                Intrinsics.g(string, "getString(...)");
            }
        } else {
            string = rewardsCenterFragment.getString(R$string.claim_failed);
            Intrinsics.g(string, "getString(...)");
        }
        com.transsion.rewardscenter.utils.p.a(false, string);
        return Unit.a;
    }

    private final qx.a getLoginApi() {
        return (qx.a) this.loginApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(RewardsCenterFragment rewardsCenterFragment, Pair pair) {
        PrizeListView prizeListView;
        PrizeListView prizeListView2;
        if (pair == null) {
            return Unit.a;
        }
        String str = (String) pair.component1();
        boolean booleanValue = ((Boolean) pair.component2()).booleanValue();
        rewardsCenterFragment.T0().n().n((Object) null);
        if (booleanValue) {
            yo.d dVar = (yo.d) rewardsCenterFragment.getMViewBinding();
            if (dVar != null && (prizeListView2 = dVar.i) != null) {
                prizeListView2.markClaimed(str);
            }
            String string = rewardsCenterFragment.getString(R$string.success_claim);
            Intrinsics.g(string, "getString(...)");
            com.transsion.rewardscenter.utils.p.a(true, string);
        } else {
            yo.d dVar2 = (yo.d) rewardsCenterFragment.getMViewBinding();
            if (dVar2 != null && (prizeListView = dVar2.i) != null) {
                prizeListView.markTopUp(str);
            }
        }
        bp.a aVar = (bp.a) TheRouter.d(bp.a.class, new Object[0]);
        if (aVar != null) {
            aVar.b();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(RewardsCenterFragment rewardsCenterFragment, Lottery lottery) {
        rewardsCenterFragment.u1(lottery);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(RewardsCenterFragment rewardsCenterFragment, User user) {
        if (user != null) {
            rewardsCenterFragment.x1(user);
        }
        return Unit.a;
    }

    private final void l1(String prizeId) {
        Intent l2 = TheRouter.c("/rewards/claim_reward").l(requireContext());
        l2.putExtra("prize_id", prizeId);
        this.claimRewardLauncher.a(l2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a loginApi_delegate$lambda$1() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseMemberLoadingDialog m1() {
        return new BaseMemberLoadingDialog();
    }

    private final void n1() {
        User w = T0().w();
        if (w != null) {
            if (w.isLogin()) {
                z1(TopUpType.BANNER, this.bannerSkuPoint);
            } else {
                y1();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("is_login", w.isLogin() ? MsgStyle.CUSTOM_LEFT_PIC : "0");
            com.transsion.rewardscenter.utils.q.a("banner", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(RewardsCenterFragment rewardsCenterFragment, String str) {
        RewardsCenterTaskView rewardsCenterTaskView;
        Intrinsics.h(str, "it");
        yo.d dVar = (yo.d) rewardsCenterFragment.getMViewBinding();
        if (dVar != null && (rewardsCenterTaskView = dVar.n) != null) {
            rewardsCenterTaskView.onPackageInstall(str);
        }
        return Unit.a;
    }

    private final void p1() {
        Navigator.x(TheRouter.c("/member/point_history"), requireContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(RewardsCenterFragment rewardsCenterFragment) {
        rewardsCenterFragment.P0();
        return Unit.a;
    }

    private final void s1() {
        FragmentManager supportFragmentManager;
        FragmentActivity activity = getActivity();
        if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
            return;
        }
        supportFragmentManager.G1("treasure_wheel_result_dismissed", getViewLifecycleOwner(), new androidx.fragment.app.t() { // from class: com.transsion.rewardscenter.ui.f0
            public final void a(String str, Bundle bundle) {
                RewardsCenterFragment.t1(RewardsCenterFragment.this, str, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(RewardsCenterFragment rewardsCenterFragment, String str, Bundle bundle) {
        Intrinsics.h(str, "<unused var>");
        Intrinsics.h(bundle, "<unused var>");
        a.a.f(wf.a.a, "RewardsCenter", "--> TreasureWheelStateDialog dismissed", false, 4, (Object) null);
        RewardsCenterModel.j(rewardsCenterFragment.T0(), null, 1, null);
    }

    private final void u1(Lottery lottery) {
        ConstraintLayout constraintLayout;
        List<DrawResult> prizeItems;
        PrizeListView prizeListView;
        String imageUrl;
        AppCompatImageView appCompatImageView;
        CardView cardView;
        PrizeFlowView prizeFlowView;
        PrizeFlowView prizeFlowView2;
        if (lottery != null) {
            List<PrizeFlow> prizeFlows = lottery.getPrizeFlows();
            if (prizeFlows != null && !prizeFlows.isEmpty()) {
                yo.d dVar = (yo.d) getMViewBinding();
                if (dVar != null && (prizeFlowView2 = dVar.f) != null) {
                    prizeFlowView2.setPrizeFlows(prizeFlows);
                }
                yo.d dVar2 = (yo.d) getMViewBinding();
                if (dVar2 != null && (prizeFlowView = dVar2.f) != null) {
                    uf.c.k(prizeFlowView);
                }
            }
            Banner banner = lottery.getBanner();
            if (banner != null && (imageUrl = banner.getImageUrl()) != null && !StringsKt.q0(imageUrl) && banner.getEnable()) {
                this.bannerSkuPoint = banner.getSku();
                yo.d dVar3 = (yo.d) getMViewBinding();
                if (dVar3 != null && (cardView = dVar3.g) != null) {
                    uf.c.k(cardView);
                    ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                    layoutParams.height = 0;
                    cardView.setLayoutParams(layoutParams);
                }
                yo.d dVar4 = (yo.d) getMViewBinding();
                if (dVar4 != null && (appCompatImageView = dVar4.c) != null) {
                    Glide.with(this).load(banner.getImageUrl()).listener(new c()).into(appCompatImageView);
                }
            }
            UserPrize userPrize = lottery.getUserPrize();
            if (userPrize != null) {
                yo.d dVar5 = (yo.d) getMViewBinding();
                if (dVar5 != null && (prizeListView = dVar5.i) != null) {
                    prizeListView.setData(userPrize);
                }
                if (userPrize.getDrawChance() == null && ((prizeItems = userPrize.getPrizeItems()) == null || prizeItems.isEmpty())) {
                    return;
                }
                yo.d dVar6 = (yo.d) getMViewBinding();
                if (dVar6 != null && (constraintLayout = dVar6.j) != null) {
                    uf.c.k(constraintLayout);
                }
                com.transsion.rewardscenter.utils.q.b("prize_list");
            }
        }
    }

    private final void v1() {
        getParentFragmentManager().G1("phone_bottom_sheet_result", getViewLifecycleOwner(), new androidx.fragment.app.t() { // from class: com.transsion.rewardscenter.ui.i0
            public final void a(String str, Bundle bundle) {
                RewardsCenterFragment.w1(RewardsCenterFragment.this, str, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(RewardsCenterFragment rewardsCenterFragment, String str, Bundle bundle) {
        Intrinsics.h(str, "<unused var>");
        Intrinsics.h(bundle, "bundle");
        rewardsCenterFragment.Q0();
        TopUpType topUpType = TopUpType.BANNER;
        int i = bundle.getInt("source", topUpType.getValue());
        String string = bundle.getString("number");
        String str2 = BuildConfig.FLAVOR;
        if (string == null) {
            string = BuildConfig.FLAVOR;
        }
        String string2 = bundle.getString("cc");
        if (string2 == null) {
            string2 = BuildConfig.FLAVOR;
        }
        String string3 = bundle.getString("iso");
        if (string3 != null) {
            str2 = string3;
        }
        com.transsion.rewardscenter.utils.b.a.g(string2, str2, string);
        if (i != topUpType.getValue() && i != TopUpType.REDEEM.getValue()) {
            if (i == TopUpType.PHONE_CREDIT.getValue()) {
                rewardsCenterFragment.T0().B(string2, string, str2);
            }
        } else {
            RewardsCenterModel T0 = rewardsCenterFragment.T0();
            FragmentActivity activity = rewardsCenterFragment.getActivity();
            Intrinsics.f(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            T0.y((AppCompatActivity) activity, string);
        }
    }

    private final void x1(User info) {
        String str;
        yo.d dVar;
        yo.h hVar;
        ImageView imageView;
        yo.h hVar2;
        AppCompatTextView appCompatTextView;
        yo.h hVar3;
        AppCompatTextView appCompatTextView2;
        yo.d dVar2 = (yo.d) getMViewBinding();
        if (dVar2 != null && (hVar3 = dVar2.e) != null && (appCompatTextView2 = hVar3.g) != null) {
            appCompatTextView2.setText(R0(info.getPoint()));
        }
        if (info.isLogin()) {
            str = info.getNickname();
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
        } else {
            str = "Log in";
        }
        String m = androidx.core.text.a.c().m(str, androidx.core.text.t.a);
        yo.d dVar3 = (yo.d) getMViewBinding();
        if (dVar3 != null && (hVar2 = dVar3.e) != null && (appCompatTextView = hVar2.f) != null) {
            appCompatTextView.setText(m);
        }
        String avatar = info.getAvatar();
        if (avatar == null || (dVar = (yo.d) getMViewBinding()) == null || (hVar = dVar.e) == null || (imageView = hVar.c) == null) {
            return;
        }
        f.a aVar = ni.f.a;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        aVar.m(requireContext).g(avatar).i(R.mipmap.profile_default_avatar).d(imageView);
    }

    private final void y1() {
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            qx.a loginApi = getLoginApi();
            if (loginApi != null) {
                loginApi.j(this);
            }
            qx.a loginApi2 = getLoginApi();
            if (loginApi2 != null) {
                loginApi2.e(this);
            }
            qx.a loginApi3 = getLoginApi();
            if (loginApi3 != null) {
                Context requireContext = requireContext();
                Intrinsics.g(requireContext, "requireContext(...)");
                loginApi3.k(requireContext);
                unit = Unit.a;
            } else {
                unit = null;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public final void P0() {
        try {
            Result.Companion companion = Result.Companion;
            S0().dismissAllowingStateLoss();
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public yo.d getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        yo.d c2 = yo.d.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
        yo.h hVar;
        yo.h hVar2;
        yo.h hVar3;
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        yo.h hVar4;
        AppCompatTextView appCompatTextView2;
        yo.h hVar5;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        yo.d dVar = (yo.d) getMViewBinding();
        if (dVar != null && (appCompatImageView3 = dVar.b) != null) {
            uf.c.c(appCompatImageView3, 0L, new Function1() { // from class: com.transsion.rewardscenter.ui.g0
                public final Object invoke(Object obj) {
                    Unit V0;
                    V0 = RewardsCenterFragment.V0(RewardsCenterFragment.this, (View) obj);
                    return V0;
                }
            }, 1, (Object) null);
        }
        yo.d dVar2 = (yo.d) getMViewBinding();
        if (dVar2 != null && (hVar5 = dVar2.e) != null && (appCompatImageView2 = hVar5.b) != null) {
            uf.c.c(appCompatImageView2, 0L, new Function1() { // from class: com.transsion.rewardscenter.ui.j0
                public final Object invoke(Object obj) {
                    Unit W0;
                    W0 = RewardsCenterFragment.W0(RewardsCenterFragment.this, (View) obj);
                    return W0;
                }
            }, 1, (Object) null);
        }
        yo.d dVar3 = (yo.d) getMViewBinding();
        if (dVar3 != null && (hVar4 = dVar3.e) != null && (appCompatTextView2 = hVar4.g) != null) {
            uf.c.c(appCompatTextView2, 0L, new Function1() { // from class: com.transsion.rewardscenter.ui.k0
                public final Object invoke(Object obj) {
                    Unit X0;
                    X0 = RewardsCenterFragment.X0(RewardsCenterFragment.this, (View) obj);
                    return X0;
                }
            }, 1, (Object) null);
        }
        yo.d dVar4 = (yo.d) getMViewBinding();
        if (dVar4 != null && (appCompatImageView = dVar4.c) != null) {
            uf.c.c(appCompatImageView, 0L, new Function1() { // from class: com.transsion.rewardscenter.ui.l0
                public final Object invoke(Object obj) {
                    Unit Y0;
                    Y0 = RewardsCenterFragment.Y0(RewardsCenterFragment.this, (View) obj);
                    return Y0;
                }
            }, 1, (Object) null);
        }
        yo.d dVar5 = (yo.d) getMViewBinding();
        if (dVar5 != null && (hVar3 = dVar5.e) != null && (appCompatTextView = hVar3.e) != null) {
            uf.c.c(appCompatTextView, 0L, new Function1() { // from class: com.transsion.rewardscenter.ui.m0
                public final Object invoke(Object obj) {
                    Unit Z0;
                    Z0 = RewardsCenterFragment.Z0(RewardsCenterFragment.this, (View) obj);
                    return Z0;
                }
            }, 1, (Object) null);
        }
        com.transsion.baseui.util.o oVar = com.transsion.baseui.util.o.a;
        yo.d dVar6 = (yo.d) getMViewBinding();
        ShapeableImageView shapeableImageView = null;
        AppCompatTextView appCompatTextView3 = (dVar6 == null || (hVar2 = dVar6.e) == null) ? null : hVar2.f;
        yo.d dVar7 = (yo.d) getMViewBinding();
        if (dVar7 != null && (hVar = dVar7.e) != null) {
            shapeableImageView = hVar.c;
        }
        oVar.a(new View[]{appCompatTextView3, shapeableImageView}, new View.OnClickListener() { // from class: com.transsion.rewardscenter.ui.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RewardsCenterFragment.a1(RewardsCenterFragment.this, view);
            }
        });
    }

    @Override // com.transsion.rewardscenter.ui.FitStatusBarFragment
    public void initViewData() {
        PrizeListView prizeListView;
        RewardsCenterTaskView rewardsCenterTaskView;
        RedeemView redeemView;
        super.initViewData();
        androidx.lifecycle.u viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.g(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        RewardsCenterModel T0 = T0();
        WeakReference weakReference = new WeakReference(this);
        androidx.lifecycle.u viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.g(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        zo.a aVar = new zo.a(viewLifecycleOwner, T0, weakReference, androidx.lifecycle.v.a(viewLifecycleOwner2));
        yo.d dVar = (yo.d) getMViewBinding();
        if (dVar != null && (redeemView = dVar.l) != null) {
            redeemView.setCtxConfig(aVar);
        }
        yo.d dVar2 = (yo.d) getMViewBinding();
        if (dVar2 != null && (rewardsCenterTaskView = dVar2.n) != null) {
            rewardsCenterTaskView.setCtxConfig(aVar);
        }
        yo.d dVar3 = (yo.d) getMViewBinding();
        if (dVar3 == null || (prizeListView = dVar3.i) == null) {
            return;
        }
        prizeListView.setCtxConfig(aVar);
    }

    public void initViewModel() {
        T0().p().j(getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.rewardscenter.ui.x
            public final Object invoke(Object obj) {
                Unit i1;
                i1 = RewardsCenterFragment.i1(RewardsCenterFragment.this, (Lottery) obj);
                return i1;
            }
        }));
        T0().x().j(getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.rewardscenter.ui.y
            public final Object invoke(Object obj) {
                Unit j1;
                j1 = RewardsCenterFragment.j1(RewardsCenterFragment.this, (User) obj);
                return j1;
            }
        }));
        T0().r().j(getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.rewardscenter.ui.z
            public final Object invoke(Object obj) {
                Unit b1;
                b1 = RewardsCenterFragment.b1(RewardsCenterFragment.this, (Redeem) obj);
                return b1;
            }
        }));
        T0().v().j(getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.rewardscenter.ui.a0
            public final Object invoke(Object obj) {
                Unit c1;
                c1 = RewardsCenterFragment.c1(RewardsCenterFragment.this, (Task) obj);
                return c1;
            }
        }));
        T0().t().j(getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.rewardscenter.ui.b0
            public final Object invoke(Object obj) {
                Unit e1;
                e1 = RewardsCenterFragment.e1(RewardsCenterFragment.this, (Rule) obj);
                return e1;
            }
        }));
        T0().o().j(getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.rewardscenter.ui.c0
            public final Object invoke(Object obj) {
                Unit f1;
                f1 = RewardsCenterFragment.f1(RewardsCenterFragment.this, (Boolean) obj);
                return f1;
            }
        }));
        T0().m().j(getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.rewardscenter.ui.d0
            public final Object invoke(Object obj) {
                Unit g1;
                g1 = RewardsCenterFragment.g1(RewardsCenterFragment.this, (Pair) obj);
                return g1;
            }
        }));
        T0().n().j(getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.rewardscenter.ui.e0
            public final Object invoke(Object obj) {
                Unit h1;
                h1 = RewardsCenterFragment.h1(RewardsCenterFragment.this, (Pair) obj);
                return h1;
            }
        }));
        v1();
        s1();
    }

    public final void k1(DrawResult drawResult) {
        Intrinsics.h(drawResult, "drawResult");
        User w = T0().w();
        if (w == null || !w.isLogin()) {
            y1();
            return;
        }
        String drawResultId = drawResult.getDrawResultId();
        if (drawResultId == null) {
            String string = getString(R.string.common_failed);
            Intrinsics.g(string, "getString(...)");
            com.transsion.rewardscenter.utils.p.a(false, string);
            return;
        }
        T0().A(drawResultId);
        String prizeType = drawResult.getPrizeType();
        if (prizeType != null) {
            int hashCode = prizeType.hashCode();
            if (hashCode == -277650678) {
                if (prizeType.equals("PHONE_CREDIT")) {
                    A1(this, TopUpType.PHONE_CREDIT, null, 2, null);
                }
            } else if (hashCode == -206450473) {
                if (prizeType.equals("PHYSICAL")) {
                    l1(drawResultId);
                }
            } else if (hashCode == 84989 && prizeType.equals("VIP")) {
                T0().f(drawResultId);
            }
        }
    }

    @Override // com.transsion.rewardscenter.ui.FitStatusBarFragment
    protected View n0() {
        yo.d dVar = (yo.d) getMViewBinding();
        if (dVar != null) {
            return dVar.q;
        }
        return null;
    }

    public qi.b newLogViewConfig() {
        UserInfo i;
        String str = null;
        qi.b bVar = new qi.b("rewards_center", false, 2, null);
        bVar.g().put("user_status", "me");
        HashMap g = bVar.g();
        qx.a loginApi = getLoginApi();
        if (loginApi != null && (i = loginApi.i()) != null) {
            str = i.getUserId();
        }
        g.put("user_id", String.valueOf(str));
        return bVar;
    }

    @Override // com.transsion.rewardscenter.ui.FitStatusBarFragment
    protected View o0() {
        yo.d dVar = (yo.d) getMViewBinding();
        if (dVar != null) {
            return dVar.o;
        }
        return null;
    }

    public void onCreate(Bundle savedInstanceState) {
        HashMap g;
        HashMap g2;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.source = arguments.getString("source");
            this.sceneId = arguments.getString("scene_id");
            this.isFromAdTask = arguments.getBoolean("is_from_ad_task", false);
            qi.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g2 = logViewConfig.g()) != null) {
            }
            qi.b logViewConfig2 = getLogViewConfig();
            if (logViewConfig2 != null && (g = logViewConfig2.g()) != null) {
            }
        }
        qi.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null) {
            logViewConfig3.k(true);
        }
        AppInstallBroadcastHelper appInstallBroadcastHelper = AppInstallBroadcastHelper.a;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        appInstallBroadcastHelper.a(requireContext, new Function1() { // from class: com.transsion.rewardscenter.ui.v
            public final Object invoke(Object obj) {
                Unit o1;
                o1 = RewardsCenterFragment.o1(RewardsCenterFragment.this, (String) obj);
                return o1;
            }
        });
    }

    public void onDestroy() {
        Unit unit;
        RewardsCenterTaskView rewardsCenterTaskView;
        PrizeFlowView prizeFlowView;
        super.onDestroy();
        AppInstallBroadcastHelper appInstallBroadcastHelper = AppInstallBroadcastHelper.a;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        appInstallBroadcastHelper.b(requireContext);
        yo.d dVar = (yo.d) getMViewBinding();
        if (dVar != null && (prizeFlowView = dVar.f) != null) {
            prizeFlowView.destroy();
        }
        yo.d dVar2 = (yo.d) getMViewBinding();
        if (dVar2 != null && (rewardsCenterTaskView = dVar2.n) != null) {
            rewardsCenterTaskView.destroy();
        }
        try {
            Result.Companion companion = Result.Companion;
            qx.a loginApi = getLoginApi();
            if (loginApi != null) {
                loginApi.j(this);
                unit = Unit.a;
            } else {
                unit = null;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public void onLogin(UserInfo user) {
        Intrinsics.h(user, "user");
        b.a.a(this, user);
        RewardsCenterModel.j(T0(), null, 1, null);
    }

    public void onLogout() {
        b.a.b(this);
    }

    public void onPause() {
        RewardsCenterTaskView rewardsCenterTaskView;
        super.onPause();
        yo.d dVar = (yo.d) getMViewBinding();
        if (dVar == null || (rewardsCenterTaskView = dVar.n) == null) {
            return;
        }
        rewardsCenterTaskView.onPause();
    }

    public void onResume() {
        RewardsCenterTaskView rewardsCenterTaskView;
        super.onResume();
        if (this.isFirstResume) {
            this.isFirstResume = false;
            q1();
        }
        yo.d dVar = (yo.d) getMViewBinding();
        if (dVar == null || (rewardsCenterTaskView = dVar.n) == null) {
            return;
        }
        rewardsCenterTaskView.onResume();
    }

    public void onUpdateUserInfo(UserInfo userInfo) {
        b.a.c(this, userInfo);
    }

    public final void q1() {
        showLoading();
        T0().i(new Function0() { // from class: com.transsion.rewardscenter.ui.w
            public final Object invoke() {
                Unit r1;
                r1 = RewardsCenterFragment.r1(RewardsCenterFragment.this);
                return r1;
            }
        });
    }

    public void retryLoadData() {
    }

    public final void showLoading() {
        S0().l0(this, "LoadingDialog");
    }

    public final void z1(TopUpType topUpType, SkuPoint skuPoint) {
        Intrinsics.h(topUpType, "topUpType");
        if (getParentFragmentManager().k0("PhoneBottomSheetFragment") != null) {
            return;
        }
        PhoneBottomSheetFragment.INSTANCE.a(topUpType, skuPoint).show(getParentFragmentManager(), "PhoneBottomSheetFragment");
    }
}
