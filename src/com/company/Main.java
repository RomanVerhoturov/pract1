package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        try {
//            RandomAccessFile rf = new RandomAccessFile("1.dat", "rw");
//// Записать в файл 10 чисел и закрыть файл
//            for(int i = 0; i < 10; i++)
//                rf.writeDouble(i * 1.414);
//            rf.close();
//// Открыть файл, записать в него еще одно число и снова закрыть
//            rf = new RandomAccessFile("1.dat", "rw");
//            rf.seek(5 * 8);
//            rf.writeDouble(47.0001);
//            rf.close();
//// Открыть файл с возможностью только чтения "r"
//            rf = new RandomAccessFile("1.dat", "r");
//// Прочитать 10 чисел и показать их на экране
//            for(int i = 0; i < 10; i++)
//                System.out.println("Value " + i + ": " + rf.readDouble());
//            rf.close();
//        } catch (IOException ex) {
//            // Обработать исключение
//        }

    /*    File path = new File(".");
        File[] list = path.listFiles();
        for(int i = 0; i < list.length; i++)
            System.out.println(list[i].getName());
*/


        try {
// Создаем буферизованный символьный входной поток
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(System.in));
// Используем класс PrintWriter для вывода
            PrintWriter out = new PrintWriter(new FileWriter("2.txt"));
// Записываем строки, пока не введем строку "stop"
            while (true) {
                String s = in.readLine();
                if (s.equals("stop"))
                    break;
                out.println(s);
            }
            out.close();
        } catch (IOException ex) {
            // Обработать исключение


            try {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("1.txt"));
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("2.txt"));
                int c = 0;
                while (true) {
                    c = bis.read();
                    if (c != -1)
                        bos.write(c);
                    else
                        break;
                    bis.close();
                    bos.flush(); //освобождаем буфер (принудительно записываем содержимое буфера вфайл)
                    bos.close(); //закрываем поток записи (обязательно!)

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            File path = new File(".");
// Получить массив объектов
            File[] list = path.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    String f = file.getName();
                    return f.indexOf(args[0]) != -1;
                }
            });
// Напечатать имена файлов
            for (int i = 0; i < list.length; i++) {
                System.out.println(list[i].getName());
            }
        }

    }
}
