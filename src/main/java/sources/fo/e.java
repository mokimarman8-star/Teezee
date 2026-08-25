package fo;

import androidx.fragment.app.Fragment;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.view.ImmVideoItemView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e extends BaseItemProvider {
    private final Fragment e;
    private boolean f;
    private final String g;
    private final String h;
    private final boolean i;
    private final String j;
    private final String k;
    private final boolean l;
    private final int m;
    private final int n;

    public e(Fragment fragment, boolean z, String str, String str2, boolean z2, String str3, String str4, boolean z3) {
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(str3, "commentId");
        Intrinsics.h(str4, "pageFrom");
        this.e = fragment;
        this.f = z;
        this.g = str;
        this.h = str2;
        this.i = z2;
        this.j = str3;
        this.k = str4;
        this.l = z3;
        this.m = 1;
        this.n = R$layout.item_immersion_video;
    }

    public int l() {
        return this.m;
    }

    public int m() {
        return this.n;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(postSubjectItem, "item");
        ((ImmVideoItemView) baseViewHolder.getView(R$id.view_video_item)).setData(postSubjectItem, this.e, Integer.valueOf(baseViewHolder.getAdapterPosition()), this.f, this.g, this.h, this.i, this.j, this.k, this.l);
    }
}
