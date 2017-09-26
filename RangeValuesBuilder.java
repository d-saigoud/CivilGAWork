package com.sai;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.Random;

public class RangeValuesBuilder {

	private static Random random = new Random();

	private static DecimalFormat df = new DecimalFormat("#.####");

	private static DecimalFormat df2 = new DecimalFormat("#.#########");

	public static void main(String[] args) throws Exception {

		// if(1==1) {
		// // double[][] a = {
		// // {1,1,1},
		// // {1,1,1}
		// // };
		// double[][] a = {
		// {0.9978,1.0196},
		// {1,2},
		// {1,2}
		// };
		// double[][] b = {
		// {1,1},
		// {1,1},
		// {1,1}
		// };
		//
		// System.out.println(checkAllGreaterThan(a, 0.0000));
		//
		//// double[][] result = matrixSubstraction(a, b);
		////
		////
		//// for(int i = 0 ; i<result.length; i++) {
		//// for(int j=0; j<result[0].length; j++) {
		//// System.out.print(result[i][j] + " ");
		//// }
		//// System.out.println();
		//// }
		//
		// return;
		// }

		BufferedWriter successBW = new BufferedWriter(new FileWriter("D:/Masters/Civil_GA_Work/Dehua/Success.txt"));
		BufferedWriter failureBW = new BufferedWriter(new FileWriter("D:/Masters/Civil_GA_Work/Dehua/Failure.txt"));

		BufferedWriter logBW = new BufferedWriter(new FileWriter("D:/Masters/Civil_GA_Work/Dehua/Log.txt"));

		successBW.close();
		failureBW.close();

		double[][] result = null;
		double count = 0.0;

		// [a,b,c,d,e,f,g,h,i,j,k,l,m]=deal(1.0000);

		double[][] K = { { 400.0000 }, { 211.0000 }, { 185.0000 }, { 230.0000 }, { 83.0000 } };

		double[][] D = { { 726.0000 }, { 431.0000 }, { 835.0000 }, { 393.0000 }, { 722.0000 }, { 406.0000 },
				{ 805.0000 }, { 452.0000 } };

		double[][] Cu = { { 0.8750, -0.1250, -0.1250, -0.1250, 0.1250, 0.1250, 0.1250, 0.1250 },
				{ 0.6250, 0.6250, -0.3750, -0.3750, 0.3750, 0.3750, 0.3750, -0.6250 },
				{ -0.7500, 0.2500, 0.2500, 0.2500, -0.2500, -0.2500, -0.2500, 0.7500 },
				{ 0.3750, 0.3750, 0.3750, -0.6250, -0.3750, 0.6250, 0.6250, -0.3750 },
				{ -0.5000, -0.5000, 0.5000, 0.5000, 0.5000, -0.5000, -0.5000, 0.5000 },
				{ 0.1250, 0.1250, 0.1250, 0.1250, -0.1250, -0.1250, 0.8750, -0.1250 },
				{ -0.2500, -0.2500, -0.2500, 0.7500, 0.2500, 0.2500, -0.7500, 0.2500 } };

		double[] AA = { randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal() };
		double[] BB = { randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal() };
		double[] CC = { randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal() };
		double[] DD = { randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal() };
		double[] EE = { randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal() };
		double[] FF = { randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal() };
		double[] GG = { randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal() };
		double[] HH = { randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal() };
		double[] II = { randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal() };
		double[] JJ = { randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal() };
		double[] KK = { randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal() };
		double[] LL = { randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal() };
		double[] MM = { randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal(), randomDecimal() };

		for (int a1 = 0; a1 < 5; a1++) {
			double a = AA[a1];
			System.out.println("a1: " + a1);
			for (int b1 = 0; b1 < 5; b1++) {
				double b = BB[b1];
				for (int c1 = 0; c1 < 5; c1++) {
					double c = CC[c1];
					for (int d1 = 0; d1 < 5; d1++) {
						double d = DD[d1];
						for (int e1 = 0; e1 < 5; e1++) {
							double e = EE[e1];
							for (int f1 = 0; f1 < 5; f1++) {
								double f = FF[f1];
								for (int g1 = 0; g1 < 5; g1++) {
									double g = GG[g1];
									for (int h1 = 0; h1 < 5; h1++) {
										double h = HH[h1];

										String sum1 = df2.format(a + b + c + d);
										String sum2 = df2.format(e + f + g + h);

										logBW.write(a + "," + b + "," + c + "," + d + "," + e + "," + f + "," + g + ","
												+ h);
										logBW.newLine();
										if (sum1.equals(sum2)) {
											//System.out.println("TRUE");
											// if ((a + b + c + d) == (e + f + g
											// + h)) {
											for (int i1 = 0; i1 < 5; i1++) {
												double i = II[i1];
												for (int j1 = 0; j1 < 5; j1++) {
													double j = JJ[j1];
													for (int k1 = 0; k1 < 5; k1++) {
														double k = KK[k1];
														for (int l1 = 0; l1 < 5; l1++) {
															double l = LL[l1];
															for (int m1 = 0; m1 < 5; m1++) {
																double m = MM[m1];
																double[][] V = { { a, 0, 0, 0, 0, 0, 0, 0 },
																		{ 0, b, 0, 0, 0, 0, 0, 0 },
																		{ 0, 0, c, 0, 0, 0, 0, 0 },
																		{ 0, 0, 0, d, 0, 0, 0, 0 },
																		{ 0, 0, 0, 0, e, 0, 0, 0 },
																		{ 0, 0, 0, 0, 0, f, 0, 0 },
																		{ 0, 0, 0, 0, 0, 0, g, 0 },
																		{ 0, 0, 0, 0, 0, 0, 0, h } };
																double[][] Ck = { { i, j, 0, 0, 0 }, { 0, 0, k, 0, 0 },
																		{ 0, 0, 0, l, 0 }, { 0, 0, 0, 0, m },
																		{ 0, 0, 0, 0, m }, { 0, j, 0, 0, 0 },
																		{ i, 0, k, 0, 0 }, { 0, 0, 0, l, 0 } };
																// result =
																// Cu*(V*D-Ck*K);
																result = matrixMultiply(Cu, matrixSubstraction(
																		matrixMultiply(V, D), matrixMultiply(Ck, K)));
																logBW.write(matrixToString(result));
																logBW.newLine();
																if (checkAllGreaterThan(result, 0.0000f)) {

																	String line = df.format(a) + " ; " + df.format(b)
																			+ " ; " + df.format(c) + " ; "
																			+ df.format(d) + " ; " + df.format(e)
																			+ " ; " + df.format(f) + " ; "
																			+ df.format(g) + " ; " + df.format(h)
																			+ " ; " + df.format(i) + " ; "
																			+ df.format(j) + " ; " + df.format(k)
																			+ " ; " + df.format(l) + " ; "
																			+ df.format(m) + " ; "
																			+ matrixToString(result);

																	successBW = new BufferedWriter(new FileWriter(
																			"D:/Masters/Civil_GA_Work/Dehua/Success.txt",
																			true));
																	successBW.write(line);
																	successBW.newLine();
																	successBW.close();
																	//System.out.println("Check All True");

																} else {
																	// System.out.println("checkAllGreaterThan(result,
																	// 0.0000)
																	// False");
																}

															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		System.out.println(matrixToString(result));

		logBW.close();

	}

	private static String matrixToString(double[][] a) {

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < a.length; i++) {
			sb.append("[");
			for (int j = 0; j < a[0].length; j++) {

				sb.append(a[i][j] + (j == a[0].length - 1 ? "" : " "));

			}
			sb.append("]");
		}
		sb.append("]");

		return sb.toString();
	}

	public static double randomDecimal() {

		double y = 0;
		while (true) {

			y = random.nextInt(10250);

			if (y >= 9250 && y <= 10250) {
				y = y / 10000.0;
				break;
			}

		}

		return y;

	}

	public static double[][] matrixMultiply(double[][] a, double[][] b) throws Exception {

		double[][] result = new double[a.length][b[0].length];

		if (a[0].length == b.length) {
			for (int i = 0; i < a.length; i++) {

				for (int j = 0; j < b[0].length; j++) {
					result[i][j] = 0;

					for (int k = 0; k < b.length; k++) {

						result[i][j] += a[i][k] * b[k][j];

					}

				}

			}
		} else {
			throw new Exception(
					"Columns of First Matrix not equal to rows of second matrix. Matrix Multiplication Violation");
		}

		return result;

	}

	public static double[][] matrixSubstraction(double[][] a, double[][] b) throws Exception {

		double[][] result = new double[a.length][a[0].length];

		if (a.length == b.length && a[0].length == b[0].length) {
			for (int i = 0; i < a.length; i++) {

				for (int j = 0; j < a[0].length; j++) {

					result[i][j] = a[i][j] - b[i][j];

				}

			}
		} else {
			throw new Exception("Cannot Subtract two matrices because their dmentions do not match");
		}

		return result;

	}

	public static boolean checkAllGreaterThan(double[][] a, double threshold) {

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a[0].length; j++) {

				if (a[i][j] < threshold) {
					return false;
				}

			}

		}

		return true;

	}

}
