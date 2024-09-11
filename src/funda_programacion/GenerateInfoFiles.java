import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Clase GenerateInfoFiles
 * Esta clase se encarga de generar archivos de prueba para el proyecto de ventas. 
 * Genera archivos planos con información de vendedores, productos y ventas.
 */
public class GenerateInfoFiles {

    /**
     * Método para crear un archivo con información de vendedores.
     * Cada línea contiene el tipo de documento, número de documento, nombre y apellidos del vendedor.
     * 
     * @param salesmanCount El número de vendedores que se desea generar en el archivo.
     */
    public static void createSalesManInfoFile(int salesmanCount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("salesmen.txt"))) {
            for (int i = 0; i < salesmanCount; i++) {
                String documentType = "CC"; // Tipo de documento por defecto (Cédula de Ciudadanía)
                long documentNumber = 1000000 + new Random().nextInt(9000000); // Número de documento aleatorio
                String firstName = "Name" + i; // Nombre aleatorio basado en el índice
                String lastName = "LastName" + i; // Apellido aleatorio basado en el índice

                // Escribimos la información del vendedor en el archivo
                writer.write(documentType + ";" + documentNumber + ";" + firstName + ";" + lastName);
                writer.newLine(); // Saltamos a la siguiente línea para el próximo vendedor
            }
            System.out.println("Archivo de vendedores generado correctamente.");
        } catch (IOException e) {
            e.printStackTrace(); // Muestra un error en caso de que la escritura del archivo falle
        }
    }

    /**
     * Método para crear un archivo con información de productos.
     * Cada línea contiene el ID del producto, el nombre del producto y su precio.
     * 
     * @param productsCount El número de productos que se desea generar en el archivo.
     */
    public static void createProductsFile(int productsCount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt"))) {
            for (int i = 0; i < productsCount; i++) {
                int productId = i + 1; // ID del producto (números consecutivos a partir de 1)
                String productName = "Producto" + productId; // Nombre del producto basado en su ID
                double productPrice = Math.round((10 + new Random().nextDouble() * 90) * 100.0) / 100.0; // Precio aleatorio entre 10 y 100

                // Escribimos la información del producto en el archivo
                writer.write(productId + ";" + productName + ";" + productPrice);
                writer.newLine(); // Saltamos a la siguiente línea para el próximo producto
            }
            System.out.println("Archivo de productos generado correctamente.");
        } catch (IOException e) {
            e.printStackTrace(); // Muestra un error en caso de que la escritura del archivo falle
        }
    }

    /**
     * Método para crear un archivo con las ventas de un vendedor.
     * Cada línea contiene el ID del producto y la cantidad vendida.
     * 
     * @param randomSalesCount La cantidad de ventas aleatorias que se desea generar para el vendedor.
     * @param salesmanName El nombre del vendedor.
     * @param documentId El número de documento del vendedor.
     */
    public static void createSalesMenFile(int randomSalesCount, String salesmanName, long documentId) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(salesmanName + "_sales.txt"))) {
            for (int i = 0; i < randomSalesCount; i++) {
                int productId = 1 + new Random().nextInt(10); // ID de producto aleatorio entre 1 y 10
                int quantitySold = 1 + new Random().nextInt(100); // Cantidad vendida aleatoria entre 1 y 100

                // Escribimos la información de la venta en el archivo
                writer.write(productId + ";" + quantitySold);
                writer.newLine(); // Saltamos a la siguiente línea para la próxima venta
            }
            System.out.println("Archivo de ventas generado correctamente para " + salesmanName);
        } catch (IOException e) {
            e.printStackTrace(); // Muestra un error en caso de que la escritura del archivo falle
        }
    }

    /**
     * Método principal que ejecuta los métodos de generación de archivos.
     * Aquí se crean archivos de prueba con información de vendedores, productos y ventas.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        // Genera un archivo con información de 10 vendedores
        createSalesManInfoFile(10);
        
        // Genera un archivo con información de 5 productos
        createProductsFile(5);
        
        // Genera un archivo con 3 ventas para el vendedor "Vendedor1" con un documento de identificación aleatorio
        createSalesMenFile(3, "Vendedor1", 123456789);
    }
}