package z3;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.Closeable;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface d extends Closeable {
    void A();

    List D();

    void E(String str);

    void I();

    void J(String str, Object[] objArr);

    void K();

    void L();

    void U(int i5);

    h Y(String str);

    Cursor a0(g gVar, CancellationSignal cancellationSignal);

    Cursor b0(g gVar);

    void c0();

    String getPath();

    int getVersion();

    int i0(String str, int i5, ContentValues contentValues, String str2, Object[] objArr);

    boolean isOpen();

    Cursor m0(String str);

    long n0(String str, int i5, ContentValues contentValues);

    boolean v0();

    boolean z0();
}
