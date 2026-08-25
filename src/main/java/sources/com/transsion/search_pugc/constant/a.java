package com.transsion.search_pugc.constant;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.b;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.search.R$color;
import com.transsion.search_pugc.constant.ResultCollectItemWrapper;
import com.transsion.ugcvideodetail.api.bean.UGCVerticalRank;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import ij.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    public static final Navigator c(Navigator navigator, String str) {
        Navigator K;
        Intrinsics.h(navigator, "<this>");
        return (str == null || (K = navigator.K("ops", str)) == null) ? navigator : K;
    }

    public static final SpannableString d(String str, Context context, String str2) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(context, "context");
        SpannableString spannableString = new SpannableString(str);
        if (str2 != null && !StringsKt.q0(str2)) {
            int color = b.getColor(context, R$color.color_keyword);
            List split = new Regex("\\s+").split(StringsKt.n1(str2).toString(), 0);
            ArrayList arrayList = new ArrayList();
            for (Object obj : split) {
                if (!StringsKt.q0((String) obj)) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return spannableString;
            }
            for (MatchResult matchResult : Regex.findAll$default(new Regex(CollectionsKt.s0(arrayList, "[\\s\\p{Punct}]+", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: fq.c
                public final Object invoke(Object obj2) {
                    CharSequence e;
                    e = com.transsion.search_pugc.constant.a.e((String) obj2);
                    return e;
                }
            }, 30, (Object) null), RegexOption.IGNORE_CASE), str, 0, 2, (Object) null)) {
                spannableString.setSpan(new ForegroundColorSpan(color), matchResult.b().f(), matchResult.b().i() + 1, 33);
            }
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence e(String str) {
        Intrinsics.h(str, "it");
        return Regex.Companion.c(str);
    }

    public static final void f(UGCVerticalRank uGCVerticalRank, String str) {
        UGCVideo uGCVideo;
        Intrinsics.h(uGCVerticalRank, "<this>");
        Navigator K = TheRouter.c("/home/ugc_film_list").K("filmType", uGCVerticalRank.getId()).K("filmListTitle", uGCVerticalRank.getTitle());
        List videos = uGCVerticalRank.getVideos();
        K.K("videoType", (videos == null || (uGCVideo = (UGCVideo) CollectionsKt.k0(videos)) == null) ? null : uGCVideo.getCategory());
        k.p(c(K, str));
    }

    public static final void g(UGCVideo uGCVideo, final boolean z) {
        Intrinsics.h(uGCVideo, "<this>");
        hu.b.a(uGCVideo, new Function1() { // from class: fq.d
            public final Object invoke(Object obj) {
                Navigator i;
                i = com.transsion.search_pugc.constant.a.i(z, (Navigator) obj);
                return i;
            }
        });
    }

    public static /* synthetic */ void h(UGCVideo uGCVideo, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        g(uGCVideo, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Navigator i(boolean z, Navigator navigator) {
        Intrinsics.h(navigator, "navigator");
        return navigator.z("ugc_without_history", z);
    }

    public static final String j(long j) {
        long j2 = 60;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j / j2), Long.valueOf(j % j2)}, 2));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    public static final List k(List list) {
        Intrinsics.h(list, "<this>");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new ResultCollectItemWrapper((UGCVideo) it.next(), ResultCollectItemWrapper.Type.DATA));
        }
        return arrayList;
    }

    public static final String l(String str) {
        Intrinsics.h(str, "<this>");
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 1000) {
                str = String.valueOf(parseInt);
            } else if (parseInt < 1000000) {
                String format = String.format("%.1fk", Arrays.copyOf(new Object[]{Double.valueOf(parseInt / 1000.0d)}, 1));
                Intrinsics.g(format, "format(...)");
                str = StringsKt.J0(format, ".0");
            } else if (parseInt < 1000000000) {
                String format2 = String.format("%.1fM", Arrays.copyOf(new Object[]{Double.valueOf(parseInt / 1000000.0d)}, 1));
                Intrinsics.g(format2, "format(...)");
                str = StringsKt.J0(format2, ".0");
            } else {
                str = "999M+";
            }
        } catch (NumberFormatException unused) {
        }
        return str;
    }
}
