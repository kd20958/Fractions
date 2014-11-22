/**
 * 
 * @author Kevin
 * 
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FractionDemo {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	
		Fraction frac1 = new Fraction(1,3);
		Fraction frac2 = new Fraction(5,6);
		Fraction frac3 = new Fraction(9,3);
		
		try
		{
			FileOutputStream outFile = new FileOutputStream("SerialF.dat");
			ObjectOutputStream objOutput = new ObjectOutputStream(outFile);
			objOutput.writeObject(frac1);
			objOutput.writeObject(frac2);
			objOutput.writeObject(frac3);
			objOutput.close();
			outFile.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		FileInputStream inFile;
		try {
			inFile = new FileInputStream("SerialF.dat");
			ObjectInputStream objInput = new ObjectInputStream(inFile);
			Object obj = objInput.readObject();
			objInput.close();
			inFile.close();
			System.out.println((Fraction)frac1);
			System.out.println((Fraction)frac2);
			System.out.println((Fraction)frac3);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("No File Found!");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}