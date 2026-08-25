package xv;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.videodetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final ProgressBar c;
    public final RecyclerView d;
    public final AppCompatTextView e;

    private a(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ProgressBar progressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = progressBar;
        this.d = recyclerView;
        this.e = appCompatTextView;
    }

    public static a a(View view) {
        RecyclerView a;
        AppCompatTextView a2;
        int i = R$id.iv_close;
        AppCompatImageView a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R$id.pb_loading;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a = f4.b.a(view, (i = R$id.f7rv))) != null && (a2 = f4.b.a(view, (i = R$id.tv_title))) != null) {
                return new a((ConstraintLayout) view, a3, progressBar, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
