package com.airbnb.lottie.parser.moshi;

import java.io.IOException;
import okio.Buffer;
import okio.ByteString;
import okio.Options;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class JsonReader$a {

    /* renamed from: a, reason: collision with root package name */
    final String[] f14516a;

    /* renamed from: b, reason: collision with root package name */
    final Options f14517b;

    private JsonReader$a(String[] strArr, Options options) {
        this.f14516a = strArr;
        this.f14517b = options;
    }

    public static JsonReader$a a(String... strArr) {
        try {
            ByteString[] byteStringArr = new ByteString[strArr.length];
            Buffer buffer = new Buffer();
            for (int i5 = 0; i5 < strArr.length; i5++) {
                JsonReader.b(buffer, strArr[i5]);
                buffer.readByte();
                byteStringArr[i5] = buffer.readByteString();
            }
            return new JsonReader$a((String[]) strArr.clone(), Options.of(byteStringArr));
        } catch (IOException e5) {
            throw new AssertionError(e5);
        }
    }
}
