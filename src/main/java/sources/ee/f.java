package ee;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.config.TAdManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f implements j {
    public Uri a;

    public static class b {
        public static final f a = new f();
    }

    public f() {
        if (com.cloud.sdk.commonutil.util.e.a() == null) {
            AdLogUtil.Log().e("ssp", "HSCoreUtil is not init now");
            return;
        }
        this.a = Uri.parse("content://" + com.cloud.sdk.commonutil.util.e.a().getPackageName() + ".HisavanaConfigContentProvider/config");
    }

    public static f d() {
        return b.a;
    }

    @Override // ee.j
    public void a() {
        try {
            com.cloud.sdk.commonutil.util.e.a().getContentResolver().delete(this.a, null, null);
        } catch (Exception e) {
            AdLogUtil.Log().e("CloudProviderManager", Log.getStackTraceString(e));
        }
    }

    @Override // ee.j
    public void a(CloudControlConfig.CodeSeat codeSeat) {
        if (codeSeat == null) {
            AdLogUtil.Log().d("CloudProviderManager", "updateConfig codeSeat is null");
            return;
        }
        try {
            ContentResolver contentResolver = com.cloud.sdk.commonutil.util.e.a().getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(codeSeat.getCodeSeatId(), GsonUtil.d(codeSeat));
            int update = contentResolver.update(this.a, contentValues, codeSeat.getCodeSeatId(), null);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateConfig result ");
            sb2.append(update);
        } catch (Exception e) {
            AdLogUtil.Log().e("CloudProviderManager", Log.getStackTraceString(e));
        }
    }

    @Override // ee.j
    public boolean a(List list) {
        if (list == null || list.isEmpty()) {
            AdLogUtil.Log().d("CloudProviderManager", "insert seatList is null or empty");
            return false;
        }
        ContentResolver contentResolver = com.cloud.sdk.commonutil.util.e.a().getContentResolver();
        ContentValues contentValues = new ContentValues();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CloudControlConfig.CodeSeat codeSeat = (CloudControlConfig.CodeSeat) it.next();
            if (codeSeat != null) {
                contentValues.put(codeSeat.getCodeSeatId(), GsonUtil.d(codeSeat));
            }
        }
        Uri insert = contentResolver.insert(this.a, contentValues);
        String path = insert != null ? insert.getPath() : null;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("insert sResult ");
        sb2.append(insert);
        return path != null && path.endsWith("true");
    }

    @Override // ee.j
    public long b() {
        if (c() == null) {
            return 0L;
        }
        return r0.size();
    }

    @Override // ee.j
    public List c() {
        String[] strArr;
        if (TAdManager.getCodeSeatIds() == null || TAdManager.getCodeSeatIds().isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = com.cloud.sdk.commonutil.util.e.a().getContentResolver();
        String[] strArr2 = new String[0];
        List codeSeatIds = TAdManager.getCodeSeatIds();
        if (codeSeatIds == null || codeSeatIds.isEmpty()) {
            AdLogUtil.Log().d("CloudProviderManager", "getAllCodeSeats codeIds is empty");
            strArr = strArr2;
        } else {
            int size = codeSeatIds.size();
            String[] strArr3 = new String[size];
            for (int i = 0; i < size; i++) {
                strArr3[i] = (String) codeSeatIds.get(i);
            }
            AdLogUtil.Log().d("CloudProviderManager", "getAllCodeSeats codeIds " + codeSeatIds);
            strArr = strArr3;
        }
        Cursor query = contentResolver.query(this.a, strArr, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    int columnIndex = query.getColumnIndex("json");
                    if (columnIndex >= 0) {
                        arrayList.add((CloudControlConfig.CodeSeat) GsonUtil.a(query.getString(columnIndex), CloudControlConfig.CodeSeat.class));
                    }
                } catch (Exception e) {
                    AdLogUtil.Log().e("CloudProviderManager", Log.getStackTraceString(e));
                } finally {
                    query.close();
                }
            }
        }
        return arrayList;
    }
}
