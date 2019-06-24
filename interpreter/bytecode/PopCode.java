package interpreter.bytecode;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode {

    private int n;

    @Override
    public void init(String arg1, String arg2) {
        this.n = Integer.parseInt(arg1);
    }

    @Override
    public void execute(VirtualMachine vm) {
        while (this.n > 0) {
            vm.popRunStack();
            n--;
        }
    }

    @Override
    public String toString() {
        String returnString = "POP " + this.n;
        return returnString;
    }
}
