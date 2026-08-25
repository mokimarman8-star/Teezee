package com.transsnet.downloader.adapter;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R;
import com.transsnet.downloader.widget.DownloadView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/transsnet/downloader/adapter/v0;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", HttpUrl.FRAGMENT_ENCODE_SET, "datas", "<init>", "(Ljava/util/List;)V", "holder", HttpUrl.FRAGMENT_ENCODE_SET, "position", HttpUrl.FRAGMENT_ENCODE_SET, "w0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", WebConstants.FIELD_ITEM, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class v0 extends BaseQuickAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(List<Subject> datas) {
        super(R.layout.item_movie_rec, datas);
        Intrinsics.h(datas, "datas");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009d, code lost:
    
        if (r0.intValue() == 1) goto L32;
     */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void F(BaseViewHolder holder, Subject item) {
        String str;
        String thumbnail;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ShapeableImageView viewOrNull = holder.getViewOrNull(R.id.iv_cover);
        if (viewOrNull != null) {
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
        holder.setText(R.id.tv_score, item.getImdbRate());
        holder.setText(R.id.tv_title, item.getTitle());
        DownloadView viewOrNull2 = holder.getViewOrNull(R.id.download);
        if (viewOrNull2 != null) {
            if (ij.t.a.b()) {
                viewOrNull2.setShowPlayType();
            } else if (Intrinsics.c(item.getHasResource(), Boolean.TRUE)) {
                uf.c.k(viewOrNull2);
                ResourceDetectors resourceDetector = item.getResourceDetector();
                if (resourceDetector != null) {
                    String subjectId = item.getSubjectId();
                    String resourceId = resourceDetector.getResourceId();
                    Integer type = resourceDetector.getType();
                    boolean z = type != null;
                    DownloadView.setShowType$default(viewOrNull2, subjectId, resourceId, Boolean.valueOf(z), false, 0, 24, (Object) null);
                }
            } else {
                uf.c.g(viewOrNull2);
            }
        }
        AppCompatImageView viewOrNull3 = holder.getViewOrNull(R.id.icon_download);
        if (viewOrNull3 != null) {
            if (ij.t.a.b()) {
                uf.c.g(viewOrNull3);
            } else {
                uf.c.k(viewOrNull3);
            }
        }
        holder.getView(R.id.tv_download_corner).setTextWithType(item.getCorner(), item.getSubjectType());
    }

    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.h(holder, "holder");
        super.w0(holder, position);
        ConstraintLayout viewOrNull = holder.getViewOrNull(R.id.item);
        if (viewOrNull != null) {
            RecyclerView.n layoutParams = viewOrNull.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            RecyclerView.n nVar = layoutParams;
            if (position == 0) {
                nVar.setMarginStart(com.blankj.utilcode.util.a0.a(16.0f));
                nVar.setMarginEnd(0);
            } else if (position == getItemCount() - 1) {
                nVar.setMarginStart(com.blankj.utilcode.util.a0.a(8.0f));
                nVar.setMarginEnd(com.blankj.utilcode.util.a0.a(16.0f));
            } else {
                nVar.setMarginStart(com.blankj.utilcode.util.a0.a(8.0f));
                nVar.setMarginEnd(0);
            }
        }
    }
}
