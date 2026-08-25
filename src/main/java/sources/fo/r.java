package fo;

import androidx.recyclerview.widget.RecyclerView;
import com.transsion.postdetail.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r extends o {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(String str, String str2, RecyclerView.s sVar) {
        super(str, str2, sVar);
        Intrinsics.h(sVar, "pool");
    }

    public int m() {
        return R$layout.item_provider_room_post_detail;
    }
}
