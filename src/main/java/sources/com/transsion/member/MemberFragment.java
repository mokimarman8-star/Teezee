package com.transsion.member;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.d;
import androidx.core.text.t;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.google.android.material.imageview.ShapeableImageView;
import com.gyf.immersionbar.ImmersionBar;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.report.g;
import com.transsion.baseui.activity.k;
import com.transsion.baseui.dialog.BaseMemberLoadingDialog;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.member.MemberFragment$special$;
import com.transsion.member.adapter.e;
import com.transsion.member.adapter.h;
import com.transsion.member.bean.RedeemResult;
import com.transsion.member.dialog.MemberPromoCodeDialog;
import com.transsion.member.widget.PointView;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskItemCheckInInfo;
import com.transsion.memberapi.MemberTaskItemInvite;
import com.transsion.memberapi.MemberTaskRewardInfo;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import com.transsion.memberapi.PointInfo;
import com.transsion.memberapi.SkuCategory;
import com.transsion.memberapi.SkuData;
import com.transsion.memberapi.SkuItem;
import com.transsnet.loginapi.bean.UserInfo;
import f.j;
import fh.b;
import gm.i;
import im.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import ni.f;
import qx.b;
import uf.c;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 £\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001hB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0007J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u0007J\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\"\u001a\u00020\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0 H\u0002¢\u0006\u0004\b\"\u0010#J!\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020\u0013H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b)\u0010\u0007J\u000f\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\u0007J\u000f\u0010+\u001a\u00020\u0013H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\bH\u0002¢\u0006\u0004\b-\u0010\u0007J#\u00100\u001a\u00020\b2\u0006\u0010.\u001a\u00020$2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\b2\u0006\u0010/\u001a\u00020$H\u0002¢\u0006\u0004\b2\u00103J+\u00107\u001a\u00020\b2\u0006\u0010/\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u0001042\b\u00106\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\b2\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<J\u001f\u0010?\u001a\u0002042\u0006\u0010=\u001a\u0002042\u0006\u0010>\u001a\u000209H\u0002¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\u00022\u0006\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020$H\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\bH\u0016¢\u0006\u0004\bG\u0010\u0007J\u000f\u0010H\u001a\u00020\bH\u0016¢\u0006\u0004\bH\u0010\u0007J\u0011\u0010J\u001a\u0004\u0018\u00010IH\u0016¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0013H\u0016¢\u0006\u0004\bL\u0010,J\u000f\u0010M\u001a\u00020\bH\u0016¢\u0006\u0004\bM\u0010\u0007J\u0019\u0010P\u001a\u00020\b2\b\u0010O\u001a\u0004\u0018\u00010NH\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\bH\u0016¢\u0006\u0004\bR\u0010\u0007J\u000f\u0010S\u001a\u00020\bH\u0016¢\u0006\u0004\bS\u0010\u0007J\u0017\u0010U\u001a\u00020\b2\u0006\u0010T\u001a\u00020\u0013H\u0016¢\u0006\u0004\bU\u0010\u0016J\r\u0010V\u001a\u00020\b¢\u0006\u0004\bV\u0010\u0007J\r\u0010W\u001a\u00020\b¢\u0006\u0004\bW\u0010\u0007J\u0017\u0010Y\u001a\u00020\b2\u0006\u0010X\u001a\u00020\nH\u0016¢\u0006\u0004\bY\u0010\rJ\u000f\u0010Z\u001a\u00020\bH\u0016¢\u0006\u0004\bZ\u0010\u0007J\u0017\u0010[\u001a\u00020\b2\u0006\u0010X\u001a\u00020\nH\u0016¢\u0006\u0004\b[\u0010\rJ\u0015\u0010]\u001a\u00020\b2\u0006\u0010\\\u001a\u000204¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020\bH\u0016¢\u0006\u0004\b_\u0010\u0007J\u000f\u0010`\u001a\u00020\bH\u0016¢\u0006\u0004\b`\u0010\u0007J\u0019\u0010c\u001a\u00020\b2\b\u0010b\u001a\u0004\u0018\u00010aH\u0016¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\bH\u0016¢\u0006\u0004\be\u0010\u0007J\u000f\u0010f\u001a\u00020\bH\u0016¢\u0006\u0004\bf\u0010\u0007R$\u0010n\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR$\u0010s\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010F\"\u0004\br\u00103R\u0018\u0010v\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u001b\u0010~\u001a\u00020y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R\"\u0010\u0083\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0080\u0001\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0090\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0091\u0001\u0010{\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R \u0010\u0099\u0001\u001a\u00030\u0095\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0096\u0001\u0010{\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0019\u0010\u009c\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0019\u0010\u009e\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009b\u0001R\u0019\u0010 \u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010\u009b\u0001R\u0019\u0010¢\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010\u009b\u0001¨\u0006¤\u0001"}, d2 = {"Lcom/transsion/member/MemberFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lgm/i;", "Landroid/view/View$OnClickListener;", "Lqx/b;", "Lcom/transsion/baselib/report/g;", "<init>", "()V", "", "h1", "Lcom/transsnet/loginapi/bean/UserInfo;", "userInfo", "w1", "(Lcom/transsnet/loginapi/bean/UserInfo;)V", "Lcom/transsion/memberapi/SkuItem;", "skuItem", "g1", "(Lcom/transsion/memberapi/SkuItem;)V", "I0", "", "isAutoRenew", "f1", "(Z)V", "Lcom/transsion/memberapi/MemberDetail;", "memberDetail", "n1", "(Lcom/transsion/memberapi/MemberDetail;)V", "i1", "Lcom/transsion/memberapi/SkuData;", "data", "p1", "(Lcom/transsion/memberapi/SkuData;)V", "", "redeemList", "j1", "(Ljava/util/List;)V", "", "productId", "isSubscription", "u1", "(Ljava/lang/String;Z)V", "P0", "L0", "d1", "()Z", "H0", "optType", "skuId", "k1", "(Ljava/lang/String;Ljava/lang/String;)V", "m1", "(Ljava/lang/String;)V", "", "code", "message", "l1", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "", "alpha", "v1", "(F)V", "color", "fraction", "G0", "(IF)I", "Landroid/view/LayoutInflater;", "inflater", "O0", "(Landroid/view/LayoutInflater;)Lgm/i;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "loadDefaultData", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "isShowPageStateLayoutTitle", "initViewModel", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onPause", "onResume", "hidden", "onHiddenChanged", "showLoading", "K0", "user", "onLogin", "onLogout", "onUpdateUserInfo", "points", "t1", "(I)V", "initListener", "retryLoadData", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "logResume", "onDestroy", "Lcom/transsion/memberapi/MemberSource;", "a", "Lcom/transsion/memberapi/MemberSource;", "getSource", "()Lcom/transsion/memberapi/MemberSource;", "s1", "(Lcom/transsion/memberapi/MemberSource;)V", "source", "b", "Ljava/lang/String;", "getSceneId", "o1", "sceneId", "c", "Lcom/transsnet/loginapi/bean/UserInfo;", "mUserInfo", "d", "Lcom/transsion/memberapi/MemberDetail;", "Lcom/transsion/baseui/dialog/BaseMemberLoadingDialog;", "e", "Lkotlin/Lazy;", "M0", "()Lcom/transsion/baseui/dialog/BaseMemberLoadingDialog;", "mLoadingDialog", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "f", "Landroidx/activity/result/b;", "loginLaunch", "Lcom/transsion/member/adapter/h;", "g", "Lcom/transsion/member/adapter/h;", "taskAdapter", "Lcom/transsion/member/adapter/g;", "h", "Lcom/transsion/member/adapter/g;", "skuListAdapter", "Lcom/transsion/member/adapter/e;", "i", "Lcom/transsion/member/adapter/e;", "redeemListAdapter", "Lqx/a;", "j", "getMLoginApi", "()Lqx/a;", "mLoginApi", "Lcom/transsion/member/MemberViewModel;", "k", "N0", "()Lcom/transsion/member/MemberViewModel;", "memberViewModel", "l", "Z", "isFirstResume", "m", "shouldRefreshPurchasedInfo", "n", "isPremium", "o", "isSelf", "p", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class MemberFragment extends PageStatusFragment<i> implements View.OnClickListener, b, g {
    public static final a p = new a((DefaultConstructorMarker) null);
    public static final int q = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private MemberSource source;

    /* renamed from: c, reason: from kotlin metadata */
    private UserInfo mUserInfo;

    /* renamed from: d, reason: from kotlin metadata */
    private MemberDetail memberDetail;

    /* renamed from: f, reason: from kotlin metadata */
    private androidx.activity.result.b loginLaunch;

    /* renamed from: g, reason: from kotlin metadata */
    private h taskAdapter;

    /* renamed from: h, reason: from kotlin metadata */
    private com.transsion.member.adapter.g skuListAdapter;

    /* renamed from: i, reason: from kotlin metadata */
    private e redeemListAdapter;

    /* renamed from: k, reason: from kotlin metadata */
    private final Lazy memberViewModel;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean isFirstResume;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean shouldRefreshPurchasedInfo;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean isPremium;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean isSelf;

    /* renamed from: b, reason: from kotlin metadata */
    private String sceneId = "";

    /* renamed from: e, reason: from kotlin metadata */
    private final Lazy mLoadingDialog = LazyKt.b(new i());

    /* renamed from: j, reason: from kotlin metadata */
    private final Lazy mLoginApi = LazyKt.b(new j());

    public MemberFragment() {
        MemberFragment$special$.inlined.viewModels.default.1 r0 = new MemberFragment$special$.inlined.viewModels.default.1(this);
        this.memberViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MemberViewModel.class), new MemberFragment$special$.inlined.viewModels.default.2(r0), new MemberFragment$special$.inlined.viewModels.default.3(r0, this));
        this.isFirstResume = true;
    }

    private final int G0(int color, float fraction) {
        return Color.argb((int) (Color.alpha(color) * fraction), Color.red(color), Color.green(color), Color.blue(color));
    }

    private final void H0() {
        ImmersionBar.with(this).statusBarDarkFont(false).init();
    }

    private final void I0() {
        Intent intent;
        Intent intent2;
        RecyclerView recyclerView;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || !intent.getBooleanExtra("extra_member_scroll_bottom", false)) {
            return;
        }
        i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.t) != null) {
            recyclerView.postDelayed(new d(this), 500L);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (intent2 = activity2.getIntent()) == null) {
            return;
        }
        intent2.removeExtra("extra_member_scroll_bottom");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(MemberFragment memberFragment) {
        NestedScrollView nestedScrollView;
        i mViewBinding = memberFragment.getMViewBinding();
        if (mViewBinding == null || (nestedScrollView = mViewBinding.u) == null) {
            return;
        }
        nestedScrollView.fullScroll(130);
    }

    private final void L0() {
        ConstraintLayout constraintLayout;
        i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (constraintLayout = mViewBinding.w) != null) {
            c.e(constraintLayout);
        }
        d activity = getActivity();
        MemberActivity memberActivity = activity instanceof MemberActivity ? (MemberActivity) activity : null;
        if (memberActivity != null) {
            memberActivity.t0();
        }
    }

    private final BaseMemberLoadingDialog M0() {
        return (BaseMemberLoadingDialog) this.mLoadingDialog.getValue();
    }

    private final MemberViewModel N0() {
        return (MemberViewModel) this.memberViewModel.getValue();
    }

    private final void P0() {
        String string;
        String string2;
        if (this.isPremium) {
            Context context = getContext();
            if (context != null) {
                string = context.getString(R.string.member_successfully_renewed);
            }
            string = null;
        } else {
            Context context2 = getContext();
            if (context2 != null) {
                string = context2.getString(R.string.member_successfully_upgraded_to_premium);
            }
            string = null;
        }
        MemberSource memberSource = this.source;
        switch (memberSource == null ? -1 : b.b[memberSource.ordinal()]) {
            case 1:
                Context context3 = getContext();
                if (context3 != null) {
                    string2 = context3.getString(R.string.member_back_to_watch);
                    break;
                }
                string2 = null;
                break;
            case 2:
                Context context4 = getContext();
                if (context4 != null) {
                    string2 = context4.getString(R.string.member_back);
                    break;
                }
                string2 = null;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                Context context5 = getContext();
                if (context5 != null) {
                    string2 = context5.getString(R.string.member_back_to_download);
                    break;
                }
                string2 = null;
                break;
            default:
                if (!(getActivity() instanceof MemberActivity)) {
                    Context context6 = getContext();
                    if (context6 != null) {
                        string2 = context6.getString(R.string.member_explore_now);
                        break;
                    }
                    string2 = null;
                    break;
                } else {
                    Context context7 = getContext();
                    if (context7 != null) {
                        string2 = context7.getString(R.string.member_back);
                        break;
                    }
                    string2 = null;
                }
        }
        a.a.g(a.a, "The source is " + this.source + ", title: " + string + ", buttonTitle: " + string2, false, 2, (Object) null);
        kotlinx.coroutines.i.d(androidx.lifecycle.v.a(this), (CoroutineContext) null, (CoroutineStart) null, new handlePurchaseSucceed.1(this, string, string2, (Continuation) null), 3, (Object) null);
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            b.a.a(bVar, (Function0) null, 1, (Object) null);
        }
        ObserveLoginAction.c.a().i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(MemberFragment memberFragment, View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        FragmentActivity activity = memberFragment.getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(MemberFragment memberFragment, View view) {
        Navigator.x(TheRouter.c("/member/point_history"), memberFragment.requireContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(MemberFragment memberFragment, View view) {
        Navigator.x(TheRouter.c("/member/point_history"), memberFragment.requireContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(View view) {
        Intrinsics.h(view, "it");
        Navigator.x(TheRouter.c("/rewards/center").K("source", "memberdetail"), (Context) null, (mf.c) null, 3, (Object) null);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(ActivityResult activityResult) {
        Intrinsics.h(activityResult, "it");
        if (activityResult.getResultCode() == -1) {
            a.a.f(a.a, "loginStatus", "登录成功", false, 4, (Object) null);
        } else {
            a.a.f(a.a, "loginStatus", "登录失败或者取消", false, 4, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(MemberFragment memberFragment, View view) {
        MemberPromoCodeDialog a = MemberPromoCodeDialog.f.a(new c(memberFragment));
        FragmentManager childFragmentManager = memberFragment.getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        a.show(childFragmentManager, "MemberPromoCodeDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(i iVar, MemberFragment memberFragment, View view, int i, int i2, int i3, int i4) {
        memberFragment.v1(Math.abs(i2 * 1.0f) / (iVar.w.getMeasuredHeight() < 1 ? a0.a(48.0f) : iVar.w.getMeasuredHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(MemberFragment memberFragment, SkuData skuData) {
        if (skuData != null) {
            memberFragment.p1(skuData);
        }
        memberFragment.K0();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(MemberFragment memberFragment, RedeemResult redeemResult) {
        String string;
        String str;
        if (redeemResult != null) {
            int vipDurationDays = redeemResult.getVipDurationDays();
            if (vipDurationDays == 1) {
                Context context = memberFragment.getContext();
                if (context != null) {
                    string = context.getString(R.string.member_claimed_succeed_1_day);
                    str = string;
                }
                str = null;
            } else {
                Context context2 = memberFragment.getContext();
                if (context2 != null) {
                    string = context2.getString(R.string.member_claimed_succeed_days, Integer.valueOf(vipDurationDays));
                    str = string;
                }
                str = null;
            }
            if (str != null) {
                b.a.h(fh.b.a, R.layout.claim_succeed_layout, str, 80, 0, a0.a(66.0f), 8, (Object) null);
            }
            memberFragment.h1();
            im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
            if (bVar != null) {
                b.a.a(bVar, (Function0) null, 1, (Object) null);
            }
        } else {
            com.tn.lib.widget.toast.core.h.a.k(R$string.failed_toast);
        }
        memberFragment.K0();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(MemberFragment memberFragment, List list) {
        h hVar = memberFragment.taskAdapter;
        if (hVar != null) {
            hVar.n1(list);
        }
        memberFragment.I0();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(MemberFragment memberFragment, im.e eVar) {
        List<Object> data;
        Object obj;
        Object obj2;
        List inviteList;
        memberFragment.h1();
        h hVar = memberFragment.taskAdapter;
        if (hVar != null && (data = hVar.getData()) != null) {
            Iterator<T> it = data.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                Integer taskSubType = ((MemberTaskItem) obj2).getTaskSubType();
                if (taskSubType != null && taskSubType.intValue() == 2) {
                    break;
                }
            }
            MemberTaskItem memberTaskItem = (MemberTaskItem) obj2;
            if (memberTaskItem != null) {
                int a = eVar.a();
                String d = eVar.d();
                MemberTaskRewardInfo b = eVar.b();
                if (b != null) {
                    if (Intrinsics.c(d, "0")) {
                        List<MemberTaskItemInvite> inviteList2 = memberTaskItem.getInviteList();
                        if (inviteList2 != null) {
                            for (MemberTaskItemInvite memberTaskItemInvite : inviteList2) {
                                if (memberTaskItemInvite.getStatus() == 1) {
                                    memberTaskItemInvite.setStatus(2);
                                }
                            }
                        }
                    } else if (a >= 0 && (inviteList = memberTaskItem.getInviteList()) != null) {
                        Iterator it2 = inviteList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next = it2.next();
                            if (Intrinsics.c(d, ((MemberTaskItemInvite) next).getRewardId())) {
                                obj = next;
                                break;
                            }
                        }
                        MemberTaskItemInvite memberTaskItemInvite2 = (MemberTaskItemInvite) obj;
                        if (memberTaskItemInvite2 != null) {
                            memberTaskItemInvite2.setStatus(2);
                        }
                    }
                    memberTaskItem.setRewardInfo(b);
                }
                h hVar2 = memberFragment.taskAdapter;
                if (hVar2 != null) {
                    hVar2.notifyDataSetChanged();
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(MemberFragment memberFragment, Pair pair) {
        List<Object> data;
        Object obj;
        List checkInList;
        MemberTaskItemCheckInInfo memberTaskItemCheckInInfo;
        memberFragment.h1();
        h hVar = memberFragment.taskAdapter;
        if (hVar != null && (data = hVar.getData()) != null) {
            Iterator<T> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Integer taskSubType = ((MemberTaskItem) obj).getTaskSubType();
                if (taskSubType != null && taskSubType.intValue() == 8) {
                    break;
                }
            }
            MemberTaskItem memberTaskItem = (MemberTaskItem) obj;
            if (memberTaskItem != null) {
                int intValue = ((Number) pair.getFirst()).intValue();
                if (((MemberTaskSubmitCheckInRes) pair.getSecond()) != null && (checkInList = memberTaskItem.getCheckInList()) != null && (memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) checkInList.get(intValue)) != null) {
                    memberTaskItemCheckInInfo.setHasCheckIn(true);
                }
                h hVar2 = memberFragment.taskAdapter;
                if (hVar2 != null) {
                    hVar2.notifyDataSetChanged();
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(MemberFragment memberFragment, MemberDetail memberDetail) {
        if (memberDetail != null) {
            memberFragment.memberDetail = memberDetail;
            qi.b logViewConfig = memberFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            memberFragment.n1(memberDetail);
            memberFragment.w1(memberDetail.getUserInfo());
        }
        if (memberDetail == null) {
            if (l.a.e()) {
                com.tn.lib.widget.toast.core.h.a.k(R$string.failed_toast);
            } else {
                fh.b.a.d(R$string.no_network_toast);
            }
        }
        memberFragment.K0();
        return Unit.a;
    }

    /* renamed from: d1, reason: from getter */
    private final boolean getIsSelf() {
        return this.isSelf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseMemberLoadingDialog e1() {
        return new BaseMemberLoadingDialog();
    }

    private final void f1(boolean isAutoRenew) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        int i = 0;
        if (isAutoRenew) {
            i mViewBinding = getMViewBinding();
            if (mViewBinding == null || (appCompatTextView3 = mViewBinding.m) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = appCompatTextView3.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            bVar.t = -1;
            i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (appCompatTextView4 = mViewBinding2.p) != null) {
                i = appCompatTextView4.getId();
            }
            bVar.s = i;
            bVar.setMarginStart(a0.a(2.0f));
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = a0.a(18.5f);
            appCompatTextView3.setLayoutParams(bVar);
            return;
        }
        i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (appCompatTextView = mViewBinding3.m) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = appCompatTextView.getLayoutParams();
        Intrinsics.f(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
        bVar2.s = -1;
        i mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatTextView2 = mViewBinding4.p) != null) {
            i = appCompatTextView2.getId();
        }
        bVar2.t = i;
        bVar2.setMarginStart(a0.a(0.0f));
        ((ViewGroup.MarginLayoutParams) bVar2).topMargin = a0.a(44.0f);
        appCompatTextView.setLayoutParams(bVar2);
    }

    private final void g1(SkuItem skuItem) {
        showLoading();
        N0().J(skuItem);
    }

    private final qx.a getMLoginApi() {
        return (qx.a) this.mLoginApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1() {
        N0().q();
        N0().s();
        h hVar = this.taskAdapter;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
        I0();
    }

    private final void i1() {
        if (this.shouldRefreshPurchasedInfo) {
            P0();
            this.shouldRefreshPurchasedInfo = false;
        }
    }

    private final void j1(List redeemList) {
        i mViewBinding;
        RecyclerView recyclerView;
        PointInfo pointInfo;
        RecyclerView recyclerView2;
        i mViewBinding2 = getMViewBinding();
        RecyclerView.Adapter adapter = null;
        if ((mViewBinding2 != null ? mViewBinding2.q : null) != null) {
            i mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (recyclerView2 = mViewBinding3.q) != null) {
                adapter = recyclerView2.getAdapter();
            }
            if (adapter == null || (mViewBinding = getMViewBinding()) == null || (recyclerView = mViewBinding.q) == null) {
                return;
            }
            MemberDetail memberDetail = this.memberDetail;
            int point = (memberDetail == null || (pointInfo = memberDetail.getPointInfo()) == null) ? 0 : pointInfo.getPoint();
            Iterator it = redeemList.iterator();
            while (it.hasNext()) {
                ((SkuItem) it.next()).setUserPoints(Integer.valueOf(point));
            }
            if (recyclerView.getAdapter() != null) {
                e adapter2 = recyclerView.getAdapter();
                Intrinsics.f(adapter2, "null cannot be cast to non-null type com.transsion.member.adapter.RedeemInfoAdapter");
                adapter2.q1(CollectionsKt.U0(redeemList));
            }
        }
    }

    private final void k1(String optType, String skuId) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("opt_type", optType);
        if (skuId != null) {
            hashMap.put("skuId", skuId);
        }
        qi.h hVar = qi.h.a;
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (str = logViewConfig.f()) == null) {
            str = "";
        }
        hVar.o(str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1(String skuId, Integer code, String message) {
        String f;
        HashMap hashMap = new HashMap();
        hashMap.put("opt_type", "pay_result");
        hashMap.put("sku_id", skuId);
        hashMap.put("fail_code", String.valueOf(code));
        String str = "";
        if (message == null) {
            message = "";
        }
        hashMap.put("fail_message", message);
        hashMap.put("result_type", "result_fail");
        qi.h hVar = qi.h.a;
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (f = logViewConfig.f()) != null) {
            str = f;
        }
        hVar.q(str, "purchase", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1(String skuId) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("opt_type", "pay_result");
        hashMap.put("sku_id", skuId);
        hashMap.put("result_type", "result_success");
        qi.h hVar = qi.h.a;
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (str = logViewConfig.f()) == null) {
            str = "";
        }
        hVar.q(str, "purchase", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a mLoginApi_delegate$lambda$1() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x024d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void n1(com.transsion.memberapi.MemberDetail r10) {
        /*
            Method dump skipped, instructions count: 943
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.MemberFragment.n1(com.transsion.memberapi.MemberDetail):void");
    }

    private final void p1(SkuData data) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        PointInfo pointInfo;
        List<SkuItem> skuList = data.getSkuList();
        List K0 = skuList != null ? CollectionsKt.K0(skuList, 3) : null;
        if (K0 == null) {
            K0 = CollectionsKt.l();
        }
        List<SkuItem> skuPointList = data.getSkuPointList();
        List K02 = skuPointList != null ? CollectionsKt.K0(skuPointList, 3) : null;
        if (K02 == null) {
            K02 = CollectionsKt.l();
        }
        List<SkuItem> list = K0;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list, 10));
        for (SkuItem skuItem : list) {
            skuItem.setMemberDetail(this.memberDetail);
            arrayList.add(skuItem);
        }
        MemberDetail memberDetail = this.memberDetail;
        int point = (memberDetail == null || (pointInfo = memberDetail.getPointInfo()) == null) ? 0 : pointInfo.getPoint();
        List<SkuItem> list2 = K02;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(list2, 10));
        for (SkuItem skuItem2 : list2) {
            skuItem2.setUserPoints(Integer.valueOf(point));
            arrayList2.add(skuItem2);
        }
        com.transsion.member.adapter.g gVar = this.skuListAdapter;
        if (Intrinsics.c(gVar != null ? gVar.getData() : null, CollectionsKt.U0(arrayList))) {
            e eVar = this.redeemListAdapter;
            if (Intrinsics.c(eVar != null ? eVar.getData() : null, CollectionsKt.U0(arrayList2))) {
                return;
            }
        }
        com.transsion.member.adapter.g gVar2 = new com.transsion.member.adapter.g(CollectionsKt.U0(arrayList));
        gVar2.l(R.id.item_root);
        gVar2.F1(new k(this));
        this.skuListAdapter = gVar2;
        i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView2 = mViewBinding.r) != null) {
            recyclerView2.setLayoutManager(new NpaGridLayoutManager(recyclerView2.getContext(), 3));
            if (recyclerView2.getItemDecorationCount() <= 0) {
                recyclerView2.addItemDecoration(new com.transsion.member.adapter.a(3, a0.a(8.0f)));
            }
            recyclerView2.setAdapter(this.skuListAdapter);
        }
        e eVar2 = new e(CollectionsKt.U0(arrayList2));
        eVar2.l(R.id.item_root);
        eVar2.F1(new l(this));
        this.redeemListAdapter = eVar2;
        i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (recyclerView = mViewBinding2.q) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 3));
        if (recyclerView.getItemDecorationCount() <= 0) {
            recyclerView.addItemDecoration(new com.transsion.member.adapter.a(3, a0.a(8.0f)));
        }
        recyclerView.setAdapter(this.redeemListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(MemberFragment memberFragment, SkuItem skuItem, View view) {
        String str;
        Intrinsics.h(skuItem, "item");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L)) {
            return Unit.a;
        }
        a.a.g(a.a, "The productId and coins: " + skuItem.getSkuId() + ", " + skuItem.getCoin(), false, 2, (Object) null);
        String category = skuItem.getCategory();
        SkuCategory skuCategory = SkuCategory.AUTO_RENEW;
        if (Intrinsics.c(category, skuCategory.getValue())) {
            str = skuItem.getDuration() + "_subscription";
        } else {
            str = skuItem.getDuration() + "_purchased";
        }
        memberFragment.k1(str, skuItem.getSkuId());
        qx.a mLoginApi = memberFragment.getMLoginApi();
        if (mLoginApi != null && mLoginApi.a()) {
            memberFragment.u1(skuItem.getSkuId(), Intrinsics.c(skuItem.getCategory(), skuCategory.getValue()));
            return Unit.a;
        }
        qx.a mLoginApi2 = memberFragment.getMLoginApi();
        if (mLoginApi2 != null) {
            mLoginApi2.e(memberFragment);
        }
        qx.a mLoginApi3 = memberFragment.getMLoginApi();
        if (mLoginApi3 != null) {
            Context requireContext = memberFragment.requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            mLoginApi3.k(requireContext);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(MemberFragment memberFragment, SkuItem skuItem, View view) {
        Intrinsics.h(skuItem, "item");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L)) {
            return Unit.a;
        }
        a.a.g(a.a, "The productId and coins: " + skuItem.getSkuId() + ", " + skuItem.getCoin(), false, 2, (Object) null);
        String duration = skuItem.getDuration();
        StringBuilder sb = new StringBuilder();
        sb.append(duration);
        sb.append("_reward");
        memberFragment.k1(sb.toString(), skuItem.getSkuId());
        memberFragment.g1(skuItem);
        return Unit.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (((r0 == null || (r0 = r0.getMemberInfo()) == null || r0.getMemberType() != 2) ? false : true) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void u1(java.lang.String r13, boolean r14) {
        /*
            r12 = this;
            com.transsion.memberapi.MemberDetail r0 = r12.memberDetail
            r1 = 0
            if (r0 == 0) goto L10
            com.transsion.memberapi.MemberInfo r0 = r0.getMemberInfo()
            if (r0 == 0) goto L10
            boolean r0 = r0.isActive()
            goto L11
        L10:
            r0 = r1
        L11:
            r2 = 2
            if (r0 == 0) goto L2b
            com.transsion.memberapi.MemberDetail r0 = r12.memberDetail
            r3 = 1
            if (r0 == 0) goto L27
            com.transsion.memberapi.MemberInfo r0 = r0.getMemberInfo()
            if (r0 == 0) goto L27
            int r0 = r0.getMemberType()
            if (r0 != r2) goto L27
            r0 = r3
            goto L28
        L27:
            r0 = r1
        L28:
            if (r0 == 0) goto L2b
            goto L2c
        L2b:
            r3 = r1
        L2c:
            r12.isPremium = r3
            wf.a$a r0 = wf.a.a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "before pay isPremium: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r4 = 0
            wf.a.a.g(r0, r3, r1, r2, r4)
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            androidx.fragment.app.FragmentActivity r1 = r12.getActivity()
            boolean r2 = r1 instanceof androidx.appcompat.app.AppCompatActivity
            if (r2 == 0) goto L55
            r4 = r1
            androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4
        L55:
            r6 = r4
            if (r6 == 0) goto L6a
            com.transsion.payment.lib.f$a r1 = com.transsion.payment.lib.f.b
            com.transsion.payment.lib.f r5 = r1.a()
            com.transsion.member.MemberFragment$startPay$1$1 r11 = new com.transsion.member.MemberFragment$startPay$1$1
            r11.<init>(r12, r13, r0)
            r8 = 0
            r10 = 0
            r7 = r13
            r9 = r14
            r5.e(r6, r7, r8, r9, r10, r11)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.MemberFragment.u1(java.lang.String, boolean):void");
    }

    private final void v1(float alpha) {
        i mViewBinding;
        ConstraintLayout constraintLayout;
        if (!isAdded() || (mViewBinding = getMViewBinding()) == null || (constraintLayout = mViewBinding.w) == null) {
            return;
        }
        constraintLayout.setBackgroundColor(G0(androidx.core.content.b.getColor(requireContext(), R$color.gray_dark_00), RangesKt.g(alpha, 1.0f)));
    }

    private final void w1(UserInfo userInfo) {
        i mViewBinding;
        if (userInfo == null || (mViewBinding = getMViewBinding()) == null) {
            return;
        }
        f.a aVar = f.a;
        Context context = mViewBinding.b.getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b i = aVar.m(context).g(userInfo.getAvatar()).i(R$mipmap.profile_default_avatar);
        ShapeableImageView shapeableImageView = mViewBinding.b;
        Intrinsics.g(shapeableImageView, "ivAvatarPremium");
        i.d(shapeableImageView);
        mViewBinding.h.setText(androidx.core.text.a.c().m(userInfo.getNickname(), t.a));
    }

    public final void K0() {
        if (M0().isAdded()) {
            M0().dismissAllowingStateLoss();
        } else {
            a.a.g(a.a, "Dialog not is added", false, 2, (Object) null);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public i getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        i c = i.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatTextView appCompatTextView;
        PointView pointView;
        PointView pointView2;
        AppCompatImageView appCompatImageView;
        i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView = mViewBinding.c) != null) {
            appCompatImageView.setOnClickListener(new m(this));
        }
        i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (pointView2 = mViewBinding2.f) != null) {
            pointView2.setOnClickListener(new n(this));
        }
        i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (pointView = mViewBinding3.o) != null) {
            pointView.setOnClickListener(new o(this));
        }
        i mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (appCompatTextView = mViewBinding4.z) == null) {
            return;
        }
        c.c(appCompatTextView, 0L, new p(), 1, (Object) null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        RecyclerView recyclerView;
        qx.a mLoginApi;
        L0();
        if (getIsSelf() && (mLoginApi = getMLoginApi()) != null) {
            mLoginApi.e(this);
        }
        this.loginLaunch = registerForActivityResult(new j(), new q());
        i mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            if (getActivity() instanceof MemberActivity) {
                mViewBinding.c.setVisibility(0);
            } else {
                mViewBinding.c.setVisibility(8);
            }
            mViewBinding.y.setOnClickListener(new r(this));
            i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (recyclerView = mViewBinding2.t) != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
                recyclerView.addItemDecoration(new h.a());
                h hVar = new h(this, N0(), this);
                this.taskAdapter = hVar;
                recyclerView.setAdapter(hVar);
            }
            H0();
            mViewBinding.u.setOnScrollChangeListener(new s(mViewBinding, this));
            v1(0.0f);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        MemberViewModel N0 = N0();
        N0.v().j(getViewLifecycleOwner(), new d(new t(this)));
        N0.A().j(getViewLifecycleOwner(), new d(new u(this)));
        N0.x().j(getViewLifecycleOwner(), new d(new e(this)));
        N0.D().j(getViewLifecycleOwner(), new d(new f(this)));
        N0.C().j(getViewLifecycleOwner(), new d(new g(this)));
        N0.B().j(getViewLifecycleOwner(), new d(new h(this)));
        N0().E();
        w1(this.mUserInfo);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void loadDefaultData() {
        LinearLayoutCompat linearLayoutCompat;
        RecyclerView recyclerView;
        LinearLayoutCompat linearLayoutCompat2;
        RecyclerView recyclerView2;
        super.loadDefaultData();
        try {
            Result.Companion companion = Result.Companion;
            im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
            if (bVar != null ? bVar.c() : false) {
                i mViewBinding = getMViewBinding();
                if (mViewBinding != null && (recyclerView2 = mViewBinding.r) != null) {
                    recyclerView2.setVisibility(0);
                }
                i mViewBinding2 = getMViewBinding();
                if (mViewBinding2 != null && (linearLayoutCompat2 = mViewBinding2.j) != null) {
                    linearLayoutCompat2.setVisibility(0);
                }
            } else {
                i mViewBinding3 = getMViewBinding();
                if (mViewBinding3 != null && (recyclerView = mViewBinding3.r) != null) {
                    recyclerView.setVisibility(8);
                }
                i mViewBinding4 = getMViewBinding();
                if (mViewBinding4 != null && (linearLayoutCompat = mViewBinding4.j) != null) {
                    linearLayoutCompat.setVisibility(8);
                }
            }
            Result.m34constructorimpl(Unit.a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m34constructorimpl(ResultKt.a(th));
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void logResume() {
        super.logResume();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public qi.b newLogViewConfig() {
        return new qi.b("memberdetail", false, 2, (DefaultConstructorMarker) null);
    }

    public final void o1(String str) {
        this.sceneId = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r3) {
        /*
            r2 = this;
            super.onCreate(r3)
            qx.a r3 = r2.getMLoginApi()
            r0 = 0
            if (r3 == 0) goto Lf
            com.transsnet.loginapi.bean.UserInfo r3 = r3.i()
            goto L10
        Lf:
            r3 = r0
        L10:
            r2.mUserInfo = r3
            if (r3 == 0) goto L19
            java.lang.String r3 = r3.getUserId()
            goto L1a
        L19:
            r3 = r0
        L1a:
            if (r3 == 0) goto L46
            int r3 = r3.length()
            if (r3 != 0) goto L23
            goto L46
        L23:
            com.transsnet.loginapi.bean.UserInfo r3 = r2.mUserInfo
            if (r3 == 0) goto L2c
            java.lang.String r3 = r3.getUserId()
            goto L2d
        L2c:
            r3 = r0
        L2d:
            qx.a r1 = r2.getMLoginApi()
            if (r1 == 0) goto L3d
            com.transsnet.loginapi.bean.UserInfo r1 = r1.i()
            if (r1 == 0) goto L3d
            java.lang.String r0 = r1.getUserId()
        L3d:
            boolean r3 = kotlin.jvm.internal.Intrinsics.c(r3, r0)
            if (r3 == 0) goto L44
            goto L46
        L44:
            r3 = 0
            goto L47
        L46:
            r3 = 1
        L47:
            r2.isSelf = r3
            qi.b r3 = r2.getLogViewConfig()
            if (r3 == 0) goto L5f
            java.util.HashMap r3 = r3.g()
            if (r3 == 0) goto L5f
            java.lang.String r0 = "scene_id"
            java.lang.String r1 = r2.sceneId
            java.lang.Object r3 = r3.put(r0, r1)
            java.lang.String r3 = (java.lang.String) r3
        L5f:
            com.transsion.memberapi.MemberSource r3 = r2.source
            java.lang.String r0 = "source"
            if (r3 == 0) goto L81
            qi.b r3 = r2.getLogViewConfig()
            if (r3 == 0) goto Lb2
            java.util.HashMap r3 = r3.g()
            if (r3 == 0) goto Lb2
            com.transsion.memberapi.MemberSource r1 = r2.source
            kotlin.jvm.internal.Intrinsics.e(r1)
            java.lang.String r1 = r1.getValue()
            java.lang.Object r3 = r3.put(r0, r1)
            java.lang.String r3 = (java.lang.String) r3
            goto Lb2
        L81:
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            boolean r3 = r3 instanceof com.transsion.member.MemberActivity
            if (r3 == 0) goto L9e
            qi.b r3 = r2.getLogViewConfig()
            if (r3 == 0) goto Lb2
            java.util.HashMap r3 = r3.g()
            if (r3 == 0) goto Lb2
            java.lang.String r1 = "OTHER"
            java.lang.Object r3 = r3.put(r0, r1)
            java.lang.String r3 = (java.lang.String) r3
            goto Lb2
        L9e:
            qi.b r3 = r2.getLogViewConfig()
            if (r3 == 0) goto Lb2
            java.util.HashMap r3 = r3.g()
            if (r3 == 0) goto Lb2
            java.lang.String r1 = "TAB"
            java.lang.Object r3 = r3.put(r0, r1)
            java.lang.String r3 = (java.lang.String) r3
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.MemberFragment.onCreate(android.os.Bundle):void");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        qx.a mLoginApi = getMLoginApi();
        if (mLoginApi != null) {
            mLoginApi.j(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                h1();
                logResume();
            }
        }
        k.h((String) null, this, hidden, (String) null, 9, (Object) null);
    }

    public void onLogin(UserInfo user) {
        Intrinsics.h(user, "user");
        b.a.a(this, user);
        h1();
        N0().r();
    }

    public void onLogout() {
        b.a.b(this);
        h1();
        N0().r();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        k.l((String) null, this, (String) null, 5, (Object) null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        h1();
        k.p((String) null, this, "visible=" + isVisible(), 1, (Object) null);
        if (this.isFirstResume) {
            this.isFirstResume = false;
        } else {
            N0().r();
        }
    }

    public void onUpdateUserInfo(UserInfo user) {
        Intrinsics.h(user, "user");
        if (getIsSelf()) {
            w1(user);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            b.a.a(bVar, (Function0) null, 1, (Object) null);
        }
    }

    public final void s1(MemberSource memberSource) {
        this.source = memberSource;
    }

    public final void showLoading() {
        M0().l0(this, "LoadingDialog");
    }

    public final void t1(int points) {
        List<SkuItem> skuPointList;
        PointView pointView;
        PointView pointView2;
        PointInfo pointInfo;
        MemberDetail memberDetail = this.memberDetail;
        if (memberDetail != null && (pointInfo = memberDetail.getPointInfo()) != null) {
            pointInfo.setPoint(points);
        }
        i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (pointView2 = mViewBinding.o) != null) {
            pointView2.setPoints(points);
        }
        i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (pointView = mViewBinding2.f) != null) {
            pointView.setPoints(points);
        }
        SkuData z = N0().z();
        if (z == null || (skuPointList = z.getSkuPointList()) == null) {
            return;
        }
        j1(skuPointList);
    }
}
