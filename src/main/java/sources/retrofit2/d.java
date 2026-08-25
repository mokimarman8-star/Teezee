package retrofit2;

import okhttp3.Request;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public interface d<T> extends Cloneable {
    void cancel();

    /* renamed from: clone */
    d mo105clone();

    j0 execute();

    void f(f fVar);

    boolean isCanceled();

    Request request();
}
