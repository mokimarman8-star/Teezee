package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class s0 implements f4.a {
    private final LinearLayout a;
    public final AppCompatImageButton b;
    public final LinearLayout c;
    public final AppCompatTextView d;

    private s0(LinearLayout linearLayout, AppCompatImageButton appCompatImageButton, LinearLayout linearLayout2, AppCompatTextView appCompatTextView) {
        this.a = linearLayout;
        this.b = appCompatImageButton;
        this.c = linearLayout2;
        this.d = appCompatTextView;
    }

    public static s0 a(View view) {
        AppCompatTextView a;
        int i = R$id.btn_back;
        AppCompatImageButton a2 = f4.b.a(view, i);
        if (a2 != null) {
            i = R$id.rlContent;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a = f4.b.a(view, (i = R$id.tv_title))) != null) {
                return new s0((LinearLayout) view, a2, linearLayout, a);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static s0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static s0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.use_activity_webview_layout, viewGroup, false);
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
