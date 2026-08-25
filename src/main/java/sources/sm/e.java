package sm;

import android.content.res.Resources;
import android.os.Build;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.R;
import com.transsion.flow.R$string;
import com.transsion.flow.h;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    private final void a(int i, SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.append(" ");
        int e = RangesKt.e(spannableStringBuilder.length() - 1, 0);
        spannableStringBuilder.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(Utils.a(), i, 2) : new ImageSpan(Utils.a(), i, 1), e, e + 1, 17);
    }

    private final void c(SpannableStringBuilder spannableStringBuilder, String str, int i) {
        if (str == null) {
            return;
        }
        int length = spannableStringBuilder.length();
        int length2 = str.length();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Utils.a().getResources().getColor(i)), length, length2 + length, 17);
    }

    static /* synthetic */ void d(e eVar, SpannableStringBuilder spannableStringBuilder, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = R.color.white_60;
        }
        eVar.c(spannableStringBuilder, str, i);
    }

    public final void b(SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.h(spannableStringBuilder, "span");
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(" I ");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Utils.a().getResources().getColor(R.color.white_20)), length, length + 3, 17);
    }

    public final SpannableString e(Subject subject) {
        String str;
        int indexOf;
        List R0;
        Intrinsics.h(subject, "subject");
        StringBuilder sb = new StringBuilder();
        String releaseDate = subject.getReleaseDate();
        String str2 = null;
        if (releaseDate != null) {
            str = releaseDate.substring(0, 4);
            Intrinsics.g(str, "substring(...)");
        } else {
            str = null;
        }
        String genre = subject.getGenre();
        if (genre != null && (R0 = StringsKt.R0(genre, new char[]{','}, false, 0, 6, (Object) null)) != null) {
            str2 = (String) CollectionsKt.k0(R0);
        }
        if (str != null && str.length() != 0) {
            sb.append(" | ");
            sb.append(str);
        }
        if (str2 != null) {
            sb.append(" | ");
            sb.append(str2);
        }
        SpannableString spannableString = new SpannableString(sb);
        if (str != null && str.length() != 0) {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Utils.a().getResources().getColor(R.color.white_20));
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(Utils.a().getResources().getColor(R.color.white_60));
            spannableString.setSpan(foregroundColorSpan, 0, 3, 17);
            spannableString.setSpan(foregroundColorSpan2, 3, str.length() + 3, 17);
        }
        if (str2 != null && (indexOf = sb.indexOf(str2)) >= 3) {
            ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(Utils.a().getResources().getColor(R.color.white_20));
            ForegroundColorSpan foregroundColorSpan4 = new ForegroundColorSpan(Utils.a().getResources().getColor(R.color.white_60));
            spannableString.setSpan(foregroundColorSpan3, indexOf - 3, indexOf, 17);
            spannableString.setSpan(foregroundColorSpan4, indexOf, sb.length(), 17);
        }
        return spannableString;
    }

    public final SpannableStringBuilder f(Subject subject) {
        String str;
        List<String> R0;
        Intrinsics.h(subject, "subject");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(BuildConfig.FLAVOR);
        a(h.a(subject.getSubjectType()), spannableStringBuilder);
        b(spannableStringBuilder);
        a(R.drawable.ic_category_star, spannableStringBuilder);
        c(spannableStringBuilder, subject.getImdbRate(), R.color.yellow_light_60);
        b(spannableStringBuilder);
        String releaseDate = subject.getReleaseDate();
        if (releaseDate != null) {
            str = releaseDate.substring(0, 4);
            Intrinsics.g(str, "substring(...)");
        } else {
            str = null;
        }
        d(this, spannableStringBuilder, str, 0, 4, null);
        String genre = subject.getGenre();
        if (genre != null && (R0 = StringsKt.R0(genre, new char[]{','}, false, 0, 6, (Object) null)) != null) {
            for (String str2 : R0) {
                e eVar = a;
                eVar.b(spannableStringBuilder);
                d(eVar, spannableStringBuilder, str2, 0, 4, null);
            }
        }
        return spannableStringBuilder;
    }

    public final String g(Integer num) {
        Resources resources = Utils.a().getResources();
        int value = SubjectType.TV.getValue();
        if (num != null && num.intValue() == value) {
            String string = resources.getString(R$string.subject_tv);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        int value2 = SubjectType.AUDIO.getValue();
        if (num == null || num.intValue() != value2) {
            int value3 = SubjectType.MUSIC.getValue();
            if (num == null || num.intValue() != value3) {
                int value4 = SubjectType.EDUCATION.getValue();
                if (num != null && num.intValue() == value4) {
                    String string2 = resources.getString(R$string.subject_education);
                    Intrinsics.g(string2, "getString(...)");
                    return string2;
                }
                String string3 = resources.getString(R$string.subject_movie);
                Intrinsics.g(string3, "getString(...)");
                return string3;
            }
        }
        String string4 = resources.getString(R$string.subject_music);
        Intrinsics.g(string4, "getString(...)");
        return string4;
    }
}
