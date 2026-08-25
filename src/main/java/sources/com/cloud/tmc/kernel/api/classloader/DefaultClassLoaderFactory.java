package com.cloud.tmc.kernel.api.classloader;

import androidx.annotation.Keep;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class DefaultClassLoaderFactory implements ClassLoaderFactory {
    @Override // com.cloud.tmc.kernel.api.classloader.ClassLoaderFactory
    public ClassLoader getClassLoader(String str) {
        return DefaultClassLoaderFactory.class.getClassLoader();
    }
}
