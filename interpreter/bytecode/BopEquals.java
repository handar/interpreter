package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopEquals extends BopCode {
    
    @Override
    public void execute(VirtualMachine vm) {
        int op2 = vm.popRunStack();
        int op1 = vm.popRunStack();
        
        int isEqual = 0;
        
        if (op2 == op1)
            isEqual = 1;
        
        vm.pushRunStack(isEqual);
    }
}