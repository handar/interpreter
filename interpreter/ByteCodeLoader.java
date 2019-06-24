package interpreter;

import interpreter.bytecode.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ByteCodeLoader extends Object implements interpreter.bytecode.BopCode.GetBop {

    private BufferedReader byteSource;
    private Program program;
    private StringTokenizer tokenizer;
    private final String delim = " \t";

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time. For each
     * line it should: Tokenize string to break it into parts. Grab correct
     * class name for the given ByteCode from CodeTable Create an instance of
     * the ByteCode class name returned from code table. Parse any additional
     * arguments for the given ByteCode and send them to the newly created
     * ByteCode instance via the init function.
     *
     * @return Program, which contains ByteCode class instances read from
     * byteSource
     */
    public Program loadCodes() {
        program = new Program();
        String line;

        try {
            while ((line = this.byteSource.readLine()) != null) {

                String token;
                String codeClass;
                String[] myArgs = {"", ""};
                ByteCode bytecode;

                // tokenize the current string
                this.tokenizer = new StringTokenizer(line, delim);
                token = this.tokenizer.nextToken();
                codeClass = CodeTable.getClassName(token);

                if (codeClass.equals("BopCode")) {
                    token = this.tokenizer.nextToken();
                    bytecode = getBop(token);
                    myArgs[0] = token;
                } else {
                    
                    String name = "interpreter.bytecode." + codeClass;
                    bytecode = (ByteCode) (Class.forName(name).newInstance());

                    //parse through tokens
                    int index = 0;
                    while (this.tokenizer.hasMoreTokens()) {
                        token = this.tokenizer.nextToken();
                        myArgs[index] = token;
                        index++;
                    }
                }
                
                bytecode.init(myArgs[0], myArgs[1]); //put them in an instance of bytecode

                //load bytecode
                this.program.addByteCode(bytecode);

            } //close file!
            this.byteSource.close();

            this.program.resolveAddress(program);

            return this.program;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return program;
    }

}
