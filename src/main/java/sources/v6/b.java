package v6;

import com.cloud.h5update.bean.UpdateEntity;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface b {
    void onDownloadProcess(String str, long j, long j2);

    void onError(String str, int i, String str2);

    boolean onGetEntity(UpdateEntity updateEntity);

    void onNoNeedDownload(String str);

    void onUnZipDownloadFinish(String str, String str2, File file);

    void onZipDownloadCancel(String str);

    void onZipDownloadFinish(String str);

    void onZipDownloadStart(String str);

    boolean onZipDownloaded(String str);

    boolean onZipTryDownload(String str, String str2, String str3);
}
