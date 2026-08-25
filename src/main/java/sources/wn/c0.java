package wn;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c0 implements f4.a {
    private final LinearLayoutCompat a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;

    private c0(LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.a = linearLayoutCompat;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = appCompatTextView3;
    }

    public static c0 a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R$id.iv_all;
        AppCompatTextView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.iv_hottest))) == null || (a2 = f4.b.a(view, (i = R$id.iv_latest))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new c0((LinearLayoutCompat) view, a3, a, a2);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
