package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopGreaterThan extends BopCode {
    
    @Override
    public void execute(VirtualMachine vm) {
        int op2 = vm.popRunStack();
        int op1 = vm.popRunStack();
        
        int isGreaterThan = 0;
        
        if (op1 > op2)
            isGreaterThan = 1;
        
        vm.pushRunStack(isGreaterThan);
        
        
    }
}