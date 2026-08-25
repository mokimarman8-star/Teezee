package zp;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.fragment.result.ResultType;
import com.transsion.search.fragment.result.ResultWrapData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g extends BaseItemProvider {
    public int l() {
        return ResultType.TITLE.ordinal();
    }

    public int m() {
        return R$layout.provider_result_title;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, ResultWrapData resultWrapData) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(resultWrapData, "item");
        baseViewHolder.setText(R$id.search_result_provider_title, resultWrapData.getTitle());
    }
}
