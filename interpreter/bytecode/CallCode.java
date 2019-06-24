package interpreter.bytecode;

import interpreter.VirtualMachine;

public class CallCode extends JumpCode {
    
    private int value;
    
    @Override
    public void execute(VirtualMachine vm) {
        this.value = vm.peekRunStack();
        vm.pushReturnAddrs();
        vm.setpc(jumpIndex - 1);
    }
    
    @Override
    public String toString() {     
       String returnString = "CALL " + this.label + "\t" + this.label + "(" + this.value + ")";
       return returnString;
    }
}