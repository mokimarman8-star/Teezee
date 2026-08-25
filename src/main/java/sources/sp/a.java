package sp;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SearchSubject;
import com.transsion.search.bean.VerticalRank;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseItemProvider {
    private final int e = a0.a(72.0f);
    private final int f = a0.a(96.0f);

    public int l() {
        return 1;
    }

    public int m() {
        return R$layout.item_associate_subject;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, SearchSubject searchSubject) {
        String str;
        Cover cover;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchSubject, "item");
        ShapeableImageView viewOrNull = baseViewHolder.getViewOrNull(R$id.ivCover);
        if (viewOrNull != null) {
            f.a aVar = f.a;
            VerticalRank verticalRank = searchSubject.getVerticalRank();
            if (verticalRank == null || (cover = verticalRank.getCover()) == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            String e = f.a.e(aVar, str, this.e, false, false, 12, null);
            Context context = viewOrNull.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(e).d(viewOrNull);
        }
        AppCompatTextView viewOrNull2 = baseViewHolder.getViewOrNull(R$id.tvTitle);
        if (viewOrNull2 != null) {
            VerticalRank verticalRank2 = searchSubject.getVerticalRank();
            viewOrNull2.setText(verticalRank2 != null ? verticalRank2.getTitle() : null);
        }
        AppCompatTextView viewOrNull3 = baseViewHolder.getViewOrNull(R$id.tvDes);
        if (viewOrNull3 != null) {
            VerticalRank verticalRank3 = searchSubject.getVerticalRank();
            viewOrNull3.setText(verticalRank3 != null ? verticalRank3.getDescription() : null);
        }
        View viewOrNull4 = baseViewHolder.getViewOrNull(R$id.divider);
        if (viewOrNull4 != null) {
            if (searchSubject.getShowDivider()) {
                uf.c.k(viewOrNull4);
            } else {
                uf.c.g(viewOrNull4);
            }
        }
    }
}
