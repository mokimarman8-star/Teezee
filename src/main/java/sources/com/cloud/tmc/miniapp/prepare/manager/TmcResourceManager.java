package com.cloud.tmc.miniapp.prepare.manager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.callback.PackageInstallCallback;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.kernel.proxy.Proxiable;
import com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface TmcResourceManager extends Proxiable {
    void clearDownloadAppMap();

    void creatBaseDirectory(@NonNull AppModel appModel);

    void createSoDirectory();

    void deleteDownloadPackage(@NonNull AppModel appModel);

    void deleteInstallStatus(@NonNull String str);

    void downloadApp(@NonNull AppModel appModel, int i, boolean z, @Nullable PackageDownloadCallback packageDownloadCallback);

    void downloadApp(String str, String str2, String str3, String str4, int i, boolean z, @Nullable PackageDownloadCallback packageDownloadCallback);

    String getInstallPath(@NonNull AppModel appModel);

    @Nullable
    String getInstalledAppVersion(@NonNull String str);

    boolean getNativeCache(@NonNull Context context, @NonNull AppModel appModel);

    boolean getOfflineCache(@NonNull Context context, @NonNull AppModel appModel);

    void installApp(@NonNull AppModel appModel, @Nullable PackageInstallCallback packageInstallCallback);

    void installApp(@NonNull AppModel appModel, boolean z, SubPackageInfo subPackageInfo, @Nullable PackageInstallCallback packageInstallCallback);

    void installZip(@NonNull Context context, @NonNull AppModel appModel, @Nullable PackageInstallCallback packageInstallCallback);

    void installZip(@NonNull Context context, @NonNull AppModel appModel, boolean z, SubPackageInfo subPackageInfo, @Nullable PackageInstallCallback packageInstallCallback);

    boolean isAvailable(@NonNull Context context, @NonNull AppModel appModel);

    boolean isDownloaded(@NonNull Context context, @NonNull AppModel appModel);

    boolean isDownloaded(@NonNull Context context, String str, String str2);

    void removeDownloadAppMap(String str);
}
