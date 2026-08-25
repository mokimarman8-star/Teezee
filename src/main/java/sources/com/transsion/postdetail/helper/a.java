package com.transsion.postdetail.helper;

import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.push.bean.MsgStyle;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public static /* synthetic */ void A(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "postdetail";
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        aVar.z(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void C(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "postdetail";
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        aVar.B(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void b(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "postdetail";
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        aVar.a(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void d(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "postdetail";
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        aVar.c(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void f(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "postdetail";
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        aVar.e(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void j(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "postdetail";
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        aVar.i(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void m(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "postdetail";
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        aVar.l(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void p(a aVar, PostSubjectItem postSubjectItem, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "postdetail";
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        aVar.o(postSubjectItem, z, str, str2);
    }

    private final void q(PostSubjectItem postSubjectItem, String str, String str2, String str3) {
        String str4;
        String str5;
        String value;
        String value2;
        String value3;
        String str6;
        String str7;
        String str8;
        String str9;
        User user;
        String userId;
        Link link;
        Group group;
        Media media;
        Media media2;
        Subject subject;
        Subject subject2;
        HashMap hashMap = new HashMap();
        if (str3 != null && str3.length() != 0) {
            hashMap.put("page_from", str3);
        }
        hashMap.put("module_name", str);
        String str10 = BuildConfig.FLAVOR;
        if (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null || (str4 = subject2.getSubjectId()) == null) {
            str4 = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str4);
        hashMap.put("has_resource", String.valueOf((postSubjectItem == null || (subject = postSubjectItem.getSubject()) == null) ? null : subject.getHasResource()));
        if (postSubjectItem == null || (str5 = postSubjectItem.getPostId()) == null) {
            str5 = BuildConfig.FLAVOR;
        }
        hashMap.put("post_id", str5);
        if (postSubjectItem == null || (media2 = postSubjectItem.getMedia()) == null || (value = media2.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value);
        if (postSubjectItem == null || (value2 = postSubjectItem.getItemType()) == null) {
            value2 = PostItemType.SUBJECT.getValue();
        }
        hashMap.put("item_type", value2);
        if (postSubjectItem == null || (media = postSubjectItem.getMedia()) == null || (value3 = media.getMediaType()) == null) {
            value3 = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value3);
        if (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null || (str6 = group.getGroupId()) == null) {
            str6 = BuildConfig.FLAVOR;
        }
        hashMap.put("group_id", str6);
        if (postSubjectItem == null || (str7 = postSubjectItem.getTitle()) == null) {
            str7 = BuildConfig.FLAVOR;
        }
        hashMap.put("title", str7);
        if (postSubjectItem == null || (link = postSubjectItem.getLink()) == null || (str8 = link.getUrl()) == null) {
            str8 = BuildConfig.FLAVOR;
        }
        hashMap.put("link_url", str8);
        if (postSubjectItem == null || (str9 = postSubjectItem.getOps()) == null) {
            str9 = BuildConfig.FLAVOR;
        }
        hashMap.put("ops", str9);
        if (postSubjectItem != null && (user = postSubjectItem.getUser()) != null && (userId = user.getUserId()) != null) {
            str10 = userId;
        }
        hashMap.put("avatar_user_id", str10);
        com.transsion.baselib.helper.a.a.g(str2, hashMap);
    }

    public static /* synthetic */ void s(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "postdetail";
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        aVar.r(postSubjectItem, str, str2);
    }

    public static /* synthetic */ void u(a aVar, PostSubjectItem postSubjectItem, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "postdetail";
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        aVar.t(postSubjectItem, str, str2);
    }

    public final void B(PostSubjectItem postSubjectItem, String str, String str2) {
        Intrinsics.h(str, "pageName");
        q(postSubjectItem, "subject", str, str2);
    }

    public final void a(PostSubjectItem postSubjectItem, String str, String str2) {
        Intrinsics.h(str, "pageName");
        q(postSubjectItem, "audio_play", str, str2);
    }

    public final void c(PostSubjectItem postSubjectItem, String str, String str2) {
        Intrinsics.h(str, "pageName");
        q(postSubjectItem, "avatar", str, str2);
    }

    public final void e(PostSubjectItem postSubjectItem, String str, String str2) {
        Intrinsics.h(str, "pageName");
        q(postSubjectItem, "comment", str, str2);
    }

    public final void g(String str, int i, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str4, "commentType");
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        Pair a2 = TuplesKt.a("comment_id", str2);
        Pair a3 = TuplesKt.a("position", String.valueOf(i));
        Pair a4 = TuplesKt.a("browse_duration", String.valueOf(j));
        Pair a5 = TuplesKt.a("module_name", "comment");
        if (str3 == null) {
            str3 = BuildConfig.FLAVOR;
        }
        Map m = MapsKt.m(new Pair[]{a2, a3, a4, a5, TuplesKt.a("topic_id", str3), TuplesKt.a("comment_type", str4)});
        if (str5 != null && str5.length() != 0) {
            m.put("page_from", str5);
        }
        if (str6 != null) {
            m.put("track_id", str6);
        }
        if (str7 != null) {
            m.put("parent_track_id", str7);
        }
        if (str8 != null) {
            m.put("parent_content_id", str8);
        }
        if (str9 != null) {
            m.put("content_id", str9);
        }
        if (str10 != null) {
            m.put("belong_to_collection_id", str10);
        }
        qi.h.a.z(str, m);
    }

    public final void h(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Intrinsics.h(str, "postId");
        Intrinsics.h(str2, "moduleName");
        Intrinsics.h(str3, "pageName");
        Intrinsics.h(str5, "commentType");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", str2);
        hashMap.put("topic_id", str);
        hashMap.put("comment_type", str5);
        if (str4 != null && str4.length() != 0) {
            hashMap.put("page_from", str4);
        }
        if (str6 != null) {
            hashMap.put("track_id", str6);
        }
        if (str7 != null) {
            hashMap.put("parent_track_id", str7);
        }
        if (str8 != null) {
            hashMap.put("parent_content_id", str8);
        }
        if (str9 != null) {
            hashMap.put("content_id", str9);
        }
        if (str10 != null) {
            hashMap.put("belong_to_collection_id", str10);
        }
        com.transsion.baselib.helper.a.a.g(str3, hashMap);
    }

    public final void i(PostSubjectItem postSubjectItem, String str, String str2) {
        Intrinsics.h(str, "pageName");
        q(postSubjectItem, "download", str, str2);
    }

    public final void k(PostSubjectItem postSubjectItem, String str, String str2) {
        Intrinsics.h(str, "pageName");
        q(postSubjectItem, "downloaded", str, str2);
    }

    public final void l(PostSubjectItem postSubjectItem, String str, String str2) {
        Intrinsics.h(str, "pageName");
        q(postSubjectItem, "group", str, str2);
    }

    public final void n(PostSubjectItem postSubjectItem, String str, String str2) {
        Intrinsics.h(str, "pageName");
        q(postSubjectItem, "image", str, str2);
    }

    public final void o(PostSubjectItem postSubjectItem, boolean z, String str, String str2) {
        Intrinsics.h(str, "pageName");
        q(postSubjectItem, z ? "dislike" : "like", str, str2);
    }

    public final void r(PostSubjectItem postSubjectItem, String str, String str2) {
        Intrinsics.h(str, "pageName");
        q(postSubjectItem, MediaItem.MUSIC_FLOAT_STATE_PAUSE, str, str2);
    }

    public final void t(PostSubjectItem postSubjectItem, String str, String str2) {
        Intrinsics.h(str, "pageName");
        q(postSubjectItem, MediaItem.MUSIC_FLOAT_STATE_PLAY, str, str2);
    }

    public final void v(String str, String str2, String str3, int i, long j, PostSubjectItem postSubjectItem, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        String value;
        Integer subjectType;
        Intrinsics.h(str2, "pageName");
        Intrinsics.h(str3, "subpageName");
        Intrinsics.h(postSubjectItem, "item");
        String postId = postSubjectItem.getPostId();
        String str9 = BuildConfig.FLAVOR;
        if (postId == null) {
            postId = BuildConfig.FLAVOR;
        }
        Pair a2 = TuplesKt.a("post_id", postId);
        Pair a3 = TuplesKt.a("position", String.valueOf(i));
        Pair a4 = TuplesKt.a("page_from", str);
        Pair a5 = TuplesKt.a("browse_duration", String.valueOf(j));
        Pair a6 = TuplesKt.a("subpage_name", str3);
        Pair a7 = TuplesKt.a("module_name", "item");
        Pair a8 = TuplesKt.a("is_cache_post", String.valueOf(postSubjectItem.isRoomCache()));
        User user = postSubjectItem.getUser();
        if (user == null || (str5 = user.getUserId()) == null) {
            str5 = BuildConfig.FLAVOR;
        }
        Pair a9 = TuplesKt.a("user_id", str5);
        if (str4 == null) {
            Group group = postSubjectItem.getGroup();
            str6 = group != null ? group.getGroupId() : null;
            if (str6 == null) {
                str6 = BuildConfig.FLAVOR;
            }
        } else {
            str6 = str4;
        }
        Pair a10 = TuplesKt.a("group_id", str6);
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (str7 = subject.getSubjectId()) == null) {
            str7 = BuildConfig.FLAVOR;
        }
        Pair a11 = TuplesKt.a("subject_id", str7);
        Subject subject2 = postSubjectItem.getSubject();
        if (subject2 == null || (subjectType = subject2.getSubjectType()) == null || (str8 = subjectType.toString()) == null) {
            str8 = BuildConfig.FLAVOR;
        }
        Pair a12 = TuplesKt.a("subject_type", str8);
        Pair a13 = TuplesKt.a("builtin", postSubjectItem.getBuiltIn() ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        Media media = postSubjectItem.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        Pair a14 = TuplesKt.a("post_media_type", value);
        String ops = postSubjectItem.getOps();
        if (ops != null) {
            str9 = ops;
        }
        qi.h.a.z(str2, MapsKt.m(new Pair[]{a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, TuplesKt.a("ops", str9)}));
    }

    public final void x(String str, String str2, String str3, int i, String str4, PostSubjectItem postSubjectItem, String str5) {
        String str6;
        String str7;
        String value;
        Integer subjectType;
        String num;
        Intrinsics.h(str2, "pageName");
        Intrinsics.h(str3, "subpageName");
        Intrinsics.h(str4, "moduleName");
        Intrinsics.h(postSubjectItem, "item");
        String postId = postSubjectItem.getPostId();
        String str8 = BuildConfig.FLAVOR;
        if (postId == null) {
            postId = BuildConfig.FLAVOR;
        }
        Pair a2 = TuplesKt.a("post_id", postId);
        Pair a3 = TuplesKt.a("position", String.valueOf(i));
        Pair a4 = TuplesKt.a("page_from", str);
        Pair a5 = TuplesKt.a("subpage_name", str3);
        Pair a6 = TuplesKt.a("module_name", str4);
        Pair a7 = TuplesKt.a("is_cache_post", String.valueOf(postSubjectItem.isRoomCache()));
        User user = postSubjectItem.getUser();
        if (user == null || (str6 = user.getUserId()) == null) {
            str6 = BuildConfig.FLAVOR;
        }
        Pair a8 = TuplesKt.a("user_id", str6);
        if (str5 == null) {
            Group group = postSubjectItem.getGroup();
            str5 = group != null ? group.getGroupId() : null;
            if (str5 == null) {
                str5 = BuildConfig.FLAVOR;
            }
        }
        Pair a9 = TuplesKt.a("group_id", str5);
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (str7 = subject.getSubjectId()) == null) {
            str7 = BuildConfig.FLAVOR;
        }
        Pair a10 = TuplesKt.a("subject_id", str7);
        Subject subject2 = postSubjectItem.getSubject();
        if (subject2 != null && (subjectType = subject2.getSubjectType()) != null && (num = subjectType.toString()) != null) {
            str8 = num;
        }
        Pair a11 = TuplesKt.a("subject_type", str8);
        Media media = postSubjectItem.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        qi.h.a.o(str2, MapsKt.m(new Pair[]{a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, TuplesKt.a("post_media_type", value), TuplesKt.a("ops", postSubjectItem.getOps())}));
    }

    public final void z(PostSubjectItem postSubjectItem, String str, String str2) {
        Intrinsics.h(str, "pageName");
        q(postSubjectItem, "share", str, str2);
    }
}
