package com.chad.library.adapter.base;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.integration.event.EventConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001>B\u0019\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007JM\u0010\u000f\u001a\u00020\u0000\"\b\b\u0000\u0010\b*\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t2\u0010\u0010\f\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J@\u0010\u0011\u001a\u00020\u0000\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u00022\u0010\u0010\f\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010 \u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0014¢\u0006\u0004\b \u0010!J#\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010#J%\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b$\u0010#J\u0017\u0010&\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015H\u0014¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010,J\u0017\u0010/\u001a\u00020.2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b/\u00100J\u001b\u00101\u001a\u00020\u00152\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0004¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u0003H\u0014¢\u0006\u0004\b3\u0010,J\u001f\u00104\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b4\u0010*RH\u00108\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r05j\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r`68\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u00107R8\u00109\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u001505j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u0015`68\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u00107R$\u0010=\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u000b0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/chad/library/adapter/base/e;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "", "list", "<init>", "(Ljava/util/List;)V", "T", "Ljava/lang/Class;", "clazz", "Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "baseItemBinder", "Landroidx/recyclerview/widget/DiffUtil$e;", EventConstants.ABILITY_NAME_CALLBACK, "I1", "(Ljava/lang/Class;Lcom/chad/library/adapter/base/binder/BaseItemBinder;Landroidx/recyclerview/widget/DiffUtil$e;)Lcom/chad/library/adapter/base/e;", "G1", "(Lcom/chad/library/adapter/base/binder/BaseItemBinder;Landroidx/recyclerview/widget/DiffUtil$e;)Lcom/chad/library/adapter/base/e;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "y0", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "F", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "", "payloads", "G", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "S1", "(I)Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "T1", "position", "P", "(I)I", "viewHolder", "z", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "V1", "", "U1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)Z", "R1", "(Ljava/lang/Class;)I", "O1", "L1", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "classDiffMap", "mTypeMap", "Landroid/util/SparseArray;", "H", "Landroid/util/SparseArray;", "mBinderArray", "a", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class e extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private final HashMap<Class<?>, DiffUtil.e> classDiffMap;

    /* renamed from: G, reason: from kotlin metadata */
    private final HashMap<Class<?>, Integer> mTypeMap;

    /* renamed from: H, reason: from kotlin metadata */
    private final SparseArray<BaseItemBinder> mBinderArray;

    private final class a extends DiffUtil.e {
        public a() {
        }

        public boolean areContentsTheSame(Object obj, Object obj2) {
            DiffUtil.e eVar;
            Intrinsics.h(obj, "oldItem");
            Intrinsics.h(obj2, "newItem");
            if (!Intrinsics.c(obj.getClass(), obj2.getClass()) || (eVar = (DiffUtil.e) e.this.classDiffMap.get(obj.getClass())) == null) {
                return true;
            }
            return eVar.areContentsTheSame(obj, obj2);
        }

        public boolean areItemsTheSame(Object obj, Object obj2) {
            DiffUtil.e eVar;
            Intrinsics.h(obj, "oldItem");
            Intrinsics.h(obj2, "newItem");
            return (!Intrinsics.c(obj.getClass(), obj2.getClass()) || (eVar = (DiffUtil.e) e.this.classDiffMap.get(obj.getClass())) == null) ? Intrinsics.c(obj, obj2) : eVar.areItemsTheSame(obj, obj2);
        }

        public Object getChangePayload(Object obj, Object obj2) {
            DiffUtil.e eVar;
            Intrinsics.h(obj, "oldItem");
            Intrinsics.h(obj2, "newItem");
            if (!Intrinsics.c(obj.getClass(), obj2.getClass()) || (eVar = (DiffUtil.e) e.this.classDiffMap.get(obj.getClass())) == null) {
                return null;
            }
            return eVar.getChangePayload(obj, obj2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e() {
        this(r0, 1, r0);
        List list = null;
    }

    public e(List<Object> list) {
        super(0, list);
        this.classDiffMap = new HashMap<>();
        this.mTypeMap = new HashMap<>();
        this.mBinderArray = new SparseArray<>();
        R0(new a());
    }

    public /* synthetic */ e(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public static /* synthetic */ e J1(e eVar, BaseItemBinder baseItemBinder, DiffUtil.e eVar2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
        }
        if ((i & 2) != 0) {
            eVar2 = null;
        }
        Intrinsics.h(baseItemBinder, "baseItemBinder");
        Intrinsics.n(4, "T");
        eVar.I1(Object.class, baseItemBinder, eVar2);
        return eVar;
    }

    public static /* synthetic */ e K1(e eVar, Class cls, BaseItemBinder baseItemBinder, DiffUtil.e eVar2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
        }
        if ((i & 4) != 0) {
            eVar2 = null;
        }
        return eVar.I1(cls, baseItemBinder, eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M1(BaseViewHolder baseViewHolder, e eVar, BaseItemBinder baseItemBinder, View view) {
        int a0;
        Object l0;
        Intrinsics.h(baseViewHolder, "$viewHolder");
        Intrinsics.h(eVar, "this$0");
        Intrinsics.h(baseItemBinder, "$provider");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1 || (l0 = CollectionsKt.l0(eVar.getData(), (a0 = bindingAdapterPosition - eVar.a0()))) == null) {
            return false;
        }
        Intrinsics.g(view, "v");
        return baseItemBinder.h(baseViewHolder, view, l0, a0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(BaseViewHolder baseViewHolder, e eVar, BaseItemBinder baseItemBinder, View view) {
        int a0;
        Object l0;
        Intrinsics.h(baseViewHolder, "$viewHolder");
        Intrinsics.h(eVar, "this$0");
        Intrinsics.h(baseItemBinder, "$provider");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1 || (l0 = CollectionsKt.l0(eVar.getData(), (a0 = bindingAdapterPosition - eVar.a0()))) == null) {
            return;
        }
        Intrinsics.g(view, "v");
        baseItemBinder.g(baseViewHolder, view, l0, a0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(BaseViewHolder baseViewHolder, e eVar, View view) {
        Intrinsics.h(baseViewHolder, "$viewHolder");
        Intrinsics.h(eVar, "this$0");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int a0 = bindingAdapterPosition - eVar.a0();
        BaseItemBinder S1 = eVar.S1(baseViewHolder.getItemViewType());
        if (CollectionsKt.l0(eVar.getData(), a0) == null) {
            return;
        }
        Intrinsics.g(view, "it");
        S1.i(baseViewHolder, view, eVar.getData().get(a0), a0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q1(BaseViewHolder baseViewHolder, e eVar, View view) {
        Intrinsics.h(baseViewHolder, "$viewHolder");
        Intrinsics.h(eVar, "this$0");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int a0 = bindingAdapterPosition - eVar.a0();
        BaseItemBinder S1 = eVar.S1(baseViewHolder.getItemViewType());
        Object l0 = CollectionsKt.l0(eVar.getData(), a0);
        if (l0 == null) {
            return false;
        }
        Intrinsics.g(view, "it");
        return S1.l(baseViewHolder, view, l0, a0);
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.B0(holder);
        BaseItemBinder T1 = T1(holder.getItemViewType());
        if (T1 != null) {
            T1.m(holder);
        }
    }

    protected void F(BaseViewHolder holder, Object item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        S1(holder.getItemViewType()).a(holder, item);
    }

    protected void G(BaseViewHolder holder, Object item, List<? extends Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        S1(holder.getItemViewType()).b(holder, item, payloads);
    }

    public final /* synthetic */ <T> e G1(BaseItemBinder baseItemBinder, DiffUtil.e callback) {
        Intrinsics.h(baseItemBinder, "baseItemBinder");
        Intrinsics.n(4, "T");
        I1(Object.class, baseItemBinder, callback);
        return this;
    }

    @JvmOverloads
    public final <T> e H1(Class<? extends T> cls, BaseItemBinder baseItemBinder) {
        Intrinsics.h(cls, "clazz");
        Intrinsics.h(baseItemBinder, "baseItemBinder");
        return K1(this, cls, baseItemBinder, null, 4, null);
    }

    @JvmOverloads
    public final <T> e I1(Class<? extends T> clazz, BaseItemBinder baseItemBinder, DiffUtil.e callback) {
        Intrinsics.h(clazz, "clazz");
        Intrinsics.h(baseItemBinder, "baseItemBinder");
        int size = this.mTypeMap.size() + 1;
        this.mTypeMap.put(clazz, Integer.valueOf(size));
        this.mBinderArray.append(size, baseItemBinder);
        baseItemBinder.o(this);
        if (callback != null) {
            this.classDiffMap.put(clazz, callback);
        }
        return this;
    }

    protected void L1(final BaseViewHolder viewHolder, int viewType) {
        Intrinsics.h(viewHolder, "viewHolder");
        if (j0() == null) {
            final BaseItemBinder S1 = S1(viewType);
            Iterator it = S1.c().iterator();
            while (it.hasNext()) {
                View findViewById = ((RecyclerView.a0) viewHolder).itemView.findViewById(((Number) it.next()).intValue());
                if (findViewById != null) {
                    Intrinsics.g(findViewById, "findViewById<View>(id)");
                    if (!findViewById.isClickable()) {
                        findViewById.setClickable(true);
                    }
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            e.N1(viewHolder, this, S1, view);
                        }
                    });
                }
            }
        }
        k0();
        final BaseItemBinder S12 = S1(viewType);
        Iterator it2 = S12.d().iterator();
        while (it2.hasNext()) {
            View findViewById2 = ((RecyclerView.a0) viewHolder).itemView.findViewById(((Number) it2.next()).intValue());
            if (findViewById2 != null) {
                Intrinsics.g(findViewById2, "findViewById<View>(id)");
                if (!findViewById2.isLongClickable()) {
                    findViewById2.setLongClickable(true);
                }
                findViewById2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.b
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean M1;
                        M1 = e.M1(viewHolder, this, S12, view);
                        return M1;
                    }
                });
            }
        }
    }

    protected void O1(final BaseViewHolder viewHolder) {
        Intrinsics.h(viewHolder, "viewHolder");
        if (l0() == null) {
            ((RecyclerView.a0) viewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.P1(viewHolder, this, view);
                }
            });
        }
        if (m0() == null) {
            ((RecyclerView.a0) viewHolder).itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.d
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean Q1;
                    Q1 = e.Q1(viewHolder, this, view);
                    return Q1;
                }
            });
        }
    }

    protected int P(int position) {
        return R1(getData().get(position).getClass());
    }

    protected final int R1(Class<?> clazz) {
        Intrinsics.h(clazz, "clazz");
        Integer num = this.mTypeMap.get(clazz);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException(("findViewType: ViewType: " + clazz + " Not Find!").toString());
    }

    public BaseItemBinder S1(int viewType) {
        BaseItemBinder baseItemBinder = this.mBinderArray.get(viewType);
        if (baseItemBinder != null) {
            return baseItemBinder;
        }
        throw new IllegalStateException(("getItemBinder: viewType '" + viewType + "' no such Binder found，please use addItemBinder() first!").toString());
    }

    public BaseItemBinder T1(int viewType) {
        BaseItemBinder baseItemBinder = this.mBinderArray.get(viewType);
        if (baseItemBinder == null) {
            return null;
        }
        return baseItemBinder;
    }

    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public boolean onFailedToRecycleView(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        BaseItemBinder T1 = T1(holder.getItemViewType());
        if (T1 != null) {
            return T1.k(holder);
        }
        return false;
    }

    /* renamed from: V1, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewDetachedFromWindow(holder);
        BaseItemBinder T1 = T1(holder.getItemViewType());
        if (T1 != null) {
            T1.n(holder);
        }
    }

    protected BaseViewHolder y0(ViewGroup parent, int viewType) {
        Intrinsics.h(parent, "parent");
        BaseItemBinder S1 = S1(viewType);
        S1.p(getContext());
        return S1.j(parent, viewType);
    }

    protected void z(BaseViewHolder viewHolder, int viewType) {
        Intrinsics.h(viewHolder, "viewHolder");
        super.z(viewHolder, viewType);
        O1(viewHolder);
        L1(viewHolder, viewType);
    }
}
