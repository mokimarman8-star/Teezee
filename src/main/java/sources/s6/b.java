package s6;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.R$id;
import com.chad.library.R$layout;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class b extends a {
    @Override // s6.a
    public View getLoadComplete(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        return baseViewHolder.getView(R$id.load_more_load_complete_view);
    }

    @Override // s6.a
    public View getLoadEndView(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        return baseViewHolder.getView(R$id.load_more_load_end_view);
    }

    @Override // s6.a
    public View getLoadFailView(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        return baseViewHolder.getView(R$id.load_more_load_fail_view);
    }

    @Override // s6.a
    public View getLoadingView(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        return baseViewHolder.getView(R$id.load_more_loading_view);
    }

    @Override // s6.a
    public View getRootView(ViewGroup viewGroup) {
        Intrinsics.h(viewGroup, "parent");
        return u6.a.a(viewGroup, R$layout.brvah_quick_view_load_more);
    }
}
