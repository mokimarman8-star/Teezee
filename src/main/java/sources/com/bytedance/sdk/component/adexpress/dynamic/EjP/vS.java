package com.bytedance.sdk.component.adexpress.dynamic.EjP;

import com.cloud.tmc.integration.athena.Constants;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class vS {
    private boolean AVc;
    private String Aw;
    private boolean Bml;
    private int Chv;
    private String DPc;
    private float Dq;
    private String EZ;
    private int Ei;
    private float EjP;
    private boolean FPG;
    private int Fm;
    private String Fmk;
    private int GMp;
    private String Gn;
    private int Grp;
    private boolean HS;
    private List<Sj> HcZ;
    private boolean HiB;
    private double HpB;
    private boolean IOh;
    private String Ir;
    private String JcM;
    private float Jcg;
    private String LD;
    private double LqL;
    private String Mts;
    private boolean MuB;
    private boolean Ov;
    private int Ph;
    private boolean QZ;
    private String RiZ;
    private double RrR;
    private JSONObject SP;
    private float Sj;
    private float TEQ;
    private int TFd;
    private float TKC;
    private int TO;
    private int TX;
    private String TzV;
    private int UHs;
    private int Uc;
    private String WMZ;
    private int Wjd;
    private int WxP;
    private String Xqg;
    private double Yf;
    private double Ym;
    private String Zq;
    private int aNB;
    private String aZ;
    private double aa;
    private int cX;
    private JSONObject dLt;
    private String dNu;
    private int dU;
    private boolean db;
    private String dwU;
    private String dx;
    private int eI;
    private int eMB;
    private String fF;
    private int gR;
    private JSONObject gY;
    private int gq;
    private long hif = -1;
    private int hzV;
    private String ib;
    private int jb;
    private String kF;
    private int kb;
    private int ley;
    private boolean liH;
    private int mZN;
    private JSONObject mj;
    private boolean nP;
    private int ndK;
    private String nou;
    private int nru;
    private boolean oWa;
    private boolean pfr;
    private boolean qRN;
    private float sP;
    private String sU;
    private boolean sdp;
    private String sef;
    private int tPD;
    private boolean tX;
    private int tY;
    private int tz;
    private float uA;
    private boolean uP;
    private String uvD;
    private float vS;
    private String vb;
    private int wE;
    private int xD;
    private int xhi;
    private int xu;
    private String xzt;
    private String zR;
    private int zwV;

    public static vS Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        vS vSVar = new vS();
        vSVar.sP(jSONObject.optString("adType", "embeded"));
        vSVar.Zq(jSONObject.optString("clickArea", "creative"));
        vSVar.uvD(jSONObject.optString("clickTigger", "click"));
        vSVar.TKC(jSONObject.optString("fontFamily", "PingFangSC"));
        vSVar.EjP(jSONObject.optString("textAlign", "left"));
        vSVar.HiB(jSONObject.optString("color", "#999999"));
        vSVar.vS(jSONObject.optString("bgColor", TmcStartParams.KEY_TRANSPARENT));
        vSVar.Jcg(jSONObject.optString("bgImgUrl", ""));
        vSVar.ley(jSONObject.optString("bgImgData", ""));
        vSVar.Dq(jSONObject.optString("borderColor", "#000000"));
        vSVar.uA(jSONObject.optString("borderStyle", "solid"));
        vSVar.TEQ(jSONObject.optString("heightMode", "auto"));
        vSVar.Ym(jSONObject.optString("widthMode", "fixed"));
        vSVar.aa(jSONObject.optString("interactText", ""));
        vSVar.TKC(jSONObject.optBoolean("isShowBgControl", false));
        vSVar.Fmk(jSONObject.optString("interactBgColor", ""));
        JSONObject optJSONObject = jSONObject.optJSONObject("interactPosition");
        if (optJSONObject != null) {
            vSVar.Jcg(optJSONObject.optInt("translateY", 0));
            vSVar.Dq(optJSONObject.optInt("translateX", 0));
            vSVar.EjP(optJSONObject.optDouble("scaleX", 0.0d));
            vSVar.HiB(optJSONObject.optDouble("scaleY", 0.0d));
        }
        vSVar.sef(jSONObject.optString("interactType", ""));
        vSVar.HiB(jSONObject.optInt("interactSlideDirection", -1));
        vSVar.dNu(jSONObject.optString("justifyHorizontal", "space-around"));
        vSVar.TzV(jSONObject.optString("justifyVertical", "flex-start"));
        vSVar.sP(jSONObject.optDouble("timingStart"));
        vSVar.TKC(jSONObject.optDouble("timingEnd"));
        vSVar.EjP((float) jSONObject.optDouble("width", 0.0d));
        vSVar.TKC((float) jSONObject.optDouble("height", 0.0d));
        vSVar.Sj((float) jSONObject.optDouble("borderRadius", 0.0d));
        vSVar.sP((float) jSONObject.optDouble("borderSize", 0.0d));
        vSVar.sP(jSONObject.optBoolean("interactValidate", false));
        vSVar.uA((float) jSONObject.optDouble("fontSize", 0.0d));
        vSVar.HiB((float) jSONObject.optDouble("paddingBottom", 0.0d));
        vSVar.vS((float) jSONObject.optDouble("paddingLeft", 0.0d));
        vSVar.Jcg((float) jSONObject.optDouble("paddingRight", 0.0d));
        vSVar.Dq((float) jSONObject.optDouble("paddingTop", 0.0d));
        vSVar.EjP(jSONObject.optBoolean("lineFeed", false));
        vSVar.uA(jSONObject.optInt("lineCount", 0));
        vSVar.vS(jSONObject.optDouble("lineHeight", 1.2d));
        vSVar.sef(jSONObject.optInt("letterSpacing", 0));
        vSVar.HiB(jSONObject.optBoolean("isDataFixed", false));
        vSVar.Zq(jSONObject.optInt("fontWeight"));
        vSVar.vS(jSONObject.optBoolean("lineLimit"));
        vSVar.uvD(jSONObject.optInt("position"));
        vSVar.RiZ(jSONObject.optString("align"));
        vSVar.Jcg(jSONObject.optBoolean("useLeft"));
        vSVar.Dq(jSONObject.optBoolean("useRight"));
        vSVar.uA(jSONObject.optBoolean("useTop"));
        vSVar.TEQ(jSONObject.optBoolean("useBottom"));
        vSVar.sU(jSONObject.optString("data"));
        vSVar.sP(jSONObject.optJSONObject("i18n"));
        vSVar.aa(jSONObject.optInt("marginLeft"));
        vSVar.Fmk(jSONObject.optInt("marginRight"));
        vSVar.TEQ(jSONObject.optInt("marginTop"));
        vSVar.Ym(jSONObject.optInt("marginBottom"));
        vSVar.dNu(jSONObject.optInt("tagMaxCount"));
        vSVar.Ym(jSONObject.optBoolean("allowTextFlow"));
        vSVar.TzV(jSONObject.optInt("textFlowType"));
        vSVar.RiZ(jSONObject.optInt("textFlowDuration"));
        vSVar.sU(jSONObject.optInt("left"));
        vSVar.dx(jSONObject.optInt("right"));
        vSVar.zR(jSONObject.optInt(IntegrationConstants.TAB_BAR_POSITION_TOP));
        vSVar.ib(jSONObject.optInt(IntegrationConstants.TAB_BAR_POSITION_DEFAULT));
        vSVar.dx(jSONObject.optString("alignItems", "flex-start"));
        vSVar.zR(jSONObject.optString("direction", ""));
        vSVar.Sj(jSONObject.optBoolean("loop", false));
        vSVar.kF(jSONObject.optInt("zIndex"));
        vSVar.Yf(jSONObject.optInt("interactVisibleTime"));
        vSVar.uP(jSONObject.optInt("interactHiddenTime"));
        vSVar.Fmk(jSONObject.optBoolean("interactEnableMask"));
        vSVar.sef(jSONObject.optBoolean("interactWontHide"));
        vSVar.Sj(jSONObject.optString("bgGradient"));
        vSVar.fF(jSONObject.optInt("areaType"));
        vSVar.JcM(jSONObject.optInt("interactSlideThreshold", 0));
        vSVar.FPG(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.EjP.sP() ? 0 : 120));
        vSVar.TzV(jSONObject.optBoolean("openPlayableLandingPage", false));
        vSVar.TKC(jSONObject.optJSONObject(Constants.VIDEO_TAG));
        vSVar.EjP(jSONObject.optJSONObject("image"));
        vSVar.WMZ(jSONObject.optInt("borderShadowExtent"));
        vSVar.Zq(jSONObject.optBoolean("bgGauseBlur"));
        vSVar.Mts(jSONObject.optInt("bgGauseBlurRadius"));
        vSVar.uvD(jSONObject.optBoolean("showTimeProgress", false));
        vSVar.dNu(jSONObject.optBoolean("showPlayButton", false));
        vSVar.Sj(jSONObject.optDouble("bgColorCg", 0.0d));
        vSVar.vS(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        vSVar.sP(jSONObject.optInt("borderTopLeftRadius", 0));
        vSVar.Sj(jSONObject.optInt("borderTopRightRadius", 0));
        vSVar.EjP(jSONObject.optInt("borderBottomLeftRadius", 0));
        vSVar.TKC(jSONObject.optInt("borderBottomRightRadius", 0));
        vSVar.HiB(jSONObject.optJSONObject("interactI18n"));
        vSVar.kF(jSONObject.optString("imageObjectFit"));
        vSVar.uP(jSONObject.optString("interactTitle"));
        vSVar.LD(jSONObject.optInt("interactTextPositionTop"));
        vSVar.ib(jSONObject.optString("imageLottieTosPath"));
        vSVar.aa(jSONObject.optBoolean("animationsLoop"));
        vSVar.wE(jSONObject.optInt("lottieAppNameMaxLength"));
        vSVar.LqL(jSONObject.optInt("lottieAdDescMaxLength"));
        vSVar.ley(jSONObject.optInt("lottieAdTitleMaxLength"));
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("animations");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    Sj sj = new Sj();
                    sj.TKC(jSONObject2.optString("animationType"));
                    sj.Sj(jSONObject2.optDouble("animationDuration"));
                    sj.sP(jSONObject2.optDouble("animationScaleX"));
                    sj.TKC(jSONObject2.optDouble("animationScaleY"));
                    sj.EjP(jSONObject2.optString("animationTimeFunction"));
                    sj.EjP(jSONObject2.optDouble("animationDelay"));
                    sj.vS(jSONObject2.optInt("animationIterationCount"));
                    sj.HiB(jSONObject2.optString("animationDirection"));
                    sj.HiB(jSONObject2.optDouble("animationInterval"));
                    sj.Sj(jSONObject2.optInt("animationBorderWidth"));
                    sj.Sj(jSONObject2.optLong("key"));
                    sj.sP(jSONObject2.optInt("animationEffectWidth"));
                    sj.TKC(jSONObject2.optInt("animationSwing", 1));
                    sj.EjP(jSONObject2.optInt("animationTranslateX"));
                    sj.HiB(jSONObject2.optInt("animationTranslateY"));
                    sj.sP(jSONObject2.optString("animationRippleBackgroundColor"));
                    sj.Sj(jSONObject2.optString("animationScaleDirection"));
                    sj.Jcg(jSONObject2.optInt("animationFadeStart"));
                    sj.Dq(jSONObject2.optInt("animationFadeEnd"));
                    sj.vS(jSONObject2.optString("animationFillMode"));
                    sj.uA(jSONObject2.optInt("animationBounceHeight"));
                    if (vSVar.RiZ() > 0.0d) {
                        sj.EjP(sj.sef() + vSVar.RiZ());
                    }
                    arrayList.add(sj);
                }
                vSVar.Sj(arrayList);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                vSVar.wE(jSONObject.optString("triggerSlideDirection", "0"));
                vSVar.Sj(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception unused) {
        }
        return vSVar;
    }

    private void Sj(vS vSVar, JSONObject jSONObject) {
        String next;
        if (vSVar == null || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            next = keys.next();
            next.hashCode();
            switch (next) {
                case "isShowBgControl":
                    vSVar.TKC(jSONObject.optBoolean(next, false));
                    break;
                case "clickArea":
                    vSVar.Zq(jSONObject.optString(next));
                    break;
                case "triggerSlideDirection":
                    vSVar.wE(jSONObject.optString(next));
                    break;
                case "bgImgUrl":
                    vSVar.Jcg(jSONObject.optString(next));
                    break;
                case "lineCount":
                    vSVar.uA(jSONObject.optInt(next));
                    break;
                case "openPlayableLandingPage":
                    vSVar.TzV(jSONObject.optBoolean(next));
                    break;
                case "lineLimit":
                    vSVar.vS(jSONObject.optBoolean(next));
                    break;
                case "interactBgColor":
                    vSVar.Fmk(jSONObject.optString(next));
                    break;
                case "paddingLeft":
                    vSVar.vS((float) jSONObject.optDouble(next));
                    break;
                case "adType":
                    vSVar.sP(jSONObject.optString(next));
                    break;
                case "bottom":
                    vSVar.ib(jSONObject.optInt(next));
                    break;
                case "fontFamily":
                    vSVar.TKC(jSONObject.optString(next));
                    break;
                case "height":
                    vSVar.TKC((float) jSONObject.optDouble(next));
                    break;
                case "textAlign":
                    vSVar.EjP(jSONObject.optString(next));
                    break;
                case "alignItems":
                    vSVar.dx(jSONObject.optString(next));
                    break;
                case "interactValidate":
                    vSVar.sP(jSONObject.optBoolean(next));
                    break;
                case "marginTop":
                    vSVar.TEQ(jSONObject.optInt(next));
                    break;
                case "useBottom":
                    vSVar.TEQ(jSONObject.optBoolean(next));
                    break;
                case "triggerSlideMinDistance":
                    vSVar.Sj(jSONObject.optLong(next));
                    break;
                case "direction":
                    vSVar.zR(jSONObject.optString(next));
                    break;
                case "tagMaxCount":
                    vSVar.dNu(jSONObject.optInt(next));
                    break;
                case "interactHiddenTime":
                    vSVar.uP(jSONObject.optInt(next));
                    break;
                case "useTop":
                    vSVar.uA(jSONObject.optBoolean(next));
                    break;
                case "fontWeight":
                    vSVar.Zq(jSONObject.optInt(next));
                    break;
                case "zIndex":
                    vSVar.kF(jSONObject.optInt(next));
                    break;
                case "timingStart":
                    vSVar.sP(jSONObject.optDouble(next));
                    break;
                case "lineHeight":
                    vSVar.vS(jSONObject.optDouble(next));
                    break;
                case "textFlowDuration":
                    vSVar.RiZ(jSONObject.optInt(next));
                    break;
                case "useRight":
                    vSVar.Dq(jSONObject.optBoolean(next));
                    break;
                case "marginBottom":
                    vSVar.Ym(jSONObject.optInt(next));
                    break;
                case "bgColor":
                    vSVar.vS(jSONObject.optString(next));
                    break;
                case "useLeft":
                    vSVar.Jcg(jSONObject.optBoolean(next));
                    break;
                case "widthMode":
                    vSVar.Ym(jSONObject.optString(next));
                    break;
                case "top":
                    vSVar.zR(jSONObject.optInt(next));
                    break;
                case "data":
                    vSVar.sU(jSONObject.optString(next));
                    break;
                case "left":
                    vSVar.sU(jSONObject.optInt(next));
                    break;
                case "loop":
                    vSVar.Sj(jSONObject.optBoolean(next));
                    break;
                case "paddingTop":
                    vSVar.Dq((float) jSONObject.optDouble(next));
                    break;
                case "align":
                    vSVar.RiZ(jSONObject.optString(next));
                    break;
                case "color":
                    vSVar.HiB(jSONObject.optString(next));
                    break;
                case "right":
                    vSVar.dx(jSONObject.optInt(next));
                    break;
                case "width":
                    vSVar.EjP((float) jSONObject.optDouble(next));
                    break;
                case "timingEnd":
                    vSVar.TKC(jSONObject.optDouble(next));
                    break;
                case "paddingBottom":
                    vSVar.HiB((float) jSONObject.optDouble(next));
                    break;
                case "allowTextFlow":
                    vSVar.Ym(jSONObject.optBoolean(next));
                    break;
                case "interactWontHide":
                    vSVar.sef(jSONObject.optBoolean(next));
                    break;
                case "fontSize":
                    vSVar.uA((float) jSONObject.optDouble(next));
                    break;
                case "justifyVertical":
                    vSVar.TzV(jSONObject.optString(next));
                    break;
                case "interactVisibleTime":
                    vSVar.Yf(jSONObject.optInt(next));
                    break;
                case "paddingRight":
                    vSVar.Jcg((float) jSONObject.optDouble(next));
                    break;
                case "borderColor":
                    vSVar.Dq(jSONObject.optString(next));
                    break;
                case "borderStyle":
                    vSVar.uA(jSONObject.optString(next));
                    break;
                case "position":
                    vSVar.uvD(jSONObject.optInt(next));
                    break;
                case "isDataFixed":
                    vSVar.HiB(jSONObject.optBoolean(next));
                    break;
                case "marginRight":
                    vSVar.Fmk(jSONObject.optInt(next));
                    break;
                case "justifyHorizontal":
                    vSVar.dNu(jSONObject.optString(next));
                    break;
                case "interactPosition":
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject == null) {
                        break;
                    } else {
                        vSVar.Jcg(optJSONObject.optInt("translateY", 0));
                        vSVar.Dq(optJSONObject.optInt("translateX", 0));
                        vSVar.EjP(optJSONObject.optDouble("scaleX", 0.0d));
                        vSVar.HiB(optJSONObject.optDouble("scaleY", 0.0d));
                        break;
                    }
                case "lineFeed":
                    vSVar.EjP(jSONObject.optBoolean(next));
                    break;
                case "interactText":
                    vSVar.aa(jSONObject.optString(next));
                    break;
                case "interactType":
                    vSVar.sef(jSONObject.optString(next));
                    break;
                case "borderRadius":
                    vSVar.Sj((float) jSONObject.optDouble(next));
                    break;
                case "clickTigger":
                    vSVar.uvD(jSONObject.optString(next));
                    break;
                case "heightMode":
                    vSVar.TEQ(jSONObject.optString(next));
                    break;
                case "textFlowType":
                    vSVar.TzV(jSONObject.optInt(next));
                    break;
                case "borderSize":
                    vSVar.sP((float) jSONObject.optDouble(next));
                    break;
                case "marginLeft":
                    vSVar.aa(jSONObject.optInt(next));
                    break;
                case "letterSpacing":
                    vSVar.sef(jSONObject.optInt(next));
                    break;
            }
        }
    }

    private void ley(String str) {
        this.Gn = str;
    }

    public boolean AVc() {
        return this.tX;
    }

    public boolean Aw() {
        return this.AVc;
    }

    public boolean Bml() {
        return this.MuB;
    }

    public boolean Chv() {
        return this.sdp;
    }

    public String DPc() {
        return this.xzt;
    }

    public double Dq() {
        return this.RrR;
    }

    public void Dq(float f) {
        this.uA = f;
    }

    public void Dq(int i) {
        this.ley = i;
    }

    public void Dq(String str) {
        this.RiZ = str;
    }

    public void Dq(boolean z) {
        this.MuB = z;
    }

    public int EZ() {
        return this.UHs;
    }

    public String Ei() {
        return this.Mts;
    }

    public int EjP() {
        return this.hzV;
    }

    public void EjP(double d) {
        this.LqL = d;
    }

    public void EjP(float f) {
        this.EjP = f;
    }

    public void EjP(int i) {
        this.TX = i;
    }

    public void EjP(String str) {
        this.Zq = str;
    }

    public void EjP(JSONObject jSONObject) {
        this.dLt = jSONObject;
    }

    public void EjP(boolean z) {
        this.FPG = z;
    }

    public double FPG() {
        return this.Yf;
    }

    public void FPG(int i) {
        this.tY = i;
    }

    public String Fm() {
        return this.JcM;
    }

    public void Fmk(int i) {
        this.Ei = i;
    }

    public void Fmk(String str) {
        this.kF = str;
    }

    public void Fmk(boolean z) {
        this.tX = z;
    }

    public boolean Fmk() {
        return this.HiB;
    }

    public boolean GMp() {
        return this.QZ;
    }

    public int Grp() {
        return this.tY;
    }

    public int HS() {
        return this.kb;
    }

    public String HcZ() {
        return this.Ir;
    }

    public int HiB() {
        return this.TX;
    }

    public void HiB(double d) {
        this.Yf = d;
    }

    public void HiB(float f) {
        this.vS = f;
    }

    public void HiB(int i) {
        this.zwV = i;
    }

    public void HiB(String str) {
        this.uvD = str;
    }

    public void HiB(JSONObject jSONObject) {
        this.mj = jSONObject;
    }

    public void HiB(boolean z) {
        this.db = z;
    }

    public boolean HpB() {
        return this.FPG;
    }

    public int IOh() {
        return this.ndK;
    }

    public int Ir() {
        return this.aNB;
    }

    public int JcM() {
        return this.wE;
    }

    public void JcM(int i) {
        this.eMB = i;
    }

    public int Jcg() {
        return this.zwV;
    }

    public void Jcg(float f) {
        this.Dq = f;
    }

    public void Jcg(int i) {
        this.wE = i;
    }

    public void Jcg(String str) {
        this.TzV = str;
    }

    public void Jcg(boolean z) {
        this.sdp = z;
    }

    public String LD() {
        return this.kF;
    }

    public void LD(int i) {
        this.Grp = i;
    }

    public String LqL() {
        return this.zR;
    }

    public void LqL(int i) {
        this.dU = i;
    }

    public double Mts() {
        return this.LqL;
    }

    public void Mts(int i) {
        this.eI = i;
    }

    public boolean MuB() {
        return this.db;
    }

    public JSONObject Ov() {
        return this.dLt;
    }

    public int Ph() {
        return this.TO;
    }

    public boolean QZ() {
        return this.Ov;
    }

    public double RiZ() {
        return this.Ym;
    }

    public void RiZ(int i) {
        this.cX = i;
    }

    public void RiZ(String str) {
        this.dwU = str;
    }

    public int RrR() {
        return this.mZN;
    }

    public boolean SP() {
        return this.oWa;
    }

    public void Sj(double d) {
        this.RrR = d;
    }

    public void Sj(float f) {
        this.Sj = f;
    }

    public void Sj(int i) {
        this.Ph = i;
    }

    public void Sj(long j) {
        this.hif = j;
    }

    public void Sj(String str) {
        this.nou = str;
    }

    public void Sj(List<Sj> list) {
        this.HcZ = list;
    }

    public void Sj(boolean z) {
        this.HS = z;
    }

    public boolean Sj() {
        return this.HS;
    }

    public String TEQ() {
        return this.nou;
    }

    public void TEQ(int i) {
        this.xD = i;
    }

    public void TEQ(String str) {
        this.dx = str;
    }

    public void TEQ(boolean z) {
        this.pfr = z;
    }

    public int TFd() {
        return this.xu;
    }

    public int TKC() {
        return this.GMp;
    }

    public void TKC(double d) {
        this.aa = d;
    }

    public void TKC(float f) {
        this.TKC = f;
    }

    public void TKC(int i) {
        this.hzV = i;
    }

    public void TKC(String str) {
        this.sef = str;
    }

    public void TKC(JSONObject jSONObject) {
        this.SP = jSONObject;
    }

    public void TKC(boolean z) {
        this.uP = z;
    }

    public int TO() {
        return this.TFd;
    }

    public boolean TX() {
        return this.nP;
    }

    public float TzV() {
        return this.TEQ;
    }

    public void TzV(int i) {
        this.aNB = i;
    }

    public void TzV(String str) {
        this.Mts = str;
    }

    public void TzV(boolean z) {
        this.AVc = z;
    }

    public int UHs() {
        return this.Ei;
    }

    public JSONObject Uc() {
        return this.gY;
    }

    public int WMZ() {
        return this.ley;
    }

    public void WMZ(int i) {
        this.TO = i;
    }

    public String Wjd() {
        return this.LD;
    }

    public void WxP() {
        Sj(this, this.SP);
    }

    public List<Sj> Xqg() {
        return this.HcZ;
    }

    public String Yf() {
        return this.ib;
    }

    public void Yf(int i) {
        this.mZN = i;
    }

    public float Ym() {
        return this.Sj;
    }

    public void Ym(int i) {
        this.Fm = i;
    }

    public void Ym(String str) {
        this.zR = str;
    }

    public void Ym(boolean z) {
        this.Bml = z;
    }

    public float Zq() {
        return this.Jcg;
    }

    public void Zq(int i) {
        this.ndK = i;
    }

    public void Zq(String str) {
        this.fF = str;
    }

    public void Zq(boolean z) {
        this.QZ = z;
    }

    public boolean aNB() {
        return this.IOh;
    }

    public int aZ() {
        return this.cX;
    }

    public float aa() {
        return this.sP;
    }

    public void aa(int i) {
        this.jb = i;
    }

    public void aa(String str) {
        this.ib = str;
    }

    public void aa(boolean z) {
        this.Ov = z;
    }

    public boolean cX() {
        return this.pfr;
    }

    public String dLt() {
        return this.vb;
    }

    public float dNu() {
        return this.uA;
    }

    public void dNu(int i) {
        this.Chv = i;
    }

    public void dNu(String str) {
        this.WMZ = str;
    }

    public void dNu(boolean z) {
        this.liH = z;
    }

    public void dU() {
        Sj(this, this.dLt);
    }

    public int db() {
        return this.xD;
    }

    public double dwU() {
        return this.HpB;
    }

    public String dx() {
        return this.Zq;
    }

    public void dx(int i) {
        this.Uc = i;
    }

    public void dx(String str) {
        this.Ir = str;
    }

    public String eI() {
        return this.Aw;
    }

    public int eMB() {
        return this.tz;
    }

    public void fF(int i) {
        this.nru = i;
    }

    public boolean fF() {
        return this.uP;
    }

    public boolean gR() {
        return this.Bml;
    }

    public String gY() {
        return this.dwU;
    }

    public int gq() {
        return this.eMB;
    }

    public int hzV() {
        return this.eI;
    }

    public String ib() {
        return this.dNu;
    }

    public void ib(int i) {
        this.gR = i;
    }

    public void ib(String str) {
        this.Aw = str;
    }

    public String jb() {
        return this.WMZ;
    }

    public String kF() {
        return this.TzV;
    }

    public void kF(int i) {
        this.tz = i;
    }

    public void kF(String str) {
        this.vb = str;
    }

    public String kb() {
        return this.EZ;
    }

    public String ley() {
        return this.dx;
    }

    public void ley(int i) {
        this.WxP = i;
    }

    public int liH() {
        return this.WxP;
    }

    public int mZN() {
        return this.gR;
    }

    public int mj() {
        return this.nru;
    }

    public int nP() {
        return this.tPD;
    }

    public int ndK() {
        return this.Fm;
    }

    public String nru() {
        return this.aZ;
    }

    public int oWa() {
        List<Sj> list = this.HcZ;
        if (list == null) {
            return 0;
        }
        for (Sj sj : list) {
            if ("translate".equals(sj.uA()) && sj.Jcg() < 0) {
                return -sj.Jcg();
            }
        }
        return 0;
    }

    public boolean pfr() {
        return this.qRN;
    }

    public int qRN() {
        return this.jb;
    }

    public int sP() {
        return this.Ph;
    }

    public void sP(double d) {
        this.Ym = d;
    }

    public void sP(float f) {
        this.sP = f;
    }

    public void sP(int i) {
        this.GMp = i;
    }

    public void sP(String str) {
        this.Fmk = str;
    }

    public void sP(JSONObject jSONObject) {
        this.gY = jSONObject;
    }

    public void sP(boolean z) {
        this.HiB = z;
    }

    public double sU() {
        return this.aa;
    }

    public void sU(int i) {
        this.kb = i;
    }

    public void sU(String str) {
        this.EZ = str;
    }

    public int sdp() {
        return this.xhi;
    }

    public float sef() {
        return this.vS;
    }

    public void sef(int i) {
        this.xhi = i;
    }

    public void sef(String str) {
        this.LD = str;
    }

    public void sef(boolean z) {
        this.oWa = z;
    }

    public String tPD() {
        return this.DPc;
    }

    public String tX() {
        return this.Xqg;
    }

    public int tY() {
        return this.dU;
    }

    public int tz() {
        return this.Uc;
    }

    public int uA() {
        return this.gq;
    }

    public void uA(float f) {
        this.TEQ = f;
    }

    public void uA(int i) {
        this.Wjd = i;
    }

    public void uA(String str) {
        this.sU = str;
    }

    public void uA(boolean z) {
        this.IOh = z;
    }

    public String uP() {
        return this.Gn;
    }

    public void uP(int i) {
        this.TFd = i;
    }

    public void uP(String str) {
        this.DPc = str;
    }

    public float uvD() {
        return this.Dq;
    }

    public void uvD(int i) {
        this.UHs = i;
    }

    public void uvD(String str) {
        this.JcM = str;
    }

    public void uvD(boolean z) {
        this.nP = z;
    }

    public JSONObject vS() {
        return this.mj;
    }

    public void vS(double d) {
        this.HpB = d;
    }

    public void vS(float f) {
        this.Jcg = f;
    }

    public void vS(int i) {
        this.gq = i;
    }

    public void vS(String str) {
        this.dNu = str;
    }

    public void vS(boolean z) {
        this.qRN = z;
    }

    public boolean vb() {
        return this.liH;
    }

    public String wE() {
        return this.RiZ;
    }

    public void wE(int i) {
        this.tPD = i;
    }

    public void wE(String str) {
        this.xzt = str;
    }

    public String xD() {
        return this.fF;
    }

    public int xhi() {
        return this.Wjd;
    }

    public int xu() {
        return this.Chv;
    }

    public long xzt() {
        return this.hif;
    }

    public String zR() {
        return this.uvD;
    }

    public void zR(int i) {
        this.xu = i;
    }

    public void zR(String str) {
        this.aZ = str;
    }

    public int zwV() {
        return this.Grp;
    }
}
