package fo;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.flow.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class u extends BaseItemProvider {
    private final ep.e e;

    public u(ep.e eVar) {
        Intrinsics.h(eVar, "roomsView");
        this.e = eVar;
    }

    public int l() {
        return MediaType.ROOM_LIST.ordinal();
    }

    public int m() {
        return R$layout.item_provider_room_post_nearby_rs_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(postSubjectItem, "item");
        FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(R$id.fl_container);
        if (frameLayout.getChildCount() == 0) {
            View view = this.e.getView();
            if (view.getParent() != null) {
                ViewParent parent = view.getParent();
                Intrinsics.f(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(view);
            }
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -2));
        }
        List roomList = postSubjectItem.getRoomList();
        if (roomList != null) {
            ep.e eVar = this.e;
            String string = Utils.a().getString(R.string.Nearby_Communities);
            Intrinsics.g(string, "getString(...)");
            eVar.updateTitle(string);
            this.e.setList(roomList);
            qi.h.a.z("room_home", MapsKt.m(new Pair[]{TuplesKt.a("module_name", "room_nearby_recommend")}));
            this.e.setReportName("room_home", "room_nearby_recommend");
        }
    }
}
