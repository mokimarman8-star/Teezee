package com.bumptech.glide.integration.cronet;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.cronet.ChromiumUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.module.GlideModule;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class CronetGlideModule implements GlideModule {
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
    }

    public void registerComponents(Context context, Glide glide, Registry registry) {
        CronetRequestFactoryImpl cronetRequestFactoryImpl = new CronetRequestFactoryImpl(new 1(this, context));
        registry.replace(GlideUrl.class, InputStream.class, new ChromiumUrlLoader.StreamFactory(cronetRequestFactoryImpl, (DataLogger) null));
        registry.prepend(GlideUrl.class, ByteBuffer.class, (ModelLoaderFactory) new ChromiumUrlLoader.ByteBufferFactory(cronetRequestFactoryImpl, (DataLogger) null));
    }
}
