package com.transsion.push.bean;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class PushConfig {
    private int checkInterval;
    private boolean closeJobService;
    private String groupId;
    private int maxNotificationCount;
    private int mobileUploadInterval;
    private int uploadInterval;

    public static class Builder {
        private int checkInterval;
        private boolean closeJobService;
        private String groupId;
        private int maxNotificationCount;
        private int mobileUploadInterval;
        private int uploadInterval;

        public PushConfig build() {
            return new PushConfig(this);
        }

        public Builder setCheckInterval(int i) {
            this.checkInterval = i;
            return this;
        }

        public Builder setCloseJobService(boolean z) {
            this.closeJobService = z;
            return this;
        }

        public Builder setGroupId(String str) {
            this.groupId = str;
            return this;
        }

        public Builder setMaxNotificationCount(int i) {
            this.maxNotificationCount = i;
            return this;
        }

        public Builder setMobileUploadInterval(int i) {
            this.mobileUploadInterval = i;
            return this;
        }

        public Builder setUploadInterval(int i) {
            this.uploadInterval = i;
            return this;
        }
    }

    private PushConfig(Builder builder) {
        this.closeJobService = builder.closeJobService;
        this.checkInterval = builder.checkInterval;
        this.uploadInterval = builder.uploadInterval;
        this.mobileUploadInterval = builder.mobileUploadInterval;
        this.groupId = builder.groupId;
        this.maxNotificationCount = builder.maxNotificationCount;
    }

    public int getCheckInterval() {
        return this.checkInterval;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public int getMaxNotificationCount() {
        return this.maxNotificationCount;
    }

    public int getMobileUploadInterval() {
        return this.mobileUploadInterval;
    }

    public int getUploadInterval() {
        return this.uploadInterval;
    }

    public boolean isCloseJobService() {
        return this.closeJobService;
    }
}
