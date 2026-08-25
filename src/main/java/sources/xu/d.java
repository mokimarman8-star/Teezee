package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d implements f4.a {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final AppCompatButton c;
    public final TitleLayout d;

    private d(ConstraintLayout constraintLayout, RecyclerView recyclerView, AppCompatButton appCompatButton, TitleLayout titleLayout) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = appCompatButton;
        this.d = titleLayout;
    }

    public static d a(View view) {
        AppCompatButton a;
        TitleLayout a2;
        int i = R$id.recyclerView;
        RecyclerView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.submitButton))) == null || (a2 = f4.b.a(view, (i = R$id.toolbar))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new d((ConstraintLayout) view, a3, a, a2);
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_labels_feedback, viewGroup, false);
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
