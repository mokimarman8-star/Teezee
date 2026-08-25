package com.transsion.member.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.lifecycle.u;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.MemberFragment;
import com.transsion.member.MemberViewModel;
import com.transsion.member.constants.TaskType;
import com.transsion.memberapi.MemberTaskItem;
import em.l;
import em.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/transsion/member/adapter/h;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/memberapi/MemberTaskItem;", "Landroidx/lifecycle/u;", "owner", "Lcom/transsion/member/MemberViewModel;", "viewModel", "Lcom/transsion/member/MemberFragment;", "fragment", "<init>", "(Landroidx/lifecycle/u;Lcom/transsion/member/MemberViewModel;Lcom/transsion/member/MemberFragment;)V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "provider", BuildConfig.FLAVOR, "F1", "(Lcom/chad/library/adapter/base/provider/BaseItemProvider;)V", BuildConfig.FLAVOR, "list", "n1", "(Ljava/util/Collection;)V", BuildConfig.FLAVOR, "G", "Ljava/util/Set;", "supportTaskTypes", "a", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h extends BaseProviderMultiAdapter<MemberTaskItem> {
    public static final int H = 8;

    /* renamed from: G, reason: from kotlin metadata */
    private final Set<Integer> supportTaskTypes;

    public static final class a extends RecyclerView.l {
        private final int a = a0.a(24.0f);
        private final int b = a0.a(8.0f);
        private final int c = a0.a(12.0f);

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(rect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            h adapter = recyclerView.getAdapter();
            Intrinsics.f(adapter, "null cannot be cast to non-null type com.transsion.member.adapter.TaskAdapter");
            Integer taskSubType = ((MemberTaskItem) adapter.getItem(childAdapterPosition)).getTaskSubType();
            TaskType taskType = TaskType.TITLE;
            int value = taskType.getValue();
            if (taskSubType != null && taskSubType.intValue() == value) {
                rect.top = this.a;
            } else if (childAdapterPosition > 0) {
                h adapter2 = recyclerView.getAdapter();
                Intrinsics.f(adapter2, "null cannot be cast to non-null type com.transsion.member.adapter.TaskAdapter");
                Integer taskSubType2 = ((MemberTaskItem) adapter2.getItem(childAdapterPosition - 1)).getTaskSubType();
                int value2 = taskType.getValue();
                if (taskSubType2 != null && taskSubType2.intValue() == value2) {
                    rect.top = this.b;
                } else {
                    rect.top = this.c;
                }
            }
            if (childAdapterPosition == xVar.b() - 1) {
                rect.bottom = a0.a(20.0f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(u uVar, MemberViewModel memberViewModel, MemberFragment memberFragment) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        Intrinsics.h(uVar, "owner");
        Intrinsics.h(memberViewModel, "viewModel");
        Intrinsics.h(memberFragment, "fragment");
        this.supportTaskTypes = new LinkedHashSet();
        F1(new n());
        F1(new l(memberFragment, memberViewModel));
        F1(new em.c(uVar, memberViewModel));
    }

    public void F1(BaseItemProvider provider) {
        Intrinsics.h(provider, "provider");
        this.supportTaskTypes.add(Integer.valueOf(provider.l()));
        super.F1(provider);
    }

    protected int N1(List<MemberTaskItem> data, int position) {
        Intrinsics.h(data, "data");
        Integer taskSubType = data.get(position).getTaskSubType();
        if (taskSubType != null) {
            return taskSubType.intValue();
        }
        return 0;
    }

    public void n1(Collection<MemberTaskItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            list = new ArrayList<>();
        }
        for (MemberTaskItem memberTaskItem : list) {
            if (CollectionsKt.b0(this.supportTaskTypes, memberTaskItem.getTaskSubType())) {
                arrayList.add(memberTaskItem);
            } else {
                a.a.f(wf.a.a, "MemberTask", "task type " + memberTaskItem.getTaskSubType() + " not support", false, 4, (Object) null);
            }
        }
        super/*com.chad.library.adapter.base.BaseQuickAdapter*/.n1(arrayList);
    }
}
