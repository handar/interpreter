package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopLessThanEquals extends BopCode {
    
    @Override
    public void execute(VirtualMachine vm) {
        int op2 = vm.popRunStack();
        int op1 = vm.popRunStack();
        int isLessThanOrEqual = 0;
        
        if (op1 <= op2)
            isLessThanOrEqual = 1;
        
        vm.pushRunStack(isLessThanOrEqual);
    }
}