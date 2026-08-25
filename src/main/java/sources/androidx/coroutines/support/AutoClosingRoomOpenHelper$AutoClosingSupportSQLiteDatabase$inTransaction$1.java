package androidx.coroutines.support;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import z3.d;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1 extends FunctionReferenceImpl implements Function1<d, Boolean> {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1() {
        super(1, d.class, "inTransaction", "inTransaction()Z", 0);
    }

    public final Boolean invoke(d dVar) {
        Intrinsics.h(dVar, "p0");
        return Boolean.valueOf(dVar.v0());
    }
}
