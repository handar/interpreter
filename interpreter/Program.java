package interpreter;

import interpreter.bytecode.*;

import java.util.ArrayList;

// The Program class stores an ArrayList of ByteCodes. 
public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        this.program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public void addByteCode(ByteCode bytecode) {
        this.program.add(bytecode);
    }

    public void replaceByteCode(ByteCode bytecode, int pc) {
        this.program.set(pc, bytecode);
    }

    public int getSize() {
        return this.program.size();
    }

    public boolean isLabel(ByteCode bytecode) {
        return (LabelCode.class.isInstance(bytecode));
    }

    public boolean jumpBool(ByteCode bytecode) {
        return (JumpCode.class.isInstance(bytecode));
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted
     * into correct addresses so the VirtualMachine knows what to set the
     * Program Counter(PC) HINT: make note what type of data-stucture bytecodes
     * are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddress(Program program) {
        int index = 0;
        int programSize = program.getSize();

        while (index < programSize) {
            ByteCode outByteCode = program.getCode(index);

            // does byteccode have a label? 
            if (jumpBool(outByteCode)) {

                // find that label
                int i = 0;
                String strGetLabel = ((JumpCode) outByteCode).getLabel();

                while (i < programSize) {
                    ByteCode inByteCode = program.getCode(i);

                    if (isLabel(inByteCode)) {
                        String currentLabel = ((JumpCode) inByteCode).getLabel();

                        if (currentLabel.equals(strGetLabel)) {
                            ((JumpCode) outByteCode).setJumpIndex(i);
                            break;
                        }
                    }

                    i++;
                } 

            } 
            index++;
        } 
    }
}
