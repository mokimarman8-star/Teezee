package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.edcation.CourseManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingListItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ni.f;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\n\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010 J\u001f\u0010$\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0002H\u0014¢\u0006\u0004\b$\u0010%J-\u0010)\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00022\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H\u0014¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010.¨\u00061"}, d2 = {"Lcom/transsion/home/adapter/suboperate/adapter/r;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/RankingListItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "layoutResId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "tabId", "<init>", "(ILcom/transsion/home/bean/OperateItem;I)V", "Landroid/content/Context;", "context", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "Landroid/view/ViewGroup;", "parent", "position", "Landroid/view/View;", "H1", "(Landroid/content/Context;Lcom/transsion/moviedetailapi/bean/Subject;Landroid/view/ViewGroup;I)Landroid/view/View;", "Landroid/widget/ImageView;", "imageView", "seenStatus", BuildConfig.FLAVOR, "L1", "(Landroid/widget/ImageView;I)V", "pos", "G1", "(I)I", "rankListItem", "J1", "(Lcom/transsion/home/bean/RankingListItem;I)V", "K1", "holder", "item", "D1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/RankingListItem;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "payloads", "E1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/RankingListItem;Ljava/util/List;)V", "F", "Lcom/transsion/home/bean/OperateItem;", "G", "I", "H", "perWidth", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r extends BaseQuickAdapter {
    public static final int I = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final OperateItem operateItem;

    /* renamed from: G, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: H, reason: from kotlin metadata */
    private final int perWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(int i, OperateItem operateItem, int i2) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(operateItem, "operateItem");
        this.operateItem = operateItem;
        this.tabId = i2;
        this.perWidth = Math.min(y.e(), y.c()) - a0.a(54.0f);
    }

    public /* synthetic */ r(int i, OperateItem operateItem, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? R.layout.item_provider_ranklist : i, operateItem, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(Subject subject, r rVar, RankingListItem rankingListItem, int i, View view) {
        zk.h.f(subject, "opt_ranking_list");
        rVar.K1(rankingListItem, i);
    }

    private final int G1(int pos) {
        return pos != 0 ? pos != 1 ? pos != 2 ? R.mipmap.ic_rank_defalut : R.mipmap.ic_rank_03 : R.mipmap.ic_rank_02 : R.mipmap.ic_rank_01;
    }

    private final View H1(Context context, final Subject subject, ViewGroup parent, int position) {
        String str;
        String valueOf;
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_provider_ranklist_items, parent, false);
        ShapeableImageView findViewById = inflate.findViewById(R.id.sub_operation_rankinglist_cover);
        Intrinsics.g(findViewById, "findViewById(...)");
        ShapeableImageView shapeableImageView = findViewById;
        f.b m = ni.f.a.m(context);
        Cover cover = subject.getCover();
        if (cover == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        m.g(str).d(shapeableImageView);
        ((TextView) inflate.findViewById(R.id.sub_operation_rankinglist_title)).setText(subject.getTitle());
        ((TextView) inflate.findViewById(R.id.sub_operation_rankinglist_tag)).setText(a.b(context, subject));
        ImageView imageView = (ImageView) inflate.findViewById(R.id.sub_operation_rankinglist_add_icon);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.I1(subject, this, view);
                }
            });
        }
        Intrinsics.e(imageView);
        Integer seenStatus = subject.getSeenStatus();
        L1(imageView, seenStatus != null ? seenStatus.intValue() : 0);
        AppCompatImageView findViewById2 = inflate.findViewById(R.id.sub_operation_rankinglist_rank);
        if (findViewById2 != null) {
            findViewById2.setImageResource(G1(position));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.sub_operation_rankinglist_text);
        if (position > 2) {
            if (position < 9) {
                valueOf = "0" + (position + 1);
            } else {
                valueOf = String.valueOf(position + 1);
            }
            textView.setText(valueOf);
        } else {
            textView.setText(BuildConfig.FLAVOR);
        }
        Intrinsics.e(inflate);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(Subject subject, r rVar, View view) {
        CourseManager.u(CourseManager.a, subject, null, 2, null);
        fk.a.b(subject, SubTabFragment.INSTANCE.a(rVar.tabId), "opt_banner");
    }

    private final void J1(RankingListItem rankListItem, int position) {
        List<Subject> subjects = rankListItem.getSubjects();
        Subject subject = subjects != null ? subjects.get(position) : null;
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "browse_rank_list_item");
        hashMap.put("sequence", String.valueOf(position));
        hashMap.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
        hashMap.put("tabId", String.valueOf(this.tabId));
        String title = rankListItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        hashMap.put("groupTitle", title);
        sk.b.a(this.operateItem, hashMap);
        if (subject != null) {
            sk.b.d(subject, hashMap);
        }
        com.transsion.baselib.helper.a.a.e(SubTabFragment.INSTANCE.a(this.tabId), hashMap);
    }

    private final void K1(RankingListItem rankListItem, int position) {
        List<Subject> subjects = rankListItem.getSubjects();
        Subject subject = subjects != null ? subjects.get(position) : null;
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_rank_list_item");
        hashMap.put("sequence", String.valueOf(position));
        hashMap.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
        hashMap.put("tabId", String.valueOf(this.tabId));
        String title = rankListItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        hashMap.put("groupTitle", title);
        sk.b.a(this.operateItem, hashMap);
        if (subject != null) {
            sk.b.d(subject, hashMap);
        }
        com.transsion.baselib.helper.a.a.b(SubTabFragment.INSTANCE.a(this.tabId), hashMap);
    }

    private final void L1(ImageView imageView, int seenStatus) {
        imageView.setImageResource(seenStatus == 1 ? com.transsion.baseui.R.mipmap.ic_added : com.transsion.baseui.R.mipmap.ic_add);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, final RankingListItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.sub_operation_rankinglist_root);
        linearLayout.removeAllViews();
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = this.perWidth;
        linearLayout.setLayoutParams(layoutParams);
        List<Subject> subjects = item.getSubjects();
        if (subjects != null) {
            final int i = 0;
            for (Object obj : subjects) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                final Subject subject = (Subject) obj;
                View H1 = H1(getContext(), subject, linearLayout, i);
                linearLayout.addView(H1);
                H1.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        r.F1(subject, this, item, i, view);
                    }
                });
                J1(item, i);
                i = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public void G(BaseViewHolder holder, RankingListItem item, List<? extends Object> payloads) {
        Integer seenStatus;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.G(holder, item, payloads);
        int i = 0;
        Subject subject = (Subject) payloads.get(0);
        List<Subject> subjects = item.getSubjects();
        int n0 = subjects != null ? CollectionsKt.n0(subjects, subject) : -1;
        LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.sub_operation_rankinglist_root);
        if (n0 < 0 || n0 >= linearLayout.getChildCount()) {
            return;
        }
        ImageView imageView = (ImageView) linearLayout.getChildAt(n0).findViewById(R.id.sub_operation_rankinglist_add_icon);
        Intrinsics.e(imageView);
        if (subject != null && (seenStatus = subject.getSeenStatus()) != null) {
            i = seenStatus.intValue();
        }
        L1(imageView, i);
    }
}
