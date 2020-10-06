import java.io.File;

public class Directory {
    static void recurPr(File[] arr, int index, int LVL) {

        if (index == arr.length)
            return;

        for (int i = 0; i < LVL; i++)
            System.out.print("\t");

        if (arr[index].isFile())
            System.out.println(arr[index].getName());

        else if (arr[index].isDirectory()) {
            System.out.println("[" + arr[index].getName() + "]");

            recurPr(arr[index].listFiles(), 0, LVL + 1);
        }

        recurPr(arr, ++index, LVL);
    }

    public static void main(String[] args) {

        String mDirPATH = args[0];

        File mDIR = new File(mDirPATH);

        if (mDIR.exists() && mDIR.isDirectory()) {
            File arr[] = mDIR.listFiles();
            System.out.println("`````````````````````````````````````````````");
            System.out.println("Files from the DIRECTORY : " + mDIR);
            System.out.println("`````````````````````````````````````````````");
            recurPr(arr, 0, 0);
        } else {
            System.out.println("`````````````````````````````````````````````");
            String data1 = mDirPATH;
            int l = data1.length() - 1;
            String answer = "";
            while (l >= 0) {
                if (data1.charAt(l) == '\\') {
                    break;
                } else {
                    answer = data1.charAt(l) + answer;
                    l--;
                }

               

            }
            System.out.println("Files from the DIRECTORY : " + answer);
            System.out.println("`````````````````````````````````````````````");
        }
    }
}