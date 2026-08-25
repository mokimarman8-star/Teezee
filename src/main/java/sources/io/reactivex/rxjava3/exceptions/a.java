package io.reactivex.rxjava3.exceptions;

import io.reactivex.rxjava3.internal.util.ExceptionHelper;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a {
    public static RuntimeException a(Throwable th) {
        throw ExceptionHelper.g(th);
    }

    public static void b(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
