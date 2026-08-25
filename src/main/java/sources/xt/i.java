package xt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i implements f4.a {
    private final RelativeLayout a;
    public final RecyclerView b;
    public final LinearLayout c;

    private i(RelativeLayout relativeLayout, RecyclerView recyclerView, LinearLayout linearLayout) {
        this.a = relativeLayout;
        this.b = recyclerView;
        this.c = linearLayout;
    }

    public static i a(View view) {
        int i = R$id.transfer_sent_file_list;
        RecyclerView a = f4.b.a(view, i);
        if (a != null) {
            i = R$id.transfer_sent_file_list_empty;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null) {
                return new i((RelativeLayout) view, a, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_transfer_sent, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
