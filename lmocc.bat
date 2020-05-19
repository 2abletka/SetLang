javac -sourcepath ./src -d bin src/com/compiler/Compiler.java %1 

java -classpath ./bin com.compiler.Compiler

javac Main.java
 
java Main