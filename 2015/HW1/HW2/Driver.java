
public class Driver {

	public static void main(String[] args) {
		
		JarType jar1 = new JarType();
		JarType jar2 = new JarType();
		
		jar1.add(10);
		jar2.add(20);
		
		System.out.println("Jar1 contains " + jar1.quantity() + " units");
		System.out.println("Jar1 contains " + jar2.quantity() + " units");
        
		jar1.emptyItOut();
		System.out.println("Jar1 contains " + jar1.quantity() + " unit");
		
		JarType jar3 = new JarType(25);  // Prefill the jar
		LabeledJar l1 = new LabeledJar();
		l1.add( 30 );
		l1.displayLabel();
		LabeledJar l2 = new LabeledJar( 50 );
		LabeledJar l3 = new LabeledJar( "Pills" );
		l3.displayLabel();
		l3.setLabel ( "Nails" );
		l3.displayLabel();
		LabeledJar l4 = new LabeledJar( 20, "Pickles" );
		System.out.println( l4.quantity() );
		l4.displayLabel();
	}

}
