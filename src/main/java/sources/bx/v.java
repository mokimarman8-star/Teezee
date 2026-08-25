package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.downloader.R;
import com.transsnet.downloader.widget.DownloadPanelForYouFootView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class v implements f4.a {
    private final LinearLayout a;
    public final FrameLayout b;
    public final DownloadPanelForYouFootView c;
    public final LinearLayout d;
    public final RecyclerView e;
    public final NestedScrollView f;

    private v(LinearLayout linearLayout, FrameLayout frameLayout, DownloadPanelForYouFootView downloadPanelForYouFootView, LinearLayout linearLayout2, RecyclerView recyclerView, NestedScrollView nestedScrollView) {
        this.a = linearLayout;
        this.b = frameLayout;
        this.c = downloadPanelForYouFootView;
        this.d = linearLayout2;
        this.e = recyclerView;
        this.f = nestedScrollView;
    }

    public static v a(View view) {
        NestedScrollView a;
        int i = R.id.fl_empty_root;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null) {
            i = R.id.foot_for_you;
            DownloadPanelForYouFootView downloadPanelForYouFootView = (DownloadPanelForYouFootView) f4.b.a(view, i);
            if (downloadPanelForYouFootView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = R.id.recycler_view;
                RecyclerView a2 = f4.b.a(view, i);
                if (a2 != null && (a = f4.b.a(view, (i = R.id.sv_empty_root))) != null) {
                    return new v(linearLayout, frameLayout, downloadPanelForYouFootView, linearLayout, a2, a);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static v c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static v d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_download_list, viewGroup, false);
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
