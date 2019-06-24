package interpreter.bytecode;

import interpreter.VirtualMachine;

public class DumpCode extends ByteCode {
    private String currDumpCommand;
    private String newDumpCommand;
    
    @Override
    public void init(String arg1, String arg2) {
        this.newDumpCommand = arg1;
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        this.currDumpCommand = vm.getDumpMode();
        if ( !(currDumpCommand.equals(newDumpCommand)) )
            vm.switchDumpMode();
    }
    
}