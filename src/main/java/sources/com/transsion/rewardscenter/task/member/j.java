package com.transsion.rewardscenter.task.member;

import android.widget.TextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j extends BaseTaskCommonProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(zo.a aVar) {
        super(aVar);
        Intrinsics.h(aVar, "config");
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public boolean F(MemberTaskItem memberTaskItem) {
        Integer status;
        Integer durationCondition;
        return (memberTaskItem == null || (status = memberTaskItem.getStatus()) == null || status.intValue() != 3) && hm.k.a.H() >= ((memberTaskItem == null || (durationCondition = memberTaskItem.getDurationCondition()) == null) ? 0 : durationCondition.intValue());
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void G() {
        hm.k.a.w();
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void K(TextView textView, MemberTaskItem memberTaskItem) {
        String str;
        Intrinsics.h(textView, "button");
        Intrinsics.h(memberTaskItem, "item");
        String jumpUrl = memberTaskItem.getJumpUrl();
        if (jumpUrl == null || jumpUrl.length() == 0) {
            str = "oneroom://com.community.oneroom?type=/commercial/gamecenter&fromTask=true";
        } else {
            str = memberTaskItem.getJumpUrl();
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
        }
        hj.b.d(hj.b.a, k(), str, null, 4, null);
    }

    public int l() {
        return TaskType.PLAY_GAME.getValue();
    }
}
