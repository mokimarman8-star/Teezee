package sv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.version.update.R$id;
import com.transsion.version.update.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements f4.a {
    private final LinearLayout a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;
    public final ConstraintLayout e;
    public final ScrollView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;

    private b(LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout, ScrollView scrollView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.a = linearLayout;
        this.b = textView;
        this.c = textView2;
        this.d = imageView;
        this.e = constraintLayout;
        this.f = scrollView;
        this.g = textView3;
        this.h = textView4;
        this.i = textView5;
        this.j = textView6;
        this.k = textView7;
    }

    public static b a(View view) {
        ConstraintLayout a;
        int i = R$id.btSkip;
        TextView textView = (TextView) f4.b.a(view, i);
        if (textView != null) {
            i = R$id.btUpdate;
            TextView textView2 = (TextView) f4.b.a(view, i);
            if (textView2 != null) {
                i = R$id.iv_icon;
                ImageView imageView = (ImageView) f4.b.a(view, i);
                if (imageView != null && (a = f4.b.a(view, (i = R$id.layout_bottom))) != null) {
                    i = R$id.scrollView;
                    ScrollView scrollView = (ScrollView) f4.b.a(view, i);
                    if (scrollView != null) {
                        i = R$id.tvDetails;
                        TextView textView3 = (TextView) f4.b.a(view, i);
                        if (textView3 != null) {
                            i = R$id.tvName;
                            TextView textView4 = (TextView) f4.b.a(view, i);
                            if (textView4 != null) {
                                i = R$id.tvSize;
                                TextView textView5 = (TextView) f4.b.a(view, i);
                                if (textView5 != null) {
                                    i = R$id.tvTitle;
                                    TextView textView6 = (TextView) f4.b.a(view, i);
                                    if (textView6 != null) {
                                        i = R$id.tvVersion;
                                        TextView textView7 = (TextView) f4.b.a(view, i);
                                        if (textView7 != null) {
                                            return new b((LinearLayout) view, textView, textView2, imageView, a, scrollView, textView3, textView4, textView5, textView6, textView7);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.dialog_update_layout_white_theme, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
