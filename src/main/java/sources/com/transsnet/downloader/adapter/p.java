package com.transsnet.downloader.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsnet.downloader.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class p extends BaseItemProvider {
    private final String e;

    public p() {
        String string = Utils.a().getString(R.string.available);
        Intrinsics.g(string, "getString(...)");
        this.e = string;
    }

    private final void A(BaseViewHolder baseViewHolder, boolean z) {
        ((ImageView) baseViewHolder.getView(R.id.iv_mb_check)).setSelected(z);
    }

    public int l() {
        return 1;
    }

    public int m() {
        return R.layout.item_download_res_path_phone_storage_mb;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, yw.b item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        int color = Utils.a().getResources().getColor(item.a() <= 0 ? com.tn.lib.widget.R.color.error_50 : com.tn.lib.widget.R.color.text_02);
        TextView textView = (TextView) helper.getView(R.id.tv_phone_storage_available_size);
        StringBuilder sb = new StringBuilder();
        sb.append(item.a() <= 0 ? "0Mb" : zg.b.a(item.a(), 2));
        sb.append(" ");
        sb.append(this.e);
        textView.setText(sb.toString());
        textView.setTextColor(color);
        A(helper, item.f());
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void f(BaseViewHolder helper, yw.b item, List payloads) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.f(helper, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof Boolean) {
            A(helper, ((Boolean) obj).booleanValue());
        }
    }
}
