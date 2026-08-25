package com.transsion.shorttv._channel.ui.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.category.adapter.l;
import com.transsion.home.category.adapter.m;
import com.transsion.push.bean.MsgStyle;
import com.transsion.shorttv._channel.model.ShortTvCategoryItemBean;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.bean.SubjectType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t6.f;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001dB1\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/transsion/shorttv/_channel/ui/adapter/b;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/shorttv/_channel/model/ShortTvCategoryItemBean;", "Lt6/i;", BuildConfig.FLAVOR, "datas", BuildConfig.FLAVOR, "pageName", "Lbr/b;", "exposure", "showType", "<init>", "(Ljava/util/List;Ljava/lang/String;Lbr/b;Ljava/lang/String;)V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", BuildConfig.FLAVOR, "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "G", "Lbr/b;", "H", "Ljava/lang/String;", "I", "a", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends BaseProviderMultiAdapter<ShortTvCategoryItemBean> implements i {
    public static final int J = 1;
    public static final int K = 2;
    public static final int L = 3;

    /* renamed from: G, reason: from kotlin metadata */
    private final br.b exposure;

    /* renamed from: H, reason: from kotlin metadata */
    private final String showType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<ShortTvCategoryItemBean> list, String str, br.b bVar, String str2) {
        super(list);
        Intrinsics.h(list, "datas");
        Intrinsics.h(str, "pageName");
        this.exposure = bVar;
        this.showType = str2;
        F1(new m(str));
        F1(new l());
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.B0(holder);
        br.b bVar = this.exposure;
        if (bVar != null) {
            LinearLayoutManager layoutManager = getRecyclerView().getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            br.b.h(bVar, layoutManager, holder.getAdapterPosition(), true, false, 8, null);
        }
    }

    protected int N1(List<ShortTvCategoryItemBean> data, int position) {
        Intrinsics.h(data, "data");
        Subject subject = data.get(position).getSubject();
        if (subject == null) {
            return 1;
        }
        if (subject.getNonAdDelegate() != null) {
            return 3;
        }
        Integer subjectType = subject.getSubjectType();
        return ((subjectType != null && subjectType.intValue() == SubjectType.MUSIC.getValue()) || Intrinsics.c(this.showType, MsgStyle.NATIVE_STANDARD) || Intrinsics.c(this.showType, "2")) ? 2 : 1;
    }

    public /* bridge */ /* synthetic */ f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
