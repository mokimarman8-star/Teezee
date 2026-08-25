package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class FirebaseRemoteConfigClientException extends FirebaseRemoteConfigException {
    public FirebaseRemoteConfigClientException(@NonNull String str) {
        super(str);
    }

    public FirebaseRemoteConfigClientException(@NonNull String str, @NonNull FirebaseRemoteConfigException$Code firebaseRemoteConfigException$Code) {
        super(str, firebaseRemoteConfigException$Code);
    }

    public FirebaseRemoteConfigClientException(@NonNull String str, @Nullable Throwable th) {
        super(str, th);
    }

    public FirebaseRemoteConfigClientException(@NonNull String str, @Nullable Throwable th, @NonNull FirebaseRemoteConfigException$Code firebaseRemoteConfigException$Code) {
        super(str, th, firebaseRemoteConfigException$Code);
    }
}
