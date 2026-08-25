package gm;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.member.R$id;
import com.transsion.member.view.CheckInView;
import com.transsion.member.view.GradientTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements f4.a {
    private final LinearLayout a;
    public final CheckBox b;
    public final GradientTextView c;
    public final ImageView d;
    public final AppCompatImageView e;
    public final CheckInView f;
    public final TextView g;
    public final TextView h;
    public final GradientTextView i;

    private f(LinearLayout linearLayout, CheckBox checkBox, GradientTextView gradientTextView, ImageView imageView, AppCompatImageView appCompatImageView, CheckInView checkInView, TextView textView, TextView textView2, GradientTextView gradientTextView2) {
        this.a = linearLayout;
        this.b = checkBox;
        this.c = gradientTextView;
        this.d = imageView;
        this.e = appCompatImageView;
        this.f = checkInView;
        this.g = textView;
        this.h = textView2;
        this.i = gradientTextView2;
    }

    public static f a(View view) {
        AppCompatImageView a;
        int i = R$id.dialog_ignore;
        CheckBox checkBox = (CheckBox) f4.b.a(view, i);
        if (checkBox != null) {
            i = R$id.go_purchase_member;
            GradientTextView gradientTextView = (GradientTextView) f4.b.a(view, i);
            if (gradientTextView != null) {
                i = R$id.ic_tips;
                ImageView imageView = (ImageView) f4.b.a(view, i);
                if (imageView != null && (a = f4.b.a(view, (i = R$id.ivClose))) != null) {
                    i = R$id.member_check_in_view;
                    CheckInView checkInView = (CheckInView) f4.b.a(view, i);
                    if (checkInView != null) {
                        i = R$id.member_tips;
                        TextView textView = (TextView) f4.b.a(view, i);
                        if (textView != null) {
                            i = R$id.point_tips;
                            TextView textView2 = (TextView) f4.b.a(view, i);
                            if (textView2 != null) {
                                i = R$id.title;
                                GradientTextView gradientTextView2 = (GradientTextView) f4.b.a(view, i);
                                if (gradientTextView2 != null) {
                                    return new f((LinearLayout) view, checkBox, gradientTextView, imageView, a, checkInView, textView, textView2, gradientTextView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
