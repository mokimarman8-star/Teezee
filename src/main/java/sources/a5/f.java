package a5;

import com.aliyun.player.source.BitStreamSource;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class f {
    public static String a(int i) {
        switch (i) {
            case 1:
                return "error";
            case 2:
                return "int";
            case 3:
                return "float";
            case 4:
                return "string";
            case 5:
                return "iso8601";
            case 6:
                return "true";
            case 7:
                return "false";
            case 8:
                return "null";
            case 9:
                return "new";
            case 10:
                return "(";
            case 11:
                return ")";
            case 12:
                return "{";
            case 13:
                return "}";
            case 14:
                return "[";
            case TTAdConstant.IMAGE_MODE_VIDEO_VERTICAL /* 15 */:
                return "]";
            case 16:
                return ",";
            case 17:
                return ":";
            case 18:
                return "ident";
            case TTAdConstant.CONVERSION_LINK_LANDING_DIRECT_AND_ENDCARD /* 19 */:
                return "fieldName";
            case 20:
                return "EOF";
            case TTAdConstant.CONVERSION_LINK_DOWNLOAD_DIRECT /* 21 */:
                return "Set";
            case BitStreamSource.EINVAL /* 22 */:
                return "TreeSet";
            case 23:
                return "undefined";
            case 24:
                return ";";
            case 25:
                return InstructionFileId.DOT;
            case 26:
                return "hex";
            default:
                return "Unknown";
        }
    }
}
