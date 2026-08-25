package com.transsion.ninegridview;

import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ImageInfo implements Serializable {
    public int alreadyShow = 0;
    public String bigImageUrl;
    public float imageViewHeight;
    public float imageViewWidth;
    public int imageViewX;
    public int imageViewY;
    public String thumbnailUrl;

    public String getBigImageUrl() {
        return this.bigImageUrl;
    }

    public float getImageViewHeight() {
        return this.imageViewHeight;
    }

    public float getImageViewWidth() {
        return this.imageViewWidth;
    }

    public int getImageViewX() {
        return this.imageViewX;
    }

    public int getImageViewY() {
        return this.imageViewY;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setBigImageUrl(String str) {
        this.bigImageUrl = str;
    }

    public void setImageViewHeight(int i) {
        this.imageViewHeight = i;
    }

    public void setImageViewWidth(int i) {
        this.imageViewWidth = i;
    }

    public void setImageViewX(int i) {
        this.imageViewX = i;
    }

    public void setImageViewY(int i) {
        this.imageViewY = i;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public String toString() {
        return "ImageInfo{imageViewY=" + this.imageViewY + ", imageViewX=" + this.imageViewX + ", imageViewWidth=" + this.imageViewWidth + ", imageViewHeight=" + this.imageViewHeight + ", bigImageUrl='" + this.bigImageUrl + "', thumbnailUrl='" + this.thumbnailUrl + "'}";
    }
}
