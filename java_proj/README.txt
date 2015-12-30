For our project we separated the objects, logic and I/O classes. Our logic was done in CommandTower.java, our airplane and airport objects are created
in its respective classes,` FlightControl.java processes the input arguments, coupled with the input provided in the command line, inputReader sends
the necessary information and creates the airplane and airport objects. CommandTower.java uses information provided by airplane.java and airport.java,
to do all necessary calculations to figure out if landing is possible and how much fuel is remaining. This information is then sent back to inputReader
which creates and saves file containing all the correct information.
We also ceated our own JUNIT tests to test our program. We used various scenarious to account for all different situations that are possible.

To compile:
> javac src/objects/*.java
> javac src/logic/*.java
> javac src/io/*.java

To run:
> java FlightControl -f input.txt -o output.txt

