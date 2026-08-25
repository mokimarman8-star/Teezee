package yo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.task.ad.StageTaskProgressLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final StageTaskProgressLayout d;
    public final CardView e;

    private g(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, StageTaskProgressLayout stageTaskProgressLayout, CardView cardView) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = stageTaskProgressLayout;
        this.e = cardView;
    }

    public static g a(View view) {
        AppCompatTextView a;
        CardView a2;
        int i = R$id.btn_action;
        AppCompatTextView a3 = f4.b.a(view, i);
        if (a3 != null && (a = f4.b.a(view, (i = R$id.dada_title))) != null) {
            i = R$id.double_progress;
            StageTaskProgressLayout stageTaskProgressLayout = (StageTaskProgressLayout) f4.b.a(view, i);
            if (stageTaskProgressLayout != null && (a2 = f4.b.a(view, (i = R$id.icon_cardview))) != null) {
                return new g((ConstraintLayout) view, a3, a, stageTaskProgressLayout, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static g c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.rc_dada_activate_view, viewGroup, false);
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
