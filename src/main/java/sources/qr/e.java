package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.shorttv.R;
import com.transsion.shorttv_pugc.base.widget.ShortTvGradientTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements f4.a {
    private final FrameLayout a;
    public final FrameLayout b;
    public final AppCompatTextView c;
    public final ShortTvGradientTextView d;

    private e(FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatTextView appCompatTextView, ShortTvGradientTextView shortTvGradientTextView) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = appCompatTextView;
        this.d = shortTvGradientTextView;
    }

    public static e a(View view) {
        ShortTvGradientTextView a;
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.tvName;
        AppCompatTextView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R.id.tvNameSelected))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new e(frameLayout, frameLayout, a2, a);
    }

    public static e c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.pugc_short_tv_item_language_select, viewGroup, false);
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
