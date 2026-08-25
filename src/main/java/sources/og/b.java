package og;

import javax.security.auth.callback.Callback;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface b extends Callback {
    void a(String str);

    void b(String str, Throwable th);

    void onCompleted(String str);
}
