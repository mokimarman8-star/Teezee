package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class s implements f4.a {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final AppCompatImageView c;
    public final ImageView d;
    public final MagicIndicator e;
    public final ViewPager2 f;

    private s(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, ImageView imageView, MagicIndicator magicIndicator, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = appCompatImageView;
        this.d = imageView;
        this.e = magicIndicator;
        this.f = viewPager2;
    }

    public static s a(View view) {
        MagicIndicator a;
        ViewPager2 a2;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R$id.iv_back;
        AppCompatImageView a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R$id.iv_top_bg;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a = f4.b.a(view, (i = R$id.magic_indicator))) != null && (a2 = f4.b.a(view, (i = R$id.view_pager))) != null) {
                return new s(constraintLayout, constraintLayout, a3, imageView, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static s c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static s d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room_list_main, viewGroup, false);
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
