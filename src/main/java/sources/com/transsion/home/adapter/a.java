package com.transsion.home.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.LayoutStyle;
import com.transsion.home.bean.MovieItem;
import com.transsion.home.p000enum.LayoutStyleEnum;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B1\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0015R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/transsion/home/adapter/a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/MovieItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", BuildConfig.FLAVOR, "dataList", "Lrk/b;", "listExposureHelper", "Lcom/transsion/home/bean/LayoutStyle;", "style", BuildConfig.FLAVOR, "rowCount", "<init>", "(Ljava/util/List;Lrk/b;Lcom/transsion/home/bean/LayoutStyle;I)V", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/MovieItem;)V", "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "E1", "F", "Lrk/b;", "G", "Lcom/transsion/home/bean/LayoutStyle;", "D1", "()Lcom/transsion/home/bean/LayoutStyle;", "F1", "(Lcom/transsion/home/bean/LayoutStyle;)V", "H", "I", "C1", "()I", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseQuickAdapter implements i {
    public static final int I = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final rk.b listExposureHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private LayoutStyle style;

    /* renamed from: H, reason: from kotlin metadata */
    private final int rowCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(List<MovieItem> list, rk.b bVar, LayoutStyle layoutStyle, int i) {
        super(R.layout.home_adapter_movie, list);
        Intrinsics.h(list, "dataList");
        this.listExposureHelper = bVar;
        this.style = layoutStyle;
        this.rowCount = i;
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.B0(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        rk.b bVar = this.listExposureHelper;
        if (bVar != null) {
            GridLayoutManager layoutManager = getRecyclerView().getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            bVar.h(layoutManager, bindingAdapterPosition, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0145, code lost:
    
        if (r3.intValue() != r5) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0169, code lost:
    
        r0 = r1;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0134, code lost:
    
        if (r6.intValue() != r8) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0167, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(r8, com.transsion.home.p000enum.LayoutStyleEnum.Square.getValue()) != false) goto L56;
     */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void F(BaseViewHolder holder, MovieItem item) {
        String str;
        String thumbnail;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        int a = a0.a(107.0f);
        int a2 = a0.a(149.0f);
        int a3 = a0.a(((this.rowCount - 1) * 8.0f) + 24.0f);
        int e = y.e();
        int i = (e - a3) / this.rowCount;
        int i2 = (int) (i * ((a2 * 1.0f) / a));
        int a4 = a0.a(((r6 - 1) * 8.0f) + 24.0f);
        a0.a(109.0f);
        a0.a(109.0f);
        int i3 = e - a4;
        int i4 = i3 / this.rowCount;
        int a5 = a0.a(164.0f);
        int a6 = a0.a(92.0f);
        int i5 = i3 / this.rowCount;
        int i6 = (int) (i5 * ((a6 * 1.0f) / a5));
        if (item.getNonAdDelegate() != null) {
            ow.b bVar = ow.b.a;
            Context context = getContext();
            BiddingNativeManager nonAdDelegate = item.getNonAdDelegate();
            r a7 = bVar.a(context, nonAdDelegate != null ? nonAdDelegate.getSceneId() : null);
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) holder.getViewOrNull(R.id.nativeView);
            if (nativeWrapperAdView != null) {
                BiddingNativeManager nonAdDelegate2 = item.getNonAdDelegate();
                BiddingNativeManager nonAdDelegate3 = item.getNonAdDelegate();
                nativeWrapperAdView.bindNativeView(nonAdDelegate2, a7, nonAdDelegate3 != null ? nonAdDelegate3.k0() : null);
            }
            ((FrameLayout) holder.getView(R.id.nativeView)).setVisibility(0);
            holder.getView(R.id.group).setVisibility(8);
            return;
        }
        ((FrameLayout) holder.getView(R.id.nativeView)).setVisibility(8);
        holder.getView(R.id.group).setVisibility(0);
        ImageView imageView = (ShapeableImageView) holder.getView(R.id.iv_cover);
        LayoutStyle layoutStyle = this.style;
        if (layoutStyle == null) {
            Integer subjectType = item.getSubjectType();
            SubjectType subjectType2 = SubjectType.AUDIO;
            int value = subjectType2.getValue();
            if (subjectType == null || subjectType.intValue() != value) {
                Integer subjectType3 = item.getSubjectType();
                int value2 = SubjectType.MOVIE.getValue();
                if (subjectType3 == null || subjectType3.intValue() != value2) {
                    Integer subjectType4 = item.getSubjectType();
                    int value3 = SubjectType.VSHOW.getValue();
                    if (subjectType4 == null || subjectType4.intValue() != value3) {
                        Integer subjectType5 = item.getSubjectType();
                        int value4 = SubjectType.TV.getValue();
                        if (subjectType5 == null || subjectType5.intValue() != value4) {
                            Integer subjectType6 = item.getSubjectType();
                            int value5 = SubjectType.SHORT_TV.getValue();
                            if (subjectType6 != null) {
                            }
                            i2 = i6;
                            i = i5;
                        }
                    }
                }
            }
            Integer subjectType7 = item.getSubjectType();
            int value6 = subjectType2.getValue();
            if (subjectType7 != null) {
            }
        } else {
            BiddingIntermediateMaterialBean shape = layoutStyle != null ? layoutStyle.getShape() : null;
            if (!Intrinsics.c(shape, LayoutStyleEnum.Horizontal.getValue())) {
            }
            i2 = i6;
            i = i5;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar2).height = i2;
        imageView.setLayoutParams(bVar2);
        f.b m = ni.f.a.m(getContext());
        Cover cover = item.getCover();
        String str2 = BuildConfig.FLAVOR;
        if (cover == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b c = m.g(str).i(com.tn.lib.widget.R.color.cl37).m(i).c(i2);
        Cover cover2 = item.getCover();
        if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        c.l(str2).d(imageView);
        holder.setText(R.id.tv_title, item.getTitle());
        holder.setText(R.id.tv_tabs, item.getGenre() + "•" + item.getCountryName());
        holder.setText(R.id.tv_score, item.getImdbRatingValue());
        holder.getView(R.id.tv_tips).setTextWithType(item.getCorner(), item.getSubjectType());
    }

    /* renamed from: C1, reason: from getter */
    public final int getRowCount() {
        return this.rowCount;
    }

    /* renamed from: D1, reason: from getter */
    public final LayoutStyle getStyle() {
        return this.style;
    }

    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        ShapeableImageView viewOrNull = holder.getViewOrNull(R.id.iv_cover);
        if (viewOrNull == null || viewOrNull.getContext() == null) {
            return;
        }
        Context context = viewOrNull.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || !activity.isDestroyed()) {
            Context context2 = viewOrNull.getContext();
            Activity activity2 = context2 instanceof Activity ? (Activity) context2 : null;
            if (activity2 == null || !activity2.isFinishing()) {
                Glide.with(viewOrNull.getContext()).clear(viewOrNull);
            }
        }
    }

    public final void F1(LayoutStyle layoutStyle) {
        this.style = layoutStyle;
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
