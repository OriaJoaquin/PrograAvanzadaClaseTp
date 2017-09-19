package tp2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBinomioDeNewton {
	BinomioDeNewton b1;
	BinomioDeNewton b2;
	BinomioDeNewton b3;
	BinomioDeNewton b4;
	BinomioDeNewton b5;
	BinomioDeNewton b6;
	BinomioDeNewton b7;
	BinomioDeNewton b8;
	BinomioDeNewton b9;
	BinomioDeNewton b10;
	BinomioDeNewton b11;
	BinomioDeNewton b12;
	
	@Before
	public void setUp() {
		b1 = new BinomioDeNewton(1,1,2);   //x^2+2x+1
		b2 = new BinomioDeNewton(1,-3,5);  //x^5 - 15x^4 + 90x^3 - 270x^2 + 405x - 243
		b3 = new BinomioDeNewton(3,2,2);   // 9x^2 + 12x +4
		b4 = new BinomioDeNewton(2,-3,7);  // 128 x^7 - 1344 x^6 + 6048 x^5 - 15120 x^4 + 22680 x^3 - 20412 x^2 + 10206 x - 2187
		b5 = new BinomioDeNewton(-1,-4,9); // -x^9 - 36 x^8 - 576 x^7 - 5376 x^6 - 32256 x^5 - 129024 x^4 - 344064 x^3 - 589824 x^2 - 589824 x - 262144
		b6 = new BinomioDeNewton(-3,2,15); //-14348907 x^15 + 143489070 x^14 - 669615660 x^13 + 1934445240 x^12 - 3868890480 x^11 + 5674372704 x^10 - 6304858560 x^9 + 5404164480 x^8 - 3602776320 x^7 + 1868106240 x^6 - 747242496 x^5 + 226437120 x^4 - 50319360 x^3 + 7741440 x^2 - 737280 x + 32768
		b7 = new BinomioDeNewton(-4,3,17);
		b8 = new BinomioDeNewton(-4,3,19);
		b9 = new BinomioDeNewton(-4,3,25);
		b10 = new BinomioDeNewton(-4,3,30);
		b11 = new BinomioDeNewton(-4,3,35);
		b12 = new BinomioDeNewton(11,6,50);
	}
	
	
	@Test
	public void queMuestreBienLosCoeficientes() {
		Assert.assertEquals(2, b1.obtenerCoeficiente(1), 0.001);
		Assert.assertEquals(-15, b2.obtenerCoeficiente(4),1.501);
		Assert.assertEquals(4, b3.obtenerCoeficiente(0),0.001);
		Assert.assertEquals(6048, b4.obtenerCoeficiente(5),0.001);
		Assert.assertEquals(-36, b5.obtenerCoeficiente(8),0.001);
		Assert.assertEquals(-14348907, b6.obtenerCoeficiente(15),0.001);
		Assert.assertEquals(Double.parseDouble("-17179869184"), b7.obtenerCoeficiente(17),0.001);
		Assert.assertEquals(Double.parseDouble("-274877906944"), b8.obtenerCoeficiente(19),0.001);
		Assert.assertEquals(Double.parseDouble("-1125899906842624"), b9.obtenerCoeficiente(25),0.001);
		Assert.assertEquals(Double.parseDouble("1152921504606846976"), b10.obtenerCoeficiente(30),0.001);
		Assert.assertEquals(Double.parseDouble("-1180591620717411303424"), b11.obtenerCoeficiente(35),0.001);
		Assert.assertEquals(Double.parseDouble("11739085287969531650666649599035831993898213898723001"), b12.obtenerCoeficiente(50),0.001);
	}
	
	@Test
	public void queMuestreBienLosCoeficientesStirling() {
		Assert.assertEquals(2, b1.obtenerCoeficienteStirling(1), 0.1);
		Assert.assertEquals(-15, b2.obtenerCoeficienteStirling(4),0.07);
		Assert.assertEquals(4, b3.obtenerCoeficienteStirling(0),0.001);
		Assert.assertEquals(6048, b4.obtenerCoeficienteStirling(5),334.1);
		Assert.assertEquals(-36, b5.obtenerCoeficienteStirling(8),0.05);
		Assert.assertEquals(-14348907, b6.obtenerCoeficienteStirling(15),0.001);
		Assert.assertEquals(Double.parseDouble("-17179869184"), b7.obtenerCoeficienteStirling(17),0.001);
		Assert.assertEquals(Double.parseDouble("-274877906944"), b8.obtenerCoeficienteStirling(19),0.001);
		Assert.assertEquals(Double.parseDouble("-1125899906842624"), b9.obtenerCoeficienteStirling(25),0.001);
		Assert.assertEquals(Double.parseDouble("1152921504606846976"), b10.obtenerCoeficienteStirling(30),0.001);
		Assert.assertEquals(Double.parseDouble("-1180591620717411303424"), b11.obtenerCoeficienteStirling(35),0.001);
		Assert.assertEquals(Double.parseDouble("11739085287969531650666649599035831993898213898723001"), b12.obtenerCoeficienteStirling(50),0.001);
	}
	
	@Test
	public void medirTiempoEjecucion() {
		long time_start,time_end;
		time_start= System.nanoTime();
		queMuestreBienLosCoeficientes();
		time_end = System.nanoTime();
		System.out.println("La tarea con factorial común ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
	}
	
	@Test
	public void medirTiempoEjecucionStirling() {
		long time_start,time_end;
		time_start= System.nanoTime();
		queMuestreBienLosCoeficientesStirling();
		time_end = System.nanoTime();
		System.out.println("La tarea con factorial Stirling ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
	}
	
}
