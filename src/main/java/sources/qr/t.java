package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.transsion.shorttv.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class t implements f4.a {
    private final BLConstraintLayout a;
    public final AppCompatImageView b;
    public final ProgressBar c;
    public final RecyclerView d;
    public final AppCompatTextView e;

    private t(BLConstraintLayout bLConstraintLayout, AppCompatImageView appCompatImageView, ProgressBar progressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.a = bLConstraintLayout;
        this.b = appCompatImageView;
        this.c = progressBar;
        this.d = recyclerView;
        this.e = appCompatTextView;
    }

    public static t a(View view) {
        RecyclerView a;
        AppCompatTextView a2;
        int i = R.id.iv_close;
        AppCompatImageView a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R.id.pb_loading;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a = f4.b.a(view, (i = R.id.rv))) != null && (a2 = f4.b.a(view, (i = R.id.tv_title))) != null) {
                return new t((BLConstraintLayout) view, a3, progressBar, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static t c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.short_tv_dialog_language_list, viewGroup, false);
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
