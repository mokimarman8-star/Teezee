package com.transsion.postdetail.shorttv_pugc.factory;

import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.shorttv_pugc.bean.Cover;
import com.transsion.shorttv_pugc.bean.GifBean;
import com.transsion.ugcvideodetail.api.UGCVideoType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.manager.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ui.m0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PugcShortTvDownloadProvider implements vs.c {
    private vs.j b;
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv_pugc.factory.c
        public final Object invoke() {
            com.transsnet.downloader.manager.g h;
            h = PugcShortTvDownloadProvider.h();
            return h;
        }
    });
    private final m0 c = new a();

    public static final class a extends ui.a {
        a() {
        }

        @Override // ui.a, ui.m0
        public void e(DownloadBean downloadBean, String str) {
            Intrinsics.h(downloadBean, "bean");
            vs.j jVar = PugcShortTvDownloadProvider.this.b;
            if (jVar != null) {
                String ugcVideoId = downloadBean.getUgcVideoId();
                Integer ugcVideoPosition = downloadBean.getUgcVideoPosition();
                jVar.a(ugcVideoId, ugcVideoPosition != null ? ugcVideoPosition.intValue() : downloadBean.getEp());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g h() {
        return p.a.a(Utils.a());
    }

    private final com.transsnet.downloader.manager.g i() {
        return (com.transsnet.downloader.manager.g) this.a.getValue();
    }

    private final ShorttvModel.UGCVideo j(DownloadBean downloadBean) {
        ShorttvModel.UGCVideo uGCVideo = new ShorttvModel.UGCVideo(downloadBean.videoUGCId(), downloadBean.getTitleName(), (String) null, (List) null, new Cover((Integer) null, (Integer) null, (Integer) null, downloadBean.getUrl(), (String) null, downloadBean.getThumbnail(), (GifBean) null, (String) null, (String) null, 471, (DefaultConstructorMarker) null), (String) null, downloadBean.getDuration(), (String) null, (String) null, (Long) null, downloadBean.getUgcVideoType(), (List) null, new ShorttvModel.UGCVideoCreator((String) null, (String) null, (String) null, (Boolean) null, 15, (DefaultConstructorMarker) null), new ShorttvModel.UGCVideoInteractiveInfo((String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null), new ShorttvModel.UGCVideoCollection(downloadBean.getUgcVideoCollectionId(), (Integer) null, Integer.valueOf(downloadBean.videoUGCPosition()), (String) null, 10, (DefaultConstructorMarker) null), downloadBean.getOps(), (List) null, (String) null, (ShorttvModel.UGCVideoResourceInfo) null, (String) null, 0, false, (List) null, false, 16714668, (DefaultConstructorMarker) null);
        uGCVideo.setPlayUrl(downloadBean.getPath());
        return uGCVideo;
    }

    public void a(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(str, "collectionId");
        DownloadManagerApi.g0(DownloadManagerApi.j.a(), fragmentActivity, str, (String) null, str2, UGCVideoType.SHORT_TV.getValue(), str4, str5, str6, (String) null, (String) null, (String) null, false, (Function4) null, 7940, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, Continuation continuation) {
        PugcShortTvDownloadProvider$fetchDownloadList$1 pugcShortTvDownloadProvider$fetchDownloadList$1;
        int i;
        List list;
        if (continuation instanceof PugcShortTvDownloadProvider$fetchDownloadList$1) {
            pugcShortTvDownloadProvider$fetchDownloadList$1 = (PugcShortTvDownloadProvider$fetchDownloadList$1) continuation;
            int i2 = pugcShortTvDownloadProvider$fetchDownloadList$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                pugcShortTvDownloadProvider$fetchDownloadList$1.label = i2 - Integer.MIN_VALUE;
                Object obj = pugcShortTvDownloadProvider$fetchDownloadList$1.result;
                Object f = IntrinsicsKt.f();
                i = pugcShortTvDownloadProvider$fetchDownloadList$1.label;
                ArrayList arrayList = null;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (str == null) {
                        return null;
                    }
                    DownloadEsHelper a2 = DownloadEsHelper.m.a();
                    pugcShortTvDownloadProvider$fetchDownloadList$1.label = 1;
                    obj = a2.P(str, pugcShortTvDownloadProvider$fetchDownloadList$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                list = (List) obj;
                if (list != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : list) {
                        if (((DownloadBean) obj2).isCompleted()) {
                            arrayList2.add(obj2);
                        }
                    }
                    arrayList = new ArrayList(CollectionsKt.v(arrayList2, 10));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(j((DownloadBean) it.next()));
                    }
                }
                return arrayList;
            }
        }
        pugcShortTvDownloadProvider$fetchDownloadList$1 = new PugcShortTvDownloadProvider$fetchDownloadList$1(this, continuation);
        Object obj3 = pugcShortTvDownloadProvider$fetchDownloadList$1.result;
        Object f2 = IntrinsicsKt.f();
        i = pugcShortTvDownloadProvider$fetchDownloadList$1.label;
        ArrayList arrayList3 = null;
        if (i != 0) {
        }
        list = (List) obj3;
        if (list != null) {
        }
        return arrayList3;
    }

    public void c() {
        i().k(this.c);
        this.b = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object d(String str, Continuation continuation) {
        PugcShortTvDownloadProvider$getDownloadUGCVideo$1 pugcShortTvDownloadProvider$getDownloadUGCVideo$1;
        int i;
        DownloadBean downloadBean;
        if (continuation instanceof PugcShortTvDownloadProvider$getDownloadUGCVideo$1) {
            pugcShortTvDownloadProvider$getDownloadUGCVideo$1 = (PugcShortTvDownloadProvider$getDownloadUGCVideo$1) continuation;
            int i2 = pugcShortTvDownloadProvider$getDownloadUGCVideo$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                pugcShortTvDownloadProvider$getDownloadUGCVideo$1.label = i2 - Integer.MIN_VALUE;
                Object obj = pugcShortTvDownloadProvider$getDownloadUGCVideo$1.result;
                Object f = IntrinsicsKt.f();
                i = pugcShortTvDownloadProvider$getDownloadUGCVideo$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (str == null) {
                        return null;
                    }
                    DownloadEsHelper a2 = DownloadEsHelper.m.a();
                    pugcShortTvDownloadProvider$getDownloadUGCVideo$1.label = 1;
                    obj = a2.R(str, pugcShortTvDownloadProvider$getDownloadUGCVideo$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                downloadBean = (DownloadBean) obj;
                if (downloadBean == null) {
                    return j(downloadBean);
                }
                return null;
            }
        }
        pugcShortTvDownloadProvider$getDownloadUGCVideo$1 = new PugcShortTvDownloadProvider$getDownloadUGCVideo$1(this, continuation);
        Object obj2 = pugcShortTvDownloadProvider$getDownloadUGCVideo$1.result;
        Object f2 = IntrinsicsKt.f();
        i = pugcShortTvDownloadProvider$getDownloadUGCVideo$1.label;
        if (i != 0) {
        }
        downloadBean = (DownloadBean) obj2;
        if (downloadBean == null) {
        }
    }

    public void e(vs.j jVar) {
        Intrinsics.h(jVar, "listener");
        this.b = jVar;
        i().g(this.c);
    }
}
