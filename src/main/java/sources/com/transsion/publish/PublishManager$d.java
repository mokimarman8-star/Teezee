package com.transsion.publish;

import com.transsion.publish.api.bean.MediaImageEntity;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PublishManager$d implements com.transsion.compressor.image.e {
    final /* synthetic */ MediaImageEntity a;
    final /* synthetic */ PublishManager b;
    final /* synthetic */ List c;

    PublishManager$d(MediaImageEntity mediaImageEntity, PublishManager publishManager, List list) {
        this.a = mediaImageEntity;
        this.b = publishManager;
        this.c = list;
    }

    @Override // com.transsion.compressor.image.e
    public void a(String str) {
        Intrinsics.h(str, "path");
    }

    @Override // com.transsion.compressor.image.e
    public void b(File file, int[] iArr, long j) {
        Intrinsics.h(file, "file");
        Intrinsics.h(iArr, "ints");
        a.a.f(wf.a.a, "TNPublish", "TranCompressor success...file " + file, false, 4, (Object) null);
        MediaImageEntity mediaImageEntity = this.a;
        String absolutePath = file.getAbsolutePath();
        Intrinsics.g(absolutePath, "getAbsolutePath(...)");
        mediaImageEntity.setUrl(absolutePath);
        this.a.setWidth(Integer.valueOf(iArr[0]));
        this.a.setHeight(Integer.valueOf(iArr[1]));
        this.a.setSize(Long.valueOf(j));
        PublishManager.access$check(this.b, this.a, this.c.size());
    }

    @Override // com.transsion.compressor.image.e
    public void onError(Throwable th2) {
        PublishManager.access$check(this.b, this.a, this.c.size());
    }
}
