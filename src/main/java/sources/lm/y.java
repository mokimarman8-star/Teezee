package lm;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.moviedetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class y implements f4.a {
    private final LinearLayoutCompat a;
    public final AppCompatImageView b;
    public final TextView c;
    public final TextView d;

    private y(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.a = linearLayoutCompat;
        this.b = appCompatImageView;
        this.c = textView;
        this.d = textView2;
    }

    public static y a(View view) {
        int i = R$id.ivDefaultImage;
        AppCompatImageView a = f4.b.a(view, i);
        if (a != null) {
            i = R$id.tvDesc;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                i = R$id.tv_retry;
                TextView textView2 = (TextView) f4.b.a(view, i);
                if (textView2 != null) {
                    return new y((LinearLayoutCompat) view, a, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
