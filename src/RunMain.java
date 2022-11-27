import Main.ManagerDocument;
import Modun.Book;
import Modun.Document;
import Modun.Magazine;
import Modun.NewsPaper;
import Utils.Menu;
import Utils.Validate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static Main.ManagerDocument.*;

public class RunMain {
    public static void main(String[] args) {
        BufferedReader bc = new BufferedReader(new InputStreamReader(System.in));
        List<Document> documentList = new ArrayList<>();
        documentList.add(new Book(1,"NXB 1", 100, "Name 1", 1000));
        documentList.add(new Book(2, "NXB 1", 100, "Name 2", 1000));
        documentList.add(new Magazine(3, "NXB 2", 12,12,11));
        ManagerDocument mn = new ManagerDocument(documentList);
        int i;

        do {
            Menu.menu();
            do {
                i = Validate.getInt(bc,"Choice: ");
                if ((i < 1) || (i > 7))
                    System.out.println("Enter a number from 1 to 7");
            } while ((i < 1) || (i > 7));

            switch (i) {
                case 1-> {
                    mn.addDocumnet();
                    System.out.println();
                }
                case 2 -> {
                    mn.showAllStudentList();
                    System.out.println();
                }
                case 3 -> {
                    String st ;
                    st = Validate.getString(bc,"Enter Keyword seach: ");
                    mn.seachDocument(st);
                    System.out.println();
                }
                case 4 -> {
                    int ch;
                    ch = Validate.getInt(bc,"Enter Keyword catelory: ");
                    mn.delete(ch);
                    System.out.println();

                }
                case 5 -> {
                    int ch;
                    ch = Validate.getInt(bc,"Enter Keyword catelory: ");
                    mn.updateDocument(ch);
                }
                case 6 -> {
                    mn.sortNameDocument(documentList);
                   System.out.println();

                }
                case 7 -> System.out.println("Program is finished");
            }
        } while (i != 7);



    }

}
