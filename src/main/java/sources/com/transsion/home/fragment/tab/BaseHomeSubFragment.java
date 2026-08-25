package com.transsion.home.fragment.tab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.therouter.TheRouter;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.fragment.home.HomeFragment;
import f4.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u0000 G*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004:\u00010B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0017H\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0006J\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0006J\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u0006J\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0011\u0010$\u001a\u0004\u0018\u00010#H&¢\u0006\u0004\b$\u0010%J\u001f\u0010)\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00142\u0006\u0010(\u001a\u00020'H&¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u0007¢\u0006\u0004\b+\u0010\u0006J#\u0010.\u001a\u00020\u00072\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0018\u00010,¢\u0006\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R$\u00108\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u0010\"\"\u0004\b6\u00107R\"\u0010>\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010=R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/transsion/home/fragment/tab/BaseHomeSubFragment;", "Lf4/a;", "T", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lim/f;", "<init>", "()V", BuildConfig.FLAVOR, "m0", "initAd", "o0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Landroid/view/View;", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "h0", "()I", BuildConfig.FLAVOR, "isWhite", "b0", "(Z)V", "k0", "()Z", "onMemberStateChange", "c0", "p0", BuildConfig.FLAVOR, "g0", "()Ljava/lang/String;", "Landroidx/recyclerview/widget/RecyclerView;", "f0", "()Landroidx/recyclerview/widget/RecyclerView;", "lastAdPosition", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "wrapperNativeManager", "l0", "(ILcom/transsion/ad/bidding/nativead/BiddingNativeManager;)V", "n0", BuildConfig.FLAVOR, "selectedItems", "q0", "(Ljava/util/Map;)V", "a", "Z", "mIsWhite", "b", "Ljava/lang/String;", "d0", "setMTabCode", "(Ljava/lang/String;)V", "mTabCode", "c", "I", "e0", "setMTabId", "(I)V", "mTabId", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "d", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "i0", "()Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "setV3ListManager", "(Lcom/transsion/ad/bidding/nativead/BiddingListManager;)V", "v3ListManager", "e", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BaseHomeSubFragment<T extends f4.a> extends BaseFragment<T> implements im.f {
    public static final int f = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private boolean mIsWhite;

    /* renamed from: b, reason: from kotlin metadata */
    private String mTabCode;

    /* renamed from: c, reason: from kotlin metadata */
    private int mTabId;

    /* renamed from: d, reason: from kotlin metadata */
    private BiddingListManager v3ListManager;

    private final void initAd() {
        if (TextUtils.isEmpty(g0()) || f0() == null) {
            return;
        }
        BiddingListManager biddingListManager = new BiddingListManager();
        this.v3ListManager = biddingListManager;
        biddingListManager.F(f0());
        BiddingListManager biddingListManager2 = this.v3ListManager;
        if (biddingListManager2 != null) {
            biddingListManager2.A(androidx.lifecycle.v.a(this));
        }
        BiddingListManager biddingListManager3 = this.v3ListManager;
        if (biddingListManager3 != null) {
            biddingListManager3.G(g0());
        }
        BiddingListManager biddingListManager4 = this.v3ListManager;
        if (biddingListManager4 != null) {
            biddingListManager4.H(String.valueOf(this.mTabId));
        }
        BiddingListManager biddingListManager5 = this.v3ListManager;
        if (biddingListManager5 != null) {
            biddingListManager5.z(new Function2() { // from class: com.transsion.home.fragment.tab.a
                public final Object invoke(Object obj, Object obj2) {
                    Unit j0;
                    j0 = BaseHomeSubFragment.j0(BaseHomeSubFragment.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                    return j0;
                }
            });
        }
        q0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(BaseHomeSubFragment baseHomeSubFragment, int i, BiddingNativeManager biddingNativeManager) {
        Intrinsics.h(biddingNativeManager, "current");
        baseHomeSubFragment.l0(i, biddingNativeManager);
        return Unit.a;
    }

    private final void m0() {
        String str;
        HomeFragment parentFragment = getParentFragment();
        HomeFragment homeFragment = parentFragment instanceof HomeFragment ? parentFragment : null;
        if ((homeFragment == null || (str = homeFragment.J0()) == null) && (str = this.mTabCode) == null) {
            str = BuildConfig.FLAVOR;
        }
        if (homeFragment != null) {
            homeFragment.a1(str, true);
        }
    }

    public final void b0(boolean isWhite) {
        this.mIsWhite = isWhite;
        HomeFragment parentFragment = getParentFragment();
        HomeFragment homeFragment = parentFragment instanceof HomeFragment ? parentFragment : null;
        if (homeFragment != null) {
            homeFragment.D0(isWhite);
        }
    }

    public void c0() {
        m0();
        n0();
    }

    /* renamed from: d0, reason: from getter */
    public final String getMTabCode() {
        return this.mTabCode;
    }

    /* renamed from: e0, reason: from getter */
    public final int getMTabId() {
        return this.mTabId;
    }

    public abstract RecyclerView f0();

    public String g0() {
        return "HomeFragmentListLinearTemplateAd";
    }

    public final int h0() {
        return com.blankj.utilcode.util.a0.a(78.0f) + com.blankj.utilcode.util.d.c();
    }

    /* renamed from: i0, reason: from getter */
    public final BiddingListManager getV3ListManager() {
        return this.v3ListManager;
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        if (ij.g.a.b()) {
            return;
        }
        initAd();
    }

    /* renamed from: k0, reason: from getter */
    protected final boolean getMIsWhite() {
        return this.mIsWhite;
    }

    public abstract void l0(int lastAdPosition, BiddingNativeManager wrapperNativeManager);

    public final void n0() {
        BiddingListManager biddingListManager = this.v3ListManager;
        if (biddingListManager != null) {
            biddingListManager.y();
        }
    }

    public final void o0() {
        b0(this.mIsWhite);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.mTabCode = arguments != null ? arguments.getString("tab_code") : null;
        Bundle arguments2 = getArguments();
        this.mTabId = arguments2 != null ? arguments2.getInt("tab_id") : 0;
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.D(this);
        }
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        n0();
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.v(this);
        }
    }

    @Override // im.f
    public void onMemberStateChange() {
        if (isFirst()) {
            return;
        }
        c0();
    }

    public void p0() {
    }

    public final void q0(Map selectedItems) {
        Map a = com.transsion.ad.strategy.c.a.a(BuildConfig.FLAVOR);
        Bundle arguments = getArguments();
        a.put("channelId", String.valueOf(arguments != null ? Integer.valueOf(arguments.getInt("tab_id")) : null));
        if (selectedItems != null) {
            for (Map.Entry entry : selectedItems.entrySet()) {
                a.put(entry.getKey(), entry.getValue());
            }
        }
        BiddingListManager biddingListManager = this.v3ListManager;
        if (biddingListManager != null) {
            biddingListManager.B(a);
        }
    }
}
