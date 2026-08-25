package com.transsion.home.view.filter.expand;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.b0;
import bl.a;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.FilterVal;
import com.transsion.home.bean.Item;
import com.transsion.home.view.filter.expand.FilterExpandView;
import com.transsion.home.viewmodel.MovieViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import uf.c;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ%\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJE\u0010\u001f\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00152(\b\u0002\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\t¢\u0006\u0004\b\"\u0010#R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R0\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0010\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/transsion/home/view/filter/expand/FilterExpandView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "index", BuildConfig.FLAVOR, "Lbl/a;", "data", BuildConfig.FLAVOR, "e", "(ILjava/util/List;)V", BuildConfig.FLAVOR, "filterType", BuildConfig.FLAVOR, "Lcom/transsion/home/bean/FilterVal;", "filterList", "selectedVal", "g", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "Lcom/transsion/home/bean/Item;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "selectItems", "updateList", "(Ljava/util/List;Ljava/util/HashMap;)V", "target", "expandFilter", "(I)V", BuildConfig.FLAVOR, "a", "Z", "getHasInit", "()Z", "setHasInit", "(Z)V", "hasInit", "Lcom/transsion/home/viewmodel/MovieViewModel;", "b", "Lcom/transsion/home/viewmodel/MovieViewModel;", "getMovieModel", "()Lcom/transsion/home/viewmodel/MovieViewModel;", "setMovieModel", "(Lcom/transsion/home/viewmodel/MovieViewModel;)V", "movieModel", "Lkotlin/Function1;", "c", "Lkotlin/jvm/functions/Function1;", "getReportEvent", "()Lkotlin/jvm/functions/Function1;", "setReportEvent", "(Lkotlin/jvm/functions/Function1;)V", "reportEvent", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class FilterExpandView extends LinearLayoutCompat {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private boolean hasInit;

    /* renamed from: b, reason: from kotlin metadata */
    private MovieViewModel movieModel;

    /* renamed from: c, reason: from kotlin metadata */
    private Function1 reportEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterExpandView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        setOrientation(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        Intrinsics.h(attributeSet, "attrs");
        setOrientation(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterExpandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        Intrinsics.h(attributeSet, "attrs");
        setOrientation(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e(int index, List data) {
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        final TabExpandView tabExpandView = new TabExpandView(context);
        tabExpandView.enableExpand(true);
        tabExpandView.updateData(data);
        tabExpandView.setInParentIndex(index);
        tabExpandView.setOnItemClickListener(new Function1() { // from class: al.a
            public final Object invoke(Object obj) {
                Unit f;
                f = FilterExpandView.f(FilterExpandView.this, tabExpandView, (bl.a) obj);
                return f;
            }
        });
        addView(tabExpandView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(FilterExpandView filterExpandView, TabExpandView tabExpandView, a aVar) {
        b0 n;
        Intrinsics.h(aVar, "item");
        filterExpandView.expandFilter(tabExpandView.getInParentIndex() + 1);
        MovieViewModel movieViewModel = filterExpandView.movieModel;
        if (movieViewModel != null && (n = movieViewModel.n()) != null) {
            n.q(aVar);
        }
        Function1 function1 = filterExpandView.reportEvent;
        if (function1 != null) {
            function1.invoke(aVar);
        }
        return Unit.a;
    }

    private final List g(String filterType, List filterList, String selectedVal) {
        ArrayList arrayList = new ArrayList();
        if (selectedVal == null) {
            selectedVal = ((FilterVal) CollectionsKt.i0(filterList)).getName();
        }
        Iterator it = filterList.iterator();
        while (it.hasNext()) {
            FilterVal filterVal = (FilterVal) it.next();
            arrayList.add(new a(filterVal.getId(), filterVal.getName(), filterType, StringsKt.H(selectedVal, filterVal.getName(), true), null, 16, null));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateList$default(FilterExpandView filterExpandView, List list, HashMap hashMap, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateList");
        }
        if ((i & 2) != 0) {
            hashMap = null;
        }
        filterExpandView.updateList(list, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void expandFilter(int target) {
        TabExpandView tabExpandView;
        int i = 0;
        for (Object obj : ViewGroupKt.getChildren(this)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            View view = (View) obj;
            if (i != target) {
                tabExpandView = view instanceof TabExpandView ? (TabExpandView) view : null;
                if (tabExpandView != null) {
                    tabExpandView.collapse();
                }
            } else {
                tabExpandView = view instanceof TabExpandView ? (TabExpandView) view : null;
                if (tabExpandView != null) {
                    tabExpandView.expand();
                }
            }
            i = i2;
        }
    }

    public final boolean getHasInit() {
        return this.hasInit;
    }

    public final MovieViewModel getMovieModel() {
        return this.movieModel;
    }

    public final Function1<a, Unit> getReportEvent() {
        return this.reportEvent;
    }

    public final void setHasInit(boolean z) {
        this.hasInit = z;
    }

    public final void setMovieModel(MovieViewModel movieViewModel) {
        this.movieModel = movieViewModel;
    }

    public final void setReportEvent(Function1<? super a, Unit> function1) {
        this.reportEvent = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateList(List<Item> data, HashMap<String, String> selectItems) {
        Intrinsics.h(data, "data");
        this.hasInit = true;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            Intrinsics.f(childAt, "null cannot be cast to non-null type com.transsion.home.view.filter.expand.TabExpandView");
            TabExpandView tabExpandView = (TabExpandView) childAt;
            if (i < data.size()) {
                c.k(tabExpandView);
                tabExpandView.setInParentIndex(i);
                tabExpandView.updateData(g(data.get(i).getFilterType(), data.get(i).getFilterValsV2(), selectItems != null ? selectItems.get(data.get(i).getFilterType()) : null));
            } else {
                c.g(tabExpandView);
            }
            i++;
        }
        if (data.size() > getChildCount()) {
            int size = data.size();
            for (int childCount2 = getChildCount(); childCount2 < size; childCount2++) {
                e(childCount2, g(data.get(childCount2).getFilterType(), data.get(childCount2).getFilterValsV2(), selectItems != null ? selectItems.get(data.get(childCount2).getFilterType()) : null));
            }
        }
    }
}
