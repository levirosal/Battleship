# Battleship
Repository of the multiplayer battleship game developed in java.  
The locations of the ships are inserted by reading a txt file in the following format, where "0" is water and "1" is a ship:

    0011100  
    0000000  
    0001000  
    0001000  
    0001000  
    0000000  
    0000111

Where the columns are the numbers and the lines the letters.

    A *  *  *  *  *  *  *
    B *  *  *  *  *  *  *
    C *  *  *  *  *  *  *
    D *  *  *  *  *  *  *
    E *  *  *  *  *  *  *
    F *  *  *  *  *  *  *
    G *  *  *  *  *  *  *
      0  1  2  3  4  5  6

## How to build this .jar locally ?

##### 1. Enter the source directory:

    cd Battleship/src    
##### 2. Run this command to compile the java code:

    javac -d ../class/ com/levi/*.java && javac -d ../class/ com/levi/model/.java
##### 3. Enter the class directory:

    cd ../class    
##### 4. Run this command to create .jar file:

    jar -cvmf manifest.txt Battleship.jar com/ 
    

## How to start the game ?

##### 1. Execute the jar by sending these parameters in any order:
Name of player 1:

    --p1-name=    
File path with ship locations:        
    
    --p1-file=
Name of player 2:

    --p2-name=
File path with ship locations:       
    
    --p2-file=   
Example:
 
    java -jar Battleship.jar --p1-name=Player1Name --p1-file=/home/github/Documents/player1.txt --p2-name=Player2Name --p2-file=/home/github/Documents/player2.txt
    

