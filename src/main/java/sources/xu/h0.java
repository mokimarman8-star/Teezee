package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h0 implements f4.a {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final AppCompatImageView c;
    public final ConstraintLayout d;

    private h0(ConstraintLayout constraintLayout, RecyclerView recyclerView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = appCompatImageView;
        this.d = constraintLayout2;
    }

    public static h0 a(View view) {
        AppCompatImageView a;
        int i = R$id.contentList;
        RecyclerView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.iv_qr_code))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        return new h0(constraintLayout, a2, a, constraintLayout);
    }

    public static h0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_me, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
