package jt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.baseui.widget.NestedScrollableHost;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f implements f4.a {
    private final ConstraintLayout a;
    public final EditTextWithClear b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final MagicIndicator e;
    public final NestedScrollableHost f;
    public final TextView g;
    public final AppCompatTextView h;
    public final ViewPager2 i;

    private f(ConstraintLayout constraintLayout, EditTextWithClear editTextWithClear, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, MagicIndicator magicIndicator, NestedScrollableHost nestedScrollableHost, TextView textView, AppCompatTextView appCompatTextView, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = editTextWithClear;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = magicIndicator;
        this.f = nestedScrollableHost;
        this.g = textView;
        this.h = appCompatTextView;
        this.i = viewPager2;
    }

    public static f a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        MagicIndicator a3;
        NestedScrollableHost a4;
        AppCompatTextView a5;
        ViewPager2 a6;
        int i = R$id.et_search_keyword;
        EditTextWithClear a7 = f4.b.a(view, i);
        if (a7 != null && (a = f4.b.a(view, (i = R$id.ivBack))) != null && (a2 = f4.b.a(view, (i = R$id.iv_search_keyword))) != null && (a3 = f4.b.a(view, (i = R$id.magic_indicator))) != null && (a4 = f4.b.a(view, (i = R$id.nsh_content))) != null) {
            i = R$id.tv_search;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null && (a5 = f4.b.a(view, (i = R$id.tvStyle))) != null && (a6 = f4.b.a(view, (i = R$id.view_pager))) != null) {
                return new f((ConstraintLayout) view, a7, a, a2, a3, a4, textView, a5, a6);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subtitle_search_download, viewGroup, false);
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
