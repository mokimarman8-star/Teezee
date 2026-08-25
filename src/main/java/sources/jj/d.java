package jj;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements f4.a {
    private final View a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final FrameLayout f;
    public final FrameLayout g;

    private d(View view, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.a = view;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
        this.f = frameLayout;
        this.g = frameLayout2;
    }

    public static d a(View view) {
        AppCompatImageView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        int i = R.id.iv_guide_line;
        AppCompatImageView a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R.id.iv_guide_target))) != null && (a2 = f4.b.a(view, (i = R.id.tv_guide_button))) != null && (a3 = f4.b.a(view, (i = R.id.tv_guide_tips))) != null) {
            i = R.id.v_guide_anima_bg;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R.id.v_guide_bg;
                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout2 != null) {
                    return new d(view, a4, a, a2, a3, frameLayout, frameLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
