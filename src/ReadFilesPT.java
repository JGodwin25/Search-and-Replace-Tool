class ThreadClass extends Thread{
public void run() {
	System.out.println ("Thread " + 
            Thread.currentThread().getId() + 
            " is running");
}
}


public class ReadFilesPT {
	
public static void main(String args[]) {

ThreadClass TC=new ThreadClass();
TC.start();
ThreadClass TC2=new ThreadClass();
TC2.start();	
}

}
