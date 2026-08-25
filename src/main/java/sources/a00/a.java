package a00;

import android.support.v4.media.session.c;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.baselib.report.recent_event.ActionEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import org.mvel2.b;
import org.mvel2.compiler.BlankLiteral;
import org.mvel2.util.InternalNumber;
import org.mvel2.util.m;
import org.mvel2.util.r;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class a {
    private static final MathContext a = MathContext.DECIMAL128;

    private static Object a(int i, Object obj, int i2, int i3, Object obj2) {
        if (i2 < 20) {
            if (((i > 49 || i2 == 18 || i2 == 19) && i == i3) || (l(i) && l(i3) && i2 >= 6 && i2 <= 13)) {
                return h(i, obj, i2, obj2);
            }
            if (m(i, obj, i2, i3, obj2)) {
                return i(k(obj, i), i2, k(obj2, i3), true, b(i3) > b(i) ? b(i3) : b(i));
            }
            if (i2 != 0 && ((i == 15 || i3 == 15) && i != i3 && i != 200 && i3 != 200)) {
                return d(i, b.b(obj, Boolean.class), i2, b.b(obj2, Boolean.class));
            }
            if ((i == 1 || i3 == 1) && (i == 8 || i == 112 || i3 == 8 || i3 == 112)) {
                return i == 1 ? d(i, obj, i2, String.valueOf(obj2)) : d(i, String.valueOf(obj), i2, obj2);
            }
        }
        return d(i, obj, i2, obj2);
    }

    private static int b(int i) {
        if (i == 7) {
            return 15;
        }
        if (i == 8) {
            return 112;
        }
        if (i == 9) {
            return 113;
        }
        switch (i) {
            case TAdErrorCode.MAX_MSG_LENGTH /* 100 */:
                return 105;
            case 101:
                return 106;
            case 102:
                return 107;
            case 103:
                return 109;
            case 104:
                return 108;
            default:
                return i;
        }
    }

    private static Object c(BigDecimal bigDecimal, int i, BigDecimal bigDecimal2, boolean z, int i2) {
        if (i == 0) {
            return z ? m.r0(bigDecimal.add(bigDecimal2, a), i2) : bigDecimal.add(bigDecimal2, a);
        }
        if (i == 1) {
            return z ? m.r0(bigDecimal.subtract(bigDecimal2, a), i2) : bigDecimal.subtract(bigDecimal2, a);
        }
        if (i == 2) {
            return z ? m.r0(bigDecimal.multiply(bigDecimal2, a), i2) : bigDecimal.multiply(bigDecimal2, a);
        }
        if (i == 3) {
            return z ? m.r0(bigDecimal.divide(bigDecimal2, a), i2) : bigDecimal.divide(bigDecimal2, a);
        }
        if (i == 4) {
            return z ? m.r0(bigDecimal.remainder(bigDecimal2), i2) : bigDecimal.remainder(bigDecimal2);
        }
        if (i == 5) {
            return z ? m.r0(bigDecimal.pow(bigDecimal2.intValue(), a), i2) : bigDecimal.pow(bigDecimal2.intValue(), a);
        }
        switch (i) {
            case ActionEvent.delete_comment /* 14 */:
                return bigDecimal.compareTo(bigDecimal2) == -1 ? Boolean.TRUE : Boolean.FALSE;
            case ActionEvent.pageview /* 15 */:
                return bigDecimal.compareTo(bigDecimal2) == 1 ? Boolean.TRUE : Boolean.FALSE;
            case 16:
                return bigDecimal.compareTo(bigDecimal2) <= 0 ? Boolean.TRUE : Boolean.FALSE;
            case ActionEvent.want_to_see_cancel /* 17 */:
                return bigDecimal.compareTo(bigDecimal2) >= 0 ? Boolean.TRUE : Boolean.FALSE;
            case 18:
                return bigDecimal.compareTo(bigDecimal2) == 0 ? Boolean.TRUE : Boolean.FALSE;
            case ActionEvent.search_cover_expose /* 19 */:
                return bigDecimal.compareTo(bigDecimal2) != 0 ? Boolean.TRUE : Boolean.FALSE;
            default:
                return null;
        }
    }

    private static Object d(int i, Object obj, int i2, Object obj2) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        if (i2 == 0) {
            if (i == 50) {
                ArrayList arrayList = new ArrayList((Collection) obj);
                arrayList.add(obj2);
                return arrayList;
            }
            return String.valueOf(obj) + String.valueOf(obj2);
        }
        boolean z = true;
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
            if (i2 == 27) {
                return Boolean.valueOf(r.a(String.valueOf(obj)).equals(r.a(String.valueOf(obj2))));
            }
            switch (i2) {
                case ActionEvent.delete_comment /* 14 */:
                    if (!(obj instanceof Comparable)) {
                        return Boolean.FALSE;
                    }
                    if (obj2 != null) {
                        try {
                            if (((Comparable) obj).compareTo(obj2) <= -1) {
                                bool = Boolean.TRUE;
                                return bool;
                            }
                        } catch (ClassCastException e) {
                            throw new RuntimeException("uncomparable values <<" + obj + ">> and <<" + obj2 + ">>", e);
                        }
                    }
                    bool = Boolean.FALSE;
                    return bool;
                case ActionEvent.pageview /* 15 */:
                    break;
                case 16:
                    if (!(obj instanceof Comparable)) {
                        return Boolean.FALSE;
                    }
                    if (obj2 != null) {
                        try {
                            if (((Comparable) obj).compareTo(obj2) <= 0) {
                                bool2 = Boolean.TRUE;
                                return bool2;
                            }
                        } catch (ClassCastException e3) {
                            throw new RuntimeException("uncomparable values <<" + obj + ">> and <<" + obj2 + ">>", e3);
                        }
                    }
                    bool2 = Boolean.FALSE;
                    return bool2;
                case ActionEvent.want_to_see_cancel /* 17 */:
                    if (!(obj instanceof Comparable)) {
                        return Boolean.FALSE;
                    }
                    if (obj2 != null) {
                        try {
                            if (((Comparable) obj).compareTo(obj2) >= 0) {
                                bool3 = Boolean.TRUE;
                                return bool3;
                            }
                        } catch (ClassCastException e4) {
                            throw new RuntimeException("uncomparable values <<" + obj + ">> and <<" + obj2 + ">>", e4);
                        }
                    }
                    bool3 = Boolean.FALSE;
                    return bool3;
                case 18:
                    return n(obj2, obj).booleanValue() ? Boolean.TRUE : Boolean.FALSE;
                case ActionEvent.search_cover_expose /* 19 */:
                    return o(obj2, obj).booleanValue() ? Boolean.TRUE : Boolean.FALSE;
                case ActionEvent.search_cover_click /* 20 */:
                    return String.valueOf(obj) + String.valueOf(obj2);
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("could not perform numeric operation on non-numeric types: left-type=");
                    sb.append(obj != null ? obj.getClass().getName() : "null");
                    sb.append("; right-type=");
                    sb.append(obj2 != null ? obj2.getClass().getName() : "null");
                    sb.append(" [vals (");
                    sb.append(String.valueOf(obj));
                    sb.append(", ");
                    sb.append(String.valueOf(obj2));
                    sb.append(") operation=");
                    sb.append(xz.a.a(i2));
                    sb.append(" (opcode:");
                    sb.append(i2);
                    sb.append(") ]");
                    throw new RuntimeException(sb.toString());
            }
        }
        if (!(obj instanceof Comparable)) {
            return Boolean.FALSE;
        }
        if (obj2 != null) {
            try {
                if ((((Comparable) obj).compareTo(obj2) >= 1 ? Boolean.TRUE : Boolean.FALSE).booleanValue()) {
                    return Boolean.valueOf(z);
                }
            } catch (ClassCastException e5) {
                throw new RuntimeException("uncomparable values <<" + obj + ">> and <<" + obj2 + ">>", e5);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }

    public static Object e(int i, Object obj, int i2, int i3, Object obj2) {
        if (i == -1) {
            i = obj == null ? 0 : m.a(obj.getClass());
        }
        if (i3 == -1) {
            i3 = obj2 == null ? 0 : m.a(obj2.getClass());
        }
        return i != 110 ? a(i, obj, i2, i3, obj2) : i3 != 110 ? i3 > 99 ? c((BigDecimal) obj, i2, j(obj2, i3), false, -1) : a(i, obj, i2, i3, obj2) : c((BigDecimal) obj, i2, (BigDecimal) obj2, false, -1);
    }

    public static Object f(Object obj, int i, int i2, Object obj2) {
        return e(obj == null ? 0 : m.a(obj.getClass()), obj, i, i2, obj2);
    }

    public static Object g(Object obj, int i, Object obj2) {
        return e(obj == null ? 0 : m.a(obj.getClass()), obj, i, obj2 == null ? -1 : m.a(obj2.getClass()), obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:267:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x060e  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x078e  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x079d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object h(int r6, java.lang.Object r7, int r8, java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 2470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a00.a.h(int, java.lang.Object, int, java.lang.Object):java.lang.Object");
    }

    private static Object i(Number number, int i, Number number2, boolean z, int i2) {
        if (i == 0) {
            return p(Double.valueOf(number.doubleValue() + number2.doubleValue()), i2);
        }
        if (i == 1) {
            return p(Double.valueOf(number.doubleValue() - number2.doubleValue()), i2);
        }
        if (i == 2) {
            return p(Double.valueOf(number.doubleValue() * number2.doubleValue()), i2);
        }
        if (i == 3) {
            return p(Double.valueOf(number.doubleValue() / number2.doubleValue()), i2);
        }
        if (i == 4) {
            return p(Double.valueOf(number.doubleValue() % number2.doubleValue()), i2);
        }
        if (i == 5) {
            return p(Double.valueOf(Math.pow(number.doubleValue(), number2.doubleValue())), i2);
        }
        switch (i) {
            case ActionEvent.delete_comment /* 14 */:
                return number.doubleValue() < number2.doubleValue() ? Boolean.TRUE : Boolean.FALSE;
            case ActionEvent.pageview /* 15 */:
                return number.doubleValue() > number2.doubleValue() ? Boolean.TRUE : Boolean.FALSE;
            case 16:
                return number.doubleValue() <= number2.doubleValue() ? Boolean.TRUE : Boolean.FALSE;
            case ActionEvent.want_to_see_cancel /* 17 */:
                return number.doubleValue() >= number2.doubleValue() ? Boolean.TRUE : Boolean.FALSE;
            case 18:
                return number.doubleValue() == number2.doubleValue() ? Boolean.TRUE : Boolean.FALSE;
            case ActionEvent.search_cover_expose /* 19 */:
                return number.doubleValue() != number2.doubleValue() ? Boolean.TRUE : Boolean.FALSE;
            default:
                return null;
        }
    }

    private static InternalNumber j(Object obj, int i) {
        if (obj == null || obj == BlankLiteral.INSTANCE) {
            return new InternalNumber(0, a);
        }
        if (i == 1) {
            return new InternalNumber((String) obj, MathContext.DECIMAL64);
        }
        if (i != 15) {
            if (i == 300) {
                c.a(obj);
                throw null;
            }
            if (i != 7) {
                if (i != 8) {
                    if (i != 9) {
                        switch (i) {
                            case TAdErrorCode.MAX_MSG_LENGTH /* 100 */:
                            case 105:
                                return new InternalNumber((int) ((Short) obj).shortValue(), MathContext.DECIMAL32);
                            case 101:
                            case 106:
                                return new InternalNumber(((Integer) obj).intValue(), MathContext.DECIMAL32);
                            case 102:
                            case 107:
                                return new InternalNumber(((Long) obj).longValue(), MathContext.DECIMAL64);
                            case 103:
                            case 109:
                                return new InternalNumber(((Double) obj).doubleValue(), MathContext.DECIMAL64);
                            case 104:
                            case 108:
                                return new InternalNumber(((Float) obj).floatValue(), MathContext.DECIMAL64);
                            case 110:
                                return new InternalNumber(((BigDecimal) obj).doubleValue());
                            case 111:
                                return new InternalNumber((BigInteger) obj, MathContext.DECIMAL128);
                            case 112:
                                break;
                            case 113:
                                break;
                            default:
                                throw new RuntimeException("cannot convert <" + obj + "> to a numeric type: " + obj.getClass() + " [" + i + "]");
                        }
                    }
                    return new InternalNumber(((Byte) obj).intValue());
                }
                return new InternalNumber((int) ((Character) obj).charValue(), MathContext.DECIMAL32);
            }
        }
        return new InternalNumber(((Boolean) obj).booleanValue() ? 1 : 0);
    }

    private static Double k(Object obj, int i) {
        if (obj == null || obj == BlankLiteral.INSTANCE) {
            return Double.valueOf(0.0d);
        }
        if (i == 1) {
            return Double.valueOf(Double.parseDouble((String) obj));
        }
        if (i == 15 || i == 7) {
            return Double.valueOf(((Boolean) obj).booleanValue() ? 1.0d : 0.0d);
        }
        if (i != 8) {
            if (i != 9) {
                switch (i) {
                    case TAdErrorCode.MAX_MSG_LENGTH /* 100 */:
                    case 105:
                        return Double.valueOf(((Number) obj).doubleValue());
                    case 101:
                    case 106:
                        return Double.valueOf(((Number) obj).doubleValue());
                    case 102:
                    case 107:
                        return Double.valueOf(((Number) obj).doubleValue());
                    case 103:
                    case 109:
                        return (Double) obj;
                    case 104:
                    case 108:
                        return Double.valueOf(((Number) obj).doubleValue());
                    case 110:
                        return Double.valueOf(((Number) obj).doubleValue());
                    case 111:
                        return Double.valueOf(((Number) obj).doubleValue());
                    case 112:
                        break;
                    case 113:
                        break;
                    default:
                        throw new RuntimeException("cannot convert <" + obj + "> to a numeric type: " + obj.getClass() + " [" + i + "]");
                }
            }
            return Double.valueOf(((Byte) obj).doubleValue());
        }
        return Double.valueOf(Double.parseDouble(String.valueOf((Character) obj)));
    }

    private static boolean l(int i) {
        return i == 101 || i == 106 || i == 102 || i == 107;
    }

    private static boolean m(int i, Object obj, int i2, int i3, Object obj2) {
        return (i > 99 && i3 > 99) || (i2 != 0 && ((i > 99 || i3 > 99 || i2 < 14 || i2 > 17) && m.g0(obj) && m.g0(obj2)));
    }

    private static Boolean n(Object obj, Object obj2) {
        boolean z;
        if (obj != null) {
            return obj.equals(obj2) ? Boolean.TRUE : Boolean.FALSE;
        }
        if (obj2 != null) {
            if (!(obj2.equals(obj) ? Boolean.TRUE : Boolean.FALSE).booleanValue()) {
                z = false;
                return Boolean.valueOf(z);
            }
        }
        z = true;
        return Boolean.valueOf(z);
    }

    private static Boolean o(Object obj, Object obj2) {
        return obj != null ? !obj.equals(obj2) ? Boolean.TRUE : Boolean.FALSE : (obj2 == null || obj2.equals(obj)) ? Boolean.FALSE : Boolean.TRUE;
    }

    private static Object p(Number number, int i) {
        if (i == 1) {
            return Double.valueOf(number.doubleValue());
        }
        switch (i) {
            case TAdErrorCode.MAX_MSG_LENGTH /* 100 */:
            case 105:
                return Short.valueOf(number.shortValue());
            case 101:
            case 106:
                return Integer.valueOf(number.intValue());
            case 102:
            case 107:
                return Long.valueOf(number.longValue());
            case 103:
            case 109:
                return Double.valueOf(number.doubleValue());
            case 104:
            case 108:
                return Float.valueOf(number.floatValue());
            case 110:
                return new BigDecimal(number.doubleValue());
            case 111:
                return BigInteger.valueOf(number.longValue());
            default:
                throw new RuntimeException("internal error: " + i);
        }
    }
}
