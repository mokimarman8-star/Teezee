package yo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;
    public final LinearLayoutCompat c;

    private i(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, LinearLayoutCompat linearLayoutCompat) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = linearLayoutCompat;
    }

    public static i a(View view) {
        LinearLayoutCompat a;
        int i = R$id.rc_task_title;
        AppCompatTextView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.task_container))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new i((ConstraintLayout) view, a2, a);
    }

    public static i c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.rewards_center_task_view, viewGroup, false);
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
