package yo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements f4.a {
    private final ConstraintLayout a;
    public final ShapeableImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;

    private f(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = shapeableImageView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
    }

    public static f a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R$id.iv_avatar;
        ShapeableImageView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.tv_prize_name))) == null || (a2 = f4.b.a(view, (i = R$id.tv_user_name))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new f((ConstraintLayout) view, a3, a, a2);
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.prize_flow_item, viewGroup, false);
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
