package com.transsion.publish;

import com.transsion.publish.net.PostResuleEntity;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PublishManager$b extends dg.a {
    final /* synthetic */ PublishManager d;
    final /* synthetic */ boolean e;

    PublishManager$b(PublishManager publishManager, boolean z) {
        this.d = publishManager;
        this.e = z;
    }

    public void a(String str, String str2) {
        PublishManager.access$failureCallback(this.d, str, str2, this.e);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(PostResuleEntity postResuleEntity) {
        PublishManager.access$successCallback(this.d, postResuleEntity);
    }
}
