package com.transsion.search.fragment.hot.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.HotCover;
import com.transsion.search.bean.HotSubject;
import com.transsion.search.fragment.hot.SearchHotFragment;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ni.f;
import t6.i;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001f¨\u0006!"}, d2 = {"Lcom/transsion/search/fragment/hot/adapter/h;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/search/bean/HotSubject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", BuildConfig.FLAVOR, "parentCategory", BuildConfig.FLAVOR, "parentIndex", BuildConfig.FLAVOR, "isTabLayout", "<init>", "(Ljava/lang/String;IZ)V", "Landroid/view/View;", "view", "subject", "position", BuildConfig.FLAVOR, "F1", "(Landroid/view/View;Lcom/transsion/search/bean/HotSubject;I)V", "E1", "()I", "holder", "item", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/search/bean/HotSubject;)V", "F", "Ljava/lang/String;", "G", "I", "H", "Z", "mIsLowDevice", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h extends BaseQuickAdapter implements i {

    /* renamed from: F, reason: from kotlin metadata */
    private final String parentCategory;

    /* renamed from: G, reason: from kotlin metadata */
    private final int parentIndex;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean isTabLayout;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean mIsLowDevice;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(String str, int i, boolean z) {
        super(R$layout.item_search_hot_rank_inner, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(str, "parentCategory");
        this.parentCategory = str;
        this.parentIndex = i;
        this.isTabLayout = z;
        this.mIsLowDevice = ij.h.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(h hVar, HotSubject hotSubject, int i, View view) {
        Intrinsics.e(view);
        hVar.F1(view, hotSubject, i);
    }

    private final int E1() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? 8388613 : 8388611;
    }

    private final void F1(View view, HotSubject subject, int position) {
        com.transsion.search.widget.d.a.o(subject, position, this.parentCategory, this.parentIndex, this.mIsLowDevice);
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
            if (KeyboardUtils.g((Activity) context)) {
                Context context2 = getContext();
                Intrinsics.f(context2, "null cannot be cast to non-null type android.app.Activity");
                KeyboardUtils.d((Activity) context2);
            }
        }
        Integer subjectType = subject.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        if (subjectType == null || subjectType.intValue() != value) {
            Navigator c = TheRouter.c("/movie/detail");
            Integer subjectType2 = subject.getSubjectType();
            Navigator.x(c.F("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).K("id", subject.getSubjectId()).K("ops", subject.getOps()), view.getContext(), (mf.c) null, 2, (Object) null);
        } else {
            DownloadManagerApi a = DownloadManagerApi.j.a();
            FragmentActivity context3 = getContext();
            Intrinsics.f(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            DownloadManagerApi.e0(a, context3, SearchHotFragment.PAGE_NAME, BuildConfig.FLAVOR, subject.getOps(), "download_subject", false, (Subject) null, subject.getSubjectId(), (Boolean) null, 320, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, final HotSubject item) {
        String str;
        String str2;
        List l;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        final int g0 = g0(item);
        if (item.isMusicType()) {
            View view = holder.getView(R$id.search_hot_rank_item_image_linear);
            float f = this.isTabLayout ? 2 : 1;
            view.getLayoutParams().width = a0.a(80.0f * f);
            view.getLayoutParams().height = a0.a(f * 45.0f);
            view.setLayoutParams(view.getLayoutParams());
            ((TextView) holder.getView(R$id.search_hot_rank_item_title_text)).setMaxLines(1);
        }
        int i = R$drawable.bg_hot_subject_no4;
        if (g0 == 0) {
            i = R$drawable.bg_hot_subject_no1;
        } else if (g0 == 1) {
            i = R$drawable.bg_hot_subject_no2;
        } else if (g0 == 2) {
            i = R$drawable.bg_hot_subject_no3;
        }
        holder.setText(R$id.search_hot_rank_item_index_text, String.valueOf(g0 + 1));
        holder.setBackgroundResource(R$id.search_hot_rank_item_index_text, i);
        boolean z = this.mIsLowDevice;
        String str3 = BuildConfig.FLAVOR;
        if (z) {
            holder.setGone(R$id.search_hot_rank_item_image_linear, true);
        } else {
            f.b m = ni.f.a.m(getContext());
            HotCover cover = item.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b g = m.g(str);
            HotCover cover2 = item.getCover();
            if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            g.l(str2).m(a0.a(50.0f)).d((ImageView) holder.getView(R$id.search_hot_rank_item_image));
        }
        holder.setText(R$id.search_hot_rank_item_title_text, item.getTitle());
        ((TextView) holder.getView(R$id.search_hot_rank_item_title_text)).setGravity(E1());
        ((TextView) holder.getView(R$id.search_hot_rank_item_subtitle_text)).setGravity(E1());
        ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.hot.adapter.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h.D1(h.this, item, g0, view2);
            }
        });
        int i2 = R$id.search_hot_rank_item_corner;
        String corner = item.getCorner();
        holder.setGone(i2, corner == null || corner.length() == 0);
        int i3 = R$id.search_hot_rank_item_corner;
        String corner2 = item.getCorner();
        if (corner2 == null) {
            corner2 = BuildConfig.FLAVOR;
        }
        holder.setText(i3, corner2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ImageSpan a = com.transsion.search.f.a(getContext(), com.transsion.flow.h.a(item.getSubjectType()));
        spannableStringBuilder.append((CharSequence) "￼");
        spannableStringBuilder.setSpan(a, 0, 1, 33);
        spannableStringBuilder.append((CharSequence) "￼");
        spannableStringBuilder.setSpan(com.transsion.search.f.b(getContext()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        if (item.getImdbRatingValue() != null && !item.isMusicType()) {
            ImageSpan a2 = com.transsion.search.f.a(getContext(), R$drawable.ic_search_result_star);
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(a2, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.append((CharSequence) item.getImdbRatingValue());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.blankj.utilcode.util.h.a(R.color.yellow_60));
            String imdbRatingValue = item.getImdbRatingValue();
            spannableStringBuilder.setSpan(foregroundColorSpan, spannableStringBuilder.length() - (imdbRatingValue != null ? imdbRatingValue.length() : 0), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(com.transsion.search.f.b(getContext()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        if (item.getReleaseDate() != null) {
            String releaseDate = item.getReleaseDate();
            if (releaseDate != null) {
                str3 = releaseDate;
            }
            if (str3.length() >= 4) {
                str3 = str3.substring(0, 4);
                Intrinsics.g(str3, "substring(...)");
            }
            spannableStringBuilder.append((CharSequence) str3);
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(com.transsion.search.f.b(getContext()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        if (item.getCountryName() != null) {
            spannableStringBuilder.append((CharSequence) item.getCountryName());
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(com.transsion.search.f.b(getContext()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        if (item.getGenre() != null) {
            String genre = item.getGenre();
            if (genre == null || (l = StringsKt.S0(genre, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                l = CollectionsKt.l();
            }
            if (!l.isEmpty()) {
                spannableStringBuilder.append((CharSequence) l.get(0));
            }
        }
        ((TextView) holder.getView(R$id.search_hot_rank_item_subtitle_text)).setText(spannableStringBuilder);
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
