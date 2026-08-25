package qr;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.shorttv.R;
import com.transsion.shorttv_pugc.base.widget.TnTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h implements f4.a {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final TnTextView c;

    private h(ConstraintLayout constraintLayout, RecyclerView recyclerView, TnTextView tnTextView) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = tnTextView;
    }

    public static h a(View view) {
        TnTextView a;
        int i = R.id.sub_operation_appointment_recycle;
        RecyclerView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R.id.sub_operation_appointment_title))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new h((ConstraintLayout) view, a2, a);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
