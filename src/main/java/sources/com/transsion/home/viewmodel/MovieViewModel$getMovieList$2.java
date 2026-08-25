package com.transsion.home.viewmodel;

import com.google.gson.JsonObject;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.MovieBean;
import com.transsion.home.bean.MovieItem;
import com.transsion.home.bean.RefreshBaseDto;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import mg.b;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.MovieViewModel$getMovieList$2", f = "MovieViewModel.kt", l = {75}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MovieViewModel$getMovieList$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelId;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ JsonObject $jsonObject;
    final /* synthetic */ Map<String, String> $selectItems;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ MovieViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MovieViewModel$getMovieList$2(JsonObject jsonObject, MovieViewModel movieViewModel, boolean z, String str, Map<String, String> map, Continuation<? super MovieViewModel$getMovieList$2> continuation) {
        super(2, continuation);
        this.$jsonObject = jsonObject;
        this.this$0 = movieViewModel;
        this.$isRefresh = z;
        this.$channelId = str;
        this.$selectItems = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MovieViewModel$getMovieList$2(this.$jsonObject, this.this$0, this.$isRefresh, this.$channelId, this.$selectItems, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        MovieViewModel movieViewModel;
        String str;
        boolean z;
        Map<String, String> map;
        List<MovieItem> items;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Exception e) {
            e.printStackTrace();
            androidx.lifecycle.b0 m = this.this$0.m();
            String message = e.getMessage();
            String str2 = message == null ? BuildConfig.FLAVOR : message;
            String message2 = e.getMessage();
            m.n(new RefreshBaseDto(str2, "-1", null, message2 == null ? BuildConfig.FLAVOR : message2, this.$isRefresh));
        }
        if (i == 0) {
            ResultKt.b(obj);
            b.a aVar = mg.b.a;
            String jsonElement = this.$jsonObject.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            RequestBody a = aVar.a(jsonElement);
            if (a != null) {
                movieViewModel = this.this$0;
                boolean z2 = this.$isRefresh;
                str = this.$channelId;
                Map<String, String> map2 = this.$selectItems;
                yk.c f2 = MovieViewModel.f(movieViewModel);
                String a2 = gg.a.a.a();
                this.L$0 = movieViewModel;
                this.L$1 = str;
                this.L$2 = map2;
                this.Z$0 = z2;
                this.label = 1;
                obj = f2.a(a2, a, this);
                if (obj == f) {
                    return f;
                }
                z = z2;
                map = map2;
            }
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z = this.Z$0;
        map = (Map) this.L$2;
        str = (String) this.L$1;
        movieViewModel = (MovieViewModel) this.L$0;
        ResultKt.b(obj);
        RefreshBaseDto refreshBaseDto = (RefreshBaseDto) obj;
        refreshBaseDto.setRefresh(z);
        MovieBean movieBean = (MovieBean) refreshBaseDto.getData();
        if (movieBean != null && (items = movieBean.getItems()) != null && items.size() > 1) {
            MovieItem movieItem = items.get(items.size() - 1);
            movieItem.setChannelId(str);
            movieItem.setSelectItems(map);
        }
        movieViewModel.m().n(refreshBaseDto);
        return Unit.a;
    }
}
