/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;
import java.util.*;
import java.io.*;

/**
 *
 * @author ADMIN
 */
public class CarList extends ArrayList<Car> {
    private BrandList brandList;

    public CarList(BrandList bList) {
        brandList = bList;
    }

    public boolean loadFromFile(String filename) {
        File f = new File(filename);
        if (!f.exists()) return false;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 5) {
                    String carID = parts[0];
                    String brandID = parts[1];
                    String color = parts[2];
                    String frameID = parts[3];
                    String engineID = parts[4];
                    int pos = brandList.searchID(brandID);
                    if (pos >= 0) {
                        Brand brand = brandList.get(pos);
                        this.add(new Car(carID, brand, color, frameID, engineID));
                    }
                }
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Car c : this) {
                pw.println(c.toString());
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public int searchID(String carID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCarID().equalsIgnoreCase(carID)) return i;
        }
        return -1;
    }

    public int searchFrame(String fID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFrameID().equalsIgnoreCase(fID)) return i;
        }
        return -1;
    }

    public int searchEngine(String eID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEngineID().equalsIgnoreCase(eID)) return i;
        }
        return -1;
    }

    public void addCar() {
        Scanner sc = new Scanner(System.in);
        String id, color, fID, eID;
        do {
            System.out.print("Enter car ID: ");
            id = sc.nextLine().trim();
        } while (searchID(id) >= 0);

        Brand brand = brandList.getUserChoice();

        do {
            System.out.print("Enter color: ");
            color = sc.nextLine().trim();
        } while (color.isEmpty());

        do {
            System.out.print("Enter frame ID (F00000): ");
            fID = sc.nextLine().trim();
        } while (!fID.matches("F\\d{5}") || searchFrame(fID) >= 0);

        do {
            System.out.print("Enter engine ID (E00000): ");
            eID = sc.nextLine().trim();
        } while (!eID.matches("E\\d{5}") || searchEngine(eID) >= 0);


        this.add(new Car(id, brand, color, fID, eID));
        System.out.println("Car added.");
    }

    public void printBasedBrandName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter part of brand name: ");
        String part = sc.nextLine();
        int count = 0;
        for (Car c : this) {
            if (c.getBrand().getBrandName().contains(part)) {
                System.out.println(c.screenString());
                count++;
            }
        }
        if (count == 0) System.out.println("No car is detected!");
    }

    public boolean removeCar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter car ID to remove: ");
        String id = sc.nextLine().trim();
        int pos = searchID(id);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        }
        this.remove(pos);
        System.out.println("Car was removed");
        return true;
    }

    public boolean updateCar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter car ID to update: ");
        String id = sc.nextLine().trim();
        int pos = searchID(id);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        }
        Brand brand = brandList.getUserChoice();
        System.out.print("Enter new color: ");
        String color = sc.nextLine().trim();

        String fID;
        do {
            System.out.print("Enter new frame ID (F00000): ");
            fID = sc.nextLine().trim();
        } while (!fID.matches("F\\d{5}") || (searchFrame(fID) >= 0 && !this.get(pos).getFrameID().equalsIgnoreCase(fID)));

        String eID;
        do {
            System.out.print("Enter new engine ID (E00000): ");
            eID = sc.nextLine().trim();
        } while (!eID.matches("E\\d{5}") || (searchEngine(eID) >= 0 && !this.get(pos).getEngineID().equalsIgnoreCase(eID)));

        Car c = this.get(pos);
        c.setBrand(brand);
        c.color = color;
        c.frameID = fID;
        c.engineID = eID;
        System.out.println("Car updated.");
        return true;
    }

    public void listCars() {
        Collections.sort(this);
        for (Car c : this) {
            System.out.println(c.screenString());
        }
    }
}
