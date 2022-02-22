import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MiCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        int total = 0;
        for(int i=0; i < 5; i++) {

            total+=i;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }
        System.out.println(Thread.currentThread().getName());


        return total;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService servicio = Executors.newFixedThreadPool(1);

        Future<Integer> resultado = servicio.submit(new MiCallable());

        if (resultado.isDone()) {
            System.out.println(resultado.get());
        }
    }
}