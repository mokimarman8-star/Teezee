package yo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements f4.a {
    private final LinearLayoutCompat a;
    public final AppCompatButton b;
    public final AppCompatEditText c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final LinearLayoutCompat g;
    public final LinearLayoutCompat h;
    public final LinearLayoutCompat i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;
    public final AppCompatTextView l;
    public final AppCompatTextView m;
    public final AppCompatTextView n;

    private e(LinearLayoutCompat linearLayoutCompat, AppCompatButton appCompatButton, AppCompatEditText appCompatEditText, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, LinearLayoutCompat linearLayoutCompat4, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5) {
        this.a = linearLayoutCompat;
        this.b = appCompatButton;
        this.c = appCompatEditText;
        this.d = appCompatImageView;
        this.e = appCompatImageView2;
        this.f = appCompatImageView3;
        this.g = linearLayoutCompat2;
        this.h = linearLayoutCompat3;
        this.i = linearLayoutCompat4;
        this.j = appCompatTextView;
        this.k = appCompatTextView2;
        this.l = appCompatTextView3;
        this.m = appCompatTextView4;
        this.n = appCompatTextView5;
    }

    public static e a(View view) {
        AppCompatEditText a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        LinearLayoutCompat a5;
        LinearLayoutCompat a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        AppCompatTextView a10;
        int i = R$id.btn_action;
        AppCompatButton a11 = f4.b.a(view, i);
        if (a11 != null && (a = f4.b.a(view, (i = R$id.et_phone))) != null && (a2 = f4.b.a(view, (i = R$id.iv_back))) != null && (a3 = f4.b.a(view, (i = R$id.iv_clear))) != null && (a4 = f4.b.a(view, (i = R$id.iv_close))) != null && (a5 = f4.b.a(view, (i = R$id.ll_phone_cc))) != null && (a6 = f4.b.a(view, (i = R$id.ll_phone_input_container))) != null) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
            i = R$id.tv_phone_cc;
            AppCompatTextView a12 = f4.b.a(view, i);
            if (a12 != null && (a7 = f4.b.a(view, (i = R$id.tv_price))) != null && (a8 = f4.b.a(view, (i = R$id.tv_product_name))) != null && (a9 = f4.b.a(view, (i = R$id.tv_subtitle))) != null && (a10 = f4.b.a(view, (i = R$id.tv_title))) != null) {
                return new e(linearLayoutCompat, a11, a, a2, a3, a4, a5, a6, linearLayoutCompat, a12, a7, a8, a9, a10);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static e c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.phone_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
