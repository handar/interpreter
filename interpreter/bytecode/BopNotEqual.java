package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopNotEqual extends BopCode {
    
    @Override
    public void execute(VirtualMachine vm) {
        int op2 = vm.popRunStack();
        int op1 = vm.popRunStack();
        int isNotEqual = 0;
        
        if (op1 != op2)
            isNotEqual = 1;
        
        vm.pushRunStack(isNotEqual);
    }
}