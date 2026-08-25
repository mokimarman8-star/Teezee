package com.transsion.ad.test.ad_config;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ci.p;
import com.blankj.utilcode.util.o;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.gson.reflect.TypeToken;
import com.transsion.ad.R;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.test.TestBaseActivity;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import sh.t;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/transsion/ad/test/ad_config/TestAdPlansActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "Lsh/t;", "a", "Lsh/t;", "binding", "AdPlansAdapter", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestAdPlansActivity extends TestBaseActivity {

    /* renamed from: a, reason: from kotlin metadata */
    private t binding;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/ad/test/ad_config/TestAdPlansActivity$AdPlansAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/ad/db/plan/MbAdDbPlans;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "holder", "mbAdDbPlans", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/ad/db/plan/MbAdDbPlans;)V", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AdPlansAdapter extends BaseQuickAdapter {
        public AdPlansAdapter() {
            super(R.layout.test_item_ad_plan_layout, (List) null, 2, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: B1, reason: merged with bridge method [inline-methods] */
        public void F(BaseViewHolder holder, MbAdDbPlans mbAdDbPlans) {
            Intrinsics.h(holder, "holder");
            Intrinsics.h(mbAdDbPlans, "mbAdDbPlans");
            StringBuilder sb = new StringBuilder();
            List list = (List) o.e(mbAdDbPlans.getAdMaterialList(), new TypeToken<List<? extends AdMaterialList>>() { // from class: com.transsion.ad.test.ad_config.TestAdPlansActivity$AdPlansAdapter$convert$adMaterialList$1
            }.getType());
            Intrinsics.e(list);
            if (!list.isEmpty()) {
                sb.append("type = " + ((AdMaterialList) list.get(0)).getType() + "\n");
            }
            sb.append("id = " + mbAdDbPlans.getId() + "\n");
            sb.append("name = " + mbAdDbPlans.getName() + "\n");
            p pVar = p.a;
            String startTime = mbAdDbPlans.getStartTime();
            sb.append("startTime = " + p.b(pVar, startTime != null ? Long.valueOf(Long.parseLong(startTime)) : null, null, 2, null) + "\n");
            String endTime = mbAdDbPlans.getEndTime();
            sb.append("endTime = " + p.b(pVar, endTime != null ? Long.valueOf(Long.parseLong(endTime)) : null, null, 2, null) + "\n");
            sb.append("dispatchTimeStart = " + mbAdDbPlans.getDispatchTimeStart() + "\n");
            sb.append("dispatchTimeEnd = " + mbAdDbPlans.getDispatchTimeEnd() + "\n");
            sb.append("displayTimes = " + mbAdDbPlans.getDisplayTimes() + "\n");
            sb.append("showedTimes = " + mbAdDbPlans.getShowedTimes() + "\n");
            sb.append("showDate = " + mbAdDbPlans.getShowDate() + "\n");
            sb.append("brand = " + mbAdDbPlans.getBrand() + "\n");
            sb.append("denyBrand = " + mbAdDbPlans.getDenyBrand() + "\n");
            sb.append("model = " + mbAdDbPlans.getModel() + "\n");
            sb.append("denyModel = " + mbAdDbPlans.getDenyModel() + "\n");
            sb.append("country = " + mbAdDbPlans.getCountry() + "\n");
            sb.append("adSource = " + mbAdDbPlans.getAdSource() + "\n");
            sb.append("extAdSlot = " + mbAdDbPlans.getExtAdSlot() + "\n");
            sb.append("sort = " + mbAdDbPlans.getSort() + "\n");
            sb.append("bidEcpmCent = " + mbAdDbPlans.getBidEcpmCent() + "\n");
            sb.append("ecpmCent = " + mbAdDbPlans.getEcpmCent() + "\n");
            sb.append("h5LinkPreload = " + mbAdDbPlans.getH5LinkPreload() + "\n");
            sb.append("h5LinkOpenByCct = " + mbAdDbPlans.getH5LinkOpenByCct() + "\n");
            holder.setText(R.id.tvConfig, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(TestAdPlansActivity testAdPlansActivity, View view) {
        i.d(v.a(testAdPlansActivity), (CoroutineContext) null, (CoroutineStart) null, new TestAdPlansActivity$onCreate$1$1(null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void S(TestAdPlansActivity testAdPlansActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        Object obj = baseQuickAdapter.getData().get(i);
        MbAdDbPlans mbAdDbPlans = obj instanceof MbAdDbPlans ? (MbAdDbPlans) obj : null;
        if (mbAdDbPlans != null) {
            Intent intent = new Intent((Context) testAdPlansActivity, (Class<?>) TestAdPlanDetailActivity.class);
            intent.putExtra("MbAdDbPlans", mbAdDbPlans);
            testAdPlansActivity.startActivity(intent);
        }
    }

    @Override // xh.b
    public String getLogTag() {
        return "ad_";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        t c = t.c(getLayoutInflater());
        this.binding = c;
        if (c == null) {
            Intrinsics.y("binding");
            c = null;
        }
        setContentView(c.b());
        t tVar = this.binding;
        if (tVar == null) {
            Intrinsics.y("binding");
            tVar = null;
        }
        tVar.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_config.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdPlansActivity.R(TestAdPlansActivity.this, view);
            }
        });
        AdPlansAdapter adPlansAdapter = new AdPlansAdapter();
        t tVar2 = this.binding;
        if (tVar2 == null) {
            Intrinsics.y("binding");
            tVar2 = null;
        }
        RecyclerView recyclerView = tVar2.c;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adPlansAdapter);
        adPlansAdapter.w1(new r6.d() { // from class: com.transsion.ad.test.ad_config.c
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                TestAdPlansActivity.S(TestAdPlansActivity.this, baseQuickAdapter, view, i);
            }
        });
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new TestAdPlansActivity$onCreate$4(adPlansAdapter, this, null), 3, (Object) null);
    }
}
