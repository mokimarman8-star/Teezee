package com.transsion.search.fragment.group;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.bean.SearchSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u000fB\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/transsion/search/fragment/group/g0;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/search/bean/SearchSubject;", "Lt6/i;", BuildConfig.FLAVOR, "datas", "<init>", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "G", "a", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g0 extends BaseProviderMultiAdapter<SearchSubject> implements t6.i {
    private static String H = BuildConfig.FLAVOR;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(List<SearchSubject> list) {
        super(list);
        Intrinsics.h(list, "datas");
        F1(new sp.b());
    }

    protected int N1(List<SearchSubject> data, int position) {
        Intrinsics.h(data, "data");
        return data.get(position).getViewType();
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
