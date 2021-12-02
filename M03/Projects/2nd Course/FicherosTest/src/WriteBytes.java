
import java.io.*;

public class WriteBytes {
    public static void main(String[] args) {
        String[] list = {"a","e","i","o","u"};
        if (args.length == 1) {
            File file = new File(args[0]);
            /*try {
                //BufferedWriter fw = new BufferedWriter(new FileReader(file));
                for (String b : list) {
                    //fw.write(b);
                    //fw.flush();
                }
                //fw.close();
            } catch (IOException e) {
                System.out.println("Input or output problem related to this exception: ");
                e.printStackTrace();
            }*/
        } else {
            System.out.println("Usage: WriteBytes filename");
        }
    }
}
