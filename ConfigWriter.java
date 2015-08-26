import java.io.*;
public class ConfigWriter{
String newline=System.getProperty("line Separator");
ConfigWriter(){try{File file=new File("program.properties");
FileOutputStream fileStream=new FileOutputStream(file);
write(fileStream,"username=max\n");
write(fileStream,"score=12550\n");
write(fileStream,"level=5\n");}
catch(IOException ioe){
System.out.println("couldnt write file");}}
void write(FileOutputStream stream,String output)
throws IOException{
output=output+newline;
byte[] data=output.getBytes();
stream.write(data,0,data.length);}
public static void main(String[] arguments){
ConfigWriter cw=new ConfigWriter();}}