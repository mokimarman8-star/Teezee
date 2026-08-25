package com.amazonaws;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AmazonWebServiceResponse<T> {
    private Object a;
    private ResponseMetadata b;

    public String a() {
        ResponseMetadata responseMetadata = this.b;
        if (responseMetadata == null) {
            return null;
        }
        return responseMetadata.a();
    }

    public Object b() {
        return this.a;
    }

    public void c(ResponseMetadata responseMetadata) {
        this.b = responseMetadata;
    }

    public void d(Object obj) {
        this.a = obj;
    }
}
