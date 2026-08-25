package rk;

import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qi.h;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final a c = new a(null);
    public static final int d = 8;
    private HashSet a;
    private String b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void e(a aVar, int i, int i2, OperateItem operateItem, UGCVideo uGCVideo, Map map, int i3, Object obj) {
            if ((i3 & 16) != 0) {
                map = null;
            }
            aVar.d(i, i2, operateItem, uGCVideo, map);
        }

        public static /* synthetic */ void g(a aVar, int i, int i2, OperateItem operateItem, UGCVideo uGCVideo, Map map, int i3, Object obj) {
            if ((i3 & 16) != 0) {
                map = null;
            }
            aVar.f(i, i2, operateItem, uGCVideo, map);
        }

        public final void a(int i, int i2, OperateItem operateItem, BannerData bannerData) {
            Intrinsics.h(operateItem, "operateItem");
            HashMap hashMap = new HashMap();
            if (bannerData != null) {
                sk.b.b(bannerData, hashMap);
            }
            sk.b.a(operateItem, hashMap);
            hashMap.put("module_name", "item");
            hashMap.put("position", String.valueOf(i2));
            hashMap.put("tabId", String.valueOf(i));
            h.a.z(SubTabFragment.INSTANCE.a(i), hashMap);
        }

        public final void b(int i, int i2, OperateItem operateItem, BannerData bannerData) {
            Intrinsics.h(operateItem, "operateItem");
            HashMap hashMap = new HashMap();
            if (bannerData != null) {
                sk.b.b(bannerData, hashMap);
            }
            sk.b.a(operateItem, hashMap);
            hashMap.put("module_name", "item");
            hashMap.put("position", String.valueOf(i2));
            hashMap.put("tabId", String.valueOf(i));
            h.a.o(SubTabFragment.INSTANCE.a(i), hashMap);
        }

        public final void c(int i, OperateItem operateItem, int i2) {
            Intrinsics.h(operateItem, "operateItem");
            HashMap hashMap = new HashMap();
            UGCVideo feedsUGCVideo = operateItem.getFeedsUGCVideo();
            if (feedsUGCVideo != null) {
                sk.b.e(feedsUGCVideo, hashMap);
            }
            OperateItem originalOperateItem = operateItem.getOriginalOperateItem();
            if (originalOperateItem != null) {
                sk.b.a(originalOperateItem, hashMap);
            }
            hashMap.put("module_name", "item");
            hashMap.put("position", String.valueOf(i));
            hashMap.put("card_type", Intrinsics.c(operateItem.getType(), PostItemType.TRENDING_FEES_GRID.getValue()) ? "grid" : "big");
            h.a.o(SubTabFragment.INSTANCE.a(i2), hashMap);
        }

        public final void d(int i, int i2, OperateItem operateItem, UGCVideo uGCVideo, Map map) {
            OperateItem originalOperateItem;
            HashMap hashMap = new HashMap();
            if (uGCVideo != null) {
                sk.b.e(uGCVideo, hashMap);
            }
            if (operateItem != null) {
                sk.b.a(operateItem, hashMap);
            }
            if (operateItem != null && (originalOperateItem = operateItem.getOriginalOperateItem()) != null) {
                sk.b.a(originalOperateItem, hashMap);
            }
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    hashMap.put((String) entry.getKey(), (String) entry.getValue());
                }
            }
            hashMap.put("module_name", "item");
            hashMap.put("position", String.valueOf(i2));
            hashMap.put("tabId", String.valueOf(i));
            h.a.z(SubTabFragment.INSTANCE.a(i), hashMap);
        }

        public final void f(int i, int i2, OperateItem operateItem, UGCVideo uGCVideo, Map map) {
            HashMap hashMap = new HashMap();
            if (uGCVideo != null) {
                sk.b.e(uGCVideo, hashMap);
            }
            if (operateItem != null) {
                sk.b.a(operateItem, hashMap);
            }
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    hashMap.put((String) entry.getKey(), (String) entry.getValue());
                }
            }
            hashMap.put("module_name", "item");
            hashMap.put("position", String.valueOf(i2));
            hashMap.put("tabId", String.valueOf(i));
            h.a.o(SubTabFragment.INSTANCE.a(i), hashMap);
        }
    }

    public d(String str) {
        Intrinsics.h(str, "page");
        this.a = new HashSet();
        this.b = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0158, code lost:
    
        if (r2 == null) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(OperateItem operateItem, int i, long j) {
        String str;
        List<UGCContent> contentList;
        String ugcVideoId;
        if (operateItem == null) {
            return;
        }
        String type = operateItem.getType();
        PostItemType postItemType = PostItemType.TRENDING_FEES_GRID;
        if (Intrinsics.c(type, postItemType.getValue()) || Intrinsics.c(operateItem.getType(), PostItemType.TRENDING_FEES_BIG.getValue())) {
            HashSet hashSet = this.a;
            UGCVideo feedsUGCVideo = operateItem.getFeedsUGCVideo();
            if (CollectionsKt.b0(hashSet, feedsUGCVideo != null ? feedsUGCVideo.getUgcVideoId() : null)) {
                a.a aVar = wf.a.a;
                UGCVideo feedsUGCVideo2 = operateItem.getFeedsUGCVideo();
                a.a.f(aVar, "reportExposure", "trendFragment position:" + i + ",subjectId: + " + (feedsUGCVideo2 != null ? feedsUGCVideo2.getUgcVideoId() : null) + "}", false, 4, (Object) null);
                return;
            }
            UGCVideo feedsUGCVideo3 = operateItem.getFeedsUGCVideo();
            if (feedsUGCVideo3 != null && (ugcVideoId = feedsUGCVideo3.getUgcVideoId()) != null && ugcVideoId.length() > 0) {
                HashSet hashSet2 = this.a;
                UGCVideo feedsUGCVideo4 = operateItem.getFeedsUGCVideo();
                String ugcVideoId2 = feedsUGCVideo4 != null ? feedsUGCVideo4.getUgcVideoId() : null;
                Intrinsics.e(ugcVideoId2);
                hashSet2.add(ugcVideoId2);
            }
            if (operateItem.getOriginalOperateItem() == null) {
                HashMap hashMap = new HashMap();
                UGCVideo feedsUGCVideo5 = operateItem.getFeedsUGCVideo();
                if (feedsUGCVideo5 != null) {
                    sk.b.e(feedsUGCVideo5, hashMap);
                }
                hashMap.put("module_name", "item");
                if (j > 0) {
                    hashMap.put("browse_duration", String.valueOf(j));
                }
                hashMap.put("position", String.valueOf(i));
                hashMap.put("card_type", Intrinsics.c(operateItem.getType(), postItemType.getValue()) ? "grid" : "big");
                h.a.z(this.b, hashMap);
                return;
            }
            HashMap hashMap2 = new HashMap();
            UGCVideo feedsUGCVideo6 = operateItem.getFeedsUGCVideo();
            if (feedsUGCVideo6 != null) {
                sk.b.e(feedsUGCVideo6, hashMap2);
            }
            OperateItem originalOperateItem = operateItem.getOriginalOperateItem();
            if (originalOperateItem != null) {
                sk.b.a(originalOperateItem, hashMap2);
            }
            hashMap2.put("module_name", "item");
            if (j > 0) {
                hashMap2.put("browse_duration", String.valueOf(j));
            }
            OperateItem originalOperateItem2 = operateItem.getOriginalOperateItem();
            if (originalOperateItem2 != null && (contentList = originalOperateItem2.getContentList()) != null) {
                Iterator<UGCContent> it = contentList.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    UGCVideo video = it.next().getVideo();
                    String ugcVideoId3 = video != null ? video.getUgcVideoId() : null;
                    UGCVideo feedsUGCVideo7 = operateItem.getFeedsUGCVideo();
                    if (Intrinsics.c(ugcVideoId3, feedsUGCVideo7 != null ? feedsUGCVideo7.getUgcVideoId() : null)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                str = Integer.valueOf(i2).toString();
            }
            str = "0";
            hashMap2.put("position", str);
            hashMap2.put("card_type", Intrinsics.c(operateItem.getType(), PostItemType.TRENDING_FEES_GRID.getValue()) ? "grid" : "big");
            h.a.z(this.b, hashMap2);
        }
    }
}
