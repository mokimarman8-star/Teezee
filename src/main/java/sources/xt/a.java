package xt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.TitleLayout;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final RecyclerView c;
    public final TitleLayout d;
    public final AppCompatTextView e;

    private a(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, RecyclerView recyclerView, TitleLayout titleLayout, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = recyclerView;
        this.d = titleLayout;
        this.e = appCompatTextView;
    }

    public static a a(View view) {
        RecyclerView a;
        TitleLayout a2;
        AppCompatTextView a3;
        int i = R$id.ivHeader;
        AppCompatImageView a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R$id.rv_permissions))) == null || (a2 = f4.b.a(view, (i = R$id.toolBar))) == null || (a3 = f4.b.a(view, (i = R$id.tvNext))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new a((ConstraintLayout) view, a4, a, a2, a3);
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_permissions, viewGroup, false);
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
