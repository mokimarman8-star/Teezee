package com.transsion.search.widget;

import com.transsion.flow.bean.PlayUrl;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.bean.GroupInfo;
import com.transsion.search.bean.HotSubject;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.BaseSearchMainFragment;
import com.transsion.search.fragment.hot.SearchHotFragment;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Group group, int i, long j, String str, String str2, String str3) {
            String groupId;
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_browse");
            String str4 = BuildConfig.FLAVOR;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("duration", String.valueOf(j));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (group != null && (groupId = group.getGroupId()) != null) {
                str4 = groupId;
            }
            hashMap.put("group_id", str4);
            hashMap.put("hasJoin", String.valueOf(group != null ? group.getHasJoin() : null));
            com.transsion.baselib.helper.a.a.e("searchresult", hashMap);
        }

        public final void b(Group group, int i, String str, String str2, String str3) {
            String groupId;
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_click");
            String str4 = BuildConfig.FLAVOR;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (group != null && (groupId = group.getGroupId()) != null) {
                str4 = groupId;
            }
            hashMap.put("group_id", str4);
            hashMap.put("hasJoin", String.valueOf(group != null ? group.getHasJoin() : null));
            com.transsion.baselib.helper.a.a.f("searchresult", hashMap);
        }

        public final void c() {
            com.transsion.baselib.helper.a.a.f(SearchHotFragment.PAGE_NAME, MapsKt.l(new Pair[]{TuplesKt.a("event_type", "history_delete"), TuplesKt.a("search_id", BaseSearchMainFragment.INSTANCE.a())}));
        }

        public final void d(boolean z) {
            HashMap hashMap = new HashMap();
            hashMap.put("isExpand", String.valueOf(z));
            hashMap.put("event_type", "history_expand");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            com.transsion.baselib.helper.a.a.f(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void e(String str, int i) {
            HashMap hashMap = new HashMap();
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("keyword", str);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("event_type", "history_browse");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            com.transsion.baselib.helper.a.a.a(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void f(String str, int i) {
            Intrinsics.h(str, "keyWord");
            HashMap hashMap = new HashMap();
            hashMap.put("keyword", str);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("event_type", "history_click");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            com.transsion.baselib.helper.a.a.f(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void g(String str, int i) {
            HashMap hashMap = new HashMap();
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("keyword", str);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("event_type", "hot_word_browse");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            com.transsion.baselib.helper.a.a.e(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void h(String str, int i) {
            Intrinsics.h(str, "keyword");
            HashMap hashMap = new HashMap();
            hashMap.put("keyword", str);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("event_type", "hot_word_click");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            com.transsion.baselib.helper.a.a.f(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void i(String str, String str2) {
            HashMap hashMap = new HashMap();
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("search_from", str2);
            hashMap.put("event_type", "result_empty");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            com.transsion.baselib.helper.a.a.e("searchresult", hashMap);
        }

        public final void j(VerticalRank verticalRank, int i, long j, String str, String str2, String str3) {
            String title;
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_browse");
            String str4 = BuildConfig.FLAVOR;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("duration", String.valueOf(j));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (verticalRank != null && (title = verticalRank.getTitle()) != null) {
                str4 = title;
            }
            hashMap.put("rank_title", str4);
            com.transsion.baselib.helper.a.a.e("searchresult", hashMap);
        }

        public final void k(VerticalRank verticalRank, int i, String str, String str2, String str3) {
            String title;
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_click");
            String str4 = BuildConfig.FLAVOR;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (verticalRank != null && (title = verticalRank.getTitle()) != null) {
                str4 = title;
            }
            hashMap.put("rank_title", str4);
            com.transsion.baselib.helper.a.a.f("searchresult", hashMap);
        }

        public final void l(GroupInfo groupInfo, int i, String str, int i2, boolean z) {
            Intrinsics.h(groupInfo, "group");
            Intrinsics.h(str, "parentCategory");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "hot_rank_browse");
            hashMap.put("group_id", groupInfo.getGroupId());
            hashMap.put("ops", groupInfo.getOps());
            hashMap.put("index", String.valueOf(i));
            hashMap.put("lowMemoryDevice", String.valueOf(z));
            hashMap.put("parentTitle", str);
            hashMap.put("parentIndex", String.valueOf(i2));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            com.transsion.baselib.helper.a.a.a(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void m(GroupInfo groupInfo, int i, String str, int i2, boolean z) {
            Intrinsics.h(groupInfo, "group");
            Intrinsics.h(str, "parentCategory");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "hot_rank_click");
            hashMap.put("group_id", groupInfo.getGroupId());
            hashMap.put("index", String.valueOf(i));
            hashMap.put("ops", groupInfo.getOps());
            hashMap.put("lowMemoryDevice", String.valueOf(z));
            hashMap.put("parentTitle", str);
            hashMap.put("parentIndex", String.valueOf(i2));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            com.transsion.baselib.helper.a.a.f(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void n(HotSubject hotSubject, int i, String str, int i2, boolean z) {
            Intrinsics.h(hotSubject, "hotSubject");
            Intrinsics.h(str, "parentCategory");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "hot_rank_browse");
            String subjectId = hotSubject.getSubjectId();
            String str2 = BuildConfig.FLAVOR;
            if (subjectId == null) {
                subjectId = BuildConfig.FLAVOR;
            }
            hashMap.put("subject_id", subjectId);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("subject_type", String.valueOf(hotSubject.getSubjectType()));
            String ops = hotSubject.getOps();
            if (ops != null) {
                str2 = ops;
            }
            hashMap.put("ops", str2);
            hashMap.put("lowMemoryDevice", String.valueOf(z));
            hashMap.put("parentTitle", str);
            hashMap.put("parentIndex", String.valueOf(i2));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            com.transsion.baselib.helper.a.a.a(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void o(HotSubject hotSubject, int i, String str, int i2, boolean z) {
            Intrinsics.h(hotSubject, "hotSubject");
            Intrinsics.h(str, "parentCategory");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "hot_rank_click");
            String subjectId = hotSubject.getSubjectId();
            String str2 = BuildConfig.FLAVOR;
            if (subjectId == null) {
                subjectId = BuildConfig.FLAVOR;
            }
            hashMap.put("subject_id", subjectId);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("subject_type", String.valueOf(hotSubject.getSubjectType()));
            String ops = hotSubject.getOps();
            if (ops != null) {
                str2 = ops;
            }
            hashMap.put("ops", str2);
            hashMap.put("lowMemoryDevice", String.valueOf(z));
            hashMap.put("parentTitle", str);
            hashMap.put("parentIndex", String.valueOf(i2));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            com.transsion.baselib.helper.a.a.f(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void p(String str, String str2, long j, int i) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_scroll_skip");
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("keyword", str2);
            hashMap.put("tabId", String.valueOf(str));
            hashMap.put("skip_item", String.valueOf(j));
            hashMap.put("fromIndex", String.valueOf(i));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            com.transsion.baselib.helper.a.a.f("searchresult", hashMap);
        }

        public final void q(String str, String str2) {
            Intrinsics.h(str, "keyword");
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            com.transsion.baselib.helper.a.a.b("searchresult", MapsKt.l(new Pair[]{TuplesKt.a("search_from", str2), TuplesKt.a("keyword", str), TuplesKt.a("event_type", "search"), TuplesKt.a("search_id", BaseSearchMainFragment.INSTANCE.a())}));
        }

        public final void r(Staff staff, int i, long j, String str, String str2, String str3) {
            String str4;
            String ops;
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_browse");
            String str5 = BuildConfig.FLAVOR;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("duration", String.valueOf(j));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (staff == null || (str4 = staff.getStaffId()) == null) {
                str4 = BuildConfig.FLAVOR;
            }
            hashMap.put("staff_id", str4);
            if (staff != null && (ops = staff.getOps()) != null) {
                str5 = ops;
            }
            hashMap.put("ops", str5);
            com.transsion.baselib.helper.a.a.e("searchresult", hashMap);
        }

        public final void s(Staff staff, int i, String str, String str2, String str3) {
            String str4;
            String ops;
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_click");
            String str5 = BuildConfig.FLAVOR;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (staff == null || (str4 = staff.getStaffId()) == null) {
                str4 = BuildConfig.FLAVOR;
            }
            hashMap.put("staff_id", str4);
            if (staff != null && (ops = staff.getOps()) != null) {
                str5 = ops;
            }
            hashMap.put("ops", str5);
            com.transsion.baselib.helper.a.a.f("searchresult", hashMap);
        }

        public final void t(Subject subject, int i, long j, String str, String str2, String str3) {
            String str4;
            String str5;
            String num;
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_browse");
            String str6 = BuildConfig.FLAVOR;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("duration", String.valueOf(j));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (subject == null || (str4 = subject.getSubjectId()) == null) {
                str4 = BuildConfig.FLAVOR;
            }
            hashMap.put("subject_id", str4);
            hashMap.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
            if (subject == null || (str5 = subject.getOps()) == null) {
                str5 = BuildConfig.FLAVOR;
            }
            hashMap.put("ops", str5);
            if (subject != null && (num = Integer.valueOf(subject.getSeason()).toString()) != null) {
                str6 = num;
            }
            hashMap.put("season", str6);
            com.transsion.baselib.helper.a.a.e("searchresult", hashMap);
        }

        public final void u(Subject subject, int i, String str, String str2, String str3) {
            String str4;
            String str5;
            String str6;
            String num;
            PlayUrl playUrl;
            PlayUrl playUrl2;
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_click");
            String str7 = BuildConfig.FLAVOR;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (subject == null || (str4 = subject.getSubjectId()) == null) {
                str4 = BuildConfig.FLAVOR;
            }
            hashMap.put("subject_id", str4);
            String str8 = null;
            hashMap.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
            if (subject == null || (str5 = subject.getOps()) == null) {
                str5 = BuildConfig.FLAVOR;
            }
            hashMap.put("ops", str5);
            String playUrl3 = (subject == null || (playUrl2 = subject.getPlayUrl()) == null) ? null : playUrl2.getPlayUrl();
            if (playUrl3 == null || playUrl3.length() == 0) {
                str6 = "NOT_URL";
            } else {
                if (subject != null && (playUrl = subject.getPlayUrl()) != null) {
                    str8 = playUrl.getUrlType();
                }
                str6 = String.valueOf(str8);
            }
            hashMap.put("jump_type", str6);
            if (subject != null && (num = Integer.valueOf(subject.getSeason()).toString()) != null) {
                str7 = num;
            }
            hashMap.put("season", str7);
            com.transsion.baselib.helper.a.a.f("searchresult", hashMap);
        }

        public final void v(SuggestEntity suggestEntity, Integer num, String str, String str2) {
            String str3;
            String str4;
            VerticalRank verticalRank;
            String title;
            Subject subject;
            Intrinsics.h(str, "keyWord");
            try {
                Result.Companion companion = Result.Companion;
                HashMap hashMap = new HashMap();
                hashMap.put("type", String.valueOf(suggestEntity != null ? suggestEntity.getType() : null));
                hashMap.put("key_word", str);
                String str5 = BuildConfig.FLAVOR;
                if (str2 == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                hashMap.put("ops", str2);
                if (suggestEntity == null || (str3 = suggestEntity.getWord()) == null) {
                    str3 = BuildConfig.FLAVOR;
                }
                hashMap.put("title", str3);
                if (suggestEntity == null || (subject = suggestEntity.getSubject()) == null || (str4 = subject.getSubjectId()) == null) {
                    str4 = BuildConfig.FLAVOR;
                }
                hashMap.put("subject_id", str4);
                if (suggestEntity != null && (verticalRank = suggestEntity.getVerticalRank()) != null && (title = verticalRank.getTitle()) != null) {
                    str5 = title;
                }
                hashMap.put("word", str5);
                hashMap.put("index", String.valueOf(num));
                hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
                h.a.z("search_suggest", hashMap);
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }

        public final void w(SuggestEntity suggestEntity, int i, String str, String str2) {
            String str3;
            String str4;
            String str5;
            Staff staff;
            String staffId;
            VerticalRank verticalRank;
            Subject subject;
            Intrinsics.h(str, "keyWord");
            try {
                Result.Companion companion = Result.Companion;
                HashMap hashMap = new HashMap();
                hashMap.put("type", String.valueOf(suggestEntity != null ? suggestEntity.getType() : null));
                hashMap.put("key_word", str);
                String str6 = BuildConfig.FLAVOR;
                if (str2 == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                hashMap.put("ops", str2);
                if (suggestEntity == null || (str3 = suggestEntity.getWord()) == null) {
                    str3 = BuildConfig.FLAVOR;
                }
                hashMap.put("title", str3);
                if (suggestEntity == null || (subject = suggestEntity.getSubject()) == null || (str4 = subject.getSubjectId()) == null) {
                    str4 = BuildConfig.FLAVOR;
                }
                hashMap.put("subject_id", str4);
                if (suggestEntity == null || (verticalRank = suggestEntity.getVerticalRank()) == null || (str5 = verticalRank.getTitle()) == null) {
                    str5 = BuildConfig.FLAVOR;
                }
                hashMap.put("word", str5);
                if (suggestEntity != null && (staff = suggestEntity.getStaff()) != null && (staffId = staff.getStaffId()) != null) {
                    str6 = staffId;
                }
                hashMap.put("staff_id", str6);
                hashMap.put("index", String.valueOf(i));
                hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
                h.a.o("search_suggest", hashMap);
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }

        public final void x(String str, String str2) {
            HashMap hashMap = new HashMap();
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("keyword", str);
            hashMap.put("tabId", String.valueOf(str2));
            hashMap.put("event_type", "result_tab_click");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            com.transsion.baselib.helper.a.a.f("searchresult", hashMap);
        }
    }
}
