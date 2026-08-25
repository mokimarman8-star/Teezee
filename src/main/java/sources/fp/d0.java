package fp;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.tabs.TabLayout;
import com.transsion.room.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d0 implements f4.a {
    private final LinearLayoutCompat a;
    public final View b;
    public final LinearLayoutCompat c;
    public final TabLayout d;

    private d0(LinearLayoutCompat linearLayoutCompat, View view, LinearLayoutCompat linearLayoutCompat2, TabLayout tabLayout) {
        this.a = linearLayoutCompat;
        this.b = view;
        this.c = linearLayoutCompat2;
        this.d = tabLayout;
    }

    public static d0 a(View view) {
        int i = R$id.divider;
        View a = f4.b.a(view, i);
        if (a != null) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
            int i2 = R$id.tab_room;
            TabLayout a2 = f4.b.a(view, i2);
            if (a2 != null) {
                return new d0(linearLayoutCompat, a, linearLayoutCompat, a2);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
