package cn.com.yunyoutianxia.commons.core.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Pattern;

public class IdCheck {

    public static LocalDate toLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate;
    }

    public static int sex(String id) {
        if (id.length() == 15) {
            int sex = Integer.parseInt(id.substring(15, 15));
            return sex % 2 == 1 ? 1 : 2;
        } else {
            if (id.length() == 18) {
                int sex = Integer.parseInt(id.substring(16, 17));
                return sex % 2 == 1 ? 1 : 2;
            } else {
                return -1;
            }
        }
    }

    public static int age(LocalDate birth) {
        LocalDate now = LocalDate.now();
        int age = now.getYear() - birth.getYear();
        if (now.getMonthValue() < birth.getMonthValue()) {
            return age;
        } else {
            if (now.getMonthValue() == birth.getMonthValue()) {
                if (now.getDayOfMonth() < birth.getDayOfMonth() || now.getDayOfMonth() == birth.getDayOfMonth()) {
                    return age;
                }
            }
            return age++;
        }
    }

    public static String birthday(String id) {
        if (id.length() == 15) {
            String year = id.substring(6, 8);
            String month = id.substring(8, 10);
            String day = id.substring(10, 12);
            StringBuilder sb = new StringBuilder();
            sb.append("19");
            sb.append(year);
            sb.append("-");
            sb.append(month);
            sb.append("-");
            sb.append(day);
            return sb.toString();
        } else {
            if (id.length() == 18) {
                String year = id.substring(6, 10);
                String month = id.substring(10, 12);
                String day = id.substring(12, 14);
                StringBuilder sb = new StringBuilder();
                sb.append(year);
                sb.append("-");
                sb.append(month);
                sb.append("-");
                sb.append(day);
                return sb.toString();
            } else {
                return null;
            }
        }
    }

    public static boolean matches(String id) {
        if (id.length() == 15) {
            String regex = "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
            return Pattern.matches(regex, id);
        } else {
            if (id.length() == 18) {
                String regex = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)";
                boolean matches = Pattern.matches(regex, id);
                if (!matches) {
                    return Boolean.FALSE;
                }
                char[] charArray = id.toCharArray();
                //前十七位加权因子
                int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                //这是除以11后，可能产生的11位余数对应的验证码
                String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                int sum = 0;
                for (int j = 0; j < idCardWi.length; j++) {
                    int current = Integer.parseInt(String.valueOf(charArray[j]));
                    int count = current * idCardWi[j];
                    sum += count;
                }
                char idCardLast = charArray[17];
                int idCardMod = sum % 11;
                if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                    System.out.println("正确");
                    return Boolean.TRUE;
                } else {
                    System.out.println("身份证最后一位:" + String.valueOf(idCardLast).toUpperCase() +
                            "错误,正确的应该是:" + idCardY[idCardMod].toUpperCase());
                    return Boolean.FALSE;
                }
            } else {
                return Boolean.FALSE;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(IdCheck.sex("360731199509226519"));

    }
}
