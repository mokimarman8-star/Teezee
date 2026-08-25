package mn;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.player.longvideo.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements f4.a {
    private final LinearLayout a;
    public final TextView b;
    public final TextView c;
    public final LinearLayout d;

    private d(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2) {
        this.a = linearLayout;
        this.b = textView;
        this.c = textView2;
        this.d = linearLayout2;
    }

    public static d a(View view) {
        int i = R$id.tv_loading;
        TextView textView = (TextView) f4.b.a(view, i);
        if (textView != null) {
            i = R$id.tv_speed;
            TextView textView2 = (TextView) f4.b.a(view, i);
            if (textView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new d(linearLayout, textView, textView2, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
