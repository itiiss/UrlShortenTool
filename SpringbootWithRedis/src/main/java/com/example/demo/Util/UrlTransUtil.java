package com.example.demo.Util;

public class UrlTransUtil {

    private static final int TOTAL_COUNT = 10 + 26 + 26;

    private static char hash[] = new char[]{'0','1','2','3','4','5', '6','7','8','9',
    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static Long toDecimal(String str) {
        Long res = 0L;
        char temp[] = str.toCharArray();
        for (int i = 0; i < temp.length ; i++) {
            if(temp[i]>'0' && temp[i] < '9') res = res * TOTAL_COUNT + (temp[i] - '0');
            if(temp[i]>('a'-1) && temp[i] < ('z'+1)) res = res * TOTAL_COUNT + (temp[i] - 'a' + 10);
            if(temp[i]>('A'-1) && temp[i] < ('Z'+1)) res = res * TOTAL_COUNT + (temp[i] - 'A' + 10 + 26);
        }
        return res;

    }


    public static String toMixin(Long l) {
        if(l == 0L) {
            return "0";
        }
        Long left = l;
        StringBuilder ans = new StringBuilder(0);
        while(left> 0) {
            Long cur = (left % TOTAL_COUNT);
            int c = cur.intValue();
            ans.append(hash[c]);
            left /= TOTAL_COUNT;
        }
        String res = ans.reverse().toString();
        return res;


    }

    public static void main(String[] args) {
        for (long i = 0L; i < 1200; i++) {
            String s = UrlTransUtil.toMixin(i);
            long l = UrlTransUtil.toDecimal(s);

            System.out.println(i +"-> "+ s + "-->"+  l);

        }
    }
}
