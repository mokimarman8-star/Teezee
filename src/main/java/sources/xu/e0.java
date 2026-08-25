package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.setting.labelsfeedback.UCEditText;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e0 implements f4.a {
    private final LinearLayout a;
    public final AppCompatTextView b;
    public final AppCompatEditText c;
    public final UCEditText d;
    public final ShapeableImageView e;
    public final AppCompatEditText f;
    public final View g;

    private e0(LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatEditText appCompatEditText, UCEditText uCEditText, ShapeableImageView shapeableImageView, AppCompatEditText appCompatEditText2, View view) {
        this.a = linearLayout;
        this.b = appCompatTextView;
        this.c = appCompatEditText;
        this.d = uCEditText;
        this.e = shapeableImageView;
        this.f = appCompatEditText2;
        this.g = view;
    }

    public static e0 a(View view) {
        AppCompatEditText a;
        ShapeableImageView a2;
        AppCompatEditText a3;
        View a4;
        int i = R$id.countTextView;
        AppCompatTextView a5 = f4.b.a(view, i);
        if (a5 != null && (a = f4.b.a(view, (i = R$id.countryEditText))) != null) {
            i = R$id.editText;
            UCEditText uCEditText = (UCEditText) f4.b.a(view, i);
            if (uCEditText != null && (a2 = f4.b.a(view, (i = R$id.imageView))) != null && (a3 = f4.b.a(view, (i = R$id.phoneEditText))) != null && (a4 = f4.b.a(view, (i = R$id.view6))) != null) {
                return new e0((LinearLayout) view, a5, a, uCEditText, a2, a3, a4);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static e0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.feedback_option_list_footer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
