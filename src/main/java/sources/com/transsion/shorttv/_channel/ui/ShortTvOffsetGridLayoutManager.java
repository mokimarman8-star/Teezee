package com.transsion.shorttv._channel.ui;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.gslb.BuildConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/transsion/shorttv/_channel/ui/ShortTvOffsetGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "spanCount", "orientation", BuildConfig.FLAVOR, "reverseLayout", "<init>", "(Landroid/content/Context;IIZ)V", "Landroidx/recyclerview/widget/RecyclerView$x;", "state", BuildConfig.FLAVOR, "onLayoutCompleted", "(Landroidx/recyclerview/widget/RecyclerView$x;)V", "computeVerticalScrollOffset", "(Landroidx/recyclerview/widget/RecyclerView$x;)I", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "j", "Ljava/util/HashMap;", "heightMap", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvOffsetGridLayoutManager extends GridLayoutManager {

    /* renamed from: j, reason: from kotlin metadata */
    private final HashMap heightMap;

    public ShortTvOffsetGridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i, i2, z);
        this.heightMap = new HashMap();
    }

    public int computeVerticalScrollOffset(RecyclerView.x state) {
        Intrinsics.h(state, "state");
        if (getChildCount() == 0) {
            return 0;
        }
        try {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            View findViewByPosition = findViewByPosition(findFirstVisibleItemPosition);
            int i = 0;
            for (int i2 = 0; i2 < findFirstVisibleItemPosition; i2++) {
                Integer num = (Integer) this.heightMap.get(Integer.valueOf(i2));
                i += num != null ? num.intValue() : 0;
            }
            return i - (findViewByPosition != null ? findViewByPosition.getTop() : 0);
        } catch (Exception e) {
            e.printStackTrace();
            return super.computeVerticalScrollOffset(state);
        }
    }

    public void onLayoutCompleted(RecyclerView.x state) {
        super.onLayoutCompleted(state);
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition < 0 || findLastVisibleItemPosition < findFirstVisibleItemPosition) {
            return;
        }
        while (findFirstVisibleItemPosition < findLastVisibleItemPosition) {
            View childAt = getChildAt(findFirstVisibleItemPosition);
            if (childAt != null) {
                GridLayoutManager.b layoutParams = childAt.getLayoutParams();
                Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
                if (layoutParams.a() == 0) {
                    this.heightMap.put(Integer.valueOf(findFirstVisibleItemPosition), Integer.valueOf(childAt.getHeight()));
                } else {
                    this.heightMap.put(Integer.valueOf(findFirstVisibleItemPosition), 0);
                }
            }
            findFirstVisibleItemPosition++;
        }
    }
}
