package b;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f14161a = "_COROUTINE";

    /* JADX INFO: Access modifiers changed from: private */
    public static final StackTraceElement b(Throwable th, String str) {
        StackTraceElement stackTraceElement = th.getStackTrace()[0];
        return new StackTraceElement(f14161a + '.' + str, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }
}
