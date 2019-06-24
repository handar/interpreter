package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LoadCode extends ByteCode {
    
    private int n;
    private String id;
    
    @Override
    public void init(String arg1, String arg2) {
        this.n = Integer.parseInt(arg1);
        this.id = arg2;
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        vm.loadFromOffset(this.n);
    }
    
    @Override
    public String toString() {              
        String returnString = "LOAD " + this.n + " " + this.id;
       return returnString;
    }
}