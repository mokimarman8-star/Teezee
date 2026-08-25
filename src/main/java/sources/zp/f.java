package zp;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R;
import com.transsion.flow.h;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.fragment.result.ResultType;
import com.transsion.search.fragment.result.ResultWrapData;
import ij.t;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f extends BaseItemProvider {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(ResultWrapData resultWrapData, ImageView imageView, f fVar, BaseViewHolder baseViewHolder, View view) {
        Subject subject = resultWrapData.getSubject();
        Context context = imageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        com.transsion.search.f.d(subject, "searchresult", context, "search_result");
        BaseProviderMultiAdapter g = fVar.g();
        if (g instanceof com.transsion.search.fragment.result.adapter.a) {
            ((com.transsion.search.fragment.result.adapter.a) g).R1(resultWrapData.getSubject(), baseViewHolder.getBindingAdapterPosition());
        }
    }

    public int l() {
        return ResultType.SUBJECT.ordinal();
    }

    public int m() {
        return R$layout.provider_result_subject;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder baseViewHolder, final ResultWrapData resultWrapData) {
        String str;
        String str2;
        Subject subject;
        Subject subject2;
        List l;
        Subject subject3;
        Cover cover;
        Cover cover2;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(resultWrapData, "item");
        Subject subject4 = resultWrapData.getSubject();
        if (subject4 == null || !subject4.isMusicType()) {
            Resources resources = k().getResources();
            Intrinsics.g(resources, "getResources(...)");
            if (com.transsion.search.f.e(resources)) {
                ImageView imageView = (ImageView) baseViewHolder.getView(R$id.search_result_provider_subject_cover);
                imageView.getLayoutParams().width = a0.a(100.0f);
                imageView.getLayoutParams().height = a0.a(140.0f);
                imageView.setLayoutParams(imageView.getLayoutParams());
            } else {
                ImageView imageView2 = (ImageView) baseViewHolder.getView(R$id.search_result_provider_subject_cover);
                imageView2.getLayoutParams().width = a0.a(50.0f);
                imageView2.getLayoutParams().height = a0.a(70.0f);
                imageView2.setLayoutParams(imageView2.getLayoutParams());
                ((TextView) baseViewHolder.getView(R$id.search_result_provider_subject_title)).setMaxLines(2);
            }
        } else {
            ImageView imageView3 = (ImageView) baseViewHolder.getView(R$id.search_result_provider_subject_cover);
            Resources resources2 = imageView3.getResources();
            Intrinsics.g(resources2, "getResources(...)");
            if (com.transsion.search.f.e(resources2)) {
                imageView3.getLayoutParams().width = a0.a(160.0f);
                imageView3.getLayoutParams().height = a0.a(90.0f);
            } else {
                imageView3.getLayoutParams().width = a0.a(80.0f);
                imageView3.getLayoutParams().height = a0.a(45.0f);
            }
            imageView3.setLayoutParams(imageView3.getLayoutParams());
            ((TextView) baseViewHolder.getView(R$id.search_result_provider_subject_title)).setMaxLines(1);
        }
        f.b m = ni.f.a.m(k());
        Subject subject5 = resultWrapData.getSubject();
        String str3 = BuildConfig.FLAVOR;
        if (subject5 == null || (cover2 = subject5.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b m2 = m.g(str).m(a0.a(80.0f));
        Subject subject6 = resultWrapData.getSubject();
        if (subject6 == null || (cover = subject6.getCover()) == null || (str2 = cover.getThumbnail()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        m2.l(str2).d((ImageView) baseViewHolder.getView(R$id.search_result_provider_subject_cover));
        TextView textView = (TextView) baseViewHolder.getView(R$id.search_result_provider_subject_corner);
        Subject subject7 = resultWrapData.getSubject();
        String corner = subject7 != null ? subject7.getCorner() : null;
        if (corner == null || corner.length() == 0) {
            uf.c.h(textView);
        } else {
            Subject subject8 = resultWrapData.getSubject();
            textView.setText(subject8 != null ? subject8.getCorner() : null);
            uf.c.k(textView);
        }
        int i = R$id.search_result_provider_subject_title;
        Subject subject9 = resultWrapData.getSubject();
        baseViewHolder.setText(i, subject9 != null ? subject9.getTitle() : null);
        final ImageView imageView4 = (ImageView) baseViewHolder.getView(R$id.search_result_provider_subject_play);
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: zp.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.A(ResultWrapData.this, imageView4, this, baseViewHolder, view);
            }
        });
        t tVar = t.a;
        if (tVar.b() && (subject3 = resultWrapData.getSubject()) != null && subject3.isJumpBrowser()) {
            imageView4.setVisibility(0);
            imageView4.setImageResource(R$drawable.ic_result_arrow);
        } else if (!tVar.b() && (subject2 = resultWrapData.getSubject()) != null && subject2.isJumpBrowser()) {
            imageView4.setVisibility(4);
        } else if (!tVar.b() || (subject = resultWrapData.getSubject()) == null || subject.isShortTV()) {
            imageView4.setVisibility(0);
            imageView4.setImageResource(R$drawable.ic_result_download);
        } else {
            imageView4.setVisibility(0);
            imageView4.setImageResource(R$drawable.ic_result_play);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Context k = k();
        Subject subject10 = resultWrapData.getSubject();
        ImageSpan a = com.transsion.search.f.a(k, h.a(subject10 != null ? subject10.getSubjectType() : null));
        spannableStringBuilder.append((CharSequence) "￼");
        spannableStringBuilder.setSpan(a, 0, 1, 33);
        spannableStringBuilder.append((CharSequence) "￼");
        spannableStringBuilder.setSpan(com.transsion.search.f.b(k()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        Subject subject11 = resultWrapData.getSubject();
        if ((subject11 != null ? subject11.getImdbRate() : null) != null && !resultWrapData.getSubject().isMusicType()) {
            ImageSpan a2 = com.transsion.search.f.a(k(), R$drawable.ic_search_result_star);
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(a2, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.append((CharSequence) resultWrapData.getSubject().getImdbRate());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.blankj.utilcode.util.h.a(R.color.yellow_60));
            String imdbRate = resultWrapData.getSubject().getImdbRate();
            spannableStringBuilder.setSpan(foregroundColorSpan, spannableStringBuilder.length() - (imdbRate != null ? imdbRate.length() : 0), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(com.transsion.search.f.b(k()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        Subject subject12 = resultWrapData.getSubject();
        if ((subject12 != null ? subject12.getReleaseDate() : null) != null) {
            String releaseDate = resultWrapData.getSubject().getReleaseDate();
            if (releaseDate != null) {
                str3 = releaseDate;
            }
            if (str3.length() >= 4) {
                str3 = str3.substring(0, 4);
                Intrinsics.g(str3, "substring(...)");
            }
            spannableStringBuilder.append((CharSequence) str3);
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(com.transsion.search.f.b(k()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        Subject subject13 = resultWrapData.getSubject();
        if ((subject13 != null ? subject13.getCountryName() : null) != null) {
            spannableStringBuilder.append((CharSequence) resultWrapData.getSubject().getCountryName());
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(com.transsion.search.f.b(k()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        Subject subject14 = resultWrapData.getSubject();
        if ((subject14 != null ? subject14.getGenre() : null) != null) {
            String genre = resultWrapData.getSubject().getGenre();
            if (genre == null || (l = StringsKt.S0(genre, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                l = CollectionsKt.l();
            }
            if (!l.isEmpty()) {
                spannableStringBuilder.append((CharSequence) l.get(0));
            }
        }
        ((TextView) baseViewHolder.getView(R$id.search_result_provider_subject_brief)).setText(spannableStringBuilder);
        TextView textView2 = (TextView) baseViewHolder.getView(R$id.search_result_provider_subject_website);
        Subject subject15 = resultWrapData.getSubject();
        textView2.setVisibility((subject15 == null || !subject15.isJumpBrowser()) ? 8 : 0);
    }
}
