package com.transsnet.downloader.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLTextView;
import com.tn.lib.widget.R;
import com.transsnet.downloader.R$color;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001f¨\u0006#"}, d2 = {"Lcom/transsnet/downloader/widget/DownloadShortTvEpItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", HttpUrl.FRAGMENT_ENCODE_SET, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ep", HttpUrl.FRAGMENT_ENCODE_SET, "showIndex", "(I)V", HttpUrl.FRAGMENT_ENCODE_SET, "select", "setSelect", "(Z)V", "show", "showLockImg", "showDownloadImg", "Lcom/noober/background/view/BLTextView;", "a", "Lcom/noober/background/view/BLTextView;", "textView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "lockImg", "c", "selectImg", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadShortTvEpItemView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final BLTextView textView;

    /* renamed from: b, reason: from kotlin metadata */
    private final ImageView lockImg;

    /* renamed from: c, reason: from kotlin metadata */
    private final ImageView selectImg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadShortTvEpItemView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        BLTextView bLTextView = new BLTextView(getContext());
        this.textView = bLTextView;
        ImageView imageView = new ImageView(getContext());
        this.lockImg = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.selectImg = imageView2;
        int a = com.blankj.utilcode.util.a0.a(4.0f);
        int a2 = com.blankj.utilcode.util.a0.a(6.0f);
        bLTextView.setBackground(new DrawableCreator.Builder().setCornersRadius(a).setSolidColor(getContext().getResources().getColor(R.color.white_10)).build());
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.i = 0;
        addView(bLTextView, bVar);
        bLTextView.setTextSize(16.0f);
        bLTextView.setTextColor(androidx.core.content.b.getColorStateList(getContext(), R$color.selector_download_short_tv_ep_text));
        bLTextView.setTypeface(Typeface.DEFAULT_BOLD);
        bLTextView.setGravity(17);
        imageView.setImageResource(com.transsnet.downloader.R.mipmap.ic_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.i = 0;
        bVar2.v = 0;
        addView(imageView, bVar2);
        imageView2.setImageDrawable(androidx.core.content.b.getDrawable(getContext(), com.transsnet.downloader.R.drawable.selector_download_group_check));
        int i = a2 * 2;
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(i, i);
        bVar3.v = 0;
        bVar3.l = 0;
        bVar3.setMarginEnd(a2);
        ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin = a2;
        addView(imageView2, bVar3);
        setPadding(a, 0, a, a * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadShortTvEpItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        BLTextView bLTextView = new BLTextView(getContext());
        this.textView = bLTextView;
        ImageView imageView = new ImageView(getContext());
        this.lockImg = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.selectImg = imageView2;
        int a = com.blankj.utilcode.util.a0.a(4.0f);
        int a2 = com.blankj.utilcode.util.a0.a(6.0f);
        bLTextView.setBackground(new DrawableCreator.Builder().setCornersRadius(a).setSolidColor(getContext().getResources().getColor(R.color.white_10)).build());
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.i = 0;
        addView(bLTextView, bVar);
        bLTextView.setTextSize(16.0f);
        bLTextView.setTextColor(androidx.core.content.b.getColorStateList(getContext(), R$color.selector_download_short_tv_ep_text));
        bLTextView.setTypeface(Typeface.DEFAULT_BOLD);
        bLTextView.setGravity(17);
        imageView.setImageResource(com.transsnet.downloader.R.mipmap.ic_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.i = 0;
        bVar2.v = 0;
        addView(imageView, bVar2);
        imageView2.setImageDrawable(androidx.core.content.b.getDrawable(getContext(), com.transsnet.downloader.R.drawable.selector_download_group_check));
        int i = a2 * 2;
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(i, i);
        bVar3.v = 0;
        bVar3.l = 0;
        bVar3.setMarginEnd(a2);
        ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin = a2;
        addView(imageView2, bVar3);
        setPadding(a, 0, a, a * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadShortTvEpItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        BLTextView bLTextView = new BLTextView(getContext());
        this.textView = bLTextView;
        ImageView imageView = new ImageView(getContext());
        this.lockImg = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.selectImg = imageView2;
        int a = com.blankj.utilcode.util.a0.a(4.0f);
        int a2 = com.blankj.utilcode.util.a0.a(6.0f);
        bLTextView.setBackground(new DrawableCreator.Builder().setCornersRadius(a).setSolidColor(getContext().getResources().getColor(R.color.white_10)).build());
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.i = 0;
        addView(bLTextView, bVar);
        bLTextView.setTextSize(16.0f);
        bLTextView.setTextColor(androidx.core.content.b.getColorStateList(getContext(), R$color.selector_download_short_tv_ep_text));
        bLTextView.setTypeface(Typeface.DEFAULT_BOLD);
        bLTextView.setGravity(17);
        imageView.setImageResource(com.transsnet.downloader.R.mipmap.ic_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.i = 0;
        bVar2.v = 0;
        addView(imageView, bVar2);
        imageView2.setImageDrawable(androidx.core.content.b.getDrawable(getContext(), com.transsnet.downloader.R.drawable.selector_download_group_check));
        int i2 = a2 * 2;
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(i2, i2);
        bVar3.v = 0;
        bVar3.l = 0;
        bVar3.setMarginEnd(a2);
        ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin = a2;
        addView(imageView2, bVar3);
        setPadding(a, 0, a, a * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadShortTvEpItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.h(context, "context");
        BLTextView bLTextView = new BLTextView(getContext());
        this.textView = bLTextView;
        ImageView imageView = new ImageView(getContext());
        this.lockImg = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.selectImg = imageView2;
        int a = com.blankj.utilcode.util.a0.a(4.0f);
        int a2 = com.blankj.utilcode.util.a0.a(6.0f);
        bLTextView.setBackground(new DrawableCreator.Builder().setCornersRadius(a).setSolidColor(getContext().getResources().getColor(R.color.white_10)).build());
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.i = 0;
        addView(bLTextView, bVar);
        bLTextView.setTextSize(16.0f);
        bLTextView.setTextColor(androidx.core.content.b.getColorStateList(getContext(), R$color.selector_download_short_tv_ep_text));
        bLTextView.setTypeface(Typeface.DEFAULT_BOLD);
        bLTextView.setGravity(17);
        imageView.setImageResource(com.transsnet.downloader.R.mipmap.ic_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.i = 0;
        bVar2.v = 0;
        addView(imageView, bVar2);
        imageView2.setImageDrawable(androidx.core.content.b.getDrawable(getContext(), com.transsnet.downloader.R.drawable.selector_download_group_check));
        int i3 = a2 * 2;
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(i3, i3);
        bVar3.v = 0;
        bVar3.l = 0;
        bVar3.setMarginEnd(a2);
        ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin = a2;
        addView(imageView2, bVar3);
        setPadding(a, 0, a, a * 2);
    }

    public final void setSelect(boolean select) {
        this.selectImg.setSelected(select);
    }

    public final void showDownloadImg(boolean show) {
        if (show) {
            uf.c.g(this.selectImg);
            this.lockImg.setImageResource(com.transsnet.downloader.R.mipmap.ic_short_tv_download_sub);
        }
        this.lockImg.setVisibility(show ? 0 : 8);
    }

    public final void showIndex(int ep) {
        this.textView.setText(String.valueOf(ep));
    }

    public final void showLockImg(boolean show) {
        if (show) {
            uf.c.g(this.selectImg);
            this.lockImg.setImageResource(com.transsnet.downloader.R.mipmap.ic_short_tv_lock);
        } else {
            uf.c.k(this.selectImg);
        }
        this.lockImg.setVisibility(show ? 0 : 8);
    }
}
