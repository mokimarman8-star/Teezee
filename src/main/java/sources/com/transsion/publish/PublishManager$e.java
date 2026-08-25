package com.transsion.publish;

import android.text.TextUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.transsion.publish.api.bean.MediaCoverEntity;
import com.transsion.publish.api.bean.RequestPostEntity;
import com.transsion.publish.api.bean.RequestPostMediaEntity;
import com.transsion.publish.bean.PublishValue;
import com.transsion.upload.bean.UploadFileType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import qo.h;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PublishManager$e implements h.b {
    final /* synthetic */ PublishManager a;
    final /* synthetic */ Ref.ObjectRef b;
    final /* synthetic */ boolean c;
    final /* synthetic */ RequestPostEntity d;

    PublishManager$e(PublishManager publishManager, Ref.ObjectRef objectRef, boolean z, RequestPostEntity requestPostEntity) {
        this.a = publishManager;
        this.b = objectRef;
        this.c = z;
        this.d = requestPostEntity;
    }

    @Override // qo.h.b
    public void a(String str) {
        Intrinsics.h(str, "path");
        try {
            if (!TextUtils.isEmpty(str) && !PublishManager.access$getPublishQueue$p(this.a).contains(str)) {
                if (PublishManager.access$isUploadSucceed(this.a, str)) {
                    PublishManager.access$disposeVideo(this.a, ((RequestPostMediaEntity) this.b.element).getVideo(), this.c);
                    return;
                }
                RequestPostMediaEntity media = this.d.getMedia();
                MediaCoverEntity cover = media != null ? media.getCover() : null;
                if (cover == null) {
                    cover = new MediaCoverEntity();
                    RequestPostMediaEntity media2 = this.d.getMedia();
                    if (media2 != null) {
                        media2.setCover(cover);
                    }
                }
                cover.setUrl(str);
                int[] d = ImageUtils.d(str);
                cover.setSize(d[0] * d[1]);
                cover.setWidth(d[0]);
                cover.setHeight(d[1]);
                PublishManager.access$getPublishQueue$p(this.a).put(str, new PublishValue(1));
                uu.c.a.f(str, UploadFileType.OBJECT_NAME_IMAGE, true, PublishManager.access$uploadCallback(this.a));
                PublishManager.access$disposeVideo(this.a, ((RequestPostMediaEntity) this.b.element).getVideo(), this.c);
                return;
            }
            PublishManager.access$disposeVideo(this.a, ((RequestPostMediaEntity) this.b.element).getVideo(), this.c);
        } catch (Exception e) {
            a.a.f(wf.a.a, "TNPublish", "onFirstFrame ext:" + e.getMessage(), false, 4, (Object) null);
        }
    }
}
