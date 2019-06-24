package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LabelCode extends JumpCode {

    @Override
    public void init(String arg1, String arg2) {
        this.label = arg1;
    }

    @Override
    public void execute(VirtualMachine vm) {
    }

    @Override
    public String toString() {
        String returnString = "LABEL " + this.label;
        return returnString;
    }
}
