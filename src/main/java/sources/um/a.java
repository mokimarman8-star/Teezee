package um;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final AppCompatImageView c;
    public final ConstraintLayout d;
    public final TextView e;
    public final AppCompatTextView f;
    public final ViewPager2 g;

    private a(ConstraintLayout constraintLayout, View view, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, TextView textView, AppCompatTextView appCompatTextView, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = view;
        this.c = appCompatImageView;
        this.d = constraintLayout2;
        this.e = textView;
        this.f = appCompatTextView;
        this.g = viewPager2;
    }

    public static a a(View view) {
        AppCompatImageView a;
        AppCompatTextView a2;
        ViewPager2 a3;
        int i = R$id.btn_top;
        View a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R$id.iv_download))) != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.tv_pager;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null && (a2 = f4.b.a(view, (i = R$id.tvSaved))) != null && (a3 = f4.b.a(view, (i = R$id.viewPager))) != null) {
                return new a(constraintLayout, a4, a, constraintLayout, textView, a2, a3);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_gif_image_preview, viewGroup, false);
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
