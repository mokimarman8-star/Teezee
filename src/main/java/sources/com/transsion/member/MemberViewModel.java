package com.transsion.member;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.therouter.TheRouter;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.bean.request.InviteUserShareInfoReq;
import com.transsion.member.constants.TaskType;
import com.transsion.memberapi.MemberAdTaskInfo;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberTaskGroup;
import com.transsion.memberapi.MemberTaskInfo;
import com.transsion.memberapi.MemberTaskInviteRewards;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskItemInvite;
import com.transsion.memberapi.MemberTaskRewardInfo;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import com.transsion.memberapi.SkuData;
import com.transsion.memberapi.SkuItem;
import com.transsion.payment.lib.bean.HttpErrorBodyBean;
import fm.a;
import im.d;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
import retrofit2.HttpException;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberViewModel extends androidx.lifecycle.b {
    public static final a o = new a(null);
    public static final int p = 8;
    private final Lazy b;
    private final Lazy c;
    private final androidx.lifecycle.b0 d;
    private final androidx.lifecycle.b0 e;
    private final androidx.lifecycle.b0 f;
    private final androidx.lifecycle.b0 g;
    private final androidx.lifecycle.b0 h;
    private final androidx.lifecycle.b0 i;
    private final androidx.lifecycle.b0 j;
    private final androidx.lifecycle.b0 k;
    private Map l;
    private io.reactivex.rxjava3.disposables.c m;
    private io.reactivex.rxjava3.disposables.c n;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b implements yx.f {
        public static final b a = new b();

        b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(BaseDto baseDto) {
            Intrinsics.h(baseDto, "it");
            MemberDetail memberDetail = (MemberDetail) baseDto.getData();
            if (memberDetail != null) {
                w.a.b().putString("MEMBER_JSON", com.blankj.utilcode.util.o.j(memberDetail));
            }
        }
    }

    public static final class c extends dg.a {
        c() {
        }

        public void a(String str, String str2) {
            MemberViewModel.this.d.q((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberDetail memberDetail) {
            super.c(memberDetail);
            MemberViewModel.this.d.q(memberDetail);
            im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
            if (bVar != null) {
                bVar.j(memberDetail);
            }
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            Intrinsics.h(cVar, "d");
            super.onSubscribe(cVar);
            MemberViewModel.this.m = cVar;
        }
    }

    public static final class d implements im.d {
        d() {
        }

        @Override // im.d
        public void a(MemberAdTaskInfo memberAdTaskInfo, boolean z) {
            d.a.a(this, memberAdTaskInfo, z);
        }

        @Override // im.d
        public void b(MemberTaskInfo memberTaskInfo, boolean z) {
            List<MemberTaskGroup> arrayList;
            ArrayList arrayList2 = new ArrayList();
            if (memberTaskInfo == null || (arrayList = memberTaskInfo.getList()) == null) {
                arrayList = new ArrayList<>();
            }
            for (MemberTaskGroup memberTaskGroup : arrayList) {
                List<MemberTaskItem> taskItems = memberTaskGroup.getTaskItems();
                if (!taskItems.isEmpty()) {
                    MemberTaskItem memberTaskItem = (MemberTaskItem) CollectionsKt.i0(taskItems);
                    List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
                    boolean z2 = false;
                    boolean z3 = inviteList != null && (inviteList.isEmpty() ^ true);
                    if (memberTaskItem.getCheckInList() != null && (!r4.isEmpty())) {
                        z2 = true;
                    }
                    if (z3 || z2) {
                        arrayList2.add(new MemberTaskItem(null, null, Integer.valueOf(TaskType.TITLE.getValue()), null, null, memberTaskGroup.getGroupName(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, memberTaskGroup.getGroupName(), memberTaskGroup.getGroupUrl(), memberTaskGroup.getGroupInfo(), 2097115, null));
                        for (MemberTaskItem memberTaskItem2 : taskItems) {
                            Integer taskSubType = memberTaskItem2.getTaskSubType();
                            int value = TaskType.DOWNLOAD_APP.getValue();
                            if (taskSubType == null || taskSubType.intValue() != value) {
                                Integer taskSubType2 = memberTaskItem2.getTaskSubType();
                                int value2 = TaskType.OPEN_APP.getValue();
                                if (taskSubType2 != null) {
                                    if (taskSubType2.intValue() != value2) {
                                    }
                                }
                                arrayList2.add(memberTaskItem2);
                            }
                            if (zh.b.a.n()) {
                                arrayList2.add(memberTaskItem2);
                            }
                        }
                    }
                }
            }
            MemberViewModel.this.g.q(arrayList2);
        }
    }

    static final class e implements yx.h {
        public static final e a = new e();

        e() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m apply(Throwable th2) {
            Intrinsics.h(th2, "it");
            String string = w.a.b().getString("SKU_LIST_JSON", (String) null);
            if (string == null || string.length() == 0) {
                return io.reactivex.rxjava3.core.j.l(th2);
            }
            try {
                SkuData skuData = (SkuData) com.blankj.utilcode.util.o.e(string, com.blankj.utilcode.util.o.h(SkuData.class, new Type[0]));
                BaseDto baseDto = new BaseDto();
                baseDto.setCode("0");
                baseDto.setData(skuData);
                return io.reactivex.rxjava3.core.j.t(baseDto);
            } catch (Exception unused) {
                return io.reactivex.rxjava3.core.j.l(th2);
            }
        }
    }

    static final class f implements yx.f {
        public static final f a = new f();

        f() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(BaseDto baseDto) {
            Intrinsics.h(baseDto, "it");
            SkuData skuData = (SkuData) baseDto.getData();
            if (skuData != null) {
                List skuList = skuData.getSkuList();
                List K0 = skuList != null ? CollectionsKt.K0(skuList, 3) : null;
                if (K0 == null) {
                    K0 = CollectionsKt.l();
                }
                skuData.setSkuList(K0);
                List skuPointList = skuData.getSkuPointList();
                List K02 = skuPointList != null ? CollectionsKt.K0(skuPointList, 3) : null;
                if (K02 == null) {
                    K02 = CollectionsKt.l();
                }
                skuData.setSkuPointList(K02);
                w.a.b().putString("SKU_LIST_JSON", com.blankj.utilcode.util.o.j(skuData));
            }
        }
    }

    public static final class g extends dg.a {
        g() {
        }

        public void a(String str, String str2) {
            MemberViewModel.this.e.q((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(SkuData skuData) {
            super.c(skuData);
            MemberViewModel.this.e.q(skuData);
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            Intrinsics.h(cVar, "d");
            super.onSubscribe(cVar);
            MemberViewModel.this.n = cVar;
        }
    }

    public static final class h extends dg.a {
        h() {
        }

        public void a(String str, String str2) {
            com.transsion.member.a.a.b("requestInviteUserMore failed " + str + ", " + str2);
            MemberViewModel.this.j.q((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberTaskInviteRewards memberTaskInviteRewards) {
            super.c(memberTaskInviteRewards);
            com.transsion.member.a.a.b("requestInviteUserMore onSuccess:" + memberTaskInviteRewards);
            MemberViewModel.this.j.q(memberTaskInviteRewards);
        }
    }

    static final class i implements yx.g {
        public static final i a = new i();

        i() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Triple a(BaseDto baseDto, BaseDto baseDto2, BaseDto baseDto3) {
            Intrinsics.h(baseDto, "response1");
            Intrinsics.h(baseDto2, "response2");
            Intrinsics.h(baseDto3, "response3");
            return new Triple(baseDto.getData(), baseDto2.getData(), baseDto3.getData());
        }
    }

    static final class j implements yx.f {
        j() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Triple triple) {
            Intrinsics.h(triple, "it");
            androidx.lifecycle.b0 b0Var = MemberViewModel.this.k;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("WhatsApp", triple.getFirst());
            linkedHashMap.put("Telegram", triple.getSecond());
            linkedHashMap.put("CopyLink", triple.getThird());
            b0Var.q(linkedHashMap);
        }
    }

    static final class k implements yx.f {
        k() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Throwable th2) {
            Intrinsics.h(th2, "it");
            MemberViewModel.this.k.q(new LinkedHashMap());
        }
    }

    public static final class l extends dg.a {
        final /* synthetic */ int e;

        l(int i) {
            this.e = i;
        }

        public void a(String str, String str2) {
            com.transsion.member.a.a.b("taskCheckInSubmit failed " + str + ", " + str2);
            MemberViewModel.this.h.q(new Pair(Integer.valueOf(this.e), (Object) null));
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberTaskSubmitCheckInRes memberTaskSubmitCheckInRes) {
            super.c(memberTaskSubmitCheckInRes);
            MemberViewModel.this.h.q(new Pair(Integer.valueOf(this.e), memberTaskSubmitCheckInRes));
        }
    }

    public static final class m extends dg.a {
        final /* synthetic */ int e;
        final /* synthetic */ String f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        m(int i, String str, int i2, int i3) {
            this.e = i;
            this.f = str;
            this.g = i2;
            this.h = i3;
        }

        public void a(String str, String str2) {
            com.transsion.member.a.a.b("taskCheckInSubmit failed " + str + ", " + str2);
            MemberViewModel.this.i.q(new im.e(-this.e, this.f, this.g, this.h, null));
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberTaskRewardInfo memberTaskRewardInfo) {
            super.c(memberTaskRewardInfo);
            MemberViewModel.this.i.q(new im.e(this.e, this.f, this.g, this.h, memberTaskRewardInfo));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.member.e0
            public final Object invoke() {
                fm.a F;
                F = MemberViewModel.F();
                return F;
            }
        });
        this.c = LazyKt.b(new Function0() { // from class: com.transsion.member.f0
            public final Object invoke() {
                im.b G;
                G = MemberViewModel.G();
                return G;
            }
        });
        this.d = new androidx.lifecycle.b0();
        this.e = new androidx.lifecycle.b0();
        this.f = new androidx.lifecycle.b0();
        this.g = new androidx.lifecycle.b0();
        this.h = new androidx.lifecycle.b0();
        this.i = new androidx.lifecycle.b0();
        this.j = new androidx.lifecycle.b0();
        this.k = new androidx.lifecycle.b0();
        this.l = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final fm.a F() {
        return (fm.a) kg.c.e.a().h(fm.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final im.b G() {
        return (im.b) TheRouter.d(im.b.class, new Object[0]);
    }

    private final void H() {
        SkuData skuData = (SkuData) im.i.a.b().f();
        a.a.f(wf.a.a, "MemberViewModel", "Preload skuCache is " + skuData, false, 4, (Object) null);
        this.e.q(skuData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object I(SkuItem skuItem, Continuation continuation) {
        MemberViewModel$redeem$1 memberViewModel$redeem$1;
        int i2;
        String str;
        String str2;
        String reason;
        try {
            if (continuation instanceof MemberViewModel$redeem$1) {
                memberViewModel$redeem$1 = (MemberViewModel$redeem$1) continuation;
                int i3 = memberViewModel$redeem$1.label;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    memberViewModel$redeem$1.label = i3 - Integer.MIN_VALUE;
                    Object obj = memberViewModel$redeem$1.result;
                    Object f2 = IntrinsicsKt.f();
                    i2 = memberViewModel$redeem$1.label;
                    if (i2 != 0) {
                        ResultKt.b(obj);
                        Result.Companion companion = Result.Companion;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("skuId", skuItem.getSkuId());
                        if (this.l.get(skuItem.getSkuId()) != null) {
                            jSONObject.put("clientOrderId", this.l.get(skuItem.getSkuId()));
                        } else {
                            jSONObject.put("clientOrderId", UUID.randomUUID().toString());
                            this.l.put(skuItem.getSkuId(), jSONObject.getString("clientOrderId"));
                        }
                        RequestBody.Companion companion2 = RequestBody.Companion;
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.g(jSONObject2, "toString(...)");
                        RequestBody create = companion2.create(jSONObject2, MediaType.Companion.parse("application/json"));
                        fm.a u = u();
                        String a2 = gg.a.a.a();
                        memberViewModel$redeem$1.label = 1;
                        obj = u.a(a2, create, memberViewModel$redeem$1);
                        if (obj == f2) {
                            return f2;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return obj;
                }
            }
            if (i2 != 0) {
            }
            return obj;
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            HttpException httpException = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.a(th2)));
            if (httpException == null) {
                throw new KotlinNothingValueException();
            }
            if (!(httpException instanceof HttpException)) {
                a.a.l(wf.a.a, "MemberViewModel", "it = " + httpException, false, 4, (Object) null);
                return null;
            }
            HttpErrorBodyBean a3 = HttpErrorBodyBean.INSTANCE.a(httpException);
            String str3 = BuildConfig.FLAVOR;
            if (a3 == null || (str = a3.getMessage()) == null) {
                str = BuildConfig.FLAVOR;
            }
            if (a3 == null || (str2 = a3.getCode()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            if (a3 != null && (reason = a3.getReason()) != null) {
                str3 = reason;
            }
            return new BaseDto(str, str2, (Object) null, str3);
        }
        memberViewModel$redeem$1 = new MemberViewModel$redeem$1(this, continuation);
        Object obj2 = memberViewModel$redeem$1.result;
        Object f22 = IntrinsicsKt.f();
        i2 = memberViewModel$redeem$1.label;
    }

    private final fm.a u() {
        return (fm.a) this.b.getValue();
    }

    private final im.b w() {
        return (im.b) this.c.getValue();
    }

    public final LiveData A() {
        return this.e;
    }

    public final LiveData B() {
        return this.h;
    }

    public final LiveData C() {
        return this.i;
    }

    public final LiveData D() {
        return this.g;
    }

    public final void E() {
        String string = w.a.b().getString("MEMBER_JSON", (String) null);
        if (string != null && string.length() != 0) {
            try {
                this.d.q((MemberDetail) com.blankj.utilcode.util.o.d(string, MemberDetail.class));
            } catch (Exception e2) {
                a.a.f(wf.a.a, "MemberViewModel", "No member detail cache " + e2, false, 4, (Object) null);
            }
        }
        String string2 = w.a.b().getString("SKU_LIST_JSON", (String) null);
        if (string2 == null || string2.length() == 0) {
            a.a.f(wf.a.a, "MemberViewModel", "Preload sku local cache", false, 4, (Object) null);
            H();
        } else {
            try {
                this.e.q((SkuData) com.blankj.utilcode.util.o.e(string2, com.blankj.utilcode.util.o.h(SkuData.class, new Type[0])));
                a.a.f(wf.a.a, "MemberViewModel", "Sku list mmkv cache exists", false, 4, (Object) null);
            } catch (Exception unused) {
                a.a.f(wf.a.a, "MemberViewModel", "No Sku list mmkv cache that needs to preload sku local cache", false, 4, (Object) null);
                H();
            }
        }
        r();
    }

    public final void J(SkuItem skuItem) {
        Intrinsics.h(skuItem, "skuItem");
        kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new MemberViewModel$redeemProduct$1(this, skuItem, null), 3, (Object) null);
    }

    public final void K(int i2, int i3) {
        a.C0069a.b(u(), null, i2, i3, 1, null).f(dg.d.a.c()).subscribe(new h());
    }

    public final void L() {
        io.reactivex.rxjava3.core.j.H(a.C0069a.c(u(), null, new InviteUserShareInfoReq(null, "WhatsApp", null, 5, null), 1, null), a.C0069a.c(u(), null, new InviteUserShareInfoReq(null, "Telegram", null, 5, null), 1, null), a.C0069a.c(u(), null, new InviteUserShareInfoReq(null, "CopyLink", null, 5, null), 1, null), i.a).f(dg.d.a.c()).B(new j(), new k());
    }

    public final void M(int i2) {
        a.C0069a.l(u(), null, null, 3, null).f(dg.d.a.c()).subscribe(new l(i2));
    }

    public final void N(int i2, String str, int i3, int i4) {
        Intrinsics.h(str, "rewardId");
        a.C0069a.i(u(), null, str, 1, null).f(dg.d.a.c()).subscribe(new m(i2, str, i3, i4));
    }

    public final void q() {
        io.reactivex.rxjava3.disposables.c cVar;
        io.reactivex.rxjava3.disposables.c cVar2 = this.m;
        if (cVar2 != null && !cVar2.isDisposed() && (cVar = this.m) != null) {
            cVar.dispose();
        }
        a.C0069a.e(u(), null, 1, null).v(ey.a.c()).h(b.a).f(dg.d.a.c()).subscribe(new c());
    }

    public final void r() {
        im.b w = w();
        if (w != null) {
            w.p(new d());
        }
    }

    public final void s() {
        io.reactivex.rxjava3.disposables.c cVar;
        io.reactivex.rxjava3.disposables.c cVar2 = this.n;
        if (cVar2 != null && !cVar2.isDisposed() && (cVar = this.n) != null) {
            cVar.dispose();
        }
        a.C0069a.h(u(), null, 1, null).v(ey.a.c()).x(e.a).h(f.a).f(dg.d.a.c()).subscribe(new g());
    }

    public final LiveData t() {
        return this.j;
    }

    public final LiveData v() {
        return this.d;
    }

    public final LiveData x() {
        return this.f;
    }

    public final LiveData y() {
        return this.k;
    }

    public final SkuData z() {
        return (SkuData) this.e.f();
    }
}
