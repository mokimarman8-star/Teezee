package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class x0 implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatButton b;
    public final AppCompatEditText c;
    public final AppCompatEditText d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final LinearLayout g;
    public final TitleLayout h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;
    public final AppCompatTextView l;

    private x0(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, TitleLayout titleLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.a = constraintLayout;
        this.b = appCompatButton;
        this.c = appCompatEditText;
        this.d = appCompatEditText2;
        this.e = appCompatImageView;
        this.f = appCompatImageView2;
        this.g = linearLayout;
        this.h = titleLayout;
        this.i = appCompatTextView;
        this.j = appCompatTextView2;
        this.k = appCompatTextView3;
        this.l = appCompatTextView4;
    }

    public static x0 a(View view) {
        AppCompatEditText a;
        AppCompatEditText a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        TitleLayout a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        int i = R$id.btn_submit;
        AppCompatButton a10 = f4.b.a(view, i);
        if (a10 != null && (a = f4.b.a(view, (i = R$id.et_desc))) != null && (a2 = f4.b.a(view, (i = R$id.et_phone))) != null && (a3 = f4.b.a(view, (i = R$id.img_background))) != null && (a4 = f4.b.a(view, (i = R$id.iv_add_image))) != null) {
            i = R$id.ll_input;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a5 = f4.b.a(view, (i = R$id.toolbar))) != null && (a6 = f4.b.a(view, (i = R$id.tv_desc_num))) != null && (a7 = f4.b.a(view, (i = R$id.tv_phone_country_code))) != null && (a8 = f4.b.a(view, (i = R$id.tv_title_desc))) != null && (a9 = f4.b.a(view, (i = R$id.whatsapp_hint))) != null) {
                return new x0((ConstraintLayout) view, a10, a, a2, a3, a4, linearLayout, a5, a6, a7, a8, a9);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static x0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static x0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.user_activity_setting_feedback, viewGroup, false);
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
