package lo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements f4.a {
    private final FrameLayout a;
    public final LinearLayout b;
    public final RecyclerView c;
    public final AppCompatTextView d;

    private i(FrameLayout frameLayout, LinearLayout linearLayout, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.a = frameLayout;
        this.b = linearLayout;
        this.c = recyclerView;
        this.d = appCompatTextView;
    }

    public static i a(View view) {
        RecyclerView a;
        AppCompatTextView a2;
        int i = R$id.ll_gps;
        LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
        if (linearLayout == null || (a = f4.b.a(view, (i = R$id.recycler_view))) == null || (a2 = f4.b.a(view, (i = R$id.tv_gps_btn))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new i((FrameLayout) view, linearLayout, a, a2);
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_select_location, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
