package aq;

import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.c0;
import com.blankj.utilcode.util.u;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.flow.h;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.fragment.suggest.d;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseItemProvider {
    public int l() {
        return 1;
    }

    public int m() {
        return R$layout.fragment_search_suggest_movie_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, SuggestEntity suggestEntity) {
        String str;
        Integer seNum;
        String mKeyWord;
        Cover cover;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(suggestEntity, "item");
        f.b m = f.a.m(k());
        Subject subject = suggestEntity.getSubject();
        String str2 = BuildConfig.FLAVOR;
        if (subject == null || (cover = subject.getCover()) == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        m.g(str).d((ImageView) baseViewHolder.getView(R$id.ivCover));
        int i = R$id.tvTitle;
        d.Companion companion = com.transsion.search.fragment.suggest.d.INSTANCE;
        BaseProviderMultiAdapter g = g();
        com.transsion.search.fragment.suggest.d dVar = g instanceof com.transsion.search.fragment.suggest.d ? (com.transsion.search.fragment.suggest.d) g : null;
        if (dVar != null && (mKeyWord = dVar.getMKeyWord()) != null) {
            str2 = mKeyWord;
        }
        Subject subject2 = suggestEntity.getSubject();
        baseViewHolder.setText(i, companion.a(str2, subject2 != null ? subject2.getTitle() : null));
        AppCompatTextView viewOrNull = baseViewHolder.getViewOrNull(R$id.tvDes);
        if (viewOrNull != null) {
            Subject subject3 = suggestEntity.getSubject();
            Date l = c0.l(subject3 != null ? subject3.getReleaseDate() : null, "yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(l);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
            Subject subject4 = suggestEntity.getSubject();
            String[] a = u.a(subject4 != null ? subject4.getGenre() : null, ",");
            if (a != null) {
                for (String str3 : a) {
                    spannableStringBuilder.append((CharSequence) " · ").append((CharSequence) str3);
                }
            }
            Subject subject5 = suggestEntity.getSubject();
            if (!TextUtils.isEmpty(subject5 != null ? subject5.getCountryName() : null)) {
                SpannableStringBuilder append = spannableStringBuilder.append((CharSequence) " · ");
                Subject subject6 = suggestEntity.getSubject();
                append.append((CharSequence) (subject6 != null ? subject6.getCountryName() : null));
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append((CharSequence) "  ");
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder.toString());
            Subject subject7 = suggestEntity.getSubject();
            int a2 = h.a(subject7 != null ? subject7.getSubjectType() : null);
            spannableStringBuilder2.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(viewOrNull.getContext(), a2, 2) : new ImageSpan(viewOrNull.getContext(), a2, 1), 0, 1, 34);
            viewOrNull.setText(spannableStringBuilder2);
        }
        int i2 = R$id.tvScore;
        Subject subject8 = suggestEntity.getSubject();
        baseViewHolder.setText(i2, String.valueOf(subject8 != null ? subject8.getImdbRate() : null));
        Subject subject9 = suggestEntity.getSubject();
        int intValue = (subject9 == null || (seNum = subject9.getSeNum()) == null) ? 0 : seNum.intValue();
        baseViewHolder.setGone(R$id.tvSeasons, intValue <= 1);
        String string = k().getString(R$string.seasons, String.valueOf(intValue));
        Intrinsics.g(string, "getString(...)");
        baseViewHolder.setText(R$id.tvSeasons, z(string));
    }

    public final String z(String str) {
        Intrinsics.h(str, "input");
        List S0 = StringsKt.S0(str, new String[]{" "}, false, 0, 6, (Object) null);
        if (S0.size() != 2) {
            return BuildConfig.FLAVOR;
        }
        String lowerCase = (S0.get(1) + " " + S0.get(0)).toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
