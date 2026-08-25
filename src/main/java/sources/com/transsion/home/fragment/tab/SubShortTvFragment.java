package com.transsion.home.fragment.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.shorttv.ui.fragment.ShortTVDiscoverFragment;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001/\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u001f\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010$R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/transsion/home/fragment/tab/SubShortTvFragment;", "Lcom/transsion/home/fragment/tab/BaseHomeSubFragment;", "Lqk/v;", "<init>", "()V", BuildConfig.FLAVOR, "y0", BuildConfig.FLAVOR, "alpha", "E0", "(F)V", "z0", "()F", "Landroid/view/LayoutInflater;", "inflater", "A0", "(Landroid/view/LayoutInflater;)Lqk/v;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "p0", BuildConfig.FLAVOR, "lastAdPosition", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "wrapperNativeManager", "l0", "(ILcom/transsion/ad/bidding/nativead/BiddingNativeManager;)V", "Landroidx/recyclerview/widget/RecyclerView;", "f0", "()Landroidx/recyclerview/widget/RecyclerView;", BuildConfig.FLAVOR, "g", "Z", "mHasTranslateWindow", "h", "I", "mHeaderBgHeight", "i", "mIsFirstRender", "Lcom/transsion/shorttv/ui/fragment/ShortTVDiscoverFragment;", "j", "Lcom/transsion/shorttv/ui/fragment/ShortTVDiscoverFragment;", "shorTvFragment", "com/transsion/home/fragment/tab/SubShortTvFragment$b", "k", "Lcom/transsion/home/fragment/tab/SubShortTvFragment$b;", "mRecycleScrollListener", "l", "a", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubShortTvFragment extends BaseHomeSubFragment<qk.v> {

    /* renamed from: l, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int m = 8;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean mHasTranslateWindow;

    /* renamed from: h, reason: from kotlin metadata */
    private int mHeaderBgHeight;

    /* renamed from: j, reason: from kotlin metadata */
    private ShortTVDiscoverFragment shorTvFragment;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean mIsFirstRender = true;

    /* renamed from: k, reason: from kotlin metadata */
    private final b mRecycleScrollListener = new b();

    /* renamed from: com.transsion.home.fragment.tab.SubShortTvFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubShortTvFragment a(int i) {
            SubShortTvFragment subShortTvFragment = new SubShortTvFragment();
            subShortTvFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("tab_id", Integer.valueOf(i))}));
            return subShortTvFragment;
        }
    }

    public static final class b extends RecyclerView.r {
        b() {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.h(recyclerView, "recyclerView");
            if (SubShortTvFragment.this.mHasTranslateWindow) {
                int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                SubShortTvFragment.this.E0(RangesKt.g((computeVerticalScrollOffset * 1.0f) / r3.mHeaderBgHeight, 1.0f));
                if (!SubShortTvFragment.this.getMIsWhite() && SubShortTvFragment.this.z0() < 0.7f) {
                    SubShortTvFragment.this.b0(true);
                } else {
                    if (!SubShortTvFragment.this.getMIsWhite() || SubShortTvFragment.this.z0() < 0.7f) {
                        return;
                    }
                    SubShortTvFragment.this.b0(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vr.a B0() {
        return new com.transsion.postdetail.shorttv.factory.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ws.a C0() {
        return new com.transsion.postdetail.shorttv.factory.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(SubShortTvFragment subShortTvFragment, boolean z) {
        subShortTvFragment.mHasTranslateWindow = z;
        if (subShortTvFragment.mIsFirstRender) {
            subShortTvFragment.y0();
            subShortTvFragment.mIsFirstRender = false;
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(float alpha) {
        View view;
        qk.v vVar = (qk.v) getMViewBinding();
        if (vVar == null || (view = vVar.c) == null) {
            return;
        }
        view.setAlpha(alpha);
    }

    private final void y0() {
        View view;
        FrameLayout frameLayout;
        qk.v vVar = (qk.v) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (vVar == null || (frameLayout = vVar.b) == null) ? null : frameLayout.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (this.mHasTranslateWindow) {
            layoutParams2.topMargin = 0;
            E0(0.0f);
            b0(true);
        } else {
            qk.v vVar2 = (qk.v) getMViewBinding();
            layoutParams2.topMargin = (vVar2 == null || (view = vVar2.c) == null) ? 0 : view.getHeight();
            E0(1.0f);
            b0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float z0() {
        View view;
        qk.v vVar = (qk.v) getMViewBinding();
        if (vVar == null || (view = vVar.c) == null) {
            return 0.0f;
        }
        return view.getAlpha();
    }

    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public qk.v getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        qk.v c = qk.v.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public RecyclerView f0() {
        return null;
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void initView(View view, Bundle savedInstanceState) {
        View view2;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.h(view, "view");
        pq.c.a.a(new Function0() { // from class: com.transsion.home.fragment.tab.v
            public final Object invoke() {
                vr.a B0;
                B0 = SubShortTvFragment.B0();
                return B0;
            }
        });
        cs.a.a.a(new Function0() { // from class: com.transsion.home.fragment.tab.w
            public final Object invoke() {
                ws.a C0;
                C0 = SubShortTvFragment.C0();
                return C0;
            }
        });
        this.shorTvFragment = ShortTVDiscoverFragment.I.a(true, getArguments());
        this.mHeaderBgHeight = h0();
        qk.v vVar = (qk.v) getMViewBinding();
        if (vVar != null && (view2 = vVar.c) != null && (layoutParams = view2.getLayoutParams()) != null) {
            layoutParams.height = this.mHeaderBgHeight;
        }
        ShortTVDiscoverFragment shortTVDiscoverFragment = this.shorTvFragment;
        if (shortTVDiscoverFragment != null) {
            shortTVDiscoverFragment.B1(this.mRecycleScrollListener, new Function1() { // from class: com.transsion.home.fragment.tab.x
                public final Object invoke(Object obj) {
                    Unit D0;
                    D0 = SubShortTvFragment.D0(SubShortTvFragment.this, ((Boolean) obj).booleanValue());
                    return D0;
                }
            });
        }
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void l0(int lastAdPosition, BiddingNativeManager wrapperNativeManager) {
        Intrinsics.h(wrapperNativeManager, "wrapperNativeManager");
    }

    public void lazyLoadData() {
        y0();
        ShortTVDiscoverFragment shortTVDiscoverFragment = this.shorTvFragment;
        if (shortTVDiscoverFragment != null) {
            getChildFragmentManager().p().s(R.id.sub_shor_tv_container, shortTVDiscoverFragment).i();
        }
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void p0() {
        ShortTVDiscoverFragment shortTVDiscoverFragment = this.shorTvFragment;
        if (shortTVDiscoverFragment != null) {
            shortTVDiscoverFragment.u1();
        }
    }
}
