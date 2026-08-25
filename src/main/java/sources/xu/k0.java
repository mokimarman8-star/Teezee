package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.edit.widget.ProfileEditBar;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class k0 implements f4.a {
    private final RelativeLayout a;
    public final ProfileEditBar b;
    public final FrameLayout c;
    public final ProfileEditBar d;
    public final AppCompatImageView e;
    public final ImageView f;
    public final BLConstraintLayout g;
    public final ProgressBar h;
    public final RelativeLayout i;
    public final RelativeLayout j;
    public final RelativeLayout k;
    public final TnTextView l;
    public final TextView m;
    public final ShapeableImageView n;

    private k0(RelativeLayout relativeLayout, ProfileEditBar profileEditBar, FrameLayout frameLayout, ProfileEditBar profileEditBar2, AppCompatImageView appCompatImageView, ImageView imageView, BLConstraintLayout bLConstraintLayout, ProgressBar progressBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TnTextView tnTextView, TextView textView, ShapeableImageView shapeableImageView) {
        this.a = relativeLayout;
        this.b = profileEditBar;
        this.c = frameLayout;
        this.d = profileEditBar2;
        this.e = appCompatImageView;
        this.f = imageView;
        this.g = bLConstraintLayout;
        this.h = progressBar;
        this.i = relativeLayout2;
        this.j = relativeLayout3;
        this.k = relativeLayout4;
        this.l = tnTextView;
        this.m = textView;
        this.n = shapeableImageView;
    }

    public static k0 a(View view) {
        AppCompatImageView a;
        BLConstraintLayout a2;
        ShapeableImageView a3;
        int i = R$id.birth_profilebar;
        ProfileEditBar profileEditBar = (ProfileEditBar) f4.b.a(view, i);
        if (profileEditBar != null) {
            i = R$id.fl_edit;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R$id.gender_profilebar;
                ProfileEditBar profileEditBar2 = (ProfileEditBar) f4.b.a(view, i);
                if (profileEditBar2 != null && (a = f4.b.a(view, (i = R$id.ivDeleteArrow))) != null) {
                    i = R$id.iv_edit;
                    ImageView imageView = (ImageView) f4.b.a(view, i);
                    if (imageView != null && (a2 = f4.b.a(view, (i = R$id.layoutDeleteProfile))) != null) {
                        i = R$id.load_view;
                        ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                        if (progressBar != null) {
                            i = R$id.rl_head;
                            RelativeLayout relativeLayout = (RelativeLayout) f4.b.a(view, i);
                            if (relativeLayout != null) {
                                i = R$id.rl_nickname;
                                RelativeLayout relativeLayout2 = (RelativeLayout) f4.b.a(view, i);
                                if (relativeLayout2 != null) {
                                    RelativeLayout relativeLayout3 = (RelativeLayout) view;
                                    i = R$id.tvDeleteKidsProfile;
                                    TnTextView a4 = f4.b.a(view, i);
                                    if (a4 != null) {
                                        i = R$id.tv_nickname;
                                        TextView textView = (TextView) f4.b.a(view, i);
                                        if (textView != null && (a3 = f4.b.a(view, (i = R$id.user_head))) != null) {
                                            return new k0(relativeLayout3, profileEditBar, frameLayout, profileEditBar2, a, imageView, a2, progressBar, relativeLayout, relativeLayout2, relativeLayout3, a4, textView, a3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static k0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static k0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_profile_edit_centerlayout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
