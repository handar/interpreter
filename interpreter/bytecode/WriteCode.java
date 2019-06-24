package interpreter.bytecode;

import interpreter.VirtualMachine;

public class WriteCode extends ByteCode { 
    @Override
    public void init(String arg1, String arg2) {}
    
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peekRunStack());
    }
    
    @Override
    public String toString() {
        return "WRITE";
    }
}