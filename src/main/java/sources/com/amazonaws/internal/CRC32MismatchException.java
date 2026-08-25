package com.amazonaws.internal;

import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class CRC32MismatchException extends IOException {
    private static final long serialVersionUID = 1;

    public CRC32MismatchException(String str) {
        super(str);
    }

    public CRC32MismatchException(String str, Throwable th) {
        super(str, th);
    }
}
