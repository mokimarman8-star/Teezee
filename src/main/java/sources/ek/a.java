package ek;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.FlowLayout;
import com.transsion.edcation.R$id;
import com.transsion.edcation.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements f4.a {
    private final LinearLayout a;
    public final FlowLayout b;
    public final ProgressBar c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;

    private a(LinearLayout linearLayout, FlowLayout flowLayout, ProgressBar progressBar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = linearLayout;
        this.b = flowLayout;
        this.c = progressBar;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
    }

    public static a a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R$id.interestLayout;
        FlowLayout a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R$id.loadView;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a = f4.b.a(view, (i = R$id.tvConfirm))) != null && (a2 = f4.b.a(view, (i = R$id.tvSkip))) != null) {
                return new a((LinearLayout) view, a3, progressBar, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static a c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.dialog_interest_select, viewGroup, false);
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
