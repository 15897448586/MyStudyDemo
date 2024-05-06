package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/5/6 17:40
 */
class Solution61 {
    public int encryptionCalculate(int dataA, int dataB) {
        while(dataB != 0) { // 当进位为 0 时跳出
            int c = (dataA & dataB) << 1;  // c = 进位
            dataA ^= dataB; // dataA = 非进位和
            dataB = c; // dataB = 进位
        }
        return dataA;
    }
}
