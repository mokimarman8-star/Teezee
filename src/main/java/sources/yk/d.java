package yk;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.RankAllData;
import com.transsion.home.bean.UGCRankAllData;
import com.transsion.push.bean.MsgStyle;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JV\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0003\u0010\b\u001a\u00020\u00042\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\f\u0010\rJJ\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0007\u001a\u00020\u00022\b\b\u0003\u0010\b\u001a\u00020\u0004H§@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lyk/d;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "host", BuildConfig.FLAVOR, "tabId", "category", "page", "perPage", "rankingListId", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/home/bean/RankAllData;", "b", "(Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/transsion/home/bean/UGCRankAllData;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ Object a(d dVar, String str, int i, String str2, int i2, int i3, String str3, Continuation continuation, int i4, Object obj) {
            if (obj == null) {
                return dVar.b((i4 & 1) != 0 ? gg.a.a.a() : str, (i4 & 2) != 0 ? 0 : i, str2, i2, (i4 & 16) != 0 ? 10 : i3, (i4 & 32) != 0 ? null : str3, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRankList");
        }

        public static /* synthetic */ Object b(d dVar, String str, String str2, String str3, String str4, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUGCRankList");
            }
            if ((i2 & 1) != 0) {
                str = gg.a.a.a();
            }
            String str5 = str;
            if ((i2 & 2) != 0) {
                str2 = "0";
            }
            String str6 = str2;
            if ((i2 & 8) != 0) {
                str4 = MsgStyle.CUSTOM_LEFT_PIC;
            }
            String str7 = str4;
            if ((i2 & 16) != 0) {
                i = 10;
            }
            return dVar.a(str5, str6, str3, str7, i, continuation);
        }
    }

    @GET("/wefeed-mobile-bff/ugc/operating/tab-rank-list")
    Object a(@Query("host") String str, @Query("tabId") String str2, @Query("categoryType") String str3, @Query("page") String str4, @Query("perPage") int i, Continuation<? super BaseDto<UGCRankAllData>> continuation);

    @GET("/wefeed-mobile-bff/tab/ranking-list")
    Object b(@Query("host") String str, @Query("tabId") int i, @Query("categoryType") String str2, @Query("page") int i2, @Query("perPage") int i3, @Query("rankingListId") String str3, Continuation<? super BaseDto<RankAllData>> continuation);
}
