package qr;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.widget.TnTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m0 implements f4.a {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final TnTextView c;

    private m0(ConstraintLayout constraintLayout, RecyclerView recyclerView, TnTextView tnTextView) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = tnTextView;
    }

    public static m0 a(View view) {
        int i = R.id.sub_operation_appointment_recycle;
        RecyclerView a = f4.b.a(view, i);
        if (a != null) {
            i = R.id.sub_operation_appointment_title;
            TnTextView tnTextView = (TnTextView) f4.b.a(view, i);
            if (tnTextView != null) {
                return new m0((ConstraintLayout) view, a, tnTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
