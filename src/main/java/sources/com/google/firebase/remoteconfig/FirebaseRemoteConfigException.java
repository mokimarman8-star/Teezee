package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseException;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class FirebaseRemoteConfigException extends FirebaseException {
    private final Code code;

    public FirebaseRemoteConfigException(@NonNull String str) {
        super(str);
        this.code = Code.UNKNOWN;
    }

    public FirebaseRemoteConfigException(@NonNull String str, @NonNull Code code) {
        super(str);
        this.code = code;
    }

    public FirebaseRemoteConfigException(@NonNull String str, @Nullable Throwable th) {
        super(str, th);
        this.code = Code.UNKNOWN;
    }

    public FirebaseRemoteConfigException(@NonNull String str, @Nullable Throwable th, @NonNull Code code) {
        super(str, th);
        this.code = code;
    }

    @NonNull
    public Code getCode() {
        return this.code;
    }
}
