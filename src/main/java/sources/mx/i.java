package mx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;
import com.transsnet.login.country.widget.SideBar;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final View c;
    public final RecyclerView d;
    public final SideBar e;

    private i(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, View view, RecyclerView recyclerView, SideBar sideBar) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = view;
        this.d = recyclerView;
        this.e = sideBar;
    }

    public static i a(View view) {
        View a;
        RecyclerView a2;
        int i = R$id.btn_back;
        AppCompatImageView a3 = f4.b.a(view, i);
        if (a3 != null && (a = f4.b.a(view, (i = R$id.line))) != null && (a2 = f4.b.a(view, (i = R$id.recycler_view))) != null) {
            i = R$id.side_bar;
            SideBar sideBar = (SideBar) f4.b.a(view, i);
            if (sideBar != null) {
                return new i((ConstraintLayout) view, a3, a, a2, sideBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.login_activity_sel_country, viewGroup, false);
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
