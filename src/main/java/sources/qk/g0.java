package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.FlowLayout;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g0 implements f4.a {
    private final LinearLayout a;
    public final FlowLayout b;
    public final AppCompatTextView c;

    private g0(LinearLayout linearLayout, FlowLayout flowLayout, AppCompatTextView appCompatTextView) {
        this.a = linearLayout;
        this.b = flowLayout;
        this.c = appCompatTextView;
    }

    public static g0 a(View view) {
        AppCompatTextView a;
        int i = R.id.flow_layout;
        FlowLayout a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R.id.tvExpand))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new g0((LinearLayout) view, a2, a);
    }

    public static g0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_filter_expand_view, viewGroup, false);
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
