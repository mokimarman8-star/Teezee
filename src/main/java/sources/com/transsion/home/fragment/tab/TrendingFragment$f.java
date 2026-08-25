package com.transsion.home.fragment.tab;

import androidx.recyclerview.widget.DiffUtil;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TrendingFragment$f extends DiffUtil.e {
    TrendingFragment$f() {
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(OperateItem operateItem, OperateItem operateItem2) {
        Intrinsics.h(operateItem, "oldItem");
        Intrinsics.h(operateItem2, "newItem");
        Subject feedsSubject = operateItem.getFeedsSubject();
        String valueOf = String.valueOf(feedsSubject != null ? feedsSubject.getSubjectId() : null);
        Subject feedsSubject2 = operateItem2.getFeedsSubject();
        return Intrinsics.c(valueOf, String.valueOf(feedsSubject2 != null ? feedsSubject2.getSubjectId() : null));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(OperateItem operateItem, OperateItem operateItem2) {
        Intrinsics.h(operateItem, "oldItem");
        Intrinsics.h(operateItem2, "newItem");
        return Intrinsics.c(operateItem.getType(), operateItem2.getType());
    }
}
