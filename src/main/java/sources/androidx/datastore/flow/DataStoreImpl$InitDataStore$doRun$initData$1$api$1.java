package androidx.datastore.flow;

import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.sync.a;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class DataStoreImpl$InitDataStore$doRun$initData$1$api$1 implements l {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f7432a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref.BooleanRef f7433b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f7434c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ DataStoreImpl f7435d;

    DataStoreImpl$InitDataStore$doRun$initData$1$api$1(a aVar, Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef, DataStoreImpl dataStoreImpl) {
        this.f7432a = aVar;
        this.f7433b = booleanRef;
        this.f7434c = objectRef;
        this.f7435d = dataStoreImpl;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:27:0x0052, B:28:0x00b2, B:30:0x00ba), top: B:26:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a A[Catch: all -> 0x00d8, TRY_LEAVE, TryCatch #1 {all -> 0x00d8, blocks: (B:40:0x0096, B:42:0x009a, B:46:0x00db, B:47:0x00e2), top: B:39:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00db A[Catch: all -> 0x00d8, TRY_ENTER, TryCatch #1 {all -> 0x00d8, blocks: (B:40:0x0096, B:42:0x009a, B:46:0x00db, B:47:0x00e2), top: B:39:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // androidx.datastore.flow.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(Function2 function2, Continuation continuation) {
        DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1;
        int i5;
        a aVar;
        DataStoreImpl dataStoreImpl;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef objectRef;
        a aVar2;
        a aVar3;
        DataStoreImpl dataStoreImpl2;
        Object obj;
        Ref.ObjectRef objectRef2;
        try {
            if (continuation instanceof DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) {
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 = (DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) continuation;
                int i6 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label;
                if ((i6 & EditorInfoCompat.IME_FLAG_FORCE_ASCII) != 0) {
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = i6 - EditorInfoCompat.IME_FLAG_FORCE_ASCII;
                    Object obj2 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.result;
                    Object f5 = IntrinsicsKt.f();
                    i5 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label;
                    if (i5 != 0) {
                        ResultKt.b(obj2);
                        aVar = this.f7432a;
                        Ref.BooleanRef booleanRef2 = this.f7433b;
                        Ref.ObjectRef objectRef3 = this.f7434c;
                        dataStoreImpl = this.f7435d;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = function2;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = aVar;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = booleanRef2;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3 = objectRef3;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4 = dataStoreImpl;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 1;
                        if (aVar.f((Object) null, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) == f5) {
                            return f5;
                        }
                        booleanRef = booleanRef2;
                        objectRef = objectRef3;
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                if (i5 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                obj = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
                                objectRef2 = (Ref.ObjectRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
                                aVar2 = (a) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
                                try {
                                    ResultKt.b(obj2);
                                    objectRef2.element = obj;
                                    objectRef = objectRef2;
                                    Object obj3 = objectRef.element;
                                    aVar2.unlock((Object) null);
                                    return obj3;
                                } catch (Throwable th) {
                                    th = th;
                                    aVar2.unlock((Object) null);
                                    throw th;
                                }
                            }
                            dataStoreImpl2 = (DataStoreImpl) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
                            objectRef = (Ref.ObjectRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
                            aVar3 = (a) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
                            try {
                                ResultKt.b(obj2);
                                if (!Intrinsics.c(obj2, objectRef.element)) {
                                    aVar2 = aVar3;
                                    Object obj32 = objectRef.element;
                                    aVar2.unlock((Object) null);
                                    return obj32;
                                }
                                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = aVar3;
                                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = objectRef;
                                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = obj2;
                                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 3;
                                if (dataStoreImpl2.B(obj2, false, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) == f5) {
                                    return f5;
                                }
                                obj = obj2;
                                objectRef2 = objectRef;
                                aVar2 = aVar3;
                                objectRef2.element = obj;
                                objectRef = objectRef2;
                                Object obj322 = objectRef.element;
                                aVar2.unlock((Object) null);
                                return obj322;
                            } catch (Throwable th2) {
                                th = th2;
                                aVar2 = aVar3;
                                aVar2.unlock((Object) null);
                                throw th;
                            }
                        }
                        DataStoreImpl dataStoreImpl3 = (DataStoreImpl) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4;
                        objectRef = (Ref.ObjectRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3;
                        booleanRef = (Ref.BooleanRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
                        a aVar4 = (a) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
                        Function2 function22 = (Function2) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
                        ResultKt.b(obj2);
                        aVar = aVar4;
                        dataStoreImpl = dataStoreImpl3;
                        function2 = function22;
                    }
                    if (!booleanRef.element) {
                        throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
                    }
                    Object obj4 = objectRef.element;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = aVar;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = objectRef;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = dataStoreImpl;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3 = null;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4 = null;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 2;
                    Object invoke = function2.invoke(obj4, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1);
                    if (invoke == f5) {
                        return f5;
                    }
                    aVar3 = aVar;
                    obj2 = invoke;
                    dataStoreImpl2 = dataStoreImpl;
                    if (!Intrinsics.c(obj2, objectRef.element)) {
                    }
                }
            }
            if (!booleanRef.element) {
            }
        } catch (Throwable th3) {
            th = th3;
            aVar2 = aVar;
            aVar2.unlock((Object) null);
            throw th;
        }
        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 = new DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1(this, continuation);
        Object obj22 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.result;
        Object f52 = IntrinsicsKt.f();
        i5 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label;
        if (i5 != 0) {
        }
    }
}
