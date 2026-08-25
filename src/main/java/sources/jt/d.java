package jt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d implements f4.a {
    private final ConstraintLayout a;
    public final EditTextWithClear b;
    public final AppCompatImageView c;
    public final ImageView d;
    public final LinearLayoutCompat e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    private d(ConstraintLayout constraintLayout, EditTextWithClear editTextWithClear, AppCompatImageView appCompatImageView, ImageView imageView, LinearLayoutCompat linearLayoutCompat, TextView textView, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = editTextWithClear;
        this.c = appCompatImageView;
        this.d = imageView;
        this.e = linearLayoutCompat;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
    }

    public static d a(View view) {
        AppCompatImageView a;
        LinearLayoutCompat a2;
        int i = R$id.et_search_keyword;
        EditTextWithClear a3 = f4.b.a(view, i);
        if (a3 != null && (a = f4.b.a(view, (i = R$id.iv_search_keyword))) != null) {
            i = R$id.iv_select;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a2 = f4.b.a(view, (i = R$id.ll_select))) != null) {
                i = R$id.tv_download;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null) {
                    i = R$id.tv_tips;
                    TextView textView2 = (TextView) f4.b.a(view, i);
                    if (textView2 != null) {
                        i = R$id.tv_title;
                        TextView textView3 = (TextView) f4.b.a(view, i);
                        if (textView3 != null) {
                            return new d((ConstraintLayout) view, a3, a, imageView, a2, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_no_subtitle_tips, viewGroup, false);
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
