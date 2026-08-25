package com.transsion.home.adapter.hashtag;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.hashtag.model.HashTagItem;
import com.transsion.home.hashtag.model.HashTagItemType;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nk.d;
import t6.f;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0019B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/transsion/home/adapter/hashtag/a;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/home/hashtag/model/HashTagItem;", "Lt6/i;", "Lcom/transsion/home/adapter/hashtag/a$a;", "callbacks", "Lrk/b;", "listExposureHelper", "<init>", "(Lcom/transsion/home/adapter/hashtag/a$a;Lrk/b;)V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", BuildConfig.FLAVOR, "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "G", "Lcom/transsion/home/adapter/hashtag/a$a;", "H", "Lrk/b;", "a", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseProviderMultiAdapter<HashTagItem> implements i {
    public static final int I = 8;

    /* renamed from: G, reason: from kotlin metadata */
    private final InterfaceC0027a callbacks;

    /* renamed from: H, reason: from kotlin metadata */
    private final rk.b listExposureHelper;

    /* renamed from: com.transsion.home.adapter.hashtag.a$a, reason: collision with other inner class name */
    public interface InterfaceC0027a {
        void a(UGCVideo uGCVideo, int i);

        void b(UGCVideoHashTag uGCVideoHashTag);
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[HashTagItemType.values().length];
            try {
                iArr[HashTagItemType.TAGS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HashTagItemType.HASHTAG_CARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(InterfaceC0027a interfaceC0027a, rk.b bVar) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        Intrinsics.h(interfaceC0027a, "callbacks");
        this.callbacks = interfaceC0027a;
        this.listExposureHelper = bVar;
        F1(new d(interfaceC0027a));
        F1(new nk.b(interfaceC0027a));
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        rk.b bVar;
        Intrinsics.h(holder, "holder");
        super.B0(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        LinearLayoutManager layoutManager = getRecyclerView().getLayoutManager();
        if (!(layoutManager instanceof GridLayoutManager) || (bVar = this.listExposureHelper) == null) {
            return;
        }
        bVar.h(layoutManager, bindingAdapterPosition, true);
    }

    protected int N1(List<HashTagItem> data, int position) {
        Intrinsics.h(data, "data");
        int i = b.a[data.get(position).getType().ordinal()];
        if (i == 1) {
            return HashTagItemType.TAGS.ordinal();
        }
        if (i == 2) {
            return HashTagItemType.HASHTAG_CARD.ordinal();
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* bridge */ /* synthetic */ f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
