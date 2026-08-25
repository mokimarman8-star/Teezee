package com.cloud.h5update.impl;

import com.cloud.h5update.bean.BaseResponse;
import com.cloud.h5update.bean.UpdateEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kotlin.text.StringsKt;
import v6.d;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class UpdateParser implements d {
    @Override // v6.d
    public UpdateEntity a(String str) {
        BaseResponse baseResponse;
        if (str == null || StringsKt.q0(str)) {
            return null;
        }
        try {
            if (StringsKt.c0(str, "error_code", false, 2, (Object) null) || !StringsKt.c0(str, "code", false, 2, (Object) null) || !StringsKt.c0(str, "data", false, 2, (Object) null) || (baseResponse = (BaseResponse) new Gson().fromJson(str, new TypeToken<BaseResponse<UpdateEntity>>() { // from class: com.cloud.h5update.impl.UpdateParser$parseJson$responseResult$1
            }.getType())) == null) {
                return null;
            }
            return (UpdateEntity) baseResponse.getData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
