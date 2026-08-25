package a4;

import android.database.sqlite.SQLiteStatement;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class j extends i implements z3.h {

    /* renamed from: b, reason: collision with root package name */
    private final SQLiteStatement f73b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        Intrinsics.h(sQLiteStatement, "delegate");
        this.f73b = sQLiteStatement;
    }

    @Override // z3.h
    public int F() {
        return this.f73b.executeUpdateDelete();
    }

    @Override // z3.h
    public long R() {
        return this.f73b.executeInsert();
    }

    @Override // z3.h
    public void execute() {
        this.f73b.execute();
    }
}
