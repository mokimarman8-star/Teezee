package iw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.web.R$id;
import com.transsion.web.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final ShapeableImageView c;
    public final RecyclerView d;
    public final TextView e;

    private b(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, RecyclerView recyclerView, TextView textView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = shapeableImageView;
        this.d = recyclerView;
        this.e = textView;
    }

    public static b a(View view) {
        ShapeableImageView a;
        RecyclerView a2;
        int i = R$id.iv_close;
        AppCompatImageView a3 = f4.b.a(view, i);
        if (a3 != null && (a = f4.b.a(view, (i = R$id.iv_share))) != null && (a2 = f4.b.a(view, (i = R$id.share_list))) != null) {
            i = R$id.tv_share_title;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                return new b((ConstraintLayout) view, a3, a, a2, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.dialog_imge_share, viewGroup, false);
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
