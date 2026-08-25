package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
abstract class GeneratedAppGlideModule extends AppGlideModule {
    GeneratedAppGlideModule() {
    }

    @NonNull
    Set<Class<?>> getExcludedModuleClasses() {
        return new HashSet();
    }

    @Nullable
    /* renamed from: getRequestManagerFactory */
    RequestManagerRetriever.RequestManagerFactory mo12getRequestManagerFactory() {
        return null;
    }
}
