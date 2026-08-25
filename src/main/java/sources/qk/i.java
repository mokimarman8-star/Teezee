package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.BlurredSectorView;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final FrameLayout e;
    public final ConstraintLayout f;
    public final TnTextView g;
    public final View h;
    public final TextView i;
    public final BlurredSectorView j;

    private i(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, FrameLayout frameLayout2, ConstraintLayout constraintLayout2, TnTextView tnTextView, View view, TextView textView, BlurredSectorView blurredSectorView) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = frameLayout2;
        this.f = constraintLayout2;
        this.g = tnTextView;
        this.h = view;
        this.i = textView;
        this.j = blurredSectorView;
    }

    public static i a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        ConstraintLayout a3;
        TnTextView a4;
        View a5;
        int i = R.id.bottom_op_container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R.id.bottom_op_mb_logo))) != null && (a2 = f4.b.a(view, (i = R.id.bottom_op_search_appstore))) != null) {
            i = R.id.bottom_op_search_gamestore;
            FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
            if (frameLayout2 != null && (a3 = f4.b.a(view, (i = R.id.bottom_op_search_liner))) != null && (a4 = f4.b.a(view, (i = R.id.bottom_op_search_text))) != null && (a5 = f4.b.a(view, (i = R.id.divider_line))) != null) {
                i = R.id.subscription_title;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null) {
                    i = R.id.trending_bottom_bg;
                    BlurredSectorView blurredSectorView = (BlurredSectorView) f4.b.a(view, i);
                    if (blurredSectorView != null) {
                        return new i((ConstraintLayout) view, frameLayout, a, a2, frameLayout2, a3, a4, a5, textView, blurredSectorView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bottom_op_subscription, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
