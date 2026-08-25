package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i1 implements f4.a {
    private final LinearLayout a;
    public final AppCompatImageView b;
    public final LinearLayout c;
    public final TextView d;

    private i1(LinearLayout linearLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout2, TextView textView) {
        this.a = linearLayout;
        this.b = appCompatImageView;
        this.c = linearLayout2;
        this.d = textView;
    }

    public static i1 a(View view) {
        int i = R.id.ivClose;
        AppCompatImageView a = f4.b.a(view, i);
        if (a != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i2 = R.id.tvTip;
            TextView textView = (TextView) f4.b.a(view, i2);
            if (textView != null) {
                return new i1(linearLayout, a, linearLayout, textView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static i1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_lottery_tip_layout, viewGroup, false);
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
