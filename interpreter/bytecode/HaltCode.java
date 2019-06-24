package interpreter.bytecode;

import interpreter.VirtualMachine;

public class HaltCode extends ByteCode {
    
    @Override
    public void init(String arg1, String arg2) {}
    
    @Override
    public void execute(VirtualMachine vm) {
        vm.popAllRunStack(); 
        vm.dumpOff(); 
    }
    
    @Override
    public String toString() {
        return "HALT";
    }
}