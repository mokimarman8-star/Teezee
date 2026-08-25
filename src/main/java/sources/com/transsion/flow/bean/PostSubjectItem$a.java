package com.transsion.flow.bean;

import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostSubjectItem$a {
    private PostSubjectItem$a() {
    }

    public /* synthetic */ PostSubjectItem$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final PostSubjectItem a(PostSubjectItem postSubjectItem) {
        Intrinsics.h(postSubjectItem, "data");
        return new PostSubjectItem(postSubjectItem.getContent(), postSubjectItem.getCreatedAt(), postSubjectItem.getGroup(), postSubjectItem.getHasLike(), postSubjectItem.isSubjectRate(), postSubjectItem.getLink(), postSubjectItem.getMedia(), postSubjectItem.getPostId(), postSubjectItem.getStat(), postSubjectItem.getStatus(), postSubjectItem.getSubject(), postSubjectItem.getSubjectRate(), postSubjectItem.getTitle(), postSubjectItem.getUpdatedAt(), postSubjectItem.getUser(), postSubjectItem.getOps(), postSubjectItem.getItemType(), postSubjectItem.getBlur(), postSubjectItem.getTran_ops(), postSubjectItem.isCache(), (Float) null, (Float) null, (String) null, (String) null, false, (List) null, false, (BiddingNativeManager) null, postSubjectItem.getBuiltIn(), false, false, false, postSubjectItem.getHotComment(), -269484032, 0, (DefaultConstructorMarker) null);
    }
}
