package com.transsion.search_pugc.fragment.result.provider;

import android.animation.ValueAnimator;
import android.text.SpannableStringBuilder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.R$plurals;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search_pugc.bean.SearchResultItem;
import com.transsion.search_pugc.constant.ResultCollectItemWrapper;
import com.transsion.search_pugc.constant.SearchType;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k extends BaseItemProvider implements t {
    private final /* synthetic */ t e;
    private final Lazy f;
    private final Lazy g;
    private final float h;

    public k(t tVar) {
        Intrinsics.h(tVar, "reportable");
        this.e = tVar;
        this.f = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.provider.h
            public final Object invoke() {
                int N;
                N = k.N();
                return Integer.valueOf(N);
            }
        });
        this.g = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.provider.i
            public final Object invoke() {
                int M;
                M = k.M();
                return Integer.valueOf(M);
            }
        });
        this.h = 0.95f;
    }

    private final void E(final View view, int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.search_pugc.fragment.result.provider.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                k.F(view, valueAnimator);
            }
        });
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(View view, ValueAnimator valueAnimator) {
        Intrinsics.h(valueAnimator, "animation");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.n nVar = (RecyclerView.n) layoutParams;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.f(animatedValue, "null cannot be cast to non-null type kotlin.Number");
        ((ViewGroup.MarginLayoutParams) nVar).width = ((Number) animatedValue).intValue();
        view.setLayoutParams(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(com.transsion.search_pugc.fragment.result.adapter.a aVar, k kVar, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        UGCVideo a = ((ResultCollectItemWrapper) aVar.getData().get(i)).a();
        if (a != null) {
            com.transsion.search_pugc.constant.a.g(a, true);
            kVar.c(a, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
    
        if (r2 != 3) goto L44;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean I(FooterStretchRecyclerView footerStretchRecyclerView, com.transsion.search_pugc.fragment.result.adapter.a aVar, Ref.FloatRef floatRef, Ref.BooleanRef booleanRef, k kVar, SearchResultItem searchResultItem, BaseViewHolder baseViewHolder, View view, MotionEvent motionEvent) {
        List videos;
        UGCVideo uGCVideo;
        LinearLayoutManager layoutManager = footerStretchRecyclerView.getLayoutManager();
        Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = layoutManager;
        int itemCount = aVar.getItemCount() - 1;
        View findViewByPosition = linearLayoutManager.findViewByPosition(itemCount);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!footerStretchRecyclerView.canScrollHorizontally(1) && findViewByPosition != null) {
                        float x = floatRef.element - motionEvent.getX();
                        int L = kVar.L() + ((int) ((kVar.K() - kVar.L()) * (1 - Math.exp((-x) / com.blankj.utilcode.util.i.e(20.0f)))));
                        if (L > kVar.K()) {
                            L = kVar.K();
                        }
                        booleanRef.element = L >= kVar.L() + ((int) (((float) (kVar.K() - kVar.L())) * kVar.h));
                        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
                        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                        RecyclerView.n nVar = (RecyclerView.n) layoutParams;
                        ((ViewGroup.MarginLayoutParams) nVar).width = L;
                        findViewByPosition.setLayoutParams(nVar);
                        boolean z = booleanRef.element;
                        StringBuilder sb = new StringBuilder();
                        sb.append("MOVE dist=");
                        sb.append(x);
                        sb.append(", width=");
                        sb.append(L);
                        sb.append(", atMax=");
                        sb.append(z);
                    }
                    return false;
                }
            }
            View findViewByPosition2 = linearLayoutManager.findViewByPosition(itemCount);
            boolean z2 = booleanRef.element;
            Integer valueOf = findViewByPosition2 != null ? Integer.valueOf(findViewByPosition2.getWidth()) : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("UP atMax=");
            sb2.append(z2);
            sb2.append(", 宽=");
            sb2.append(valueOf);
            if (findViewByPosition2 != null) {
                if (booleanRef.element) {
                    UGCCollection collection = searchResultItem.getCollection();
                    if (collection != null && (videos = collection.getVideos()) != null && (uGCVideo = (UGCVideo) CollectionsKt.k0(videos)) != null) {
                        com.transsion.search_pugc.constant.a.h(uGCVideo, false, 1, null);
                    }
                    kVar.d(searchResultItem, baseViewHolder.getBindingAdapterPosition());
                }
                kVar.E(findViewByPosition2, findViewByPosition2.getWidth(), kVar.L());
            }
            booleanRef.element = false;
        } else {
            float x2 = motionEvent.getX();
            floatRef.element = x2;
            booleanRef.element = false;
            Integer valueOf2 = findViewByPosition != null ? Integer.valueOf(findViewByPosition.getWidth()) : null;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("DOWN startX=");
            sb3.append(x2);
            sb3.append(" 初始宽=");
            sb3.append(valueOf2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(SearchResultItem searchResultItem, k kVar, BaseViewHolder baseViewHolder, View view) {
        List videos;
        UGCVideo uGCVideo;
        UGCCollection collection = searchResultItem.getCollection();
        if (collection != null && (videos = collection.getVideos()) != null && (uGCVideo = (UGCVideo) CollectionsKt.k0(videos)) != null) {
            com.transsion.search_pugc.constant.a.h(uGCVideo, false, 1, null);
        }
        kVar.d(searchResultItem, baseViewHolder.getBindingAdapterPosition());
    }

    private final int K() {
        return ((Number) this.g.getValue()).intValue();
    }

    private final int L() {
        return ((Number) this.f.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int M() {
        return com.blankj.utilcode.util.i.e(52.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int N() {
        return com.blankj.utilcode.util.i.e(26.0f);
    }

    private final void O(SearchResultItem searchResultItem) {
        List videos;
        UGCCollection collection = searchResultItem.getCollection();
        if (collection == null || (videos = collection.getVideos()) == null) {
            return;
        }
        int i = 0;
        for (Object obj : videos) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            e((UGCVideo) obj, i);
            i = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0177  */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.view.View, androidx.recyclerview.widget.RecyclerView, com.transsion.search_pugc.fragment.result.provider.FooterStretchRecyclerView] */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(final BaseViewHolder baseViewHolder, final SearchResultItem searchResultItem) {
        boolean z;
        List k;
        List U0;
        String watchNum;
        Integer videoNum;
        String title;
        List videos;
        UGCVideo uGCVideo;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchResultItem, "item");
        UGCCollection collection = searchResultItem.getCollection();
        List list = null;
        if (collection == null || (videos = collection.getVideos()) == null || (uGCVideo = (UGCVideo) CollectionsKt.k0(videos)) == null) {
            baseViewHolder.setImageResource(R$id.iv_ic, UGCVideoTypeKt.e((String) null));
        } else {
            UGCVideoTypeKt.i((ImageView) baseViewHolder.getView(R$id.iv_ic), uGCVideo, (Integer) null, 4, (Object) null);
        }
        int i = R$id.tv_collection_info;
        UGCCollection collection2 = searchResultItem.getCollection();
        baseViewHolder.setText(i, (collection2 == null || (title = collection2.getTitle()) == null) ? null : com.transsion.search_pugc.constant.a.d(title, k(), com.transsion.search_pugc.g.g.a(k()).e()));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        UGCCollection collection3 = searchResultItem.getCollection();
        if (collection3 != null && (videoNum = collection3.getVideoNum()) != null) {
            int intValue = videoNum.intValue();
            spannableStringBuilder.append((CharSequence) k().getResources().getQuantityString(R$plurals.videos_count_text, intValue, Integer.valueOf(intValue)));
        }
        spannableStringBuilder.append((CharSequence) "￼");
        spannableStringBuilder.setSpan(com.transsion.search_pugc.h.a(k()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        UGCCollection collection4 = searchResultItem.getCollection();
        String l = (collection4 == null || (watchNum = collection4.getWatchNum()) == null) ? null : com.transsion.search_pugc.constant.a.l(watchNum);
        spannableStringBuilder.append((CharSequence) (l + " " + k().getString(R$string.views)));
        ((TextView) baseViewHolder.getView(R$id.tv_info)).setText(spannableStringBuilder);
        baseViewHolder.getView(R$id.view_into).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.fragment.result.provider.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.J(SearchResultItem.this, this, baseViewHolder, view);
            }
        });
        final ?? r2 = (FooterStretchRecyclerView) baseViewHolder.getView(R$id.rv);
        r2.setLayoutManager(new LinearLayoutManager(r2.getContext(), 0, false));
        final com.transsion.search_pugc.fragment.result.adapter.a aVar = new com.transsion.search_pugc.fragment.result.adapter.a(true);
        UGCCollection collection5 = searchResultItem.getCollection();
        List videos2 = collection5 != null ? collection5.getVideos() : null;
        List list2 = videos2;
        if (list2 != null && !list2.isEmpty()) {
            if ((videos2 != null ? videos2.size() : 0) > 5) {
                z = true;
                if (z) {
                    videos2 = videos2 != null ? videos2.subList(0, 5) : null;
                }
                if (videos2 != null && (k = com.transsion.search_pugc.constant.a.k(videos2)) != null && (U0 = CollectionsKt.U0(k)) != null) {
                    if (z) {
                        U0.add(new ResultCollectItemWrapper(null, ResultCollectItemWrapper.Type.FOOTER, 1, null));
                    }
                    list = U0;
                }
                aVar.n1(list);
                aVar.w1(new r6.d() { // from class: com.transsion.search_pugc.fragment.result.provider.f
                    public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                        k.H(com.transsion.search_pugc.fragment.result.adapter.a.this, this, baseQuickAdapter, view, i2);
                    }
                });
                r2.setAdapter(aVar);
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                if (z) {
                    r2.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.search_pugc.fragment.result.provider.g
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            boolean I;
                            I = k.I(FooterStretchRecyclerView.this, aVar, floatRef, booleanRef, this, searchResultItem, baseViewHolder, view, motionEvent);
                            return I;
                        }
                    });
                }
                O(searchResultItem);
            }
        }
        z = false;
        if (z) {
        }
        if (videos2 != null) {
            if (z) {
            }
            list = U0;
        }
        aVar.n1(list);
        aVar.w1(new r6.d() { // from class: com.transsion.search_pugc.fragment.result.provider.f
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                k.H(com.transsion.search_pugc.fragment.result.adapter.a.this, this, baseQuickAdapter, view, i2);
            }
        });
        r2.setAdapter(aVar);
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        if (z) {
        }
        O(searchResultItem);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void a(UGCVideo uGCVideo, int i) {
        Intrinsics.h(uGCVideo, "ugcVideo");
        this.e.a(uGCVideo, i);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void c(UGCVideo uGCVideo, int i) {
        Intrinsics.h(uGCVideo, "ugcVideo");
        this.e.c(uGCVideo, i);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void d(SearchResultItem searchResultItem, int i) {
        Intrinsics.h(searchResultItem, "item");
        this.e.d(searchResultItem, i);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void e(UGCVideo uGCVideo, int i) {
        Intrinsics.h(uGCVideo, "ugcVideo");
        this.e.e(uGCVideo, i);
    }

    public int l() {
        return SearchType.UGC_COLLECTION.ordinal();
    }

    public int m() {
        return R$layout.provider_result_collection;
    }
}
