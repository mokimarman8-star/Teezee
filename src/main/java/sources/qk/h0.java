package qk;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h0 implements f4.a {
    private final ConstraintLayout a;
    public final LinearLayoutCompat b;
    public final View c;
    public final LinearLayoutCompat d;
    public final LinearLayoutCompat e;
    public final LinearLayoutCompat f;
    public final LinearLayoutCompat g;
    public final ConstraintLayout h;
    public final ProgressBar i;

    private h0(ConstraintLayout constraintLayout, LinearLayoutCompat linearLayoutCompat, View view, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, LinearLayoutCompat linearLayoutCompat4, LinearLayoutCompat linearLayoutCompat5, ConstraintLayout constraintLayout2, ProgressBar progressBar) {
        this.a = constraintLayout;
        this.b = linearLayoutCompat;
        this.c = view;
        this.d = linearLayoutCompat2;
        this.e = linearLayoutCompat3;
        this.f = linearLayoutCompat4;
        this.g = linearLayoutCompat5;
        this.h = constraintLayout2;
        this.i = progressBar;
    }

    public static h0 a(View view) {
        View a;
        LinearLayoutCompat a2;
        LinearLayoutCompat a3;
        LinearLayoutCompat a4;
        LinearLayoutCompat a5;
        int i = R.id.l1;
        LinearLayoutCompat a6 = f4.b.a(view, i);
        if (a6 != null && (a = f4.b.a(view, (i = R.id.l2))) != null && (a2 = f4.b.a(view, (i = R.id.l3))) != null && (a3 = f4.b.a(view, (i = R.id.l4))) != null && (a4 = f4.b.a(view, (i = R.id.l5))) != null && (a5 = f4.b.a(view, (i = R.id.l6))) != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.loading_pb;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null) {
                return new h0(constraintLayout, a6, a, a2, a3, a4, a5, constraintLayout, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
