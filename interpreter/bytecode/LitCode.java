package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LitCode extends ByteCode {
    
    private int n;
    private String var;
    
    @Override
    public void init(String arg1, String arg2) {
        this.n = Integer.parseInt(arg1);
        this.var = arg2;
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        vm.pushRunStack(this.n);
    }
    
    @Override
    public String toString() {
     
        
        String returnString = "LIT " + this.n + " " + this.var;
       return returnString;
    }
}