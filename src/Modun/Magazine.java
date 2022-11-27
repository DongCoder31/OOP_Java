package Modun;

import Inteface.IDocument;
import Utils.Validate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Magazine extends Document  {
    private int issueNumber;
    private int releaseMonth;

    public Magazine(){
    }

    public Magazine(int ID, String name, int releaseNumber, int issueNumber, int releaseMonth) {
        super(ID, name, releaseNumber);
        this.issueNumber = issueNumber;
        this.releaseMonth = releaseMonth;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(int releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    @Override
    public void inputDocument(List<Document> documentList) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        super.inputDocument(documentList);
        boolean checkMonth = true;
        do{
            this.releaseMonth = Validate.getInt(br, "Enter releas Month: ");
            if(getReleaseMonth() < 1 || getReleaseMonth() > 12)
                checkMonth = false;
        }while (!checkMonth);
        this.issueNumber = Validate.getInt(br, "Enter issueNumber: ");
    }


    public void display() {
        super.display();
        System.out.println(
                " Issue number : " + this.issueNumber + "\t"
                        +"Release month: " + this.releaseMonth + "\n");
    }
}
