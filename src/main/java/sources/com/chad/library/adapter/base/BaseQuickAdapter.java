package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m6.b;
import o6.c;
import o6.d;
import r6.a;
import r6.d;
import r6.e;
import t6.f;
import t6.g;
import t6.i;
import t6.l;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class BaseQuickAdapter extends RecyclerView.Adapter {
    public static final a A = new a((DefaultConstructorMarker) null);
    public static final int B = 268435729;
    public static final int C = 268436002;
    public static final int D = 268436275;
    public static final int E = 268436821;
    private final int a;
    private List<Object> b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private b j;
    private c k;
    private LinearLayout l;
    private LinearLayout m;
    private FrameLayout n;
    private int o;
    private a p;
    private d q;
    private e r;
    private r6.b s;
    private r6.c t;
    private g u;
    private t6.a v;
    private f w;
    private RecyclerView x;
    private final LinkedHashSet<Integer> y;
    private final LinkedHashSet<Integer> z;

    public BaseQuickAdapter(int i, List list) {
        this.a = i;
        this.b = list == null ? new ArrayList() : list;
        this.e = true;
        this.i = true;
        this.o = -1;
        D();
        this.y = new LinkedHashSet<>();
        this.z = new LinkedHashSet<>();
    }

    public /* synthetic */ BaseQuickAdapter(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(BaseViewHolder baseViewHolder, BaseQuickAdapter baseQuickAdapter, View view) {
        Intrinsics.h(baseViewHolder, "$viewHolder");
        Intrinsics.h(baseQuickAdapter, "this$0");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int a0 = bindingAdapterPosition - baseQuickAdapter.a0();
        Intrinsics.g(view, "v");
        baseQuickAdapter.r1(view, a0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(BaseViewHolder baseViewHolder, BaseQuickAdapter baseQuickAdapter, View view) {
        Intrinsics.h(baseViewHolder, "$viewHolder");
        Intrinsics.h(baseQuickAdapter, "this$0");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int a0 = bindingAdapterPosition - baseQuickAdapter.a0();
        Intrinsics.g(view, "v");
        baseQuickAdapter.v1(view, a0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C(BaseViewHolder baseViewHolder, BaseQuickAdapter baseQuickAdapter, View view) {
        Intrinsics.h(baseViewHolder, "$viewHolder");
        Intrinsics.h(baseQuickAdapter, "this$0");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int a0 = bindingAdapterPosition - baseQuickAdapter.a0();
        Intrinsics.g(view, "v");
        return baseQuickAdapter.x1(view, a0);
    }

    private final void D() {
        if (this instanceof i) {
            this.w = ((i) this).b(this);
        }
        if (this instanceof l) {
            this.u = ((l) this).f(this);
        }
    }

    private final BaseViewHolder H(Class cls, View view) {
        try {
            if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
                Constructor declaredConstructor = cls.getDeclaredConstructor(View.class);
                Intrinsics.g(declaredConstructor, "z.getDeclaredConstructor(View::class.java)");
                declaredConstructor.setAccessible(true);
                Object newInstance = declaredConstructor.newInstance(view);
                Intrinsics.f(newInstance, "null cannot be cast to non-null type VH of com.chad.library.adapter.base.BaseQuickAdapter");
                return (BaseViewHolder) newInstance;
            }
            Constructor declaredConstructor2 = cls.getDeclaredConstructor(getClass(), View.class);
            Intrinsics.g(declaredConstructor2, "z.getDeclaredConstructor…aClass, View::class.java)");
            declaredConstructor2.setAccessible(true);
            Object newInstance2 = declaredConstructor2.newInstance(this, view);
            Intrinsics.f(newInstance2, "null cannot be cast to non-null type VH of com.chad.library.adapter.base.BaseQuickAdapter");
            return (BaseViewHolder) newInstance2;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ void W0(BaseQuickAdapter baseQuickAdapter, List list, Runnable runnable, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDiffNewData");
        }
        if ((i & 2) != 0) {
            runnable = null;
        }
        baseQuickAdapter.V0(list, runnable);
    }

    public static /* synthetic */ int c1(BaseQuickAdapter baseQuickAdapter, View view, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFooterView");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 1;
        }
        return baseQuickAdapter.b1(view, i, i2);
    }

    private final Class e0(Class cls) {
        try {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                return null;
            }
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            Intrinsics.g(actualTypeArguments, "types");
            for (Type type : actualTypeArguments) {
                if (type instanceof Class) {
                    if (BaseViewHolder.class.isAssignableFrom((Class) type)) {
                        return (Class) type;
                    }
                } else if (type instanceof ParameterizedType) {
                    Type rawType = ((ParameterizedType) type).getRawType();
                    if ((rawType instanceof Class) && BaseViewHolder.class.isAssignableFrom((Class) rawType)) {
                        return (Class) rawType;
                    }
                } else {
                    continue;
                }
            }
            return null;
        } catch (TypeNotPresentException e) {
            e.printStackTrace();
            return null;
        } catch (GenericSignatureFormatError e3) {
            e3.printStackTrace();
            return null;
        } catch (MalformedParameterizedTypeException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static final /* synthetic */ a j(BaseQuickAdapter baseQuickAdapter) {
        baseQuickAdapter.getClass();
        return null;
    }

    private final void k(RecyclerView.a0 a0Var) {
        if (this.h) {
            if (!this.i || a0Var.getLayoutPosition() > this.o) {
                m6.a aVar = this.j;
                if (aVar == null) {
                    aVar = new m6.a(0.0f, 1, (DefaultConstructorMarker) null);
                }
                View view = a0Var.itemView;
                Intrinsics.g(view, "holder.itemView");
                for (Animator animator : aVar.a(view)) {
                    A1(animator, a0Var.getLayoutPosition());
                }
                this.o = a0Var.getLayoutPosition();
            }
        }
    }

    public static /* synthetic */ int k1(BaseQuickAdapter baseQuickAdapter, View view, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeaderView");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 1;
        }
        return baseQuickAdapter.j1(view, i, i2);
    }

    public static /* synthetic */ int u(BaseQuickAdapter baseQuickAdapter, View view, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addFooterView");
        }
        if ((i3 & 2) != 0) {
            i = -1;
        }
        if ((i3 & 4) != 0) {
            i2 = 1;
        }
        return baseQuickAdapter.t(view, i, i2);
    }

    public static /* synthetic */ int y(BaseQuickAdapter baseQuickAdapter, View view, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addHeaderView");
        }
        if ((i3 & 2) != 0) {
            i = -1;
        }
        if ((i3 & 4) != 0) {
            i2 = 1;
        }
        return baseQuickAdapter.x(view, i, i2);
    }

    protected void A0(BaseViewHolder baseViewHolder, int i) {
        Intrinsics.h(baseViewHolder, "viewHolder");
    }

    protected void A1(Animator animator, int i) {
        Intrinsics.h(animator, "anim");
        animator.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.onViewAttachedToWindow(baseViewHolder);
        if (u0(baseViewHolder.getItemViewType())) {
            f1(baseViewHolder);
        } else {
            k(baseViewHolder);
        }
    }

    @Deprecated
    public void C0(int i) {
        G0(i);
    }

    public void D0(Object obj) {
        int indexOf = this.b.indexOf(obj);
        if (indexOf == -1) {
            return;
        }
        G0(indexOf);
    }

    protected final void E(int i) {
        if (this.b.size() == i) {
            notifyDataSetChanged();
        }
    }

    public final void E0() {
        if (r0()) {
            LinearLayout linearLayout = this.m;
            if (linearLayout == null) {
                Intrinsics.y("mFooterLayout");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            int X = X();
            if (X != -1) {
                notifyItemRemoved(X);
            }
        }
    }

    protected abstract void F(BaseViewHolder baseViewHolder, Object obj);

    public final void F0() {
        if (s0()) {
            LinearLayout linearLayout = this.l;
            if (linearLayout == null) {
                Intrinsics.y("mHeaderLayout");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            int c0 = c0();
            if (c0 != -1) {
                notifyItemRemoved(c0);
            }
        }
    }

    protected void G(BaseViewHolder baseViewHolder, Object obj, List<? extends Object> list) {
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(list, "payloads");
    }

    public void G0(int i) {
        if (i >= this.b.size()) {
            return;
        }
        this.b.remove(i);
        int a0 = i + a0();
        notifyItemRemoved(a0);
        E(0);
        notifyItemRangeChanged(a0, this.b.size() - a0);
    }

    public final void H0() {
        FrameLayout frameLayout = this.n;
        if (frameLayout != null) {
            if (frameLayout == null) {
                Intrinsics.y("mEmptyLayout");
                frameLayout = null;
            }
            frameLayout.removeAllViews();
        }
    }

    protected BaseViewHolder I(View view) {
        Intrinsics.h(view, "view");
        Class cls = null;
        for (Class<?> cls2 = getClass(); cls == null && cls2 != null; cls2 = cls2.getSuperclass()) {
            cls = e0(cls2);
        }
        BaseViewHolder baseViewHolder = cls == null ? new BaseViewHolder(view) : H(cls, view);
        return baseViewHolder == null ? new BaseViewHolder(view) : baseViewHolder;
    }

    public final void I0(View view) {
        int X;
        Intrinsics.h(view, "footer");
        if (r0()) {
            LinearLayout linearLayout = this.m;
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.y("mFooterLayout");
                linearLayout = null;
            }
            linearLayout.removeView(view);
            LinearLayout linearLayout3 = this.m;
            if (linearLayout3 == null) {
                Intrinsics.y("mFooterLayout");
            } else {
                linearLayout2 = linearLayout3;
            }
            if (linearLayout2.getChildCount() != 0 || (X = X()) == -1) {
                return;
            }
            notifyItemRemoved(X);
        }
    }

    protected BaseViewHolder J(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        return I(u6.a.a(viewGroup, i));
    }

    public final void J0(View view) {
        int c0;
        Intrinsics.h(view, "header");
        if (s0()) {
            LinearLayout linearLayout = this.l;
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.y("mHeaderLayout");
                linearLayout = null;
            }
            linearLayout.removeView(view);
            LinearLayout linearLayout3 = this.l;
            if (linearLayout3 == null) {
                Intrinsics.y("mHeaderLayout");
            } else {
                linearLayout2 = linearLayout3;
            }
            if (linearLayout2.getChildCount() != 0 || (c0 = c0()) == -1) {
                return;
            }
            notifyItemRemoved(c0);
        }
    }

    public final b K() {
        return this.j;
    }

    @Deprecated
    public void K0(Collection<Object> collection) {
        Intrinsics.h(collection, "newData");
        n1(collection);
    }

    public final boolean L() {
        return this.h;
    }

    public final void L0(b bVar) {
        this.h = true;
        this.j = bVar;
    }

    public final LinkedHashSet<Integer> M() {
        return this.y;
    }

    public final void M0(boolean z) {
        this.h = z;
    }

    public final LinkedHashSet<Integer> N() {
        return this.z;
    }

    public final void N0(boolean z) {
        this.i = z;
    }

    protected int O() {
        return this.b.size();
    }

    public final void O0(AnimationType animationType) {
        m6.f aVar;
        Intrinsics.h(animationType, "animationType");
        int i = b.a[animationType.ordinal()];
        if (i == 1) {
            aVar = new m6.a(0.0f, 1, (DefaultConstructorMarker) null);
        } else if (i == 2) {
            aVar = new m6.c(0.0f, 1, (DefaultConstructorMarker) null);
        } else if (i == 3) {
            aVar = new m6.d();
        } else if (i == 4) {
            aVar = new m6.e();
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            aVar = new m6.f();
        }
        L0(aVar);
    }

    protected int P(int i) {
        return super.getItemViewType(i);
    }

    public void P0(int i, Object obj) {
        if (i >= this.b.size()) {
            return;
        }
        this.b.set(i, obj);
        notifyItemChanged(i + a0());
    }

    @Deprecated
    public final c Q() {
        return R();
    }

    public final void Q0(List<Object> list) {
        Intrinsics.h(list, "<set-?>");
        this.b = list;
    }

    public final c R() {
        c cVar = this.k;
        if (cVar == null) {
            throw new IllegalStateException("Please use setDiffCallback() or setDiffConfig() first!");
        }
        Intrinsics.e(cVar);
        return cVar;
    }

    public final void R0(DiffUtil.e eVar) {
        Intrinsics.h(eVar, "diffCallback");
        S0(new d.a(eVar).a());
    }

    public final t6.a S() {
        throw new IllegalStateException("Please first implements DraggableModule");
    }

    public final void S0(o6.d dVar) {
        Intrinsics.h(dVar, "config");
        this.k = new c(this, dVar);
    }

    public final FrameLayout T() {
        FrameLayout frameLayout = this.n;
        if (frameLayout != null) {
            if (frameLayout != null) {
                return frameLayout;
            }
            Intrinsics.y("mEmptyLayout");
        }
        return null;
    }

    public void T0(@NonNull DiffUtil.d dVar, List<Object> list) {
        Intrinsics.h(dVar, "diffResult");
        Intrinsics.h(list, "list");
        if (q0()) {
            q1(list);
        } else {
            dVar.b(new o6.e(this));
            this.b = list;
        }
    }

    public final LinearLayout U() {
        LinearLayout linearLayout = this.m;
        if (linearLayout != null) {
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.y("mFooterLayout");
        }
        return null;
    }

    @JvmOverloads
    public final void U0(List<Object> list) {
        W0(this, list, null, 2, null);
    }

    public final int V() {
        return r0() ? 1 : 0;
    }

    @JvmOverloads
    public void V0(List<Object> list, Runnable runnable) {
        if (q0()) {
            q1(list);
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.f(list, runnable);
        }
    }

    public final boolean W() {
        return this.g;
    }

    public final int X() {
        if (!q0()) {
            return a0() + this.b.size();
        }
        int i = (this.c && s0()) ? 2 : 1;
        if (this.d) {
            return i;
        }
        return -1;
    }

    public final void X0(int i) {
        RecyclerView recyclerView = this.x;
        if (recyclerView != null) {
            View inflate = LayoutInflater.from(recyclerView.getContext()).inflate(i, (ViewGroup) recyclerView, false);
            Intrinsics.g(inflate, "view");
            Y0(inflate);
        }
    }

    public final boolean Y() {
        return this.d;
    }

    public final void Y0(View view) {
        boolean z;
        Intrinsics.h(view, "emptyView");
        int itemCount = getItemCount();
        FrameLayout frameLayout = null;
        if (this.n == null) {
            FrameLayout frameLayout2 = new FrameLayout(view.getContext());
            this.n = frameLayout2;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            frameLayout2.setLayoutParams(layoutParams != null ? new ViewGroup.LayoutParams(layoutParams.width, layoutParams.height) : new ViewGroup.LayoutParams(-1, -1));
            z = true;
        } else {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                FrameLayout frameLayout3 = this.n;
                if (frameLayout3 == null) {
                    Intrinsics.y("mEmptyLayout");
                    frameLayout3 = null;
                }
                ViewGroup.LayoutParams layoutParams3 = frameLayout3.getLayoutParams();
                layoutParams3.width = layoutParams2.width;
                layoutParams3.height = layoutParams2.height;
                FrameLayout frameLayout4 = this.n;
                if (frameLayout4 == null) {
                    Intrinsics.y("mEmptyLayout");
                    frameLayout4 = null;
                }
                frameLayout4.setLayoutParams(layoutParams3);
            }
            z = false;
        }
        FrameLayout frameLayout5 = this.n;
        if (frameLayout5 == null) {
            Intrinsics.y("mEmptyLayout");
            frameLayout5 = null;
        }
        frameLayout5.removeAllViews();
        FrameLayout frameLayout6 = this.n;
        if (frameLayout6 == null) {
            Intrinsics.y("mEmptyLayout");
        } else {
            frameLayout = frameLayout6;
        }
        frameLayout.addView(view);
        this.e = true;
        if (z && q0()) {
            int i = (this.c && s0()) ? 1 : 0;
            if (getItemCount() > itemCount) {
                notifyItemInserted(i);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public final LinearLayout Z() {
        LinearLayout linearLayout = this.l;
        if (linearLayout != null) {
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.y("mHeaderLayout");
        }
        return null;
    }

    @JvmOverloads
    public final int Z0(View view) {
        Intrinsics.h(view, "view");
        return c1(this, view, 0, 0, 6, null);
    }

    public final int a0() {
        return s0() ? 1 : 0;
    }

    @JvmOverloads
    public final int a1(View view, int i) {
        Intrinsics.h(view, "view");
        return c1(this, view, i, 0, 4, null);
    }

    public final boolean b0() {
        return this.f;
    }

    @JvmOverloads
    public final int b1(View view, int i, int i2) {
        Intrinsics.h(view, "view");
        LinearLayout linearLayout = this.m;
        if (linearLayout != null) {
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.y("mFooterLayout");
                linearLayout = null;
            }
            if (linearLayout.getChildCount() > i) {
                LinearLayout linearLayout3 = this.m;
                if (linearLayout3 == null) {
                    Intrinsics.y("mFooterLayout");
                    linearLayout3 = null;
                }
                linearLayout3.removeViewAt(i);
                LinearLayout linearLayout4 = this.m;
                if (linearLayout4 == null) {
                    Intrinsics.y("mFooterLayout");
                } else {
                    linearLayout2 = linearLayout4;
                }
                linearLayout2.addView(view, i);
                return i;
            }
        }
        return t(view, i, i2);
    }

    public final int c0() {
        return (!q0() || this.c) ? 0 : -1;
    }

    public final boolean d0() {
        return this.c;
    }

    public final void d1(boolean z) {
        this.g = z;
    }

    public final void e1(boolean z) {
        this.d = z;
    }

    public Object f0(int i) {
        return CollectionsKt.l0(this.b, i);
    }

    protected void f1(RecyclerView.a0 a0Var) {
        Intrinsics.h(a0Var, "holder");
        StaggeredGridLayoutManager.b layoutParams = a0Var.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.b) {
            layoutParams.c(true);
        }
    }

    public int g0(Object obj) {
        if (obj == null || this.b.isEmpty()) {
            return -1;
        }
        return this.b.indexOf(obj);
    }

    public final void g1(a aVar) {
    }

    public final Context getContext() {
        Context context = getRecyclerView().getContext();
        Intrinsics.g(context, "recyclerView.context");
        return context;
    }

    public final List<Object> getData() {
        return this.b;
    }

    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!q0()) {
            f fVar = this.w;
            return a0() + O() + V() + ((fVar == null || !fVar.m()) ? 0 : 1);
        }
        if (this.c && s0()) {
            r1 = 2;
        }
        return (this.d && r0()) ? r1 + 1 : r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (q0()) {
            boolean z = this.c && s0();
            if (i != 0) {
                return i != 1 ? D : D;
            }
            if (z) {
                return B;
            }
            return E;
        }
        boolean s0 = s0();
        if (s0 && i == 0) {
            return B;
        }
        if (s0) {
            i--;
        }
        int size = this.b.size();
        return i < size ? P(i) : i - size < r0() ? D : C;
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.x;
        if (recyclerView == null) {
            throw new IllegalStateException("Please get it after onAttachedToRecyclerView()");
        }
        Intrinsics.e(recyclerView);
        return recyclerView;
    }

    public final f h0() {
        f fVar = this.w;
        if (fVar == null) {
            throw new IllegalStateException("Please first implements LoadMoreModule");
        }
        Intrinsics.e(fVar);
        return fVar;
    }

    @JvmOverloads
    public final int h1(View view) {
        Intrinsics.h(view, "view");
        return k1(this, view, 0, 0, 6, null);
    }

    public final f i0() {
        return this.w;
    }

    @JvmOverloads
    public final int i1(View view, int i) {
        Intrinsics.h(view, "view");
        return k1(this, view, i, 0, 4, null);
    }

    public final r6.b j0() {
        return this.s;
    }

    @JvmOverloads
    public final int j1(View view, int i, int i2) {
        Intrinsics.h(view, "view");
        LinearLayout linearLayout = this.l;
        if (linearLayout != null) {
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.y("mHeaderLayout");
                linearLayout = null;
            }
            if (linearLayout.getChildCount() > i) {
                LinearLayout linearLayout3 = this.l;
                if (linearLayout3 == null) {
                    Intrinsics.y("mHeaderLayout");
                    linearLayout3 = null;
                }
                linearLayout3.removeViewAt(i);
                LinearLayout linearLayout4 = this.l;
                if (linearLayout4 == null) {
                    Intrinsics.y("mHeaderLayout");
                } else {
                    linearLayout2 = linearLayout4;
                }
                linearLayout2.addView(view, i);
                return i;
            }
        }
        return x(view, i, i2);
    }

    public final r6.c k0() {
        return null;
    }

    public final void l(int... iArr) {
        Intrinsics.h(iArr, "viewIds");
        for (int i : iArr) {
            this.y.add(Integer.valueOf(i));
        }
    }

    public final r6.d l0() {
        return this.q;
    }

    public final void l1(boolean z) {
        this.f = z;
    }

    public final void m(int... iArr) {
        Intrinsics.h(iArr, "viewIds");
        for (int i : iArr) {
            this.z.add(Integer.valueOf(i));
        }
    }

    public final e m0() {
        return this.r;
    }

    public final void m1(boolean z) {
        this.c = z;
    }

    public void n(int i, Object obj) {
        this.b.add(i, obj);
        notifyItemInserted(i + a0());
        E(1);
    }

    public final RecyclerView n0() {
        return this.x;
    }

    public void n1(Collection<Object> collection) {
        List<Object> list = this.b;
        if (collection != list) {
            list.clear();
            if (collection != null && !collection.isEmpty()) {
                this.b.addAll(collection);
            }
        } else if (collection == null || collection.isEmpty()) {
            this.b.clear();
        } else {
            ArrayList arrayList = new ArrayList(collection);
            this.b.clear();
            this.b.addAll(arrayList);
        }
        f fVar = this.w;
        if (fVar != null) {
            fVar.x();
        }
        this.o = -1;
        notifyDataSetChanged();
        f fVar2 = this.w;
        if (fVar2 != null) {
            fVar2.f();
        }
    }

    public void o(int i, Collection<Object> collection) {
        Intrinsics.h(collection, "newData");
        this.b.addAll(i, collection);
        notifyItemRangeInserted(i + a0(), collection.size());
        E(collection.size());
    }

    public final g o0() {
        g gVar = this.u;
        if (gVar == null) {
            throw new IllegalStateException("Please first implements UpFetchModule");
        }
        Intrinsics.e(gVar);
        return gVar;
    }

    public final void o1(f fVar) {
        this.w = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.x = recyclerView;
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.d0(new c(this, layoutManager, gridLayoutManager.Y()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.x = null;
    }

    public void p(@NonNull Object obj) {
        this.b.add(obj);
        notifyItemInserted(this.b.size() + a0());
        E(1);
    }

    public final View p0(int i, int i2) {
        BaseViewHolder baseViewHolder;
        RecyclerView recyclerView = this.x;
        if (recyclerView == null || (baseViewHolder = (BaseViewHolder) recyclerView.findViewHolderForLayoutPosition(i)) == null) {
            return null;
        }
        return baseViewHolder.getViewOrNull(i2);
    }

    @Deprecated
    public void p1(List<Object> list) {
        q1(list);
    }

    public void q(@NonNull Collection<Object> collection) {
        Intrinsics.h(collection, "newData");
        this.b.addAll(collection);
        notifyItemRangeInserted((this.b.size() - collection.size()) + a0(), collection.size());
        E(collection.size());
    }

    public final boolean q0() {
        FrameLayout frameLayout = this.n;
        if (frameLayout != null) {
            if (frameLayout == null) {
                Intrinsics.y("mEmptyLayout");
                frameLayout = null;
            }
            if (frameLayout.getChildCount() != 0 && this.e) {
                return this.b.isEmpty();
            }
            return false;
        }
        return false;
    }

    public void q1(List<Object> list) {
        if (list == this.b) {
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        this.b = list;
        f fVar = this.w;
        if (fVar != null) {
            fVar.x();
        }
        this.o = -1;
        notifyDataSetChanged();
        f fVar2 = this.w;
        if (fVar2 != null) {
            fVar2.f();
        }
    }

    @JvmOverloads
    public final int r(View view) {
        Intrinsics.h(view, "view");
        return u(this, view, 0, 0, 6, null);
    }

    public final boolean r0() {
        LinearLayout linearLayout = this.m;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.y("mFooterLayout");
            linearLayout = null;
        }
        return linearLayout.getChildCount() > 0;
    }

    protected void r1(View view, int i) {
        Intrinsics.h(view, "v");
        r6.b bVar = this.s;
        if (bVar != null) {
            bVar.a(this, view, i);
        }
    }

    @JvmOverloads
    public final int s(View view, int i) {
        Intrinsics.h(view, "view");
        return u(this, view, i, 0, 4, null);
    }

    public final boolean s0() {
        LinearLayout linearLayout = this.l;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.y("mHeaderLayout");
            linearLayout = null;
        }
        return linearLayout.getChildCount() > 0;
    }

    public final void s1(r6.b bVar) {
        this.s = bVar;
    }

    @JvmOverloads
    public final int t(View view, int i, int i2) {
        int X;
        Intrinsics.h(view, "view");
        LinearLayout linearLayout = null;
        if (this.m == null) {
            LinearLayout linearLayout2 = new LinearLayout(view.getContext());
            this.m = linearLayout2;
            linearLayout2.setOrientation(i2);
            LinearLayout linearLayout3 = this.m;
            if (linearLayout3 == null) {
                Intrinsics.y("mFooterLayout");
                linearLayout3 = null;
            }
            linearLayout3.setLayoutParams(i2 == 1 ? new RecyclerView.n(-1, -2) : new RecyclerView.n(-2, -1));
        }
        LinearLayout linearLayout4 = this.m;
        if (linearLayout4 == null) {
            Intrinsics.y("mFooterLayout");
            linearLayout4 = null;
        }
        int childCount = linearLayout4.getChildCount();
        if (i < 0 || i > childCount) {
            i = childCount;
        }
        LinearLayout linearLayout5 = this.m;
        if (linearLayout5 == null) {
            Intrinsics.y("mFooterLayout");
            linearLayout5 = null;
        }
        linearLayout5.addView(view, i);
        LinearLayout linearLayout6 = this.m;
        if (linearLayout6 == null) {
            Intrinsics.y("mFooterLayout");
        } else {
            linearLayout = linearLayout6;
        }
        if (linearLayout.getChildCount() == 1 && (X = X()) != -1) {
            notifyItemInserted(X);
        }
        return i;
    }

    public final boolean t0() {
        return this.i;
    }

    protected boolean t1(View view, int i) {
        Intrinsics.h(view, "v");
        return false;
    }

    protected boolean u0(int i) {
        return i == 268436821 || i == 268435729 || i == 268436275 || i == 268436002;
    }

    public final void u1(r6.c cVar) {
    }

    @JvmOverloads
    public final int v(View view) {
        Intrinsics.h(view, "view");
        return y(this, view, 0, 0, 6, null);
    }

    public final boolean v0() {
        return this.e;
    }

    protected void v1(View view, int i) {
        Intrinsics.h(view, "v");
        r6.d dVar = this.q;
        if (dVar != null) {
            dVar.a(this, view, i);
        }
    }

    @JvmOverloads
    public final int w(View view, int i) {
        Intrinsics.h(view, "view");
        return y(this, view, i, 0, 4, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        Intrinsics.h(baseViewHolder, "holder");
        g gVar = this.u;
        if (gVar != null) {
            gVar.a(i);
        }
        f fVar = this.w;
        if (fVar != null) {
            fVar.e(i);
        }
        switch (baseViewHolder.getItemViewType()) {
            case B /* 268435729 */:
            case D /* 268436275 */:
            case E /* 268436821 */:
                break;
            case C /* 268436002 */:
                f fVar2 = this.w;
                if (fVar2 != null) {
                    fVar2.j().convert(baseViewHolder, i, fVar2.i());
                    break;
                }
                break;
            default:
                F(baseViewHolder, getItem(i - a0()));
                break;
        }
    }

    public final void w1(r6.d dVar) {
        this.q = dVar;
    }

    @JvmOverloads
    public final int x(View view, int i, int i2) {
        int c0;
        Intrinsics.h(view, "view");
        LinearLayout linearLayout = null;
        if (this.l == null) {
            LinearLayout linearLayout2 = new LinearLayout(view.getContext());
            this.l = linearLayout2;
            linearLayout2.setOrientation(i2);
            LinearLayout linearLayout3 = this.l;
            if (linearLayout3 == null) {
                Intrinsics.y("mHeaderLayout");
                linearLayout3 = null;
            }
            linearLayout3.setLayoutParams(i2 == 1 ? new RecyclerView.n(-1, -2) : new RecyclerView.n(-2, -1));
        }
        LinearLayout linearLayout4 = this.l;
        if (linearLayout4 == null) {
            Intrinsics.y("mHeaderLayout");
            linearLayout4 = null;
        }
        int childCount = linearLayout4.getChildCount();
        if (i < 0 || i > childCount) {
            i = childCount;
        }
        LinearLayout linearLayout5 = this.l;
        if (linearLayout5 == null) {
            Intrinsics.y("mHeaderLayout");
            linearLayout5 = null;
        }
        linearLayout5.addView(view, i);
        LinearLayout linearLayout6 = this.l;
        if (linearLayout6 == null) {
            Intrinsics.y("mHeaderLayout");
        } else {
            linearLayout = linearLayout6;
        }
        if (linearLayout.getChildCount() == 1 && (c0 = c0()) != -1) {
            notifyItemInserted(c0);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i, List<Object> list) {
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(list, "payloads");
        if (list.isEmpty()) {
            onBindViewHolder(baseViewHolder, i);
        }
        g gVar = this.u;
        if (gVar != null) {
            gVar.a(i);
        }
        f fVar = this.w;
        if (fVar != null) {
            fVar.e(i);
        }
        switch (baseViewHolder.getItemViewType()) {
            case B /* 268435729 */:
            case D /* 268436275 */:
            case E /* 268436821 */:
                break;
            case C /* 268436002 */:
                f fVar2 = this.w;
                if (fVar2 != null) {
                    fVar2.j().convert(baseViewHolder, i, fVar2.i());
                    break;
                }
                break;
            default:
                G(baseViewHolder, getItem(i - a0()), list);
                break;
        }
    }

    protected boolean x1(View view, int i) {
        Intrinsics.h(view, "v");
        e eVar = this.r;
        if (eVar != null) {
            return eVar.a(this, view, i);
        }
        return false;
    }

    protected BaseViewHolder y0(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        return J(viewGroup, this.a);
    }

    public final void y1(e eVar) {
        this.r = eVar;
    }

    protected void z(BaseViewHolder baseViewHolder, int i) {
        Intrinsics.h(baseViewHolder, "viewHolder");
        if (this.q != null) {
            ((RecyclerView.a0) baseViewHolder).itemView.setOnClickListener(new l(baseViewHolder, this));
        }
        if (this.r != null) {
            ((RecyclerView.a0) baseViewHolder).itemView.setOnLongClickListener(new m(baseViewHolder, this));
        }
        if (this.s != null) {
            Iterator<Integer> it = M().iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                View view = ((RecyclerView.a0) baseViewHolder).itemView;
                Intrinsics.g(next, "id");
                View findViewById = view.findViewById(next.intValue());
                if (findViewById != null) {
                    Intrinsics.g(findViewById, "findViewById<View>(id)");
                    if (!findViewById.isClickable()) {
                        findViewById.setClickable(true);
                    }
                    findViewById.setOnClickListener(new n(baseViewHolder, this));
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        View view = null;
        switch (i) {
            case B /* 268435729 */:
                LinearLayout linearLayout = this.l;
                if (linearLayout == null) {
                    Intrinsics.y("mHeaderLayout");
                    linearLayout = null;
                }
                ViewParent parent = linearLayout.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) parent;
                    LinearLayout linearLayout2 = this.l;
                    if (linearLayout2 == null) {
                        Intrinsics.y("mHeaderLayout");
                        linearLayout2 = null;
                    }
                    viewGroup2.removeView(linearLayout2);
                }
                LinearLayout linearLayout3 = this.l;
                if (linearLayout3 == null) {
                    Intrinsics.y("mHeaderLayout");
                } else {
                    view = linearLayout3;
                }
                return I(view);
            case C /* 268436002 */:
                f fVar = this.w;
                Intrinsics.e(fVar);
                BaseViewHolder I = I(fVar.j().getRootView(viewGroup));
                f fVar2 = this.w;
                Intrinsics.e(fVar2);
                fVar2.F(I);
                return I;
            case D /* 268436275 */:
                LinearLayout linearLayout4 = this.m;
                if (linearLayout4 == null) {
                    Intrinsics.y("mFooterLayout");
                    linearLayout4 = null;
                }
                ViewParent parent2 = linearLayout4.getParent();
                if (parent2 instanceof ViewGroup) {
                    ViewGroup viewGroup3 = (ViewGroup) parent2;
                    LinearLayout linearLayout5 = this.m;
                    if (linearLayout5 == null) {
                        Intrinsics.y("mFooterLayout");
                        linearLayout5 = null;
                    }
                    viewGroup3.removeView(linearLayout5);
                }
                LinearLayout linearLayout6 = this.m;
                if (linearLayout6 == null) {
                    Intrinsics.y("mFooterLayout");
                } else {
                    view = linearLayout6;
                }
                return I(view);
            case E /* 268436821 */:
                FrameLayout frameLayout = this.n;
                if (frameLayout == null) {
                    Intrinsics.y("mEmptyLayout");
                    frameLayout = null;
                }
                ViewParent parent3 = frameLayout.getParent();
                if (parent3 instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) parent3;
                    FrameLayout frameLayout2 = this.n;
                    if (frameLayout2 == null) {
                        Intrinsics.y("mEmptyLayout");
                        frameLayout2 = null;
                    }
                    viewGroup4.removeView(frameLayout2);
                }
                FrameLayout frameLayout3 = this.n;
                if (frameLayout3 == null) {
                    Intrinsics.y("mEmptyLayout");
                } else {
                    view = frameLayout3;
                }
                return I(view);
            default:
                BaseViewHolder y0 = y0(viewGroup, i);
                z(y0, i);
                A0(y0, i);
                return y0;
        }
    }

    public final void z1(boolean z) {
        this.e = z;
    }
}
