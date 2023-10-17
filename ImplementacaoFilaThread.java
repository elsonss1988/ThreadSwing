package Thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread{

    private static ConcurrentLinkedQueue<ObjectFile> pilhaFilha
            = new ConcurrentLinkedQueue<ObjectFile>();

    public  static void add(ObjectFile objectFile){
        pilhaFilha.add(objectFile);

    }


    public void run(){
        while(true){
            synchronized (pilhaFilha) {
                Iterator iterator = pilhaFilha.iterator();


                while (iterator.hasNext()) {
                    ObjectFile processar = (ObjectFile) iterator.next();

                    System.out.println("-------------------------");
                    System.out.println(processar.toString());

                    iterator.remove();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}












