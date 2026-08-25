package androidx.datastore.flow;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface t {
    Object a();

    Object b(Object obj, OutputStream outputStream, Continuation continuation);

    Object c(InputStream inputStream, Continuation continuation);
}
