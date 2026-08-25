package com.transsion.rewardscenter.task.member;

import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i extends BaseTaskCommonProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(zo.a aVar) {
        super(aVar);
        Intrinsics.h(aVar, "config");
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public String D(MemberTaskItem memberTaskItem) {
        Intrinsics.h(memberTaskItem, "item");
        return String.valueOf(memberTaskItem.getTitle());
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public boolean F(MemberTaskItem memberTaskItem) {
        return false;
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void G() {
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void K(TextView textView, MemberTaskItem memberTaskItem) {
        String str;
        Intrinsics.h(textView, "button");
        Intrinsics.h(memberTaskItem, "item");
        String jumpUrl = memberTaskItem.getJumpUrl();
        if (jumpUrl == null || jumpUrl.length() == 0) {
            str = "https://h5-aoneroom.com/spa/fissionh5/pp";
        } else {
            str = memberTaskItem.getJumpUrl();
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
        }
        hj.b.d(hj.b.a, k(), "oneroom://com.community.oneroom?type=/web/web&url=" + str, null, 4, null);
    }

    public int l() {
        return TaskType.PALM_PAY.getValue();
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, MemberTaskItem memberTaskItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(memberTaskItem, "item");
        super.b(baseViewHolder, memberTaskItem);
        TextView textView = (TextView) baseViewHolder.getView(R$id.member_item_task_button);
        memberTaskItem.setStatus(0);
        E(textView, memberTaskItem);
    }
}
