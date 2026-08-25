package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class WMZ implements Ei<com.bytedance.adsdk.sP.Jcg.TKC> {
    public static final WMZ Sj = new WMZ();

    private WMZ() {
    }

    @Override // com.bytedance.adsdk.sP.HiB.Ei
    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.sP.Jcg.TKC sP(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.bytedance.adsdk.sP.Jcg.TKC((nextDouble / 100.0f) * f, (nextDouble2 / 100.0f) * f);
    }
}
