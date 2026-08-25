package com.transsion.audio.fragment;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.imageview.ShapeableImageView;
import com.therouter.TheRouter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.audio.adapter.SubjectListAdapter;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.audio.viewmodel.SubjectListViewModel;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.push.bean.MsgStyle;
import com.transsnet.downloader.bean.DownloadListBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 q2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00019B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J)\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J!\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\u0005J\u000f\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010\u0005J\u0019\u0010.\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/J!\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u0002002\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b2\u00103J!\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u0002042\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b6\u00107J\u0019\u00108\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b8\u0010/R\u0018\u0010;\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010:R\u0018\u0010B\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010:R\u0018\u0010D\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010:R$\u0010L\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010S\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010NR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010NR\u0016\u0010X\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010NR\u0016\u0010Z\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010NR\u001b\u0010`\u001a\u00020[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010]\u001a\u0004\bc\u0010dR\u001d\u0010j\u001a\u0004\u0018\u00010f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010]\u001a\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010:R\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010o¨\u0006r"}, d2 = {"Lcom/transsion/audio/fragment/SubjectListFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lki/c;", "Lcom/transsion/player/orplayer/e;", "<init>", "()V", BuildConfig.FLAVOR, "loadMore", "u0", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "page", "perPage", "E0", "(ZII)V", "Lcom/transsnet/downloader/bean/DownloadListBean;", "bean", "I0", "(Lcom/transsnet/downloader/bean/DownloadListBean;)V", BuildConfig.FLAVOR, "subjectId", "subjectType", "y0", "(Ljava/lang/String;I)V", "Lcom/transsion/moviedetailapi/DownloadItem;", "download", "Lcom/transsion/baselib/db/audio/AudioBean;", "item", "H0", "(Lcom/transsion/moviedetailapi/DownloadItem;Lcom/transsion/baselib/db/audio/AudioBean;)V", "Landroid/view/LayoutInflater;", "inflater", "x0", "(Landroid/view/LayoutInflater;)Lki/c;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "lazyLoadData", "onResume", "onPause", "Lgn/e;", "mediaSource", "onPrepare", "(Lgn/e;)V", BuildConfig.FLAVOR, "progress", "onProgress", "(JLgn/e;)V", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lgn/e;)V", "onCompletion", "a", "Ljava/lang/String;", "subjectCover", "Lcom/transsion/audio/adapter/SubjectListAdapter;", "b", "Lcom/transsion/audio/adapter/SubjectListAdapter;", "mAdapter", "c", "d", "groupId", "e", "subjectTitle", "Lcom/transsion/audio/fragment/AudioBottomSheetFragment;", "f", "Lcom/transsion/audio/fragment/AudioBottomSheetFragment;", "getParent", "()Lcom/transsion/audio/fragment/AudioBottomSheetFragment;", "setParent", "(Lcom/transsion/audio/fragment/AudioBottomSheetFragment;)V", "parent", "g", "I", "getTotalEpisode", "()I", "setTotalEpisode", "(I)V", "totalEpisode", "h", "currentPage", "i", "j", "currentPageUp", "k", "currentPageDown", "Lcom/transsion/audio/viewmodel/SubjectListViewModel;", "l", "Lkotlin/Lazy;", "w0", "()Lcom/transsion/audio/viewmodel/SubjectListViewModel;", "subjectListViewModel", "Lsi/a;", "m", "v0", "()Lsi/a;", "audioDao", "Lep/a;", "n", "getMAudioApi", "()Lep/a;", "mAudioApi", "o", "previousUrl", "Ljava/util/concurrent/atomic/AtomicBoolean;", "p", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsStop", "q", "Audio_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubjectListFragment extends BaseFragment<ki.c> implements com.transsion.player.orplayer.e {

    /* renamed from: q, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String r = "SubjectListFragment";

    /* renamed from: b, reason: from kotlin metadata */
    private SubjectListAdapter mAdapter;

    /* renamed from: f, reason: from kotlin metadata */
    private AudioBottomSheetFragment parent;

    /* renamed from: g, reason: from kotlin metadata */
    private int totalEpisode;

    /* renamed from: l, reason: from kotlin metadata */
    private final Lazy subjectListViewModel;

    /* renamed from: m, reason: from kotlin metadata */
    private final Lazy audioDao;

    /* renamed from: n, reason: from kotlin metadata */
    private final Lazy mAudioApi;

    /* renamed from: o, reason: from kotlin metadata */
    private String previousUrl;

    /* renamed from: p, reason: from kotlin metadata */
    private AtomicBoolean mIsStop;

    /* renamed from: a, reason: from kotlin metadata */
    private String subjectCover = BuildConfig.FLAVOR;

    /* renamed from: c, reason: from kotlin metadata */
    private String subjectId = BuildConfig.FLAVOR;

    /* renamed from: d, reason: from kotlin metadata */
    private String groupId = BuildConfig.FLAVOR;

    /* renamed from: e, reason: from kotlin metadata */
    private String subjectTitle = BuildConfig.FLAVOR;

    /* renamed from: h, reason: from kotlin metadata */
    private int currentPage = 1;

    /* renamed from: i, reason: from kotlin metadata */
    private int perPage = 8;

    /* renamed from: j, reason: from kotlin metadata */
    private int currentPageUp = 1;

    /* renamed from: k, reason: from kotlin metadata */
    private int currentPageDown = 1;

    /* renamed from: com.transsion.audio.fragment.SubjectListFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return SubjectListFragment.r;
        }

        public final SubjectListFragment b(String str) {
            SubjectListFragment subjectListFragment = new SubjectListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("subjectId", str);
            subjectListFragment.setArguments(bundle);
            return subjectListFragment;
        }
    }

    static final class b implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        b(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    public SubjectListFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.audio.fragment.SubjectListFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m3invoke() {
                return this;
            }
        };
        this.subjectListViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(SubjectListViewModel.class), new Function0<x0>() { // from class: com.transsion.audio.fragment.SubjectListFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m4invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.audio.fragment.SubjectListFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m5invoke() {
                Object invoke = function0.invoke();
                androidx.lifecycle.m mVar = invoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.audioDao = LazyKt.b(new Function0() { // from class: com.transsion.audio.fragment.m
            public final Object invoke() {
                si.a t0;
                t0 = SubjectListFragment.t0();
                return t0;
            }
        });
        this.mAudioApi = LazyKt.b(new Function0() { // from class: com.transsion.audio.fragment.n
            public final Object invoke() {
                ep.a G0;
                G0 = SubjectListFragment.G0();
                return G0;
            }
        });
        this.previousUrl = BuildConfig.FLAVOR;
        this.mIsStop = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(SubjectListFragment subjectListFragment, DownloadListBean downloadListBean) {
        subjectListFragment.I0(downloadListBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(SubjectListFragment subjectListFragment) {
        subjectListFragment.loadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof DownloadItem) {
            DownloadItem downloadItem = (DownloadItem) item;
            if (TextUtils.isEmpty(downloadItem.getPostId())) {
                fh.b.a.e("This page is unavailable");
            } else {
                ij.k.p(TheRouter.c("/post/detail").K("page_from", "audio_list").K("id", downloadItem.getPostId()).K("media_type", MediaType.AUDIO.getValue()).z("video_load_more", true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(SubjectListFragment subjectListFragment) {
        subjectListFragment.u0();
    }

    private final void E0(boolean loadMore, int page, int perPage) {
        w0().g(loadMore, this.subjectId, (r17 & 4) != 0 ? MsgStyle.CUSTOM_LEFT_PIC : String.valueOf(page), (r17 & 8) != 0 ? 8 : perPage, (r17 & 16) != 0 ? 1 : 0, (r17 & 32) != 0 ? 8 : 0, (r17 & 64) != 0 ? 0 : 0);
    }

    static /* synthetic */ void F0(SubjectListFragment subjectListFragment, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 8;
        }
        subjectListFragment.E0(z, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.a G0() {
        return (ep.a) TheRouter.d(ep.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(DownloadItem download, AudioBean item) {
        List data;
        SubjectListAdapter subjectListAdapter;
        SubjectListAdapter subjectListAdapter2 = this.mAdapter;
        if (subjectListAdapter2 != null && (data = subjectListAdapter2.getData()) != null) {
            int i = 0;
            for (Object obj : data) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                if (Intrinsics.c(download, (DownloadItem) obj) && (subjectListAdapter = this.mAdapter) != null) {
                    subjectListAdapter.notifyItemChanged(i, download);
                }
                i = i2;
            }
        }
        Long readProcess = item.getReadProcess();
        long longValue = readProcess != null ? readProcess.longValue() : 0L;
        String url = download.getUrl();
        String url2 = download.getUrl();
        if (url2 == null) {
            url2 = BuildConfig.FLAVOR;
        }
        onProgress(longValue, new gn.e(url, url2, 0, null, null, 28, null));
    }

    private final void I0(final DownloadListBean bean) {
        String str;
        t6.f h0;
        List l;
        SwipeRefreshLayout swipeRefreshLayout;
        ki.c cVar;
        SwipeRefreshLayout swipeRefreshLayout2;
        RecyclerView recyclerView;
        SubjectListAdapter subjectListAdapter;
        t6.f h02;
        t6.f h03;
        SubjectListAdapter subjectListAdapter2;
        t6.f h04;
        String nextPage;
        List data;
        AppCompatTextView appCompatTextView;
        LinearLayoutCompat linearLayoutCompat;
        Cover cover;
        if (bean == null || (cover = bean.getCover()) == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        ki.c cVar2 = (ki.c) getMViewBinding();
        ShapeableImageView shapeableImageView = cVar2 != null ? cVar2.c : null;
        Context context = getContext();
        if (context != null && !TextUtils.isEmpty(str) && shapeableImageView != null) {
            ni.f.a.m(context).g(str).d(shapeableImageView);
        }
        ki.c cVar3 = (ki.c) getMViewBinding();
        if (cVar3 != null && (linearLayoutCompat = cVar3.d) != null) {
            linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.fragment.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectListFragment.J0(SubjectListFragment.this, bean, view);
                }
            });
        }
        ki.c cVar4 = (ki.c) getMViewBinding();
        if (cVar4 != null && (appCompatTextView = cVar4.g) != null) {
            appCompatTextView.setText(bean != null ? bean.getSubjectTitle() : null);
        }
        List items = bean != null ? bean.getItems() : null;
        if (items == null || items.isEmpty()) {
            SubjectListAdapter subjectListAdapter3 = this.mAdapter;
            if (subjectListAdapter3 == null || (h0 = subjectListAdapter3.h0()) == null) {
                return;
            }
            t6.f.u(h0, false, 1, (Object) null);
            return;
        }
        SubjectListAdapter subjectListAdapter4 = this.mAdapter;
        if (subjectListAdapter4 != null && (data = subjectListAdapter4.getData()) != null && data.isEmpty()) {
            SubjectListAdapter subjectListAdapter5 = this.mAdapter;
            if (subjectListAdapter5 != null) {
                subjectListAdapter5.n1(items);
                return;
            }
            return;
        }
        SubjectListAdapter subjectListAdapter6 = this.mAdapter;
        if (subjectListAdapter6 == null || (l = subjectListAdapter6.getData()) == null) {
            l = CollectionsKt.l();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (!l.contains((DownloadItem) obj)) {
                arrayList.add(obj);
            }
        }
        if (bean.getLoadMore()) {
            SubjectListAdapter subjectListAdapter7 = this.mAdapter;
            if (subjectListAdapter7 != null) {
                subjectListAdapter7.q(arrayList);
            }
            Pager pager = bean.getPager();
            this.currentPageUp = (pager == null || (nextPage = pager.getNextPage()) == null) ? 1 : Integer.parseInt(nextPage);
            SubjectListAdapter subjectListAdapter8 = this.mAdapter;
            if (subjectListAdapter8 != null && (h03 = subjectListAdapter8.h0()) != null && h03.r() && (subjectListAdapter2 = this.mAdapter) != null && (h04 = subjectListAdapter2.h0()) != null) {
                h04.s();
            }
        } else {
            SubjectListAdapter subjectListAdapter9 = this.mAdapter;
            if (subjectListAdapter9 != null) {
                subjectListAdapter9.o(0, arrayList);
            }
            ki.c cVar5 = (ki.c) getMViewBinding();
            if (cVar5 != null && (recyclerView = cVar5.e) != null) {
                recyclerView.scrollToPosition(arrayList.size() - 1);
            }
            ki.c cVar6 = (ki.c) getMViewBinding();
            if (cVar6 != null && (swipeRefreshLayout = cVar6.f) != null && swipeRefreshLayout.isRefreshing() && (cVar = (ki.c) getMViewBinding()) != null && (swipeRefreshLayout2 = cVar.f) != null) {
                swipeRefreshLayout2.setRefreshing(false);
            }
            this.currentPageDown--;
        }
        Pager pager2 = bean.getPager();
        if (!(pager2 != null ? Intrinsics.c(pager2.getHasMore(), Boolean.FALSE) : false) || (subjectListAdapter = this.mAdapter) == null || (h02 = subjectListAdapter.h0()) == null) {
            return;
        }
        t6.f.u(h02, false, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(SubjectListFragment subjectListFragment, DownloadListBean downloadListBean, View view) {
        subjectListFragment.y0(subjectListFragment.subjectId, downloadListBean != null ? downloadListBean.getSubjectType() : SubjectType.MOVIE.getValue());
    }

    private final ep.a getMAudioApi() {
        return (ep.a) this.mAudioApi.getValue();
    }

    private final void loadMore() {
        F0(this, true, this.currentPageUp, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final si.a t0() {
        Application a = Utils.a();
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Intrinsics.e(a);
        return appDatabase$f1.b(a).n1();
    }

    private final void u0() {
        if (this.currentPage < 1) {
            return;
        }
        F0(this, false, this.currentPageDown, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final si.a v0() {
        return (si.a) this.audioDao.getValue();
    }

    private final SubjectListViewModel w0() {
        return (SubjectListViewModel) this.subjectListViewModel.getValue();
    }

    private final void y0(String subjectId, int subjectType) {
        ij.k.p(TheRouter.c("/movie/detail").F("subject_type", subjectType).K("id", subjectId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(SubjectListFragment subjectListFragment, DownloadListBean downloadListBean) {
        SubjectListAdapter subjectListAdapter;
        t6.f h0;
        ki.c cVar;
        SwipeRefreshLayout swipeRefreshLayout;
        if (downloadListBean != null) {
            Integer totalEpisode = downloadListBean.getTotalEpisode();
            subjectListFragment.totalEpisode = totalEpisode != null ? totalEpisode.intValue() : 0;
            Cover cover = downloadListBean.getCover();
            subjectListFragment.subjectCover = cover != null ? cover.getUrl() : null;
            subjectListFragment.groupId = downloadListBean.getGroupId();
            subjectListFragment.subjectTitle = downloadListBean.getSubjectTitle();
            subjectListFragment.I0(downloadListBean);
            Integer position = downloadListBean.getPosition();
            int intValue = position != null ? (position.intValue() / subjectListFragment.perPage) + 1 : 1;
            subjectListFragment.currentPage = intValue;
            subjectListFragment.currentPageDown = intValue - 1;
            subjectListFragment.currentPageUp = intValue + 1;
            if (intValue < 1 && (cVar = (ki.c) subjectListFragment.getMViewBinding()) != null && (swipeRefreshLayout = cVar.f) != null) {
                swipeRefreshLayout.setEnabled(false);
            }
            Pager pager = downloadListBean.getPager();
            if ((pager != null ? Intrinsics.c(pager.getHasMore(), Boolean.FALSE) : false) && (subjectListAdapter = subjectListFragment.mAdapter) != null && (h0 = subjectListAdapter.h0()) != null) {
                t6.f.u(h0, false, 1, (Object) null);
            }
        }
        return Unit.a;
    }

    @Override // com.transsion.player.orplayer.e
    public void canNonSubscriberPlay(boolean z, int i, int i2, qn.d dVar) {
        e.a.a(this, z, i, i2, dVar);
    }

    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        HistoryListManager.e.b().v().j(this, new b(new Function1() { // from class: com.transsion.audio.fragment.k
            public final Object invoke(Object obj) {
                Unit z0;
                z0 = SubjectListFragment.z0(SubjectListFragment.this, (DownloadListBean) obj);
                return z0;
            }
        }));
        w0().f().j(this, new b(new Function1() { // from class: com.transsion.audio.fragment.l
            public final Object invoke(Object obj) {
                Unit A0;
                A0 = SubjectListFragment.A0(SubjectListFragment.this, (DownloadListBean) obj);
                return A0;
            }
        }));
        Bundle arguments = getArguments();
        this.subjectId = arguments != null ? arguments.getString("subjectId") : null;
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.b(this);
    }

    public void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView2;
        SwipeRefreshLayout swipeRefreshLayout2;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.h(view, "view");
        AudioBottomSheetFragment parentFragment = getParentFragment();
        Intrinsics.f(parentFragment, "null cannot be cast to non-null type com.transsion.audio.fragment.AudioBottomSheetFragment");
        this.parent = parentFragment;
        ki.c cVar = (ki.c) getMViewBinding();
        if (cVar != null && (swipeRefreshLayout2 = cVar.f) != null && (layoutParams = swipeRefreshLayout2.getLayoutParams()) != null) {
            AudioBottomSheetFragment audioBottomSheetFragment = this.parent;
            layoutParams.height = audioBottomSheetFragment != null ? audioBottomSheetFragment.D0() - a0.a(104.0f) : 0;
        }
        ki.c cVar2 = (ki.c) getMViewBinding();
        if (cVar2 != null && (recyclerView2 = cVar2.e) != null) {
            recyclerView2.setLayoutManager(new NpaLinearLayoutManager(getContext()));
        }
        SubjectListAdapter subjectListAdapter = new SubjectListAdapter(new ArrayList());
        subjectListAdapter.h0().z(true);
        subjectListAdapter.h0().D(new r6.f() { // from class: com.transsion.audio.fragment.h
            public final void a() {
                SubjectListFragment.B0(SubjectListFragment.this);
            }
        });
        subjectListAdapter.w1(new r6.d() { // from class: com.transsion.audio.fragment.i
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                SubjectListFragment.C0(baseQuickAdapter, view2, i);
            }
        });
        subjectListAdapter.J1(new SubjectListAdapter.a() { // from class: com.transsion.audio.fragment.SubjectListFragment$initView$1$3
            @Override // com.transsion.audio.adapter.SubjectListAdapter.a
            public void a(DownloadItem downloadItem) {
                Intrinsics.h(downloadItem, "download");
                kotlinx.coroutines.i.f((CoroutineContext) null, new SubjectListFragment$initView$1$3$onPlayItem$1(downloadItem, SubjectListFragment.this, null), 1, (Object) null);
            }
        });
        this.mAdapter = subjectListAdapter;
        ki.c cVar3 = (ki.c) getMViewBinding();
        if (cVar3 != null && (swipeRefreshLayout = cVar3.f) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.audio.fragment.j
                public final void a() {
                    SubjectListFragment.D0(SubjectListFragment.this);
                }
            });
        }
        ki.c cVar4 = (ki.c) getMViewBinding();
        if (cVar4 == null || (recyclerView = cVar4.e) == null) {
            return;
        }
        recyclerView.setAdapter(this.mAdapter);
    }

    public void lazyLoadData() {
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
        e.a.c(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j, gn.e eVar) {
        e.a.d(this, j, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(gn.e mediaSource) {
        e.a.e(this, mediaSource);
        kotlinx.coroutines.i.f((CoroutineContext) null, new SubjectListFragment$onCompletion$1(mediaSource, this, null), 1, (Object) null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z) {
        e.a.g(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z) {
        e.a.h(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(gn.e eVar) {
        e.a.i(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(gn.e eVar) {
        e.a.k(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i, float f, gn.e eVar) {
        e.a.m(this, i, f, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        e.a.o(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.p(this, str);
    }

    public void onPause() {
        super.onPause();
        ep.a mAudioApi = getMAudioApi();
        if (mAudioApi != null) {
            mAudioApi.removePlayerListener(this);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, gn.e mediaSource) {
        Intrinsics.h(errorInfo, "errorInfo");
        e.a.q(this, errorInfo, mediaSource);
        fh.b.a.e(String.valueOf(errorInfo.getErrorMessage()));
        kotlinx.coroutines.i.f((CoroutineContext) null, new SubjectListFragment$onPlayError$1(this, null), 1, (Object) null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(gn.e eVar) {
        e.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.v(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(gn.e mediaSource) {
        e.a.w(this, mediaSource);
        a.a.f(wf.a.a, r, "onPrepare  " + (!TextUtils.equals(this.previousUrl, mediaSource != null ? mediaSource.j() : null)) + "  previousUrl " + this.previousUrl + " url " + (mediaSource != null ? mediaSource.j() : null), false, 4, (Object) null);
        kotlinx.coroutines.i.f((CoroutineContext) null, new SubjectListFragment$onPrepare$1(mediaSource, this, null), 1, (Object) null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long progress, gn.e mediaSource) {
        e.a.y(this, progress, mediaSource);
        kotlinx.coroutines.i.f((CoroutineContext) null, new SubjectListFragment$onProgress$1(mediaSource, this, progress, null), 1, (Object) null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        e.a.A(this);
    }

    public void onResume() {
        super.onResume();
        ep.a mAudioApi = getMAudioApi();
        if (mAudioApi != null) {
            mAudioApi.addPlayerListener(this);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.B(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i) {
        e.a.C(this, i);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(qn.c cVar) {
        e.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i) {
        e.a.E(this, i);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(gn.e eVar) {
        e.a.F(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i, int i2) {
        e.a.H(this, i, i2);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e eVar) {
        e.a.I(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.K(this);
    }

    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public ki.c getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        ki.c c = ki.c.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }
}
