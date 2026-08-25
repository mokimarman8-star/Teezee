package com.transsion.publish;

import android.text.TextUtils;
import com.transsion.publish.bean.PublishValue;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PublishManager$f implements uu.a {
    final /* synthetic */ PublishManager a;

    PublishManager$f(PublishManager publishManager) {
        this.a = publishManager;
    }

    public void a(String str, long j, long j2) {
        Intrinsics.h(str, "localFilePath");
        if (PublishManager.access$getCancelIng$p(this.a)) {
            return;
        }
        PublishManager.access$uploadProgress(this.a, str, j, j2);
        PublishValue publishValue = (PublishValue) PublishManager.access$getPublishQueue$p(this.a).get(str);
        if (publishValue != null) {
            publishValue.setState(3);
        }
    }

    public void b(String str, String str2, String str3) {
        Intrinsics.h(str, "localFilePath");
        Intrinsics.h(str2, "url");
        Intrinsics.h(str3, "bucket");
        if (PublishManager.access$getCancelIng$p(this.a)) {
            return;
        }
        PublishValue publishValue = (PublishValue) PublishManager.access$getPublishQueue$p(this.a).get(str);
        if (publishValue != null) {
            publishValue.setUploadUrl(str2);
        }
        PublishValue publishValue2 = (PublishValue) PublishManager.access$getPublishQueue$p(this.a).get(str);
        if (publishValue2 != null) {
            publishValue2.setState(1);
        }
        if (!TextUtils.isEmpty(str3)) {
            PublishManager.access$setTempBucket$p(this.a, str3);
        }
        wu.a.a.a(PublishManager.access$getClassTag(this.a) + " --> bucket = " + str3);
        PublishManager.access$uploadSuccess(this.a);
    }

    public void c(String str, String str2, String str3, UploadTstTokenStorageType uploadTstTokenStorageType) {
        if (PublishManager.access$getCancelIng$p(this.a)) {
            return;
        }
        PublishValue publishValue = (PublishValue) PublishManager.access$getPublishQueue$p(this.a).get(str);
        if (publishValue != null) {
            publishValue.setState(2);
        }
        PublishManager.access$uploadFail(this.a);
    }
}
