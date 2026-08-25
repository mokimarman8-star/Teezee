package com.transsion.search_pugc;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import androidx.lifecycle.w;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.shorttv.widget.ShortTVCollectionView;
import com.transsion.search_pugc.bean.SearchResultItem;
import com.transsion.search_pugc.bean.SearchSuggestItem;
import com.transsion.search_pugc.bean.SearchTab;
import com.transsion.search_pugc.bean.SecondTab;
import com.transsion.search_pugc.fragment.hot.SearchHotFragment;
import com.transsion.ugcvideodetail.api.bean.UGCCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVerticalRank;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g {
    public static final b g = new b(null);
    private static final Map h = new LinkedHashMap();
    private static final Lazy i = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.f
        public final Object invoke() {
            g d;
            d = g.d();
            return d;
        }
    });
    private final u a;
    private final Map b;
    private final String c;
    private final String d;
    private String e;
    private String f;

    private static final class a implements u {
        public static final a a;
        private static final w b;

        static {
            a aVar = new a();
            a = aVar;
            b = new w(aVar);
        }

        private a() {
        }

        public Lifecycle getLifecycle() {
            return b;
        }
    }

    public static final class b {

        public static final class a implements androidx.lifecycle.f {
            a() {
            }

            public /* synthetic */ void onCreate(u uVar) {
                androidx.lifecycle.e.a(this, uVar);
            }

            public void onDestroy(u uVar) {
                Intrinsics.h(uVar, "owner");
                g.h.remove(uVar);
            }

            public /* synthetic */ void onPause(u uVar) {
                androidx.lifecycle.e.c(this, uVar);
            }

            public /* synthetic */ void onResume(u uVar) {
                androidx.lifecycle.e.d(this, uVar);
            }

            public /* synthetic */ void onStart(u uVar) {
                androidx.lifecycle.e.e(this, uVar);
            }

            public /* synthetic */ void onStop(u uVar) {
                androidx.lifecycle.e.f(this, uVar);
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final g c() {
            return (g) g.i.getValue();
        }

        public final g a(Context context) {
            if (context != null) {
                g b = context instanceof u ? g.g.b((u) context) : g.g.c();
                if (b != null) {
                    return b;
                }
            }
            return c();
        }

        public final g b(u uVar) {
            g gVar = (g) g.h.get(uVar);
            return gVar == null ? c() : gVar;
        }

        public final g d(u uVar) {
            Intrinsics.h(uVar, "lifecycleOwner");
            Map map = g.h;
            Object obj = map.get(uVar);
            if (obj == null) {
                obj = new g(uVar, null);
                uVar.getLifecycle().a(new a());
                map.put(uVar, obj);
            }
            return (g) obj;
        }
    }

    private g(u uVar) {
        this.a = uVar;
        this.b = new LinkedHashMap();
        this.c = qi.h.a.h();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "toString(...)");
        this.d = uuid;
    }

    public /* synthetic */ g(u uVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(uVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g d() {
        return new g(a.a);
    }

    private final HashMap h() {
        HashMap hashMap = new HashMap();
        hashMap.put("search_id", this.d);
        return hashMap;
    }

    public final void A(SearchSuggestItem searchSuggestItem, Integer num, String str, String str2) {
        String str3;
        Intrinsics.h(str, "keyWord");
        HashMap h2 = h();
        h2.put("keyword", str);
        if (searchSuggestItem == null || (str3 = searchSuggestItem.getWord()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        h2.put("title", str3);
        h2.put("position", String.valueOf(num));
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        h2.put("ops", str2);
        qi.h.a.z("/ugc_search/search_suggest", h2);
    }

    public final void B(SearchSuggestItem searchSuggestItem, int i2, String str, String str2) {
        String str3;
        Intrinsics.h(str, "keyWord");
        HashMap h2 = h();
        h2.put("keyword", str);
        if (searchSuggestItem == null || (str3 = searchSuggestItem.getWord()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        h2.put("title", str3);
        h2.put("position", String.valueOf(i2));
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        h2.put("ops", str2);
        qi.h.a.o("/ugc_search/search_suggest", h2);
    }

    public final void C(String str, SearchTab searchTab, String str2) {
        String str3;
        HashMap h2 = h();
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        h2.put("keyword", str);
        if (searchTab == null || (str3 = searchTab.getName()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        h2.put("page_tab_name", str3);
        h2.put("module_name", "result_tab_click");
        h2.put("search_from", String.valueOf(this.e));
        h2.put("content_type", "ugc_video");
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        h2.put("ops", str2);
        com.transsion.baselib.helper.a.a.f("/ugc_search/search_result", h2);
    }

    public final void D(qi.b bVar) {
        if (bVar != null) {
            bVar.g().put("search_from", this.e);
            bVar.g().put("keyword", this.f);
        }
    }

    public final void E(String str, String str2) {
        Intrinsics.h(str, "searchFrom");
        Intrinsics.h(str2, "keyword");
        this.e = str;
        this.f = str2;
    }

    public final String e() {
        return this.f;
    }

    public final String f() {
        return this.c;
    }

    public final qi.b g(String str) {
        Intrinsics.h(str, "pageName");
        qi.b bVar = new qi.b(str, false, 2, null);
        bVar.g().put("search_id", this.d);
        return bVar;
    }

    public final void i(qi.b bVar) {
        Long l;
        if (bVar == null || (l = (Long) this.b.remove(bVar)) == null) {
            return;
        }
        bVar.g().put("load_duration", String.valueOf(System.currentTimeMillis() - l.longValue()));
    }

    public final void j(qi.b bVar) {
        if (bVar != null) {
            Map map = this.b;
            Object obj = map.get(bVar);
            if (obj == null) {
                obj = Long.valueOf(System.currentTimeMillis());
                map.put(bVar, obj);
            }
            ((Number) obj).longValue();
        }
    }

    public final void k(UGCVideo uGCVideo, int i2, String str, SearchTab searchTab, SecondTab secondTab) {
        String str2;
        String str3;
        String str4;
        String ops;
        UGCVideoBelongToCollection belongToCollection;
        Intrinsics.h(searchTab, "tab");
        HashMap h2 = h();
        String str5 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        h2.put("keyword", str);
        h2.put("position", String.valueOf(i2));
        String valueOf = String.valueOf(searchTab.getName());
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h2.put("page_tab_name", valueOf);
        h2.put("content_type", "ugc_video");
        h2.put("search_from", String.valueOf(this.e));
        h2.put("module_name", "item");
        if (uGCVideo == null || (str2 = uGCVideo.getUgcVideoId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        h2.put("content_id", str2);
        if (uGCVideo == null || (str3 = uGCVideo.getSubjectId()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        h2.put("refer_subject_id", str3);
        if (uGCVideo == null || (belongToCollection = uGCVideo.getBelongToCollection()) == null || (str4 = belongToCollection.getCollectionId()) == null) {
            str4 = BuildConfig.FLAVOR;
        }
        h2.put("belong_to_collection_id", str4);
        if (uGCVideo != null && (ops = uGCVideo.getOps()) != null) {
            str5 = ops;
        }
        h2.put("ops", str5);
        com.transsion.baselib.helper.a.a.e("/ugc_search/search_result", h2);
    }

    public final void l(UGCVideo uGCVideo, int i2, String str, SearchTab searchTab, SecondTab secondTab) {
        String str2;
        String str3;
        String str4;
        String ops;
        UGCVideoBelongToCollection belongToCollection;
        Intrinsics.h(searchTab, "tab");
        HashMap h2 = h();
        String str5 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        h2.put("keyword", str);
        h2.put("position", String.valueOf(i2));
        String valueOf = String.valueOf(searchTab.getName());
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h2.put("page_tab_name", valueOf);
        h2.put("content_type", "ugc_video");
        h2.put("search_from", String.valueOf(this.e));
        h2.put("module_name", "item");
        if (uGCVideo == null || (str2 = uGCVideo.getUgcVideoId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        h2.put("content_id", str2);
        if (uGCVideo == null || (str3 = uGCVideo.getSubjectId()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        h2.put("refer_subject_id", str3);
        if (uGCVideo == null || (belongToCollection = uGCVideo.getBelongToCollection()) == null || (str4 = belongToCollection.getCollectionId()) == null) {
            str4 = BuildConfig.FLAVOR;
        }
        h2.put("belong_to_collection_id", str4);
        if (uGCVideo != null && (ops = uGCVideo.getOps()) != null) {
            str5 = ops;
        }
        h2.put("ops", str5);
        com.transsion.baselib.helper.a.a.f("/ugc_search/search_result", h2);
    }

    public final void m() {
        HashMap h2 = h();
        h2.put("module_name", "history_delete");
        com.transsion.baselib.helper.a.a.f(SearchHotFragment.PAGE_NAME, h2);
    }

    public final void n(boolean z) {
        HashMap h2 = h();
        h2.put("isExpand", String.valueOf(z));
        h2.put("module_name", "history_expand");
        com.transsion.baselib.helper.a.a.f(SearchHotFragment.PAGE_NAME, h2);
    }

    public final void o(String str, int i2) {
        HashMap h2 = h();
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        h2.put("keyword", str);
        h2.put("position", String.valueOf(i2));
        h2.put("module_name", "history_browse");
        h2.put("content_type", "ugc_video");
        com.transsion.baselib.helper.a.a.a(SearchHotFragment.PAGE_NAME, h2);
    }

    public final void p(String str, int i2) {
        Intrinsics.h(str, "keyWord");
        HashMap h2 = h();
        h2.put("keyword", str);
        h2.put("position", String.valueOf(i2));
        h2.put("module_name", "history_click");
        h2.put("content_type", "ugc_video");
        com.transsion.baselib.helper.a.a.f(SearchHotFragment.PAGE_NAME, h2);
    }

    public final void q(String str, int i2) {
        HashMap h2 = h();
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        h2.put("keyword", str);
        h2.put("position", String.valueOf(i2));
        h2.put("module_name", "hot_word_browse");
        h2.put("content_type", "ugc_video");
        com.transsion.baselib.helper.a.a.e(SearchHotFragment.PAGE_NAME, h2);
    }

    public final void r(String str, int i2) {
        Intrinsics.h(str, "keyword");
        HashMap h2 = h();
        h2.put("keyword", str);
        h2.put("position", String.valueOf(i2));
        h2.put("module_name", "hot_word_click");
        h2.put("content_type", "ugc_video");
        com.transsion.baselib.helper.a.a.f(SearchHotFragment.PAGE_NAME, h2);
    }

    public final void s(UGCVideo uGCVideo, int i2, String str, int i3) {
        String str2;
        Intrinsics.h(uGCVideo, "ugcVideo");
        Intrinsics.h(str, "tabName");
        HashMap h2 = h();
        h2.put("module_name", "hot_rank_browse");
        String ugcVideoId = uGCVideo.getUgcVideoId();
        String str3 = BuildConfig.FLAVOR;
        if (ugcVideoId == null) {
            ugcVideoId = BuildConfig.FLAVOR;
        }
        h2.put("content_id", ugcVideoId);
        h2.put("position", String.valueOf(i2));
        String subjectId = uGCVideo.getSubjectId();
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        h2.put("refer_subject_id", subjectId);
        UGCVideoBelongToCollection belongToCollection = uGCVideo.getBelongToCollection();
        if (belongToCollection == null || (str2 = belongToCollection.getCollectionId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        h2.put("belong_to_collection_id", str2);
        h2.put("content_type", "ugc_video");
        h2.put("page_tab_name", str);
        String ops = uGCVideo.getOps();
        if (ops != null) {
            str3 = ops;
        }
        h2.put("ops", str3);
        com.transsion.baselib.helper.a.a.a(SearchHotFragment.PAGE_NAME, h2);
    }

    public final void t(UGCVideo uGCVideo, int i2, String str, int i3) {
        String str2;
        Intrinsics.h(uGCVideo, "ugcVideo");
        Intrinsics.h(str, "tabName");
        HashMap h2 = h();
        h2.put("module_name", "hot_rank_click");
        String ugcVideoId = uGCVideo.getUgcVideoId();
        String str3 = BuildConfig.FLAVOR;
        if (ugcVideoId == null) {
            ugcVideoId = BuildConfig.FLAVOR;
        }
        h2.put("content_id", ugcVideoId);
        h2.put("position", String.valueOf(i2));
        String subjectId = uGCVideo.getSubjectId();
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        h2.put("refer_subject_id", subjectId);
        UGCVideoBelongToCollection belongToCollection = uGCVideo.getBelongToCollection();
        if (belongToCollection == null || (str2 = belongToCollection.getCollectionId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        h2.put("belong_to_collection_id", str2);
        h2.put("content_type", "ugc_video");
        h2.put("page_tab_name", str);
        String ops = uGCVideo.getOps();
        if (ops != null) {
            str3 = ops;
        }
        h2.put("ops", str3);
        com.transsion.baselib.helper.a.a.f(SearchHotFragment.PAGE_NAME, h2);
    }

    public final void u(UGCVideo uGCVideo, int i2, String str, SearchTab searchTab, SecondTab secondTab) {
        String str2;
        Intrinsics.h(uGCVideo, "ugcVideo");
        Intrinsics.h(searchTab, "tab");
        HashMap h2 = h();
        String str3 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        h2.put("keyword", str);
        h2.put("position", String.valueOf(i2));
        h2.put("content_type", "ugc_video");
        h2.put("module_name", "item");
        String ugcVideoId = uGCVideo.getUgcVideoId();
        if (ugcVideoId == null) {
            ugcVideoId = BuildConfig.FLAVOR;
        }
        h2.put("content_id", ugcVideoId);
        String subjectId = uGCVideo.getSubjectId();
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        h2.put("refer_subject_id", subjectId);
        UGCVideoBelongToCollection belongToCollection = uGCVideo.getBelongToCollection();
        if (belongToCollection == null || (str2 = belongToCollection.getCollectionId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        h2.put("belong_to_collection_id", str2);
        String valueOf = String.valueOf(searchTab.getName());
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h2.put("page_tab_name", valueOf);
        h2.put("search_from", String.valueOf(this.e));
        String ops = uGCVideo.getOps();
        if (ops != null) {
            str3 = ops;
        }
        h2.put("ops", str3);
        com.transsion.baselib.helper.a.a.f("/ugc_search/search_result", h2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void v(SearchResultItem searchResultItem, int i2, long j, String str, SearchTab searchTab, SecondTab secondTab) {
        String str2;
        String str3;
        String str4;
        String ops;
        UGCVideoBelongToCollection belongToCollection;
        String collectionId;
        String str5;
        String title;
        String id;
        Intrinsics.h(searchResultItem, "item");
        HashMap h2 = h();
        String str6 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        h2.put("keyword", str);
        h2.put("position", String.valueOf(i2));
        String valueOf = String.valueOf(searchTab != null ? searchTab.getName() : null);
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h2.put("page_tab_name", valueOf);
        h2.put("content_type", "ugc_video");
        h2.put("search_from", String.valueOf(this.e));
        String topicType = searchResultItem.getTopicType();
        if (topicType != null) {
            switch (topicType.hashCode()) {
                case -1989652851:
                    if (topicType.equals("UGC_VIDEO")) {
                        h2.put("module_name", "item");
                        UGCVideo video = searchResultItem.getVideo();
                        if (video == null || (str2 = video.getUgcVideoId()) == null) {
                            str2 = BuildConfig.FLAVOR;
                        }
                        h2.put("content_id", str2);
                        UGCVideo video2 = searchResultItem.getVideo();
                        if (video2 == null || (str3 = video2.getSubjectId()) == null) {
                            str3 = BuildConfig.FLAVOR;
                        }
                        h2.put("refer_subject_id", str3);
                        UGCVideo video3 = searchResultItem.getVideo();
                        if (video3 == null || (belongToCollection = video3.getBelongToCollection()) == null || (str4 = belongToCollection.getCollectionId()) == null) {
                            str4 = BuildConfig.FLAVOR;
                        }
                        h2.put("belong_to_collection_id", str4);
                        UGCVideo video4 = searchResultItem.getVideo();
                        if (video4 != null && (ops = video4.getOps()) != null) {
                            str6 = ops;
                        }
                        h2.put("ops", str6);
                        break;
                    }
                    break;
                case 511113132:
                    if (topicType.equals("UGC_COLLECTION")) {
                        h2.put("module_name", ShortTVCollectionView.TYPE_COLLECTION);
                        UGCCollection collection = searchResultItem.getCollection();
                        if (collection != null && (collectionId = collection.getCollectionId()) != null) {
                            str6 = collectionId;
                        }
                        h2.put("content_id", str6);
                        h2.put("ops", searchResultItem.getOps());
                        break;
                    }
                    break;
                case 932115657:
                    if (topicType.equals("HASH_TAG")) {
                        h2.put("module_name", "hashtag");
                        UGCVideoHashTag hashTag = searchResultItem.getHashTag();
                        if (hashTag == null || (str5 = hashTag.getReferId()) == null) {
                            str5 = BuildConfig.FLAVOR;
                        }
                        h2.put("content_id", str5);
                        UGCVideoHashTag hashTag2 = searchResultItem.getHashTag();
                        if (hashTag2 != null && (title = hashTag2.getTitle()) != null) {
                            str6 = title;
                        }
                        h2.put("title", str6);
                        break;
                    }
                    break;
                case 2033770325:
                    if (topicType.equals("VERTICAL_RANK")) {
                        h2.put("module_name", "verticalRank");
                        UGCVerticalRank verticalRank = searchResultItem.getVerticalRank();
                        if (verticalRank != null && (id = verticalRank.getId()) != null) {
                            str6 = id;
                        }
                        h2.put("content_id", str6);
                        h2.put("ops", searchResultItem.getOps());
                        break;
                    }
                    break;
            }
        }
        com.transsion.baselib.helper.a.a.e("/ugc_search/search_result", h2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void w(SearchResultItem searchResultItem, int i2, String str, SearchTab searchTab, SecondTab secondTab) {
        String str2;
        String str3;
        String str4;
        String ops;
        UGCVideoBelongToCollection belongToCollection;
        String collectionId;
        String str5;
        String title;
        String str6;
        String ops2;
        Intrinsics.h(searchResultItem, "item");
        Intrinsics.h(searchTab, "tab");
        HashMap h2 = h();
        String str7 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        h2.put("keyword", str);
        h2.put("position", String.valueOf(i2));
        String valueOf = String.valueOf(searchTab.getName());
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h2.put("page_tab_name", valueOf);
        h2.put("content_type", "ugc_video");
        h2.put("search_from", String.valueOf(this.e));
        String topicType = searchResultItem.getTopicType();
        if (topicType != null) {
            switch (topicType.hashCode()) {
                case -1989652851:
                    if (topicType.equals("UGC_VIDEO")) {
                        h2.put("module_name", "item");
                        UGCVideo video = searchResultItem.getVideo();
                        if (video == null || (str2 = video.getUgcVideoId()) == null) {
                            str2 = BuildConfig.FLAVOR;
                        }
                        h2.put("content_id", str2);
                        UGCVideo video2 = searchResultItem.getVideo();
                        if (video2 == null || (str3 = video2.getSubjectId()) == null) {
                            str3 = BuildConfig.FLAVOR;
                        }
                        h2.put("refer_subject_id", str3);
                        UGCVideo video3 = searchResultItem.getVideo();
                        if (video3 == null || (belongToCollection = video3.getBelongToCollection()) == null || (str4 = belongToCollection.getCollectionId()) == null) {
                            str4 = BuildConfig.FLAVOR;
                        }
                        h2.put("belong_to_collection_id", str4);
                        UGCVideo video4 = searchResultItem.getVideo();
                        if (video4 != null && (ops = video4.getOps()) != null) {
                            str7 = ops;
                        }
                        h2.put("ops", str7);
                        break;
                    }
                    break;
                case 511113132:
                    if (topicType.equals("UGC_COLLECTION")) {
                        h2.put("module_name", ShortTVCollectionView.TYPE_COLLECTION);
                        UGCCollection collection = searchResultItem.getCollection();
                        if (collection != null && (collectionId = collection.getCollectionId()) != null) {
                            str7 = collectionId;
                        }
                        h2.put("content_id", str7);
                        h2.put("ops", searchResultItem.getOps());
                        break;
                    }
                    break;
                case 932115657:
                    if (topicType.equals("HASH_TAG")) {
                        h2.put("module_name", "hashtag");
                        UGCVideoHashTag hashTag = searchResultItem.getHashTag();
                        if (hashTag == null || (str5 = hashTag.getReferId()) == null) {
                            str5 = BuildConfig.FLAVOR;
                        }
                        h2.put("content_id", str5);
                        UGCVideoHashTag hashTag2 = searchResultItem.getHashTag();
                        if (hashTag2 != null && (title = hashTag2.getTitle()) != null) {
                            str7 = title;
                        }
                        h2.put("title", str7);
                        h2.put("ops", searchResultItem.getOps());
                        break;
                    }
                    break;
                case 2033770325:
                    if (topicType.equals("VERTICAL_RANK")) {
                        h2.put("module_name", "verticalRank");
                        UGCVerticalRank verticalRank = searchResultItem.getVerticalRank();
                        if (verticalRank == null || (str6 = verticalRank.getId()) == null) {
                            str6 = BuildConfig.FLAVOR;
                        }
                        h2.put("content_id", str6);
                        UGCVideo video5 = searchResultItem.getVideo();
                        if (video5 != null && (ops2 = video5.getOps()) != null) {
                            str7 = ops2;
                        }
                        h2.put("ops", str7);
                        h2.put("ops", searchResultItem.getOps());
                        break;
                    }
                    break;
            }
        }
        com.transsion.baselib.helper.a.a.f("/ugc_search/search_result", h2);
    }

    public final void x(String str, String str2) {
        Intrinsics.h(str, "searchResult");
        HashMap h2 = h();
        h2.put("keyword", String.valueOf(this.f));
        h2.put("search_from", String.valueOf(this.e));
        h2.put("search_result", str);
        if (str2 != null) {
            h2.put("ops", str2);
        }
        qi.h.a.A(SearchHotFragment.PAGE_NAME, "search", h2);
    }

    public final void y(UGCVideo uGCVideo, int i2, String str, SearchTab searchTab, SecondTab secondTab) {
        String str2;
        Intrinsics.h(uGCVideo, "ugcVideo");
        Intrinsics.h(searchTab, "tab");
        HashMap h2 = h();
        String str3 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        h2.put("keyword", str);
        h2.put("position", String.valueOf(i2));
        h2.put("content_type", "ugc_video");
        h2.put("module_name", "item");
        String ugcVideoId = uGCVideo.getUgcVideoId();
        if (ugcVideoId == null) {
            ugcVideoId = BuildConfig.FLAVOR;
        }
        h2.put("content_id", ugcVideoId);
        String subjectId = uGCVideo.getSubjectId();
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        h2.put("refer_subject_id", subjectId);
        UGCVideoBelongToCollection belongToCollection = uGCVideo.getBelongToCollection();
        if (belongToCollection == null || (str2 = belongToCollection.getCollectionId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        h2.put("belong_to_collection_id", str2);
        String valueOf = String.valueOf(searchTab.getName());
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h2.put("page_tab_name", valueOf);
        h2.put("search_from", String.valueOf(this.e));
        String ops = uGCVideo.getOps();
        if (ops != null) {
            str3 = ops;
        }
        h2.put("ops", str3);
        com.transsion.baselib.helper.a.a.f("/ugc_search/search_result", h2);
    }

    public final void z(String str, SearchTab searchTab, SecondTab secondTab, String str2) {
        HashMap h2 = h();
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        h2.put("keyword", str);
        String valueOf = String.valueOf(searchTab != null ? searchTab.getName() : null);
        if (secondTab != null) {
            valueOf = ((Object) valueOf) + "/" + secondTab.getTagValue();
        }
        h2.put("page_tab_name", valueOf);
        h2.put("module_name", "result_second_tab_click");
        h2.put("search_from", String.valueOf(this.e));
        h2.put("content_type", "ugc_video");
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        h2.put("ops", str2);
        com.transsion.baselib.helper.a.a.f("/ugc_search/search_result", h2);
    }
}
