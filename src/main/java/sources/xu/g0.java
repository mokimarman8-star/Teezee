package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLView;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g0 implements f4.a {
    private final ConstraintLayout a;
    public final BLLinearLayout b;
    public final ShapeableImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ShapeableImageView f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final LinearLayout j;
    public final TnTextView k;
    public final TnTextView l;
    public final BLView m;
    public final BLView n;

    private g0(ConstraintLayout constraintLayout, BLLinearLayout bLLinearLayout, ShapeableImageView shapeableImageView, ImageView imageView, ImageView imageView2, ShapeableImageView shapeableImageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TnTextView tnTextView, TnTextView tnTextView2, BLView bLView, BLView bLView2) {
        this.a = constraintLayout;
        this.b = bLLinearLayout;
        this.c = shapeableImageView;
        this.d = imageView;
        this.e = imageView2;
        this.f = shapeableImageView2;
        this.g = linearLayout;
        this.h = linearLayout2;
        this.i = linearLayout3;
        this.j = linearLayout4;
        this.k = tnTextView;
        this.l = tnTextView2;
        this.m = bLView;
        this.n = bLView2;
    }

    public static g0 a(View view) {
        ShapeableImageView a;
        ShapeableImageView a2;
        TnTextView a3;
        TnTextView a4;
        BLView a5;
        BLView a6;
        int i = R$id.ivAddKids;
        BLLinearLayout a7 = f4.b.a(view, i);
        if (a7 != null && (a = f4.b.a(view, (i = R$id.ivAdultAvatar))) != null) {
            i = R$id.ivAdultEditIcon;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null) {
                i = R$id.ivEditIcon;
                ImageView imageView2 = (ImageView) f4.b.a(view, i);
                if (imageView2 != null && (a2 = f4.b.a(view, (i = R$id.ivKidsAvatar))) != null) {
                    i = R$id.layoutAccountsRow;
                    LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                    if (linearLayout != null) {
                        i = R$id.layoutAddKids;
                        LinearLayout linearLayout2 = (LinearLayout) f4.b.a(view, i);
                        if (linearLayout2 != null) {
                            i = R$id.layoutAdultProfile;
                            LinearLayout linearLayout3 = (LinearLayout) f4.b.a(view, i);
                            if (linearLayout3 != null) {
                                i = R$id.layoutKidsProfile;
                                LinearLayout linearLayout4 = (LinearLayout) f4.b.a(view, i);
                                if (linearLayout4 != null && (a3 = f4.b.a(view, (i = R$id.tvAdultName))) != null && (a4 = f4.b.a(view, (i = R$id.tvKidsName))) != null && (a5 = f4.b.a(view, (i = R$id.viewAdultAvatarOverlay))) != null && (a6 = f4.b.a(view, (i = R$id.viewKidsAvatarOverlay))) != null) {
                                    return new g0((ConstraintLayout) view, a7, a, imageView, imageView2, a2, linearLayout, linearLayout2, linearLayout3, linearLayout4, a3, a4, a5, a6);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static g0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_manage_profiles, viewGroup, false);
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
