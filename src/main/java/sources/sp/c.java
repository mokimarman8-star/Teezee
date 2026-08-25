package sp;

import android.content.Context;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.flow.h;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import sm.e;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseItemProvider {
    public int l() {
        return 1;
    }

    public int m() {
        return R$layout.item_works_layout_room;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, VideoDetailPlayBean videoDetailPlayBean) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(videoDetailPlayBean, "item");
        Context context = ((RecyclerView.a0) baseViewHolder).itemView.getContext();
        ImageView imageView = (ImageView) ((RecyclerView.a0) baseViewHolder).itemView.findViewById(R$id.ivCover);
        String coverUrl = videoDetailPlayBean.getCoverUrl();
        if (coverUrl != null) {
            f.a aVar = f.a;
            Intrinsics.e(context);
            f.b g = aVar.m(context).g(coverUrl);
            String thumbnail = videoDetailPlayBean.getThumbnail();
            if (thumbnail == null) {
                thumbnail = BuildConfig.FLAVOR;
            }
            f.b l = g.l(thumbnail);
            Intrinsics.e(imageView);
            l.d(imageView);
        }
        baseViewHolder.setText(R$id.tvSubject, videoDetailPlayBean.getTitle());
        AppCompatTextView viewOrNull = baseViewHolder.getViewOrNull(R$id.tvTag);
        if (viewOrNull != null) {
            viewOrNull.setText(" " + e.a.g(videoDetailPlayBean.getSubjectType()));
            viewOrNull.setCompoundDrawablesWithIntrinsicBounds(h.a(videoDetailPlayBean.getSubjectType()), 0, 0, 0);
        }
    }
}
