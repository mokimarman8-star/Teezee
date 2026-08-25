package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class t implements f4.a {
    private final LinearLayout a;
    public final Button b;
    public final RecyclerView c;
    public final TextView d;

    private t(LinearLayout linearLayout, Button button, RecyclerView recyclerView, TextView textView) {
        this.a = linearLayout;
        this.b = button;
        this.c = recyclerView;
        this.d = textView;
    }

    public static t a(View view) {
        RecyclerView a;
        int i = R$id.btn;
        Button button = (Button) f4.b.a(view, i);
        if (button != null && (a = f4.b.a(view, (i = R$id.rv))) != null) {
            i = R$id.tvTitle;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                return new t((LinearLayout) view, button, a, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static t c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static t d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_plans_layout, viewGroup, false);
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
