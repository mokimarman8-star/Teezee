package fo;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.helper.ShortTvImmVideoHelper;
import com.transsion.postdetail.ui.view.ShortTvImmVideoItemView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class y extends BaseItemProvider {
    private final Fragment e;
    private final String f;
    private final String g;
    private final boolean h;
    private final int i;
    private final int j;

    public y(Fragment fragment, String str, String str2, boolean z) {
        Intrinsics.h(fragment, "fragment");
        this.e = fragment;
        this.f = str;
        this.g = str2;
        this.h = z;
        this.i = 1;
        this.j = R$layout.item_short_tv_immersion_video;
    }

    public int l() {
        return this.i;
    }

    public int m() {
        return this.j;
    }

    public BaseViewHolder r(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        ShortTvImmVideoHelper.a aVar = ShortTvImmVideoHelper.k;
        if (!aVar.a().l().isEmpty()) {
            View view = (View) aVar.a().l().remove(0);
            if (view.getParent() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return new BaseViewHolder(view);
            }
        }
        return super.r(viewGroup, i);
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, Subject subject) {
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(subject, "item");
        ((ShortTvImmVideoItemView) baseViewHolder.getView(R$id.video_item)).setData(subject, this.e, Integer.valueOf(baseViewHolder.getAdapterPosition()), this.f, this.g, this.h);
    }
}
