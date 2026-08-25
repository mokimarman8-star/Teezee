package androidx.datastore.flow;

import androidx.core.view.inputmethod.EditorInfoCompat;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class FileReadScope implements s {

    /* renamed from: a, reason: collision with root package name */
    private final File f7437a;

    /* renamed from: b, reason: collision with root package name */
    private final t f7438b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f7439c;

    public FileReadScope(File file, t tVar) {
        Intrinsics.h(file, "file");
        Intrinsics.h(tVar, "serializer");
        this.f7437a = file;
        this.f7438b = tVar;
        this.f7439c = new AtomicBoolean(false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(6:5|6|7|(1:(1:(5:11|12|13|14|15)(2:25|26))(3:27|28|29))(6:40|41|42|43|44|(1:46)(1:47))|30|31))|67|6|7|(0)(0)|30|31|(3:(1:36)|(1:21)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x006f, code lost:
    
        r7 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [androidx.datastore.core.FileReadScope] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object i(FileReadScope fileReadScope, Continuation continuation) {
        FileReadScope$readData$1 fileReadScope$readData$1;
        ?? r22;
        Throwable th;
        Closeable closeable;
        Closeable closeable2;
        Throwable th2;
        if (continuation instanceof FileReadScope$readData$1) {
            fileReadScope$readData$1 = (FileReadScope$readData$1) continuation;
            int i5 = fileReadScope$readData$1.label;
            if ((i5 & EditorInfoCompat.IME_FLAG_FORCE_ASCII) != 0) {
                fileReadScope$readData$1.label = i5 - EditorInfoCompat.IME_FLAG_FORCE_ASCII;
                Object obj = fileReadScope$readData$1.result;
                Object f5 = IntrinsicsKt.f();
                r22 = fileReadScope$readData$1.label;
                if (r22 != 0) {
                    ResultKt.b(obj);
                    fileReadScope.f();
                    try {
                        FileInputStream fileInputStream = new FileInputStream(fileReadScope.f7437a);
                        try {
                            t tVar = fileReadScope.f7438b;
                            fileReadScope$readData$1.L$0 = fileReadScope;
                            fileReadScope$readData$1.L$1 = fileInputStream;
                            fileReadScope$readData$1.label = 1;
                            Object c5 = tVar.c(fileInputStream, fileReadScope$readData$1);
                            if (c5 == f5) {
                                return f5;
                            }
                            closeable2 = fileInputStream;
                            obj = c5;
                        } catch (Throwable th3) {
                            r22 = fileReadScope;
                            closeable2 = fileInputStream;
                            th2 = th3;
                            throw th;
                        }
                    } catch (FileNotFoundException unused) {
                        if (!fileReadScope.f7437a.exists()) {
                            return fileReadScope.f7438b.a();
                        }
                        FileInputStream fileInputStream2 = new FileInputStream(fileReadScope.f7437a);
                        try {
                            t tVar2 = fileReadScope.f7438b;
                            fileReadScope$readData$1.L$0 = fileInputStream2;
                            fileReadScope$readData$1.L$1 = null;
                            fileReadScope$readData$1.label = 2;
                            Object c6 = tVar2.c(fileInputStream2, fileReadScope$readData$1);
                            if (c6 == f5) {
                                return f5;
                            }
                            obj = c6;
                            closeable = fileInputStream2;
                            CloseableKt.a(closeable, (Throwable) null);
                            return obj;
                        } catch (Throwable th4) {
                            th = th4;
                            closeable = fileInputStream2;
                            throw th;
                        }
                    }
                } else {
                    if (r22 != 1) {
                        if (r22 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        closeable = (Closeable) fileReadScope$readData$1.L$0;
                        try {
                            ResultKt.b(obj);
                            CloseableKt.a(closeable, (Throwable) null);
                            return obj;
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    closeable2 = (Closeable) fileReadScope$readData$1.L$1;
                    r22 = (FileReadScope) fileReadScope$readData$1.L$0;
                    try {
                        ResultKt.b(obj);
                    } catch (Throwable th6) {
                        th2 = th6;
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                CloseableKt.a(closeable2, (Throwable) null);
                return obj;
            }
        }
        fileReadScope$readData$1 = new FileReadScope$readData$1(fileReadScope, continuation);
        Object obj2 = fileReadScope$readData$1.result;
        Object f52 = IntrinsicsKt.f();
        r22 = fileReadScope$readData$1.label;
        if (r22 != 0) {
        }
        CloseableKt.a(closeable2, (Throwable) null);
        return obj2;
    }

    @Override // androidx.datastore.flow.s
    public Object c(Continuation continuation) {
        return i(this, continuation);
    }

    @Override // androidx.datastore.flow.c
    public void close() {
        this.f7439c.set(true);
    }

    protected final void f() {
        if (this.f7439c.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    protected final File g() {
        return this.f7437a;
    }

    protected final t h() {
        return this.f7438b;
    }
}
