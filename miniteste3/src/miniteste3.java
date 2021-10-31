class miniteste3 {
	
static int[] test() {
	int[] v = new int[5];
	int i = 1;
	while(i != v.length) {
	    v[i] = 3;
	    i = i + 1;
	}
	return v;
}


static int f(int a, int[] v) {
    int b = 0;
    int i = 0;
    while (i != v.length) {
        if (v[i] != a) {
            b = b + 1;
        }
        i = i + 1;
    }
    return b;
}


static int[] g(int[] v, boolean b) {
    int n = v.length/2;
    if(v.length%2 != 0 && b) {
        n = n + 1;
    }
    int[] u = new int[n];
    int i = 0;
    while(i != n) {
        u[i] = v[i];
        i = i + 1;
    }
    return u;
}


static int[] subArray(int a, int b, int[] v) {
	int[] u = new int[b - a + 1];
    int i = a;
    while(i != b + 1) {
    	u[i - a] = v[i];
        i = i + 1;
    }
    return u;
}

}