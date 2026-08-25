package com.transsion.room.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.therouter.TheRouter;
import com.tn.lib.view.CheckInAnimationView;
import com.tn.lib.view.ToolBarCheckInAnimationView;
import com.tn.lib.view.expand.ExpandView;
import com.tn.lib.widget.R;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.widget.PileLayout;
import com.transsion.flow.bean.RoomItem;
import com.transsion.flow.bean.RoomNet;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.view.PublishStateView;
import com.transsion.room.R$drawable;
import com.transsion.room.R$string;
import com.transsion.room.activity.CreateRoomActivity;
import com.transsion.room.viewmodel.RoomDetailViewModel;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import ni.f;
import wf.a;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 o2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002>pB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0013\u0010\n\u001a\u00020\u0005*\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J)\u0010-\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\"H\u0016¢\u0006\u0004\b/\u0010$J\u0017\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0019H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0005H\u0016¢\u0006\u0004\b6\u0010\u0004J\u000f\u00107\u001a\u00020\u0005H\u0016¢\u0006\u0004\b7\u0010\u0004J\u000f\u00108\u001a\u00020\u0005H\u0016¢\u0006\u0004\b8\u0010\u0004J\u000f\u00109\u001a\u00020\u0005H\u0016¢\u0006\u0004\b9\u0010\u0004J\u000f\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0005H\u0016¢\u0006\u0004\b=\u0010\u0004R\u0016\u0010@\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u001e\u0010G\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001e\u0010I\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u0018\u0010L\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010BR\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u001d\u0010d\u001a\u0004\u0018\u00010`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010X\u001a\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010j\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010?R\u0016\u0010l\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010BR\u0016\u0010n\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010B¨\u0006q"}, d2 = {"Lcom/transsion/room/fragment/RoomDetailFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lfp/n;", "<init>", "()V", BuildConfig.FLAVOR, "D0", "N0", "H0", "Lcom/tn/lib/view/CheckInAnimationView;", "B0", "(Lcom/tn/lib/view/CheckInAnimationView;)V", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "roomItem", "c1", "(Lcom/transsion/moviedetailapi/bean/RoomItem;)V", "Landroid/view/View;", "tvCheckIn", "Landroid/widget/TextView;", "tvEdit", "X0", "(Landroid/view/View;Landroid/widget/TextView;)V", "C0", "V0", "b1", BuildConfig.FLAVOR, "coverUrl", "Z0", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "position", "F0", "(I)Ljava/lang/String;", "U0", BuildConfig.FLAVOR, "checkLogin", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "isAudioShowNoNetworkLayout", "Landroid/view/LayoutInflater;", "inflater", "G0", "(Landroid/view/LayoutInflater;)Lfp/n;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "retryLoadData", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "loadDefaultData", "a", "I", "mTabSelectIndex", "b", "Z", "isNeedShowLoginActivity", "Landroidx/activity/result/b;", "c", "Landroidx/activity/result/b;", "loginLaunch", "d", "updateInfoLaunch", "e", "Ljava/lang/String;", "mGroupId", "f", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "mRoomDetailItem", "Lcom/transsion/share/share/ShareDialogFragment;", "g", "Lcom/transsion/share/share/ShareDialogFragment;", "mShareDialog", "h", "netResultSuccess", "Lcom/transsion/room/viewmodel/RoomDetailViewModel;", "i", "Lkotlin/Lazy;", "E0", "()Lcom/transsion/room/viewmodel/RoomDetailViewModel;", "roomDetailViewModel", "Lcb/n;", "j", "Lcb/n;", "shapeModel", "Lqx/a;", "k", "getLoginApi", "()Lqx/a;", "loginApi", "Lcom/transsion/room/fragment/RoomDetailFragment$CollapsingToolbarLayoutState;", "l", "Lcom/transsion/room/fragment/RoomDetailFragment$CollapsingToolbarLayoutState;", "state", "m", "sz", "n", "dealWith80", "o", "dealWithElse", "p", "CollapsingToolbarLayoutState", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomDetailFragment extends PageStatusFragment<fp.n> {

    /* renamed from: a, reason: from kotlin metadata */
    private int mTabSelectIndex;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean isNeedShowLoginActivity;

    /* renamed from: c, reason: from kotlin metadata */
    private androidx.activity.result.b loginLaunch;

    /* renamed from: d, reason: from kotlin metadata */
    private androidx.activity.result.b updateInfoLaunch;

    /* renamed from: e, reason: from kotlin metadata */
    private String mGroupId;

    /* renamed from: f, reason: from kotlin metadata */
    private RoomItem mRoomDetailItem;

    /* renamed from: g, reason: from kotlin metadata */
    private ShareDialogFragment mShareDialog;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean netResultSuccess;

    /* renamed from: i, reason: from kotlin metadata */
    private final Lazy roomDetailViewModel;

    /* renamed from: j, reason: from kotlin metadata */
    private cb.n shapeModel;

    /* renamed from: k, reason: from kotlin metadata */
    private final Lazy loginApi;

    /* renamed from: l, reason: from kotlin metadata */
    private CollapsingToolbarLayoutState state;

    /* renamed from: m, reason: from kotlin metadata */
    private final int sz;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean dealWith80;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean dealWithElse;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/transsion/room/fragment/RoomDetailFragment$CollapsingToolbarLayoutState;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", "INTERNEDIATE", "TOOLBAR", "APPBAR", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class CollapsingToolbarLayoutState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CollapsingToolbarLayoutState[] $VALUES;
        public static final CollapsingToolbarLayoutState EXPANDED = new CollapsingToolbarLayoutState("EXPANDED", 0);
        public static final CollapsingToolbarLayoutState COLLAPSED = new CollapsingToolbarLayoutState("COLLAPSED", 1);
        public static final CollapsingToolbarLayoutState INTERNEDIATE = new CollapsingToolbarLayoutState("INTERNEDIATE", 2);
        public static final CollapsingToolbarLayoutState TOOLBAR = new CollapsingToolbarLayoutState("TOOLBAR", 3);
        public static final CollapsingToolbarLayoutState APPBAR = new CollapsingToolbarLayoutState("APPBAR", 4);

        private static final /* synthetic */ CollapsingToolbarLayoutState[] $values() {
            return new CollapsingToolbarLayoutState[]{EXPANDED, COLLAPSED, INTERNEDIATE, TOOLBAR, APPBAR};
        }

        static {
            CollapsingToolbarLayoutState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private CollapsingToolbarLayoutState(String str, int i) {
        }

        public static EnumEntries<CollapsingToolbarLayoutState> getEntries() {
            return $ENTRIES;
        }

        public static CollapsingToolbarLayoutState valueOf(String str) {
            return (CollapsingToolbarLayoutState) Enum.valueOf(CollapsingToolbarLayoutState.class, str);
        }

        public static CollapsingToolbarLayoutState[] values() {
            return (CollapsingToolbarLayoutState[]) $VALUES.clone();
        }
    }

    public static final class b implements TabLayout.OnTabSelectedListener {
        b() {
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabSelected(TabLayout.Tab tab) {
            TextView textView = (TextView) (tab != null ? tab.getCustomView() : null);
            if (textView != null) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
            }
            if (RoomDetailFragment.this.isVisible()) {
                HashMap hashMap = new HashMap();
                String str = RoomDetailFragment.this.mGroupId;
                if (str == null) {
                    str = BuildConfig.FLAVOR;
                }
                hashMap.put("group_id", str);
                hashMap.put("page_tab_name", RoomDetailFragment.this.F0(tab != null ? tab.getPosition() : 0));
                com.transsion.baselib.helper.a.a.l("groupdetail", hashMap);
            }
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            TextView textView = (TextView) (tab != null ? tab.getCustomView() : null);
            if (textView != null) {
                textView.setTypeface(Typeface.defaultFromStyle(0));
            }
        }
    }

    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        public void onPageSelected(int i) {
            super.onPageSelected(i);
            RoomDetailFragment.this.mTabSelectIndex = i;
        }
    }

    static final class d implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        d(Function1 function1) {
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

    public static final class e implements com.transsion.share.share.a {
        e() {
        }

        @Override // com.transsion.share.share.a
        public void a(String str, PostType postType) {
            Intrinsics.h(str, "id");
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
            a.C0056a.b(this, str);
        }

        @Override // com.transsion.share.share.a
        public void c(String str, String str2, String str3, String str4) {
            Intrinsics.h(str, "url");
            Intrinsics.h(str2, "fileName");
            Intrinsics.h(str3, "fileSize");
            Intrinsics.h(str4, "fileImage");
        }

        @Override // com.transsion.share.share.a
        public void d(String str) {
            String str2;
            Intrinsics.h(str, "id");
            if (com.transsion.baseui.util.c.a.a(2, 2000L) || (str2 = RoomDetailFragment.this.mGroupId) == null) {
                return;
            }
            RoomDetailFragment.this.E0().x(str2);
        }

        @Override // com.transsion.share.share.a
        public void e(String str) {
            a.C0056a.c(this, str);
        }
    }

    public RoomDetailFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.room.fragment.RoomDetailFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m152invoke() {
                return this;
            }
        };
        this.roomDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(RoomDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.room.fragment.RoomDetailFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.x0 m153invoke() {
                androidx.lifecycle.x0 viewModelStore = ((androidx.lifecycle.y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.room.fragment.RoomDetailFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m154invoke() {
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
        cb.n m = cb.n.a().q(0, 20.0f).p(cb.n.m).m();
        Intrinsics.g(m, "build(...)");
        this.shapeModel = m;
        this.loginApi = LazyKt.b(new Function0() { // from class: com.transsion.room.fragment.f
            public final Object invoke() {
                qx.a T0;
                T0 = RoomDetailFragment.T0();
                return T0;
            }
        });
        this.sz = com.blankj.utilcode.util.a0.a(20.0f);
    }

    private final void B0(CheckInAnimationView checkInAnimationView) {
        String str;
        int currentState = checkInAnimationView.getCurrentState();
        if (currentState == 2 || currentState == 4) {
            return;
        }
        if (currentState == 1) {
            checkInAnimationView.upDateState(2);
            C0();
        } else {
            if (currentState != 3) {
                return;
            }
            checkInAnimationView.upDateState(4);
            if (com.transsion.baseui.util.c.a.a(2, 2000L) || (str = this.mGroupId) == null) {
                return;
            }
            E0().x(str);
        }
    }

    private final void C0() {
        RoomItem roomItem;
        String groupId;
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        CheckInAnimationView checkInAnimationView;
        if (!checkLogin() || com.transsion.baseui.util.c.a.a(1, 2000L) || (roomItem = this.mRoomDetailItem) == null || (groupId = roomItem.getGroupId()) == null) {
            return;
        }
        E0().w(groupId);
        fp.n nVar = (fp.n) getMViewBinding();
        if (nVar != null && (checkInAnimationView = nVar.t) != null) {
            checkInAnimationView.upDateState(2);
        }
        fp.n nVar2 = (fp.n) getMViewBinding();
        if (nVar2 != null && (toolBarCheckInAnimationView = nVar2.r) != null) {
            toolBarCheckInAnimationView.upDateState(2);
        }
        D0();
        com.transsion.baselib.helper.a.a.h("groupdetail", "checkin", (r16 & 4) != 0 ? BuildConfig.FLAVOR : this.mGroupId, (r16 & 8) != 0 ? BuildConfig.FLAVOR : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
    }

    private final void D0() {
        String str = this.mGroupId;
        if (str != null) {
            E0().p(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoomDetailViewModel E0() {
        return (RoomDetailViewModel) this.roomDetailViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String F0(int position) {
        String string = getString(position == 0 ? R$string.hot : R$string.s_new);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    private final void H0() {
        AppBarLayout appBarLayout;
        PublishStateView publishStateView;
        AppCompatImageView appCompatImageView;
        fp.n nVar = (fp.n) getMViewBinding();
        if (nVar != null && (appCompatImageView = nVar.f) != null) {
            appCompatImageView.setImageResource(R.mipmap.icon_white_back);
        }
        fp.n nVar2 = (fp.n) getMViewBinding();
        if (nVar2 != null && (publishStateView = nVar2.h) != null) {
            publishStateView.setImageResource(R.mipmap.libui_ic_base_whit_publish);
        }
        fp.n nVar3 = (fp.n) getMViewBinding();
        if (nVar3 == null || (appBarLayout = nVar3.b) == null) {
            return;
        }
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.room.fragment.i
            public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                RoomDetailFragment.I0(RoomDetailFragment.this, appBarLayout2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(RoomDetailFragment roomDetailFragment, AppBarLayout appBarLayout, int i) {
        AppCompatTextView appCompatTextView;
        TextView textView;
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        ShapeableImageView shapeableImageView;
        PublishStateView publishStateView;
        PublishStateView publishStateView2;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        Toolbar toolbar;
        Toolbar toolbar2;
        Toolbar toolbar3;
        Toolbar toolbar4;
        ViewGroup.LayoutParams layoutParams;
        PublishStateView publishStateView3;
        AppCompatImageView appCompatImageView3;
        AppCompatImageView appCompatImageView4;
        PublishStateView publishStateView4;
        AppCompatTextView appCompatTextView2;
        ShapeableImageView shapeableImageView2;
        PublishStateView publishStateView5;
        AppCompatImageView appCompatImageView5;
        AppCompatImageView appCompatImageView6;
        Toolbar toolbar5;
        Toolbar toolbar6;
        Toolbar toolbar7;
        Toolbar toolbar8;
        ViewGroup.LayoutParams layoutParams2;
        if (i == 0) {
            roomDetailFragment.state = CollapsingToolbarLayoutState.EXPANDED;
            return;
        }
        if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            roomDetailFragment.state = CollapsingToolbarLayoutState.COLLAPSED;
            return;
        }
        roomDetailFragment.state = CollapsingToolbarLayoutState.INTERNEDIATE;
        if (Math.abs(i) <= com.blankj.utilcode.util.a0.a(80.0f)) {
            if (roomDetailFragment.dealWithElse) {
                return;
            }
            roomDetailFragment.dealWithElse = true;
            roomDetailFragment.dealWith80 = false;
            roomDetailFragment.state = CollapsingToolbarLayoutState.APPBAR;
            fp.n nVar = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar != null && (toolbar4 = nVar.o) != null && (layoutParams = toolbar4.getLayoutParams()) != null) {
                layoutParams.height = com.blankj.utilcode.util.a0.a(44.0f);
            }
            fp.n nVar2 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar2 != null && (toolbar3 = nVar2.o) != null) {
                toolbar3.setPadding(0, 0, 0, 0);
            }
            fp.n nVar3 = (fp.n) roomDetailFragment.getMViewBinding();
            ViewGroup.LayoutParams layoutParams3 = (nVar3 == null || (toolbar2 = nVar3.o) == null) ? null : toolbar2.getLayoutParams();
            if (layoutParams3 instanceof CollapsingToolbarLayout.c) {
                ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.c) layoutParams3)).topMargin = com.blankj.utilcode.util.d.c();
            }
            fp.n nVar4 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar4 != null && (toolbar = nVar4.o) != null) {
                toolbar.setBackgroundResource(R.color.transparent);
            }
            fp.n nVar5 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar5 != null && (appCompatImageView2 = nVar5.f) != null) {
                appCompatImageView2.setImageResource(R.mipmap.icon_white_back);
            }
            fp.n nVar6 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar6 != null && (appCompatImageView = nVar6.k) != null) {
                appCompatImageView.setImageResource(R.mipmap.libui_ic_base_whit_share);
            }
            fp.n nVar7 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar7 != null && (publishStateView2 = nVar7.h) != null) {
                publishStateView2.setImageResource(R.mipmap.libui_ic_base_whit_publish);
            }
            fp.n nVar8 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar8 != null && (publishStateView = nVar8.h) != null) {
                publishStateView.setProgressColor(Color.parseColor("#FF5ABF"));
            }
            fp.n nVar9 = (fp.n) roomDetailFragment.getMViewBinding();
            CheckInAnimationView checkInAnimationView = nVar9 != null ? nVar9.t : null;
            fp.n nVar10 = (fp.n) roomDetailFragment.getMViewBinding();
            roomDetailFragment.X0(checkInAnimationView, nVar10 != null ? nVar10.u : null);
            fp.n nVar11 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar11 != null && (shapeableImageView = nVar11.g) != null) {
                uf.c.g(shapeableImageView);
            }
            fp.n nVar12 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar12 != null && (toolBarCheckInAnimationView = nVar12.r) != null) {
                uf.c.g(toolBarCheckInAnimationView);
            }
            fp.n nVar13 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar13 != null && (textView = nVar13.s) != null) {
                uf.c.g(textView);
            }
            fp.n nVar14 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar14 == null || (appCompatTextView = nVar14.y) == null) {
                return;
            }
            uf.c.g(appCompatTextView);
            return;
        }
        if (roomDetailFragment.dealWith80) {
            return;
        }
        roomDetailFragment.dealWith80 = true;
        roomDetailFragment.dealWithElse = false;
        roomDetailFragment.state = CollapsingToolbarLayoutState.TOOLBAR;
        fp.n nVar15 = (fp.n) roomDetailFragment.getMViewBinding();
        if (nVar15 != null && (toolbar8 = nVar15.o) != null && (layoutParams2 = toolbar8.getLayoutParams()) != null) {
            layoutParams2.height = com.blankj.utilcode.util.a0.a(44.0f) + com.blankj.utilcode.util.d.c();
        }
        fp.n nVar16 = (fp.n) roomDetailFragment.getMViewBinding();
        if (nVar16 != null && (toolbar7 = nVar16.o) != null) {
            toolbar7.setPadding(0, com.blankj.utilcode.util.d.c(), 0, 0);
        }
        fp.n nVar17 = (fp.n) roomDetailFragment.getMViewBinding();
        ViewGroup.LayoutParams layoutParams4 = (nVar17 == null || (toolbar6 = nVar17.o) == null) ? null : toolbar6.getLayoutParams();
        if (layoutParams4 instanceof CollapsingToolbarLayout.c) {
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.c) layoutParams4)).topMargin = 0;
        }
        fp.n nVar18 = (fp.n) roomDetailFragment.getMViewBinding();
        if (nVar18 != null && (toolbar5 = nVar18.o) != null) {
            toolbar5.setBackgroundResource(R.color.bg_01);
        }
        if (ij.y.a.a()) {
            fp.n nVar19 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar19 != null && (appCompatImageView6 = nVar19.f) != null) {
                appCompatImageView6.setImageResource(R.mipmap.icon_white_back);
            }
            fp.n nVar20 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar20 != null && (appCompatImageView5 = nVar20.k) != null) {
                appCompatImageView5.setImageResource(R.mipmap.libui_ic_base_whit_share);
            }
            fp.n nVar21 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar21 != null && (publishStateView5 = nVar21.h) != null) {
                publishStateView5.setImageResource(R.mipmap.libui_ic_base_whit_publish);
            }
        } else {
            fp.n nVar22 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar22 != null && (appCompatImageView4 = nVar22.f) != null) {
                appCompatImageView4.setImageResource(R.mipmap.libui_ic_base_black_left);
            }
            fp.n nVar23 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar23 != null && (appCompatImageView3 = nVar23.k) != null) {
                appCompatImageView3.setImageResource(R.mipmap.libui_ic_base_black_share);
            }
            fp.n nVar24 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar24 != null && (publishStateView3 = nVar24.h) != null) {
                publishStateView3.setImageResource(R.mipmap.libui_ic_base_black_publish);
            }
        }
        fp.n nVar25 = (fp.n) roomDetailFragment.getMViewBinding();
        if (nVar25 != null && (shapeableImageView2 = nVar25.g) != null) {
            uf.c.k(shapeableImageView2);
        }
        fp.n nVar26 = (fp.n) roomDetailFragment.getMViewBinding();
        ToolBarCheckInAnimationView toolBarCheckInAnimationView2 = nVar26 != null ? nVar26.r : null;
        fp.n nVar27 = (fp.n) roomDetailFragment.getMViewBinding();
        roomDetailFragment.X0(toolBarCheckInAnimationView2, nVar27 != null ? nVar27.s : null);
        fp.n nVar28 = (fp.n) roomDetailFragment.getMViewBinding();
        if (nVar28 != null && (appCompatTextView2 = nVar28.y) != null) {
            RoomItem roomItem = roomDetailFragment.mRoomDetailItem;
            appCompatTextView2.setText(roomItem != null ? roomItem.getName() : null);
            uf.c.k(appCompatTextView2);
        }
        fp.n nVar29 = (fp.n) roomDetailFragment.getMViewBinding();
        if (nVar29 == null || (publishStateView4 = nVar29.h) == null) {
            return;
        }
        publishStateView4.setProgressColor(Color.parseColor("#ffffff"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(RoomDetailFragment roomDetailFragment, CheckInAnimationView checkInAnimationView, View view) {
        roomDetailFragment.B0(checkInAnimationView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(RoomDetailFragment roomDetailFragment, ToolBarCheckInAnimationView toolBarCheckInAnimationView, View view) {
        roomDetailFragment.B0(toolBarCheckInAnimationView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(RoomDetailFragment roomDetailFragment, ActivityResult activityResult) {
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        CheckInAnimationView checkInAnimationView;
        Intrinsics.h(activityResult, "it");
        if (activityResult.getResultCode() == -1) {
            roomDetailFragment.C0();
            return;
        }
        fp.n nVar = (fp.n) roomDetailFragment.getMViewBinding();
        if (nVar != null && (checkInAnimationView = nVar.t) != null) {
            checkInAnimationView.upDateState(1);
        }
        fp.n nVar2 = (fp.n) roomDetailFragment.getMViewBinding();
        if (nVar2 == null || (toolBarCheckInAnimationView = nVar2.r) == null) {
            return;
        }
        toolBarCheckInAnimationView.upDateState(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(RoomDetailFragment roomDetailFragment, ActivityResult activityResult) {
        Intrinsics.h(activityResult, "it");
        if (activityResult.getResultCode() == -1) {
            roomDetailFragment.D0();
        }
    }

    private final void N0() {
        fp.n nVar = (fp.n) getMViewBinding();
        if (nVar != null) {
            TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(nVar.l.d, nVar.z, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.transsion.room.fragment.s
                public final void onConfigureTab(TabLayout.Tab tab, int i) {
                    RoomDetailFragment.O0(RoomDetailFragment.this, tab, i);
                }
            });
            nVar.l.d.addOnTabSelectedListener(new b());
            if (nVar.z.getAdapter() != null) {
                tabLayoutMediator.attach();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(RoomDetailFragment roomDetailFragment, TabLayout.Tab tab, int i) {
        Intrinsics.h(tab, "tab");
        TextView textView = new TextView(roomDetailFragment.requireContext());
        String[] strArr = {roomDetailFragment.getString(R$string.hot), roomDetailFragment.getString(R$string.s_new)};
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{androidx.core.content.b.getColor(roomDetailFragment.requireContext(), R.color.text_01), androidx.core.content.b.getColor(roomDetailFragment.requireContext(), R.color.text_02)});
        textView.setText(strArr[i]);
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setTextColor(colorStateList);
        tab.setCustomView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(RoomDetailFragment roomDetailFragment, View view) {
        FragmentActivity activity = roomDetailFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(RoomDetailFragment roomDetailFragment, RoomItem roomItem) {
        roomDetailFragment.showContentView();
        if (roomItem == null) {
            PageStatusFragment.showEmptyView$default(roomDetailFragment, false, 1, (Object) null);
        } else {
            roomDetailFragment.c1(roomItem);
            roomDetailFragment.netResultSuccess = true;
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(RoomDetailFragment roomDetailFragment, RoomNet roomNet) {
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        CheckInAnimationView checkInAnimationView;
        CheckInAnimationView checkInAnimationView2;
        ToolBarCheckInAnimationView toolBarCheckInAnimationView2;
        CheckInAnimationView checkInAnimationView3;
        ToolBarCheckInAnimationView toolBarCheckInAnimationView3;
        if (roomNet == null) {
            if (roomDetailFragment.state == CollapsingToolbarLayoutState.INTERNEDIATE) {
                fp.n nVar = (fp.n) roomDetailFragment.getMViewBinding();
                if (nVar != null && (toolBarCheckInAnimationView3 = nVar.r) != null) {
                    toolBarCheckInAnimationView3.setVisibility(0);
                }
            } else {
                fp.n nVar2 = (fp.n) roomDetailFragment.getMViewBinding();
                if (nVar2 != null && (checkInAnimationView2 = nVar2.t) != null) {
                    checkInAnimationView2.setVisibility(0);
                }
            }
            fp.n nVar3 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar3 != null && (checkInAnimationView3 = nVar3.t) != null) {
                checkInAnimationView3.upDateState(1);
            }
            fp.n nVar4 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar4 != null && (toolBarCheckInAnimationView2 = nVar4.r) != null) {
                toolBarCheckInAnimationView2.upDateState(1);
            }
        } else {
            RoomItem roomItem = roomDetailFragment.mRoomDetailItem;
            if (roomItem != null) {
                roomItem.setHasJoin(Boolean.TRUE);
            }
            fp.n nVar5 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar5 != null && (checkInAnimationView = nVar5.t) != null) {
                checkInAnimationView.upDateState(3);
            }
            fp.n nVar6 = (fp.n) roomDetailFragment.getMViewBinding();
            if (nVar6 != null && (toolBarCheckInAnimationView = nVar6.r) != null) {
                toolBarCheckInAnimationView.upDateState(3);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(RoomDetailFragment roomDetailFragment, RoomNet roomNet) {
        if (roomNet != null) {
            roomDetailFragment.D0();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a T0() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    private final void U0() {
        fp.n nVar;
        PublishStateView publishStateView;
        RoomItem roomItem = this.mRoomDetailItem;
        if (roomItem == null || (nVar = (fp.n) getMViewBinding()) == null || (publishStateView = nVar.h) == null) {
            return;
        }
        String str = this.mGroupId;
        String str2 = str == null ? BuildConfig.FLAVOR : str;
        String avatar = roomItem.getAvatar();
        String str3 = avatar == null ? BuildConfig.FLAVOR : avatar;
        String name = roomItem.getName();
        PublishStateView.publishSource$default(publishStateView, 4, null, null, null, null, str2, name == null ? BuildConfig.FLAVOR : name, str3, false, 286, null);
    }

    private final void V0() {
        AppCompatImageView appCompatImageView;
        fp.n nVar = (fp.n) getMViewBinding();
        if (nVar == null || (appCompatImageView = nVar.k) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomDetailFragment.W0(RoomDetailFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(RoomDetailFragment roomDetailFragment, View view) {
        ShareDialogFragment a;
        ShareDialogFragment shareDialogFragment;
        ShareDialogFragment.Companion companion = ShareDialogFragment.INSTANCE;
        PostType postType = PostType.GROUP_TYPE;
        String str = roomDetailFragment.mGroupId;
        RoomItem roomItem = roomDetailFragment.mRoomDetailItem;
        String creatorId = roomItem != null ? roomItem.getCreatorId() : null;
        String value = ReportType.GROUP.getValue();
        RoomItem roomItem2 = roomDetailFragment.mRoomDetailItem;
        a = companion.a(postType, str, creatorId, value, (r29 & 16) != 0 ? BuildConfig.FLAVOR : roomItem2 != null ? roomItem2.getName() : null, (r29 & 32) != 0 ? BuildConfig.FLAVOR : BuildConfig.FLAVOR, (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : false, (r29 & 256) != 0 ? false : false, "groupdetail", (r29 & 1024) != 0 ? BuildConfig.FLAVOR : null, (r29 & 2048) != 0 ? BuildConfig.FLAVOR : null);
        roomDetailFragment.mShareDialog = a;
        if (a != null) {
            a.G0(roomDetailFragment.new e());
        }
        FragmentManager childFragmentManager = roomDetailFragment.getChildFragmentManager();
        childFragmentManager.g0();
        ShareDialogFragment shareDialogFragment2 = roomDetailFragment.mShareDialog;
        if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.k0("share") == null && (shareDialogFragment = roomDetailFragment.mShareDialog) != null) {
            shareDialogFragment.show(childFragmentManager, "share");
        }
        com.transsion.baselib.helper.a.a.h("groupdetail", "share", (r16 & 4) != 0 ? BuildConfig.FLAVOR : roomDetailFragment.mGroupId, (r16 & 8) != 0 ? BuildConfig.FLAVOR : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
    }

    private final void X0(View tvCheckIn, TextView tvEdit) {
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        CheckInAnimationView checkInAnimationView;
        ToolBarCheckInAnimationView toolBarCheckInAnimationView2;
        CheckInAnimationView checkInAnimationView2;
        UserInfo i;
        RoomItem roomItem = this.mRoomDetailItem;
        if (!TextUtils.isEmpty(roomItem != null ? roomItem.getCreatorId() : null)) {
            qx.a loginApi = getLoginApi();
            String userId = (loginApi == null || (i = loginApi.i()) == null) ? null : i.getUserId();
            RoomItem roomItem2 = this.mRoomDetailItem;
            if (TextUtils.equals(userId, roomItem2 != null ? roomItem2.getCreatorId() : null)) {
                if (tvCheckIn != null) {
                    uf.c.g(tvCheckIn);
                }
                if (tvEdit != null) {
                    uf.c.k(tvEdit);
                }
                if (tvEdit != null) {
                    tvEdit.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.h
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            RoomDetailFragment.Y0(RoomDetailFragment.this, view);
                        }
                    });
                    return;
                }
                return;
            }
        }
        if (tvCheckIn != null) {
            uf.c.k(tvCheckIn);
        }
        if (tvEdit != null) {
            uf.c.g(tvEdit);
        }
        RoomItem roomItem3 = this.mRoomDetailItem;
        if (roomItem3 != null ? Intrinsics.c(roomItem3.getHasJoin(), Boolean.TRUE) : false) {
            fp.n nVar = (fp.n) getMViewBinding();
            if (nVar != null && (checkInAnimationView2 = nVar.t) != null) {
                checkInAnimationView2.upDateState(3);
            }
            fp.n nVar2 = (fp.n) getMViewBinding();
            if (nVar2 == null || (toolBarCheckInAnimationView2 = nVar2.r) == null) {
                return;
            }
            toolBarCheckInAnimationView2.upDateState(3);
            return;
        }
        fp.n nVar3 = (fp.n) getMViewBinding();
        if (nVar3 != null && (checkInAnimationView = nVar3.t) != null) {
            checkInAnimationView.upDateState(1);
        }
        fp.n nVar4 = (fp.n) getMViewBinding();
        if (nVar4 == null || (toolBarCheckInAnimationView = nVar4.r) == null) {
            return;
        }
        toolBarCheckInAnimationView.upDateState(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(RoomDetailFragment roomDetailFragment, View view) {
        Intent intent = new Intent((Context) roomDetailFragment.requireActivity(), (Class<?>) CreateRoomActivity.class);
        intent.putExtra("field_key", roomDetailFragment.mRoomDetailItem);
        intent.putExtra("field_type", "type_edit");
        androidx.activity.result.b bVar = roomDetailFragment.updateInfoLaunch;
        if (bVar != null) {
            bVar.a(intent);
        }
        com.transsion.baselib.helper.a.a.h("groupdetail", "edit_room", (r16 & 4) != 0 ? BuildConfig.FLAVOR : roomDetailFragment.mGroupId, (r16 & 8) != 0 ? BuildConfig.FLAVOR : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
    }

    private final void Z0(String coverUrl) {
        ExpandView expandView;
        ShapeableImageView shapeableImageView;
        ViewGroup.LayoutParams layoutParams;
        fp.n nVar = (fp.n) getMViewBinding();
        Integer valueOf = (nVar == null || (shapeableImageView = nVar.j) == null || (layoutParams = shapeableImageView.getLayoutParams()) == null) ? null : Integer.valueOf(layoutParams.width);
        f.a aVar = ni.f.a;
        String e2 = f.a.e(aVar, coverUrl, valueOf != null ? valueOf.intValue() : 0, false, false, 12, null);
        fp.n nVar2 = (fp.n) getMViewBinding();
        if (nVar2 != null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            f.b g = aVar.m(requireContext).g(coverUrl);
            ShapeableImageView shapeableImageView2 = nVar2.j;
            Intrinsics.g(shapeableImageView2, "ivRoomCover");
            g.d(shapeableImageView2);
            Context requireContext2 = requireContext();
            Intrinsics.g(requireContext2, "requireContext(...)");
            f.b g2 = aVar.m(requireContext2).g(coverUrl);
            ShapeableImageView shapeableImageView3 = nVar2.g;
            Intrinsics.g(shapeableImageView3, "ivCoverSmall");
            g2.d(shapeableImageView3);
        }
        Glide.with(requireContext()).asBitmap().load(e2).into(new CustomTarget() { // from class: com.transsion.room.fragment.RoomDetailFragment$showCover$2
            public void onLoadCleared(Drawable drawable) {
            }

            public void onResourceReady(Bitmap bitmap, Transition transition) {
                Intrinsics.h(bitmap, "resource");
                a.a.f(wf.a.a, "RoomDetailFragment", "success", false, 4, (Object) null);
                kotlinx.coroutines.i.d(androidx.lifecycle.v.a(RoomDetailFragment.this), kotlinx.coroutines.y0.c(), (CoroutineStart) null, new RoomDetailFragment$showCover$2$onResourceReady$1(bitmap, RoomDetailFragment.this, null), 2, (Object) null);
            }
        });
        fp.n nVar3 = (fp.n) getMViewBinding();
        if (nVar3 == null || (expandView = nVar3.w) == null) {
            return;
        }
        expandView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.transsion.room.fragment.j
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                RoomDetailFragment.a1(RoomDetailFragment.this, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(RoomDetailFragment roomDetailFragment, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fp.n nVar = (fp.n) roomDetailFragment.getMViewBinding();
        if (nVar != null) {
            ViewGroup.LayoutParams layoutParams = nVar.c.getLayoutParams();
            int i9 = i4 - i2;
            int i10 = i8 - i6;
            if (layoutParams != null) {
                layoutParams.height += i9 - i10;
            }
            nVar.c.setLayoutParams(layoutParams);
        }
    }

    private final void b1() {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        Long postCount;
        PileLayout pileLayout;
        List<String> memberAvatars;
        List<String> memberAvatars2;
        PileLayout pileLayout2;
        fp.n nVar = (fp.n) getMViewBinding();
        if (nVar != null && (pileLayout2 = nVar.m) != null) {
            pileLayout2.removeAllViews();
        }
        RoomItem roomItem = this.mRoomDetailItem;
        int size = (roomItem == null || (memberAvatars2 = roomItem.getMemberAvatars()) == null) ? 0 : memberAvatars2.size();
        for (int i = 0; i < size; i++) {
            RoomItem roomItem2 = this.mRoomDetailItem;
            String str = (roomItem2 == null || (memberAvatars = roomItem2.getMemberAvatars()) == null) ? null : memberAvatars.get(i);
            ImageView shapeableImageView = new ShapeableImageView(getContext());
            shapeableImageView.setShapeAppearanceModel(this.shapeModel);
            if (str != null) {
                f.a aVar = ni.f.a;
                Context requireContext = requireContext();
                Intrinsics.g(requireContext, "requireContext(...)");
                aVar.m(requireContext).g(str).i(R$drawable.ic_avatar_default).m(this.sz).c(this.sz).d(shapeableImageView);
            }
            fp.n nVar2 = (fp.n) getMViewBinding();
            if (nVar2 != null && (pileLayout = nVar2.m) != null) {
                int i2 = this.sz;
                pileLayout.addView(shapeableImageView, i2, i2);
            }
        }
        RoomItem roomItem3 = this.mRoomDetailItem;
        long longValue = (roomItem3 == null || (postCount = roomItem3.getPostCount()) == null) ? 0L : postCount.longValue();
        if (longValue > 0) {
            fp.n nVar3 = (fp.n) getMViewBinding();
            if (nVar3 != null && (appCompatTextView2 = nVar3.v) != null) {
                uf.c.k(appCompatTextView2);
            }
            fp.n nVar4 = (fp.n) getMViewBinding();
            if (nVar4 == null || (appCompatTextView = nVar4.v) == null) {
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String string = getString(R$string.member_count_check_in);
            Intrinsics.g(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(longValue)}, 1));
            Intrinsics.g(format, "format(...)");
            appCompatTextView.setText(format);
        }
    }

    private final void c1(RoomItem roomItem) {
        HashMap g;
        String avatar;
        ExpandView expandView;
        AppCompatTextView appCompatTextView;
        this.mRoomDetailItem = roomItem;
        if (TextUtils.equals(roomItem.getLevel(), "LIMIT") && com.transsion.baselib.report.launch.b.a.b().getBoolean("adult_restricted", true)) {
            new AdultRestrictedDialogFragment().show(requireActivity().getSupportFragmentManager(), "AdultRestrictedDialogFragment");
        }
        fp.n nVar = (fp.n) getMViewBinding();
        if (nVar != null && (appCompatTextView = nVar.x) != null) {
            appCompatTextView.setText(roomItem.getName());
        }
        fp.n nVar2 = (fp.n) getMViewBinding();
        if (nVar2 != null && (expandView = nVar2.w) != null) {
            RoomItem roomItem2 = this.mRoomDetailItem;
            expandView.setTitle(roomItem2 != null ? roomItem2.getDescription() : null);
        }
        CollapsingToolbarLayoutState collapsingToolbarLayoutState = this.state;
        if (collapsingToolbarLayoutState == CollapsingToolbarLayoutState.INTERNEDIATE || collapsingToolbarLayoutState == CollapsingToolbarLayoutState.COLLAPSED) {
            fp.n nVar3 = (fp.n) getMViewBinding();
            ToolBarCheckInAnimationView toolBarCheckInAnimationView = nVar3 != null ? nVar3.r : null;
            fp.n nVar4 = (fp.n) getMViewBinding();
            X0(toolBarCheckInAnimationView, nVar4 != null ? nVar4.s : null);
        } else {
            fp.n nVar5 = (fp.n) getMViewBinding();
            CheckInAnimationView checkInAnimationView = nVar5 != null ? nVar5.t : null;
            fp.n nVar6 = (fp.n) getMViewBinding();
            X0(checkInAnimationView, nVar6 != null ? nVar6.u : null);
        }
        b1();
        RoomItem roomItem3 = this.mRoomDetailItem;
        if (roomItem3 != null && (avatar = roomItem3.getAvatar()) != null) {
            Z0(avatar);
        }
        N0();
        E0().v(roomItem);
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        qi.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g = logViewConfig2.g()) != null) {
            RoomItem roomItem4 = this.mRoomDetailItem;
            g.put("group_id", roomItem4 != null ? roomItem4.getGroupId() : null);
        }
        V0();
        U0();
    }

    private final boolean checkLogin() {
        Intent p;
        androidx.activity.result.b bVar;
        qx.a loginApi = getLoginApi();
        if (loginApi == null || loginApi.a()) {
            return true;
        }
        if (this.loginLaunch == null) {
            this.isNeedShowLoginActivity = true;
        }
        Context context = getContext();
        if (context == null || (p = loginApi.p(context)) == null || (bVar = this.loginLaunch) == null) {
            return false;
        }
        bVar.a(p);
        return false;
    }

    private final qx.a getLoginApi() {
        return (qx.a) this.loginApi.getValue();
    }

    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public fp.n getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        fp.n c2 = fp.n.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
        final ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        final CheckInAnimationView checkInAnimationView;
        this.loginLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.room.fragment.k
            public final void a(Object obj) {
                RoomDetailFragment.L0(RoomDetailFragment.this, (ActivityResult) obj);
            }
        });
        this.updateInfoLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.room.fragment.l
            public final void a(Object obj) {
                RoomDetailFragment.M0(RoomDetailFragment.this, (ActivityResult) obj);
            }
        });
        fp.n nVar = (fp.n) getMViewBinding();
        if (nVar != null && (checkInAnimationView = nVar.t) != null) {
            checkInAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomDetailFragment.J0(RoomDetailFragment.this, checkInAnimationView, view);
                }
            });
        }
        fp.n nVar2 = (fp.n) getMViewBinding();
        if (nVar2 != null && (toolBarCheckInAnimationView = nVar2.r) != null) {
            toolBarCheckInAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomDetailFragment.K0(RoomDetailFragment.this, toolBarCheckInAnimationView, view);
                }
            });
        }
        U0();
        V0();
    }

    public void initViewData() {
        AppCompatImageView appCompatImageView;
        Toolbar toolbar;
        pageStateFitStatusBar();
        fp.n nVar = (fp.n) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (nVar == null || (toolbar = nVar.o) == null) ? null : toolbar.getLayoutParams();
        if (layoutParams instanceof CollapsingToolbarLayout.c) {
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.c) layoutParams)).topMargin = com.blankj.utilcode.util.d.c();
        }
        fp.n nVar2 = (fp.n) getMViewBinding();
        if (nVar2 != null && (appCompatImageView = nVar2.f) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomDetailFragment.P0(RoomDetailFragment.this, view);
                }
            });
        }
        fp.n nVar3 = (fp.n) getMViewBinding();
        if (nVar3 != null) {
            nVar3.z.setAdapter(new com.transsion.room.adapter.c(this.mGroupId, this));
            nVar3.z.registerOnPageChangeCallback(new c());
            N0();
        }
        H0();
    }

    public void initViewModel() {
        RoomDetailViewModel E0 = E0();
        E0.q().j(this, new d(new Function1() { // from class: com.transsion.room.fragment.p
            public final Object invoke(Object obj) {
                Unit Q0;
                Q0 = RoomDetailFragment.Q0(RoomDetailFragment.this, (RoomItem) obj);
                return Q0;
            }
        }));
        E0.s().j(this, new d(new Function1() { // from class: com.transsion.room.fragment.q
            public final Object invoke(Object obj) {
                Unit R0;
                R0 = RoomDetailFragment.R0(RoomDetailFragment.this, (RoomNet) obj);
                return R0;
            }
        }));
        E0.t().j(this, new d(new Function1() { // from class: com.transsion.room.fragment.r
            public final Object invoke(Object obj) {
                Unit S0;
                S0 = RoomDetailFragment.S0(RoomDetailFragment.this, (RoomNet) obj);
                return S0;
            }
        }));
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public void loadDefaultData() {
        showLoadingView();
        D0();
    }

    public qi.b newLogViewConfig() {
        return new qi.b("groupdetail", false, 2, null);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            D0();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        String groupId;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String str = null;
        RoomItem roomItem = arguments != null ? (RoomItem) arguments.getParcelable("item") : null;
        if (roomItem == null || (groupId = roomItem.getGroupId()) == null) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString("id");
            }
        } else {
            str = groupId;
        }
        this.mGroupId = str;
    }

    public void retryLoadData() {
    }
}
