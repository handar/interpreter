package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopLessThan extends BopCode {
    
    @Override
    public void execute(VirtualMachine vm) {
        int op2 = vm.popRunStack();
        int op1 = vm.popRunStack();
        int isLessThan = 0;
        
        if (op1 < op2)
            isLessThan = 1;
        
        vm.pushRunStack(isLessThan);
    }
}