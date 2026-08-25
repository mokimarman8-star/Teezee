package jt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.SwitchButton;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final LinearLayoutCompat d;
    public final LinearLayoutCompat e;
    public final RecyclerView f;
    public final SwitchButton g;
    public final SwitchButton h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;
    public final AppCompatTextView l;
    public final View m;
    public final LinearLayoutCompat n;

    private g(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, RecyclerView recyclerView, SwitchButton switchButton, SwitchButton switchButton2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, View view, LinearLayoutCompat linearLayoutCompat3) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = linearLayoutCompat;
        this.e = linearLayoutCompat2;
        this.f = recyclerView;
        this.g = switchButton;
        this.h = switchButton2;
        this.i = appCompatTextView;
        this.j = appCompatTextView2;
        this.k = appCompatTextView3;
        this.l = appCompatTextView4;
        this.m = view;
        this.n = linearLayoutCompat3;
    }

    public static g a(View view) {
        AppCompatImageView a;
        LinearLayoutCompat a2;
        LinearLayoutCompat a3;
        RecyclerView a4;
        SwitchButton a5;
        SwitchButton a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        AppCompatTextView a10;
        View a11;
        LinearLayoutCompat a12;
        int i = R$id.ivOptions;
        AppCompatImageView a13 = f4.b.a(view, i);
        if (a13 == null || (a = f4.b.a(view, (i = R$id.ivSync))) == null || (a2 = f4.b.a(view, (i = R$id.llOptions))) == null || (a3 = f4.b.a(view, (i = R$id.llSync))) == null || (a4 = f4.b.a(view, (i = R$id.recycler_view))) == null || (a5 = f4.b.a(view, (i = R$id.switchBilingual))) == null || (a6 = f4.b.a(view, (i = R$id.switchBtn))) == null || (a7 = f4.b.a(view, (i = R$id.tvBilingual))) == null || (a8 = f4.b.a(view, (i = R$id.tvOptions))) == null || (a9 = f4.b.a(view, (i = R$id.tvSync))) == null || (a10 = f4.b.a(view, (i = R$id.tvTitle))) == null || (a11 = f4.b.a(view, (i = R$id.viewLine))) == null || (a12 = f4.b.a(view, (i = R$id.viewOptionsBg))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new g((ConstraintLayout) view, a13, a, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12);
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subtitle_select_list, viewGroup, false);
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
