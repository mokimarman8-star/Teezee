package um;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLView;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.R$layout;
import com.transsion.ninegridview.preview.HackyViewPager;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements f4.a {
    private final ConstraintLayout a;
    public final BLView b;
    public final BLView c;
    public final ImageView d;
    public final ConstraintLayout e;
    public final View f;
    public final AppCompatTextView g;
    public final TextView h;
    public final AppCompatTextView i;
    public final HackyViewPager j;

    private b(ConstraintLayout constraintLayout, BLView bLView, BLView bLView2, ImageView imageView, ConstraintLayout constraintLayout2, View view, AppCompatTextView appCompatTextView, TextView textView, AppCompatTextView appCompatTextView2, HackyViewPager hackyViewPager) {
        this.a = constraintLayout;
        this.b = bLView;
        this.c = bLView2;
        this.d = imageView;
        this.e = constraintLayout2;
        this.f = view;
        this.g = appCompatTextView;
        this.h = textView;
        this.i = appCompatTextView2;
        this.j = hackyViewPager;
    }

    public static b a(View view) {
        BLView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        int i = R$id.bg_download;
        BLView a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R$id.bg_share))) != null) {
            i = R$id.iv_back;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R$id.statusSpace;
                View a5 = f4.b.a(view, i);
                if (a5 != null && (a2 = f4.b.a(view, (i = R$id.tv_download))) != null) {
                    i = R$id.tv_pager;
                    TextView textView = (TextView) f4.b.a(view, i);
                    if (textView != null && (a3 = f4.b.a(view, (i = R$id.tv_share))) != null) {
                        i = R$id.viewPager;
                        HackyViewPager hackyViewPager = (HackyViewPager) f4.b.a(view, i);
                        if (hackyViewPager != null) {
                            return new b(constraintLayout, a4, a, imageView, constraintLayout, a5, a2, textView, a3, hackyViewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_preview, viewGroup, false);
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
