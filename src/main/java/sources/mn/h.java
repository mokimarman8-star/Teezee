package mn;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.player.longvideo.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h implements f4.a {
    private final LinearLayoutCompat a;
    public final EditText b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final LinearLayoutCompat f;
    public final LinearLayoutCompat g;

    private h(LinearLayoutCompat linearLayoutCompat, EditText editText, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3) {
        this.a = linearLayoutCompat;
        this.b = editText;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = appCompatImageView3;
        this.f = linearLayoutCompat2;
        this.g = linearLayoutCompat3;
    }

    public static h a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        int i = R$id.et_sync_adjust;
        EditText editText = (EditText) f4.b.a(view, i);
        if (editText != null && (a = f4.b.a(view, (i = R$id.iv_close))) != null && (a2 = f4.b.a(view, (i = R$id.iv_sync_adjust_minus))) != null && (a3 = f4.b.a(view, (i = R$id.iv_sync_adjust_plus))) != null) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
            i = R$id.llSyncAdjust;
            LinearLayoutCompat a4 = f4.b.a(view, i);
            if (a4 != null) {
                return new h(linearLayoutCompat, editText, a, a2, a3, linearLayoutCompat, a4);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
