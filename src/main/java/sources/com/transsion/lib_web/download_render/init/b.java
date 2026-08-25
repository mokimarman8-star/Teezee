package com.transsion.lib_web.download_render.init;

import com.transsion.lib_web.download_render.FileDownloadTaskManager;
import com.transsion.lib_web.download_render.data.PageListData;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements c {
    @Override // com.transsion.lib_web.download_render.init.c
    public void invoke() {
        PageListData l = com.transsion.lib_web.download_render.c.a.l();
        if (l == null) {
            return;
        }
        FileDownloadTaskManager.a.g(l.getH5Pages());
    }
}
