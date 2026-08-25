package uu;

import com.transsion.upload.bean.UploadTstTokenStorageType;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface a {

    /* renamed from: uu.a$a, reason: collision with other inner class name */
    public static final class C0106a {
        public static /* synthetic */ void a(a aVar, String str, String str2, String str3, UploadTstTokenStorageType uploadTstTokenStorageType, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailure");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                uploadTstTokenStorageType = null;
            }
            aVar.c(str, str2, str3, uploadTstTokenStorageType);
        }
    }

    void a(String str, long j, long j2);

    void b(String str, String str2, String str3);

    void c(String str, String str2, String str3, UploadTstTokenStorageType uploadTstTokenStorageType);
}
