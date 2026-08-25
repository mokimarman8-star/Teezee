package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private static final String TAG = "ManifestParser";
    private final Context context;

    public ManifestParser(Context context) {
        this.context = context;
    }

    @Nullable
    private ApplicationInfo getOurApplicationInfo() throws PackageManager.NameNotFoundException {
        return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
    }

    private static GlideModule parseModule(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor(null).newInstance(null);
            } catch (IllegalAccessException e) {
                throwInstantiateGlideModuleException(cls, e);
            } catch (InstantiationException e2) {
                throwInstantiateGlideModuleException(cls, e2);
            } catch (NoSuchMethodException e3) {
                throwInstantiateGlideModuleException(cls, e3);
            } catch (InvocationTargetException e4) {
                throwInstantiateGlideModuleException(cls, e4);
            }
            if (obj instanceof GlideModule) {
                return (GlideModule) obj;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
        } catch (ClassNotFoundException e8) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e8);
        }
    }

    private static void throwInstantiateGlideModuleException(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List<GlideModule> parse() {
        ApplicationInfo ourApplicationInfo;
        Log.isLoggable(TAG, 3);
        ArrayList arrayList = new ArrayList();
        try {
            ourApplicationInfo = getOurApplicationInfo();
        } catch (PackageManager.NameNotFoundException e) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "Failed to parse glide modules", e);
            }
        }
        if (ourApplicationInfo != null && ourApplicationInfo.metaData != null) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Got app info metadata: " + ourApplicationInfo.metaData);
            }
            for (String str : ourApplicationInfo.metaData.keySet()) {
                if (GLIDE_MODULE_VALUE.equals(ourApplicationInfo.metaData.get(str))) {
                    arrayList.add(parseModule(str));
                    if (Log.isLoggable(TAG, 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Loaded Glide module: ");
                        sb.append(str);
                    }
                }
            }
            Log.isLoggable(TAG, 3);
            return arrayList;
        }
        Log.isLoggable(TAG, 3);
        return arrayList;
    }
}
