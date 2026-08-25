package org.chromium.net;

import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class CronetException extends IOException {
    protected CronetException(String str, Throwable th) {
        super(str, th);
    }
}
