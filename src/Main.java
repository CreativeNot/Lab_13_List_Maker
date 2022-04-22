import javax.swing.*;
import java.io.*;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.*;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.CREATE_NEW;

public class Main {

    public static void main(String[] args)
    {
        String menuChoice = " ";
        boolean keepgoin = false;
        boolean flag = false;
        boolean flag2 = false;
        boolean needsToBeSaved = false;
        String rec = " ";
        int counter = 0;
        int deleted = 0;
        int line = 0;
        String userInput = " ";
        Scanner in = new Scanner(System.in);
        JFileChooser chooser = new JFileChooser();
        File selectedFile;

        ArrayList<String> list = new ArrayList<>();
        list.add("Data Holder");
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        try {
        OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            do {
                menuChoice = SafeInput.getRegExString(in, "Please enter a menu choice: Add, Delete, View, Quit, Open, Save, or Clear. ", "[AaDdVvQqOoSsCc]");
                if (menuChoice.equalsIgnoreCase("A")) {
                    do {
                        userInput = SafeInput.getNonZeroLenString(in, "Please enter something to add to the list");
                        list.add(userInput);
                        flag = SafeInput.getYNConfirm(in, "Do you have more to add? [Y/N]");
                    } while (flag == true);
                } else if (menuChoice.equalsIgnoreCase("O")) {
                    chooser.setCurrentDirectory(workingDirectory);
                    if (chooser.showOpenDialog(null) == JFileChooser.OPEN_DIALOG);
                    {
                        selectedFile = chooser.getSelectedFile();
                        Path File = selectedFile.toPath();
                        line = 0;



                    }
                } else if (menuChoice.equalsIgnoreCase("D")) {
                    counter = 0;
                    do {
                        for (String str : list) {
                            counter++;
                            System.out.println(counter + ". " + str);
                        }
                        deleted = SafeInput.getRangedInt(in, "Please enter which item you would like to delete", 1, list.size());
                        in.nextLine();
                        deleted = deleted - 1;
                        userInput = SafeInput.getNonZeroLenString(in, "Add replacement entry");
                        list.set(deleted, userInput);
                        flag2 = true;
                    } while (!flag2);
                } else if (menuChoice.equalsIgnoreCase("V")) {
                    counter = 0;
                    for (String str : list) {
                        counter++;
                        System.out.println(counter + ". " + str);
                    }

                } else {
                    keepgoin = SafeInput.getYNConfirm(in, "Are you sure you want to quit? [Y/N]");
                }
            }
            while (!keepgoin);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
