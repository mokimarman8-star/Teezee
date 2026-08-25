package so;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g extends RecyclerView.a0 {
    private View a;
    private ImageView b;
    private TnTextView c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(View view) {
        super(view);
        Intrinsics.h(view, "itemView");
        this.a = view;
        View findViewById = view.findViewById(R$id.image);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.b = (ImageView) findViewById;
        TnTextView findViewById2 = view.findViewById(R$id.desc);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.c = findViewById2;
    }

    public final TnTextView f() {
        return this.c;
    }

    public final ImageView g() {
        return this.b;
    }

    public final View h() {
        return this.a;
    }
}
