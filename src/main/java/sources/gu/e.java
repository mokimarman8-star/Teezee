package gu;

import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class e {
    public static final UGCVideoBelongToCollection a(UGCVideoBelongToCollection uGCVideoBelongToCollection) {
        Intrinsics.h(uGCVideoBelongToCollection, "<this>");
        return new UGCVideoBelongToCollection(uGCVideoBelongToCollection.getCollectionId(), uGCVideoBelongToCollection.getCollectionName(), uGCVideoBelongToCollection.getVideoNum(), null, uGCVideoBelongToCollection.getDescImage(), 8, null);
    }
}
