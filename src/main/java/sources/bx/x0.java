package bx;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class x0 implements f4.a {
    private final View a;
    public final ConstraintLayout b;
    public final Group c;
    public final AppCompatImageView d;
    public final LinearLayout e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;

    private x0(View view, ConstraintLayout constraintLayout, Group group, AppCompatImageView appCompatImageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.a = view;
        this.b = constraintLayout;
        this.c = group;
        this.d = appCompatImageView;
        this.e = linearLayout;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
        this.j = textView5;
        this.k = textView6;
    }

    public static x0 a(View view) {
        Group a;
        AppCompatImageView a2;
        int i = R.id.cl_permission;
        ConstraintLayout a3 = f4.b.a(view, i);
        if (a3 != null && (a = f4.b.a(view, (i = R.id.group_permission))) != null && (a2 = f4.b.a(view, (i = R.id.iv_icon))) != null) {
            i = R.id.ll_content;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null) {
                i = R.id.tv_available_size;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null) {
                    i = R.id.tv_change;
                    TextView textView2 = (TextView) f4.b.a(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_path_name;
                        TextView textView3 = (TextView) f4.b.a(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_permission_btn;
                            TextView textView4 = (TextView) f4.b.a(view, i);
                            if (textView4 != null) {
                                i = R.id.tv_permission_tips;
                                TextView textView5 = (TextView) f4.b.a(view, i);
                                if (textView5 != null) {
                                    i = R.id.tv_permission_title;
                                    TextView textView6 = (TextView) f4.b.a(view, i);
                                    if (textView6 != null) {
                                        return new x0(view, a3, a, a2, linearLayout, textView, textView2, textView3, textView4, textView5, textView6);
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

    public View getRoot() {
        return this.a;
    }
}
