package com.transsion.home.view.filter.linear;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.b0;
import androidx.recyclerview.widget.DiffUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.HorizontalRecyclerview;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.FilterVal;
import com.transsion.home.bean.Item;
import com.transsion.home.viewmodel.MovieViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import r6.d;
import uf.c;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014JA\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00162\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\"\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u000e¢\u0006\u0004\b\"\u0010#JC\u0010'\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u000e2&\u0010&\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010$j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`%¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u000e¢\u0006\u0004\b)\u0010#J%\u0010*\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b*\u0010+R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010;\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/transsion/home/view/filter/linear/FilterView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "filterType", BuildConfig.FLAVOR, "Lcom/transsion/home/bean/FilterVal;", "filterList", BuildConfig.FLAVOR, "Lbl/a;", "f", "(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "selectedVal", "Lkotlin/Pair;", "g", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lkotlin/Pair;", "Lcom/tn/lib/view/HorizontalRecyclerview;", "recyclerview", "selectIndex", "size", BuildConfig.FLAVOR, "h", "(Lcom/tn/lib/view/HorizontalRecyclerview;II)V", "Lcom/transsion/home/bean/Item;", "datas", "setDatas", "(Ljava/util/List;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "selectItems", "updateSelectedFilterItems", "(Ljava/util/List;Ljava/util/HashMap;)V", "updateDatas", "createTabs", "(Ljava/util/List;I)V", BuildConfig.FLAVOR, "a", "Z", "getHasInit", "()Z", "setHasInit", "(Z)V", "hasInit", "Lcom/transsion/home/viewmodel/MovieViewModel;", "b", "Lcom/transsion/home/viewmodel/MovieViewModel;", "getMovieModel", "()Lcom/transsion/home/viewmodel/MovieViewModel;", "setMovieModel", "(Lcom/transsion/home/viewmodel/MovieViewModel;)V", "movieModel", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class FilterView extends LinearLayoutCompat {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private boolean hasInit;

    /* renamed from: b, reason: from kotlin metadata */
    private MovieViewModel movieModel;

    public static final class a extends DiffUtil.e {
        a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(bl.a aVar, bl.a aVar2) {
            Intrinsics.h(aVar, "oldItem");
            Intrinsics.h(aVar2, "newItem");
            return Intrinsics.c(aVar.c(), aVar2.c());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(bl.a aVar, bl.a aVar2) {
            Intrinsics.h(aVar, "oldItem");
            Intrinsics.h(aVar2, "newItem");
            return Intrinsics.c(aVar.b(), aVar2.b());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        setOrientation(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        Intrinsics.h(attributeSet, "attrs");
        setOrientation(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        Intrinsics.h(attributeSet, "attrs");
        setOrientation(1);
    }

    public static /* synthetic */ void createTabs$default(FilterView filterView, List list, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createTabs");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        filterView.createTabs(list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(FilterView filterView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MovieViewModel movieViewModel;
        b0 n;
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        int i2 = 0;
        for (Object obj : baseQuickAdapter.getData()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            if (obj instanceof bl.a) {
                ((bl.a) obj).e(i2 == i);
                if (i2 == i && (movieViewModel = filterView.movieModel) != null && (n = movieViewModel.n()) != null) {
                    n.q(obj);
                }
            }
            i2 = i3;
        }
        baseQuickAdapter.notifyDataSetChanged();
    }

    private final List f(String filterType, List filterList) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : filterList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            FilterVal filterVal = (FilterVal) obj;
            arrayList.add(new bl.a(filterVal.getId(), filterVal.getName(), filterType, i == 0, null, 16, null));
            i = i2;
        }
        return arrayList;
    }

    private final Pair g(String filterType, List filterList, String selectedVal) {
        String str;
        bl.a aVar;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (Object obj : filterList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            FilterVal filterVal = (FilterVal) obj;
            String id = filterVal.getId();
            Locale locale = Locale.ROOT;
            String lowerCase = id.toLowerCase(locale);
            Intrinsics.g(lowerCase, "toLowerCase(...)");
            if (selectedVal != null) {
                str = selectedVal.toLowerCase(locale);
                Intrinsics.g(str, "toLowerCase(...)");
            } else {
                str = null;
            }
            if (Intrinsics.c(lowerCase, str)) {
                aVar = new bl.a(filterVal.getId(), filterVal.getName(), filterType, true, null, 16, null);
            } else {
                i2 = i;
                aVar = new bl.a(filterVal.getId(), filterVal.getName(), filterType, false, null, 16, null);
            }
            arrayList.add(aVar);
            i = i2;
            i2 = i3;
        }
        return new Pair(Integer.valueOf(i), arrayList);
    }

    private final void h(HorizontalRecyclerview recyclerview, int selectIndex, int size) {
        if (selectIndex > 5 || selectIndex < size - 3) {
            recyclerview.scrollToPosition(selectIndex - 3);
        } else {
            recyclerview.scrollToPosition(selectIndex);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void createTabs(List<bl.a> datas, int selectIndex) {
        Intrinsics.h(datas, "datas");
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        HorizontalRecyclerview horizontalRecyclerview = new HorizontalRecyclerview(context);
        horizontalRecyclerview.setLayoutParams(new LinearLayoutCompat.a(-1, -2));
        horizontalRecyclerview.setLayoutManager(new NpaLinearLayoutManager(getContext(), 0, false));
        com.transsion.home.view.filter.linear.a aVar = new com.transsion.home.view.filter.linear.a(R.layout.adapter_filter_item, datas);
        aVar.w1(new d() { // from class: com.transsion.home.view.filter.linear.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FilterView.e(FilterView.this, baseQuickAdapter, view, i);
            }
        });
        aVar.R0(new a());
        horizontalRecyclerview.setAdapter(aVar);
        h(horizontalRecyclerview, selectIndex, datas.size());
        addView(horizontalRecyclerview);
    }

    public final boolean getHasInit() {
        return this.hasInit;
    }

    public final MovieViewModel getMovieModel() {
        return this.movieModel;
    }

    public final void setDatas(List<Item> datas) {
        Intrinsics.h(datas, "datas");
        for (Item item : datas) {
            createTabs$default(this, f(item.getFilterType(), item.getFilterValsV2()), 0, 2, null);
        }
        this.hasInit = true;
    }

    public final void setHasInit(boolean z) {
        this.hasInit = z;
    }

    public final void setMovieModel(MovieViewModel movieViewModel) {
        this.movieModel = movieViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateDatas(List<Item> datas) {
        Intrinsics.h(datas, "datas");
        if (datas.size() > getChildCount()) {
            int size = datas.size();
            for (int childCount = getChildCount(); childCount < size; childCount++) {
                createTabs$default(this, f(datas.get(childCount).getFilterType(), datas.get(childCount).getFilterValsV2()), 0, 2, null);
            }
            return;
        }
        int childCount2 = getChildCount();
        for (int i = 0; i < childCount2; i++) {
            HorizontalRecyclerview childAt = getChildAt(i);
            Intrinsics.f(childAt, "null cannot be cast to non-null type com.tn.lib.view.HorizontalRecyclerview");
            HorizontalRecyclerview horizontalRecyclerview = childAt;
            if (i < datas.size()) {
                c.k(horizontalRecyclerview);
                com.transsion.home.view.filter.linear.a adapter = horizontalRecyclerview.getAdapter();
                Intrinsics.f(adapter, "null cannot be cast to non-null type com.transsion.home.view.filter.linear.FilterItemAdapter");
                adapter.q1(f(datas.get(i).getFilterType(), datas.get(i).getFilterValsV2()));
                horizontalRecyclerview.scrollToPosition(0);
            } else {
                c.g(horizontalRecyclerview);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateSelectedFilterItems(List<Item> datas, HashMap<String, String> selectItems) {
        Intrinsics.h(datas, "datas");
        this.hasInit = true;
        if (datas.size() > getChildCount()) {
            int size = datas.size();
            for (int childCount = getChildCount(); childCount < size; childCount++) {
                Pair g = g(datas.get(childCount).getFilterType(), datas.get(childCount).getFilterValsV2(), selectItems != null ? selectItems.get(datas.get(childCount).getFilterType()) : null);
                createTabs((List) g.getSecond(), ((Number) g.getFirst()).intValue());
            }
            return;
        }
        int childCount2 = getChildCount();
        for (int i = 0; i < childCount2; i++) {
            HorizontalRecyclerview childAt = getChildAt(i);
            Intrinsics.f(childAt, "null cannot be cast to non-null type com.tn.lib.view.HorizontalRecyclerview");
            HorizontalRecyclerview horizontalRecyclerview = childAt;
            if (i < datas.size()) {
                c.k(horizontalRecyclerview);
                Pair g2 = g(datas.get(i).getFilterType(), datas.get(i).getFilterValsV2(), selectItems != null ? selectItems.get(datas.get(i).getFilterType()) : null);
                com.transsion.home.view.filter.linear.a adapter = horizontalRecyclerview.getAdapter();
                Intrinsics.f(adapter, "null cannot be cast to non-null type com.transsion.home.view.filter.linear.FilterItemAdapter");
                adapter.q1((List) g2.getSecond());
                h(horizontalRecyclerview, ((Number) g2.getFirst()).intValue(), datas.size());
            } else {
                c.g(horizontalRecyclerview);
            }
        }
    }
}
