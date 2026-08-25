package com.transsion.room.fragment;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v0;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.therouter.TheRouter;
import com.tn.lib.util.networkinfo.NetworkType;
import com.tn.lib.view.RoomCacheAnimationView;
import com.tn.lib.view.RoomCacheStatus;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.tn.lib.widget.R;
import com.tn.lib.widget.TnTextView;
import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.baseui.widget.NestedSwipeRefreshLayout;
import com.transsion.flow.bean.RoomBean;
import com.transsion.flow.bean.RoomItem;
import com.transsion.flow.bean.RoomTabBean;
import com.transsion.flow.bean.RoomTabItem;
import com.transsion.flow.bean.RoomTabType;
import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.publish.bean.PublishResult;
import com.transsion.publish.view.UploadView;
import com.transsion.room.activity.RoomHomeActivity;
import com.transsion.room.api.RoomHomeCacheEvent;
import com.transsion.room.api.RoomHomeParentType;
import com.transsion.room.api.RoomHomeRefreshCacheEvent;
import com.transsion.room.api.RoomTabId;
import com.transsion.room.dialog.RequestCacheRoomDialog;
import com.transsion.room.view.RoomHomeTabTitleView;
import com.transsion.room.viewmodel.RoomViewModel;
import com.transsion.room.widget.CommunityRoomsView;
import com.transsion.web.fragment.WebFragmentV2;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.JoinRoomEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 |2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001}B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010\u0006J\u000f\u0010%\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010\u0006J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010\u0006J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010\u001bJ\u0019\u0010,\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b.\u0010\u0006J\u000f\u0010/\u001a\u00020\u0007H\u0016¢\u0006\u0004\b/\u0010\u0006J\u000f\u00100\u001a\u00020\u0007H\u0016¢\u0006\u0004\b0\u0010\u0006J\u000f\u00101\u001a\u00020\u0007H\u0016¢\u0006\u0004\b1\u0010\u0006J\u000f\u00102\u001a\u00020\u0007H\u0016¢\u0006\u0004\b2\u0010\u0006J\u000f\u00103\u001a\u00020\u0007H\u0016¢\u0006\u0004\b3\u0010\u0006J\u0017\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J-\u0010=\u001a\u00020\u00072\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u0002042\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030;H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020\u00072\b\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\u0011\u0010G\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0004\bG\u0010HJ\u0011\u0010J\u001a\u0004\u0018\u00010IH\u0016¢\u0006\u0004\bJ\u0010KJ\u0015\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030;H\u0016¢\u0006\u0004\bL\u0010MJ\u0019\u0010O\u001a\u0004\u0018\u00010N2\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u000204H\u0016¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\u0007H\u0016¢\u0006\u0004\bS\u0010\u0006J\u000f\u0010T\u001a\u00020\u0007H\u0016¢\u0006\u0004\bT\u0010\u0006J\u000f\u0010U\u001a\u00020\u0007H\u0016¢\u0006\u0004\bU\u0010\u0006R\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010`\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R$\u0010d\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0006\u0012\u0004\u0018\u00010N0a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010g\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010iR\u0018\u0010p\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010iR\u0019\u0010v\u001a\u0004\u0018\u00010q8\u0006¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u001d\u0010{\u001a\u0004\u0018\u00010w8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010X\u001a\u0004\by\u0010z¨\u0006~"}, d2 = {"Lcom/transsion/room/fragment/RoomHomeFragment;", "Lcom/transsion/room/fragment/RoomBaseFragment;", "Lfp/q;", "Lcom/transsion/moviedetailapi/bean/RoomTabItem;", "Lep/g;", "<init>", "()V", BuildConfig.FLAVOR, "r1", "b1", "c1", BuildConfig.FLAVOR, "W0", "()Z", "T0", "m1", "w1", "loadData", "z1", "k1", "i1", "Landroid/content/Context;", "context", "A1", "(Landroid/content/Context;)V", "isTabClick", "t1", "(Z)V", "Landroid/view/LayoutInflater;", "inflater", "X0", "(Landroid/view/LayoutInflater;)Lfp/q;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "lazyLoadData", "lazyLoadWithoutNet", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "e", "pageFrom", "z", "(Ljava/lang/String;)V", "initViewModel", "initListener", "onStart", "retryLoadData", "onResume", "q1", BuildConfig.FLAVOR, "position", "v0", "(I)V", "Lcom/transsion/room/view/RoomHomeTabTitleView;", "tabView", "index", BuildConfig.FLAVOR, "tabList", "x0", "(Lcom/transsion/room/view/RoomHomeTabTitleView;ILjava/util/List;)V", "Lcom/transsion/publish/bean/PublishResult;", "eventBean", "u1", "(Lcom/transsion/publish/bean/PublishResult;)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Landroidx/viewpager2/widget/ViewPager2;", "z0", "()Landroidx/viewpager2/widget/ViewPager2;", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "u0", "()Lnet/lucode/hackware/magicindicator/MagicIndicator;", "y0", "()Ljava/util/List;", "Landroidx/fragment/app/Fragment;", "m0", "(I)Landroidx/fragment/app/Fragment;", "B", "()I", "v", "G", "P", "Lcom/transsion/room/viewmodel/RoomViewModel;", "g", "Lkotlin/Lazy;", "V0", "()Lcom/transsion/room/viewmodel/RoomViewModel;", "mRoomViewModel", "h", "Lcom/transsion/publish/bean/PublishResult;", "i", "Landroidx/fragment/app/Fragment;", "mExploreFragment", BuildConfig.FLAVOR, "j", "Ljava/util/Map;", "mRefreshViewMap", "k", "I", "mExplorePosition", "l", "Ljava/lang/String;", "insertPostId", "m", "insertPostOps", "n", "parentTypeName", "o", "cache", "Lcom/transsion/mb/config/manager/ConfigBean;", "p", "Lcom/transsion/mb/config/manager/ConfigBean;", "getRoomCacheOpen", "()Lcom/transsion/mb/config/manager/ConfigBean;", "roomCacheOpen", "Ljo/a;", "q", "U0", "()Ljo/a;", "mPublishedApi", "r", "a", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomHomeFragment extends RoomBaseFragment<fp.q, RoomTabItem> implements ep.g {

    /* renamed from: r, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String s = "net_without_wifi_image_tab";

    /* renamed from: h, reason: from kotlin metadata */
    private PublishResult eventBean;

    /* renamed from: i, reason: from kotlin metadata */
    private Fragment mExploreFragment;

    /* renamed from: k, reason: from kotlin metadata */
    private int mExplorePosition;

    /* renamed from: l, reason: from kotlin metadata */
    private String insertPostId;

    /* renamed from: m, reason: from kotlin metadata */
    private String insertPostOps;

    /* renamed from: n, reason: from kotlin metadata */
    private String parentTypeName;

    /* renamed from: g, reason: from kotlin metadata */
    private final Lazy mRoomViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(RoomViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.room.fragment.RoomHomeFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final androidx.lifecycle.x0 m157invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.room.fragment.RoomHomeFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m158invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: j, reason: from kotlin metadata */
    private Map mRefreshViewMap = new LinkedHashMap();

    /* renamed from: o, reason: from kotlin metadata */
    private String cache = com.transsion.baselib.report.launch.b.a.b().getString("room_cache_data", BuildConfig.FLAVOR);

    /* renamed from: p, reason: from kotlin metadata */
    private final ConfigBean roomCacheOpen = cm.f.c.a().c("room_cache_open", true);

    /* renamed from: q, reason: from kotlin metadata */
    private final Lazy mPublishedApi = LazyKt.b(new Function0() { // from class: com.transsion.room.fragment.z0
        public final Object invoke() {
            jo.a h1;
            h1 = RoomHomeFragment.h1();
            return h1;
        }
    });

    /* renamed from: com.transsion.room.fragment.RoomHomeFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ RoomHomeFragment b(Companion companion, RoomHomeParentType roomHomeParentType, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.a(roomHomeParentType, str, str2);
        }

        public final RoomHomeFragment a(RoomHomeParentType roomHomeParentType, String str, String str2) {
            Intrinsics.h(roomHomeParentType, "parentType");
            RoomHomeFragment roomHomeFragment = new RoomHomeFragment();
            roomHomeFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("post_id", str), TuplesKt.a("ops", str2), TuplesKt.a("parent_type", roomHomeParentType.name())}));
            return roomHomeFragment;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NetworkType.values().length];
            try {
                iArr[NetworkType.NETWORK_2G.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetworkType.NETWORK_3G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NetworkType.NETWORK_4G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NetworkType.NETWORK_5G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        public void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
        }

        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
        }

        public void onPageSelected(int i) {
            RoomCacheAnimationView roomCacheAnimationView;
            super.onPageSelected(i);
            fp.q qVar = (fp.q) RoomHomeFragment.this.getMViewBinding();
            if (qVar == null || (roomCacheAnimationView = qVar.d) == null) {
                return;
            }
            roomCacheAnimationView.setVisibility(i == RoomHomeFragment.this.mExplorePosition && RoomHomeFragment.this.W0() ? 0 : 8);
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

    public static final class e extends CountDownTimer {
        e() {
            super(5000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            BubbleTextView bubbleTextView;
            fp.q qVar = (fp.q) RoomHomeFragment.this.getMViewBinding();
            if (qVar == null || (bubbleTextView = qVar.b) == null) {
                return;
            }
            uf.c.g(bubbleTextView);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.transsion.publish.view.BaseFloatView, com.transsion.publish.view.UploadView] */
    private final void A1(Context context) {
        ?? uploadView = new UploadView(context);
        uploadView.setPageName("room_home");
        if (!uploadView.getIsShow()) {
            uploadView.setVisibility(0);
            uploadView.setAlpha(1.0f);
            Activity b2 = com.blankj.utilcode.util.a.b();
            if (b2 == null || b2.isFinishing() || b2.isDestroyed()) {
                b2 = com.blankj.utilcode.util.a.b();
            }
            if (b2 == null || b2.isFinishing() || b2.isDestroyed()) {
                return;
            } else {
                uploadView.show(b2);
            }
        }
        uploadView.showFloatView(this.eventBean);
    }

    private final void T0() {
        RoomCacheAnimationView roomCacheAnimationView;
        RoomCacheAnimationView roomCacheAnimationView2;
        String string = com.transsion.baselib.report.launch.b.a.b().getString("room_cache_data", BuildConfig.FLAVOR);
        this.cache = string;
        if (string == null || string.length() == 0) {
            fp.q qVar = (fp.q) getMViewBinding();
            if (qVar == null || (roomCacheAnimationView = qVar.d) == null) {
                return;
            }
            roomCacheAnimationView.setStatus(RoomCacheStatus.START);
            return;
        }
        fp.q qVar2 = (fp.q) getMViewBinding();
        if (qVar2 == null || (roomCacheAnimationView2 = qVar2.d) == null) {
            return;
        }
        roomCacheAnimationView2.setStatus(RoomCacheStatus.END);
    }

    private final jo.a U0() {
        return (jo.a) this.mPublishedApi.getValue();
    }

    private final RoomViewModel V0() {
        return (RoomViewModel) this.mRoomViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean W0() {
        ConfigBean configBean = this.roomCacheOpen;
        String value = configBean != null ? configBean.getValue() : null;
        if (value != null && value.length() != 0) {
            ConfigBean configBean2 = this.roomCacheOpen;
            if (Intrinsics.c(configBean2 != null ? configBean2.getValue() : null, "true")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(RoomHomeFragment roomHomeFragment, View view) {
        roomHomeFragment.q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(RoomHomeFragment roomHomeFragment, View view) {
        roomHomeFragment.q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(RoomHomeFragment roomHomeFragment, View view) {
        String string = com.transsion.baselib.report.launch.b.a.b().getString("room_cache_data", BuildConfig.FLAVOR);
        if (string == null || string.length() == 0) {
            roomHomeFragment.w1();
            return;
        }
        io.b q0 = roomHomeFragment.q0();
        if (q0 != null) {
            q0.n(roomHomeFragment.mExploreFragment);
        }
    }

    private final void b1() {
        RoomCacheAnimationView roomCacheAnimationView;
        RoomCacheAnimationView roomCacheAnimationView2;
        c1();
        String str = this.cache;
        if (str == null || str.length() == 0) {
            fp.q qVar = (fp.q) getMViewBinding();
            if (qVar == null || (roomCacheAnimationView = qVar.d) == null) {
                return;
            }
            roomCacheAnimationView.setStatus(RoomCacheStatus.START);
            return;
        }
        fp.q qVar2 = (fp.q) getMViewBinding();
        if (qVar2 == null || (roomCacheAnimationView2 = qVar2.d) == null) {
            return;
        }
        roomCacheAnimationView2.setStatus(RoomCacheStatus.END);
    }

    private final void c1() {
        RoomCacheAnimationView roomCacheAnimationView;
        RoomCacheAnimationView roomCacheAnimationView2;
        ConfigBean configBean = this.roomCacheOpen;
        String value = configBean != null ? configBean.getValue() : null;
        if (value != null && value.length() != 0) {
            ConfigBean configBean2 = this.roomCacheOpen;
            if (Intrinsics.c(configBean2 != null ? configBean2.getValue() : null, "true")) {
                fp.q qVar = (fp.q) getMViewBinding();
                if (qVar == null || (roomCacheAnimationView2 = qVar.d) == null) {
                    return;
                }
                uf.c.k(roomCacheAnimationView2);
                return;
            }
        }
        fp.q qVar2 = (fp.q) getMViewBinding();
        if (qVar2 == null || (roomCacheAnimationView = qVar2.d) == null) {
            return;
        }
        uf.c.g(roomCacheAnimationView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(RoomHomeFragment roomHomeFragment) {
        roomHomeFragment.r1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(RoomHomeFragment roomHomeFragment, AppBarLayout appBarLayout, int i) {
        NestedSwipeRefreshLayout nestedSwipeRefreshLayout;
        fp.q qVar = (fp.q) roomHomeFragment.getMViewBinding();
        if (qVar == null || (nestedSwipeRefreshLayout = qVar.g) == null) {
            return;
        }
        nestedSwipeRefreshLayout.setEnabled(i >= 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(RoomHomeFragment roomHomeFragment, RoomTabBean roomTabBean) {
        List<RoomTabItem> items;
        List<RoomTabItem> items2;
        List<RoomTabItem> items3;
        String value;
        List<RoomTabItem> items4;
        NetworkType c2 = yg.l.a.c();
        int i = -1;
        int i2 = c2 == null ? -1 : b.a[c2.ordinal()];
        int i3 = 0;
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            ConfigBean d2 = cm.f.d(cm.f.c.a(), s, false, 2, (Object) null);
            if ((d2 == null || (value = d2.getValue()) == null) ? false : Boolean.parseBoolean(value)) {
                if (roomTabBean != null && (items3 = roomTabBean.getItems()) != null) {
                    Iterator<RoomTabItem> it = items3.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.c(it.next().getTabId(), "images")) {
                            i = i3;
                            break;
                        }
                        i3++;
                    }
                    i3 = i;
                } else if (roomTabBean != null && (items2 = roomTabBean.getItems()) != null) {
                    Iterator<RoomTabItem> it2 = items2.iterator();
                    while (it2.hasNext()) {
                        if (Intrinsics.c(it2.next().getTabId(), roomTabBean.getDefTabId())) {
                            i = i3;
                            break;
                        }
                        i3++;
                    }
                    i3 = i;
                }
            } else if (roomTabBean != null && (items = roomTabBean.getItems()) != null) {
                Iterator<RoomTabItem> it3 = items.iterator();
                while (it3.hasNext()) {
                    if (Intrinsics.c(it3.next().getTabId(), roomTabBean.getDefTabId())) {
                        i = i3;
                        break;
                    }
                    i3++;
                }
                i3 = i;
            }
        } else if (roomTabBean != null && (items4 = roomTabBean.getItems()) != null) {
            Iterator<RoomTabItem> it4 = items4.iterator();
            while (it4.hasNext()) {
                if (Intrinsics.c(it4.next().getTabId(), roomTabBean.getDefTabId())) {
                    i = i3;
                    break;
                }
                i3++;
            }
            i3 = i;
        }
        roomHomeFragment.w0(i3);
        roomHomeFragment.initViewPager();
        roomHomeFragment.s0();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(RoomHomeFragment roomHomeFragment, RoomBean roomBean) {
        fp.q qVar;
        ConstraintLayout constraintLayout;
        CommunityRoomsView communityRoomsView;
        CommunityRoomsView communityRoomsView2;
        ConstraintLayout constraintLayout2;
        List<RoomItem> items = roomBean != null ? roomBean.getItems() : null;
        if (items != null && !items.isEmpty()) {
            fp.q qVar2 = (fp.q) roomHomeFragment.getMViewBinding();
            if ((qVar2 == null || (constraintLayout2 = qVar2.j) == null || constraintLayout2.getVisibility() != 0) && (qVar = (fp.q) roomHomeFragment.getMViewBinding()) != null && (constraintLayout = qVar.j) != null) {
                uf.c.k(constraintLayout);
            }
            fp.q qVar3 = (fp.q) roomHomeFragment.getMViewBinding();
            if (qVar3 != null && (communityRoomsView2 = qVar3.j) != null) {
                List<RoomItem> items2 = roomBean != null ? roomBean.getItems() : null;
                Intrinsics.e(items2);
                communityRoomsView2.setList(items2);
            }
            fp.q qVar4 = (fp.q) roomHomeFragment.getMViewBinding();
            if (qVar4 != null && (communityRoomsView = qVar4.j) != null) {
                communityRoomsView.setReportName("room_home", "room_home_community");
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jo.a h1() {
        return (jo.a) TheRouter.d(jo.a.class, new Object[0]);
    }

    private final void i1() {
        androidx.lifecycle.u context = getContext();
        if (context instanceof ComponentActivity) {
            Function1 function1 = new Function1() { // from class: com.transsion.room.fragment.q0
                public final Object invoke(Object obj) {
                    Unit j1;
                    j1 = RoomHomeFragment.j1(RoomHomeFragment.this, (PublishResult) obj);
                    return j1;
                }
            };
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = PublishResult.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.observeEvent(context, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(RoomHomeFragment roomHomeFragment, PublishResult publishResult) {
        Intrinsics.h(publishResult, "it");
        roomHomeFragment.u1(publishResult);
        return Unit.a;
    }

    private final void k1() {
        Function1 function1 = new Function1() { // from class: com.transsion.room.fragment.t0
            public final Object invoke(Object obj) {
                Unit l1;
                l1 = RoomHomeFragment.l1(RoomHomeFragment.this, (JoinRoomEvent) obj);
                return l1;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = JoinRoomEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(RoomHomeFragment roomHomeFragment, JoinRoomEvent joinRoomEvent) {
        CommunityRoomsView communityRoomsView;
        List<RoomItem> dataList;
        Object obj;
        Context context;
        Intrinsics.h(joinRoomEvent, "value");
        if (joinRoomEvent.getJoin()) {
            Context context2 = roomHomeFragment.getContext();
            if (context2 != null) {
                RoomViewModel.u(roomHomeFragment.V0(), context2, null, 0, 6, null);
            }
        } else {
            fp.q qVar = (fp.q) roomHomeFragment.getMViewBinding();
            if (qVar != null && (communityRoomsView = qVar.j) != null && (dataList = communityRoomsView.getDataList()) != null) {
                Iterator<T> it = dataList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.c(((RoomItem) obj).getGroupId(), joinRoomEvent.getGroupId())) {
                        break;
                    }
                }
                if (((RoomItem) obj) != null && (context = roomHomeFragment.getContext()) != null) {
                    RoomViewModel.u(roomHomeFragment.V0(), context, null, 0, 6, null);
                }
            }
        }
        return Unit.a;
    }

    private final void loadData() {
        Context context = getContext();
        if (context != null) {
            RoomViewModel.u(V0(), context, null, 0, 6, null);
        }
    }

    private final void m1() {
        Function1 function1 = new Function1() { // from class: com.transsion.room.fragment.r0
            public final Object invoke(Object obj) {
                Unit n1;
                n1 = RoomHomeFragment.n1(RoomHomeFragment.this, (RoomHomeCacheEvent) obj);
                return n1;
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus applicationScopeViewModel = appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = RoomHomeCacheEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        Lifecycle.State state = Lifecycle.State.CREATED;
        applicationScopeViewModel.observeEvent(this, name, state, kotlinx.coroutines.y0.c().p(), false, function1);
        Function1 function12 = new Function1() { // from class: com.transsion.room.fragment.s0
            public final Object invoke(Object obj) {
                Unit o1;
                o1 = RoomHomeFragment.o1((RoomHomeRefreshCacheEvent) obj);
                return o1;
            }
        };
        FlowEventBus applicationScopeViewModel2 = appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = RoomHomeRefreshCacheEvent.class.getName();
        Intrinsics.g(name2, "getName(...)");
        applicationScopeViewModel2.observeEvent(this, name2, state, kotlinx.coroutines.y0.c().p(), false, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(RoomHomeFragment roomHomeFragment, RoomHomeCacheEvent roomHomeCacheEvent) {
        RoomCacheAnimationView roomCacheAnimationView;
        Intrinsics.h(roomHomeCacheEvent, "it");
        fp.q qVar = (fp.q) roomHomeFragment.getMViewBinding();
        if (qVar != null && (roomCacheAnimationView = qVar.d) != null) {
            roomCacheAnimationView.setStatus(RoomCacheStatus.END);
        }
        roomHomeFragment.cache = com.transsion.baselib.report.launch.b.a.b().getString("room_cache_data", BuildConfig.FLAVOR);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(RoomHomeRefreshCacheEvent roomHomeRefreshCacheEvent) {
        Intrinsics.h(roomHomeRefreshCacheEvent, "it");
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(RoomHomeFragment roomHomeFragment) {
        ViewPager2 z0 = roomHomeFragment.z0();
        if (z0 != null) {
            z0.setCurrentItem(roomHomeFragment.o0(), false);
        }
        ep.k.a.q(false);
    }

    private final void r1() {
        loadData();
        T0();
        io.c cVar = (Fragment) this.mRefreshViewMap.get(Integer.valueOf(getMSelectTabIndex()));
        if (cVar != null) {
            io.c cVar2 = cVar instanceof io.c ? cVar : null;
            if (cVar2 != null) {
                cVar2.doRefresh(new Function0() { // from class: com.transsion.room.fragment.e1
                    public final Object invoke() {
                        Unit s1;
                        s1 = RoomHomeFragment.s1(RoomHomeFragment.this);
                        return s1;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(RoomHomeFragment roomHomeFragment) {
        NestedSwipeRefreshLayout nestedSwipeRefreshLayout;
        fp.q qVar;
        NestedSwipeRefreshLayout nestedSwipeRefreshLayout2;
        fp.q qVar2 = (fp.q) roomHomeFragment.getMViewBinding();
        if (qVar2 != null && (nestedSwipeRefreshLayout = qVar2.g) != null && nestedSwipeRefreshLayout.isRefreshing() && (qVar = (fp.q) roomHomeFragment.getMViewBinding()) != null && (nestedSwipeRefreshLayout2 = qVar.g) != null) {
            nestedSwipeRefreshLayout2.setRefreshing(false);
        }
        return Unit.a;
    }

    private final void t1(boolean isTabClick) {
        String str;
        List<RoomTabItem> items;
        RoomTabItem roomTabItem;
        String tabId;
        Map m = MapsKt.m(new Pair[]{TuplesKt.a("opt_type", isTabClick ? "tab_refresh" : "feed_error")});
        try {
            Result.Companion companion = Result.Companion;
            RoomTabBean roomTabBean = (RoomTabBean) V0().G().f();
            if (roomTabBean == null || (items = roomTabBean.getItems()) == null || (roomTabItem = items.get(getMSelectTabIndex())) == null || (tabId = roomTabItem.getTabId()) == null) {
                str = null;
            } else {
                str = (String) m.put("subpage_name", "room_home_" + tabId);
            }
            Result.constructor-impl(str);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        qi.h.a.o("room_home", m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(RoomHomeFragment roomHomeFragment) {
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        roomHomeFragment.A1(a);
    }

    private final void w1() {
        RequestCacheRoomDialog a = RequestCacheRoomDialog.INSTANCE.a();
        a.t0(new Function0() { // from class: com.transsion.room.fragment.u0
            public final Object invoke() {
                Unit x1;
                x1 = RoomHomeFragment.x1(RoomHomeFragment.this);
                return x1;
            }
        });
        Dialog dialog = a.getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        a.j0(new DialogInterface.OnDismissListener() { // from class: com.transsion.room.fragment.v0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RoomHomeFragment.y1(dialogInterface);
            }
        });
        a.k0(getContext(), "room_cache_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(RoomHomeFragment roomHomeFragment) {
        fp.q qVar;
        RoomCacheAnimationView roomCacheAnimationView;
        if (!yg.l.a.e()) {
            fh.b.a.d(R.string.no_network_toast);
            return Unit.a;
        }
        io.b q0 = roomHomeFragment.q0();
        if (q0 != null) {
            q0.g(roomHomeFragment.mExploreFragment, false);
        }
        String str = roomHomeFragment.cache;
        if ((str == null || str.length() == 0) && (qVar = (fp.q) roomHomeFragment.getMViewBinding()) != null && (roomCacheAnimationView = qVar.d) != null) {
            roomCacheAnimationView.setStatus(RoomCacheStatus.LOADING);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(DialogInterface dialogInterface) {
    }

    private final void z1() {
        BubbleTextView bubbleTextView;
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        if (bVar.b().getBoolean("show_room_cache_guide", false) || !W0()) {
            return;
        }
        e eVar = new e();
        fp.q qVar = (fp.q) getMViewBinding();
        if (qVar != null && (bubbleTextView = qVar.b) != null) {
            uf.c.k(bubbleTextView);
        }
        fp.q qVar2 = (fp.q) getMViewBinding();
        if (qVar2 == null || qVar2.b == null) {
            return;
        }
        eVar.start();
        bVar.b().putBoolean("show_room_cache_guide", true);
    }

    @Override // ep.g
    public int B() {
        return getMSelectTabIndex();
    }

    @Override // ep.g
    public void G() {
        T0();
    }

    @Override // ep.g
    public void P() {
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
    }

    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public fp.q getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        fp.q c2 = fp.q.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    @Override // ep.g
    public void e(boolean isTabClick) {
        NestedSwipeRefreshLayout nestedSwipeRefreshLayout;
        AppBarLayout appBarLayout;
        if (!yg.l.a.e()) {
            fh.b.a.d(R.string.no_network_toast);
            return;
        }
        t1(isTabClick);
        fp.q qVar = (fp.q) getMViewBinding();
        if (qVar != null && (appBarLayout = qVar.c) != null) {
            appBarLayout.setExpanded(true);
        }
        fp.q qVar2 = (fp.q) getMViewBinding();
        if (qVar2 != null && (nestedSwipeRefreshLayout = qVar2.g) != null) {
            nestedSwipeRefreshLayout.setRefreshing(true);
        }
        r1();
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
        ViewPager2 viewPager2;
        RoomCacheAnimationView roomCacheAnimationView;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView;
        fp.q qVar = (fp.q) getMViewBinding();
        if (qVar != null && (appCompatImageView = qVar.e) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.p0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomHomeFragment.Y0(RoomHomeFragment.this, view);
                }
            });
        }
        fp.q qVar2 = (fp.q) getMViewBinding();
        if (qVar2 != null && (tnTextView = qVar2.i) != null) {
            tnTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.x0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomHomeFragment.Z0(RoomHomeFragment.this, view);
                }
            });
        }
        fp.q qVar3 = (fp.q) getMViewBinding();
        if (qVar3 != null && (roomCacheAnimationView = qVar3.d) != null) {
            roomCacheAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.y0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomHomeFragment.a1(RoomHomeFragment.this, view);
                }
            });
        }
        fp.q qVar4 = (fp.q) getMViewBinding();
        if (qVar4 == null || (viewPager2 = qVar4.k) == null) {
            return;
        }
        viewPager2.registerOnPageChangeCallback(new c());
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    public void initViewData() {
        AppCompatImageView appCompatImageView;
        AppBarLayout appBarLayout;
        SwipeRefreshLayout swipeRefreshLayout;
        fp.q qVar = (fp.q) getMViewBinding();
        if (qVar != null && (swipeRefreshLayout = qVar.g) != null) {
            swipeRefreshLayout.setProgressBackgroundColorSchemeColor(androidx.core.content.b.getColor(swipeRefreshLayout.getContext(), R.color.bg_01));
            swipeRefreshLayout.setColorSchemeColors(new int[]{androidx.core.content.b.getColor(swipeRefreshLayout.getContext(), R.color.main_gradient_center), androidx.core.content.b.getColor(swipeRefreshLayout.getContext(), R.color.main_gradient_start)});
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.room.fragment.a1
                public final void a() {
                    RoomHomeFragment.d1(RoomHomeFragment.this);
                }
            });
        }
        fp.q qVar2 = (fp.q) getMViewBinding();
        if (qVar2 != null && (appBarLayout = qVar2.c) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.room.fragment.b1
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                    RoomHomeFragment.e1(RoomHomeFragment.this, appBarLayout2, i);
                }
            });
        }
        fp.q qVar3 = (fp.q) getMViewBinding();
        if (qVar3 != null && (appCompatImageView = qVar3.e) != null && !(getActivity() instanceof RoomHomeActivity)) {
            ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = com.transsion.usercenter.setting.labelsfeedback.a.b(TidConfigBean.REASON_TID_DISABLE);
            appCompatImageView.setLayoutParams(marginLayoutParams);
        }
        b1();
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    public void initViewModel() {
        super.initViewModel();
        V0().v().j(this, new d(new Function1() { // from class: com.transsion.room.fragment.c1
            public final Object invoke(Object obj) {
                Unit g1;
                g1 = RoomHomeFragment.g1(RoomHomeFragment.this, (RoomBean) obj);
                return g1;
            }
        }));
        V0().G().j(this, new d(new Function1() { // from class: com.transsion.room.fragment.d1
            public final Object invoke(Object obj) {
                Unit f1;
                f1 = RoomHomeFragment.f1(RoomHomeFragment.this, (RoomTabBean) obj);
                return f1;
            }
        }));
        i1();
        k1();
        m1();
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment, com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        V0().H();
        loadData();
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadWithoutNet() {
        V0().H();
        loadData();
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    public Fragment m0(int position) {
        List<RoomTabItem> items;
        RoomTabItem roomTabItem;
        Fragment c2;
        fp.q qVar;
        fp.q qVar2;
        RoomCacheAnimationView roomCacheAnimationView;
        RoomCacheAnimationView roomCacheAnimationView2;
        try {
            RoomTabBean roomTabBean = (RoomTabBean) V0().G().f();
            if (roomTabBean != null && (items = roomTabBean.getItems()) != null && (roomTabItem = items.get(position)) != null) {
                String tabId = roomTabItem.getTabId();
                if (Intrinsics.c(tabId, RoomTabId.EXPLORE.getValue())) {
                    io.b q0 = q0();
                    c2 = q0 != null ? q0.d(this.parentTypeName, this.insertPostId, this.insertPostOps) : null;
                    this.mExplorePosition = position;
                    if (getMSelectTabIndex() == position && (((qVar = (fp.q) getMViewBinding()) == null || (roomCacheAnimationView2 = qVar.d) == null || roomCacheAnimationView2.getVisibility() != 0) && W0() && (qVar2 = (fp.q) getMViewBinding()) != null && (roomCacheAnimationView = qVar2.d) != null)) {
                        uf.c.k(roomCacheAnimationView);
                    }
                    this.mExploreFragment = c2;
                    this.mRefreshViewMap.put(Integer.valueOf(position), c2);
                } else if (Intrinsics.c(tabId, RoomTabId.NEARBY.getValue())) {
                    io.b q02 = q0();
                    c2 = q02 != null ? q02.l(this.parentTypeName) : null;
                    this.mRefreshViewMap.put(Integer.valueOf(position), c2);
                } else if (Intrinsics.c(tabId, RoomTabId.DISCOVER.getValue())) {
                    io.b q03 = q0();
                    c2 = q03 != null ? q03.b(this.parentTypeName, roomTabItem, position) : null;
                    this.mRefreshViewMap.put(Integer.valueOf(position), c2);
                } else if (Intrinsics.c(roomTabItem.getType(), RoomTabType.H5.getValue())) {
                    Fragment b2 = WebFragmentV2.w.b();
                    Pair a = TuplesKt.a("url", roomTabItem.getUrl());
                    Boolean bool = Boolean.TRUE;
                    b2.setArguments(androidx.core.os.d.b(new Pair[]{a, TuplesKt.a("tool_status_bar_hidden", bool), TuplesKt.a("tool_bar_hidden", bool)}));
                    c2 = b2;
                } else {
                    io.b q04 = q0();
                    c2 = q04 != null ? q04.c(this.parentTypeName, roomTabItem, position) : null;
                    this.mRefreshViewMap.put(Integer.valueOf(position), c2);
                }
                if (c2 != null) {
                    return c2;
                }
            }
            io.b q05 = q0();
            Fragment d2 = q05 != null ? q05.d(this.parentTypeName, this.insertPostId, this.insertPostOps) : null;
            this.mExploreFragment = d2;
            return d2;
        } catch (Throwable unused) {
            io.b q06 = q0();
            Fragment d3 = q06 != null ? q06.d(this.parentTypeName, this.insertPostId, this.insertPostOps) : null;
            this.mExploreFragment = d3;
            return d3;
        }
    }

    public qi.b newLogViewConfig() {
        return new qi.b("room_home", false, 2, null);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.insertPostId = arguments != null ? arguments.getString("post_id") : null;
        Bundle arguments2 = getArguments();
        this.insertPostOps = arguments2 != null ? arguments2.getString("ops") : null;
        Bundle arguments3 = getArguments();
        this.parentTypeName = arguments3 != null ? arguments3.getString("parent_type") : null;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void onResume() {
        ViewPager2 z0;
        super.onResume();
        z1();
        c1();
        if (!ep.k.a.f() || (z0 = z0()) == null) {
            return;
        }
        z0.postDelayed(new Runnable() { // from class: com.transsion.room.fragment.f1
            @Override // java.lang.Runnable
            public final void run() {
                RoomHomeFragment.p1(RoomHomeFragment.this);
            }
        }, 200L);
    }

    public void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
    }

    public void q1() {
        jo.a U0;
        Context context = getContext();
        if (context == null || (U0 = U0()) == null) {
            return;
        }
        U0.b(context);
    }

    public void retryLoadData() {
        loadData();
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    public MagicIndicator u0() {
        fp.q qVar = (fp.q) getMViewBinding();
        if (qVar != null) {
            return qVar.f;
        }
        return null;
    }

    public final void u1(PublishResult eventBean) {
        fp.q qVar;
        AppCompatImageView appCompatImageView;
        this.eventBean = eventBean;
        Integer valueOf = eventBean != null ? Integer.valueOf(eventBean.getState()) : null;
        if (valueOf == null || valueOf.intValue() != 0 || (qVar = (fp.q) getMViewBinding()) == null || (appCompatImageView = qVar.e) == null) {
            return;
        }
        appCompatImageView.postDelayed(new Runnable() { // from class: com.transsion.room.fragment.w0
            @Override // java.lang.Runnable
            public final void run() {
                RoomHomeFragment.v1(RoomHomeFragment.this);
            }
        }, 1500L);
    }

    @Override // ep.g
    public void v() {
        RoomCacheAnimationView roomCacheAnimationView;
        if (!yg.l.a.e()) {
            fh.b.a.d(R.string.no_network_toast);
            return;
        }
        fp.q qVar = (fp.q) getMViewBinding();
        if (qVar != null && (roomCacheAnimationView = qVar.d) != null) {
            roomCacheAnimationView.setStatus(RoomCacheStatus.LOADING);
        }
        io.b q0 = q0();
        if (q0 != null) {
            q0.g(this.mExploreFragment, true);
        }
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    public void v0(int position) {
        NestedSwipeRefreshLayout nestedSwipeRefreshLayout;
        fp.q qVar = (fp.q) getMViewBinding();
        if (qVar == null || (nestedSwipeRefreshLayout = qVar.g) == null) {
            return;
        }
        nestedSwipeRefreshLayout.setEnabled(this.mRefreshViewMap.containsKey(Integer.valueOf(position)));
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    public void x0(RoomHomeTabTitleView tabView, int index, List tabList) {
        Intrinsics.h(tabView, "tabView");
        Intrinsics.h(tabList, "tabList");
        RoomTabItem roomTabItem = (RoomTabItem) tabList.get(index);
        tabView.setTitle(roomTabItem.getName());
        tabView.setBadge(roomTabItem);
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    /* renamed from: y0 */
    public List getMTabs() {
        List<RoomTabItem> items;
        ArrayList arrayList = new ArrayList();
        RoomTabBean roomTabBean = (RoomTabBean) V0().G().f();
        if (roomTabBean != null && (items = roomTabBean.getItems()) != null) {
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add((RoomTabItem) it.next());
            }
        }
        return arrayList;
    }

    @Override // ep.g
    public void z(String pageFrom) {
        ViewPager2 viewPager2;
        HashMap g;
        HashMap g2;
        if (pageFrom != null && pageFrom.length() != 0) {
            qi.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g2 = logViewConfig.g()) != null) {
            }
            String str = getActivity() instanceof RoomHomeActivity ? "sub_page" : "main";
            qi.b logViewConfig2 = getLogViewConfig();
            if (logViewConfig2 != null && (g = logViewConfig2.g()) != null) {
            }
        }
        fp.q qVar = (fp.q) getMViewBinding();
        if (qVar == null || (viewPager2 = qVar.k) == null) {
            return;
        }
        viewPager2.setCurrentItem(n0());
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    public ViewPager2 z0() {
        fp.q qVar = (fp.q) getMViewBinding();
        if (qVar != null) {
            return qVar.k;
        }
        return null;
    }
}
