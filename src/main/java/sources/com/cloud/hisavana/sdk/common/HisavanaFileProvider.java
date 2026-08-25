package com.cloud.hisavana.sdk.common;

import androidx.core.content.FileProvider;
import com.cloud.hisavana.sdk.b4;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class HisavanaFileProvider extends FileProvider {
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        b4.b().d("HisavanaFileProvider", "onCreate");
        return super.onCreate();
    }
}
