import java.io.*;

public class Main {

    public static void main(String[] args) {

        File dir;
        String[] fileList;
        StringBuilder output = new StringBuilder();


        if (args.length > 0) {
            dir = new File(args[0]);
            if (dir.exists() && dir.isDirectory()) {
                output.append("\nAbsolute path: ").append(dir.getAbsolutePath());
                output.append("\nRelative path: ").append(dir.getPath());
                output.append("\nName: ").append(dir.getName());
                output.append("\nContent: ");
                output.append("\n----------");
                fileList = dir.list();

                if (fileList != null) {
                    for (String s : fileList) {
                        output.append("\n");
                        output.append(s);
                    }
                }
            } else {
                output = new StringBuilder("Directory doesn't exist or it's not a directory!");
            }
        } else {
            output = new StringBuilder("Us: ListDir ruta_dir");
        }
        System.out.println(output);
    }
}