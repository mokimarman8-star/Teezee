package com.transsion.baselib.helper;

import android.net.Uri;
import android.text.TextUtils;
import com.google.common.base.p;
import com.transsion.core.utils.ToastUtil;
import com.transsion.gslb.BuildConfig;
import com.transsion.search_pugc.fragment.hot.SearchHotFragment;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    private final String a(String str) {
        return (str == null || str.length() == 0) ? str : Intrinsics.c(str, "/search/activity/search_manager") ? SearchHotFragment.PAGE_NAME : Intrinsics.c(str, "/download/panel_activity") ? "/download/ugc_my_downloads" : str;
    }

    private final Uri b(Uri uri) {
        return uri;
    }

    private final boolean f(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return CollectionsKt.o(new String[]{"/rank/all", "/home/movieFilter", "/home/playlist", "/movie/staff", "/home/category"}).contains(str);
    }

    public final ReferrerBean c(Uri uri) {
        String queryParameter;
        String uri2;
        ReferrerBean referrerBean = new ReferrerBean((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
        if (StringsKt.c0(String.valueOf(uri != null ? uri.getPath() : null), "/share", false, 2, (Object) null)) {
            referrerBean.setUtmSource("share");
        } else {
            if (uri != null && (uri2 = uri.toString()) != null && StringsKt.c0(uri2, "utm_source", false, 2, (Object) null)) {
                Uri parse = Uri.parse("?" + uri);
                String valueOf = String.valueOf(parse.getQueryParameter("utm_source"));
                referrerBean.setUtmContent(parse.getQueryParameter("utm_content"));
                referrerBean.setUtmCampaign(parse.getQueryParameter("utm_campaign"));
                if (!TextUtils.isEmpty(valueOf)) {
                    referrerBean.setUtmSource(valueOf);
                    return referrerBean;
                }
            }
            boolean isEmpty = TextUtils.isEmpty(uri != null ? uri.getQueryParameter("utm_source") : null);
            String str = BuildConfig.FLAVOR;
            if (!isEmpty ? !(uri == null || (queryParameter = uri.getQueryParameter("utm_source")) == null) : !(uri == null || (queryParameter = uri.getQueryParameter("channel")) == null)) {
                str = queryParameter;
            }
            referrerBean.setUtmSource(str);
            referrerBean.setUtmContent(uri != null ? uri.getQueryParameter("utm_content") : null);
            referrerBean.setUtmCampaign(uri != null ? uri.getQueryParameter("utm_campaign") : null);
        }
        return referrerBean;
    }

    public final ReferrerBean d(String str) {
        return (str == null || str.length() == 0) ? new ReferrerBean((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null) : c(Uri.parse(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(r4 != null ? r4.getScheme() : null, "http") != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean e(Uri uri) {
        if (!Intrinsics.c(uri != null ? uri.getScheme() : null, "https")) {
        }
        return p.b(uri.getQuery());
    }

    public final Uri g(Uri uri) {
        int i;
        String str;
        List S0;
        String str2 = null;
        if (uri == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            String queryParameter = uri.getQueryParameter("type");
            if (queryParameter == null) {
                queryParameter = BuildConfig.FLAVOR;
            }
            if (queryParameter.length() > 0) {
                if (ij.g.a.b()) {
                    b bVar = a;
                    if (bVar.f(queryParameter)) {
                        return new Uri.Builder().encodedPath("/main/tab").build();
                    }
                    String a2 = bVar.a(queryParameter);
                    if (!Intrinsics.c(a2, queryParameter)) {
                        Uri.Builder clearQuery = uri.buildUpon().path(a2).clearQuery();
                        Set<String> queryParameterNames = uri.getQueryParameterNames();
                        Intrinsics.g(queryParameterNames, "getQueryParameterNames(...)");
                        for (String str3 : queryParameterNames) {
                            if (Intrinsics.c(str3, "type")) {
                                clearQuery.appendQueryParameter("type", a2);
                            } else {
                                String queryParameter2 = uri.getQueryParameter(str3);
                                if (queryParameter2 != null) {
                                    clearQuery.appendQueryParameter(str3, queryParameter2);
                                }
                            }
                        }
                        Uri build = clearQuery.build();
                        Uri b = a.b(build);
                        return b == null ? build : b;
                    }
                    if (Intrinsics.c(queryParameter, "/movie/detail")) {
                        String queryParameter3 = uri.getQueryParameter("id");
                        Uri.Builder clearQuery2 = uri.buildUpon().path("/ugc_video/detail").clearQuery();
                        Set<String> queryParameterNames2 = uri.getQueryParameterNames();
                        Intrinsics.g(queryParameterNames2, "getQueryParameterNames(...)");
                        for (String str4 : queryParameterNames2) {
                            if (Intrinsics.c(str4, "id")) {
                                if (queryParameter3 != null) {
                                    clearQuery2.appendQueryParameter("subject_id", queryParameter3);
                                }
                            } else if (Intrinsics.c(str4, "type")) {
                                clearQuery2.appendQueryParameter("type", "/ugc_video/detail");
                            } else {
                                String queryParameter4 = uri.getQueryParameter(str4);
                                if (queryParameter4 != null) {
                                    clearQuery2.appendQueryParameter(str4, queryParameter4);
                                }
                            }
                        }
                        if (queryParameter3 == null) {
                            String path = uri.getPath();
                            if (path != null && (S0 = StringsKt.S0(path, new String[]{"/"}, false, 0, 6, (Object) null)) != null) {
                                str2 = (String) CollectionsKt.v0(S0);
                            }
                            if (str2 != null) {
                                clearQuery2.appendQueryParameter("subject_id", str2);
                            }
                        }
                        return clearQuery2.build();
                    }
                }
                Uri build2 = uri.buildUpon().path(queryParameter).build();
                Uri b2 = a.b(build2);
                return b2 == null ? build2 : b2;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("subject", "/movie/detail");
            hashMap.put("post", "/post/detail");
            String uri2 = uri.toString();
            Intrinsics.g(uri2, "toString(...)");
            if (TextUtils.isEmpty(uri2)) {
                i = 0;
            } else {
                i = 0;
                List S02 = StringsKt.S0(uri2, new String[]{"-"}, false, 0, 6, (Object) null);
                if (S02.size() >= 2) {
                    String str5 = (String) hashMap.get(S02.get(0));
                    String str6 = (String) S02.get(1);
                    if (str5 != null) {
                        if (ij.g.a.b()) {
                            b bVar2 = a;
                            if (bVar2.f(str5)) {
                                return new Uri.Builder().encodedPath("/main/tab").build();
                            }
                            String a3 = bVar2.a(str5);
                            if (a3 != null && !Intrinsics.c(a3, str5)) {
                                return new Uri.Builder().encodedPath(a3).encodedQuery("id=" + str6).build();
                            }
                            if (Intrinsics.c(str5, "/movie/detail")) {
                                return new Uri.Builder().encodedPath("/ugc_video/detail").encodedQuery("subject_id=" + str6).build();
                            }
                        }
                        return new Uri.Builder().encodedPath(str5).encodedQuery("id=" + str6).build();
                    }
                }
            }
            String path2 = uri.getPath();
            String str7 = path2 == null ? BuildConfig.FLAVOR : path2;
            for (int i2 = i; i2 < str7.length(); i2++) {
                if (str7.charAt(i2) == '/') {
                    i++;
                }
            }
            if (i < 2) {
                return null;
            }
            if (ij.g.a.b()) {
                b bVar3 = a;
                if (bVar3.f(str7)) {
                    return new Uri.Builder().encodedPath("/main/tab").build();
                }
                String a4 = bVar3.a(str7);
                if (!Intrinsics.c(a4, str7)) {
                    Uri.Builder path3 = uri.buildUpon().path(a4);
                    Uri b3 = bVar3.b(path3.build());
                    return b3 == null ? path3.build() : b3;
                }
                if (Intrinsics.c(str7, "/movie/detail")) {
                    String queryParameter5 = uri.getQueryParameter("id");
                    Uri.Builder clearQuery3 = uri.buildUpon().path("/ugc_video/detail").clearQuery();
                    Set<String> queryParameterNames3 = uri.getQueryParameterNames();
                    Intrinsics.g(queryParameterNames3, "getQueryParameterNames(...)");
                    for (String str8 : queryParameterNames3) {
                        if (!Intrinsics.c(str8, "id")) {
                            String queryParameter6 = uri.getQueryParameter(str8);
                            if (queryParameter6 != null) {
                                clearQuery3.appendQueryParameter(str8, queryParameter6);
                            }
                        } else if (queryParameter5 != null) {
                            clearQuery3.appendQueryParameter("subject_id", queryParameter5);
                        }
                    }
                    if (queryParameter5 == null && (str = (String) CollectionsKt.v0(StringsKt.S0(str7, new String[]{"/"}, false, 0, 6, (Object) null))) != null) {
                        clearQuery3.appendQueryParameter("subject_id", str);
                    }
                    return clearQuery3.build();
                }
            }
            Uri b4 = a.b(uri);
            return b4 == null ? uri : b4;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            if (Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.a(th2))) != null) {
                ToastUtil.f("请升级最新版本");
            }
            return uri;
        }
    }
}
