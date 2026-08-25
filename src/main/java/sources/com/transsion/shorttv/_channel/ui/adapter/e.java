package com.transsion.shorttv._channel.ui.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.bean.Subject;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import t6.f;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\"B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/transsion/shorttv/_channel/ui/adapter/e;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/shorttv/bean/Subject;", "Lt6/i;", BuildConfig.FLAVOR, "datas", "Lbr/b;", "exposureHelper", "<init>", "(Ljava/util/List;Lbr/b;)V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", BuildConfig.FLAVOR, "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", BuildConfig.FLAVOR, "showRank", "T1", "(Z)V", "G", "Lbr/b;", "Lvq/d;", "H", "Lkotlin/Lazy;", "R1", "()Lvq/d;", "playListItemProvider", "I", "a", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e extends BaseProviderMultiAdapter<Subject> implements i {
    public static final int J = 1;
    public static final int K = 2;

    /* renamed from: G, reason: from kotlin metadata */
    private final br.b exposureHelper;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy playListItemProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(List<Subject> list, br.b bVar) {
        super(list);
        Intrinsics.h(list, "datas");
        this.exposureHelper = bVar;
        this.playListItemProvider = LazyKt.b(new Function0() { // from class: com.transsion.shorttv._channel.ui.adapter.d
            public final Object invoke() {
                vq.d S1;
                S1 = e.S1();
                return S1;
            }
        });
        F1(R1());
        F1(new vq.c());
    }

    private final vq.d R1() {
        return (vq.d) this.playListItemProvider.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vq.d S1() {
        return new vq.d();
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.B0(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        br.b bVar = this.exposureHelper;
        if (bVar != null) {
            LinearLayoutManager layoutManager = getRecyclerView().getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            br.b.h(bVar, layoutManager, bindingAdapterPosition, true, false, 8, null);
        }
    }

    protected int N1(List<? extends Subject> data, int position) {
        Intrinsics.h(data, "data");
        return data.get(position).getNonAdDelegate() != null ? 2 : 1;
    }

    public final void T1(boolean showRank) {
        R1().z(showRank);
    }

    public /* bridge */ /* synthetic */ f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
