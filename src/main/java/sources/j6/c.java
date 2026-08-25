package j6;

import com.bykv.vk.openvk.Sj.Sj.sP.sP.uA;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cloud.hisavana.abtestkit.db.ABContentProvider;
import java.io.InputStream;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class c {
    List a;
    b b;

    public abstract InputStream a();

    public abstract String b();

    public b c() {
        return this.b;
    }

    public abstract int d();

    protected uA.c e(String str) {
        List list;
        if (str != null && (list = this.a) != null && list.size() > 0) {
            for (uA.c cVar : this.a) {
                if (str.equals(cVar.a)) {
                    return cVar;
                }
            }
        }
        return null;
    }

    protected String f(int i) {
        switch (i) {
            case 200:
                return "OK";
            case 201:
                return "Created";
            case 202:
                return "Accepted";
            case 203:
                return "Non-Authoritative";
            case 204:
                return "No Content";
            case 205:
                return "Reset Content";
            case 206:
                return "Partial Content";
            default:
                switch (i) {
                    case ABContentProvider.AB_SUCCESS /* 300 */:
                        return "Multiple Choices";
                    case 301:
                        return "Moved Permanently";
                    case 302:
                        return "Temporary Redirect";
                    case 303:
                        return "See Other";
                    case 304:
                        return "Not Modified";
                    case 305:
                        return "Use Proxy";
                    default:
                        switch (i) {
                            case ABContentProvider.LOCAL_AB_SUCCESS /* 400 */:
                                return "Bad Request";
                            case 401:
                                return "Unauthorized";
                            case TTAdConstant.AD_ID_IS_NULL_CODE /* 402 */:
                                return "Payment Required";
                            case TTAdConstant.DEEPLINK_UNAVAILABLE_CODE /* 403 */:
                                return "Forbidden";
                            case TTAdConstant.DEEPLINK_FALLBACK_CODE /* 404 */:
                                return "Not Found";
                            case TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE /* 405 */:
                                return "Method Not Allowed";
                            case TTAdConstant.LANDING_PAGE_TYPE_CODE /* 406 */:
                                return "Not Acceptable";
                            case TTAdConstant.DOWNLOAD_APP_INFO_CODE /* 407 */:
                                return "Proxy Authentication Required";
                            case TTAdConstant.DOWNLOAD_URL_CODE /* 408 */:
                                return "Request Time-Out";
                            case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                                return "Conflict";
                            case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                                return "Gone";
                            case TTAdConstant.IMAGE_CODE /* 411 */:
                                return "Length Required";
                            case TTAdConstant.IMAGE_URL_CODE /* 412 */:
                                return "Precondition Failed";
                            case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                                return "Request Entity Too Large";
                            case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                                return "Request-URI Too Large";
                            case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                                return "Unsupported Media Type";
                            default:
                                switch (i) {
                                    case ABContentProvider.LOCAL_AB_BY_VERSION_CODE_SUCCESS /* 500 */:
                                        return "Internal Server Error";
                                    case PglCryptUtils.LOAD_SO_FAILED /* 501 */:
                                        return "Not Implemented";
                                    case PglCryptUtils.INPUT_INVALID /* 502 */:
                                        return "Bad Gateway";
                                    case PglCryptUtils.COMPRESS_FAILED /* 503 */:
                                        return "Service Unavailable";
                                    case PglCryptUtils.BASE64_FAILED /* 504 */:
                                        return "Gateway Timeout";
                                    case PglCryptUtils.ENCRYPT_FAILED /* 505 */:
                                        return "HTTP Version Not Supported";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    public abstract String g(String str, String str2);

    public abstract List h();

    public abstract boolean i();

    public abstract String j();
}
