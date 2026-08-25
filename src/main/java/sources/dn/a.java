package dn;

import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.flow.bean.LayoutStyle;
import com.transsion.flow.bean.PlayUrl;
import com.transsion.flow.bean.SubjectGameInfo;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectDl;
import com.transsion.moviedetailapi.bean.Trailer;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    public static final Subject a(DownloadBean downloadBean) {
        if (downloadBean == null) {
            return null;
        }
        String subjectId = downloadBean.getSubjectId();
        int subjectType = downloadBean.getSubjectType();
        Long duration = downloadBean.getDuration();
        String l = duration != null ? duration.toString() : null;
        String titleNameAppendResolution = downloadBean.getTitleNameAppendResolution();
        Cover cover = new Cover((Integer) null, (Integer) null, (Integer) null, downloadBean.getCover(), (String) null, downloadBean.getThumbnail(), (GifBean) null, (String) null, (String) null, 471, (DefaultConstructorMarker) null);
        String ops = downloadBean.getOps();
        String genre = downloadBean.getGenre();
        String restrictLevel = downloadBean.getRestrictLevel();
        String releaseDate = downloadBean.getReleaseDate();
        String countryName = downloadBean.getCountryName();
        Integer seNum = downloadBean.getSeNum();
        String subtitles = downloadBean.getSubtitles();
        return new Subject(subjectId, Integer.valueOf(subjectType), titleNameAppendResolution, countryName, cover, releaseDate, (String) null, l, (Integer) null, genre, (List) null, (String) null, downloadBean.getImdbRate(), (String) null, (String) null, (Integer) null, (List) null, (Long) null, Boolean.TRUE, ops, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, seNum, 0, (SubjectGameInfo) null, subtitles, (List) null, (String) null, restrictLevel, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -791232, 66510847, (DefaultConstructorMarker) null);
    }
}
