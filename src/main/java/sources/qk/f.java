package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements f4.a {
    private final FrameLayout a;
    public final ConstraintLayout b;
    public final View c;
    public final AppCompatImageView d;
    public final RecyclerView e;
    public final TnTextView f;

    private f(FrameLayout frameLayout, ConstraintLayout constraintLayout, View view, AppCompatImageView appCompatImageView, RecyclerView recyclerView, TnTextView tnTextView) {
        this.a = frameLayout;
        this.b = constraintLayout;
        this.c = view;
        this.d = appCompatImageView;
        this.e = recyclerView;
        this.f = tnTextView;
    }

    public static f a(View view) {
        View a;
        AppCompatImageView a2;
        RecyclerView a3;
        TnTextView a4;
        int i = R.id.clHeader;
        ConstraintLayout a5 = f4.b.a(view, i);
        if (a5 == null || (a = f4.b.a(view, (i = R.id.divider))) == null || (a2 = f4.b.a(view, (i = R.id.ivClose))) == null || (a3 = f4.b.a(view, (i = R.id.rvGrades))) == null || (a4 = f4.b.a(view, (i = R.id.tvTitle))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new f((FrameLayout) view, a5, a, a2, a3, a4);
    }

    public static f c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_grade_select, viewGroup, false);
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
