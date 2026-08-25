package xu;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.usercenter.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class r0 implements f4.a {
    private final ConstraintLayout a;
    public final TextView b;
    public final TextView c;
    public final TextView d;

    private r0(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
    }

    public static r0 a(View view) {
        int i = R$id.tvDes;
        TextView textView = (TextView) f4.b.a(view, i);
        if (textView != null) {
            i = R$id.tvJump;
            TextView textView2 = (TextView) f4.b.a(view, i);
            if (textView2 != null) {
                i = R$id.tvTitle;
                TextView textView3 = (TextView) f4.b.a(view, i);
                if (textView3 != null) {
                    return new r0((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
