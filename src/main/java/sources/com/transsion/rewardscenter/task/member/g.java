package com.transsion.rewardscenter.task.member;

import android.widget.TextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g extends BaseTaskCommonProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(zo.a aVar) {
        super(aVar);
        Intrinsics.h(aVar, "config");
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public String D(MemberTaskItem memberTaskItem) {
        Intrinsics.h(memberTaskItem, "item");
        long intValue = (memberTaskItem.getDurationCondition() != null ? r0.intValue() : 0) / 60;
        long i = RangesKt.i(hm.k.a.D(), intValue);
        return memberTaskItem.getTitle() + " (" + i + "/" + intValue + " mins)";
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public boolean F(MemberTaskItem memberTaskItem) {
        Integer status;
        Integer durationCondition;
        return (memberTaskItem == null || (status = memberTaskItem.getStatus()) == null || status.intValue() != 3) && hm.k.a.D() >= ((long) ((memberTaskItem == null || (durationCondition = memberTaskItem.getDurationCondition()) == null) ? 0 : durationCondition.intValue())) / 60;
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void K(TextView textView, MemberTaskItem memberTaskItem) {
        String str;
        Intrinsics.h(textView, "button");
        Intrinsics.h(memberTaskItem, "item");
        String jumpUrl = memberTaskItem.getJumpUrl();
        if (jumpUrl == null || jumpUrl.length() == 0) {
            str = "oneroom://com.community.oneroom?type=/main/tab&bottomTab=home&topTab=Game";
        } else {
            str = memberTaskItem.getJumpUrl();
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
        }
        hj.b.d(hj.b.a, k(), str, null, 4, null);
    }

    public int l() {
        return TaskType.GAME_RES_BROWSE.getValue();
    }
}
