package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.wrapperad.view.NativeSlideshowView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class k0 implements f4.a {
    private final FrameLayout a;
    public final FrameLayout b;
    public final NativeSlideshowView c;

    private k0(FrameLayout frameLayout, FrameLayout frameLayout2, NativeSlideshowView nativeSlideshowView) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = nativeSlideshowView;
    }

    public static k0 a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.nativeSlideshowView;
        NativeSlideshowView nativeSlideshowView = (NativeSlideshowView) f4.b.a(view, i);
        if (nativeSlideshowView != null) {
            return new k0(frameLayout, frameLayout, nativeSlideshowView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static k0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static k0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_top_card_ad_layout, viewGroup, false);
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
