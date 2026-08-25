package gm;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.member.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements f4.a {
    private final FrameLayout a;
    public final ConstraintLayout b;
    public final GradientBorderView c;
    public final AppCompatTextView d;
    public final TextView e;
    public final AppCompatTextView f;
    public final TextView g;

    private e(FrameLayout frameLayout, ConstraintLayout constraintLayout, GradientBorderView gradientBorderView, AppCompatTextView appCompatTextView, TextView textView, AppCompatTextView appCompatTextView2, TextView textView2) {
        this.a = frameLayout;
        this.b = constraintLayout;
        this.c = gradientBorderView;
        this.d = appCompatTextView;
        this.e = textView;
        this.f = appCompatTextView2;
        this.g = textView2;
    }

    public static e a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R$id.clRoot;
        ConstraintLayout a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R$id.iv_confirm_container;
            GradientBorderView gradientBorderView = (GradientBorderView) f4.b.a(view, i);
            if (gradientBorderView != null && (a = f4.b.a(view, (i = R$id.tv_confirm))) != null) {
                i = R$id.tvDesc;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null && (a2 = f4.b.a(view, (i = R$id.tv_later))) != null) {
                    i = R$id.tvTitle;
                    TextView textView2 = (TextView) f4.b.a(view, i);
                    if (textView2 != null) {
                        return new e((FrameLayout) view, a3, gradientBorderView, a, textView, a2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
