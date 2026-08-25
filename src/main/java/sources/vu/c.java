package vu;

import android.net.Uri;
import android.os.Build;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.blankj.utilcode.util.Utils;
import com.transsion.upload.bean.TstTokenEntity;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c extends vu.a {
    private TstTokenEntity b;
    private OSS c;
    private LinkedHashMap d = new LinkedHashMap();

    public static final class a implements OSSCompletedCallback {
        final /* synthetic */ String b;
        final /* synthetic */ uu.a c;
        final /* synthetic */ String d;

        a(String str, uu.a aVar, String str2) {
            this.b = str;
            this.c = aVar;
            this.d = str2;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onFailure(PutObjectRequest putObjectRequest, ClientException clientException, ServiceException serviceException) {
            wu.a.a.c(c.this.d() + " --> OSSCompletedCallback() --> onFailure() --> clientException = " + clientException + " --> serviceException = " + serviceException);
            uu.a aVar = this.c;
            if (aVar != null) {
                aVar.c(this.d, clientException != null ? clientException.getMessage() : null, serviceException != null ? serviceException.getMessage() : null, c.this.f());
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult result) {
            Intrinsics.h(result, "result");
            wu.a.a.b(c.this.d() + " --> OSSCompletedCallback() --> onSuccess() --> remotePath = " + this.b);
            uu.a aVar = this.c;
            if (aVar != null) {
                String str = this.d;
                String str2 = this.b;
                String bucketName = putObjectRequest != null ? putObjectRequest.getBucketName() : null;
                if (bucketName == null) {
                    bucketName = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                aVar.b(str, str2, bucketName);
            }
        }
    }

    private final void k(String str, OSSAsyncTask oSSAsyncTask) {
        this.d.put(str, oSSAsyncTask);
    }

    private final void l(UploadFileType uploadFileType, final String str, boolean z, final uu.a aVar) {
        PutObjectRequest putObjectRequest;
        String a2 = a(uploadFileType, str);
        if (Build.VERSION.SDK_INT >= 29) {
            TstTokenEntity tstTokenEntity = this.b;
            putObjectRequest = new PutObjectRequest(tstTokenEntity != null ? tstTokenEntity.getBucket() : null, a2, Uri.fromFile(new File(str)));
        } else {
            TstTokenEntity tstTokenEntity2 = this.b;
            putObjectRequest = new PutObjectRequest(tstTokenEntity2 != null ? tstTokenEntity2.getBucket() : null, a2, str);
        }
        putObjectRequest.setProgressCallback(new OSSProgressCallback() { // from class: vu.b
            public final void onProgress(Object obj, long j, long j2) {
                c.m(uu.a.this, str, (PutObjectRequest) obj, j, j2);
            }
        });
        OSS oss = this.c;
        OSSAsyncTask asyncPutObject = oss != null ? oss.asyncPutObject(putObjectRequest, new a(a2, aVar, str)) : null;
        if (z) {
            k(str, asyncPutObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(uu.a aVar, String localFilePath, PutObjectRequest putObjectRequest, long j, long j2) {
        Intrinsics.h(localFilePath, "$localFilePath");
        if (aVar != null) {
            aVar.a(localFilePath, j, j2);
        }
    }

    @Override // vu.a
    public void b() {
        Iterator it = this.d.entrySet().iterator();
        while (it.hasNext()) {
            OSSAsyncTask oSSAsyncTask = (OSSAsyncTask) ((Map.Entry) it.next()).getValue();
            if (oSSAsyncTask != null) {
                oSSAsyncTask.cancel();
            }
        }
        this.d.clear();
        wu.a.a.b(d() + " --> cancel() --> end");
    }

    @Override // vu.a
    public void c(TstTokenEntity tstToken, String localFilePath, UploadFileType uploadFileType, boolean z, uu.a aVar) {
        Intrinsics.h(tstToken, "tstToken");
        Intrinsics.h(localFilePath, "localFilePath");
        Intrinsics.h(uploadFileType, "uploadFileType");
        l(uploadFileType, localFilePath, z, aVar);
    }

    @Override // vu.a
    public UploadTstTokenStorageType f() {
        return UploadTstTokenStorageType.TST_TOKEN_STORAGE_OSS;
    }

    @Override // vu.a
    public void h(TstTokenEntity tstToken) {
        Intrinsics.h(tstToken, "tstToken");
        this.b = tstToken;
        if (tstToken != null) {
            OSSStsTokenCredentialProvider oSSStsTokenCredentialProvider = new OSSStsTokenCredentialProvider(tstToken.getAccessKeyId(), tstToken.getAccessKeySecret(), tstToken.getSecurityToken());
            ClientConfiguration clientConfiguration = new ClientConfiguration();
            clientConfiguration.setConnectionTimeout(30000);
            clientConfiguration.setSocketTimeout(30000);
            clientConfiguration.setMaxConcurrentRequest(5);
            clientConfiguration.setMaxErrorRetry(3);
            OSS oss = this.c;
            if (oss == null) {
                this.c = new OSSClient(Utils.a(), tstToken.getEndPoint(), oSSStsTokenCredentialProvider);
            } else if (oss != null) {
                oss.updateCredentialProvider(oSSStsTokenCredentialProvider);
            }
        }
    }
}
