package com.canteen.system;

import com.canteen.models.MenuItem;
import java.time.LocalTime;

public class MenuManager {
    private Canteen[] canteens;

    public MenuManager() {
        initializeMenus();
    }

    private void initializeMenus() {
        canteens = new Canteen[3]; // For 3 canteens
        
        // ================== MAIN CANTEEN ==================
        TimeSlotMenu[] mainCanteenSlots = new TimeSlotMenu[4];
        
        // Breakfast (7:30-9:30)
        MenuItem[] mainBreakfast = {
            new MenuItem("MB1", "Aloo Paratha + Curd", 45, "Main"),
            new MenuItem("MB2", "Stuffed Kulcha", 50, "Main"),
            new MenuItem("MB3", "Chole Bhature", 60, "Main"),
            new MenuItem("MB4", "Poha with Jalebi", 35, "Main"),
            new MenuItem("MB5", "Besan Chilla", 40, "Main"),
            new MenuItem("MB6", "Lassi (Sweet/Salted)", 30, "Beverage"),
            new MenuItem("MB7", "Fresh Fruit Plate", 60, "Fruits"),
            new MenuItem("MB8", "Boiled Eggs (2 pcs)", 25, "Starter(NV)"),
            new MenuItem("MB9", "Poori Bhaji", 55, "Main"),
            new MenuItem("MB10", "Milk + Cornflakes", 40, "Main")
        };
        mainCanteenSlots[0] = new TimeSlotMenu("Breakfast", mainBreakfast);
        
        // Lunch (12:00-14:30)
        MenuItem[] mainLunch = {
            new MenuItem("ML1", "Thali (4 Roti+2 Sabzi+Dal+Rice)", 120, "Combo"),
            new MenuItem("ML2", "Butter Chicken + Naan", 150, "Main(NV)"),
            new MenuItem("ML3", "Paneer Tikka", 90, "Starter"),
            new MenuItem("ML4", "Chicken Wings (6 pcs)", 130, "Starter(NV)"),
            new MenuItem("ML5", "Masala Chaas", 25, "Beverage"),
            new MenuItem("ML6", "Pepsi/Mirinda", 30, "Soft Drink"),
            new MenuItem("ML7", "Gajar Ka Halwa", 50, "Dessert"),
            new MenuItem("ML8", "Ice Cream Scoop", 40, "Dessert"),
            new MenuItem("ML9", "Dal Makhani + Naan", 110, "Main"),
            new MenuItem("ML10", "Veg Biryani", 100, "Main")
        };
        mainCanteenSlots[1] = new TimeSlotMenu("Lunch", mainLunch);
        
        // Snacks (16:30-18:00)
        MenuItem[] mainSnacks = {
            new MenuItem("MS1", "Samosa Chaat", 45, "Starter"),
            new MenuItem("MS2", "Aloo Tikki (2 pcs)", 35, "Starter"),
            new MenuItem("MS3", "Rose Milk", 35, "Beverage"),
            new MenuItem("MS4", "Cold Coffee", 40, "Beverage"),
            new MenuItem("MS5", "Gulab Jamun (2 pcs)", 30, "Dessert"),
            new MenuItem("MS6", "French Fries", 50, "Starter"),
            new MenuItem("MS7", "Paneer Pakora (6 pcs)", 60, "Starter"),
            new MenuItem("MS8", "Mango Shake", 50, "Beverage"),
            new MenuItem("MS9", "Bhel Puri", 40, "Starter"),
            new MenuItem("MS10", "Badam Milk", 45, "Beverage")
        };
        mainCanteenSlots[2] = new TimeSlotMenu("Snacks", mainSnacks);
        
        // Dinner (19:00-20:30)
        MenuItem[] mainDinner = {
            new MenuItem("MD1", "Paneer Butter Masala + Naan", 130, "Main"),
            new MenuItem("MD2", "Mutton Rogan Josh", 180, "Main(NV)"),
            new MenuItem("MD3", "Veg Fried Rice", 90, "Main"),
            new MenuItem("MD4", "Chicken Soup", 70, "Starter(NV)"),
            new MenuItem("MD5", "Blue Lagoon Mocktail", 70, "Beverage"),
            new MenuItem("MD6", "Kulfi Falooda", 65, "Dessert"),
            new MenuItem("MD7", "Garlic Bread", 45, "Starter"),
            new MenuItem("MD8", "Chocolate Mousse", 80, "Dessert"),
            new MenuItem("MD9", "Pizza Slice", 90, "Main"),
            new MenuItem("MD10", "Red Velvet Cake", 75, "Dessert")
        };
        mainCanteenSlots[3] = new TimeSlotMenu("Dinner", mainDinner);
        
        canteens[0] = new Canteen("Main Canteen", mainCanteenSlots);
        
        // ================== MBA CANTEEN ==================
        TimeSlotMenu[] mbaCanteenSlots = new TimeSlotMenu[4];
        
        // Breakfast (7:30-9:30)
        MenuItem[] mbaBreakfast = {
            new MenuItem("SB1", "Masala Dosa", 55, "Main"),
            new MenuItem("SB2", "Idli-Sambar (4 pcs)", 40, "Main"),
            new MenuItem("SB3", "Rava Upma with Chutney", 35, "Main"),
            new MenuItem("SB4", "Set Dosa (3 pcs)", 50, "Main"),
            new MenuItem("SB5", "Pongal with Vada", 45, "Main"),
            new MenuItem("SB6", "Filter Coffee", 20, "Beverage"),
            new MenuItem("SB7", "Banana Smoothie", 60, "Beverage"),
            new MenuItem("SB8", "Egg Toast", 40, "Starter(NV)"),
            new MenuItem("SB9", "Uttapam", 50, "Main"),
            new MenuItem("SB10", "Fruit Salad with Yogurt", 65, "Main")
        };
        mbaCanteenSlots[0] = new TimeSlotMenu("Breakfast", mbaBreakfast);
        
        // Lunch (12:00-14:30)
        MenuItem[] mbaLunch = {
            new MenuItem("SL1", "Meals Plate (Rice+Sambar+Rasam)", 90, "Combo"),
            new MenuItem("SL2", "Fish Curry + Rice", 150, "Combo(NV)"),
            new MenuItem("SL3", "Veg Biryani", 100, "Main"),
            new MenuItem("SL4", "Curd Rice", 50, "Main"),
            new MenuItem("SL5", "Papad + Pickle", 15, "Side"),
            new MenuItem("SL6", "Buttermilk", 20, "Beverage"),
            new MenuItem("SL7", "Payasam", 40, "Dessert"),
            new MenuItem("SL8", "Fruit Custard", 60, "Dessert"),
            new MenuItem("SL9", "Chicken 65", 120, "Starter(NV)"),
            new MenuItem("SL10", "Avocado Salad", 80, "Main")
        };
        mbaCanteenSlots[1] = new TimeSlotMenu("Lunch", mbaLunch);
        
        // Snacks (16:30-18:00)
        MenuItem[] mbaSnacks = {
            new MenuItem("SS1", "Masala Vada (2 pcs)", 30, "Starter"),
            new MenuItem("SS2", "Bhel Puri", 40, "Starter"),
            new MenuItem("SS3", "Rose Milk", 35, "Beverage"),
            new MenuItem("SS4", "Mango Shake", 50, "Beverage"),
            new MenuItem("SS5", "Ice Cream Sandwich", 45, "Dessert"),
            new MenuItem("SS6", "Cold Coffee", 40, "Beverage"),
            new MenuItem("SS7", "French Fries", 50, "Starter"),
            new MenuItem("SS8", "Chocolate Brownie", 60, "Dessert"),
            new MenuItem("SS9", "Pani Puri (6 pcs)", 35, "Starter"),
            new MenuItem("SS10", "Badam Milk", 45, "Beverage")
        };
        mbaCanteenSlots[2] = new TimeSlotMenu("Snacks", mbaSnacks);
        
        // Dinner (19:00-20:30)
        MenuItem[] mbaDinner = {
            new MenuItem("SD1", "Chicken Chettinad + Appam", 160, "Main(NV)"),
            new MenuItem("SD2", "Vegetable Stew", 90, "Main"),
            new MenuItem("SD3", "Spring Rolls (4 pcs)", 60, "Starter"),
            new MenuItem("SD4", "Fish Fingers (6 pcs)", 140, "Starter(NV)"),
            new MenuItem("SD5", "Jaljeera", 25, "Beverage"),
            new MenuItem("SD6", "Coca Cola/Fanta", 35, "Soft Drink"),
            new MenuItem("SD7", "Semiya Payasam", 50, "Dessert"),
            new MenuItem("SD8", "Chocolate Ice Cream", 55, "Dessert"),
            new MenuItem("SD9", "Grilled Sandwich", 70, "Main"),
            new MenuItem("SD10", "Fruit Punch", 65, "Beverage")
        };
        mbaCanteenSlots[3] = new TimeSlotMenu("Dinner", mbaDinner);
        
        canteens[1] = new Canteen("MBA Canteen", mbaCanteenSlots);
        
        // ================== IT CANTEEN ==================
        TimeSlotMenu[] itCanteenSlots = new TimeSlotMenu[4];
        
        // Breakfast (7:30-9:30)
        MenuItem[] itBreakfast = {
            new MenuItem("IB1", "Egg Bhurji + Pav", 50, "Main(NV)"),
            new MenuItem("IB2", "Omlette Sandwich", 45, "Main(NV)"),
            new MenuItem("IB3", "Cornflakes + Milk", 35, "Main"),
            new MenuItem("IB4", "Pancakes with Honey", 60, "Main"),
            new MenuItem("IB5", "Fresh Juice", 40, "Beverage"),
            new MenuItem("IB6", "Scrambled Eggs + Toast", 55, "Main(NV)"),
            new MenuItem("IB7", "Fruit Platter", 70, "Fruits"),
            new MenuItem("IB8", "Cereal Bowl", 65, "Main"),
            new MenuItem("IB9", "Bacon Sandwich", 80, "Main(NV)"),
            new MenuItem("IB10", "Smoothie Bowl", 75, "Main")
        };
        itCanteenSlots[0] = new TimeSlotMenu("Breakfast", itBreakfast);
        
        // Lunch (12:00-14:30)
        MenuItem[] itLunch = {
            new MenuItem("IL1", "Chicken Biryani", 140, "Main(NV)"),
            new MenuItem("IL2", "Pasta Alfredo", 120, "Main"),
            new MenuItem("IL3", "Grilled Sandwich", 70, "Main"),
            new MenuItem("IL4", "Mutton Rogan Josh", 180, "Main(NV)"),
            new MenuItem("IL5", "French Fries", 50, "Side"),
            new MenuItem("IL6", "Mint Lemonade", 40, "Beverage"),
            new MenuItem("IL7", "Chocolate Mousse", 80, "Dessert"),
            new MenuItem("IL8", "Cheese Cake", 90, "Dessert"),
            new MenuItem("IL9", "Chicken Burger", 110, "Main(NV)"),
            new MenuItem("IL10", "Caesar Salad", 85, "Main")
        };
        itCanteenSlots[1] = new TimeSlotMenu("Lunch", itLunch);
        
        // Snacks (16:30-18:00)
        MenuItem[] itSnacks = {
            new MenuItem("IS1", "Chicken Popcorn (10 pcs)", 100, "Starter(NV)"),
            new MenuItem("IS2", "Veg Manchurian", 60, "Starter"),
            new MenuItem("IS3", "Iced Tea", 35, "Beverage"),
            new MenuItem("IS4", "Oreo Shake", 55, "Beverage"),
            new MenuItem("IS5", "Waffles with Ice Cream", 85, "Dessert"),
            new MenuItem("IS6", "Nachos with Cheese", 70, "Starter"),
            new MenuItem("IS7", "Chocolate Donut", 45, "Dessert"),
            new MenuItem("IS8", "Hot Chocolate", 50, "Beverage"),
            new MenuItem("IS9", "Garlic Cheese Bread", 65, "Starter"),
            new MenuItem("IS10", "Fruit Smoothie", 60, "Beverage")
        };
        itCanteenSlots[2] = new TimeSlotMenu("Snacks", itSnacks);
        
        // Dinner (19:00-20:30)
        MenuItem[] itDinner = {
            new MenuItem("ID1", "Chicken Tikka Masala + Naan", 160, "Main(NV)"),
            new MenuItem("ID2", "Veg Fried Rice + Manchurian", 110, "Main"),
            new MenuItem("ID3", "Spring Rolls (4 pcs)", 60, "Starter"),
            new MenuItem("ID4", "Fish Fingers (6 pcs)", 140, "Starter(NV)"),
            new MenuItem("ID5", "Blue Lagoon Mocktail", 70, "Beverage"),
            new MenuItem("ID6", "Coca Cola/Fanta", 35, "Soft Drink"),
            new MenuItem("ID7", "Chocolate Mousse", 80, "Dessert"),
            new MenuItem("ID8", "Kulfi Falooda", 65, "Dessert"),
            new MenuItem("ID9", "Pizza Slice", 90, "Main"),
            new MenuItem("ID10", "Red Velvet Cake", 75, "Dessert")
        };
        itCanteenSlots[3] = new TimeSlotMenu("Dinner", itDinner);
        
        canteens[2] = new Canteen("IT Canteen", itCanteenSlots);
    }

    public String getCurrentTimeSlot(LocalTime time) {
        if (time.isAfter(LocalTime.of(7, 30)) && time.isBefore(LocalTime.of(12, 0))) {
            return "Breakfast";
        } else if (time.isAfter(LocalTime.of(12, 1)) && time.isBefore(LocalTime.of(14, 30))) {
            return "Lunch";
        } else if (time.isAfter(LocalTime.of(14, 31)) && time.isBefore(LocalTime.of(18, 0))) {
            return "Snacks";
        } else if (time.isAfter(LocalTime.of(18, 1)) && time.isBefore(LocalTime.of(20, 30))) {
            return "Dinner";
        } else {
            return "Closed";
        }
    }

    public void displayMenu(String canteen, String timeSlot) {
        MenuItem[] menu = getMenu(canteen, timeSlot);
        
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.printf("║ %-36s ║%n", canteen.toUpperCase() + " (" + timeSlot + ")");
        System.out.println("╠════════════════════════════╦═════════════╣");
        System.out.println("║          ITEM              ║    PRICE    ║");
        System.out.println("╠════════════════════════════╬═════════════╣");
        
        for (int i = 0; i < menu.length; i++) {
            MenuItem item = menu[i];
            String displayName = item.getType().contains("NV)") ? 
                (i+1) + ". " + item.getName() + " ♦" : (i+1) + ". " + item.getName();
            System.out.printf("║ %-28s ║   ₹%-8.2f ║%n", 
                displayName, item.getPrice());
        }
        System.out.println("╚════════════════════════════╩═════════════╝");
        if (containsNonVeg(menu)) {
            System.out.println(" ♦ = Non-Vegetarian");
        }
    }

    public MenuItem[] getMenu(String canteen, String timeSlot) {
        for (Canteen c : canteens) {
            if (c.getName().equals(canteen)) {
                for (TimeSlotMenu tsm : c.getTimeSlots()) {
                    if (tsm.getTimeSlot().equals(timeSlot)) {
                        return tsm.getItems();
                    }
                }
            }
        }
        return new MenuItem[0];
    }

    private boolean containsNonVeg(MenuItem[] menu) {
        for (MenuItem item : menu) {
            if (item.getType().contains("NV)")) {
                return true;
            }
        }
        return false;
    }

    private class Canteen {
        private String name;
        private TimeSlotMenu[] timeSlots;

        public Canteen(String name, TimeSlotMenu[] timeSlots) {
            this.name = name;
            this.timeSlots = timeSlots;
        }

        public String getName() { return name; }
        public TimeSlotMenu[] getTimeSlots() { return timeSlots; }
    }

    private class TimeSlotMenu {
        private String timeSlot;
        private MenuItem[] items;

        public TimeSlotMenu(String timeSlot, MenuItem[] items) {
            this.timeSlot = timeSlot;
            this.items = items;
        }

        public String getTimeSlot() { return timeSlot; }
        public MenuItem[] getItems() { return items; }
    }
}