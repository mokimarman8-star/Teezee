package com.transsion.room.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.widget.R;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.R$string;
import com.transsion.room.fragment.RoomListMainFragment;
import com.transsion.room.view.RoomListMainTabTitleView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.WrapPagerIndicator;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/transsion/room/fragment/RoomListMainFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lfp/s;", "<init>", "()V", BuildConfig.FLAVOR, "initViewPager", "e0", "Landroid/view/LayoutInflater;", "inflater", "f0", "(Landroid/view/LayoutInflater;)Lfp/s;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "a", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "vpAdapter", "Lcom/transsion/baseui/widget/magicindicator/ORCommonNavigator;", "b", "Lcom/transsion/baseui/widget/magicindicator/ORCommonNavigator;", "commonNavigator", BuildConfig.FLAVOR, "c", "I", "selectTabIndex", BuildConfig.FLAVOR, "d", "Z", "isSelectRoom", BuildConfig.FLAVOR, "e", "[Ljava/lang/Integer;", "tabs", "f", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomListMainFragment extends BaseFragment<fp.s> {

    /* renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private FragmentStateAdapter vpAdapter;

    /* renamed from: b, reason: from kotlin metadata */
    private ORCommonNavigator commonNavigator;

    /* renamed from: c, reason: from kotlin metadata */
    private int selectTabIndex;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isSelectRoom;

    /* renamed from: e, reason: from kotlin metadata */
    private final Integer[] tabs = {Integer.valueOf(R$string.Your_rooms), Integer.valueOf(R$string.Room_list)};

    /* renamed from: com.transsion.room.fragment.RoomListMainFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomListMainFragment a(boolean z, int i) {
            RoomListMainFragment roomListMainFragment = new RoomListMainFragment();
            roomListMainFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("is_select_room", Boolean.valueOf(z)), TuplesKt.a("index", Integer.valueOf(i))}));
            return roomListMainFragment;
        }
    }

    public static final class b extends qj.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(RoomListMainFragment roomListMainFragment, int i, View view) {
            ViewPager2 viewPager2;
            fp.s sVar = (fp.s) roomListMainFragment.getMViewBinding();
            if (sVar == null || (viewPager2 = sVar.f) == null) {
                return;
            }
            viewPager2.setCurrentItem(i, true);
        }

        public int a() {
            return RoomListMainFragment.this.tabs.length;
        }

        public xy.c b(Context context) {
            Intrinsics.h(context, "context");
            WrapPagerIndicator wrapPagerIndicator = new WrapPagerIndicator(context);
            int a = com.blankj.utilcode.util.a0.a(3.0f);
            wrapPagerIndicator.setRoundRadius(a * 2.0f);
            int i = -a;
            wrapPagerIndicator.setVerticalPadding(i);
            wrapPagerIndicator.setHorizontalPadding(i);
            wrapPagerIndicator.setFillColor(androidx.core.content.b.getColor(context, R.color.bg_01));
            return wrapPagerIndicator;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.transsion.room.view.RoomListMainTabTitleView, xy.d] */
        public xy.d c(Context context, final int i) {
            Intrinsics.h(context, "context");
            ?? roomListMainTabTitleView = new RoomListMainTabTitleView(context);
            final RoomListMainFragment roomListMainFragment = RoomListMainFragment.this;
            roomListMainTabTitleView.setTextById(roomListMainFragment.tabs[i].intValue());
            roomListMainTabTitleView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.x1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomListMainFragment.b.j(RoomListMainFragment.this, i, view);
                }
            });
            return roomListMainTabTitleView;
        }
    }

    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        public void onPageScrollStateChanged(int i) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i);
            fp.s sVar = (fp.s) RoomListMainFragment.this.getMViewBinding();
            if (sVar == null || (magicIndicator = sVar.e) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i);
        }

        public void onPageScrolled(int i, float f, int i2) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i, f, i2);
            fp.s sVar = (fp.s) RoomListMainFragment.this.getMViewBinding();
            if (sVar == null || (magicIndicator = sVar.e) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i, f, i2);
        }

        public void onPageSelected(int i) {
            MagicIndicator magicIndicator;
            super.onPageSelected(i);
            fp.s sVar = (fp.s) RoomListMainFragment.this.getMViewBinding();
            if (sVar != null && (magicIndicator = sVar.e) != null) {
                magicIndicator.onPageSelected(i);
            }
            RoomListMainFragment.this.selectTabIndex = i;
        }
    }

    public static final class d extends FragmentStateAdapter {
        d() {
            super(RoomListMainFragment.this);
        }

        public Fragment createFragment(int i) {
            return i == 0 ? RoomMyListFragment.INSTANCE.a(RoomListMainFragment.this.isSelectRoom, null) : RoomFilterListFragment.INSTANCE.a(RoomListMainFragment.this.isSelectRoom);
        }

        public int getItemCount() {
            return RoomListMainFragment.this.tabs.length;
        }
    }

    private final void e0() {
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        MagicIndicator magicIndicator;
        ORCommonNavigator oRCommonNavigator = new ORCommonNavigator(requireContext());
        oRCommonNavigator.setAdapter(new b());
        this.commonNavigator = oRCommonNavigator;
        fp.s sVar = (fp.s) getMViewBinding();
        if (sVar != null && (magicIndicator = sVar.e) != null) {
            magicIndicator.setNavigator(this.commonNavigator);
        }
        fp.s sVar2 = (fp.s) getMViewBinding();
        if (sVar2 != null && (viewPager22 = sVar2.f) != null) {
            viewPager22.registerOnPageChangeCallback(new c());
        }
        fp.s sVar3 = (fp.s) getMViewBinding();
        if (sVar3 == null || (viewPager2 = sVar3.f) == null) {
            return;
        }
        viewPager2.setCurrentItem(this.selectTabIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(RoomListMainFragment roomListMainFragment, View view) {
        FragmentActivity activity = roomListMainFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void initViewPager() {
        ViewPager2 viewPager2;
        this.vpAdapter = new d();
        fp.s sVar = (fp.s) getMViewBinding();
        if (sVar != null && (viewPager2 = sVar.f) != null) {
            viewPager2.setAdapter(this.vpAdapter);
        }
        e0();
    }

    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public fp.s getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        fp.s c2 = fp.s.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void initView(View view, Bundle savedInstanceState) {
        AppCompatImageView appCompatImageView;
        ImageView imageView;
        Intrinsics.h(view, "view");
        fp.s sVar = (fp.s) getMViewBinding();
        if (sVar != null && (imageView = sVar.d) != null) {
            uf.c.e(imageView);
        }
        fp.s sVar2 = (fp.s) getMViewBinding();
        if (sVar2 != null && (appCompatImageView = sVar2.c) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.w1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RoomListMainFragment.g0(RoomListMainFragment.this, view2);
                }
            });
        }
        initViewPager();
    }

    public void lazyLoadData() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.selectTabIndex = arguments != null ? arguments.getInt("index") : 0;
        Bundle arguments2 = getArguments();
        this.isSelectRoom = arguments2 != null ? arguments2.getBoolean("is_select_room") : false;
        ImmersionBar.with(this).statusBarDarkFont(!ij.y.a.a()).init();
    }
}
