package xw;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R;
import com.transsnet.downloader.adapter.LayoutType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a extends BaseItemProvider {
    public int l() {
        return LayoutType.ALL_EP_BTN.ordinal();
    }

    public int m() {
        return R.layout.adapter_download_item_all_ep;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, DownloadBean item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
    }
}
