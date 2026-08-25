package com.transsion.usercenter.setting.adapter;

import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R;
import com.transsion.baseui.widget.text.GradientTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e extends BaseItemProvider {
    public int l() {
        return 1;
    }

    public int m() {
        return R$layout.user_item_setting;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, jv.b item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        helper.getView(R$id.tv_title).setTextById(item.i());
        helper.setText(R$id.tv_content, item.b()).setGone(R$id.progress_bar, !item.c()).setGone(R$id.tv_content, item.c());
        View viewOrNull = helper.getViewOrNull(R$id.divider);
        if (viewOrNull != null) {
            uf.c.j(viewOrNull, item.d());
        }
        View viewOrNull2 = helper.getViewOrNull(R$id.bgView);
        if (viewOrNull2 != null) {
            Integer a = item.a();
            viewOrNull2.setBackgroundResource(a != null ? a.intValue() : 0);
        }
        GradientTextView view = helper.getView(R$id.tv_tips);
        view.setEnableGradientColor(item.h());
        view.setTextColor(k().getResources().getColor(R.color.white_60));
        String g = item.g();
        if (g == null) {
            g = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        view.setText(g);
        String g2 = item.g();
        view.setVisibility(g2 != null && g2.length() > 0 ? 0 : 8);
    }
}
