package Modun;

import Inteface.IDocument;
import Utils.Validate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Book extends Document  {
    private String author;
    private int numPage;
    public Book(){
    }
    public Book(int ID, String name, int releaseNumber, String author, int numPage) {
        super(ID, name, releaseNumber);
        this.author = author;
        this.numPage = numPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    @Override
    public void inputDocument(List<Document> documentList) {
        BufferedReader bc = new BufferedReader(new InputStreamReader(System.in));
        super.inputDocument(documentList);
        this.numPage = Validate.getInt(bc,"Enter num page: ");
        this.author = Validate.getString(bc, "Enter author: ");
    }




    @Override
    public void display() {
        super.display();
        System.out.print(
                " Author : " + this.author + "\t"
                +"Num page: " + this.numPage + "\n");
    }
}
