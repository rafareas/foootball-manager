JC = javac

all: compile run 

compile:
	$(JC) Main.java
	
run:
	java Main

clean:
	rm -rf *.class