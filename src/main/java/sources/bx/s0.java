package bx;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.downloader.R;
import com.transsnet.downloader.widget.DownloadPremiumView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class s0 implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final DownloadPremiumView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final View h;

    private s0(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, DownloadPremiumView downloadPremiumView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, View view) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = downloadPremiumView;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
        this.f = appCompatTextView3;
        this.g = appCompatTextView4;
        this.h = view;
    }

    public static s0 a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        View a5;
        int i = R.id.iv_check;
        AppCompatImageView a6 = f4.b.a(view, i);
        if (a6 != null) {
            i = R.id.iv_premium;
            DownloadPremiumView downloadPremiumView = (DownloadPremiumView) f4.b.a(view, i);
            if (downloadPremiumView != null && (a = f4.b.a(view, (i = R.id.tv_ep))) != null && (a2 = f4.b.a(view, (i = R.id.tv_size))) != null && (a3 = f4.b.a(view, (i = R.id.tv_time))) != null && (a4 = f4.b.a(view, (i = R.id.tv_title))) != null && (a5 = f4.b.a(view, (i = R.id.v_size_line))) != null) {
                return new s0((ConstraintLayout) view, a6, downloadPremiumView, a, a2, a3, a4, a5);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
