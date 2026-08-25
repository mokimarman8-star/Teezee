package com.transsion.rewardscenter.task.member;

import android.widget.TextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e extends BaseTaskCommonProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(zo.a aVar) {
        super(aVar);
        Intrinsics.h(aVar, "config");
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public String D(MemberTaskItem memberTaskItem) {
        Intrinsics.h(memberTaskItem, "item");
        Integer timesCondition = memberTaskItem.getTimesCondition();
        int intValue = timesCondition != null ? timesCondition.intValue() : 0;
        int h = RangesKt.h(hm.k.a.G(), intValue);
        return memberTaskItem.getTitle() + " (" + h + "/" + intValue + ")";
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public boolean F(MemberTaskItem memberTaskItem) {
        Integer timesCondition;
        return hm.k.a.G() >= ((memberTaskItem == null || (timesCondition = memberTaskItem.getTimesCondition()) == null) ? 0 : timesCondition.intValue());
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void G() {
        hm.k.a.u();
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void K(TextView textView, MemberTaskItem memberTaskItem) {
        String str;
        Intrinsics.h(textView, "button");
        Intrinsics.h(memberTaskItem, "item");
        String jumpUrl = memberTaskItem.getJumpUrl();
        if (jumpUrl == null || jumpUrl.length() == 0) {
            str = "oneroom://com.community.oneroom?type=/main/tab&tabIndex=0";
        } else {
            str = memberTaskItem.getJumpUrl();
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
        }
        hj.b.d(hj.b.a, k(), str, null, 4, null);
    }

    public int l() {
        return TaskType.DOWNLOAD_MOVIE.getValue();
    }
}
