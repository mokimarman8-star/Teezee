package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsnet.downloader.R;
import com.transsnet.downloader.widget.DownloadPathEntranceView;
import com.transsnet.downloader.widget.DownloadView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g0 implements f4.a {
    private final FrameLayout a;
    public final s0 b;
    public final ImageView c;
    public final View d;
    public final LinearLayoutCompat e;
    public final DownloadView f;
    public final AppCompatTextView g;
    public final View h;
    public final DownloadPathEntranceView i;

    private g0(FrameLayout frameLayout, s0 s0Var, ImageView imageView, View view, LinearLayoutCompat linearLayoutCompat, DownloadView downloadView, AppCompatTextView appCompatTextView, View view2, DownloadPathEntranceView downloadPathEntranceView) {
        this.a = frameLayout;
        this.b = s0Var;
        this.c = imageView;
        this.d = view;
        this.e = linearLayoutCompat;
        this.f = downloadView;
        this.g = appCompatTextView;
        this.h = view2;
        this.i = downloadPathEntranceView;
    }

    public static g0 a(View view) {
        View a;
        LinearLayoutCompat a2;
        DownloadView a3;
        AppCompatTextView a4;
        View a5;
        int i = R.id.included_content;
        View a6 = f4.b.a(view, i);
        if (a6 != null) {
            s0 a7 = s0.a(a6);
            i = R.id.iv_close;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a = f4.b.a(view, (i = R.id.line))) != null && (a2 = f4.b.a(view, (i = R.id.ll_content))) != null && (a3 = f4.b.a(view, (i = R.id.tv_download))) != null && (a4 = f4.b.a(view, (i = R.id.tv_title))) != null && (a5 = f4.b.a(view, (i = R.id.v_bottom))) != null) {
                i = R.id.v_path_entrance;
                DownloadPathEntranceView downloadPathEntranceView = (DownloadPathEntranceView) f4.b.a(view, i);
                if (downloadPathEntranceView != null) {
                    return new g0((FrameLayout) view, a7, imageView, a, a2, a3, a4, a5, downloadPathEntranceView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static g0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_download_res_single_res, viewGroup, false);
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
