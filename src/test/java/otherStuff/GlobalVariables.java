package otherStuff;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalVariables {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("resources/data.properties");
        properties.load(file);                  // reading mode
        System.out.println(properties.getProperty("name"));
        // change property
        properties.setProperty("name","Timur Celik");
        System.out.println(properties.getProperty("name"));
        FileOutputStream fo = new FileOutputStream("resources/data.properties");
        properties.store(fo,null);      // writing mode
    }
}
