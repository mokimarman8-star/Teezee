package com.transsion.home.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/transsion/home/view/OpRankingView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "Lcom/transsion/moviedetailapi/bean/Subject;", "item", BuildConfig.FLAVOR, "e", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "setDatas", "(Lcom/transsion/home/bean/OperateItem;)V", "Landroidx/recyclerview/widget/GridLayoutManager;", "gridLayoutManager", "Ljava/util/SortedSet;", "calcExposureLines", "(Landroidx/recyclerview/widget/GridLayoutManager;)Ljava/util/SortedSet;", "Lcom/transsion/home/view/RankingAdapter;", "a", "Lcom/transsion/home/view/RankingAdapter;", "mAdapter", "b", "I", "mRow", "Ljava/util/TreeSet;", "c", "Ljava/util/TreeSet;", "set", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class OpRankingView extends LinearLayoutCompat {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private RankingAdapter mAdapter;

    /* renamed from: b, reason: from kotlin metadata */
    private int mRow;

    /* renamed from: c, reason: from kotlin metadata */
    private final TreeSet set;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OpRankingView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OpRankingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OpRankingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        LayoutInflater.from(context).inflate(R.layout.post_list_item_ranking_view, (ViewGroup) this, true);
        setOrientation(1);
        this.set = SetsKt.e(new Integer[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e(Subject item) {
        Integer subjectType = item.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        if (subjectType == null || subjectType.intValue() != value) {
            Navigator c = TheRouter.c("/movie/detail");
            Integer subjectType2 = item.getSubjectType();
            Navigator.x(c.F("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).K("id", item.getSubjectId()).K("module_name", "opt_ranking").K("ops", item.getOps()), getContext(), (mf.c) null, 2, (Object) null);
        } else {
            DownloadManagerApi a = DownloadManagerApi.j.a();
            FragmentActivity context = getContext();
            Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            DownloadManagerApi.e0(a, context, "Trending", BuildConfig.FLAVOR, item.getOps(), "download_subject", false, item, (String) null, (Boolean) null, 384, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(List list, OpRankingView opRankingView, OperateItem operateItem, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        Subject subject = (Subject) list.get(i);
        opRankingView.e((Subject) list.get(i));
        zk.c.a.c("Trending", "opt", PostItemType.OP_RANKING.getValue(), (r35 & 8) != 0 ? null : subject.getSubjectId(), (r35 & 16) != 0 ? null : null, (r35 & 32) != 0 ? null : subject.getOps(), (r35 & 64) != 0 ? null : subject.getHasResource(), (r35 & 128) != 0 ? null : null, (r35 & 256) != 0 ? null : null, (r35 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? null : Integer.valueOf(i), (r35 & 1024) != 0 ? null : null, (r35 & 2048) != 0 ? Boolean.FALSE : Boolean.valueOf(subject.getBuiltIn()), (r35 & 4096) != 0 ? null : subject.getTag(), (r35 & 8192) != 0 ? null : operateItem.getTitle(), (r35 & 16384) != 0 ? null : operateItem.getOpId());
    }

    public final SortedSet<Integer> calcExposureLines(GridLayoutManager gridLayoutManager) {
        List data;
        Intrinsics.h(gridLayoutManager, "gridLayoutManager");
        int i = 0;
        if (gridLayoutManager.getChildCount() == 0) {
            RankingAdapter rankingAdapter = this.mAdapter;
            if (rankingAdapter != null && (data = rankingAdapter.getData()) != null) {
                for (Object obj : data) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.u();
                    }
                    this.set.add(Integer.valueOf(i));
                    i = i2;
                }
            }
        } else {
            int i3 = this.mRow;
            for (int i4 = 0; i4 < i3; i4++) {
                View findViewByPosition = gridLayoutManager.findViewByPosition(i4 * 3);
                if (findViewByPosition != null ? findViewByPosition.getGlobalVisibleRect(new Rect()) : false) {
                    this.set.add(Integer.valueOf(i4));
                }
            }
        }
        return this.set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDatas(final OperateItem operateItem) {
        List<Subject> rankings;
        if (operateItem == null) {
            return;
        }
        AppCompatTextView findViewById = findViewById(R.id.tv_title);
        if (findViewById != null) {
            findViewById.setText(operateItem.getTitle());
        }
        RecyclerView recyclerView = (HRecyclerView) findViewById(R.id.recycler_view);
        if (recyclerView == null || (rankings = operateItem.getRankings()) == null) {
            return;
        }
        final Context context = recyclerView.getContext();
        recyclerView.setLayoutManager(new NpaGridLayoutManager(context) { // from class: com.transsion.home.view.OpRankingView$setDatas$2$1$1
            public boolean canScrollHorizontally() {
                return false;
            }

            public boolean canScrollVertically() {
                return false;
            }
        });
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new tf.b(a0.a(4.0f), a0.a(4.0f), a0.a(16.0f), a0.a(16.0f)));
        }
        int size = rankings.size() / 3;
        this.mRow = size;
        final List<Subject> subList = rankings.subList(0, size * 3);
        RankingAdapter rankingAdapter = new RankingAdapter(CollectionsKt.U0(subList));
        rankingAdapter.w1(new r6.d() { // from class: com.transsion.home.view.e
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OpRankingView.f(subList, this, operateItem, baseQuickAdapter, view, i);
            }
        });
        recyclerView.setAdapter(rankingAdapter);
        this.mAdapter = rankingAdapter;
    }
}
