package aed;

class Debugging {
    boolean xor(boolean a, boolean b) {
        return (a || b) && !(a && b);
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;
        for (int i = 0; i < xs.length; i++) {
            if (xs.length == ys.length) {
                if (xs[i] != ys[i]) {
                    res = false;
                }
            } else if (xs.length != ys.length) {
                res = false;
            }
        }
        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;
        for (int i = 0; i < (xs.length-1); i++) {
            if (xs[i] > xs[i + 1]) {
                res = false;
            }
        }
        return res;
    }

    int maximo(int[] xs) {
        int res = 0;
        for (int i = 0; i <= xs.length; i++) {
            if (xs[i] > res)
                res = xs[i];
        }
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = true;
        for (int i = 0; i < xs.length;i++){
             if (xs[i] < 0) {
                res = false;
                return res;
             }  
        }
        return res;
    }
}
