class Rational0 {

    int n;
    int d;
   
    Rational0(int n, int d) {
        this.n = n;
        this.d = d;
    }
    boolean isEqualTo(Rational0 r) {
        return this.n*r.d == r.n*this.d;
    }
   
}
