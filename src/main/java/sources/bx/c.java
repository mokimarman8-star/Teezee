package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tn.lib.view.TitleLayout;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c implements f4.a {
    private final LinearLayoutCompat a;
    public final FrameLayout b;
    public final TitleLayout c;

    private c(LinearLayoutCompat linearLayoutCompat, FrameLayout frameLayout, TitleLayout titleLayout) {
        this.a = linearLayoutCompat;
        this.b = frameLayout;
        this.c = titleLayout;
    }

    public static c a(View view) {
        TitleLayout a;
        int i = R.id.container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout == null || (a = f4.b.a(view, (i = R.id.title_layout))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new c((LinearLayoutCompat) view, frameLayout, a);
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_download_series_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
