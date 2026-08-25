package com.transsion.home.fragment.subscription;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.d;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.activity.k;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.fragment.subscription.SubscriptionBottomOpFragment;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.room.sub.fragment.subscription.SubscriptionFragment;
import gj.a;
import gj.b;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mf.c;
import qk.i;
import wj.e;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0004R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/transsion/home/fragment/subscription/SubscriptionBottomOpFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lqk/i;", "<init>", "()V", BuildConfig.FLAVOR, "h0", "g0", "d0", "Landroid/view/LayoutInflater;", "inflater", "c0", "(Landroid/view/LayoutInflater;)Lqk/i;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "hidden", "onHiddenChanged", "(Z)V", "lazyLoadData", "onResume", BuildConfig.FLAVOR, "a", "I", "tabId", BuildConfig.FLAVOR, "b", "Ljava/lang/String;", "tabCode", "c", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubscriptionBottomOpFragment extends BaseFragment<i> {

    /* renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int d = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private int tabId = HomeTabId.INSTANCE.e();

    /* renamed from: b, reason: from kotlin metadata */
    private String tabCode;

    /* renamed from: com.transsion.home.fragment.subscription.SubscriptionBottomOpFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubscriptionBottomOpFragment a(int i, String str) {
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", i);
            bundle.putString("tab_code", str);
            SubscriptionBottomOpFragment subscriptionBottomOpFragment = new SubscriptionBottomOpFragment();
            subscriptionBottomOpFragment.setArguments(bundle);
            return subscriptionBottomOpFragment;
        }
    }

    private final void d0() {
        getChildFragmentManager().p().s(R.id.bottom_op_container, SubscriptionFragment.INSTANCE.a()).i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(SubscriptionBottomOpFragment subscriptionBottomOpFragment, View view) {
        b bVar = (b) a.a.a(b.class);
        if (bVar != null) {
            Context requireContext = subscriptionBottomOpFragment.requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            bVar.c(BuildConfig.FLAVOR, requireContext);
        }
        subscriptionBottomOpFragment.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(SubscriptionBottomOpFragment subscriptionBottomOpFragment, View view) {
        Navigator.x(TheRouter.c("/commercial/playstore"), subscriptionBottomOpFragment.requireContext(), (c) null, 2, (Object) null);
        subscriptionBottomOpFragment.g0();
    }

    private final void g0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "app_center");
        com.transsion.baselib.helper.a.a.i(SubTabFragment.INSTANCE.a(this.tabId), linkedHashMap);
    }

    private final void h0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "search");
        linkedHashMap.put("hot_search_word", BuildConfig.FLAVOR);
        com.transsion.baselib.helper.a.a.i(SubTabFragment.INSTANCE.a(this.tabId), linkedHashMap);
    }

    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public i getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        i c = i.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void initView(View view, Bundle savedInstanceState) {
        i iVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        ConstraintLayout constraintLayout;
        Intrinsics.h(view, "view");
        Bundle arguments = getArguments();
        this.tabId = arguments != null ? arguments.getInt("tab_id") : this.tabId;
        Bundle arguments2 = getArguments();
        ViewGroup.LayoutParams layoutParams = null;
        this.tabCode = arguments2 != null ? arguments2.getString("tab_code") : null;
        d0();
        i iVar2 = (i) getMViewBinding();
        if (iVar2 != null && (constraintLayout = iVar2.f) != null) {
            layoutParams = constraintLayout.getLayoutParams();
        }
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).topMargin = d.c();
        i iVar3 = (i) getMViewBinding();
        if (iVar3 != null && (appCompatImageView3 = iVar3.c) != null) {
            appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: wk.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubscriptionBottomOpFragment.e0(SubscriptionBottomOpFragment.this, view2);
                }
            });
        }
        i iVar4 = (i) getMViewBinding();
        if (iVar4 != null && (appCompatImageView2 = iVar4.d) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: wk.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubscriptionBottomOpFragment.f0(SubscriptionBottomOpFragment.this, view2);
                }
            });
        }
        e eVar = (e) TheRouter.d(e.class, new Object[0]);
        if ((eVar != null && eVar.a() && !zk.a.a.a()) || (iVar = (i) getMViewBinding()) == null || (appCompatImageView = iVar.d) == null) {
            return;
        }
        uf.c.g(appCompatImageView);
    }

    public void lazyLoadData() {
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
