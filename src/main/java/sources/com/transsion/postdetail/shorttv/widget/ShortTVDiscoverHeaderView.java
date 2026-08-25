package com.transsion.postdetail.shorttv.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.TnTextView;
import com.transsion.flow.bean.PlayListDeepLink;
import com.transsion.flow.bean.PlayListItemBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.shorttv.adapter.ShortTVHeaderViewAdapter;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;
import wn.e0;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\fB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u00104¨\u00066"}, d2 = {"Lcom/transsion/postdetail/shorttv/widget/ShortTVDiscoverHeaderView;", "Landroid/widget/LinearLayout;", "Lcom/transsion/moviedetailapi/bean/PlayListItemBean;", "playListBean", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Lcom/transsion/moviedetailapi/bean/PlayListItemBean;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Lcom/transsion/moviedetailapi/bean/PlayListItemBean;Landroid/content/Context;)V", "(Lcom/transsion/moviedetailapi/bean/PlayListItemBean;Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "c", "()V", "f", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "g", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", BuildConfig.FLAVOR, "getItemOptType", "()Ljava/lang/String;", BuildConfig.FLAVOR, "list", "updateList", "(Ljava/util/List;)V", "clearExposureCache", "a", "Lcom/transsion/moviedetailapi/bean/PlayListItemBean;", "getPlayListBean", "()Lcom/transsion/moviedetailapi/bean/PlayListItemBean;", BuildConfig.FLAVOR, "b", "Z", "isRTL", "I", "dp8", "Lwn/e0;", "d", "Lwn/e0;", "viewBinding", "Lcom/transsion/postdetail/shorttv/adapter/ShortTVHeaderViewAdapter;", "e", "Lcom/transsion/postdetail/shorttv/adapter/ShortTVHeaderViewAdapter;", "headerAdapter", "Lbj/b;", "Lbj/b;", "exposureHelper", "Lcom/transsion/postdetail/shorttv/j;", "Lcom/transsion/postdetail/shorttv/j;", "recReport", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTVDiscoverHeaderView extends LinearLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final PlayListItemBean playListBean;

    /* renamed from: b, reason: from kotlin metadata */
    private final boolean isRTL;

    /* renamed from: c, reason: from kotlin metadata */
    private final int dp8;

    /* renamed from: d, reason: from kotlin metadata */
    private final e0 viewBinding;

    /* renamed from: e, reason: from kotlin metadata */
    private ShortTVHeaderViewAdapter headerAdapter;

    /* renamed from: f, reason: from kotlin metadata */
    private bj.b exposureHelper;

    /* renamed from: g, reason: from kotlin metadata */
    private final com.transsion.postdetail.shorttv.j recReport;

    public static final class a implements bj.a {
        a() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            List data;
            List data2;
            ShortTVHeaderViewAdapter shortTVHeaderViewAdapter = ShortTVDiscoverHeaderView.this.headerAdapter;
            if (((shortTVHeaderViewAdapter == null || (data2 = shortTVHeaderViewAdapter.getData()) == null) ? 0 : data2.size()) <= i) {
                return;
            }
            ShortTVHeaderViewAdapter shortTVHeaderViewAdapter2 = ShortTVDiscoverHeaderView.this.headerAdapter;
            Subject subject = (shortTVHeaderViewAdapter2 == null || (data = shortTVHeaderViewAdapter2.getData()) == null) ? null : (Subject) data.get(i);
            if (subject != null) {
                ShortTVDiscoverHeaderView.this.recReport.a("minitv_explore", subject, i, j, ShortTVDiscoverHeaderView.this.getItemOptType());
            }
        }
    }

    public static final class b extends RecyclerView.l {
        b() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(rect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            super.getItemOffsets(rect, view, recyclerView, xVar);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (recyclerView.getAdapter() != null) {
                if (childAdapterPosition == 0) {
                    if (ShortTVDiscoverHeaderView.this.isRTL) {
                        rect.right = ShortTVDiscoverHeaderView.this.dp8 * 2;
                        return;
                    } else {
                        rect.left = ShortTVDiscoverHeaderView.this.dp8 * 2;
                        return;
                    }
                }
                if (childAdapterPosition == r4.getItemCount() - 1) {
                    rect.right = ShortTVDiscoverHeaderView.this.dp8;
                    rect.left = ShortTVDiscoverHeaderView.this.dp8;
                } else if (ShortTVDiscoverHeaderView.this.isRTL) {
                    rect.right = ShortTVDiscoverHeaderView.this.dp8;
                } else {
                    rect.left = ShortTVDiscoverHeaderView.this.dp8;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVDiscoverHeaderView(PlayListItemBean playListItemBean, Context context) {
        this(playListItemBean, context, null);
        Intrinsics.h(playListItemBean, "playListBean");
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVDiscoverHeaderView(PlayListItemBean playListItemBean, Context context, AttributeSet attributeSet) {
        this(playListItemBean, context, attributeSet, 0);
        Intrinsics.h(playListItemBean, "playListBean");
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVDiscoverHeaderView(PlayListItemBean playListItemBean, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(playListItemBean, "playListBean");
        Intrinsics.h(context, "context");
        this.playListBean = playListItemBean;
        this.isRTL = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        this.dp8 = a0.a(8.0f);
        this.recReport = new com.transsion.postdetail.shorttv.j();
        View.inflate(context, R$layout.layout_short_tv_discover_header, this);
        e0 a2 = e0.a(this);
        Intrinsics.g(a2, "bind(...)");
        this.viewBinding = a2;
        setOrientation(1);
        c();
        f();
    }

    private final void c() {
        this.exposureHelper = new bj.b(0.6f, new a(), false, 4, null);
        this.viewBinding.e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.shorttv.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTVDiscoverHeaderView.d(ShortTVDiscoverHeaderView.this, view);
            }
        });
        ShortTVHeaderViewAdapter shortTVHeaderViewAdapter = new ShortTVHeaderViewAdapter(this.exposureHelper);
        shortTVHeaderViewAdapter.w1(new r6.d() { // from class: com.transsion.postdetail.shorttv.widget.f
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ShortTVDiscoverHeaderView.e(ShortTVDiscoverHeaderView.this, baseQuickAdapter, view, i);
            }
        });
        this.headerAdapter = shortTVHeaderViewAdapter;
        RecyclerView recyclerView = this.viewBinding.b;
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.addItemDecoration(new b());
        recyclerView.setAdapter(this.headerAdapter);
        bj.b bVar = this.exposureHelper;
        Intrinsics.e(bVar);
        recyclerView.addOnScrollListener(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ShortTVDiscoverHeaderView shortTVDiscoverHeaderView, View view) {
        a.a aVar = wf.a.a;
        a.a.g(aVar, "Click view all", false, 2, (Object) null);
        PlayListDeepLink a2 = PlayListDeepLink.INSTANCE.a(shortTVDiscoverHeaderView.playListBean.getDeepLink());
        if (a2 != null) {
            Navigator.x(TheRouter.c("/home/playlist").K("label", a2.getLabel()).K("category", a2.getCategory()).K("recType", a2.getRecType()).K("topIds", (String) null), shortTVDiscoverHeaderView.getContext(), (mf.c) null, 2, (Object) null);
            return;
        }
        a.a.m(aVar, "Invalid deeplink for " + shortTVDiscoverHeaderView.playListBean.getTitle() + ", " + shortTVDiscoverHeaderView.playListBean.getDeepLink(), false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ShortTVDiscoverHeaderView shortTVDiscoverHeaderView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            shortTVDiscoverHeaderView.recReport.b("minitv_explore", subject, i, shortTVDiscoverHeaderView.getItemOptType());
            shortTVDiscoverHeaderView.g(subject);
        }
    }

    private final void f() {
        if (this.playListBean.isLastOne()) {
            TnTextView tnTextView = this.viewBinding.d;
            Intrinsics.g(tnTextView, "tvTitleTrending");
            tnTextView.setVisibility(0);
        }
        this.viewBinding.c.setText(this.playListBean.getTitle());
        updateList(this.playListBean.getSubjects());
    }

    private final void g(Subject subject) {
        FragmentActivity context = getContext();
        if (context != null) {
            String itemOptType = getItemOptType();
            if (Intrinsics.c(itemOptType, "new_release") || Intrinsics.c(itemOptType, "playlist")) {
                DownloadManagerApi.e0(DownloadManagerApi.j.a(), context, "minitv_explore", BuildConfig.FLAVOR, subject.getOps(), "download_subject", false, subject, (String) null, (Boolean) null, 384, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getItemOptType() {
        return Intrinsics.c(this.playListBean.getId(), "10000000000") ? "new_release" : "playlist";
    }

    public final void clearExposureCache() {
        bj.b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final PlayListItemBean getPlayListBean() {
        return this.playListBean;
    }

    public final void updateList(List<? extends Subject> list) {
        ShortTVHeaderViewAdapter shortTVHeaderViewAdapter;
        List<? extends Subject> list2 = list;
        if (list2 == null || list2.isEmpty() || (shortTVHeaderViewAdapter = this.headerAdapter) == null) {
            return;
        }
        shortTVHeaderViewAdapter.n1(list2);
    }
}
