package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieFeatureFlag;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.layer.a;
import o4.l;
import t4.c;
import x4.f;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class MergePaths implements c {
    private final String a;
    private final MergePathsMode b;
    private final boolean c;

    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.a = str;
        this.b = mergePathsMode;
        this.c = z;
    }

    public o4.c a(LottieDrawable lottieDrawable, h hVar, a aVar) {
        if (lottieDrawable.n0(LottieFeatureFlag.MergePathsApi19)) {
            return new l(this);
        }
        f.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public MergePathsMode b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.b + '}';
    }
}
