package com.paazl.cases.test6;

import com.paazl.cases.test6.entities.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<User> userList = new ArrayList<>();
    private static String mainLine;

    /*
     * Read and parse "testdata.csv" (located in
     * src/main/resources/com/paazl/cases/test6) into a list of POJOs. Increase
     * each POJO's "number" field by 1, and move the "date" field one day ahead.
     * Write the results to a file named "testdata.new.csv".
     */
    public static void main(String[] args) throws FileNotFoundException {
        readData();

        writeData();
    }

    private static void readData() throws FileNotFoundException {
        String url = Main.class.getResource("/com/paazl/cases/test6/testdata.csv").getFile();
        BufferedReader reader = new BufferedReader(new FileReader(new File(url)));

        String line;
        String[] values;
        String[] date;

        try {
            mainLine = reader.readLine();

            while ((line = reader.readLine()) != null) {
                values = line.split(";");
                date = values[4].split("/");

                User user = new User();
                user.setName(values[0]);
                user.setCity(values[1]);
                user.setCountry(values[2]);
                user.setNumber(Integer.parseInt(values[3]));
                user.setDate(LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0])));

                userList.add(user);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeData() {
        String url = Main.class.getResource("/com/paazl/cases/test6/testdatanew.csv").getFile();
        File file = new File(url);
        try {
            FileWriter wrt = new FileWriter(file);

            int number;
            LocalDate date;

            wrt.write(mainLine + "\n");

            for (User user : userList) {
                number = user.getNumber();
                number++;
                user.setNumber(number);

                date = user.getDate();
                date = date.plusDays(1);
                user.setDate(date);

                wrt.write(user.toString() + "\n");
            }

            wrt.flush();
            wrt.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}