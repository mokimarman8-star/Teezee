package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class aa implements Ei<Float> {
    public static final aa Sj = new aa();

    private aa() {
    }

    @Override // com.bytedance.adsdk.sP.HiB.Ei
    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
    public Float sP(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(RiZ.sP(jsonReader) * f);
    }
}
