package Main;

import Inteface.IDocument;
import Modun.Book;
import Modun.Document;
import Modun.Magazine;
import Modun.NewsPaper;
import Utils.Validate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public  class ManagerDocument
{
    private static List<Document> documentList;

    public ManagerDocument(List<Document> documentList) {
        this.documentList = documentList;
    }

    public  List<Document> getDocumentList() {
        return documentList;
    }

    public  void setDocumentList(List<Document> documentList) {
        ManagerDocument.documentList = documentList;
    }

    //Handle



    public void addDocumnet() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ch;
        System.out.println("Select document:\n(0) Book.\n (1) Magazine. \n (2) NewsPaper");
        ch = Validate.getInt(br, "Enter select: ");
        switch (ch){
            case 0:
            System.out.println("Enter Information Book:");
            Document book = new Book();
            book.inputDocument(documentList);
            documentList.add(book);
            break;

            case 1:
            System.out.println("Enter Information Magazine:");
            Document magazine = new Magazine();
            magazine.inputDocument(documentList);
            documentList.add(magazine);
            break;

            case 2:
            System.out.println("Enter Information NewsPaper:");
            Document  newsPaper = new  NewsPaper();
            newsPaper.inputDocument(documentList);
            documentList.add(newsPaper);
            break;
        }
    }


    public void showAllStudentList() {
        System.out.println("Show All Employ List:");
        for (Document doc : documentList) {
           doc.display();
        }
    }

    public void delete(int índex){
        int d = 0;
        System.out.println("List after deletion");
        for (int i = 0; i < documentList.size(); i++){
            if(documentList.get(i).getID() == índex)
            {
                documentList.remove(i);
                d++;
            }
        }
        if(d==0)
            System.out.println("No data index.");
        else {
            System.out.println("Delete successful.");
        }
    }

    public void seachDocument(String st) {
        System.out.println("Show All Employ List:");
        for (Document doc : documentList) {
            if (st.equalsIgnoreCase("book")) {
                if (doc instanceof Book) {
                    Book book = (Book) doc;
                    book.display();
                }
            }
            else if (st.equalsIgnoreCase("magazine")) {
                if (doc instanceof Magazine){
                    Magazine magazine = (Magazine) doc;
                    magazine.display();
                }
            }
            else if (st.equalsIgnoreCase("newspaper")) {
                if (doc instanceof NewsPaper){
                    NewsPaper newsPaper = (NewsPaper) doc;
                    doc.display();
                }
            }else{
                System.out.println("No data");
            }
        }
    }


    public void updateDocument(int n){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i< documentList.size(); i++){
            int d = 0;

            if (documentList.get(i) instanceof Book){
                if(documentList.get(i).getID() == n){
                    System.out.println("Enter Information Book.");
                    String name = Validate.getString(br,"Enter name: ");
                    int releaseNumber = Validate.getInt(br,"Enter releaseNumber: ");
                    String author = Validate.getString(br,"Enter author: ");
                    int numPage = Validate.getInt(br,"Enter numPage: ");
                    documentList.get(i).setName(name);
                    documentList.get(i).setReleaseNumber(releaseNumber);
                    ((Book) documentList.get(i)).setAuthor(author);
                    ((Book) documentList.get(i)).setNumPage(numPage);
                    d++;
                    break;
                }
            }
            if (documentList.get(i) instanceof Magazine){
                if(documentList.get(i).getID() == n){
                    System.out.println("Enter Information Magazine.");
                    String name = Validate.getString(br,"Enter name: ");
                    int releaseNumber = Validate.getInt(br,"Enter releaseNumber: ");
                    int issueNumber = Validate.getInt(br,"Enter issueNumber: ");
                    int releaseMonth = Validate.getInt(br,"Enter releaseMonth: ");
                    documentList.get(i).setName(name);
                    documentList.get(i).setReleaseNumber(releaseNumber);
                    ((Magazine) documentList.get(i)).setIssueNumber(issueNumber);
                    ((Magazine) documentList.get(i)).setReleaseMonth(releaseMonth);
                    d++;
                    break;
                }
            }
            if (documentList.get(i) instanceof NewsPaper){
                if(documentList.get(i).getID() == n){
                    System.out.println("Enter Information NewsPaper.");
                    String name = Validate.getString(br,"Enter name: ");
                    int releaseNumber = Validate.getInt(br,"Enter releaseNumber: ");
                    String releaseDate = Validate.getString(br,"Enter releaseDate: ");
                    documentList.get(i).setName(name);
                    documentList.get(i).setReleaseNumber(releaseNumber);
                    ((NewsPaper) documentList.get(i)).setReleaseDate(releaseDate);
                    d++;

                    break;
                }
            }
            if (d!=0)
                System.out.println("Update successful");
            else
                System.out.println("No data found");

        }

    }

    public void sortNameDocument(List<Document> documentList){
        Collections.sort(documentList, new Comparator<Document>(){
            public int compare(Document d1, Document d2){
                if (d1.getName().compareToIgnoreCase(d2.getName()) > 0)
                        return 1;
                else if (d1.getName().compareToIgnoreCase(d2.getName()) < 0)
                        return -1;
                else {
                    return 0;
                }
            }
        });
    }
}
