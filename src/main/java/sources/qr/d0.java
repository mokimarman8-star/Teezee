package qr;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.tabs.TabLayout;
import com.transsion.shorttv.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d0 implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final ConstraintLayout c;
    public final TabLayout d;

    private d0(ConstraintLayout constraintLayout, View view, ConstraintLayout constraintLayout2, TabLayout tabLayout) {
        this.a = constraintLayout;
        this.b = view;
        this.c = constraintLayout2;
        this.d = tabLayout;
    }

    public static d0 a(View view) {
        int i = R.id.divider;
        View a = f4.b.a(view, i);
        if (a != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i2 = R.id.tab_movie;
            TabLayout a2 = f4.b.a(view, i2);
            if (a2 != null) {
                return new d0(constraintLayout, a, constraintLayout, a2);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
