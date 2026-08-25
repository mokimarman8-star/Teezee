package com.transsion.usercenter.setting.adapter;

import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.SwitchButton;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g extends BaseItemProvider {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(BaseViewHolder baseViewHolder, View view) {
        baseViewHolder.getView(R$id.llRoot).performClick();
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void f(BaseViewHolder helper, jv.b item, List payloads) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.f(helper, item, payloads);
        SwitchButton viewOrNull = helper.getViewOrNull(R$id.switchBtn);
        if (viewOrNull != null) {
            viewOrNull.setChecked(item.f());
        }
    }

    public int l() {
        return 3;
    }

    public int m() {
        return R$layout.user_item_switch_setting;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder helper, jv.b item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        helper.getView(R$id.tvTitle).setTextById(item.i());
        TnTextView view = helper.getView(R$id.tvDes);
        String b = item.b();
        view.setVisibility(!(b == null || b.length() == 0) ? 0 : 8);
        if (view.getVisibility() == 0) {
            view.setText(item.b());
        }
        helper.getView(R$id.divider).setVisibility(item.d() ? 0 : 8);
        helper.getView(R$id.tvNew).setVisibility(item.e() ? 0 : 8);
        SwitchButton view2 = helper.getView(R$id.switchBtn);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.adapter.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                g.B(helper, view3);
            }
        });
        view2.setChecked(item.f());
        View viewOrNull = helper.getViewOrNull(R$id.bgView);
        if (viewOrNull != null) {
            Integer a = item.a();
            viewOrNull.setBackgroundResource(a != null ? a.intValue() : 0);
        }
    }
}
