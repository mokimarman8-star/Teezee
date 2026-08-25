package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.shorttv.R;
import com.transsion.shorttv._channel.ui.widget.ShortTvTitleLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final ShortTvTitleLayout c;

    private n(ConstraintLayout constraintLayout, FrameLayout frameLayout, ShortTvTitleLayout shortTvTitleLayout) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = shortTvTitleLayout;
    }

    public static n a(View view) {
        int i = R.id.content_layout;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null) {
            i = R.id.tool_bar;
            ShortTvTitleLayout shortTvTitleLayout = (ShortTvTitleLayout) f4.b.a(view, i);
            if (shortTvTitleLayout != null) {
                return new n((ConstraintLayout) view, frameLayout, shortTvTitleLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.short_tv_activity_movie_filter, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
