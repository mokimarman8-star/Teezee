package xw;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.a0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ni.f;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g extends BaseItemProvider {
    private final float e;

    public g(float f) {
        this.e = f;
    }

    private final int A(DownloadBean downloadBean) {
        Iterator it = downloadBean.getSeriesList().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((DownloadBean) it.next()).isCheck()) {
                i++;
            }
        }
        return i;
    }

    private final void B(BaseViewHolder baseViewHolder, DownloadBean downloadBean) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_more_count);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_more);
        if (!downloadBean.isCheck()) {
            imageView.setImageResource(R.drawable.ic_download_group_unselected);
            uf.c.g(textView);
            return;
        }
        if (!downloadBean.isSeriesCollection()) {
            imageView.setImageResource(R.drawable.ic_download_group_selected);
            uf.c.g(textView);
        } else if (downloadBean.isSeriesAllCheck()) {
            imageView.setImageResource(R.drawable.ic_download_group_selected);
            uf.c.g(textView);
        } else {
            imageView.setImageResource(R.drawable.shape_transfer_select_icon_bg);
            uf.c.k(textView);
            int A = A(downloadBean);
            textView.setText(A > 99 ? "99+" : String.valueOf(A));
        }
    }

    public int l() {
        return 0;
    }

    public int m() {
        return R.layout.item_transfer_select_item;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, DownloadBean bean) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(bean, "bean");
        uf.c.g(helper.getView(R.id.iv_play));
        ProgressBar progressBar = (ProgressBar) helper.getViewOrNull(R.id.progress_bar);
        if (progressBar != null) {
            uf.c.g(progressBar);
        }
        ImageView imageView = (ImageView) helper.getView(R.id.iv_cover);
        String cover = bean.getCover();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (cover != null && !Intrinsics.c(imageView.getTag(), cover)) {
            imageView.setTag(cover);
            if (StringsKt.W(cover, "http", false, 2, null)) {
                f.a aVar = ni.f.a;
                Context context = imageView.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b g = aVar.m(context).g(cover);
                String thumbnail = bean.getThumbnail();
                if (thumbnail == null) {
                    thumbnail = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                g.l(thumbnail).d(imageView);
            } else {
                imageView.setImageBitmap(a0.a.d(cover));
            }
        }
        ((ImageView) helper.getView(R.id.iv_type)).setImageResource(DownloadUtil.a.r(bean));
        ((TextView) helper.getView(R.id.tv_name)).setText(bean.getTitleNameAppendResolution());
        TextView textView = (TextView) helper.getView(R.id.tv_ep);
        textView.setText(bean.getTitleNameAppendResolution());
        String epName = bean.getEpName();
        if (epName == null || epName.length() == 0) {
            uf.c.g(textView);
        } else {
            uf.c.k(textView);
            textView.setText(bean.getEpName());
        }
        Long size = bean.getSize();
        if (size != null) {
            String a = zg.b.a(size.longValue(), this.e == 12.0f ? 1 : 0);
            if (a != null) {
                str = a;
            }
        }
        if (bean.isSeriesCollection()) {
            uf.c.k(helper.getView(R.id.v_series_top_bg));
            uf.c.k(helper.getView(R.id.v_series_top_bg_2));
            TextView textView2 = (TextView) helper.getView(R.id.tv_file_size);
            textView2.setText(((RecyclerView.a0) helper).itemView.getContext().getString(R.string.download_files, Integer.valueOf(bean.getCount())) + " · " + str);
            textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(R.mipmap.ic_download_series, 0, 0, 0);
        } else {
            uf.c.g(helper.getView(R.id.v_series_top_bg));
            uf.c.g(helper.getView(R.id.v_series_top_bg_2));
            TextView textView3 = (TextView) helper.getView(R.id.tv_file_size);
            textView3.setText(str);
            textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        }
        B(helper, bean);
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void f(BaseViewHolder helper, DownloadBean item, List payloads) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.f(helper, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof DownloadBean) {
            B(helper, (DownloadBean) obj);
        }
    }
}
