package ki;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.audio.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements f4.a {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final AppCompatImageView i;
    public final ProgressBar j;
    public final TextView k;
    public final TextView l;

    private d(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, ProgressBar progressBar, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = constraintLayout3;
        this.d = constraintLayout4;
        this.e = appCompatImageView;
        this.f = appCompatImageView2;
        this.g = appCompatImageView3;
        this.h = appCompatImageView4;
        this.i = appCompatImageView5;
        this.j = progressBar;
        this.k = textView;
        this.l = textView2;
    }

    public static d a(View view) {
        ConstraintLayout a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        int i = R$id.clExpansion;
        ConstraintLayout a6 = f4.b.a(view, i);
        if (a6 != null && (a = f4.b.a(view, (i = R$id.clPackUp))) != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.iv_history;
            AppCompatImageView a7 = f4.b.a(view, i);
            if (a7 != null && (a2 = f4.b.a(view, (i = R$id.iv_next))) != null && (a3 = f4.b.a(view, (i = R$id.ivPackUp))) != null && (a4 = f4.b.a(view, (i = R$id.iv_play))) != null && (a5 = f4.b.a(view, (i = R$id.iv_remove))) != null) {
                i = R$id.pbSubject;
                ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                if (progressBar != null) {
                    i = R$id.tvAudioName;
                    TextView textView = (TextView) f4.b.a(view, i);
                    if (textView != null) {
                        i = R$id.tvAudioTime;
                        TextView textView2 = (TextView) f4.b.a(view, i);
                        if (textView2 != null) {
                            return new d(constraintLayout, a6, a, constraintLayout, a7, a2, a3, a4, a5, progressBar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
