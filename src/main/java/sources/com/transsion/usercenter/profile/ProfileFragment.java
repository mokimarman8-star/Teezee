package com.transsion.usercenter.profile;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.text.t;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.b0;
import androidx.lifecycle.m;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.d;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.gyf.immersionbar.ImmersionBar;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.NoTouchToolBar;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.e;
import com.transsion.baseui.activity.k;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.usercenter.R;
import com.transsion.usercenter.edit.ProfileEditCenterActivity;
import com.transsion.usercenter.message.UserMessageActivity;
import com.transsion.usercenter.profile.bean.BlockInfo;
import com.transsion.usercenter.profile.bean.CoverUrl;
import com.transsion.usercenter.profile.bean.EntranceInfo;
import com.transsion.usercenter.profile.bean.Group;
import com.transsion.usercenter.profile.bean.ProfileEntranceInfo;
import com.transsion.usercenter.profile.bean.ProfileInfo;
import com.transsion.usercenter.profile.see.ProfileSeeActivity;
import com.transsion.usercenter.setting.SettingActivity;
import com.transsion.usercenter.widget.MyRoomView;
import com.transsion.usercenterapi.UpdateResultEvent;
import com.transsion.version.update.UpdateManager;
import com.transsion.wrapperad.view.NativeSlideshowView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.bean.UserInfo;
import f.j;
import ij.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kj.h;
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
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import ni.f;
import org.mvel2.ast.ASTNode;
import qx.a;
import qx.b;
import uf.c;
import wf.a;
import xu.j0;
import xu.r0;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 §\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001[B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0019\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J?\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010\u001fJ\u001b\u0010#\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010'\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020!H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010\u0006J\u000f\u0010*\u001a\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010\u0006J\u001b\u0010,\u001a\u00020\u0007*\u00020+2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u001dH\u0002¢\u0006\u0004\b.\u0010\u001fJ\u0019\u00101\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0007H\u0002¢\u0006\u0004\b3\u0010\u0006J\u0017\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00072\u0006\u00108\u001a\u000204H\u0002¢\u0006\u0004\b9\u00107J\u000f\u0010:\u001a\u00020\u0007H\u0002¢\u0006\u0004\b:\u0010\u0006J\u0017\u0010=\u001a\u00020\u00022\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010>J\u0019\u0010A\u001a\u00020\u00072\b\u0010@\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\bA\u0010BJ!\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020+2\b\u0010@\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\bD\u0010EJ!\u0010F\u001a\u00020\u00072\u0006\u0010C\u001a\u00020+2\b\u0010@\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\bF\u0010EJ\u000f\u0010G\u001a\u00020\u0007H\u0016¢\u0006\u0004\bG\u0010\u0006J\u0017\u0010I\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u001dH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0007H\u0016¢\u0006\u0004\bK\u0010\u0006J\u000f\u0010L\u001a\u00020\u0007H\u0016¢\u0006\u0004\bL\u0010\u0006J\u000f\u0010M\u001a\u00020\u0007H\u0016¢\u0006\u0004\bM\u0010\u0006J\u000f\u0010N\u001a\u00020\u0007H\u0016¢\u0006\u0004\bN\u0010\u0006J\u0017\u0010O\u001a\u00020\u00072\u0006\u0010C\u001a\u00020+H\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0007H\u0016¢\u0006\u0004\bQ\u0010\u0006J\u0017\u0010S\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\fH\u0016¢\u0006\u0004\bS\u0010\u000fJ\u0017\u0010T\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\fH\u0016¢\u0006\u0004\bT\u0010\u000fJ\u000f\u0010U\u001a\u00020\u0007H\u0016¢\u0006\u0004\bU\u0010\u0006J\u000f\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\bW\u0010XJ\u0015\u0010Z\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u001d¢\u0006\u0004\bZ\u0010JR\u0018\u0010]\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u001b\u0010f\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u001d\u0010o\u001a\u0004\u0018\u00010k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010c\u001a\u0004\bm\u0010nR\u001e\u0010t\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u001e\u0010v\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010sR\u0016\u0010y\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010\u007f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010xR \u0010\u0082\u0001\u001a\u0004\u0018\u00010k8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010c\u001a\u0005\b\u0081\u0001\u0010nR\u0019\u0010\u0085\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0084\u0001R \u0010\u008c\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0089\u0001\u0010c\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001f\u0010\u0090\u0001\u001a\u00020\u00148\u0006X\u0086D¢\u0006\u0010\n\u0006\b\u008d\u0001\u0010\u0084\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001f\u0010\u0093\u0001\u001a\u00020\u00148\u0006X\u0086D¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0084\u0001\u001a\u0006\b\u0092\u0001\u0010\u008f\u0001R)\u0010\u0098\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0084\u0001\u001a\u0006\b\u0095\u0001\u0010\u008f\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010\u009c\u0001\u001a\u00030\u0099\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0018\u0010 \u0001\u001a\u00030\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R(\u0010¦\u0001\u001a\u00020z8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b¡\u0001\u0010|\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001¨\u0006¨\u0001"}, d2 = {"Lcom/transsion/usercenter/profile/ProfileFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lxu/j0;", "Landroid/view/View$OnClickListener;", "Lqx/b;", "<init>", "()V", "", "g1", "G0", "D0", "O0", "Lcom/transsnet/loginapi/bean/UserInfo;", "userInfo", "m1", "(Lcom/transsnet/loginapi/bean/UserInfo;)V", "Lcom/transsion/usercenter/profile/bean/ProfileInfo;", "profileInfo", "k1", "(Lcom/transsion/usercenter/profile/bean/ProfileInfo;)V", "", "amount", "Lcom/transsion/usercenter/profile/bean/CoverUrl;", "url1", "url2", "url3", "url4", "h1", "(ILcom/transsion/usercenter/profile/bean/CoverUrl;Lcom/transsion/usercenter/profile/bean/CoverUrl;Lcom/transsion/usercenter/profile/bean/CoverUrl;Lcom/transsion/usercenter/profile/bean/CoverUrl;)V", "", "X0", "()Z", "W0", "", "alpha", "j1", "(Lxu/j0;F)V", "color", "fraction", "z0", "(IF)I", "d1", "refresh", "Landroid/view/View;", "A0", "(Landroid/view/View;F)V", "checkLogin", "Lcom/transsion/usercenter/profile/bean/EntranceInfo;", "entranceInfo", "F0", "(Lcom/transsion/usercenter/profile/bean/EntranceInfo;)V", "C0", "", "moduleName", "e1", "(Ljava/lang/String;)V", "tabName", "f1", "c1", "Landroid/view/LayoutInflater;", "inflater", "I0", "(Landroid/view/LayoutInflater;)Lxu/j0;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "onResume", "hidden", "onHiddenChanged", "(Z)V", "logPause", "onPause", "logResume", "lazyLoadData", "onClick", "(Landroid/view/View;)V", "onDestroy", "user", "onUpdateUserInfo", "onLogin", "onLogout", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "isExpand", "B0", "a", "Lcom/transsnet/loginapi/bean/UserInfo;", "mUserInfo", "b", "Lcom/transsion/usercenter/profile/bean/ProfileInfo;", "mProfileInfo", "Lcom/transsion/usercenter/profile/ProfileViewModel;", "c", "Lkotlin/Lazy;", "H0", "()Lcom/transsion/usercenter/profile/ProfileViewModel;", "mProfileViewModel", "Lcom/transsion/usercenter/profile/f;", "d", "Lcom/transsion/usercenter/profile/f;", "mNoticeMessageViewModel", "Lqx/a;", "e", "getLoginApi", "()Lqx/a;", "loginApi", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "f", "Landroidx/activity/result/b;", "loginLaunch", "g", "seeListLaunch", "h", "Z", "isNeedShowLoginActivity", "", "i", "J", "recordRefreshingTime", "j", "isSelf", "k", "getMLoginApi", "mLoginApi", "l", "I", "mTabSelectIndex", "m", "refreshTime", "Landroid/os/Handler;", "n", "getMHandler", "()Landroid/os/Handler;", "mHandler", "o", "getMaxStep", "()I", "maxStep", "p", "getStep", "step", "q", "getDefault", "setDefault", "(I)V", "default", "Lkj/h;", "r", "Lkj/h;", "mLoadingDialog", "Landroid/view/animation/DecelerateInterpolator;", "s", "Landroid/view/animation/DecelerateInterpolator;", "appbarChildAlphaDecelerateInterpolator", "t", "getResumeTimeStamp", "()J", "setResumeTimeStamp", "(J)V", "resumeTimeStamp", "u", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ProfileFragment extends BaseFragment<j0> implements View.OnClickListener, b {
    public static final a u = new a((DefaultConstructorMarker) null);

    /* renamed from: a, reason: from kotlin metadata */
    private UserInfo mUserInfo;

    /* renamed from: b, reason: from kotlin metadata */
    private ProfileInfo mProfileInfo;

    /* renamed from: c, reason: from kotlin metadata */
    private final Lazy mProfileViewModel;

    /* renamed from: d, reason: from kotlin metadata */
    private f mNoticeMessageViewModel;

    /* renamed from: e, reason: from kotlin metadata */
    private final Lazy loginApi;

    /* renamed from: f, reason: from kotlin metadata */
    private androidx.activity.result.b loginLaunch;

    /* renamed from: g, reason: from kotlin metadata */
    private androidx.activity.result.b seeListLaunch;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean isNeedShowLoginActivity;

    /* renamed from: i, reason: from kotlin metadata */
    private long recordRefreshingTime;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean isSelf;

    /* renamed from: k, reason: from kotlin metadata */
    private final Lazy mLoginApi;

    /* renamed from: l, reason: from kotlin metadata */
    private int mTabSelectIndex;

    /* renamed from: m, reason: from kotlin metadata */
    private int refreshTime;

    /* renamed from: n, reason: from kotlin metadata */
    private final Lazy mHandler;

    /* renamed from: o, reason: from kotlin metadata */
    private final int maxStep;

    /* renamed from: p, reason: from kotlin metadata */
    private final int step;

    /* renamed from: q, reason: from kotlin metadata */
    private int default;

    /* renamed from: r, reason: from kotlin metadata */
    private h mLoadingDialog;

    /* renamed from: s, reason: from kotlin metadata */
    private final DecelerateInterpolator appbarChildAlphaDecelerateInterpolator;

    /* renamed from: t, reason: from kotlin metadata */
    private long resumeTimeStamp;

    public ProfileFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.usercenter.profile.ProfileFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m30invoke() {
                return Fragment.this;
            }
        };
        this.mProfileViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(ProfileViewModel.class), new Function0<x0>() { // from class: com.transsion.usercenter.profile.ProfileFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m31invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.profile.ProfileFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m32invoke() {
                Object invoke = function0.invoke();
                m mVar = invoke instanceof m ? (m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.loginApi = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.g
            public final Object invoke() {
                a Z0;
                Z0 = ProfileFragment.Z0();
                return Z0;
            }
        });
        this.mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.r
            public final Object invoke() {
                a mLoginApi_delegate$lambda$1;
                mLoginApi_delegate$lambda$1 = ProfileFragment.mLoginApi_delegate$lambda$1();
                return mLoginApi_delegate$lambda$1;
            }
        });
        this.refreshTime = 15;
        this.mHandler = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.u
            public final Object invoke() {
                Handler a1;
                a1 = ProfileFragment.a1();
                return a1;
            }
        });
        this.maxStep = ASTNode.ASSIGN;
        this.step = 2;
        this.default = 1;
        this.appbarChildAlphaDecelerateInterpolator = new DecelerateInterpolator();
    }

    private final void A0(View view, float f) {
        view.setAlpha(f);
    }

    private final void C0() {
        if (isAdded()) {
            zg.g gVar = zg.g.a;
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            if (gVar.a(requireContext)) {
                refresh();
                return;
            }
            h hVar = this.mLoadingDialog;
            if (hVar == null) {
                Intrinsics.y("mLoadingDialog");
                hVar = null;
            }
            hVar.dismiss();
            com.tn.lib.widget.toast.core.h.a.k(R.string.no_network);
        }
    }

    private final void D0() {
        LinearLayoutCompat linearLayoutCompat;
        View view;
        View view2;
        TabLayout tabLayout;
        View view3;
        LinearLayoutCompat linearLayoutCompat2;
        LinearLayoutCompat linearLayoutCompat3;
        TnTextView tnTextView;
        LinearLayoutCompat linearLayoutCompat4;
        View view4;
        TnTextView tnTextView2;
        View view5;
        TabLayout tabLayout2;
        View view6;
        LinearLayoutCompat linearLayoutCompat5;
        LinearLayoutCompat linearLayoutCompat6;
        BlockInfo blockInfo;
        BlockInfo blockInfo2;
        ProfileInfo profileInfo = this.mProfileInfo;
        boolean block = (profileInfo == null || (blockInfo2 = profileInfo.getBlockInfo()) == null) ? false : blockInfo2.getBlock();
        ProfileInfo profileInfo2 = this.mProfileInfo;
        boolean blocked = (profileInfo2 == null || (blockInfo = profileInfo2.getBlockInfo()) == null) ? false : blockInfo.getBlocked();
        if (getIsSelf() || !(block || blocked)) {
            j0 mViewBinding = getMViewBinding();
            if (mViewBinding != null && (linearLayoutCompat3 = mViewBinding.B) != null) {
                linearLayoutCompat3.setVisibility(0);
            }
            j0 mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (linearLayoutCompat2 = mViewBinding2.w) != null) {
                linearLayoutCompat2.setVisibility(0);
            }
            j0 mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (view3 = mViewBinding3.R) != null) {
                view3.setVisibility(0);
            }
            j0 mViewBinding4 = getMViewBinding();
            if (mViewBinding4 != null && (tabLayout = mViewBinding4.E) != null) {
                tabLayout.setVisibility(0);
            }
            j0 mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (view2 = mViewBinding5.e) != null) {
                view2.setVisibility(0);
            }
            j0 mViewBinding6 = getMViewBinding();
            if (mViewBinding6 != null && (view = mViewBinding6.Y) != null) {
                view.setVisibility(8);
            }
            j0 mViewBinding7 = getMViewBinding();
            if (mViewBinding7 == null || (linearLayoutCompat = mViewBinding7.u) == null) {
                return;
            }
            linearLayoutCompat.setVisibility(8);
            return;
        }
        j0 mViewBinding8 = getMViewBinding();
        if (mViewBinding8 != null && (linearLayoutCompat6 = mViewBinding8.B) != null) {
            linearLayoutCompat6.setVisibility(4);
        }
        j0 mViewBinding9 = getMViewBinding();
        if (mViewBinding9 != null && (linearLayoutCompat5 = mViewBinding9.w) != null) {
            linearLayoutCompat5.setVisibility(4);
        }
        j0 mViewBinding10 = getMViewBinding();
        if (mViewBinding10 != null && (view6 = mViewBinding10.R) != null) {
            view6.setVisibility(4);
        }
        j0 mViewBinding11 = getMViewBinding();
        if (mViewBinding11 != null && (tabLayout2 = mViewBinding11.E) != null) {
            tabLayout2.setVisibility(4);
        }
        j0 mViewBinding12 = getMViewBinding();
        if (mViewBinding12 != null && (view5 = mViewBinding12.e) != null) {
            view5.setVisibility(4);
        }
        if (blocked) {
            j0 mViewBinding13 = getMViewBinding();
            if (mViewBinding13 != null && (tnTextView2 = mViewBinding13.H) != null) {
                tnTextView2.setTextById(R.string.str_block_been);
            }
        } else {
            j0 mViewBinding14 = getMViewBinding();
            if (mViewBinding14 != null && (tnTextView = mViewBinding14.H) != null) {
                tnTextView.setTextAction(new t(this));
            }
        }
        j0 mViewBinding15 = getMViewBinding();
        if (mViewBinding15 != null && (view4 = mViewBinding15.Y) != null) {
            view4.setVisibility(0);
        }
        j0 mViewBinding16 = getMViewBinding();
        if (mViewBinding16 == null || (linearLayoutCompat4 = mViewBinding16.u) == null) {
            return;
        }
        linearLayoutCompat4.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence E0(ProfileFragment profileFragment) {
        UserInfo userInfo;
        String string = profileFragment.getString(R.string.str_block_blocked);
        ProfileInfo profileInfo = profileFragment.mProfileInfo;
        return string + " " + ((profileInfo == null || (userInfo = profileInfo.getUserInfo()) == null) ? null : userInfo.getNickname());
    }

    private final void F0(EntranceInfo entranceInfo) {
        r0 r0Var;
        String jumpUrl;
        String title;
        j0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (r0Var = mViewBinding.f) == null) {
            return;
        }
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        boolean z = bVar != null ? bVar.z() : false;
        if (!getIsSelf() || entranceInfo == null || (jumpUrl = entranceInfo.getJumpUrl()) == null || jumpUrl.length() == 0 || (title = entranceInfo.getTitle()) == null || title.length() == 0 || !z) {
            ConstraintLayout b = r0Var.b();
            Intrinsics.g(b, "getRoot(...)");
            c.g(b);
        } else {
            ConstraintLayout b2 = r0Var.b();
            Intrinsics.g(b2, "getRoot(...)");
            c.k(b2);
            r0Var.d.setText(entranceInfo.getTitle());
            r0Var.b.setText(entranceInfo.getDescription());
        }
    }

    private final void G0() {
        ConstraintLayout constraintLayout;
        NoTouchToolBar noTouchToolBar;
        j0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (noTouchToolBar = mViewBinding.F) != null) {
            c.e(noTouchToolBar);
        }
        j0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (constraintLayout = mViewBinding2.G) != null) {
            c.e(constraintLayout);
        }
        ProfileActivity activity = getActivity();
        ProfileActivity profileActivity = activity instanceof ProfileActivity ? activity : null;
        if (profileActivity != null) {
            profileActivity.t0();
        }
    }

    private final ProfileViewModel H0() {
        return (ProfileViewModel) this.mProfileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(ProfileFragment profileFragment, ProfileInfo profileInfo) {
        if (profileInfo != null) {
            profileFragment.k1(profileInfo);
        }
        h hVar = profileFragment.mLoadingDialog;
        if (hVar == null) {
            Intrinsics.y("mLoadingDialog");
            hVar = null;
        }
        hVar.dismiss();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(ProfileFragment profileFragment, Pair pair) {
        MyRoomView myRoomView;
        List list;
        Unit unit = null;
        ArrayList h = CollectionsKt.h(new MyRoomView.b[]{null, null, null});
        profileFragment.getClass();
        if (pair != null && (list = (List) pair.getSecond()) != null) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                DownloadBean downloadBean = (DownloadBean) obj;
                h.set(i, new MyRoomView.b(downloadBean.getCover(), downloadBean.getType()));
                i = i2;
            }
        }
        try {
            Result.Companion companion = Result.Companion;
            j0 mViewBinding = profileFragment.getMViewBinding();
            if (mViewBinding != null && (myRoomView = mViewBinding.y) != null) {
                myRoomView.showDownloadsData(2, Integer.valueOf(pair != null ? ((Number) pair.getFirst()).intValue() : 0), (MyRoomView.b) h.get(0), (MyRoomView.b) h.get(1), (MyRoomView.b) h.get(2), new n(profileFragment));
                unit = Unit.a;
            }
            Result.m34constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m34constructorimpl(ResultKt.a(th));
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(ProfileFragment profileFragment) {
        profileFragment.e1("downloads");
        Navigator.x(TheRouter.c("/download/panel_activity"), profileFragment.requireContext(), (mf.c) null, 2, (Object) null);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(ProfileFragment profileFragment, ProfileEntranceInfo profileEntranceInfo) {
        profileFragment.F0(profileEntranceInfo != null ? profileEntranceInfo.getEntranceInfo() : null);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(ProfileFragment profileFragment, Integer num) {
        View view;
        View view2;
        j0 mViewBinding = profileFragment.getMViewBinding();
        if (mViewBinding != null && (view2 = mViewBinding.W) != null) {
            view2.setVisibility(num.intValue() > 0 ? 0 : 8);
        }
        j0 mViewBinding2 = profileFragment.getMViewBinding();
        if (mViewBinding2 != null && (view = mViewBinding2.X) != null) {
            view.setVisibility(num.intValue() > 0 ? 0 : 8);
        }
        return Unit.a;
    }

    private final void O0() {
        j0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mViewBinding.E, mViewBinding.S, new m(this));
            mViewBinding.E.addOnTabSelectedListener(new b());
            tabLayoutMediator.attach();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(ProfileFragment profileFragment, TabLayout.Tab tab, int i) {
        Intrinsics.h(tab, "tab");
        Context requireContext = profileFragment.requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        TnTextView tnTextView = new TnTextView(requireContext);
        Integer[] numArr = {Integer.valueOf(R.string.profile_post), Integer.valueOf(R.string.profile_like)};
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{androidx.core.content.b.getColor(profileFragment.requireContext(), R$color.text_01), androidx.core.content.b.getColor(profileFragment.requireContext(), R$color.text_02)});
        tnTextView.setTextById(numArr[i].intValue());
        tnTextView.setGravity(17);
        tnTextView.setTextSize(16.0f);
        tnTextView.setTextColor(colorStateList);
        tab.setCustomView(tnTextView);
        tab.view.setOnClickListener(new s(tab, profileFragment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(TabLayout.Tab tab, ProfileFragment profileFragment, View view) {
        ViewPager2 viewPager2;
        tab.select();
        j0 mViewBinding = profileFragment.getMViewBinding();
        if (mViewBinding == null || (viewPager2 = mViewBinding.S) == null || viewPager2.getCurrentItem() != 0) {
            profileFragment.f1("like");
        } else {
            profileFragment.f1("post");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(j0 j0Var, ProfileFragment profileFragment, UpdateResultEvent updateResultEvent) {
        Intrinsics.h(updateResultEvent, "it");
        if (updateResultEvent.getHasUpdate()) {
            j0Var.D.setVisibility(profileFragment.isSelf ? 0 : 8);
            j0Var.C.setVisibility(profileFragment.isSelf ? 0 : 8);
            j0Var.s.setVisibility(profileFragment.isSelf ? 0 : 8);
            j0Var.t.setVisibility(profileFragment.isSelf ? 0 : 8);
            j0Var.O.setVisibility(profileFragment.isSelf ? 0 : 8);
        } else {
            View view = j0Var.D;
            Intrinsics.g(view, "settingRedTips");
            c.g(view);
            View view2 = j0Var.C;
            Intrinsics.g(view2, "settingBlankRedTips");
            c.g(view2);
            AppCompatImageView appCompatImageView = j0Var.s;
            Intrinsics.g(appCompatImageView, "ivUpdate");
            c.g(appCompatImageView);
            AppCompatImageView appCompatImageView2 = j0Var.P;
            Intrinsics.g(appCompatImageView2, "updateRedTips");
            c.g(appCompatImageView2);
            AppCompatImageView appCompatImageView3 = j0Var.t;
            Intrinsics.g(appCompatImageView3, "ivUpdateBlank");
            c.g(appCompatImageView3);
            View view3 = j0Var.O;
            Intrinsics.g(view3, "updateBlankRedTips");
            c.g(view3);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(ProfileFragment profileFragment, j0 j0Var, AppBarLayout appBarLayout, int i) {
        profileFragment.j1(j0Var, Math.abs(i * 1.0f) / (appBarLayout != null ? appBarLayout.getTotalScrollRange() : i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(ProfileFragment profileFragment, float f, boolean z) {
        if (!z || f <= 0.0f || f >= 0.1f) {
            return;
        }
        Dialog dialog = profileFragment.mLoadingDialog;
        if (dialog == null) {
            Intrinsics.y("mLoadingDialog");
            dialog = null;
        }
        if (dialog.isShowing() || System.currentTimeMillis() - profileFragment.recordRefreshingTime <= 500) {
            return;
        }
        profileFragment.recordRefreshingTime = System.currentTimeMillis();
        profileFragment.C0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(ActivityResult activityResult) {
        Intrinsics.h(activityResult, "it");
        if (activityResult.getResultCode() == -1) {
            a.a.f(wf.a.a, "loginStatus", "登录成功", false, 4, (Object) null);
        } else {
            a.a.f(wf.a.a, "loginStatus", "登录失败或者取消", false, 4, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(ProfileFragment profileFragment, ActivityResult activityResult) {
        Intent data;
        ProfileInfo profileInfo;
        Intrinsics.h(activityResult, "it");
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null || (profileInfo = profileFragment.mProfileInfo) == null) {
            return;
        }
        profileInfo.getMySubject().setWantToSeeCount(data.getIntExtra("want2SeeCount", profileInfo.getMySubject().getWantToSeeCount()));
    }

    /* renamed from: W0, reason: from getter */
    private final boolean getIsSelf() {
        return this.isSelf;
    }

    private final boolean X0() {
        UserInfo i;
        qx.a mLoginApi = getMLoginApi();
        if (mLoginApi != null && (i = mLoginApi.i()) != null && i.getUserType() == 0 && getIsSelf()) {
            return true;
        }
        ProfileInfo profileInfo = this.mProfileInfo;
        return profileInfo != null && profileInfo.isVisitor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(j0 j0Var) {
        j0Var.S.setCurrentItem(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a Z0() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler a1() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(ProfileFragment profileFragment) {
        EntranceInfo entranceInfo;
        ProfileEntranceInfo profileEntranceInfo = (ProfileEntranceInfo) profileFragment.H0().l().f();
        if (profileEntranceInfo != null && (entranceInfo = profileEntranceInfo.getEntranceInfo()) != null) {
            String jumpUrl = entranceInfo.getJumpUrl();
            int jumpType = entranceInfo.getJumpType();
            StringBuilder sb = new StringBuilder();
            sb.append("jumpUrl :");
            sb.append(jumpUrl);
            sb.append(", jumpType:");
            sb.append(jumpType);
            if (jumpUrl == null || jumpUrl.length() == 0) {
                return Unit.a;
            }
            if (entranceInfo.getJumpType() == 2) {
                Navigator.x(TheRouter.c("/web/web").K("url", jumpUrl), profileFragment.requireContext(), (mf.c) null, 2, (Object) null);
            } else {
                hj.b bVar = hj.b.a;
                Context requireContext = profileFragment.requireContext();
                Intrinsics.g(requireContext, "requireContext(...)");
                hj.b.d(bVar, requireContext, jumpUrl, (hj.c) null, 4, (Object) null);
            }
        }
        return Unit.a;
    }

    private final void c1() {
        Navigator.x(TheRouter.c("/profile/qr_code"), requireContext(), (mf.c) null, 2, (Object) null);
    }

    private final boolean checkLogin() {
        qx.a loginApi = getLoginApi();
        if (loginApi == null || loginApi.a()) {
            return true;
        }
        androidx.activity.result.b bVar = this.loginLaunch;
        if (bVar == null) {
            this.isNeedShowLoginActivity = true;
        }
        if (bVar == null) {
            return false;
        }
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        bVar.a(loginApi.p(requireContext));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1() {
        if (isHidden()) {
            return;
        }
        ProfileViewModel H0 = H0();
        UserInfo userInfo = this.mUserInfo;
        H0.k(userInfo != null ? userInfo.getUserId() : null);
        if (this.isSelf) {
            H0().j();
            H0().i();
        }
    }

    private final void e1(String moduleName) {
        String str;
        String f;
        HashMap hashMap = new HashMap();
        UserInfo userInfo = this.mUserInfo;
        String str2 = "";
        if (userInfo == null || (str = userInfo.getUserId()) == null) {
            str = "";
        }
        hashMap.put("user_id", str);
        hashMap.put("user_status", this.isSelf ? "me" : "others");
        hashMap.put("module_name", moduleName);
        qi.h hVar = qi.h.a;
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (f = logViewConfig.f()) != null) {
            str2 = f;
        }
        hVar.o(str2, hashMap);
    }

    private final void f1(String tabName) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("page_tab_name", tabName);
        qi.h hVar = qi.h.a;
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (str = logViewConfig.f()) == null) {
            str = "";
        }
        hVar.o(str, hashMap);
    }

    private final void g1() {
        MyRoomView myRoomView;
        MyRoomView myRoomView2;
        View view;
        View view2;
        LinearLayoutCompat linearLayoutCompat;
        LinearLayoutCompat linearLayoutCompat2;
        TnTextView tnTextView;
        TnTextView tnTextView2;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        ShapeableImageView shapeableImageView;
        TnTextView tnTextView3;
        TnTextView tnTextView4;
        AppCompatTextView appCompatTextView3;
        ShapeableImageView shapeableImageView2;
        j0 mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = (mViewBinding == null || (shapeableImageView2 = mViewBinding.g) == null) ? null : shapeableImageView2.getLayoutParams();
        Intrinsics.f(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams2;
        j0 mViewBinding2 = getMViewBinding();
        ViewGroup.LayoutParams layoutParams3 = (mViewBinding2 == null || (appCompatTextView3 = mViewBinding2.N) == null) ? null : appCompatTextView3.getLayoutParams();
        Intrinsics.f(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams3;
        j0 mViewBinding3 = getMViewBinding();
        ViewGroup.LayoutParams layoutParams4 = (mViewBinding3 == null || (tnTextView4 = mViewBinding3.J) == null) ? null : tnTextView4.getLayoutParams();
        Intrinsics.f(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar3 = (ConstraintLayout.b) layoutParams4;
        j0 mViewBinding4 = getMViewBinding();
        ViewGroup.LayoutParams layoutParams5 = (mViewBinding4 == null || (tnTextView3 = mViewBinding4.M) == null) ? null : tnTextView3.getLayoutParams();
        Intrinsics.f(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar4 = (ConstraintLayout.b) layoutParams5;
        bVar.v = 0;
        bVar.setMarginStart(0);
        ((ViewGroup.MarginLayoutParams) bVar).topMargin = lj.a.b(32);
        j0 mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (shapeableImageView = mViewBinding5.g) != null) {
            shapeableImageView.setLayoutParams(bVar);
        }
        ((ViewGroup.MarginLayoutParams) bVar2).topMargin = lj.a.b(8);
        bVar2.setMarginStart(0);
        bVar2.setMarginEnd(0);
        ((ViewGroup.MarginLayoutParams) bVar2).width = -2;
        bVar2.i = -1;
        bVar2.k = -1;
        bVar2.s = -1;
        bVar2.v = -1;
        bVar2.O = -1;
        bVar2.N = 2;
        int i = R.id.iv_avatar;
        bVar2.j = i;
        bVar2.t = i;
        bVar2.u = R.id.tv_gender;
        j0 mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (appCompatTextView2 = mViewBinding6.N) != null) {
            appCompatTextView2.setLayoutParams(bVar2);
        }
        j0 mViewBinding7 = getMViewBinding();
        if (mViewBinding7 != null && (appCompatTextView = mViewBinding7.N) != null) {
            appCompatTextView.setMaxWidth(lj.a.b(200));
        }
        ((ViewGroup.MarginLayoutParams) bVar3).topMargin = 0;
        bVar3.setMarginStart(lj.a.b(4));
        bVar3.t = -1;
        bVar3.j = -1;
        int i2 = R.id.tv_user_name;
        bVar3.s = i2;
        bVar3.i = i2;
        bVar3.v = R.id.iv_avatar;
        bVar3.l = i2;
        j0 mViewBinding8 = getMViewBinding();
        if (mViewBinding8 != null && (tnTextView2 = mViewBinding8.J) != null) {
            tnTextView2.setLayoutParams(bVar3);
        }
        bVar4.setMarginStart(0);
        bVar4.s = -1;
        bVar4.l = -1;
        int i3 = R.id.iv_avatar;
        bVar4.t = i3;
        bVar4.v = i3;
        bVar4.j = R.id.tv_user_name;
        j0 mViewBinding9 = getMViewBinding();
        if (mViewBinding9 != null && (tnTextView = mViewBinding9.M) != null) {
            tnTextView.setLayoutParams(bVar4);
        }
        j0 mViewBinding10 = getMViewBinding();
        ViewGroup.LayoutParams layoutParams6 = (mViewBinding10 == null || (linearLayoutCompat2 = mViewBinding10.w) == null) ? null : linearLayoutCompat2.getLayoutParams();
        Intrinsics.f(layoutParams6, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams7 = (ConstraintLayout.b) layoutParams6;
        ((ConstraintLayout.b) layoutParams7).x = lj.a.b(71);
        j0 mViewBinding11 = getMViewBinding();
        if (mViewBinding11 != null && (linearLayoutCompat = mViewBinding11.w) != null) {
            linearLayoutCompat.setLayoutParams(layoutParams7);
        }
        j0 mViewBinding12 = getMViewBinding();
        if (mViewBinding12 != null && (view2 = mViewBinding12.Q) != null) {
            layoutParams = view2.getLayoutParams();
        }
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams8 = (ConstraintLayout.b) layoutParams;
        ((ConstraintLayout.b) layoutParams8).x = lj.a.b(71);
        j0 mViewBinding13 = getMViewBinding();
        if (mViewBinding13 != null && (view = mViewBinding13.Q) != null) {
            view.setLayoutParams(layoutParams8);
        }
        j0 mViewBinding14 = getMViewBinding();
        if (mViewBinding14 != null && (myRoomView2 = mViewBinding14.x) != null) {
            myRoomView2.resetUserUi();
        }
        j0 mViewBinding15 = getMViewBinding();
        if (mViewBinding15 == null || (myRoomView = mViewBinding15.z) == null) {
            return;
        }
        myRoomView.resetUserUi();
    }

    private final qx.a getLoginApi() {
        return (qx.a) this.loginApi.getValue();
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    private final qx.a getMLoginApi() {
        return (qx.a) this.mLoginApi.getValue();
    }

    private final void h1(int amount, CoverUrl url1, CoverUrl url2, CoverUrl url3, CoverUrl url4) {
        MyRoomView myRoomView;
        j0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (myRoomView = mViewBinding.z) == null) {
            return;
        }
        myRoomView.showCollectionData(3, getIsSelf(), Integer.valueOf(amount), url1, url2, url3, url4, new q(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(ProfileFragment profileFragment) {
        ProfileInfo profileInfo = profileFragment.mProfileInfo;
        if (profileInfo != null) {
            profileFragment.e1("want_to_see");
            Intent intent = new Intent(profileFragment.requireContext(), (Class<?>) ProfileSeeActivity.class);
            intent.putExtra("userId", profileInfo.getUserInfo().getUserId());
            androidx.activity.result.b bVar = profileFragment.seeListLaunch;
            if (bVar != null) {
                bVar.a(intent);
            }
        }
        return Unit.a;
    }

    private final void j1(j0 j0Var, float f) {
        View view;
        View view2;
        View view3;
        if (isAdded()) {
            float interpolation = f < 0.2f ? 0.0f : f < 0.4f ? this.appbarChildAlphaDecelerateInterpolator.getInterpolation((f - 0.2f) * 5.0f) : 1.0f;
            B0(interpolation == 1.0f);
            if (getIsSelf()) {
                AppCompatImageView appCompatImageView = j0Var.p;
                Intrinsics.g(appCompatImageView, "ivSetting");
                float f2 = 1 - interpolation;
                A0(appCompatImageView, f2);
                AppCompatImageView appCompatImageView2 = j0Var.q;
                Intrinsics.g(appCompatImageView2, "ivSettingBlank");
                A0(appCompatImageView2, interpolation);
                if (UpdateManager.f.a().g()) {
                    View view4 = j0Var.D;
                    Intrinsics.g(view4, "settingRedTips");
                    A0(view4, f2);
                    View view5 = j0Var.C;
                    Intrinsics.g(view5, "settingBlankRedTips");
                    A0(view5, interpolation);
                    AppCompatImageView appCompatImageView3 = j0Var.s;
                    Intrinsics.g(appCompatImageView3, "ivUpdate");
                    A0(appCompatImageView3, f2);
                    AppCompatImageView appCompatImageView4 = j0Var.P;
                    Intrinsics.g(appCompatImageView4, "updateRedTips");
                    A0(appCompatImageView4, f2);
                    AppCompatImageView appCompatImageView5 = j0Var.t;
                    Intrinsics.g(appCompatImageView5, "ivUpdateBlank");
                    A0(appCompatImageView5, interpolation);
                    View view6 = j0Var.O;
                    Intrinsics.g(view6, "updateBlankRedTips");
                    A0(view6, interpolation);
                }
                AppCompatImageView appCompatImageView6 = j0Var.l;
                Intrinsics.g(appCompatImageView6, "ivNotice");
                A0(appCompatImageView6, f2);
                View view7 = j0Var.W;
                Intrinsics.g(view7, "viewRed");
                A0(view7, f2);
                AppCompatImageView appCompatImageView7 = j0Var.n;
                Intrinsics.g(appCompatImageView7, "ivQrCode");
                A0(appCompatImageView7, f2);
                AppCompatImageView appCompatImageView8 = j0Var.m;
                Intrinsics.g(appCompatImageView8, "ivNoticeBlank");
                A0(appCompatImageView8, interpolation);
                View view8 = j0Var.X;
                Intrinsics.g(view8, "viewRedBlank");
                A0(view8, interpolation);
                AppCompatImageView appCompatImageView9 = j0Var.o;
                Intrinsics.g(appCompatImageView9, "ivQrCodeBlank");
                A0(appCompatImageView9, interpolation);
                j0 mViewBinding = getMViewBinding();
                if (mViewBinding != null && (view = mViewBinding.W) != null && view.getVisibility() == 0) {
                    j0 mViewBinding2 = getMViewBinding();
                    if (mViewBinding2 != null && (view3 = mViewBinding2.W) != null) {
                        A0(view3, f2);
                    }
                    j0 mViewBinding3 = getMViewBinding();
                    if (mViewBinding3 != null && (view2 = mViewBinding3.X) != null) {
                        A0(view2, interpolation);
                    }
                }
                AppCompatImageView appCompatImageView10 = j0Var.j;
                Intrinsics.g(appCompatImageView10, "ivMore");
                c.g(appCompatImageView10);
                AppCompatImageView appCompatImageView11 = j0Var.k;
                Intrinsics.g(appCompatImageView11, "ivMoreBlank");
                c.g(appCompatImageView11);
            } else {
                AppCompatImageView appCompatImageView12 = j0Var.j;
                Intrinsics.g(appCompatImageView12, "ivMore");
                A0(appCompatImageView12, 1 - interpolation);
                AppCompatImageView appCompatImageView13 = j0Var.k;
                Intrinsics.g(appCompatImageView13, "ivMoreBlank");
                A0(appCompatImageView13, interpolation);
                ConstraintLayout b = j0Var.f.b();
                Intrinsics.g(b, "getRoot(...)");
                c.g(b);
            }
            if (getActivity() instanceof ProfileActivity) {
                AppCompatImageView appCompatImageView14 = j0Var.h;
                Intrinsics.g(appCompatImageView14, "ivBack");
                c.k(appCompatImageView14);
                TnTextView tnTextView = j0Var.i;
                Intrinsics.g(tnTextView, "ivBackBlack");
                c.k(tnTextView);
                AppCompatImageView appCompatImageView15 = j0Var.h;
                Intrinsics.g(appCompatImageView15, "ivBack");
                A0(appCompatImageView15, 1 - interpolation);
                TnTextView tnTextView2 = j0Var.i;
                Intrinsics.g(tnTextView2, "ivBackBlack");
                A0(tnTextView2, interpolation);
            } else {
                j0Var.h.setVisibility(8);
                j0Var.i.setVisibility(8);
            }
            j0Var.F.setIntercept(!(interpolation == 0.0f));
            ShapeableImageView shapeableImageView = j0Var.r;
            Intrinsics.g(shapeableImageView, "ivTitleAvatar");
            A0(shapeableImageView, interpolation);
            TnTextView tnTextView3 = j0Var.L;
            Intrinsics.g(tnTextView3, "tvTitleUserName");
            A0(tnTextView3, interpolation);
            j0Var.F.setBackgroundColor(z0(androidx.core.content.b.getColor(requireContext(), R$color.bg_01), interpolation));
        }
    }

    private final void k1(ProfileInfo profileInfo) {
        f fVar;
        MyRoomView myRoomView;
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        this.mProfileInfo = profileInfo;
        m1(profileInfo.getUserInfo());
        j0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (myRoomView = mViewBinding.x) != null) {
            boolean isSelf = getIsSelf();
            Group myGroup = profileInfo.getMyGroup();
            myRoomView.showMyRoomData(1, isSelf, myGroup != null ? myGroup.getCount() : null, profileInfo.getMyGroupIconByIndex(0), profileInfo.getMyGroupIconByIndex(1), profileInfo.getMyGroupIconByIndex(2), profileInfo.getMyGroupIconByIndex(3), new l(this));
        }
        ArrayList h = CollectionsKt.h(new CoverUrl[]{null, null, null, null});
        List wantSubjects = profileInfo.getMySubject().getWantSubjects();
        if (wantSubjects != null) {
            int i = 0;
            for (Object obj : wantSubjects) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                CoverUrl coverUrl = (CoverUrl) obj;
                try {
                    Result.Companion companion = Result.Companion;
                    h.set(i, coverUrl);
                    Result.m34constructorimpl(Unit.a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m34constructorimpl(ResultKt.a(th));
                }
                i = i2;
            }
        }
        h1(profileInfo.getMySubject().getWantToSeeCount(), (CoverUrl) h.get(0), (CoverUrl) h.get(1), (CoverUrl) h.get(2), (CoverUrl) h.get(3));
        if (getIsSelf() && (fVar = this.mNoticeMessageViewModel) != null) {
            fVar.d();
        }
        D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(ProfileFragment profileFragment, int i) {
        if (i == 4) {
            profileFragment.e1("myrooms");
            if (profileFragment.getIsSelf()) {
                Navigator.x(TheRouter.c("/room/list"), profileFragment.requireContext(), (mf.c) null, 2, (Object) null);
            } else {
                Navigator c = TheRouter.c("/room/others_list");
                UserInfo userInfo = profileFragment.mUserInfo;
                Navigator.x(c.K("user_id", userInfo != null ? userInfo.getUserId() : null), profileFragment.requireContext(), (mf.c) null, 2, (Object) null);
            }
        } else if (i == 5 && profileFragment.getIsSelf()) {
            profileFragment.e1("addroom");
            Navigator.x(TheRouter.c("/room/home"), profileFragment.requireContext(), (mf.c) null, 2, (Object) null);
        }
        return Unit.a;
    }

    private final void m1(UserInfo userInfo) {
        HashMap g;
        if (userInfo == null) {
            return;
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g = logViewConfig.g()) != null) {
            String userId = userInfo.getUserId();
            if (userId == null) {
                userId = "";
            }
            g.put("user_id", userId);
            g.put("user_status", this.isSelf ? "me" : "others");
        }
        j0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.c.setForeground(androidx.core.content.b.getDrawable(requireContext(), R$color.cl31_30_p));
            ViewGroup.LayoutParams layoutParams = mViewBinding.c.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            ConstraintLayout.b layoutParams3 = mViewBinding.Q.getLayoutParams();
            Intrinsics.f(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = layoutParams3;
            if (X0()) {
                mViewBinding.K.setVisibility(0);
                mViewBinding.J.setVisibility(8);
                mViewBinding.I.setVisibility(8);
                f.a aVar = f.a;
                Context context = mViewBinding.g.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                String avatar = userInfo.getAvatar();
                if (avatar == null) {
                    avatar = "";
                }
                f.b i = m.g(avatar).i(R.mipmap.profile_visitor_avatar);
                ShapeableImageView shapeableImageView = mViewBinding.g;
                Intrinsics.g(shapeableImageView, "ivAvatar");
                i.d(shapeableImageView);
                Context context2 = mViewBinding.r.getContext();
                Intrinsics.g(context2, "getContext(...)");
                f.b m2 = aVar.m(context2);
                String avatar2 = userInfo.getAvatar();
                f.b i2 = m2.g(avatar2 != null ? avatar2 : "").i(R.mipmap.profile_visitor_avatar);
                ShapeableImageView shapeableImageView2 = mViewBinding.r;
                Intrinsics.g(shapeableImageView2, "ivTitleAvatar");
                i2.d(shapeableImageView2);
                layoutParams2.height = a0.a(getIsSelf() ? 176.0f : 185.0f) + d.c();
                ((ViewGroup.MarginLayoutParams) bVar).height = a0.a(106.0f) + d.c();
                bVar.j = mViewBinding.K.getId();
            } else {
                mViewBinding.K.setVisibility(8);
                mViewBinding.I.setVisibility(getIsSelf() ? 0 : 8);
                f.a aVar2 = f.a;
                Context context3 = mViewBinding.g.getContext();
                Intrinsics.g(context3, "getContext(...)");
                f.b i3 = aVar2.m(context3).g(userInfo.getAvatar()).i(R$mipmap.profile_default_avatar);
                ShapeableImageView shapeableImageView3 = mViewBinding.g;
                Intrinsics.g(shapeableImageView3, "ivAvatar");
                i3.d(shapeableImageView3);
                Context context4 = mViewBinding.r.getContext();
                Intrinsics.g(context4, "getContext(...)");
                f.b i4 = aVar2.m(context4).g(userInfo.getAvatar()).i(R$mipmap.profile_default_avatar);
                ShapeableImageView shapeableImageView4 = mViewBinding.r;
                Intrinsics.g(shapeableImageView4, "ivTitleAvatar");
                i4.d(shapeableImageView4);
                mViewBinding.J.setCompoundDrawablesWithIntrinsicBounds(userInfo.getGender() == 0 ? 0 : userInfo.getGender() == 1 ? R.mipmap.profile_man : R.mipmap.profile_female, 0, 0, 0);
                if (userInfo.getAge() <= 0) {
                    mViewBinding.J.setTextWithString("");
                } else if (userInfo.getGender() == 0) {
                    mViewBinding.J.setTextAction(new o(this, userInfo));
                } else {
                    mViewBinding.J.setTextWithString(String.valueOf(userInfo.getAge()));
                }
                if (userInfo.getGender() != 0 || userInfo.getAge() > 0) {
                    if (mViewBinding.J.getVisibility() != 0) {
                        mViewBinding.J.setVisibility(0);
                        ConstraintLayout.b layoutParams4 = mViewBinding.I.getLayoutParams();
                        Intrinsics.f(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        ConstraintLayout.b bVar2 = layoutParams4;
                        bVar2.setMarginStart(a0.a(8.0f));
                        mViewBinding.I.setLayoutParams(bVar2);
                    }
                } else if (mViewBinding.J.getVisibility() != 8) {
                    mViewBinding.J.setVisibility(8);
                    ConstraintLayout.b layoutParams5 = mViewBinding.I.getLayoutParams();
                    Intrinsics.f(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ConstraintLayout.b bVar3 = layoutParams5;
                    bVar3.setMarginStart(a0.a(16.0f));
                    mViewBinding.I.setLayoutParams(bVar3);
                }
                layoutParams2.height = a0.a(getIsSelf() ? 156.0f : 175.0f) + d.c();
                bVar.j = (mViewBinding.J.getVisibility() == 0 ? mViewBinding.J : mViewBinding.I).getId();
            }
            mViewBinding.c.setLayoutParams(layoutParams2);
            mViewBinding.Q.setLayoutParams(bVar);
            mViewBinding.L.setText(userInfo.getNickname());
            mViewBinding.N.setText(androidx.core.text.a.c().m(userInfo.getNickname(), t.a));
            mViewBinding.M.setTextAction(new p(this, userInfo));
            mViewBinding.p.setVisibility(getIsSelf() ? 0 : 8);
            if (UpdateManager.f.a().g()) {
                mViewBinding.D.setVisibility(getIsSelf() ? 0 : 8);
                mViewBinding.C.setVisibility(getIsSelf() ? 0 : 8);
                mViewBinding.s.setVisibility(getIsSelf() ? 0 : 8);
                mViewBinding.P.setVisibility(getIsSelf() ? 0 : 8);
                mViewBinding.t.setVisibility(getIsSelf() ? 0 : 8);
                mViewBinding.O.setVisibility(getIsSelf() ? 0 : 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a mLoginApi_delegate$lambda$1() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence n1(ProfileFragment profileFragment, UserInfo userInfo) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = profileFragment.getString(R.string.years_old);
        Intrinsics.g(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(userInfo.getAge())}, 1));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence o1(ProfileFragment profileFragment, UserInfo userInfo) {
        return profileFragment.getString(R.string.profile_one_room_id, userInfo.getUsername());
    }

    private final void refresh() {
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        com.transsion.usercenter.profile.adapter.b adapter;
        d1();
        j0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (viewPager22 = mViewBinding.S) != null && (adapter = viewPager22.getAdapter()) != null && (adapter instanceof com.transsion.usercenter.profile.adapter.b)) {
            adapter.h(this.mTabSelectIndex);
        }
        j0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (viewPager2 = mViewBinding2.S) == null) {
            return;
        }
        viewPager2.setCurrentItem(this.mTabSelectIndex);
    }

    private final int z0(int color, float fraction) {
        return Color.argb((int) (Color.alpha(color) * fraction), Color.red(color), Color.green(color), Color.blue(color));
    }

    public final void B0(boolean isExpand) {
        ImmersionBar with = ImmersionBar.with(this);
        boolean z = false;
        if (isExpand && !y.a.a()) {
            z = true;
        }
        with.statusBarDarkFont(z).init();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public j0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        j0 c = j0.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        b0 h;
        qx.a mLoginApi;
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        if (getIsSelf() && (mLoginApi = getMLoginApi()) != null) {
            mLoginApi.e(this);
        }
        ProfileViewModel H0 = H0();
        H0.p().j(getViewLifecycleOwner(), new e(new v(this)));
        H0.m().j(getViewLifecycleOwner(), new e(new w(this)));
        H0.l().j(getViewLifecycleOwner(), new e(new x(this)));
        m1(this.mUserInfo);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            f a = new v0(activity).a(f.class);
            this.mNoticeMessageViewModel = a;
            if (a != null && (h = a.h()) != null) {
                h.j(getViewLifecycleOwner(), new e(new y(this)));
            }
        }
        if (getIsSelf()) {
            H0().j();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        MyRoomView myRoomView;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        AppCompatImageView appCompatImageView4;
        AppCompatImageView appCompatImageView5;
        AppCompatImageView appCompatImageView6;
        MyRoomView myRoomView2;
        View view2;
        View view3;
        MyRoomView myRoomView3;
        View view4;
        MyRoomView myRoomView4;
        MyRoomView myRoomView5;
        Intrinsics.h(view, "view");
        G0();
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        this.mLoadingDialog = new h(requireContext);
        this.loginLaunch = registerForActivityResult(new j(), new b0());
        this.seeListLaunch = registerForActivityResult(new j(), new h(this));
        j0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.b.addOnOffsetChangedListener(new i(this, mViewBinding));
            j1(mViewBinding, 0.0f);
            mViewBinding.p.setVisibility(this.isSelf ? 0 : 8);
            if (UpdateManager.f.a().g()) {
                mViewBinding.D.setVisibility(this.isSelf ? 0 : 8);
                mViewBinding.s.setVisibility(this.isSelf ? 0 : 8);
                mViewBinding.P.setVisibility(this.isSelf ? 0 : 8);
                mViewBinding.t.setVisibility(this.isSelf ? 0 : 8);
                mViewBinding.O.setVisibility(this.isSelf ? 0 : 8);
            }
            CoordinatorLayout.f layoutParams = mViewBinding.b.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            FixAppBarLayoutBehavior f = layoutParams.f();
            if (f instanceof FixAppBarLayoutBehavior) {
                f.S0(new j(this));
            }
            k kVar = new k(mViewBinding, this);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = UpdateResultEvent.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, kVar);
            mViewBinding.p.setOnClickListener(this);
            mViewBinding.q.setOnClickListener(this);
            mViewBinding.s.setOnClickListener(this);
            mViewBinding.t.setOnClickListener(this);
            mViewBinding.j.setOnClickListener(this);
            mViewBinding.k.setOnClickListener(this);
            mViewBinding.l.setOnClickListener(this);
            mViewBinding.m.setOnClickListener(this);
            mViewBinding.K.setOnClickListener(this);
            mViewBinding.I.setOnClickListener(this);
            mViewBinding.g.setOnClickListener(this);
            mViewBinding.h.setOnClickListener(this);
            mViewBinding.i.setOnClickListener(this);
            mViewBinding.n.setOnClickListener(this);
            mViewBinding.f.c.setOnClickListener(this);
        }
        j0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (myRoomView5 = mViewBinding2.x) != null) {
            myRoomView5.setTitle(R.string.profile_my_room);
        }
        j0 mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (myRoomView4 = mViewBinding3.y) != null) {
            myRoomView4.setTitle(R.string.profile_my_downloads);
        }
        if (getIsSelf()) {
            j0 mViewBinding4 = getMViewBinding();
            if (mViewBinding4 == null || (myRoomView = mViewBinding4.z) == null) {
                return;
            }
            myRoomView.setTitle(R.string.profile_your_list);
            return;
        }
        j0 mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (view4 = mViewBinding5.T) != null) {
            view4.setVisibility(8);
        }
        j0 mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (myRoomView3 = mViewBinding6.y) != null) {
            myRoomView3.setVisibility(8);
        }
        j0 mViewBinding7 = getMViewBinding();
        if (mViewBinding7 != null && (view3 = mViewBinding7.U) != null) {
            view3.setVisibility(8);
        }
        j0 mViewBinding8 = getMViewBinding();
        if (mViewBinding8 != null && (view2 = mViewBinding8.V) != null) {
            view2.setVisibility(0);
        }
        j0 mViewBinding9 = getMViewBinding();
        if (mViewBinding9 != null && (myRoomView2 = mViewBinding9.z) != null) {
            myRoomView2.setTitle(R.string.profile_list);
        }
        j0 mViewBinding10 = getMViewBinding();
        if (mViewBinding10 != null && (appCompatImageView6 = mViewBinding10.n) != null) {
            c.g(appCompatImageView6);
        }
        j0 mViewBinding11 = getMViewBinding();
        if (mViewBinding11 != null && (appCompatImageView5 = mViewBinding11.o) != null) {
            c.g(appCompatImageView5);
        }
        j0 mViewBinding12 = getMViewBinding();
        if (mViewBinding12 != null && (appCompatImageView4 = mViewBinding12.j) != null) {
            c.g(appCompatImageView4);
        }
        j0 mViewBinding13 = getMViewBinding();
        if (mViewBinding13 != null && (appCompatImageView3 = mViewBinding13.k) != null) {
            c.g(appCompatImageView3);
        }
        j0 mViewBinding14 = getMViewBinding();
        if (mViewBinding14 != null && (appCompatImageView2 = mViewBinding14.l) != null) {
            c.g(appCompatImageView2);
        }
        j0 mViewBinding15 = getMViewBinding();
        if (mViewBinding15 != null && (appCompatImageView = mViewBinding15.m) != null) {
            c.g(appCompatImageView);
        }
        g1();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        j0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.S.setOffscreenPageLimit(1);
            ViewPager2 viewPager2 = mViewBinding.S;
            UserInfo userInfo = this.mUserInfo;
            viewPager2.setAdapter(new com.transsion.usercenter.profile.adapter.b(userInfo != null ? userInfo.getUserId() : null, this));
            mViewBinding.S.registerOnPageChangeCallback(new c(this));
            O0();
            if (X0()) {
                mViewBinding.S.post(new a0(mViewBinding));
            }
        }
        H0().i();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logPause() {
        super.logPause();
        if (this.resumeTimeStamp != 0) {
            e.a.n("profiledetail", Long.valueOf(SystemClock.elapsedRealtime() - this.resumeTimeStamp), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        this.resumeTimeStamp = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public qi.b newLogViewConfig() {
        return new qi.b("profiledetail", false, 2, (DefaultConstructorMarker) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        AppCompatImageView appCompatImageView4;
        BlockInfo blockInfo;
        BlockInfo blockInfo2;
        ShapeableImageView shapeableImageView;
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 1000L)) {
            return;
        }
        int id = view.getId();
        if (id == R.id.tv_login) {
            e1("login");
            qx.a mLoginApi = getMLoginApi();
            if (mLoginApi != null) {
                Context requireContext = requireContext();
                Intrinsics.g(requireContext, "requireContext(...)");
                mLoginApi.k(requireContext);
                return;
            }
            return;
        }
        boolean z = false;
        if (id == R.id.tv_find_movie) {
            e1("findmovies");
            Navigator.x(TheRouter.c("/main/tab").F("tabIndex", 0).K("topTab", "Trending"), requireContext(), (mf.c) null, 2, (Object) null);
            return;
        }
        if (id == R.id.iv_setting || id == R.id.iv_setting_blank) {
            e1("setting");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                SettingActivity.a aVar = SettingActivity.t;
                ProfileInfo profileInfo = this.mProfileInfo;
                aVar.a(activity, profileInfo != null ? profileInfo.getFissionState() : null);
                return;
            }
            return;
        }
        if (id == R.id.iv_update || id == R.id.iv_update_blank) {
            e1("update");
            if (UpdateManager.f.a().g()) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new onClick.2.1(activity2, this, (Continuation) null), 3, (Object) null);
                    return;
                }
                return;
            }
            j0 mViewBinding = getMViewBinding();
            if (mViewBinding != null && (appCompatImageView3 = mViewBinding.s) != null) {
                c.g(appCompatImageView3);
            }
            j0 mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (appCompatImageView2 = mViewBinding2.P) != null) {
                c.g(appCompatImageView2);
            }
            j0 mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (appCompatImageView = mViewBinding3.t) != null) {
                c.g(appCompatImageView);
            }
            j0 mViewBinding4 = getMViewBinding();
            if (mViewBinding4 == null || (view2 = mViewBinding4.O) == null) {
                return;
            }
            c.g(view2);
            return;
        }
        if (id == R.id.iv_notice_blank || id == R.id.iv_notice) {
            e1("notice");
            startActivity(new Intent(getActivity(), (Class<?>) UserMessageActivity.class));
            f fVar = this.mNoticeMessageViewModel;
            if (fVar != null) {
                fVar.e();
                return;
            }
            return;
        }
        if (id == R.id.tv_edit) {
            e1("editinfo");
            if (checkLogin()) {
                com.transsion.usercenter.edit.u a = com.transsion.usercenter.edit.u.b.a();
                j0 mViewBinding5 = getMViewBinding();
                a.f((mViewBinding5 == null || (shapeableImageView = mViewBinding5.g) == null) ? null : shapeableImageView.getDrawable());
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    ProfileEditCenterActivity.a aVar2 = ProfileEditCenterActivity.b;
                    ProfileInfo profileInfo2 = this.mProfileInfo;
                    aVar2.a(activity3, profileInfo2 != null ? profileInfo2.getUserInfo() : null);
                    return;
                }
                return;
            }
            return;
        }
        if (id == R.id.iv_back || id == R.id.iv_back_black) {
            FragmentActivity activity4 = getActivity();
            if (activity4 != null) {
                activity4.onBackPressed();
                return;
            }
            return;
        }
        if (id != R.id.iv_more && id != R.id.iv_more_blank) {
            if (id == R.id.tvJump) {
                com.transsion.baseui.util.d.b(0L, new z(this), 1, (Object) null);
                return;
            } else {
                if (id == R.id.iv_qr_code || id == R.id.iv_qr_code_blank) {
                    c1();
                    return;
                }
                return;
            }
        }
        if (this.mProfileInfo == null) {
            return;
        }
        iv.c cVar = new iv.c();
        j0 mViewBinding6 = getMViewBinding();
        if (mViewBinding6 == null || (appCompatImageView4 = mViewBinding6.j) == null) {
            return;
        }
        ProfileInfo profileInfo3 = this.mProfileInfo;
        if (profileInfo3 != null && (blockInfo2 = profileInfo3.getBlockInfo()) != null) {
            z = blockInfo2.getBlock();
        }
        ProfileInfo profileInfo4 = this.mProfileInfo;
        cVar.g(appCompatImageView4, (profileInfo4 == null || (blockInfo = profileInfo4.getBlockInfo()) == null || !blockInfo.getBlocked()) ? z : true);
        cVar.f(new d(this));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        boolean z;
        j0 mViewBinding;
        j0 mViewBinding2;
        NativeSlideshowView nativeSlideshowView;
        NativeSlideshowView nativeSlideshowView2;
        JsonElement jsonElement;
        UserInfo i;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String str = null;
        this.mUserInfo = (UserInfo) (arguments != null ? arguments.getSerializable("userInfo") : null);
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("userId") : null;
        if (this.mUserInfo == null) {
            if (string == null || string.length() == 0) {
                qx.a loginApi = getLoginApi();
                this.mUserInfo = loginApi != null ? loginApi.i() : null;
            } else {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(string);
                this.mUserInfo = userInfo;
            }
        }
        UserInfo userInfo2 = this.mUserInfo;
        String userId = userInfo2 != null ? userInfo2.getUserId() : null;
        if (userId != null && userId.length() != 0) {
            UserInfo userInfo3 = this.mUserInfo;
            String userId2 = userInfo3 != null ? userInfo3.getUserId() : null;
            qx.a mLoginApi = getMLoginApi();
            if (mLoginApi != null && (i = mLoginApi.i()) != null) {
                str = i.getUserId();
            }
            if (!Intrinsics.c(userId2, str)) {
                z = false;
                this.isSelf = z;
                JsonObject b = com.transsion.ad.scene.d.a.b("ProfileDetailBottomScene");
                this.refreshTime = (b != null || (jsonElement = b.get("refreshTime")) == null) ? 15 : jsonElement.getAsInt();
                mViewBinding = getMViewBinding();
                if (mViewBinding != null && (nativeSlideshowView2 = mViewBinding.A) != null) {
                    nativeSlideshowView2.setSceneId("ProfileDetailBottomScene");
                }
                mViewBinding2 = getMViewBinding();
                if (mViewBinding2 != null || (nativeSlideshowView = mViewBinding2.A) == null) {
                }
                nativeSlideshowView.initAd();
                return;
            }
        }
        z = true;
        this.isSelf = z;
        JsonObject b2 = com.transsion.ad.scene.d.a.b("ProfileDetailBottomScene");
        this.refreshTime = (b2 != null || (jsonElement = b2.get("refreshTime")) == null) ? 15 : jsonElement.getAsInt();
        mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            nativeSlideshowView2.setSceneId("ProfileDetailBottomScene");
        }
        mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        NativeSlideshowView nativeSlideshowView;
        qx.a mLoginApi;
        super.onDestroy();
        if (getIsSelf() && (mLoginApi = getMLoginApi()) != null) {
            mLoginApi.j(this);
        }
        getMHandler().removeCallbacksAndMessages(null);
        j0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (nativeSlideshowView = mViewBinding.A) == null) {
            return;
        }
        nativeSlideshowView.destroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                d1();
                logResume();
            }
        }
        k.h((String) null, this, hidden, (String) null, 9, (Object) null);
    }

    public void onLogin(UserInfo user) {
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        RecyclerView.Adapter adapter;
        ViewPager2 viewPager23;
        Intrinsics.h(user, "user");
        if (getIsSelf()) {
            this.mUserInfo = user;
            this.mProfileInfo = null;
            j0 mViewBinding = getMViewBinding();
            if (mViewBinding != null && (viewPager23 = mViewBinding.S) != null) {
                UserInfo userInfo = this.mUserInfo;
                viewPager23.setAdapter(new com.transsion.usercenter.profile.adapter.b(userInfo != null ? userInfo.getUserId() : null, this));
            }
            j0 mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (viewPager22 = mViewBinding2.S) != null && (adapter = viewPager22.getAdapter()) != null) {
                adapter.notifyDataSetChanged();
            }
            j0 mViewBinding3 = getMViewBinding();
            if (mViewBinding3 == null || (viewPager2 = mViewBinding3.S) == null) {
                return;
            }
            viewPager2.setCurrentItem(this.mTabSelectIndex);
        }
    }

    public void onLogout() {
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        RecyclerView.Adapter adapter;
        ViewPager2 viewPager23;
        if (getIsSelf()) {
            qx.a loginApi = getLoginApi();
            this.mUserInfo = loginApi != null ? loginApi.i() : null;
            this.mProfileInfo = null;
            ProfileViewModel H0 = H0();
            UserInfo userInfo = this.mUserInfo;
            H0.k(userInfo != null ? userInfo.getUserId() : null);
            this.mTabSelectIndex = 1;
            j0 mViewBinding = getMViewBinding();
            if (mViewBinding != null && (viewPager23 = mViewBinding.S) != null) {
                UserInfo userInfo2 = this.mUserInfo;
                viewPager23.setAdapter(new com.transsion.usercenter.profile.adapter.b(userInfo2 != null ? userInfo2.getUserId() : null, this));
            }
            j0 mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (viewPager22 = mViewBinding2.S) != null && (adapter = viewPager22.getAdapter()) != null) {
                adapter.notifyDataSetChanged();
            }
            j0 mViewBinding3 = getMViewBinding();
            if (mViewBinding3 == null || (viewPager2 = mViewBinding3.S) == null) {
                return;
            }
            viewPager2.setCurrentItem(this.mTabSelectIndex);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        k.l((String) null, this, (String) null, 5, (Object) null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d1();
        k.p((String) null, this, "visible=" + isVisible(), 1, (Object) null);
    }

    public void onUpdateUserInfo(UserInfo user) {
        Intrinsics.h(user, "user");
        if (getIsSelf()) {
            m1(user);
        }
    }
}
