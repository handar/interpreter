package interpreter.bytecode;

import interpreter.VirtualMachine;

public class GotoCode extends JumpCode {

    @Override
    public void execute(VirtualMachine vm) {
        vm.setpc(jumpIndex - 1);
    }

    @Override
    public String toString() {
        String returnString = "GOTO " + this.label;
        return returnString;
    }
}
