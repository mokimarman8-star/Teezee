package ki;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.audio.R$id;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final View c;
    public final LinearLayoutCompat d;
    public final MagicIndicator e;
    public final TextView f;
    public final ViewPager2 g;

    private a(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, View view, LinearLayoutCompat linearLayoutCompat, MagicIndicator magicIndicator, TextView textView, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = view;
        this.d = linearLayoutCompat;
        this.e = magicIndicator;
        this.f = textView;
        this.g = viewPager2;
    }

    public static a a(View view) {
        View a;
        LinearLayoutCompat a2;
        MagicIndicator a3;
        ViewPager2 a4;
        int i = R$id.iv_clear;
        AppCompatImageView a5 = f4.b.a(view, i);
        if (a5 != null && (a = f4.b.a(view, (i = R$id.line1))) != null && (a2 = f4.b.a(view, (i = R$id.ll_ctl))) != null && (a3 = f4.b.a(view, (i = R$id.magic_indicator))) != null) {
            i = R$id.tv_close;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null && (a4 = f4.b.a(view, (i = R$id.view_pager))) != null) {
                return new a((ConstraintLayout) view, a5, a, a2, a3, textView, a4);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
