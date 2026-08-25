package fo;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.flow.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class p extends BaseItemProvider {
    public int l() {
        return MediaType.ROOM_CACHE_LIST_END.ordinal();
    }

    public int m() {
        return R$layout.item_provider_room_post_cache_end_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(postSubjectItem, "item");
    }
}
