package com.transsion.push.bean;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class TrackerResponse {

    @nl.a(name = "data")
    public TrackerConfig config;
    public String message;
    public int status;

    public String toString() {
        return "TrackerResponse{status=" + this.status + ", message='" + this.message + "', config=" + this.config + '}';
    }
}
