public class Data {
    public static int count_process;
    public static int count_resource;
    public static int available;
    public static int[] allocation;
    public static int[] max;
    public static int[] need;

    public static String test() {
        return test(0, 0);
    }

    public static String test(int request_no, int request_num) {
        boolean[] finish = new boolean[count_process];
        for (int i = 0; i < count_process; i++) {
            finish[i] = false;
        }
        int currentAvailable = available - request_num;
        boolean isSafe = true;
        StringBuffer str = new StringBuffer("分配成功，安全序列为：");
        allocation[request_no] += request_num;
        need[request_no] -= request_num;

        for (int c = 0; c < count_process; c++) {
            for (int i = 0; i < count_process; i++) {
                if (finish[i] == false && need[i] <= currentAvailable) {
                    currentAvailable += allocation[i];
                    finish[i] = true;
                    str.append("P" + (i+1)+",");
                    break;
                }
            }

        }
        for (int i = 0; i < count_process; i++) {
            if (finish[i] == false)
                isSafe = false;
        }
        if (isSafe) {
            allocation[request_no] -= request_num;
            need[request_no] += request_num;
            return str.toString();
        } else {
            allocation[request_no] -= request_num;
            need[request_no] += request_num;
            return "分配失败！";
        }


    }

}
