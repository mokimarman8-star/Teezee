package com.transsion.rewardscenter.task.ad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.task.ad.v;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class p extends BaseItemProvider {
    private final MemberTaskAdHelper e;
    private boolean f;
    private final int g = AdTaskType.REWARD_AD.getValue();
    private final int h = R$layout.member_task_reward_layout;

    public p(MemberTaskAdHelper memberTaskAdHelper) {
        this.e = memberTaskAdHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(p pVar, View view) {
        pVar.D(true);
        MemberTaskAdHelper memberTaskAdHelper = pVar.e;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.Y(new Function1() { // from class: com.transsion.rewardscenter.task.ad.o
                public final Object invoke(Object obj) {
                    Unit C;
                    C = p.C(((Boolean) obj).booleanValue());
                    return C;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(boolean z) {
        return Unit.a;
    }

    private final void D(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "member_ad_task_reward");
        if (z) {
            qi.h.a.o("MemberAdTask", hashMap);
        } else {
            qi.h.a.z("MemberAdTask", hashMap);
        }
    }

    static /* synthetic */ void E(p pVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        pVar.D(z);
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, v vVar) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(vVar, "item");
        if (vVar instanceof v.b) {
            View findViewById = ((RecyclerView.a0) baseViewHolder).itemView.findViewById(R$id.reward_action);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.task.ad.n
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        p.B(p.this, view);
                    }
                });
            }
            if (this.f) {
                return;
            }
            this.f = true;
            E(this, false, 1, null);
        }
    }

    public int l() {
        return this.g;
    }

    public int m() {
        return this.h;
    }

    public BaseViewHolder r(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(m(), viewGroup, false);
        Intrinsics.e(inflate);
        return new BaseViewHolder(inflate);
    }
}
