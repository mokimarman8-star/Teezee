package com.transsion.home.viewmodel;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.u0;
import androidx.lifecycle.v0;
import com.google.gson.Gson;
import com.transsion.baselib.net.LaunchWithErrorHandlerKt;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.adapter.trending.adapter.SportLiveAdapter;
import com.transsion.home.bean.BannerBean;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.DisplayMeta;
import com.transsion.home.bean.FeedsLayoutType;
import com.transsion.home.bean.LiveListItem;
import com.transsion.home.bean.MainOperateData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.home.bean.TrendingRequestEntity;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.push.bean.MsgStyle;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import ep.k;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.y0;
import wf.a;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TrendingUGCViewModel extends androidx.lifecycle.b {
    public static final a l = new a(null);
    public static final int m = 8;
    private static TrendingUGCViewModel n;
    private String b;
    private int c;
    private boolean d;
    private List e;
    private final Lazy f;
    private final Lazy g;
    private final Lazy h;
    private final Lazy i;
    private final Lazy j;
    private final Lazy k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TrendingUGCViewModel a(Application application) {
            Intrinsics.h(application, "application");
            if (TrendingUGCViewModel.n == null) {
                TrendingUGCViewModel.n = v0.a.e.a(application).create(TrendingUGCViewModel.class);
            }
            return TrendingUGCViewModel.n;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingUGCViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = MsgStyle.CUSTOM_LEFT_PIC;
        this.c = 14;
        this.f = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.o
            public final Object invoke() {
                androidx.lifecycle.b0 H;
                H = TrendingUGCViewModel.H();
                return H;
            }
        });
        this.g = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.p
            public final Object invoke() {
                androidx.lifecycle.b0 G;
                G = TrendingUGCViewModel.G();
                return G;
            }
        });
        this.h = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.q
            public final Object invoke() {
                androidx.lifecycle.b0 P;
                P = TrendingUGCViewModel.P();
                return P;
            }
        });
        this.i = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.r
            public final Object invoke() {
                yk.e O;
                O = TrendingUGCViewModel.O();
                return O;
            }
        });
        this.j = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.s
            public final Object invoke() {
                androidx.lifecycle.b0 L;
                L = TrendingUGCViewModel.L();
                return L;
            }
        });
        this.k = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.t
            public final Object invoke() {
                com.transsion.home.viewmodel.preload.a s;
                s = TrendingUGCViewModel.s();
                return s;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final yk.e C() {
        return (yk.e) this.i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(MainOperateData mainOperateData) {
        List<OperateItem> items;
        ArrayList arrayList;
        List<BannerData> banners;
        List<BannerData> banners2;
        List I0;
        if (mainOperateData == null || (items = mainOperateData.getItems()) == null) {
            return;
        }
        List<OperateItem> items2 = mainOperateData.getItems();
        mainOperateData.setItems((items2 == null || (I0 = CollectionsKt.I0(items2, new Comparator() { // from class: com.transsion.home.viewmodel.TrendingUGCViewModel$handlerOperateData$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.d(((OperateItem) t).getPosition(), ((OperateItem) t2).getPosition());
            }
        })) == null) ? null : CollectionsKt.U0(I0));
        ArrayList<OperateItem> arrayList2 = new ArrayList();
        for (OperateItem operateItem : items) {
            if (Intrinsics.c(operateItem.getType(), PostItemType.SPORT_LIVE.getValue())) {
                List<LiveListItem> liveList = operateItem.getLiveList();
                if (liveList != null) {
                    arrayList = new ArrayList();
                    for (Object obj : liveList) {
                        if (!Intrinsics.c(((LiveListItem) obj).getStatus(), SportLiveAdapter.P)) {
                            arrayList.add(obj);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    arrayList2.add(operateItem);
                }
            } else if (Intrinsics.c(operateItem.getType(), PostItemType.UGC_MOVIE_RANK.getValue())) {
                List<UGCContent> contentList = operateItem.getContentList();
                if ((contentList != null ? contentList.size() : 0) >= 3) {
                    arrayList2.add(operateItem);
                }
            } else if (Intrinsics.c(operateItem.getType(), PostItemType.CUSTOM_DATA.getValue())) {
                BannerBean banner = operateItem.getBanner();
                if (((banner == null || (banners = banner.getBanners()) == null) ? 0 : banners.size()) >= 3) {
                    arrayList2.add(operateItem);
                }
            } else {
                if (Intrinsics.c(operateItem.getType(), PostItemType.UGC_BANNER.getValue())) {
                    BannerBean banner2 = operateItem.getBanner();
                    if (((banner2 == null || (banners2 = banner2.getBanners()) == null) ? 0 : banners2.size()) != 0) {
                    }
                }
                arrayList2.add(operateItem);
            }
        }
        Integer groupPos = mainOperateData.getGroupPos();
        if ((groupPos != null ? groupPos.intValue() : 0) > 0) {
            k.a.m(true);
            Integer groupPos2 = mainOperateData.getGroupPos();
            int intValue = groupPos2 != null ? groupPos2.intValue() : 0;
            if (intValue >= items.size()) {
                arrayList2.add(new OperateItem(null, PostItemType.ROOM.getValue(), null, null, "TrendingRoom", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870893, null));
            } else {
                arrayList2.add(intValue, new OperateItem(null, PostItemType.ROOM.getValue(), null, null, "TrendingRoom", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870893, null));
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (OperateItem operateItem2 : arrayList2) {
            String type = operateItem2.getType();
            PostItemType postItemType = PostItemType.UGC_SUBJECT_LIST;
            if (Intrinsics.c(type, postItemType.getValue()) && Intrinsics.c(operateItem2.getStyleTemplate(), com.transsion.home.adapter.operateUGC.b.M)) {
                List<UGCContent> contentList2 = operateItem2.getContentList();
                boolean z = (contentList2 != null ? contentList2.size() : 0) % 2 == 0;
                String title = operateItem2.getTitle();
                if (!(title == null || title.length() == 0)) {
                    arrayList3.add(new OperateItem(operateItem2.getTitle(), PostItemType.FEEDS_TITLE.getValue(), null, operateItem2.getDeepLink(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870900, null));
                }
                List<UGCContent> contentList3 = operateItem2.getContentList();
                if (contentList3 != null) {
                    int i = 0;
                    for (Object obj2 : contentList3) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.u();
                        }
                        UGCContent uGCContent = (UGCContent) obj2;
                        if (i == 0) {
                            arrayList3.add(new OperateItem(null, PostItemType.TRENDING_FEES_BIG.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, uGCContent.getVideo(), null, null, null, null, null, null, operateItem2, null, 401604605, null));
                        } else {
                            if (z) {
                                List<UGCContent> contentList4 = operateItem2.getContentList();
                                if (contentList4 != null && i == contentList4.size() - 1) {
                                }
                            }
                            arrayList3.add(new OperateItem(null, PostItemType.TRENDING_FEES_GRID.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, uGCContent.getVideo(), null, null, null, null, null, null, operateItem2, null, 401604605, null));
                        }
                        i = i2;
                    }
                }
                arrayList3.add(new OperateItem(null, PostItemType.TRENDING_MARGIN.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870909, null));
            } else {
                if (Intrinsics.c(operateItem2.getType(), postItemType.getValue()) && Intrinsics.c(operateItem2.getStyleTemplate(), com.transsion.home.adapter.operateUGC.b.N)) {
                    operateItem2.setType(PostItemType.UGC_PORTRAIT_GRID.getValue());
                }
                arrayList3.add(operateItem2);
            }
        }
        if (y().f() == null && !l.a.e()) {
            int x = x(arrayList3);
            if (x >= 0 && x < arrayList3.size()) {
                arrayList3.add(x, new OperateItem(null, PostItemType.NO_NETWORK.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870909, null));
            }
        }
        if (mainOperateData.getTrendingTitle() != null) {
            arrayList3.add(new OperateItem(mainOperateData.getTrendingTitle(), PostItemType.FEEDS_TITLE.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870908, null));
        }
        mainOperateData.setItems(arrayList3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 G() {
        return new androidx.lifecycle.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 H() {
        return new androidx.lifecycle.b0();
    }

    private final void K() {
        LaunchWithErrorHandlerKt.b(this, new TrendingUGCViewModel$requestOperateData$1(this, null), new TrendingUGCViewModel$requestOperateData$2(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 L() {
        return new androidx.lifecycle.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(MainOperateData mainOperateData) {
        List<OperateItem> items;
        if (mainOperateData == null || (items = mainOperateData.getItems()) == null || !(!items.isEmpty())) {
            return;
        }
        String json = new Gson().toJson(mainOperateData);
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        bVar.b().putString("trending_operating_version", mainOperateData.getVersion());
        bVar.b().putString("trending_operating_data", json);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yk.e O() {
        return (yk.e) kg.c.e.a().h(yk.e.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 P() {
        return new androidx.lifecycle.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.home.viewmodel.preload.a s() {
        return new com.transsion.home.viewmodel.preload.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List t(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TrendingRespItem trendingRespItem = (TrendingRespItem) it.next();
            UGCContent content = trendingRespItem.getContent();
            if ((content != null ? content.getVideo() : null) != null) {
                DisplayMeta displayMeta = trendingRespItem.getDisplayMeta();
                if (Intrinsics.c(displayMeta != null ? displayMeta.getLayoutType() : null, FeedsLayoutType.FULL.getValue())) {
                    String value = PostItemType.TRENDING_FEES_BIG.getValue();
                    UGCContent content2 = trendingRespItem.getContent();
                    arrayList.add(new OperateItem(null, value, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, content2 != null ? content2.getVideo() : null, null, null, null, null, null, null, null, null, 535822333, null));
                } else {
                    DisplayMeta displayMeta2 = trendingRespItem.getDisplayMeta();
                    if (Intrinsics.c(displayMeta2 != null ? displayMeta2.getLayoutType() : null, FeedsLayoutType.HALF.getValue())) {
                        String value2 = PostItemType.TRENDING_FEES_GRID.getValue();
                        UGCContent content3 = trendingRespItem.getContent();
                        arrayList.add(new OperateItem(null, value2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, content3 != null ? content3.getVideo() : null, null, null, null, null, null, null, null, null, 535822333, null));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(TrendingUGCViewModel trendingUGCViewModel) {
        String string = zk.e.a.b().getString("trending_room_entrance_cache_v2", BuildConfig.FLAVOR);
        if (string == null || string.length() == 0) {
            wf.a.a.c("TrendingUGCFragment", "fetchGroupInfo failed without cache", true);
        } else {
            trendingUGCViewModel.B().n((RoomEntranceResponse) com.blankj.utilcode.util.o.d(string, RoomEntranceResponse.class));
            wf.a.a.c("TrendingUGCFragment", "fetchGroupInfo use cache", true);
        }
        return Unit.a;
    }

    private final com.transsion.home.viewmodel.preload.a w() {
        return (com.transsion.home.viewmodel.preload.a) this.k.getValue();
    }

    public final void A(Context context) {
        Intrinsics.h(context, "context");
        String string = com.transsion.baselib.report.launch.b.a.b().getString("trending_operating_data", BuildConfig.FLAVOR);
        if (string == null || string.length() == 0) {
            string = w().e(context);
        }
        if (string != null) {
            try {
            } catch (Exception e) {
                wf.a.a.c("PreloadTrending", "exception when from json " + e.getMessage(), true);
            }
            if (string.length() != 0) {
                MainOperateData mainOperateData = (MainOperateData) com.blankj.utilcode.util.o.d(string, MainOperateData.class);
                if (mainOperateData != null) {
                    a.a aVar = wf.a.a;
                    List<OperateItem> items = mainOperateData.getItems();
                    aVar.c("PreloadTrending", "load operating cache size=" + (items != null ? Integer.valueOf(items.size()) : null) + "}", true);
                    F(mainOperateData);
                    y().n(mainOperateData);
                }
                K();
            }
        }
        wf.a.a.c("PreloadTrending", "preloadOperatingCache json is null", true);
        K();
    }

    public final androidx.lifecycle.b0 B() {
        return (androidx.lifecycle.b0) this.j.getValue();
    }

    public final List D() {
        return this.e;
    }

    public final androidx.lifecycle.b0 E() {
        return (androidx.lifecycle.b0) this.h.getValue();
    }

    public final void I() {
        this.b = MsgStyle.CUSTOM_LEFT_PIC;
        this.c = 14;
        K();
    }

    public final void J() {
        String str;
        if (this.d) {
            return;
        }
        this.d = true;
        TrendingRequestEntity trendingRequestEntity = new TrendingRequestEntity();
        trendingRequestEntity.setPage(this.b);
        trendingRequestEntity.setPerPage(this.c);
        trendingRequestEntity.setSessionId(jg.b.a.h());
        Uri b = com.transsion.baselib.report.h.a.b();
        if (b == null || (str = b.toString()) == null) {
            str = BuildConfig.FLAVOR;
        }
        trendingRequestEntity.setDeepLink(str);
        trendingRequestEntity.setLatest_events(new ej.a(ej.b.a.e()));
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new TrendingUGCViewModel$requestFeedsList$1(trendingRequestEntity, this, null), 2, (Object) null);
    }

    public final void N(List list) {
        this.e = list;
    }

    public final void u(boolean z) {
        Function0 function0 = new Function0() { // from class: com.transsion.home.viewmodel.u
            public final Object invoke() {
                Unit v;
                v = TrendingUGCViewModel.v(TrendingUGCViewModel.this);
                return v;
            }
        };
        if (z) {
            function0.invoke();
        } else {
            kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new TrendingUGCViewModel$fetchGroupInfo$1(this, function0, null), 2, (Object) null);
        }
    }

    public final int x(List list) {
        Intrinsics.h(list, "operateItems");
        OperateItem operateItem = (OperateItem) CollectionsKt.l0(list, 0);
        return Intrinsics.c(operateItem != null ? operateItem.getType() : null, PostItemType.TRENDING_FEES_GRID.getValue()) ? 2 : 1;
    }

    public final androidx.lifecycle.b0 y() {
        return (androidx.lifecycle.b0) this.g.getValue();
    }

    public final androidx.lifecycle.b0 z() {
        return (androidx.lifecycle.b0) this.f.getValue();
    }
}
