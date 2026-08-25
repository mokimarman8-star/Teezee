package com.google.gson.internal.bind;

import com.google.gson.stream.JsonToken;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
/* synthetic */ class JsonTreeReader$2 {
    static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

    static {
        int[] iArr = new int[JsonToken.values().length];
        $SwitchMap$com$google$gson$stream$JsonToken = iArr;
        try {
            iArr[JsonToken.NAME.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
