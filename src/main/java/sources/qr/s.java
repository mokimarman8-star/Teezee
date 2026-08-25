package qr;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.transsion.shorttv.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class s implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final ProgressBar c;
    public final RecyclerView d;
    public final TabLayout e;
    public final AppCompatTextView f;
    public final View g;

    private s(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ProgressBar progressBar, RecyclerView recyclerView, TabLayout tabLayout, AppCompatTextView appCompatTextView, View view) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = progressBar;
        this.d = recyclerView;
        this.e = tabLayout;
        this.f = appCompatTextView;
        this.g = view;
    }

    public static s a(View view) {
        RecyclerView a;
        TabLayout a2;
        AppCompatTextView a3;
        View a4;
        int i = R.id.iv_close;
        AppCompatImageView a5 = f4.b.a(view, i);
        if (a5 != null) {
            i = R.id.pb_loading;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a = f4.b.a(view, (i = R.id.rv))) != null && (a2 = f4.b.a(view, (i = R.id.tab))) != null && (a3 = f4.b.a(view, (i = R.id.tv_title))) != null && (a4 = f4.b.a(view, (i = R.id.view_line))) != null) {
                return new s((ConstraintLayout) view, a5, progressBar, a, a2, a3, a4);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
