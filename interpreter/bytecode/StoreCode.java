package interpreter.bytecode;

import interpreter.VirtualMachine;

public class StoreCode extends ByteCode {

    private int n;
    private String id;

    @Override
    public void init(String arg1, String arg2) {
        this.n = Integer.parseInt(arg1);
        this.id = arg2;
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.storeAtOffset(this.n);
    }

    @Override
    public String toString() {
        String returnString = "STORE " + this.n + " " + this.id + "\t" + id + " = " + this.n;
        return returnString;
    }
}
