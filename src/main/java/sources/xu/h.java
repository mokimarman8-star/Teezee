package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h implements f4.a {
    private final LinearLayout a;
    public final View b;
    public final FrameLayout c;
    public final ImageView d;

    private h(LinearLayout linearLayout, View view, FrameLayout frameLayout, ImageView imageView) {
        this.a = linearLayout;
        this.b = view;
        this.c = frameLayout;
        this.d = imageView;
    }

    public static h a(View view) {
        int i = R$id.divider_line;
        View a = f4.b.a(view, i);
        if (a != null) {
            i = R$id.flContainer;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R$id.ivBack;
                ImageView imageView = (ImageView) f4.b.a(view, i);
                if (imageView != null) {
                    return new h((LinearLayout) view, a, frameLayout, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_pin_management, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
