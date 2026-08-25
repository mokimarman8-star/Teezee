package com.transsion.rewardscenter.task.member;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.R$color;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskType;
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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/transsion/rewardscenter/task/member/d;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/rewardscenterapi/MemberTaskItem;", "Lzo/a;", "config", "<init>", "(Lzo/a;)V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "provider", BuildConfig.FLAVOR, "F1", "(Lcom/chad/library/adapter/base/provider/BaseItemProvider;)V", BuildConfig.FLAVOR, "list", "n1", "(Ljava/util/Collection;)V", BuildConfig.FLAVOR, "G", "Ljava/util/Set;", "supportTaskTypes", "a", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseProviderMultiAdapter<MemberTaskItem> {
    public static final int H = 8;

    /* renamed from: G, reason: from kotlin metadata */
    private final Set<Integer> supportTaskTypes;

    public static final class a extends RecyclerView.l {
        private final int a;
        private final Paint b;
        private final int c;
        private final int d;
        private final int e;

        public a() {
            this(0, 1, null);
        }

        public a(int i) {
            this.a = i;
            this.b = new Paint();
            this.c = a0.a(24.0f);
            this.d = a0.a(8.0f);
        }

        public /* synthetic */ a(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 1 : i);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(rect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            d adapter = recyclerView.getAdapter();
            Intrinsics.f(adapter, "null cannot be cast to non-null type com.transsion.rewardscenter.task.member.MemberTaskAdapter");
            Integer taskSubType = ((MemberTaskItem) adapter.getItem(childAdapterPosition)).getTaskSubType();
            TaskType taskType = TaskType.TITLE;
            int value = taskType.getValue();
            if (taskSubType != null && taskSubType.intValue() == value) {
                rect.top = this.c;
            } else if (childAdapterPosition > 0) {
                d adapter2 = recyclerView.getAdapter();
                Intrinsics.f(adapter2, "null cannot be cast to non-null type com.transsion.rewardscenter.task.member.MemberTaskAdapter");
                Integer taskSubType2 = ((MemberTaskItem) adapter2.getItem(childAdapterPosition - 1)).getTaskSubType();
                int value2 = taskType.getValue();
                if (taskSubType2 != null && taskSubType2.intValue() == value2) {
                    rect.top = this.d;
                } else {
                    rect.top = this.e;
                }
            }
            if (childAdapterPosition == xVar.b() - 1) {
                rect.bottom = a0.a(12.0f);
            }
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(canvas, "c");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            this.b.setColor(androidx.core.content.b.getColor(recyclerView.getContext(), R$color.prize_list_divider));
            int childCount = recyclerView.getChildCount() - 1;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                RecyclerView.n layoutParams = childAt.getLayoutParams();
                Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                int paddingLeft = recyclerView.getPaddingLeft();
                int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                canvas.drawRect(paddingLeft, childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, width, this.a + r1, this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(zo.a aVar) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        Intrinsics.h(aVar, "config");
        this.supportTaskTypes = new LinkedHashSet();
        F1(new k(aVar));
        F1(new h(aVar));
        F1(new j(aVar));
        F1(new e(aVar));
        F1(new i(aVar));
        F1(new f(aVar));
        F1(new g(aVar));
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
