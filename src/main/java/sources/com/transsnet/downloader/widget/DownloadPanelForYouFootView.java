package com.transsnet.downloader.widget;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.StateView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.PlayUrl;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.R;
import com.transsnet.downloader.api.DownloadPageType;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okhttp3.HttpUrl;
import yg.m;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u000fJ\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u000fJ\u001b\u0010\u001c\u001a\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010 \u001a\u00020\r2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\r¢\u0006\u0004\b&\u0010\u000fJ\u000f\u0010'\u001a\u00020\rH\u0014¢\u0006\u0004\b'\u0010\u000fJ\u000f\u0010(\u001a\u00020\rH\u0014¢\u0006\u0004\b(\u0010\u000fJ\r\u0010)\u001a\u00020\r¢\u0006\u0004\b)\u0010\u000fJ\u001f\u0010.\u001a\u00020\r2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\rH\u0016¢\u0006\u0004\b0\u0010\u000fR\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001b\u0010:\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lcom/transsnet/downloader/widget/DownloadPanelForYouFootView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lyg/m;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", HttpUrl.FRAGMENT_ENCODE_SET, "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", HttpUrl.FRAGMENT_ENCODE_SET, "u", "()V", "Lcom/transsion/moviedetailapi/bean/Subject;", WebConstants.FIELD_ITEM, "s", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "w", "p", "Landroid/view/View;", "getForYouNoNetView", "()Landroid/view/View;", "configChange", HttpUrl.FRAGMENT_ENCODE_SET, "data", "setData", "(Ljava/util/List;)V", "Lkotlin/Function0;", "callback", "setRefreshClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "Landroidx/recyclerview/widget/RecyclerView;", "parentRecyclerView", "initBrowseReport", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onPageResume", "onAttachedToWindow", "onDetachedFromWindow", "showNoNetView", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "onDisconnected", "Lbx/u0;", "a", "Lbx/u0;", "viewBinding", "Lex/a;", "b", "Lkotlin/Lazy;", "getDownloadReport", "()Lex/a;", "downloadReport", "Lcom/transsnet/downloader/adapter/w0;", "c", "Lcom/transsnet/downloader/adapter/w0;", "movieRecAdapter", "d", "Lkotlin/jvm/functions/Function0;", "refreshCallback", "Lij/e;", "e", "Lij/e;", "exposureTracker", "f", "Landroid/view/View;", "noNetView", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadPanelForYouFootView extends ConstraintLayout implements yg.m {

    /* renamed from: a, reason: from kotlin metadata */
    private final bx.u0 viewBinding;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy downloadReport;

    /* renamed from: c, reason: from kotlin metadata */
    private com.transsnet.downloader.adapter.w0 movieRecAdapter;

    /* renamed from: d, reason: from kotlin metadata */
    private Function0 refreshCallback;

    /* renamed from: e, reason: from kotlin metadata */
    private ij.e exposureTracker;

    /* renamed from: f, reason: from kotlin metadata */
    private View noNetView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadPanelForYouFootView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadPanelForYouFootView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadPanelForYouFootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.downloadReport = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.widget.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ex.a q;
                q = DownloadPanelForYouFootView.q();
                return q;
            }
        });
        View.inflate(getContext(), R.layout.layout_download_for_you_footview, this);
        bx.u0 a = bx.u0.a(this);
        Intrinsics.g(a, "bind(...)");
        this.viewBinding = a;
        dl.b context2 = getContext();
        setPadding(0, 0, 0, lj.a.b(((context2 instanceof dl.b) && context2.g()) ? 88 : 80));
        u();
        a.g.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadPanelForYouFootView.o(DownloadPanelForYouFootView.this, view);
            }
        });
    }

    private final ex.a getDownloadReport() {
        return (ex.a) this.downloadReport.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View getForYouNoNetView() {
        if (this.noNetView == null) {
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            StateView stateView = new StateView(context);
            stateView.showData(1, 6, false, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET);
            stateView.retry(new Function0() { // from class: com.transsnet.downloader.widget.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit r;
                    r = DownloadPanelForYouFootView.r(DownloadPanelForYouFootView.this);
                    return r;
                }
            });
            this.noNetView = stateView;
        }
        View view = this.noNetView;
        Intrinsics.e(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(DownloadPanelForYouFootView downloadPanelForYouFootView, View view) {
        downloadPanelForYouFootView.w();
        Function0 function0 = downloadPanelForYouFootView.refreshCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void p() {
        ViewPropertyAnimator animate = this.viewBinding.c.animate();
        if (animate != null) {
            animate.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ex.a q() {
        return new ex.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(DownloadPanelForYouFootView downloadPanelForYouFootView) {
        Function0 function0 = downloadPanelForYouFootView.refreshCallback;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(Subject item) {
        String playUrl;
        String playUrl2;
        Integer subjectType = item.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        if (subjectType != null && subjectType.intValue() == value) {
            DownloadManagerApi a = DownloadManagerApi.j.a();
            FragmentActivity context = getContext();
            Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            DownloadManagerApi.e0(a, context, DownloadPageType.DOWNLOAD.getPageName(), HttpUrl.FRAGMENT_ENCODE_SET, item.getOps(), "download_subject", false, item, (String) null, (Boolean) null, 384, (Object) null);
            return;
        }
        if (item.isJumpBrowser()) {
            PlayUrl playUrl3 = item.getPlayUrl();
            if (playUrl3 == null || (playUrl2 = playUrl3.getPlayUrl()) == null) {
                return;
            }
            ij.k.i(playUrl2);
            return;
        }
        if (!item.isJumpWebview()) {
            Navigator c = TheRouter.c("/movie/detail");
            Integer subjectType2 = item.getSubjectType();
            Navigator.x(c.F("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).K("id", item.getSubjectId()).K("ops", item.getOps()), getContext(), (mf.c) null, 2, (Object) null);
        } else {
            PlayUrl playUrl4 = item.getPlayUrl();
            if (playUrl4 == null || (playUrl = playUrl4.getPlayUrl()) == null) {
                return;
            }
            ij.k.h(playUrl, (String) null, 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$6(DownloadPanelForYouFootView downloadPanelForYouFootView) {
        ij.e eVar = downloadPanelForYouFootView.exposureTracker;
        if (eVar != null) {
            eVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(DownloadPanelForYouFootView downloadPanelForYouFootView, int i) {
        Subject subject;
        com.transsnet.downloader.adapter.w0 w0Var = downloadPanelForYouFootView.movieRecAdapter;
        if (w0Var == null || (subject = (Subject) w0Var.f0(i)) == null) {
            return Unit.a;
        }
        downloadPanelForYouFootView.getDownloadReport().a(DownloadPageType.DOWNLOAD.getPageName(), subject, i, -1L);
        return Unit.a;
    }

    private final void u() {
        RecyclerView recyclerView = this.viewBinding.d;
        recyclerView.setNestedScrollingEnabled(false);
        Context context = recyclerView.getContext();
        Context context2 = recyclerView.getContext();
        Intrinsics.g(context2, "getContext(...)");
        recyclerView.setLayoutManager(new NpaGridLayoutManager(context, com.transsion.baseui.util.b.a(context2) ? 4 : 3));
        recyclerView.addItemDecoration(new tf.a(lj.a.b(8), lj.a.b(12), 0, 0));
        com.transsnet.downloader.adapter.w0 w0Var = new com.transsnet.downloader.adapter.w0(new ArrayList());
        w0Var.w1(new r6.d() { // from class: com.transsnet.downloader.widget.p
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DownloadPanelForYouFootView.v(DownloadPanelForYouFootView.this, baseQuickAdapter, view, i);
            }
        });
        this.movieRecAdapter = w0Var;
        recyclerView.setAdapter(w0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(DownloadPanelForYouFootView downloadPanelForYouFootView, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = adapter.getItem(i);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            downloadPanelForYouFootView.s(subject);
            downloadPanelForYouFootView.getDownloadReport().b(DownloadPageType.DOWNLOAD.getPageName(), subject, i);
        }
    }

    private final void w() {
        final AppCompatImageView appCompatImageView = this.viewBinding.c;
        appCompatImageView.animate().cancel();
        ViewPropertyAnimator animate = appCompatImageView.animate();
        animate.setDuration(1000L);
        animate.rotation(appCompatImageView.getRotation() + 360.0f);
        animate.setInterpolator(new AccelerateDecelerateInterpolator());
        ViewPropertyAnimator withEndAction = animate.withEndAction(new Runnable() { // from class: com.transsnet.downloader.widget.o
            @Override // java.lang.Runnable
            public final void run() {
                DownloadPanelForYouFootView.x(appCompatImageView, this);
            }
        });
        if (withEndAction != null) {
            withEndAction.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(AppCompatImageView appCompatImageView, DownloadPanelForYouFootView downloadPanelForYouFootView) {
        if (appCompatImageView.getRotation() >= 360.0f) {
            appCompatImageView.setRotation(appCompatImageView.getRotation() - 360);
        }
        downloadPanelForYouFootView.w();
    }

    public final void configChange() {
        com.transsnet.downloader.adapter.w0 w0Var = this.movieRecAdapter;
        if (w0Var != null) {
            w0Var.notifyDataSetChanged();
        }
    }

    public final void initBrowseReport(RecyclerView parentRecyclerView) {
        this.exposureTracker = new ij.e(parentRecyclerView, this.viewBinding.d, 0.5f, new Function1() { // from class: com.transsnet.downloader.widget.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit t;
                t = DownloadPanelForYouFootView.t(DownloadPanelForYouFootView.this, ((Integer) obj).intValue());
                return t;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        com.transsnet.downloader.adapter.w0 w0Var = this.movieRecAdapter;
        if (w0Var == null || !w0Var.q0()) {
            yg.l.a.l(this);
        }
    }

    public void onConnected() {
        m.a.a(this);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        Function0 function0 = this.refreshCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        yg.l.a.m(this);
    }

    public void onDisconnected() {
    }

    public final void onPageResume() {
        ij.e eVar = this.exposureTracker;
        if (eVar != null) {
            eVar.e();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setData(List<? extends Subject> data) {
        Intrinsics.h(data, "data");
        p();
        int size = data.size();
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        List K0 = CollectionsKt.K0(data, size - RangesKt.e(size % (com.transsion.baseui.util.b.a(context) ? 4 : 3), 0));
        com.transsnet.downloader.adapter.w0 w0Var = this.movieRecAdapter;
        if (w0Var != null) {
            w0Var.n1(K0);
        }
        Group groupRefresh = this.viewBinding.b;
        Intrinsics.g(groupRefresh, "groupRefresh");
        uf.c.k(groupRefresh);
        yg.l.a.m(this);
        postDelayed(new Runnable() { // from class: com.transsnet.downloader.widget.n
            @Override // java.lang.Runnable
            public final void run() {
                DownloadPanelForYouFootView.setData$lambda$6(DownloadPanelForYouFootView.this);
            }
        }, 500L);
    }

    public final void setRefreshClickCallback(Function0<Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.refreshCallback = callback;
    }

    public final void showNoNetView() {
        p();
        com.transsnet.downloader.adapter.w0 w0Var = this.movieRecAdapter;
        List data = w0Var != null ? w0Var.getData() : null;
        if (data == null || data.isEmpty()) {
            yg.l.a.l(this);
            Group groupRefresh = this.viewBinding.b;
            Intrinsics.g(groupRefresh, "groupRefresh");
            uf.c.g(groupRefresh);
            com.transsnet.downloader.adapter.w0 w0Var2 = this.movieRecAdapter;
            if (w0Var2 != null) {
                w0Var2.Y0(getForYouNoNetView());
            }
        }
    }
}
