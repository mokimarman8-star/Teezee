package mn;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.noober.background.view.BLLinearLayout;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.player.longvideo.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements f4.a {
    private final BLLinearLayout a;
    public final AppCompatImageView b;
    public final LinearLayoutCompat c;
    public final GradientTextView d;
    public final AppCompatImageView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;

    private f(BLLinearLayout bLLinearLayout, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat, GradientTextView gradientTextView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = bLLinearLayout;
        this.b = appCompatImageView;
        this.c = linearLayoutCompat;
        this.d = gradientTextView;
        this.e = appCompatImageView2;
        this.f = appCompatTextView;
        this.g = appCompatTextView2;
    }

    public static f a(View view) {
        LinearLayoutCompat a;
        AppCompatImageView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        int i = R$id.ivMore;
        AppCompatImageView a5 = f4.b.a(view, i);
        if (a5 != null && (a = f4.b.a(view, (i = R$id.llButton))) != null) {
            i = R$id.tvButton;
            GradientTextView gradientTextView = (GradientTextView) f4.b.a(view, i);
            if (gradientTextView != null && (a2 = f4.b.a(view, (i = R$id.tvClose))) != null && (a3 = f4.b.a(view, (i = R$id.tvTips))) != null && (a4 = f4.b.a(view, (i = R$id.tvTitle))) != null) {
                return new f((BLLinearLayout) view, a5, a, gradientTextView, a2, a3, a4);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLLinearLayout getRoot() {
        return this.a;
    }
}
