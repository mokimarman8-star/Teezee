package com.transsion.room.helper;

import com.transsion.flow.bean.RoomItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.push.bean.MsgStyle;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l {
    public static final l a = new l();

    private l() {
    }

    public final void a(String str) {
        Intrinsics.h(str, "pageName");
        qi.h.a.o(str, MapsKt.m(new Pair[]{TuplesKt.a("source", "my_room"), TuplesKt.a("module_name", "all")}));
    }

    public final void b(String str, RoomItem roomItem) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(roomItem, "item");
        Pair a2 = TuplesKt.a("source", "my_room");
        Pair a3 = TuplesKt.a("module_name", "item");
        String groupId = roomItem.getGroupId();
        if (groupId == null) {
            groupId = BuildConfig.FLAVOR;
        }
        qi.h.a.o(str, MapsKt.m(new Pair[]{a2, a3, TuplesKt.a("group_id", groupId), TuplesKt.a("ops", roomItem.getOps())}));
    }

    public final void c(String str, String str2, PostSubjectItem postSubjectItem) {
        String str3;
        String str4;
        String str5;
        String str6;
        String groupId;
        Integer subjectType;
        Intrinsics.h(str, "pageName");
        Intrinsics.h(postSubjectItem, "item");
        Pair a2 = TuplesKt.a("source", str2);
        Pair a3 = TuplesKt.a("module_name", "group");
        User user = postSubjectItem.getUser();
        String str7 = BuildConfig.FLAVOR;
        if (user == null || (str3 = user.getUserId()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        Pair a4 = TuplesKt.a("user_id", str3);
        String postId = postSubjectItem.getPostId();
        if (postId == null) {
            postId = BuildConfig.FLAVOR;
        }
        Pair a5 = TuplesKt.a("post_id", postId);
        Media media = postSubjectItem.getMedia();
        if (media == null || (str4 = media.getMediaType()) == null) {
            str4 = BuildConfig.FLAVOR;
        }
        Pair a6 = TuplesKt.a("post_media_type", str4);
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (str5 = subject.getSubjectId()) == null) {
            str5 = BuildConfig.FLAVOR;
        }
        Pair a7 = TuplesKt.a("subject_id", str5);
        Subject subject2 = postSubjectItem.getSubject();
        if (subject2 == null || (subjectType = subject2.getSubjectType()) == null || (str6 = subjectType.toString()) == null) {
            str6 = BuildConfig.FLAVOR;
        }
        Pair a8 = TuplesKt.a("subject_type", str6);
        Pair a9 = TuplesKt.a("is_cache_post", String.valueOf(postSubjectItem.isRoomCache()));
        Group group = postSubjectItem.getGroup();
        if (group != null && (groupId = group.getGroupId()) != null) {
            str7 = groupId;
        }
        qi.h.a.o(str, MapsKt.m(new Pair[]{a2, a3, a4, a5, a6, a7, a8, a9, TuplesKt.a("group_id", str7), TuplesKt.a("ops", postSubjectItem.getOps())}));
    }

    public final void d(String str, String str2) {
        Intrinsics.h(str, "pageName");
        qi.h.a.o(str, MapsKt.m(new Pair[]{TuplesKt.a("source", str2), TuplesKt.a("module_name", "all")}));
    }

    public final void e(String str, String str2, RoomItem roomItem) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "moduleName");
        Intrinsics.h(roomItem, "item");
        Pair a2 = TuplesKt.a("module_name", str2);
        String groupId = roomItem.getGroupId();
        if (groupId == null) {
            groupId = BuildConfig.FLAVOR;
        }
        qi.h.a.z(str, MapsKt.m(new Pair[]{a2, TuplesKt.a("group_id", groupId), TuplesKt.a("ops", roomItem.getOps())}));
    }

    public final void f(String str, String str2) {
        Intrinsics.h(str, "pageName");
        qi.h.a.o(str, MapsKt.m(new Pair[]{TuplesKt.a("source", str2), TuplesKt.a("module_name", "explore")}));
    }

    public final void g(String str, String str2, RoomItem roomItem) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(roomItem, "item");
        Pair a2 = TuplesKt.a("source", str2);
        Pair a3 = TuplesKt.a("module_name", "item");
        String groupId = roomItem.getGroupId();
        if (groupId == null) {
            groupId = BuildConfig.FLAVOR;
        }
        qi.h.a.o(str, MapsKt.m(new Pair[]{a2, a3, TuplesKt.a("group_id", groupId), TuplesKt.a("has_join", Intrinsics.c(roomItem.getHasJoin(), Boolean.TRUE) ? MsgStyle.CUSTOM_LEFT_PIC : "0"), TuplesKt.a("ops", roomItem.getOps())}));
    }

    public final void h(String str) {
        Intrinsics.h(str, "pageName");
        qi.h.a.o(str, MapsKt.m(new Pair[]{TuplesKt.a("opt_type", "room_list_more")}));
    }

    public final void i(String str, String str2, int i, long j, RoomItem roomItem) {
        Intrinsics.h(str2, "pageName");
        Intrinsics.h(roomItem, "item");
        String groupId = roomItem.getGroupId();
        if (groupId == null) {
            groupId = BuildConfig.FLAVOR;
        }
        qi.h.a.z(str2, MapsKt.m(new Pair[]{TuplesKt.a("group_id", groupId), TuplesKt.a("position", String.valueOf(i)), TuplesKt.a("page_from", str), TuplesKt.a("browse_duration", String.valueOf(j)), TuplesKt.a("module_name", "item"), TuplesKt.a("ops", roomItem.getOps())}));
    }

    public final void j(String str, String str2, int i, RoomItem roomItem) {
        Intrinsics.h(str2, "pageName");
        Intrinsics.h(roomItem, "item");
        String groupId = roomItem.getGroupId();
        if (groupId == null) {
            groupId = BuildConfig.FLAVOR;
        }
        qi.h.a.o(str2, MapsKt.m(new Pair[]{TuplesKt.a("group_id", groupId), TuplesKt.a("position", String.valueOf(i)), TuplesKt.a("page_from", str), TuplesKt.a("module_name", "item"), TuplesKt.a("ops", roomItem.getOps())}));
    }
}
