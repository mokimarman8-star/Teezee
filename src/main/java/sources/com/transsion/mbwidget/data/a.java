package com.transsion.mbwidget.data;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\b\u0010\tJ,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/transsion/mbwidget/data/a;", BuildConfig.FLAVOR, "Lcom/transsion/mbwidget/data/WidgetRequestBody;", "requestBody", BuildConfig.FLAVOR, "host", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/mbwidget/data/DeskWidgetResp;", "b", "(Lcom/transsion/mbwidget/data/WidgetRequestBody;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "count", "Lcom/transsion/mbwidget/data/BffMatchData;", "a", "(Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a {

    /* renamed from: com.transsion.mbwidget.data.a$a, reason: collision with other inner class name */
    public static final class C0037a {
        public static /* synthetic */ Object a(a aVar, Integer num, String str, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubUpcomingMatch");
            }
            if ((i & 1) != 0) {
                num = null;
            }
            if ((i & 2) != 0) {
                str = gg.a.a.a();
            }
            return aVar.a(num, str, continuation);
        }

        public static /* synthetic */ Object b(a aVar, WidgetRequestBody widgetRequestBody, String str, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWidgetData");
            }
            if ((i & 2) != 0) {
                str = gg.a.a.a();
            }
            return aVar.b(widgetRequestBody, str, continuation);
        }
    }

    @GET("/wefeed-mobile-bff/live/sub-upcomming-match")
    Object a(@Query("count") Integer num, @Query("host") String str, Continuation<? super BaseDto<BffMatchData>> continuation);

    @POST("/wefeed-mobile-bff/subject-api/widget")
    Object b(@Body WidgetRequestBody widgetRequestBody, @Query("host") String str, Continuation<? super BaseDto<DeskWidgetResp>> continuation);
}
