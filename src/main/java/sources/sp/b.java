package sp;

import android.content.Context;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.flow.h;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SearchSubject;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import sm.e;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends BaseItemProvider {
    public int l() {
        return 0;
    }

    public int m() {
        return R$layout.item_works_layout_room;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, SearchSubject searchSubject) {
        String url;
        String str;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchSubject, "item");
        Context context = ((RecyclerView.a0) baseViewHolder).itemView.getContext();
        ImageView imageView = (ImageView) ((RecyclerView.a0) baseViewHolder).itemView.findViewById(R$id.ivCover);
        Cover cover = searchSubject.getCover();
        if (cover != null && (url = cover.getUrl()) != null) {
            f.a aVar = f.a;
            Intrinsics.e(context);
            f.b g = aVar.m(context).g(url);
            Cover cover2 = searchSubject.getCover();
            if (cover2 == null || (str = cover2.getThumbnail()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b l = g.l(str);
            Intrinsics.e(imageView);
            l.d(imageView);
        }
        baseViewHolder.setText(R$id.tvSubject, searchSubject.getTitle());
        AppCompatTextView viewOrNull = baseViewHolder.getViewOrNull(R$id.tvTag);
        if (viewOrNull != null) {
            viewOrNull.setText(e.a.e(searchSubject));
            viewOrNull.setCompoundDrawablesWithIntrinsicBounds(h.a(searchSubject.getSubjectType()), 0, 0, 0);
        }
    }
}
