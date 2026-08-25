package wn;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements f4.a {
    private final FrameLayout a;
    public final ImageView b;
    public final LinearLayoutCompat c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    private f(FrameLayout frameLayout, ImageView imageView, LinearLayoutCompat linearLayoutCompat, TextView textView, TextView textView2, TextView textView3) {
        this.a = frameLayout;
        this.b = imageView;
        this.c = linearLayoutCompat;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
    }

    public static f a(View view) {
        LinearLayoutCompat a;
        int i = R$id.ivSelect;
        ImageView imageView = (ImageView) f4.b.a(view, i);
        if (imageView != null && (a = f4.b.a(view, (i = R$id.llSelect))) != null) {
            i = R$id.tvBtnCancel;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                i = R$id.tvBtnDownload;
                TextView textView2 = (TextView) f4.b.a(view, i);
                if (textView2 != null) {
                    i = R$id.tvTip;
                    TextView textView3 = (TextView) f4.b.a(view, i);
                    if (textView3 != null) {
                        return new f((FrameLayout) view, imageView, a, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
