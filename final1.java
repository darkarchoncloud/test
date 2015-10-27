class final1 {
	public long pow(long a,long b) {
		if (b == 0) {
			return 1;
		}
		if (b == 1) {
			return a;
		}
		long half = b / 2;
		long halfPow = pow(a, half);
		if (b % 2 == 0) {
			return halfPow * halfPow;
		} else {
			return halfPow * halfPow * a;
		}
  }

  public long npow(long x, int n) {
  	
  	if (n == 1) {
  		return x;
  	}
  	if (n == 2) {
  		return pow(x, x);
  	}
  	long mid = pow(x, x);
  	int half = n / 2;
  	if (n % 2 == 0) {
  		return npow(mid, half);
  	} else {
  		return pow(npow(mid, half), x);
  	}

  }

  public static void main(String[] args) {
      final1 newfinal = new final1();
      long a = 2;
      int b = 10;
      long result = newfinal.pow(a,b);
      long result1 = newfinal.npow(2,4);
      System.out.println(result);
      System.out.println(result1);

  }
}