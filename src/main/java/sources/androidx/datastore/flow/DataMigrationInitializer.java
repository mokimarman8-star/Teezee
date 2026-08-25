package androidx.datastore.flow;

import androidx.core.view.inputmethod.EditorInfoCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class DataMigrationInitializer {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f7414a = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0088 -> B:13:0x006b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008b -> B:13:0x006b). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object c(List list, l lVar, Continuation continuation) {
            DataMigrationInitializer$Companion$runMigrations$1 dataMigrationInitializer$Companion$runMigrations$1;
            int i5;
            List list2;
            Ref.ObjectRef objectRef;
            Iterator it;
            Throwable th;
            if (continuation instanceof DataMigrationInitializer$Companion$runMigrations$1) {
                dataMigrationInitializer$Companion$runMigrations$1 = (DataMigrationInitializer$Companion$runMigrations$1) continuation;
                int i6 = dataMigrationInitializer$Companion$runMigrations$1.label;
                if ((i6 & EditorInfoCompat.IME_FLAG_FORCE_ASCII) != 0) {
                    dataMigrationInitializer$Companion$runMigrations$1.label = i6 - EditorInfoCompat.IME_FLAG_FORCE_ASCII;
                    Object obj = dataMigrationInitializer$Companion$runMigrations$1.result;
                    Object f5 = IntrinsicsKt.f();
                    i5 = dataMigrationInitializer$Companion$runMigrations$1.label;
                    if (i5 != 0) {
                        ResultKt.b(obj);
                        ArrayList arrayList = new ArrayList();
                        DataMigrationInitializer$Companion$runMigrations$2 dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2(list, arrayList, null);
                        dataMigrationInitializer$Companion$runMigrations$1.L$0 = arrayList;
                        dataMigrationInitializer$Companion$runMigrations$1.label = 1;
                        if (lVar.a(dataMigrationInitializer$Companion$runMigrations$2, dataMigrationInitializer$Companion$runMigrations$1) == f5) {
                            return f5;
                        }
                        list2 = arrayList;
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            it = (Iterator) dataMigrationInitializer$Companion$runMigrations$1.L$1;
                            objectRef = (Ref.ObjectRef) dataMigrationInitializer$Companion$runMigrations$1.L$0;
                            try {
                                ResultKt.b(obj);
                            } catch (Throwable th2) {
                                Object obj2 = objectRef.element;
                                if (obj2 == null) {
                                    objectRef.element = th2;
                                } else {
                                    Intrinsics.e(obj2);
                                    ExceptionsKt.a((Throwable) obj2, th2);
                                }
                            }
                            while (it.hasNext()) {
                                Function1 function1 = (Function1) it.next();
                                dataMigrationInitializer$Companion$runMigrations$1.L$0 = objectRef;
                                dataMigrationInitializer$Companion$runMigrations$1.L$1 = it;
                                dataMigrationInitializer$Companion$runMigrations$1.label = 2;
                                if (function1.invoke(dataMigrationInitializer$Companion$runMigrations$1) == f5) {
                                    return f5;
                                }
                            }
                            th = (Throwable) objectRef.element;
                            if (th == null) {
                                return Unit.a;
                            }
                            throw th;
                        }
                        list2 = (List) dataMigrationInitializer$Companion$runMigrations$1.L$0;
                        ResultKt.b(obj);
                    }
                    objectRef = new Ref.ObjectRef();
                    it = list2.iterator();
                    while (it.hasNext()) {
                    }
                    th = (Throwable) objectRef.element;
                    if (th == null) {
                    }
                }
            }
            dataMigrationInitializer$Companion$runMigrations$1 = new DataMigrationInitializer$Companion$runMigrations$1(this, continuation);
            Object obj3 = dataMigrationInitializer$Companion$runMigrations$1.result;
            Object f52 = IntrinsicsKt.f();
            i5 = dataMigrationInitializer$Companion$runMigrations$1.label;
            if (i5 != 0) {
            }
            objectRef = new Ref.ObjectRef();
            it = list2.iterator();
            while (it.hasNext()) {
            }
            th = (Throwable) objectRef.element;
            if (th == null) {
            }
        }

        public final Function2 b(List list) {
            Intrinsics.h(list, "migrations");
            return new DataMigrationInitializer$Companion$getInitializer$1(list, null);
        }
    }
}
