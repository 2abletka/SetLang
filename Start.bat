javac -sourcepath ./src -d bin src/com/compiler/Compiler.java 
java -classpath ./bin com.compiler.Compiler %1
javac Main.java
java Main