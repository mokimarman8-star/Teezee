package w4;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$a;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader$a f18217a = JsonReader$a.a("nm", "mm", "hd");

    static MergePaths a(JsonReader jsonReader) {
        String str = null;
        boolean z5 = false;
        MergePaths.MergePathsMode mergePathsMode = null;
        while (jsonReader.m()) {
            int v5 = jsonReader.v(f18217a);
            if (v5 == 0) {
                str = jsonReader.r();
            } else if (v5 == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.p());
            } else if (v5 != 2) {
                jsonReader.w();
                jsonReader.x();
            } else {
                z5 = jsonReader.n();
            }
        }
        return new MergePaths(str, mergePathsMode, z5);
    }
}
