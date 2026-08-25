package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.ProfileSettingTitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class k implements f4.a {
    private final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ProfileSettingTitleLayout d;
    public final ProfileSettingTitleLayout e;
    public final TitleLayout f;
    public final ProfileSettingTitleLayout g;
    public final TextView h;

    private k(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ProfileSettingTitleLayout profileSettingTitleLayout, ProfileSettingTitleLayout profileSettingTitleLayout2, TitleLayout titleLayout, ProfileSettingTitleLayout profileSettingTitleLayout3, TextView textView) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = profileSettingTitleLayout;
        this.e = profileSettingTitleLayout2;
        this.f = titleLayout;
        this.g = profileSettingTitleLayout3;
        this.h = textView;
    }

    public static k a(View view) {
        TitleLayout a;
        int i = R$id.ivAvatar;
        ImageView imageView = (ImageView) f4.b.a(view, i);
        if (imageView != null) {
            i = R$id.ivRight;
            ImageView imageView2 = (ImageView) f4.b.a(view, i);
            if (imageView2 != null) {
                i = R$id.titleBirth;
                ProfileSettingTitleLayout profileSettingTitleLayout = (ProfileSettingTitleLayout) f4.b.a(view, i);
                if (profileSettingTitleLayout != null) {
                    i = R$id.titleGender;
                    ProfileSettingTitleLayout profileSettingTitleLayout2 = (ProfileSettingTitleLayout) f4.b.a(view, i);
                    if (profileSettingTitleLayout2 != null && (a = f4.b.a(view, (i = R$id.titleLayout))) != null) {
                        i = R$id.titleRegion;
                        ProfileSettingTitleLayout profileSettingTitleLayout3 = (ProfileSettingTitleLayout) f4.b.a(view, i);
                        if (profileSettingTitleLayout3 != null) {
                            i = R$id.tvNickName;
                            TextView textView = (TextView) f4.b.a(view, i);
                            if (textView != null) {
                                return new k((ConstraintLayout) view, imageView, imageView2, profileSettingTitleLayout, profileSettingTitleLayout2, a, profileSettingTitleLayout3, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static k c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static k d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_profile_edit, viewGroup, false);
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
