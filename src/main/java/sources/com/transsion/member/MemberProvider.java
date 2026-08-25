package com.transsion.member;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.o;
import com.google.gson.JsonObject;
import com.therouter.TheRouter;
import com.transsion.baseui.fragment.EmptyFragment;
import com.transsion.member.dialog.CheckMemberRightsLoadingDialog;
import com.transsion.member.dialog.ClaimMemberDialog;
import com.transsion.member.dialog.MemberGuideDialog;
import com.transsion.member.dialog.MemberMiddleStateDialog;
import com.transsion.member.dialog.PurchaseSucceedDialog;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberInfo;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.MemberTaskInfo;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.OpType;
import com.transsion.memberapi.TaskRewards;
import dg.d;
import fh.b;
import fm.a;
import hm.k;
import im.b;
import im.f;
import im.j;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kg.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.h1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.x0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class MemberProvider implements b {
    private volatile MemberDetail b;
    private volatile MemberTaskInfo c;
    private ClaimMemberDialog g;
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.member.z
        public final Object invoke() {
            a W;
            W = MemberProvider.W();
            return W;
        }
    });
    private final x0 d = i1.a((Object) null);
    private final x0 e = i1.a(Boolean.FALSE);
    private String f = "";

    public MemberProvider() {
        Object m34constructorimpl;
        String string = w.a.b().getString("MEMBER_JSON", null);
        if (string == null || string.length() == 0) {
            this.b = null;
        } else {
            try {
                this.b = (MemberDetail) o.d(string, MemberDetail.class);
            } catch (Exception unused) {
                this.b = null;
            }
        }
        String string2 = w.a.b().getString("MEMBER_TASK_JSON", null);
        if (string2 != null) {
            try {
                Result.Companion companion = Result.Companion;
                m34constructorimpl = Result.m34constructorimpl((MemberTaskInfo) o.d(string2, MemberTaskInfo.class));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m34constructorimpl = Result.m34constructorimpl(ResultKt.a(th));
            }
            this.c = (MemberTaskInfo) (Result.m40isFailureimpl(m34constructorimpl) ? null : m34constructorimpl);
        }
        if (z()) {
            ObserveLoginAction.c.a().j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(Function2 function2, String str, String str2) {
        if (function2 != null) {
            function2.invoke(str, str2);
        }
        b.a aVar = fh.b.a;
        if (str2 == null) {
            return Unit.a;
        }
        aVar.e(str2);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(MemberProvider memberProvider, Function0 function0, TaskRewards taskRewards) {
        memberProvider.d.setValue((Object) null);
        memberProvider.e.setValue(Boolean.FALSE);
        if (taskRewards != null && taskRewards.getTips() != null) {
            fh.b.a.e(taskRewards.getTips());
        }
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String T() {
        String simpleName = MemberProvider.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String U() {
        String format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date(Calendar.getInstance().getTimeInMillis() - 14400000));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    private final a V() {
        return (a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a W() {
        return (a) c.e.a().h(a.class);
    }

    @Override // im.b
    public void A(Function0 function0) {
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new MemberProvider$checkShowAdState$1(this, function0, null), 3, (Object) null);
    }

    @Override // im.b
    public int B() {
        return w.a.b().getInt("kv_parallel_download_task_num", 1);
    }

    @Override // im.b
    public void C(Activity activity, String str, String str2, j jVar) {
        Intrinsics.h(str, "title");
        Intrinsics.h(str2, "buttonTitle");
        PurchaseSucceedDialog purchaseSucceedDialog = new PurchaseSucceedDialog(str, str2, jVar);
        purchaseSucceedDialog.s0(jVar);
        purchaseSucceedDialog.t0(str);
        purchaseSucceedDialog.r0(str2);
        purchaseSucceedDialog.k0(activity, "PurchaseSucceedDialog");
    }

    @Override // im.b
    public void D(f fVar) {
        Intrinsics.h(fVar, "listener");
        ObserveLoginAction.c.a().e(fVar);
    }

    @Override // im.b
    public void E() {
        ClaimMemberDialog claimMemberDialog = this.g;
        if (claimMemberDialog != null) {
            claimMemberDialog.r0();
        }
        this.g = null;
    }

    @Override // im.b
    public h1 a() {
        return this.e;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|(2:3|(11:5|6|7|(1:(1:(3:11|12|13)(2:15|16))(2:17|18))(7:29|(1:31)(1:39)|32|(1:34)|35|36|(1:38))|19|20|(1:22)|23|(2:25|(1:27))|12|13))|42|6|7|(0)(0)|19|20|(0)|23|(0)|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x003f, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0092, code lost:
    
        r8 = kotlin.Result.Companion;
        r7 = kotlin.Result.m34constructorimpl(kotlin.ResultKt.a(r7));
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Override // im.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(com.transsion.memberapi.MemberSceneType r7, java.lang.Integer r8, kotlin.jvm.functions.Function1 r9, kotlin.coroutines.Continuation r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.transsion.member.MemberProvider$checkMemberRights$1
            if (r0 == 0) goto L13
            r0 = r10
            com.transsion.member.MemberProvider$checkMemberRights$1 r0 = (com.transsion.member.MemberProvider$checkMemberRights$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.member.MemberProvider$checkMemberRights$1 r0 = new com.transsion.member.MemberProvider$checkMemberRights$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L41
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.b(r10)
            goto Ld9
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            java.lang.Object r7 = r0.L$0
            r9 = r7
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L3f
            goto L8b
        L3f:
            r7 = move-exception
            goto L92
        L41:
            kotlin.ResultKt.b(r10)
            com.google.gson.JsonObject r10 = new com.google.gson.JsonObject
            r10.<init>()
            if (r7 == 0) goto L50
            java.lang.String r7 = r7.getValue()
            goto L51
        L50:
            r7 = r5
        L51:
            java.lang.String r2 = "sceneType"
            r10.addProperty(r2, r7)
            if (r8 == 0) goto L5d
            java.lang.String r7 = "resolution"
            r10.addProperty(r7, r8)
        L5d:
            okhttp3.RequestBody$Companion r7 = okhttp3.RequestBody.Companion
            java.lang.String r8 = r10.toString()
            java.lang.String r10 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.g(r8, r10)
            okhttp3.MediaType$Companion r10 = okhttp3.MediaType.Companion
            java.lang.String r2 = "application/json"
            okhttp3.MediaType r10 = r10.parse(r2)
            okhttp3.RequestBody r7 = r7.create(r8, r10)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L3f
            fm.a r8 = r6.V()     // Catch: java.lang.Throwable -> L3f
            gg.a$a r10 = gg.a.a     // Catch: java.lang.Throwable -> L3f
            java.lang.String r10 = r10.a()     // Catch: java.lang.Throwable -> L3f
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L3f
            r0.label = r4     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r10 = r8.m(r10, r7, r0)     // Catch: java.lang.Throwable -> L3f
            if (r10 != r1) goto L8b
            return r1
        L8b:
            com.tn.lib.net.bean.BaseDto r10 = (com.tn.lib.net.bean.BaseDto) r10     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r7 = kotlin.Result.m34constructorimpl(r10)     // Catch: java.lang.Throwable -> L3f
            goto L9c
        L92:
            kotlin.Result$Companion r8 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.ResultKt.a(r7)
            java.lang.Object r7 = kotlin.Result.m34constructorimpl(r7)
        L9c:
            java.lang.Throwable r8 = kotlin.Result.m37exceptionOrNullimpl(r7)
            if (r8 != 0) goto La3
            goto Lc1
        La3:
            com.transsion.member.a r7 = com.transsion.member.a.a
            java.lang.String r10 = r6.T()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            java.lang.String r10 = " --> checkMemberRights() ---> getOrElse() --> it = "
            r2.append(r10)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r7.b(r8)
            r7 = r5
        Lc1:
            com.tn.lib.net.bean.BaseDto r7 = (com.tn.lib.net.bean.BaseDto) r7
            if (r9 == 0) goto Ld9
            kotlinx.coroutines.a2 r8 = kotlinx.coroutines.y0.c()
            com.transsion.member.MemberProvider$checkMemberRights$2$1 r10 = new com.transsion.member.MemberProvider$checkMemberRights$2$1
            r10.<init>(r9, r7, r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.i.g(r8, r10, r0)
            if (r7 != r1) goto Ld9
            return r1
        Ld9:
            kotlin.Unit r7 = kotlin.Unit.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.MemberProvider.b(com.transsion.memberapi.MemberSceneType, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // im.b
    public boolean c() {
        w.a.b().getBoolean("kv_is_pay_enable_member", false);
        return true;
    }

    @Override // im.b
    public void d(MemberSceneType memberSceneType, Integer num, im.a aVar) {
        Intrinsics.h(memberSceneType, "sceneType");
        CheckMemberRightsLoadingDialog checkMemberRightsLoadingDialog = new CheckMemberRightsLoadingDialog();
        checkMemberRightsLoadingDialog.u0(aVar);
        checkMemberRightsLoadingDialog.v0(memberSceneType, num);
        checkMemberRightsLoadingDialog.k0(com.blankj.utilcode.util.a.b(), "CheckMemberRightsDialog");
    }

    @Override // im.b
    public boolean e() {
        w.a.b().getBoolean("kv_is_skip_ad", false);
        return true;
    }

    @Override // im.b
    public void f() {
        a.a.a(V(), (String) null, 1, (Object) null).f(d.a.c()).subscribe(new b(this));
    }

    @Override // im.b
    public void g(Integer num, im.a aVar) {
        a.a.a(T() + " --> showCheckResolutionRightsDialog() --> 这里不需要判断了，统一下载的时候会有校验 ");
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // im.b
    public void h() {
        k.a.Y();
    }

    @Override // im.b
    public boolean i(Fragment fragment) {
        return fragment instanceof MemberFragment;
    }

    @Override // im.b
    public void j(MemberDetail memberDetail) {
        this.b = memberDetail;
    }

    @Override // im.b
    public void k(MemberTaskItem memberTaskItem, Function2 function2, Function1 function1) {
        Intrinsics.h(memberTaskItem, "item");
        JSONObject jSONObject = new JSONObject();
        a.a.a("claimTaskReward taskId: " + memberTaskItem.getTaskId());
        Object taskId = memberTaskItem.getTaskId();
        if (taskId == null) {
            taskId = 0;
        }
        jSONObject.put("taskId", taskId);
        RequestBody.Companion companion = RequestBody.Companion;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.g(jSONObject2, "toString(...)");
        a.a.j(V(), (String) null, companion.create(jSONObject2, MediaType.Companion.parse("application/json")), 1, (Object) null).f(d.a.c()).subscribe(new a(function2, function1));
    }

    @Override // im.b
    public MemberDetail l() {
        return this.b;
    }

    @Override // im.b
    public boolean m() {
        MemberInfo memberInfo;
        MemberDetail memberDetail = this.b;
        if (memberDetail == null || (memberInfo = memberDetail.getMemberInfo()) == null) {
            return true;
        }
        return memberInfo.isActive();
    }

    @Override // im.b
    public void n(OpType opType, Function1 function1) {
        Intrinsics.h(opType, "opType");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("opType", opType.getValue());
        RequestBody.Companion companion = RequestBody.Companion;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        V().h(gg.a.a.a(), companion.create(jsonElement, MediaType.Companion.parse("application/json"))).f(d.a.c()).subscribe(new h(function1));
    }

    @Override // im.b
    public void o() {
        V().k(gg.a.a.a()).f(d.a.c()).subscribe(new e(this));
    }

    @Override // im.b
    public void p(im.d dVar) {
        a.a.f(V(), (String) null, 1, (Object) null).f(d.a.c()).h(new f(this)).subscribe(new g(this, dVar));
    }

    @Override // im.b
    public void q() {
        k.a.a0();
    }

    @Override // im.b
    public Fragment r() {
        Fragment k = TheRouter.c("/member/MemberFragment").k();
        return k == null ? new EmptyFragment() : k;
    }

    @Override // im.b
    public void s(im.d dVar) {
        a.a.d(V(), (String) null, 1, (Object) null).f(d.a.c()).h(c.a).subscribe(new d(dVar));
    }

    @Override // im.b
    public void t() {
        k.a.W();
    }

    @Override // im.b
    public void u(Activity activity, MemberSource memberSource, im.c cVar, boolean z, String str) {
        Intrinsics.h(str, "sceneId");
        if (z()) {
            MemberMiddleStateDialog a = MemberMiddleStateDialog.h.a(z);
            a.p0(cVar);
            a.q0(memberSource);
            a.r0(str);
            a.k0(activity, "MemberMiddleStateDialog");
            return;
        }
        a.a.b(T() + " --> startMemberPage() --> 当前不开发会员功能");
    }

    @Override // im.b
    public void v(f fVar) {
        Intrinsics.h(fVar, "listener");
        ObserveLoginAction.c.a().n(fVar);
    }

    @Override // im.b
    public void w(float f) {
        a.a.a("checkMemberShipShow data:" + this.d.getValue());
        try {
            if (this.d.getValue() != null) {
                ClaimMemberDialog claimMemberDialog = new ClaimMemberDialog();
                claimMemberDialog.y0((MemberTaskItem) this.d.getValue());
                claimMemberDialog.z0(a0.a(f));
                claimMemberDialog.k0(com.blankj.utilcode.util.a.b(), "ClaimMemberDialog");
                this.g = claimMemberDialog;
            }
        } catch (Exception e) {
            a.a.b("checkMemberShipShow error:" + e.getMessage());
        }
    }

    @Override // im.b
    public void x(Activity activity, MemberSource memberSource, MemberCheckResult memberCheckResult, im.c cVar) {
        Intrinsics.h(memberSource, "source");
        Intrinsics.h(cVar, "callback");
        MemberGuideDialog memberGuideDialog = new MemberGuideDialog();
        memberGuideDialog.r0(cVar);
        memberGuideDialog.w0(memberSource);
        memberGuideDialog.v0(memberCheckResult);
        memberGuideDialog.k0(activity, "MemberGuideDialog");
    }

    @Override // im.b
    public void y(Function2 function2, Function0 function0) {
        MemberTaskItem memberTaskItem = (MemberTaskItem) this.d.getValue();
        if (memberTaskItem != null) {
            k(memberTaskItem, new a0(function2), new b0(this, function0));
        }
    }

    @Override // im.b
    public boolean z() {
        w.a.b().getBoolean("kv_is_enable_member", true);
        return true;
    }
}
