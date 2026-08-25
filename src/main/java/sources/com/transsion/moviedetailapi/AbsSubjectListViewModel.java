package com.transsion.moviedetailapi;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.enum.PostListSource;
import com.transsion.moviedetailapi.enum.ProfileSubSource;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class AbsSubjectListViewModel extends androidx.lifecycle.b {
    public static final a j = new a((DefaultConstructorMarker) null);
    private final Lazy b;
    private final Lazy c;
    private final Lazy d;
    private final Lazy e;
    private final Lazy f;
    private final Lazy g;
    private String h;
    private PostRankType i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsSubjectListViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.moviedetailapi.a
            public final Object invoke() {
                tm.a L;
                L = AbsSubjectListViewModel.L();
                return L;
            }
        });
        this.c = LazyKt.b(new Function0() { // from class: com.transsion.moviedetailapi.b
            public final Object invoke() {
                b0 G;
                G = AbsSubjectListViewModel.G();
                return G;
            }
        });
        this.d = LazyKt.b(new Function0() { // from class: com.transsion.moviedetailapi.c
            public final Object invoke() {
                b0 j2;
                j2 = AbsSubjectListViewModel.j();
                return j2;
            }
        });
        this.e = LazyKt.b(new Function0() { // from class: com.transsion.moviedetailapi.d
            public final Object invoke() {
                b0 k;
                k = AbsSubjectListViewModel.k();
                return k;
            }
        });
        this.f = LazyKt.b(new Function0() { // from class: com.transsion.moviedetailapi.e
            public final Object invoke() {
                b0 D;
                D = AbsSubjectListViewModel.D();
                return D;
            }
        });
        this.g = LazyKt.b(new Function0() { // from class: com.transsion.moviedetailapi.f
            public final Object invoke() {
                b0 l;
                l = AbsSubjectListViewModel.l();
                return l;
            }
        });
        this.h = "";
        this.i = PostRankType.POST_RANK_TYPE_DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 D() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 G() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tm.a L() {
        return (tm.a) kg.c.e.a().h(tm.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 j() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 k() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 l() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final tm.a z() {
        return (tm.a) this.b.getValue();
    }

    public abstract PostListSource A();

    public ProfileSubSource B() {
        return null;
    }

    public void C(String str, int i) {
        i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new like.1(str, i, this, (Continuation) null), 3, (Object) null);
    }

    public abstract void E(boolean z);

    public abstract void F(Bundle bundle);

    public void H(PostSubjectItem postSubjectItem, int i) {
        String str;
        String value;
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.h(postSubjectItem, "postSubjectItem");
        HashMap hashMap = new HashMap();
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (str = subject.getSubjectId()) == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        Subject subject2 = postSubjectItem.getSubject();
        hashMap.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
        String postId = postSubjectItem.getPostId();
        if (postId == null) {
            postId = "";
        }
        hashMap.put("post_id", postId);
        Media media = postSubjectItem.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value);
        Group group = postSubjectItem.getGroup();
        if (group == null || (str2 = group.getGroupId()) == null) {
            str2 = "";
        }
        hashMap.put("group_id", str2);
        Subject subject3 = postSubjectItem.getSubject();
        if (subject3 == null || (str3 = subject3.getSubjectId()) == null) {
            str3 = "";
        }
        hashMap.put("subject_id", str3);
        String content = postSubjectItem.getContent();
        if (content == null) {
            content = "";
        }
        hashMap.put("link_url", content);
        Link link = postSubjectItem.getLink();
        if (link == null || (str4 = link.getUrl()) == null) {
            str4 = "";
        }
        hashMap.put("link_url", str4);
        User user = postSubjectItem.getUser();
        if (user == null || (str5 = user.getUserId()) == null) {
            str5 = "";
        }
        hashMap.put("avatar_user_id", str5);
        hashMap.put("sequence", String.valueOf(i));
        String ops = postSubjectItem.getOps();
        if (ops == null) {
            ops = "";
        }
        hashMap.put("ops", ops);
        hashMap.put("page_from", this.h);
        Map q = q(this.i.ordinal());
        if (q != null) {
            for (Map.Entry entry : q.entrySet()) {
                String str6 = (String) entry.getKey();
                String str7 = (String) entry.getValue();
                if (str7 == null) {
                    str7 = "";
                }
                hashMap.put(str6, str7);
            }
        }
        com.transsion.baselib.helper.a.a.e(w(this.i.ordinal()), hashMap);
    }

    public void I(PostSubjectItem postSubjectItem, int i, String str) {
        String str2;
        String value;
        String str3;
        String str4;
        String str5;
        String str6;
        Intrinsics.h(postSubjectItem, "postSubjectItem");
        Intrinsics.h(str, "subPageName");
        HashMap hashMap = new HashMap();
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (str2 = subject.getSubjectId()) == null) {
            str2 = "";
        }
        hashMap.put("subject_id", str2);
        Subject subject2 = postSubjectItem.getSubject();
        hashMap.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
        String postId = postSubjectItem.getPostId();
        if (postId == null) {
            postId = "";
        }
        hashMap.put("post_id", postId);
        Media media = postSubjectItem.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value);
        Group group = postSubjectItem.getGroup();
        if (group == null || (str3 = group.getGroupId()) == null) {
            str3 = "";
        }
        hashMap.put("group_id", str3);
        Subject subject3 = postSubjectItem.getSubject();
        if (subject3 == null || (str4 = subject3.getSubjectId()) == null) {
            str4 = "";
        }
        hashMap.put("subject_id", str4);
        String title = postSubjectItem.getTitle();
        if (title == null) {
            title = "";
        }
        hashMap.put("title", title);
        Link link = postSubjectItem.getLink();
        if (link == null || (str5 = link.getUrl()) == null) {
            str5 = "";
        }
        hashMap.put("link_url", str5);
        User user = postSubjectItem.getUser();
        if (user == null || (str6 = user.getUserId()) == null) {
            str6 = "";
        }
        hashMap.put("avatar_user_id", str6);
        hashMap.put("sequence", String.valueOf(i));
        String ops = postSubjectItem.getOps();
        if (ops == null) {
            ops = "";
        }
        hashMap.put("ops", ops);
        hashMap.put("page_from", this.h);
        hashMap.put("module_name", "item");
        hashMap.put("subpage_name", str);
        Map q = q(this.i.ordinal());
        if (q != null) {
            for (Map.Entry entry : q.entrySet()) {
                String str7 = (String) entry.getKey();
                String str8 = (String) entry.getValue();
                if (str8 == null) {
                    str8 = "";
                }
                hashMap.put(str7, str8);
            }
        }
        com.transsion.baselib.helper.a.a.f(w(this.i.ordinal()), hashMap);
    }

    public void J(PostSubjectItem postSubjectItem, int i, String str, String str2) {
        Intrinsics.h(postSubjectItem, "postSubjectItem");
        Intrinsics.h(str, "moduleName");
        Intrinsics.h(str2, "subPageName");
        Link link = postSubjectItem.getLink();
        K(postSubjectItem, i, str, link != null ? link.getUrl() : null, str2);
    }

    public void K(PostSubjectItem postSubjectItem, int i, String str, String str2, String str3) {
        String str4;
        String value;
        String value2;
        String str5;
        String str6;
        Intrinsics.h(postSubjectItem, "postSubjectItem");
        Intrinsics.h(str, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", str);
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("subpage_name", str3);
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (str4 = subject.getSubjectId()) == null) {
            str4 = "";
        }
        hashMap.put("subject_id", str4);
        Subject subject2 = postSubjectItem.getSubject();
        hashMap.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
        String postId = postSubjectItem.getPostId();
        if (postId == null) {
            postId = "";
        }
        hashMap.put("post_id", postId);
        Media media = postSubjectItem.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value);
        String itemType = postSubjectItem.getItemType();
        if (itemType == null) {
            itemType = PostItemType.SUBJECT.getValue();
        }
        hashMap.put("item_type", itemType);
        Media media2 = postSubjectItem.getMedia();
        if (media2 == null || (value2 = media2.getMediaType()) == null) {
            value2 = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value2);
        Group group = postSubjectItem.getGroup();
        if (group == null || (str5 = group.getGroupId()) == null) {
            str5 = "";
        }
        hashMap.put("group_id", str5);
        String title = postSubjectItem.getTitle();
        if (title == null) {
            title = "";
        }
        hashMap.put("title", title);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("link_url", str2);
        String ops = postSubjectItem.getOps();
        if (ops == null) {
            ops = "";
        }
        hashMap.put("ops", ops);
        hashMap.put("page_from", this.h);
        User user = postSubjectItem.getUser();
        if (user == null || (str6 = user.getUserId()) == null) {
            str6 = "";
        }
        hashMap.put("avatar_user_id", str6);
        hashMap.put("sequence", String.valueOf(i));
        Map u = u(this.i.ordinal());
        if (u != null) {
            for (Map.Entry entry : u.entrySet()) {
                String str7 = (String) entry.getKey();
                String str8 = (String) entry.getValue();
                if (str8 == null) {
                    str8 = "";
                }
                hashMap.put(str7, str8);
            }
        }
        com.transsion.baselib.helper.a.a.g(w(this.i.ordinal()), hashMap);
    }

    public final void M(PostRankType postRankType) {
        Intrinsics.h(postRankType, "<set-?>");
        this.i = postRankType;
    }

    public final void N(String str) {
        Intrinsics.h(str, "<set-?>");
        this.h = str;
    }

    public final void m(String str) {
        i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new deletePost.1(str, this, (Continuation) null), 3, (Object) null);
    }

    public final LiveData n() {
        return o();
    }

    protected final b0 o() {
        return (b0) this.d.getValue();
    }

    public final b0 p() {
        return (b0) this.g.getValue();
    }

    public Map q(int i) {
        return null;
    }

    public final LiveData r() {
        return s();
    }

    protected final b0 s() {
        return (b0) this.f.getValue();
    }

    public final PostRankType t() {
        return this.i;
    }

    public Map u(int i) {
        return null;
    }

    public final String v() {
        return this.h;
    }

    public String w(int i) {
        return "";
    }

    public final LiveData x() {
        return y();
    }

    protected final b0 y() {
        return (b0) this.c.getValue();
    }
}
