package leetcode;

/**
 * @Author zlx
 * @Date 2024/6/18 11:47
 */
public class DiscountPrices {
    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        int n = sentence.length();
        char[] chs = sentence.toCharArray();
        for (int i = 0; i < n;) {
            if (chs[i] == '$') {
                int j = i + 1;
                while (j < n && Character.isDigit(chs[j])) {
                    j++;
                }
                if (j == i + 1) {
                    sb.append(chs[i]);
                }else {
                    if (j == n ||chs[j] == ' ') {
                        sb.append(replacePrice(sentence.substring(i, j), discount));
                    }else {
                        sb.append(sentence.substring(i, j));
                    }
                }
                i = j;
                continue;
            }
            sb.append(chs[i++]);
        }
        return sb.toString();
    }

    private String replacePrice(String word, int discount) {
        if (word.charAt(0) != '$') return word;
        if (discount == 0) return word;
        else if (discount == 100) return "$0.00";
        else {
            double price = Double.parseDouble(word.substring(1));
            price = price * (100 - discount) / 100;
            return "$"+ String.format("%.2f", price);
        }
    }
}
