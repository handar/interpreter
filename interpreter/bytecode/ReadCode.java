package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    
    @Override
    public void init(String arg1, String arg2) {}
    
    @Override
    public void execute(VirtualMachine vm) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input integer: ");
        int readInt = input.nextInt();
        input.nextLine(); 
        
        vm.pushRunStack(readInt);
    }
    
    @Override
    public String toString() {
        return "READ";
    }
}