package com.transsion.search_pugc.fragment.result.provider;

import android.animation.ValueAnimator;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R;
import com.transsion.baseui.R$plurals;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search_pugc.bean.SearchResultItem;
import com.transsion.search_pugc.constant.ResultCollectItemWrapper;
import com.transsion.search_pugc.constant.SearchType;
import com.transsion.ugcvideodetail.api.bean.UGCVerticalRank;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class s extends BaseItemProvider implements t {
    private final /* synthetic */ t e;
    private final Lazy f;
    private final Lazy g;
    private final float h;

    public s(t tVar) {
        Intrinsics.h(tVar, "reportable");
        this.e = tVar;
        this.f = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.provider.m
            public final Object invoke() {
                int O;
                O = s.O();
                return Integer.valueOf(O);
            }
        });
        this.g = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.provider.n
            public final Object invoke() {
                int N;
                N = s.N();
                return Integer.valueOf(N);
            }
        });
        this.h = 0.95f;
    }

    private final void E(final View view, int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.search_pugc.fragment.result.provider.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                s.F(view, valueAnimator);
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
    public static final void H(SearchResultItem searchResultItem, s sVar, BaseViewHolder baseViewHolder, View view) {
        UGCVerticalRank verticalRank = searchResultItem.getVerticalRank();
        if (verticalRank != null) {
            com.transsion.search_pugc.constant.a.f(verticalRank, searchResultItem.getOps());
        }
        sVar.d(searchResultItem, baseViewHolder.getBindingAdapterPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(com.transsion.search_pugc.fragment.result.adapter.a aVar, s sVar, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        UGCVideo a = ((ResultCollectItemWrapper) aVar.getData().get(i)).a();
        if (a != null) {
            com.transsion.search_pugc.constant.a.h(a, false, 1, null);
            sVar.a(a, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
    
        if (r2 != 3) goto L42;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean J(FooterStretchRecyclerView footerStretchRecyclerView, com.transsion.search_pugc.fragment.result.adapter.a aVar, Ref.FloatRef floatRef, Ref.BooleanRef booleanRef, s sVar, SearchResultItem searchResultItem, BaseViewHolder baseViewHolder, View view, MotionEvent motionEvent) {
        Integer valueOf;
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
                        if (floatRef.element == 0.0f) {
                            floatRef.element = motionEvent.getX();
                            booleanRef.element = false;
                        }
                        float f = floatRef.element;
                        float x = motionEvent.getX();
                        StringBuilder sb = new StringBuilder();
                        sb.append("startX = ");
                        sb.append(f);
                        sb.append(", event.x= ");
                        sb.append(x);
                        float x2 = floatRef.element - motionEvent.getX();
                        int L = sVar.L() + ((int) ((sVar.K() - sVar.L()) * (1 - Math.exp((-x2) / com.blankj.utilcode.util.i.e(20.0f)))));
                        if (L > sVar.K()) {
                            L = sVar.K();
                        }
                        booleanRef.element = L >= sVar.L() + ((int) (((float) (sVar.K() - sVar.L())) * sVar.h));
                        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
                        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                        RecyclerView.n nVar = (RecyclerView.n) layoutParams;
                        ((ViewGroup.MarginLayoutParams) nVar).width = Math.max(L, sVar.L());
                        findViewByPosition.setLayoutParams(nVar);
                        boolean z = booleanRef.element;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("MOVE dist=");
                        sb2.append(x2);
                        sb2.append(", width=");
                        sb2.append(L);
                        sb2.append(", atMax=");
                        sb2.append(z);
                    }
                    return false;
                }
            }
            View findViewByPosition2 = linearLayoutManager.findViewByPosition(itemCount);
            boolean z2 = booleanRef.element;
            valueOf = findViewByPosition2 != null ? Integer.valueOf(findViewByPosition2.getWidth()) : null;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("UP atMax=");
            sb3.append(z2);
            sb3.append(", 宽=");
            sb3.append(valueOf);
            if (findViewByPosition2 != null) {
                if (booleanRef.element) {
                    UGCVerticalRank verticalRank = searchResultItem.getVerticalRank();
                    if (verticalRank != null) {
                        com.transsion.search_pugc.constant.a.f(verticalRank, searchResultItem.getOps());
                    }
                    sVar.d(searchResultItem, baseViewHolder.getBindingAdapterPosition());
                }
                sVar.E(findViewByPosition2, findViewByPosition2.getWidth(), sVar.L());
            }
            booleanRef.element = false;
        } else {
            float x3 = motionEvent.getX();
            floatRef.element = x3;
            booleanRef.element = false;
            valueOf = findViewByPosition != null ? Integer.valueOf(findViewByPosition.getWidth()) : null;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("--------------------------------DOWN startX=");
            sb4.append(x3);
            sb4.append(" 初始宽=");
            sb4.append(valueOf);
        }
        return false;
    }

    private final int K() {
        return ((Number) this.g.getValue()).intValue();
    }

    private final int L() {
        return ((Number) this.f.getValue()).intValue();
    }

    private final SpannableStringBuilder M(String str, String str2, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int o0 = StringsKt.o0(str, str2, 0, false, 6, (Object) null);
        if (o0 >= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), o0, str2.length() + o0, 33);
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int N() {
        return com.blankj.utilcode.util.i.e(52.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int O() {
        return com.blankj.utilcode.util.i.e(26.0f);
    }

    private final void P(SearchResultItem searchResultItem) {
        List videos;
        UGCVerticalRank verticalRank = searchResultItem.getVerticalRank();
        if (verticalRank == null || (videos = verticalRank.getVideos()) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:26:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013c  */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.view.View, androidx.recyclerview.widget.RecyclerView, com.transsion.search_pugc.fragment.result.provider.FooterStretchRecyclerView] */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(final BaseViewHolder baseViewHolder, final SearchResultItem searchResultItem) {
        boolean z;
        List k;
        List U0;
        Integer count;
        String title;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(searchResultItem, "item");
        int i = R$id.tv_collection_info;
        String string = k().getString(R$string.collection);
        UGCVerticalRank verticalRank = searchResultItem.getVerticalRank();
        List list = null;
        String str = string + " • " + (verticalRank != null ? verticalRank.getTitle() : null);
        UGCVerticalRank verticalRank2 = searchResultItem.getVerticalRank();
        baseViewHolder.setText(i, M(str, String.valueOf((verticalRank2 == null || (title = verticalRank2.getTitle()) == null) ? null : com.transsion.search_pugc.constant.a.d(title, k(), com.transsion.search_pugc.g.g.a(k()).e())), k().getColor(R.color.white)));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        UGCVerticalRank verticalRank3 = searchResultItem.getVerticalRank();
        if (verticalRank3 != null && (count = verticalRank3.getCount()) != null) {
            int intValue = count.intValue();
            spannableStringBuilder.append((CharSequence) k().getResources().getQuantityString(R$plurals.videos_count_text, intValue, Integer.valueOf(intValue)));
        }
        ((TextView) baseViewHolder.getView(R$id.tv_info)).setText(spannableStringBuilder);
        baseViewHolder.getView(R$id.view_into).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.fragment.result.provider.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s.H(SearchResultItem.this, this, baseViewHolder, view);
            }
        });
        final ?? r8 = (FooterStretchRecyclerView) baseViewHolder.getView(R$id.rv);
        r8.setLayoutManager(new LinearLayoutManager(r8.getContext(), 0, false));
        final com.transsion.search_pugc.fragment.result.adapter.a aVar = new com.transsion.search_pugc.fragment.result.adapter.a(false, 1, null);
        UGCVerticalRank verticalRank4 = searchResultItem.getVerticalRank();
        List videos = verticalRank4 != null ? verticalRank4.getVideos() : null;
        List list2 = videos;
        if (list2 != null && !list2.isEmpty()) {
            if ((videos != null ? videos.size() : 0) >= 5) {
                z = true;
                if (z) {
                    videos = videos != null ? videos.subList(0, 5) : null;
                }
                if (videos != null && (k = com.transsion.search_pugc.constant.a.k(videos)) != null && (U0 = CollectionsKt.U0(k)) != null) {
                    if (z) {
                        U0.add(new ResultCollectItemWrapper(null, ResultCollectItemWrapper.Type.FOOTER, 1, null));
                    }
                    list = U0;
                }
                aVar.n1(list);
                aVar.w1(new r6.d() { // from class: com.transsion.search_pugc.fragment.result.provider.p
                    public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                        s.I(com.transsion.search_pugc.fragment.result.adapter.a.this, this, baseQuickAdapter, view, i2);
                    }
                });
                r8.setAdapter(aVar);
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                if (z) {
                    r8.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.search_pugc.fragment.result.provider.q
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            boolean J;
                            J = s.J(FooterStretchRecyclerView.this, aVar, floatRef, booleanRef, this, searchResultItem, baseViewHolder, view, motionEvent);
                            return J;
                        }
                    });
                }
                P(searchResultItem);
            }
        }
        z = false;
        if (z) {
        }
        if (videos != null) {
            if (z) {
            }
            list = U0;
        }
        aVar.n1(list);
        aVar.w1(new r6.d() { // from class: com.transsion.search_pugc.fragment.result.provider.p
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                s.I(com.transsion.search_pugc.fragment.result.adapter.a.this, this, baseQuickAdapter, view, i2);
            }
        });
        r8.setAdapter(aVar);
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        if (z) {
        }
        P(searchResultItem);
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
        return SearchType.VERTICAL_RANK.ordinal();
    }

    public int m() {
        return R$layout.provider_result_collection;
    }
}
