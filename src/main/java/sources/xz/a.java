package xz;

import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.baselib.report.recent_event.ActionEvent;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class a {
    public static String a(int i) {
        switch (i) {
            case 0:
                return "ADD";
            case 1:
                return "SUBTRACT";
            case 2:
                return "MULTIPLY";
            case 3:
                return "DIVIDE";
            case 4:
                return "MODULUS";
            case 5:
                return "POWER_OF";
            case 6:
                return "BIT_AND";
            case 7:
                return "BIT_OR";
            case 8:
                return "BIT_XOR";
            case 9:
                return "BIT_SHIFT_RIGHT";
            case 10:
                return "BIT_SHIFT_LEFT";
            case 11:
                return "BIT_UNSIGNED_SHIFT_RIGHT";
            case 12:
                return "BIT_UNSIGNED_SHIFT_LEFT";
            default:
                switch (i) {
                    case ActionEvent.delete_comment /* 14 */:
                        return "LESS_THAN";
                    case ActionEvent.pageview /* 15 */:
                        return "GREATHER_THAN";
                    case 16:
                        return "LESS_THAN_OR_EQUAL";
                    case ActionEvent.want_to_see_cancel /* 17 */:
                        return "GREATER_THAN_OR_EQUAL";
                    case 18:
                        return "EQUAL";
                    case ActionEvent.search_cover_expose /* 19 */:
                        return "NOT_EQUAL";
                    case ActionEvent.search_cover_click /* 20 */:
                        return "STR_APPEND";
                    case 21:
                        return "AND";
                    case 22:
                        return "OR";
                    case 23:
                        return "CHAINED_OR";
                    case 24:
                        return "REGEX";
                    case 25:
                        return "INSTANCEOF";
                    case 26:
                        return "CONTAINS";
                    case 27:
                        return "SOUNDEX";
                    case 28:
                        return "SIMILARITY";
                    case 29:
                        return "TERNARY_IF";
                    case 30:
                        return "TERNARY_ELSE";
                    case 31:
                        return "ASSIGN";
                    case 32:
                        return "INCREMENT_ASSIGN";
                    case 33:
                        return "DECREMENT_ASSIGN";
                    case 34:
                        return "NEW_OBJECT";
                    case 35:
                        return "PROJECT";
                    case 36:
                        return "CONVERTABLE_TO";
                    case 37:
                        return "END_OF_STATEMENT";
                    case 38:
                        return "FOREACH";
                    case 39:
                        return "IF";
                    case 40:
                        return "ELSE";
                    case 41:
                        return "WHILE";
                    default:
                        switch (i) {
                            case 43:
                                return "FOR";
                            case 44:
                                return "SWITCH";
                            case 45:
                                return "DO";
                            default:
                                switch (i) {
                                    case 50:
                                        return "INCREMENT";
                                    case 51:
                                        return "DECREMENT";
                                    case 52:
                                        return "ASSIGN_ADD";
                                    case 53:
                                        return "ASSIGN_SUB";
                                    case 54:
                                        return "ASSIGN_STR_APPEND";
                                    default:
                                        switch (i) {
                                            case 99:
                                                return "RETURN";
                                            case TAdErrorCode.MAX_MSG_LENGTH /* 100 */:
                                                return "FUNCTION";
                                            case 101:
                                                return "STACKLANG";
                                            default:
                                                return "UNKNOWN_OPERATOR";
                                        }
                                }
                        }
                }
        }
    }

    public static String b(int i) {
        switch (i) {
            case 0:
                return "+";
            case 1:
                return "-";
            case 2:
                return "*";
            case 3:
                return "/";
            case 4:
                return "%";
            case 5:
                return "**";
            case 6:
                return "&";
            case 7:
                return "|";
            case 8:
                return "^";
            case 9:
                return ">>";
            case 10:
                return "<<";
            case 11:
                return ">>>";
            case 12:
                return "<<<";
            default:
                switch (i) {
                    case ActionEvent.delete_comment /* 14 */:
                        return "<";
                    case ActionEvent.pageview /* 15 */:
                        return ">";
                    case 16:
                        return "<=";
                    case ActionEvent.want_to_see_cancel /* 17 */:
                        return ">=";
                    case 18:
                        return "==";
                    case ActionEvent.search_cover_expose /* 19 */:
                        return "!=";
                    case ActionEvent.search_cover_click /* 20 */:
                        return "+";
                    case 21:
                        return "&&";
                    case 22:
                        return "||";
                    case 23:
                        return "or";
                    case 24:
                        return "REGEX";
                    case 25:
                        return "instanceof";
                    case 26:
                        return "contains";
                    case 27:
                        return "SOUNDEX";
                    case 28:
                        return "SIMILARITY";
                    case 29:
                        return "TERNARY_IF";
                    case 30:
                        return "TERNARY_ELSE";
                    case 31:
                        return "=";
                    case 32:
                    case 33:
                        return "++";
                    case 34:
                        return "new";
                    case 35:
                        return "PROJECT";
                    case 36:
                        return "convertable_to";
                    case 37:
                        return ";";
                    case 38:
                        return "foreach";
                    case 39:
                        return "if";
                    case 40:
                        return "else";
                    case 41:
                        return "while";
                    default:
                        switch (i) {
                            case 43:
                                return "for";
                            case 44:
                                return "SWITCH";
                            case 45:
                                return "do";
                            default:
                                switch (i) {
                                    case 50:
                                        return "++";
                                    case 51:
                                        return "--";
                                    case 52:
                                        return "=+";
                                    case 53:
                                        return "=";
                                    case 54:
                                        return "=+";
                                    default:
                                        switch (i) {
                                            case 99:
                                                return "RETURN";
                                            case TAdErrorCode.MAX_MSG_LENGTH /* 100 */:
                                                return "function";
                                            case 101:
                                                return "stacklang";
                                            default:
                                                return "UNKNOWN_OPERATOR";
                                        }
                                }
                        }
                }
        }
    }
}
