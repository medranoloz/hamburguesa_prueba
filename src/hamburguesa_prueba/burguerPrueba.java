/*
 - Será necesario desarrollar un switch para las distintas opciones. 

Opción 1: Será necesario solicitar el nombre de la hamburguesa y las unidades a comer 
por pantalla al usuario y se calculará y visualizará el importe del pedido.

Opción 2: Será necesario visualizar el nombre y el importe de la hamburguesa más barata.

Opción 3: Será necesario solicitar el nombre de la hamburguesa por pantalla al usuario y se mostrarán todos 
sus ingredientes y el stock disponible.

Opción 4: Será necesario solicitar el nombre del ingrediente por pantalla al usuario y se visualizará el texto
"SI, hay hamburguesas con dicho ingrediente y son las siguientes:" + el nombre de las hamburguesas que tengan
dicho ingrediente entre sus ingredientes. Es necesario hacer uso de una variable BOOLEAN. En caso contrario 
se visualizará: "NO, no hay hamburguesas con dicho ingrediente". 

Opción 5: Será necesario solicitar el nombre de la hamburguesa y las unidades a comer por pantalla al usuario y
se disminuirá el stock de dicha hamburguesa. Será necesario visualizar un mensaje con el nuevo stock de la 
hamburguesa "El nuevo stock de la hamburguesa x es de y unidades."

Opción 6: Será necesario solicitar el número de comensales y se calculará la media de hamburguesas que puede comer
cada comensal teniendo en cuenta el stock existente.

*/

package hamburguesa_prueba;
import java.util.Scanner;

public class burguerPrueba {

	public static void main(String[] args) {
		
		//variables que nos dan
		//prueba github
				String[] aIngredientes = { "carne , tomate, picante, pimiento", "carne, lechuga, bacon, alioli", "carne,  cebolla, cheddar, lechuga, tomate, mahonesa", "carne, bacon, cebolla,cheddar, lechuga,tomate, mayonesa,barbacoa"};
				String[] aNombre = { "Mexicano", "Alioli", "CheeseBurger", "Barbacoa"};
				double[] aPrecio = { 8.50, 11, 12.50, 14};
				int[] aStock = { 12, 8, 23, 15};
				
				int selector;
				Scanner leer;
				leer= new Scanner(System.in);
				
				//metodo do while con el que recorremos al menos una vez todo el metodo
				do {
					
					//menu que se mostrara por pantalla al lanzar el programa
					System.out.println("-----------MENU------------");
					System.out.println("1.PEDIDO");
					System.out.println("2.LA HAMBURGUESA MAS BARATA");
					System.out.println("3.INFORMACION HAMBURGUESA");
					System.out.println("4.BUSCAR INGREDIENTES");
					System.out.println("5.DISMINUIR STOCK");
					System.out.println("6.HAMBURGUESAS POR PERSONA");
					System.out.println("7.SALIR");
					
					//con esta linea se lee y se guarda la eleccion del usuario
					selector= leer.nextInt();
					
					//metodo switch con el que examinar cada caso del menu
					switch(selector){
					
					case 1:
						/*  
						 Opción 1: Será necesario solicitar el nombre de la hamburguesa y las unidades a comer 
					     por pantalla al usuario y se calculará y visualizará el importe del pedido.
						 */
						
						//variables para este caso
						String palabra;
						int unidades;
						boolean existe= false;
						String burguer;
						double precio= 0;
						double resultado= 0;
						int stock= 0;
						
						//mostramos por pantalla un mensaje y se guarda en "palabra" la eleccion del usuario
						System.out.println("Introduce que hamburguesa quieres comer");
						palabra= leer.next();
						
						//metodo for para recorrer el Array de aNombre
						for(int i=0; i < aNombre.length; i++) {
							
							//metodo if que compara lo introducido por el usuario con lo que hay en la posicion "i" del Array "aNombre"
							if(palabra.equalsIgnoreCase(aNombre[i])) {
								
								existe= true;
								
								precio= aPrecio[i];
								
								stock= aStock[i];
								
							}
							
						}//fin del for
						
						//metodo if que valida la existencia de lo introducido por el usuario
						if(existe) {
							
							//se muestra por pantalla un mensaje y se recoge lo que introduce el usuario
							System.out.println("Introduce cuantas hamburguesas quieres");
							unidades= leer.nextInt();
							
							//metodo if que valida si hay suficiente stock de la eleccion del usuario
							if(unidades <= stock) {
								
								resultado= unidades * precio;
							
								System.out.println("El importe total del pedido es: " + resultado + " Euros");
							}else {
								System.out.println("no tenemos suficientes hamburguesas de tu eleccion SOS!!");
							}
							
							
						}else {
							System.out.println("esa hamburguesa no existe!");
						}
						
						break;// break del caso 1
						
					case 2:
						/*
						 Opción 2: Será necesario visualizar el nombre y el importe de la hamburguesa más barata.
						 */
						
						//variables de este caso
						double minimo= Integer.MAX_VALUE;
						burguer="";
						
						
						//metodo for que recorre todo el Array de aPrecio
						for(int i=0; i < aPrecio.length; i++) {
							
							//metodo if que compara el precio de la posicion "i" del Array "aPrecio"
							if(aPrecio[i] < minimo) {
								
								//la variable "minimo" guarda el nuevo valor minimo
								minimo= aPrecio[i];
								
								//se guarda en "burguer" lo que hay en la posicion "i" del Array "aNombre"
								burguer= aNombre[i];
							}
						}
						
						//mensaje final que se muestra por pantalla
						System.out.println("La hamburguesa mas barata es: " + burguer + "\n" + "y cuesta: " + minimo);
						break; //break del caso 2
						
					case 3:
						/*
						 Opción 3: Será necesario solicitar el nombre de la hamburguesa por pantalla al usuario y se mostrarán todos 
						 sus ingredientes y el stock disponible.
						 */
						
						//variables de este caso
						existe= false; //esta variable ya esta declarada en el caso 1 y aqui solo se actualiza el valor para este caso
						stock= 0; //la variable "stock" ya esta declarada en el caso 1 y aqui solo se actualiza el valor para este caso
						String ingredientes= "";
						
						//se muestra el siguiente mensaje por pantalla y se recoge lo que introduce el usuario
						System.out.println("Introduce la hamburguesa que quieres");
						palabra= leer.next();  //la variable "palabra" ya esta declarada en el caso 1
						
						//metodo for que recorre el Array de "aIngredientes[]"
						for(int i=0; i < aIngredientes.length; i++) {
							
							//metodo if que valida si "palabra" es igual a la posicion "i" del Array "aNombre[]"
							if(palabra.equalsIgnoreCase(aNombre[i])) {
								
								 existe= true;
								 
								 ingredientes= aIngredientes[i];
								 
								 stock= aStock[i];  
							}else {
								System.out.println("Esa hamburguesa no existe!");
							}
						}
						
						if(existe) {
							System.out.println("Los ingredientes de esa hamburguesa son: " + ingredientes + "\n" + "puedes pedir como maximo: " + stock + " de esa hamburguesa");
						}
						
					case 4:
						/*
						 Opción 4: Será necesario solicitar el nombre del ingrediente por pantalla al usuario y se visualizará el texto 
						"SI, hay hamburguesas con dicho ingrediente y son las siguientes:" + el nombre de las hamburguesas que tengan
						dicho ingrediente entre sus ingredientes. Es necesario hacer uso de una variable BOOLEAN. En caso contrario 
						se visualizará: "NO, no hay hamburguesas con dicho ingrediente".
						*/
						
						//variables para este caso
						
						String palabraUsuario;
						String[] partes;
						ingredientes= ""; //variable declarada en el caso...
						burguer= ""; // variable declarada en el caso...
						existe= false; // variable declarada en el caso 1
						String pedido= "";
						
						System.out.println("Introduce el ingrediente que quieres");
						palabraUsuario= leer.next();
						
						for(int i=0; i < aIngredientes.length; i++) {
							
							if(aIngredientes[i].contains(palabraUsuario)) {
								
								existe= true;
								
								burguer= aNombre[i];
								
								pedido= pedido.concat(burguer + ", ");
							}
							
						}
						if(existe) {
							System.out.println(pedido);
						}else {
							System.out.println("ese ingrediente no existe");
						}
						
					}//fin del switch
					
				}while(selector > 0 && selector < 8);  //fin del do while
				
				
				leer.close();

	}//fin del main

}//final
