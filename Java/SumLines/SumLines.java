import java.util.*;
import java.io.File;

/** This class illustrates exception handling. It reads lines
  from a file and sums the numbers on those lines. It handles
  two types of exceptions:
  1) FileNotFoundException: If the file entered on the command
  line does not exist, then a catch statement in main prompts
  the user for another file name. If this filename does not
  work, the program throws the FileNotFoundException out of
  main and terminates.
  2) BadNumberException: This exception is user-defined and
  is thrown when a non-positive integer is read. It is handled
  by printing the bad number and an error message.
 **/

class SumLines {
	public static void main(String args[]) throws java.io.FileNotFoundException {
		SumLines sum = new SumLines();
		int flag = 0;
		String filename = args[0]; 
		while(flag == 0)                //added loop
		{
			try {
				sum.execute(filename);
				flag = 1;
			}
			catch (java.io.FileNotFoundException e) {
				System.out.printf("file %s not found%n", filename);
				System.out.printf("please enter a new file name: ");
				Scanner input = new Scanner(System.in);
				filename = input.next();  //change filename
			}
		}
	}

	public void execute(String filename) throws java.io.FileNotFoundException {
		Scanner input = new Scanner(new File(filename));
		while (input.hasNextLine()) {
			Scanner line = new Scanner(input.nextLine());
			int sum = 0;
			int nextNum = 0;
			while (line.hasNext()) {
				try {
					nextNum = line.nextInt();
				}
				catch(InputMismatchException ime) //catch for input
				{
					line.next();
					continue;
				}

				try {
					if (nextNum <= 0) throw new BadNumberException(nextNum);
					sum += nextNum;
				}
				catch(BadNumberException e) {
					System.out.println(e);
				}
			}
			System.out.println("sum = " + sum);
			line.close();
		}
	}
}
