package com.cloud.hisavana.sdk.data.bean.response;

import com.cloud.hisavana.sdk.data.bean.inapp.DefaultDataDTO;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DefaultResponse {
    private int code;
    private DefaultDataDTO data;
    private String message;

    public int getCode() {
        return this.code;
    }

    public DefaultDataDTO getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(DefaultDataDTO defaultDataDTO) {
        this.data = defaultDataDTO;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
