package sp;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.c0;
import com.blankj.utilcode.util.u;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.bean.SearchSubject;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import zg.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseItemProvider {
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;

    public d(Context context) {
        Intrinsics.h(context, "context");
        int a = a0.a(104.0f);
        this.e = a;
        int a2 = a0.a(149.0f);
        this.f = a2;
        int a3 = a0.a(48.0f);
        this.g = a3;
        int e = h.a.e(context);
        this.h = e;
        int i = (e - a3) / 3;
        this.i = i;
        this.j = (int) (i * ((a2 * 1.0f) / a));
    }

    public int l() {
        return 0;
    }

    public int m() {
        return R$layout.item_works_layout_vertical;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, SearchSubject searchSubject) {
        String url;
        String str;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchSubject, "item");
        Context context = ((RecyclerView.a0) baseViewHolder).itemView.getContext();
        ImageView imageView = (ImageView) ((RecyclerView.a0) baseViewHolder).itemView.findViewById(R$id.ivCover);
        ConstraintLayout.b layoutParams = imageView.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = this.j;
        ((ViewGroup.MarginLayoutParams) bVar).width = this.i;
        Cover cover = searchSubject.getCover();
        if (cover != null && (url = cover.getUrl()) != null) {
            f.a aVar = f.a;
            Intrinsics.e(context);
            f.b c = aVar.m(context).g(url).m(this.i).c(this.j);
            Cover cover2 = searchSubject.getCover();
            if (cover2 == null || (str = cover2.getThumbnail()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b l = c.l(str);
            Intrinsics.e(imageView);
            l.d(imageView);
        }
        baseViewHolder.setText(R$id.tvSubject, searchSubject.getTitle());
        AppCompatTextView viewOrNull = baseViewHolder.getViewOrNull(R$id.tvSubjectYear);
        if (viewOrNull != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "  ");
            String releaseDate = searchSubject.getReleaseDate();
            if (releaseDate != null && releaseDate.length() != 0) {
                Date l2 = c0.l(searchSubject.getReleaseDate(), "yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(l2);
                spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
            }
            String[] a = u.a(searchSubject.getGenre(), ",");
            if (a != null) {
                for (String str2 : a) {
                    spannableStringBuilder.append((CharSequence) " / ").append((CharSequence) str2);
                }
            }
            String countryName = searchSubject.getCountryName();
            if (countryName != null && countryName.length() != 0) {
                spannableStringBuilder.append((CharSequence) " / ").append((CharSequence) searchSubject.getCountryName());
            }
            int a2 = com.transsion.flow.h.a(searchSubject.getSubjectType());
            spannableStringBuilder.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(context, a2, 2) : new ImageSpan(context, a2, 1), 0, 1, 34);
            viewOrNull.setText(spannableStringBuilder);
        }
        Integer seNum = searchSubject.getSeNum();
        int intValue = seNum != null ? seNum.intValue() : 0;
        baseViewHolder.setGone(R$id.tvSeasons, intValue < 2);
        baseViewHolder.setText(R$id.tvSeasons, context.getString(R$string.seasons, String.valueOf(intValue)));
        baseViewHolder.getView(R$id.ivSearchCorner).setTextWithType(searchSubject.getCorner(), searchSubject.getSubjectType());
    }
}
