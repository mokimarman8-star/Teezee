package com.transsion.shorttv.subtitle;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v;
import com.transsion.shorttv.R;
import com.transsion.subtitle_download.a;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import nr.e;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTVSubtitleControlImp$downloadListener$1 implements com.transsion.subtitle_download.a {
    final /* synthetic */ ShortTVSubtitleControlImp a;

    ShortTVSubtitleControlImp$downloadListener$1(ShortTVSubtitleControlImp shortTVSubtitleControlImp) {
        this.a = shortTVSubtitleControlImp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SubtitleDownloadTable subtitleDownloadTable, ShortTVSubtitleControlImp shortTVSubtitleControlImp) {
        e eVar;
        if (subtitleDownloadTable.isSetImmediately()) {
            eVar = shortTVSubtitleControlImp.e;
            if (Intrinsics.c(eVar.f(), subtitleDownloadTable.getResourceId())) {
                jr.b.a.d(R.string.short_tv_subtitle_download_failed);
            }
        }
    }

    public void onComplete(SubtitleDownloadTable subtitleDownloadTable) {
        FragmentActivity fragmentActivity;
        Intrinsics.h(subtitleDownloadTable, "stDownloadTable");
        fragmentActivity = this.a.b;
        i.d(v.a(fragmentActivity), (CoroutineContext) null, (CoroutineStart) null, new ShortTVSubtitleControlImp$downloadListener$1$onComplete$1(this.a, subtitleDownloadTable, null), 3, (Object) null);
    }

    public void onDownloading(int i, SubtitleDownloadTable subtitleDownloadTable) {
        Intrinsics.h(subtitleDownloadTable, "stDownloadTable");
    }

    public void onFail(Exception exc, final SubtitleDownloadTable subtitleDownloadTable) {
        FragmentActivity fragmentActivity;
        Intrinsics.h(exc, "e");
        Intrinsics.h(subtitleDownloadTable, "dbBean");
        fragmentActivity = this.a.b;
        final ShortTVSubtitleControlImp shortTVSubtitleControlImp = this.a;
        fragmentActivity.runOnUiThread(new Runnable() { // from class: com.transsion.shorttv.subtitle.d
            @Override // java.lang.Runnable
            public final void run() {
                ShortTVSubtitleControlImp$downloadListener$1.b(subtitleDownloadTable, shortTVSubtitleControlImp);
            }
        });
    }

    public void onSaveDownload(SubtitleDownloadTable subtitleDownloadTable) {
        e eVar;
        FragmentActivity fragmentActivity;
        String str;
        Intrinsics.h(subtitleDownloadTable, "bean");
        String resourceId = subtitleDownloadTable.getResourceId();
        eVar = this.a.e;
        if (Intrinsics.c(resourceId, eVar.f())) {
            fragmentActivity = this.a.b;
            i.d(v.a(fragmentActivity), (CoroutineContext) null, (CoroutineStart) null, new ShortTVSubtitleControlImp$downloadListener$1$onSaveDownload$1(this.a, subtitleDownloadTable, null), 3, (Object) null);
            return;
        }
        a.a aVar = wf.a.a;
        str = this.a.g;
        a.a.g(aVar, str + " --> -------- onSaveDownload，不是当前视频，不做处理", false, 2, (Object) null);
    }

    public void onUnGzZip(SubtitleDownloadTable subtitleDownloadTable) {
        a.a.b(this, subtitleDownloadTable);
    }
}
