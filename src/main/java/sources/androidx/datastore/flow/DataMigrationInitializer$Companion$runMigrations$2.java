package androidx.datastore.flow;

import androidx.core.view.MotionEventCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H\u008a@"}, d2 = {"<anonymous>", "T", "startingData"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {MotionEventCompat.AXIS_GENERIC_13, MotionEventCompat.AXIS_GENERIC_15}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class DataMigrationInitializer$Companion$runMigrations$2 extends SuspendLambda implements Function2<Object, Continuation<Object>, Object> {
    final /* synthetic */ List<Function1<Continuation<? super Unit>, Object>> $cleanUps;
    final /* synthetic */ List<f> $migrations;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DataMigrationInitializer$Companion$runMigrations$2(List<? extends f> list, List<Function1<Continuation<? super Unit>, Object>> list2, Continuation<? super DataMigrationInitializer$Companion$runMigrations$2> continuation) {
        super(2, continuation);
        this.$migrations = list;
        this.$cleanUps = list2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DataMigrationInitializer$Companion$runMigrations$2 dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2(this.$migrations, this.$cleanUps, continuation);
        dataMigrationInitializer$Companion$runMigrations$2.L$0 = obj;
        return dataMigrationInitializer$Companion$runMigrations$2;
    }

    public final Object invoke(Object obj, Continuation<Object> continuation) {
        return create(obj, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List<Function1<Continuation<? super Unit>, Object>> list;
        Iterator it;
        f fVar;
        Iterator it2;
        Object obj2;
        Object f5 = IntrinsicsKt.f();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.b(obj);
            obj = this.L$0;
            List<f> list2 = this.$migrations;
            list = this.$cleanUps;
            it = list2.iterator();
        } else if (i5 == 1) {
            obj2 = this.L$3;
            f fVar2 = (f) this.L$2;
            it2 = (Iterator) this.L$1;
            List<Function1<Continuation<? super Unit>, Object>> list3 = (List) this.L$0;
            ResultKt.b(obj);
            fVar = fVar2;
            list = list3;
            if (((Boolean) obj).booleanValue()) {
                obj = obj2;
                it = it2;
            } else {
                list.add(new DataMigrationInitializer$Companion$runMigrations$2$1$1(fVar, null));
                this.L$0 = list;
                this.L$1 = it2;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 2;
                obj = fVar.c(obj2, this);
                if (obj == f5) {
                    return f5;
                }
                it = it2;
            }
        } else {
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$1;
            list = (List) this.L$0;
            ResultKt.b(obj);
        }
        if (!it.hasNext()) {
            f fVar3 = (f) it.next();
            this.L$0 = list;
            this.L$1 = it;
            this.L$2 = fVar3;
            this.L$3 = obj;
            this.label = 1;
            Object a5 = fVar3.a(obj, this);
            if (a5 == f5) {
                return f5;
            }
            Iterator it3 = it;
            obj2 = obj;
            obj = a5;
            fVar = fVar3;
            it2 = it3;
            if (((Boolean) obj).booleanValue()) {
            }
            if (!it.hasNext()) {
                return obj;
            }
        }
    }
}
