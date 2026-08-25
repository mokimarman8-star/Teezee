package com.transsion.moviedetail.adapter;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.edcation.CourseManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\rJ-\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/transsion/moviedetail/adapter/ForYouEduAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", BuildConfig.FLAVOR, "data", "<init>", "(Ljava/util/List;)V", "holder", "item", BuildConfig.FLAVOR, "E1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "C1", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "payloads", "D1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;Ljava/util/List;)V", BuildConfig.FLAVOR, "F", "I", "width", BuildConfig.FLAVOR, "G", "coverW", "H", "coverH", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ForYouEduAdapter extends BaseQuickAdapter implements t6.i {

    /* renamed from: F, reason: from kotlin metadata */
    private final int width;

    /* renamed from: G, reason: from kotlin metadata */
    private final float coverW;

    /* renamed from: H, reason: from kotlin metadata */
    private final float coverH;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForYouEduAdapter(List<Subject> list) {
        super(R$layout.movie_detail_item_for_you_edu, list);
        Intrinsics.h(list, "data");
        this.width = y.e();
        float a = (r2 - a0.a(40.0f)) / 3.0f;
        this.coverW = a;
        this.coverH = (a * 149.0f) / 107.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r0.intValue() == 1) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void E1(BaseViewHolder holder, final Subject item) {
        AppCompatImageView viewOrNull = holder.getViewOrNull(R$id.ivAdd);
        if (viewOrNull != null) {
            Integer seenStatus = item.getSeenStatus();
            boolean z = seenStatus != null;
            viewOrNull.setSelected(z);
            viewOrNull.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.adapter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ForYouEduAdapter.F1(item, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(Subject subject, View view) {
        CourseManager.u(CourseManager.a, subject, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, Subject item) {
        String str;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ShapeableImageView viewOrNull = holder.getViewOrNull(R$id.iv_cover);
        if (viewOrNull != null) {
            if (item.getBuiltIn()) {
                kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new ForYouEduAdapter$convert$1$1(item, viewOrNull, null), 3, (Object) null);
            } else {
                f.a aVar = ni.f.a;
                Context context = viewOrNull.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                Cover cover = item.getCover();
                f.b c = m.g(cover != null ? cover.getUrl() : null).m((int) this.coverW).c((int) this.coverH);
                Cover cover2 = item.getCover();
                if (cover2 == null || (str = cover2.getThumbnail()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                c.l(str).d(viewOrNull);
            }
        }
        AppCompatTextView viewOrNull2 = holder.getViewOrNull(R$id.tv_title);
        if (viewOrNull2 != null) {
            viewOrNull2.setText(item.getTitle());
        }
        AppCompatTextView viewOrNull3 = holder.getViewOrNull(R$id.tvTag);
        if (viewOrNull3 != null) {
            Context context2 = viewOrNull3.getContext();
            Intrinsics.g(context2, "getContext(...)");
            viewOrNull3.setText(a.b(context2, item));
        }
        E1(holder, item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public void G(BaseViewHolder holder, Subject item, List<? extends Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        if (!payloads.isEmpty() && (payloads.get(payloads.size() - 1) instanceof Integer)) {
            E1(holder, item);
        }
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
