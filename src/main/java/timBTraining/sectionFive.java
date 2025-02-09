package timBTraining;

public class sectionFive {

	
	// Packages are Folders inside your Cabinet
	// Class are Documents inside your Folder
	
	// Nest Packages - a SubFolder inside the Main Folder (helps organize code)
	
	
	// Package = car manufactoring factory               package com.carfactory;  // This is the package (Factory)
	
		// Class =  Blueprint of car model - defines what the car will have - 4 doors, 2 doors etc. and what it can do     public class Car {  // This is the class (Blueprint)
// }
				// Method = Is a car function - what a car can do - start accelerate and brake      public void startEngine() {  // This is a method

					//	Object = the actual car built - can perform actions (Methods) 
									//	Car myCar = new Car();  // This is an object (a real car)
									//	myCar.startEngine();  // Calls a method (starts the car)
	/*
	package com.carfactory;  // 1️⃣ Package (Factory)

	public class Car {  // 2️⃣ Class (Blueprint)
	    
	    // 3️⃣ Methods (Car Functions)
	    public void startEngine() {
	        System.out.println("Engine started");
	    }

	    public void drive() {
	        System.out.println("Car is driving");
	    }

	    public static void main(String[] args) {
	        // 4️⃣ Object (Real Car)
	        Car myCar = new Car();
	        myCar.startEngine();
	        myCar.drive();
	    }
	}
		*/
	
	// KEYWORDS       - double, float, protected, package, private , void, while, super const, class, char, 
	// CONTEXTUAL KEYWORDS - 

	// =========================
	// JAVA BASICS - BEGINNER GUIDE
	// =========================


	    // This is the main method, which acts as the ENTRY POINT of the Java program.
	    public static void main(String[] args) {       
	        // 'public' - This makes the method accessible from anywhere.
	        // 'static' - This allows the method to be run without creating an object of the class.
	        // 'void' - This means the method does NOT return any value.
	        // 'main' - The method name recognized by Java as the starting point of execution.
	        // 'String[] args' - Array of Strings to hold command-line arguments (optional input from the user).

	        // =========================
	        // VARIABLES, DATA TYPES, AND EXPRESSIONS
	        // =========================

	        double miles = (100 * 1.609344);  // Expression: 100 * 1.609344 is evaluated first.
	        // 'double' - A data type for storing decimal numbers.
	        // 'miles' - A variable that stores the result of the expression.

	        double miles2 = 100 * 1.609344; // Another way to write the same expression.

	        // Print output to the console
	        System.out.println(miles);   // Outputs the calculated value of 'miles'
	        System.out.println(miles2);  // Outputs the calculated value of 'miles2'

	        // =========================
	        // IF STATEMENTS AND CONDITIONAL LOGIC
	        // =========================

	        int highScore = 26;  // Integer variable

	        // If 'highScore' is greater than 25, execute the code inside the curly braces.
	        if (highScore > 25) {
	            highScore = 1000 + highScore;  // Update highScore by adding 1000.
	            System.out.println("highScore = " + highScore);
	        }

	        // =========================
	        // LOGICAL OPERATORS: && (AND), || (OR)
	        // =========================

	        int health = 100;  // Another integer variable.

	        // The IF condition checks two things:
	        // (health < 25) - Is health less than 25? ❌ (No, health is 100)
	        // (highScore > 1000) - Is highScore greater than 1000? ✅ (Yes, highScore is now 1026)
	        // Since the AND (&&) operator is used, BOTH conditions must be true to run the code.
	        if ((health < 25) && (highScore > 1000)) {
	            highScore = highScore - 1000; // Subtract 1000 from highScore.
	            System.out.println(highScore);
	        }

	        // =========================
	        // STRING CONCATENATION (+ operator)
	        // =========================

	        // The '+' operator combines multiple strings into one.
	        System.out.println("This is " +
	                " another " +
	                " still more. ");

	        // =========================
	        // BOOLEAN VARIABLES AND IF-ELSE STATEMENTS
	        // =========================

	        boolean gameOver = true; // Boolean variable (true or false)
	        int score = 5000;
	        int levelCompleted = 5;
	        int bonus = 100;

	        
	        //  CALLS THE calculateScore METHOD  ---   2 different ways, depends on application and other criteria... 
	        
	        calculateScore( true, 800, 7, 200);           //  you type in the changed values of the variables and the method 
	        calculateScore( true, 1000, 2000, 3000);       // in this case the method adds the finalscore2 + levelcompleted + bonus
	        
	         boolean gameOver2 = true;
	         int score2 = 1234;
	         int levelCompleted2 = 2345;
	         int bonus2 = 3456;
	        
	         calculateScore( gameOver2, score2, levelCompleted2, bonus2); // in this case you can identify the values of the variables and then pass them to the parameters)
	        
	         
	         
	         // Method of calculateMyAge
	         
	         int myAge = calculateMyAge (1980);
	         System.out.println("My age is : " + myAge);
	         
	         
	         
	        // IF STATEMENT:
	        if (score == 5000) { // If 'score' is exactly 5000, print the message.
	            System.out.println("Your score is 5000");
	        }

	        // IF-ELSE STATEMENT:
	        if (score < 5000) { // If score is less than 5000, print the first message.
	            System.out.println("Your score is less than 5000");
	        } else { // If score is NOT less than 5000, print this instead.
	            System.out.println("got here");
	        }

	        // =========================
	        // IF-ELSE IF-ELSE (MULTI-CONDITION STATEMENTS)
	        // =========================

	        if (score < 5000 && score > 1000) { // Score is between 1001 and 4999
	            System.out.println("Score is less than 5000 but greater than 1000");
	        } else if (score < 1000) { // Score is below 1000
	            System.out.println("score is less than 1000");
	        } else { // Any other case
	            System.out.println("we got here");
	        }

	        // =========================
	        // ARITHMETIC OPERATORS: += (SHORTHAND ADDITION)
	        // =========================

	        // CHALLENGE: Using += operator

	        int finalScore = score; // Assign score (5000) to finalScore

	        // If gameOver is true, update finalScore:
	        if (gameOver) {  
	            finalScore += (levelCompleted * bonus); 
	            // Equivalent to: finalScore = finalScore + (levelCompleted * bonus);
	            // (5 * 100) = 500
	            // finalScore = 5000 + 500 = 5500

	            System.out.println("the game is over");
	        } else if (finalScore < 5000) {  
	            System.out.println("the game is over because less than 5000");
	        } else {
	            System.out.println("You have won the game");
	        }

	        // =========================
	        // FINAL EXAMPLE WITH BOOLEAN CHECK
	        // =========================

	        int score1 = 10000;
	        int levelCompleted1 = 8;
	        int bonus1 = 200;
	        boolean gameOver1 = true;

	        int finalScore1 = score1; // Store initial score

	        // Another if statement with += operator
	        if (gameOver1) { // Same as 'if (gameOver1 == true)' (but shorter)
	            finalScore1 += (levelCompleted1 + bonus1); // finalScore1 = finalScore1 + (8 + 200)
	            System.out.println("Score is = " + finalScore1);
	        }
	        
	        
	        // Methods - Sections 46
	        
	        // way of reducting code duplication
	        
	       //  method main  with method body  (above)  
	        
	        //  public static void methodName () {
	        

	    }
	    
	    public static void calculateScore(boolean gameOver2, int score2, int levelCompleted2, int bonus2) {
			// TODO Auto-generated method stub
	    		//  anything in here will be method body and part of calculateScore method
	    	// to execute a method, we write a statement in code, which we say is calling or involking the method
	    	
	    	// THE VARIABLES (PARAMETERS) ARE NOT DEFINED HERE BUT RATHER AT LINE 119   ,  YOU PUT VALUES OF THE VARIABLE THERE.
	    	//  GAMEOVER, SCORE2 LEVELCOMPELETE2, BONUS 2 ALL DEFINED AT LINE 119   IN THE PARAMETERS
	    	// MUST BE IN THE EXACT ORDER AS THIS METHOD  GAMEOVER SCORE LEVLECOMPLETED AND BONUS
	    	
		        int finalScore2 = score2; // Store initial score

		        // Another if statement with += operator
		        if (gameOver2) { // Same as 'if (gameOver1 == true)' (but shorter)
		            finalScore2 += (levelCompleted2 + bonus2); // finalScore1 = finalScore1 + (8 + 200)
		            System.out.println("calculateScore method is = " + finalScore2);
		            
		            //  Method parameters   
		            // public static void methodName(p1type p1, p2type p2, {more} ) {
		        }
		            
		            
		   }
	    	
		        // METHOD STRUCTURE WITH PARAMETSR AND RETURN TYPE
		        		// return statement - returns a value back from the method
		
		        
	    	public static int calculateMyAge(int dateOfBirth) {
	    		return (2025 - dateOfBirth);
	    		
	    
	    		
	    		
	    		}
	    
	    	
		}
	    
	

		    
		 	
	 

