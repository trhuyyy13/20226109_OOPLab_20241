package hust.soict.ep.aims.disc;
public class TestPassingParameter {
    public static void main(String[] args) {
    DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
    DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
    swap(jungleDVD,cinderellaDVD);

    System.out.println("jungle title: "+ jungleDVD.getTitle());
    System.out.println("cinderella title: "+ cinderellaDVD.getTitle());
    
    changeTitle(jungleDVD,cinderellaDVD.getTitle());
    System.out.println("jungle title: "+ jungleDVD.getTitle());
    }
    public static void swap(Object o1,Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
    public static void  changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        DigitalVideoDisc tmp = new DigitalVideoDisc(dvd1.getTitle(), dvd1.getCategory(), dvd1.getDirector(), dvd1.getLength(), dvd1.getCost());

        dvd1.setTitle(dvd2.getTitle());
        dvd1.setCategory(dvd2.getCategory());
        dvd1.setDirector(dvd2.getDirector());
        dvd1.setLength(dvd2.getLength());
        dvd1.setCost(dvd2.getCost());
        
        
        dvd2.setTitle(tmp.getTitle());
        dvd2.setCategory(tmp.getCategory());
        dvd2.setDirector(tmp.getDirector());
        dvd2.setLength(tmp.getLength());
        dvd2.setCost(tmp.getCost());
    }

    
}