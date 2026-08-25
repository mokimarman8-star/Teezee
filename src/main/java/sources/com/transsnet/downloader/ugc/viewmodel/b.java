package com.transsnet.downloader.ugc.viewmodel;

import androidx.compose.foundation.e;
import androidx.lifecycle.t0;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b extends t0 {
    private final String a = "UGCForYouCacheViewModel";
    private final Map b = new LinkedHashMap();

    public static final class a {
        private final List a;
        private String b;
        private boolean c;

        public a() {
            this(null, null, false, 7, null);
        }

        public a(List videos, String str, boolean z) {
            Intrinsics.h(videos, "videos");
            this.a = videos;
            this.b = str;
            this.c = z;
        }

        public /* synthetic */ a(List list, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? true : z);
        }

        public final boolean a() {
            return this.c;
        }

        public final String b() {
            return this.b;
        }

        public final List c() {
            return this.a;
        }

        public final void d(boolean z) {
            this.c = z;
        }

        public final void e(String str) {
            this.b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b) && this.c == aVar.c;
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            String str = this.b;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + e.a(this.c);
        }

        public String toString() {
            return "CacheData(videos=" + this.a + ", nextPage=" + this.b + ", hasMore=" + this.c + ")";
        }
    }

    public final String b(String cacheKey) {
        Intrinsics.h(cacheKey, "cacheKey");
        a aVar = (a) this.b.get(cacheKey);
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public final List c(String cacheKey) {
        List c;
        List R0;
        Intrinsics.h(cacheKey, "cacheKey");
        a aVar = (a) this.b.get(cacheKey);
        return (aVar == null || (c = aVar.c()) == null || (R0 = CollectionsKt.R0(c)) == null) ? CollectionsKt.l() : R0;
    }

    public final boolean d(String cacheKey) {
        List c;
        Intrinsics.h(cacheKey, "cacheKey");
        a aVar = (a) this.b.get(cacheKey);
        return (aVar == null || (c = aVar.c()) == null || !(c.isEmpty() ^ true)) ? false : true;
    }

    public final boolean e(String cacheKey) {
        Intrinsics.h(cacheKey, "cacheKey");
        a aVar = (a) this.b.get(cacheKey);
        if (aVar != null) {
            return aVar.a();
        }
        return true;
    }

    public final void f(String cacheKey, List videos, String str, boolean z) {
        Intrinsics.h(cacheKey, "cacheKey");
        Intrinsics.h(videos, "videos");
        Map map = this.b;
        Object obj = map.get(cacheKey);
        if (obj == null) {
            obj = new a(null, null, false, 7, null);
            map.put(cacheKey, obj);
        }
        a aVar = (a) obj;
        List c = aVar.c();
        ArrayList arrayList = new ArrayList();
        Iterator it = c.iterator();
        while (it.hasNext()) {
            String ugcVideoId = ((UGCVideo) it.next()).getUgcVideoId();
            if (ugcVideoId != null) {
                arrayList.add(ugcVideoId);
            }
        }
        Set W0 = CollectionsKt.W0(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : videos) {
            UGCVideo uGCVideo = (UGCVideo) obj2;
            String ugcVideoId2 = uGCVideo.getUgcVideoId();
            if (ugcVideoId2 != null && ugcVideoId2.length() != 0 && !CollectionsKt.b0(W0, uGCVideo.getUgcVideoId())) {
                arrayList2.add(obj2);
            }
        }
        aVar.c().addAll(arrayList2);
        aVar.e(str);
        aVar.d(z);
        a.a.f(wf.a.a, this.a, "saveCacheAppend: cacheKey=" + cacheKey + ", newSize=" + arrayList2.size() + ", totalSize=" + aVar.c().size() + ", hasMore=" + z, false, 4, (Object) null);
    }

    public final void g(String cacheKey, List videos, String str, boolean z) {
        Intrinsics.h(cacheKey, "cacheKey");
        Intrinsics.h(videos, "videos");
        Map map = this.b;
        Object obj = map.get(cacheKey);
        if (obj == null) {
            obj = new a(null, null, false, 7, null);
            map.put(cacheKey, obj);
        }
        a aVar = (a) obj;
        aVar.c().clear();
        aVar.c().addAll(videos);
        aVar.e(str);
        aVar.d(z);
        a.a.f(wf.a.a, this.a, "saveCacheRefresh: cacheKey=" + cacheKey + ", size=" + videos.size() + ", hasMore=" + z, false, 4, (Object) null);
    }
}
