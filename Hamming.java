import java.util.Scanner;

public class Hamming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите 7-бит сообщение:");
        String message = scanner.next();

        if (message.length() != 7 || !message.matches("[01]+")) {
            System.out.println("Неверный ввод. Пожалуйста, введите ровно 7 бит (0 и 1).");
            return;
        }

        int[] bits = new int[7];
        for (int i = 0; i < 7; i++) {
            bits[i] = Character.getNumericValue(message.charAt(i));
        }

        System.out.println("Основное сообщение: " + message);

        int s1 = bits[0] ^ bits[2] ^ bits[4] ^ bits[6];
        int s2 = bits[1] ^ bits[2] ^ bits[5] ^ bits[6];
        int s3 = bits[3] ^ bits[4] ^ bits[5] ^ bits[6];

        int posiErr = (s3 * 4) + (s2 * 2) + (s1 * 1);

        if (posiErr != 0) {
            System.out.println("Обнаружена ошибка в позиции бита: " + posiErr);

            if (posiErr > 1) {
                bits[posiErr - 1] = bits[posiErr - 1] == 0 ? 1 : 0;
            } else {
                bits[0] = bits[0] == 0 ? 1 : 0;
            }
        } else {
            System.out.println("Ошибка не обнаружена.");
        }

        System.out.print("Правильное сообщение: ");
        for (int bit : bits) {
            System.out.print(bit);
        }
        System.out.println();
        System.out.println("правильно бит : " + bits[2] + "" + bits[4] + "" + bits[5] + "" + bits[6]);
    }
}
