package zk;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.flow.bean.PlayUrl;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.AppointSubject;
import com.transsion.home.bean.BannerBean;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.CustomData;
import com.transsion.home.bean.LiveListItem;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingListData;
import com.transsion.home.bean.RankingListItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.ugcvideodetail.api.bean.UGCCollection;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsnet.downloader.DownloadManagerApi;
import ij.t;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class h {
    public static final void c(List list, final String str) {
        List<BannerData> items;
        List<UGCContent> contentList;
        List<RankingListItem> items2;
        List<BannerData> banners;
        if (str == null || str.length() == 0) {
            return;
        }
        Function1 function1 = new Function1() { // from class: zk.f
            public final Object invoke(Object obj) {
                Unit d;
                d = h.d(str, (List) obj);
                return d;
            }
        };
        Function1 function12 = new Function1() { // from class: zk.g
            public final Object invoke(Object obj) {
                Unit e;
                e = h.e(str, (List) obj);
                return e;
            }
        };
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                OperateItem operateItem = (OperateItem) it.next();
                operateItem.setOps(str);
                BannerBean banner = operateItem.getBanner();
                List<BannerData> banners2 = banner != null ? banner.getBanners() : null;
                if (banners2 == null || banners2.isEmpty()) {
                    List<AppointSubject> subjects = operateItem.getSubjects();
                    if (subjects == null || subjects.isEmpty()) {
                        CustomData customData = operateItem.getCustomData();
                        if ((customData != null ? customData.getItems() : null) != null) {
                            CustomData customData2 = operateItem.getCustomData();
                            if (customData2 != null && (items = customData2.getItems()) != null) {
                                Iterator<T> it2 = items.iterator();
                                while (it2.hasNext()) {
                                    ((BannerData) it2.next()).setOps(str);
                                }
                            }
                        } else {
                            List<Subject> rankings = operateItem.getRankings();
                            if (rankings == null || rankings.isEmpty()) {
                                RankingListData rankingListData = operateItem.getRankingListData();
                                List<RankingListItem> items3 = rankingListData != null ? rankingListData.getItems() : null;
                                if (items3 != null && !items3.isEmpty()) {
                                    RankingListData rankingListData2 = operateItem.getRankingListData();
                                    if (rankingListData2 != null && (items2 = rankingListData2.getItems()) != null) {
                                        for (RankingListItem rankingListItem : items2) {
                                            function1.invoke(rankingListItem.getSubjects());
                                            function12.invoke(rankingListItem.getContentList());
                                        }
                                    }
                                } else if (operateItem.getFeedsSubject() != null) {
                                    Subject feedsSubject = operateItem.getFeedsSubject();
                                    String ops = feedsSubject != null ? feedsSubject.getOps() : null;
                                    if (ops == null || ops.length() == 0) {
                                        Subject feedsSubject2 = operateItem.getFeedsSubject();
                                        if (feedsSubject2 != null) {
                                            feedsSubject2.setOps(str);
                                        }
                                    }
                                } else {
                                    List<LiveListItem> liveList = operateItem.getLiveList();
                                    if (liveList != null && !liveList.isEmpty()) {
                                        List<LiveListItem> liveList2 = operateItem.getLiveList();
                                        if (liveList2 != null) {
                                            for (LiveListItem liveListItem : liveList2) {
                                                String ops2 = liveListItem.getOps();
                                                if (ops2 == null || ops2.length() == 0) {
                                                    liveListItem.setOps(str);
                                                }
                                            }
                                        }
                                    } else if (operateItem.getContentList() != null && (contentList = operateItem.getContentList()) != null) {
                                        for (UGCContent uGCContent : contentList) {
                                            if (uGCContent.getVideo() != null) {
                                                UGCVideo video = uGCContent.getVideo();
                                                String ops3 = video != null ? video.getOps() : null;
                                                if (ops3 == null || ops3.length() == 0) {
                                                    UGCVideo video2 = uGCContent.getVideo();
                                                    if (video2 != null) {
                                                        video2.setOps(str);
                                                    }
                                                }
                                            }
                                            if (uGCContent.getCollection() != null) {
                                                UGCCollection collection = uGCContent.getCollection();
                                                String ops4 = collection != null ? collection.getOps() : null;
                                                if (ops4 == null || ops4.length() == 0) {
                                                    UGCCollection collection2 = uGCContent.getCollection();
                                                    if (collection2 != null) {
                                                        collection2.setOps(str);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                function1.invoke(operateItem.getRankings());
                            }
                        }
                    } else {
                        function1.invoke(operateItem.getSubjects());
                    }
                } else {
                    BannerBean banner2 = operateItem.getBanner();
                    if (banner2 != null && (banners = banner2.getBanners()) != null) {
                        for (BannerData bannerData : banners) {
                            if (bannerData != null) {
                                bannerData.setOps(str);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(String str, List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Subject subject = (Subject) it.next();
                String ops = subject.getOps();
                if (ops == null || ops.length() == 0) {
                    subject.setOps(str);
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(String str, List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                UGCContent uGCContent = (UGCContent) it.next();
                UGCVideo video = uGCContent.getVideo();
                String ops = video != null ? video.getOps() : null;
                if (ops == null || ops.length() == 0) {
                    UGCVideo video2 = uGCContent.getVideo();
                    if (video2 != null) {
                        video2.setOps(str);
                    }
                }
            }
        }
        return Unit.a;
    }

    public static final void f(Subject subject, String str) {
        String playUrl;
        String playUrl2;
        Intrinsics.h(str, "playModule");
        if (subject == null) {
            return;
        }
        if (subject.isJumpBrowser()) {
            PlayUrl playUrl3 = subject.getPlayUrl();
            if (playUrl3 == null || (playUrl2 = playUrl3.getPlayUrl()) == null) {
                return;
            }
            ij.k.i(playUrl2);
            return;
        }
        if (!subject.isJumpWebview()) {
            Navigator c = TheRouter.c("/movie/detail");
            Integer subjectType = subject.getSubjectType();
            ij.k.p(c.F("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.MOVIE.getValue()).K("id", subject.getSubjectId()).K("module_name", str).F("season", subject.getSeason()).z("autoPlay", true).K("ops", subject.getOps()));
        } else {
            PlayUrl playUrl4 = subject.getPlayUrl();
            if (playUrl4 == null || (playUrl = playUrl4.getPlayUrl()) == null) {
                return;
            }
            ij.k.h(playUrl, null, 1, null);
        }
    }

    public static final String g(Subject subject, String str, Context context, String str2) {
        String str3;
        ResourceDetectors resourceDetector;
        String subjectId;
        ResourceDetectors resourceDetector2;
        Intrinsics.h(str, "pageName");
        Intrinsics.h(context, "context");
        Intrinsics.h(str2, "playModule");
        if (subject != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi.e0(DownloadManagerApi.j.a(), (FragmentActivity) context, str, BuildConfig.FLAVOR, subject.getOps(), "download_subject", true, subject, (String) null, (Boolean) null, 384, (Object) null);
                return "download_subject";
            }
        }
        if (t.a.b()) {
            f(subject, str2);
        } else {
            DownloadManagerApi.a aVar = DownloadManagerApi.j;
            if (!DownloadManagerApi.x0(aVar.a(), subject != null ? subject.getSubjectId() : null, (subject == null || (resourceDetector2 = subject.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId(), subject != null && subject.isSeries(), false, 8, (Object) null)) {
                DownloadManagerApi a = aVar.a();
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                String ops = subject != null ? subject.getOps() : null;
                if (subject == null || (resourceDetector = subject.getResourceDetector()) == null || (str3 = resourceDetector.getResourceLink()) == null) {
                    str3 = BuildConfig.FLAVOR;
                }
                DownloadManagerApi.M(a, fragmentActivity, subject, str, (String) null, ops, str3, (String) null, (String) null, (String) null, false, 960, (Object) null);
                return "download_subject";
            }
            if (subject != null && (subjectId = subject.getSubjectId()) != null) {
                DownloadManagerApi.z0(aVar.a(), subjectId, context, str, (String) null, 8, (Object) null);
            }
        }
        return "play_subject";
    }
}
