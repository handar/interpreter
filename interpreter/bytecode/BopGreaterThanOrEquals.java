package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopGreaterThanOrEquals extends BopCode {
    
    @Override
    public void execute(VirtualMachine vm) {
        int op2 = vm.popRunStack();
        int op1 = vm.popRunStack();
        int isGreaterThanOrEqual = 0;
        
        if (op1 >= op2)
            isGreaterThanOrEqual = 1;
        
        vm.pushRunStack(isGreaterThanOrEqual);
    }
}