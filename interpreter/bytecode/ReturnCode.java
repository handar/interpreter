package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {

    private String returnFuncName; 
    private int returnVal; 

    @Override
    public void init(String arg1, String arg2) {
        this.returnFuncName = arg1; 
    }

    @Override
    public void execute(VirtualMachine vm) {
        this.returnVal = vm.peekRunStack();
        vm.popAllCurrentFrame();
        vm.popReturnAddrs();
    }

    @Override
    public String toString() {
        String returnString = "RETURN " + this.returnFuncName + "\texit: " + this.returnFuncName;
        if (this.returnVal >= 0) {
            returnString = "RETURN " + this.returnFuncName + "\texit: " + this.returnFuncName + this.returnVal;
        }
        return returnString;
    }
}
