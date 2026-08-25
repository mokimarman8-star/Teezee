package com.google.firebase.datastorage;

import androidx.datastore.core.g;
import androidx.datastore.preferences.core.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"T", "Lkotlinx/coroutines/n0;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.google.firebase.datastorage.JavaDataStorage$getSync$1", f = "JavaDataStorage.kt", l = {104}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class JavaDataStorage$getSync$1 extends SuspendLambda implements Function2<n0, Continuation<Object>, Object> {
    final /* synthetic */ Object $defaultValue;
    final /* synthetic */ c.a $key;
    int label;
    final /* synthetic */ JavaDataStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JavaDataStorage$getSync$1(JavaDataStorage javaDataStorage, c.a aVar, Object obj, Continuation<? super JavaDataStorage$getSync$1> continuation) {
        super(2, continuation);
        this.this$0 = javaDataStorage;
        this.$key = aVar;
        this.$defaultValue = obj;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new JavaDataStorage$getSync$1(this.this$0, this.$key, this.$defaultValue, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<Object> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        g gVar;
        Object b;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            gVar = this.this$0.e;
            kotlinx.coroutines.flow.a data = gVar.getData();
            this.label = 1;
            obj = kotlinx.coroutines.flow.c.q(data, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        androidx.datastore.preferences.core.c cVar = (androidx.datastore.preferences.core.c) obj;
        return (cVar == null || (b = cVar.b(this.$key)) == null) ? this.$defaultValue : b;
    }
}
