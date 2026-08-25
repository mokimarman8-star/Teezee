package vm;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.video.NineGridVideoView;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends RecyclerView.r {
    public static final a i = new a(null);
    private BaseQuickAdapter a;
    private wm.a b;
    private d c;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private int g = -1;
    private int h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void d(RecyclerView recyclerView) {
        List data;
        int position;
        d dVar;
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        if ((layoutManager instanceof LinearLayoutManager) && g()) {
            if (this.b == null && (dVar = this.c) != null) {
                dVar.a();
            }
            wm.a aVar = this.b;
            int b = aVar != null ? aVar.b() : -1;
            wm.a aVar2 = this.b;
            int f = aVar2 != null ? aVar2.f() : -1;
            wm.a aVar3 = this.b;
            if (aVar3 != null && aVar3.n() && h((LinearLayoutManager) layoutManager, b, f)) {
                return;
            }
            wm.a aVar4 = this.b;
            if (aVar4 != null) {
                aVar4.r();
            }
            BaseQuickAdapter baseQuickAdapter = this.a;
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int f2 = f(baseQuickAdapter != null ? baseQuickAdapter.getData() : null, linearLayoutManager);
            if (f2 < 0) {
                return;
            }
            a.a.f(wf.a.a, "ItemChangeListener", "curPos=" + b + " next=" + f2 + ", dy=" + this.h + ", firstVisible=" + this.f + " lastVisible=" + this.g, false, 4, (Object) null);
            BaseQuickAdapter baseQuickAdapter2 = this.a;
            if (baseQuickAdapter2 == null || (data = baseQuickAdapter2.getData()) == null) {
                return;
            }
            int childCount = linearLayoutManager.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = linearLayoutManager.getChildAt(i2);
                if (childAt != null && (position = linearLayoutManager.getPosition(childAt)) == f2 && position < data.size() && b != f2) {
                    PostSubjectItem postSubjectItem = (PostSubjectItem) data.get(f2);
                    wm.a aVar5 = this.b;
                    if (aVar5 != null) {
                        aVar5.s(postSubjectItem, childAt, f2);
                    }
                    wm.a aVar6 = this.b;
                    if (aVar6 != null && aVar6.e(postSubjectItem.getMedia()) == 1) {
                        i(f2);
                    }
                }
            }
        }
    }

    private final int f(List list, LinearLayoutManager linearLayoutManager) {
        NineGridVideoView nineGridVideoView;
        int position;
        int i2 = -1;
        if (list == null) {
            return -1;
        }
        int childCount = linearLayoutManager.getChildCount();
        float f = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = linearLayoutManager.getChildAt(i3);
            if (childAt != null && (nineGridVideoView = (NineGridVideoView) childAt.findViewById(R$id.nine_grid)) != null && (position = linearLayoutManager.getPosition(childAt)) >= 0 && position < list.size()) {
                PostSubjectItem postSubjectItem = (PostSubjectItem) list.get(position);
                if (wm.b.a(postSubjectItem.getMedia())) {
                    wm.a aVar = this.b;
                    float h = aVar != null ? aVar.h(nineGridVideoView, postSubjectItem.getMedia()) : 0.0f;
                    if (f < h) {
                        if (h > 0.5f) {
                            i2 = position;
                        }
                        f = h;
                    }
                }
            }
        }
        return i2;
    }

    private final boolean g() {
        List data;
        BaseQuickAdapter baseQuickAdapter = this.a;
        if (baseQuickAdapter == null || (data = baseQuickAdapter.getData()) == null) {
            return false;
        }
        Iterator it = data.iterator();
        while (it.hasNext()) {
            if (wm.b.a(((PostSubjectItem) it.next()).getMedia())) {
                return true;
            }
        }
        return false;
    }

    private final boolean h(LinearLayoutManager linearLayoutManager, int i2, int i3) {
        int childCount = linearLayoutManager.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = linearLayoutManager.getChildAt(i4);
            if (childAt != null) {
                NineGridVideoView nineGridVideoView = (NineGridVideoView) childAt.findViewById(R$id.nine_grid);
                int position = linearLayoutManager.getPosition(childAt);
                if (position == i2) {
                    Boolean valueOf = nineGridVideoView != null ? Boolean.valueOf(nineGridVideoView.currentGifVisible(i3)) : null;
                    if (Intrinsics.c(valueOf, Boolean.TRUE)) {
                        a.a.f(wf.a.a, "ItemChangeListener", "childPos=" + position + " currentGifVisible=" + valueOf, false, 4, (Object) null);
                        return true;
                    }
                    boolean hasGifVisible = nineGridVideoView != null ? nineGridVideoView.hasGifVisible() : false;
                    a.a.f(wf.a.a, "ItemChangeListener", "childPos=" + position + " gifVisible=" + hasGifVisible, false, 4, (Object) null);
                    wm.a aVar = this.b;
                    if (aVar != null) {
                        aVar.q();
                    }
                    return hasGifVisible;
                }
            }
        }
        return false;
    }

    private final void i(int i2) {
        List data;
        List data2;
        BaseQuickAdapter baseQuickAdapter = this.a;
        int size = (baseQuickAdapter == null || (data2 = baseQuickAdapter.getData()) == null) ? 0 : data2.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (i3 > i2) {
                BaseQuickAdapter baseQuickAdapter2 = this.a;
                PostSubjectItem postSubjectItem = (baseQuickAdapter2 == null || (data = baseQuickAdapter2.getData()) == null) ? null : (PostSubjectItem) data.get(i3);
                if (wm.b.a(postSubjectItem != null ? postSubjectItem.getMedia() : null)) {
                    wm.a aVar = this.b;
                    if (aVar != null) {
                        aVar.v(postSubjectItem != null ? postSubjectItem.getMedia() : null);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void e() {
        this.a = null;
        this.b = null;
        this.e = -1;
        this.d = -1;
        this.f = -1;
        this.g = -1;
        this.h = 0;
        this.c = null;
    }

    public final void j(BaseQuickAdapter baseQuickAdapter) {
        this.a = baseQuickAdapter;
    }

    public final void k(wm.a aVar) {
        this.b = aVar;
    }

    public final void l(d dVar) {
        this.c = dVar;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        Intrinsics.h(recyclerView, "recyclerView");
        if (recyclerView.getScrollState() == 0) {
            d(recyclerView);
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        Intrinsics.h(recyclerView, "recyclerView");
        LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            throw new RuntimeException("Unsupported layoutManager.");
        }
        LinearLayoutManager linearLayoutManager = layoutManager;
        this.d = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        this.e = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        this.f = linearLayoutManager.findFirstVisibleItemPosition();
        this.g = linearLayoutManager.findLastVisibleItemPosition();
        this.h = i3;
        if (recyclerView.getScrollState() == 0) {
            d(recyclerView);
        }
    }
}
