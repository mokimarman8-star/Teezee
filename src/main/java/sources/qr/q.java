package qr;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.noober.background.view.BLTextView;
import com.transsion.shorttv.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class q implements f4.a {
    private final LinearLayoutCompat a;
    public final AppCompatImageView b;
    public final LinearLayoutCompat c;
    public final TextView d;
    public final BLTextView e;

    private q(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat2, TextView textView, BLTextView bLTextView) {
        this.a = linearLayoutCompat;
        this.b = appCompatImageView;
        this.c = linearLayoutCompat2;
        this.d = textView;
        this.e = bLTextView;
    }

    public static q a(View view) {
        BLTextView a;
        int i = R.id.ivDefaultImage;
        AppCompatImageView a2 = f4.b.a(view, i);
        if (a2 != null) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
            i = R.id.tvDesc;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null && (a = f4.b.a(view, (i = R.id.tv_retry))) != null) {
                return new q(linearLayoutCompat, a2, linearLayoutCompat, textView, a);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
