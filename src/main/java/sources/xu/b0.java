package xu;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.usercenter.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b0 implements f4.a {
    private final LinearLayoutCompat a;
    public final RecyclerView b;
    public final AppCompatTextView c;

    private b0(LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.a = linearLayoutCompat;
        this.b = recyclerView;
        this.c = appCompatTextView;
    }

    public static b0 a(View view) {
        AppCompatTextView a;
        int i = R$id.recycler_view;
        RecyclerView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.tv_cancel))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new b0((LinearLayoutCompat) view, a2, a);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
