package yo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.task.ad.StageTaskProgressLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final View c;
    public final AppCompatTextView d;
    public final StageTaskProgressLayout e;

    private l(ConstraintLayout constraintLayout, FrameLayout frameLayout, View view, AppCompatTextView appCompatTextView, StageTaskProgressLayout stageTaskProgressLayout) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = view;
        this.d = appCompatTextView;
        this.e = stageTaskProgressLayout;
    }

    public static l a(View view) {
        View a;
        AppCompatTextView a2;
        int i = R$id.ad_container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R$id.ad_mask))) != null && (a2 = f4.b.a(view, (i = R$id.btn_action))) != null) {
            i = R$id.double_progress;
            StageTaskProgressLayout stageTaskProgressLayout = (StageTaskProgressLayout) f4.b.a(view, i);
            if (stageTaskProgressLayout != null) {
                return new l((ConstraintLayout) view, frameLayout, a, a2, stageTaskProgressLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static l c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.stage_task_view_layout, viewGroup, false);
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
