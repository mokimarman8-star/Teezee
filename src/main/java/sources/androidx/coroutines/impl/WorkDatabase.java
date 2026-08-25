package androidx.coroutines.impl;

import android.content.Context;
import androidx.room.RoomDatabase;
import j4.b;
import j4.e;
import j4.g;
import j4.j;
import j4.o;
import j4.r;
import j4.v;
import j4.z;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Landroidx/work/impl/WorkDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lj4/v;", "n0", "()Lj4/v;", "Lj4/b;", "h0", "()Lj4/b;", "Lj4/z;", "o0", "()Lj4/z;", "Lj4/j;", "k0", "()Lj4/j;", "Lj4/o;", "l0", "()Lj4/o;", "Lj4/r;", "m0", "()Lj4/r;", "Lj4/e;", "i0", "()Lj4/e;", "Lj4/g;", "j0", "()Lj4/g;", "p", "a", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class WorkDatabase extends RoomDatabase {
    public static final a p = new a((DefaultConstructorMarker) null);

    public static final WorkDatabase g0(Context context, Executor executor, boolean z) {
        return p.b(context, executor, z);
    }

    public abstract b h0();

    public abstract e i0();

    public abstract g j0();

    public abstract j k0();

    public abstract o l0();

    public abstract r m0();

    public abstract v n0();

    public abstract z o0();
}
