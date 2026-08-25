package zp;

import android.text.SpannableStringBuilder;
import android.widget.ImageView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.fragment.result.ResultType;
import com.transsion.search.fragment.result.ResultWrapData;
import ij.k;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseItemProvider {
    public int l() {
        return ResultType.GROUP.ordinal();
    }

    public int m() {
        return R$layout.provider_result_group;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, ResultWrapData resultWrapData) {
        String str;
        List tags;
        Cover cover;
        String thumbnail;
        Cover cover2;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(resultWrapData, "item");
        f.b m = ni.f.a.m(k());
        Group groups = resultWrapData.getGroups();
        String str2 = BuildConfig.FLAVOR;
        if (groups == null || (cover2 = groups.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b g = m.g(str);
        Group groups2 = resultWrapData.getGroups();
        if (groups2 != null && (cover = groups2.getCover()) != null && (thumbnail = cover.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        g.l(str2).m(a0.a(50.0f)).d((ImageView) baseViewHolder.getView(R$id.search_result_provider_group_cover));
        int i = R$id.search_result_provider_group_title;
        Group groups3 = resultWrapData.getGroups();
        String str3 = null;
        baseViewHolder.setText(i, groups3 != null ? groups3.getName() : null);
        Group groups4 = resultWrapData.getGroups();
        if ((groups4 != null ? groups4.getUserCount() : null) != null) {
            Long userCount = resultWrapData.getGroups().getUserCount();
            if (userCount != null) {
                str3 = k.d(userCount.longValue());
            }
        } else {
            str3 = "0";
        }
        String string = k().getString(R.string.members, str3);
        Intrinsics.g(string, "getString(...)");
        baseViewHolder.setText(R$id.search_result_provider_group_member, string);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Group groups5 = resultWrapData.getGroups();
        if (groups5 != null && (tags = groups5.getTags()) != null) {
            int i2 = 0;
            for (Object obj : tags) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                spannableStringBuilder.append((CharSequence) obj);
                List tags2 = resultWrapData.getGroups().getTags();
                if (i2 < (tags2 != null ? tags2.size() : 0) - 1) {
                    spannableStringBuilder.append((CharSequence) "￼");
                    spannableStringBuilder.setSpan(com.transsion.search.f.b(k()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                }
                i2 = i3;
            }
        }
        if (spannableStringBuilder.length() > 0) {
            baseViewHolder.setText(R$id.search_result_provider_group_des, spannableStringBuilder);
            baseViewHolder.setVisible(R$id.search_result_provider_group_des, true);
        } else {
            baseViewHolder.setGone(R$id.search_result_provider_group_des, true);
        }
        Group groups6 = resultWrapData.getGroups();
        if (groups6 != null ? Intrinsics.c(groups6.getHasJoin(), Boolean.TRUE) : false) {
            baseViewHolder.setImageResource(R$id.search_result_provider_group_arrow, R$drawable.ic_result_arrow);
        } else {
            baseViewHolder.setImageResource(R$id.search_result_provider_group_arrow, R.mipmap.ic_room_join_def_white);
        }
    }
}
