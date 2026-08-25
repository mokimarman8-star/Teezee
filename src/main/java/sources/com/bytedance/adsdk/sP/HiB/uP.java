package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import com.bytedance.adsdk.sP.TKC.sP.uA;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class uP {
    static com.bytedance.adsdk.sP.TKC.sP.uA Sj(JsonReader jsonReader) throws IOException {
        String str = null;
        uA.Sj sj = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "mm":
                    sj = uA.Sj.Sj(jsonReader.nextInt());
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.sP.TKC.sP.uA(str, sj, z);
    }
}
