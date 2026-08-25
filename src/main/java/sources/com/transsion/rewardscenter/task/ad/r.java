package com.transsion.rewardscenter.task.ad;

import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.task.ad.v;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r extends BaseItemProvider {
    private final BaseStageTaskAdHelper e;
    private boolean f;
    private final int g = AdTaskType.STAGE_AD.getValue();
    private final int h = R$layout.member_task_stage_item_layout;

    public r(BaseStageTaskAdHelper baseStageTaskAdHelper) {
        this.e = baseStageTaskAdHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(r rVar, v vVar, v.c cVar) {
        Intrinsics.h(cVar, "it");
        rVar.B((v.c) vVar);
        return Unit.a;
    }

    private final void B(v.c cVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "member_ad_task_stage");
        hashMap.put("ad_state", cVar.e().name());
        qi.h.a.o("MemberAdTask", hashMap);
    }

    private final void C() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "member_ad_task_stage");
        qi.h.a.z("MemberAdTask", hashMap);
    }

    public int l() {
        return this.g;
    }

    public int m() {
        return this.h;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final v vVar) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(vVar, "item");
        if (vVar instanceof v.c) {
            Object obj = ((RecyclerView.a0) baseViewHolder).itemView;
            Intrinsics.f(obj, "null cannot be cast to non-null type com.transsion.rewardscenter.task.ad.StageTaskAdView");
            StageTaskAdView stageTaskAdView = (StageTaskAdView) obj;
            stageTaskAdView.setAdHelper(this.e);
            stageTaskAdView.setData((v.c) vVar);
            stageTaskAdView.setClickCallback(new Function1() { // from class: com.transsion.rewardscenter.task.ad.q
                public final Object invoke(Object obj2) {
                    Unit A;
                    A = r.A(r.this, vVar, (v.c) obj2);
                    return A;
                }
            });
            if (this.f) {
                return;
            }
            this.f = true;
            C();
        }
    }
}
