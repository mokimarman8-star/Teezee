package eh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final TitleLayout c;

    private a(ConstraintLayout constraintLayout, FrameLayout frameLayout, TitleLayout titleLayout) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = titleLayout;
    }

    public static a a(View view) {
        int i = R$id.container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null) {
            i = R$id.tool_bar;
            TitleLayout titleLayout = (TitleLayout) f4.b.a(view, i);
            if (titleLayout != null) {
                return new a((ConstraintLayout) view, frameLayout, titleLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_fragment_title, viewGroup, false);
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
