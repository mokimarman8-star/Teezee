package nk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.FlowLayout;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.home.adapter.hashtag.a;
import com.transsion.home.hashtag.model.HashTagItem;
import com.transsion.home.hashtag.model.HashTagItemType;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseItemProvider {
    private final a.InterfaceC0027a e;

    public d(a.InterfaceC0027a interfaceC0027a) {
        Intrinsics.h(interfaceC0027a, "callbacks");
        this.e = interfaceC0027a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(d dVar, UGCVideoHashTag uGCVideoHashTag, View view) {
        dVar.e.b(uGCVideoHashTag);
    }

    public int l() {
        return HashTagItemType.TAGS.ordinal();
    }

    public int m() {
        return R.layout.item_hashtag_tags;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [android.widget.TextView, com.transsion.baseui.widget.GradientTextView] */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, HashTagItem hashTagItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(hashTagItem, "item");
        FlowLayout view = baseViewHolder.getView(R.id.hashtag_tags_flow);
        view.removeAllViews();
        LayoutInflater from = LayoutInflater.from(k());
        List<UGCVideoHashTag> tags = hashTagItem.getTags();
        if (tags == null) {
            tags = CollectionsKt.l();
        }
        for (final UGCVideoHashTag uGCVideoHashTag : tags) {
            boolean z = false;
            View inflate = from.inflate(R.layout.item_hashtag_chip, (ViewGroup) view, false);
            ?? r6 = (GradientTextView) inflate.findViewById(R.id.hashtag_chip_text);
            String title = uGCVideoHashTag.getTitle();
            if (title == null) {
                title = uGCVideoHashTag.getTag();
            }
            r6.setText(title);
            List<UGCVideoHashTag> selectedTags = hashTagItem.getSelectedTags();
            if (selectedTags != null) {
                List<UGCVideoHashTag> list = selectedTags;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.c(((UGCVideoHashTag) it.next()).getTag(), uGCVideoHashTag.getTag())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            inflate.setSelected(z);
            if (z) {
                inflate.setBackgroundResource(R$drawable.bg_hashtag_item_seleted);
                r6.setGradientColors(androidx.core.content.b.getColor(((RecyclerView.a0) baseViewHolder).itemView.getContext(), com.tn.lib.widget.R.color.brand_new_gradient_start), androidx.core.content.b.getColor(((RecyclerView.a0) baseViewHolder).itemView.getContext(), com.tn.lib.widget.R.color.brand_new_gradient_center), androidx.core.content.b.getColor(((RecyclerView.a0) baseViewHolder).itemView.getContext(), com.tn.lib.widget.R.color.brand_new_gradient_end));
            } else {
                inflate.setBackgroundResource(R$drawable.bg_hashtag_item_unseleted);
                r6.setGradientColors(androidx.core.content.b.getColor(((RecyclerView.a0) baseViewHolder).itemView.getContext(), com.tn.lib.widget.R.color.white_80), androidx.core.content.b.getColor(((RecyclerView.a0) baseViewHolder).itemView.getContext(), com.tn.lib.widget.R.color.white_80), androidx.core.content.b.getColor(((RecyclerView.a0) baseViewHolder).itemView.getContext(), com.tn.lib.widget.R.color.white_80));
            }
            inflate.setOnClickListener(new View.OnClickListener() { // from class: nk.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    d.A(d.this, uGCVideoHashTag, view2);
                }
            });
            view.addView(inflate);
        }
    }
}
