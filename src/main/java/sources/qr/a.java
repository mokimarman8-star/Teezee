package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.shorttv.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements f4.a {
    private final ConstraintLayout a;
    public final TextView b;
    public final View c;
    public final ProgressBar d;

    private a(ConstraintLayout constraintLayout, TextView textView, View view, ProgressBar progressBar) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = view;
        this.d = progressBar;
    }

    public static a a(View view) {
        View a;
        int i = R.id.tvLoading;
        TextView textView = (TextView) f4.b.a(view, i);
        if (textView != null && (a = f4.b.a(view, (i = R.id.viewBg))) != null) {
            i = R.id.viewLoad;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null) {
                return new a((ConstraintLayout) view, textView, a, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static a c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.pay_order_id_dialog_loading, viewGroup, false);
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
