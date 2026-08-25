package com.transsion.search.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\fJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0019\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0018\u00010\u0014R\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R(\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060&0\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/transsion/search/widget/LinesFlexBoxLayoutManager;", "Lcom/google/android/flexbox/FlexboxLayoutManager;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BuildConfig.FLAVOR, "maxLine", BuildConfig.FLAVOR, "q0", "(I)V", "n0", "()I", "p0", "()V", "o0", BuildConfig.FLAVOR, "Lcom/google/android/flexbox/b;", "getFlexLinesInternal", "()Ljava/util/List;", "Landroidx/recyclerview/widget/RecyclerView$t;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$x;", "state", "onLayoutChildren", "(Landroidx/recyclerview/widget/RecyclerView$t;Landroidx/recyclerview/widget/RecyclerView$x;)V", "Landroid/view/View;", "child", "attachView", "(Landroid/view/View;)V", "B", "I", "mMaxLines", "Lkotlin/Function0;", "C", "Lkotlin/jvm/functions/Function0;", "mOverMaxLineListener", "Lkotlin/Pair;", "D", "Ljava/util/List;", "actualLineCount", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LinesFlexBoxLayoutManager extends FlexboxLayoutManager {

    /* renamed from: B, reason: from kotlin metadata */
    private int mMaxLines;

    /* renamed from: C, reason: from kotlin metadata */
    private Function0 mOverMaxLineListener;

    /* renamed from: D, reason: from kotlin metadata */
    private List actualLineCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinesFlexBoxLayoutManager(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.actualLineCount = new ArrayList();
    }

    public void attachView(View child) {
        Intrinsics.h(child, "child");
        if (child.getParent() != null) {
            ViewParent parent = child.getParent();
            Intrinsics.f(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(child);
        }
        super/*androidx.recyclerview.widget.RecyclerView.m*/.attachView(child);
    }

    public List getFlexLinesInternal() {
        List<com.google.android.flexbox.b> flexLinesInternal = super.getFlexLinesInternal();
        if (flexLinesInternal.size() > this.actualLineCount.size()) {
            this.actualLineCount.clear();
            Intrinsics.e(flexLinesInternal);
            int i = 0;
            for (com.google.android.flexbox.b bVar : flexLinesInternal) {
                this.actualLineCount.add(new Pair(Integer.valueOf(i + 1), Integer.valueOf(bVar.b() + i)));
                i += bVar.b();
            }
        }
        if (this.mMaxLines == 0) {
            Intrinsics.e(flexLinesInternal);
            return flexLinesInternal;
        }
        int size = flexLinesInternal.size();
        int i2 = this.mMaxLines;
        if (size > i2) {
            flexLinesInternal.subList(i2, flexLinesInternal.size()).clear();
            Function0 function0 = this.mOverMaxLineListener;
            if (function0 != null) {
                function0.invoke();
            }
        }
        Intrinsics.e(flexLinesInternal);
        return flexLinesInternal;
    }

    public final int n0() {
        return (this.actualLineCount.size() == 0 ? super.getFlexLinesInternal() : this.actualLineCount).size();
    }

    public final int o0() {
        int i = 0;
        int i2 = 0;
        for (Object obj : this.actualLineCount) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            Pair pair = (Pair) obj;
            if (i2 < this.mMaxLines) {
                i = ((Number) pair.getSecond()).intValue();
            }
            i2 = i3;
        }
        return i;
    }

    public void onLayoutChildren(RecyclerView.t recycler, RecyclerView.x state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void p0() {
        this.actualLineCount.clear();
    }

    public final void q0(int maxLine) {
        this.mMaxLines = maxLine;
        requestLayout();
    }
}
