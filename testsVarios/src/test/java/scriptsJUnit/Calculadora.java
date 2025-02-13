package scriptsJUnit;

	public class Calculadora {
		private int num1;
		private int num2;

		public Calculadora(int num1, int num2) {
			super();
			this.num1 = num1;
			this.num2 = num2;
		}

		public int suma() {
			return num1 + num2;
		}

		public int resta() {
			return num1 - num2;
		}

		public int multiplica() {
			return num1 * num2;
		}

		public int divide() {
			return num1 / num2;
		}
		
	    public int valorAbsoluto() {
	        return restaPositiva() ? num1 - num2 : num2 - num1;
	    }

	    public boolean restaPositiva() {
	        return this.num1 >= this.num2;
	    }

	    public Integer divideAcepta0() {
	        return num2 == 0 ? null : num1 / num2;
	    }
	}

