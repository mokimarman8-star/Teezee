package ah;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class b extends SpannableString {
    public b() {
        super("");
    }

    public b(CharSequence charSequence) {
        super(charSequence);
    }

    public b(CharSequence charSequence, int i, int i2) {
        super(charSequence);
        d(i);
        c(i2);
    }

    public b a(Object... objArr) {
        return b(0, length(), objArr);
    }

    public b b(int i, int i2, Object... objArr) {
        if (i <= i2 && objArr != null && objArr.length != 0) {
            for (Object obj : objArr) {
                if (obj != null) {
                    super.setSpan(obj, i, i2, 33);
                }
            }
        }
        return this;
    }

    public b c(int i) {
        a(new ForegroundColorSpan(i));
        return this;
    }

    public b d(int i) {
        a(new AbsoluteSizeSpan(i, true));
        return this;
    }

    public b e(Typeface typeface) {
        a(new a(typeface));
        return this;
    }
}
