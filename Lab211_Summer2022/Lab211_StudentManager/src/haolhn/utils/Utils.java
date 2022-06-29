/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haolhn.utils;

import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 *
 * @author ngoc hao
 */
public class Utils {


    public static boolean updateGender(String wellcome, boolean oldData) {
        boolean result = false;
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(wellcome);
            String tmp = sc.nextLine();
            if ("y".equalsIgnoreCase(tmp)) {
                result = true;
                check = false;
            } else if ("n".equalsIgnoreCase(tmp)) {
                result = false;
                check = false;
            } else if ("".equalsIgnoreCase(tmp)) {
                result = oldData;
                check = false;
            } else {
                System.out.println("Must input Y/N");
            }
        } while (check);
        return result;
    }

    public static boolean getGender(String wellcome) {
        boolean result = false;
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(wellcome);
            String confirm = sc.nextLine();
            if ("y".equalsIgnoreCase(confirm)) {
                result = true;
                check = false;
            } else if ("n".equalsIgnoreCase(confirm)) {
                result = false;
                check = false;
            } else {
                System.out.println("Must input Y/N");

            }
        } while (check);
        return result;
    }

    public static String getMail(String wellcome) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(wellcome);
            result = sc.nextLine();
//bắt đầu bằng 1 ký tự từ [a-zA-Z] tiếp theo bao gồm cả số vì có 0-9. vì có dấu cộng nên được viết nhiều // {1,3} biếu thị cho chỉ được viết từ 1 đến 3
            Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-z]+(\\.[a-zA-Z]+){1,3}$");
            if (p.matcher(result).find()) {
                check = false;
            } else {
                System.out.println("Invalid Email ! please Input again");
            }
        } while (check);
        return result;
    }

    public static String UpdateMail(String wellcome, String oldData) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(wellcome);
            String tmp = sc.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-z]+(\\.[a-zA-Z]+){1,3}$");
            if (p.matcher(tmp).find()) {
                result = tmp;
                check = false;
            } else if (tmp.isEmpty()) {
                result = oldData;
                check = false;
            } else {
                System.out.println("Invalid Email ! please Input again");
            }
        } while (check);
        return result;

    }

    public static String updateDate(String wellcome, String olddata) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        Calendar cld = Calendar.getInstance();
        int curentYear = cld.get(Calendar.YEAR);
        do {
            System.out.println(wellcome);
            String tmp = sc.nextLine();
            Pattern p = Pattern.compile("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{2,4}$");
            if (p.matcher(tmp).find()) {
                StringTokenizer stk = new StringTokenizer(tmp, "/", false);
                while (stk.hasMoreElements()) {
                    int day = Integer.parseInt(stk.nextToken());
                    int month = Integer.parseInt(stk.nextToken());
                    int year = Integer.parseInt(stk.nextToken());
                    if (day >= 1 && day <= 31) {
                        if (month >= 1 && month <= 12) {
                            if (year > 1000 && year <= curentYear) {
                                result = tmp;
                                check = false;
                            } else {
                                System.out.println("Year is not valid");
                            }
                        } else {
                            System.out.println("Monthis not valid");
                        }
                    } else {
                        System.out.println("date is not valid");
                    }
                }
            } else if (tmp.isEmpty()) {
                result = olddata;
                check = false;
            } else {
                System.out.println("Must input fomart (DD/MM/YYYY)");
            }
        } while (check);
        return result;
    }

    public static String getDate(String wellcome) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        Calendar cld = Calendar.getInstance();
        int curentYear = cld.get(Calendar.YEAR);
        do {
            System.out.println(wellcome);
            result = sc.nextLine();
            Pattern p = Pattern.compile("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{2,4}$");
            if (p.matcher(result).find()) {
                StringTokenizer stk = new StringTokenizer(result, "/", false);
                while (stk.hasMoreElements()) {
                    int day = Integer.parseInt(stk.nextToken());
                    int month = Integer.parseInt(stk.nextToken());
                    int year = Integer.parseInt(stk.nextToken());
                    if (day >= 1 && day <= 31) {
                        if (month >= 1 && month <= 12) {
                            if (year > 1000 && year <= curentYear) {
                                check = false;
                            } else {
                                System.out.println("Year is not valid");
                            }
                        } else {
                            System.out.println("Monthis not valid");
                        }
                    } else {
                        System.out.println("date is not valid");
                    }
                }
            } else {
                System.out.println("Must input fomart (DD/MM/YYYY)");
            }
        } while (check);
        return result;
    }

    public static String getString(String wellcome) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(wellcome);
            result = sc.nextLine();
            if (!result.isEmpty()) {
                check = false;
            } else {
                System.out.println("Must input text !");
            }
        } while (check);
        return result;
    }

    public static String updateString(String wellcome, String oldData) {
        String result = "";
        Scanner sc = new Scanner(System.in);
        System.out.println(wellcome);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        } else {
            result = oldData;
        }
        return result;
    }

    public static double getDouble(String wellcome, int min, int max) {
        boolean check = true;
        double number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println(wellcome);
                number = Double.parseDouble(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println(" Must input number !");
            }
        } while (check || number > max || number < min);

        return number;
    }

    public static double updateDouble(String wellcome, int min, int max, double oldData) {
        boolean check = true;
        double number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(wellcome);
                String tmp = sc.nextLine();
                if (!tmp.isEmpty()) {
                    number = Double.parseDouble(tmp);
                    check = false;
                } else {
                    number = oldData;
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Must input number !");
            }
        } while (check || max > number && number < min);
        return number;
    }

    public static int getInt(String wellcome, int min, int max) {
        boolean check = true;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println(wellcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println(" Must input number !");
            }
        } while (check || number > max || number < min);

        return number;
    }

    public static int updateInt(String wellcome, int min, int max, int oldData) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(wellcome);
                String tmp = sc.nextLine();
                if (!tmp.isEmpty()) {
                    number = Integer.parseInt(tmp);
                    check = false;
                } else {
                    number = oldData;
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Must input number !");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static boolean confirmYesNo(String wellcome) {
        boolean result = false;
        String confirm = Utils.getString(wellcome);
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }

    public static String getPhone(String wellcome) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            Pattern p = Pattern.compile("^[0-9]{10,12}$");
            System.out.println(wellcome);
            result = sc.nextLine();
            if (!result.isEmpty()) {
                if (p.matcher(result).find()) {
                    check = false;
                } else {
                    System.out.println("Must input phone number 10 <--> 12");
                }
            } else {
                System.out.println("Must input text !");
            }
        } while (check);
        return result;
    }

    public static String updatePhone(String welcome, String oldData) {
        String result = oldData;
        boolean check = true;
        do {
            Pattern p = Pattern.compile("^[0-9]{10,12}$");
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            String tmp = sc.nextLine();
            if (!tmp.isEmpty()) {
                if (p.matcher(tmp).find()) {
                    result = tmp;
                    check = false;
                } else {
                    System.out.println("You need input your phone number from 10 to 12 ");
                }
            } else {
                check = false;
            }
        } while (check);

        return result;
    }

    public static void StudentMenu() {
        System.out.println("\n------------------STUDENT--------------------");
        System.out.println("1.Update Student.");
        System.out.println("2.Delete Student. ");
        System.out.println("3.Quit. ");
        System.out.println("\n");
    }

    public static void SubjectMenu() {
        System.out.println("\n------------------SUBJECT--------------------");
        System.out.println("1.Update Subject.");
        System.out.println("2.Delete Subject.");
        System.out.println("3.Quit. ");
        System.out.println("\n");
    }

}
