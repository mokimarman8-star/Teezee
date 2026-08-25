package tn;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.transsion.player.view.R$id;
import f4.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements f4.a {
    private final LinearLayout a;
    public final ImageView b;
    public final ProgressBar c;
    public final LinearLayout d;
    public final ProgressBar e;
    public final LinearLayout f;

    private a(LinearLayout linearLayout, ImageView imageView, ProgressBar progressBar, LinearLayout linearLayout2, ProgressBar progressBar2, LinearLayout linearLayout3) {
        this.a = linearLayout;
        this.b = imageView;
        this.c = progressBar;
        this.d = linearLayout2;
        this.e = progressBar2;
        this.f = linearLayout3;
    }

    public static a a(View view) {
        int i = R$id.bvIV;
        ImageView imageView = (ImageView) b.a(view, i);
        if (imageView != null) {
            i = R$id.bvProgress;
            ProgressBar progressBar = (ProgressBar) b.a(view, i);
            if (progressBar != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = R$id.secProgress;
                ProgressBar progressBar2 = (ProgressBar) b.a(view, i);
                if (progressBar2 != null) {
                    i = R$id.tipsLL;
                    LinearLayout linearLayout2 = (LinearLayout) b.a(view, i);
                    if (linearLayout2 != null) {
                        return new a(linearLayout, imageView, progressBar, linearLayout, progressBar2, linearLayout2);
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
