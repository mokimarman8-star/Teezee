package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e0 implements f4.a {
    private final BLConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final BLView g;

    private e0(BLConstraintLayout bLConstraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, BLView bLView) {
        this.a = bLConstraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
        this.f = appCompatTextView3;
        this.g = bLView;
    }

    public static e0 a(View view) {
        AppCompatImageView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        BLView a5;
        int i = R.id.iv_ad;
        AppCompatImageView a6 = f4.b.a(view, i);
        if (a6 == null || (a = f4.b.a(view, (i = R.id.iv_close))) == null || (a2 = f4.b.a(view, (i = R.id.tv_ep))) == null || (a3 = f4.b.a(view, (i = R.id.tv_unlock))) == null || (a4 = f4.b.a(view, (i = R.id.tv_watch))) == null || (a5 = f4.b.a(view, (i = R.id.v_bg))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new e0((BLConstraintLayout) view, a6, a, a2, a3, a4, a5);
    }

    public static e0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_download_res_short_tv_ad, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.a;
    }
}
