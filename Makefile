JC = javac

ac: all clean

all: compile run 

compile:
	$(JC) Main.java
	
run:
	java Main

clean:
	rm -rf *.class