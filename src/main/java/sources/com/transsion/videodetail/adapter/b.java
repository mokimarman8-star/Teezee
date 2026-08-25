package com.transsion.videodetail.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u001a\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010!R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010!R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010\u001dR\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010\u001d¨\u0006."}, d2 = {"Lcom/transsion/videodetail/adapter/b;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/videodetail/bean/VideoDetailMediaSource;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", HttpUrl.FRAGMENT_ENCODE_SET, "subjectType", HttpUrl.FRAGMENT_ENCODE_SET, "isDynamicWidth", "layoutResId", "<init>", "(IZI)V", "holder", "isPlaying", HttpUrl.FRAGMENT_ENCODE_SET, "G1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Z)V", WebConstants.FIELD_ITEM, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/videodetail/bean/VideoDetailMediaSource;)V", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "payloads", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/videodetail/bean/VideoDetailMediaSource;Ljava/util/List;)V", "source", "F1", "(Lcom/transsion/videodetail/bean/VideoDetailMediaSource;)V", "H1", "F", "I", "D1", "()I", "G", "Z", "E1", "()Z", "H", "Lcom/transsion/videodetail/bean/VideoDetailMediaSource;", "playingMediaSource", "isMovie", "J", "isEdu", "K", "screenWidth", "L", "dp8", "VideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private final int subjectType;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isDynamicWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private VideoDetailMediaSource playingMediaSource;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isMovie;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isEdu;

    /* renamed from: K, reason: from kotlin metadata */
    private final int screenWidth;

    /* renamed from: L, reason: from kotlin metadata */
    private final int dp8;

    public b(int i, boolean z, int i2) {
        super(i2, (List) null, 2, (DefaultConstructorMarker) null);
        this.subjectType = i;
        this.isDynamicWidth = z;
        this.isMovie = i == SubjectType.MOVIE.getValue();
        this.isEdu = i == SubjectType.EDUCATION.getValue();
        this.dp8 = lj.a.b(8);
        this.screenWidth = Math.min(y.e(), y.c());
    }

    public /* synthetic */ b(int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? R$layout.item_video_detail_episode : i2);
    }

    private final void G1(BaseViewHolder holder, boolean isPlaying) {
        ((RecyclerView.a0) holder).itemView.setSelected(isPlaying);
        holder.getView(R$id.tvName).setVisibility(!isPlaying ? 0 : 8);
        holder.getView(R$id.tvNameSelected).setVisibility(isPlaying ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, VideoDetailMediaSource item) {
        VideoDetailMediaSource videoDetailMediaSource;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        if (this.isDynamicWidth || (this.isMovie && getItemCount() > 1)) {
            ViewGroup.LayoutParams layoutParams = ((RecyclerView.a0) holder).itemView.getLayoutParams();
            int i = this.screenWidth;
            int i2 = this.dp8;
            layoutParams.width = ((i - (i2 * 6)) / 6) - i2;
        }
        VideoDetailMediaSource videoDetailMediaSource2 = this.playingMediaSource;
        G1(holder, videoDetailMediaSource2 != null && videoDetailMediaSource2.getSe() == item.getSe() && (videoDetailMediaSource = this.playingMediaSource) != null && videoDetailMediaSource.getEp() == item.getEp());
        if (this.isEdu) {
            String format = new DecimalFormat("00").format(Integer.valueOf(item.getEp()));
            TextView textView = (TextView) holder.getView(R$id.tvName);
            textView.setEllipsize(format.length() > 20 ? TextUtils.TruncateAt.MIDDLE : null);
            textView.setText(format);
            GradientTextView view = holder.getView(R$id.tvNameSelected);
            view.setEllipsize(format.length() > 20 ? TextUtils.TruncateAt.MIDDLE : null);
            view.setText(format);
        } else {
            TextView textView2 = (TextView) holder.getView(R$id.tvName);
            String name = item.getName();
            textView2.setEllipsize((name != null ? name.length() : 0) > 20 ? TextUtils.TruncateAt.MIDDLE : null);
            String name2 = item.getName();
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (name2 == null) {
                name2 = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            textView2.setText(name2);
            GradientTextView view2 = holder.getView(R$id.tvNameSelected);
            String name3 = item.getName();
            view2.setEllipsize((name3 != null ? name3.length() : 0) > 20 ? TextUtils.TruncateAt.MIDDLE : null);
            String name4 = item.getName();
            if (name4 != null) {
                str = name4;
            }
            view2.setText(str);
        }
        View view3 = holder.getView(R$id.iv_download_status);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 0) {
            view3.setRotationY(0.0f);
        } else {
            view3.setRotationY(180.0f);
        }
        view3.setVisibility(item.getDownloadBean() != null ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void G(BaseViewHolder holder, VideoDetailMediaSource item, List<? extends Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.G(holder, item, payloads);
        if (item.getSe() == 0) {
            item.getEp();
        }
        G1(holder, Intrinsics.c(this.playingMediaSource, item));
    }

    /* renamed from: D1, reason: from getter */
    public final int getSubjectType() {
        return this.subjectType;
    }

    /* renamed from: E1, reason: from getter */
    public final boolean getIsDynamicWidth() {
        return this.isDynamicWidth;
    }

    public final void F1(VideoDetailMediaSource source) {
        this.playingMediaSource = source;
        notifyDataSetChanged();
    }

    public final void H1(VideoDetailMediaSource source) {
        int i;
        if (Intrinsics.c(this.playingMediaSource, source) || source == null) {
            return;
        }
        int i2 = 0;
        int i3 = -1;
        if (this.playingMediaSource != null) {
            Iterator it = getData().iterator();
            i = 0;
            while (it.hasNext()) {
                if (Intrinsics.c((VideoDetailMediaSource) it.next(), this.playingMediaSource)) {
                    break;
                } else {
                    i++;
                }
            }
        }
        i = -1;
        this.playingMediaSource = source;
        if (i >= 0) {
            notifyItemChanged(i, source);
        }
        Iterator it2 = getData().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            if (Intrinsics.c((VideoDetailMediaSource) it2.next(), source)) {
                i3 = i2;
                break;
            }
            i2++;
        }
        if (i3 >= 0) {
            notifyItemChanged(i3, source);
        }
    }
}
