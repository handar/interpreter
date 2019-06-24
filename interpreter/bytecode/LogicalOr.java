package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LogicalOr extends BopCode {
    
    @Override
    public void execute(VirtualMachine vm) {
        int op2 = vm.popRunStack();
        int op1 = vm.popRunStack();
        
        boolean op2b = (op2 >= 1);
        boolean op1b = (op1 >= 1);
        
        boolean result = op2b | op1b;
        int resultInt;
        if (result == true) {
            resultInt = 1;
        } else {
            resultInt = 0;
        }
        
        vm.pushRunStack(resultInt);
    }
}