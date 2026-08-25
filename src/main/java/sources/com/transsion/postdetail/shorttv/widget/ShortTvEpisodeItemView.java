package com.transsion.postdetail.shorttv.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.R$color;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$mipmap;
import com.transsion.push.PushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001e¨\u0006\""}, d2 = {"Lcom/transsion/postdetail/shorttv/widget/ShortTvEpisodeItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ep", BuildConfig.FLAVOR, "showIndex", "(I)V", BuildConfig.FLAVOR, PushConstants.PUSH_SERVICE_TYPE_SHOW, "showPlayingImg", "(Z)V", "showLockImg", "showDownloadStatus", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "lockImg", "c", "playingImg", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvEpisodeItemView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final TextView textView;

    /* renamed from: b, reason: from kotlin metadata */
    private final ImageView lockImg;

    /* renamed from: c, reason: from kotlin metadata */
    private final ImageView playingImg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShortTvEpisodeItemView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        TextView textView = new TextView(getContext());
        this.textView = textView;
        ImageView imageView = new ImageView(getContext());
        this.lockImg = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.playingImg = imageView2;
        textView.setBackgroundResource(R$drawable.post_detail_short_tv_episode_bg);
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.i = 0;
        addView(textView, bVar);
        textView.setTextSize(16.0f);
        textView.setTextColor(androidx.core.content.b.getColorStateList(getContext(), R$color.post_detail_short_tv_episode_tv_color));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        imageView.setImageResource(R$drawable.post_detail_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.i = 0;
        bVar2.v = 0;
        addView(imageView, bVar2);
        int e = com.blankj.utilcode.util.i.e(16.0f);
        int e2 = com.blankj.utilcode.util.i.e(4.0f);
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(e, e);
        bVar3.l = 0;
        bVar3.t = 0;
        bVar3.setMargins(e2, e2, e2, e2);
        imageView2.setColorFilter(androidx.core.content.b.getColor(getContext(), R.color.color_07B84E));
        addView(imageView2, bVar3);
        setPadding(e2, 0, e2, e2 * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShortTvEpisodeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        TextView textView = new TextView(getContext());
        this.textView = textView;
        ImageView imageView = new ImageView(getContext());
        this.lockImg = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.playingImg = imageView2;
        textView.setBackgroundResource(R$drawable.post_detail_short_tv_episode_bg);
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.i = 0;
        addView(textView, bVar);
        textView.setTextSize(16.0f);
        textView.setTextColor(androidx.core.content.b.getColorStateList(getContext(), R$color.post_detail_short_tv_episode_tv_color));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        imageView.setImageResource(R$drawable.post_detail_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.i = 0;
        bVar2.v = 0;
        addView(imageView, bVar2);
        int e = com.blankj.utilcode.util.i.e(16.0f);
        int e2 = com.blankj.utilcode.util.i.e(4.0f);
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(e, e);
        bVar3.l = 0;
        bVar3.t = 0;
        bVar3.setMargins(e2, e2, e2, e2);
        imageView2.setColorFilter(androidx.core.content.b.getColor(getContext(), R.color.color_07B84E));
        addView(imageView2, bVar3);
        setPadding(e2, 0, e2, e2 * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShortTvEpisodeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        TextView textView = new TextView(getContext());
        this.textView = textView;
        ImageView imageView = new ImageView(getContext());
        this.lockImg = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.playingImg = imageView2;
        textView.setBackgroundResource(R$drawable.post_detail_short_tv_episode_bg);
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.i = 0;
        addView(textView, bVar);
        textView.setTextSize(16.0f);
        textView.setTextColor(androidx.core.content.b.getColorStateList(getContext(), R$color.post_detail_short_tv_episode_tv_color));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        imageView.setImageResource(R$drawable.post_detail_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.i = 0;
        bVar2.v = 0;
        addView(imageView, bVar2);
        int e = com.blankj.utilcode.util.i.e(16.0f);
        int e2 = com.blankj.utilcode.util.i.e(4.0f);
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(e, e);
        bVar3.l = 0;
        bVar3.t = 0;
        bVar3.setMargins(e2, e2, e2, e2);
        imageView2.setColorFilter(androidx.core.content.b.getColor(getContext(), R.color.color_07B84E));
        addView(imageView2, bVar3);
        setPadding(e2, 0, e2, e2 * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShortTvEpisodeItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.h(context, "context");
        TextView textView = new TextView(getContext());
        this.textView = textView;
        ImageView imageView = new ImageView(getContext());
        this.lockImg = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.playingImg = imageView2;
        textView.setBackgroundResource(R$drawable.post_detail_short_tv_episode_bg);
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.i = 0;
        addView(textView, bVar);
        textView.setTextSize(16.0f);
        textView.setTextColor(androidx.core.content.b.getColorStateList(getContext(), R$color.post_detail_short_tv_episode_tv_color));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        imageView.setImageResource(R$drawable.post_detail_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.i = 0;
        bVar2.v = 0;
        addView(imageView, bVar2);
        int e = com.blankj.utilcode.util.i.e(16.0f);
        int e2 = com.blankj.utilcode.util.i.e(4.0f);
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(e, e);
        bVar3.l = 0;
        bVar3.t = 0;
        bVar3.setMargins(e2, e2, e2, e2);
        imageView2.setColorFilter(androidx.core.content.b.getColor(getContext(), R.color.color_07B84E));
        addView(imageView2, bVar3);
        setPadding(e2, 0, e2, e2 * 2);
    }

    public final void showDownloadStatus(boolean show) {
        this.lockImg.setImageResource(R$mipmap.post_detail_short_tv_downloaded);
        this.lockImg.setVisibility(show ? 0 : 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showIndex(int ep2) {
        if (ep2 == 0) {
            this.textView.setText(getContext().getString(com.transsion.postdetail.R.string.short_tv_trailer));
        } else {
            this.textView.setText(String.valueOf(ep2));
        }
    }

    public final void showLockImg(boolean show) {
        this.lockImg.setImageResource(R$drawable.post_detail_short_tv_lock);
        this.lockImg.setVisibility(show ? 0 : 8);
    }

    public final void showPlayingImg(boolean show) {
        if (show) {
            if (this.playingImg.getTag() == null) {
                this.playingImg.setTag("playing");
                Glide.with(this.playingImg).load(Integer.valueOf(R$drawable.post_detail_short_tv_playing)).into(this.playingImg);
            }
            uf.c.k(this.playingImg);
        } else {
            uf.c.g(this.playingImg);
        }
        this.textView.setSelected(show);
    }
}
