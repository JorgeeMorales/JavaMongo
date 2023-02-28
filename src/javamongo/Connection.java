package javamongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorgemorales
 */
public class Connection {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    public Connection(){
        try {
          Mongo mongo= new Mongo("localhost",27017);
          BaseDatos = mongo.getDB("Act6");
          coleccion = BaseDatos.getCollection("Actividades501");
          System.out.println("Conexion exitosa!");
        } catch (UnknownError ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    //METODOS CRUD
    
    //INSERTAR
    
    public boolean insertar(String accion){
        document.put("accion", accion);
        coleccion.insert(document);
        
        return true;
    }
    
    //MOSTRAR
    public void mostrar(){
        DBCursor cursor = coleccion.find();
        while (cursor.hasNext()) {            
            System.out.println(cursor.next());
        }
    }
    
    //ACTUALIZAR
    public boolean actualizar(String accionVieja, String accionNueva){
        document.put("accion", accionVieja);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("accion", accionNueva);
        coleccion.findAndModify(document, documentoNuevo);
        return true;
        
    }
    
    //ELIMINAR
    
    public boolean eliminar(String accion){
        document.put("accion", accion);
        coleccion.remove(document);
        return true;
    }
    
}
