package com.google.firebase.encoders.proto;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public @interface Protobuf {

    public enum IntEncoding {
        DEFAULT,
        SIGNED,
        FIXED
    }

    IntEncoding intEncoding() default IntEncoding.DEFAULT;

    int tag();
}
