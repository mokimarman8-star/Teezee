package com.therouter.router;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a {
    public static final InputStream a(Context context, String str) {
        Resources resources;
        AssetManager assets;
        if (str == null || context == null || (resources = context.getResources()) == null || (assets = resources.getAssets()) == null) {
            return null;
        }
        return assets.open(str);
    }
}
