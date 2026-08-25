package com.google.firebase.remoteconfig;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum FirebaseRemoteConfigException$Code {
    UNKNOWN(0),
    CONFIG_UPDATE_STREAM_ERROR(1),
    CONFIG_UPDATE_MESSAGE_INVALID(2),
    CONFIG_UPDATE_NOT_FETCHED(3),
    CONFIG_UPDATE_UNAVAILABLE(4);

    private final int value;

    FirebaseRemoteConfigException$Code(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }
}
