package com.hisavana.common.bean;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.protobuf.h1;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.interfacz.ICacheAd;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.utils.AdLogUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class AdCache<T extends ICacheAd> {
    private static final int CODE_SEAT_LIMIT_30 = 30;
    private static final int CODE_SEAT_LIMIT_FIVE = 5;
    private static final int CODE_SEAT_LIMIT_TEN = 10;
    private static final String TAG = "AdCache";
    private static final AdCacheComp mComparator = new AdCacheComp();
    final ConcurrentHashMap<String, CopyOnWriteArrayList<T>> map = new ConcurrentHashMap<>();
    private AdCacheExpiredWatcher watcher;

    public static class AdCacheComp implements Comparator<ICacheAd> {
        @Override // java.util.Comparator
        public int compare(ICacheAd iCacheAd, ICacheAd iCacheAd2) {
            try {
                if (iCacheAd.isExpired() && !iCacheAd2.isExpired()) {
                    return 1;
                }
                if (!iCacheAd.isExpired() && iCacheAd2.isExpired()) {
                    return -1;
                }
                if (iCacheAd.getEcpmPrice() != iCacheAd2.getEcpmPrice()) {
                    return iCacheAd.getEcpmPrice() > iCacheAd2.getEcpmPrice() ? -1 : 1;
                }
                if (iCacheAd.getValidTimeLimit() - iCacheAd2.getValidTimeLimit() < 0) {
                    return -1;
                }
                return iCacheAd.getValidTimeLimit() - iCacheAd2.getValidTimeLimit() > 0 ? 1 : 0;
            } catch (Throwable unused) {
                return 0;
            }
        }
    }

    public interface AdCacheExpiredWatcher {
        void onExpired(ICacheAd iCacheAd);
    }

    private int getCodeSeatLimit(T t) {
        if (t != null && t.isIconAd()) {
            return CODE_SEAT_LIMIT_30;
        }
        return 5;
    }

    private double getMaxPrice(String str, T t, boolean z) {
        if (str == null) {
            return 0.0d;
        }
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return 0.0d;
            }
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                T next = it.next();
                if (next.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(next);
                    }
                    next.destroyAd();
                    copyOnWriteArrayList.remove(next);
                } else if (z && next.isMatchVulgarBrand()) {
                    next.destroyAd();
                    copyOnWriteArrayList.remove(next);
                } else {
                    if (t == null || t != next) {
                        AdLogUtil.Log().d(TAG, "*----> max ad in pool is :" + next.getPlacementId() + ",EcpmPrice is :" + next.getEcpmPrice() + ",AdSource is :" + next.getAdSource() + ",ValidTimeLimit :" + next.getValidTimeLimit());
                        return next.getEcpmPrice();
                    }
                    AdLogUtil.Log().d("ssp_second_price", "*----> getMaxPrice updateSecondPrice()，excludeAd == iteratorAd");
                }
            }
            return 0.0d;
        } catch (Throwable th) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th));
            return 0.0d;
        }
    }

    private CopyOnWriteArrayList<T> getOrCreateList(String str) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList != null) {
            return copyOnWriteArrayList;
        }
        CopyOnWriteArrayList<T> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
        this.map.put(str, copyOnWriteArrayList2);
        return copyOnWriteArrayList2;
    }

    private T getSupportAd(String str, int i, boolean z) {
        AdLogUtil.Log().d(TAG, "getSupportAd " + str + " hisavanaAdSupportFlag " + i);
        ArrayList<T> caches = getCaches(str, h1.READ_DONE, false, z);
        if (caches == null) {
            return null;
        }
        Iterator<T> it = caches.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (next != null && isAdConformSupportFlag(next, i)) {
                return next;
            }
        }
        return null;
    }

    private boolean isAdConformSupportFlag(T t, int i) {
        if (t.isOfflineAd()) {
            return false;
        }
        if (i == 1) {
            return t.isAdxAd();
        }
        if (i == 2) {
            return t.isEwAd();
        }
        if (i != 3) {
            return false;
        }
        return t.isAdxAd() || t.isEwAd();
    }

    private static <T extends ICacheAd> boolean isLowPrice(T t) {
        return t.getNetwork() != null && t.getNetwork().getBiddingType().intValue() == 1 && t.getNetwork().getPrice().doubleValue() < ((double) t.getNetwork().getMinPrice().intValue());
    }

    private boolean removeAd(CopyOnWriteArrayList<T> copyOnWriteArrayList, T t, boolean z) {
        if (z) {
            AdLogUtil.Log().d(TAG, "---> Remove ad:" + t.getPlacementId() + " from cache");
            copyOnWriteArrayList.remove(t);
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(t), RecordTestInfo.LOG_CODE10);
            }
        }
        if (!t.isExpired()) {
            return false;
        }
        if (!z) {
            copyOnWriteArrayList.remove(t);
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(t), RecordTestInfo.LOG_CODE10);
            }
        }
        AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
        if (adCacheExpiredWatcher != null) {
            adCacheExpiredWatcher.onExpired(t);
        }
        t.destroyAd();
        return true;
    }

    public void addCache(String str, @NonNull T t) {
        String str2;
        if (t != null) {
            if (LogSwitch.isDebug) {
                str2 = "add Cache list,AdSource is :" + t.getAdSource();
            } else {
                str2 = null;
            }
            RecordTestInfo.record(str2);
            t.detachContext();
        }
        CopyOnWriteArrayList<T> orCreateList = getOrCreateList(str);
        if (orCreateList.size() > getCodeSeatLimit(t)) {
            orCreateList.remove(orCreateList.size() - 1);
        }
        try {
            ArrayList arrayList = new ArrayList(orCreateList);
            int binarySearch = Collections.binarySearch(arrayList, t, mComparator);
            if (binarySearch < 0) {
                binarySearch = -(binarySearch + 1);
            }
            arrayList.add(binarySearch, t);
            orCreateList.clear();
            orCreateList.addAll(arrayList);
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg("add cache:" + RecordTestInfo.getLogMsg(t), RecordTestInfo.LOG_CODE10);
                RecordTestInfo.record("add Cache list is :" + arrayList.size());
            }
            AdLogUtil.Log().d(TAG, "*----> add Caches list is :" + arrayList.size());
        } catch (Exception e) {
            AdLogUtil.Log().d(TAG, Log.getStackTraceString(e));
        }
    }

    public void addCaches(String str, List<T> list) {
        for (T t : list) {
            if (t != null) {
                if (LogSwitch.isDebug) {
                    RecordTestInfo.record("add Caches list,EcpmPrice is :" + t.getEcpmPrice());
                }
                t.detachContext();
            }
        }
        CopyOnWriteArrayList<T> orCreateList = getOrCreateList(str);
        if (list.size() == 0 || orCreateList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(orCreateList);
        int size = (list.size() + arrayList.size()) - getCodeSeatLimit(list.get(0));
        arrayList.addAll(list);
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                int size2 = arrayList.size();
                if (size2 > 0) {
                    arrayList.remove(size2 - 1);
                } else {
                    AdLogUtil.Log().e(TAG, "addCaches,index out of bounds");
                }
            }
        }
        try {
            Collections.sort(arrayList, mComparator);
            orCreateList.clear();
            orCreateList.addAll(arrayList);
            AdLogUtil.Log().d(TAG, "*----> add Caches list is :" + arrayList.size());
            if (LogSwitch.isDebug) {
                RecordTestInfo.record("add Caches list is :" + arrayList.size());
                RecordTestInfo.LogMsg("add caches:" + RecordTestInfo.getLogMsg(list), RecordTestInfo.LOG_CODE10);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0108 A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:3:0x0002, B:5:0x000d, B:8:0x0015, B:10:0x0019, B:11:0x0022, B:13:0x0028, B:15:0x006f, B:16:0x007a, B:17:0x007f, B:19:0x0085, B:22:0x008e, B:24:0x0095, B:26:0x0099, B:27:0x009c, B:30:0x0108, B:34:0x0110, B:38:0x00bd, B:40:0x00c3, B:41:0x00e1, B:43:0x00e7, B:50:0x012e), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0110 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int checkCacheStatus(String str, boolean z) {
        boolean z2;
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                if (LogSwitch.isDebug) {
                    StringBuilder sb2 = new StringBuilder();
                    Iterator<T> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        T next = it.next();
                        sb2.append("------>> item source : ");
                        sb2.append(next.getAdSource());
                        sb2.append(", price: ");
                        sb2.append(next.getEcpmPrice());
                        sb2.append(", bidType: ");
                        sb2.append(next.getNetwork().getBiddingType());
                        sb2.append(", minPrice: ");
                        sb2.append(next.getNetwork().getMinPrice());
                        sb2.append("\n");
                    }
                    AdLogUtil.Log().d(TAG, sb2.toString());
                }
                Iterator<T> it2 = copyOnWriteArrayList.iterator();
                int i = 1;
                while (it2.hasNext()) {
                    T next2 = it2.next();
                    if (next2 != null) {
                        if (next2.isExpired()) {
                            AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                            if (adCacheExpiredWatcher != null) {
                                adCacheExpiredWatcher.onExpired(next2);
                            }
                            AdLogUtil.Log().d(TAG, "------>> Cache expire -> " + next2.getAdSource());
                            i = 2;
                        } else if (z && next2.isMatchVulgarBrand()) {
                            AdLogUtil.Log().d(TAG, "------>> Cache sensitive -> " + next2.getAdSource());
                            i = 3;
                        } else if (isLowPrice(next2)) {
                            AdLogUtil.Log().d(TAG, "------>> Cache low price -> " + next2.getAdSource());
                            i = 4;
                        } else {
                            z2 = false;
                            if (z2) {
                                AdLogUtil.Log().d(TAG, "------>> Cache default -> " + next2.getAdSource());
                                return 0;
                            }
                            copyOnWriteArrayList.remove(next2);
                            next2.destroyAd();
                        }
                        z2 = true;
                        if (z2) {
                        }
                    }
                }
                return i;
            }
            AdLogUtil.Log().d(TAG, "------>> Cache empty");
            return 1;
        } catch (Exception e) {
            AdLogUtil.Log().e(TAG, "check cache status failed: " + e.getMessage());
            return 5;
        }
    }

    public ICacheAd getAdBySourceAndUnitID(String str, int i, boolean z) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList;
        try {
            copyOnWriteArrayList = this.map.get(str);
        } catch (Throwable th) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th));
        }
        if (copyOnWriteArrayList == null) {
            return null;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (next.isExpired()) {
                AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                if (adCacheExpiredWatcher != null) {
                    adCacheExpiredWatcher.onExpired(next);
                }
                next.destroyAd();
                copyOnWriteArrayList.remove(next);
            } else if (!z || !next.isMatchVulgarBrand()) {
                if (next.getAdSource() == i && TextUtils.equals(next.getPlacementId(), str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public int getAdNum(String str) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return 0;
            }
            Iterator<T> it = copyOnWriteArrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                T next = it.next();
                if (next.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(next);
                    }
                    next.destroyAd();
                    copyOnWriteArrayList.remove(next);
                } else {
                    i++;
                    AdLogUtil.Log().d(TAG, "*----> ad in pool is :" + next.getPlacementId() + ",EcpmPrice is :" + next.getEcpmPrice() + ",AdSource is :" + next.getAdSource() + ",ValidTimeLimit :" + next.getValidTimeLimit());
                }
            }
            return i;
        } catch (Throwable th) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th));
            return 0;
        }
    }

    public int getAdNum(String str, int i, String str2, boolean z) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return 0;
            }
            Iterator<T> it = copyOnWriteArrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                T next = it.next();
                if (next.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(next);
                    }
                    next.destroyAd();
                    copyOnWriteArrayList.remove(next);
                } else if (z && next.isMatchVulgarBrand()) {
                    next.destroyAd();
                    copyOnWriteArrayList.remove(next);
                } else if (next.getAdSource() == i && TextUtils.equals(next.getPlacementId(), str2)) {
                    i2++;
                }
            }
            return i2;
        } catch (Throwable th) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th));
            return 0;
        }
    }

    public T getCache(String str, boolean z, int i, boolean z2) {
        ArrayList<T> caches;
        T supportAd = getSupportAd(str, i, z2);
        return (supportAd != null || (caches = getCaches(str, 1, z, z2)) == null || caches.isEmpty()) ? supportAd : caches.get(0);
    }

    public ArrayList<T> getCaches(@NonNull String str, int i, boolean z, int i2, boolean z2) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            ArrayList<T> arrayList = new ArrayList<>();
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<T> it = copyOnWriteArrayList.iterator();
                if (LogSwitch.isDebug) {
                    Iterator<T> it2 = copyOnWriteArrayList.iterator();
                    AdLogUtil.Log().d(TAG, "current ad pool size is :" + copyOnWriteArrayList.size());
                    while (it2.hasNext()) {
                        T next = it2.next();
                        AdLogUtil.Log().d(TAG, "ad: " + next.getPlacementId() + "，price：" + next.getEcpmPrice() + " isAdx " + next.isAdxAd() + " isEw " + next.isEwAd());
                    }
                }
                while (it.hasNext()) {
                    T next2 = it.next();
                    if (next2 != null) {
                        if (z2 && next2.isMatchVulgarBrand()) {
                            copyOnWriteArrayList.remove(next2);
                            if (LogSwitch.isDebug) {
                                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(next2), RecordTestInfo.LOG_CODE10);
                            }
                            next2.destroyAd();
                        } else {
                            if (isAdConformSupportFlag(next2, i2) && !removeAd(copyOnWriteArrayList, next2, z)) {
                                arrayList.add(next2);
                            }
                            if (arrayList.size() >= i) {
                                return arrayList;
                            }
                        }
                    }
                }
                if (arrayList.size() < i) {
                    arrayList.addAll(getCaches(str, i - arrayList.size(), z, z2));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th));
            return null;
        }
    }

    public ArrayList<T> getCaches(@NonNull String str, int i, boolean z, boolean z2) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return new ArrayList<>();
            }
            Iterator<T> it = copyOnWriteArrayList.iterator();
            if (LogSwitch.isDebug) {
                Iterator<T> it2 = copyOnWriteArrayList.iterator();
                AdLogUtil.Log().d(TAG, "*----> current ad pool size is :" + copyOnWriteArrayList.size());
                while (it2.hasNext()) {
                    T next = it2.next();
                    AdLogUtil.Log().d(TAG, "---> ad: " + next.getPlacementId() + "，price：" + next.getEcpmPrice() + " source " + next.getAdSource());
                }
            }
            ArrayList<T> arrayList = null;
            while (it.hasNext()) {
                T next2 = it.next();
                if (next2 != null) {
                    if (z) {
                        copyOnWriteArrayList.remove(next2);
                        if (LogSwitch.isDebug) {
                            RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(next2), RecordTestInfo.LOG_CODE10);
                        }
                    }
                    if (next2.isExpired()) {
                        if (!z) {
                            copyOnWriteArrayList.remove(next2);
                            if (LogSwitch.isDebug) {
                                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(next2), RecordTestInfo.LOG_CODE10);
                            }
                        }
                        AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                        if (adCacheExpiredWatcher != null) {
                            adCacheExpiredWatcher.onExpired(next2);
                        }
                        next2.destroyAd();
                    } else if (z2 && next2.isMatchVulgarBrand()) {
                        if (!z) {
                            copyOnWriteArrayList.remove(next2);
                            if (LogSwitch.isDebug) {
                                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(next2), RecordTestInfo.LOG_CODE10);
                            }
                        }
                        next2.destroyAd();
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(next2);
                        if (arrayList.size() >= i) {
                            break;
                        }
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th));
            return null;
        }
    }

    public ArrayList<T> getCaches(@NonNull String str, int i, boolean z, boolean z2, int i2, boolean z3) {
        try {
            if (!z2) {
                return getCaches(str, i, z, i2, z3);
            }
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return null;
            }
            int i3 = i2 > 0 ? 0 : -1;
            if (LogSwitch.isDebug) {
                Iterator<T> it = copyOnWriteArrayList.iterator();
                AdLogUtil.Log().d(TAG, "*----> current ad pool size is :" + copyOnWriteArrayList.size());
                while (it.hasNext()) {
                    T next = it.next();
                    AdLogUtil.Log().d(TAG, "---> ad: " + next.getPlacementId() + "，price：" + next.getEcpmPrice());
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = copyOnWriteArrayList.iterator();
            ArrayList<T> arrayList2 = null;
            while (it2.hasNext()) {
                T next2 = it2.next();
                if (next2 != null) {
                    if (next2.isExpired()) {
                        copyOnWriteArrayList.remove(next2);
                        AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                        if (adCacheExpiredWatcher != null) {
                            adCacheExpiredWatcher.onExpired(next2);
                        }
                        next2.destroyAd();
                    } else if (z3 && next2.isMatchVulgarBrand()) {
                        copyOnWriteArrayList.remove(next2);
                        next2.destroyAd();
                        AdLogUtil.Log().d(TAG, "current ad filter by vulgar content");
                    } else if (i3 == -1 || i3 == next2.getAdSource()) {
                        if (i3 == -1) {
                            i3 = next2.getAdSource();
                        }
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>();
                        }
                        if (!TextUtils.isEmpty(next2.getFilterSource())) {
                            AdLogUtil.Log().d(TAG, "current filter ------->" + next2.getFilterSource());
                            if (!arrayList.contains(next2.getFilterSource())) {
                                arrayList.add(next2.getFilterSource());
                            }
                        }
                        if (z) {
                            AdLogUtil.Log().d(TAG, "---> Remove ad:" + next2.getPlacementId() + " from cache");
                            copyOnWriteArrayList.remove(next2);
                        }
                        arrayList2.add(next2);
                        if (arrayList2.size() >= i) {
                            break;
                        }
                    }
                }
            }
            return (i2 <= 0 || !(arrayList2 == null || arrayList2.isEmpty())) ? arrayList2 : getCaches(str, i, z, 0, z3);
        } catch (Throwable th) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th));
            return null;
        }
    }

    public double getMaxPrice(String str, boolean z) {
        return getMaxPrice(str, null, z);
    }

    public double getNetworkPrice(String str, int i, String str2) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return 0.0d;
            }
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                T next = it.next();
                if (next.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(next);
                    }
                    next.destroyAd();
                    copyOnWriteArrayList.remove(next);
                } else if (next.getAdSource() == i && TextUtils.equals(next.getPlacementId(), str2)) {
                    return next.getEcpmPrice();
                }
            }
            return 0.0d;
        } catch (Throwable th) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th));
            return 0.0d;
        }
    }

    public int[] getValidAndInvalidAdNum(String str) {
        int[] iArr = {0, 0};
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList == null) {
            return iArr;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().isExpired()) {
                i2++;
            } else {
                i++;
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }

    public boolean hasAd(String str, T t) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        return copyOnWriteArrayList.contains(t);
    }

    public boolean hasAds(String str, boolean z) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return false;
            }
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                T next = it.next();
                if (next.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(next);
                    }
                    next.destroyAd();
                    copyOnWriteArrayList.remove(next);
                } else if (!z || !next.isMatchVulgarBrand()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th));
            return false;
        }
    }

    public void registerWatcher(AdCacheExpiredWatcher adCacheExpiredWatcher) {
        this.watcher = adCacheExpiredWatcher;
    }

    public void removeAll() {
        this.map.clear();
    }

    public void removeCache(String str, T t) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        copyOnWriteArrayList.remove(t);
        AdLogUtil.Log().d(TAG, "---> Remove ad:" + t.getPlacementId() + " from cache");
        if (LogSwitch.isDebug) {
            RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(t), RecordTestInfo.LOG_CODE10);
        }
    }

    public void removeCodeSeatCache(String str) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
            AdLogUtil.Log().d(TAG, "---> clear codeSeat cache : " + str);
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg("clear codeSeat cache:" + RecordTestInfo.getLogMsg(copyOnWriteArrayList), RecordTestInfo.LOG_CODE10);
            }
        }
    }

    public void unRegisterWatcher() {
        this.watcher = null;
    }
}
