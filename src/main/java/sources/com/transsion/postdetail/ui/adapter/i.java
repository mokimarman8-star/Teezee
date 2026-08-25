package com.transsion.postdetail.ui.adapter;

import androidx.fragment.app.Fragment;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Subject;
import fo.x;
import fo.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0016B9\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/transsion/postdetail/ui/adapter/i;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lt6/i;", BuildConfig.FLAVOR, "dataList", "Landroidx/fragment/app/Fragment;", "fragment", BuildConfig.FLAVOR, "basePostId", "baseItemType", BuildConfig.FLAVOR, "attachToMain", "<init>", "(Ljava/util/List;Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/String;Z)V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "G", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i extends BaseProviderMultiAdapter<Subject> implements t6.i {
    public static final int H = 1;
    public static final int I = 2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(List<Subject> list, Fragment fragment, String str, String str2, boolean z) {
        super(CollectionsKt.U0(list));
        Intrinsics.h(list, "dataList");
        Intrinsics.h(fragment, "fragment");
        F1(new y(fragment, str, str2, z));
        F1(new x());
    }

    protected int N1(List<? extends Subject> data, int position) {
        Intrinsics.h(data, "data");
        return data.get(position).getNonAdDelegate() == null ? 1 : 2;
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
