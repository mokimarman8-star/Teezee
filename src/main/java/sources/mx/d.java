package mx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d implements f4.a {
    private final LinearLayout a;
    public final RecyclerView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;

    private d(LinearLayout linearLayout, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = linearLayout;
        this.b = recyclerView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
    }

    public static d a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R$id.f8rv;
        RecyclerView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.tv_post))) == null || (a2 = f4.b.a(view, (i = R$id.tv_skip))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new d((LinearLayout) view, a3, a, a2);
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.login_activity_interest, viewGroup, false);
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
