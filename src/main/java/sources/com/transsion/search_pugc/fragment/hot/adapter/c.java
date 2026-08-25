package com.transsion.search_pugc.fragment.hot.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.fragment.hot.adapter.c;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002'(B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/transsion/search_pugc/fragment/hot/adapter/c;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/search_pugc/fragment/hot/adapter/a;", "Lt6/i;", "<init>", "()V", "Lkotlin/Function0;", BuildConfig.FLAVOR, "listener", "Y1", "(Lkotlin/jvm/functions/Function0;)V", BuildConfig.FLAVOR, "moreShow", "isExpand", BuildConfig.FLAVOR, "moreIndex", "Z1", "(ZZI)V", BuildConfig.FLAVOR, "data", "position", "N1", "(Ljava/util/List;I)I", "G", "Lkotlin/jvm/functions/Function0;", "H", "Z", "showMode", "I", "expandMode", "J", "showMoreIndex", "Lcom/transsion/search_pugc/g;", "K", "Lkotlin/Lazy;", "W1", "()Lcom/transsion/search_pugc/g;", "searchReporter", "L", "a", "b", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseProviderMultiAdapter<a> implements i {
    public static final int M = 1;
    public static final int N = 2;

    /* renamed from: G, reason: from kotlin metadata */
    private Function0<Unit> listener;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean showMode;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean expandMode;

    /* renamed from: J, reason: from kotlin metadata */
    private int showMoreIndex;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy searchReporter;

    public final class b extends BaseItemProvider {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void A(c cVar, int i, View view) {
            if (cVar.showMode && i == cVar.showMoreIndex) {
                Function0 function0 = cVar.listener;
                if (function0 != null) {
                    function0.invoke();
                }
                cVar.W1().n(!cVar.expandMode);
            }
        }

        public int l() {
            return 1;
        }

        public int m() {
            return R$layout.item_search_history_word;
        }

        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public void b(BaseViewHolder baseViewHolder, a aVar) {
            Intrinsics.h(baseViewHolder, "helper");
            Intrinsics.h(aVar, "item");
            final int g0 = c.this.g0(aVar);
            baseViewHolder.setText(R$id.search_history_text, aVar.a());
            boolean z = c.this.showMode && g0 == c.this.showMoreIndex;
            View view = baseViewHolder.getView(R$id.search_hot_history_more_image);
            final c cVar = c.this;
            ImageView imageView = (ImageView) view;
            imageView.setVisibility(z ? 0 : 8);
            imageView.setImageResource(cVar.expandMode ? R$drawable.ic_hide : R$drawable.ic_more);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.fragment.hot.adapter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.b.A(c.this, g0, view2);
                }
            });
        }
    }

    public c() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        F1(new b());
        this.showMoreIndex = -1;
        this.searchReporter = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.hot.adapter.b
            public final Object invoke() {
                com.transsion.search_pugc.g X1;
                X1 = c.X1(c.this);
                return X1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.search_pugc.g W1() {
        return (com.transsion.search_pugc.g) this.searchReporter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.search_pugc.g X1(c cVar) {
        return com.transsion.search_pugc.g.g.a(cVar.getContext());
    }

    public static /* synthetic */ void a2(c cVar, boolean z, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        cVar.Z1(z, z2, i);
    }

    protected int N1(List<a> data, int position) {
        Intrinsics.h(data, "data");
        return data.get(position).b();
    }

    public final void Y1(Function0<Unit> listener) {
        Intrinsics.h(listener, "listener");
        this.listener = listener;
    }

    @SuppressLint({"Range"})
    public final void Z1(boolean moreShow, boolean isExpand, int moreIndex) {
        StringBuilder sb = new StringBuilder();
        sb.append("setShowMoreMode, moreShow:");
        sb.append(moreShow);
        sb.append(", isExpand:");
        sb.append(isExpand);
        sb.append(",  moreIndex:");
        sb.append(moreIndex);
        this.showMode = moreShow;
        this.expandMode = isExpand;
        this.showMoreIndex = moreIndex;
        if (getItemCount() > 0 && moreIndex >= 0) {
            int itemCount = moreShow ? moreIndex + 1 : getItemCount();
            for (int i = 0; i < itemCount; i++) {
                if (i < getItemCount()) {
                    W1().o(((a) getItem(i)).a(), i);
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
