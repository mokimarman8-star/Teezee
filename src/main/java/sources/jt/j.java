package jt;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.subtitle.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class j implements f4.a {
    private final LinearLayoutCompat a;
    public final EditText b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final LinearLayoutCompat f;

    private j(LinearLayoutCompat linearLayoutCompat, EditText editText, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat2) {
        this.a = linearLayoutCompat;
        this.b = editText;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = appCompatImageView3;
        this.f = linearLayoutCompat2;
    }

    public static j a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        int i = R$id.et_sync_adjust;
        EditText editText = (EditText) f4.b.a(view, i);
        if (editText == null || (a = f4.b.a(view, (i = R$id.iv_close))) == null || (a2 = f4.b.a(view, (i = R$id.iv_sync_adjust_minus))) == null || (a3 = f4.b.a(view, (i = R$id.iv_sync_adjust_plus))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
        return new j(linearLayoutCompat, editText, a, a2, a3, linearLayoutCompat);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
