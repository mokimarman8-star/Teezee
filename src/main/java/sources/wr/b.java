package wr;

import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import com.transsion.shorttv.bean.Subject;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public static /* synthetic */ void b(b bVar, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 8) != 0) {
            str4 = "minitv_play";
        }
        bVar.a(str, str2, str3, str4);
    }

    public static /* synthetic */ void g(b bVar, String str, String str2, String str3, boolean z, String str4, String str5, int i, Object obj) {
        if ((i & 16) != 0) {
            str4 = "minitv_play";
        }
        String str6 = str4;
        if ((i & 32) != 0) {
            str5 = null;
        }
        bVar.f(str, str2, str3, z, str6, str5);
    }

    public static /* synthetic */ void n(b bVar, String str, String str2, Integer num, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = "minitv_play";
        }
        bVar.m(str, str2, num, str3);
    }

    public final void a(String str, String str2, String str3, String str4) {
        Intrinsics.h(str3, "dialogName");
        Intrinsics.h(str4, "pageName");
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str);
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        hashMap.put("ops", str2);
        hashMap.put("dialog_name", str3);
        h.a.q(str4, "dialog_show", hashMap);
    }

    public final void c(Subject subject, int i, boolean z, boolean z2, String str) {
        String str2;
        Intrinsics.h(str, "unlockWay");
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_play");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str2 = subject.getSubjectId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str2);
        hashMap.put("ep_num", String.valueOf(i));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("is_free", String.valueOf(z));
        hashMap.put("is_unlock", String.valueOf(z2));
        hashMap.put("unlock_way", str);
        hashMap.put("opt_type", "minitv_download");
        h.a.o("minitv_play", hashMap);
    }

    public final void d(Subject subject, int i, String str) {
        String str2;
        Intrinsics.h(str, "optType");
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_download");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str2 = subject.getSubjectId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str2);
        hashMap.put("ep_num", String.valueOf(i));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("opt_type", str);
        h.a.o("minitv_download", hashMap);
    }

    public final void e(Subject subject, int i) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_download");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str);
        hashMap.put("ep_num", String.valueOf(i));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("dialog_name", "dialog_minitv_download");
        h.a.q("minitv_download", "dialog_show", hashMap);
    }

    public final void f(String str, String str2, String str3, boolean z, String str4, String str5) {
        Intrinsics.h(str3, "optType");
        Intrinsics.h(str4, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "favorite");
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str);
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        hashMap.put("ops", str2);
        hashMap.put("opt_type", str3);
        hashMap.put("favorite", String.valueOf(!z));
        if (str5 != null && str5.length() != 0) {
            hashMap.put("page_from", str5);
        }
        h.a.o(str4, hashMap);
    }

    public final void h(Subject subject, int i, String str, String str2) {
        String str3;
        Intrinsics.h(str, "optType");
        Intrinsics.h(str2, "adUnlockType");
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_lock");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str3 = subject.getSubjectId()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str3);
        hashMap.put("ep_num", String.valueOf(i));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("opt_type", str);
        hashMap.put("ad_unlock_type", str2);
        h.a.o("minitv_lock", hashMap);
    }

    public final void i(Subject subject, int i) {
        String str;
        List<Integer> l;
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_lock");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str);
        hashMap.put("ep_num", String.valueOf(i));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        if (subject == null || (l = subject.getUnlockType()) == null) {
            l = CollectionsKt.l();
        }
        String str2 = MsgStyle.CUSTOM_LEFT_PIC;
        if (subject == null || subject.getMiniTvType() != 2) {
            hashMap.put("minitv_pay", l.contains(1) ? MsgStyle.CUSTOM_LEFT_PIC : "0");
            if (!l.contains(2)) {
                str2 = "0";
            }
            hashMap.put("minitv_ad", str2);
        } else {
            hashMap.put("minitv_pay", l.contains(1) ? MsgStyle.CUSTOM_LEFT_PIC : "0");
            if (l.contains(1) || !l.contains(2)) {
                str2 = "0";
            }
            hashMap.put("minitv_ad", str2);
        }
        h.a.q("minitv_lock", "pt", hashMap);
    }

    public final void j(Subject subject, int i, String str, String str2, String str3, String str4) {
        String str5;
        Intrinsics.h(str, "unlockResult");
        Intrinsics.h(str2, "errorMessage");
        Intrinsics.h(str3, "errorCode");
        Intrinsics.h(str4, "source");
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_play");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str5 = subject.getSubjectId()) == null) {
            str5 = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str5);
        hashMap.put("ep_num", String.valueOf(i));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("unlock_result", str);
        hashMap.put("error_message", str2);
        hashMap.put("error_code", str3);
        hashMap.put("source", str4);
        h.a.q("minitv_play", "minitv_pay", hashMap);
    }

    public final void k(Subject subject, int i, boolean z, boolean z2, String str) {
        String str2;
        Intrinsics.h(str, "unlockWay");
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_play");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str2 = subject.getSubjectId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str2);
        hashMap.put("ep_num", String.valueOf(i));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("is_free", String.valueOf(z));
        hashMap.put("is_unlock", String.valueOf(z2));
        hashMap.put("unlock_way", str);
        h.a.q("minitv_play", "minitv_play", hashMap);
    }

    public final void l(Subject subject, int i, String str, String str2, String str3, String str4) {
        String str5;
        Intrinsics.h(str, "unlockResult");
        Intrinsics.h(str2, "errorMessage");
        Intrinsics.h(str3, "errorCode");
        Intrinsics.h(str4, "source");
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", "minitv_play");
        hashMap.put("from", "minitv_sdk");
        if (subject == null || (str5 = subject.getSubjectId()) == null) {
            str5 = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str5);
        hashMap.put("ep_num", String.valueOf(i));
        hashMap.put("minitv_type", (subject == null || subject.getMiniTvType() != 2) ? "short" : "long");
        hashMap.put("unlock_result", str);
        hashMap.put("error_message", str2);
        hashMap.put("error_code", str3);
        hashMap.put("source", str4);
        h.a.q("minitv_play", "minitv_unlock", hashMap);
    }

    public final void m(String str, String str2, Integer num, String str3) {
        String num2;
        Intrinsics.h(str3, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "share");
        String str4 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str);
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        hashMap.put("ops", str2);
        if (num != null && (num2 = num.toString()) != null) {
            str4 = num2;
        }
        hashMap.put("ep", str4);
        h.a.o(str3, hashMap);
    }
}
