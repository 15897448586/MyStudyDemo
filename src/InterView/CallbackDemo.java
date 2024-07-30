package InterView;

/**
 * @Author zlx
 * @Date 2024/7/4 22:17
 */
// 回调接口
interface Callback {
    void onComplete(String result);
}

// 异步执行任务的类
class TaskExecutor {
    // 模拟异步操作
    void executeTask(Callback callback) {
        // 这里用Thread.sleep模拟异步操作的耗时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 假设这是异步操作的结果
        String result = "Task completed successfully";

        // 回调
        callback.onComplete(result);
    }
}

// 测试类
public class CallbackDemo {
    public static void main(String[] args) {
        TaskExecutor executor = new TaskExecutor();

        // 使用匿名内部类实现回调
//        executor.executeTask(new Callback() {
//            @Override
//            public void onComplete(String result) {
//                System.out.println(result);
//            }
//        });

        // 如果使用Java 8及以上，可以使用Lambda表达式使代码更简洁
         executor.executeTask(result -> System.out.println(result));
    }
}
