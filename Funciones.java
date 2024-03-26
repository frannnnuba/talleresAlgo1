package aed;

class Funciones {
    int cuadrado(int x) {
        if (x != 0) {
            return x * x;
        }
        return 0;
    }

    double distancia(double x, double y) {
        if (x != 0 && y != 0) {
            return Math.sqrt((x * x) + (y * y));
        }
        return 0.0;
    }

    boolean esPar(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }

    boolean esBisiesto(int n) {
        if (n % 400 == 0) {
            return true;
        } else if (n % 4 == 0 && n % 100 != 0) {
            return true;
        }
        return false;
    }

    int factorialIterativo(int n) {
        int i = 1;
        int res = 1;
        if (n != 0) {
            while (i != (n + 1)) {
                res = res * i;
                i++;
            }
            return res;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if (n == 0) {
            return res;
        } else if (n == 1) {
            return res;
        } else if (n != 1) {
            res = n * factorialRecursivo((n - 1));
        }
        return res;
    }

    boolean esPrimo(int n) {
        int div = n - 1;
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        while (div != 1) {
            if (n % div == 0) {
                return false;
            } else if (n % div != 0) {
                div = div - 1;
            }
        }
        return true;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++) {
            res = res + numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                res = i;
                return res;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean valor = false;
        for (int i = 0; i < numeros.length; i++) {
            valor = esPrimo(numeros[i]);
            if (valor == true) {
                return valor;
            }
        }
        return valor;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 != 0) {
                res = false;
                return res;
            }
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        boolean res = true;
        if (l1 <= l2) {
            for (int i = 0; i < l1; i++) {
                char a = s1.charAt(i);
                char b = s2.charAt(i);
                if (a != b) {
                    res = false;
                    return res;
                }
            }
        } else if (l1 > l2) {
            res = false;
            return res;
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int inicioSuf = (l2 - l1);
        if (l1 <= l2) {
            for (int i = 0;i < l1; i++) {
                char a = s1.charAt(i);
                char b = s2.charAt(i + inicioSuf);
                if (a != b) {
                    return false;
                }
            }
        } else if (l1 > l2) {
            return false;
        }
        return true;
    }

}