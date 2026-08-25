package com.transsion.push.bean;

import java.util.Arrays;
import java.util.List;
import nl.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ConfigInfo {
    public String clientId;
    public Config config;
    public boolean configRefresh;
    public String[] destroyAppIds;
    public boolean nextWithApp;
    public boolean nextWithDetail;
    public boolean startPointReport;
    public int syncInfoInterval;
    public Whitelist whitelist;
    public boolean whitelistRefresh;

    public static class Apps {
        public String id;
        public String pkg;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Apps apps = (Apps) obj;
                String str = this.id;
                if (str != null && this.pkg != null && str.equals(apps.id) && this.pkg.equals(apps.pkg)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.id.hashCode() * 19) + this.pkg.hashCode();
        }

        public String toString() {
            return "Apps{pkg='" + this.pkg + "', id='" + this.id + "'}";
        }
    }

    public static class Config {
        public int alarmCheckInterval;
        public int checkInterval;
        public int destroy;
        public int mobileUploadInterval;
        public int retryCount;
        public int retryInterval;
        public int uploadDelay;
        public int uploadInterval;
        public int version;

        public String toString() {
            return "Config{version=" + this.version + ", checkInterval=" + this.checkInterval + ", uploadInterval=" + this.uploadInterval + ", uploadDelay=" + this.uploadDelay + ", retryCount=" + this.retryCount + ", retryInterval=" + this.retryInterval + ", mobileUploadInterval=" + this.mobileUploadInterval + ", alarmCheckInterval=" + this.alarmCheckInterval + ", destroy=" + this.destroy + '}';
        }
    }

    public static class Whitelist {

        @a(name = "apps")
        public List<Apps> apps;
        public int version;

        public String toString() {
            return "Whitelist{version=" + this.version + ", apps=" + this.apps + '}';
        }
    }

    public String toString() {
        return "ConfigInfo{clientId='" + this.clientId + "', nextWithApp=" + this.nextWithApp + ", nextWithDetail=" + this.nextWithDetail + ", configRefresh=" + this.configRefresh + ", whitelistRefresh=" + this.whitelistRefresh + ", config=" + this.config + ", whitelist=" + this.whitelist + ", startPointReport=" + this.startPointReport + ", destroyAppIds=" + Arrays.toString(this.destroyAppIds) + ", syncInfoInterval=" + this.syncInfoInterval + '}';
    }
}
