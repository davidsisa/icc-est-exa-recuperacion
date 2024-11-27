package Controllers;
import Models.Persona;
import java.util.Arrays;
/**
 * Controlador para manejar la lógica de operaciones sobre arrays de Carross.
 * 
 * 
 * Generar los metdoos necesarions para ordenar un array de personas por edad en
 * orden descendente
 * y para la busqueda binaria de una persona por edad.
 * 
 */
public class PersonaController {
    public Persona[] sortWithSelection(Persona[] array){
        Persona[] copyArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < copyArray.length - 1; i++){
            int indice = i;
            for (int j = i + 1; j < copyArray.length; j++){
                if (copyArray[j].getEdad() > copyArray[indice].getEdad()) {
                    indice = j;
                }
            } 
            Persona pequeno = copyArray[i];
            copyArray[i] = copyArray[indice];
            copyArray[indice] = pequeno;
        }
        return copyArray;
    }
    public Persona[] sortWithInsertionNames(Persona[] array){
        Persona[] copyArray = Arrays.copyOf(array, array.length);
        for (int i = 1; i < copyArray.length; i++) {
            Persona key = copyArray[i];
            int j = i - 1;
            while (j >= 0 && copyArray[j].getNombre().compareTo(key.getNombre()) > 0) {
                copyArray[j + 1] = copyArray[j];
                j = j - 1;
            }
            copyArray[j + 1] = key;
        }
        return copyArray;
    }
    public int searchBinary(Persona[] array, int age){
        int tamanio = array.length;
        int inicio = 0;
        int fin = tamanio - 1;
        while (inicio <= fin) { 
            int mitad = inicio + (fin - inicio)/2;
            if (array[mitad].getEdad() == age) {
                return mitad;
            }
            if (array[mitad].getEdad() < age) {
                fin = mitad - 1;
            }else {
                inicio = mitad + 1;
            }

        } 
        return -1;
    }
    public int searchBinaryName(Persona[] array, String objetivo){
        int tamanio = array.length;
        int inicio = 0;
        int fin = tamanio - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int comparacion = array[medio].getNombre().compareTo(objetivo);

            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {

                inicio = medio + 1;
            } else {

                fin = medio - 1;
            }
        }
        return -1;
    }
    public void printArray(Persona[] array){
        for (Persona vari: array) {
            System.out.println("" + vari);
        }
    }
    
}
