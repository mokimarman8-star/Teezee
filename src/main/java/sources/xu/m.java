package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class m implements f4.a {
    private final LinearLayoutCompat a;
    public final TextView b;
    public final TextView c;
    public final TextView d;

    private m(LinearLayoutCompat linearLayoutCompat, TextView textView, TextView textView2, TextView textView3) {
        this.a = linearLayoutCompat;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
    }

    public static m a(View view) {
        int i = R$id.btnEdit;
        TextView textView = (TextView) f4.b.a(view, i);
        if (textView != null) {
            i = R$id.btnFollowers;
            TextView textView2 = (TextView) f4.b.a(view, i);
            if (textView2 != null) {
                i = R$id.btnFollowing;
                TextView textView3 = (TextView) f4.b.a(view, i);
                if (textView3 != null) {
                    return new m((LinearLayoutCompat) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static m c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static m d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_user_center, viewGroup, false);
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
