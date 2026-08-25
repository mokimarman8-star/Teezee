package ek;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.edcation.R$id;
import com.transsion.edcation.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements f4.a {
    private final ConstraintLayout a;
    public final RecyclerView b;

    private b(ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        this.a = constraintLayout;
        this.b = recyclerView;
    }

    public static b a(View view) {
        int i = R$id.education_history_recycler;
        RecyclerView a = f4.b.a(view, i);
        if (a != null) {
            return new b((ConstraintLayout) view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_education_history, viewGroup, false);
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
