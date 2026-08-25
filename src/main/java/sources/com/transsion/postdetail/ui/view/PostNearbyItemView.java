package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLView;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/transsion/postdetail/ui/view/PostNearbyItemView;", "Lcom/transsion/postdetail/ui/view/PostBaseItemView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "res", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setHeaderData", BuildConfig.FLAVOR, "item", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "setSubjectAndRoomContent", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostNearbyItemView extends PostBaseItemView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostNearbyItemView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostNearbyItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostNearbyItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
    }

    @Override // com.transsion.postdetail.ui.view.PostBaseItemView
    public void setHeaderData(PostSubjectItem item) {
        Intrinsics.h(item, "item");
        ShapeableImageView shapeableImageView = getViewBinding().k;
        Intrinsics.g(shapeableImageView, "ivRoomCover");
        uf.c.g(shapeableImageView);
        ShapeableImageView shapeableImageView2 = getViewBinding().l;
        Intrinsics.g(shapeableImageView2, "ivUserAvatar");
        uf.c.g(shapeableImageView2);
        BLView bLView = getViewBinding().H;
        if (bLView != null) {
            uf.c.g(bLView);
        }
        ShapeableImageView shapeableImageView3 = getViewBinding().m;
        Intrinsics.g(shapeableImageView3, "ivUserAvatar2");
        uf.c.k(shapeableImageView3);
        BLView bLView2 = getViewBinding().I;
        if (bLView2 != null) {
            uf.c.k(bLView2);
        }
        setHeaderPostData(item, true);
    }

    @Override // com.transsion.postdetail.ui.view.PostBaseItemView
    public void setSubjectAndRoomContent(PostSubjectItem item) {
        Intrinsics.h(item, "item");
        setBottomSubjectAndRoomVisibility(item.getSubject() != null, item.getGroup() != null);
        if (item.getSubject() != null) {
            setBottomSubjectModuleData(item);
        }
        if (item.getGroup() != null) {
            Group group = item.getGroup();
            String name = group != null ? group.getName() : null;
            if (name == null || name.length() == 0) {
                return;
            }
            setBottomRoomModuleData(item);
        }
    }
}
