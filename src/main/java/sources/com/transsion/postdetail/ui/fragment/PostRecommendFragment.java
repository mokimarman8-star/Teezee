package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.flow.bean.CommentBean;
import com.transsion.flow.bean.MediaType;
import com.transsion.flow.bean.PostSubjectBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.viewmodel.PostRecommendFragmentViewModel;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u001b\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u0004J/\u0010(\u001a\u00020\u00072\u000e\u0010#\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00142\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b*\u0010\rJ\u000f\u0010+\u001a\u00020\u0007H\u0002¢\u0006\u0004\b+\u0010\u0004J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0002H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u0010\u0004R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010>\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00109R\u0016\u0010A\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/PostRecommendFragment;", "Lcom/transsion/baseui/fragment/BaseListFragment;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "onPause", BuildConfig.FLAVOR, "s0", "()Ljava/lang/String;", "getPageStateLayoutTitle", BuildConfig.FLAVOR, "isAudioShowNoNetworkLayout", "()Z", "isMonitorNetworkState", "isShowPageStateLayoutTitle", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "m0", "()Lcom/chad/library/adapter/base/BaseQuickAdapter;", "initViewData", "initListener", "initViewModel", "x0", "G0", "lazyLoadData", "retryLoadData", "loadMore", "loadDefaultData", "onDestroy", "e1", "adapter", "Landroid/view/View;", "view", BuildConfig.FLAVOR, "position", "W0", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;Landroid/view/View;I)V", "getPageName", "initExposureHelper", "item", "g1", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "initAd", "Lbj/b;", "b", "Lbj/b;", "exposureHelper", "Lxn/a;", "c", "Lxn/a;", "postListReport", "d", "I", "mTabId", "e", "mNextPage", "f", "mPerPage", "g", "Ljava/lang/String;", "mPostId", "Lcom/transsion/postdetail/viewmodel/PostRecommendFragmentViewModel;", "h", "Lkotlin/Lazy;", "X0", "()Lcom/transsion/postdetail/viewmodel/PostRecommendFragmentViewModel;", "mViewModel", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "i", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "middleListManager", "j", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostRecommendFragment extends BaseListFragment<PostSubjectItem> {

    /* renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: from kotlin metadata */
    private bj.b exposureHelper;

    /* renamed from: c, reason: from kotlin metadata */
    private xn.a postListReport;

    /* renamed from: d, reason: from kotlin metadata */
    private int mTabId;

    /* renamed from: e, reason: from kotlin metadata */
    private int mNextPage = 1;

    /* renamed from: f, reason: from kotlin metadata */
    private int mPerPage = 8;

    /* renamed from: g, reason: from kotlin metadata */
    private String mPostId = BuildConfig.FLAVOR;

    /* renamed from: h, reason: from kotlin metadata */
    private final Lazy mViewModel = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.j3
        public final Object invoke() {
            PostRecommendFragmentViewModel d1;
            d1 = PostRecommendFragment.d1();
            return d1;
        }
    });

    /* renamed from: i, reason: from kotlin metadata */
    private BiddingListManager middleListManager;

    /* renamed from: com.transsion.postdetail.ui.fragment.PostRecommendFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PostRecommendFragment a(String str) {
            PostRecommendFragment postRecommendFragment = new PostRecommendFragment();
            Bundle bundle = new Bundle();
            bundle.putString("post_subject_id", str);
            postRecommendFragment.setArguments(bundle);
            return postRecommendFragment;
        }
    }

    public static final class b implements bj.a {
        b() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            PostRecommendFragment postRecommendFragment = PostRecommendFragment.this;
            try {
                Result.Companion companion = Result.Companion;
                if (postRecommendFragment.getMBaseAdapter() instanceof com.transsion.postdetail.ui.adapter.e) {
                    a.a.f(wf.a.a, bj.b.j.a(), "exposure position  " + i, false, 4, (Object) null);
                    xn.a aVar = postRecommendFragment.postListReport;
                    if (aVar != null) {
                        BaseQuickAdapter mBaseAdapter = postRecommendFragment.getMBaseAdapter();
                        Intrinsics.f(mBaseAdapter, "null cannot be cast to non-null type com.transsion.postdetail.ui.adapter.PostRecommendAdapter");
                        aVar.a((com.transsion.postdetail.ui.adapter.e) mBaseAdapter, i, j);
                    }
                }
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
    }

    static final class c implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.c0) && (obj instanceof FunctionAdapter)) {
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

    private final void W0(BaseQuickAdapter adapter, View view, int position) {
        String str;
        User user;
        Subject subject;
        ResourceDetectors resourceDetector;
        Group group;
        Subject subject2;
        Subject subject3;
        String subjectId;
        Context context;
        Subject subject4;
        Subject subject5;
        ResourceDetectors resourceDetector2;
        Subject subject6;
        Object item = adapter.getItem(position);
        PostSubjectItem postSubjectItem = item instanceof PostSubjectItem ? (PostSubjectItem) item : null;
        DownloadManagerApi.a aVar = DownloadManagerApi.j;
        DownloadManagerApi a = aVar.a();
        String subjectId2 = (postSubjectItem == null || (subject6 = postSubjectItem.getSubject()) == null) ? null : subject6.getSubjectId();
        String resourceId = (postSubjectItem == null || (subject5 = postSubjectItem.getSubject()) == null || (resourceDetector2 = subject5.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId();
        boolean z = false;
        if (postSubjectItem != null && (subject4 = postSubjectItem.getSubject()) != null && subject4.isSeries()) {
            z = true;
        }
        if (DownloadManagerApi.x0(a, subjectId2, resourceId, z, false, 8, (Object) null)) {
            if (postSubjectItem == null || (subject3 = postSubjectItem.getSubject()) == null || (subjectId = subject3.getSubjectId()) == null || (context = getContext()) == null) {
                return;
            }
            DownloadManagerApi.z0(aVar.a(), subjectId, context, getPageName(), (String) null, 8, (Object) null);
            return;
        }
        if (postSubjectItem != null && (subject2 = postSubjectItem.getSubject()) != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi a2 = aVar.a();
                FragmentActivity context2 = getContext();
                Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = context2;
                String pageName = getPageName();
                Group group2 = postSubjectItem.getGroup();
                DownloadManagerApi.e0(a2, fragmentActivity, pageName, group2 != null ? group2.getGroupId() : null, postSubjectItem.getOps(), "download_subject", true, postSubjectItem.getSubject(), (String) null, (Boolean) null, 384, (Object) null);
                return;
            }
        }
        DownloadManagerApi a3 = aVar.a();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        Subject subject7 = postSubjectItem != null ? postSubjectItem.getSubject() : null;
        String pageName2 = getPageName();
        String groupId = (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null) ? null : group.getGroupId();
        String ops = postSubjectItem != null ? postSubjectItem.getOps() : null;
        if (postSubjectItem == null || (subject = postSubjectItem.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (str = resourceDetector.getResourceLink()) == null) {
            str = BuildConfig.FLAVOR;
        }
        String str2 = str;
        if (postSubjectItem != null && (user = postSubjectItem.getUser()) != null) {
            r2 = user.getNickname();
        }
        DownloadManagerApi.M(a3, requireActivity, subject7, pageName2, groupId, ops, str2, (String) null, (String) null, r2, false, 704, (Object) null);
    }

    private final PostRecommendFragmentViewModel X0() {
        return (PostRecommendFragmentViewModel) this.mViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(PostRecommendFragment postRecommendFragment, int i, BiddingNativeManager biddingNativeManager) {
        List data;
        Intrinsics.h(biddingNativeManager, "current");
        if (biddingNativeManager != null) {
            PostSubjectItem postSubjectItem = new PostSubjectItem((String) null, (String) null, (Group) null, (Boolean) null, (Boolean) null, (Link) null, (Media) null, (String) null, (Stat) null, (Integer) null, (Subject) null, (Integer) null, (String) null, (String) null, (User) null, (String) null, (String) null, (Integer) null, (String) null, false, (Float) null, (Float) null, (String) null, (String) null, false, (List) null, false, (BiddingNativeManager) null, false, false, false, false, (CommentBean) null, -1, 1, (DefaultConstructorMarker) null);
            postSubjectItem.setNonAdDelegate(biddingNativeManager);
            BaseQuickAdapter mBaseAdapter = postRecommendFragment.getMBaseAdapter();
            int size = (mBaseAdapter == null || (data = mBaseAdapter.getData()) == null) ? 0 : data.size();
            if (i <= size) {
                BaseQuickAdapter mBaseAdapter2 = postRecommendFragment.getMBaseAdapter();
                if (mBaseAdapter2 != null) {
                    mBaseAdapter2.n(i, postSubjectItem);
                }
            } else {
                BaseQuickAdapter mBaseAdapter3 = postRecommendFragment.getMBaseAdapter();
                if (mBaseAdapter3 != null) {
                    mBaseAdapter3.n(size, postSubjectItem);
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(PostRecommendFragment postRecommendFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        a.a.f(wf.a.a, bj.b.j.a(), "position " + i, false, 4, (Object) null);
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof PostSubjectItem) {
            PostSubjectItem postSubjectItem = (PostSubjectItem) item;
            postRecommendFragment.g1(postSubjectItem);
            xn.a aVar = postRecommendFragment.postListReport;
            if (aVar != null) {
                aVar.b(i, postSubjectItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(PostRecommendFragment postRecommendFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (view.getId() == R$id.llDownload) {
            postRecommendFragment.W0(baseQuickAdapter, view, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        if (r3 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit b1(final PostRecommendFragment postRecommendFragment, PostSubjectBean postSubjectBean) {
        List<PostSubjectItem> items;
        ConstraintLayout root;
        Pager pager;
        Boolean bool = null;
        if ((postSubjectBean == null || (pager = postSubjectBean.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.FALSE)) {
            BaseListFragment.D0(postRecommendFragment, false, 1, null);
        }
        if (postSubjectBean != null && (items = postSubjectBean.getItems()) != null) {
            if (items.isEmpty()) {
                BaseListFragment.D0(postRecommendFragment, false, 1, null);
                if (postRecommendFragment.isEmpty()) {
                    PageStatusFragment.showEmptyView$default(postRecommendFragment, false, 1, (Object) null);
                }
                return Unit.a;
            }
            BaseQuickAdapter mBaseAdapter = postRecommendFragment.getMBaseAdapter();
            if (mBaseAdapter != null) {
                mBaseAdapter.q(items);
            }
            jj.b bVar = (jj.b) postRecommendFragment.getMViewBinding();
            if (bVar != null && (root = bVar.getRoot()) != null) {
                bool = Boolean.valueOf(root.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.n3
                    @Override // java.lang.Runnable
                    public final void run() {
                        PostRecommendFragment.c1(PostRecommendFragment.this);
                    }
                }, 300L));
            }
        }
        postRecommendFragment.N0();
        Unit unit = Unit.a;
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(PostRecommendFragment postRecommendFragment) {
        postRecommendFragment.B0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PostRecommendFragmentViewModel d1() {
        return new PostRecommendFragmentViewModel();
    }

    private final void e1() {
        AppCompatActivity context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? context : null;
        if (appCompatActivity != null) {
            Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.i3
                public final Object invoke(Object obj) {
                    Unit f1;
                    f1 = PostRecommendFragment.f1(PostRecommendFragment.this, (AddToDownloadEvent) obj);
                    return f1;
                }
            };
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = AddToDownloadEvent.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.observeEvent(appCompatActivity, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(PostRecommendFragment postRecommendFragment, AddToDownloadEvent addToDownloadEvent) {
        BaseQuickAdapter mBaseAdapter;
        List data;
        Intrinsics.h(addToDownloadEvent, "value");
        try {
            BaseQuickAdapter mBaseAdapter2 = postRecommendFragment.getMBaseAdapter();
            int i = -1;
            if (mBaseAdapter2 != null && (data = mBaseAdapter2.getData()) != null) {
                Iterator it = data.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Subject subject = ((PostSubjectItem) it.next()).getSubject();
                    if (Intrinsics.c(subject != null ? subject.getSubjectId() : null, addToDownloadEvent.getSubjectId())) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (i >= 0 && (mBaseAdapter = postRecommendFragment.getMBaseAdapter()) != null) {
                mBaseAdapter.notifyItemChanged(i + 1);
            }
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        return Unit.a;
    }

    private final void g1(PostSubjectItem item) {
        if (!yg.l.a.e()) {
            fh.b.a.d(R.string.no_network_tips);
            return;
        }
        io.b bVar = (io.b) TheRouter.d(io.b.class, new Object[0]);
        if (bVar != null) {
            bVar.i(item);
        }
        Media media = item.getMedia();
        Navigator K = TheRouter.c(Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.VIDEO.getValue()) ? "/post/detailVideo" : "/post/detail").K("page_from", getPageName()).K("id", item.getPostId()).K("item_type", item.getItemType());
        Media media2 = item.getMedia();
        Navigator.x(K.K("media_type", media2 != null ? media2.getMediaType() : null).z("from_comment", false), requireContext(), (mf.c) null, 2, (Object) null);
    }

    private final String getPageName() {
        return "post_detail_recommend";
    }

    private final void initAd() {
        BiddingListManager biddingListManager = new BiddingListManager();
        this.middleListManager = biddingListManager;
        jj.b bVar = (jj.b) getMViewBinding();
        biddingListManager.F(bVar != null ? bVar.d : null);
        BiddingListManager biddingListManager2 = this.middleListManager;
        if (biddingListManager2 != null) {
            biddingListManager2.A(androidx.lifecycle.v.a(this));
        }
        BiddingListManager biddingListManager3 = this.middleListManager;
        if (biddingListManager3 != null) {
            biddingListManager3.G("PostDetailRecommendScene");
        }
        BiddingListManager biddingListManager4 = this.middleListManager;
        if (biddingListManager4 != null) {
            biddingListManager4.z(new Function2() { // from class: com.transsion.postdetail.ui.fragment.k3
                public final Object invoke(Object obj, Object obj2) {
                    Unit Y0;
                    Y0 = PostRecommendFragment.Y0(PostRecommendFragment.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                    return Y0;
                }
            });
        }
    }

    private final void initExposureHelper() {
        jj.b bVar;
        RecyclerView recyclerView;
        this.postListReport = new xn.a("post_recommend", this.mPostId);
        bj.b bVar2 = new bj.b(0.6f, new b(), false, 4, null);
        this.exposureHelper = bVar2;
        bVar2.n(2);
        bj.b bVar3 = this.exposureHelper;
        if (bVar3 == null || (bVar = (jj.b) getMViewBinding()) == null || (recyclerView = bVar.d) == null) {
            return;
        }
        recyclerView.addOnScrollListener(bVar3);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void G0() {
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void initListener() {
        super.initListener();
        e1();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void initViewData() {
        super.initViewData();
        n0();
        u0();
        initAd();
    }

    public void initViewModel() {
        X0().h().j(this, new c(new Function1() { // from class: com.transsion.postdetail.ui.fragment.h3
            public final Object invoke(Object obj) {
                Unit b1;
                b1 = PostRecommendFragment.b1(PostRecommendFragment.this, (PostSubjectBean) obj);
                return b1;
            }
        }));
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public boolean isMonitorNetworkState() {
        return true;
    }

    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
    }

    public void loadDefaultData() {
        X0().g(this.mPostId, this.mTabId, this.mNextPage, this.mPerPage);
        this.mNextPage++;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void loadMore() {
        loadDefaultData();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter m0() {
        return new com.transsion.postdetail.ui.adapter.e(new ArrayList(), this.exposureHelper);
    }

    public void onCreate(Bundle savedInstanceState) {
        Object obj;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                Result.Companion companion = Result.Companion;
                String string = arguments.getString("post_subject_id");
                if (string == null) {
                    string = BuildConfig.FLAVOR;
                }
                this.mPostId = string;
                obj = Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th2));
            }
            Result.box-impl(obj);
        }
        initExposureHelper();
    }

    public void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.middleListManager;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
    }

    public void onPause() {
        super.onPause();
        bj.b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    public void retryLoadData() {
        F0();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String s0() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void x0() {
        RecyclerView recyclerView;
        super.x0();
        BaseQuickAdapter mBaseAdapter = getMBaseAdapter();
        if (mBaseAdapter != null) {
            View inflate = LayoutInflater.from(requireActivity()).inflate(R$layout.item_provider_post_recommend_for_you, (ViewGroup) null);
            Intrinsics.e(inflate);
            BaseQuickAdapter.y(mBaseAdapter, inflate, 0, 0, 6, (Object) null);
            mBaseAdapter.X0(R$layout.item_recommend_empty_layout);
            mBaseAdapter.w1(new r6.d() { // from class: com.transsion.postdetail.ui.fragment.l3
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    PostRecommendFragment.Z0(PostRecommendFragment.this, baseQuickAdapter, view, i);
                }
            });
            mBaseAdapter.l(new int[]{R$id.llDownload});
            mBaseAdapter.s1(new r6.b() { // from class: com.transsion.postdetail.ui.fragment.m3
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    PostRecommendFragment.a1(PostRecommendFragment.this, baseQuickAdapter, view, i);
                }
            });
        }
        jj.b bVar = (jj.b) getMViewBinding();
        if (bVar == null || (recyclerView = bVar.d) == null) {
            return;
        }
        recyclerView.addItemDecoration(new tf.i(com.blankj.utilcode.util.a0.a(16.0f), 0, 2, (DefaultConstructorMarker) null));
    }
}
