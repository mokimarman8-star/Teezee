package sj;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.task.wheel.LuckyWheelView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements f4.a {
    private final LinearLayout a;
    public final AppCompatImageView b;
    public final LuckyWheelView c;
    public final LinearLayout d;
    public final TextView e;
    public final TextView f;
    public final TextView g;

    private f(LinearLayout linearLayout, AppCompatImageView appCompatImageView, LuckyWheelView luckyWheelView, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.a = linearLayout;
        this.b = appCompatImageView;
        this.c = luckyWheelView;
        this.d = linearLayout2;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
    }

    public static f a(View view) {
        int i = R$id.ivClose;
        AppCompatImageView a = f4.b.a(view, i);
        if (a != null) {
            i = R$id.luckyWheel;
            LuckyWheelView luckyWheelView = (LuckyWheelView) f4.b.a(view, i);
            if (luckyWheelView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = R$id.spinNowBtn;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null) {
                    i = R$id.tvTitle1;
                    TextView textView2 = (TextView) f4.b.a(view, i);
                    if (textView2 != null) {
                        i = R$id.tvTitle2;
                        TextView textView3 = (TextView) f4.b.a(view, i);
                        if (textView3 != null) {
                            return new f(linearLayout, a, luckyWheelView, linearLayout, textView, textView2, textView3);
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
