package yo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k implements f4.a {
    private final ConstraintLayout a;
    public final ImageView b;
    public final AppCompatTextView c;
    public final CardView d;

    private k(ConstraintLayout constraintLayout, ImageView imageView, AppCompatTextView appCompatTextView, CardView cardView) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = appCompatTextView;
        this.d = cardView;
    }

    public static k a(View view) {
        AppCompatTextView a;
        CardView a2;
        int i = R$id.ad_icon;
        ImageView imageView = (ImageView) f4.b.a(view, i);
        if (imageView == null || (a = f4.b.a(view, (i = R$id.ad_title))) == null || (a2 = f4.b.a(view, (i = R$id.icon_cardview))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new k((ConstraintLayout) view, imageView, a, a2);
    }

    public static k c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.stage_task_ssp_native_ad_layout, viewGroup, false);
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
