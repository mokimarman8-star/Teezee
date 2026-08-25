package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tn.lib.view.TitleLayout;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d implements f4.a {
    private final FrameLayout a;
    public final FrameLayout b;
    public final TitleLayout c;

    private d(FrameLayout frameLayout, FrameLayout frameLayout2, TitleLayout titleLayout) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = titleLayout;
    }

    public static d a(View view) {
        TitleLayout a;
        int i = R.id.container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout == null || (a = f4.b.a(view, (i = R.id.title_layout))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new d((FrameLayout) view, frameLayout, a);
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_my_downloads, viewGroup, false);
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
