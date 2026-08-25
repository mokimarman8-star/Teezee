package com.transsion.home.fragment.bottom;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.a0;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.activity.k;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.adapter.d;
import com.transsion.home.fragment.bottom.BottomOpFragment;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p000enum.HomeTabId;
import gj.a;
import ij.g;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import qk.h;
import uf.c;
import wj.e;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0004R\u0016\u0010#\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/transsion/home/fragment/bottom/BottomOpFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lqk/h;", "<init>", "()V", BuildConfig.FLAVOR, "k0", "j0", "f0", "e0", "i0", "Landroid/view/LayoutInflater;", "inflater", "d0", "(Landroid/view/LayoutInflater;)Lqk/h;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "hidden", "onHiddenChanged", "(Z)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", BuildConfig.FLAVOR, "c0", "()I", "lazyLoadData", "onResume", "a", "I", "tabId", BuildConfig.FLAVOR, "b", "Ljava/lang/String;", "tabCode", "c", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class BottomOpFragment extends BaseFragment<h> {

    /* renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int d = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private int tabId = HomeTabId.INSTANCE.e();

    /* renamed from: b, reason: from kotlin metadata */
    private String tabCode;

    /* renamed from: com.transsion.home.fragment.bottom.BottomOpFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BottomOpFragment a(int i, String str) {
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", i);
            bundle.putString("tab_code", str);
            BottomOpFragment bottomOpFragment = new BottomOpFragment();
            bottomOpFragment.setArguments(bundle);
            return bottomOpFragment;
        }
    }

    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(BottomOpFragment bottomOpFragment, int i) {
            MagicIndicator magicIndicator;
            h hVar = (h) bottomOpFragment.getMViewBinding();
            if (hVar == null || (magicIndicator = hVar.h) == null) {
                return;
            }
            magicIndicator.onPageSelected(i);
        }

        public void onPageScrollStateChanged(int i) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i);
            h hVar = (h) BottomOpFragment.this.getMViewBinding();
            if (hVar == null || (magicIndicator = hVar.h) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i);
        }

        public void onPageScrolled(int i, float f, int i2) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i, f, i2);
            h hVar = (h) BottomOpFragment.this.getMViewBinding();
            if (hVar == null || (magicIndicator = hVar.h) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i, f, i2);
        }

        public void onPageSelected(final int i) {
            View view;
            View view2;
            MagicIndicator magicIndicator;
            super.onPageSelected(i);
            h hVar = (h) BottomOpFragment.this.getMViewBinding();
            if (hVar != null && (magicIndicator = hVar.h) != null) {
                final BottomOpFragment bottomOpFragment = BottomOpFragment.this;
                magicIndicator.post(new Runnable() { // from class: tk.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        BottomOpFragment.b.b(BottomOpFragment.this, i);
                    }
                });
            }
            if (i == 0) {
                h hVar2 = (h) BottomOpFragment.this.getMViewBinding();
                if (hVar2 == null || (view2 = hVar2.j) == null) {
                    return;
                }
                view2.setVisibility(8);
                return;
            }
            h hVar3 = (h) BottomOpFragment.this.getMViewBinding();
            if (hVar3 == null || (view = hVar3.j) == null) {
                return;
            }
            view.setVisibility(0);
        }
    }

    private final void e0() {
        MagicIndicator magicIndicator;
        FrameLayout frameLayout;
        h hVar = (h) getMViewBinding();
        if (hVar != null && (frameLayout = hVar.b) != null) {
            c.h(frameLayout);
        }
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdapter(new d((h) getMViewBinding()));
        h hVar2 = (h) getMViewBinding();
        if (hVar2 == null || (magicIndicator = hVar2.h) == null) {
            return;
        }
        magicIndicator.setNavigator(commonNavigator);
    }

    private final void f0() {
        View view;
        MagicIndicator magicIndicator;
        ViewPager2 viewPager2;
        h hVar = (h) getMViewBinding();
        if (hVar != null && (viewPager2 = hVar.k) != null) {
            c.h(viewPager2);
        }
        h hVar2 = (h) getMViewBinding();
        if (hVar2 != null && (magicIndicator = hVar2.h) != null) {
            c.h(magicIndicator);
        }
        h hVar3 = (h) getMViewBinding();
        if (hVar3 != null && (view = hVar3.j) != null) {
            c.h(view);
        }
        Bundle arguments = getArguments();
        getChildFragmentManager().p().s(R.id.bottom_op_container, SubTabFragment.INSTANCE.b(this.tabId, arguments != null ? arguments.getString("tab_code") : null)).i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(BottomOpFragment bottomOpFragment, View view) {
        gj.b bVar = (gj.b) a.a.a(gj.b.class);
        if (bVar != null) {
            Context requireContext = bottomOpFragment.requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            bVar.c(BuildConfig.FLAVOR, requireContext);
        }
        bottomOpFragment.k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(BottomOpFragment bottomOpFragment, View view) {
        Navigator.x(TheRouter.c("/commercial/playstore"), bottomOpFragment.requireContext(), (mf.c) null, 2, (Object) null);
        bottomOpFragment.j0();
    }

    private final void i0() {
        ViewPager2 viewPager2;
        h hVar = (h) getMViewBinding();
        com.transsion.home.adapter.c cVar = new com.transsion.home.adapter.c(hVar != null ? hVar.k : null, this.tabId, this.tabCode, this);
        h hVar2 = (h) getMViewBinding();
        if (hVar2 != null) {
            hVar2.k.setAdapter(cVar);
        }
        h hVar3 = (h) getMViewBinding();
        if (hVar3 == null || (viewPager2 = hVar3.k) == null) {
            return;
        }
        viewPager2.registerOnPageChangeCallback(new b());
    }

    private final void j0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "app_center");
        com.transsion.baselib.helper.a.a.i(SubTabFragment.INSTANCE.a(this.tabId), linkedHashMap);
    }

    private final void k0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "search");
        linkedHashMap.put("hot_search_word", BuildConfig.FLAVOR);
        com.transsion.baselib.helper.a.a.i(SubTabFragment.INSTANCE.a(this.tabId), linkedHashMap);
    }

    public final int c0() {
        int a = a0.a(56.0f) + com.blankj.utilcode.util.d.c();
        return this.tabId == HomeTabId.INSTANCE.e() ? a + a0.a(22.0f) : a;
    }

    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public h getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        h c = h.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void initView(View view, Bundle savedInstanceState) {
        h hVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        TnTextView tnTextView;
        ConstraintLayout constraintLayout;
        Intrinsics.h(view, "view");
        Bundle arguments = getArguments();
        this.tabId = arguments != null ? arguments.getInt("tab_id") : this.tabId;
        Bundle arguments2 = getArguments();
        ViewGroup.LayoutParams layoutParams = null;
        this.tabCode = arguments2 != null ? arguments2.getString("tab_code") : null;
        if (this.tabId != HomeTabId.INSTANCE.e() || g.a.b()) {
            f0();
        } else {
            i0();
            e0();
        }
        h hVar2 = (h) getMViewBinding();
        if (hVar2 != null && (constraintLayout = hVar2.f) != null) {
            layoutParams = constraintLayout.getLayoutParams();
        }
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).topMargin = com.blankj.utilcode.util.d.c();
        h hVar3 = (h) getMViewBinding();
        if (hVar3 != null && (tnTextView = hVar3.g) != null) {
            tnTextView.setOnClickListener(new View.OnClickListener() { // from class: tk.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BottomOpFragment.g0(BottomOpFragment.this, view2);
                }
            });
        }
        h hVar4 = (h) getMViewBinding();
        if (hVar4 != null && (appCompatImageView2 = hVar4.d) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: tk.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BottomOpFragment.h0(BottomOpFragment.this, view2);
                }
            });
        }
        e eVar = (e) TheRouter.d(e.class, new Object[0]);
        if ((eVar != null && eVar.a() && !zk.a.a.a()) || (hVar = (h) getMViewBinding()) == null || (appCompatImageView = hVar.d) == null) {
            return;
        }
        c.g(appCompatImageView);
    }

    public void lazyLoadData() {
    }

    public qi.b newLogViewConfig() {
        String str = this.tabCode;
        if (str == null) {
            str = "BottomOpFragment: " + this.tabId;
        }
        return new qi.b(str, false, 2, null);
    }

    public void onHiddenChanged(boolean hidden) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                logResume();
            }
        }
        k.h(null, this, hidden, null, 9, null);
    }

    public void onResume() {
        super.onResume();
    }
}
