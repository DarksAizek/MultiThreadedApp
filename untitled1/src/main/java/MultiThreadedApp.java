public class MultiThreadedApp {
    public static void main(String[] args) {
        // Создание и запуск потока для вывода чисел
        Thread numbersThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Число: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        numbersThread.start();

        // Создание и запуск потока для вывода букв
        Thread lettersThread = new Thread(() -> {
            for (char c = 'A'; c <= 'J'; c++) {
                System.out.println("Буква: " + c);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        lettersThread.start();

        // Создание и запуск потока для выполнения сложных вычислений
        Thread complexTaskThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Выполнение сложной задачи: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        complexTaskThread.start();

        // Ожидание завершения всех потоков
        try {
            numbersThread.join();
            lettersThread.join();
            complexTaskThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Все потоки завершены.");
    }
}
