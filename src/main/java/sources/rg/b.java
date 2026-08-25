package rg;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.tn.lib.tranpay.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class b implements f4.a {
    private final LinearLayoutCompat a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatEditText d;
    public final AppCompatEditText e;
    public final AppCompatTextView f;
    public final FrameLayout g;
    public final AppCompatImageView h;
    public final ConstraintLayout i;
    public final View j;
    public final AppCompatTextView k;
    public final AppCompatTextView l;
    public final AppCompatTextView m;
    public final AppCompatTextView n;
    public final AppCompatTextView o;
    public final AppCompatTextView p;
    public final AppCompatTextView q;
    public final AppCompatTextView r;
    public final ConstraintLayout s;
    public final View t;
    public final LinearLayoutCompat u;
    public final LinearLayoutCompat v;
    public final NestedScrollView w;
    public final View x;

    private b(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, AppCompatTextView appCompatTextView, FrameLayout frameLayout, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout, View view, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, ConstraintLayout constraintLayout2, View view2, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, NestedScrollView nestedScrollView, View view3) {
        this.a = linearLayoutCompat;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatEditText;
        this.e = appCompatEditText2;
        this.f = appCompatTextView;
        this.g = frameLayout;
        this.h = appCompatImageView3;
        this.i = constraintLayout;
        this.j = view;
        this.k = appCompatTextView2;
        this.l = appCompatTextView3;
        this.m = appCompatTextView4;
        this.n = appCompatTextView5;
        this.o = appCompatTextView6;
        this.p = appCompatTextView7;
        this.q = appCompatTextView8;
        this.r = appCompatTextView9;
        this.s = constraintLayout2;
        this.t = view2;
        this.u = linearLayoutCompat2;
        this.v = linearLayoutCompat3;
        this.w = nestedScrollView;
        this.x = view3;
    }

    public static b a(View view) {
        AppCompatImageView a;
        AppCompatEditText a2;
        AppCompatEditText a3;
        AppCompatTextView a4;
        AppCompatImageView a8;
        ConstraintLayout a9;
        View a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        AppCompatTextView a13;
        AppCompatTextView a14;
        AppCompatTextView a15;
        AppCompatTextView a16;
        AppCompatTextView a17;
        AppCompatTextView a18;
        ConstraintLayout a19;
        View a20;
        View a21;
        int i = R$id.clear_cnic_button;
        AppCompatImageView a22 = f4.b.a(view, i);
        if (a22 != null && (a = f4.b.a(view, (i = R$id.clear_phone_button))) != null && (a2 = f4.b.a(view, (i = R$id.input_cnic))) != null && (a3 = f4.b.a(view, (i = R$id.input_phone))) != null && (a4 = f4.b.a(view, (i = R$id.iv_amount))) != null) {
            i = R$id.iv_back;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null && (a8 = f4.b.a(view, (i = R$id.iv_close))) != null && (a9 = f4.b.a(view, (i = R$id.iv_cnic_container))) != null && (a10 = f4.b.a(view, (i = R$id.iv_cnic_container_line))) != null && (a11 = f4.b.a(view, (i = R$id.iv_company))) != null && (a12 = f4.b.a(view, (i = R$id.iv_desc))) != null && (a13 = f4.b.a(view, (i = R$id.iv_input_cnic_error))) != null && (a14 = f4.b.a(view, (i = R$id.iv_input_phone_error))) != null && (a15 = f4.b.a(view, (i = R$id.iv_order_id))) != null && (a16 = f4.b.a(view, (i = R$id.iv_pay_button))) != null && (a17 = f4.b.a(view, (i = R$id.iv_payment_method))) != null && (a18 = f4.b.a(view, (i = R$id.iv_phone_code))) != null && (a19 = f4.b.a(view, (i = R$id.iv_phone_container))) != null && (a20 = f4.b.a(view, (i = R$id.iv_phone_container_line))) != null) {
                LinearLayoutCompat a23 = f4.b.a(view, R$id.left_panel);
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
                i = R$id.scroll_view;
                NestedScrollView a24 = f4.b.a(view, i);
                if (a24 != null && (a21 = f4.b.a(view, (i = R$id.view))) != null) {
                    return new b(linearLayoutCompat, a22, a, a2, a3, a4, frameLayout, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a23, linearLayoutCompat, a24, a21);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
