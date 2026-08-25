package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLConstraintLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i0 implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final BLConstraintLayout e;
    public final BLConstraintLayout f;
    public final BLConstraintLayout g;

    private i0(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, BLConstraintLayout bLConstraintLayout, BLConstraintLayout bLConstraintLayout2, BLConstraintLayout bLConstraintLayout3) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatImageView3;
        this.e = bLConstraintLayout;
        this.f = bLConstraintLayout2;
        this.g = bLConstraintLayout3;
    }

    public static i0 a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        BLConstraintLayout a3;
        BLConstraintLayout a4;
        BLConstraintLayout a5;
        int i = R$id.ivChangePinArrow;
        AppCompatImageView a6 = f4.b.a(view, i);
        if (a6 == null || (a = f4.b.a(view, (i = R$id.ivDeletePinArrow))) == null || (a2 = f4.b.a(view, (i = R$id.ivTrumpet))) == null || (a3 = f4.b.a(view, (i = R$id.layoutChangePin))) == null || (a4 = f4.b.a(view, (i = R$id.layoutDeletePin))) == null || (a5 = f4.b.a(view, (i = R$id.layoutLockStatus))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new i0((ConstraintLayout) view, a6, a, a2, a3, a4, a5);
    }

    public static i0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_pin_management, viewGroup, false);
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
