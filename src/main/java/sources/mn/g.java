package mn;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.noober.background.view.BLTextView;
import com.transsion.player.longvideo.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements f4.a {
    private final ConstraintLayout a;
    public final Group b;
    public final Group c;
    public final BLTextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final BLTextView h;
    public final LinearLayout i;
    public final ConstraintLayout j;

    private g(ConstraintLayout constraintLayout, Group group, Group group2, BLTextView bLTextView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, BLTextView bLTextView2, LinearLayout linearLayout, ConstraintLayout constraintLayout2) {
        this.a = constraintLayout;
        this.b = group;
        this.c = group2;
        this.d = bLTextView;
        this.e = appCompatTextView;
        this.f = appCompatTextView2;
        this.g = appCompatTextView3;
        this.h = bLTextView2;
        this.i = linearLayout;
        this.j = constraintLayout2;
    }

    public static g a(View view) {
        Group a;
        BLTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        AppCompatTextView a5;
        BLTextView a6;
        int i = R$id.group1;
        Group a7 = f4.b.a(view, i);
        if (a7 != null && (a = f4.b.a(view, (i = R$id.group2))) != null && (a2 = f4.b.a(view, (i = R$id.interceptPremium))) != null && (a3 = f4.b.a(view, (i = R$id.interceptTip))) != null && (a4 = f4.b.a(view, (i = R$id.interceptTitle))) != null && (a5 = f4.b.a(view, (i = R$id.interceptTitleCam))) != null && (a6 = f4.b.a(view, (i = R$id.interceptWatchAd))) != null) {
            i = R$id.llBtn;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new g(constraintLayout, a7, a, a2, a3, a4, a5, a6, linearLayout, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
