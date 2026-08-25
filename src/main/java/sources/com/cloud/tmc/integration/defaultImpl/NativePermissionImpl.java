package com.cloud.tmc.integration.defaultImpl;

import android.content.Context;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.callback.NativePermissionCallback;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.proxy.NativePermissionProxy;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/cloud/tmc/integration/defaultImpl/NativePermissionImpl;", "Lcom/cloud/tmc/integration/proxy/NativePermissionProxy;", "()V", "requestStoragePermission", "", "context", "Landroid/content/Context;", EventConstants.ABILITY_NAME_CALLBACK, "Lcom/cloud/tmc/integration/callback/NativePermissionCallback;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class NativePermissionImpl implements NativePermissionProxy {
    @Override // com.cloud.tmc.integration.proxy.NativePermissionProxy
    public void requestStoragePermission(Context context, final NativePermissionCallback callback) {
        Intrinsics.h(context, "context");
        Intrinsics.h(callback, EventConstants.ABILITY_NAME_CALLBACK);
        PermissionUtils.permissionGroup(new String[]{"STORAGE_READ"}).callback(new PermissionUtils.SimpleCallback() { // from class: com.cloud.tmc.integration.defaultImpl.NativePermissionImpl$requestStoragePermission$1
            public void onDenied() {
                NativePermissionCallback.this.onDenied();
            }

            public void onGranted() {
                NativePermissionCallback.this.onGranted();
            }
        }).request();
    }
}
