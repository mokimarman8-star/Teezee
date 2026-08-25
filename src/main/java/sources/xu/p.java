package xu;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class p implements f4.a {
    private final LinearLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final EditTextWithClear d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;

    private p(LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, EditTextWithClear editTextWithClear, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8) {
        this.a = linearLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = editTextWithClear;
        this.e = appCompatTextView3;
        this.f = appCompatTextView4;
        this.g = appCompatTextView5;
        this.h = appCompatTextView6;
        this.i = appCompatTextView7;
        this.j = appCompatTextView8;
    }

    public static p a(View view) {
        AppCompatTextView a;
        EditTextWithClear a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        AppCompatTextView a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        int i = R$id.btn_close;
        AppCompatTextView a9 = f4.b.a(view, i);
        if (a9 == null || (a = f4.b.a(view, (i = R$id.btn_custom_brand))) == null || (a2 = f4.b.a(view, (i = R$id.et_custom_brand))) == null || (a3 = f4.b.a(view, (i = R$id.tv_lane_cur))) == null || (a4 = f4.b.a(view, (i = R$id.tv_lane_infinix))) == null || (a5 = f4.b.a(view, (i = R$id.tv_lane_itel))) == null || (a6 = f4.b.a(view, (i = R$id.tv_lane_samsung))) == null || (a7 = f4.b.a(view, (i = R$id.tv_lane_tecno))) == null || (a8 = f4.b.a(view, (i = R$id.tv_reset))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new p((LinearLayout) view, a9, a, a2, a3, a4, a5, a6, a7, a8);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
