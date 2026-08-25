package com.hisavana.common.param;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class UserDTO {
    private String baseStation;
    private long coordTime;
    private double latitude;
    private double longitude;

    public String getBaseStation() {
        return this.baseStation;
    }

    public long getCoordTime() {
        return this.coordTime;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setBaseStation(String str) {
        this.baseStation = str;
    }

    public void setCoordTime(long j) {
        this.coordTime = j;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }
}
