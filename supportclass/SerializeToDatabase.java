
package com.supportclass;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import com.Database.DAO;

 
public class SerializeToDatabase
{
  
  public static Connection connection = null;
  public static DAO database = DAO.getInstance();
  
  private static final String SQL_SERIALIZE_OBJECT = "insert into m_key values(?,?,?)";
  private static final String SQL_DESERIALIZE_OBJECT = "SELECT public_key FROM m_key";
  private static final String SQL_DESERIALIZE_OBJECT1 = "SELECT master_s_key FROM m_key";
  private static final String SQL_DESERIALIZE_OBJECT2 = "SELECT des_secrete_key FROM m_key";
  
 
  public static boolean serializeJavaObjectToDB(Object pubKeyObj,Object prvKeyObj,String userid) throws SQLException 
  {
     
	connection = database.connector();
    
	PreparedStatement pstmt = connection.prepareStatement(SQL_SERIALIZE_OBJECT);
 
    // just setting the class name
   
	pstmt.setObject(1,userid);
    pstmt.setObject(2,pubKeyObj);
    pstmt.setObject(3,prvKeyObj);
    pstmt.executeUpdate();
    
  
  
    pstmt.close();
   
	return true;
    
  }
 
  /**
   * To de-serialize a java object from database
   *
   * @throws SQLException
   * @throws IOException
   * @throws ClassNotFoundException
   */
  public static Object getPublicKey(String userid) throws SQLException, IOException,ClassNotFoundException 
  {
	DAO dao = DAO.getInstance();
	connection = dao.connector();
	Statement pstmt = connection.createStatement();
    ResultSet rs = pstmt.executeQuery("SELECT public_key FROM m_key where key_id = '"+userid+"'");
    rs.next();
 
    // Object object = rs.getObject(1);
 
    byte[] buf = rs.getBytes(1);
    ObjectInputStream objectIn = null;
    if (buf != null)
      objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
    Object deSerializedObject = objectIn.readObject();
    rs.close();
    pstmt.close();
    System.out.println("\n\n ***** De-Serialization Information *****\n");
    System.out.println("Java object de-serialized from database. Object: "+ deSerializedObject + " Classname: "+ deSerializedObject.getClass().getName()+"\n\n");
    return deSerializedObject;
  }
  
  public static Object getPrivateKey(String userid) throws SQLException, IOException,ClassNotFoundException 
  {
    
	connection = database.connector();
	Statement pstmt = connection.createStatement();
    ResultSet rs = pstmt.executeQuery("SELECT master_s_key FROM m_key where key_id = '"+userid+"'");
    rs.next();
 
    // Object object = rs.getObject(1);
 
    byte[] buf = rs.getBytes(1);
    ObjectInputStream objectIn = null;
    if (buf != null)
      objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
 
    Object deSerializedObject = objectIn.readObject();
 
    rs.close();
    pstmt.close();
    //System.out.println("\n\n ***** De-Serialization Information *****\n");
    //System.out.println("Java object de-serialized from database. Object: "+ deSerializedObject + " Classname: "+ deSerializedObject.getClass().getName()+"\n\n");
    return deSerializedObject;
  }
  
  /* Getting DES Secrete Key From DB */
  
  public static Object getDESsecreteKey() throws SQLException, IOException,ClassNotFoundException 
  {
    
	connection = database.connector();
	PreparedStatement pstmt = connection.prepareStatement(SQL_DESERIALIZE_OBJECT2);
    ResultSet rs = pstmt.executeQuery();
    rs.next();
 
    // Object object = rs.getObject(1);
 
    byte[] buf = rs.getBytes(1);
    ObjectInputStream objectIn = null;
    if (buf != null)
      objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
 
    Object deSerializedObject = objectIn.readObject();
 
    rs.close();
    pstmt.close();
    System.out.println("\n\n ***** De-Serialization Information *****\n");
    System.out.println("Java object de-serialized from database. Object: "+ deSerializedObject + " Classname: "+ deSerializedObject.getClass().getName()+"\n\n");
    return deSerializedObject;
  }
 
  /**
   * Serialization and de-serialization of java object from mysql
   *
   * @throws ClassNotFoundException
   * @throws SQLException
   * @throws IOException
 * @throws NoSuchAlgorithmException 
   */
  /* Testing The Algorithm */
  public static void main(String args[]) throws ClassNotFoundException,SQLException, IOException, NoSuchAlgorithmException 
  {
        
		String userName = "kumar";
 
	    // a sample java object to serialize
	   
	    SecretKey key = KeyGenerator.getInstance("DES").generateKey();
	    // serializing java object to mysql database
	  //  serializeJavaObjectToDB(userName, key);
	 
	    // de-serializing java object from mysql database
	    // Key objFromDatabase = (Key) (deSerializeJavaObjectFromDB(connection,userName));
	   // SecretKey objFromDatabase = (SecretKey)(getPublicKey());
	    connection.close();
   }
  
  
      
}
