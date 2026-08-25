package zk;

import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.LiveListItem;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.push.bean.MsgStyle;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final c a = new c();
    private static final HashSet b = new HashSet();
    private static final HashSet c = new HashSet();
    private static final HashSet d = new HashSet();
    private static final HashSet e = new HashSet();
    public static final int f = 8;

    private c() {
    }

    public final void a() {
        b.clear();
        c.clear();
        d.clear();
    }

    public final void b(OperateItem operateItem, String str, List list, long j, int i) {
        Intrinsics.h(operateItem, "operateItem");
        Intrinsics.h(list, "bannerData");
        HashSet hashSet = e;
        if (CollectionsKt.b0(hashSet, operateItem.getOpId())) {
            return;
        }
        String opId = operateItem.getOpId();
        String str2 = BuildConfig.FLAVOR;
        if (opId == null) {
            opId = BuildConfig.FLAVOR;
        }
        hashSet.add(opId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("opt_type", str);
        String opId2 = operateItem.getOpId();
        if (opId2 == null) {
            opId2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("op_id", opId2);
        String title = operateItem.getTitle();
        if (title != null) {
            str2 = title;
        }
        linkedHashMap.put("title", str2);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        linkedHashMap.put("position", sb.toString());
        linkedHashMap.put("browse_duration", String.valueOf(j));
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            BannerData bannerData = (BannerData) obj;
            String subjectId = bannerData != null ? bannerData.getSubjectId() : null;
            if (subjectId == null || subjectId.length() == 0) {
                sb3.append(bannerData != null ? bannerData.getDeepLink() : null);
                sb3.append(",");
            } else {
                sb2.append(bannerData != null ? bannerData.getSubjectId() : null);
                sb2.append(",");
            }
            i2 = i3;
        }
        String sb4 = sb2.toString();
        Intrinsics.g(sb4, "toString(...)");
        linkedHashMap.put("subject_ids", StringsKt.r1(sb4, new char[]{','}));
        String sb5 = sb3.toString();
        Intrinsics.g(sb5, "toString(...)");
        linkedHashMap.put("deeplinks", StringsKt.r1(sb5, new char[]{','}));
    }

    public final void c(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, Integer num, String str8, Boolean bool3, String str9, String str10, String str11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str12 = BuildConfig.FLAVOR;
        linkedHashMap.put("item_type", str2 == null ? BuildConfig.FLAVOR : str2);
        linkedHashMap.put("opt_type", str3 == null ? BuildConfig.FLAVOR : str3);
        linkedHashMap.put("subject_id", str4 == null ? BuildConfig.FLAVOR : str4);
        linkedHashMap.put("group_id", str5 == null ? BuildConfig.FLAVOR : str5);
        linkedHashMap.put("ops", str6 == null ? BuildConfig.FLAVOR : str6);
        linkedHashMap.put("has_resource", String.valueOf(bool));
        linkedHashMap.put("check_in", String.valueOf(bool2));
        linkedHashMap.put("deeplink", str7);
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        linkedHashMap.put("position", sb.toString());
        linkedHashMap.put("cover", str8);
        linkedHashMap.put("builtin", Intrinsics.c(bool3, Boolean.TRUE) ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        linkedHashMap.put("tag", String.valueOf(str9));
        linkedHashMap.put("opTitle", str10 == null ? BuildConfig.FLAVOR : str10);
        linkedHashMap.put("opId", str11 == null ? BuildConfig.FLAVOR : str11);
        com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.a;
        if (str != null) {
            str12 = str;
        }
        aVar.f(str12, linkedHashMap);
    }

    public final void e(int i, long j, OperateItem operateItem) {
        String str;
        String str2;
        String title;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str3 = BuildConfig.FLAVOR;
        if (operateItem == null || (str = operateItem.getType()) == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("opt_type", str);
        if (operateItem == null || (str2 = operateItem.getOpId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("opId", str2);
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str3 = title;
        }
        linkedHashMap.put("opTitle", str3);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        linkedHashMap.put("position", sb.toString());
        linkedHashMap.put("browse_duration", String.valueOf(j));
        qi.h.a.z("Trending", linkedHashMap);
    }

    public final void f(int i, OperateItem operateItem) {
        String str;
        String str2;
        String title;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str3 = BuildConfig.FLAVOR;
        if (operateItem == null || (str = operateItem.getType()) == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("opt_type", str);
        if (operateItem == null || (str2 = operateItem.getOpId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("opId", str2);
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str3 = title;
        }
        linkedHashMap.put("opTitle", str3);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        linkedHashMap.put("position", sb.toString());
        qi.h.a.o("Trending", linkedHashMap);
    }

    public final void g(Subject subject, int i, OperateItem operateItem) {
        String str;
        String str2;
        String title;
        Intrinsics.h(subject, "subject");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str3 = BuildConfig.FLAVOR;
        if (operateItem == null || (str = operateItem.getType()) == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("opt_type", str);
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("subject_id", subjectId);
        String ops = subject.getOps();
        if (ops == null) {
            ops = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("ops", ops);
        linkedHashMap.put("has_resource", String.valueOf(subject.getHasResource()));
        if (operateItem == null || (str2 = operateItem.getOpId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("opId", str2);
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str3 = title;
        }
        linkedHashMap.put("opTitle", str3);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        linkedHashMap.put("position", sb.toString());
        qi.h.a.z("Trending", linkedHashMap);
    }

    public final void h(Subject subject, int i, OperateItem operateItem) {
        String str;
        String str2;
        String title;
        Intrinsics.h(subject, "subject");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str3 = BuildConfig.FLAVOR;
        if (operateItem == null || (str = operateItem.getType()) == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("opt_type", str);
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("subject_id", subjectId);
        String ops = subject.getOps();
        if (ops == null) {
            ops = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("ops", ops);
        linkedHashMap.put("has_resource", String.valueOf(subject.getHasResource()));
        if (operateItem == null || (str2 = operateItem.getOpId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("opId", str2);
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str3 = title;
        }
        linkedHashMap.put("opTitle", str3);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        linkedHashMap.put("position", sb.toString());
        qi.h.a.o("Trending", linkedHashMap);
    }

    public final void i(OperateItem operateItem, Integer num) {
        String str;
        String str2;
        String str3;
        String title;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        String str4 = BuildConfig.FLAVOR;
        if (operateItem == null || (str = operateItem.getType()) == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("opt_type", str + "_RANK_MORE");
        if (operateItem == null || (str2 = operateItem.getDeepLink()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("deeplink", str2);
        if (operateItem == null || (str3 = operateItem.getOpId()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("op_id", str3);
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        linkedHashMap.put("position", sb.toString());
        if (operateItem != null && (title = operateItem.getTitle()) != null) {
            str4 = title;
        }
        linkedHashMap.put("opTitle", str4);
        qi.h.a.o("Trending", linkedHashMap);
    }

    public final void j(int i, String str, HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.h(str, "tabCode");
        Intrinsics.h(homePreferencesConfig, "config");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dialog_name", "preference");
        linkedHashMap.put("tab_id", String.valueOf(i));
        linkedHashMap.put("tab_code", str);
        linkedHashMap.put("dialog_id", homePreferencesConfig.getLabelId());
        linkedHashMap.put("module_name", "close");
        String showStyle = homePreferencesConfig.getShowStyle();
        if (showStyle == null) {
            showStyle = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("show_style", showStyle);
        qi.h.a.o(SubTabFragment.INSTANCE.a(i), linkedHashMap);
    }

    public final void k(int i, String str, HomePreferencesConfig homePreferencesConfig, List list) {
        Intrinsics.h(str, "tabCode");
        Intrinsics.h(homePreferencesConfig, "config");
        Intrinsics.h(list, "selectedOptions");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dialog_name", "preference");
        linkedHashMap.put("tab_id", String.valueOf(i));
        linkedHashMap.put("tab_code", str);
        linkedHashMap.put("dialog_id", homePreferencesConfig.getLabelId());
        String showStyle = homePreferencesConfig.getShowStyle();
        if (showStyle == null) {
            showStyle = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("show_style", showStyle);
        linkedHashMap.put("module_name", "confirm");
        linkedHashMap.put("select_content", CollectionsKt.s0(list, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        qi.h.a.o(SubTabFragment.INSTANCE.a(i), linkedHashMap);
    }

    public final void l(int i, String str, HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.h(str, "tabCode");
        Intrinsics.h(homePreferencesConfig, "config");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dialog_name", "preference");
        linkedHashMap.put("tab_id", String.valueOf(i));
        linkedHashMap.put("tab_code", str);
        linkedHashMap.put("dialog_id", homePreferencesConfig.getLabelId());
        String showStyle = homePreferencesConfig.getShowStyle();
        if (showStyle == null) {
            showStyle = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("show_style", showStyle);
        qi.h.a.p(SubTabFragment.INSTANCE.a(i), linkedHashMap);
    }

    public final void m(HomePreferencesConfig homePreferencesConfig, List list) {
        Intrinsics.h(homePreferencesConfig, "config");
        Intrinsics.h(list, "selectedOptions");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dialog_name", "preference_enter_pop");
        linkedHashMap.put("dialog_id", homePreferencesConfig.getLabelId());
        linkedHashMap.put("show_style", homePreferencesConfig.getShowStyle());
        linkedHashMap.put("module_name", "confirm");
        linkedHashMap.put("select_content", CollectionsKt.s0(list, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        qi.h.a.o("Trending", linkedHashMap);
    }

    public final void n(HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.h(homePreferencesConfig, "config");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dialog_name", "preference_enter_pop");
        linkedHashMap.put("dialog_id", homePreferencesConfig.getLabelId());
        linkedHashMap.put("show_style", homePreferencesConfig.getShowStyle());
        qi.h.a.p("Trending", linkedHashMap);
    }

    public final void o(HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.h(homePreferencesConfig, "config");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dialog_name", "preference_enter_pop");
        linkedHashMap.put("dialog_id", homePreferencesConfig.getLabelId());
        linkedHashMap.put("show_style", homePreferencesConfig.getShowStyle());
        linkedHashMap.put("module_name", "skip");
        qi.h.a.o("Trending", linkedHashMap);
    }

    public final void p(int i, String str, HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.h(str, "tabCode");
        Intrinsics.h(homePreferencesConfig, "config");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tab_id", String.valueOf(i));
        linkedHashMap.put("tab_code", str);
        linkedHashMap.put("opId", homePreferencesConfig.getLabelId());
        linkedHashMap.put("opt_id", homePreferencesConfig.getLabelId());
        linkedHashMap.put("item_type", "opt");
        linkedHashMap.put("opt_type", "Preferences");
        linkedHashMap.put("module_name", "close");
        String showStyle = homePreferencesConfig.getShowStyle();
        if (showStyle == null) {
            showStyle = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("show_style", showStyle);
        qi.h.a.o(SubTabFragment.INSTANCE.a(i), linkedHashMap);
    }

    public final void q(int i, String str, HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.h(str, "tabCode");
        Intrinsics.h(homePreferencesConfig, "config");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tab_id", String.valueOf(i));
        linkedHashMap.put("tab_code", str);
        linkedHashMap.put("opId", homePreferencesConfig.getLabelId());
        linkedHashMap.put("opt_id", homePreferencesConfig.getLabelId());
        linkedHashMap.put("item_type", "opt");
        linkedHashMap.put("opt_type", "Preferences");
        String showStyle = homePreferencesConfig.getShowStyle();
        if (showStyle == null) {
            showStyle = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("show_style", showStyle);
        qi.h.a.z(SubTabFragment.INSTANCE.a(i), linkedHashMap);
    }

    public final void r(int i, String str, HomePreferencesConfig homePreferencesConfig, List list) {
        Intrinsics.h(str, "tabCode");
        Intrinsics.h(homePreferencesConfig, "config");
        Intrinsics.h(list, "selectedOptions");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tab_id", String.valueOf(i));
        linkedHashMap.put("tab_code", str);
        linkedHashMap.put("opId", homePreferencesConfig.getLabelId());
        linkedHashMap.put("opt_id", homePreferencesConfig.getLabelId());
        linkedHashMap.put("item_type", "opt");
        linkedHashMap.put("opt_type", "Preferences");
        String showStyle = homePreferencesConfig.getShowStyle();
        if (showStyle == null) {
            showStyle = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("show_style", showStyle);
        linkedHashMap.put("module_name", "confirm");
        linkedHashMap.put("select_content", CollectionsKt.s0(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        qi.h.a.o(SubTabFragment.INSTANCE.a(i), linkedHashMap);
    }

    public final void s(OperateItem operateItem, String str, List list, long j, int i) {
        Intrinsics.h(operateItem, "operateItem");
        Intrinsics.h(list, "subjects");
        HashSet hashSet = e;
        if (CollectionsKt.b0(hashSet, operateItem.getOpId())) {
            return;
        }
        String opId = operateItem.getOpId();
        String str2 = BuildConfig.FLAVOR;
        if (opId == null) {
            opId = BuildConfig.FLAVOR;
        }
        hashSet.add(opId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("opt_type", str);
        String opId2 = operateItem.getOpId();
        if (opId2 == null) {
            opId2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("op_id", opId2);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            sb.append(((Subject) obj).getSubjectId());
            sb.append(",");
            i2 = i3;
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "toString(...)");
        linkedHashMap.put("subject_ids", StringsKt.r1(sb2, new char[]{','}));
        String title = operateItem.getTitle();
        if (title != null) {
            str2 = title;
        }
        linkedHashMap.put("title", str2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i);
        linkedHashMap.put("position", sb3.toString());
        linkedHashMap.put("browse_duration", String.valueOf(j));
        com.transsion.baselib.helper.a.a.e("Trending", linkedHashMap);
    }

    public final void t(OperateItem operateItem, String str, List list, long j, int i) {
        Intrinsics.h(operateItem, "operateItem");
        Intrinsics.h(list, "liveList");
        HashSet hashSet = e;
        if (CollectionsKt.b0(hashSet, operateItem.getOpId())) {
            return;
        }
        String opId = operateItem.getOpId();
        String str2 = BuildConfig.FLAVOR;
        if (opId == null) {
            opId = BuildConfig.FLAVOR;
        }
        hashSet.add(opId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "opt");
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("opt_type", str);
        String opId2 = operateItem.getOpId();
        if (opId2 == null) {
            opId2 = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("op_id", opId2);
        String title = operateItem.getTitle();
        if (title != null) {
            str2 = title;
        }
        linkedHashMap.put("title", str2);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            sb.append(((LiveListItem) obj).getMatchId());
            sb.append(",");
            i2 = i3;
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "toString(...)");
        linkedHashMap.put("match_ids", StringsKt.r1(sb2, new char[]{','}));
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i);
        linkedHashMap.put("position", sb3.toString());
        linkedHashMap.put("browse_duration", String.valueOf(j));
        com.transsion.baselib.helper.a.a.e("Trending", linkedHashMap);
    }
}
