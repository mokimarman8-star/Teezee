package xn;

import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.ui.adapter.e;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import qi.h;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private HashSet a;
    private String b;
    private String c;

    public a(String str, String str2) {
        Intrinsics.h(str, "page");
        Intrinsics.h(str2, "postId");
        this.b = str;
        this.c = str2;
    }

    public final void a(e eVar, int i, long j) {
        Boolean hasResource;
        Intrinsics.h(eVar, "adapter");
        if (i >= eVar.getData().size()) {
            return;
        }
        PostSubjectItem postSubjectItem = (PostSubjectItem) eVar.getItem(i);
        if (this.a == null) {
            this.a = new HashSet();
        }
        HashMap hashMap = new HashMap();
        HashSet hashSet = this.a;
        if (hashSet != null && hashSet.contains(postSubjectItem)) {
            a.a aVar = wf.a.a;
            String postId = postSubjectItem.getPostId();
            Media media = postSubjectItem.getMedia();
            a.a.f(aVar, "reportExposure", "trendFragment position:" + i + ",videoId: + " + postId + "  mediaType: " + (media != null ? media.getMediaType() : null), false, 4, (Object) null);
            return;
        }
        HashSet hashSet2 = this.a;
        if (hashSet2 != null) {
            hashSet2.add(postSubjectItem);
        }
        hashMap.put("post_id", postSubjectItem.getPostId());
        hashMap.put("origin_post_id", this.c);
        hashMap.put("sequence", String.valueOf(i));
        hashMap.put("item_type", postSubjectItem.getItemType());
        hashMap.put("ops", postSubjectItem.getOps());
        Media media2 = postSubjectItem.getMedia();
        hashMap.put("post_media_type", media2 != null ? media2.getMediaType() : null);
        Subject subject = postSubjectItem.getSubject();
        hashMap.put("subject_id", subject != null ? subject.getSubjectId() : null);
        Group group = postSubjectItem.getGroup();
        hashMap.put("group_id", group != null ? group.getGroupId() : null);
        hashMap.put("browse_duration", String.valueOf(j));
        Subject subject2 = postSubjectItem.getSubject();
        if (subject2 != null && (hasResource = subject2.getHasResource()) != null) {
            r2 = hasResource.toString();
        }
        hashMap.put("has_resource", r2);
        h.a.z(this.b, hashMap);
    }

    public final void b(int i, PostSubjectItem postSubjectItem) {
        Intrinsics.h(postSubjectItem, "item");
        HashMap hashMap = new HashMap();
        hashMap.put("post_id", postSubjectItem.getPostId());
        hashMap.put("origin_post_id", this.c);
        hashMap.put("sequence", String.valueOf(i));
        hashMap.put("item_type", postSubjectItem.getItemType());
        hashMap.put("ops", postSubjectItem.getOps());
        Media media = postSubjectItem.getMedia();
        hashMap.put("post_media_type", media != null ? media.getMediaType() : null);
        Subject subject = postSubjectItem.getSubject();
        hashMap.put("subject_id", subject != null ? subject.getSubjectId() : null);
        Group group = postSubjectItem.getGroup();
        hashMap.put("group_id", group != null ? group.getGroupId() : null);
        h.a.o(this.b, hashMap);
    }
}
