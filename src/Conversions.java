import java.util.Scanner;

public class Conversions {

    public static float metricConverter(float sourceNum, String sourceMetric, float targetNum, String targetMetric) {
        targetNum = 0;

        switch (sourceMetric) {
            case "km":
                switch (targetMetric) {
                    case "m":
                        targetNum = sourceNum * 1000;
                        break;
                    case "mile":
                        targetNum = sourceNum / (float) 1.609;
                        break;
                    default:
                        System.out.println("Input not accepted. Please try again. For example, 1 kg = lb.");
                        break;
                }
                break;
            case "mile":
                switch (targetMetric) {
                    case "km":
                        targetNum = sourceNum * (float) 1.609;
                        break;
                    case "ft":
                        targetNum = sourceNum * 5280;
                        break;
                    default:
                        System.out.println("Input not accepted. Please try agian. For example, 1 kg = lb.");
                        break;
                }
                break;
            case "m":
                switch (targetMetric) {
                    case "km":
                        targetNum = sourceNum / 1000;
                        break;
                    case "mile":
                        targetNum = sourceNum / 1609;
                        break;
                    case "ft":
                        targetNum = sourceNum * (float) 3.281;
                        break;
                    case "cm":
                        targetNum = sourceNum * 100;
                        break;
                    default:
                        System.out.println("Input not accepted. Please try again. For example, 1 kg = lb.");
                        break;
                }
                break;
            case "ft":
                switch (targetMetric) {
                    case "m":
                        targetNum = sourceNum / (float) 3.281;
                        break;
                    case "in":
                        targetNum = sourceNum * 12;
                        break;
                    case "mile":
                        targetNum = sourceNum / 5280;
                        break;
                    default:
                        System.out.println("Input not accepted. Please try again. For example, 1 kg = lb.");
                        break;
                }
                break;
            case "kg":
                switch (targetMetric) {
                    case "lb":
                        targetNum = sourceNum * (float) 2.205;
                        break;
                    default:
                        System.out.println("Input not accepted. Please try again. For example, 1 kg = lb.");
                        break;
                }
                break;
            case "lb":
                switch (targetMetric) {
                    case "kg":
                        targetNum = sourceNum / (float) 2.205;
                        break;
                    default:
                        System.out.println("Input not accepted. Please try again. For example, 1 kg = lb.");
                        break;
                }
                break;
            case "celsius":
                switch (targetMetric) {
                    case "fahrenheit":
                        targetNum = (float) (sourceNum * (9 / 5) + 32);
                        break;
                    case "kelvin":
                        targetNum = sourceNum + (float) 273.15;
                        break;
                    default:
                        System.out.println("Input not accepted. Please try again. For example, 1 kg = lb.");
                        break;
                }
                break;
            case "fahrenheit":
                switch (targetMetric) {
                    case "celsius":
                        targetNum = (float) ((5 / 9) * (sourceNum - 32));
                        break;
                    case "kelvin":
                        targetNum = (float) (((5 / 9) * (sourceNum - 32)) + 273.15);
                        break;
                }
                break;
            case "kelvin":
                switch (targetMetric) {
                    case "celsius":
                        targetNum = sourceNum - (float) 273.15;
                        break;
                    case "fahrenheit":
                        targetNum = (float) (((sourceNum - 273.15) * (9 / 5)) + 32);
                        break;
                    default:
                        System.out.println("Input not accepted. Please try again. For example, 1 kg = lb.");
                }
                break;
            default:
                System.out.println("Input not accepted. Please try again. For example, 1 kg = lb.");
                break;
        }

        System.out.printf("%.2f %s = %.2f %s%n", sourceNum, sourceMetric, targetNum, targetMetric); // go over
        return targetNum;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String str;
        String[] strArray;
        float sourceNum;
        String sourceMetric;
        float targetNum = 0;
        String targetMetric;

        while (true) {
            System.out.println("Welcome to metric converter!" + "\n" + 
                               "Please input your metric to be converted. For example, 1 kg = lb." + "\n" + 
                               "Enter 'exit' or '-1' to exit the program.");

            str = scanner.nextLine();

            if ((str.equals("exit") || (str.equals("-1")))) {
                System.out.println("Bye!");
                scanner.close();
                break;
            }

            strArray = str.split(" ");

            if (strArray.length != 4) {
                System.out.println("Input not accepted. Please try again. For example, 1 kg = lb.");
                continue;
            } else {
                sourceNum = Float.parseFloat(strArray[0]);
                sourceMetric = strArray[1];
                targetMetric = strArray[3];
                metricConverter(sourceNum, sourceMetric, targetNum, targetMetric);
            }
        }
    }
}