package wn;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l0 implements f4.a {
    private final LinearLayout a;
    public final ImageView b;
    public final LinearLayout c;
    public final TextView d;
    public final TextView e;
    public final View f;

    private l0(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView, TextView textView2, View view) {
        this.a = linearLayout;
        this.b = imageView;
        this.c = linearLayout2;
        this.d = textView;
        this.e = textView2;
        this.f = view;
    }

    public static l0 a(View view) {
        View a;
        int i = R$id.ivRight;
        ImageView imageView = (ImageView) f4.b.a(view, i);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R$id.tvCountDown;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                i = R$id.tvGetAdFree;
                TextView textView2 = (TextView) f4.b.a(view, i);
                if (textView2 != null && (a = f4.b.a(view, (i = R$id.view))) != null) {
                    return new l0(linearLayout, imageView, linearLayout, textView, textView2, a);
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
