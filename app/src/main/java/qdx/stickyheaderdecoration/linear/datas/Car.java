package qdx.stickyheaderdecoration.linear.datas;


public class Car {
    public Car(String name, String logo, String headerName, String letter) {
        this.name = name;
        this.logo = logo;
        this.headerName = headerName;
        this.letter = letter;
    }

    private String name;
    private String logo;
    private String headerName;
    private String letter;

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }
}
