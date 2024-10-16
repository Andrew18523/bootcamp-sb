package com.javahongkong.bootcamp.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    HashMap<Furniture, Integer> ordersOfFurnitures;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        this.ordersOfFurnitures = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        this.ordersOfFurnitures.put(type, furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return this.ordersOfFurnitures;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        float total =0;
        for (Map.Entry<Furniture,Integer> entry: this.ordersOfFurnitures.entrySet()) {
            total += entry.getKey().cost()*entry.getValue();
        }
        return total;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        return this.ordersOfFurnitures.getOrDefault(type,0);
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        return type.cost()*this.getTypeCount(type);
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        int total =0;
        // Approach 1
        for (Map.Entry<Furniture,Integer> entry: this.ordersOfFurnitures.entrySet()){
            total +=entry.getValue();
        }
        return total;
        // Approach 2
        // total = this.ordersOfFurnitures.values()
        //     .stream()
        //     .mapToInt(Integer::intValue)
        //     .sum();
        // return total;
        // Approcah 3
        // Set<Furniture> furnitureList = this.ordersOfFurnitures.keySet();
    }
}