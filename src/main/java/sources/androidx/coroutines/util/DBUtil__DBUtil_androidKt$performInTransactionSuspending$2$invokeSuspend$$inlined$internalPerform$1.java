package androidx.coroutines.util;

import androidx.coroutines.Transactor;
import androidx.coroutines.p0;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "R", "transactor", "Landroidx/room/Transactor;", "androidx/room/util/DBUtil__DBUtilKt$internalPerform$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1", f = "DBUtil.android.kt", l = {56, 57, 59, 60, 67}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 extends SuspendLambda implements Function2<Transactor, Continuation<Object>, Object> {
    final /* synthetic */ Function1 $block$inlined;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ boolean $isReadOnly;
    final /* synthetic */ RoomDatabase $this_internalPerform;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¨\u0006\u0002"}, d2 = {"R", "Landroidx/room/p0;", "androidx/room/util/DBUtil__DBUtilKt$internalPerform$2$result$1", "<anonymous>"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1$1", f = "DBUtil.android.kt", l = {60}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<p0, Continuation<Object>, Object> {
        final /* synthetic */ Function1 $block$inlined;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Continuation continuation, Function1 function1) {
            super(2, continuation);
            this.$block$inlined = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation, this.$block$inlined);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(p0 p0Var, Continuation<Object> continuation) {
            return create(p0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = IntrinsicsKt.f();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.b(obj);
                Function1 function1 = this.$block$inlined;
                this.label = 1;
                InlineMarker.c(6);
                obj = function1.invoke(this);
                InlineMarker.c(7);
                if (obj == f5) {
                    return f5;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return obj;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1(boolean z5, boolean z6, RoomDatabase roomDatabase, Continuation continuation, Function1 function1) {
        super(2, continuation);
        this.$inTransaction = z5;
        this.$isReadOnly = z6;
        this.$this_internalPerform = roomDatabase;
        this.$block$inlined = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1(this.$inTransaction, this.$isReadOnly, this.$this_internalPerform, continuation, this.$block$inlined);
        dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1.L$0 = obj;
        return dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1;
    }

    public final Object invoke(Transactor transactor, Continuation<Object> continuation) {
        return create(transactor, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Transactor.SQLiteTransactionType sQLiteTransactionType;
        Transactor transactor;
        Transactor transactor2;
        Transactor.SQLiteTransactionType sQLiteTransactionType2;
        Object obj2;
        Object f5 = IntrinsicsKt.f();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.b(obj);
            Transactor transactor3 = (Transactor) this.L$0;
            if (!this.$inTransaction) {
                Function1 function1 = this.$block$inlined;
                this.label = 5;
                InlineMarker.c(6);
                Object invoke = function1.invoke(this);
                InlineMarker.c(7);
                return invoke == f5 ? f5 : invoke;
            }
            boolean z5 = this.$isReadOnly;
            sQLiteTransactionType = z5 ? Transactor.SQLiteTransactionType.DEFERRED : Transactor.SQLiteTransactionType.IMMEDIATE;
            if (z5) {
                transactor = transactor3;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(null, this.$block$inlined);
                this.L$0 = transactor;
                this.L$1 = null;
                this.label = 3;
                obj = transactor.a(sQLiteTransactionType, anonymousClass1, this);
                if (obj == f5) {
                }
                if (!this.$isReadOnly) {
                }
            } else {
                this.L$0 = transactor3;
                this.L$1 = sQLiteTransactionType;
                this.label = 1;
                Object b5 = transactor3.b(this);
                if (b5 == f5) {
                    return f5;
                }
                Transactor.SQLiteTransactionType sQLiteTransactionType3 = sQLiteTransactionType;
                transactor2 = transactor3;
                obj = b5;
                sQLiteTransactionType2 = sQLiteTransactionType3;
            }
        } else if (i5 == 1) {
            sQLiteTransactionType2 = (Transactor.SQLiteTransactionType) this.L$1;
            transactor2 = (Transactor) this.L$0;
            ResultKt.b(obj);
        } else {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        return obj;
                    }
                    obj2 = this.L$0;
                    ResultKt.b(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        this.$this_internalPerform.y().w();
                    }
                    return obj2;
                }
                transactor = (Transactor) this.L$0;
                ResultKt.b(obj);
                if (!this.$isReadOnly) {
                    return obj;
                }
                this.L$0 = obj;
                this.label = 4;
                Object b6 = transactor.b(this);
                if (b6 == f5) {
                    return f5;
                }
                obj2 = obj;
                obj = b6;
                if (!((Boolean) obj).booleanValue()) {
                }
                return obj2;
            }
            sQLiteTransactionType2 = (Transactor.SQLiteTransactionType) this.L$1;
            transactor2 = (Transactor) this.L$0;
            ResultKt.b(obj);
            Transactor transactor4 = transactor2;
            sQLiteTransactionType = sQLiteTransactionType2;
            transactor = transactor4;
            AnonymousClass1 anonymousClass12 = new AnonymousClass1(null, this.$block$inlined);
            this.L$0 = transactor;
            this.L$1 = null;
            this.label = 3;
            obj = transactor.a(sQLiteTransactionType, anonymousClass12, this);
            if (obj == f5) {
                return f5;
            }
            if (!this.$isReadOnly) {
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            InvalidationTracker y5 = this.$this_internalPerform.y();
            this.L$0 = transactor2;
            this.L$1 = sQLiteTransactionType2;
            this.label = 2;
            if (y5.C(this) == f5) {
                return f5;
            }
        }
        Transactor transactor42 = transactor2;
        sQLiteTransactionType = sQLiteTransactionType2;
        transactor = transactor42;
        AnonymousClass1 anonymousClass122 = new AnonymousClass1(null, this.$block$inlined);
        this.L$0 = transactor;
        this.L$1 = null;
        this.label = 3;
        obj = transactor.a(sQLiteTransactionType, anonymousClass122, this);
        if (obj == f5) {
        }
        if (!this.$isReadOnly) {
        }
    }
}
