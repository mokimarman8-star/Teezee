package wn;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j0 implements f4.a {
    private final AppCompatTextView a;
    public final AppCompatTextView b;

    private j0(AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = appCompatTextView;
        this.b = appCompatTextView2;
    }

    public static j0 a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) view;
        return new j0(appCompatTextView, appCompatTextView);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppCompatTextView getRoot() {
        return this.a;
    }
}
