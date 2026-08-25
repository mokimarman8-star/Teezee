package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.integration.cronet.CronetLibraryGlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule;
import com.transsion.base.image.CustomGlideModule;
import java.util.Collections;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final CustomGlideModule appGlideModule = new CustomGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        Log.isLoggable("Glide", 3);
    }

    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        this.appGlideModule.applyOptions(context, glideBuilder);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    public Set<Class<?>> getExcludedModuleClasses() {
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    /* renamed from: getRequestManagerFactory, reason: merged with bridge method [inline-methods] */
    public GeneratedRequestManagerFactory mo12getRequestManagerFactory() {
        return new GeneratedRequestManagerFactory();
    }

    public boolean isManifestParsingEnabled() {
        return this.appGlideModule.isManifestParsingEnabled();
    }

    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        new CronetLibraryGlideModule().registerComponents(context, glide, registry);
        new OkHttpLibraryGlideModule().registerComponents(context, glide, registry);
        this.appGlideModule.registerComponents(context, glide, registry);
    }
}
