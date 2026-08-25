package com.transsion.postdetail.shorttv.factory;

import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.bean.Cover;
import com.transsion.shorttv.bean.DownloadItem;
import com.transsion.shorttv.bean.DownloadListBean;
import com.transsion.shorttv.bean.Media;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.bean.SubjectType;
import com.transsion.shorttv.bean.Video;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.manager.p;
import com.transsnet.downloader.view.DownloadingTipsDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ui.m0;
import ui.s0;
import ur.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvDownloadProvider implements ur.d {
    private ur.m b;
    private ur.n c;
    private DownloadBean f;
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv.factory.c
        public final Object invoke() {
            com.transsnet.downloader.manager.g r;
            r = ShortTvDownloadProvider.r();
            return r;
        }
    });
    private final m0 d = new a();
    private final s0 e = new b();

    public static final class a extends ui.a {
        a() {
        }

        @Override // ui.a, ui.m0
        public void e(DownloadBean downloadBean, String str) {
            Intrinsics.h(downloadBean, "bean");
            ur.m mVar = ShortTvDownloadProvider.this.b;
            if (mVar != null) {
                mVar.a(downloadBean.getSubjectId(), downloadBean.getEp());
            }
        }
    }

    public static final class b implements s0 {
        b() {
        }

        private final xr.a d(DownloadBean downloadBean) {
            return new xr.a(downloadBean.getSubjectId(), downloadBean.getSubjectId() + "_" + downloadBean.getEp() + "short", downloadBean.getName(), downloadBean.getTitleName(), downloadBean.getResourceId(), downloadBean.getEp(), downloadBean.getSe(), downloadBean.getOps());
        }

        @Override // ui.s0
        public void a(String str) {
            Intrinsics.h(str, "subtitleResId");
            ur.n nVar = ShortTvDownloadProvider.this.c;
            if (nVar != null) {
                nVar.a(str);
            }
        }

        @Override // ui.s0
        public void b(DownloadBean downloadBean) {
            String resourceId;
            ur.n nVar;
            Intrinsics.h(downloadBean, "bean");
            if (!downloadBean.isVideo() || downloadBean.isMusic() || (resourceId = downloadBean.getResourceId()) == null || resourceId.length() == 0 || (nVar = ShortTvDownloadProvider.this.c) == null) {
                return;
            }
            nVar.b(d(downloadBean));
        }

        @Override // ui.s0
        public void c(DownloadBean downloadBean, boolean z) {
            String resourceId;
            ur.n nVar;
            Intrinsics.h(downloadBean, "bean");
            if (!downloadBean.isShotTV() || (resourceId = downloadBean.getResourceId()) == null || resourceId.length() == 0 || (nVar = ShortTvDownloadProvider.this.c) == null) {
                return;
            }
            nVar.c(d(downloadBean), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(DownloadItem downloadItem, int i, FragmentActivity fragmentActivity) {
        DownloadBean q;
        String resourceId = downloadItem.getResourceId();
        if (resourceId == null) {
            resourceId = downloadItem.getUrl();
        }
        if (resourceId == null || (q = DownloadEsHelper.m.a().q(resourceId)) == null) {
            return;
        }
        DownloadingTipsDialogFragment a2 = DownloadingTipsDialogFragment.k.a(i);
        a2.O0(q);
        a2.k0(fragmentActivity, "DownloadingTipsDialogFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g r() {
        return p.a.a(Utils.a());
    }

    private final com.transsnet.downloader.manager.g s() {
        return (com.transsnet.downloader.manager.g) this.a.getValue();
    }

    private final ShortTVItem t(DownloadBean downloadBean) {
        Integer valueOf = Integer.valueOf(downloadBean.getVideoHeight());
        Long size = downloadBean.getSize();
        return new ShortTVItem(downloadBean.getResourceId(), downloadBean.getSubjectId(), downloadBean.getSe(), downloadBean.getEp(), null, new Media(null, null, null, null, null, null, new Video(null, null, null, null, valueOf, size != null ? Integer.valueOf((int) size.longValue()) : null, downloadBean.getPath(), Integer.valueOf(downloadBean.getVideoWidth()), null), null), null, null, downloadBean.getReadProgress(), downloadBean.getStatus(), 0, 1232, null);
    }

    private final Subject u(DownloadBean downloadBean) {
        Cover cover = new Cover(null, null, null, downloadBean.getCover(), null, downloadBean.getThumbnail(), null, null, null, 471, null);
        String subjectId = downloadBean.getSubjectId();
        String subjectName = downloadBean.getSubjectName();
        int subjectType = downloadBean.getSubjectType();
        return new Subject(subjectId, Integer.valueOf(subjectType), subjectName, null, cover, null, null, null, null, null, null, null, null, null, null, null, null, null, null, downloadBean.getOps(), null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, downloadBean.getTotalEpisode(), false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, false, null, null, 0, 0, null, 0, null, 0, null, -524312, 1073741815, null);
    }

    private final DownloadBean v(DownloadListBean downloadListBean, Subject subject, String str, String str2, String str3, DownloadItem downloadItem) {
        String genre;
        String thumbnail;
        Cover cover;
        String releaseDate;
        String countryName;
        String title;
        List<DownloadItem> items;
        Integer totalEpisode;
        Cover cover2;
        Cover cover3;
        Cover cover4;
        String url;
        String url2 = downloadItem.getUrl();
        String str4 = url2 == null ? BuildConfig.FLAVOR : url2;
        String resourceId = downloadItem.getResourceId();
        String str5 = resourceId == null ? BuildConfig.FLAVOR : resourceId;
        String name = downloadItem.getName();
        DownloadBean downloadBean = new DownloadBean(str4, str5, name == null ? BuildConfig.FLAVOR : name, (downloadListBean == null || (cover4 = downloadListBean.getCover()) == null || (url = cover4.getUrl()) == null) ? BuildConfig.FLAVOR : url, downloadItem.getSize(), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -32, -1, 65535, null);
        Integer num = null;
        if (subject == null || (genre = subject.getGenre()) == null) {
            genre = downloadListBean != null ? downloadListBean.getGenre() : null;
        }
        downloadBean.setGenre(genre);
        downloadBean.setCreateAt(System.currentTimeMillis());
        if (subject == null || (cover3 = subject.getCover()) == null || (thumbnail = cover3.getThumbnail()) == null) {
            thumbnail = (downloadListBean == null || (cover = downloadListBean.getCover()) == null) ? null : cover.getThumbnail();
            if (thumbnail == null) {
                thumbnail = BuildConfig.FLAVOR;
            }
        }
        downloadBean.setThumbnail(thumbnail);
        if (subject == null || (releaseDate = subject.getGenre()) == null) {
            releaseDate = downloadListBean != null ? downloadListBean.getReleaseDate() : null;
        }
        downloadBean.setReleaseDate(releaseDate);
        if (subject == null || (countryName = subject.getCountryName()) == null) {
            countryName = downloadListBean != null ? downloadListBean.getCountryName() : null;
        }
        downloadBean.setCountryName(countryName);
        downloadBean.setRestrictLevel(subject != null ? subject.getRestrictLevel() : null);
        downloadBean.setImdbRate(subject != null ? subject.getImdbRate() : null);
        downloadBean.setSeNum(subject != null ? subject.getSeNum() : null);
        downloadBean.setSubtitles(subject != null ? subject.getSubtitles() : null);
        downloadBean.setDuration(downloadItem.getDuration());
        downloadBean.setAverageHueLight((downloadListBean == null || (cover2 = downloadListBean.getCover()) == null) ? null : cover2.getAverageHueLight());
        String uploadBy = downloadItem.getUploadBy();
        if (uploadBy == null) {
            uploadBy = BuildConfig.FLAVOR;
        }
        downloadBean.setUploadBy(uploadBy);
        downloadBean.setPostId(downloadItem.getPostId());
        Integer epse = downloadItem.getEpse();
        downloadBean.setEpse(epse != null ? epse.intValue() : 0);
        downloadBean.setEp(downloadItem.getEp());
        downloadBean.setSe(downloadItem.getSe());
        Integer resolution = downloadItem.getResolution();
        downloadBean.setResolution(resolution != null ? resolution.intValue() : 0);
        downloadBean.setSubjectId(downloadListBean != null ? downloadListBean.getSubjectId() : null);
        if (downloadListBean == null || (title = downloadListBean.getTitle()) == null) {
            title = subject != null ? subject.getTitle() : null;
        }
        downloadBean.setSubjectName(title);
        downloadBean.setPageFrom(str2);
        downloadBean.setLastPageFrom(str3);
        downloadBean.setOps(str);
        String sourceUrl = downloadItem.getSourceUrl();
        if (sourceUrl == null) {
            sourceUrl = BuildConfig.FLAVOR;
        }
        downloadBean.setSourceUrl(sourceUrl);
        downloadBean.setTaskId(downloadItem.getTaskId());
        downloadBean.setRequireMemberType(downloadItem.getRequireMemberType());
        downloadBean.setType(DownloadBean.INSTANCE.c(downloadListBean != null ? Integer.valueOf(downloadListBean.getSubjectType()) : null));
        downloadBean.setSubjectType(downloadListBean != null ? downloadListBean.getSubjectType() : SubjectType.SHORT_TV.getValue());
        downloadBean.setSubjectDurationSeconds(downloadListBean != null ? downloadListBean.getDurationSeconds() : null);
        downloadBean.setTotalEpisode((downloadListBean == null || (totalEpisode = downloadListBean.getTotalEpisode()) == null) ? 1 : totalEpisode.intValue());
        if (downloadListBean != null && (items = downloadListBean.getItems()) != null) {
            num = Integer.valueOf(items.size());
        }
        Intrinsics.e(num);
        if (num.intValue() > downloadBean.getTotalEpisode()) {
            downloadBean.setMultiresolution(1);
        }
        return downloadBean;
    }

    @Override // ur.d
    public Object a(String str, int i, String str2, Continuation continuation) {
        return s().a(str, i, str2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[LOOP:0: B:11:0x0054->B:13:0x005a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // ur.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, Continuation continuation) {
        ShortTvDownloadProvider$fetchDownloadList$1 shortTvDownloadProvider$fetchDownloadList$1;
        int i;
        Iterator it;
        if (continuation instanceof ShortTvDownloadProvider$fetchDownloadList$1) {
            shortTvDownloadProvider$fetchDownloadList$1 = (ShortTvDownloadProvider$fetchDownloadList$1) continuation;
            int i2 = shortTvDownloadProvider$fetchDownloadList$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                shortTvDownloadProvider$fetchDownloadList$1.label = i2 - Integer.MIN_VALUE;
                Object obj = shortTvDownloadProvider$fetchDownloadList$1.result;
                Object f = IntrinsicsKt.f();
                i = shortTvDownloadProvider$fetchDownloadList$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    DownloadEsHelper a2 = DownloadEsHelper.m.a();
                    shortTvDownloadProvider$fetchDownloadList$1.label = 1;
                    obj = a2.v(str, shortTvDownloadProvider$fetchDownloadList$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                Iterable iterable = (Iterable) obj;
                ArrayList arrayList = new ArrayList(CollectionsKt.v(iterable, 10));
                it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(t((DownloadBean) it.next()));
                }
                return arrayList;
            }
        }
        shortTvDownloadProvider$fetchDownloadList$1 = new ShortTvDownloadProvider$fetchDownloadList$1(this, continuation);
        Object obj2 = shortTvDownloadProvider$fetchDownloadList$1.result;
        Object f2 = IntrinsicsKt.f();
        i = shortTvDownloadProvider$fetchDownloadList$1.label;
        if (i != 0) {
        }
        Iterable iterable2 = (Iterable) obj2;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(iterable2, 10));
        it = iterable2.iterator();
        while (it.hasNext()) {
        }
        return arrayList2;
    }

    @Override // ur.d
    public void c() {
        s().k(this.d);
        this.b = null;
    }

    @Override // ur.d
    public Object d(String str, int i, long j, Continuation continuation) {
        Object d0 = DownloadEsHelper.m.a().d0(str, i, j, continuation);
        return d0 == IntrinsicsKt.f() ? d0 : Unit.a;
    }

    @Override // ur.d
    public boolean e(long j) {
        DownloadEsHelper.a aVar = DownloadEsHelper.m;
        aVar.a().i();
        String t = aVar.a().t();
        if (t.length() == 0) {
            return false;
        }
        try {
            long j2 = com.blankj.utilcode.util.n.j(t);
            Long w = s().w();
            if (j + (w != null ? w.longValue() : 0L) >= j2) {
                fh.b.a.d(R.string.insufficient_storage_available);
                wf.a.a.o("--- 可用存储空间不足，释放空间并重试 ---", true);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // ur.d
    public DownloadItem f(String str) {
        DownloadItem downloadItem = null;
        if (str != null && str.length() != 0) {
            DownloadBean q = DownloadEsHelper.m.a().q(str);
            if (q == null) {
                return null;
            }
            String resourceId = q.getResourceId();
            if (resourceId == null) {
                resourceId = q.getUrl();
            }
            String str2 = resourceId;
            String totalTitleName = q.getTotalTitleName();
            String url = q.getUrl();
            Long size = q.getSize();
            downloadItem = new DownloadItem(str2, totalTitleName, url, 1, Long.valueOf(size != null ? size.longValue() : 0L), q.getUploadBy(), q.getPostId(), Integer.valueOf(q.getEpse()), q.getSe(), q.getEp(), q.getStatus(), q.getSourceUrl(), Integer.valueOf(q.getResolution()), null, null);
            String taskId = q.getTaskId();
            if (taskId == null) {
                taskId = BuildConfig.FLAVOR;
            }
            downloadItem.setTaskId(taskId);
        }
        return downloadItem;
    }

    @Override // ur.d
    public void g(DownloadListBean downloadListBean, Subject subject, String str, String str2, String str3, List list) {
        Intrinsics.h(list, "list");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DownloadBean v = v(downloadListBean, subject, str, str2, str3, (DownloadItem) it.next());
            if (this.f != null) {
                this.f = v;
            }
            arrayList.add(v);
        }
        s().C(arrayList);
    }

    @Override // ur.d
    public void h(final FragmentActivity fragmentActivity, final DownloadItem downloadItem, final int i, String str) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(downloadItem, "item");
        Intrinsics.h(str, "formatSize");
        ((FrameLayout) fragmentActivity.findViewById(android.R.id.content)).postDelayed(new Runnable() { // from class: com.transsion.postdetail.shorttv.factory.d
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvDownloadProvider.q(DownloadItem.this, i, fragmentActivity);
            }
        }, 300L);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // ur.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object i(String str, Continuation continuation) {
        ShortTvDownloadProvider$getDownloadSubject$1 shortTvDownloadProvider$getDownloadSubject$1;
        int i;
        DownloadBean downloadBean;
        if (continuation instanceof ShortTvDownloadProvider$getDownloadSubject$1) {
            shortTvDownloadProvider$getDownloadSubject$1 = (ShortTvDownloadProvider$getDownloadSubject$1) continuation;
            int i2 = shortTvDownloadProvider$getDownloadSubject$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                shortTvDownloadProvider$getDownloadSubject$1.label = i2 - Integer.MIN_VALUE;
                Object obj = shortTvDownloadProvider$getDownloadSubject$1.result;
                Object f = IntrinsicsKt.f();
                i = shortTvDownloadProvider$getDownloadSubject$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    DownloadEsHelper a2 = DownloadEsHelper.m.a();
                    shortTvDownloadProvider$getDownloadSubject$1.label = 1;
                    obj = a2.v(str, shortTvDownloadProvider$getDownloadSubject$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                downloadBean = (DownloadBean) CollectionsKt.k0((List) obj);
                if (downloadBean == null) {
                    return u(downloadBean);
                }
                return null;
            }
        }
        shortTvDownloadProvider$getDownloadSubject$1 = new ShortTvDownloadProvider$getDownloadSubject$1(this, continuation);
        Object obj2 = shortTvDownloadProvider$getDownloadSubject$1.result;
        Object f2 = IntrinsicsKt.f();
        i = shortTvDownloadProvider$getDownloadSubject$1.label;
        if (i != 0) {
        }
        downloadBean = (DownloadBean) CollectionsKt.k0((List) obj2);
        if (downloadBean == null) {
        }
    }

    @Override // ur.d
    public void j(ur.m mVar) {
        Intrinsics.h(mVar, "listener");
        this.b = mVar;
        s().g(this.d);
    }

    @Override // ur.d
    public void k(FragmentActivity fragmentActivity, String str, int i) {
        d.a.a(this, fragmentActivity, str, i);
    }

    @Override // ur.d
    public void l(ur.n nVar) {
        Intrinsics.h(nVar, "listener");
        this.c = nVar;
        s().E(this.e);
    }
}
