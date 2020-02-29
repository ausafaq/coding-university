package CallCenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CallCenter {

    private static final int CALL_LEVELS = 3;
    private static final int FRESHERS = 5;

    List<List<Employee>> employeeLevels = new ArrayList<>(CALL_LEVELS);
    // queues for each call rank
    List<Queue<Call>> callQueues = new ArrayList<>(CALL_LEVELS);

    public CallCenter() {
        // constructor
    }

    public Employee getCallHandler(Call call) {
        for(int i = call.getRank(); i < CALL_LEVELS - 1; i++) {
            List<Employee> employeeList = employeeLevels.get(i);
            for(Employee emp : employeeList) {
                if(emp.isAvailable()) {
                    return emp;
                }
            }
        }
        return null;
    }

    // Routes the call to an available employee, or adds to the queue
    public void dispatchCall(Call call) {
        // try to route the call to an employee with minimal rank
        Employee emp = getCallHandler(call);
        if(emp != null) {
            emp.receiveCall(call);
        } else {
            callQueues.get(call.getRank()).add(call);
        }
    }

    public void getNextCall(Employee e) {
        // look for call for e's rank
    }
}
