package com.transsion.moviedetail.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.fragment.ForYouFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0015B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0012\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/transsion/moviedetail/adapter/c;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lt6/i;", "Lcom/transsion/moviedetail/fragment/ForYouFragment;", "fragment", BuildConfig.FLAVOR, "pageName", BuildConfig.FLAVOR, "spanCount", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", "subject", "<init>", "(Lcom/transsion/moviedetail/fragment/ForYouFragment;Ljava/lang/String;ILcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;Lcom/transsion/moviedetailapi/bean/Subject;)V", BuildConfig.FLAVOR, "data", "position", "N1", "(Ljava/util/List;I)I", "G", "a", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseProviderMultiAdapter<Subject> implements t6.i {
    public static final int H = 1002;
    public static final int I = -9901;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ForYouFragment forYouFragment, String str, int i, MovieDetailViewModel movieDetailViewModel, Subject subject) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        Intrinsics.h(forYouFragment, "fragment");
        Intrinsics.h(str, "pageName");
        Intrinsics.h(movieDetailViewModel, "movieDetailViewModel");
        F1(new ForYouSubjectProvider(subject, i));
        F1(new i(forYouFragment, str, movieDetailViewModel));
    }

    protected int N1(List<? extends Subject> data, int position) {
        Intrinsics.h(data, "data");
        Integer subjectType = data.get(position).getSubjectType();
        return (subjectType != null && subjectType.intValue() == -9901) ? I : H;
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
