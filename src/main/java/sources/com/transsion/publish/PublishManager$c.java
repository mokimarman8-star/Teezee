package com.transsion.publish;

import com.transsion.publish.api.bean.RequestPostEntity;
import com.transsion.publish.net.PostResuleEntity;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PublishManager$c extends dg.a {
    final /* synthetic */ PublishManager d;
    final /* synthetic */ boolean e;
    final /* synthetic */ RequestPostEntity f;

    PublishManager$c(PublishManager publishManager, boolean z, RequestPostEntity requestPostEntity) {
        this.d = publishManager;
        this.e = z;
        this.f = requestPostEntity;
    }

    public void a(String str, String str2) {
        PublishManager.access$failureCallback(this.d, str, str2, this.e);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(PostResuleEntity postResuleEntity) {
        if (postResuleEntity != null) {
            postResuleEntity.setScore(this.f.getScore());
        }
        PublishManager.access$successCallback(this.d, postResuleEntity);
    }
}
