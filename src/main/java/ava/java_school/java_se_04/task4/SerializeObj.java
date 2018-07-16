package ava.java_school.java_se_04.task4;

import java.io.*;

public class SerializeObj {
    public static void writeObj(Object obj, String file){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object readObjFromFile(String file){
        Object obj = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            obj = in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
