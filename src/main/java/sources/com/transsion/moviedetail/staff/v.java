package com.transsion.moviedetail.staff;

import android.graphics.Rect;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class v extends RecyclerView.r {
    private final s a;
    private final Function2 b;
    private RecyclerView c;
    private final String d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private SparseArray j;

    public v(s sVar, Function2 function2) {
        Intrinsics.h(sVar, "adapter");
        Intrinsics.h(function2, "callback");
        this.a = sVar;
        this.b = function2;
        this.d = "MovieStaffScroll";
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = new SparseArray();
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0114, code lost:
    
        r0 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0115, code lost:
    
        r8.j.put(r0, new kotlin.Pair(r8.a.getItem(r0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime())));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x012d, code lost:
    
        if (r0 == r10) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x012f, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h(int i, int i2) {
        if (i > i2) {
            return;
        }
        try {
            int itemCount = this.a.getItemCount();
            if (this.g == i && i2 == this.h && this.i == itemCount) {
                return;
            }
            this.i = itemCount;
            a.a.f(wf.a.a, this.d, "showChange firstPosition:" + i + "  lastPosition:" + i2, false, 4, (Object) null);
            if (this.g >= 0 && this.h >= 0) {
                ArrayList arrayList = new ArrayList();
                IntIterator a = androidx.core.util.k.a(this.j);
                while (a.hasNext()) {
                    int intValue = ((Number) a.next()).intValue();
                    if (i > intValue || intValue > i2) {
                        Function2 function2 = this.b;
                        Integer valueOf = Integer.valueOf(intValue);
                        Object obj = this.j.get(intValue);
                        Intrinsics.g(obj, "get(...)");
                        function2.invoke(valueOf, obj);
                        arrayList.add(Integer.valueOf(intValue));
                    } else if (intValue >= 0 && intValue < this.a.getItemCount() && !Intrinsics.c(((Pair) this.j.get(intValue)).getFirst(), this.a.getItem(intValue))) {
                        Function2 function22 = this.b;
                        Integer valueOf2 = Integer.valueOf(intValue);
                        Object obj2 = this.j.get(intValue);
                        Intrinsics.g(obj2, "get(...)");
                        function22.invoke(valueOf2, obj2);
                        this.j.put(intValue, new Pair(this.a.getItem(intValue), Long.valueOf(SystemClock.elapsedRealtime())));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.j.remove(((Number) it.next()).intValue());
                }
                if (i <= i2) {
                    int i3 = i;
                    while (true) {
                        Object item = this.a.getItem(i3);
                        if (this.j.get(i3) == null) {
                            this.j.put(i3, new Pair(item, Long.valueOf(SystemClock.elapsedRealtime())));
                        }
                        if (i3 == i2) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                this.g = i;
                this.h = i2;
            }
            this.g = i;
            this.h = i2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void d(AppBarLayout appBarLayout, int i) {
        Intrinsics.h(appBarLayout, "appBarLayout");
        a.a.f(wf.a.a, this.d, "appbarScroll  moveY:" + i, false, 4, (Object) null);
        try {
            this.f = i;
            int c = com.blankj.utilcode.util.y.c();
            int a = com.blankj.utilcode.util.d.a();
            RecyclerView recyclerView = this.c;
            int i2 = 0;
            int top = (c - a) - (recyclerView != null ? recyclerView.getTop() : 0);
            RecyclerView recyclerView2 = this.c;
            GridLayoutManager gridLayoutManager = (GridLayoutManager) (recyclerView2 != null ? recyclerView2.getLayoutManager() : null);
            if (gridLayoutManager == null) {
                return;
            }
            int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
            int i3 = -1;
            if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                int i4 = 0;
                int i5 = -1;
                while (true) {
                    View findViewByPosition = gridLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                    if (findViewByPosition != null) {
                        a.a aVar = wf.a.a;
                        a.a.f(aVar, this.d, "appbarScroll  *****  index:" + findFirstVisibleItemPosition + "  totalY:" + this.e + "    top:" + findViewByPosition.getTop(), false, 4, (Object) null);
                        if (findViewByPosition.getTop() < 0) {
                            return;
                        }
                        if (findViewByPosition.getBottom() < findViewByPosition.getHeight() * 0.7f) {
                            a.a.f(aVar, this.d, "index:" + findFirstVisibleItemPosition + "  标题栏档住了，不计入", false, 4, (Object) null);
                        } else if (gridLayoutManager.Y().e(findFirstVisibleItemPosition, gridLayoutManager.U()) == 0) {
                            if (i5 == -1) {
                                i5 = findFirstVisibleItemPosition;
                            }
                            int height = findViewByPosition.getHeight();
                            int i6 = i4 + height;
                            if (i6 < top) {
                                i4 = i6;
                            } else if (((top - i4) * 100) / height >= 70) {
                                int i7 = findFirstVisibleItemPosition + 1;
                                if (i7 <= findLastVisibleItemPosition) {
                                    while (true) {
                                        int i8 = findFirstVisibleItemPosition;
                                        findFirstVisibleItemPosition = i7;
                                        if (gridLayoutManager.Y().e(findFirstVisibleItemPosition, gridLayoutManager.U()) != 0) {
                                            if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                                                break;
                                            } else {
                                                i7 = findFirstVisibleItemPosition + 1;
                                            }
                                        } else {
                                            findFirstVisibleItemPosition = i8;
                                            break;
                                        }
                                    }
                                }
                                i2 = findFirstVisibleItemPosition;
                            } else {
                                i2 = RangesKt.e(findFirstVisibleItemPosition - 1, 0);
                            }
                        }
                    }
                    if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                        break;
                    } else {
                        findFirstVisibleItemPosition++;
                    }
                }
                i3 = i5;
            }
            a.a.f(wf.a.a, this.d, "firstVisiblePosition:" + i3 + "   realLastVisiblePosition:" + i2, false, 4, (Object) null);
            h(i3, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void e(int i, int i2) {
        while (i < i2) {
            try {
                Pair pair = (Pair) this.j.get(i);
                if (pair != null) {
                    this.b.invoke(Integer.valueOf(i), pair);
                    this.j.remove(i);
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public final void f() {
        try {
            IntIterator a = androidx.core.util.k.a(this.j);
            while (a.hasNext()) {
                int intValue = ((Number) a.next()).intValue();
                Function2 function2 = this.b;
                Integer valueOf = Integer.valueOf(intValue);
                Object obj = this.j.get(intValue);
                Intrinsics.g(obj, "get(...)");
                function2.invoke(valueOf, obj);
            }
            this.j.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void g() {
        try {
            int i = this.g;
            if (i >= 0) {
                int i2 = this.h;
                this.g = -1;
                this.h = -1;
                h(i, i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        this.e += i2;
        this.c = recyclerView;
        if (this.f >= 0) {
            return;
        }
        GridLayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager gridLayoutManager = layoutManager;
        int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        int i3 = findFirstVisibleItemPosition;
        while (true) {
            if (i3 >= findLastVisibleItemPosition) {
                break;
            }
            View findViewByPosition = gridLayoutManager.findViewByPosition(i3);
            if (findViewByPosition != null) {
                Rect rect = new Rect();
                findViewByPosition.getLocalVisibleRect(rect);
                a.a aVar = wf.a.a;
                a.a.f(aVar, this.d, "index:" + i3 + "  totalY:" + this.e + "    dy:" + i2 + " top:" + recyclerView.getTop(), false, 4, (Object) null);
                a.a.f(aVar, this.d, "index:" + i3 + "  firstView top:" + findViewByPosition.getTop() + "    bottom:" + findViewByPosition.getBottom(), false, 4, (Object) null);
                if (findViewByPosition.getBottom() < findViewByPosition.getHeight() * 0.7f) {
                    a.a.f(aVar, this.d, "index:" + i3 + "  标题栏档住了，不计入", false, 4, (Object) null);
                } else if ((rect.height() * 100) / findViewByPosition.getHeight() >= 70) {
                    findFirstVisibleItemPosition = i3;
                    break;
                }
            }
            i3++;
        }
        if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            int i4 = findLastVisibleItemPosition;
            while (true) {
                View findViewByPosition2 = gridLayoutManager.findViewByPosition(i4);
                if (findViewByPosition2 != null) {
                    Rect rect2 = new Rect();
                    findViewByPosition2.getLocalVisibleRect(rect2);
                    if ((rect2.height() * 100) / findViewByPosition2.getHeight() >= 70) {
                        findLastVisibleItemPosition = i4;
                        break;
                    }
                }
                if (i4 == findFirstVisibleItemPosition) {
                    break;
                } else {
                    i4--;
                }
            }
        }
        a.a.f(wf.a.a, this.d, "firstVisiblePosition:" + findFirstVisibleItemPosition + "   lastVisiblePosition:" + findLastVisibleItemPosition, false, 4, (Object) null);
        h(findFirstVisibleItemPosition, findLastVisibleItemPosition);
    }
}
