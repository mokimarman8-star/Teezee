package qr;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.shorttv.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements f4.a {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final TextView c;

    private i(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = textView;
    }

    public static i a(View view) {
        int i = R.id.sub_operation_variable_recycle;
        RecyclerView a = f4.b.a(view, i);
        if (a != null) {
            i = R.id.sub_operation_variable_title;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                return new i((ConstraintLayout) view, a, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
