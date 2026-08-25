package eh;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b implements f4.a {
    private final LinearLayoutCompat a;
    public final AppCompatImageView b;
    public final TitleLayout c;
    public final LinearLayoutCompat d;
    public final TextView e;
    public final TextView f;

    private b(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, TitleLayout titleLayout, LinearLayoutCompat linearLayoutCompat2, TextView textView, TextView textView2) {
        this.a = linearLayoutCompat;
        this.b = appCompatImageView;
        this.c = titleLayout;
        this.d = linearLayoutCompat2;
        this.e = textView;
        this.f = textView2;
    }

    public static b a(View view) {
        int i = R$id.ivDefaultImage;
        AppCompatImageView a = f4.b.a(view, i);
        if (a != null) {
            i = R$id.llTitle;
            TitleLayout titleLayout = (TitleLayout) f4.b.a(view, i);
            if (titleLayout != null) {
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
                i = R$id.tvDesc;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null) {
                    i = R$id.tv_retry;
                    TextView textView2 = (TextView) f4.b.a(view, i);
                    if (textView2 != null) {
                        return new b(linearLayoutCompat, a, titleLayout, linearLayoutCompat, textView, textView2);
                    }
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
