package com.transsion.moviedetail.adapter;

import android.content.Context;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.flow.SubjectLayoutStyle;
import com.transsion.flow.bean.LayoutStyle;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ForYouSubjectProvider extends BaseItemProvider {
    private final Subject e;
    private final int f;
    private final int g = y.e();
    private final float h;
    private final float i;

    public ForYouSubjectProvider(Subject subject, int i) {
        this.e = subject;
        this.f = i;
        float a = (r2 - a0.a(((i - 1) * 8) + 24)) / i;
        this.h = a;
        this.i = (a * 149.0f) / 107.0f;
    }

    public int l() {
        return c.H;
    }

    public int m() {
        LayoutStyle style;
        Subject subject = this.e;
        if (subject != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.MUSIC.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                return R$layout.movie_detail_item_for_you_hor;
            }
        }
        Subject subject2 = this.e;
        String shape = (subject2 == null || (style = subject2.getStyle()) == null) ? null : style.getShape();
        return Intrinsics.c(shape, SubjectLayoutStyle.Horizontal.getValue()) ? R$layout.movie_detail_item_for_you_hor : Intrinsics.c(shape, SubjectLayoutStyle.Square.getValue()) ? R$layout.movie_detail_item_for_you_square : R$layout.movie_detail_item_for_you;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, Subject subject) {
        String str;
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(subject, "item");
        StaggeredGridLayoutManager.b layoutParams = ((RecyclerView.a0) baseViewHolder).itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.b) {
            layoutParams.c(false);
        }
        ShapeableImageView viewOrNull = baseViewHolder.getViewOrNull(R$id.iv_cover);
        if (viewOrNull != null) {
            if (subject.getBuiltIn()) {
                kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new ForYouSubjectProvider$convert$1$1(subject, viewOrNull, null), 3, (Object) null);
            } else {
                f.a aVar = ni.f.a;
                Context context = viewOrNull.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                Cover cover = subject.getCover();
                f.b c = m.g(cover != null ? cover.getUrl() : null).m((int) this.h).c((int) this.i);
                Cover cover2 = subject.getCover();
                if (cover2 == null || (str = cover2.getThumbnail()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                c.l(str).d(viewOrNull);
            }
        }
        AppCompatTextView viewOrNull2 = baseViewHolder.getViewOrNull(R$id.tv_title);
        if (viewOrNull2 != null) {
            viewOrNull2.setText(subject.getTitle());
        }
        TextView textView = (TextView) baseViewHolder.getView(R$id.tv_for_you_corner);
        textView.setText(subject.getCorner());
        String corner = subject.getCorner();
        textView.setVisibility(corner == null || corner.length() == 0 ? 8 : 0);
    }
}
