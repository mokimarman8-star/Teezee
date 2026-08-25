package xs;

import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.web.api.WebConstants;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public static /* synthetic */ void b(a aVar, String str, ShorttvModel.UGCVideo uGCVideo, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        aVar.a(str, uGCVideo, str2, str3);
    }

    public final void a(String moduleName, ShorttvModel.UGCVideo uGCVideo, String str, String str2) {
        String str3;
        String str4;
        String str5;
        ShorttvModel.UGCVideoCollection belongToCollection;
        Intrinsics.h(moduleName, "moduleName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", moduleName);
        if (uGCVideo == null || (str3 = uGCVideo.getTitle()) == null) {
            str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        linkedHashMap.put("title", str3);
        if (str != null) {
            linkedHashMap.put("page_tab_name", str);
        }
        String str6 = null;
        linkedHashMap.put("position", String.valueOf(uGCVideo != null ? Integer.valueOf(uGCVideo.getEp()) : null));
        if (uGCVideo != null && (belongToCollection = uGCVideo.getBelongToCollection()) != null) {
            str6 = belongToCollection.getCollectionId();
        }
        linkedHashMap.put("belong_to_collection_id", String.valueOf(str6));
        if (uGCVideo == null || (str4 = uGCVideo.getSubjectId()) == null) {
            str4 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        linkedHashMap.put("refer_subject_id", str4);
        if (uGCVideo == null || (str5 = uGCVideo.getUgcVideoId()) == null) {
            str5 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        linkedHashMap.put("content_id", str5);
        if (str2 == null) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        linkedHashMap.put("ops", str2);
        linkedHashMap.put("content_type", "ugc_video");
        h.a.o("/ugc_shorts/detail", linkedHashMap);
    }

    public final void c(ShorttvModel.UGCVideoHasTag uGCVideoHasTag, int i, String str) {
        String str2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "hashtag");
        if (uGCVideoHasTag == null || (str2 = uGCVideoHasTag.getTitle()) == null) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        linkedHashMap.put("title", str2);
        linkedHashMap.put("position", String.valueOf(i));
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        linkedHashMap.put("ops", str);
        linkedHashMap.put("content_type", "ugc_video");
        h.a.o("/ugc_shorts/detail", linkedHashMap);
    }

    public final void d(long j, ShorttvModel.UGCVideo uGCVideo, String pageTabName, String ops) {
        String str;
        String subjectId;
        ShorttvModel.UGCVideoCollection belongToCollection;
        Intrinsics.h(pageTabName, "pageTabName");
        Intrinsics.h(ops, "ops");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("browse_duration", String.valueOf(j));
        linkedHashMap.put("module_name", WebConstants.FIELD_ITEM);
        linkedHashMap.put("page_tab_name", pageTabName);
        String str2 = null;
        linkedHashMap.put("position", String.valueOf(uGCVideo != null ? Integer.valueOf(uGCVideo.getEp()) : null));
        linkedHashMap.put("ops", ops);
        if (uGCVideo != null && (belongToCollection = uGCVideo.getBelongToCollection()) != null) {
            str2 = belongToCollection.getCollectionId();
        }
        linkedHashMap.put("belong_to_collection_id", String.valueOf(str2));
        String str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (uGCVideo == null || (str = uGCVideo.getUgcVideoId()) == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        linkedHashMap.put("content_id", str);
        if (uGCVideo != null && (subjectId = uGCVideo.getSubjectId()) != null) {
            str3 = subjectId;
        }
        linkedHashMap.put("refer_subject_id", str3);
        linkedHashMap.put("content_type", "ugc_video");
        h.a.z("/ugc_shorts/detail", linkedHashMap);
    }
}
