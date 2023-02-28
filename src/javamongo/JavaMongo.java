package javamongo;

/**
 *
 * @author jorgemorales
 * programa que conecte mongo con java
 * fecha: 24/02/2023
 */
public class JavaMongo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conexion = new Connection();
        
        conexion.mostrar();
        //conexion.insertar("Nadar");
        System.out.println("Otro");
        //conexion.mostrar();
        System.out.println("Otro mas");
        //conexion.actualizar("Nadar", "Brincar");
        conexion.eliminar("Brincar");
        
        conexion.mostrar();
        
        
        
    }
    
}
