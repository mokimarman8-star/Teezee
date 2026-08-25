package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k implements f4.a {
    private final FrameLayout a;

    private k(FrameLayout frameLayout) {
        this.a = frameLayout;
    }

    public static k a(View view) {
        if (view != null) {
            return new k((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static k c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static k d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_empty, viewGroup, false);
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
