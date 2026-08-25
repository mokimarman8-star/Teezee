package com.bytedance.adsdk.sP.HiB;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class LqL implements Ei<PointF> {
    public static final LqL Sj = new LqL();

    private LqL() {
    }

    @Override // com.bytedance.adsdk.sP.HiB.Ei
    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
    public PointF sP(JsonReader jsonReader, float f) throws IOException {
        JsonToken peek = jsonReader.peek();
        if (peek != JsonToken.BEGIN_ARRAY && peek != JsonToken.BEGIN_OBJECT) {
            if (peek != JsonToken.NUMBER) {
                throw new IllegalArgumentException("Cannot convert json to point. Next token is ".concat(String.valueOf(peek)));
            }
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        return RiZ.sP(jsonReader, f);
    }
}
