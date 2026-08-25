package com.transsion.home.hashtag;

import android.app.Application;
import androidx.annotation.Keep;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.o;
import com.google.gson.annotations.SerializedName;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.Utils;
import com.transsion.home.R;
import com.transsion.home.bean.RefreshBaseDto;
import com.transsion.home.hashtag.model.HashTagItem;
import com.transsion.home.hashtag.model.HashTagItemType;
import com.transsion.home.hashtag.model.HashTagTab;
import com.transsion.home.net.HashTagListRequest;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.push.bean.MsgStyle;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCContentList;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kg.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import mg.b;
import okhttp3.RequestBody;
import wf.a;
import yk.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HashTagViewModel extends b {
    private final Application b;
    private final a c;
    private List d;
    private UGCVideoHashTag e;
    private List f;
    private String g;
    private int h;
    private String i;
    private final Map j;
    private final Map k;
    private final Map l;
    private final Map m;
    private final Map n;
    private t1 o;

    @Keep
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/transsion/home/hashtag/HashTagViewModel$DeeplinkTag;", BuildConfig.FLAVOR, "tag", BuildConfig.FLAVOR, "title", "tagType", "referId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "getTitle", "getTagType", "getReferId", "mapTagType", "t", "toUgcTag", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoHashTag;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class DeeplinkTag {
        public static final int $stable = 0;

        @SerializedName("refer_id")
        private final String referId;

        @SerializedName("tag")
        private final String tag;

        @SerializedName("tag_type")
        private final String tagType;

        @SerializedName("title")
        private final String title;

        public DeeplinkTag() {
            this(null, null, null, null, 15, null);
        }

        public DeeplinkTag(String str, String str2, String str3, String str4) {
            this.tag = str;
            this.title = str2;
            this.tagType = str3;
            this.referId = str4;
        }

        public /* synthetic */ DeeplinkTag(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
        }

        public static /* synthetic */ DeeplinkTag copy$default(DeeplinkTag deeplinkTag, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deeplinkTag.tag;
            }
            if ((i & 2) != 0) {
                str2 = deeplinkTag.title;
            }
            if ((i & 4) != 0) {
                str3 = deeplinkTag.tagType;
            }
            if ((i & 8) != 0) {
                str4 = deeplinkTag.referId;
            }
            return deeplinkTag.copy(str, str2, str3, str4);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        private final String mapTagType(String t) {
            if (t == null) {
                return t;
            }
            switch (t.hashCode()) {
                case 49:
                    if (!t.equals(MsgStyle.CUSTOM_LEFT_PIC)) {
                    }
                    break;
                case 50:
                    if (!t.equals("2")) {
                    }
                    break;
                case 51:
                    if (!t.equals(MsgStyle.NATIVE_STANDARD)) {
                    }
                    break;
                case 52:
                    if (!t.equals(MsgStyle.CUSTOM_BUTTON)) {
                    }
                    break;
            }
            return t;
        }

        /* renamed from: component1, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTagType() {
            return this.tagType;
        }

        /* renamed from: component4, reason: from getter */
        public final String getReferId() {
            return this.referId;
        }

        public final DeeplinkTag copy(String tag, String title, String tagType, String referId) {
            return new DeeplinkTag(tag, title, tagType, referId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeeplinkTag)) {
                return false;
            }
            DeeplinkTag deeplinkTag = (DeeplinkTag) other;
            return Intrinsics.c(this.tag, deeplinkTag.tag) && Intrinsics.c(this.title, deeplinkTag.title) && Intrinsics.c(this.tagType, deeplinkTag.tagType) && Intrinsics.c(this.referId, deeplinkTag.referId);
        }

        public final String getReferId() {
            return this.referId;
        }

        public final String getTag() {
            return this.tag;
        }

        public final String getTagType() {
            return this.tagType;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.tag;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.title;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.tagType;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.referId;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "DeeplinkTag(tag=" + this.tag + ", title=" + this.title + ", tagType=" + this.tagType + ", referId=" + this.referId + ")";
        }

        public final UGCVideoHashTag toUgcTag() {
            String str;
            String str2 = this.title;
            if (str2 == null || str2.length() == 0) {
                String str3 = this.tag;
                if (str3 == null) {
                    str3 = BuildConfig.FLAVOR;
                }
                str = Utils.SEPARATOR + str3;
            } else {
                str = this.title;
            }
            return new UGCVideoHashTag(this.tag, str, mapTagType(this.tagType), this.referId, (String) null);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/transsion/home/hashtag/HashTagViewModel$HashtagPayload;", BuildConfig.FLAVOR, "type", BuildConfig.FLAVOR, "mainHashtag", "Lcom/transsion/home/hashtag/HashTagViewModel$DeeplinkTag;", "subHashtag", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Lcom/transsion/home/hashtag/HashTagViewModel$DeeplinkTag;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getMainHashtag", "()Lcom/transsion/home/hashtag/HashTagViewModel$DeeplinkTag;", "getSubHashtag", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class HashtagPayload {
        public static final int $stable = 8;

        @SerializedName("main_hashtag")
        private final DeeplinkTag mainHashtag;

        @SerializedName("sub_hashtag")
        private final List<DeeplinkTag> subHashtag;

        @SerializedName("type")
        private final String type;

        public HashtagPayload() {
            this(null, null, null, 7, null);
        }

        public HashtagPayload(String str, DeeplinkTag deeplinkTag, List<DeeplinkTag> list) {
            this.type = str;
            this.mainHashtag = deeplinkTag;
            this.subHashtag = list;
        }

        public /* synthetic */ HashtagPayload(String str, DeeplinkTag deeplinkTag, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : deeplinkTag, (i & 4) != 0 ? null : list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HashtagPayload copy$default(HashtagPayload hashtagPayload, String str, DeeplinkTag deeplinkTag, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = hashtagPayload.type;
            }
            if ((i & 2) != 0) {
                deeplinkTag = hashtagPayload.mainHashtag;
            }
            if ((i & 4) != 0) {
                list = hashtagPayload.subHashtag;
            }
            return hashtagPayload.copy(str, deeplinkTag, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final DeeplinkTag getMainHashtag() {
            return this.mainHashtag;
        }

        public final List<DeeplinkTag> component3() {
            return this.subHashtag;
        }

        public final HashtagPayload copy(String type, DeeplinkTag mainHashtag, List<DeeplinkTag> subHashtag) {
            return new HashtagPayload(type, mainHashtag, subHashtag);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HashtagPayload)) {
                return false;
            }
            HashtagPayload hashtagPayload = (HashtagPayload) other;
            return Intrinsics.c(this.type, hashtagPayload.type) && Intrinsics.c(this.mainHashtag, hashtagPayload.mainHashtag) && Intrinsics.c(this.subHashtag, hashtagPayload.subHashtag);
        }

        public final DeeplinkTag getMainHashtag() {
            return this.mainHashtag;
        }

        public final List<DeeplinkTag> getSubHashtag() {
            return this.subHashtag;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            String str = this.type;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            DeeplinkTag deeplinkTag = this.mainHashtag;
            int hashCode2 = (hashCode + (deeplinkTag == null ? 0 : deeplinkTag.hashCode())) * 31;
            List<DeeplinkTag> list = this.subHashtag;
            return hashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "HashtagPayload(type=" + this.type + ", mainHashtag=" + this.mainHashtag + ", subHashtag=" + this.subHashtag + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashTagViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = application;
        this.c = (a) c.e.a().h(a.class);
        this.d = CollectionsKt.l();
        this.g = "ForYou";
        this.j = new LinkedHashMap();
        this.k = new LinkedHashMap();
        this.l = new LinkedHashMap();
        this.m = new LinkedHashMap();
        this.n = new LinkedHashMap();
    }

    private final List h(Set set, boolean z) {
        List list;
        if (!z || (list = this.f) == null || list.isEmpty()) {
            return null;
        }
        return CollectionsKt.e(new HashTagItem(HashTagItemType.TAGS, this.f, CollectionsKt.R0(set), null, null, null, 56, null));
    }

    private final List i(List list, Set set, boolean z) {
        if (!z) {
            return list;
        }
        List c = CollectionsKt.c();
        List list2 = this.f;
        if (list2 != null && !list2.isEmpty()) {
            c.add(new HashTagItem(HashTagItemType.TAGS, this.f, CollectionsKt.R0(set), null, null, null, 56, null));
            a.a aVar = wf.a.a;
            List list3 = this.f;
            Integer valueOf = list3 != null ? Integer.valueOf(list3.size()) : null;
            a.a.f(aVar, "HashTagViewModel", "buildFinalData: insert tags item, tags size=" + valueOf + ", selected size=" + set.size(), false, 4, (Object) null);
        }
        c.addAll(list);
        return CollectionsKt.a(c);
    }

    private final List j(Set set) {
        List c = CollectionsKt.c();
        UGCVideoHashTag uGCVideoHashTag = this.e;
        if (uGCVideoHashTag != null) {
            c.add(uGCVideoHashTag);
        }
        Set set2 = set;
        if (!set2.isEmpty()) {
            c.addAll(set2);
        }
        return CollectionsKt.a(c);
    }

    private final HashTagItem k(UGCContent uGCContent) {
        if (Intrinsics.c(uGCContent.getTopicType(), "UGC_VIDEO")) {
            UGCVideo video = uGCContent.getVideo();
            if (video != null) {
                return new HashTagItem(HashTagItemType.HASHTAG_CARD, null, null, video, null, null, 54, null);
            }
            return null;
        }
        a.a.x(wf.a.a, "HashTagViewModel", "convertToHashTagItem: unknown or unsupported content type=" + uGCContent.getTopicType(), false, 4, (Object) null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RequestBody l(String str, int i, Set set) {
        String j = o.j(new HashTagListRequest(i, 20, j(set), this.i, this.h, str));
        a.a.f(wf.a.a, "HashTagViewModel", "createRequestBody: request=" + j, false, 4, (Object) null);
        b.a aVar = mg.b.a;
        Intrinsics.e(j);
        return aVar.a(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str, Set set, boolean z, String str2, String str3) {
        Map map = this.m;
        Object obj = map.get(str);
        Object obj2 = obj;
        if (obj == null) {
            b0 b0Var = new b0((Object) null);
            map.put(str, b0Var);
            obj2 = b0Var;
        }
        b0 b0Var2 = (b0) obj2;
        List h = h(set, z);
        a.a.f(wf.a.a, "HashTagViewModel", "handleError: errorMsg=" + str2 + ", errorCode=" + str3 + ", errorData size=" + (h != null ? Integer.valueOf(h.size()) : null), false, 4, (Object) null);
        b0Var2.n(new RefreshBaseDto(str2, str3, h, BuildConfig.FLAVOR, z));
        if (z) {
            Map map2 = this.n;
            Object obj3 = map2.get(str);
            if (obj3 == null) {
                obj3 = new b0(Boolean.FALSE);
                map2.put(str, obj3);
            }
            ((b0) obj3).n(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String str, int i, Set set, boolean z, BaseDto baseDto) {
        if (Intrinsics.c(baseDto.getCode(), "0") && baseDto.getData() != null) {
            p(str, i, set, z, (UGCContentList) baseDto.getData());
            return;
        }
        wf.a.a.i("HashTagViewModel", "loadHashTagList failed: code=" + baseDto.getCode() + ", msg=" + baseDto.getMsg(), true);
        String msg = baseDto.getMsg();
        if (msg == null) {
            msg = BuildConfig.FLAVOR;
        }
        String str2 = msg;
        String code = baseDto.getCode();
        if (code == null) {
            code = "-1";
        }
        n(str, set, z, str2, code);
    }

    private final void p(String str, int i, Set set, boolean z, UGCContentList uGCContentList) {
        List l;
        Pager pager;
        Boolean hasMore;
        if (uGCContentList == null || (l = uGCContentList.getItems()) == null) {
            l = CollectionsKt.l();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = l.iterator();
        while (it.hasNext()) {
            HashTagItem k = k((UGCContent) it.next());
            if (k != null) {
                arrayList.add(k);
            }
        }
        boolean booleanValue = (uGCContentList == null || (pager = uGCContentList.getPager()) == null || (hasMore = pager.getHasMore()) == null) ? false : hasMore.booleanValue();
        this.l.put(str, Boolean.valueOf(booleanValue));
        a.a aVar = wf.a.a;
        a.a.f(aVar, "HashTagViewModel", "loadHashTagList success, tabSort=" + str + ", page=" + i + ", size=" + arrayList.size() + ", hasMore=" + booleanValue, false, 4, (Object) null);
        List i2 = i(arrayList, set, z);
        int size = i2.size();
        StringBuilder sb = new StringBuilder();
        sb.append("loadHashTagList: finalData size=");
        sb.append(size);
        a.a.f(aVar, "HashTagViewModel", sb.toString(), false, 4, (Object) null);
        Map map = this.m;
        Object obj = map.get(str);
        Object obj2 = obj;
        if (obj == null) {
            b0 b0Var = new b0((Object) null);
            map.put(str, b0Var);
            obj2 = b0Var;
        }
        ((b0) obj2).n(new RefreshBaseDto(BuildConfig.FLAVOR, "0", i2, BuildConfig.FLAVOR, z));
        if (z) {
            Map map2 = this.n;
            Object obj3 = map2.get(str);
            if (obj3 == null) {
                obj3 = new b0(Boolean.FALSE);
                map2.put(str, obj3);
            }
            ((b0) obj3).n(Boolean.FALSE);
        }
    }

    private final void t(String str, boolean z) {
        Integer num = (Integer) this.k.get(str);
        int intValue = num != null ? num.intValue() : 1;
        Set set = (Set) this.j.get(str);
        if (set == null) {
            set = new LinkedHashSet();
        }
        Set set2 = set;
        a.a.f(wf.a.a, "HashTagViewModel", "loadHashTagList: start, tabSort=" + str + ", page=" + intValue + ", isRefresh=" + z + ", selectedTags=" + set2.size(), false, 4, (Object) null);
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new HashTagViewModel$loadHashTagList$1(this, str, intValue, set2, z, null), 2, (Object) null);
    }

    private final void z(String str) {
        List l;
        Map map = this.m;
        Object obj = map.get(str);
        HashTagItem hashTagItem = null;
        if (obj == null) {
            obj = new b0((Object) null);
            map.put(str, obj);
        }
        b0 b0Var = (b0) obj;
        RefreshBaseDto refreshBaseDto = (RefreshBaseDto) b0Var.f();
        if (refreshBaseDto == null || (l = (List) refreshBaseDto.getData()) == null) {
            l = CollectionsKt.l();
        }
        Iterable iterable = (Set) this.j.get(str);
        if (iterable == null) {
            iterable = new LinkedHashSet();
        }
        List list = this.f;
        if (list != null && !list.isEmpty()) {
            hashTagItem = new HashTagItem(HashTagItemType.TAGS, this.f, CollectionsKt.R0(iterable), null, null, null, 56, null);
        }
        if (hashTagItem != null) {
            List list2 = l;
            if (list2.isEmpty() || ((HashTagItem) l.get(0)).getType() != HashTagItemType.TAGS) {
                List c = CollectionsKt.c();
                c.add(hashTagItem);
                c.addAll(list2);
                l = CollectionsKt.a(c);
            } else {
                List c2 = CollectionsKt.c();
                c2.add(hashTagItem);
                c2.addAll(CollectionsKt.d0(l, 1));
                l = CollectionsKt.a(c2);
            }
        }
        b0Var.n(new RefreshBaseDto(BuildConfig.FLAVOR, "0", l, BuildConfig.FLAVOR, true));
    }

    public final void A(String str) {
        Intrinsics.h(str, "tabSort");
        this.k.put(str, 1);
        a.a.f(wf.a.a, "HashTagViewModel", "refresh: tabSort=" + str + ", reset page to 1", false, 4, (Object) null);
        Map map = this.n;
        Object obj = map.get(str);
        if (obj == null) {
            obj = new b0(Boolean.FALSE);
            map.put(str, obj);
        }
        ((b0) obj).n(Boolean.TRUE);
        t(str, true);
    }

    public final List m() {
        return this.d;
    }

    public final boolean q(String str) {
        Intrinsics.h(str, "tabSort");
        Boolean bool = (Boolean) this.l.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final void r(UGCVideoHashTag uGCVideoHashTag, List list, int i, String str) {
        ArrayList arrayList;
        this.e = uGCVideoHashTag;
        if (list != null) {
            arrayList = new ArrayList();
            for (Object obj : list) {
                String title = ((UGCVideoHashTag) obj).getTitle();
                if (!(title == null || title.length() == 0)) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        this.f = arrayList;
        this.h = i;
        this.i = str;
        this.g = "ForYou";
        a.a.f(wf.a.a, "HashTagViewModel", "init: hashTag=" + (uGCVideoHashTag != null ? uGCVideoHashTag.getTitle() : null) + ", hashTags size=" + (list != null ? Integer.valueOf(list.size()) : null) + ", tabId=" + i + ", ugcVideoId=" + str, false, 4, (Object) null);
        String string = this.b.getString(R.string.item_tab_hash_tag_for_you);
        Intrinsics.g(string, "getString(...)");
        HashTagTab hashTagTab = new HashTagTab("ForYou", string, true);
        String string2 = this.b.getString(R.string.item_tab_hash_tag_most_viewed);
        Intrinsics.g(string2, "getString(...)");
        HashTagTab hashTagTab2 = new HashTagTab("MostViewed", string2, false, 4, null);
        String string3 = this.b.getString(R.string.item_tab_hash_tag_new);
        Intrinsics.g(string3, "getString(...)");
        List o = CollectionsKt.o(new HashTagTab[]{hashTagTab, hashTagTab2, new HashTagTab("New", string3, false, 4, null)});
        this.d = o;
        Iterator it = o.iterator();
        while (it.hasNext()) {
            this.j.put(((HashTagTab) it.next()).getId(), new LinkedHashSet());
        }
    }

    public final LiveData s(String str) {
        Intrinsics.h(str, "tabSort");
        Map map = this.m;
        Object obj = map.get(str);
        if (obj == null) {
            obj = new b0((Object) null);
            map.put(str, obj);
        }
        return (LiveData) obj;
    }

    public final void u(String str) {
        Intrinsics.h(str, "tabSort");
        if (!q(str)) {
            a.a.f(wf.a.a, "HashTagViewModel", "loadMore: no more data, tabSort=" + str, false, 4, (Object) null);
            return;
        }
        Integer num = (Integer) this.k.get(str);
        int intValue = (num != null ? num.intValue() : 1) + 1;
        this.k.put(str, Integer.valueOf(intValue));
        a.a.f(wf.a.a, "HashTagViewModel", "loadMore: tabSort=" + str + ", page=" + intValue, false, 4, (Object) null);
        t(str, false);
    }

    public final LiveData v(String str) {
        Intrinsics.h(str, "tabSort");
        Map map = this.n;
        Object obj = map.get(str);
        if (obj == null) {
            obj = new b0(Boolean.FALSE);
            map.put(str, obj);
        }
        return (LiveData) obj;
    }

    public final void w(String str) {
        Intrinsics.h(str, "tabSort");
        a.a.f(wf.a.a, "HashTagViewModel", "onTabSelected: tabSort=" + str + ", previous=" + this.g, false, 4, (Object) null);
        List<HashTagTab> list = this.d;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list, 10));
        for (HashTagTab hashTagTab : list) {
            arrayList.add(HashTagTab.copy$default(hashTagTab, null, null, Intrinsics.c(hashTagTab.getId(), str), 3, null));
        }
        this.d = arrayList;
        this.g = str;
        Map map = this.m;
        Object obj = map.get(str);
        if (obj == null) {
            obj = new b0((Object) null);
            map.put(str, obj);
        }
        RefreshBaseDto refreshBaseDto = (RefreshBaseDto) ((b0) obj).f();
        List list2 = refreshBaseDto != null ? (List) refreshBaseDto.getData() : null;
        List list3 = list2;
        if (list3 != null && !list3.isEmpty()) {
            a.a.f(wf.a.a, "HashTagViewModel", "onTabSelected: data exists, size=" + list2.size(), false, 4, (Object) null);
            return;
        }
        a.a.f(wf.a.a, "HashTagViewModel", "onTabSelected: no data, start loading", false, 4, (Object) null);
        Map map2 = this.n;
        Object obj2 = map2.get(str);
        if (obj2 == null) {
            obj2 = new b0(Boolean.FALSE);
            map2.put(str, obj2);
        }
        ((b0) obj2).n(Boolean.TRUE);
        A(str);
    }

    public final void x(UGCVideoHashTag uGCVideoHashTag) {
        Object obj;
        Intrinsics.h(uGCVideoHashTag, "tag");
        Set set = (Set) this.j.get(this.g);
        if (set == null) {
            set = new LinkedHashSet();
        }
        Iterator it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.c(((UGCVideoHashTag) obj).getTag(), uGCVideoHashTag.getTag())) {
                    break;
                }
            }
        }
        UGCVideoHashTag uGCVideoHashTag2 = (UGCVideoHashTag) obj;
        if (uGCVideoHashTag2 != null) {
            set.remove(uGCVideoHashTag2);
            a.a.f(wf.a.a, "HashTagViewModel", "onTagClicked: unselect tag=" + uGCVideoHashTag.getTag() + ", tabSort=" + this.g + ", current selected=" + set.size(), false, 4, (Object) null);
        } else {
            set.add(uGCVideoHashTag);
            a.a.f(wf.a.a, "HashTagViewModel", "onTagClicked: select tag=" + uGCVideoHashTag.getTag() + ", tabSort=" + this.g + ", current selected=" + set.size(), false, 4, (Object) null);
        }
        this.j.put(this.g, set);
        z(this.g);
        t1 t1Var = this.o;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        a.a.f(wf.a.a, "HashTagViewModel", "onTagClicked: cancel previous debounce job, will refresh after 700ms", false, 4, (Object) null);
        this.o = i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new HashTagViewModel$onTagClicked$1(this, null), 3, (Object) null);
    }

    public final Pair y(String str) {
        Object obj;
        ArrayList arrayList;
        List<DeeplinkTag> subHashtag;
        DeeplinkTag mainHashtag;
        Intrinsics.h(str, "raw");
        try {
            Result.Companion companion = Result.Companion;
            HashtagPayload hashtagPayload = (HashtagPayload) o.f().fromJson(str, HashtagPayload.class);
            UGCVideoHashTag ugcTag = (hashtagPayload == null || (mainHashtag = hashtagPayload.getMainHashtag()) == null) ? null : mainHashtag.toUgcTag();
            if (hashtagPayload == null || (subHashtag = hashtagPayload.getSubHashtag()) == null) {
                arrayList = null;
            } else {
                List<DeeplinkTag> list = subHashtag;
                arrayList = new ArrayList(CollectionsKt.v(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((DeeplinkTag) it.next()).toUgcTag());
                }
            }
            a.a.f(wf.a.a, "HashTagViewModel", "parse hashtag json success: main=" + (ugcTag != null ? ugcTag.getTitle() : null) + ", subs=" + (arrayList != null ? Integer.valueOf(arrayList.size()) : null), false, 4, (Object) null);
            obj = Result.constructor-impl(new Pair(ugcTag, arrayList));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            wf.a.a.i("HashTagViewModel", "parse hashtag json failed: " + th3.getMessage(), true);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Pair pair = (Pair) obj;
        return pair == null ? new Pair((Object) null, (Object) null) : pair;
    }
}
