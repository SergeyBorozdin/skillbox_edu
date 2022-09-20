import java.text.DecimalFormat;

public class Hospital {

    public static void main(String[] args) {

        // используя данный метод, вы можете использовать ваши методы, и проверить их работу на разных
        // значений для проверки и отладки

        float[] temperatureData = generatePatientsTemperatures(30);
        System.out.println(getReport(temperatureData));

        //Пример вывода в консоль:
        //Температуры пациентов: 36.7 38.9 34.7
        //Средняя температура: 36.76
        //Количество здоровых: 1


    }

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] temp = new float[patientsCount];
        double valueTemp;
        for (int i = 0; i < patientsCount; i++) {
            valueTemp = (32.0 +(Math.random() * 8));
            temp[i] = (float) valueTemp;
        }
        return temp;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
            Округлите среднюю температуру с помощью Math.round до 2 знаков после запятой,
            а температуры каждого пациента до 1 знака после запятой
        */
        float averageTemp = 0;
        int countHealthy = 0;
        String allTemp = "";
        for (float temp : temperatureData) {
            if (temp >= 36.6) {
                countHealthy++;
            }
            averageTemp += temp;
            allTemp += String.format("%.1f", temp) + ", ";
        }
        averageTemp = averageTemp / temperatureData.length;

        String report = String.format("Температуры пациентов: "+ "%s" + "\nСредняя температура: " + "%.2f" + "\nКоличество здоровых: " + "%d", allTemp, averageTemp, countHealthy);

        return report;
    }


}
