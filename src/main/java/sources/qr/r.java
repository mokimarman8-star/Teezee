package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.shorttv.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r implements f4.a {
    private final LinearLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final TextView d;
    public final TextView e;

    private r(LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView, TextView textView2) {
        this.a = linearLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = textView;
        this.e = textView2;
    }

    public static r a(View view) {
        AppCompatTextView a;
        int i = R.id.btn_primary;
        AppCompatTextView a2 = f4.b.a(view, i);
        if (a2 != null && (a = f4.b.a(view, (i = R.id.btn_secondary))) != null) {
            i = R.id.tv_message;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                i = R.id.tv_title;
                TextView textView2 = (TextView) f4.b.a(view, i);
                if (textView2 != null) {
                    return new r((LinearLayout) view, a2, a, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static r c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.short_tv_dialog_alert, viewGroup, false);
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
