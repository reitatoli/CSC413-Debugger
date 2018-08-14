package interpreter;

import java.io.*;
import interpreter.debugger.*;

/**
 * <pre>
 *
 *
 *
 *     Interpreter class runs the interpreter:
 *     1. Perform all initializations
 *     2. Load the bytecodes from file
 *     3. Run the virtual machine
 *
 *
 *
 * </pre>
 */
public class Interpreter {

    ByteCodeLoader bcl;

    public Program getProg() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //    try {
        Program program = bcl.loadCodes();
        return program;
        //    } catch (IOException e) {
        //       System.out.println("Error in trying to get program " + e);
        //   }

    }

    public Interpreter(String codeFile, boolean debug) {
        try {
            if (!debug) {
                CodeTable.init();
            } else {
                CodeTable.initDebug();
            }
            bcl = new ByteCodeLoader(codeFile);
        } catch (IOException e) {
            System.out.println("**** " + e);
        }
    }

    void run() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Program program = bcl.loadCodes();
        VirtualMachine vm = new VirtualMachine(program);
        vm.executeProgram();
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (args.length == 0) {
            System.out.println("***Incorrect usage, try: java interpreter.Interpreter <file>");
            System.exit(1);
        } else if (args.length == 2 && args[0].equals("-d")) {
            (new Debugger(args[1] + ".x.cod", args[1] + ".x")).runDebug();
        }
      //  (new Interpreter(args[0])).run();
    }
}
