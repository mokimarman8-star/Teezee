package vu;

import android.text.TextUtils;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.blankj.utilcode.util.Utils;
import com.transsion.upload.bean.TstTokenEntity;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d extends vu.a {
    private TransferUtility b;
    private String c = HttpUrl.FRAGMENT_ENCODE_SET;
    private LinkedHashMap d = new LinkedHashMap();

    public static final class a implements TransferListener {
        final /* synthetic */ String b;
        final /* synthetic */ uu.a c;
        final /* synthetic */ String d;
        final /* synthetic */ TransferObserver e;

        /* renamed from: vu.d$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0114a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[TransferState.values().length];
                try {
                    iArr[TransferState.COMPLETED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TransferState.FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TransferState.CANCELED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        a(String str, uu.a aVar, String str2, TransferObserver transferObserver) {
            this.b = str;
            this.c = aVar;
            this.d = str2;
            this.e = transferObserver;
        }

        public void a(int i, TransferState transferState) {
            int i2 = transferState == null ? -1 : C0114a.a[transferState.ordinal()];
            if (i2 == 1) {
                wu.a.a.b(d.this.d() + " --> onStateChanged() --> COMPLETED --> file path == " + this.b + " --> id = " + i);
                uu.a aVar = this.c;
                if (aVar != null) {
                    String str = this.d;
                    String str2 = this.b;
                    String e = this.e.e();
                    Intrinsics.g(e, "transferObserver.bucket");
                    aVar.b(str, str2, e);
                    return;
                }
                return;
            }
            if (i2 == 2) {
                wu.a.a.c(d.this.d() + " --> onStateChanged() --> FAILED");
                uu.a aVar2 = this.c;
                if (aVar2 != null) {
                    aVar2.c(this.d, "failed", HttpUrl.FRAGMENT_ENCODE_SET, d.this.f());
                    return;
                }
                return;
            }
            if (i2 != 3) {
                return;
            }
            wu.a.a.b(d.this.d() + " --> onStateChanged() --> CANCELED --> 取消了");
            uu.a aVar3 = this.c;
            if (aVar3 != null) {
                aVar3.c(this.d, "canceled", HttpUrl.FRAGMENT_ENCODE_SET, d.this.f());
            }
        }

        public void b(int i, long j, long j2) {
            wu.a.a.b(d.this.d() + " --> onProgressChanged() --> id = " + i + " --> bytesCurrent = " + j + " --> bytesTotal = " + j2);
            uu.a aVar = this.c;
            if (aVar != null) {
                aVar.a(this.d, j, j2);
            }
        }

        public void c(int i, Exception exc) {
            wu.a.a.b(d.this.d() + " --> onError() --> id = " + i + " --> ex = " + (exc != null ? exc.getMessage() : null));
            uu.a aVar = this.c;
            if (aVar != null) {
                aVar.c(this.d, exc != null ? exc.getMessage() : null, HttpUrl.FRAGMENT_ENCODE_SET, d.this.f());
            }
        }
    }

    private final void j(boolean z, TransferObserver transferObserver) {
        if (z) {
            if (!this.d.containsKey(this.b)) {
                this.d.put(this.b, CollectionsKt.q(new TransferObserver[]{transferObserver}));
                return;
            }
            List list = (List) this.d.get(this.b);
            if (list != null) {
                list.add(transferObserver);
            }
        }
    }

    private final void k(TstTokenEntity tstTokenEntity) {
        AmazonS3Client amazonS3Client = new AmazonS3Client(new BasicSessionCredentials(tstTokenEntity.getAccessKeyId(), tstTokenEntity.getAccessKeySecret(), tstTokenEntity.getSecurityToken()), Region.e(Regions.fromName(tstTokenEntity.getRegionId())));
        amazonS3Client.d0(S3ClientOptions.a().b(false).c(true).a());
        this.b = TransferUtility.c().c(amazonS3Client).b(Utils.a()).a();
    }

    private final void l(TstTokenEntity tstTokenEntity, String str, UploadFileType uploadFileType, boolean z, uu.a aVar) {
        String a2 = a(uploadFileType, str);
        TransferUtility transferUtility = this.b;
        TransferObserver i = transferUtility != null ? transferUtility.i(tstTokenEntity.getBucket(), a2, new File(str)) : null;
        j(z, i);
        if (i != null) {
            i.g(new a(a2, aVar, str, i));
        }
    }

    @Override // vu.a
    public void b() {
        for (Map.Entry entry : this.d.entrySet()) {
            for (TransferObserver transferObserver : (Iterable) entry.getValue()) {
                TransferUtility transferUtility = (TransferUtility) entry.getKey();
                if (transferUtility != null) {
                    transferUtility.d(transferObserver != null ? transferObserver.f() : 0);
                }
                if (transferObserver != null) {
                    transferObserver.d();
                }
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
        l(tstToken, localFilePath, uploadFileType, z, aVar);
    }

    @Override // vu.a
    public UploadTstTokenStorageType f() {
        return UploadTstTokenStorageType.TST_TOKEN_STORAGE_S3;
    }

    @Override // vu.a
    public void h(TstTokenEntity tstToken) {
        Intrinsics.h(tstToken, "tstToken");
        if (TextUtils.equals(this.c, tstToken.getAccessKeyId())) {
            return;
        }
        String accessKeyId = tstToken.getAccessKeyId();
        if (accessKeyId == null) {
            accessKeyId = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        this.c = accessKeyId;
        k(tstToken);
    }
}
