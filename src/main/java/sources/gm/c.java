package gm;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.member.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements f4.a {
    private final FrameLayout a;
    public final View b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final RecyclerView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final View k;

    private c(FrameLayout frameLayout, View view, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, View view2) {
        this.a = frameLayout;
        this.b = view;
        this.c = constraintLayout;
        this.d = constraintLayout2;
        this.e = appCompatImageView;
        this.f = appCompatImageView2;
        this.g = recyclerView;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = view2;
    }

    public static c a(View view) {
        ConstraintLayout a;
        ConstraintLayout a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        RecyclerView a5;
        View a6;
        int i = R$id.MeBg1;
        View a7 = f4.b.a(view, i);
        if (a7 != null && (a = f4.b.a(view, (i = R$id.MeBg2))) != null && (a2 = f4.b.a(view, (i = R$id.clRoot))) != null && (a3 = f4.b.a(view, (i = R$id.ivClose))) != null && (a4 = f4.b.a(view, (i = R$id.ivPremium))) != null && (a5 = f4.b.a(view, (i = R$id.rvMemberRights))) != null) {
            i = R$id.tvGetAd;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                i = R$id.tvPay;
                TextView textView2 = (TextView) f4.b.a(view, i);
                if (textView2 != null) {
                    i = R$id.tvTitle;
                    TextView textView3 = (TextView) f4.b.a(view, i);
                    if (textView3 != null && (a6 = f4.b.a(view, (i = R$id.viewBtnBg))) != null) {
                        return new c((FrameLayout) view, a7, a, a2, a3, a4, a5, textView, textView2, textView3, a6);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
