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
public class BrandList extends ArrayList<Brand>{
    public boolean loadFromFile(String filename) {
        File f = new File(filename);
        if (!f.exists()) return false;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", |: ");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    String sound = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    this.add(new Brand(id, name, sound, price));
                }
            }
        } catch (IOException e) { 
            return false;
        }

        return true;
    }

    public boolean saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Brand b : this) {
                pw.println(b.toString());
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public int searchID(String bID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getBrandID().equalsIgnoreCase(bID)) return i;
        }
        return -1;
    }

    public Brand getUserChoice() {
        Menu m = new Menu();
        return (Brand) m.ref_getChoice(this);
    }

    public void addBrand() {
        Scanner sc = new Scanner(System.in);
        String id, name, sound;
        double price;
        do {
            System.out.print("Enter brand ID: ");
            id = sc.nextLine().trim();
        } while (searchID(id) >= 0);

        do {
            System.out.print("Enter brand name: ");
            name = sc.nextLine().trim();
        } while (name.isEmpty());

        do {
            System.out.print("Enter sound brand: ");
            sound = sc.nextLine().trim();
        } while (sound.isEmpty());

        do {
            System.out.print("Enter price: ");
            price = Double.parseDouble(sc.nextLine());
        } while (price <= 0);

        this.add(new Brand(id, name, sound, price));
        System.out.println("Brand added.");
    }

    public void updateBrand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter brand ID to update: ");
        String id = sc.nextLine().trim();
        int pos = searchID(id);
        if (pos < 0) {
            System.out.println("Not found!");
            return;
        }
        String name, sound;
        double price;
        do {
            System.out.print("Enter new brand name: ");
            name = sc.nextLine().trim();
        } while (name.isEmpty());

        do {
            System.out.print("Enter new sound brand: ");
            sound = sc.nextLine().trim();
        } while (sound.isEmpty());

        do {
            System.out.print("Enter new price: ");
            price = Double.parseDouble(sc.nextLine());
        } while (price <= 0);

        Brand b = this.get(pos);
        b.setBrandName(name);
        b.setSoundBrand(sound);
        b.setPrice(price);
        System.out.println("Brand updated.");
    }

    public void listBrands() {
        for (Brand b : this) {
            System.out.println(b);
        }
    }
}
