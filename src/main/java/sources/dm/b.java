package dm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.baseui.widget.text.GradientTextView;
import com.transsion.mbwidget.R$id;
import com.transsion.mbwidget.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements f4.a {
    private final LinearLayout a;
    public final TextView b;
    public final ImageView c;
    public final GradientTextView d;

    private b(LinearLayout linearLayout, TextView textView, ImageView imageView, GradientTextView gradientTextView) {
        this.a = linearLayout;
        this.b = textView;
        this.c = imageView;
        this.d = gradientTextView;
    }

    public static b a(View view) {
        int i = R$id.addTv;
        TextView textView = (TextView) f4.b.a(view, i);
        if (textView != null) {
            i = R$id.closeIV;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null) {
                i = R$id.tipsTv;
                GradientTextView gradientTextView = (GradientTextView) f4.b.a(view, i);
                if (gradientTextView != null) {
                    return new b((LinearLayout) view, textView, imageView, gradientTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.dialog_widget_add, viewGroup, false);
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
