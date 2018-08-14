/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;

import interpreter.*;
import interpreter.bytecode.*;
import interpreter.debugger.*;
import java.util.*;

/**
 *
 * @author Bradley SomathiNg
 */
public class DebugLitCode extends LitCode {


    @Override
    public void execute(VirtualMachine vm) {
        DebuggerVirtualMachine virtM = (DebuggerVirtualMachine) vm;
        super.execute(virtM);
        if (!(id.isEmpty())) {
            int buffer = virtM.getStackSize();
            virtM.funcRecEnter(id, buffer);

        }

    }
}
