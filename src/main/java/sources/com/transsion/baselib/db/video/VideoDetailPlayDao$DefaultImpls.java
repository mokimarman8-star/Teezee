package com.transsion.baselib.db.video;

import com.transsion.gslb.BuildConfig;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class VideoDetailPlayDao$DefaultImpls {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object a(VideoDetailPlayDao videoDetailPlayDao, String str, Continuation continuation) {
        VideoDetailPlayDao$getHistory$1 videoDetailPlayDao$getHistory$1;
        int i;
        VideoDetailPlayBean videoDetailPlayBean;
        Object obj;
        VideoDetailPlayBean videoDetailPlayBean2;
        String str2;
        VideoDetailPlayBean videoDetailPlayBean3;
        VideoDetailPlayDao videoDetailPlayDao2 = videoDetailPlayDao;
        String str3 = str;
        if (continuation instanceof VideoDetailPlayDao$getHistory$1) {
            videoDetailPlayDao$getHistory$1 = (VideoDetailPlayDao$getHistory$1) continuation;
            int i2 = videoDetailPlayDao$getHistory$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                videoDetailPlayDao$getHistory$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = videoDetailPlayDao$getHistory$1.result;
                Object f = IntrinsicsKt.f();
                i = videoDetailPlayDao$getHistory$1.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    videoDetailPlayDao$getHistory$1.L$0 = videoDetailPlayDao2;
                    videoDetailPlayDao$getHistory$1.L$1 = str3;
                    videoDetailPlayDao$getHistory$1.label = 1;
                    obj2 = videoDetailPlayDao2.n(str3, videoDetailPlayDao$getHistory$1);
                    if (obj2 == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                ResultKt.b(obj2);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        videoDetailPlayBean2 = (VideoDetailPlayBean) videoDetailPlayDao$getHistory$1.L$1;
                        String str4 = (String) videoDetailPlayDao$getHistory$1.L$0;
                        ResultKt.b(obj2);
                        str2 = str4;
                        obj = obj2;
                        videoDetailPlayBean3 = (VideoDetailPlayBean) obj;
                        if (videoDetailPlayBean3 != null) {
                            return new VideoDetailPlayBean(str2, videoDetailPlayBean2.getId(), videoDetailPlayBean2.getEp(), videoDetailPlayBean2.getSe(), videoDetailPlayBean2.getProgress(), videoDetailPlayBean2.getTitle(), videoDetailPlayBean2.getCoverUrl(), videoDetailPlayBean2.getThumbnail(), videoDetailPlayBean2.getVideoUrl(), videoDetailPlayBean2.getTimeStamp(), videoDetailPlayBean2.getSubtitleSelectId(), videoDetailPlayBean2.getTotalDuration(), videoDetailPlayBean2.getSubjectDurationSeconds(), videoDetailPlayBean2.getAverageHueLight(), videoDetailPlayBean2.getSubjectType(), videoDetailPlayBean2.getHasDelete(), videoDetailPlayBean2.getPlayMode(), videoDetailPlayBean2.getDownloadUrl(), videoDetailPlayBean2.getDownloadFilePath(), videoDetailPlayBean2.getDownloadSize(), videoDetailPlayBean2.getDubs(), null, null, false, false, false, null, 132120576, null);
                        }
                        videoDetailPlayBean3.setProgress(videoDetailPlayBean2.getProgress());
                        return videoDetailPlayBean3;
                    }
                    String str5 = (String) videoDetailPlayDao$getHistory$1.L$1;
                    VideoDetailPlayDao videoDetailPlayDao3 = (VideoDetailPlayDao) videoDetailPlayDao$getHistory$1.L$0;
                    ResultKt.b(obj2);
                    str3 = str5;
                    videoDetailPlayDao2 = videoDetailPlayDao3;
                }
                videoDetailPlayBean = (VideoDetailPlayBean) obj2;
                if (videoDetailPlayBean != null) {
                    videoDetailPlayDao$getHistory$1.L$0 = null;
                    videoDetailPlayDao$getHistory$1.L$1 = null;
                    videoDetailPlayDao$getHistory$1.label = 3;
                    obj2 = videoDetailPlayDao2.e(str3, videoDetailPlayDao$getHistory$1);
                    return obj2 == f ? f : obj2;
                }
                if (Intrinsics.c(videoDetailPlayBean.getSubjectId(), str3)) {
                    return videoDetailPlayBean;
                }
                videoDetailPlayDao$getHistory$1.L$0 = str3;
                videoDetailPlayDao$getHistory$1.L$1 = videoDetailPlayBean;
                videoDetailPlayDao$getHistory$1.label = 2;
                Object e = videoDetailPlayDao2.e(str3, videoDetailPlayDao$getHistory$1);
                if (e == f) {
                    return f;
                }
                String str6 = str3;
                obj = e;
                videoDetailPlayBean2 = videoDetailPlayBean;
                str2 = str6;
                videoDetailPlayBean3 = (VideoDetailPlayBean) obj;
                if (videoDetailPlayBean3 != null) {
                }
            }
        }
        videoDetailPlayDao$getHistory$1 = new VideoDetailPlayDao$getHistory$1(continuation);
        Object obj22 = videoDetailPlayDao$getHistory$1.result;
        Object f2 = IntrinsicsKt.f();
        i = videoDetailPlayDao$getHistory$1.label;
        if (i != 0) {
        }
        videoDetailPlayBean = (VideoDetailPlayBean) obj22;
        if (videoDetailPlayBean != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object b(VideoDetailPlayDao videoDetailPlayDao, VideoDetailPlayBean videoDetailPlayBean, Continuation continuation) {
        VideoDetailPlayDao$insertOrUpdate$1 videoDetailPlayDao$insertOrUpdate$1;
        Object obj;
        int i;
        if (continuation instanceof VideoDetailPlayDao$insertOrUpdate$1) {
            videoDetailPlayDao$insertOrUpdate$1 = (VideoDetailPlayDao$insertOrUpdate$1) continuation;
            int i2 = videoDetailPlayDao$insertOrUpdate$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                videoDetailPlayDao$insertOrUpdate$1.label = i2 - Integer.MIN_VALUE;
                obj = videoDetailPlayDao$insertOrUpdate$1.result;
                Object f = IntrinsicsKt.f();
                i = videoDetailPlayDao$insertOrUpdate$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    String subjectId = videoDetailPlayBean.getSubjectId();
                    int se = videoDetailPlayBean.getSe();
                    int ep2 = videoDetailPlayBean.getEp();
                    videoDetailPlayDao$insertOrUpdate$1.L$0 = videoDetailPlayDao;
                    videoDetailPlayDao$insertOrUpdate$1.L$1 = videoDetailPlayBean;
                    videoDetailPlayDao$insertOrUpdate$1.label = 1;
                    obj = videoDetailPlayDao.m(subjectId, se, ep2, videoDetailPlayDao$insertOrUpdate$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.b(obj);
                            return Unit.a;
                        }
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        return Unit.a;
                    }
                    videoDetailPlayBean = (VideoDetailPlayBean) videoDetailPlayDao$insertOrUpdate$1.L$1;
                    videoDetailPlayDao = (VideoDetailPlayDao) videoDetailPlayDao$insertOrUpdate$1.L$0;
                    ResultKt.b(obj);
                }
                if (obj != null) {
                    videoDetailPlayDao$insertOrUpdate$1.L$0 = null;
                    videoDetailPlayDao$insertOrUpdate$1.L$1 = null;
                    videoDetailPlayDao$insertOrUpdate$1.label = 2;
                    if (videoDetailPlayDao.o(videoDetailPlayBean, videoDetailPlayDao$insertOrUpdate$1) == f) {
                        return f;
                    }
                    return Unit.a;
                }
                videoDetailPlayDao$insertOrUpdate$1.L$0 = null;
                videoDetailPlayDao$insertOrUpdate$1.L$1 = null;
                videoDetailPlayDao$insertOrUpdate$1.label = 3;
                if (videoDetailPlayDao.k(videoDetailPlayBean, videoDetailPlayDao$insertOrUpdate$1) == f) {
                    return f;
                }
                return Unit.a;
            }
        }
        videoDetailPlayDao$insertOrUpdate$1 = new VideoDetailPlayDao$insertOrUpdate$1(continuation);
        obj = videoDetailPlayDao$insertOrUpdate$1.result;
        Object f2 = IntrinsicsKt.f();
        i = videoDetailPlayDao$insertOrUpdate$1.label;
        if (i != 0) {
        }
        if (obj != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x015c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object c(VideoDetailPlayDao videoDetailPlayDao, String str, int i, int i2, long j, long j2, Continuation continuation) {
        VideoDetailPlayDao$insertOrUpdateProgress$1 videoDetailPlayDao$insertOrUpdateProgress$1;
        int i3;
        long j3;
        int i4;
        VideoDetailPlayDao videoDetailPlayDao2;
        String str2;
        Object obj;
        int i5;
        long j4;
        Object obj2;
        long j5;
        VideoDetailPlayDao videoDetailPlayDao3;
        long j6;
        int i6;
        long j7;
        int i7;
        String str3;
        VideoDetailPlayDao videoDetailPlayDao4;
        VideoDetailPlayBean videoDetailPlayBean;
        VideoDetailPlayBean videoDetailPlayBean2;
        if (continuation instanceof VideoDetailPlayDao$insertOrUpdateProgress$1) {
            videoDetailPlayDao$insertOrUpdateProgress$1 = (VideoDetailPlayDao$insertOrUpdateProgress$1) continuation;
            int i8 = videoDetailPlayDao$insertOrUpdateProgress$1.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                videoDetailPlayDao$insertOrUpdateProgress$1.label = i8 - Integer.MIN_VALUE;
                Object obj3 = videoDetailPlayDao$insertOrUpdateProgress$1.result;
                Object f = IntrinsicsKt.f();
                i3 = videoDetailPlayDao$insertOrUpdateProgress$1.label;
                if (i3 != 0) {
                    ResultKt.b(obj3);
                    videoDetailPlayDao$insertOrUpdateProgress$1.L$0 = videoDetailPlayDao;
                    videoDetailPlayDao$insertOrUpdateProgress$1.L$1 = str;
                    videoDetailPlayDao$insertOrUpdateProgress$1.I$0 = i;
                    videoDetailPlayDao$insertOrUpdateProgress$1.I$1 = i2;
                    videoDetailPlayDao$insertOrUpdateProgress$1.J$0 = j;
                    j3 = j2;
                    videoDetailPlayDao$insertOrUpdateProgress$1.J$1 = j3;
                    videoDetailPlayDao$insertOrUpdateProgress$1.label = 1;
                    Object m = videoDetailPlayDao.m(str, i, i2, videoDetailPlayDao$insertOrUpdateProgress$1);
                    if (m == f) {
                        return f;
                    }
                    i4 = i;
                    videoDetailPlayDao2 = videoDetailPlayDao;
                    str2 = str;
                    obj = m;
                    i5 = i2;
                    j4 = j;
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.b(obj3);
                                return Unit.a;
                            }
                            if (i3 != 4) {
                                if (i3 != 5) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.b(obj3);
                                return Unit.a;
                            }
                            j5 = videoDetailPlayDao$insertOrUpdateProgress$1.J$0;
                            videoDetailPlayDao3 = (VideoDetailPlayDao) videoDetailPlayDao$insertOrUpdateProgress$1.L$0;
                            ResultKt.b(obj3);
                            obj2 = obj3;
                            videoDetailPlayBean2 = (VideoDetailPlayBean) obj2;
                            if (videoDetailPlayBean2 != null) {
                                videoDetailPlayBean2.setProgress(j5);
                                videoDetailPlayDao$insertOrUpdateProgress$1.L$0 = null;
                                videoDetailPlayDao$insertOrUpdateProgress$1.label = 5;
                                if (videoDetailPlayDao3.k(videoDetailPlayBean2, videoDetailPlayDao$insertOrUpdateProgress$1) == f) {
                                    return f;
                                }
                            }
                            return Unit.a;
                        }
                        long j8 = videoDetailPlayDao$insertOrUpdateProgress$1.J$1;
                        long j9 = videoDetailPlayDao$insertOrUpdateProgress$1.J$0;
                        int i9 = videoDetailPlayDao$insertOrUpdateProgress$1.I$1;
                        int i10 = videoDetailPlayDao$insertOrUpdateProgress$1.I$0;
                        String str4 = (String) videoDetailPlayDao$insertOrUpdateProgress$1.L$1;
                        videoDetailPlayDao4 = (VideoDetailPlayDao) videoDetailPlayDao$insertOrUpdateProgress$1.L$0;
                        ResultKt.b(obj3);
                        j7 = j8;
                        j6 = j9;
                        i6 = i9;
                        i7 = i10;
                        str3 = str4;
                        VideoDetailPlayBean videoDetailPlayBean3 = (VideoDetailPlayBean) obj3;
                        videoDetailPlayBean = videoDetailPlayBean3 == null ? new VideoDetailPlayBean(videoDetailPlayBean3.getSubjectId(), videoDetailPlayBean3.getId(), i6, i7, j7, null, null, null, null, j6, null, null, null, null, null, false, null, null, null, 0L, null, null, null, false, false, false, null, 134217184, null) : new VideoDetailPlayBean(str3, BuildConfig.FLAVOR, i6, i7, j7, null, null, null, null, j6, null, null, null, null, null, false, null, null, null, 0L, null, null, null, false, false, false, null, 134217184, null);
                        videoDetailPlayDao$insertOrUpdateProgress$1.L$0 = null;
                        videoDetailPlayDao$insertOrUpdateProgress$1.L$1 = null;
                        videoDetailPlayDao$insertOrUpdateProgress$1.label = 3;
                        if (videoDetailPlayDao4.o(videoDetailPlayBean, videoDetailPlayDao$insertOrUpdateProgress$1) == f) {
                            return f;
                        }
                        return Unit.a;
                    }
                    long j10 = videoDetailPlayDao$insertOrUpdateProgress$1.J$1;
                    j4 = videoDetailPlayDao$insertOrUpdateProgress$1.J$0;
                    i5 = videoDetailPlayDao$insertOrUpdateProgress$1.I$1;
                    i4 = videoDetailPlayDao$insertOrUpdateProgress$1.I$0;
                    str2 = (String) videoDetailPlayDao$insertOrUpdateProgress$1.L$1;
                    videoDetailPlayDao2 = (VideoDetailPlayDao) videoDetailPlayDao$insertOrUpdateProgress$1.L$0;
                    ResultKt.b(obj3);
                    j3 = j10;
                    obj = obj3;
                }
                if (obj == null) {
                    videoDetailPlayDao$insertOrUpdateProgress$1.L$0 = videoDetailPlayDao2;
                    videoDetailPlayDao$insertOrUpdateProgress$1.L$1 = null;
                    videoDetailPlayDao$insertOrUpdateProgress$1.J$0 = j3;
                    videoDetailPlayDao$insertOrUpdateProgress$1.label = 4;
                    Object l = videoDetailPlayDao2.l(str2, i4, i5, videoDetailPlayDao$insertOrUpdateProgress$1);
                    if (l == f) {
                        return f;
                    }
                    obj2 = l;
                    j5 = j3;
                    videoDetailPlayDao3 = videoDetailPlayDao2;
                    videoDetailPlayBean2 = (VideoDetailPlayBean) obj2;
                    if (videoDetailPlayBean2 != null) {
                    }
                    return Unit.a;
                }
                videoDetailPlayDao$insertOrUpdateProgress$1.L$0 = videoDetailPlayDao2;
                videoDetailPlayDao$insertOrUpdateProgress$1.L$1 = str2;
                videoDetailPlayDao$insertOrUpdateProgress$1.I$0 = i4;
                videoDetailPlayDao$insertOrUpdateProgress$1.I$1 = i5;
                videoDetailPlayDao$insertOrUpdateProgress$1.J$0 = j4;
                videoDetailPlayDao$insertOrUpdateProgress$1.J$1 = j3;
                videoDetailPlayDao$insertOrUpdateProgress$1.label = 2;
                obj3 = videoDetailPlayDao2.c(str2, videoDetailPlayDao$insertOrUpdateProgress$1);
                if (obj3 == f) {
                    return f;
                }
                j6 = j4;
                i6 = i5;
                j7 = j3;
                i7 = i4;
                str3 = str2;
                videoDetailPlayDao4 = videoDetailPlayDao2;
                VideoDetailPlayBean videoDetailPlayBean32 = (VideoDetailPlayBean) obj3;
                if (videoDetailPlayBean32 == null) {
                }
                videoDetailPlayDao$insertOrUpdateProgress$1.L$0 = null;
                videoDetailPlayDao$insertOrUpdateProgress$1.L$1 = null;
                videoDetailPlayDao$insertOrUpdateProgress$1.label = 3;
                if (videoDetailPlayDao4.o(videoDetailPlayBean, videoDetailPlayDao$insertOrUpdateProgress$1) == f) {
                }
                return Unit.a;
            }
        }
        videoDetailPlayDao$insertOrUpdateProgress$1 = new VideoDetailPlayDao$insertOrUpdateProgress$1(continuation);
        Object obj32 = videoDetailPlayDao$insertOrUpdateProgress$1.result;
        Object f2 = IntrinsicsKt.f();
        i3 = videoDetailPlayDao$insertOrUpdateProgress$1.label;
        if (i3 != 0) {
        }
        if (obj == null) {
        }
    }
}
