package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode {
    
    private int n;
    
    @Override
    public void init(String arg1, String arg2) {
        this.n = Integer.parseInt(arg1);
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        vm.pushNewFrame(this.n);
    }
    
    @Override
    public String toString() {
       String returnString = "ARGS " + this.n;
       return returnString;
    }
}