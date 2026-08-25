package com.transsion.rewardscenter.task.member;

import android.widget.TextView;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h extends BaseTaskCommonProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(zo.a aVar) {
        super(aVar);
        Intrinsics.h(aVar, "config");
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void E(TextView textView, MemberTaskItem memberTaskItem) {
        Intrinsics.h(textView, "button");
        Intrinsics.h(memberTaskItem, "item");
        super.E(textView, memberTaskItem);
        textView.setAlpha(0.5f);
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void K(TextView textView, MemberTaskItem memberTaskItem) {
        Intrinsics.h(textView, "button");
        Intrinsics.h(memberTaskItem, "item");
    }

    public int l() {
        return TaskType.OPEN_APP.getValue();
    }
}
