package mn;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsion.player.longvideo.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements f4.a {
    private final ConstraintLayout a;
    public final BLTextView b;
    public final BLTextView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;

    private e(ConstraintLayout constraintLayout, BLTextView bLTextView, BLTextView bLTextView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = bLTextView;
        this.c = bLTextView2;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
    }

    public static e a(View view) {
        BLTextView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        int i = R$id.longVdTvOperator;
        BLTextView a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R$id.longVdTvPlay))) == null || (a2 = f4.b.a(view, (i = R$id.longVodTvTips))) == null || (a3 = f4.b.a(view, (i = R$id.longVodTvTitle))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new e((ConstraintLayout) view, a4, a, a2, a3);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
