package com.transsion.ad.test.ad_example;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.R;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.test.TestBaseActivity;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.gslb.BuildConfig;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u0015\u0011\u0019\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000f\u0010\u0003R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/transsion/ad/test/ad_example/TestAdNativeListActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", BuildConfig.FLAVOR, "U", "W", "R", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lsh/p;", "a", "Lsh/p;", "binding", "Lcom/transsion/ad/test/ad_example/TestAdNativeListActivity$a;", "b", "Lcom/transsion/ad/test/ad_example/TestAdNativeListActivity$a;", "mTestAdapter", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "c", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "v3ListManager", "d", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestAdNativeListActivity extends TestBaseActivity {

    /* renamed from: a, reason: from kotlin metadata */
    private sh.p binding;

    /* renamed from: b, reason: from kotlin metadata */
    private a mTestAdapter;

    /* renamed from: c, reason: from kotlin metadata */
    private BiddingListManager v3ListManager;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/transsion/ad/test/ad_example/TestAdNativeListActivity$a;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/ad/test/ad_example/TestAdNativeListActivity$b;", "Lt6/i;", "<init>", "()V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends BaseProviderMultiAdapter<b> implements t6.i {
        public a() {
            super((List) null, 1, (DefaultConstructorMarker) null);
            F1(new c());
            F1(new d());
        }

        protected int N1(List<b> data, int position) {
            Intrinsics.h(data, "data");
            return data.get(position).a() != null ? 2 : 1;
        }

        public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
            return t6.h.a(this, baseQuickAdapter);
        }
    }

    public static final class b {
        public static final a c = new a(null);
        private final String a;
        private final BiddingNativeManager b;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(String str, BiddingNativeManager biddingNativeManager) {
            Intrinsics.h(str, "title");
            this.a = str;
            this.b = biddingNativeManager;
        }

        public final BiddingNativeManager a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.c(this.a, bVar.a) && Intrinsics.c(this.b, bVar.b);
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            BiddingNativeManager biddingNativeManager = this.b;
            return hashCode + (biddingNativeManager == null ? 0 : biddingNativeManager.hashCode());
        }

        public String toString() {
            return "TestAdNativeListBean(title=" + this.a + ", adManager=" + this.b + ")";
        }
    }

    public static final class c extends BaseItemProvider {
        public int l() {
            return 2;
        }

        public int m() {
            return R.layout.test_ad_native_list_ad_item_layout;
        }

        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public void b(BaseViewHolder baseViewHolder, b bVar) {
            Intrinsics.h(baseViewHolder, "helper");
            Intrinsics.h(bVar, "item");
            s sVar = new s(k());
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) baseViewHolder.getViewOrNull(R.id.nativeView);
            if (nativeWrapperAdView != null) {
                BiddingNativeManager a = bVar.a();
                BiddingNativeManager a2 = bVar.a();
                nativeWrapperAdView.bindNativeView(a, sVar, a2 != null ? a2.k0() : null);
            }
        }
    }

    public static final class d extends BaseItemProvider {
        public int l() {
            return 1;
        }

        public int m() {
            return R.layout.test_ad_native_list_content_item_layout;
        }

        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public void b(BaseViewHolder baseViewHolder, b bVar) {
            Intrinsics.h(baseViewHolder, "helper");
            Intrinsics.h(bVar, "item");
        }
    }

    private final void R() {
        BiddingListManager biddingListManager = new BiddingListManager();
        sh.p pVar = this.binding;
        if (pVar == null) {
            Intrinsics.y("binding");
            pVar = null;
        }
        biddingListManager.F(pVar.b);
        biddingListManager.A(androidx.lifecycle.v.a(this));
        biddingListManager.G("MBNativeTestId");
        biddingListManager.B(new LinkedHashMap());
        biddingListManager.z(new Function2() { // from class: com.transsion.ad.test.ad_example.o
            public final Object invoke(Object obj, Object obj2) {
                Unit S;
                S = TestAdNativeListActivity.S(TestAdNativeListActivity.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                return S;
            }
        });
        this.v3ListManager = biddingListManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(TestAdNativeListActivity testAdNativeListActivity, int i, BiddingNativeManager biddingNativeManager) {
        List data;
        Intrinsics.h(biddingNativeManager, "current");
        a aVar = testAdNativeListActivity.mTestAdapter;
        int size = (aVar == null || (data = aVar.getData()) == null) ? 0 : data.size();
        b bVar = new b(BuildConfig.FLAVOR, biddingNativeManager);
        if (i < size) {
            a aVar2 = testAdNativeListActivity.mTestAdapter;
            if (aVar2 != null) {
                aVar2.n(i, bVar);
            }
        } else {
            a aVar3 = testAdNativeListActivity.mTestAdapter;
            if (aVar3 != null) {
                aVar3.p(bVar);
            }
        }
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U() {
        sh.p pVar = this.binding;
        if (pVar == null) {
            Intrinsics.y("binding");
            pVar = null;
        }
        RecyclerView recyclerView = pVar.b;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        a aVar = new a();
        aVar.h0().z(true);
        aVar.h0().B(true);
        aVar.h0().D(new r6.f() { // from class: com.transsion.ad.test.ad_example.p
            public final void a() {
                TestAdNativeListActivity.V(TestAdNativeListActivity.this);
            }
        });
        this.mTestAdapter = aVar;
        recyclerView.setAdapter(aVar);
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(TestAdNativeListActivity testAdNativeListActivity) {
        testAdNativeListActivity.W();
    }

    private final void W() {
        kotlinx.coroutines.i.d(androidx.lifecycle.v.a(this), (CoroutineContext) null, (CoroutineStart) null, new TestAdNativeListActivity$loadMore$1(this, null), 3, (Object) null);
    }

    @Override // xh.b
    public String getLogTag() {
        return "ad_n";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        sh.p c2 = sh.p.c(getLayoutInflater());
        this.binding = c2;
        if (c2 == null) {
            Intrinsics.y("binding");
            c2 = null;
        }
        setContentView(c2.b());
        R();
        U();
    }

    protected void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.v3ListManager;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
    }
}
