package com.transsion.rewardscenter.task.member;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.R$mipmap;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.ui.RewardsCenterFragment;
import com.transsion.rewardscenterapi.MemberTaskItem;
import java.util.HashMap;
import java.util.Locale;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BaseTaskCommonProvider extends BaseItemProvider {
    private final zo.a e;
    private final int f;
    private boolean g;

    public BaseTaskCommonProvider(zo.a aVar) {
        Intrinsics.h(aVar, "config");
        this.e = aVar;
        this.f = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(BaseTaskCommonProvider baseTaskCommonProvider, MemberTaskItem memberTaskItem, View view) {
        if (com.transsion.baseui.util.c.a.a(R$id.member_item_task_button, 2000L)) {
            return;
        }
        if (baseTaskCommonProvider.F(memberTaskItem)) {
            baseTaskCommonProvider.J(memberTaskItem);
        } else {
            Intrinsics.f(view, "null cannot be cast to non-null type android.widget.TextView");
            baseTaskCommonProvider.K((TextView) view, memberTaskItem);
        }
        baseTaskCommonProvider.I(memberTaskItem);
    }

    private final int C() {
        Locale locale = Locale.getDefault();
        Intrinsics.g(locale, "getDefault(...)");
        return TextUtils.getLayoutDirectionFromLocale(locale) == 1 ? 8388613 : 8388611;
    }

    private final void H(MemberTaskItem memberTaskItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_browse");
        String taskId = memberTaskItem.getTaskId();
        if (taskId == null) {
            taskId = BuildConfig.FLAVOR;
        }
        hashMap.put("taskId", taskId);
        hashMap.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        hashMap.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        hashMap.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        hashMap.put("showClaim", String.valueOf(this.g));
        com.transsion.baselib.helper.a.a.a("rewards_center", hashMap);
    }

    private final void I(MemberTaskItem memberTaskItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_click");
        String taskId = memberTaskItem.getTaskId();
        if (taskId == null) {
            taskId = BuildConfig.FLAVOR;
        }
        hashMap.put("taskId", taskId);
        hashMap.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        hashMap.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        hashMap.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        hashMap.put("showClaim", String.valueOf(this.g));
        com.transsion.baselib.helper.a.a.b("rewards_center", hashMap);
    }

    private final void J(MemberTaskItem memberTaskItem) {
        RewardsCenterFragment rewardsCenterFragment = (RewardsCenterFragment) this.e.a().get();
        if (rewardsCenterFragment != null) {
            rewardsCenterFragment.showLoading();
        }
        kotlinx.coroutines.i.d(this.e.b(), (CoroutineContext) null, (CoroutineStart) null, new BaseTaskCommonProvider$startClaim$1(memberTaskItem, this, null), 3, (Object) null);
    }

    protected final zo.a B() {
        return this.e;
    }

    public String D(MemberTaskItem memberTaskItem) {
        Intrinsics.h(memberTaskItem, "item");
        String title = memberTaskItem.getTitle();
        return title == null ? BuildConfig.FLAVOR : title;
    }

    public void E(TextView textView, MemberTaskItem memberTaskItem) {
        Intrinsics.h(textView, "button");
        Intrinsics.h(memberTaskItem, "item");
        this.g = F(memberTaskItem);
        Integer status = memberTaskItem.getStatus();
        if (status != null && status.intValue() == 3) {
            textView.setText(k().getString(R$string.claimed));
            textView.setEnabled(false);
            textView.setAlpha(0.5f);
        } else if (this.g) {
            textView.setText(textView.getContext().getString(R$string.claim));
            textView.setEnabled(true);
            textView.setAlpha(1.0f);
        } else {
            textView.setText(memberTaskItem.getButtonName());
            textView.setEnabled(true);
            textView.setAlpha(1.0f);
        }
    }

    public boolean F(MemberTaskItem memberTaskItem) {
        return false;
    }

    public void G() {
    }

    public abstract void K(TextView textView, MemberTaskItem memberTaskItem);

    public int m() {
        return R$layout.item_task_common;
    }

    @Override // 
    /* renamed from: z */
    public void b(BaseViewHolder baseViewHolder, final MemberTaskItem memberTaskItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(memberTaskItem, "item");
        ImageView imageView = (ImageView) baseViewHolder.getView(R$id.icon);
        f.a aVar = ni.f.a;
        Context context = imageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        aVar.m(context).g(memberTaskItem.getIcon()).i(R$mipmap.ic_earn_points).d(imageView);
        int i = R$id.member_item_task_points_icon;
        Integer rewardType = memberTaskItem.getRewardType();
        baseViewHolder.setImageResource(i, (rewardType != null && rewardType.intValue() == this.f) ? R$mipmap.ic_member_small : R$mipmap.ic_points);
        baseViewHolder.setText(R$id.member_item_task_points_text, "+" + memberTaskItem.getRewardAmount() + " points");
        TextView textView = (TextView) baseViewHolder.getView(R$id.member_item_task_title);
        textView.setText(D(memberTaskItem));
        textView.setGravity(C());
        TextView textView2 = (TextView) baseViewHolder.getView(R$id.member_item_task_button);
        E(textView2, memberTaskItem);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.task.member.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseTaskCommonProvider.A(BaseTaskCommonProvider.this, memberTaskItem, view);
            }
        });
        H(memberTaskItem);
    }
}
