package zp;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$layout;
import com.transsion.search.fragment.result.ResultType;
import com.transsion.search.fragment.result.ResultWrapData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends BaseItemProvider {
    public int l() {
        return ResultType.MORE.ordinal();
    }

    public int m() {
        return R$layout.provider_result_more;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, ResultWrapData resultWrapData) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(resultWrapData, "item");
    }
}
