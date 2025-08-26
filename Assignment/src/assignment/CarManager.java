/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class CarManager {
    public static void main(String[] args) {
        ArrayList<String> ops = new ArrayList<>(Arrays.asList(
            "List all brands",
            "Add a new brand",
            "Search a brand based on its ID",
            "Update a brand",
            "Save brands to the file",
            "List all cars in ascending order of brand names",
            "List cars based on a part of an input brand name",
            "Add a car",
            "Remove a car based on its ID",
            "Update a car based on its ID",
            "Save cars to file"
        ));

        BrandList brandList = new BrandList();
        brandList.loadFromFile("File brands.txt");

        CarList carList = new CarList(brandList);
        carList.loadFromFile("File cars.txt");

        Menu m = new Menu();
        int choice;
        do {
            choice = m.int_getChoice(ops);
            switch (choice) {
                case 1: brandList.listBrands(); break;
                case 2: brandList.addBrand(); break;
                case 3:
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter brand ID to search: ");
                    int pos = brandList.searchID(sc.nextLine().trim());
                    if (pos < 0) System.out.println("Not found!");
                    else System.out.println(brandList.get(pos));
                    break;
                case 4: brandList.updateBrand(); break;
                case 5: brandList.saveToFile("File brands.txt"); break;
                case 6: carList.listCars(); break;
                case 7: carList.printBasedBrandName(); break;
                case 8: carList.addCar(); break;
                case 9: carList.removeCar(); break;
                case 10: carList.updateCar(); break;
                case 11: carList.saveToFile("File cars.txt"); break;
            }
        } while (choice > 0 && choice <= ops.size());
    }
}
