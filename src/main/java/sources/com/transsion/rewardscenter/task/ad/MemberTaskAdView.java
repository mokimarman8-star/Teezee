package com.transsion.rewardscenter.task.ad;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper;
import com.transsion.rewardscenter.task.ad.MemberTaskAdHelper;
import com.transsion.rewardscenter.task.ad.d;
import com.transsion.rewardscenter.task.ad.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\fJ\u001f\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\n¢\u0006\u0004\b#\u0010\fJ\r\u0010$\u001a\u00020\n¢\u0006\u0004\b$\u0010\fJ\u0015\u0010%\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b%\u0010\u0014J\r\u0010&\u001a\u00020\n¢\u0006\u0004\b&\u0010\fJ\u0017\u0010)\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u000208078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/transsion/rewardscenter/task/ad/MemberTaskAdView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "r", "()V", "s", "p", "n", "u", BuildConfig.FLAVOR, "packageName", "m", "(Ljava/lang/String;)V", "k", "l", "Lcom/transsion/rewardscenter/task/ad/v$c;", "item", "index", "w", "(Lcom/transsion/rewardscenter/task/ad/v$c;I)V", "Lcom/transsion/rewardscenter/task/ad/v$a;", "v", "(Lcom/transsion/rewardscenter/task/ad/v$a;I)V", "Lzo/a;", "config", "setCtxConfig", "(Lzo/a;)V", "onPause", "onResume", "onPackageInstall", PushConstants.PROVIDER_FIELD_DESTROY, "Lcom/transsion/rewardscenter/task/ad/BaseStageTaskAdHelper$a;", "listener", "setClaimListener", "(Lcom/transsion/rewardscenter/task/ad/BaseStageTaskAdHelper$a;)V", "Lcom/transsion/rewardscenter/task/ad/MemberTaskAdHelper;", "a", "Lcom/transsion/rewardscenter/task/ad/MemberTaskAdHelper;", "adHelper", "Lcom/transsion/rewardscenter/task/ad/d;", "b", "Lcom/transsion/rewardscenter/task/ad/d;", "taskAdAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "taskAdRecycler", BuildConfig.FLAVOR, "Lcom/transsion/rewardscenter/task/ad/v;", "getFullList", "()Ljava/util/List;", "fullList", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberTaskAdView extends ConstraintLayout {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private MemberTaskAdHelper adHelper;

    /* renamed from: b, reason: from kotlin metadata */
    private d taskAdAdapter;

    /* renamed from: c, reason: from kotlin metadata */
    private RecyclerView taskAdRecycler;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MemberTaskAdView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MemberTaskAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MemberTaskAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        r();
    }

    public /* synthetic */ MemberTaskAdView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final List<v> getFullList() {
        ArrayList arrayList = new ArrayList();
        List e = u.a.e();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(e, 10));
        Iterator it = e.iterator();
        while (it.hasNext()) {
            arrayList2.add(((v.c) it.next()).i());
        }
        Set W0 = CollectionsKt.W0(arrayList2);
        u uVar = u.a;
        if (!uVar.e().isEmpty()) {
            arrayList.addAll(uVar.e());
        }
        if (!uVar.d().isEmpty()) {
            List d = uVar.d();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : d) {
                if (!W0.contains(((v.a) obj).i())) {
                    arrayList3.add(obj);
                }
            }
            arrayList.addAll(arrayList3);
        }
        arrayList.add(new v.b(null, 1, null));
        return arrayList;
    }

    private final void k() {
        List<v> l;
        MemberTaskAdHelper memberTaskAdHelper;
        d dVar = this.taskAdAdapter;
        if (dVar == null || (l = dVar.getData()) == null) {
            l = CollectionsKt.l();
        }
        int i = 0;
        for (v vVar : l) {
            int i2 = i + 1;
            if (vVar instanceof v.c) {
                MemberTaskAdHelper memberTaskAdHelper2 = this.adHelper;
                if (memberTaskAdHelper2 != null) {
                    v.c cVar = (v.c) vVar;
                    if (memberTaskAdHelper2.n(cVar)) {
                        a.a.f(wf.a.a, "StageTaskAd", "MemberTaskAdView----> update stage index: " + i + " state: " + cVar.e(), false, 4, (Object) null);
                        d dVar2 = this.taskAdAdapter;
                        if (dVar2 != null) {
                            dVar2.notifyItemChanged(i);
                        }
                    }
                }
            } else if ((vVar instanceof v.a) && (memberTaskAdHelper = this.adHelper) != null) {
                v.a aVar = (v.a) vVar;
                if (memberTaskAdHelper.m(aVar)) {
                    a.a.f(wf.a.a, "StageTaskAd", "MemberTaskAdView----> update regular index: " + i + " state: " + aVar.e(), false, 4, (Object) null);
                    d dVar3 = this.taskAdAdapter;
                    if (dVar3 != null) {
                        dVar3.notifyItemChanged(i);
                    }
                }
            }
            i = i2;
        }
    }

    private final void l() {
        List<v> l;
        d dVar;
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper == null || memberTaskAdHelper.h() != 0) {
            d dVar2 = this.taskAdAdapter;
            if (dVar2 == null || (l = dVar2.getData()) == null) {
                l = CollectionsKt.l();
            }
            int i = 0;
            for (v vVar : l) {
                int i2 = i + 1;
                if (vVar instanceof v.c) {
                    MemberTaskAdHelper memberTaskAdHelper2 = this.adHelper;
                    if (memberTaskAdHelper2 != null && memberTaskAdHelper2.l((v.c) vVar) && (dVar = this.taskAdAdapter) != null) {
                        dVar.notifyItemChanged(i);
                    }
                } else if (vVar instanceof v.a) {
                    v.a aVar = (v.a) vVar;
                    if (aVar.e() == AdTaskState.PLAYING) {
                        aVar.m(AdTaskState.PLAYED);
                        d dVar3 = this.taskAdAdapter;
                        if (dVar3 != null) {
                            dVar3.notifyItemChanged(i);
                        }
                    }
                }
                i = i2;
            }
        }
    }

    private final void m(String packageName) {
        List<v> l;
        a.a.f(wf.a.a, "StageTaskAd", "MemberTaskAdView --> checkAdsInstallStatus packageName = " + packageName, false, 4, (Object) null);
        d dVar = this.taskAdAdapter;
        if (dVar == null || (l = dVar.getData()) == null) {
            l = CollectionsKt.l();
        }
        int i = 0;
        for (v vVar : l) {
            int i2 = i + 1;
            if (vVar instanceof v.c) {
                v.c cVar = (v.c) vVar;
                if (Intrinsics.c(cVar.i(), packageName)) {
                    w(cVar, i);
                }
            } else if (vVar instanceof v.a) {
                v.a aVar = (v.a) vVar;
                if (Intrinsics.c(aVar.i(), packageName)) {
                    v(aVar, i);
                }
            }
            i = i2;
        }
    }

    private final void n() {
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.X(new Function1() { // from class: com.transsion.rewardscenter.task.ad.i
                public final Object invoke(Object obj) {
                    Unit o;
                    o = MemberTaskAdView.o(MemberTaskAdView.this, (List) obj);
                    return o;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bf, code lost:
    
        if (r5 != false) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit o(MemberTaskAdView memberTaskAdView, List list) {
        Intrinsics.h(list, "newRegularItems");
        List<v.a> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
        for (v.a aVar : list2) {
            AdTaskState l = u.a.l(aVar.i());
            if (l != null) {
                aVar = aVar.a((r23 & 1) != 0 ? aVar.a : null, (r23 & 2) != 0 ? aVar.b : null, (r23 & 4) != 0 ? aVar.c : null, (r23 & 8) != 0 ? aVar.d : null, (r23 & 16) != 0 ? aVar.e : l, (r23 & 32) != 0 ? aVar.f : null, (r23 & 64) != 0 ? aVar.g : false, (r23 & 128) != 0 ? aVar.h : false, (r23 & 256) != 0 ? aVar.i : 0L);
            }
            arrayList.add(aVar);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            v.a aVar2 = (v.a) obj;
            boolean z = false;
            boolean z2 = aVar2.e().ordinal() > AdTaskState.NORMAL.ordinal();
            com.transsion.rewardscenter.utils.o oVar = com.transsion.rewardscenter.utils.o.a;
            Context context = memberTaskAdView.getContext();
            Intrinsics.g(context, "getContext(...)");
            boolean a = oVar.a(context, aVar2.i());
            a.a.f(wf.a.a, "StageTaskAd", "Regular ----> restoreItem: " + z2 + ", isPullNewAd: " + aVar2.k() + ", isAppInstalled: " + a, false, 4, (Object) null);
            if (!z2) {
                if (aVar2.k()) {
                    a = !a;
                }
            }
            z = true;
            if (z) {
                arrayList2.add(obj);
            }
        }
        List B0 = CollectionsKt.B0(u.a.d(), arrayList2);
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : B0) {
            if (hashSet.add(((v.a) obj2).i())) {
                arrayList3.add(obj2);
            }
        }
        u.a.s(CollectionsKt.K0(arrayList3, MemberTaskAdHelper.r.a()));
        memberTaskAdView.u();
        return Unit.a;
    }

    private final void p() {
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.Z(new Function1() { // from class: com.transsion.rewardscenter.task.ad.h
                public final Object invoke(Object obj) {
                    Unit q;
                    q = MemberTaskAdView.q(MemberTaskAdView.this, (List) obj);
                    return q;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit q(MemberTaskAdView memberTaskAdView, List list) {
        Intrinsics.h(list, "newStageItems");
        List<v.c> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
        for (v.c cVar : list2) {
            AdTaskState l = u.a.l(cVar.i());
            if (l != null) {
                cVar = cVar.a((r25 & 1) != 0 ? cVar.a : null, (r25 & 2) != 0 ? cVar.b : null, (r25 & 4) != 0 ? cVar.c : null, (r25 & 8) != 0 ? cVar.d : null, (r25 & 16) != 0 ? cVar.e : l, (r25 & 32) != 0 ? cVar.f : null, (r25 & 64) != 0 ? cVar.g : false, (r25 & 128) != 0 ? cVar.h : 0L, (r25 & 256) != 0 ? cVar.i : 0L);
            }
            arrayList.add(cVar);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            v.c cVar2 = (v.c) obj;
            boolean z = cVar2.e().ordinal() > AdTaskState.NORMAL.ordinal();
            com.transsion.rewardscenter.utils.o oVar = com.transsion.rewardscenter.utils.o.a;
            Context context = memberTaskAdView.getContext();
            Intrinsics.g(context, "getContext(...)");
            boolean a = oVar.a(context, cVar2.i());
            a.a.f(wf.a.a, "StageTaskAd", "Stage ----> restoreItem: " + z + ", isAppInstalled: " + a, false, 4, (Object) null);
            if (z || !a) {
                arrayList2.add(obj);
            }
        }
        List B0 = CollectionsKt.B0(u.a.e(), arrayList2);
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : B0) {
            if (hashSet.add(((v.c) obj2).i())) {
                arrayList3.add(obj2);
            }
        }
        u.a.t(CollectionsKt.K0(arrayList3, MemberTaskAdHelper.r.b()));
        memberTaskAdView.u();
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        RecyclerView recyclerView = new RecyclerView(getContext());
        addView(recyclerView, new ConstraintLayout.b(-1, -1));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new d.a(16, 0, 2, null));
        this.taskAdRecycler = recyclerView;
    }

    private final void s() {
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            boolean z = memberTaskAdHelper.v() <= 0;
            boolean z2 = memberTaskAdHelper.w() <= 0;
            boolean z3 = memberTaskAdHelper.u() <= 0;
            boolean z4 = memberTaskAdHelper.t() <= 0;
            if (z) {
                u uVar = u.a;
                List e = uVar.e();
                ArrayList arrayList = new ArrayList();
                for (Object obj : e) {
                    if (((v.c) obj).e().ordinal() >= AdTaskState.CLAIMED_STAGE1.ordinal()) {
                        arrayList.add(obj);
                    }
                }
                uVar.t(arrayList);
            }
            if (z2) {
                u.a.t(CollectionsKt.l());
            }
            for (v.c cVar : u.a.e()) {
                AdTaskState l = u.a.l(cVar.i());
                if (l != null && cVar.e() != l) {
                    cVar.m(l);
                }
            }
            if (z3) {
                u uVar2 = u.a;
                List d = uVar2.d();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : d) {
                    if (!((v.a) obj2).k()) {
                        arrayList2.add(obj2);
                    }
                }
                uVar2.s(arrayList2);
            }
            if (z4) {
                u uVar3 = u.a;
                List d2 = uVar3.d();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : d2) {
                    if (((v.a) obj3).k()) {
                        arrayList3.add(obj3);
                    }
                }
                uVar3.s(arrayList3);
            }
            for (v.a aVar : u.a.d()) {
                AdTaskState l2 = u.a.l(aVar.i());
                if (l2 != null && aVar.e() != l2) {
                    aVar.m(l2);
                }
            }
            u uVar4 = u.a;
            int size = uVar4.e().size();
            MemberTaskAdHelper.a aVar2 = MemberTaskAdHelper.r;
            boolean z5 = size < aVar2.b();
            boolean z6 = uVar4.d().size() < aVar2.a();
            if (!z && z5) {
                p();
            }
            if ((!z3 || !z4) && z6) {
                n();
            }
            d dVar = this.taskAdAdapter;
            if (dVar != null) {
                dVar.n1(getFullList());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MemberTaskAdView memberTaskAdView) {
        memberTaskAdView.s();
        return Unit.a;
    }

    private final void u() {
        d dVar = this.taskAdAdapter;
        if (dVar != null) {
            dVar.n1(getFullList());
        }
    }

    private final void v(v.a item, int index) {
        if (item.e() == AdTaskState.NORMAL || item.e() == AdTaskState.DOWNLOADING) {
            item.m(AdTaskState.INSTALLED);
            a.a.f(wf.a.a, "StageTaskAd", "MemberTaskAdView --> update regular index:" + index + " installed", false, 4, (Object) null);
            d dVar = this.taskAdAdapter;
            if (dVar != null) {
                dVar.notifyItemChanged(index);
            }
        }
    }

    private final void w(v.c item, int index) {
        if (item.e() == AdTaskState.NORMAL || item.e() == AdTaskState.DOWNLOADING) {
            item.m(AdTaskState.INSTALLED);
            a.a.f(wf.a.a, "StageTaskAd", "MemberTaskAdView --> update stage index:" + index + " installed", false, 4, (Object) null);
            d dVar = this.taskAdAdapter;
            if (dVar != null) {
                dVar.notifyItemChanged(index);
            }
        }
    }

    public final void destroy() {
        for (v.c cVar : u.a.e()) {
            cVar.n(false);
            cVar.p(null);
            cVar.l(null);
            cVar.r(null);
        }
        for (v.a aVar : u.a.d()) {
            aVar.n(false);
            aVar.p(null);
            aVar.l(null);
            aVar.q(null);
        }
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.d();
        }
        this.adHelper = null;
    }

    public final void onPackageInstall(String packageName) {
        Intrinsics.h(packageName, "packageName");
        m(packageName);
    }

    public final void onPause() {
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.o();
        }
    }

    public final void onResume() {
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.p();
        }
        k();
        l();
    }

    public final void setClaimListener(BaseStageTaskAdHelper.a listener) {
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.x(listener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCtxConfig(zo.a config) {
        Intrinsics.h(config, "config");
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        this.adHelper = new MemberTaskAdHelper(context, config.b());
        d dVar = new d(this.adHelper);
        this.taskAdAdapter = dVar;
        RecyclerView recyclerView = this.taskAdRecycler;
        if (recyclerView != null) {
            recyclerView.setAdapter(dVar);
        }
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.f(new Function0() { // from class: com.transsion.rewardscenter.task.ad.g
                public final Object invoke() {
                    Unit t;
                    t = MemberTaskAdView.t(MemberTaskAdView.this);
                    return t;
                }
            });
        }
    }
}
