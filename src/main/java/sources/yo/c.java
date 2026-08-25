package yo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;
    public final EditText c;
    public final EditText d;
    public final EditText e;
    public final EditText f;
    public final EditText g;
    public final EditText h;
    public final AppCompatImageView i;
    public final LinearLayout j;
    public final LinearLayout k;
    public final LinearLayout l;
    public final ScrollView m;
    public final AppCompatTextView n;
    public final ConstraintLayout o;
    public final TextView p;
    public final TextView q;

    private c(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, AppCompatImageView appCompatImageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ScrollView scrollView, AppCompatTextView appCompatTextView2, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = editText;
        this.d = editText2;
        this.e = editText3;
        this.f = editText4;
        this.g = editText5;
        this.h = editText6;
        this.i = appCompatImageView;
        this.j = linearLayout;
        this.k = linearLayout2;
        this.l = linearLayout3;
        this.m = scrollView;
        this.n = appCompatTextView2;
        this.o = constraintLayout2;
        this.p = textView;
        this.q = textView2;
    }

    public static c a(View view) {
        AppCompatImageView a;
        AppCompatTextView a2;
        ConstraintLayout a3;
        int i = R$id.btn_submit;
        AppCompatTextView a4 = f4.b.a(view, i);
        if (a4 != null) {
            i = R$id.et_address;
            EditText editText = (EditText) f4.b.a(view, i);
            if (editText != null) {
                i = R$id.et_alt_phone;
                EditText editText2 = (EditText) f4.b.a(view, i);
                if (editText2 != null) {
                    i = R$id.et_email;
                    EditText editText3 = (EditText) f4.b.a(view, i);
                    if (editText3 != null) {
                        i = R$id.et_fullname;
                        EditText editText4 = (EditText) f4.b.a(view, i);
                        if (editText4 != null) {
                            i = R$id.et_main_phone;
                            EditText editText5 = (EditText) f4.b.a(view, i);
                            if (editText5 != null) {
                                i = R$id.et_postal;
                                EditText editText6 = (EditText) f4.b.a(view, i);
                                if (editText6 != null && (a = f4.b.a(view, (i = R$id.iv_back))) != null) {
                                    i = R$id.ll_alt_phone_cc;
                                    LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                                    if (linearLayout != null) {
                                        i = R$id.ll_main_phone_cc;
                                        LinearLayout linearLayout2 = (LinearLayout) f4.b.a(view, i);
                                        if (linearLayout2 != null) {
                                            i = R$id.ll_main_phone_container;
                                            LinearLayout linearLayout3 = (LinearLayout) f4.b.a(view, i);
                                            if (linearLayout3 != null) {
                                                i = R$id.scrollView;
                                                ScrollView scrollView = (ScrollView) f4.b.a(view, i);
                                                if (scrollView != null && (a2 = f4.b.a(view, (i = R$id.title))) != null && (a3 = f4.b.a(view, (i = R$id.titleLayout))) != null) {
                                                    i = R$id.tv_alt_phone_cc;
                                                    TextView textView = (TextView) f4.b.a(view, i);
                                                    if (textView != null) {
                                                        i = R$id.tv_main_phone_cc;
                                                        TextView textView2 = (TextView) f4.b.a(view, i);
                                                        if (textView2 != null) {
                                                            return new c((ConstraintLayout) view, a4, editText, editText2, editText3, editText4, editText5, editText6, a, linearLayout, linearLayout2, linearLayout3, scrollView, a2, a3, textView, textView2);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_claim_reward, viewGroup, false);
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
