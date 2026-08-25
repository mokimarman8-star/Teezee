package km;

import android.view.View;
import android.widget.FrameLayout;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.transsion.flow.bean.MediaType;
import com.transsion.flow.p002enum.ProfileSubSource;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.room.api.RoomsViewType;
import ep.e;
import ep.f;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseItemProvider {
    private final String e;
    private final String f;
    private final Lazy g = LazyKt.b(new Function0() { // from class: km.c
        public final Object invoke() {
            e B;
            B = d.B(d.this);
            return B;
        }
    });

    public d(String str, String str2) {
        this.e = str;
        this.f = str2;
    }

    private final e A() {
        return (e) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e B(d dVar) {
        f fVar = (f) TheRouter.d(f.class, new Object[0]);
        if (fVar != null) {
            return fVar.c(dVar.k(), RoomsViewType.TYPE_SUBJECT_DETAIL);
        }
        return null;
    }

    public int l() {
        return MediaType.ROOM_LIST.ordinal();
    }

    public int m() {
        return R$layout.movie_detail_item_rooms;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        View view;
        e A;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(postSubjectItem, "item");
        FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(R$id.fl_root);
        String str = this.e;
        if (str != null) {
            String str2 = this.f;
            if (str2 == null) {
                str2 = ProfileSubSource.COMMENTS.getValue();
            }
            e A2 = A();
            if (A2 != null) {
                A2.setReportName(str, str2);
            }
        }
        List roomList = postSubjectItem.getRoomList();
        if (roomList != null && (A = A()) != null) {
            A.setList(roomList);
        }
        e A3 = A();
        if (A3 == null || (view = A3.getView()) == null || frameLayout.indexOfChild(view) != -1) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.addView(view);
    }
}
