package com.transsion.commercialization.task.wheel;

import com.transsion.bean.lottery.LotteryDrawResultEntity;
import com.transsion.bean.lottery.LotteryUserActivityInfoPriceItemsBean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface e {

    public static final class a {
        public static void a(e eVar, String str) {
            Intrinsics.h(str, "msg");
        }

        public static void b(e eVar) {
        }

        public static void c(e eVar) {
        }

        public static void d(e eVar) {
        }

        public static void e(e eVar, LotteryUserActivityInfoPriceItemsBean lotteryUserActivityInfoPriceItemsBean) {
            Intrinsics.h(lotteryUserActivityInfoPriceItemsBean, "target");
        }
    }

    void a();

    void b(LotteryUserActivityInfoPriceItemsBean lotteryUserActivityInfoPriceItemsBean);

    void c(LotteryDrawResultEntity.LotteryResultBean lotteryResultBean);

    void d();

    void e();

    void f(String str);
}
