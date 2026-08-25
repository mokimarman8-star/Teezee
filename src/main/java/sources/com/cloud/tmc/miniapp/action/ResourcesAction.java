package com.cloud.tmc.miniapp.action;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.b;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface ResourcesAction {

    public static final class DefaultImpls {
        public static int getColor(ResourcesAction resourcesAction, int i) {
            return b.getColor(resourcesAction.getContext(), i);
        }

        public static Drawable getDrawable(ResourcesAction resourcesAction, int i) {
            return b.getDrawable(resourcesAction.getContext(), i);
        }

        public static Resources getResources(ResourcesAction resourcesAction) {
            Resources resources = resourcesAction.getContext().getResources();
            Intrinsics.g(resources, "getContext().resources");
            return resources;
        }

        public static String getString(ResourcesAction resourcesAction, int i) {
            return resourcesAction.getContext().getString(i);
        }

        public static String getString(ResourcesAction resourcesAction, int i, Object... objArr) {
            Intrinsics.h(objArr, "formatArgs");
            return resourcesAction.getResources().getString(i, Arrays.copyOf(objArr, objArr.length));
        }

        public static <S> S getSystemService(ResourcesAction resourcesAction, Class<S> cls) {
            Intrinsics.h(cls, "serviceClass");
            S s = (S) b.getSystemService(resourcesAction.getContext(), cls);
            Intrinsics.e(s);
            return s;
        }
    }

    int getColor(int i);

    Context getContext();

    Drawable getDrawable(int i);

    Resources getResources();

    String getString(int i);

    String getString(int i, Object... objArr);

    <S> S getSystemService(Class<S> cls);
}
