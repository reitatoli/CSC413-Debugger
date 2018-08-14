package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author Bradley SomathiNg
 */
public class ReturnCode extends ByteCode {

    String label = "";
    int topValue;

    @Override
    public void init(Vector<String> args) {
        if (!args.isEmpty()) {
            label = args.firstElement();
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.popFrame();
        vm.setPC(vm.popAddress());
        topValue = vm.peek();
        String tmp = "RETURN ";
        if ((label.equals("NULL"))) {
            vm.dump(tmp);
        } else {
            tmp = tmp.concat(label);
            vm.dump(tmp);
        }
    }

    @Override
    public String getArgs() {

        return label;
    }

}
