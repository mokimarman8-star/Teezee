package xv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLTextView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final BLTextView f;
    public final LinearLayout g;
    public final RecyclerView h;
    public final BLTextView i;
    public final BLTextView j;

    private d(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, BLTextView bLTextView, LinearLayout linearLayout, RecyclerView recyclerView, BLTextView bLTextView2, BLTextView bLTextView3) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = appCompatTextView3;
        this.f = bLTextView;
        this.g = linearLayout;
        this.h = recyclerView;
        this.i = bLTextView2;
        this.j = bLTextView3;
    }

    public static d a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        BLTextView a4;
        RecyclerView a5;
        BLTextView a6;
        BLTextView a7;
        int i = R$id.innerIcon;
        AppCompatImageView a8 = f4.b.a(view, i);
        if (a8 != null && (a = f4.b.a(view, (i = R$id.innerTvInfo))) != null && (a2 = f4.b.a(view, (i = R$id.innerTvName))) != null && (a3 = f4.b.a(view, (i = R$id.innerTvTitle))) != null && (a4 = f4.b.a(view, (i = R$id.iv_seasons))) != null) {
            i = R$id.llLanguage;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a5 = f4.b.a(view, (i = R$id.resourceRv))) != null && (a6 = f4.b.a(view, (i = R$id.tvLanguage))) != null && (a7 = f4.b.a(view, (i = R$id.tv_more))) != null) {
                return new d((ConstraintLayout) view, a8, a, a2, a3, a4, linearLayout, a5, a6, a7);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_episode, viewGroup, false);
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
