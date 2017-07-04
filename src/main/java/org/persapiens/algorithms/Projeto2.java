/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.persapiens.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.persapiens.algorithms.graph.apsp.FloydWarshall;
import org.persapiens.algorithms.graph.apsp.Matrix;
import static org.persapiens.algorithms.graph.apsp.Matrix.INFINITY;
import static org.persapiens.algorithms.graph.apsp.Matrix.NIL;

/**
 * Main class.
 * @author Marcelo Fernandes
 */
public class Projeto2 {

	public Projeto2() {
	}

	/**
	 * Imprime a lista ordenada de todas as chaves armazenadas na árvore T.
	 */
	private void print(Matrix D) {
		String result = "";
		for (int i = 0; i < D.getRows(); i++) {
			System.out.println(line(D, i));
		}
	}
	
	private String line(Matrix D, int i) {
		String result = "";
		for (int j = 0; j < D.getRows(); j++) {
			String d = D.get(i, j).equals(NIL) ? "NIL" : D.get(i, j).toString();
			if (j > 0) {
				result += " ";
			}

			result += d;
		}
		return result;
	}
	
	private Matrix fillLine(Matrix matrix, int i, String readLine) {
		String[] values = readLine.split(" ");
		for (int j = 0; j < matrix.getRows(); j++) {
			String s = values[j];
			Integer value = s.equals("INFINITY") ? INFINITY : Integer.parseInt(s);
			matrix.set(i, j, value);
		}
		return matrix;
	}

	private Matrix createMatrix(BufferedReader bis) throws IOException {
		int numberOfVertices = Integer.parseInt(bis.readLine());
		Matrix result = new Matrix(numberOfVertices);
		for (int i = 0; i < numberOfVertices; i++) {
			result = fillLine(result, i, bis.readLine());
		}
		return result;
	}
	
	public void processarGrafo(File grafo) throws IOException {
		try (BufferedReader bis = new BufferedReader(new FileReader(grafo))) {
			Matrix matrix = createMatrix(bis);
			
			FloydWarshall floydWarshall = new FloydWarshall();
			Matrix D = floydWarshall.create(matrix);
			
			print(D);
		}
	}

}
