package com.transsion.postdetail.ui.adapter;

import androidx.fragment.app.Fragment;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001aB_\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0017\u001a\u00020\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/transsion/postdetail/ui/adapter/d;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "Lt6/i;", BuildConfig.FLAVOR, "dataList", "Landroidx/fragment/app/Fragment;", "fragment", BuildConfig.FLAVOR, "videoLoadMore", BuildConfig.FLAVOR, "basePostId", "baseItemType", "attachToMain", "commentId", "pageFrom", "isFromDownloaded", "<init>", "(Ljava/util/List;Landroidx/fragment/app/Fragment;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "G", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseProviderMultiAdapter<PostSubjectItem> implements t6.i {
    public static final int H = 1;
    public static final int I = 2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(List<PostSubjectItem> list, Fragment fragment, boolean z, String str, String str2, boolean z2, String str3, String str4, boolean z3) {
        super(CollectionsKt.U0(list));
        Intrinsics.h(list, "dataList");
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(str3, "commentId");
        Intrinsics.h(str4, "pageFrom");
        F1(new fo.e(fragment, z, str, str2, z2, str3, str4, z3));
        F1(new fo.d());
    }

    public /* synthetic */ d(List list, Fragment fragment, boolean z, String str, String str2, boolean z2, String str3, String str4, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, fragment, z, str, str2, z2, (i & 64) != 0 ? BuildConfig.FLAVOR : str3, (i & 128) != 0 ? BuildConfig.FLAVOR : str4, (i & 256) != 0 ? false : z3);
    }

    protected int N1(List<PostSubjectItem> data, int position) {
        Intrinsics.h(data, "data");
        return data.get(position).getNonAdDelegate() == null ? 1 : 2;
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
