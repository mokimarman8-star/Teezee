package pt;

import com.transsion.subtitle_download.bean.SubtitleItem;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    private final SubtitleDownloadTable a(SubtitleItem subtitleItem, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5, String str6) {
        String id = subtitleItem.getId();
        String str7 = id == null ? HttpUrl.FRAGMENT_ENCODE_SET : id;
        String lan = subtitleItem.getLan();
        String lanName = subtitleItem.getLanName();
        String name = subtitleItem.getName();
        String url = subtitleItem.getUrl();
        Long size = subtitleItem.getSize();
        Long delay = subtitleItem.getDelay();
        Integer downloads = subtitleItem.getDownloads();
        Integer type = subtitleItem.getType();
        int intValue = type != null ? type.intValue() : 1;
        String str8 = str == null ? HttpUrl.FRAGMENT_ENCODE_SET : str;
        Integer episode = subtitleItem.getEpisode();
        int intValue2 = episode != null ? episode.intValue() : i2;
        Integer season = subtitleItem.getSeason();
        return new SubtitleDownloadTable(str7, i, str8, lan, lanName, url, size, delay, downloads, intValue, HttpUrl.FRAGMENT_ENCODE_SET, name, str2, intValue2, season != null ? season.intValue() : i3, 0, str3, 0, null, HttpUrl.FRAGMENT_ENCODE_SET, null, null, 0, str4, str5, str6, 7602176, null);
    }

    public final SubtitleDownloadTable b(String str, String str2, String str3, int i, int i2, int i3, SubtitleItem subtitleItem, String str4, String str5, String str6) {
        Intrinsics.h(subtitleItem, "subtitleItem");
        return a(subtitleItem, str2, str, str3, i, i2, i3, str4, str5, str6);
    }
}
