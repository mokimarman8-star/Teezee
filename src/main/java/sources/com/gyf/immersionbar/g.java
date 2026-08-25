package com.gyf.immersionbar;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class g {

    static class a {
        public boolean a = false;
        public boolean b = false;
        public NavigationBarType c;

        a() {
        }

        public String toString() {
            return "GestureBean{isGesture=" + this.a + ", checkNavigation=" + this.b + ", type=" + this.c + '}';
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0079, code lost:
    
        if (android.provider.Settings.Global.getInt(r9, "navigation_bar_gesture_hint", 1) == 1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007b, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d4, code lost:
    
        if (android.provider.Settings.Global.getInt(r9, "hide_gesture_line", -1) != 1) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(Context context) {
        int i;
        boolean z;
        boolean z2;
        a aVar = new a();
        if (context != null && context.getContentResolver() != null) {
            ContentResolver contentResolver = context.getContentResolver();
            NavigationBarType navigationBarType = NavigationBarType.UNKNOWN;
            boolean z3 = false;
            boolean z4 = true;
            if (OSUtils.isHuaWei() || OSUtils.isEMUI()) {
                i = !OSUtils.isEMUI3_x() ? Settings.Global.getInt(contentResolver, "navigationbar_is_min", -1) : Settings.System.getInt(contentResolver, "navigationbar_is_min", -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i == 1) {
                    navigationBarType = NavigationBarType.GESTURES;
                    z = false;
                    z2 = true;
                    if (i == -1) {
                        int i2 = Settings.Secure.getInt(contentResolver, "navigation_mode", -1);
                        if (i2 == 0) {
                            navigationBarType = NavigationBarType.CLASSIC;
                        } else if (i2 == 1) {
                            navigationBarType = NavigationBarType.DOUBLE;
                        } else if (i2 == 2) {
                            navigationBarType = NavigationBarType.GESTURES;
                            z3 = true;
                            aVar.a = z3;
                            aVar.b = z4;
                            aVar.c = navigationBarType;
                        }
                        z4 = z;
                        aVar.a = z3;
                        aVar.b = z4;
                        aVar.c = navigationBarType;
                    }
                    z4 = z;
                    z3 = z2;
                    aVar.a = z3;
                    aVar.b = z4;
                    aVar.c = navigationBarType;
                }
                z = false;
                z2 = false;
                if (i == -1) {
                }
                z4 = z;
                z3 = z2;
                aVar.a = z3;
                aVar.b = z4;
                aVar.c = navigationBarType;
            } else if (OSUtils.isXiaoMi() || OSUtils.isMIUI()) {
                i = Settings.Global.getInt(contentResolver, "force_fsg_nav_bar", -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i == 1) {
                    navigationBarType = NavigationBarType.GESTURES;
                }
                z = false;
                z2 = false;
                if (i == -1) {
                }
                z4 = z;
                z3 = z2;
                aVar.a = z3;
                aVar.b = z4;
                aVar.c = navigationBarType;
            } else if (OSUtils.isVivo() || OSUtils.isFuntouchOrOriginOs()) {
                i = Settings.Secure.getInt(contentResolver, "navigation_gesture_on", -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else {
                    if (i == 1) {
                        navigationBarType = NavigationBarType.GESTURES_THREE_STAGE;
                    } else if (i == 2) {
                        navigationBarType = NavigationBarType.GESTURES;
                    }
                    z = false;
                    z2 = true;
                    if (i == -1) {
                    }
                    z4 = z;
                    z3 = z2;
                    aVar.a = z3;
                    aVar.b = z4;
                    aVar.c = navigationBarType;
                }
                z = false;
                z2 = false;
                if (i == -1) {
                }
                z4 = z;
                z3 = z2;
                aVar.a = z3;
                aVar.b = z4;
                aVar.c = navigationBarType;
            } else if (OSUtils.isOppo() || OSUtils.isColorOs()) {
                i = Settings.Secure.getInt(contentResolver, "hide_navigationbar_enable", -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i == 1 || i == 2 || i == 3) {
                    navigationBarType = NavigationBarType.GESTURES;
                    z = false;
                    z2 = true;
                    if (i == -1) {
                    }
                    z4 = z;
                    z3 = z2;
                    aVar.a = z3;
                    aVar.b = z4;
                    aVar.c = navigationBarType;
                }
                z = false;
                z2 = false;
                if (i == -1) {
                }
                z4 = z;
                z3 = z2;
                aVar.a = z3;
                aVar.b = z4;
                aVar.c = navigationBarType;
            } else if (OSUtils.isSamsung()) {
                i = Settings.Global.getInt(contentResolver, "navigation_bar_gesture_while_hidden", -1);
                if (i != -1) {
                    if (i == 0) {
                        navigationBarType = NavigationBarType.CLASSIC;
                    } else if (i == 1) {
                        navigationBarType = Settings.Global.getInt(contentResolver, "navigation_bar_gesture_detail_type", 1) == 1 ? NavigationBarType.GESTURES : NavigationBarType.GESTURES_THREE_STAGE;
                    }
                    z = false;
                    z2 = false;
                    if (i == -1) {
                    }
                    z4 = z;
                    z3 = z2;
                    aVar.a = z3;
                    aVar.b = z4;
                    aVar.c = navigationBarType;
                } else {
                    i = Settings.Global.getInt(contentResolver, "navigationbar_hide_bar_enabled", -1);
                    if (i == 0) {
                        navigationBarType = NavigationBarType.CLASSIC;
                    } else if (i == 1) {
                        navigationBarType = NavigationBarType.GESTURES;
                        z = false;
                        z2 = true;
                        if (i == -1) {
                        }
                        z4 = z;
                        z3 = z2;
                        aVar.a = z3;
                        aVar.b = z4;
                        aVar.c = navigationBarType;
                    }
                    z = false;
                    z2 = false;
                    if (i == -1) {
                    }
                    z4 = z;
                    z3 = z2;
                    aVar.a = z3;
                    aVar.b = z4;
                    aVar.c = navigationBarType;
                }
            } else {
                z = false;
                z2 = false;
                i = -1;
                if (i == -1) {
                }
                z4 = z;
                z3 = z2;
                aVar.a = z3;
                aVar.b = z4;
                aVar.c = navigationBarType;
            }
        }
        return aVar;
    }
}
