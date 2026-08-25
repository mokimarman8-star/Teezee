package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.view.AdvRecyclerView;
import com.transsnet.downloader.R;
import com.transsnet.downloader.widget.DownloadTransferLaterTipsView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class x implements f4.a {
    private final FrameLayout a;
    public final AdvRecyclerView b;
    public final SwipeRefreshLayout c;
    public final DownloadTransferLaterTipsView d;

    private x(FrameLayout frameLayout, AdvRecyclerView advRecyclerView, SwipeRefreshLayout swipeRefreshLayout, DownloadTransferLaterTipsView downloadTransferLaterTipsView) {
        this.a = frameLayout;
        this.b = advRecyclerView;
        this.c = swipeRefreshLayout;
        this.d = downloadTransferLaterTipsView;
    }

    public static x a(View view) {
        SwipeRefreshLayout a;
        int i = R.id.rv_list;
        AdvRecyclerView a2 = f4.b.a(view, i);
        if (a2 != null && (a = f4.b.a(view, (i = R.id.swipe_refresh))) != null) {
            i = R.id.v_transfer_later_tips;
            DownloadTransferLaterTipsView downloadTransferLaterTipsView = (DownloadTransferLaterTipsView) f4.b.a(view, i);
            if (downloadTransferLaterTipsView != null) {
                return new x((FrameLayout) view, a2, a, downloadTransferLaterTipsView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static x c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static x d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_download_panel, viewGroup, false);
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
