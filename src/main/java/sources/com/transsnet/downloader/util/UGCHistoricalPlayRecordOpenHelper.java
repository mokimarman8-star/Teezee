package com.transsnet.downloader.util;

import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.UGCVideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.ugcvideodetail.api.UGCVideoType;
import com.transsnet.downloader.manager.DownloadEsHelper;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class UGCHistoricalPlayRecordOpenHelper {
    public static final UGCHistoricalPlayRecordOpenHelper a = new UGCHistoricalPlayRecordOpenHelper();

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {
        private final String a;
        private final Integer b;
        private final String c;
        private final String d;
        private final String e;
        private final String f;
        private final String g;
        private final String h;

        public a(String str, Integer num, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.a = str;
            this.b = num;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
            this.h = str7;
        }

        public final String a() {
            return this.a;
        }

        public final Integer b() {
            return this.b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b) && Intrinsics.c(this.c, aVar.c) && Intrinsics.c(this.d, aVar.d) && Intrinsics.c(this.e, aVar.e) && Intrinsics.c(this.f, aVar.f) && Intrinsics.c(this.g, aVar.g) && Intrinsics.c(this.h, aVar.h);
        }

        public final String f() {
            return this.f;
        }

        public final String g() {
            return this.g;
        }

        public final String h() {
            return this.h;
        }

        public int hashCode() {
            String str = this.a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.b;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.d;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.e;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.g;
            int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.h;
            return hashCode7 + (str7 != null ? str7.hashCode() : 0);
        }

        public String toString() {
            return "VideoParams(subjectId=" + this.a + ", subjectType=" + this.b + ", queryVideoId=" + this.c + ", ugcVideoId=" + this.d + ", collectionId=" + this.e + ", ugcVideoType=" + this.f + ", ops=" + this.g + ", videoStyle=" + this.h + ")";
        }
    }

    private UGCHistoricalPlayRecordOpenHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0229 A[PHI: r9
      0x0229: PHI (r9v22 java.lang.Object) = (r9v15 java.lang.Object), (r9v1 java.lang.Object) binds: [B:33:0x0226, B:13:0x0043] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0228 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003b  */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.transsnet.downloader.util.UGCHistoricalPlayRecordOpenHelper$handleNavigation$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(String str, Integer num, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Continuation continuation) {
        ?? r10;
        Object obj;
        Object f;
        int i;
        String str9;
        String str10;
        Integer num2;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        DownloadBean downloadBean;
        DownloadBean downloadBean2;
        boolean c;
        String str16 = str4;
        if (continuation instanceof UGCHistoricalPlayRecordOpenHelper$handleNavigation$1) {
            UGCHistoricalPlayRecordOpenHelper$handleNavigation$1 uGCHistoricalPlayRecordOpenHelper$handleNavigation$1 = (UGCHistoricalPlayRecordOpenHelper$handleNavigation$1) continuation;
            int i2 = uGCHistoricalPlayRecordOpenHelper$handleNavigation$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                uGCHistoricalPlayRecordOpenHelper$handleNavigation$1.label = i2 - Integer.MIN_VALUE;
                r10 = uGCHistoricalPlayRecordOpenHelper$handleNavigation$1;
                obj = r10.result;
                f = IntrinsicsKt.f();
                i = r10.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (str == null || str.length() == 0) {
                        if (str2 != null) {
                            DownloadEsHelper a2 = DownloadEsHelper.m.a();
                            r10.L$0 = str;
                            r10.L$1 = num;
                            r10.L$2 = str2;
                            r10.L$3 = str3;
                            r10.L$4 = str16;
                            r10.L$5 = str5;
                            r10.L$6 = str6;
                            r10.L$7 = str7;
                            r10.L$8 = str8;
                            r10.label = 1;
                            obj = a2.R(str2, (Continuation) r10);
                            if (obj == f) {
                                return f;
                            }
                            str9 = str;
                            str10 = str8;
                            num2 = num;
                            str11 = str7;
                            str12 = str2;
                            str13 = str6;
                            str14 = str3;
                            str15 = str5;
                            downloadBean2 = (DownloadBean) obj;
                        }
                    } else if (str2 != null) {
                        DownloadEsHelper a3 = DownloadEsHelper.m.a();
                        r10.L$0 = str;
                        r10.L$1 = num;
                        r10.L$2 = str2;
                        r10.L$3 = str3;
                        r10.L$4 = str16;
                        r10.L$5 = str5;
                        r10.L$6 = str6;
                        r10.L$7 = str7;
                        r10.L$8 = str8;
                        r10.label = 2;
                        obj = a3.p(str2, (Continuation) r10);
                        if (obj == f) {
                            return f;
                        }
                        str9 = str;
                        str10 = str8;
                        num2 = num;
                        str11 = str7;
                        str12 = str2;
                        str13 = str6;
                        str14 = str3;
                        str15 = str5;
                        downloadBean2 = (DownloadBean) obj;
                    }
                    downloadBean = null;
                    str9 = str;
                    str10 = str8;
                    num2 = num;
                    str11 = str7;
                    str12 = str2;
                    str13 = str6;
                    str14 = str3;
                    str15 = str5;
                    if (str9 != null || str9.length() == 0) {
                        c = Intrinsics.c(str15, UGCVideoType.SHORT_TV.getValue());
                    } else {
                        c = num2 != null && num2.intValue() == SubjectType.SHORT_TV.getValue();
                    }
                    boolean z = downloadBean == null && downloadBean.isCompleted();
                    a.a.f(wf.a.a, "UGCVideoOpen", StringsKt.n("\n                " + str10 + " gotoUGCVideoDetail isDownloaded:" + z + ",isShortTV" + c + "\n                subjectId:" + str9 + ",subjectType:" + num2 + ",queryVideoId:" + str12 + ",\n                ugcVideoId:" + str14 + ",collectionId:" + str16 + ",ugcVideoType:" + str15 + ",\n                ops:" + str13 + ", videoStyle:" + str11 + "\n            "), false, 4, (Object) null);
                    a2 c2 = y0.c();
                    UGCHistoricalPlayRecordOpenHelper$handleNavigation$2 uGCHistoricalPlayRecordOpenHelper$handleNavigation$2 = new UGCHistoricalPlayRecordOpenHelper$handleNavigation$2(str11, z, downloadBean, str14, str12, str9, str16, str13, str15, c, null);
                    r10.L$0 = null;
                    r10.L$1 = null;
                    r10.L$2 = null;
                    r10.L$3 = null;
                    r10.L$4 = null;
                    r10.L$5 = null;
                    r10.L$6 = null;
                    r10.L$7 = null;
                    r10.L$8 = null;
                    r10.label = 3;
                    obj = kotlinx.coroutines.i.g(c2, uGCHistoricalPlayRecordOpenHelper$handleNavigation$2, r10);
                    return obj == f ? f : obj;
                }
                if (i == 1) {
                    str10 = (String) r10.L$8;
                    str11 = (String) r10.L$7;
                    str13 = (String) r10.L$6;
                    str15 = (String) r10.L$5;
                    str16 = (String) r10.L$4;
                    str14 = (String) r10.L$3;
                    str12 = (String) r10.L$2;
                    num2 = (Integer) r10.L$1;
                    str9 = (String) r10.L$0;
                    ResultKt.b(obj);
                    downloadBean2 = (DownloadBean) obj;
                } else {
                    if (i != 2) {
                        if (i == 3) {
                            ResultKt.b(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str10 = (String) r10.L$8;
                    str11 = (String) r10.L$7;
                    str13 = (String) r10.L$6;
                    str15 = (String) r10.L$5;
                    str16 = (String) r10.L$4;
                    str14 = (String) r10.L$3;
                    str12 = (String) r10.L$2;
                    num2 = (Integer) r10.L$1;
                    str9 = (String) r10.L$0;
                    ResultKt.b(obj);
                    downloadBean2 = (DownloadBean) obj;
                }
                downloadBean = downloadBean2;
                if (str9 != null) {
                }
                c = Intrinsics.c(str15, UGCVideoType.SHORT_TV.getValue());
                if (downloadBean == null) {
                }
                a.a.f(wf.a.a, "UGCVideoOpen", StringsKt.n("\n                " + str10 + " gotoUGCVideoDetail isDownloaded:" + z + ",isShortTV" + c + "\n                subjectId:" + str9 + ",subjectType:" + num2 + ",queryVideoId:" + str12 + ",\n                ugcVideoId:" + str14 + ",collectionId:" + str16 + ",ugcVideoType:" + str15 + ",\n                ops:" + str13 + ", videoStyle:" + str11 + "\n            "), false, 4, (Object) null);
                a2 c22 = y0.c();
                UGCHistoricalPlayRecordOpenHelper$handleNavigation$2 uGCHistoricalPlayRecordOpenHelper$handleNavigation$22 = new UGCHistoricalPlayRecordOpenHelper$handleNavigation$2(str11, z, downloadBean, str14, str12, str9, str16, str13, str15, c, null);
                r10.L$0 = null;
                r10.L$1 = null;
                r10.L$2 = null;
                r10.L$3 = null;
                r10.L$4 = null;
                r10.L$5 = null;
                r10.L$6 = null;
                r10.L$7 = null;
                r10.L$8 = null;
                r10.label = 3;
                obj = kotlinx.coroutines.i.g(c22, uGCHistoricalPlayRecordOpenHelper$handleNavigation$22, r10);
                if (obj == f) {
                }
            }
        }
        r10 = new UGCHistoricalPlayRecordOpenHelper$handleNavigation$1(this, continuation);
        obj = r10.result;
        f = IntrinsicsKt.f();
        i = r10.label;
        if (i != 0) {
        }
        downloadBean = downloadBean2;
        if (str9 != null) {
        }
        c = Intrinsics.c(str15, UGCVideoType.SHORT_TV.getValue());
        if (downloadBean == null) {
        }
        a.a.f(wf.a.a, "UGCVideoOpen", StringsKt.n("\n                " + str10 + " gotoUGCVideoDetail isDownloaded:" + z + ",isShortTV" + c + "\n                subjectId:" + str9 + ",subjectType:" + num2 + ",queryVideoId:" + str12 + ",\n                ugcVideoId:" + str14 + ",collectionId:" + str16 + ",ugcVideoType:" + str15 + ",\n                ops:" + str13 + ", videoStyle:" + str11 + "\n            "), false, 4, (Object) null);
        a2 c222 = y0.c();
        UGCHistoricalPlayRecordOpenHelper$handleNavigation$2 uGCHistoricalPlayRecordOpenHelper$handleNavigation$222 = new UGCHistoricalPlayRecordOpenHelper$handleNavigation$2(str11, z, downloadBean, str14, str12, str9, str16, str13, str15, c, null);
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.L$3 = null;
        r10.L$4 = null;
        r10.L$5 = null;
        r10.L$6 = null;
        r10.L$7 = null;
        r10.L$8 = null;
        r10.label = 3;
        obj = kotlinx.coroutines.i.g(c222, uGCHistoricalPlayRecordOpenHelper$handleNavigation$222, r10);
        if (obj == f) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String str, String str2, String str3, DownloadBean downloadBean) {
        ij.k.p(TheRouter.c("/ugc_video/local_detail").K("id", str).K("resource_id", downloadBean.getResourceId()).K("collection_id", str2).K("ops", str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String str, String str2, String str3, String str4, String str5, String str6) {
        ij.k.p(TheRouter.c("/ugc_video/detail").K("id", str2).K("subject_id", str).K("collection_id", str3).K("ugcCategory", str5).K("videoStyle", str6).K("ops", str4));
    }

    public final Object d(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, VideoDetailPlayBean videoDetailPlayBean, String str, Continuation continuation) {
        Object g = kotlinx.coroutines.i.g(y0.b(), new UGCHistoricalPlayRecordOpenHelper$gotoUGCVideoDetail$4(uGCVideoDetailPlayBean, videoDetailPlayBean, str, null), continuation);
        return g == IntrinsicsKt.f() ? g : Unit.a;
    }

    public final Object e(Object obj, String str, Continuation continuation) {
        Object g = kotlinx.coroutines.i.g(y0.b(), new UGCHistoricalPlayRecordOpenHelper$gotoUGCVideoDetail$2(obj, str, null), continuation);
        return g == IntrinsicsKt.f() ? g : Unit.a;
    }
}
