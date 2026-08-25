package com.transsnet.downloader.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ni.f;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/transsnet/downloader/adapter/w0;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", HttpUrl.FRAGMENT_ENCODE_SET, "dataList", "<init>", "(Ljava/util/List;)V", HttpUrl.FRAGMENT_ENCODE_SET, "C1", "()[I", "holder", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class w0 extends BaseQuickAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(List<Subject> dataList) {
        super(R.layout.item_movie_rec_footview, dataList);
        Intrinsics.h(dataList, "dataList");
    }

    private final int[] C1() {
        int a = com.blankj.utilcode.util.a0.a(6.0f);
        int a2 = com.blankj.utilcode.util.a0.a(8.0f);
        int i = com.transsion.baseui.util.b.a(getContext()) ? 4 : 3;
        int e = ((com.blankj.utilcode.util.y.e() - ((a * 2) * i)) - (a2 * 2)) / i;
        return new int[]{e, (int) (e * 1.3925234f)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, Subject item) {
        String str;
        String thumbnail;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        int[] C1 = C1();
        ShapeableImageView viewOrNull = holder.getViewOrNull(R.id.iv_cover);
        boolean z = true;
        if (viewOrNull != null) {
            ViewGroup.LayoutParams layoutParams = viewOrNull.getLayoutParams();
            layoutParams.width = C1[0];
            layoutParams.height = C1[1];
            viewOrNull.setLayoutParams(layoutParams);
            f.a aVar = ni.f.a;
            Context context = viewOrNull.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            Cover cover = item.getCover();
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (cover == null || (str = cover.getUrl()) == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            f.b g = m.g(str);
            Cover cover2 = item.getCover();
            if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
                str2 = thumbnail;
            }
            g.l(str2).d(viewOrNull);
        }
        holder.setText(R.id.tv_title, item.getTitle());
        AppCompatImageView viewOrNull2 = holder.getViewOrNull(R.id.icon_download);
        if (viewOrNull2 != null) {
            if (ij.t.a.b()) {
                uf.c.g(viewOrNull2);
            } else {
                uf.c.k(viewOrNull2);
            }
        }
        TextView textView = (TextView) holder.getViewOrNull(R.id.tv_download_foryou_corner);
        if (textView != null) {
            textView.setText(item.getCorner());
        }
        if (textView != null) {
            String corner = item.getCorner();
            if (corner != null && corner.length() != 0) {
                z = false;
            }
            textView.setVisibility(z ? 8 : 0);
        }
    }
}
