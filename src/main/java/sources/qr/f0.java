package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.widget.ShortTvGradientTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f0 implements f4.a {
    private final FrameLayout a;
    public final FrameLayout b;
    public final AppCompatTextView c;
    public final ShortTvGradientTextView d;

    private f0(FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatTextView appCompatTextView, ShortTvGradientTextView shortTvGradientTextView) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = appCompatTextView;
        this.d = shortTvGradientTextView;
    }

    public static f0 a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.tvName;
        AppCompatTextView a = f4.b.a(view, i);
        if (a != null) {
            i = R.id.tvNameSelected;
            ShortTvGradientTextView shortTvGradientTextView = (ShortTvGradientTextView) f4.b.a(view, i);
            if (shortTvGradientTextView != null) {
                return new f0(frameLayout, frameLayout, a, shortTvGradientTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static f0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.short_tv_item_language_select, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
