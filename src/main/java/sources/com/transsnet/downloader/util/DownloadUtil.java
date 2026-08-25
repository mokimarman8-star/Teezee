package com.transsnet.downloader.util;

import android.app.Application;
import android.os.Build;
import androidx.fragment.app.Fragment;
import cm.f;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.c0;
import com.blankj.utilcode.util.o;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsion.baseui.R$mipmap;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResolutionItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.bean.DownloadUrlBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.manager.g;
import com.transsnet.downloader.manager.p;
import com.transsnet.downloader.util.DownloadUtil$initGetPositions$;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ui.n0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class DownloadUtil {
    public static final DownloadUtil a = new DownloadUtil();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.util.l
        public final Object invoke() {
            g m;
            m = DownloadUtil.m();
            return m;
        }
    });
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.util.m
        public final Object invoke() {
            n0 n;
            n = DownloadUtil.n();
            return n;
        }
    });
    private static final String[] d = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};

    private DownloadUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Function2 function2, long j, long j2) {
        if (function2 != null) {
            function2.invoke(Long.valueOf(j), Long.valueOf(j2));
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit M(Ref$ObjectRef ref$ObjectRef, String str) {
        Intrinsics.h(str, "newPath");
        ref$ObjectRef.element = str;
        a.a.u("resource_save", "转存到相册 newPath = " + str, true);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Function2 function2, long j, long j2) {
        if (function2 != null) {
            function2.invoke(Long.valueOf(j), Long.valueOf(j2));
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit O(Ref$ObjectRef ref$ObjectRef, String str) {
        Intrinsics.h(str, "newPath");
        ref$ObjectRef.element = str;
        a.a.u("resource_save", "转存到sdcard newPath = " + str, true);
        return Unit.a;
    }

    private final Object P(DownloadBean downloadBean, boolean z, Continuation continuation) {
        if (!z) {
            return Unit.a;
        }
        downloadBean.setTransferFailed(true);
        Object b0 = DownloadEsHelper.m.a().b0(downloadBean, continuation);
        return b0 == IntrinsicsKt.f() ? b0 : Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q(com.transsion.baselib.db.download.DownloadBean r17, java.lang.String r18, java.lang.String r19, int r20, java.lang.String r21, int r22, java.lang.String r23, boolean r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.util.DownloadUtil.Q(com.transsion.baselib.db.download.DownloadBean, java.lang.String, java.lang.String, int, java.lang.String, int, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g m() {
        return p.a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n0 n() {
        AppDatabase.f1 f1Var = AppDatabase.p;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return f1Var.b(a2).p1();
    }

    private final g p() {
        return (g) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n0 q() {
        return (n0) c.getValue();
    }

    private final File u(String str) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            int i = 1;
            if ((parentFile == null || !parentFile.exists()) && parentFile != null) {
                parentFile.mkdirs();
            }
            String x = FilesKt.x(file);
            String w = FilesKt.w(file);
            File file2 = new File(parentFile, file.getName());
            while (file2.exists()) {
                file2 = new File(parentFile, x + "_" + i + "." + w);
                i++;
            }
            return file2;
        } catch (Throwable unused) {
            return new File(str);
        }
    }

    private final DownloadBean z(DownloadListBean downloadListBean, Subject subject, DownloadItem downloadItem, String str, String str2, String str3, String str4, String str5) {
        String genre;
        String thumbnail;
        String releaseDate;
        String countryName;
        Cover cover;
        String url;
        String url2 = downloadItem.getUrl();
        String str6 = url2 == null ? "" : url2;
        String resourceId = downloadItem.getResourceId();
        String str7 = resourceId == null ? "" : resourceId;
        String name = downloadItem.getName();
        String str8 = name == null ? "" : name;
        Cover cover2 = downloadListBean.getCover();
        DownloadBean downloadBean = new DownloadBean(str6, str7, str8, (cover2 == null || (url = cover2.getUrl()) == null) ? "" : url, downloadItem.getSize(), (String) null, (String) null, (String) null, (Long) null, (Long) null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, 0L, 0, 0, (String) null, (String) null, 0L, (String) null, (String) null, 0L, 0, 0L, (String) null, 0, (String) null, (String) null, false, false, 0, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, -32, -1, 65535, (DefaultConstructorMarker) null);
        if (subject == null || (genre = subject.getGenre()) == null) {
            genre = downloadListBean.getGenre();
        }
        downloadBean.setGenre(genre);
        downloadBean.setCreateAt(System.currentTimeMillis());
        if (subject == null || (cover = subject.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) {
            Cover cover3 = downloadListBean.getCover();
            thumbnail = cover3 != null ? cover3.getThumbnail() : null;
            if (thumbnail == null) {
                thumbnail = "";
            }
        }
        downloadBean.setThumbnail(thumbnail);
        if (subject == null || (releaseDate = subject.getGenre()) == null) {
            releaseDate = downloadListBean.getReleaseDate();
        }
        downloadBean.setReleaseDate(releaseDate);
        if (subject == null || (countryName = subject.getCountryName()) == null) {
            countryName = downloadListBean.getCountryName();
        }
        downloadBean.setCountryName(countryName);
        downloadBean.setRestrictLevel(subject != null ? subject.getRestrictLevel() : null);
        downloadBean.setImdbRate(subject != null ? subject.getImdbRate() : null);
        downloadBean.setSeNum(subject != null ? subject.getSeNum() : null);
        downloadBean.setSubtitles(subject != null ? subject.getSubtitles() : null);
        downloadBean.setDuration(downloadItem.getDuration());
        Cover cover4 = downloadListBean.getCover();
        downloadBean.setAverageHueLight(cover4 != null ? cover4.getAverageHueLight() : null);
        String uploadBy = downloadItem.getUploadBy();
        if (uploadBy == null) {
            uploadBy = "";
        }
        downloadBean.setUploadBy(uploadBy);
        downloadBean.setPostId(downloadItem.getPostId());
        Integer epse = downloadItem.getEpse();
        downloadBean.setEpse(epse != null ? epse.intValue() : 0);
        downloadBean.setEp(downloadItem.getEp());
        downloadBean.setSe(downloadItem.getSe());
        Integer resolution = downloadItem.getResolution();
        downloadBean.setResolution(resolution != null ? resolution.intValue() : 0);
        downloadBean.setSubjectId(downloadListBean.getSubjectId());
        downloadBean.setGroupId(str == null ? downloadListBean.getGroupId() : str);
        downloadBean.setSubjectName((str5 == null || str5.length() == 0) ? downloadListBean.getTitle() : str5);
        downloadBean.setPageFrom(str2);
        downloadBean.setLastPageFrom(str3);
        downloadBean.setOps(str4);
        String sourceUrl = downloadItem.getSourceUrl();
        if (sourceUrl == null) {
            sourceUrl = "";
        }
        downloadBean.setSourceUrl(sourceUrl);
        downloadBean.setRequireMemberType(downloadItem.getRequireMemberType());
        downloadBean.setType(DownloadBean.Companion.c(Integer.valueOf(downloadListBean.getSubjectType())));
        downloadBean.setSubjectType(downloadListBean.getSubjectType());
        downloadBean.setSubjectDurationSeconds(downloadListBean.getDurationSeconds());
        Integer totalEpisode = downloadListBean.getTotalEpisode();
        downloadBean.setTotalEpisode(totalEpisode != null ? totalEpisode.intValue() : 1);
        List items = downloadListBean.getItems();
        Integer valueOf = items != null ? Integer.valueOf(items.size()) : null;
        Intrinsics.e(valueOf);
        if (valueOf.intValue() > downloadBean.getTotalEpisode()) {
            downloadBean.setMultiresolution(1);
        }
        return downloadBean;
    }

    public final Pair A(List list, int i, int i2) {
        int epNum;
        Intrinsics.h(list, "seasons");
        List<ResourcesSeason> list2 = list;
        CollectionsKt.I0(list2, new DownloadUtil$initGetPositions$.inlined.sortedBy.1());
        int i3 = 0;
        int i4 = 0;
        for (ResourcesSeason resourcesSeason : list2) {
            Object obj = null;
            if (i2 == 0) {
                List resolutions = resourcesSeason.getResolutions();
                if (resolutions != null) {
                    Iterator it = resolutions.iterator();
                    if (it.hasNext()) {
                        obj = it.next();
                        if (it.hasNext()) {
                            int epNum2 = ((ResolutionItem) obj).getEpNum();
                            do {
                                Object next = it.next();
                                int epNum3 = ((ResolutionItem) next).getEpNum();
                                if (epNum2 < epNum3) {
                                    obj = next;
                                    epNum2 = epNum3;
                                }
                            } while (it.hasNext());
                        }
                    }
                    ResolutionItem resolutionItem = (ResolutionItem) obj;
                    if (resolutionItem != null) {
                        a.a.c("DownloadRes", "initGetPositions,分辨率0  it.epNum:" + resolutionItem.getEpNum() + " ", true);
                        if (resourcesSeason.getSe() < i) {
                            i3 += resolutionItem.getEpNum();
                        }
                        if (resourcesSeason.getSe() <= i) {
                            epNum = resolutionItem.getEpNum();
                            i4 += epNum;
                        }
                    }
                }
            } else {
                List resolutions2 = resourcesSeason.getResolutions();
                if (resolutions2 != null) {
                    Iterator it2 = resolutions2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next2 = it2.next();
                        if (((ResolutionItem) next2).getResolution() == i2) {
                            obj = next2;
                            break;
                        }
                    }
                    ResolutionItem resolutionItem2 = (ResolutionItem) obj;
                    if (resolutionItem2 != null) {
                        a.a.c("DownloadRes", "initGetPositions,分辨率0  resolution:" + i2 + " ", true);
                        if (resourcesSeason.getSe() < i) {
                            i3 += resolutionItem2.getEpNum();
                        }
                        if (resourcesSeason.getSe() <= i) {
                            epNum = resolutionItem2.getEpNum();
                            i4 += epNum;
                        }
                    }
                }
            }
        }
        int i6 = i3 + 1;
        if (i4 < i6) {
            i4 = i6;
        }
        return new Pair(Integer.valueOf(i4), Integer.valueOf(i6));
    }

    public final void B(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "bean");
        if (downloadBean.getDownloadRanges().isEmpty()) {
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new initSetDownloadInfoAndRanges.1(downloadBean, (Continuation) null), 3, (Object) null);
        }
    }

    public final boolean C(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "data");
        boolean z = true;
        if (!downloadBean.isSeriesCollection()) {
            return true;
        }
        Iterator it = downloadBean.getSeriesList().iterator();
        while (it.hasNext()) {
            if (!((DownloadBean) it.next()).isCheck()) {
                z = false;
            }
        }
        return z;
    }

    public final boolean D() {
        if (Build.VERSION.SDK_INT > 29) {
            return true;
        }
        try {
            return PermissionUtils.s(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean E(DownloadBean downloadBean) {
        String subjectId;
        String resourceId;
        Object obj;
        Intrinsics.h(downloadBean, "bean");
        if (downloadBean.isVideo() && (subjectId = downloadBean.getSubjectId()) != null && subjectId.length() != 0 && (resourceId = downloadBean.getResourceId()) != null && resourceId.length() != 0) {
            ConfigBean c2 = f.c.a().c("download_error_opt_off", false);
            if (c2 == null || (obj = c2.getValue()) == null) {
                obj = 0;
            }
            DownloadException exception = downloadBean.getException();
            if (exception != null && exception.getCode() == downloadBean.getPreErrorCode() && Intrinsics.c(obj, 0)) {
                return false;
            }
            if ((downloadBean.isCNDError() || downloadBean.is4xxError()) && downloadBean.getRequestNewSourceCount() < 5) {
                return true;
            }
        }
        return false;
    }

    public final boolean F(Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        boolean z = false;
        for (String str : d) {
            if (!fragment.shouldShowRequestPermissionRationale(str)) {
                z = true;
            }
        }
        return z;
    }

    public final DownloadBean G(PostSubjectItem postSubjectItem) {
        String content;
        Integer height;
        Integer height2;
        Integer width;
        Integer duration;
        Integer size;
        List<Video> video;
        Intrinsics.h(postSubjectItem, "item");
        Media media = postSubjectItem.getMedia();
        if (!Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.VIDEO.getValue())) {
            Media media2 = postSubjectItem.getMedia();
            if (!Intrinsics.c(media2 != null ? media2.getMediaType() : null, "VIDEO")) {
                return null;
            }
        }
        Media media3 = postSubjectItem.getMedia();
        Video video2 = (media3 == null || (video = media3.getVideo()) == null) ? null : (Video) CollectionsKt.k0(video);
        String url = video2 != null ? video2.getUrl() : null;
        if (url != null && url.length() != 0) {
            String title = postSubjectItem.getTitle();
            if (title == null || title.length() == 0) {
                String content2 = postSubjectItem.getContent();
                content = (content2 == null || content2.length() == 0) ? "" : postSubjectItem.getContent();
            } else {
                content = postSubjectItem.getTitle();
            }
            String str = content;
            String postId = postSubjectItem.getPostId();
            if (postId == null) {
                postId = String.valueOf(url.hashCode());
            }
            String str2 = postId;
            String coverUrl = postSubjectItem.getCoverUrl(false);
            long j = 0;
            long intValue = (video2 == null || (size = video2.getSize()) == null) ? 0L : size.intValue();
            String postId2 = postSubjectItem.getPostId();
            if (video2 != null && (duration = video2.getDuration()) != null) {
                j = duration.intValue();
            }
            long j2 = 1000 * j;
            Subject subject = postSubjectItem.getSubject();
            String subjectId = subject != null ? subject.getSubjectId() : null;
            Subject subject2 = postSubjectItem.getSubject();
            String title2 = subject2 != null ? subject2.getTitle() : null;
            User user = postSubjectItem.getUser();
            String nickname = user != null ? user.getNickname() : null;
            int intValue2 = (video2 == null || (width = video2.getWidth()) == null) ? 0 : width.intValue();
            int intValue3 = (video2 == null || (height2 = video2.getHeight()) == null) ? 0 : height2.intValue();
            int intValue4 = (video2 == null || (height = video2.getHeight()) == null) ? 0 : height.intValue();
            String ops = postSubjectItem.getOps();
            String coverUrl2 = postSubjectItem.getCoverUrl(true);
            long currentTimeMillis = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis();
            String uuid = UUID.randomUUID().toString();
            Long valueOf = Long.valueOf(intValue);
            Long valueOf2 = Long.valueOf(j2);
            Long valueOf3 = Long.valueOf(currentTimeMillis2);
            r2 = r10;
            String downloadBean = new DownloadBean(url, str2, str, coverUrl, valueOf, postId2, (String) null, "", valueOf2, valueOf3, 0L, 0, 0, 9, 0L, currentTimeMillis, 0, 0, 0, 0, intValue4, 0, 0, intValue2, intValue3, 0, 0, subjectId, (String) null, (String) null, title2, 0L, 1, 0, nickname, (String) null, 0L, (String) null, uuid, 0L, 0, 0L, (String) null, 0, coverUrl2, (String) null, false, false, 1, (String) null, (Integer) null, (String) null, (String) null, ops, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, -1234219968, -2166854, 65535, (DefaultConstructorMarker) null);
            try {
                r2.setOriginData(o.j(postSubjectItem));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return r2;
    }

    public final void H(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "bean");
        downloadBean.setProgress(0L);
        Iterator it = downloadBean.getDownloadRanges().iterator();
        while (it.hasNext()) {
            ((DownloadRange) it.next()).setProgress(0L);
        }
    }

    public final void I(boolean z, DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "data");
        if (downloadBean.isSeriesCollection()) {
            downloadBean.setSeriesAllCheck(z);
            Iterator it = downloadBean.getSeriesList().iterator();
            while (it.hasNext()) {
                ((DownloadBean) it.next()).setCheck(z);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(android.content.Context r26, boolean r27, com.transsion.baselib.db.download.DownloadBean r28, java.lang.String r29, int r30, java.lang.String r31, int r32, kotlin.jvm.functions.Function2 r33, kotlin.jvm.functions.Function1 r34, boolean r35, kotlin.coroutines.Continuation r36) {
        /*
            Method dump skipped, instructions count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.util.DownloadUtil.J(android.content.Context, boolean, com.transsion.baselib.db.download.DownloadBean, java.lang.String, int, java.lang.String, int, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean i(DownloadBean downloadBean) {
        String path;
        Intrinsics.h(downloadBean, "bean");
        if (downloadBean.getProgress() != 0) {
            Long size = downloadBean.getSize();
            if ((size != null ? size.longValue() : 0L) > 31457280 && (path = downloadBean.getPath()) != null) {
                File file = new File(path);
                long length = file.length();
                if (!file.exists() || length <= 0) {
                    a.a.i("download", "文件不存在，重新下载，fileLength = " + length + ",progress = " + downloadBean.getProgress() + "，path = " + path, true);
                    return true;
                }
                long progress = downloadBean.getProgress() - length;
                if (progress > 5120) {
                    a.a.w("download", "文件已经开始出现异常 name：" + downloadBean.getTitleName(), true);
                }
                if (progress > 10485760) {
                    a.a.i("download", "重新下载，fileLength = " + length + ",progress = " + downloadBean.getProgress() + ",extra = " + progress + "，path = " + path, true);
                    return true;
                }
            }
        }
        return false;
    }

    public final DownloadBean j(Subject subject, String str, String str2, String str3, String str4, String str5) {
        String downloadUrl;
        ResourceDetectors resourceDetector;
        String str6;
        ResourceDetectors resourceDetector2;
        String resourceLink;
        ResourceDetectors resourceDetector3;
        Integer subjectType;
        ResourceDetectors resourceDetector4;
        Integer resolution;
        ResourceDetectors resourceDetector5;
        Cover cover;
        ResourceDetectors resourceDetector6;
        Cover cover2;
        String title;
        ResourceDetectors resourceDetector7;
        String resourceId;
        ResourceDetectors resourceDetector8;
        String downloadUrl2;
        ResourceDetectors resourceDetector9;
        DownloadEsHelper a2 = DownloadEsHelper.m.a();
        String str7 = "";
        if (subject == null || (resourceDetector9 = subject.getResourceDetector()) == null || (downloadUrl = resourceDetector9.getResourceId()) == null) {
            downloadUrl = (subject == null || (resourceDetector = subject.getResourceDetector()) == null) ? null : resourceDetector.getDownloadUrl();
            if (downloadUrl == null) {
                downloadUrl = "";
            }
        }
        DownloadBean q = a2.q(downloadUrl);
        if (q != null) {
            a.a.f(a.a, "downloadAna", "single， get download bean from database", false, 4, (Object) null);
        } else {
            q = new DownloadBean((subject == null || (resourceDetector8 = subject.getResourceDetector()) == null || (downloadUrl2 = resourceDetector8.getDownloadUrl()) == null) ? "" : downloadUrl2, (subject == null || (resourceDetector7 = subject.getResourceDetector()) == null || (resourceId = resourceDetector7.getResourceId()) == null) ? "" : resourceId, (subject == null || (title = subject.getTitle()) == null) ? "" : title, (subject == null || (cover2 = subject.getCover()) == null) ? null : cover2.getUrl(), (subject == null || (resourceDetector6 = subject.getResourceDetector()) == null) ? null : resourceDetector6.getTotalSize(), (String) null, (String) null, (String) null, (Long) null, (Long) null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, 0L, 0, 0, (String) null, (String) null, 0L, (String) null, (String) null, 0L, 0, 0L, (String) null, 0, (String) null, (String) null, false, false, 0, subject != null ? subject.getGenre() : null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, -32, -131073, 65535, (DefaultConstructorMarker) null);
            q.setGenre(subject != null ? subject.getGenre() : null);
            q.setRestrictLevel(subject != null ? subject.getRestrictLevel() : null);
            q.setReleaseDate(subject != null ? subject.getReleaseDate() : null);
            q.setImdbRate(subject != null ? subject.getImdbRate() : null);
            q.setCountryName(subject != null ? subject.getCountryName() : null);
            q.setSeNum(subject != null ? subject.getSeNum() : null);
            q.setSubtitles(subject != null ? subject.getSubtitles() : null);
            q.setThumbnail((subject == null || (cover = subject.getCover()) == null) ? null : cover.getThumbnail());
            q.setPostId((subject == null || (resourceDetector5 = subject.getResourceDetector()) == null) ? null : resourceDetector5.getPostId());
            q.setSubjectId(subject != null ? subject.getSubjectId() : null);
            q.setGroupId(str4);
            q.setSubjectName(subject != null ? subject.getTitle() : null);
            q.setResolution((subject == null || (resourceDetector4 = subject.getResourceDetector()) == null || (resolution = resourceDetector4.getResolution()) == null) ? 0 : resolution.intValue());
            q.setType(DownloadBean.Companion.c(subject != null ? subject.getSubjectType() : null));
            q.setSubjectType((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
            if (subject == null || (resourceDetector3 = subject.getResourceDetector()) == null || (str6 = resourceDetector3.getUploadBy()) == null) {
                str6 = str5 == null ? "" : str5;
            }
            q.setUploadBy(str6);
            if (subject != null && (resourceDetector2 = subject.getResourceDetector()) != null && (resourceLink = resourceDetector2.getResourceLink()) != null) {
                str7 = resourceLink;
            }
            q.setSourceUrl(str7);
        }
        a.a.f(a.a, "downloadAna", "single， add download task， " + q, false, 4, (Object) null);
        q.setCreateAt(System.currentTimeMillis());
        q.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
        q.setPageFrom(str);
        q.setLastPageFrom(str2);
        q.setOps(str3);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "toString(...)");
        q.setTaskId(uuid);
        q.setDuration(subject != null ? Long.valueOf(subject.getResourceAboutDuration()) : null);
        return q;
    }

    public final DownloadBean k(DownloadUrlBean downloadUrlBean, Subject subject, String str, String str2, String str3) {
        String str4;
        String str5;
        Integer subjectType;
        Integer resolution;
        Integer epse;
        Cover cover;
        Cover cover2;
        Cover cover3;
        String name;
        String resourceId;
        String url;
        Intrinsics.h(downloadUrlBean, "urlBean");
        DownloadItem resource = downloadUrlBean.getResource();
        int totalEpisode = downloadUrlBean.getTotalEpisode();
        DownloadBean downloadBean = new DownloadBean((resource == null || (url = resource.getUrl()) == null) ? "" : url, (resource == null || (resourceId = resource.getResourceId()) == null) ? "" : resourceId, (resource == null || (name = resource.getName()) == null) ? "" : name, (subject == null || (cover3 = subject.getCover()) == null) ? null : cover3.getUrl(), resource != null ? resource.getSize() : null, (String) null, (String) null, (String) null, (Long) null, (Long) null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, 0L, 0, 0, (String) null, (String) null, 0L, (String) null, (String) null, 0L, 0, 0L, (String) null, 0, (String) null, (String) null, false, false, 0, subject != null ? subject.getGenre() : null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, -32, -131073, 65535, (DefaultConstructorMarker) null);
        downloadBean.setThumbnail((subject == null || (cover2 = subject.getCover()) == null) ? null : cover2.getThumbnail());
        downloadBean.setGenre(subject != null ? subject.getGenre() : null);
        downloadBean.setRestrictLevel(subject != null ? subject.getRestrictLevel() : null);
        downloadBean.setReleaseDate(subject != null ? subject.getReleaseDate() : null);
        downloadBean.setImdbRate(subject != null ? subject.getImdbRate() : null);
        downloadBean.setCountryName(subject != null ? subject.getCountryName() : null);
        downloadBean.setSeNum(subject != null ? subject.getSeNum() : null);
        downloadBean.setSubtitles(subject != null ? subject.getSubtitles() : null);
        downloadBean.setAverageHueLight((subject == null || (cover = subject.getCover()) == null) ? null : cover.getAverageHueLight());
        downloadBean.setSubjectDurationSeconds(subject != null ? subject.getDurationSeconds() : null);
        if (resource == null || (str4 = resource.getUploadBy()) == null) {
            str4 = "";
        }
        downloadBean.setUploadBy(str4);
        if (resource == null || (str5 = resource.getSourceUrl()) == null) {
            str5 = "";
        }
        downloadBean.setSourceUrl(str5);
        downloadBean.setPostId(resource != null ? resource.getPostId() : null);
        int i = 0;
        downloadBean.setEpse((resource == null || (epse = resource.getEpse()) == null) ? 0 : epse.intValue());
        downloadBean.setEp(resource != null ? resource.getEp() : 0);
        downloadBean.setSe(resource != null ? resource.getSe() : 0);
        if (resource != null && (resolution = resource.getResolution()) != null) {
            i = resolution.intValue();
        }
        downloadBean.setResolution(i);
        downloadBean.setSubjectId(subject != null ? subject.getSubjectId() : null);
        downloadBean.setType(DownloadBean.Companion.c(subject != null ? subject.getSubjectType() : null));
        downloadBean.setSubjectType((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
        downloadBean.setTotalEpisode(totalEpisode);
        downloadBean.setCreateAt(System.currentTimeMillis());
        downloadBean.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
        String title = subject != null ? subject.getTitle() : null;
        downloadBean.setSubjectName((title == null || title.length() == 0) ? downloadUrlBean.getName() : subject != null ? subject.getTitle() : null);
        downloadBean.setPageFrom(str);
        downloadBean.setLastPageFrom(str2);
        downloadBean.setOps(str3);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "toString(...)");
        downloadBean.setTaskId(uuid);
        downloadBean.setDuration(subject != null ? Long.valueOf(subject.getResourceAboutDuration()) : null);
        return downloadBean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PostSubjectItem l(DownloadBean downloadBean) {
        List<Video> video;
        Intrinsics.h(downloadBean, "bean");
        String originData = downloadBean.getOriginData();
        if (originData != null && originData.length() != 0) {
            try {
                PostSubjectItem postSubjectItem = (PostSubjectItem) o.d(downloadBean.getOriginData(), PostSubjectItem.class);
                if (postSubjectItem != null) {
                    Media media = postSubjectItem.getMedia();
                    Video video2 = (media == null || (video = media.getVideo()) == null) ? null : (Video) CollectionsKt.k0(video);
                    if (video2 != null) {
                        video2.setUrl(downloadBean.getPath());
                    }
                    return postSubjectItem;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String path = downloadBean.getPath();
        int videoWidth = downloadBean.getVideoWidth();
        int videoHeight = downloadBean.getVideoHeight();
        Long duration = downloadBean.getDuration();
        Media media2 = new Media(null, new Cover(null, null, null, downloadBean.getCover(), null, downloadBean.getThumbnail(), null, null, null, 471, null), null, null, MediaType.VIDEO.getValue(), CollectionsKt.e(new Video(0, 0, duration != null ? Integer.valueOf((int) duration.longValue()) : null, 0, Integer.valueOf(videoHeight), 0, path, Integer.valueOf(videoWidth))), null);
        String subjectId = downloadBean.getSubjectId();
        String subjectName = downloadBean.getSubjectName();
        int subjectType = downloadBean.getSubjectType();
        String releaseDate = downloadBean.getReleaseDate();
        if (releaseDate == null) {
            releaseDate = c0.i(downloadBean.getCreateAt(), "yyyy-MM-dd");
        }
        return new PostSubjectItem(null, String.valueOf(downloadBean.getCreateAt()), null, null, null, null, media2, downloadBean.getPostId(), null, null, new Subject(subjectId, Integer.valueOf(subjectType), subjectName, null, null, releaseDate, null, null, null, downloadBean.getGenre(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, -552, 67108863, null), null, downloadBean.getTitleName(), null, null, null, null == true ? 1 : 0, null, null, false, null == true ? 1 : 0, null, null == true ? 1 : 0, null, false, null == true ? 1 : 0, false, null, true, false, false, false, null, -268440771, 1, null);
    }

    public final long o(DownloadBean downloadBean) {
        Long duration;
        Intrinsics.h(downloadBean, "bean");
        if (downloadBean.getDuration() == null || ((duration = downloadBean.getDuration()) != null && duration.longValue() == 0)) {
            return downloadBean.getType() != 2 ? 5242880L : 7864320L;
        }
        Long duration2 = downloadBean.getDuration();
        Intrinsics.e(duration2);
        long longValue = duration2.longValue() - 3600000;
        if (longValue > 0) {
            long j = ((46080 * longValue) / 60000) + 5242880;
            if (j > 9437184) {
                return 9437184L;
            }
            return j;
        }
        long abs = 5242880 - ((87040 * Math.abs(longValue)) / 60000);
        if (abs < 3145728) {
            return 3145728L;
        }
        return abs;
    }

    public final int r(DownloadBean downloadBean) {
        Integer valueOf = downloadBean != null ? Integer.valueOf(downloadBean.getType()) : null;
        return (valueOf != null && valueOf.intValue() == 1) ? R$mipmap.home_ic_audio_white : (valueOf != null && valueOf.intValue() == 3) ? downloadBean.isShotTV() ? R$mipmap.home_ic_short_tv_white : R$mipmap.home_ic_tv_white : R$mipmap.home_ic_movie_white;
    }

    public final String s(DownloadBean downloadBean) {
        File parentFile;
        Intrinsics.h(downloadBean, "bean");
        String replace = new Regex("[\\\\/:#*?\"<>|&,]").replace(downloadBean.getFileName(), "");
        String f1 = StringsKt.f1(StringsKt.h1(downloadBean.getUrl(), "?", (String) null, 2, (Object) null), ".", (String) null, 2, (Object) null);
        if (f1.length() == 0) {
            f1 = "mp4";
        }
        DownloadEsHelper.a aVar = DownloadEsHelper.m;
        String absolutePath = u((aVar.a().h().getAbsolutePath() + File.separatorChar + replace) + "." + f1).getAbsolutePath();
        downloadBean.setRootPath(aVar.a().t());
        downloadBean.setRootPathType(aVar.a().u());
        File file = new File(absolutePath);
        if (!file.exists()) {
            try {
                Result.Companion companion = Result.Companion;
                if (file.getParentFile() != null && (!r1.exists()) && (parentFile = file.getParentFile()) != null) {
                    parentFile.mkdirs();
                }
                Result.m34constructorimpl(Boolean.valueOf(file.createNewFile()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m34constructorimpl(ResultKt.a(th));
            }
        }
        Intrinsics.e(absolutePath);
        return absolutePath;
    }

    public final int t(List list, int i) {
        Object obj;
        Object obj2;
        List resolutions;
        Intrinsics.h(list, "seasons");
        Iterator it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((ResourcesSeason) obj2).getSe() == i) {
                break;
            }
        }
        ResourcesSeason resourcesSeason = (ResourcesSeason) obj2;
        if (resourcesSeason == null || (resolutions = resourcesSeason.getResolutions()) == null) {
            return 0;
        }
        Iterator it2 = resolutions.iterator();
        if (it2.hasNext()) {
            obj = it2.next();
            if (it2.hasNext()) {
                int epNum = ((ResolutionItem) obj).getEpNum();
                do {
                    Object next = it2.next();
                    int epNum2 = ((ResolutionItem) next).getEpNum();
                    if (epNum < epNum2) {
                        obj = next;
                        epNum = epNum2;
                    }
                } while (it2.hasNext());
            }
        }
        ResolutionItem resolutionItem = (ResolutionItem) obj;
        if (resolutionItem != null) {
            return resolutionItem.getResolution();
        }
        return 0;
    }

    public final String[] v() {
        return d;
    }

    public final int w(List list) {
        int i;
        if (list == null) {
            return 0;
        }
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            DownloadBean downloadBean = (DownloadBean) it.next();
            if (downloadBean.getStatus() != 10) {
                i = 1;
            } else if (downloadBean.isSeriesAllCheck()) {
                i = downloadBean.getSeriesList().size();
            } else {
                Iterator it2 = downloadBean.getSeriesList().iterator();
                int i3 = 0;
                while (it2.hasNext()) {
                    if (((DownloadBean) it2.next()).isCheck()) {
                        i3++;
                    }
                }
                i = i3;
            }
            i2 += i;
        }
        return i2;
    }

    public final List x(DownloadListBean downloadListBean, Subject subject, String str, String str2, String str3, String str4, String str5, List list) {
        List<DownloadItem> items;
        DownloadBean z;
        Object obj;
        ArrayList arrayList = new ArrayList();
        if (downloadListBean != null && (items = downloadListBean.getItems()) != null) {
            for (DownloadItem downloadItem : items) {
                if (list == null || !(!list.isEmpty())) {
                    z = a.z(downloadListBean, subject, downloadItem, str, str2, str3, str4, str5);
                } else {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (Intrinsics.c(((DownloadBean) obj).getResourceId(), downloadItem.getResourceId())) {
                            break;
                        }
                    }
                    z = (DownloadBean) obj;
                    if (z == null) {
                        z = a.z(downloadListBean, subject, downloadItem, str, str2, str3, str4, str5);
                    }
                }
                arrayList.add(z);
            }
        }
        return arrayList;
    }
}
