package com.transsion.room.fragment;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.therouter.TheRouter;
import com.transsion.baseui.fragment.EmptyFragment;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.flow.bean.RoomTabItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.fragment.RoomBaseFragment;
import com.transsion.room.view.RoomHomeTabTitleView;
import com.transsion.room.viewmodel.RoomDetailViewModel;
import f4.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004:\u00012B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0006J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u0006J\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010 \u001a\u0004\u0018\u00010\u001fH&¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H&¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010%\u001a\u00020\u0017H&¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0017H&¢\u0006\u0004\b)\u0010*J-\u0010/\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00172\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010\"H&¢\u0006\u0004\b/\u00100R\u001b\u00106\u001a\u0002018DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R(\u0010>\u001a\u0014\u0018\u00010;R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\"\u0010G\u001a\u00020\u00178\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u0019\"\u0004\bF\u0010*R\u001d\u0010L\u001a\u0004\u0018\u00010H8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bI\u00103\u001a\u0004\bJ\u0010K¨\u0006M"}, d2 = {"Lcom/transsion/room/fragment/RoomBaseFragment;", "Lf4/a;", "T", "TabItem", "Lcom/transsion/baseui/fragment/LazyFragment;", "<init>", "()V", BuildConfig.FLAVOR, "l0", "lazyLoadData", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", BuildConfig.FLAVOR, "isAudioShowNoNetworkLayout", "()Z", "isShowPageStateLayoutTitle", "initViewData", "initViewModel", "hidden", "onHiddenChanged", "(Z)V", "initViewPager", BuildConfig.FLAVOR, "o0", "()I", "n0", "s0", "Landroidx/viewpager2/widget/ViewPager2;", "z0", "()Landroidx/viewpager2/widget/ViewPager2;", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "u0", "()Lnet/lucode/hackware/magicindicator/MagicIndicator;", BuildConfig.FLAVOR, "y0", "()Ljava/util/List;", "position", "Landroidx/fragment/app/Fragment;", "m0", "(I)Landroidx/fragment/app/Fragment;", "v0", "(I)V", "Lcom/transsion/room/view/RoomHomeTabTitleView;", "tabView", "index", "tabList", "x0", "(Lcom/transsion/room/view/RoomHomeTabTitleView;ILjava/util/List;)V", "Lcom/transsion/room/viewmodel/RoomDetailViewModel;", "a", "Lkotlin/Lazy;", "p0", "()Lcom/transsion/room/viewmodel/RoomDetailViewModel;", "mDetailViewModel", "Lcom/transsion/baseui/widget/magicindicator/ORCommonNavigator;", "b", "Lcom/transsion/baseui/widget/magicindicator/ORCommonNavigator;", "mCommonNavigator", "Lcom/transsion/room/fragment/RoomBaseFragment$a;", "c", "Lcom/transsion/room/fragment/RoomBaseFragment$a;", "mCommonNavigatorAdapter", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "d", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "mFragmentStateAdapter", "e", "I", "r0", "w0", "mSelectTabIndex", "Lio/b;", "f", "q0", "()Lio/b;", "mPostDetailApi", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class RoomBaseFragment<T extends f4.a, TabItem> extends LazyFragment<T> {

    /* renamed from: b, reason: from kotlin metadata */
    private ORCommonNavigator mCommonNavigator;

    /* renamed from: c, reason: from kotlin metadata */
    private a mCommonNavigatorAdapter;

    /* renamed from: d, reason: from kotlin metadata */
    private FragmentStateAdapter mFragmentStateAdapter;

    /* renamed from: e, reason: from kotlin metadata */
    private int mSelectTabIndex;

    /* renamed from: a, reason: from kotlin metadata */
    private final Lazy mDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(RoomDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.room.fragment.RoomBaseFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final androidx.lifecycle.x0 m150invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.room.fragment.RoomBaseFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m151invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: f, reason: from kotlin metadata */
    private final Lazy mPostDetailApi = LazyKt.b(new Function0() { // from class: com.transsion.room.fragment.d
        public final Object invoke() {
            io.b t0;
            t0 = RoomBaseFragment.t0();
            return t0;
        }
    });

    public final class a extends qj.a {
        private final ViewPager2 b;
        private final List c;
        final /* synthetic */ RoomBaseFragment d;

        public a(RoomBaseFragment roomBaseFragment, ViewPager2 viewPager2, List list) {
            Intrinsics.h(list, "tabList");
            this.d = roomBaseFragment;
            this.b = viewPager2;
            this.c = list;
        }

        private final LinearLayout.LayoutParams j() {
            return new LinearLayout.LayoutParams(-2, -1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(a aVar, int i, View view) {
            ViewPager2 viewPager2 = aVar.b;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(i, true);
            }
        }

        public int a() {
            return this.c.size();
        }

        public xy.c b(Context context) {
            Intrinsics.h(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(2);
            linePagerIndicator.setLineHeight(com.blankj.utilcode.util.i.e(2.0f));
            linePagerIndicator.setLineWidth(com.blankj.utilcode.util.i.e(57.0f));
            linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            linePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            linePagerIndicator.setColors(new Integer[]{-1, -1, -1});
            return linePagerIndicator;
        }

        public xy.d c(Context context, final int i) {
            Intrinsics.h(context, "context");
            RoomHomeTabTitleView roomHomeTabTitleView = new RoomHomeTabTitleView(context);
            this.d.x0(roomHomeTabTitleView, i, this.c);
            roomHomeTabTitleView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomBaseFragment.a.k(RoomBaseFragment.a.this, i, view);
                }
            });
            return roomHomeTabTitleView;
        }

        @Override // qj.a
        public LinearLayout.LayoutParams h(Context context, int i) {
            Intrinsics.h(context, "context");
            return j();
        }
    }

    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        public void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
            MagicIndicator u0 = RoomBaseFragment.this.u0();
            if (u0 != null) {
                u0.onPageScrollStateChanged(i);
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
            MagicIndicator u0 = RoomBaseFragment.this.u0();
            if (u0 != null) {
                u0.onPageScrolled(i, f, i2);
            }
        }

        public void onPageSelected(int i) {
            super.onPageSelected(i);
            MagicIndicator u0 = RoomBaseFragment.this.u0();
            if (u0 != null) {
                u0.onPageSelected(i);
            }
            RoomBaseFragment.this.v0(i);
            RoomBaseFragment.this.w0(i);
        }
    }

    public static final class c extends FragmentStateAdapter {
        c() {
            super(RoomBaseFragment.this);
        }

        public Fragment createFragment(int i) {
            Fragment m0 = RoomBaseFragment.this.m0(i);
            return m0 == null ? new EmptyFragment() : m0;
        }

        public int getItemCount() {
            return RoomBaseFragment.this.getMTabs().size();
        }
    }

    private final void l0() {
        ViewPager2 z0 = z0();
        if (z0 != null) {
            z0.registerOnPageChangeCallback(new b());
        }
        ep.k kVar = ep.k.a;
        if (kVar.f()) {
            this.mSelectTabIndex = o0();
            kVar.q(false);
        }
        ViewPager2 z02 = z0();
        if (z02 != null) {
            z02.setCurrentItem(this.mSelectTabIndex, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final io.b t0() {
        return (io.b) TheRouter.d(io.b.class, new Object[0]);
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initViewData() {
        initViewPager();
        s0();
    }

    public void initViewModel() {
    }

    public void initViewPager() {
        this.mFragmentStateAdapter = new c();
        ViewPager2 z0 = z0();
        if (z0 != null) {
            z0.setAdapter(this.mFragmentStateAdapter);
        }
        l0();
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
    }

    public abstract Fragment m0(int position);

    public final int n0() {
        Iterator it = getMTabs().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            Object next = it.next();
            if ((next instanceof RoomTabItem) && Intrinsics.c(((RoomTabItem) next).getTabId(), "explore")) {
                break;
            }
            i++;
        }
        Integer valueOf = Integer.valueOf(i);
        if (valueOf.intValue() < 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }

    public final int o0() {
        for (Object obj : getMTabs()) {
            if ((obj instanceof RoomTabItem) && Intrinsics.c(((RoomTabItem) obj).getTabId(), "images")) {
                return getMTabs().indexOf(obj);
            }
        }
        return 0;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                logResume();
            }
        }
    }

    protected final RoomDetailViewModel p0() {
        return (RoomDetailViewModel) this.mDetailViewModel.getValue();
    }

    protected final io.b q0() {
        return (io.b) this.mPostDetailApi.getValue();
    }

    /* renamed from: r0, reason: from getter */
    protected final int getMSelectTabIndex() {
        return this.mSelectTabIndex;
    }

    public void s0() {
        ORCommonNavigator oRCommonNavigator = new ORCommonNavigator(requireContext());
        oRCommonNavigator.setFollowTouch(true);
        a aVar = new a(this, z0(), getMTabs());
        this.mCommonNavigatorAdapter = aVar;
        oRCommonNavigator.setAdapter(aVar);
        this.mCommonNavigator = oRCommonNavigator;
        MagicIndicator u0 = u0();
        if (u0 != null) {
            u0.setNavigator(this.mCommonNavigator);
        }
        MagicIndicator u02 = u0();
        if (u02 != null) {
            u02.onPageSelected(this.mSelectTabIndex);
        }
    }

    public abstract MagicIndicator u0();

    public abstract void v0(int position);

    protected final void w0(int i) {
        this.mSelectTabIndex = i;
    }

    public abstract void x0(RoomHomeTabTitleView tabView, int index, List tabList);

    /* renamed from: y0 */
    public abstract List getMTabs();

    public abstract ViewPager2 z0();
}
