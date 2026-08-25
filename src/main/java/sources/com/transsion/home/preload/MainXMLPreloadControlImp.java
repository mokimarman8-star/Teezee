package com.transsion.home.preload;

import android.app.Activity;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class MainXMLPreloadControlImp implements b {
    private View a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.home.preload.MainXMLPreloadControlImp$1", f = "MainXMLPreloadControlImp.kt", l = {51, 58, ASTNode.INVERT}, m = "invokeSuspend")
    /* renamed from: com.transsion.home.preload.MainXMLPreloadControlImp$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = MainXMLPreloadControlImp.this.new AnonymousClass1(this.$activity, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0132 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0133  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 316
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.preload.MainXMLPreloadControlImp.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public MainXMLPreloadControlImp(Activity activity) {
        Intrinsics.h(activity, "activity");
        i.d(o0.a(y0.a()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(activity, null), 3, (Object) null);
    }

    public boolean a() {
        return this.m;
    }

    public boolean b() {
        return this.j;
    }

    public View c() {
        this.m = true;
        return this.f;
    }

    public View d() {
        this.j = true;
        return this.e;
    }

    public boolean e() {
        return this.g;
    }

    public View f() {
        this.g = true;
        return this.a;
    }

    public void reset() {
        this.a = null;
        this.d = null;
        this.e = null;
        this.b = null;
        this.c = null;
        this.f = null;
        this.g = false;
        this.k = false;
        this.l = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.m = false;
    }
}
