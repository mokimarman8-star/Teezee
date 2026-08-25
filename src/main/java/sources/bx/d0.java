package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d0 implements f4.a {
    private final FrameLayout a;
    public final z0 b;

    private d0(FrameLayout frameLayout, z0 z0Var) {
        this.a = frameLayout;
        this.b = z0Var;
    }

    public static d0 a(View view) {
        int i = R.id.included_content;
        View a = f4.b.a(view, i);
        if (a == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new d0((FrameLayout) view, z0.a(a));
    }

    public static d0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_download_res_path_setting, viewGroup, false);
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
