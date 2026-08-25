package com.transsion.postdetail.shorttv.adapter;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.c0;
import com.blankj.utilcode.util.u;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.tn.lib.widget.R;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$mipmap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;
import r6.d;
import t6.h;
import t6.i;
import uf.c;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\r*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\r*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/transsion/postdetail/shorttv/adapter/ShortTVTrendingAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", BuildConfig.FLAVOR, "pageName", BuildConfig.FLAVOR, "isDownloadBtn", "<init>", "(Ljava/lang/String;Z)V", "Landroidx/appcompat/widget/AppCompatImageView;", "item", BuildConfig.FLAVOR, "E1", "(Landroidx/appcompat/widget/AppCompatImageView;Lcom/transsion/moviedetailapi/bean/Subject;)V", "F1", "holder", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "F", "Ljava/lang/String;", "G", "Z", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTVTrendingAdapter extends BaseQuickAdapter implements i {

    /* renamed from: F, reason: from kotlin metadata */
    private final String pageName;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isDownloadBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVTrendingAdapter(String str, boolean z) {
        super(R$layout.item_short_tv_trending, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(str, "pageName");
        this.pageName = str;
        this.isDownloadBtn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(BaseViewHolder baseViewHolder, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        ((RecyclerView.a0) baseViewHolder).itemView.performClick();
    }

    private final void E1(AppCompatImageView appCompatImageView, Subject subject) {
        kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new ShortTVTrendingAdapter$loadBuiltInCover$1(subject, appCompatImageView, null), 3, (Object) null);
    }

    private final void F1(AppCompatImageView appCompatImageView, Subject subject) {
        String str;
        String thumbnail;
        f.a aVar = f.a;
        Context context = appCompatImageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b m = aVar.m(context);
        Cover cover = subject.getCover();
        String str2 = BuildConfig.FLAVOR;
        if (cover == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b i = m.g(str).i(R.color.module_04);
        Cover cover2 = subject.getCover();
        if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        i.l(str2).d(appCompatImageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(final BaseViewHolder holder, Subject item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        if (item.getNonAdDelegate() != null) {
            ((FrameLayout) holder.getView(R$id.flAdContainer)).setVisibility(0);
            holder.getView(R$id.group).setVisibility(8);
            ow.b bVar = ow.b.a;
            Context context = getContext();
            BiddingNativeManager nonAdDelegate = item.getNonAdDelegate();
            r a = bVar.a(context, nonAdDelegate != null ? nonAdDelegate.getSceneId() : null);
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) holder.getViewOrNull(R$id.flAdContainer);
            if (nativeWrapperAdView != null) {
                BiddingNativeManager nonAdDelegate2 = item.getNonAdDelegate();
                BiddingNativeManager nonAdDelegate3 = item.getNonAdDelegate();
                nativeWrapperAdView.bindNativeView(nonAdDelegate2, a, nonAdDelegate3 != null ? nonAdDelegate3.k0() : null);
                return;
            }
            return;
        }
        ((FrameLayout) holder.getView(R$id.flAdContainer)).setVisibility(8);
        holder.getView(R$id.group).setVisibility(0);
        AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getView(R$id.iv_cover);
        if (item.getBuiltIn()) {
            E1(appCompatImageView, item);
        } else {
            F1(appCompatImageView, item);
        }
        TextView textView = (TextView) holder.getView(R$id.tv_title);
        textView.setText(item.getTitle());
        boolean z = new StaticLayout(item.getTitle(), textView.getPaint(), y.e() - a0.a(139.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() > 1;
        TextView textView2 = (TextView) holder.getView(R$id.tv_type);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String releaseDate = item.getReleaseDate();
        if (releaseDate != null && releaseDate.length() != 0) {
            Date l = c0.l(item.getReleaseDate(), "yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(l);
            spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
        }
        String[] a2 = u.a(item.getGenre(), ",");
        if (a2 != null) {
            for (String str : a2) {
                spannableStringBuilder.append((CharSequence) " · ").append((CharSequence) str);
            }
        }
        String countryName = item.getCountryName();
        if (countryName != null && countryName.length() != 0) {
            spannableStringBuilder.append((CharSequence) " · ").append((CharSequence) item.getCountryName());
        }
        textView2.setText(spannableStringBuilder);
        List tags = item.getTags();
        if (tags == null) {
            tags = new ArrayList();
        }
        RecyclerView view = holder.getView(R$id.rv_list);
        if (tags.isEmpty()) {
            c.g(view);
        } else {
            a aVar = new a(CollectionsKt.U0(tags));
            aVar.w1(new d() { // from class: com.transsion.postdetail.shorttv.adapter.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    ShortTVTrendingAdapter.D1(holder, baseQuickAdapter, view2, i);
                }
            });
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(view.getContext());
            flexboxLayoutManager.c0(0);
            flexboxLayoutManager.d0(1);
            flexboxLayoutManager.e0(0);
            view.setLayoutManager(flexboxLayoutManager);
            if (view.getItemDecorationCount() <= 0) {
                view.addItemDecoration(new tf.d(a0.a(4.0f)));
            }
            view.setAdapter(aVar);
            c.k(view);
        }
        TextView textView3 = (TextView) holder.getView(R$id.tv_desc);
        textView3.setMaxLines(z ? 1 : 2);
        String str2 = this.pageName;
        if (Intrinsics.c(str2, "minitv_explore")) {
            textView3.setText(item.getDescription());
        } else if (Intrinsics.c(str2, "minitv_favorite")) {
            textView3.setText(item.getTotalEpisode() + " EPs");
        }
        TextView textView4 = (TextView) holder.getView(R$id.btn_download);
        textView4.setText(this.isDownloadBtn ? Utils.a().getString(com.transsnet.downloader.R.string.str_download) : Utils.a().getString(com.transsion.baseui.R.string.play));
        textView4.setCompoundDrawablesWithIntrinsicBounds(this.isDownloadBtn ? com.transsnet.downloader.R.mipmap.ic_download_white : R$mipmap.ic_play_white_trending, 0, 0, 0);
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
