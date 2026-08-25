package com.transsion.shorttv.utils;

import com.transsion.shorttv.bean.ShortTvItemType;
import com.transsion.web.api.WebConstants;
import java.util.HashSet;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final C0005a e = new C0005a(null);
    private final String a;
    private final HashSet b;
    private final HashSet c;
    private final HashSet d;

    /* renamed from: com.transsion.shorttv.utils.a$a, reason: collision with other inner class name */
    public static final class C0005a {
        private C0005a() {
        }

        public /* synthetic */ C0005a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(String pageName) {
        Intrinsics.h(pageName, "pageName");
        this.a = pageName;
        this.b = new HashSet();
        this.c = new HashSet();
        this.d = new HashSet();
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, String str7, Integer num, String str8, long j, Boolean bool2, String str9) {
        boolean contains;
        String str10 = str4;
        if (str == null || str.length() == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str11 = HttpUrl.FRAGMENT_ENCODE_SET;
        linkedHashMap.put("item_type", str2 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str2);
        linkedHashMap.put("opt_type", str3 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str3);
        if (Intrinsics.c(str3, ShortTvItemType.OP_SUBJECTS_MOVIE.getValue())) {
            if (str10 != null) {
                contains = this.b.contains(str4);
                this.b.add(str4);
            }
            contains = false;
        } else if (Intrinsics.c(str3, ShortTvItemType.BANNER.getValue())) {
            if (num != null) {
                contains = this.c.contains(num);
                this.c.add(num);
            }
            contains = false;
        } else {
            if (Intrinsics.c(str3, ShortTvItemType.OP_RANKING.getValue()) && str10 != null) {
                contains = this.d.contains(str4);
                this.d.add(str4);
            }
            contains = false;
        }
        if (contains) {
            return;
        }
        if (str10 == null) {
            str10 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        linkedHashMap.put("subject_id", str10);
        linkedHashMap.put("group_id", str5 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str5);
        if (str6 != null) {
            str11 = str6;
        }
        linkedHashMap.put("ops", str11);
        linkedHashMap.put("has_resource", String.valueOf(bool));
        linkedHashMap.put(WebConstants.FIELD_DEEPLINK, str7);
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        linkedHashMap.put("position", sb.toString());
        linkedHashMap.put("cover", str8);
        linkedHashMap.put("browse_duration", String.valueOf(j));
        linkedHashMap.put("builtin", Intrinsics.c(bool2, Boolean.TRUE) ? com.vungle.ads.internal.b.AD_VISIBILITY_INVISIBLE : "0");
        linkedHashMap.put("tag", String.valueOf(str9));
        or.b.a.a();
        qi.h.a.z(str, linkedHashMap);
    }

    public final void c(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, Integer num, String str8, Boolean bool3, String str9) {
        if (str == null || str.length() == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str10 = HttpUrl.FRAGMENT_ENCODE_SET;
        linkedHashMap.put("item_type", str2 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str2);
        linkedHashMap.put("opt_type", str3 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str3);
        linkedHashMap.put("subject_id", str4 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str4);
        linkedHashMap.put("group_id", str5 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str5);
        if (str6 != null) {
            str10 = str6;
        }
        linkedHashMap.put("ops", str10);
        linkedHashMap.put("has_resource", String.valueOf(bool));
        linkedHashMap.put("check_in", String.valueOf(bool2));
        linkedHashMap.put(WebConstants.FIELD_DEEPLINK, str7);
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        linkedHashMap.put("position", sb.toString());
        linkedHashMap.put("cover", str8);
        linkedHashMap.put("builtin", Intrinsics.c(bool3, Boolean.TRUE) ? com.vungle.ads.internal.b.AD_VISIBILITY_INVISIBLE : "0");
        linkedHashMap.put("tag", String.valueOf(str9));
        or.b.a.a();
        qi.h.a.o(str, linkedHashMap);
    }
}
