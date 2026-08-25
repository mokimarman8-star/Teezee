package zp;

import android.widget.ImageView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.result.ResultType;
import com.transsion.search.fragment.result.ResultWrapData;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseItemProvider {
    public int l() {
        return ResultType.VERTICAL_RANK.ordinal();
    }

    public int m() {
        return R$layout.provider_result_rank;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, ResultWrapData resultWrapData) {
        String str;
        String str2;
        String description;
        Integer count;
        Cover cover;
        Cover cover2;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(resultWrapData, "item");
        f.b m = ni.f.a.m(k());
        VerticalRank verticalRank = resultWrapData.getVerticalRank();
        String str3 = BuildConfig.FLAVOR;
        if (verticalRank == null || (cover2 = verticalRank.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b g = m.g(str);
        VerticalRank verticalRank2 = resultWrapData.getVerticalRank();
        if (verticalRank2 == null || (cover = verticalRank2.getCover()) == null || (str2 = cover.getThumbnail()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        g.l(str2).m(a0.a(50.0f)).d((ImageView) baseViewHolder.getView(R$id.search_result_provider_rank_cover));
        int i = R$id.search_result_provider_rank_title;
        VerticalRank verticalRank3 = resultWrapData.getVerticalRank();
        baseViewHolder.setText(i, verticalRank3 != null ? verticalRank3.getTitle() : null);
        VerticalRank verticalRank4 = resultWrapData.getVerticalRank();
        int intValue = (verticalRank4 == null || (count = verticalRank4.getCount()) == null) ? 0 : count.intValue();
        if (intValue > 0) {
            str3 = k().getString(R.string.sources, Integer.valueOf(intValue));
        } else {
            VerticalRank verticalRank5 = resultWrapData.getVerticalRank();
            if (verticalRank5 != null && (description = verticalRank5.getDescription()) != null) {
                str3 = description;
            }
        }
        Intrinsics.e(str3);
        baseViewHolder.setText(R$id.search_result_provider_rank_subtitle, str3);
    }
}
