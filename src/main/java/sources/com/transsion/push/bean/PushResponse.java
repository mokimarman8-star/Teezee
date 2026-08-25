package com.transsion.push.bean;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class PushResponse {
    public SignedEncryptedData data;
    public String message;
    public int status;

    public static class SignedEncryptedData {
        public String data;
        public String sign;

        public String toString() {
            return "DataContent{data='" + this.data + "', sign='" + this.sign + "'}";
        }
    }

    public String toString() {
        return "PushResponse{status=" + this.status + ", message='" + this.message + "', data=" + this.data + '}';
    }
}
