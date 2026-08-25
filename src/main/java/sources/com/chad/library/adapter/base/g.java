package com.chad.library.adapter.base;

import androidx.recyclerview.widget.DiffUtil;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ/\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011JC\u0010\u0017\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018JC\u0010\u001a\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u0018J\u0015\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010\u001fJ\u0015\u0010!\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b!\u0010\u001fJ\u001d\u0010#\u001a\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0007H\u0014¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u001d2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016¢\u0006\u0004\b(\u0010\u0006J\u001f\u0010)\u001a\u00020\u001d2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fH\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0002H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010/J%\u00101\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¢\u0006\u0004\b1\u00102J\u001d\u00103\u001a\u00020\u001d2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¢\u0006\u0004\b3\u0010*J\u0017\u00104\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u00105J\u001f\u00107\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0002H\u0016¢\u0006\u0004\b7\u0010-J)\u0010:\u001a\u00020\u001d2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00032\b\u00109\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\b:\u0010;J%\u0010>\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020<2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¢\u0006\u0004\b>\u0010?J\u001d\u0010A\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0002¢\u0006\u0004\bA\u0010BJ%\u0010D\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0002¢\u0006\u0004\bD\u0010EJ+\u0010F\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u00072\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\bF\u0010GJ\u001d\u0010H\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u0007¢\u0006\u0004\bH\u0010IJ\u001d\u0010K\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u0002¢\u0006\u0004\bK\u0010BJ%\u0010L\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0002¢\u0006\u0004\bL\u0010EJ#\u0010M\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u00022\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\bM\u0010NJ9\u0010O\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\bO\u0010PJ9\u0010Q\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\bQ\u0010PJ9\u0010R\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\bR\u0010PJ9\u0010S\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\bS\u0010PJ9\u0010T\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\bT\u0010PJY\u0010Y\u001a\u00020\u001d2\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010U\u001a\u00020\u000e2\b\b\u0002\u0010V\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\bY\u0010ZJ\u0015\u0010\\\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u0002¢\u0006\u0004\b\\\u0010]J\u0017\u0010^\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b^\u0010\nR$\u0010c\u001a\u0012\u0012\u0004\u0012\u00020\u00070_j\b\u0012\u0004\u0012\u00020\u0007``8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010b¨\u0006d"}, d2 = {"Lcom/chad/library/adapter/base/g;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lq6/b;", "", "nodeList", "<init>", "(Ljava/util/List;)V", "", "position", "S2", "(I)I", "R2", "", "list", "", "isExpanded", "I2", "(Ljava/util/Collection;Ljava/lang/Boolean;)Ljava/util/List;", "isChangeChildCollapse", "animate", "notify", "", "parentPayload", "Z1", "(IZZZLjava/lang/Object;)I", "isChangeChildExpand", "l2", "Lcom/chad/library/adapter/base/provider/a;", "provider", "", "U1", "(Lcom/chad/library/adapter/base/provider/a;)V", "T1", "S1", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "F1", "(Lcom/chad/library/adapter/base/provider/BaseItemProvider;)V", "type", "u0", "(I)Z", "q1", "n1", "(Ljava/util/Collection;)V", "data", "Q1", "(ILq6/b;)V", "R1", "(Lq6/b;)V", "newData", "o", "(ILjava/util/Collection;)V", "q", "G0", "(I)V", "index", "T2", "Ljava/lang/Runnable;", "commitCallback", "V0", "(Ljava/util/List;Ljava/lang/Runnable;)V", "Landroidx/recyclerview/widget/DiffUtil$d;", "diffResult", "T0", "(Landroidx/recyclerview/widget/DiffUtil$d;Ljava/util/List;)V", "parentNode", "M2", "(Lq6/b;Lq6/b;)V", "childIndex", "L2", "(Lq6/b;ILq6/b;)V", "K2", "(Lq6/b;ILjava/util/Collection;)V", "N2", "(Lq6/b;I)V", "childNode", "O2", "Q2", "P2", "(Lq6/b;Ljava/util/Collection;)V", "Y1", "(IZZLjava/lang/Object;)I", "k2", "E2", "r2", "f2", "isExpandedChild", "isCollapseChild", "expandPayload", "collapsePayload", "z2", "(IZZZZLjava/lang/Object;Ljava/lang/Object;)V", "node", "H2", "(Lq6/b;)I", "G2", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "G", "Ljava/util/HashSet;", "fullSpanNodeTypeSet", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class g extends BaseProviderMultiAdapter<q6.b> {

    /* renamed from: G, reason: from kotlin metadata */
    private final HashSet<Integer> fullSpanNodeTypeSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public g() {
        this(r0, 1, r0);
        List list = null;
    }

    public g(List<q6.b> list) {
        super((List) null);
        this.fullSpanNodeTypeSet = new HashSet<>();
        List<q6.b> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        getData().addAll(J2(this, list2, null, 2, null));
    }

    public /* synthetic */ g(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public static /* synthetic */ void A2(g gVar, int i, boolean z, boolean z2, boolean z3, boolean z4, Object obj, Object obj2, int i2, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandAndCollapseOther");
        }
        gVar.z2(i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? true : z2, (i2 & 8) != 0 ? true : z3, (i2 & 16) == 0 ? z4 : true, (i2 & 32) != 0 ? null : obj, (i2 & 64) == 0 ? obj2 : null);
    }

    public static /* synthetic */ int F2(g gVar, int i, boolean z, boolean z2, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandOrCollapse");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            obj = null;
        }
        return gVar.E2(i, z, z2, obj);
    }

    private final List<q6.b> I2(Collection<? extends q6.b> list, Boolean isExpanded) {
        List a;
        ArrayList arrayList = new ArrayList();
        for (q6.b bVar : list) {
            arrayList.add(bVar);
            if (bVar instanceof q6.a) {
                if ((Intrinsics.c(isExpanded, Boolean.TRUE) || ((q6.a) bVar).b()) && (a = bVar.a()) != null && !a.isEmpty()) {
                    arrayList.addAll(I2(a, isExpanded));
                }
                if (isExpanded != null) {
                    ((q6.a) bVar).c(isExpanded.booleanValue());
                }
            } else {
                List a2 = bVar.a();
                if (a2 != null && !a2.isEmpty()) {
                    arrayList.addAll(I2(a2, isExpanded));
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ List J2(g gVar, Collection collection, Boolean bool, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatData");
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        return gVar.I2(collection, bool);
    }

    private final int R2(int position) {
        q6.b bVar;
        List a;
        if (position >= getData().size() || (a = (bVar = (q6.b) getData().get(position)).a()) == null || a.isEmpty()) {
            return 0;
        }
        if (!(bVar instanceof q6.a)) {
            List a2 = bVar.a();
            Intrinsics.e(a2);
            List J2 = J2(this, a2, null, 2, null);
            getData().removeAll(J2);
            return J2.size();
        }
        if (!((q6.a) bVar).b()) {
            return 0;
        }
        List a3 = bVar.a();
        Intrinsics.e(a3);
        List J22 = J2(this, a3, null, 2, null);
        getData().removeAll(J22);
        return J22.size();
    }

    private final int S2(int position) {
        if (position >= getData().size()) {
            return 0;
        }
        int R2 = R2(position);
        getData().remove(position);
        int i = R2 + 1;
        return i;
    }

    private final int Z1(int position, boolean isChangeChildCollapse, boolean animate, boolean notify, Object parentPayload) {
        q6.b bVar = (q6.b) getData().get(position);
        if (bVar instanceof q6.a) {
            q6.a aVar = (q6.a) bVar;
            if (aVar.b()) {
                int a0 = position + a0();
                aVar.c(false);
                List a = bVar.a();
                if (a != null && !a.isEmpty()) {
                    List a2 = bVar.a();
                    Intrinsics.e(a2);
                    List<q6.b> I2 = I2(a2, isChangeChildCollapse ? Boolean.FALSE : null);
                    int size = I2.size();
                    getData().removeAll(I2);
                    if (notify) {
                        if (animate) {
                            notifyItemChanged(a0, parentPayload);
                            notifyItemRangeRemoved(a0 + 1, size);
                        } else {
                            notifyDataSetChanged();
                        }
                    }
                    return size;
                }
                notifyItemChanged(a0, parentPayload);
            }
        }
        return 0;
    }

    public static /* synthetic */ int a2(g gVar, int i, boolean z, boolean z2, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            obj = null;
        }
        return gVar.Y1(i, z, z2, obj);
    }

    static /* synthetic */ int b2(g gVar, int i, boolean z, boolean z2, boolean z3, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        boolean z4 = z;
        boolean z7 = (i2 & 4) != 0 ? true : z2;
        boolean z8 = (i2 & 8) != 0 ? true : z3;
        if ((i2 & 16) != 0) {
            obj = null;
        }
        return gVar.Z1(i, z4, z7, z8, obj);
    }

    public static /* synthetic */ int g2(g gVar, int i, boolean z, boolean z2, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapseAndChild");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            obj = null;
        }
        return gVar.f2(i, z, z2, obj);
    }

    private final int l2(int position, boolean isChangeChildExpand, boolean animate, boolean notify, Object parentPayload) {
        q6.b bVar = (q6.b) getData().get(position);
        if (bVar instanceof q6.a) {
            q6.a aVar = (q6.a) bVar;
            if (!aVar.b()) {
                int a0 = a0() + position;
                aVar.c(true);
                List a = bVar.a();
                if (a != null && !a.isEmpty()) {
                    List a2 = bVar.a();
                    Intrinsics.e(a2);
                    List<q6.b> I2 = I2(a2, isChangeChildExpand ? Boolean.TRUE : null);
                    int size = I2.size();
                    getData().addAll(position + 1, I2);
                    if (notify) {
                        if (animate) {
                            notifyItemChanged(a0, parentPayload);
                            notifyItemRangeInserted(a0 + 1, size);
                        } else {
                            notifyDataSetChanged();
                        }
                    }
                    return size;
                }
                notifyItemChanged(a0, parentPayload);
            }
        }
        return 0;
    }

    public static /* synthetic */ int m2(g gVar, int i, boolean z, boolean z2, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            obj = null;
        }
        return gVar.k2(i, z, z2, obj);
    }

    static /* synthetic */ int n2(g gVar, int i, boolean z, boolean z2, boolean z3, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        boolean z4 = z;
        boolean z7 = (i2 & 4) != 0 ? true : z2;
        boolean z8 = (i2 & 8) != 0 ? true : z3;
        if ((i2 & 16) != 0) {
            obj = null;
        }
        return gVar.l2(i, z4, z7, z8, obj);
    }

    public static /* synthetic */ int s2(g gVar, int i, boolean z, boolean z2, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandAndChild");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            obj = null;
        }
        return gVar.r2(i, z, z2, obj);
    }

    @JvmOverloads
    public final int B2(int i) {
        return F2(this, i, false, false, null, 14, null);
    }

    @JvmOverloads
    public final int C2(int i, boolean z) {
        return F2(this, i, z, false, null, 12, null);
    }

    @JvmOverloads
    public final int D2(int i, boolean z, boolean z2) {
        return F2(this, i, z, z2, null, 8, null);
    }

    @JvmOverloads
    public final int E2(int position, boolean animate, boolean notify, Object parentPayload) {
        q6.b bVar = (q6.b) getData().get(position);
        if (bVar instanceof q6.a) {
            return ((q6.a) bVar).b() ? Z1(position, false, animate, notify, parentPayload) : l2(position, false, animate, notify, parentPayload);
        }
        return 0;
    }

    public void F1(BaseItemProvider provider) {
        Intrinsics.h(provider, "provider");
        if (!(provider instanceof com.chad.library.adapter.base.provider.a)) {
            throw new IllegalStateException("Please add BaseNodeProvider, no BaseItemProvider!");
        }
        super.F1(provider);
    }

    public void G0(int position) {
        notifyItemRangeRemoved(position + a0(), S2(position));
        E(0);
    }

    public final int G2(int position) {
        if (position == 0) {
            return -1;
        }
        q6.b bVar = (q6.b) getData().get(position);
        for (int i = position - 1; -1 < i; i--) {
            List a = ((q6.b) getData().get(i)).a();
            if (a != null && a.contains(bVar)) {
                return i;
            }
        }
        return -1;
    }

    public final int H2(q6.b node) {
        Intrinsics.h(node, "node");
        int indexOf = getData().indexOf(node);
        if (indexOf != -1 && indexOf != 0) {
            for (int i = indexOf - 1; -1 < i; i--) {
                List a = ((q6.b) getData().get(i)).a();
                if (a != null && a.contains(node)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public final void K2(q6.b parentNode, int childIndex, Collection<? extends q6.b> newData) {
        Intrinsics.h(parentNode, "parentNode");
        Intrinsics.h(newData, "newData");
        List a = parentNode.a();
        if (a != null) {
            a.addAll(childIndex, newData);
            if (!(parentNode instanceof q6.a) || ((q6.a) parentNode).b()) {
                o(getData().indexOf(parentNode) + 1 + childIndex, newData);
            }
        }
    }

    public final void L2(q6.b parentNode, int childIndex, q6.b data) {
        Intrinsics.h(parentNode, "parentNode");
        Intrinsics.h(data, "data");
        List a = parentNode.a();
        if (a != null) {
            a.add(childIndex, data);
            if (!(parentNode instanceof q6.a) || ((q6.a) parentNode).b()) {
                n(getData().indexOf(parentNode) + 1 + childIndex, data);
            }
        }
    }

    public final void M2(q6.b parentNode, q6.b data) {
        Intrinsics.h(parentNode, "parentNode");
        Intrinsics.h(data, "data");
        List a = parentNode.a();
        if (a != null) {
            a.add(data);
            if (!(parentNode instanceof q6.a) || ((q6.a) parentNode).b()) {
                n(getData().indexOf(parentNode) + a.size(), data);
            }
        }
    }

    public final void N2(q6.b parentNode, int childIndex) {
        Intrinsics.h(parentNode, "parentNode");
        List a = parentNode.a();
        if (a == null || childIndex >= a.size()) {
            return;
        }
        if ((parentNode instanceof q6.a) && !((q6.a) parentNode).b()) {
            a.remove(childIndex);
        } else {
            C0(getData().indexOf(parentNode) + 1 + childIndex);
        }
    }

    public final void O2(q6.b parentNode, q6.b childNode) {
        Intrinsics.h(parentNode, "parentNode");
        Intrinsics.h(childNode, "childNode");
        List a = parentNode.a();
        if (a != null) {
            if ((parentNode instanceof q6.a) && !((q6.a) parentNode).b()) {
                a.remove(childNode);
            } else {
                D0(childNode);
                a.remove(childNode);
            }
        }
    }

    public final void P2(q6.b parentNode, Collection<? extends q6.b> newData) {
        Intrinsics.h(parentNode, "parentNode");
        Intrinsics.h(newData, "newData");
        List a = parentNode.a();
        if (a != null) {
            if ((parentNode instanceof q6.a) && !((q6.a) parentNode).b()) {
                a.clear();
                a.addAll(newData);
                return;
            }
            int indexOf = getData().indexOf(parentNode);
            int R2 = R2(indexOf);
            a.clear();
            a.addAll(newData);
            List J2 = J2(this, newData, null, 2, null);
            int i = indexOf + 1;
            getData().addAll(i, J2);
            int a0 = i + a0();
            if (R2 == J2.size()) {
                notifyItemRangeChanged(a0, R2);
            } else {
                notifyItemRangeRemoved(a0, R2);
                notifyItemRangeInserted(a0, J2.size());
            }
        }
    }

    /* renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public void n(int position, q6.b data) {
        Intrinsics.h(data, "data");
        o(position, CollectionsKt.h(new q6.b[]{data}));
    }

    public final void Q2(q6.b parentNode, int childIndex, q6.b data) {
        Intrinsics.h(parentNode, "parentNode");
        Intrinsics.h(data, "data");
        List a = parentNode.a();
        if (a == null || childIndex >= a.size()) {
            return;
        }
        if ((parentNode instanceof q6.a) && !((q6.a) parentNode).b()) {
            a.set(childIndex, data);
        } else {
            P0(getData().indexOf(parentNode) + 1 + childIndex, data);
            a.set(childIndex, data);
        }
    }

    /* renamed from: R1, reason: merged with bridge method [inline-methods] */
    public void p(q6.b data) {
        Intrinsics.h(data, "data");
        q(CollectionsKt.h(new q6.b[]{data}));
    }

    public final void S1(com.chad.library.adapter.base.provider.a provider) {
        Intrinsics.h(provider, "provider");
        T1(provider);
    }

    public void T0(DiffUtil.d diffResult, List<q6.b> list) {
        Intrinsics.h(diffResult, "diffResult");
        Intrinsics.h(list, "list");
        if (q0()) {
            q1(list);
        } else {
            super/*com.chad.library.adapter.base.BaseQuickAdapter*/.T0(diffResult, J2(this, list, null, 2, null));
        }
    }

    public final void T1(com.chad.library.adapter.base.provider.a provider) {
        Intrinsics.h(provider, "provider");
        this.fullSpanNodeTypeSet.add(Integer.valueOf(provider.l()));
        F1(provider);
    }

    /* renamed from: T2, reason: merged with bridge method [inline-methods] */
    public void P0(int index, q6.b data) {
        Intrinsics.h(data, "data");
        int S2 = S2(index);
        List J2 = J2(this, CollectionsKt.h(new q6.b[]{data}), null, 2, null);
        getData().addAll(index, J2);
        if (S2 == J2.size()) {
            notifyItemRangeChanged(index + a0(), S2);
        } else {
            notifyItemRangeRemoved(a0() + index, S2);
            notifyItemRangeInserted(index + a0(), J2.size());
        }
    }

    public final void U1(com.chad.library.adapter.base.provider.a provider) {
        Intrinsics.h(provider, "provider");
        F1(provider);
    }

    public void V0(List<q6.b> list, Runnable commitCallback) {
        if (q0()) {
            q1(list);
        } else {
            super/*com.chad.library.adapter.base.BaseQuickAdapter*/.V0(J2(this, list != null ? list : new ArrayList(), null, 2, null), commitCallback);
        }
    }

    @JvmOverloads
    public final int V1(int i) {
        return a2(this, i, false, false, null, 14, null);
    }

    @JvmOverloads
    public final int W1(int i, boolean z) {
        return a2(this, i, z, false, null, 12, null);
    }

    @JvmOverloads
    public final int X1(int i, boolean z, boolean z2) {
        return a2(this, i, z, z2, null, 8, null);
    }

    @JvmOverloads
    public final int Y1(int position, boolean animate, boolean notify, Object parentPayload) {
        return Z1(position, false, animate, notify, parentPayload);
    }

    @JvmOverloads
    public final int c2(int i) {
        return g2(this, i, false, false, null, 14, null);
    }

    @JvmOverloads
    public final int d2(int i, boolean z) {
        return g2(this, i, z, false, null, 12, null);
    }

    @JvmOverloads
    public final int e2(int i, boolean z, boolean z2) {
        return g2(this, i, z, z2, null, 8, null);
    }

    @JvmOverloads
    public final int f2(int position, boolean animate, boolean notify, Object parentPayload) {
        return Z1(position, true, animate, notify, parentPayload);
    }

    @JvmOverloads
    public final int h2(int i) {
        return m2(this, i, false, false, null, 14, null);
    }

    @JvmOverloads
    public final int i2(int i, boolean z) {
        return m2(this, i, z, false, null, 12, null);
    }

    @JvmOverloads
    public final int j2(int i, boolean z, boolean z2) {
        return m2(this, i, z, z2, null, 8, null);
    }

    @JvmOverloads
    public final int k2(int position, boolean animate, boolean notify, Object parentPayload) {
        return l2(position, false, animate, notify, parentPayload);
    }

    public void n1(Collection<? extends q6.b> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        super/*com.chad.library.adapter.base.BaseQuickAdapter*/.n1(J2(this, list, null, 2, null));
    }

    public void o(int position, Collection<? extends q6.b> newData) {
        Intrinsics.h(newData, "newData");
        super/*com.chad.library.adapter.base.BaseQuickAdapter*/.o(position, J2(this, newData, null, 2, null));
    }

    @JvmOverloads
    public final int o2(int i) {
        return s2(this, i, false, false, null, 14, null);
    }

    @JvmOverloads
    public final int p2(int i, boolean z) {
        return s2(this, i, z, false, null, 12, null);
    }

    public void q(Collection<? extends q6.b> newData) {
        Intrinsics.h(newData, "newData");
        super/*com.chad.library.adapter.base.BaseQuickAdapter*/.q(J2(this, newData, null, 2, null));
    }

    public void q1(List<q6.b> list) {
        super/*com.chad.library.adapter.base.BaseQuickAdapter*/.q1(J2(this, list != null ? list : new ArrayList(), null, 2, null));
    }

    @JvmOverloads
    public final int q2(int i, boolean z, boolean z2) {
        return s2(this, i, z, z2, null, 8, null);
    }

    @JvmOverloads
    public final int r2(int position, boolean animate, boolean notify, Object parentPayload) {
        return l2(position, true, animate, notify, parentPayload);
    }

    @JvmOverloads
    public final void t2(int i) {
        A2(this, i, false, false, false, false, null, null, 126, null);
    }

    protected boolean u0(int type) {
        return super/*com.chad.library.adapter.base.BaseQuickAdapter*/.u0(type) || this.fullSpanNodeTypeSet.contains(Integer.valueOf(type));
    }

    @JvmOverloads
    public final void u2(int i, boolean z) {
        A2(this, i, z, false, false, false, null, null, 124, null);
    }

    @JvmOverloads
    public final void v2(int i, boolean z, boolean z2) {
        A2(this, i, z, z2, false, false, null, null, 120, null);
    }

    @JvmOverloads
    public final void w2(int i, boolean z, boolean z2, boolean z3) {
        A2(this, i, z, z2, z3, false, null, null, 112, null);
    }

    @JvmOverloads
    public final void x2(int i, boolean z, boolean z2, boolean z3, boolean z4) {
        A2(this, i, z, z2, z3, z4, null, null, 96, null);
    }

    @JvmOverloads
    public final void y2(int i, boolean z, boolean z2, boolean z3, boolean z4, Object obj) {
        A2(this, i, z, z2, z3, z4, obj, null, 64, null);
    }

    @JvmOverloads
    public final void z2(int position, boolean isExpandedChild, boolean isCollapseChild, boolean animate, boolean notify, Object expandPayload, Object collapsePayload) {
        int i;
        int size;
        int l2 = l2(position, isExpandedChild, animate, notify, expandPayload);
        if (l2 == 0) {
            return;
        }
        int G2 = G2(position);
        int i2 = G2 == -1 ? 0 : G2 + 1;
        if (position - i2 > 0) {
            int i3 = i2;
            i = position;
            do {
                int Z1 = Z1(i3, isCollapseChild, animate, notify, collapsePayload);
                i3++;
                i -= Z1;
            } while (i3 < i);
        } else {
            i = position;
        }
        if (G2 == -1) {
            size = getData().size() - 1;
        } else {
            List a = ((q6.b) getData().get(G2)).a();
            size = G2 + (a != null ? a.size() : 0) + l2;
        }
        int i4 = i + l2;
        if (i4 < size) {
            int i8 = i4 + 1;
            while (i8 <= size) {
                int Z12 = Z1(i8, isCollapseChild, animate, notify, collapsePayload);
                i8++;
                size -= Z12;
            }
        }
    }
}
