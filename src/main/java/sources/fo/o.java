package fo;

import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.flow.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.ui.view.PostBaseItemView;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class o extends BaseItemProvider {
    private final String e;
    private final String f;
    private final RecyclerView.s g;

    public o(String str, String str2, RecyclerView.s sVar) {
        Intrinsics.h(sVar, "pool");
        this.e = str;
        this.f = str2;
        this.g = sVar;
    }

    private final void A(PostBaseItemView postBaseItemView, PostSubjectItem postSubjectItem, boolean z) {
        if (postBaseItemView != null) {
            postBaseItemView.refreshLike(z, postSubjectItem);
        }
    }

    public int l() {
        return MediaType.CONTENT_ALL.ordinal();
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(postSubjectItem, "item");
        Object obj = ((RecyclerView.a0) baseViewHolder).itemView;
        PostBaseItemView postBaseItemView = obj instanceof PostBaseItemView ? (PostBaseItemView) obj : null;
        if (postBaseItemView != null) {
            postBaseItemView.setPage(this.e, this.f);
            postBaseItemView.setData(postSubjectItem);
            postBaseItemView.setRecycledViewPool(this.g);
        }
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void f(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem, List list) {
        List data;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(postSubjectItem, "item");
        Intrinsics.h(list, "payloads");
        super.f(baseViewHolder, postSubjectItem, list);
        if (list.isEmpty()) {
            return;
        }
        Object v0 = CollectionsKt.v0(list);
        if (v0 instanceof Boolean) {
            try {
                Result.Companion companion = Result.Companion;
                BaseProviderMultiAdapter g = g();
                if (g != null && (data = g.getData()) != null) {
                    int adapterPosition = baseViewHolder.getAdapterPosition();
                    BaseProviderMultiAdapter g2 = g();
                    PostSubjectItem postSubjectItem2 = (PostSubjectItem) data.get(adapterPosition + (g2 != null ? g2.a0() : 0));
                    if (postSubjectItem2 != null) {
                        Object obj = ((RecyclerView.a0) baseViewHolder).itemView;
                        A(obj instanceof PostBaseItemView ? (PostBaseItemView) obj : null, postSubjectItem2, ((Boolean) v0).booleanValue());
                    }
                }
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
    }
}
