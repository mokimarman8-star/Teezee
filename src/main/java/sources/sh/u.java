package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class u implements f4.a {
    private final LinearLayoutCompat a;
    public final Button b;
    public final Button c;
    public final Button d;
    public final RecyclerView e;
    public final AppCompatTextView f;

    private u(LinearLayoutCompat linearLayoutCompat, Button button, Button button2, Button button3, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.a = linearLayoutCompat;
        this.b = button;
        this.c = button2;
        this.d = button3;
        this.e = recyclerView;
        this.f = appCompatTextView;
    }

    public static u a(View view) {
        RecyclerView a;
        AppCompatTextView a2;
        int i = R$id.btn;
        Button button = (Button) f4.b.a(view, i);
        if (button != null) {
            i = R$id.btnLogger;
            Button button2 = (Button) f4.b.a(view, i);
            if (button2 != null) {
                i = R$id.btnRequestDetailLog;
                Button button3 = (Button) f4.b.a(view, i);
                if (button3 != null && (a = f4.b.a(view, (i = R$id.rv))) != null && (a2 = f4.b.a(view, (i = R$id.tvConfig))) != null) {
                    return new u((LinearLayoutCompat) view, button, button2, button3, a, a2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static u c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static u d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_ps_offer_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
