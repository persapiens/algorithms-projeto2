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

import java.io.File;
import java.io.IOException;

/**
 * Main class.
 * @author Marcelo Fernandes
 */
public class Projeto2Main {
	public static void main(String[] args) throws IOException {
		if (args.length == 1) {
			new Projeto2().processarGrafo(new File(args[0]));
		}
		else {
			System.out.println("Uso: " + Projeto2Main.class.getCanonicalName() 
				+ " <grafo.txt>");
		}
	}
}
