package com.transsion.rewardscenter.redeem;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.R$color;
import com.transsion.rewardscenter.redeem.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/transsion/rewardscenter/redeem/d;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/rewardscenter/redeem/e;", "Lzo/a;", "config", "<init>", "(Lzo/a;)V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "a", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseProviderMultiAdapter<e> {
    public static final int G = 8;

    public static final class a extends RecyclerView.l {
        private final int a;
        private final int b;
        private final Paint c;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a() {
            this(r2, r2, 3, null);
            int i = 0;
        }

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
            this.c = new Paint();
        }

        public /* synthetic */ a(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 1 : i2);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(rect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            rect.set(0, 0, 0, recyclerView.getChildAdapterPosition(view) < xVar.b() + (-1) ? this.a + this.b : this.a);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(canvas, "c");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            this.c.setColor(androidx.core.content.b.getColor(recyclerView.getContext(), R$color.prize_list_divider));
            int childCount = recyclerView.getChildCount() - 1;
            for (int i = 1; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                RecyclerView.n layoutParams = childAt.getLayoutParams();
                Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                int paddingLeft = recyclerView.getPaddingLeft();
                int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                canvas.drawRect(paddingLeft, childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, width, this.b + r1, this.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(zo.a aVar) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        Intrinsics.h(aVar, "config");
        F1(new i());
        F1(new SkuItemProvider(aVar));
        F1(new LotteryItemProvider(aVar));
    }

    protected int N1(List<? extends e> data, int position) {
        Intrinsics.h(data, "data");
        e eVar = data.get(position);
        if (eVar instanceof e.c) {
            return RedeemType.TITLE.getValue();
        }
        if (eVar instanceof e.b) {
            return RedeemType.SKU.getValue();
        }
        if (eVar instanceof e.a) {
            return RedeemType.LOTTERY.getValue();
        }
        throw new NoWhenBranchMatchedException();
    }
}
