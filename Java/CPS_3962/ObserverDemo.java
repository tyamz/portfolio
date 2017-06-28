package CPS_3962;

import java.util.Scanner;

abstract class Observer { 
protected Subject subj; 
  public abstract void update();
}

class HexObserver extends Observer { 
  public HexObserver( Subject s ) { 
    subj = s; 
    subj.attach( this ); 
  }

  public void update() { 
  System.out.print( " " + Integer.toHexString( subj.getState() ) ); 
  } 
} // Observers "pull" information 

class OctObserver extends Observer { 
  public OctObserver( Subject s ) {
    subj = s;
    subj.attach( this );
  } 
  public void update() {
    System.out.print( " " + Integer.toOctalString( subj.getState() ) );
  } 
} // Observers "pull" information 

class BinObserver extends Observer { 
  public BinObserver( Subject s ) { 
    subj = s; 
    subj.attach( this ); } // Observers register themselves 
    public void update() { 
    System.out.print( " " + Integer.toBinaryString( subj.getState() ) ); 
  } 
}

class Subject { 
  private Observer[] observers = new Observer[9];
  private int totalObs = 0;
  private int state;
  public void attach( Observer o ) {
    observers[totalObs++] = o;
  }

  public int getState() {
    return state;
  }
  
  public void setState( int in ) {
	if(in < 1000) {
	    state = in;
	    notify1();
	} else {
		System.out.println("The number you entered is too large.");
	}
  }
  
  private void notify1() {
	  for (int i = 0; i < totalObs; i++) {
		  observers[i].update();
	  }
  }
}

public class ObserverDemo {
  public static void main( String[] args ) {
    Subject sub = new Subject();
    // Client configures the number and type of Observers
    new HexObserver( sub );
    new OctObserver( sub );
    new BinObserver( sub );
    Scanner scan = new Scanner(System.in);
    while (true) {
      System.out.print( "\nEnter a number: " );
      sub.setState( scan.nextInt() );
    }
  }
}
