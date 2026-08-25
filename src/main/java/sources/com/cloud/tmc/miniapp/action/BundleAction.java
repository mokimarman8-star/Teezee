package com.cloud.tmc.miniapp.action;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface BundleAction {

    public static final class DefaultImpls {
        public static boolean getBoolean(BundleAction bundleAction, String str) {
            Intrinsics.h(str, "name");
            return bundleAction.getBoolean(str, false);
        }

        public static boolean getBoolean(BundleAction bundleAction, String str, boolean z) {
            Intrinsics.h(str, "name");
            Bundle bundle = bundleAction.getBundle();
            return bundle == null ? z : bundle.getBoolean(str, z);
        }

        public static double getDouble(BundleAction bundleAction, String str) {
            Intrinsics.h(str, "name");
            return bundleAction.getDouble(str, 0.0d);
        }

        public static double getDouble(BundleAction bundleAction, String str, double d) {
            Intrinsics.h(str, "name");
            Bundle bundle = bundleAction.getBundle();
            return bundle == null ? d : bundle.getDouble(str, d);
        }

        public static float getFloat(BundleAction bundleAction, String str) {
            Intrinsics.h(str, "name");
            return bundleAction.getFloat(str, 0.0f);
        }

        public static float getFloat(BundleAction bundleAction, String str, float f) {
            Intrinsics.h(str, "name");
            Bundle bundle = bundleAction.getBundle();
            return bundle == null ? f : bundle.getFloat(str, f);
        }

        public static int getInt(BundleAction bundleAction, String str) {
            Intrinsics.h(str, "name");
            return bundleAction.getInt(str, 0);
        }

        public static int getInt(BundleAction bundleAction, String str, int i) {
            Intrinsics.h(str, "name");
            Bundle bundle = bundleAction.getBundle();
            return bundle == null ? i : bundle.getInt(str, i);
        }

        public static ArrayList<Integer> getIntegerArrayList(BundleAction bundleAction, String str) {
            Intrinsics.h(str, "name");
            Bundle bundle = bundleAction.getBundle();
            if (bundle == null) {
                return null;
            }
            return bundle.getIntegerArrayList(str);
        }

        public static long getLong(BundleAction bundleAction, String str) {
            Intrinsics.h(str, "name");
            return bundleAction.getLong(str, 0L);
        }

        public static long getLong(BundleAction bundleAction, String str, long j) {
            Intrinsics.h(str, "name");
            Bundle bundle = bundleAction.getBundle();
            return bundle == null ? j : bundle.getLong(str, j);
        }

        public static <P extends Parcelable> P getParcelable(BundleAction bundleAction, String str) {
            Intrinsics.h(str, "name");
            Bundle bundle = bundleAction.getBundle();
            if (bundle == null) {
                return null;
            }
            return (P) bundle.getParcelable(str);
        }

        public static <S extends Serializable> S getSerializable(BundleAction bundleAction, String str) {
            Intrinsics.h(str, "name");
            Bundle bundle = bundleAction.getBundle();
            if (bundle == null) {
                return null;
            }
            return (S) bundle.getSerializable(str);
        }

        public static String getString(BundleAction bundleAction, String str) {
            Intrinsics.h(str, "name");
            Bundle bundle = bundleAction.getBundle();
            if (bundle == null) {
                return null;
            }
            return bundle.getString(str);
        }

        public static ArrayList<String> getStringArrayList(BundleAction bundleAction, String str) {
            Intrinsics.h(str, "name");
            Bundle bundle = bundleAction.getBundle();
            if (bundle == null) {
                return null;
            }
            return bundle.getStringArrayList(str);
        }
    }

    boolean getBoolean(String str);

    boolean getBoolean(String str, boolean z);

    Bundle getBundle();

    double getDouble(String str);

    double getDouble(String str, double d);

    float getFloat(String str);

    float getFloat(String str, float f);

    int getInt(String str);

    int getInt(String str, int i);

    ArrayList<Integer> getIntegerArrayList(String str);

    long getLong(String str);

    long getLong(String str, long j);

    <P extends Parcelable> P getParcelable(String str);

    <S extends Serializable> S getSerializable(String str);

    String getString(String str);

    ArrayList<String> getStringArrayList(String str);
}
