package com.transsion.mbwidget.data;

import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.flow.bean.LayoutStyle;
import com.transsion.flow.bean.PlayUrl;
import com.transsion.flow.bean.SubjectGameInfo;
import com.transsion.mbwidget.R$mipmap;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectDl;
import com.transsion.moviedetailapi.bean.Trailer;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j {
    public static final j a = new j();
    private static final Map b = MapsKt.l(new Pair[]{TuplesKt.a("img_default_1", Integer.valueOf(R$mipmap.img_widget_subject_default_1)), TuplesKt.a("img_default_2", Integer.valueOf(R$mipmap.img_widget_subject_default_2)), TuplesKt.a("img_default_3", Integer.valueOf(R$mipmap.img_widget_subject_default_3)), TuplesKt.a("img_default_4", Integer.valueOf(R$mipmap.img_widget_subject_default_4))});
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.f
        public final Object invoke() {
            Subject e2;
            e2 = j.e();
            return e2;
        }
    });
    private static final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.g
        public final Object invoke() {
            Subject f2;
            f2 = j.f();
            return f2;
        }
    });
    private static final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.h
        public final Object invoke() {
            Subject g;
            g = j.g();
            return g;
        }
    });
    private static final Lazy f = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.i
        public final Object invoke() {
            Subject h;
            h = j.h();
            return h;
        }
    });

    private j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Subject e() {
        return new Subject("8906247916759695608", (Integer) null, "Avatar", (String) null, new Cover((Integer) null, (Integer) null, (Integer) null, "img_default_1", (String) null, (String) null, (GifBean) null, (String) null, (String) null, DownloadException.EXCEPTION_IO_SOCKET_TIMEOUT, (DefaultConstructorMarker) null), (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -22, 67108863, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Subject f() {
        return new Subject("4191963760367656968", (Integer) null, "Avengers: Endgame", (String) null, new Cover((Integer) null, (Integer) null, (Integer) null, "img_default_2", (String) null, (String) null, (GifBean) null, (String) null, (String) null, DownloadException.EXCEPTION_IO_SOCKET_TIMEOUT, (DefaultConstructorMarker) null), (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -22, 67108863, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Subject g() {
        return new Subject("5390197429792821032", (Integer) null, "Titanic", (String) null, new Cover((Integer) null, (Integer) null, (Integer) null, "img_default_3", (String) null, (String) null, (GifBean) null, (String) null, (String) null, DownloadException.EXCEPTION_IO_SOCKET_TIMEOUT, (DefaultConstructorMarker) null), (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -22, 67108863, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Subject h() {
        return new Subject("9155478106520576008", (Integer) null, "The Lion King", (String) null, new Cover((Integer) null, (Integer) null, (Integer) null, "img_default_4", (String) null, (String) null, (GifBean) null, (String) null, (String) null, DownloadException.EXCEPTION_IO_SOCKET_TIMEOUT, (DefaultConstructorMarker) null), (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -22, 67108863, (DefaultConstructorMarker) null);
    }

    private final Subject i() {
        return (Subject) c.getValue();
    }

    private final Subject j() {
        return (Subject) d.getValue();
    }

    private final Subject k() {
        return (Subject) e.getValue();
    }

    private final Subject l() {
        return (Subject) f.getValue();
    }

    public final List m() {
        return CollectionsKt.q(new Subject[]{i(), j(), k(), l()});
    }

    public final Integer n(String str) {
        return (Integer) b.get(str);
    }
}
