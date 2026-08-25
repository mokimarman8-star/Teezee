package com.transsnet.downloader.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.moviedetailapi.bean.DownloadResolutionItem;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.R;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import im.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import wf.a;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ'\u0010\u0017\u001a\u00020\f2\u000e\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00142\u0006\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u0012J\u0015\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b \u0010\u0012J#\u0010%\u001a\u00020\f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010$\u001a\u00020\t¢\u0006\u0004\b%\u0010&J#\u0010)\u001a\u00020\f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020'0!2\u0006\u0010(\u001a\u00020\t¢\u0006\u0004\b)\u0010&J'\u0010,\u001a\u00020\f2\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\f0*¢\u0006\u0004\b,\u0010-J'\u0010.\u001a\u00020\f2\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\f0*¢\u0006\u0004\b.\u0010-J\u001b\u00100\u001a\u00020\f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0/¢\u0006\u0004\b0\u00101J\u001b\u00102\u001a\u00020\f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0/¢\u0006\u0004\b2\u00101J\u0017\u00105\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b5\u00106R\u0014\u00109\u001a\u0002038\u0002X\u0082D¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR*\u0010G\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\f\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR*\u0010I\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\f\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u001e\u0010L\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001e\u0010N\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010P\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010?R\u0016\u0010R\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010?R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010?R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006W"}, d2 = {"Lcom/transsnet/downloader/widget/DownloadResolutionTabView;", "Lcom/noober/background/view/BLConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", HttpUrl.FRAGMENT_ENCODE_SET, "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", HttpUrl.FRAGMENT_ENCODE_SET, "n", "()V", "p", "curSeason", "t", "(I)V", "l", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "adapter", "position", "o", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;I)V", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "setSubject", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "seasons", "setSeasons", "season", "setSeason", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/transsion/moviedetailapi/bean/DownloadResolutionItem;", "data", "resolutionPosition", "setResolutionContentData", "(Ljava/util/List;I)V", "Lcom/transsion/moviedetailapi/bean/DubsInfo;", "audioPosition", "setAudioContentData", "Lkotlin/Function2;", "listener", "setResolutionItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "setAudioItemClickListener", "Lkotlin/Function0;", "setSeasonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setAudioClickListener", HttpUrl.FRAGMENT_ENCODE_SET, "name", "updateAudioTrack", "(Ljava/lang/String;)V", "a", "Ljava/lang/String;", "TAG", "Lbx/y0;", "b", "Lbx/y0;", "viewBinding", "c", "I", "dp16", "Lcom/transsnet/downloader/adapter/r;", "d", "Lcom/transsnet/downloader/adapter/r;", "resolutionTabAdapter", "e", "Lkotlin/jvm/functions/Function2;", "resolutionItemClickListener", "f", "audioItemClickListener", "g", "Lkotlin/jvm/functions/Function0;", "audioClickListener", "h", "seasonClickListener", "i", "curResPosition", "j", "curAudioPosition", "k", "Lcom/transsion/moviedetailapi/bean/Subject;", "m", "Ljava/lang/Integer;", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadResolutionTabView extends BLConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: from kotlin metadata */
    private final bx.y0 viewBinding;

    /* renamed from: c, reason: from kotlin metadata */
    private final int dp16;

    /* renamed from: d, reason: from kotlin metadata */
    private com.transsnet.downloader.adapter.r resolutionTabAdapter;

    /* renamed from: e, reason: from kotlin metadata */
    private Function2 resolutionItemClickListener;

    /* renamed from: f, reason: from kotlin metadata */
    private Function2 audioItemClickListener;

    /* renamed from: g, reason: from kotlin metadata */
    private Function0 audioClickListener;

    /* renamed from: h, reason: from kotlin metadata */
    private Function0 seasonClickListener;

    /* renamed from: i, reason: from kotlin metadata */
    private int curResPosition;

    /* renamed from: j, reason: from kotlin metadata */
    private int curAudioPosition;

    /* renamed from: k, reason: from kotlin metadata */
    private Subject subject;

    /* renamed from: l, reason: from kotlin metadata */
    private int curSeason;

    /* renamed from: m, reason: from kotlin metadata */
    private Integer seasons;

    public static final class a implements im.a {
        final /* synthetic */ BaseQuickAdapter b;
        final /* synthetic */ int c;

        a(BaseQuickAdapter baseQuickAdapter, int i) {
            this.b = baseQuickAdapter;
            this.c = i;
        }

        public void a(MemberCheckResult memberCheckResult) {
            a.a.f(this, memberCheckResult);
        }

        public void b(MemberCheckResult memberCheckResult) {
            a.a.d(this, memberCheckResult);
        }

        public void c(MemberCheckResult memberCheckResult) {
            a.a.g(this, memberCheckResult);
        }

        public void d(MemberCheckResult memberCheckResult) {
            a.a.e(this, memberCheckResult);
        }

        public void e() {
            a.a.c(this);
            DownloadResolutionTabView downloadResolutionTabView = DownloadResolutionTabView.this;
            BaseQuickAdapter baseQuickAdapter = this.b;
            Intrinsics.e(baseQuickAdapter);
            downloadResolutionTabView.o(baseQuickAdapter, this.c);
        }

        public void f(MemberCheckResult memberCheckResult) {
            a.a.a(this, memberCheckResult);
        }

        public void onFail(String errorMsg) {
            Intrinsics.h(errorMsg, "errorMsg");
            a.a.b(this, errorMsg);
            a.a.f(wf.a.a, "co_mem", "DownloadResolutionTabView --> initRvAndAdapter() --> 剧集选择分辨率 -->  " + errorMsg, false, 4, (Object) null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadResolutionTabView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadResolutionTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadResolutionTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.TAG = "DownloadResolutionTabView";
        this.dp16 = com.blankj.utilcode.util.a0.a(16.0f);
        this.curResPosition = -1;
        this.curAudioPosition = -1;
        this.curSeason = 1;
        View.inflate(context, R.layout.layout_download_re_resolution_tab, this);
        bx.y0 a2 = bx.y0.a(this);
        Intrinsics.g(a2, "bind(...)");
        this.viewBinding = a2;
        n();
    }

    private final void l() {
        com.transsnet.downloader.adapter.r rVar = new com.transsnet.downloader.adapter.r();
        rVar.w1(new r6.d() { // from class: com.transsnet.downloader.widget.v
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DownloadResolutionTabView.m(DownloadResolutionTabView.this, baseQuickAdapter, view, i);
            }
        });
        this.resolutionTabAdapter = rVar;
        RecyclerView recyclerView = this.viewBinding.h;
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 4));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new tf.a(lj.a.b(8), 0, 0, 0));
        }
        recyclerView.setAdapter(this.resolutionTabAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(DownloadResolutionTabView downloadResolutionTabView, BaseQuickAdapter adapter, View view, int i) {
        im.b bVar;
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (i == downloadResolutionTabView.curResPosition) {
            return;
        }
        if (!yg.l.a.e()) {
            fh.b.a.d(com.tn.lib.widget.R.string.no_network_tips);
            return;
        }
        Object f0 = adapter.f0(i);
        DownloadResolutionItem downloadResolutionItem = f0 instanceof DownloadResolutionItem ? (DownloadResolutionItem) f0 : null;
        if (downloadResolutionItem == null || (bVar = (im.b) TheRouter.d(im.b.class, new Object[0])) == null) {
            return;
        }
        bVar.g(Integer.valueOf(downloadResolutionItem.getResolution()), downloadResolutionTabView.new a(adapter, i));
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (r0 == null) goto L6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void n() {
        ConstraintLayout.b bVar;
        if (getLayoutParams() != null) {
            ConstraintLayout.b layoutParams = getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            bVar = layoutParams;
        }
        bVar = new ConstraintLayout.b(-1, -2);
        bVar.setMarginStart(this.dp16);
        bVar.setMarginEnd(this.dp16);
        setLayoutParams(bVar);
        l();
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(BaseQuickAdapter adapter, int position) {
        Function2 function2;
        try {
            Object f0 = adapter.f0(this.curResPosition);
            DownloadResolutionItem downloadResolutionItem = f0 instanceof DownloadResolutionItem ? (DownloadResolutionItem) f0 : null;
            if (downloadResolutionItem != null) {
                downloadResolutionItem.setSelected(false);
            }
            adapter.notifyItemChanged(this.curResPosition, Boolean.FALSE);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Object f02 = adapter.f0(position);
        DownloadResolutionItem downloadResolutionItem2 = f02 instanceof DownloadResolutionItem ? (DownloadResolutionItem) f02 : null;
        if (downloadResolutionItem2 != null) {
            downloadResolutionItem2.setSelected(true);
        }
        adapter.notifyItemChanged(position, Boolean.TRUE);
        this.curResPosition = position;
        if (downloadResolutionItem2 == null || (function2 = this.resolutionItemClickListener) == null) {
            return;
        }
        function2.invoke(Integer.valueOf(position), downloadResolutionItem2);
    }

    private final void p() {
        this.viewBinding.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadResolutionTabView.q(DownloadResolutionTabView.this, view);
            }
        });
        this.viewBinding.i.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadResolutionTabView.r(DownloadResolutionTabView.this, view);
            }
        });
        this.viewBinding.f.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadResolutionTabView.s(DownloadResolutionTabView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void q(DownloadResolutionTabView downloadResolutionTabView, View view) {
        Navigator K = TheRouter.c("/profile/user_center_labels_feedback").K("feedback_from_page", "SUBJECT_DETAIL");
        Subject subject = downloadResolutionTabView.subject;
        Navigator.x(K.K("subject_id", subject != null ? subject.getSubjectId() : null), downloadResolutionTabView.getContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(DownloadResolutionTabView downloadResolutionTabView, View view) {
        a.a.f(wf.a.a, "DownloadDialog", "innerTvTitle click then switch audio track", false, 4, (Object) null);
        Function0 function0 = downloadResolutionTabView.audioClickListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(DownloadResolutionTabView downloadResolutionTabView, View view) {
        a.a.f(wf.a.a, "DownloadDialog", "Switch seasons", false, 4, (Object) null);
        com.blankj.utilcode.util.a.b();
        Function0 function0 = downloadResolutionTabView.seasonClickListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t(int curSeason) {
        this.curSeason = curSeason;
        Subject subject = this.subject;
        if (subject != null && subject.isTvType()) {
            BLTextView bLTextView = this.viewBinding.f;
            Context context = getContext();
            bLTextView.setText(context != null ? context.getString(R.string.download_video_detail_season_index, sm.f.a(curSeason)) : null);
            return;
        }
        Subject subject2 = this.subject;
        if (subject2 == null || !subject2.isEduType()) {
            BLTextView ivSeasons = this.viewBinding.f;
            Intrinsics.g(ivSeasons, "ivSeasons");
            uf.c.g(ivSeasons);
        } else {
            BLTextView bLTextView2 = this.viewBinding.f;
            Context context2 = getContext();
            bLTextView2.setText(context2 != null ? context2.getString(R.string.download_video_detail_unit_index, sm.f.a(curSeason)) : null);
        }
    }

    public final void setAudioClickListener(Function0<Unit> listener) {
        Intrinsics.h(listener, "listener");
        this.audioClickListener = listener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x003e, code lost:
    
        if (r8.size() > 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setAudioContentData(List<DubsInfo> data, int audioPosition) {
        boolean z;
        Intrinsics.h(data, "data");
        a.a.f(wf.a.a, "DownloadDialog", "setAudioContentData size:" + data.size(), false, 4, (Object) null);
        this.curAudioPosition = audioPosition;
        BLTextView tvLanguage = this.viewBinding.i;
        Intrinsics.g(tvLanguage, "tvLanguage");
        if (!data.isEmpty()) {
            z = true;
        }
        z = false;
        tvLanguage.setVisibility(z ? 0 : 8);
        if (audioPosition < 0 || audioPosition >= data.size()) {
            return;
        }
        this.viewBinding.i.setText(data.get(audioPosition).getLanName());
    }

    public final void setAudioItemClickListener(Function2<? super Integer, ? super DubsInfo, Unit> listener) {
        Intrinsics.h(listener, "listener");
        this.audioItemClickListener = listener;
    }

    public final void setResolutionContentData(List<DownloadResolutionItem> data, int resolutionPosition) {
        Intrinsics.h(data, "data");
        RecyclerView qualityRecyclerView = this.viewBinding.h;
        Intrinsics.g(qualityRecyclerView, "qualityRecyclerView");
        uf.c.k(qualityRecyclerView);
        View vLine = this.viewBinding.k;
        Intrinsics.g(vLine, "vLine");
        uf.c.k(vLine);
        this.curResPosition = resolutionPosition;
        com.transsnet.downloader.adapter.r rVar = this.resolutionTabAdapter;
        if (rVar != null) {
            List<DownloadResolutionItem> list = data;
            rVar.n1(list);
            if (list.isEmpty()) {
                return;
            }
            o(rVar, resolutionPosition);
        }
    }

    public final void setResolutionItemClickListener(Function2<? super Integer, ? super DownloadResolutionItem, Unit> listener) {
        Intrinsics.h(listener, "listener");
        this.resolutionItemClickListener = listener;
    }

    public final void setSeason(int season) {
        t(season);
    }

    public final void setSeasonClickListener(Function0<Unit> listener) {
        Intrinsics.h(listener, "listener");
        this.seasonClickListener = listener;
    }

    public final void setSeasons(int seasons) {
        this.seasons = Integer.valueOf(seasons);
        if (seasons <= 1) {
            BLTextView ivSeasons = this.viewBinding.f;
            Intrinsics.g(ivSeasons, "ivSeasons");
            uf.c.g(ivSeasons);
        } else {
            BLTextView ivSeasons2 = this.viewBinding.f;
            Intrinsics.g(ivSeasons2, "ivSeasons");
            uf.c.k(ivSeasons2);
        }
    }

    public final void setSubject(Subject subject) {
        ResourceDetectors resourceDetectors;
        Intrinsics.h(subject, "subject");
        this.subject = subject;
        List resourceDetectors2 = subject.getResourceDetectors();
        if (resourceDetectors2 == null || (resourceDetectors = (ResourceDetectors) CollectionsKt.k0(resourceDetectors2)) == null) {
            return;
        }
        this.viewBinding.d.setText(resourceDetectors.getUploadBy());
    }

    public final void updateAudioTrack(String name) {
        this.viewBinding.i.setText(name);
    }
}
