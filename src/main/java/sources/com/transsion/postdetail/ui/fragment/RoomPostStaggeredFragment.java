package com.transsion.postdetail.ui.fragment;

import android.os.Bundle;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.flow.bean.PostSubjectBean;
import com.transsion.flow.bean.RoomTabItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.ui.adapter.PostAdapterFrom;
import com.transsion.postdetail.viewmodel.RoomPostViewModel;
import com.transsion.push.bean.MsgStyle;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\bJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u0003J\u001f\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001aH\u0016¢\u0006\u0004\b$\u0010\u001cJ\u000f\u0010%\u001a\u00020\u001aH\u0016¢\u0006\u0004\b%\u0010\u001cJ\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010'J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H\u0016¢\u0006\u0004\b,\u0010'R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00103\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00104R\u0018\u00106\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00108\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00107R\u0018\u00109\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00107¨\u0006<"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/RoomPostStaggeredFragment;", "Lcom/transsion/postdetail/ui/fragment/RoomPostBaseFragment;", "<init>", "()V", BuildConfig.FLAVOR, "isSaveInstance", BuildConfig.FLAVOR, "trySaveDataCache", "(Z)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initViewData", "initViewModel", "outState", "onSaveInstanceState", "onDestroyView", "lazyLoadWithoutNet", "Lcom/transsion/postdetail/ui/adapter/PostAdapterFrom;", "postAdapterFrom", "()Lcom/transsion/postdetail/ui/adapter/PostAdapterFrom;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "item", "onItemHeaderClick", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", BuildConfig.FLAVOR, "onItemHeaderModuleName", "()Ljava/lang/String;", "hidden", "onHiddenChanged", "onResume", "isFirstLoad", "isRefresh", "loadData", "(ZZ)V", "pageName", "subpageName", "isSwipeRefreshEnable", "()Z", "isNeedInsertPublishPost", BuildConfig.FLAVOR, "tabIndex", "()I", "isStaggeredPost", "Lep/j;", "trendingImageRoomsViewModel$delegate", "Lkotlin/Lazy;", "getTrendingImageRoomsViewModel", "()Lep/j;", "trendingImageRoomsViewModel", "mTabIndex", "I", "curExposurePosition", "pageFrom", "Ljava/lang/String;", "insertPostId", "insertPostOps", "Companion", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class RoomPostStaggeredFragment extends RoomPostBaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String SUBPAGE_NAME = "room_home_discover";
    private static final String TAB_INDEX = "index";
    private static final String TAB_ITEM = "tab";
    private int curExposurePosition;
    private String insertPostId;
    private String insertPostOps;
    private int mTabIndex;
    private String pageFrom;

    /* renamed from: trendingImageRoomsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy trendingImageRoomsViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(ep.j.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostStaggeredFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final androidx.lifecycle.x0 m117invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostStaggeredFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m118invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: com.transsion.postdetail.ui.fragment.RoomPostStaggeredFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomPostStaggeredFragment a(String str, RoomTabItem roomTabItem, int i) {
            Intrinsics.h(roomTabItem, "item");
            RoomPostStaggeredFragment roomPostStaggeredFragment = new RoomPostStaggeredFragment();
            roomPostStaggeredFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a(RoomPostStaggeredFragment.TAB_ITEM, roomTabItem), TuplesKt.a(RoomPostStaggeredFragment.TAB_INDEX, Integer.valueOf(i)), TuplesKt.a("parent_type", str)}));
            return roomPostStaggeredFragment;
        }
    }

    public static final class b implements ij.q {
        b() {
        }

        @Override // ij.q
        public void a(int i) {
            if (RoomPostStaggeredFragment.this.curExposurePosition < i) {
                RoomPostStaggeredFragment.this.curExposurePosition = i;
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

    private final ep.j getTrendingImageRoomsViewModel() {
        return (ep.j) this.trendingImageRoomsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$1(RoomPostStaggeredFragment roomPostStaggeredFragment, PostSubjectBean postSubjectBean) {
        String str;
        List<PostSubjectItem> items;
        PostSubjectItem postSubjectItem;
        String ops;
        if (postSubjectBean != null && postSubjectBean.getIsRefresh() && (str = roomPostStaggeredFragment.insertPostOps) != null && str.length() != 0 && (items = postSubjectBean.getItems()) != null && (postSubjectItem = (PostSubjectItem) CollectionsKt.k0(items)) != null && Intrinsics.c(postSubjectItem.getPostId(), roomPostStaggeredFragment.insertPostId) && ((ops = postSubjectItem.getOps()) == null || ops.length() == 0)) {
            postSubjectItem.setOps(roomPostStaggeredFragment.insertPostOps);
        }
        roomPostStaggeredFragment.updateData(postSubjectBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$3(RoomPostStaggeredFragment roomPostStaggeredFragment, Pair pair) {
        RecyclerView recyclerView;
        qi.b logViewConfig;
        HashMap g;
        String str = pair != null ? (String) pair.getFirst() : null;
        if (str == null || str.length() == 0) {
            return Unit.a;
        }
        ep.k kVar = ep.k.a;
        String g2 = kVar.g();
        if (g2 != null && g2.length() != 0) {
            roomPostStaggeredFragment.pageFrom = kVar.g();
            kVar.r(null);
        }
        if (roomPostStaggeredFragment.pageFrom != null && (logViewConfig = roomPostStaggeredFragment.getLogViewConfig()) != null && (g = logViewConfig.g()) != null) {
        }
        roomPostStaggeredFragment.insertPostOps = (String) pair.getSecond();
        roomPostStaggeredFragment.insertPostId = str;
        RoomPostBaseFragment.loadData$default(roomPostStaggeredFragment, false, true, 1, null);
        wn.p pVar = (wn.p) roomPostStaggeredFragment.getMViewBinding();
        if (pVar != null && (recyclerView = pVar.b) != null) {
            recyclerView.scrollToPosition(0);
        }
        roomPostStaggeredFragment.insertPostId = null;
        return Unit.a;
    }

    private final void trySaveDataCache(boolean isSaveInstance) {
        String tabId;
        com.transsion.postdetail.ui.adapter.f mAdapter;
        List data;
        List data2;
        List subList;
        String str;
        Group group;
        List data3;
        List data4;
        a.a aVar = wf.a.a;
        String tag = getTAG();
        RoomTabItem mTopTab = getMTopTab();
        String tabId2 = mTopTab != null ? mTopTab.getTabId() : null;
        com.transsion.postdetail.ui.adapter.f mAdapter2 = getMAdapter();
        Integer valueOf = (mAdapter2 == null || (data4 = mAdapter2.getData()) == null) ? null : Integer.valueOf(data4.size());
        a.a.f(aVar, tag, "trySaveDataCache," + isSaveInstance + " tabId:" + tabId2 + ", size:" + valueOf + ", curExposurePosition:" + this.curExposurePosition, false, 4, (Object) null);
        RoomTabItem mTopTab2 = getMTopTab();
        if (mTopTab2 == null || (tabId = mTopTab2.getTabId()) == null || (mAdapter = getMAdapter()) == null || (data = mAdapter.getData()) == null) {
            return;
        }
        int size = data.size();
        int i = this.curExposurePosition;
        int i2 = size - i < 9 ? size - i : 9;
        if (i2 > 0 && size > i2) {
            String tag2 = getTAG();
            int i3 = size - i2;
            com.transsion.postdetail.ui.adapter.f mAdapter3 = getMAdapter();
            a.a.f(aVar, tag2, "trySaveDataCache, " + i3 + "， " + i2 + ", size:" + ((mAdapter3 == null || (data3 = mAdapter3.getData()) == null) ? null : Integer.valueOf(data3.size())), false, 4, (Object) null);
            com.transsion.postdetail.ui.adapter.f mAdapter4 = getMAdapter();
            if (mAdapter4 == null || (data2 = mAdapter4.getData()) == null || (subList = data2.subList(i3, size)) == null) {
                return;
            }
            String tag3 = getTAG();
            int size2 = subList.size();
            PostSubjectItem postSubjectItem = (PostSubjectItem) CollectionsKt.k0(subList);
            String name = (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null) ? null : group.getName();
            PostSubjectItem postSubjectItem2 = (PostSubjectItem) CollectionsKt.k0(subList);
            if (postSubjectItem2 != null) {
                String title = postSubjectItem2.getTitle();
                str = (title == null || title.length() == 0) ? postSubjectItem2.getContent() : postSubjectItem2.getTitle();
            } else {
                str = null;
            }
            a.a.f(aVar, tag3, "trySaveDataCache, " + size2 + "，name:" + name + "，content:" + str, false, 4, (Object) null);
            String j = com.blankj.utilcode.util.o.j(new PostSubjectBean(subList, new Pager(Boolean.TRUE, MsgStyle.CUSTOM_LEFT_PIC, BuildConfig.FLAVOR, 0, 0), null, null));
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
            int i4 = bVar.b().getInt("post_staggered_page_cache_code", 0);
            int hashCode = j.hashCode();
            if (i4 == hashCode) {
                a.a.f(aVar, getTAG(), "trySaveDataCache, HashCode same:" + hashCode, false, 4, (Object) null);
                return;
            }
            a.a.f(aVar, getTAG(), "SaveDataCache, oldCode:" + i4 + "，newCode:" + hashCode, false, 4, (Object) null);
            bVar.b().putInt("post_staggered_page_cache_code", hashCode);
            bVar.b().putString("post_staggered_page_cache_" + tabId, j);
        }
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void initViewData() {
        super.initViewData();
        setOnNumNotExposureListener(new b());
    }

    public void initViewModel() {
        androidx.lifecycle.b0 N;
        RoomPostViewModel mViewModel = getMViewModel();
        if (mViewModel != null && (N = mViewModel.N()) != null) {
            N.j(this, new c(new Function1() { // from class: com.transsion.postdetail.ui.fragment.x4
                public final Object invoke(Object obj) {
                    Unit initViewModel$lambda$1;
                    initViewModel$lambda$1 = RoomPostStaggeredFragment.initViewModel$lambda$1(RoomPostStaggeredFragment.this, (PostSubjectBean) obj);
                    return initViewModel$lambda$1;
                }
            }));
        }
        getTrendingImageRoomsViewModel().b().j(this, new c(new Function1() { // from class: com.transsion.postdetail.ui.fragment.y4
            public final Object invoke(Object obj) {
                Unit initViewModel$lambda$3;
                initViewModel$lambda$3 = RoomPostStaggeredFragment.initViewModel$lambda$3(RoomPostStaggeredFragment.this, (Pair) obj);
                return initViewModel$lambda$3;
            }
        }));
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public boolean isNeedInsertPublishPost() {
        return false;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public boolean isStaggeredPost() {
        return true;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public boolean isSwipeRefreshEnable() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadWithoutNet() {
        RoomPostViewModel mViewModel;
        showLoadingView();
        RoomTabItem mTopTab = getMTopTab();
        if (mTopTab == null || (mViewModel = getMViewModel()) == null) {
            return;
        }
        mViewModel.W(mTopTab.getTabId());
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void loadData(boolean isFirstLoad, boolean isRefresh) {
        RoomPostViewModel mViewModel;
        a.a.f(wf.a.a, getTAG(), "loadData isRefresh:" + isRefresh, false, 4, (Object) null);
        RoomTabItem mTopTab = getMTopTab();
        if (mTopTab == null || (mViewModel = getMViewModel()) == null) {
            return;
        }
        RoomPostViewModel.P(mViewModel, isFirstLoad, isRefresh, mTopTab.getTabId(), getMPage(), this.insertPostId, 0, 32, null);
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void onCreate(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(TAB_ITEM) : null;
        setMTopTab(serializable instanceof RoomTabItem ? (RoomTabItem) serializable : null);
        Bundle arguments2 = getArguments();
        this.mTabIndex = arguments2 != null ? arguments2.getInt(TAB_INDEX) : 0;
        Bundle arguments3 = getArguments();
        setMParentTypeName(arguments3 != null ? arguments3.getString("parent_type") : null);
        super.onCreate(savedInstanceState);
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void onDestroyView() {
        super.onDestroyView();
        trySaveDataCache(false);
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment, com.transsion.baseui.fragment.LazyFragment
    public void onHiddenChanged(boolean hidden) {
        ep.k kVar;
        String c2;
        super.onHiddenChanged(hidden);
        if (hidden || (c2 = (kVar = ep.k.a).c()) == null || c2.length() == 0) {
            return;
        }
        androidx.lifecycle.b0 b2 = getTrendingImageRoomsViewModel().b();
        String c3 = kVar.c();
        Intrinsics.e(c3);
        b2.q(new Pair(c3, kVar.e()));
        String g = kVar.g();
        if (g != null && g.length() != 0) {
            this.pageFrom = kVar.g();
            kVar.r(null);
        }
        kVar.n(null);
        kVar.p(null);
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void onItemHeaderClick(PostSubjectItem item) {
        openUserCenter(item);
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String onItemHeaderModuleName() {
        return "group";
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment, com.transsion.baseui.fragment.LazyFragment
    public void onResume() {
        super.onResume();
        ep.k kVar = ep.k.a;
        String c2 = kVar.c();
        if (c2 == null || c2.length() == 0) {
            return;
        }
        androidx.lifecycle.b0 b2 = getTrendingImageRoomsViewModel().b();
        String c3 = kVar.c();
        Intrinsics.e(c3);
        b2.q(new Pair(c3, kVar.e()));
        String g = kVar.g();
        if (g != null && g.length() != 0) {
            this.pageFrom = kVar.g();
            kVar.r(null);
        }
        kVar.n(null);
        kVar.p(null);
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(outState);
        trySaveDataCache(true);
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String pageName() {
        return "room_home";
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public PostAdapterFrom postAdapterFrom() {
        return PostAdapterFrom.STAGGERED;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String subpageName() {
        return SUBPAGE_NAME;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    /* renamed from: tabIndex, reason: from getter */
    public int getMTabIndex() {
        return this.mTabIndex;
    }
}
