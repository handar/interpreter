package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopAdd extends BopCode {
    
    @Override
    public void execute(VirtualMachine vm) {
        int op2 = vm.popRunStack();
        int op1 = vm.popRunStack();
        vm.pushRunStack(op1 + op2);
    }
}