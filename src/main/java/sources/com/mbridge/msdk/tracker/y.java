package com.mbridge.msdk.tracker;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class y {
    public static long a(int i, long j, long j2) {
        if (i <= 0 || j == 0 || i <= 10) {
            return j2;
        }
        if (i <= 20) {
            return ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        }
        if (i <= 30) {
            return 120000L;
        }
        if (i <= 40) {
            return 180000L;
        }
        return i <= 50 ? 240000L : 300000L;
    }

    static void a(Cursor cursor) {
        try {
            if (!a((Object) cursor) || cursor.isClosed()) {
                return;
            }
            cursor.close();
        } catch (Exception unused) {
        }
    }

    static boolean a(e eVar) {
        return a((Object) eVar) && eVar.c() == 1;
    }

    static boolean a(Object obj) {
        return obj != null;
    }

    static boolean a(List<i> list) {
        if (b((List<?>) list)) {
            return false;
        }
        for (i iVar : list) {
            if (!b(iVar)) {
                e a = iVar.a();
                if (!b(a) && a.c() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static List<i> b(Cursor cursor) {
        int i;
        int i2;
        int i3;
        Cursor cursor2 = cursor;
        ArrayList arrayList = new ArrayList();
        try {
            int columnIndex = cursor2.getColumnIndex(RewardPlus.NAME);
            int columnIndex2 = cursor2.getColumnIndex("type");
            int columnIndex3 = cursor2.getColumnIndex("time_stamp");
            int columnIndex4 = cursor2.getColumnIndex("properties");
            int columnIndex5 = cursor2.getColumnIndex(TrackingKey.PRIORITY);
            int columnIndex6 = cursor2.getColumnIndex("uuid");
            int columnIndex7 = cursor2.getColumnIndex("duration");
            int columnIndex8 = cursor2.getColumnIndex("state");
            int columnIndex9 = cursor2.getColumnIndex("report_count");
            int columnIndex10 = cursor2.getColumnIndex("ignore_max_timeout");
            int columnIndex11 = cursor2.getColumnIndex("ignore_max_retry_times");
            int columnIndex12 = cursor2.getColumnIndex("invalid_time");
            int columnIndex13 = cursor2.getColumnIndex("report_error_message");
            while (cursor.moveToNext()) {
                try {
                    i = columnIndex;
                    try {
                        e eVar = new e(cursor2.getString(columnIndex));
                        eVar.b(cursor2.getInt(columnIndex2));
                        int i4 = columnIndex12;
                        int i5 = columnIndex13;
                        try {
                            eVar.c(cursor2.getLong(columnIndex3));
                            eVar.a(new JSONObject(cursor2.getString(columnIndex4)));
                            eVar.a(cursor2.getInt(columnIndex5));
                            eVar.a(cursor2.getString(columnIndex6));
                            eVar.a(cursor2.getLong(columnIndex7));
                            i iVar = new i(eVar);
                            iVar.b(cursor2.getInt(columnIndex8));
                            iVar.a(cursor2.getInt(columnIndex9));
                            iVar.b(cursor2.getInt(columnIndex10) == 0);
                            iVar.a(cursor2.getInt(columnIndex11) == 0);
                            i2 = i4;
                            try {
                                iVar.a(cursor2.getLong(i2));
                                i3 = i5;
                            } catch (JSONException e) {
                                e = e;
                                i3 = i5;
                                if (a.a) {
                                }
                                cursor2 = cursor;
                                columnIndex13 = i3;
                                columnIndex12 = i2;
                                columnIndex = i;
                            }
                            try {
                                String string = cursor2.getString(i3);
                                if (TextUtils.isEmpty(string)) {
                                    string = TtmlNode.ANONYMOUS_REGION_ID;
                                }
                                iVar.a(string);
                                arrayList.add(iVar);
                            } catch (JSONException e2) {
                                e = e2;
                                if (a.a) {
                                }
                                cursor2 = cursor;
                                columnIndex13 = i3;
                                columnIndex12 = i2;
                                columnIndex = i;
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            i2 = i4;
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        i2 = columnIndex12;
                        i3 = columnIndex13;
                        if (a.a) {
                            Log.e("TrackManager", "create: ", e);
                        }
                        cursor2 = cursor;
                        columnIndex13 = i3;
                        columnIndex12 = i2;
                        columnIndex = i;
                    }
                } catch (JSONException e5) {
                    e = e5;
                    i = columnIndex;
                }
                columnIndex13 = i3;
                columnIndex12 = i2;
                columnIndex = i;
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    static boolean b(Object obj) {
        return obj == null;
    }

    static boolean b(List<?> list) {
        return list == null || list.isEmpty();
    }
}
