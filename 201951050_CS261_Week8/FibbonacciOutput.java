import java.io.*;
public class FibbonacciOutput {
    public static void main(String args[])
    {
        try{
            File myfile = new File(args[0]);
            FileReader fr = new FileReader(myfile);
            BufferedReader br = new BufferedReader(fr);
            String data;
            while((data = br.readLine()) != null)
            {
                System.out.println(data.toString());

            }
            fr.close();


        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
    
    
}
