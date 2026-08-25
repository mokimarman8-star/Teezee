package com.transsion.ad.test.ad_config;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.o;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.R;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import com.transsion.ad.ps.model.ItemDetail;
import com.transsion.ad.ps.model.PSAdTypeEnum;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.ad.test.TestBaseActivity;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import sh.u;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/transsion/ad/test/ad_config/TestAdPsOfferActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", BuildConfig.FLAVOR, "W", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lsh/u;", "a", "Lsh/u;", "binding", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestAdPsOfferActivity extends TestBaseActivity {

    /* renamed from: a, reason: from kotlin metadata */
    private u binding;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/ad/test/ad_config/TestAdPsOfferActivity$a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/ad/db/pslink/PsLinkAdPlan;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/ad/db/pslink/PsLinkAdPlan;)V", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends BaseQuickAdapter {
        public a() {
            super(R.layout.test_item_ad_plan_layout, (List) null, 2, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: B1, reason: merged with bridge method [inline-methods] */
        public void F(BaseViewHolder holder, PsLinkAdPlan item) {
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            StringBuilder sb = new StringBuilder();
            RecommendInfo recommendInfo = (RecommendInfo) o.d(item.getPsInfoJson(), RecommendInfo.class);
            sb.append("id = " + item.getId() + "\n");
            sb.append("nonId = " + item.getNonId() + "\n");
            sb.append("adSource = " + item.getAdSource() + "\n");
            sb.append("extAdSlot = " + item.getExtAdSlot() + "\n");
            sb.append("showMax = " + item.getShowMax() + "\n");
            sb.append("clickMax = " + item.getClickMax() + "\n");
            sb.append("showHours = " + item.getShowHours() + "\n");
            sb.append("showedTimes = " + item.getShowedTimes() + "\n");
            sb.append("clickedTimes = " + item.getClickedTimes() + "\n");
            sb.append("showDate = " + item.getShowDate() + "\n");
            sb.append("rank = " + item.getRank() + "\n");
            sb.append("psPlanId = " + item.getPsPlanId() + "\n");
            sb.append("updateTimestamp = " + item.getUpdateTimestamp() + "\n");
            sb.append("packageName = " + recommendInfo.getPackageName() + "\n");
            ItemDetail detail = recommendInfo.getDetail();
            sb.append("name = " + (detail != null ? detail.getName() : null) + "\n");
            sb.append("showAttributionLink = " + recommendInfo.getShowAttributionLink() + "\n");
            sb.append("attributionLink = " + recommendInfo.getAttributionLink() + "\n");
            sb.append("deepLink = " + recommendInfo.getDeepLink() + "\n");
            sb.append("gpLink = " + recommendInfo.getGpLink() + "\n");
            sb.append("isOffer = " + recommendInfo.isOffer() + "\n");
            Integer adType = recommendInfo.getAdType();
            int value = PSAdTypeEnum.PS_AD_TYPE_USER_RETENTION_1.getValue();
            if (adType != null && adType.intValue() == value) {
                sb.append("adType = 拉活\n");
            } else {
                sb.append("adType = 拉新\n");
            }
            holder.setText(R.id.tvConfig, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(TestAdPsOfferActivity testAdPsOfferActivity, View view) {
        rh.f.a.h(!r2.d());
        testAdPsOfferActivity.W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(TestAdPsOfferActivity testAdPsOfferActivity, View view) {
        i.d(v.a(testAdPsOfferActivity), (CoroutineContext) null, (CoroutineStart) null, new TestAdPsOfferActivity$onCreate$4$1(testAdPsOfferActivity, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(TestAdPsOfferActivity testAdPsOfferActivity, View view) {
        rh.f.a.e(!r2.a());
        testAdPsOfferActivity.W();
    }

    private final void W() {
        u uVar = this.binding;
        u uVar2 = null;
        if (uVar == null) {
            Intrinsics.y("binding");
            uVar = null;
        }
        Button button = uVar.b;
        rh.f fVar = rh.f.a;
        button.setText(fVar.d() ? "releasePsApi = true" : "releasePsApi = false");
        u uVar3 = this.binding;
        if (uVar3 == null) {
            Intrinsics.y("binding");
        } else {
            uVar2 = uVar3;
        }
        uVar2.d.setText(fVar.a() ? "detailRequestLog = true" : "detailRequestLog = false");
    }

    @Override // xh.b
    public String getLogTag() {
        return "ad_ps_d";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        u c = u.c(getLayoutInflater());
        this.binding = c;
        u uVar = null;
        if (c == null) {
            Intrinsics.y("binding");
            c = null;
        }
        setContentView(c.b());
        a aVar = new a();
        u uVar2 = this.binding;
        if (uVar2 == null) {
            Intrinsics.y("binding");
            uVar2 = null;
        }
        RecyclerView recyclerView = uVar2.e;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(aVar);
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new TestAdPsOfferActivity$onCreate$2(this, aVar, null), 3, (Object) null);
        W();
        u uVar3 = this.binding;
        if (uVar3 == null) {
            Intrinsics.y("binding");
            uVar3 = null;
        }
        uVar3.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_config.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdPsOfferActivity.S(TestAdPsOfferActivity.this, view);
            }
        });
        u uVar4 = this.binding;
        if (uVar4 == null) {
            Intrinsics.y("binding");
            uVar4 = null;
        }
        uVar4.c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_config.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdPsOfferActivity.U(TestAdPsOfferActivity.this, view);
            }
        });
        u uVar5 = this.binding;
        if (uVar5 == null) {
            Intrinsics.y("binding");
        } else {
            uVar = uVar5;
        }
        uVar.d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_config.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdPsOfferActivity.V(TestAdPsOfferActivity.this, view);
            }
        });
    }
}
