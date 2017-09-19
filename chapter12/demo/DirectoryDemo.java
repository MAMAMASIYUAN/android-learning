import java.io.File;

public class DirectoryDemo {
    public static void main(String args[]) {
      //CreateFolder();
       PrintFolder();
      // deleteFolder();
    }

    public static void CreateFolder() {
        String dirname = "newFolder";
        File d = new File(dirname);
        // 现在创建目录
        d.mkdirs();
    }

    public static void PrintFolder() {
        String dirname = "../demo";
        File f1 = new File(dirname);
        if (f1.isDirectory()) {
            System.out.println("目录 " + dirname);
            String s[] = f1.list();
            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " 是一个目录");
                } else {
                    System.out.println(s[i] + " 是一个文件");
                }
            }
        } else {
            System.out.println(dirname + " 不是一个目录");
        }
    }

    public static void deleteFolder() {
        // 这里修改为自己的测试目录
        File folder = new File("newFolder");
        deleteFolder(folder);
    }

    //删除文件及目录
    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f: files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
}