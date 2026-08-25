package com.transsion.home.fragment.hashtag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blankj.utilcode.util.a0;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.adapter.hashtag.a;
import com.transsion.home.bean.RefreshBaseDto;
import com.transsion.home.fragment.hashtag.m;
import com.transsion.home.hashtag.HashTagViewModel;
import com.transsion.home.hashtag.model.HashTagItem;
import com.transsion.home.hashtag.model.HashTagItemType;
import com.transsion.home.view.layoutmanager.OffsetGridLayoutManager;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import com.transsnet.downloader.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import qk.o;
import wf.a;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J+\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0004R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00101R\u0016\u00107\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00101R\u0016\u0010:\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010HR\u0016\u0010O\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010=¨\u0006Q"}, d2 = {"Lcom/transsion/home/fragment/hashtag/HashTagPageFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lqk/o;", "<init>", "()V", BuildConfig.FLAVOR, "z0", "showLoadingView", "v0", "G0", "J0", "u0", "r0", "L0", BuildConfig.FLAVOR, "tabId", BuildConfig.FLAVOR, "loadDuration", "ops", "E0", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "s0", "(Landroid/view/LayoutInflater;)Lqk/o;", "lazyLoadData", "onResume", "onPause", "Lcom/transsion/home/adapter/hashtag/a;", "a", "Lcom/transsion/home/adapter/hashtag/a;", "adapter", "Lcom/transsion/home/hashtag/HashTagViewModel;", "b", "Lkotlin/Lazy;", "t0", "()Lcom/transsion/home/hashtag/HashTagViewModel;", "viewModel", BuildConfig.FLAVOR, "c", "I", "spanCount", "d", "Ljava/lang/String;", "e", "fromOptId", "f", "ugcVideoId", "g", "hashtagTitle", "h", "J", "firstLoadStartTimeMillis", BuildConfig.FLAVOR, "i", "Z", "hasRecordedFirstLoadDuration", "Lcom/transsion/home/fragment/hashtag/HashTagPageFragment$b;", "j", "Lcom/transsion/home/fragment/hashtag/HashTagPageFragment$b;", "getLoadDurationCallback", "()Lcom/transsion/home/fragment/hashtag/HashTagPageFragment$b;", "F0", "(Lcom/transsion/home/fragment/hashtag/HashTagPageFragment$b;)V", "loadDurationCallback", "k", "Landroid/view/View;", "skeletonScreenView", "l", "mNoNetworkView", "m", "mNoResultView", "n", "tagsFullyInvisible", "o", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HashTagPageFragment extends BaseFragment<o> {

    /* renamed from: o, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int p = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private com.transsion.home.adapter.hashtag.a adapter;

    /* renamed from: f, reason: from kotlin metadata */
    private String ugcVideoId;

    /* renamed from: h, reason: from kotlin metadata */
    private long firstLoadStartTimeMillis;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean hasRecordedFirstLoadDuration;

    /* renamed from: j, reason: from kotlin metadata */
    private b loadDurationCallback;

    /* renamed from: k, reason: from kotlin metadata */
    private View skeletonScreenView;

    /* renamed from: l, reason: from kotlin metadata */
    private View mNoNetworkView;

    /* renamed from: m, reason: from kotlin metadata */
    private View mNoResultView;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean tagsFullyInvisible;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(HashTagViewModel.class), new Function0<x0>() { // from class: com.transsion.home.fragment.hashtag.HashTagPageFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final x0 m11invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.home.fragment.hashtag.HashTagPageFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m12invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: c, reason: from kotlin metadata */
    private int spanCount = 2;

    /* renamed from: d, reason: from kotlin metadata */
    private String tabId = BuildConfig.FLAVOR;

    /* renamed from: e, reason: from kotlin metadata */
    private String fromOptId = BuildConfig.FLAVOR;

    /* renamed from: g, reason: from kotlin metadata */
    private String hashtagTitle = BuildConfig.FLAVOR;

    /* renamed from: com.transsion.home.fragment.hashtag.HashTagPageFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HashTagPageFragment a(String str, String str2, String str3, String str4) {
            Intrinsics.h(str, "tabId");
            Intrinsics.h(str3, "hashtagTitle");
            HashTagPageFragment hashTagPageFragment = new HashTagPageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("arg_tab_id", str);
            bundle.putString("ugc_video_id", str4);
            bundle.putString("fromOptId", str2);
            bundle.putString("hashtag_title", str3);
            hashTagPageFragment.setArguments(bundle);
            return hashTagPageFragment;
        }
    }

    public interface b {
        void a(String str, Long l, String str2);
    }

    public static final class c implements rk.a {
        c() {
        }

        @Override // rk.a
        public void a(int i, long j, View view) {
            int size;
            HashTagItem hashTagItem;
            UGCVideo ugcVideo;
            Collection l;
            String str;
            com.transsion.home.adapter.hashtag.a aVar = HashTagPageFragment.this.adapter;
            if (aVar != null && (size = aVar.getData().size()) > 0) {
                int i2 = aVar.getItemViewType(0) == HashTagItemType.TAGS.ordinal() ? 1 : 0;
                int i3 = i - i2;
                if (i3 < 0 || i3 >= size - i2 || (hashTagItem = (HashTagItem) CollectionsKt.l0(aVar.getData(), i3)) == null || (ugcVideo = hashTagItem.getUgcVideo()) == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("browse_duration", String.valueOf(j));
                hashMap.put("module_name", "item");
                HashTagItem hashTagItem2 = (HashTagItem) CollectionsKt.k0(aVar.getData());
                List<UGCVideoHashTag> selectedTags = hashTagItem2 != null ? hashTagItem2.getSelectedTags() : null;
                if (selectedTags != null) {
                    l = new ArrayList();
                    Iterator<T> it = selectedTags.iterator();
                    while (it.hasNext()) {
                        String tag = ((UGCVideoHashTag) it.next()).getTag();
                        if (tag != null) {
                            l.add(tag);
                        }
                    }
                } else {
                    l = CollectionsKt.l();
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("sort", HashTagPageFragment.this.tabId);
                linkedHashMap.put("selected_tags", l);
                hashMap.put("rank_category", com.blankj.utilcode.util.o.j(linkedHashMap));
                hashMap.put("from_opt_id", HashTagPageFragment.this.fromOptId);
                hashMap.put("title", HashTagPageFragment.this.hashtagTitle);
                UGCVideoBelongToCollection belongToCollection = ugcVideo.getBelongToCollection();
                if (belongToCollection == null || (str = belongToCollection.getCollectionId()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                hashMap.put("belong_to_collection_id", str);
                hashMap.put("content_id", String.valueOf(ugcVideo.getUgcVideoId()));
                hashMap.put("refer_subject_id", String.valueOf(ugcVideo.getSubjectId()));
                hashMap.put("content_type", "ugc_video");
                hashMap.put("position", String.valueOf(i3));
                hashMap.put("ops", String.valueOf(ugcVideo.getOps()));
                com.transsion.baselib.helper.a.a.e("/home/hashtag", hashMap);
            }
        }
    }

    public static final class d implements a.InterfaceC0027a {
        d() {
        }

        @Override // com.transsion.home.adapter.hashtag.a.InterfaceC0027a
        public void a(UGCVideo uGCVideo, int i) {
            String str;
            Intrinsics.h(uGCVideo, "uGCVideo");
            gu.c.i(uGCVideo, (Integer) null, (String) null, 3, (Object) null);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "item");
            hashMap.put("rank_category", "item");
            hashMap.put("from_opt_id", HashTagPageFragment.this.fromOptId);
            UGCVideoBelongToCollection belongToCollection = uGCVideo.getBelongToCollection();
            String str2 = BuildConfig.FLAVOR;
            if (belongToCollection == null || (str = belongToCollection.getCollectionId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("belong_to_collection_id", str);
            String ugcVideoId = uGCVideo.getUgcVideoId();
            if (ugcVideoId == null) {
                ugcVideoId = BuildConfig.FLAVOR;
            }
            hashMap.put("content_id", ugcVideoId);
            String subjectId = uGCVideo.getSubjectId();
            if (subjectId == null) {
                subjectId = BuildConfig.FLAVOR;
            }
            hashMap.put("refer_subject_id", subjectId);
            hashMap.put("content_type", "ugc_video");
            hashMap.put("position", String.valueOf(i));
            String ops = uGCVideo.getOps();
            if (ops != null) {
                str2 = ops;
            }
            hashMap.put("ops", str2);
            com.transsion.baselib.helper.a.a.f("/home/hashtag", hashMap);
        }

        @Override // com.transsion.home.adapter.hashtag.a.InterfaceC0027a
        public void b(UGCVideoHashTag uGCVideoHashTag) {
            List data;
            HashTagItem hashTagItem;
            UGCVideo ugcVideo;
            String ops;
            Intrinsics.h(uGCVideoHashTag, "tag");
            HashTagPageFragment.this.t0().x(uGCVideoHashTag);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "item");
            hashMap.put("rank_category", "btn");
            hashMap.put("from_opt_id", HashTagPageFragment.this.fromOptId);
            String tag = uGCVideoHashTag.getTag();
            String str = BuildConfig.FLAVOR;
            if (tag == null) {
                tag = BuildConfig.FLAVOR;
            }
            hashMap.put("click_tag", tag);
            String tagType = uGCVideoHashTag.getTagType();
            if (tagType == null) {
                tagType = BuildConfig.FLAVOR;
            }
            hashMap.put("click_tag_type", tagType);
            com.transsion.home.adapter.hashtag.a aVar = HashTagPageFragment.this.adapter;
            if (aVar != null && (data = aVar.getData()) != null && (hashTagItem = (HashTagItem) CollectionsKt.k0(data)) != null && (ugcVideo = hashTagItem.getUgcVideo()) != null && (ops = ugcVideo.getOps()) != null) {
                str = ops;
            }
            hashMap.put("ops", str);
            com.transsion.baselib.helper.a.a.f("/home/hashtag", hashMap);
        }
    }

    public static final class e extends RecyclerView.r {
        e() {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i, i2);
            HashTagPageFragment.this.r0();
        }
    }

    public static final class f extends GridLayoutManager.c {
        final /* synthetic */ RecyclerView e;

        f(RecyclerView recyclerView) {
            this.e = recyclerView;
        }

        public int f(int i) {
            RecyclerView.Adapter adapter = this.e.getAdapter();
            Integer valueOf = adapter != null ? Integer.valueOf(adapter.getItemViewType(i)) : null;
            return (valueOf != null && valueOf.intValue() == HashTagItemType.TAGS.ordinal()) ? 2 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(final HashTagPageFragment hashTagPageFragment, RefreshBaseDto refreshBaseDto) {
        t6.f h0;
        o oVar;
        RecyclerView recyclerView;
        com.transsion.home.adapter.hashtag.a aVar;
        t6.f h02;
        Long l;
        String str;
        RecyclerView recyclerView2;
        UGCVideo ugcVideo;
        List data;
        SwipeRefreshLayout swipeRefreshLayout;
        o oVar2;
        SwipeRefreshLayout swipeRefreshLayout2;
        t6.f h03;
        com.transsion.home.adapter.hashtag.a aVar2;
        t6.f h04;
        List data2;
        SwipeRefreshLayout swipeRefreshLayout3;
        o oVar3;
        SwipeRefreshLayout swipeRefreshLayout4;
        SwipeRefreshLayout swipeRefreshLayout5;
        List list;
        a.a.f(wf.a.a, "HashTagPageFragment", "observe data: filterId=" + hashTagPageFragment.tabId + ", isRefresh=" + (refreshBaseDto != null ? Boolean.valueOf(refreshBaseDto.getIsRefresh()) : null) + ", dataSize=" + ((refreshBaseDto == null || (list = (List) refreshBaseDto.getData()) == null) ? null : Integer.valueOf(list.size())) + ", code=" + (refreshBaseDto != null ? refreshBaseDto.getCode() : null), false, 4, (Object) null);
        o oVar4 = (o) hashTagPageFragment.getMViewBinding();
        if (oVar4 != null && (swipeRefreshLayout5 = oVar4.f) != null) {
            swipeRefreshLayout5.setRefreshing(false);
        }
        if (refreshBaseDto == null) {
            return Unit.a;
        }
        if (!Intrinsics.c(refreshBaseDto.getCode(), "0")) {
            if (refreshBaseDto.getIsRefresh()) {
                o oVar5 = (o) hashTagPageFragment.getMViewBinding();
                if (oVar5 != null && (swipeRefreshLayout3 = oVar5.f) != null && swipeRefreshLayout3.isRefreshing() && (oVar3 = (o) hashTagPageFragment.getMViewBinding()) != null && (swipeRefreshLayout4 = oVar3.f) != null) {
                    swipeRefreshLayout4.setRefreshing(false);
                }
            } else {
                com.transsion.home.adapter.hashtag.a aVar3 = hashTagPageFragment.adapter;
                if (aVar3 != null && (h03 = aVar3.h0()) != null && h03.r() && (aVar2 = hashTagPageFragment.adapter) != null && (h04 = aVar2.h0()) != null) {
                    h04.v();
                }
            }
            com.transsion.home.adapter.hashtag.a aVar4 = hashTagPageFragment.adapter;
            if (aVar4 == null || (data2 = aVar4.getData()) == null || data2.size() != 0) {
                if (yg.l.a.e()) {
                    fh.b.a.d(R.string.str_ad_video_error_tips);
                } else {
                    fh.b.a.d(com.tn.lib.widget.R.string.no_network_toast);
                }
                return Unit.a;
            }
            if (yg.l.a.e()) {
                hashTagPageFragment.J0();
            } else {
                hashTagPageFragment.G0();
            }
            return Unit.a;
        }
        List list2 = (List) refreshBaseDto.getData();
        if (list2 != null) {
            if (refreshBaseDto.getIsRefresh()) {
                o oVar6 = (o) hashTagPageFragment.getMViewBinding();
                if (oVar6 != null && (swipeRefreshLayout = oVar6.f) != null && swipeRefreshLayout.isRefreshing() && (oVar2 = (o) hashTagPageFragment.getMViewBinding()) != null && (swipeRefreshLayout2 = oVar2.f) != null) {
                    swipeRefreshLayout2.setRefreshing(false);
                }
                com.transsion.home.adapter.hashtag.a aVar5 = hashTagPageFragment.adapter;
                if (aVar5 == null || (data = aVar5.getData()) == null || !data.isEmpty() || hashTagPageFragment.hasRecordedFirstLoadDuration || hashTagPageFragment.firstLoadStartTimeMillis <= 0) {
                    l = null;
                } else {
                    l = Long.valueOf(System.currentTimeMillis() - hashTagPageFragment.firstLoadStartTimeMillis);
                    hashTagPageFragment.hasRecordedFirstLoadDuration = true;
                }
                String str2 = hashTagPageFragment.tabId;
                HashTagItem hashTagItem = (HashTagItem) CollectionsKt.k0(list2);
                if (hashTagItem == null || (ugcVideo = hashTagItem.getUgcVideo()) == null || (str = ugcVideo.getOps()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                hashTagPageFragment.E0(str2, l, str);
                com.transsion.home.adapter.hashtag.a aVar6 = hashTagPageFragment.adapter;
                if (aVar6 != null) {
                    aVar6.n1(list2);
                }
                if (list2.isEmpty()) {
                    hashTagPageFragment.J0();
                } else {
                    hashTagPageFragment.u0();
                }
                o oVar7 = (o) hashTagPageFragment.getMViewBinding();
                if (oVar7 != null && (recyclerView2 = oVar7.e) != null) {
                    recyclerView2.post(new Runnable() { // from class: com.transsion.home.fragment.hashtag.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            HashTagPageFragment.B0(HashTagPageFragment.this);
                        }
                    });
                }
            } else {
                List list3 = list2;
                if (!list3.isEmpty()) {
                    com.transsion.home.adapter.hashtag.a aVar7 = hashTagPageFragment.adapter;
                    if (aVar7 != null) {
                        aVar7.q(list3);
                    }
                    hashTagPageFragment.u0();
                }
                com.transsion.home.adapter.hashtag.a aVar8 = hashTagPageFragment.adapter;
                if (aVar8 != null && (h0 = aVar8.h0()) != null && h0.r() && (oVar = (o) hashTagPageFragment.getMViewBinding()) != null && (recyclerView = oVar.e) != null) {
                    recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.hashtag.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            HashTagPageFragment.C0(HashTagPageFragment.this);
                        }
                    }, 300L);
                }
            }
            if (!hashTagPageFragment.t0().q(hashTagPageFragment.tabId) && (aVar = hashTagPageFragment.adapter) != null && (h02 = aVar.h0()) != null) {
                t6.f.u(h02, false, 1, (Object) null);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(HashTagPageFragment hashTagPageFragment) {
        hashTagPageFragment.r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(HashTagPageFragment hashTagPageFragment) {
        t6.f h0;
        com.transsion.home.adapter.hashtag.a aVar = hashTagPageFragment.adapter;
        if (aVar == null || (h0 = aVar.h0()) == null) {
            return;
        }
        h0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(HashTagPageFragment hashTagPageFragment, Boolean bool) {
        if (Intrinsics.c(bool, Boolean.TRUE)) {
            hashTagPageFragment.showLoadingView();
        } else {
            hashTagPageFragment.v0();
        }
        return Unit.a;
    }

    private final void E0(String tabId, Long loadDuration, String ops) {
        b bVar = this.loadDurationCallback;
        if (bVar != null) {
            bVar.a(tabId, loadDuration, ops);
        }
    }

    private final void G0() {
        ViewStub viewStub;
        a.a.f(wf.a.a, "HashTagPageFragment", "showNoNetworkView", false, 4, (Object) null);
        if (this.mNoNetworkView == null) {
            o oVar = (o) getMViewBinding();
            this.mNoNetworkView = (oVar == null || (viewStub = oVar.c) == null) ? null : viewStub.inflate();
        }
        View view = this.mNoNetworkView;
        if (view != null) {
            uf.c.k(view);
            final NoNetworkBigView findViewById = view.findViewById(com.transsion.home.R.id.state_view);
            if (findViewById != null) {
                NoNetworkBigView.showTitle$default(findViewById, false, (String) null, 2, (Object) null);
                findViewById.retry(new Function0() { // from class: com.transsion.home.fragment.hashtag.k
                    public final Object invoke() {
                        Unit H0;
                        H0 = HashTagPageFragment.H0(findViewById, this);
                        return H0;
                    }
                });
                findViewById.goToSetting(new Function0() { // from class: com.transsion.home.fragment.hashtag.l
                    public final Object invoke() {
                        Unit I0;
                        I0 = HashTagPageFragment.I0();
                        return I0;
                    }
                });
            }
            com.tn.lib.view.o.a("home_hashtag_page");
        }
        View view2 = this.skeletonScreenView;
        if (view2 != null) {
            uf.c.g(view2);
        }
        View view3 = this.mNoResultView;
        if (view3 != null) {
            uf.c.g(view3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(NoNetworkBigView noNetworkBigView, HashTagPageFragment hashTagPageFragment) {
        uf.c.g(noNetworkBigView);
        hashTagPageFragment.t0().A(hashTagPageFragment.tabId);
        com.tn.lib.view.o.b("home_hashtag_page");
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0() {
        com.tn.lib.view.o.c("home_hashtag_page");
        return Unit.a;
    }

    private final void J0() {
        ViewStub viewStub;
        a.a.f(wf.a.a, "HashTagPageFragment", "showNoResultView", false, 4, (Object) null);
        if (this.mNoResultView == null) {
            o oVar = (o) getMViewBinding();
            this.mNoResultView = (oVar == null || (viewStub = oVar.d) == null) ? null : viewStub.inflate();
        }
        final View view = this.mNoResultView;
        if (view != null) {
            uf.c.k(view);
            TextView textView = (TextView) view.findViewById(com.transsion.home.R.id.tv_no_result);
            if (textView != null) {
                textView.setText(getString(com.transsion.home.R.string.no_filter_result));
            }
            View findViewById = view.findViewById(com.transsion.home.R.id.tv_reset);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.hashtag.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        HashTagPageFragment.K0(view, this, view2);
                    }
                });
            }
        }
        View view2 = this.skeletonScreenView;
        if (view2 != null) {
            uf.c.g(view2);
        }
        View view3 = this.mNoNetworkView;
        if (view3 != null) {
            uf.c.g(view3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(View view, HashTagPageFragment hashTagPageFragment, View view2) {
        uf.c.g(view);
        hashTagPageFragment.t0().A(hashTagPageFragment.tabId);
    }

    private final void L0() {
        TnTextView tnTextView;
        TnTextView tnTextView2;
        com.transsion.home.adapter.hashtag.a aVar = this.adapter;
        if (aVar == null || aVar.getData().isEmpty() || aVar.getItemViewType(0) != HashTagItemType.TAGS.ordinal()) {
            return;
        }
        HashTagItem hashTagItem = (HashTagItem) CollectionsKt.k0(aVar.getData());
        List<UGCVideoHashTag> selectedTags = hashTagItem != null ? hashTagItem.getSelectedTags() : null;
        List<UGCVideoHashTag> list = selectedTags;
        if (list == null || list.isEmpty()) {
            o oVar = (o) getMViewBinding();
            if (oVar == null || (tnTextView = oVar.g) == null) {
                return;
            }
            uf.c.g(tnTextView);
            return;
        }
        String s0 = CollectionsKt.s0(selectedTags, " · ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.transsion.home.fragment.hashtag.h
            public final Object invoke(Object obj) {
                CharSequence M0;
                M0 = HashTagPageFragment.M0((UGCVideoHashTag) obj);
                return M0;
            }
        }, 30, (Object) null);
        a.a.f(wf.a.a, "HashTagPageFragment", "showSelectedTagsBar: tagsText=" + s0, false, 4, (Object) null);
        o oVar2 = (o) getMViewBinding();
        if (oVar2 == null || (tnTextView2 = oVar2.g) == null) {
            return;
        }
        tnTextView2.setText(s0);
        uf.c.k(tnTextView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence M0(UGCVideoHashTag uGCVideoHashTag) {
        Intrinsics.h(uGCVideoHashTag, "it");
        String title = uGCVideoHashTag.getTitle();
        if (title != null) {
            return title;
        }
        String tag = uGCVideoHashTag.getTag();
        return tag != null ? tag : BuildConfig.FLAVOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0() {
        com.transsion.home.adapter.hashtag.a aVar;
        TnTextView tnTextView;
        TnTextView tnTextView2;
        RecyclerView recyclerView;
        o oVar = (o) getMViewBinding();
        RecyclerView.m layoutManager = (oVar == null || (recyclerView = oVar.e) == null) ? null : recyclerView.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager == null || (aVar = this.adapter) == null) {
            return;
        }
        if (aVar.getData().isEmpty() || aVar.getItemViewType(0) != HashTagItemType.TAGS.ordinal()) {
            o oVar2 = (o) getMViewBinding();
            if (oVar2 != null && (tnTextView = oVar2.g) != null) {
                uf.c.g(tnTextView);
            }
            this.tagsFullyInvisible = false;
            return;
        }
        boolean z = gridLayoutManager.findFirstVisibleItemPosition() > 0;
        if (z != this.tagsFullyInvisible) {
            this.tagsFullyInvisible = z;
            if (z) {
                L0();
                return;
            }
            o oVar3 = (o) getMViewBinding();
            if (oVar3 == null || (tnTextView2 = oVar3.g) == null) {
                return;
            }
            uf.c.g(tnTextView2);
        }
    }

    private final void showLoadingView() {
        List data;
        View view;
        ViewStub viewStub;
        a.a.f(wf.a.a, "HashTagPageFragment", "showLoadingView", false, 4, (Object) null);
        if (this.skeletonScreenView == null) {
            o oVar = (o) getMViewBinding();
            this.skeletonScreenView = (oVar == null || (viewStub = oVar.b) == null) ? null : viewStub.inflate();
        }
        com.transsion.home.adapter.hashtag.a aVar = this.adapter;
        if (aVar != null && (data = aVar.getData()) != null && data.isEmpty() && (view = this.skeletonScreenView) != null) {
            uf.c.k(view);
        }
        if (!this.hasRecordedFirstLoadDuration && this.firstLoadStartTimeMillis == 0) {
            this.firstLoadStartTimeMillis = System.currentTimeMillis();
        }
        View view2 = this.mNoNetworkView;
        if (view2 != null) {
            uf.c.g(view2);
        }
        View view3 = this.mNoResultView;
        if (view3 != null) {
            uf.c.g(view3);
        }
        View view4 = this.mNoResultView;
        if (view4 != null) {
            uf.c.g(view4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashTagViewModel t0() {
        return (HashTagViewModel) this.viewModel.getValue();
    }

    private final void u0() {
        View view = this.skeletonScreenView;
        if (view != null) {
            uf.c.g(view);
        }
        View view2 = this.mNoNetworkView;
        if (view2 != null) {
            uf.c.g(view2);
        }
        View view3 = this.mNoResultView;
        if (view3 != null) {
            uf.c.g(view3);
        }
    }

    private final void v0() {
        View view = this.skeletonScreenView;
        if (view != null) {
            uf.c.g(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(final HashTagPageFragment hashTagPageFragment) {
        RecyclerView recyclerView;
        if (yg.l.a.e()) {
            hashTagPageFragment.t0().u(hashTagPageFragment.tabId);
            return;
        }
        fh.b.a.d(com.tn.lib.widget.R.string.no_network_toast);
        o oVar = (o) hashTagPageFragment.getMViewBinding();
        if (oVar == null || (recyclerView = oVar.e) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.hashtag.g
            @Override // java.lang.Runnable
            public final void run() {
                HashTagPageFragment.x0(HashTagPageFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(HashTagPageFragment hashTagPageFragment) {
        t6.f h0;
        com.transsion.home.adapter.hashtag.a aVar = hashTagPageFragment.adapter;
        if (aVar == null || (h0 = aVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(HashTagPageFragment hashTagPageFragment) {
        rk.b bVar;
        hashTagPageFragment.u0();
        bVar = m.a;
        if (bVar != null) {
            bVar.e();
        }
        hashTagPageFragment.t0().A(hashTagPageFragment.tabId);
    }

    private final void z0() {
        t0().s(this.tabId).j(getViewLifecycleOwner(), new m.a(new Function1() { // from class: com.transsion.home.fragment.hashtag.e
            public final Object invoke(Object obj) {
                Unit A0;
                A0 = HashTagPageFragment.A0(HashTagPageFragment.this, (RefreshBaseDto) obj);
                return A0;
            }
        }));
        t0().v(this.tabId).j(getViewLifecycleOwner(), new m.a(new Function1() { // from class: com.transsion.home.fragment.hashtag.f
            public final Object invoke(Object obj) {
                Unit D0;
                D0 = HashTagPageFragment.D0(HashTagPageFragment.this, (Boolean) obj);
                return D0;
            }
        }));
    }

    public final void F0(b bVar) {
        this.loadDurationCallback = bVar;
    }

    public void initView(View view, Bundle savedInstanceState) {
        String str;
        String str2;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        RecyclerView recyclerView;
        rk.b bVar;
        rk.b bVar2;
        t6.f h0;
        t6.f h02;
        t6.f h03;
        String string;
        Intrinsics.h(view, "view");
        Bundle arguments = getArguments();
        String str3 = BuildConfig.FLAVOR;
        if (arguments == null || (str = arguments.getString("arg_tab_id")) == null) {
            str = BuildConfig.FLAVOR;
        }
        this.tabId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("fromOptId")) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        this.fromOptId = str2;
        Bundle arguments3 = getArguments();
        this.ugcVideoId = arguments3 != null ? arguments3.getString("ugc_video_id") : null;
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (string = arguments4.getString("hashtag_title")) != null) {
            str3 = string;
        }
        this.hashtagTitle = str3;
        a.a.f(wf.a.a, "HashTagPageFragment", "initView: filterId=" + this.tabId, false, 4, (Object) null);
        o oVar = (o) getMViewBinding();
        if (oVar != null && (recyclerView = oVar.e) != null) {
            OffsetGridLayoutManager offsetGridLayoutManager = new OffsetGridLayoutManager(recyclerView.getContext(), this.spanCount, 1, false);
            offsetGridLayoutManager.d0(new f(recyclerView));
            recyclerView.setLayoutManager(offsetGridLayoutManager);
            rk.b bVar3 = new rk.b(0.6f, new c(), false, 4, null);
            bVar3.l(2);
            m.a = bVar3;
            bVar = m.a;
            Intrinsics.e(bVar);
            recyclerView.addOnScrollListener(bVar);
            d dVar = new d();
            bVar2 = m.a;
            com.transsion.home.adapter.hashtag.a aVar = new com.transsion.home.adapter.hashtag.a(dVar, bVar2);
            this.adapter = aVar;
            recyclerView.setAdapter(aVar);
            com.transsion.home.adapter.hashtag.a aVar2 = this.adapter;
            if (aVar2 != null && (h03 = aVar2.h0()) != null) {
                h03.z(true);
            }
            com.transsion.home.adapter.hashtag.a aVar3 = this.adapter;
            if (aVar3 != null && (h02 = aVar3.h0()) != null) {
                h02.y(true);
            }
            com.transsion.home.adapter.hashtag.a aVar4 = this.adapter;
            if (aVar4 != null && (h0 = aVar4.h0()) != null) {
                h0.D(new r6.f() { // from class: com.transsion.home.fragment.hashtag.b
                    public final void a() {
                        HashTagPageFragment.w0(HashTagPageFragment.this);
                    }
                });
            }
            if (recyclerView.getItemDecorationCount() < 1) {
                recyclerView.addItemDecoration(new a(a0.a(0.0f), a0.a(4.0f), a0.a(8.0f), a0.a(8.0f)));
            }
            recyclerView.addOnScrollListener(new e());
        }
        o oVar2 = (o) getMViewBinding();
        if (oVar2 != null && (swipeRefreshLayout2 = oVar2.f) != null) {
            swipeRefreshLayout2.setEnabled(true);
        }
        o oVar3 = (o) getMViewBinding();
        if (oVar3 != null && (swipeRefreshLayout = oVar3.f) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.home.fragment.hashtag.d
                public final void a() {
                    HashTagPageFragment.y0(HashTagPageFragment.this);
                }
            });
        }
        z0();
    }

    public void lazyLoadData() {
    }

    public void onPause() {
        rk.b bVar;
        super.onPause();
        bVar = m.a;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void onResume() {
        com.transsion.home.adapter.hashtag.a aVar;
        List data;
        super.onResume();
        View view = this.mNoNetworkView;
        if (view == null || !uf.c.i(view) || !yg.l.a.e() || (aVar = this.adapter) == null || (data = aVar.getData()) == null || !data.isEmpty()) {
            return;
        }
        a.a.f(wf.a.a, "HashTagPageFragment", "onResume: network recovered, auto refresh", false, 4, (Object) null);
        View view2 = this.mNoNetworkView;
        if (view2 != null) {
            uf.c.g(view2);
        }
        t0().A(this.tabId);
    }

    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public o getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        o c2 = o.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
