package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c {

    private static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        private final ActivityOptions f6931a;

        a(ActivityOptions activityOptions) {
            this.f6931a = activityOptions;
        }

        @Override // androidx.core.app.c
        public Bundle c() {
            return this.f6931a.toBundle();
        }
    }

    protected c() {
    }

    public static c a(Context context, int i5, int i6) {
        return new a(ActivityOptions.makeCustomAnimation(context, i5, i6));
    }

    public static c b(Activity activity, androidx.core.util.e... eVarArr) {
        Pair[] pairArr;
        if (eVarArr != null) {
            pairArr = new Pair[eVarArr.length];
            for (int i5 = 0; i5 < eVarArr.length; i5++) {
                androidx.core.util.e eVar = eVarArr[i5];
                pairArr[i5] = Pair.create((View) eVar.f7124a, (String) eVar.f7125b);
            }
        } else {
            pairArr = null;
        }
        return new a(ActivityOptions.makeSceneTransitionAnimation(activity, pairArr));
    }

    public abstract Bundle c();
}
