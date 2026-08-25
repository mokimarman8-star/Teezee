package gm;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.member.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements f4.a {
    private final FrameLayout a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;

    private j(FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.a = frameLayout;
        this.b = appCompatImageView;
        this.c = appCompatTextView;
    }

    public static j a(View view) {
        AppCompatTextView a;
        int i = R$id.iv_back;
        AppCompatImageView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.tv_title))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new j((FrameLayout) view, a2, a);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
