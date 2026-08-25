package yo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements f4.a {
    private final ConstraintLayout a;
    public final CardView b;
    public final CardView c;
    public final ImageView d;
    public final ImageView e;
    public final TextView f;
    public final TextView g;
    public final ProgressBar h;
    public final ProgressBar i;
    public final TextView j;
    public final TextView k;

    private j(ConstraintLayout constraintLayout, CardView cardView, CardView cardView2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, ProgressBar progressBar, ProgressBar progressBar2, TextView textView3, TextView textView4) {
        this.a = constraintLayout;
        this.b = cardView;
        this.c = cardView2;
        this.d = imageView;
        this.e = imageView2;
        this.f = textView;
        this.g = textView2;
        this.h = progressBar;
        this.i = progressBar2;
        this.j = textView3;
        this.k = textView4;
    }

    public static j a(View view) {
        CardView a;
        int i = R$id.dot_1;
        CardView a2 = f4.b.a(view, i);
        if (a2 != null && (a = f4.b.a(view, (i = R$id.dot_2))) != null) {
            i = R$id.point_icon_1;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null) {
                i = R$id.point_icon_2;
                ImageView imageView2 = (ImageView) f4.b.a(view, i);
                if (imageView2 != null) {
                    i = R$id.point_text_1;
                    TextView textView = (TextView) f4.b.a(view, i);
                    if (textView != null) {
                        i = R$id.point_text_2;
                        TextView textView2 = (TextView) f4.b.a(view, i);
                        if (textView2 != null) {
                            i = R$id.progress_1;
                            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                            if (progressBar != null) {
                                i = R$id.progress_2;
                                ProgressBar progressBar2 = (ProgressBar) f4.b.a(view, i);
                                if (progressBar2 != null) {
                                    i = R$id.title_1;
                                    TextView textView3 = (TextView) f4.b.a(view, i);
                                    if (textView3 != null) {
                                        i = R$id.title_2;
                                        TextView textView4 = (TextView) f4.b.a(view, i);
                                        if (textView4 != null) {
                                            return new j((ConstraintLayout) view, a2, a, imageView, imageView2, textView, textView2, progressBar, progressBar2, textView3, textView4);
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

    public static j c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.stage_task_progress_layout, viewGroup, false);
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
