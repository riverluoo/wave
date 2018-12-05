package com.riverluoo.wave;


import java.util.ArrayList;
import java.util.List;

public class Wave {

    public void getWave(List<Double> data) {
        // 计算一阶差分 && 符号运算
        List<Double> diff = new ArrayList<>();
        for (int i = 0; i < data.size() - 1; i++) {
            diff.add(i, (data.get(i + 1) - data.get(i)));
            if (diff.get(i) > 0) {
                diff.add(i, (double) 1);
            } else if (diff.get(i) < 0) {
                diff.add(i, (double) -1);
            } else {
                diff.add(i, (double) 0);
            }
            diff.remove(i + 1);
        }
        // 从尾部遍历向量diff 处理为0的情况
        int lenth = diff.size() - 1;
        for (int j = 0; j < lenth; j++) {
            if (diff.get(lenth - j - 1) == 0 && diff.get(lenth - j) >= 0) {
                diff.add(lenth - j - 1, (double) 1);
                diff.remove(lenth - j);
            } else if (diff.get(lenth - j - 1) == 0 && diff.get(lenth - j) < 0) {
                diff.add(lenth - j - 1, (double) -1);
                diff.remove(lenth - j);
            }

        }
        // 二次计算一阶差分
        List<Double> tread = new ArrayList<>();
        for (int n = 0; n < diff.size() - 1; n++) {
            tread.add(n, (diff.get(n + 1) - diff.get(n)));
        }

        // 处理波谷波峰
        for (int k = 0; k < tread.size(); k++) {
            if (-2 == tread.get(k)) {
                // 波峰
                System.out.println("波峰:" + data.get(k + 1));

            }
            if (2 == tread.get(k)) {
                // 波谷
                System.out.println("波谷:" + data.get(k + 1));
            }
        }


    }
}
