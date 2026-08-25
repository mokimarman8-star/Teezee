package com.google.api;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum BackendRule$AuthenticationCase {
    JWT_AUDIENCE(7),
    DISABLE_AUTH(8),
    AUTHENTICATION_NOT_SET(0);

    private final int value;

    BackendRule$AuthenticationCase(int i) {
        this.value = i;
    }

    public static BackendRule$AuthenticationCase forNumber(int i) {
        if (i == 0) {
            return AUTHENTICATION_NOT_SET;
        }
        if (i == 7) {
            return JWT_AUDIENCE;
        }
        if (i != 8) {
            return null;
        }
        return DISABLE_AUTH;
    }

    @Deprecated
    public static BackendRule$AuthenticationCase valueOf(int i) {
        return forNumber(i);
    }

    public int getNumber() {
        return this.value;
    }
}
