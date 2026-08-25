package com.transsion.rewardscenter.task.member;

import android.widget.TextView;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.w;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f extends BaseTaskCommonProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(zo.a aVar) {
        super(aVar);
        Intrinsics.h(aVar, "config");
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public boolean F(MemberTaskItem memberTaskItem) {
        Integer status;
        return (memberTaskItem == null || (status = memberTaskItem.getStatus()) == null || status.intValue() != 3) && hm.k.a.C() > 0;
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void G() {
        hm.k.a.v();
        w.a.b().putLong("kv_game_download_app_claim_item", System.currentTimeMillis());
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void K(TextView textView, MemberTaskItem memberTaskItem) {
        String str;
        Intrinsics.h(textView, "button");
        Intrinsics.h(memberTaskItem, "item");
        if (System.currentTimeMillis() - w.a.b().getLong("kv_game_download_app_claim_item", 0L) <= (memberTaskItem.getTimeInterval() != null ? r7.intValue() : 0) * 1000) {
            fh.b.a.e(k().getString(R.string.try_again));
            return;
        }
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
        return TaskType.GAME_RES_APP_DOWNLOAD.getValue();
    }
}
