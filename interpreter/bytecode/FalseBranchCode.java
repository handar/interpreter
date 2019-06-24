package interpreter.bytecode;

import interpreter.VirtualMachine;

public class FalseBranchCode extends JumpCode {

    @Override
    public void execute(VirtualMachine vm) {
        int value = vm.popRunStack();

        if (value == 0) {
            vm.setpc(jumpIndex - 1);
        }
    }

    @Override
    public String toString() {
        String returnString = "FALSEBRANCH " + this.label;
        return returnString;
    }
}
